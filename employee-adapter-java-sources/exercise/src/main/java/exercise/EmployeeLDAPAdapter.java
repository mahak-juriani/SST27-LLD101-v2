public class EmployeeLDAPAdapter implements Employee{
    EmployeeLDAP e;

    @Override
    String getID(){
        return e.get("uid");
    }

    @Override
    String getFirstName(){
        return e.get("givenName");
    }

    @Override
    String getLastName(){
        return e.get("sn");
    }

    @Override
    String getEmail(){
        return e.get("mail");
    }
}
