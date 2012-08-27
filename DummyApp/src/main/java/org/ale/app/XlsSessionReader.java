package org.ale.app;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.ale.domain.Session;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Row;

public class XlsSessionReader {

	private static final short ROW_TITLE = 0;
	private static final short ROW_SPEAKER = 1;
	private static final short ROW_DESCRIPTION = 2;

	private POIFSFileSystem fileSystem; 
	
	public XlsSessionReader(String filename) throws IOException {
		this(new FileInputStream(filename));
	}
	

	public XlsSessionReader(InputStream is) throws IOException {
		fileSystem = new POIFSFileSystem(is);
	}

	public List<Session> readAllSessions() {
		final List<Session> result = new ArrayList<Session>();

		try {

			final HSSFWorkbook workBook = new HSSFWorkbook(fileSystem);
			final HSSFSheet sheet = workBook.getSheetAt(0);

			int rows = sheet.getPhysicalNumberOfRows();
			// as the row is a header we start with the second one
			for (int r = 1; r < rows; r++) {		
				final HSSFRow row = sheet.getRow(r);
				if (row == null) {
					continue;
				}
				final Session session  = getSessionFromRow(row);
				if(session != null) {
					result.add(session);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	private Session getSessionFromRow(HSSFRow row) {		
		final String title = getCellValue(row.getCell(ROW_TITLE, Row.RETURN_BLANK_AS_NULL));
		final String speaker = getCellValue(row.getCell(ROW_SPEAKER, Row.RETURN_BLANK_AS_NULL));
		final String description = getCellValue(row.getCell(ROW_DESCRIPTION, Row.RETURN_BLANK_AS_NULL));
		
		if(title != null || speaker != null || description != null) {
			return new Session(title, speaker, description);	
		}
		
		return null;
	}

	private String getCellValue(HSSFCell cell) {
		String result = null;
		if(cell != null) {
			switch (cell.getCellType()) {
	
				case HSSFCell.CELL_TYPE_FORMULA:
					result = cell.getCellFormula().toString();
					break;
	
				case HSSFCell.CELL_TYPE_NUMERIC:
					result = "" + cell.getNumericCellValue();
					break;
	
				case HSSFCell.CELL_TYPE_STRING:
					result = cell.getStringCellValue();
					break;
	
				default:
			}
		}
		return result;
	}


}
