## 오늘의 읽은 범위
3장.함수

## 기억하고 싶은 내용
- `p.56` 명령과 조회를 분리하라!
- `p.58` Try/Catch 블록은 ... 코드 구조에 혼란을 일으키며, 정상 동작과 오류처리 동작을 뒤섞는다 ... 별도의 함수로 뽑아내는 편이 좋다.
  ```java
  public void delete(Page page) {
    try {
      deletePageAndAllReferences(page);
    } catch (Exception e) {
      logError(e);
    }
  }
  
  private void deletePageAndAllReferences(Page page) throws Exception {
    // ... omitted
  }
  
  private void logError(Exception e) {
    logger.log(e.getMessage());
  }
  ```

## 읽은 소감
- CQRS를 상기하는 단순하고 명쾌한 해석이었네요.
- try/catch 문장 구조가 SRP 를 위반할거라곤 상상도 못했네요. 위에 언급한 코드처럼 분리하니까 완전한 하나의 문장처럼 읽히면서 
역할 분리도 확실해지는 장점에 감동했답니다.
- 함수의 크기를 줄이려는 잘못된 노력으로 단순한 한단어 동사로 이름짓기를 해왔단 걸 깨달았어요.
누구나 알법한 단어라고 단정짓고 며칠지나면 나조차도 의미를 해석하지 못했던 코드들이 생각났어요.

## 해결되지 않은 궁금증, 의구심
없어요.
