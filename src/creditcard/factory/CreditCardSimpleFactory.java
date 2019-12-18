package creditcard.factory;

import framework.AccountTypes;
import framework.UserType;
import framework.account.AbstractAccount;
import framework.factory.AbstractAccountFactory;
import framework.factory.SimpleFactory;
import framework.user.AbstractUser;

import java.util.List;

public class CreditCardSimpleFactory extends SimpleFactory {

    private static CreditCardSimpleFactory creditCardSimpleFactory;

    private CreditCardSimpleFactory(){}

    public static CreditCardSimpleFactory getInstance(){
        if(creditCardSimpleFactory == null){
            creditCardSimpleFactory = new CreditCardSimpleFactory();
        }
        return creditCardSimpleFactory;
    }

    @Override
    public AbstractUser createUser(UserType userType, String name, String street, String city, String state, String email, String zip, List<AbstractAccount> accounts) {
        return super.createUser(userType, name, street, city, state, email, zip, accounts);
    }

    public AbstractAccount createAccount(AccountTypes accountTypes, String accountNumber, AbstractUser user) {
        AbstractAccountFactory accountFactory=null;
        if (accountTypes== AccountTypes.GOLD){
            accountFactory = new GoldAccountFactory();
            return accountFactory.createAccount(accountNumber,user);
        }else if(accountTypes== AccountTypes.SILVER){
            accountFactory = new SilverAccountFactory();
            return accountFactory.createAccount(accountNumber,user);
        }else if(accountTypes== AccountTypes.BRONZE){
            accountFactory = new BronzeAccountFactory();
            return accountFactory.createAccount(accountNumber,user);
        }
        return null;

    }

}