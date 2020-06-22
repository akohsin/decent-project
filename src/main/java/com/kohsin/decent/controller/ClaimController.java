package com.kohsin.decent.controller;

import com.kohsin.decent.dto.ClaimResponseDto;
import com.kohsin.decent.service.ClaimService;
import com.kohsin.decent.utils.ResponseEntityFactory;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequestMapping(path = "/claim")
@Api(value = "claim", produces = "Claim entity")
@RestController
public class ClaimController {

    private ClaimService claimService;

    @Autowired
    public ClaimController(ClaimService claimService) {
        this.claimService = claimService;
    }

    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success."),
            @ApiResponse(code = 204, message = "No content.")
    })
    @GetMapping("/all")
    public ResponseEntity<List<ClaimResponseDto>> getBy() {
        return ResponseEntityFactory.returnOkOrEmptyStatus(claimService.getAll());
    }

    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success."),
            @ApiResponse(code = 204, message = "No content.")
    })
    @GetMapping
    public ResponseEntity<List<ClaimResponseDto>> getByInsuredId(@RequestParam String insuredId){
        return ResponseEntityFactory.returnListOk(claimService.getByInsuredId(insuredId));
    }

    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success."),
            @ApiResponse(code = 204, message = "No content.")
    })
    @GetMapping("/{id}")
    public ResponseEntity<ClaimResponseDto> getById(@PathVariable Long id){
        return ResponseEntityFactory.returnOkOrEmptyStatus(claimService.getById(id));
    }
}
