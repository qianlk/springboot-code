package org.sboot.service.impl;

import org.sboot.service.BookService;

/**
 * @author qlk
 */
public class BookServiceImpl implements BookService {

    @Override
    public void check() {
        System.out.println("book service 1.");
    }
}
