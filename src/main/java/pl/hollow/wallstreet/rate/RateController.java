package pl.hollow.wallstreet.rate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.hollow.wallstreet.rate.dto.RateDto;

import java.util.List;

@RestController
@RequestMapping("/rate")
public class RateController {

    private RateFacade rateFacade;
    private RateMapper rateMapper;

    @Autowired
    public RateController(RateFacade rateFacade, RateMapper rateMapper) {
        this.rateFacade = rateFacade;
        this.rateMapper = rateMapper;
    }

    @GetMapping
    public List<RateDto> getRates() {
        return rateMapper.ratesToRateDtos(rateFacade.getRates());
    }

    @GetMapping
    public RateDto getRate(String date) {
        return rateMapper.rateToRateDto(rateFacade.getRate(date));
    }

    @PostMapping
    public void createRate(RateDto rateDto) {
        rateFacade.createRate(rateMapper.rateDtoToRate(rateDto));
    }

    @PutMapping
    public RateDto updateRate(RateDto rateDto) {
        return rateMapper.rateToRateDto(rateFacade.updateRate(rateMapper.rateDtoToRate(rateDto)));
    }

    @DeleteMapping
    public void deleteRate(String date) {
        rateFacade.deleteRate(date);
    }
}
