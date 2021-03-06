package com.kodilla.patterns.prototype.library;

import java.util.HashSet;
import java.util.Set;

public final class Library extends Prototype {
    private String name;
    private Set<Book> books = new HashSet<>();

    public Library(final String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Set<Book> getBooks() {
        return books;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBooks(Set<Book> books) {
        this.books = books;
    }

    @Override
    public String toString() {
        String s = "Library: " + name;
        for (Book book : books) {
            s = s + "\n  " + book.toString();
        }
        s += "\n";
        return s;
    }

    public Library shallowCopy() throws CloneNotSupportedException {
        return (Library)super.clone();
    }

    public Library deepCopy() throws CloneNotSupportedException {
        Library clonedLibrary = (Library)super.clone();
        clonedLibrary.setBooks(new HashSet<>());
        for (Book book : books) {
            clonedLibrary.getBooks().add(new Book(book.getTitle(),book.getAuthor(),book.getPublicationDate()));
        }
        return clonedLibrary;
    }

}