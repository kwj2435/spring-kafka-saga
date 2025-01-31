# Kafka를 활용한 SAGA 패턴 기반 분산트랜잭션 구현

이 프로젝트에서는 MSA 환경에서 서로 다른 모듈간 데이터 일관성을 보장하는 SAGA 패턴 기반의 분산 트랜잭션을 구현하는 미니프로젝트를 진행하고 이를 정리했습니다.

프로젝트 진행과정은 아래 블로그에 자세히 정리되어 있습니다.
https://turtledev.tistory.com/73

---
### 기술 스택
- Spring Boot 3.4.1
- Spring Data JPA
- Java 17
- Kafka
- MySql 8.0

### 주요 구현 사항


### 실행 방법
전체 모듈 빌드
```
bash ./allModuleBuild.sh
```

Root 디렉토리 위치한 Docker-Compose 파일 실행
```
docker-compose up -d
```

### 인프라 구성
