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
### Insert new comment 
```
curl --header "Content-type: application/json" --request POST --data '{"parentCommentId" : {parent-comment-id},"description" : "{description}","isCommentResolve":{is-comment-resolve},"userId":{user-id},"image":{image-dataurl}}' -v http://localhost:8080/comment-feature-api/comment

Note :
1. {parent-comment-id} is Integer ( 0 if it is new comment otherwise it has parent-comment-id)
2. {description} is String
3. {is-comment-resolve} is Boolean
4. {user-id} is Integer
5. {image-dataurl} as canvas.toDataURL() 
```
### Update comment
```
curl --header "Content-type: application/json" --request PUT --data '{"id" : {comment-id},"description" : "{description}","isCommentResolve":{is-comment-resolve}' -v http://localhost:8080/comment-feature-api/comment

Note : Only description and is-comment-resolve is able to update by user
1. {id} is Integer
2. {description} is String
3. {isCommentResolve} is Boolean
```
### Delete comment
```
curl --header "Content-type: application/json" --request DELETE -v http://localhost:8080/comment-feature-api/comment/{comment-id}

Note :
1. {comment-id} is Integer
```

