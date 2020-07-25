package spring.junit.mock;

import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Override
    public String queryPwdBySaleNo(String saleNo) {
        return "123";
    }
}
