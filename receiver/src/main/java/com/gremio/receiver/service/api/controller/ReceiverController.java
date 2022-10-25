package com.gremio.receiver.service.api.controller;

import com.gremio.receiver.business.SalesService;
import com.gremio.receiver.dto.FugitiveCartRequest;
import com.gremio.receiver.dto.MemberRequest;
import com.gremio.receiver.dto.SaleRequest;
import com.gremio.receiver.exceptions.DatabaseException;
import com.gremio.receiver.model.FugitiveCart;
import com.gremio.receiver.model.Member;
import com.gremio.receiver.model.Sale;
import com.gremio.receiver.service.api.responses.DefaultResponse;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Calendar;

@RestController
@RequestMapping("/api/v1/add")
public class ReceiverController {
    private static final org.slf4j.Logger LOGGER = org.slf4j.LoggerFactory.getLogger(ReceiverController.class);

    @Autowired
    private KafkaTemplate<String, Member> membersKafkaTemplate;

    @Autowired
    private KafkaTemplate<String, FugitiveCart> fugitiveCartsKafkaTemplate;

    @Autowired
    private SalesService salesService;

    @Autowired
    private ModelMapper modelMapper;



    @PostMapping(value="/sale")
    public ResponseEntity<DefaultResponse> sales(@RequestBody @Valid SaleRequest request) throws DatabaseException {
        Sale sale = modelMapper.map(request, Sale.class);
        salesService.send(sale);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(new DefaultResponse("New Sale added!", Calendar.getInstance().getTimeInMillis()));
    }

    @PostMapping(value="/member")
    public ResponseEntity<DefaultResponse> members(@RequestBody @Valid MemberRequest memberRequest){
//        membersKafkaTemplate.send("new-members", memberRequest);
        LOGGER.info("New Member added. " + memberRequest.getEmail());
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(new DefaultResponse("New Member added!", Calendar.getInstance().getTimeInMillis()));
    }

    @PostMapping(value="fugitive-cart")
    public ResponseEntity<DefaultResponse> fugitiveCart(@RequestBody @Valid FugitiveCartRequest fugitiveCartRequest){
//        fugitiveCartsKafkaTemplate.send("location", fugitiveCartRequest);
        LOGGER.info("New Fugitive Cart Added. " + fugitiveCartRequest.getLatitude());
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(new DefaultResponse("New Fugitive Cart added", Calendar.getInstance().getTimeInMillis()));
    }


}
