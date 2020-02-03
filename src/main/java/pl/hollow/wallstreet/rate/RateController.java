package pl.hollow.wallstreet.rate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.hollow.wallstreet.rate.dto.RateDto;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/rates")
public class RateController {

    private RateFacade rateFacade;
    private RateMapper rateMapper;

    @Autowired
    public RateController(RateFacade rateFacade, RateMapper rateMapper) {
        this.rateFacade = rateFacade;
        this.rateMapper = rateMapper;
    }

    @GetMapping("")
    public List<RateDto> getRates() {
        return rateMapper.ratesToRateDtos(rateFacade.getRates());
    }

    @GetMapping("/{date}")
    public RateDto getRate(@PathVariable String date) {
        return rateMapper.rateToRateDto(rateFacade.getRate(date));
    }

    @PostMapping("")
    public void createRate(@RequestBody RateDto rateDto) {
        rateFacade.createRate(rateMapper.rateDtoToRate(rateDto));
    }

    @PutMapping("")
    public RateDto updateRate(@RequestBody RateDto rateDto) {
        return rateMapper.rateToRateDto(rateFacade.updateRate(rateMapper.rateDtoToRate(rateDto)));
    }

    @DeleteMapping("/{date}")
    public void deleteRate(@PathVariable String date) {
        rateFacade.deleteRate(date);
    }
}
