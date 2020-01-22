package pl.hollow.wallstreet.rate;

import org.mapstruct.*;
import pl.hollow.wallstreet.rate.dto.RateDto;

import java.util.List;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
interface RateMapper {

    RateDto rateToRateDto(Rate rate);
    Rate rateDtoToRate(RateDto rateDto);
    List<RateDto> ratesToRateDtos(List<Rate> rates);
}
