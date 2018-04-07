## core

- http://www.baeldung.com/spring-security-with-maven

- http://www.baeldung.com/get-user-in-spring-security

- http://www.baeldung.com/spring-security-authentication-provider

- http://www.baeldung.com/spring-security-expressions-basic

- http://www.baeldung.com/security-none-filters-none-access-permitAll

## rest

- http://www.baeldung.com/securing-a-restful-web-service-with-spring-security

```text
curl -i -X POST -d username=user -d password=userPass -c cookies.txt http://localhost:8080/login
curl -i --header "Accept:application/json" -X GET -b cookies.txt http://localhost:8080/api/foos
```

## 웹 개발자를 위한 Spring 4.0 프로그래밍
### chapter16 스프링 시큐리티를 이용한 웹 보안
https://github.com/chori84/springsecuritybook