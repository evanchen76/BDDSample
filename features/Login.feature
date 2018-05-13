
Feature: Login

  @login
  Scenario: 驗證登入成功
    Given 我開啟登入頁
    When 我在帳號輸入 "evan"
    And 我在密碼輸入 "123"
    And 我點擊登入
    Then Result 會顯示:"登入成功"

  @login
  Scenario: 驗證登入失敗
    Given 我開啟登入頁
    When 我在帳號輸入 "evan"
    And 我在密碼輸入 "123456"
    And 我點擊登入
    Then Result 會顯示:"登入失敗"

