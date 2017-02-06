<p>Easygoing project to create a RESTful API</p>

<h1>Install and run the project</h1>
<p>1. download/clone the project.</p>
<p>2. Run the following maven command on the console in the root directory of the project.</p>
<code>mvn test</code>

<h1>Testing the project</h1>
<p>Run the following maven command on the console in the root directory of the project.</p>
<code>mvn test</code>

<h1>Endpoints</h1>
<p>The next json was used in the follows examples:</p>
<code>{"name":"Barbecue", "images":[{"uri":"https://static.carrefourdigital.com.br/medias/sys_master/images/images/h66/he6/h00/h00/8944087203870.jpg"},{"uri":"https://static.carrefourdigital.com.br/medias/sys_master/images/images/h16/hc8/h00/h00/8944089759774.jpg"}]}</code>
<p>Create a product</p>
<code>Method:POST http://localhost:8080/challenge/rest/product/</code>
<p>Update a product</p>
<code>Method:PUT http://localhost:8080/challenge/rest/product/</code>
<p>Delete a product</p>
<code>Method:DELETE http://localhost:8080/challenge/rest/product/</code>
<p>Get all products with images and child products</p>
<code>Method:GET http://localhost:8080/challenge/rest/product/</code>
<p>Get all products without images and child products</p>
<p>You have to set the header fot images and child products (both are boolean values), so if you want images/child products set true.<p>
<code>Method:GET http://localhost:8080/challenge/rest/product/</code>
<p>Get a product with images and child products</p>
<code>Method:GET http://localhost:8080/challenge/rest/product/{product-id}</code>
<p>Get a product without images and child products</p>
<p>You have to set the header fot images and child products (both are boolean values), so if you want images/child products set true.<p>
<code>Method:GET http://localhost:8080/challenge/rest/product/{product-id}</code>
<p>Get the childs products</p>
<code>Method:GET http://localhost:8080/challenge/rest/product/child/{product-id}</code>
<p>Get the image's products</p>
<code>Method:GET http://localhost:8080/challenge/rest/product/image/{product-id}</code>








