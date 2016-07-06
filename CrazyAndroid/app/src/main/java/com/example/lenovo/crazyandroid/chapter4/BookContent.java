package com.example.lenovo.crazyandroid.chapter4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by LENOVO on 2016/1/4.
 */
public class BookContent {
    public static class Book{
        public Integer id;
        public String title;
        public String desc;

        public Book(Integer id, String title, String desc) {
            this.id = id;
            this.title = title;
            this.desc = desc;
        }

        @Override
        public String toString() {
            return "Book{" +
                    "id=" + id +
                    ", title='" + title + '\'' +
                    ", desc='" + desc + '\'' +
                    '}';
        }
    }
    public static List<Book> ITEMS = new ArrayList<Book>();
    public static Map<Integer,Book> ITEM_MAP = new HashMap<Integer,Book>();
    static{
        addItem(new Book(1,"疯狂Java讲义","一本全面、深入的Java学习图书，已被多家高校选作教材"));
        addItem(new Book(1,"疯狂Android讲义","一本全面、深入的Android学习图书，已被多家高校选作教材"));
        addItem(new Book(1,"疯狂JavaEE讲义","一本全面、深入的JavaEE学习图书，已被多家高校选作教材"));
    }
    private static void addItem(Book book){
        ITEMS.add(book);
        ITEM_MAP.put(book.id,book);
    }
}
