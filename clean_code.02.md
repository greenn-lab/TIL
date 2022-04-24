## 오늘의 읽은 범위
2장.의미있는 이름

## 기억하고 싶은 내용
- `p.22`
  ```java
  public List<int[]> getThem() {
    List<int[]> list1 = new ArrayList<>();
    
    for (int[] x : theList) {
      if (x[0] == 4) list1.add(x);
    }
    
    return list1;
  }
  ```
  코드가 하는 일을 짐작하기 어렵다. 복잡한 문장은 없다.
  
  ```java
  public List<int[]> getFlaggedCells() {
    List<int[]> flaggedCells = new ArrayList<>();
    
    for (int[] cell : gameBoard) {
      if (cell[STATUS_VALUE] == FLAGGED) {
        flaggedCells.add(cell);
      }
      
      return flaggedCells;
    }
  }
  ```
  한걸음 더 나아가, int 배열을 사용하는 대신, 
  ```java
  public List<Cell getFlaggedCells() {
    List<Cell> flaggedCells = new ArrayList<>();
    for (cell cell: gameBoard) {
      if(cell.isFlagged()) {
        flaggedCells.add(cell);
      }
      
      return flaggedCells;
    }
  }
  ```
  단순히 이름만 고쳤는데도 함수가 하는 일을 이해하기 쉬워졌다. 바로 이것이 좋은 이름이 주는 위력이다.

## 읽은 소감
적절하고 좋은 예시가 인상 깊었어요. 무의식적으로 타입을 변수명으로 쓰던 습관들에 섬뜩함을 느끼기도 했답니다.

## 해결되지 않은 궁금증, 의구심
없어요.
