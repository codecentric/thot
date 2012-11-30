package org.ale.thot.domain;

import javax.persistence.EntityManager;

import org.junit.Before;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class JpaLinkDaoTest {

	@Mock
	private EntityManager emMock;
	private JpaLinkDao dao;
	
	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		dao = new JpaLinkDao(emMock);
	}
	
//	@Test
//	public void shouldSaveLink() {
//		Link link = new Link(new Date(), "comment", "http", 10);
//		dao.saveLink(link);
//		verify(emMock).merge(link);
//	}
}
