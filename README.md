# KokoLang (ココラン)

KokoLang (ココラン) は、グローバルな学習者を対象とした言語学習プラットフォームです。  
現在は初期フェーズとして、韓国語を学び始めたユーザー向けに、ポータル型トップページとミニゲーム形式の学習コンテンツを実装しています。

## 概要

本プロジェクトは、Spring Boot、Thymeleaf、Vanilla JavaScript、PostgreSQL を利用したモノリシック構成の Web アプリケーションです。  
キッズ向けポータルの親しみやすさを取り入れつつ、将来的には複数言語・複数コンテンツへ拡張できる学習サービスとして設計を進めています。

## 主な機能

- ポータル型トップページ
  - 明るいヘッダー、検索 UI、カテゴリタブを備えたメイン画面
  - 学習コンテンツをカード形式で選択できるゲームグリッド
- ミニゲーム: 母音キャッチ！
  - Web Speech API で韓国語母音を聞き、4択から正しい母音を選ぶ学習ゲーム
  - 10ステージ制、スコア表示、正解・不正解フィードバック、クリア画面に対応
  - ゲーム中にメイン画面へ戻れる中断ボタンを搭載
- PostgreSQL / JPA 設定
  - 環境変数による接続情報の切り替えに対応
  - 開発初期段階として `ddl-auto=update` を使用

## 技術スタック

- Java 21
- Spring Boot 4
- Spring Web MVC
- Thymeleaf
- Spring Data JPA
- PostgreSQL
- Vanilla JavaScript
- Gradle

## 画面構成

| パス | 画面 | 説明 |
| --- | --- | --- |
| `/` | トップページ | KokoLang (ココラン) のポータル型メイン画面 |
| `/game/vowel` | 母音キャッチ！ | 韓国語母音を使ったリスニングミニゲーム |

## セットアップ

### 前提条件

- Java 21
- PostgreSQL
- Git

### データベース設定

`src/main/resources/application.properties` では、以下の環境変数を利用できます。

```bash
POSTGRES_URL=jdbc:postgresql://localhost:5432/language_helper
POSTGRES_USERNAME=language_helper
POSTGRES_PASSWORD=language_helper
```

環境変数を指定しない場合は、上記のデフォルト値が利用されます。

### 起動方法

```bash
./gradlew bootRun
```

起動後、以下の URL でアクセスできます。

```text
http://localhost:8083/
```

## テスト

```bash
./gradlew test
```

## ディレクトリ構成

```text
src/main/java/com/languagehelper
  LanguageHelperApplication.java
  GameController.java

src/main/resources
  application.properties
  templates/
    index.html
    vowel-game.html
  static/
```

## 今後の拡張方針

- 学習対象言語の追加
- ミニゲームの追加
- ユーザー学習履歴・スコア管理
- コンテンツ管理機能
- 多言語 UI 対応

## 開発メモ

現時点では、UI プロトタイプと画面遷移の基礎実装を優先しています。  
今後、ユーザー管理、教材データ、ゲーム結果の永続化などの機能追加に合わせて、ドメインモデルとデータベース設計を段階的に拡張する想定です。
