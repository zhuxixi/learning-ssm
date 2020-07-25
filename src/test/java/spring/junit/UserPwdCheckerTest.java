package spring.junit;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import spring.junit.testcase.UserPwdChecker;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = JunitTestingConfig.class)
public class UserPwdCheckerTest {

    @Autowired
    private UserPwdChecker checker;

    @Test
    public void testPwdCheck(){
        Assert.assertFalse(checker.pwdMatch("1","2"));
        Assert.assertTrue(checker.pwdMatch("1","1"));
    }
}
