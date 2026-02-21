package comm.manyToManyBidirectionalMapping;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Subject {
	@Id
	private int sub_id;
	private String sub_name;
	private int sub_no_of_days;
	
	//mapped by subject_student will be deleted 
	@ManyToMany(mappedBy = "subject")
	private List <Student> student; 
	
	public int getSub_id() {
		return sub_id;
	}
	public void setSub_id(int sub_id) {
		this.sub_id = sub_id;
	}
	public String getSub_name() {
		return sub_name;
	}
	public void setSub_name(String sub_name) {
		this.sub_name = sub_name;
	}
	public int getSub_no_of_days() {
		return sub_no_of_days;
	}
	public void setSub_no_of_days(int sub_no_of_days) {
		this.sub_no_of_days = sub_no_of_days;
	}
	@Override
	public String toString() {
		return "Subject [sub_id=" + sub_id + ", sub_name=" + sub_name + ", sub_no_of_days=" + sub_no_of_days + "]";
	}
	public List<Student> getStudent() {
		return student;
	}
	public void setStudent(List<Student> student) {
		this.student = student;
	}
	
	
	

}
