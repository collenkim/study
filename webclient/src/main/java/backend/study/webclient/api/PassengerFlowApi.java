package backend.study.webclient.api;

import backend.study.webclient.service.PassengerFlowService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/passenger-flow")
@RequiredArgsConstructor
public class PassengerFlowApi {

    private final PassengerFlowService passengerFlowService;

    /**
     * 공항 승객 예보 조회
     *
     * @param selectDate
     */
    @GetMapping
    public void getPassengerFlowList(@RequestParam("selectDate") String selectDate) {
        passengerFlowService.getPassengerFlowBySelectDate(selectDate);
    }

    /**
     * 공항 승객 예보 정보 저장
     *
     * @param selectDate
     */
    @PostMapping
    public void insertPassengerFlow(@RequestParam("selectDate") String selectDate) {
        passengerFlowService.insertPassengerFlowBySelectDate(selectDate);
    }

    /**
     * 공항 승객 예보 정보 수정
     *
     * @param id
     */
    @PutMapping("/{id}")
    public void updatePassengerFlow(@PathVariable("id") String id) {
        passengerFlowService.updatePassengerFlowById(id);
    }

    /**
     * 공항 승객 예보 정보 삭제
     *
     * @param id
     */
    @DeleteMapping("/{id}")
    public void deletePassengerFlow(@PathVariable("id") String id) {
        passengerFlowService.deletePassengerFlowById(id);
    }

}
