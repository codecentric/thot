<%@ include file="header.jsp"%>

<div class="container-fluid">

		<!--/span-->
			<div class="well well-small">
				<h1>Program outline</h1>
				<br />
				<p>For more details on content, please click the description
					inside the cells</p>
			</div>
			
			<div class="row-fluid">
				<div class="tabbable">
					<ul class="nav nav-tabs">
						<li class="active"><a href="#1" data-toggle="tab">Day 1</a></li>
						<li class=""><a href="#2" data-toggle="tab">Day 2</a></li>
						<li class=""><a href="#3" data-toggle="tab">Day 3</a></li>
					</ul>
					<div class="tab-content">
						<div class="tab-pane active" id="1">
							<p>You are watching Day 1, August 29th.</p>
							<table class="table table-striped">
								<thead>
									<tr>
										<th>Start</th>
										<th>End</th>
										<th>Talk</th>
										<th>Speaker</th>
									</tr>
								</thead>
								<tbody>
									<tr>
										<td>11:00</td>
										<td>11:30</td>
										<td><a href="session.html">Validate Your Influence</a></td>
										<td>Ivana Gancheva</td>
									</tr>
									<tr>
										<td>11:00</td>
										<td>11:30</td>
										<td>Spreading collaboration - Dissolving vs Bullying
											Product Owners</td>
										<td>Konrad Pogorzala, Christian Kaemmerer</td>
									</tr>
									<tr>
										<td>11:00</td>
										<td>11:30</td>
										<td>The Pirate Metrics - AARRR</td>
										<td>Jurgen De Smet</td>
									</tr>
								</tbody>
							</table>
						</div>
						<div class="tab-pane" id="2">
							<p>You are watching Day 2.</p>
						</div>
						<div class="tab-pane" id="3">
							<p>You are watching Day 3.</p>
						</div>
					</div>

				</div>
				<!--/row-->

				<hr>

			</div>
			<!--/.fluid-container-->
			</div>

			<%@ include file="footer.html"%>