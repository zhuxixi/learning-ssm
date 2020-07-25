package spring.ioc1;

/**
 * @author zhuzhenxi
 * @date 2020.07.25
 */
public class OldSchoolStyle {

    public static void main(String[] args){
        ParamChecker checker = new ParamChecker();
        String password = "Clic1234";
        String expectValue = "Clic1234!";
        System.out.println(checker.pwdMatch(password,expectValue));
    }
}
