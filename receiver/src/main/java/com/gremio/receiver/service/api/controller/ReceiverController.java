package com.gremio.receiver.service.api.controller;

import com.gremio.receiver.business.FugitivesCartsService;
import com.gremio.receiver.business.MembersService;
import com.gremio.receiver.business.SalesService;
import com.gremio.receiver.dto.FugitiveCartRequest;
import com.gremio.receiver.dto.MemberRequest;
import com.gremio.receiver.dto.SaleRequest;
import com.gremio.receiver.model.FugitiveCart;
import com.gremio.receiver.model.Member;
import com.gremio.receiver.model.Sale;
import com.gremio.receiver.service.api.responses.DefaultResponse;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Calendar;

@RestController
@RequestMapping("/api/v1/add")
public class ReceiverController {
    @Autowired
    private SalesService salesService;

    @Autowired
    private MembersService membersService;

    @Autowired
    private FugitivesCartsService fugitivesCartsService;

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping(value="/sale")
    public ResponseEntity<DefaultResponse> sales(@RequestBody @Valid SaleRequest request) {
        Sale sale = modelMapper.map(request, Sale.class);
        salesService.send(sale);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(new DefaultResponse("New Sale added!", Calendar.getInstance().getTimeInMillis()));
    }

    @PostMapping(value="/member")
    public ResponseEntity<DefaultResponse> members(@RequestBody @Valid MemberRequest request){
        Member member = modelMapper.map(request, Member.class);
        membersService.send(member);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(new DefaultResponse("New Member added!", Calendar.getInstance().getTimeInMillis()));
    }

    @PostMapping(value="/fugitive-cart")
    public ResponseEntity<DefaultResponse> fugitiveCart(@RequestBody @Valid FugitiveCartRequest request){
        FugitiveCart fugitiveCart = modelMapper.map(request, FugitiveCart.class);
        fugitivesCartsService.send(fugitiveCart);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(new DefaultResponse("New Fugitive Cart added", Calendar.getInstance().getTimeInMillis()));
    }
}
