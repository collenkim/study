package backend.study.logtracing.api;

import backend.study.logtracing.dto.LogDto;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class LogtracingApi {

    @GetMapping("/logs")
    public ResponseEntity<List<LogDto>> getAllLogs() {
        // 예시 데이터
        List<LogDto> logs = List.of(
            new LogDto("시스템 시작", "INFO", "2025-04-22T12:00:00"),
            new LogDto("오류 발생", "ERROR", "2025-04-22T12:05:00")
        );
        return ResponseEntity.ok(logs);
    }

    // GET /logs/{id} → 특정 로그 조회
    @GetMapping("/logs/{id}")
    public ResponseEntity<LogDto> getLogById(@PathVariable Long id) {
        LogDto log = new LogDto("특정 로그", "DEBUG", "2025-04-22T12:10:00");
        return ResponseEntity.ok(log);
    }

    // POST /logs → 로그 추가
    @PostMapping("/logs")
    public ResponseEntity<String> createLog(@RequestBody LogDto logDto) {
        return ResponseEntity.ok("로그 저장 완료");
    }

    // PUT /logs/{id} → 로그 전체 수정
    @PutMapping("/logs/{id}")
    public ResponseEntity<String> updateLog(@PathVariable Long id, @RequestBody LogDto logDto) {
        return ResponseEntity.ok("로그 수정 완료");
    }

    // DELETE /logs/{id} → 로그 삭제
    @DeleteMapping("/logs/{id}")
    public ResponseEntity<String> deleteLog(@PathVariable Long id) {
        return ResponseEntity.ok("로그 삭제 완료");
    }

}
