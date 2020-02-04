package pl.hollow.wallstreet.rate;

import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import pl.hollow.wallstreet.rate.dto.RateDto;
import pl.hollow.wallstreet.rate.dto.SingleRateDto;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
abstract class RateMapper {

    abstract List<RateDto> ratesToRateDtos(List<Rate> rates);

    RateDto rateToRateDto(Rate rate) {
        RateDto rateDto = new RateDto();
        rateDto.setDate(rate.getDate());
        rateDto.setPurchaseRates(rateToRatePurchaseDto(rate));
        rateDto.setSaleRates(rateToRateSaleDto(rate));
        return rateDto;
    }

    private List<SingleRateDto> rateToRatePurchaseDto(Rate rate) {
        List<SingleRateDto> ratePurchaseDtos = new ArrayList<>();
        ratePurchaseDtos.add(new SingleRateDto("bitcoinPurchaseRate", rate.getBitcoinRate()));
        ratePurchaseDtos.add(new SingleRateDto("hufPurchaseRate", rate.getHufRate()));
        ratePurchaseDtos.add(new SingleRateDto("czkPurchaseRate", rate.getCzkRate()));
        ratePurchaseDtos.add(new SingleRateDto("ronPurchaseRate", rate.getRonRate()));
        ratePurchaseDtos.add(new SingleRateDto("sekPurchaseRate", rate.getSekRate()));
        ratePurchaseDtos.add(new SingleRateDto("rubPurchaseRate", rate.getRubRate()));
        ratePurchaseDtos.add(new SingleRateDto("chfPurchaseRate", rate.getChfRate()));
        ratePurchaseDtos.add(new SingleRateDto("eurPurchaseRate", rate.getEurRate()));
        ratePurchaseDtos.add(new SingleRateDto("bgnPurchaseRate", rate.getBgnRate()));
        ratePurchaseDtos.add(new SingleRateDto("nokPurchaseRate", rate.getNokRate()));
        ratePurchaseDtos.add(new SingleRateDto("usdPurchaseRate", rate.getUsdRate()));
        ratePurchaseDtos.add(new SingleRateDto("gbpPurchaseRate", rate.getGbpRate()));
        return ratePurchaseDtos;
    }

    private List<SingleRateDto> rateToRateSaleDto(Rate rate) {
        List<SingleRateDto> ratePurchaseDtos = new ArrayList<>();
        ratePurchaseDtos.add(new SingleRateDto("bitcoinSaleRate", invert(rate.getBitcoinRate())));
        ratePurchaseDtos.add(new SingleRateDto("hufSaleRate", invert(rate.getHufRate())));
        ratePurchaseDtos.add(new SingleRateDto("czkSaleRate", invert(rate.getCzkRate())));
        ratePurchaseDtos.add(new SingleRateDto("ronSaleRate", invert(rate.getRonRate())));
        ratePurchaseDtos.add(new SingleRateDto("sekSaleRate", invert(rate.getSekRate())));
        ratePurchaseDtos.add(new SingleRateDto("rubSaleRate", invert(rate.getRubRate())));
        ratePurchaseDtos.add(new SingleRateDto("chfSaleRate", invert(rate.getChfRate())));
        ratePurchaseDtos.add(new SingleRateDto("eurSaleRate", invert(rate.getEurRate())));
        ratePurchaseDtos.add(new SingleRateDto("bgnSaleRate", invert(rate.getBgnRate())));
        ratePurchaseDtos.add(new SingleRateDto("nokSaleRate", invert(rate.getNokRate())));
        ratePurchaseDtos.add(new SingleRateDto("usdSaleRate", invert(rate.getUsdRate())));
        ratePurchaseDtos.add(new SingleRateDto("gbpSaleRate", invert(rate.getGbpRate())));
        return ratePurchaseDtos;
    }

    private BigDecimal invert(BigDecimal rateInDecimal) {
        if (rateInDecimal == null) {
            return null;
        }
        return new BigDecimal("1").setScale(9).divide(rateInDecimal, RoundingMode.UP);
    }
}
