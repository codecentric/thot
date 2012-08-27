<h1>Welcome to the Open Space Software Development at ALE2012</h1>

<h2>Setting up the development environment</h2>

<h3>Prerequisites</h3>

<p>
The software itself is Java/Maven, so you'll need these and an IDE installed. 
Eclipse is preferred and we also added a setup task for Eclipse (see below).
If you want to run the app on your local machine, you need a MySQL installation 
at hand (checkout http://dev.mysql.com/downloads/).
</p>

<h3>Setting things up</h3>

<p>
When you checked out the project, just go to the <tt>thot-env</tt> directory and execute <br/><br/>

<code>./init-env.sh</code> <br/><br/>

This will download a tomcat, extract it into <tt>thot-env/target</tt> and will setup a admin user to
enable deployments with the Cargo plugin (http://cargo.codehaus.org/Maven2+plugin). <br/><br/>

Then, go into the <tt>thot-app</tt> directory and execute <br/><br/>

<code>mvn eclipse:eclipse</code> <br/><br/>

Finally you need to setup a database and the appropriate user. This can be done in the same directoy with the command <br/><br/>

<code>mysql -u root -p < src/main/resources/sql/init-db.sql</code>

After that simple import the project into Eclipse, add the Tomcat to your Servers tab and you're ready to get started.
</p>

<h2>Further information</h2>

<p>
For further information on setting up your local development environment please see: https://sites.google.com/site/openspacesoftwaredevelopment/
</p>

