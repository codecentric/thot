									<tr>
										<td><%=emptyIfNull(s.getStart())%></td>
										<td><%=emptyIfNull(s.getEnd())%></td>
										<td>
						 <% if(s.getDescription() != null) {
              %>	
											<a href="sessionDetails.jsp?sessionId=<%=s.getId() %>" role="button" class="btn"><%=emptyIfNull(s.getTitle())%></a> 
							<%} else { %>
							        <%=emptyIfNull(s.getTitle()) %>
							 <%}  %>
										 </td>
										<td><%=emptyIfNull(s.getAuthor())%></td>
										<td><%=emptyIfNull(s.getLocation())%></td>
										<td>
										<c:url value="comments" var="url" scope="page">
											<c:param name="sessionId" value="<%=String.valueOf(s.getId()) %>"/>
										</c:url>
										
										
										<a href='${url}' role="button" class="btn">Comments</a>
										</td>
										
										<%-- ?sessionId=<%=s.getId() %>&title=<%=s.getTitle()%> --%>
									</tr>