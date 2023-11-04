package com.ctf_kg.ctf_kg.service;

import java.io.IOException;

public interface ParserService {
    void parsePages(String baseUrl, int maxPages) throws IOException;

    void parse(String url) throws IOException;
}
