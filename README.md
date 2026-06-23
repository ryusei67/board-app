(1)プロジェクト概要
  
  本アプリはSpring Bootフレームワークを使って作成した掲示板アプリケーションです。
  投稿の作成・一覧表示・詳細表示・編集・削除といった基本的なCRUD機能に加え、以下の機能を実装しています
  
  - 条件を指定できる検索機能(部分一致、前方一致、後方一致)
  - ソート機能(作成日、タイトル、昇順、降順)
  - ページネーション機能
  - Spring Securityを利用したログイン認証機能
  - ユーザー登録機能
  - 問い合わせフォームおよびメール送信機能
  - パリデーション機能
  - フラッシュメッセージ機能

(2)使用技術

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


(3)ローカル実行方法

### 1.リポジトリのクローン
   https://github.com/ryusei67/board-app.git
  ### 2.MySQLでデータベースの作成
  　CREATE DATABASE board;
  ### 3.Application Propertiesの設定
  　Application Propertiesの設定手順および設定値については
   別途お送りした「設定ファイルの作成.xlsx」にまとめておりますのでそちらを参照してください
  ### 4.アプリケーションの実行
  　エクリプスから実行
  ### 5.ブラウザからアクセス
  　http://localhost:8080/
　
