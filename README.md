## 🖥️ 키오스크 과제

## 📍필수 기능
### 단계별 요구사항
### 1️⃣LV.1 기본적인 키오스크를 프로그래밍 해보자
##### <kiosk>
##### Main.java
주요 기능 : `Scanner`활용법, 조건문, 반복문 활용하기
1. 햄버거 메뉴 출력 및 선택하기
   
   - 햄버거 메뉴 출력
   - 번호 입력 받기
   - 반복문을 이용해서 특정 번호 입력 시 프로그램 종료

##### <결과>
```
---------------------------------------------------------------
[ SHAKESHACK MENU ]
1. ShackBurger   | W 6.9 | 토마토, 양상추, 쉑소스가 토핑된 치즈버거
2. SmokeShack    | W 8.9 | 베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거
3. Cheeseburger  | W 6.9 | 포테이토 번과 비프패티, 치즈가 토핑된 치즈버거
4. Hamburger     | W 5.4 | 비프패티를 기반으로 야채가 들어간 기본버거
0. 종료      | 종료
메뉴를 골라주세요. : 1
ShackBurger을 선택하셨습니다. 6,900원을 결제해주세요.
---------------------------------------------------------------
[ SHAKESHACK MENU ]
1. ShackBurger   | W 6.9 | 토마토, 양상추, 쉑소스가 토핑된 치즈버거
2. SmokeShack    | W 8.9 | 베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거
3. Cheeseburger  | W 6.9 | 포테이토 번과 비프패티, 치즈가 토핑된 치즈버거
4. Hamburger     | W 5.4 | 비프패티를 기반으로 야채가 들어간 기본버거
0. 종료      | 종료
메뉴를 골라주세요. : 0
프로그램을 종료합니다.
```

💬 기본적인 반복문(while), 조건문(if/else-if/else), Scanner 문법을 이용하여 입출력 기능을 구현한 기초 레벨이었다.
***

### 2️⃣LV.2 객체 지향 설계를 적용해 햄버거 메뉴를 클래스로 관리하기
##### <kiosk2>
##### Main.java / MenuItem.java
1. MenuItem 클래스
   
   - 개별 음식 항목을 관리하는 클래스이다. (현재는 햄버거만 관리)
     - `이름`, `가격`, `설명` 필드를 가짐
       
2. Main 클래스
   
   - 사용자가 사용하는 키오스크 (입출력 담당)
   - MenuItem 타입으로 리스트를 만들어서 MenuItem을 추가하고 관리함
      - `List<MenuItem> menuItems = new ArrayList<>();`
      - MenuItem 객체 생성을 통해 `이름`, `가격`, `설명`을 셋팅
        
       ![image](https://github.com/user-attachments/assets/7e7eebb9-2f4a-423f-a32f-f317c8c42658)
     
   - 반복문을 활용하여 menuitems를 하나씩 접근

##### <결과>
```
---------------------------------------------------------------
[ SHAKESHACK MENU ]
1. ShackBurger | W 6.9 | 토마토, 양상추, 쉑소스가 토핑된 치즈버거
2. SmokeShack | W 8.9 | 베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거
3. ShackBurger | W 6.9 | 포테이토 번과 비프패티, 치즈가 토핑된 치즈버거
4. Hamburger | W 5.4 | 비프패티를 기반으로 야채가 들어간 기본버거
0. 종료      | 종료
메뉴를 골라주세요. : 1
선택한 메뉴: < ShackBurger | W 6.9 | 토마토, 양상추, 쉑소스가 토핑된 치즈버거 >
---------------------------------------------------------------
[ SHAKESHACK MENU ]
1. ShackBurger | W 6.9 | 토마토, 양상추, 쉑소스가 토핑된 치즈버거
2. SmokeShack | W 8.9 | 베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거
3. ShackBurger | W 6.9 | 포테이토 번과 비프패티, 치즈가 토핑된 치즈버거
4. Hamburger | W 5.4 | 비프패티를 기반으로 야채가 들어간 기본버거
0. 종료      | 종료
메뉴를 골라주세요. : 0
프로그램을 종료합니다.
```

💬 MenuItem클래스를 통해 메뉴아이템을 하나씩 관리할 수 있도록 좀 더 객체지향적인 설계를 구현하였다.<br>
   반복문을 통해 메뉴 아이템 리스트에서 하나씩 접근하여 출력할 수 있고, 선택한 메뉴 출력 또한 리스트 접근하여 출력한다.<br>
   Lv.1에 객체지향 개념을 추가하였고, 데이터를 이전보다 구조적으로 관리할 수 있다.
   
***

### 3️⃣LV.3 객체 지향 설계를 적용해 순서 제어를 클래스로 관리하기
##### <kiosk3>
##### Kiosk.java / Main.java / MenuItem.java
1. Kiosk 클래스
   
   - 사용자 입출력 및 순서 제어를 담당한다.
   - MenuItem 을 관리하는 리스트가 필드로 존재한다.
       
2. Main 클래스
   
   - start() 함수를 만들어서 키오스크 동작 실행을 관리한다.
   - Kiosk 클래스 생성자를 통해 menuitems 값을 할당한다.
     ![image](https://github.com/user-attachments/assets/13f0368b-e518-4bff-9fc5-4fa7cf21a838)


💬 구현 결과는 Lv.2와 동일하다. 달라진 점은 main 함수에서 관리하던 전체 순서 제어를 Kiosk 클래스를 통해 관리하게 된 것이다.
   
***

### 4️⃣LV.4 객체 지향 설계를 적용해 음식 메뉴와 주문 내역을 클래스 기반으로 관리하기
##### <kiosk4>
##### Kiosk.java / Menu.java / Main.java / MenuItem.java /

1. Menu 클래스

   - MenuItem 클래스를 관리하는 클래스이다.
   - 쉽게 말해서 세부적인 메뉴 아이템들을 카테고리 별로 나누어서 관리하는 것이다.
     (ex. 버거 메뉴, 음료 메뉴, 디저트 메뉴 ..등)
   - menuCategory랑 MenuItem 리스트를 필드로 구성하여 관리한다.
  
   - 메뉴 카테고리/메뉴 아이템 리스트를 출력하거나, 메뉴 아이템을 추가하는 등의 메서드를 통해 메뉴에 대해 전반적으로 관리하는 클래스이다.
    
   
2. MenuItem 클래스
   
   - getter 메서드를 추가하여 데이터들을 외부에서 사할 수 있도록 한다.

![image](https://github.com/user-attachments/assets/5aa9ef17-a238-46eb-88f7-4464ccb3ea22)
main 클래스에 메뉴판 리스트도 생성하고 추가하였다. 이 메뉴 카테고리들은 Menu클래스에서 관리한다.


💬 메뉴 카테고리 및 아이템과 주문을 각각 Menu클래스와 Kiosk클래스로 나누어서 관리할 수 있도록 구현하였다.

***

### 5️⃣LV.5 캡슐화 적용하기
- `MenuItem`, `Menu`, `Kiosk`클래스에 직접 접근하지 못하도록 설정한다.
- Getter와 Setter메서드를 사용하여 데이터를 관리한다.

=> `<kiosk4> 프로젝트 파일`에 캡슐화 구현 완료
   
***

## 📍도전 기능

### 1️⃣Lv.1 장바구니 및 구매하기 기능 추가하기 
##### => `<kiosk6> 패키지`에 구현 완료
1. 장바구니 생성 및 관리 기능
   - 장바구니는 메뉴명, 수량, 가격 정보를 저장하며, 항목을 동적으로 추가 및 조회할 수 있어야 한다.
2. 장바구니 출력 및 금액 계산
   - 사용자가 결제를 시도하기 전에, 장바구니에 담긴 모든 메뉴와 총 금액을 출력한다.
      - 각 메뉴의 이름, 가격, 수량
      - 총 금액 합계
3. 장바구니 담기 기능
   - 메뉴를 클릭하면 장바구니에 추가할 지 물어보고, 입력값에 따라 “추가”, “취소” 처리한다.

4. 주문 기능
   - 합산하여 총 금액을 계산하고, “주문하기”를 누르면 장바구니를 초기화합니다.

### Lv.2 Enum, 람다 & 스트림을 활용한 주문 및 장바구니 관리 
1. **Enum**을 활용한 사용자 유형별 할인율 관리하기
   ##### => `<kiosk7> 패키지`에 구현 완료
   
   - 사용자 유형의 Enum 정의 및 각 사용자 유형에 따른 할인율 적용
   - 주문 시, 사용자 유형에 맞는 할인율 적용해 총 금액 계산
     
3. **람다 & 스트림**을 활용한 장바구니 조회 기능
   ##### => `<kiosk8> 패키지`에 구현 완료
   
   - 기존에 생성한 Menu의 MenuItem을 조회 할 때 스트림을 사용하여 출력하도록 수정
   - 기존 장바구니에서 특정 메뉴 빼기 기능을 통한 스트림 활용
     
***

## 🪄 주요 코드 구현 설명

##### * 모든 기능 구현 완료
##### * 상위 코드인 kiosk8번 패키지에 대해서만 설명


### ✅Kiosk.java
#### 사용자 입출력 및 순서 제어를 담당한다.
* 사용자로부터 입력받은 번호에 따라 이후 로직을 결정함
* 무한 반복 중, 프로그램 종료 및 뒤로가기 기능을 위한 `while`문
   - 2중 while문으로 구성하여 뒤로가기 기능 구현
* 예외처리를 위한 `try-catch`문
  ```
  catch (IndexOutOfBoundsException e){ // 0 이나 메인 메뉴판에 없는 숫자 고를 시에 예외처리
     System.out.println("잘못된 숫자입니다. 다시 입력해주세요."); }
  ```
* Menu, Cart, Discount 클래스를 필드로 가짐

### ✅ Menu.java
* 메뉴 아이템을 추가하는 `addMenuItems()`메서드
* 메뉴 아이템을 출력하는 `printMenuItems()`메서드
    ```
    // 스트림 사용하여 menuItems 출력
    menuItems.stream()
       .map(item -> (menuItems.indexOf(item)+1)+". "+item.getName() + " | W " + item.getPrice() + " | " + item.getInfo())
       .forEach(System.out::println);
    ```

### ✅ Cart.java
* 장바구니 관리하는 Cart 클래스
  * 장바구니에 메뉴 추가, 장바구니 비우기, 장바구니 리스트 출력
   
* 장바구니에 담긴 메뉴아이템들의 금액 계산해주는 `calculateTotalPrice()` 메서드
  * 반복문을 통해 cartItem 항목 별 (수량 * 가격) 값을 더해주어 총 금액을 계산
   
* 특정 이름을 가진 메뉴를 제외하고 다시 출력해주는 `removeAndPrintCart()`메서드
   * `스트림`을 사용하여 구현
  ```
      public void removeAndPrintCart(){
        System.out.println("[ SHOPPING CART ] - 'SmokeShack'을 제외한 장바구니입니다.");

        //스트림 사용하여 필터링
        List<CartItem> filteredCarts = carts.stream()
                .filter(item -> !item.getName().equals("SmokeShack"))
                .toList();

        carts.clear(); //기존 장바구니 초기화
        carts.addAll(filteredCarts); // 특정 이름을 가진 메뉴 제외한 filterCarts 리스트를 기존 장바구니로 이동
        carts.forEach(System.out::println); // 장바구니 출력
    }
  ```
  * 다른 메서드나 코드에서 carts를 기준으로 totalPrice를 계산하거나 목록을 출력하기 때문에 기존 장바구니를 비우고, 필터링한 리스트를 carts리스트에 추가하여 장바구니를 새롭게 구성하였음.

* 장바구니에 중복 메뉴 추가할 때, 수량만 늘릴 수 있도록 하는 `plusQuantity()`메서드
  * `isContainCart()`메서드를 통해 중복 메뉴아이템인지 확인 후, 매개변수로 중복 메뉴아이템을 받는다.

### ✅ CartItem.java
* 메뉴 이름, 가격, 수량으로 필드가 구성되어있음
   * Cart클래스의 `addMenuToCart()`메서드를 통해 MenuItem에서 이름, 가격은 받아온다.
   * 수량은 맨 처음 장바구니 추가 시에는 기본 1로 설정하여 받아오고, 이후 동일메뉴 추가 시에는 +1이 된다.
     
* 동일메뉴 추가 시 수량은 계속해서 수정해야하기 때문에 `setQuantity()`로 setter메서드를 구현해두었음

### ✅ Discount.java
* 할인 정보가 담겨있는 `enum DiscountType`
![image](https://github.com/user-attachments/assets/2925a54c-b274-432a-8005-a4ef5a4ee49c)
* 할인 정보를 반영하여 최종 totalPrice를 계산해주는 `calculateDiscount()` 메서드
