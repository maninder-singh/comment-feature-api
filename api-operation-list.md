# Usage of comment-feature-api operation's

1. Get all comment's list
```
curl -v http://localhost:8080/comment-feature-api/comment
```
2. Get comment's responses based on comment-id
```
curl -v http://localhost:8080/comment-feature-api/comment/{comment-id}
```
3. Get user list
```
curl -v http://localhost:8080/comment-feature-api/user
```
4. Get user based on user-id
```
curl -v http://localhost:8080/comment-feature-api/user/{user-id}
```
5. Insert new user
```
curl --header "Content-type: application/json" --request POST --data '{"id" : 0,"name" : "post-name","email":"post-email","isExternal":true}' -v http://localhost:8080/comment-feature-api/user
```
