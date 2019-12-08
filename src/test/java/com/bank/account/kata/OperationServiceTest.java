package com.bank.account.kata;

import com.bank.acount.kata.dao.OperationDao;
import com.bank.acount.kata.dao.model.Account;
import com.bank.acount.kata.service.OperationService;
import javassist.NotFoundException;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Spy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import sun.applet.Main;

/**
 * Created by IBRAHIM on 04/12/2019.
 */

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Main.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class OperationServiceTest {

    @Mock
    private OperationService operationService;

    @Spy
    private OperationDao operationDao;


    @Test
    public void testDepositAmount() throws NotFoundException {
        Long amount = 100l;
        operationService.deposit(amount);
    }

}
