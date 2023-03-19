package zerobase.weather.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
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
    @ApiOperation("일기 텍스트, 날씨를 이용해 DB에 일기 저장")
    @PostMapping("/create/diary")
    void createDiary(@RequestParam
                     @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) @ApiParam(value = "저장할 일기의 날짜", example = "2022-01-01") LocalDate date, // date 타입이 다양해 포맷을 정하기 위해서 사용
                     @RequestBody @ApiParam(value = "저장할 일기의 내용", example = "오늘은 api swagger 에 대해 배웠다.") String text) {
        diaryService.createDiary(date, text);
    }

    // 특정 날짜의 다이어리 값들을 가져오기
    @ApiOperation("선택 날짜의 다이어리 값들을 가져오기")
    @GetMapping("/read/diary")
    List<Diary> readDiary(@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) @ApiParam(value = "조회할 날짜", example = "2022-01-01") LocalDate date) {
        return diaryService.readDiary(date);
    }

    // 특정 기간동안의 다이어리 값들을 가져오기
    @ApiOperation("선택 기간의 모든 다이어리 값들을 가져오기")
    @GetMapping("/read/diaries")
    List<Diary> readDairies(@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) @ApiParam(value = "조회할 기간의 시작 날", example = "2022-01-01") LocalDate startDate,
                            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) @ApiParam(value = "조회할 기간의 마지막 날", example = "2022-01-31") LocalDate endDate) {
        return diaryService.readDiaries(startDate, endDate);
    }

    // 다이어리 수정
    @ApiOperation("선택 날짜의 가장 오래된 일기의 값을 수정")
    @PutMapping("/update/diary")
    void upgradeDiary(@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) @ApiParam(value = "수정할 일기의 날짜", example = "2022-01-01") LocalDate date,
                      @RequestBody String text) {
        diaryService.updateDiary(date, text);
    }

    // 다이어리 삭제
    @ApiOperation("선택 날짜의 모든 일기들을 삭제")
    @DeleteMapping("/delete/diary")
    void deleteDairy(@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) @ApiParam(value = "삭제할 일기의 날찌", example = "2022-01-01") LocalDate date) {
        diaryService.deleteDiary(date);
    }
}
