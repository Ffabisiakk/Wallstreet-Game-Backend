package pl.hollow.wallstreet.rate;

import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import pl.hollow.wallstreet.rate.dto.RateDto;
import pl.hollow.wallstreet.util.StringUtil;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

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

    private Map<String, BigDecimal> rateToRatePurchaseDto(Rate rate) {
        return rate.getRates();
    }

    private Map<String, BigDecimal> rateToRateSaleDto(Rate rate) {
        Map<String, BigDecimal> rateSaleDtos = new LinkedHashMap<>();
        rate.getRates().forEach((key, value) -> rateSaleDtos.put(key, invert(value)));
        return rateSaleDtos;
    }

    private BigDecimal invert(BigDecimal rateInDecimal) {
        if (rateInDecimal == null) {
            return null;
        }
        return BigDecimal.ONE.setScale(9, RoundingMode.UP).divide(rateInDecimal, RoundingMode.UP);
    }
}
