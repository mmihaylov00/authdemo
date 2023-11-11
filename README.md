# Endpoints
- GET /user/hello - Unauthenticated endpoint, can be always accessed
- POST /user/register {"username": "test", "password": "pw"} - create a new user with role student
- POST /user {"username": "test", "password": "pw"} - login with the created user. Returns the JsonWebToken as string, put this string as "Authorization" header with value "Bearer {token}"
- GET /user - list all users, all authenticated users can access it
- GET /user/student - returns a message, can be accessed only by students, shows their username
- GET /user/tutor - same as student, but only for tutors

Examples:
- Login
```
curl --location 'http://localhost:8080/user' \
--header 'Content-Type: application/json' \
--header 'Authorization: Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJUZXN0IiwiaWF0IjoxNjk5NzQwNjYxLCJleHAiOjE2OTk3NDI0NjF9.x1BVmY59LLYmanxpicDWXD2QOvo6Aw1zWL2THgMHswQ' \
--header 'Cookie: JSESSIONID=17D280DAD137B4A8FF402F0F2E1ABF5E' \
--data '{
    "username": "Test",
    "password": "testpw"
}'
```
- Test student request after login
```
curl --location --request GET 'http://localhost:8080/user/student' \
--header 'Authorization: Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJUZXN0IiwiaWF0IjoxNjk5NzQwNjYxLCJleHAiOjE2OTk3NDI0NjF9.x1BVmY59LLYmanxpicDWXD2QOvo6Aw1zWL2THgMHswQ' \
--header 'Cookie: JSESSIONID=17D280DAD137B4A8FF402F0F2E1ABF5E' \
```