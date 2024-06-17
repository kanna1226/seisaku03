# タスク管理アプリ(seisaku03/WorkOptimizer)

仕事をする中で、どのタスクをどれくらいの時間で終わらせることができるかや、１日の時間配分が気になることがありませんか。そのような時、このアプリを使えば、簡単にタスクを管理することができます。タスクを可視化することで、時間の使い方や、予定の立て方がもっと効率的にできます。

# DEMO

実行動画です
https://github.com/kanna1226/seisaku03/assets/168618983/32cc9f64-9566-4a03-8f94-34990ae0524a

# Features

1.予定時間と実際にかかった時間を表示、集計
2.タスクの登録、業務の実行が簡単
3.集中力と持続力を高めてくれる青を基調としたデザイン

# Requirement

* H2データベース
* Eclipse2023以降
* Apache Tomcat (Tomcat9_Java17)

# Usage

1.Eclipse上でプロジェクトのクローンをする
　Gitリポジトリーをビューに追加　→　「Gitリポジトリーをクローンし、このビューへ追加」を押下
2.プロジェクトのインポート
　作業ツリーを右クリックし、「プロジェクトのインポート」を押下、WorkOptimizerフォルダを作成し、インポート
3.H2データベースの準備
　/WorkOptimizer/WorkOptimizer/01.データベース内にある下記ファイルをコピー
　　workoptimizer.mv.db
　　workoptimizer.trace.db
  /dataに上記ファイルを配置
4.サーバーTomcat9_Java17で index.jsp を実行

5.ユーザーID:test パスワード:1234 でログイン
6.「タスク入力」を押下
7.タスクを入力して「登録」を押下
8.「業務開始」を押下
9.適切な業務の「start」「end」を押下
10.業務終了を押下
11.ログアウトを押下

# Author

* 井上カンナ
* y3_k12.26@icloud.com

# License

WorkOptimizer is under [MIT license](https://en.wikipedia.org/wiki/MIT_License).
