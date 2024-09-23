package org.sax;

import java.util.ArrayList;

public class Catalog {
    private ArrayList<Book> books;

    public Catalog() {
        books = new ArrayList<>();
    }

    public ArrayList<Book> getBooks() {
        return books;
    }

    public void setBooks(ArrayList<Book> books) {
        this.books = books;
    }

    public void addBook(Book book){
        this.books.add(book);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Book b : books) {
            sb.append(b.toString());
        }
        return sb.toString();
    }

}
