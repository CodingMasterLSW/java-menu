# 점메추

## 입력
- [x] 프로그램 실행 시, 실행 메세지를 출력한다.
- [x] 메뉴 추천을 받을 코치의 이름을 입력한다.
  - [ ] 각 코치들은 ',' 로 구분되어 입력된다.
  - [ ] 코치는 최소 2명, 최대 5명까지 입력할 수 있다.
  - [ ] 코치의 이름은 최소 2글자, 최대 4글자이다.
  - Exception
    - [x] 공백이 입력될 경우, 예외를 발생시킨다.
    - [ ] 코치의 이름이 두 글자보다 작거나, 4글자보다 크다면 예외를 발생시킨다.
    - [ ] 코치가 2명보다 작거나, 5명보다 많을 경우, 예외를 발생시킨다.

- [ ] 각 코치가 못 먹는 메뉴를 입력받는다
  - [ ] 최소 0개, 최대 2개의 못 먹는 메뉴가 있다.
  - [ ] 입력은 ',' 로 구분해 입력해야 한다.
  - Exception
    - [ ] 못 먹는 메뉴가 3개 이상 입력될 경우, 예외를 발생시킨다.

## 메뉴 추천
- [ ] Enum을 사용해 각 카테고리 별 메뉴를 등록한다
- [ ] Random.pickNumberInRange() 를 사용해 메뉴 추천을 할 카테고리를 선택한다.
- [ ] Randoms.shuffle()을 통해 임의의 순서로 섞은 후, 첫 번째 값을 추천한다.

## 결과값 출력 
- [ ] 메뉴 추천 결과를 출력한다.
