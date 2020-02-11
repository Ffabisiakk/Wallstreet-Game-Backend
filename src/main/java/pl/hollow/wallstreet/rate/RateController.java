package pl.hollow.wallstreet.rate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.hollow.wallstreet.rate.dto.RateDto;
import pl.hollow.wallstreet.util.StringUtil;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/rates")
public class RateController {

    private RateService rateService;
    private RateMapper rateMapper;

    @Autowired
    public RateController(RateService rateService, RateMapper rateMapper) {
        this.rateService = rateService;
        this.rateMapper = rateMapper;
    }

    @GetMapping("")
    public List<RateDto> getRates() {
        return rateMapper.ratesToRateDtos(rateService.getRates());
    }

    @GetMapping("/{date}")
    public RateDto getRate(@PathVariable String date) {
        String dateId = StringUtil.formatToDateId(date);
        return rateMapper.rateToRateDto(rateService.getRate(dateId));
    }

}
