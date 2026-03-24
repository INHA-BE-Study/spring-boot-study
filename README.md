# 🌱 InhaStudy — 백엔드 스터디 실습 레포지토리

Spring Boot 백엔드 개발을 학습하는 4인 스터디 실습 코드 저장소입니다.  
매주 개념을 학습하고, 금요일 스터디에서 함께 코드를 작성하며 정리합니다.

---

## 🛠️ 기술 스택

| 분류 | 기술 |
|------|------|
| Language | Java 21 |
| Framework | Spring Boot 4.0.4 |
| ORM | Spring Data JPA / Hibernate 7 |
| Database | PostgreSQL 16 |
| Build | Gradle |
| Container | Docker / Docker Compose |

---

## 📅 스터디 커리큘럼

| Phase | 주제 | 기간 |
|-------|------|------|
| Phase 1 | Spring MVC 구조, DTO & 응답 설계 | 1~2주차 |
| Phase 2 | 레이어드 아키텍처 | 3주차 |
| Phase 3 | JPA (영속성, 연관관계, N+1 최적화) | 4~6주차 |
| Phase 4 | 예외처리 | 7주차 |
| Phase 5 | 인증/인가 (Spring Security + JWT) | 8~9주차 |

---

## 🚀 로컬 환경 설정

### 1. 저장소 클론

```bash
git clone https://github.com/{org}/{repo}.git
cd InhaStudy
```

### 2. 환경변수 설정

```bash
cp .env.example .env
```

`.env` 파일을 열고 비밀번호를 채워주세요.

```env
DB_NAME=study_db
DB_USERNAME=study
DB_PASSWORD=        # 여기 입력
DB_PORT=5432
```

### 3. PostgreSQL 컨테이너 실행

```bash
docker-compose up -d
```

### 4. IntelliJ EnvFile 설정

```
Run → Edit Configurations → 앱 선택
→ EnvFile 탭 → Enable EnvFile 체크
→ + 버튼으로 .env 파일 선택
→ Apply → OK
```

> ⚠️ EnvFile 플러그인이 없다면 먼저 설치해주세요.  
> `Settings → Plugins → "EnvFile" 검색`

### 5. 앱 실행

IntelliJ에서 `InhaStudyApplication` 실행

---

## 📁 패키지 구조

```
src/main/java/org/myproject/inhastudy/
├── controller/     # API 엔드포인트
├── service/        # 비즈니스 로직
├── repository/     # DB 접근
├── domain/         # Entity
└── dto/            # 요청/응답 DTO
```

---
