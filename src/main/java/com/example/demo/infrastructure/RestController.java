package com.example.demo.infrastructure;

import com.example.demo.core.application.WriteFizzBussInboundPort;
import com.example.demo.core.application.WriteFizzBussOutboundPort;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class RestController implements WriteFizzBussInboundPort {

    @Autowired
    private WriteFizzBussOutboundPort fizzBuzzUseCase;

    @Override
    public List<String> writeFizzBuzz(Integer int1, Integer int2, Integer limit, String str1, String str2) {
        return null;
    }
}
