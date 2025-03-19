
package DAO;

import Model.Student;

public interface DAOInterface {
    boolean insertStudent(Student s);
    void viewAll();
    boolean viewAllById(int id);
    boolean updateStudent(int id,Student s);
    boolean deleteStudent(int id);
    
}
