package interfaceentity;

import java.util.List;

public interface InterfaceActivity {

	 public void setActivity(metier.Activity a);
	 public List<metier.Activity> getAllActivity();
	 public metier.Activity getActivityById(int id);
	 public void updateActivity(metier.Activity u);
	 public void delateActivity(metier.Activity u);
}
