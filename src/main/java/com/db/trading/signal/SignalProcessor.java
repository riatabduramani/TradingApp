package com.db.trading.signal;

import com.db.trading.dto.Signal;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class SignalProcessor {

    private final Gson gson;

    public List<Signal> payload() {
        try {
            File file = ResourceUtils.getFile("classpath:signalList.json");
            Type foundListType = new TypeToken<ArrayList<Signal>>(){}.getType();
            return gson.fromJson(new FileReader(file), foundListType);
        } catch (FileNotFoundException e) {
            throw new RuntimeException("File not found: " + e.getMessage());
        }
    }
}
