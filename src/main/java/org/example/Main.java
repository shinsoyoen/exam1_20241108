package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import dto.Article;
import Util.Util;

class Main {
    static List<Article> articles = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println("== 프로그램 시작 ==");

        makeTestData();

        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.printf("명령어) ");
            String command = sc.nextLine();
            command = command.trim();

            if (command.length() == 0) {
                continue;
            }

            if (command.equals("exit")) {
                break;
            } else if (command.equals("article list")) {
                if (articles.size() == 0) {
                    System.out.println("게시글이 없습니다.");
                    continue;
                }

                System.out.println("번호 |  제목  |  내용");
                for (int i = 0; i < articles.size(); i++) {
                    Article article = articles.get(i);

                    System.out.printf("%3d | %6s | %6s\n", article.id, article.title, article.body);

                }
            } else if (command.equals("article write")) {
                int id = articles.size() + 1;
                String regDate = Util.getNowDateStr();
                System.out.printf("제목 : ");
                String title = sc.nextLine();
                System.out.printf("내용 : ");
                String body = sc.nextLine();

                Article article = new Article(id, regDate, title, body);
                articles.add(article);

                System.out.printf("%d번 글이 생성되었습니다.\n", id);
            } else if (command.startsWith("article detail ")) {
                String[] commandBits = command.split(" ");
                int id = Integer.parseInt(commandBits[2]);

                Article foundArticle = getArticleById(id);

                if (foundArticle == null) {
                    System.out.printf("%d번 게시물은 존재하지 않습니다.\n", id);
                    continue;
                }

                System.out.printf("번호 : %d\n", foundArticle.id);
                System.out.printf("날짜 : %s\n", foundArticle.regDate);
                System.out.printf("제목 : %s\n", foundArticle.title);
                System.out.printf("내용 : %s\n", foundArticle.body);
            } else if (command.startsWith("article modify ")) {
                String[] commandBits = command.split(" ");
                int id = Integer.parseInt(commandBits[2]);

                Article foundArticle = getArticleById(id);

                if (foundArticle == null) {
                    System.out.printf("%d번 게시물은 존재하지 않습니다.\n", id);
                    continue;
                }

                System.out.printf("제목 : ");
                String title = sc.nextLine();
                System.out.printf("내용 : ");
                String body = sc.nextLine();

                foundArticle.title = title;
                foundArticle.body = body;

                System.out.printf("%d번 게시물이 수정되었습니다.\n", id);
            } else if (command.startsWith("article delete ")) {
                String[] commandBits = command.split(" ");
                int id = Integer.parseInt(commandBits[2]);

                int foundIndex = getArticleIndexById(id);

                if (foundIndex == -1) {
                    System.out.printf("%d번 게시물은 존재하지 않습니다.\n", id);
                    continue;
                }

                articles.remove(foundIndex);
                System.out.printf("%d번 게시물이 삭제되었습니다.\n", id);
            } else {
                System.out.printf("%s(은)는 존재하지 않는 명령어 입니다.\n", command);
            }

        }

        sc.close();
        System.out.println("== 프로그램 끝 ==");
    }

    private static void makeTestData() {
        System.out.println("테스트를 위한 데이터를 생성합니다.");
        articles.add(new Article(1, Util.getNowDateStr(), "제목1", "내용1"));
        articles.add(new Article(2, Util.getNowDateStr(), "제목2", "내용2"));
        articles.add(new Article(3, Util.getNowDateStr(), "제목3", "내용3"));

    }

    private static int getArticleIndexById(int id) {
        int i = 0;
        for (Article article : articles) {
            if (article.id == id) return i;
            i++;
        }

        return -1;
    }

    private static Article getArticleById(int id) {
        int index = getArticleIndexById(id);

        if (index != -1) {
            return articles.get(index);
        }

        return null;
    }
}

