package spring.junit;


import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import spring.common.CommonUtil;
import spring.junit.mock.MockJunitTestingConfig;
import spring.junit.mock.UserPwdChecker;
import spring.junit.mock.UserService;

import static org.mockito.Mockito.when;

//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(classes = MockJunitTestingConfig.class)
public class UserPwdCheckerMockTest {

    public UserService userService;

    public UserPwdChecker userPwdChecker;

    public void before(){
    }


    public void mockTest(){
        CommonUtil.ps(userService.queryPwdBySaleNo("12010600000621"));
        when(userService.queryPwdBySaleNo("12010600000621")).thenReturn("Clic1234!");
        CommonUtil.ps(userService.queryPwdBySaleNo("12010600000621"));

        Assert.assertTrue(userPwdChecker.pwdMatch("12010600000621","Clic1234!"));
    }


}
