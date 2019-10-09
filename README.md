UI:
* After User is logined - Login link present for him in bottom menu.
* Registration can be made with empty fields.
* When total cost of goods is more then 100$ then user can't buy goods.
* User can't look his information.
	
API:
* Doesn't work API: POST /addresses
* Doesn't work API GET /customers{id} - if request is not authorised, should return 401 response code, returns random data or 500 code
* API POST /user - if request is sent only with three empty fields - 500 response code, should be 400; if request sent with registration data from UI - with all fields are empty - 200 response code.
* API's return text/plain in response.
* 404 for queue-master
