package pl.hollow.wallstreet.rate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.hollow.wallstreet.exception.EntityNotFoundException;
import pl.hollow.wallstreet.util.StringUtil;

import java.util.List;

@Service
class RateService {

    private RateRepository rateRepository;

    @Autowired
    public RateService(RateRepository rateRepository) {
        this.rateRepository = rateRepository;
    }

    public Rate getRate(String date) {
        return rateRepository.findById(date)
                .orElseThrow(() -> new EntityNotFoundException("Rate history from " + StringUtil.getDate(date) +
                        " " + Integer.parseInt(date.substring(8)) + ":00 unavailable"));
    }

    public List<Rate> getRates() {
        return rateRepository.findAll();
    }

    public void createRate(Rate rate) {
        rateRepository.save(rate);
    }

    public Rate updateRate(Rate rate) {
        return rateRepository.save(rate);
    }

    public void deleteRate(String date) {
        rateRepository.deleteById(date);
    }
}
