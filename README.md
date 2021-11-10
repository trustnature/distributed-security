SpringCloud+SpringSecurity+OAuth2+JWT+Zuul+Eureka DEMO
分布式认证解决方案

**第一步：用户登录授权**
http://localhost:53010/uaa/oauth/authorize?response_type=code&client_id=heima_two
获取code

**第二步：客户端通过code 获取token**
http://localhost:53010/uaa/oauth/token
请求报文：
<from-data {
    grant_type :authorization_code
    client_id  :heima_two
    client_secret  :123
    code    : mq6aa4
 }>
 结果如下
 {
     "access_token": "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJhdWQiOlsicmVzMSIsInByb2R1Y3RfYXBpIl0sImV4cCI6MTYzNTkzMzE0NSwidXNlcl9uYW1lIjoie1wiaWRcIjpcIjFcIixcInBhc3N3b3JkXCI6XCIkMmEkMTAkQ1lYOU9NdjB5Tzh3UjhyRTE5TjJmT2FYREpvbmRjaTV1UjY4azJlUUptNTBxOEVTc0RNbENcIixcInVzZXJuYW1lXCI6XCJhZG1pblwifSIsImp0aSI6IjYxM2FlZWNkLTYwMzMtNDg4Ni05MDhiLTEwYjM1MzZhNTMwNiIsImNsaWVudF9pZCI6ImhlaW1hX3R3byIsInNjb3BlIjpbInJlYWQiLCJST0xFX0FQSSIsIlJPTEVfQURNSU4iXX0.JEiHPKFNghGxglUbwihyzp1RHuyOKi8pu_-FhY64vNs",
     "token_type": "bearer",
     "refresh_token": "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJhdWQiOlsicmVzMSIsInByb2R1Y3RfYXBpIl0sInVzZXJfbmFtZSI6IntcImlkXCI6XCIxXCIsXCJwYXNzd29yZFwiOlwiJDJhJDEwJENZWDlPTXYweU84d1I4ckUxOU4yZk9hWERKb25kY2k1dVI2OGsyZVFKbTUwcThFU3NETWxDXCIsXCJ1c2VybmFtZVwiOlwiYWRtaW5cIn0iLCJzY29wZSI6WyJyZWFkIiwiUk9MRV9BUEkiLCJST0xFX0FETUlOIl0sImF0aSI6IjYxM2FlZWNkLTYwMzMtNDg4Ni05MDhiLTEwYjM1MzZhNTMwNiIsImV4cCI6MTYzNjE4NTE0NSwianRpIjoiZWFjMTYwMWQtNjg0MS00ZDhkLWI1NzctNzc3NThkNmQ3YmE3IiwiY2xpZW50X2lkIjoiaGVpbWFfdHdvIn0.iQzZswBLMvWjG9arIc3sMvYe7vI0Ct-YwFTBjQX0K9Q",
     "expires_in": 7199,
     "scope": "read ROLE_API ROLE_ADMIN", //用来限制客户端的访问范围，如果为空（默认）的话，那么客户端拥有全部的访问范围
     "jti": "613aeecd-6033-4886-908b-10b3536a5306"
 }
 
 **第三步：根据token访问资源**
 http://localhost:53010/order/r1?access_token=eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJhdWQiOlsicmVzMSIsInByb2R1Y3RfYXBpIl0sImV4cCI6MTYzNTkzMjcyMiwidXNlcl9uYW1lIjoie1wiaWRcIjpcIjFcIixcInBhc3N3b3JkXCI6XCIkMmEkMTAkQ1lYOU9NdjB5Tzh3UjhyRTE5TjJmT2FYREpvbmRjaTV1UjY4azJlUUptNTBxOEVTc0RNbENcIixcInVzZXJuYW1lXCI6XCJhZG1pblwifSIsImp0aSI6Ijg0YjUxZDE3LTg2Y2QtNDY1Yi05NzE0LWQ3NDM3NDRiN2ViNyIsImNsaWVudF9pZCI6ImhlaW1hX3R3byIsInNjb3BlIjpbInJlYWQiLCJST0xFX0FQSSIsIlJPTEVfQURNSU4iLCJ3cml0ZSJdfQ.nudQPCWT_vbaERnSa_MwUoOeDqqefHQLHoBCAMXLQmE
 
 **第四步：校验token是否合法**
 http://localhost:53010/uaa/oauth/check_token
 x-www-form-urlencoded
 token:
 
{
    "aud": [ //可访问的资源
        "res1",
        "product_api"
    ],
    "user_name": "{\"id\":\"1\",\"password\":\"$2a$10$CYX9OMv0yO8wR8rE19N2fOaXDJondci5uR68k2eQJm50q8ESsDMlC\",\"username\":\"admin\"}",
    "scope": [  //范围
        "ROLE_API",
        "ROLE_ADMIN"
    ],
    "exp": 1635933885,
    "authorities": [   //这个是授权用户的权限列表
        "p1",
        "p2"
    ],
    "jti": "75576b14-a0b9-427c-bc1a-4d6f5de254e6",
    "client_id": "heima_two"
}

视频教程：
https://www.bilibili.com/video/BV1VE411h7aL?p=47
