package com.example.demo1;

import com.example.demo1.entity.Color;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Filter {
    private String carNumKeyword;
    private Color color;
}
