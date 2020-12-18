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
### 1.[nginx](https://github.com/zkdlu/deployment-example/blob/main/nginx/%EB%AC%B4%EC%A4%91%EB%8B%A8%EB%B0%B0%ED%8F%AC.md)

### 2.kubernetes

### 3.zuul
- config server로 reload하는 듯 (팩트 체크 필요) (나중 참고용: https://elfinlas.github.io/2019/06/25/spring-config-refresh/)

# 배포 자동화
> Github push/pull-request -> build -> docker build -> docker push -> code deploy -> docker pull -> docker run

- 내가 생각하는 배포 자동화 (맞는지 모름, 전체 과정에 대한 설명을 찾지 못함)
1. 코드를 수정하고 push/pull-reauqest
2. push가 된 걸 감지 하면 CI툴 (github-action / jenkins .. )에서 감지 하여 빌드 및 테스트 진행한다.
3. 이상없이 완료가 되면 실행중인 서버 (AWS EC2)에서 github에서 해당 프로젝트를 가져오도록 한다. 
  > EC2에서 push가 된 것을 어떻게 알아낼 것인가?
  >
  > 1. CI 툴에서 빌드 단계 이후 scp로 자체 복사 한다. -> 복사하는 것은 좋다. 어떻게 그 다음 단계를 진행 할 것인가? -> ssh 접속하여 sh 스크립트 실행?
  > 
  > 2. 다른 솔루션이 있는가? 아마도 AWS Code Deploy -> 확인 필요
4. 프로젝트를 빌드 후 구동시킨다.
  > sh 스크립트로 자동화 완료
5. gateway는 routing 정보를 수정한 후 reload 한다.
  > 설정 파일은 어떻게 업데이트를 할 것인가? -> 확인 필요
  > 할 
  > 거
  > 
