##  1.9回目の課題　目次
- Serviceの実装
- 例外をハンドリングする処理をControllerに書く


## 2.作成したファイルの内容<br>
Cosemeticテーブルを作成し、カラムにないIDを検索したときに例外処理が表示されるようにしました。

ポストマンでの動作確認の一例です。
![image](https://github.com/hiro903/Kadai8/assets/145466271/3df81cba-b49e-4e6e-a76f-a895b140a6fb)
![image](https://github.com/hiro903/Kadai8/assets/145466271/60b7c1ea-c9e0-4e1f-bb39-b98f186bf923)
![image](https://github.com/hiro903/Kadai8/assets/145466271/05a7c31c-f81b-4832-8b7e-1ad9f3bfac87)
## 3.つまづいたところ<br>

- create-table-and-load-data.sqlファイルで、INSERT INTO のあとがテーブル名になっていなかった為テーブルにレコードが正しく登録されてなかった。<br>
- Dockerを立ち上げ忘れてスプリングブートを起動して、サーバーエラーになる。

## 4.学習した内容まとめ
学習記録も兼ねて記載します。

1.課題8でController,Mapperを扱い、今回はそこにビジネスロジック、特別な処理を担うServiceクラスを実装した。

2.存在しないIDを検索された場合にハンドリングする例外処理をつくる。

3.Mapperに、Optional<Cosmetic>のコンストラクタを作る。　`Optional<Cosmetic> findBYId(int id);`<br>Optional（存在しない）を使うことで、その値がnullかもしれない…と覚えておく。<br>

4.Serviceクラスに存在しないIDが検索されたときに、例外クラスを呼びだす処理を書き、Controllerクラスに例外に対する設定をMap型で記載する。

5.Controllerクラスに直接記載する方法は同一Controllerで発生した例外にのみ対応できるが、専用のクラスを作成し@ControllerAdviceを付与した場合は、全てのControllerを横断的にハンドリングできる。

6.アノテーションの意味、使い方。<br>@ControllerAdvice
コントローラーアドバイスクラスに設定します。このアノテーションが設定されると、クラスが DI コンテナへの登録対象としてマークされます。

@ExceptionHandler
例外をハンドリングするコントローラーメソッドに設定します。対処する例外クラスごとに、複数定義することができます。<br>
コントローラーでも使用できますが、この場合、そのコントローラー内のみで有効になります。コントローラーアドバイスで設定した場合は、すべてのコントローラーに対して、横断的に作用します。
## 5.今後の課題、気を付けること
年末の仕事の忙しさからの体調不良でしばらく学習することができず、忘れていることも多かった。
コードはなるべくコピペではなく、記憶の定着の為に自分で打ち込み、イメージできなくなったら絵に書いてやることを意識する。
GitHubにpushする流れのおさらい。
## 6.訂正・追加事項
- @ControllerAdviceの追加。
- ServiceクラスでorElseThrowに書き替える
- CosmeticControllerクラスの@GetMappingの処理の書き替え<br>ResponseEntityを使ってnullだった場合の処理を書く。
- ```
   @GetMapping("/cosmetics/{id}")
  public ResponseEntity<Cosmetic> getCosmetic(@PathVariable("id") int id) {
  Cosmetic cosmetic = cosmeticService.findCosmetic(id);
        if (cosmetic != null) {
            return new ResponseEntity<>(cosmetic, HttpStatus.OK);
        } else {
            throw new CosmeticNotFoundException("Cosmetic not found with id: " + id);
        }
  }
  ``` 
- Optionalを使ったら↓
- ```
  @GetMapping("/cosmetics/{id}")
   public ResponseEntity<Cosmetic> getCosmetic(@PathVariable("id") int id) {
   Optional<Cosmetic> optionalCosmetic = cosmeticService.findCosmetic(id);

    return optionalCosmetic
            .map(cosmetic -> new ResponseEntity<>(cosmetic, HttpStatus.OK))
            .orElseThrow(() -> new CosmeticNotFoundException("Cosmetic not found with id: " + id));
}
```
