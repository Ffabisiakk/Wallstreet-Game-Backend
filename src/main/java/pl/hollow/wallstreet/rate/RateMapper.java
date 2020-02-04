package pl.hollow.wallstreet.rate;

import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import pl.hollow.wallstreet.rate.dto.RateDto;
import pl.hollow.wallstreet.rate.dto.SingleRateDto;
import pl.hollow.wallstreet.util.StringUtil;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
abstract class RateMapper {

    abstract List<RateDto> ratesToRateDtos(List<Rate> rates);

    RateDto rateToRateDto(Rate rate) {
        RateDto rateDto = new RateDto();
        rateDto.setDate(StringUtil.formatToDate(rate.getDate()));
        rateDto.setPurchaseRates(rateToRatePurchaseDto(rate));
        rateDto.setSaleRates(rateToRateSaleDto(rate));
        return rateDto;
    }

    private List<SingleRateDto> rateToRatePurchaseDto(Rate rate) {
        List<SingleRateDto> ratePurchaseDtos = new ArrayList<>();
        ratePurchaseDtos.add(new SingleRateDto("BTC", rate.getBitcoinRate()));
        ratePurchaseDtos.add(new SingleRateDto("HUF", rate.getHufRate()));
        ratePurchaseDtos.add(new SingleRateDto("CZK", rate.getCzkRate()));
        ratePurchaseDtos.add(new SingleRateDto("RON", rate.getRonRate()));
        ratePurchaseDtos.add(new SingleRateDto("SEK", rate.getSekRate()));
        ratePurchaseDtos.add(new SingleRateDto("RUB", rate.getRubRate()));
        ratePurchaseDtos.add(new SingleRateDto("CHF", rate.getChfRate()));
        ratePurchaseDtos.add(new SingleRateDto("EUR", rate.getEurRate()));
        ratePurchaseDtos.add(new SingleRateDto("BGN", rate.getBgnRate()));
        ratePurchaseDtos.add(new SingleRateDto("NOK", rate.getNokRate()));
        ratePurchaseDtos.add(new SingleRateDto("USD", rate.getUsdRate()));
        ratePurchaseDtos.add(new SingleRateDto("GBP", rate.getGbpRate()));
        return ratePurchaseDtos;
    }

    private List<SingleRateDto> rateToRateSaleDto(Rate rate) {
        List<SingleRateDto> rateSaleDtos = new ArrayList<>();
        rateSaleDtos.add(new SingleRateDto("BTC", invert(rate.getBitcoinRate())));
        rateSaleDtos.add(new SingleRateDto("HUF", invert(rate.getHufRate())));
        rateSaleDtos.add(new SingleRateDto("CZK", invert(rate.getCzkRate())));
        rateSaleDtos.add(new SingleRateDto("RON", invert(rate.getRonRate())));
        rateSaleDtos.add(new SingleRateDto("SEK", invert(rate.getSekRate())));
        rateSaleDtos.add(new SingleRateDto("RUB", invert(rate.getRubRate())));
        rateSaleDtos.add(new SingleRateDto("CHF", invert(rate.getChfRate())));
        rateSaleDtos.add(new SingleRateDto("EUR", invert(rate.getEurRate())));
        rateSaleDtos.add(new SingleRateDto("BGN", invert(rate.getBgnRate())));
        rateSaleDtos.add(new SingleRateDto("NOK", invert(rate.getNokRate())));
        rateSaleDtos.add(new SingleRateDto("USD", invert(rate.getUsdRate())));
        rateSaleDtos.add(new SingleRateDto("GBP", invert(rate.getGbpRate())));
        return rateSaleDtos;
    }

    private BigDecimal invert(BigDecimal rateInDecimal) {
        if (rateInDecimal == null) {
            return null;
        }
        return BigDecimal.ONE.setScale(9, RoundingMode.UP).divide(rateInDecimal, RoundingMode.UP);
    }
}
