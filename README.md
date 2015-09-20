# NOS-Client
Java Client Library for KiSTi NDSL NOS Open API(http://nos.ndsl.kr/)

한국과학기술연구원에서 제공하는 NDSL 검색서비스 OpenAPI를, Java를 이용한 개발에
사용할 때, 하부 HTTP 통신, 결과 XML 파싱 등을 신경쓰지 않고 이 Library의 Java 클래스를
사용하여 할 수 있게 하기 위한 목적.

처음이라 여러가지 생각이 떠 오르긴 하는데 뒤엉켜 있고 정리되지 않는다.

* 일단 기능 구현을 목표로 한다.
  - 성능, 확장성 등은 나중에
* 결국 하부는 HTTP 통신이다
  - 적절한 HTTP 클라이언트 Library가 필요하다
    * Apache HttpComponents Client?
    * 직접 짠다?
    * 아니면 또 다른 Library?
* java.concurrency 패키지를 이용해 보자
  - Excutor, Callable, Future
* Generic을 활용할 거다. 그러니 당연히 Java는 5 버전 이상에서 동작한다.
