package com.example.demo1.domain;

import com.example.demo1.entity.Color;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Filter {
    int page;
    int size;
    private String carNumKeyword;
    private Color color;
}
