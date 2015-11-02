# Usage of comment-feature-api operation's

### Get all comment's list
```
curl -v http://localhost:8080/comment-feature-api/comment
```
### Get comment's responses based on comment-id
```
curl -v http://localhost:8080/comment-feature-api/comment/{comment-id}
```
### Get user list
```
curl -v http://localhost:8080/comment-feature-api/user
```
### Get user based on user-id
```
curl -v http://localhost:8080/comment-feature-api/user/{user-id}
```
### Insert new user
```
curl --header "Content-type: application/json" --request POST --data '{"id" : {user-id},"name" : "{user-name}","email":"{email}","isExternal":{isExternal}}' -v http://localhost:8080/comment-feature-api/user

Note : 
1. {user-id} is Integer
2. {user-name} is String
3. {email} is String
4. {isExternal} is Boolean
```
### Update existing user
```
curl --header "Content-type: application/json" --request PUT --data '{"id" : {user-id},"name" : "{user-name}","email":"{email}","isExternal":{isExternal}}' -v http://localhost:8080/comment-feature-api/user

Note : 
1. {user-id} is Integer
2. {user-name} is String
3. {email} is String
4. {isExternal} is Boolean
```
### Delete User based on user-id
```
curl --header "Content-type: application/json" --request DELETE -v http://localhost:8080/comment-feature-api/user/{user-id}
```
