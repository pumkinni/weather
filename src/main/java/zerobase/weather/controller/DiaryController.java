package zerobase.weather.controller;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import zerobase.weather.domain.Diary;
import zerobase.weather.service.DiaryService;

import java.time.LocalDate;
import java.util.List;

@RestController
public class DiaryController {
    private final DiaryService diaryService;

    public DiaryController(DiaryService diaryService) {
        this.diaryService = diaryService;
    }

    // 다이어리 생성
    @PostMapping("/create/diary")
    void createDiary(@RequestParam
                     @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date, // date 타입이 다양해 포맷을 정하기 위해서 사용
                     @RequestBody String text) {
        diaryService.createDiary(date, text);
    }

    // 특정 날짜의 다이어리 값들을 가져오기
    @GetMapping("/read/diary")
    List<Diary> readDiary(@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
        return diaryService.readDiary(date);
    }

    // 특정 기간동안의 다이어리 값들을 가져오기
    @GetMapping("/read/diaries")
    List<Diary> readDairies(@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
                            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate) {
        return diaryService.readDiaries(startDate, endDate);
    }

    // 다이어리 수정
    @PutMapping("/update/diary")
    void upgradeDiary(@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date,
                      @RequestBody String text) {
        diaryService.updateDiary(date, text);
    }

    // 다이어리 삭제
    @DeleteMapping("/delete/diary")
    void deleteDairy(@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
        diaryService.deleteDiary(date);
    }
}
