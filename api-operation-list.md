# Usage of comment-feature-api operation's

Get all comment's list
```
curl -v http://localhost:8080/comment-feature-api/comment
```
Get comment's responses based on comment-id
```
curl -v http://localhost:8080/comment-feature-api/comment/{comment-id}
```
Get user list
```
curl -v http://localhost:8080/comment-feature-api/user
```
Get user based on user-id
```
curl -v http://localhost:8080/comment-feature-api/user/{user-id}
```
Insert new user
```
curl --header "Content-type: application/json" --request POST --data '{"id" : 0,"name" : "post-name","email":"post-email","isExternal":true}' -v http://localhost:8080/comment-feature-api/user
```
