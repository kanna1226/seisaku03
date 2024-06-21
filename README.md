# タスク管理アプリ(seisaku03/WorkOptimizer)

仕事をする中で、どのタスクをどれくらいの時間で終わらせることができるかや、１日の時間配分が気になることがありませんか。そのような時、このアプリを使えば、簡単にタスクを管理することができます。タスクを可視化することで、時間の使い方や、予定の立て方をもっと効率的にできます。

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

実行準備  
1.Eclipse上でプロジェクトのクローンをする  
　https://github.com/kanna1226/seisaku03
  でGitのコードをコピーする　　
　Gitリポジトリーをビューに追加　→　「Gitリポジトリーをクローンし、このビューへ追加」を押下  
 ![01 start](https://github.com/kanna1226/seisaku03/assets/168618983/c4feb49d-43d0-44c4-9c88-6abec785be1d)  
 ![02 clone](https://github.com/kanna1226/seisaku03/assets/168618983/e35a80f7-7b01-46da-9d98-5f86d70ea874)  
 ![03 cloneDetale1](https://github.com/kanna1226/seisaku03/assets/168618983/c2b3f13e-45d6-44ca-8d05-209c45c682d4) 
 フォルダ選択の際、参照を押下し、適切なフォルダを選択、「WorkOptimizer」というファイル名で保存し、「完了」を押下  
 ![04 cloneSelectFile](https://github.com/kanna1226/seisaku03/assets/168618983/171b3807-62c7-4a49-b167-d5ef4eb8aede)  
 ![05 cloneFinish](https://github.com/kanna1226/seisaku03/assets/168618983/e5752623-f1f7-4a11-9efa-a686f80c7b70)  





2.プロジェクトのインポート  
masterブランチを右クリックし、「プロジェクトのインポート」を押下し、インポート  
![06 projectImport](https://github.com/kanna1226/seisaku03/assets/168618983/05b6bb27-7529-433f-9a70-32aa90bf8127)  

 
3.H2データベースの準備  
　/WorkOptimizer/WorkOptimizer/01.データベース内にある下記ファイルをコピー  
　　workoptimizer.mv.db  
　　workoptimizer.trace.db  
　/dataに上記ファイルを配置  
![08 database](https://github.com/kanna1226/seisaku03/assets/168618983/de170eb5-1ee4-4144-a416-b8ab265f8d92)  

 
4.サーバーTomcat9_Java17で index.jsp を実行  
![07 projectExecution](https://github.com/kanna1226/seisaku03/assets/168618983/8fd1a0d6-4798-48a6-bf3d-0f3f70d6ac4f)  

操作手順  
1.ユーザーID:test パスワード:1234 でログイン  
2.「タスク入力」を押下  
3.タスクを入力して「登録」を押下  
4.「業務開始」を押下  
5.適切な業務の「start」「end」を押下  
6.業務終了を押下  
7.ログアウトを押下  

# Author

* 井上カンナ
* y3_k12.26@icloud.com

# License

WorkOptimizer is under [MIT license](https://en.wikipedia.org/wiki/MIT_License).
