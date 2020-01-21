package pl.hollow.wallstreet.rate;

import org.mapstruct.*;
import pl.hollow.wallstreet.rate.dto.RateDto;

import java.util.List;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
interface RateMapper {

    RateDto rateToRateDto(Rate rate);
    void rateDtoToRate(RateDto rateDto, @MappingTarget Rate rate);
    List<RateDto> ratesToRateDtos(List<Rate> rates);
}
