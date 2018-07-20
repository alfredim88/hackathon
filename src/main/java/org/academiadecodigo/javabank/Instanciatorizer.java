package org.academiadecodigo.javabank;

import org.academiadecodigo.javabank.model.customer.Customer;
import org.academiadecodigo.javabank.service.CustomerService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Instanciatorizer {

    public static void main(String[] args) {
        create();
    }

    private static void create(){

        ApplicationContext context = new ClassPathXmlApplicationContext("WEB-INF/spring/spring-config.xml");

        CustomerService service = (CustomerService) context.getBean("customerService");
        Customer c = new Customer();
        c.setUsername("Alfredo");
        service.add(c);
        //context.getBean(MainMenuController.class).start();


       /* Options.LOGIN.setHandler(context.getBean(LoginController.class));
        Options.REGISTER.setHandler(context.getBean(RegisterController.class));
        Options.QUIT.setHandler(context.getBean(QuitController.class));

        Operations.OPEN_ACCOUNT.setHandler(context.getBean(OpenAccountController.class));
        Operations.ACCOUNTS_IDS.setHandler(context.getBean(ListAccountsIDsController.class));
        Operations.CHECK_BALANCE.setHandler(context.getBean(CheckBalanceController.class));
        Operations.DEPOSIT.setHandler(context.getBean(DepositController.class));
        Operations.WITHDRAW.setHandler(context.getBean(WithdrawController.class));
        Operations.TRANSFER.setHandler(context.getBean(TransferController.class));
        Operations.LOG_OFF.setHandler(context.getBean(LogOffController.class));

        BankAppController app = new BankAppController();
        BankAppView bankAppView = new BankAppView();

        MainMenuController mainMenuController = new MainMenuController();
        MainMenuView mainMenuView = new MainMenuView();

        RegisterController registerController = new RegisterController();
        RegisterView registerView = new RegisterView();

        LoginController loginController = new LoginController();
        LoginView loginView = new LoginView();

        OpenAccountController openAccountController = new OpenAccountController();
        OpenAccountView openAccountView = new OpenAccountView();

        CheckBalanceController checkBalanceController = new CheckBalanceController();
        CheckBalanceView checkBalanceView = new CheckBalanceView();

        ListAccountsIDsController accountsIDsController = new ListAccountsIDsController();
        ListAccountIdsView accountIdsView = new ListAccountIdsView();

        DepositController depositController = new DepositController();
        DepositView depositView = new DepositView();

        WithdrawController withdrawController = new WithdrawController();
        WithdrawView withdrawView = new WithdrawView();

        TransferController transferController = new TransferController();
        TransferView transferView = new TransferView();

        LogOffController logOffController = new LogOffController();

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("test");

        SessionManager sm = new JPASessionManager(emf);
        TransactionManager tm = new JPATransactionManager(sm);

        CustomerDao customerDao = new JPACustomerDao(sm);
        CustomerService customerService = new JpaCustomerService(customerDao, tm);

        AccountDao accountDao = new JPAAccountDao(sm);
        AccountService accountService = new JpaAccountService(tm,accountDao, customerDao);

        AuthService authService = new JpaAuthService(customerDao, tm);


        mainMenuView.setController(mainMenuController);
        mainMenuController.setView(mainMenuView);

        loginController.setApp(app);
        loginController.setView(loginView);
        loginController.setAuthenticatorService(authService);
        loginView.setController(loginController);

        registerController.setView(registerView);
        registerController.setAuthService(authService);
        registerController.setCustomerService(customerService);
        registerView.setController(registerController);

        app.setView(bankAppView);
        bankAppView.setController(app);
        app.setAuthService(authService);

        openAccountController.setView(openAccountView);
        openAccountController.setAuthService(authService);
        openAccountController.setAccountService(accountService);
        openAccountView.setController(openAccountController);

        accountsIDsController.setService(authService);
        accountsIDsController.setView(accountIdsView);
        accountIdsView.setController(accountsIDsController);

        checkBalanceController.setView(checkBalanceView);
        checkBalanceController.setAuthService(authService);
        checkBalanceController.setCustomerService(customerService);
        checkBalanceView.setController(checkBalanceController);

        depositController.setView(depositView);
        depositController.setAuthService(authService);
        depositController.setAccountService(accountService);
        depositView.setController(depositController);

        withdrawController.setView(withdrawView);
        withdrawController.setAuthService(authService);
        withdrawController.setAccountService(accountService);
        withdrawController.setCustomerService(customerService);
        withdrawView.setController(withdrawController);

        transferController.setView(transferView);
        transferController.setAuthService(authService);
        transferController.setAccountService(accountService);
        transferView.setController(transferController);

        logOffController.setAuthService(authService);*/


    }
}
