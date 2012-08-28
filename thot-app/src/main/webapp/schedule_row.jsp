									<tr>
										<td><%=emptyIfNull(s.getStart())%></td>
										<td><%=emptyIfNull(s.getEnd())%></td>
										<td>
						 <% if(s.getDescription() != null) {
              %>	
											<a href="#myModal_<%=i%>" role="button" class="btn" data-toggle="modal"><%=emptyIfNull(s.getTitle())%></a> 
							<%} else { %>
							        <%=emptyIfNull(s.getTitle()) %>
							 <%}  %>
										 </td>
										<td><%=emptyIfNull(s.getAuthor())%></td>
										<td><%=emptyIfNull(s.getLocation())%></td>
										<td></td>
									</tr>