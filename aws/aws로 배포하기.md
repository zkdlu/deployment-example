1. git 설치 & docker 설치

```bash
sudo apt-get update
sudo apt-get install git

curl -fsSL https://get.docker.com/ | sudo sh
```

2. 프로젝트 디렉토리 생성

```bash
mkdir ~/app && mkdir ~/app/step1
cd ~/app/step1
```

3.  git clone

```bash
git clone [repository]
```

4. docker-compose 설치

```bash
//설치
sudo curl -L https://github.com/docker/compose/releases/download/1.21.0/docker-compose-`uname -s`-`uname -m` | sudo tee /usr/local/bin/docker-compose > /dev/null
//권한 변경
sudo chmod +x /usr/local/bin/docker-compose
// symbolic link 생성
sudo ln -s /usr/local/bin/docker-compose /usr/bin/docker-compose
//확인
docker-compose --version
```

5. 배포 스크립트 작성

```sh
#!/bin/bash
REPOSITORY=~/app/step1
PROJECT_NAME=deployment-example
cd $REPOSITORY/$PROJECT_NAME/

echo "> Git Pull"
git pull
echo "> Finished Update"

echo "> docker-compose build"
cd nginx
sudo docker-compose up
```

```bash
chmod +x deploy.sh
./deploy.sh
```

### 생각 정리
- docker-compose를 이용하여 업데이트를 구현해보려 하였으나, 캐싱되어 있는 이미지들이 새로 빌드가 되지 않고 기존 이미지를 그대로 컨테이너로 사용한다.
- 실행중인 경우엔 up-to-date라고 떠서 아무것도 안한다.
