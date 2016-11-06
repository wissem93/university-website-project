package interfaceentity;

import java.util.List;

import metier.Resource;

public interface InterfaceResource {
	 
	 public void setResource(Resource r);
	 public List<Resource> getAllResource();
	 public Resource getResourceById(int id);
	 public Resource getResourceByIdType(int id,String t);

	 public void updateResource(Resource u);
	 public void delateResource(Resource u);

}
