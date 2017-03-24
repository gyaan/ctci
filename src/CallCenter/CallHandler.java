package CallCenter;

import java.util.List;

/**
 * Created by lenskart on 26/02/2017.
 */
public class CallHandler {


    //keep the call handler class singleton
    private static CallHandler instance;


    //define the number of levels in jbo
    private final int LEVELS = 3;

    //initialize values for employee
    private final int NUM_RESPONDENTS = 10;
    private final int NUM_MANAGER = 4;
    private final int NUM_DIRECTOR = 2;


    /*
     *List of employees by level
     */

    List<List<Employee>> employeeLevels;
    List<List<Call>> callQueue;


}
