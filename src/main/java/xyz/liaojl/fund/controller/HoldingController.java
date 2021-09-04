package xyz.liaojl.fund.controller;

import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.liaojl.fund.common.HttpResponse;
import xyz.liaojl.fund.entity.Holding;
import xyz.liaojl.fund.service.HoldingService;

import javax.validation.Valid;
import java.util.List;

@Tag(name = "Fund Holding", description = "Holding management")
@RestController
@RequestMapping("/api/holdings")
public class HoldingController {
    @Autowired
    private HoldingService holdingService;

    @PostMapping
    public HttpResponse<Holding> add(@RequestBody @Valid Holding holding) {
        return HttpResponse.success(holdingService.add(holding));
    }

    @PutMapping("/{id}")
    public HttpResponse<Holding> update(@RequestBody @Valid Holding holding,
                                        @Parameter(name = "Holding id", in = ParameterIn.PATH) @PathVariable Long id) {
        holding.setId(id);
        return HttpResponse.success(holdingService.updateHolding(holding));
    }

    @DeleteMapping("/{id}")
    public HttpResponse<String> delete(@Parameter(name = "Holding id", in = ParameterIn.PATH) @PathVariable Long id) {
        holdingService.deleteHolding(id);
        return HttpResponse.success();
    }

    @GetMapping({"/{id}"})
    public HttpResponse<Holding> get(@Parameter(name = "Holding id", in = ParameterIn.PATH) @PathVariable Long id) {
        return HttpResponse.success(holdingService.get(id));
    }

    @GetMapping
    public HttpResponse<List<Holding>> getAll() {
        return HttpResponse.success(holdingService.getAll());
    }
}
