package com.panpan.walle.start;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Profile;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = WalleStartApplication.class)
@Profile({"dev"})
public class HelloTest {

    @Test
    public void test(){
        System.out.println(111);
    }
}
