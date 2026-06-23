# Board App

## 1. プロジェクト概要

本アプリは Spring Boot フレームワークを用いて作成した掲示板アプリケーションです。

投稿の作成・一覧表示・詳細表示・編集・削除といった基本的な CRUD 機能に加え、検索機能、ログイン認証機能、問い合わせメール機能を実装し、Web アプリケーション開発に必要な基本機能を備えています。

## 2. 主な機能

### 認証機能

- ユーザー登録
- ログイン
- ログアウト

### 投稿機能

- 投稿新規登録
- 投稿一覧表示
- 投稿詳細表示
- 投稿編集
- 投稿削除

### 検索・表示機能

- 部分一致検索
- 前方一致検索
- 後方一致検索
- ソート機能
  - 作成日
  - タイトル
  - 昇順
  - 降順
- ページネーション機能

### 問い合わせ機能

- 問い合わせフォーム
- 入力内容確認画面
- メール送信機能

### その他機能

- バリデーション機能
- フラッシュメッセージ機能

## 3. 使用技術

### バックエンド

- Java 17
- Spring Boot 3.5.14
- Spring Security
- Spring Data JPA

### フロントエンド

- HTML
- CSS
- Thymeleaf 3.1.3.RELEASE

### データベース

- MySQL 9.6.0

### その他

- Lombok 1.18.42
- Validation 9.0.1
- Spring Mail

## 4. ローカル実行方法

### 1. リポジトリのクローン

```bash
git clone https://github.com/ryusei67/board-app.git
```

### 2. MySQLでデータベースを作成

```sql
CREATE DATABASE board;
```

### 3. application.properties の設定

`src/main/resources/application.properties` を作成し、実行環境に合わせて値を設定してください。

※ パスワードやメールアドレスなどの機密情報は、ご自身の環境に合わせて設定してください。

```properties
# データベース設定
spring.datasource.url=jdbc:mysql://localhost:3306/{データベース名}
spring.datasource.username=root
spring.datasource.password={パスワード}

# JPA設定
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect

# Mail設定
spring.mail.host=smtp.gmail.com
spring.mail.port=587
spring.mail.username={送信元メールアドレス}
spring.mail.password={アプリパスワード}
spring.mail.properties.mail.smtp.auth=true
spring.mail.properties.mail.smtp.starttls.enable=true

# カスタム設定
mail.from={送信元メールアドレス}
mail.admin={管理者宛メールアドレス}
```

### 4. アプリケーションの実行

Eclipse から起動

### 5. ブラウザからアクセス

```
http://localhost:8080/
```
