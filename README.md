
<p>A challenge project to create a RESTful API</p>
<br/>
<p><b>Comments</b></p>
<p>Few tests missing<p>
<br/>
<b>Technical Specification:</b>
<p>1) Maven must be used to build, run tests and start the application.</p>
<p>2) The tests must be started with the mvn test command.</p>
<p>3) The application must start with a Maven command: mvn exec:java, mvn jetty:run, mvn spring-boot:run, etc.</p>
<p>4) The application must have a stateless API and use a database to store data.</p>
<p>5) An embedded in-memory database should be used: either H2, HSQL, SQLite or Derby.</p>
<p>6) The database and tables creation should be done by Maven or by the application.</p>

<h1>Install and run the project</h1>
<p>1. download/clone the project.</p>
<p>2. Run the following maven command on the console in the root directory of the project.</p>
<code>mvn tomcat7:run</code>

<h1>Testing the project</h1>
<p>Run the following maven command on the console in the root directory of the project.</p>
<code>mvn test</code>

<h1>Endpoints</h1>
<p>The next json was used in the follows examples:</p>
<code>{"name":"Barbecue", "images":[{"uri":"https://static.carrefourdigital.com.br/medias/sys_master/images/images/h66/he6/h00/h00/8944087203870.jpg"},{"uri":"https://static.carrefourdigital.com.br/medias/sys_master/images/images/h16/hc8/h00/h00/8944089759774.jpg"}]}</code>
<p>Create a product</p>
<code>Method:POST http://localhost:8080/challenge/product/</code>
<p>Update a product</p>
<code>Method:PUT http://localhost:8080/challenge/product/</code>
<p>Delete a product</p>
<code>Method:DELETE http://localhost:8080/challenge/product/</code>
<p>Get all products with images and child products</p>
<code>Method:GET http://localhost:8080/challenge/product/</code>
<p>Get all products without images and child products</p>
<p>You have to set the header fot images and child products (both are boolean values), so if you want images/child products set true.<p>
<code>Method:GET http://localhost:8080/challenge/product/</code>
<p>Get a product with images and child products</p>
<code>Method:GET http://localhost:8080/challenge/product/{product-id}</code>
<p>Get a product without images and child products</p>
<p>You have to set the header for images and child products (both are boolean values), so if you want images/child products set true.<p>
<code>Method:GET http://localhost:8080/challenge/product/{product-id}</code>
<p>Get the child's products</p>
<code>Method:GET http://localhost:8080/challenge/product/child/{product-id}</code>
<p>Get the image's products</p>
<code>Method:GET http://localhost:8080/challenge/product/image/{product-id}</code>








