# jwtauth
jwt authentication

1.Download;
2.Run;
3.Test uing Postman
1)create post request:(POST,
 http://localhost:8080/authenticate,
Body
{
    "userName":"user1",
    "password":"pass"
});
->you will recive token
2) copy token and create get request:(GET,
http://localhost:8080/,
Authorization-> TYPE: Bearer Token
paste your token
