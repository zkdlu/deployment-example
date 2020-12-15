# 무중단 배포
> 무중단 배포의 핵심은 로드밸런싱이 되어야 하고, 라우팅 정보를 reload가 되어야 함

## 로드밸런싱 (부하 분산)
- 서버에 가해지는 부하를 분산 해주는 장치 또는 기술

## 종류
### 1. Rolling-deployment
- 추가적인 서버 증설 필요x
- 롤백이 어려움
### 2. Blue/Green-deployment
- 배포가 빠르고 롤백이 쉬움
- 추가적인 서버 증설 필요
### 3. Canary-deployment
- 카나리아??

## 무중단 배포 연습
### [1.nginx](https://github.com/zkdlu/deployment-example/blob/main/nginx/%EB%AC%B4%EC%A4%91%EB%8B%A8%EB%B0%B0%ED%8F%AC.md)

### 2.kubernetes

### 3.zuul
- config server로 reload하는 듯 (팩트 체크 필요) (나중 참고용: https://elfinlas.github.io/2019/06/25/spring-config-refresh/)

# 배포 자동화
Github push/pull-request -> build -> docker build -> docker push -> code deploy -> docker pull -> docker run
