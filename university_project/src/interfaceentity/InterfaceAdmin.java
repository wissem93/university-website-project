package interfaceentity;

import java.util.List;

import metier.Admin;

public interface InterfaceAdmin {
	public void setAdmin(Admin u);
	 public List<Admin> getAllAdmin();
	 public Admin getAdminById(int id);
	 public void updateAdmin(Admin u);
	 public void delateAdmin(Admin u);
}
