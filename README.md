(1)プロジェクト概要
  
  本アプリはSpring Bootフレームワークを使って作成した掲示板アプリケーションです。
  投稿の作成・一覧表示・詳細表示・編集・削除といった基本的なCRUD機能に加え、検索機能、ログイン認証機能や問い合わせメール機能を実装し、WEBアプリケーション開発に必要な基本機能を備えています。
  
(2)主な機能

### 認証機能
 - ユーザー登録
 - ログイン/ログアウト

### 投稿機能
 - 投稿新規登録
 - 投稿一覧表示
 - 投稿詳細表示
 - 投稿編集
 - 投稿削除

### 検索・表示機能
 - 部分一致検索機能
 - 前方一致検索機能
 - 後方一致検索機能
 - ソート機能
   - 作成日
   - タイトル
   - 昇順/降順
 - ページネーション機能

### 問い合わせ機能
- 問い合わせフォーム
- 入力内容画面
- メール送信機能

### その他機能
- バリデーション機能
- フラッシュメッセージ

(3)使用技術

 ### バックエンド
 - Java -17
 - Spring Boot 3.5.14
 - Spring Security
 - Spring Data JPA

### フロントエンド
 - HTML
 - CSS
 - Thymeleaf  3.1.3 RELEASE

### データベース
 - MySQL 9.6.0

### その他
- Lombok 1.18.42
- Validation　9.0.1
- Mail Sender


(4)ローカル実行方法

### 1.リポジトリのクローン
   https://github.com/ryusei67/board-app.git
  ### 2.MySQLでデータベースの作成
  　CREATE DATABASE board;
  ### 3.application.propertiesの設定
  application.propertiesをsrc/main/resources/application.propertiesに作成して実行環境に合わせて値を変更してください
  パスワードやメールアドレスなどの機密情報は、ご自身の環境に合わせて設定してください。

### データベース設定  
  spring.datasource.url=jdbc:mysql://localhost/{データベース名}
  
  spring.datasource.username=root
  
  spring.datasource.password={パスワード}

# JPA 設定
spring.jpa.hibernate.ddl-auto=update

spring.jpa.show-sql=true

spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect

### mail設定
  spring.mail.host=smtp.gmail.com
  
  spring.mail.port=587
  
  spring.mail.username={送信元メールアドレス}
  
  spring.mail.password={アプリパスワード}
  
  spring.mail.properties.mail.smtp.auth=true
  
  spring.mail.properties.mail.smtp.starttls.enable=true

### カスタム設定  
  mail.from ={送信元メールアドレス}
  
  mail.admin ={管理者宛メールアドレス}

  ### 4.アプリケーションの実行
  　エクリプスから実行
  ### 5.ブラウザからアクセス
  　http://localhost:8080/
　
