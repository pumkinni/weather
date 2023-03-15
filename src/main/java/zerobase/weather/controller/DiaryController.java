package zerobase.weather.controller;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import zerobase.weather.service.DiaryService;

import java.time.LocalDate;

@RestController
public class DiaryController {
    private final DiaryService diaryService;

    public DiaryController(DiaryService diaryService) {
        this.diaryService = diaryService;
    }

    @PostMapping("/create/diary")
    void createDiary(@RequestParam
                     @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date, // date 타입이 다양해 포맷을 정하기 위해서 사용
                     @RequestBody String text) {
        diaryService.createDiary(date, text);
    }
}
