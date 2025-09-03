public class EmployeeDBAdapter implements Employee {
    EmployeeDB e;

    @Override
    String getId(){
        return String.valueOf(e.getId());
    }

    @Override
    String getFirstName(){
        return e.getFirstName();
    }

    @Override
    String getLastName(){
        return e.getSurname();
    }

    @Override
    String getEmail(){
        return e.getEmailAddress();
    }

   
}
