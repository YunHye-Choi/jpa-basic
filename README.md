## h2 컨테이너 실행 명령어
docker run -d -p 1521:1521 -p 8081:81 -v /home/yunhye/h2:/opt/h2-data -e H2_OPTIONS="-ifNotExists" --name=h2 oscarfonts/h2