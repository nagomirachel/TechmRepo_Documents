package com.mums.controller;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import com.mums.bean.DocumentBean;
import com.mums.bean.DocumentGroupBean;
import com.mums.bean.UserBean;
import com.mums.model.Document;
import com.mums.model.DocumentGroup;
import com.mums.model.User;
import com.mums.service.DocumentGroupService;
import com.mums.service.DocumentService;
import com.mums.service.UserService;

@RestController
public class UserController {
	
	@Autowired
	private UserService userService;
	@Autowired
	private DocumentGroupService documentGroupService;
	@Autowired
	private DocumentService documentService;

	/****************** Webservice Methods for user,Document,documentgroup modules*********************************************/
	
	
	 @RequestMapping(value="/user/add/{cdsId}/{firstName}/{lastName}",method = RequestMethod.POST)
	 public void addUser(@PathVariable("cdsId") String cdsId,@PathVariable("firstName") String firstName,@PathVariable("lastName") String lastName) throws ParseException {
			User user = new User();
			user.setCdsId(cdsId);
			user.setFirstName(firstName);
			user.setLastName(lastName);
			System.out.println(cdsId);
			System.out.println(firstName);
			userService.addUser(user);
			//return user;
	 }
	 @RequestMapping(value="/user/search/{cdsId}",method = RequestMethod.GET,produces="application/json")
	 public  @ResponseBody List<UserBean> searchUser(@PathVariable("cdsId") String cdsId) throws ParseException {
		 	UserBean user = new UserBean();
		 	System.out.println("..1..");
		 	user.setCdsId(cdsId);
		 	List<UserBean> users = userService.searchUser(user);
		 	System.out.println(users);
		 	for (UserBean a : users) {
		 		System.out.println(a);
		 		System.out.println(a.getCdsId());
		 		System.out.println(a.getFirstName());
		 		
		 	}		 	
			return users; 
	}

	 @Transactional(propagation=Propagation.REQUIRED, rollbackFor=Exception.class)
		@RequestMapping(value = "/user/update/{cdsId}/{firstName}/{lastName}", method = RequestMethod.POST)
		public void editUser(@PathVariable("cdsId") String cdsId,@PathVariable("firstName") String firstName,@PathVariable("lastName") String lastName)
				 {
		System.out.println("check edit..");
			
			User user = new User();
			user.setCdsId(cdsId);
			user.setFirstName(firstName);
			user.setLastName(lastName);
			System.out.println(cdsId);
			System.out.println(firstName);
			System.out.println(lastName);
			userService.editUser(cdsId,firstName,lastName);
		}
	
		@RequestMapping(value = "/user/delete/{cdsId}", method = RequestMethod.POST)
		public void deleteUser(@PathVariable("cdsId") String cdsId,User user)
				 {
		System.out.println("check delete..");
			System.out.println("INside Delete user");
			userService.deleteUser(user);
			System.out.println("Oustdie Delete User");
			//return user;
		}


	@RequestMapping(value="/document/add/{documentId}/{documentName}/{printId}", method=RequestMethod.POST)
	public void insertDoc(@PathVariable("documentId") String documentId,@PathVariable ("documentName") String documentName,
	@PathVariable("printId") String printId)
	{
		System.out.println(documentId);
		System.out.println(documentName);
		Document document=new Document();
		document.setDocumentId(documentId);
		document.setDocumentName(documentName);
		document.setPrintId(printId);
		
		documentService.addDoc(document);
		
		  

	}
	@RequestMapping(value="/document/search/{documentId}",method = RequestMethod.GET,produces="application/json")
	public @ResponseBody List<DocumentBean> searchDoc(@PathVariable("documentId") String documentId) throws ParseException {
			DocumentBean document=new DocumentBean();
			
		 	System.out.println("..1..");
		 	document.setDocumentId(documentId);
		 	List<DocumentBean> docs = documentService.searchDocument(document);
		 	System.out.println(docs);
		 	for (DocumentBean a : docs) {
		 		System.out.println(a);
		 		System.out.println(a.getDocumentId());
		 		System.out.println(a.getDocumentName());
		 		System.out.println(a.getPrintId());
		 	}		 	
			return docs;
	}
	
	
	 @Transactional(propagation=Propagation.REQUIRED, rollbackFor=Exception.class)
		@RequestMapping(value = "/document/update/{documentId}/{documentName}/{printId}", method = RequestMethod.POST)
		public void editDocument(@PathVariable("documentId") String documentId,@PathVariable("documentName") String documentName,@PathVariable("printId") String printId)
				 {
		System.out.println("check edit..");
			
			Document document = new Document();
			document.setDocumentId(documentId);
			document.setDocumentName(documentName);
			document.setPrintId(printId);
			documentService.updateDocument(documentId,documentName,printId);
			
		}
	
	 
		@RequestMapping(value = "/document/delete/{documentId}", method = RequestMethod.POST)
		public void deleteDoc(@PathVariable("documentId") String documentId,Document document)
				 {
			documentService.deleteDocument(document);
			System.out.println("INside Delete user");
			System.out.println("Oustdie Delete User");
		}
	
		//change the values of uid and sid /cdsid and docid as per the jsp requirement.....
	@RequestMapping(value = "/grp/add/{documentGroupId}/{documentGroupName}/{cdsId}/{documentId}", method = RequestMethod.GET)
	 public void saveDocumentRest(@PathVariable("documentGroupId") String documentGroupId, @PathVariable("documentGroupName") String documentGroupName,@PathVariable("cdsId") String cdsId, @PathVariable("documentId") String documentId) {
		DocumentGroup documentgroup = new DocumentGroup(documentGroupId, documentGroupName);
		
		Set<Document> documents = new HashSet<Document>(0); 
		Set<User> users = new HashSet<User>(0);
		System.out.println("saved " +documentgroup.getDocumentGroupId());
		ModelAndView mv = new ModelAndView();
			mv.addObject("documentgroup",documentgroup);
			mv.setViewName("saved");
			System.out.println("entered save");
			
			
			String usersArr[] = StringUtils.split(cdsId, ",");
			User user = null;
			if (usersArr != null && usersArr.length > 0) {
				for (int i = 0; i < usersArr.length; i++) {
					user = new User();
					user.setCdsId(usersArr[i]);
					users.add(user);
				}
			}
			
			documentgroup.setUsers(users);
			
			String docsarr[] = StringUtils.split(documentId, ",");
			Document document = null;
			if (docsarr != null && docsarr.length > 0) {
				for (int i = 0; i < docsarr.length; i++) {
					document = new Document();
					document.setDocumentId(docsarr[i]);
					documents.add(document);
				}
			}
			
			documentgroup.setDocuments(documents);	
			documentGroupService.addDocumentGroup(documentgroup);
			//return mv;
	}
	 @Transactional(propagation=Propagation.REQUIRED, rollbackFor=Exception.class)
		@RequestMapping(value = "/grp/update/{documentGroupId}/{documentGroupName}/{cdsId}/{documentId}", method = RequestMethod.POST)
		public void editGrp(@PathVariable("documentGroupId") String documentGroupId,@PathVariable("documentGroupName") String documentGroupName,@PathVariable("cdsId") String cdsId,@PathVariable("documentId") String documentId)
				 {
		System.out.println("check edit..");
			
			//DocumentGroup grp = new DocumentGroup();
			//grp.setDocumentGroupId(documentGroupId);
			//grp.setDocumentGroupName(documentGroupName);
			
			//System.out.println(documentGroupId);
			//userService.addEmp(cdsId,firstName,lastName);
		}
	
	 
	@RequestMapping(value = "/grp/delete/{documentGroupId}", method = RequestMethod.POST)
	public void deleteGrp(@PathVariable("documentGroupId") String documentGroupId,DocumentGroup documentGroup)
			 {
		documentGroupService.deleteDocumentGroup(documentGroup);
		System.out.println("INside Delete user");
		System.out.println("Oustdie Delete User");
	}
	
	 
	 

	
	
	
	/******************* SPRING CODE SERVICE CALLS and CONTROLLER *************************************************/
	
	@RequestMapping(value = "/save", method = RequestMethod.POST,params = {"submit"})
	public ModelAndView saveEmployee(@ModelAttribute("command") UserBean userBean) {
		
		System.out.println(userBean.getCdsId());
		User user = prepareModel(userBean);
		System.out.println("INside Add User");
		userService.addEmployee(user);
		System.out.println("Outseide Add User");
		return new ModelAndView("redirect:/add.html");

	}
	
	
	@RequestMapping(value = "/save", method = RequestMethod.POST,params = {"search"})
	public ModelAndView searchEmployee(@ModelAttribute("command") UserBean userBean) {

		
		ModelAndView model = new ModelAndView("userList");
		System.out.println("Inside search");
		model.addObject("employees", userService.searchEmployee(userBean));
		System.out.println("new");
		System.out.println("Outside search");
		return model; 

	}
		
	
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public ModelAndView addEmployee(@ModelAttribute("command")  UserBean userBean,
			BindingResult result) {
		System.out.println(userBean.getCdsId());
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("employees",  prepareListofBean(userService.listEmployeess()));
		return new ModelAndView("addUser", model);
	}
	
	@RequestMapping(value="/employees", method = RequestMethod.GET)
	public ModelAndView listEmployees() {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("employees",  prepareListofBean(userService.listEmployeess()));
		return new ModelAndView("userList", model);
	}

	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public ModelAndView welcome() {
		return new ModelAndView("index");
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public ModelAndView deleteEmployee(@ModelAttribute("command")  UserBean userBean,
			BindingResult result) {
		userService.deleteUser(prepareModel(userBean));
		Map<String, Object> model = new HashMap<String, Object>();
		System.out.println("INside Delete Emp");
		model.put("employee",null);
		model.put("employees",prepareListofBean(userService.listEmployeess()));
		System.out.println("Oustdie Delete Emp");
		return new ModelAndView("addUser", model);
	}
	
	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public ModelAndView editEmployee(@ModelAttribute("command")  UserBean userBean,
			BindingResult result) {
		Map<String, Object> model = new HashMap<String, Object>();
		System.out.println("INside Edit Employee");
		model.put("employee", prepareEmployeeBean(userService.getEmployee(userBean.getCdsId())));
		model.put("employees",  prepareListofBean(userService.listEmployeess()));
		System.out.println("Outside Edit Employee");
		return new ModelAndView("addUser", model);
	}
	

	
	 @RequestMapping(value = "/savedocument", method = RequestMethod.POST,params = {"submit"})
	 public ModelAndView saveDocument(@ModelAttribute("command") DocumentBean documentBean, 
				BindingResult result) {
			Document document = prepareModel1(documentBean);
			System.out.println("INside Add Document mod");
			documentService.addDocument(document);
			System.out.println("Outside Add Document mod");
			return new ModelAndView("redirect:/add1.html");
	 		}
	 
	 @RequestMapping(value = "/savedocument", method = RequestMethod.POST,params = {"search"})
	 public ModelAndView searchDocument(@ModelAttribute("command") DocumentBean documentBean, 
				BindingResult result) {
		 
		 
			ModelAndView model = new ModelAndView("documentList");
			System.out.println("Inside search Document");
			model.addObject("documents", documentService.searchDocument(documentBean));
			System.out.println("new");
			System.out.println("Outside search");
			return model; 

	 		}	
		@RequestMapping(value = "/add1", method = RequestMethod.GET)
		public ModelAndView addDocumentnew(@ModelAttribute("command")  DocumentBean documentBean,
				BindingResult result) {
			Map<String, Object> model = new HashMap<String, Object>();
			model.put("documents",  prepareListofBean1(documentService.listDocuments()));
			return new ModelAndView("addDocument", model);
		}
	 	
	 	
	 	@RequestMapping(value="/documents", method = RequestMethod.GET)
		public ModelAndView listDocuments() {
			Map<String, Object> model = new HashMap<String, Object>();
			model.put("documents",  prepareListofBean1(documentService.listDocuments()));
			return new ModelAndView("documentList", model);
		}
	 	
	 	@RequestMapping(value = "/delete1", method = RequestMethod.GET)
		public ModelAndView editDocument(@ModelAttribute("command")  DocumentBean documentBean,
				BindingResult result) {
	 		documentService.deleteDocument(prepareModel1(documentBean));
			Map<String, Object> model = new HashMap<String, Object>();
			model.put("document", null);
			model.put("documents",  prepareListofBean1(documentService.listDocuments()));
			return new ModelAndView("addDocument", model);
		}
		
		@RequestMapping(value = "/edit1", method = RequestMethod.GET)
		public ModelAndView deleteDocument(@ModelAttribute("command")  DocumentBean documentBean,
				BindingResult result) {
			Map<String, Object> model = new HashMap<String, Object>();
			System.out.println("INside Edit Docx");
			model.put("document", prepareDocumentBean(documentService.getDocument(documentBean.getDocumentId())));
			model.put("documents",  prepareListofBean1(documentService.listDocuments()));
			System.out.println("Outside Edit Docx");
			return new ModelAndView("addDocument", model);
		}
		
		
		@RequestMapping(value = "/savedocumentgroup", method = RequestMethod.GET,params = {"submit"})
		 public ModelAndView saveDocument(@RequestParam("documentGroupId") String documentGroupId, @RequestParam("documentGroupName") String documentGroupName,@RequestParam("uid") String cdsId, @RequestParam("sid") String documentId) {
			DocumentGroup documentgroup = new DocumentGroup(documentGroupId, documentGroupName);
			
			Set<Document> documents = new HashSet<Document>(0); 
			Set<User> users = new HashSet<User>(0);
			System.out.println("saved " +documentgroup.getDocumentGroupId());
			ModelAndView mv = new ModelAndView();
				mv.addObject("documentgroup",documentgroup);
				mv.setViewName("saved");
				System.out.println("entered save");
				
				
				String usersArr[] = StringUtils.split(cdsId, ",");
				User user = null;
				if (usersArr != null && usersArr.length > 0) {
					for (int i = 0; i < usersArr.length; i++) {
						user = new User();
						user.setCdsId(usersArr[i]);
						users.add(user);
					}
				}
				
				documentgroup.setUsers(users);
				
				String docsarr[] = StringUtils.split(documentId, ",");
				Document document = null;
				if (docsarr != null && docsarr.length > 0) {
					for (int i = 0; i < docsarr.length; i++) {
						document = new Document();
						document.setDocumentId(docsarr[i]);
						documents.add(document);
					}
				}
				
				documentgroup.setDocuments(documents);	
				documentGroupService.addDocumentGroup(documentgroup);
				return mv;
	}
		
		
		@RequestMapping(value = "/savedocumentgroup", method = RequestMethod.GET,params = {"search"})
		 public ModelAndView searchDocumentGroup(@RequestParam("documentGroupId") String documentGroupId, @RequestParam("documentGroupName") String documentGroupName,@RequestParam("uid") String cdsId, @RequestParam("sid") String documentId) {
			ModelAndView model = new ModelAndView("documentgroupList");
			System.out.println("Inside search DocumentGroup");
			model.addObject("documentGroupss",documentGroupService.searchDocumentGroup(documentGroupId,documentGroupName));
			System.out.println("new");
			System.out.println("Outside search");
			return model; 
	}
	
		@RequestMapping(value = "/adddoc")
		public ModelAndView deleteEmployee(@ModelAttribute("command")  DocumentGroupBean documentGroupBean,
				BindingResult result)
		{
			Map<String, Object> model = new HashMap<String, Object>();
			System.out.println(documentGroupBean.getDocumentGroupId());
			model.put("document",  prepareListofBeanfordoc(documentService.getAllDocId()));
			System.out.println("displayGroupIds entered..");
			
			List<Document> idlist= documentService.getAllDocId();
			Iterator<Document> it = idlist.iterator();
			while(it.hasNext()){
				System.out.println("Group ID: " + it.next().getDocumentId());
			}
			ModelAndView mv= new ModelAndView();
			mv.addObject("docIds", idlist);
			mv.setViewName("addDocumentGroup");
			for(Document item : idlist){
				System.out.println("DG id["+ idlist.indexOf(item)+"]: " + item.getDocumentId());		
			}
			System.out.println("displayGroupIds exited..");
			
			List<User> list= userService.getAllEmpId();
			Iterator<User> iter = list.iterator();
			while(iter.hasNext()){
				System.out.println("CDS ID: " + iter.next().getCdsId());
			}
			ModelAndView mv1= new ModelAndView();
			mv1.addObject("cdsIds", list);
			mv1.setViewName("addDocumentGroup");
			for(User item : list){
				System.out.println("Cds id["+ list.indexOf(item)+"]: " + item.getCdsId());		
			}
			System.out.println("displayGroupIds exited..");
	      
			
			ModelAndView mv2= new ModelAndView();
			mv2.addObject("cdsIds", list);
			mv2.addObject("docIds", idlist);
			mv2.setViewName("addDocumentGroup");
			
		return mv2;
			
		}

	
		@RequestMapping(value="/documentgroups", method = RequestMethod.GET)
		public ModelAndView listDocumentGroups() {
			Map<String, Object> model = new HashMap<String, Object>();
			model.put("documentgroups",  prepareListofBean2(documentGroupService.listDocumentGroups()));
			return new ModelAndView("documentgroupList", model);
		}

/*//		@RequestMapping(value = "/delete2", method = RequestMethod.GET)
//		public ModelAndView editDocumentGroup(@ModelAttribute("command")  DocumentGroupBean documentGroupBean,
//				BindingResult result) {
//			documentGroupService.deleteDocumentGroup(prepareModel2(documentGroupBean));
//			Map<String, Object> model = new HashMap<String, Object>();
//			model.put("documentgroup", null);
//			model.put("documentgroups",  prepareListofBean2(documentGroupService.listDocumentGroups()));
//			return new ModelAndView("addDocumentGroup", model);
//		}
*/		
		@RequestMapping(value = "/edit2", method = RequestMethod.GET)
		public ModelAndView deleteEmployee2(@ModelAttribute("command")  DocumentGroupBean documentGroupBean,
				BindingResult result) {
			Map<String, Object> model = new HashMap<String, Object>();
			System.out.println(documentGroupBean.getDocumentGroupId());
			model.put("documentgroup", prepareDocumentGroupBean(documentGroupService.getDocumentGroup(documentGroupBean.getDocumentGroupId())));
			model.put("documentgroups",  prepareListofBean2(documentGroupService.listDocumentGroups()));
			return new ModelAndView("addDocumentGroup", model);
		}
		
		private User prepareModel(UserBean userBean){
		User user = new User();
		user.setCdsId(userBean.getCdsId());
		user.setFirstName(userBean.getFirstName());
		user.setLastName(userBean.getLastName());
	
		return user;
		}
	
		private Document prepareModel1(DocumentBean documentBean){
		Document document = new Document();
		document.setDocumentId(documentBean.getDocumentId());
		document.setPrintId(documentBean.getPrintId());
		document.setDocumentName(documentBean.getDocumentName());
		
		return document;
	}
	
//	private DocumentGroup prepareModel2(DocumentGroupBean documentGroupBean) {
//		// TODO Auto-generated method stub
//		DocumentGroup documentgroup = new DocumentGroup();
//		documentgroup.setDocumentgroupid(documentGroupBean.getDocumentGroupId());
//		documentgroup.setDocumentgroupname(documentGroupBean.getDocumentGroupName());
//		return documentgroup;
//	}
	

	private List<DocumentBean> prepareListofBeanfordoc(List<Document> documentss){
		List<DocumentBean> beans = null;
		if(documentss != null && !documentss.isEmpty()){
			beans = new ArrayList<DocumentBean>();
			DocumentBean bean = null;
			for(Document document : documentss){
				bean = new DocumentBean();
				bean.setDocumentId(document.getDocumentId());
				bean.setDocumentName(document.getDocumentName());
				bean.setPrintId(document.getPrintId());
				beans.add(bean);
		}
		}
		return beans;
	}
	
	
	private List<UserBean> prepareListofBean(List<User> users){
		List<UserBean> beans = null;
		if(users != null && !users.isEmpty()){
			beans = new ArrayList<UserBean>();
			UserBean bean = null;
			for(User user : users){
				bean = new UserBean();
				bean.setCdsId(user.getCdsId());
				bean.setFirstName(user.getFirstName());
				bean.setLastName(user.getLastName());
				beans.add(bean);
			}
		}
		return beans;
	}
			private List<DocumentBean> prepareListofBean1(List<Document> documents){
				List<DocumentBean> beans = null;
				if(documents != null && !documents.isEmpty()){
					beans = new ArrayList<DocumentBean>();
					DocumentBean bean = null;
					for(Document document : documents){
						bean = new DocumentBean();
						bean.setDocumentId(document.getDocumentId());
						bean.setDocumentName(document.getDocumentName());
						bean.setPrintId(document.getPrintId());
						beans.add(bean);
					}
		}
		return beans;
	}
			
			private List<DocumentGroupBean> prepareListofBean2(List<DocumentGroup> documentgroups){
				List<DocumentGroupBean> beans = null;
				if(documentgroups != null && !documentgroups.isEmpty()){
					beans = new ArrayList<DocumentGroupBean>();
					DocumentGroupBean bean = null;
					for(DocumentGroup documentgroup : documentgroups){
						bean = new DocumentGroupBean();
						bean.setDocumentGroupId(documentgroup.getDocumentGroupId());
						bean.setDocumentGroupName(documentgroup.getDocumentGroupName());						
						beans.add(bean);
					}
		}
		return beans;
	}
	
	private UserBean prepareEmployeeBean(User user){
		UserBean bean = new UserBean();
		bean.setCdsId(user.getCdsId());
		bean.setFirstName(user.getFirstName());
		bean.setLastName(user.getLastName());
		System.out.println("Hello inside Employee aditionals"+user.getLastName());
		return bean;
	}

	 
	private DocumentBean prepareDocumentBean(Document document){
		DocumentBean bean = new DocumentBean();
		bean.setDocumentId(document.getDocumentId());
		bean.setPrintId(document.getPrintId());
		bean.setDocumentName(document.getDocumentName());
		System.out.println("Hello inside Docx aditionals"+document.getDocumentName());
		return bean;
	}
	
	private DocumentGroupBean prepareDocumentGroupBean(DocumentGroup documentGroup){
		DocumentGroupBean bean = new DocumentGroupBean();
		bean.setDocumentGroupId(documentGroup.getDocumentGroupId());
		bean.setDocumentGroupName(documentGroup.getDocumentGroupName());
		//bean.setDocumentOptions((List<SelectItem>) documentGroup.getDocument());
		System.out.println("Hello inside Docx Group aditionals"+documentGroup.getDocumentGroupName());
		return bean;
	}
	

	
	
}

	
	
	
	
