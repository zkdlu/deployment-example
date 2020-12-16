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

