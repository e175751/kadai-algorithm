/*Program name: list2.c*/
#include <stdio.h>
#include <stdlib.h>//実行に必要な要素を取り入れている

struct vertex{         //ポインタが示しているデータ構造
	int name, key;　　　　　//ポインタ変数  name,key
	struct vertex *next;
} *top;

int find_key(k)    //過去に変数keyに代入された数字を遡って探す
	int k;
{
	struct vertex *w;
	
	w = top;
	while(w != NULL){
		if (k == w->key)
			return 1;
		w = w->next;
	}
	return 0;
}

int delete_key(k)　　　//変数keyに代入された数字に被りが出てしまった場合、過去の被って
	int k;　　　　　　　　　　　　　　　　　//しまった数字を削除する
{
	struct vertex *w, *prev, *tmp;
	
	if(k == top->key){    /* top は　NULL ではない*/
		tmp = top;
		top = top->next;
		free(tmp);
	}
	else{
		prev = top;
		w = prev->next;
		while(w != NULL){
			if (k == w->key){
				prev->next = w->next;
				free(w);
				break;
			}
			prev = w;
			w = w->next;
		}
	}
	return 0;
}


int main()          //主に実行している関数。ここで関数の呼び出しを行う。
{
	struct vertex *new;
	int n, k, ans;
	
	printf("\n");
	printf("::::::::::::: リストへのデータ入力 ::::::::::::::::: \n");
	printf("\n");
	
	printf("各要素を入力して下さい\n");
	top = NULL;
	while(1){
		printf(" nameの値を入力しなさい:");
		scanf("%d",&n);
		if(n < 0) break; /* nが負ならばwhile文を終了*/
		printf("keyの値を入力して下さい:");
		scanf("%d",&k);
		if(find_key(k) == 1){　　　　　　//変数keyに代入された数字が過去にあったかを調べる
			printf("key:  %d は既登録です\n", k);
			printf("key が %d　のものを削除しますか？\n", k);
			printf("YES:1/NO:0==");
			scanf("%d",&ans);
			if (ans == 1) delete_key(k);　　//もし被りがあった際に、それを消すための作業
			else printf("もう一度nameの値から入力して下さい\n");
		}
		else{　　　　　　//もし、被りがなかった場合新しいアドレスを生成するための処理
			new = (struct vertex *) malloc(sizeof(struct vertex));
			new->name = n;
			new->key = k;
			new->next = top;
			top = new;
		}
	}
	printf("\n");
	printf("---------------------------------------------\n");
	printf("　入力したデータ　([name,key] の順番で");
	printf("ヘッドに近い　vretex から出力)\n");
	while(top != NULL){			//過去に代入された数字を[name,key]のくくりにして表示する
		printf("[%d,%d]",top->name, top->key);
		top = top->next;
	}
	printf("\n");
}


