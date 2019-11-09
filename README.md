# java-ladder
사다리 게임 미션 저장소

## 기능 설명

### RandomNumberGenerator
- createNumber()
    - random으로 0 or 1을 생성해서 return

### Player
- getName()
    - Player 객체의 name을 return
- validName()
    - Player 객체의 이름이 5칸 이하인지 유효성 검증

### Ladder
- getLines()
    - List<Line>을 return

### Line
- getPoints()
    - 각 가로줄(Line)에서 "|", "\t", "-------"를 return
- createLines()
    - Player들의 숫자 만큼 한줄을 생성
- checkEvenOrOdd()
    - 한 line 에서짝수인지 홀수인지 판단하여 짝수면 "|", 홀수면 "\t" or "-------"를 add 하고 해당 string이 null인지 아닌지 판단한 결과를 return
- checkRandomNumber()
    - 생성한 randomNumber가 1이면 "-------", 0이면 "\t"를 list에 add 하고 return
- addLine()
    - "-------"인지 "\t"을 넣을지 로직 판단
- addString()
    - "|", "\t", "-------"인지를 return

### LetterGameInputView
- inputPlayers()
    - 사다리 게임 참가자 입력받고 arraylist return
- inputLetterHigh()
    - 사다리 높이를 입력 받고 return

### LetterGameOutputView
- printProcess()
    - player들을 print 하고 사다리 print 제어
- printLadder()
    - 사다리 print
- printLine()
    - 사다리 가로 한줄 print

### LetterGameController
- run()
    - 전체 게임을 진행
- createPlayerList()
    - 참여자 이름을 입력 받아 ArrayList로 변환해 return