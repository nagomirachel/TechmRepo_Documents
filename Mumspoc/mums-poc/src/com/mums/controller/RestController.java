package com.mums.controller;
/*package com.java.controller;

import javax.ws.rs.Produces;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.java.model.Document;
import com.java.model.User;
import com.java.service.DocumentGroupService;
import com.java.service.DocumentService;
import com.java.service.UserService;

public class RestController {

	
	@Autowired
	private UserService userService;
	@Autowired
	private DocumentGroupService documentGroupService;
	@Autowired
	private DocumentService documentService;

	@RequestMapping(value="/adduser/{cdsId}/{firstName}/{lastName}", method=RequestMethod.GET)
	@Transactional(propagation=Propagation.REQUIRED, rollbackFor=Exception.class)
	@ResponseBody
	public ModelAndView insertEmp(@PathVariable("cdsId") String cdsId,@PathVariable ("firstName") String firstName,
	@PathVariable("lastName") String lastName)
	{
		System.out.println(cdsId);
		System.out.println(firstName);
		User user = new User();
		user.setCdsid(cdsId);
		user.setFirstName(firstName);
		user.setLastName(lastName);
		
		userService.addEmp(user);
		//employeeService.addEmp(cdsId,firstname,lastname);
		  return new ModelAndView("redirect:/add.html");
		  

	}
	
	@Produces("application/xml")
	@RequestMapping(value="/adddocument/{documentId}/{documentName}/{printId}", method=RequestMethod.GET)
	@Transactional(propagation=Propagation.REQUIRED, rollbackFor=Exception.class)
	@ResponseBody
	public ModelAndView insertDoc(@PathVariable("documentId") String documentId,@PathVariable ("documentName") String documentName,
	@PathVariable("printId") String printId)
	{
		System.out.println(documentId);
		System.out.println(documentName);
		Document document=new Document();
		document.setDocumentId(documentId);
		document.setDocumentName(documentName);
		document.setPrintId(printId);
		
		documentService.addDoc(document);
		return new ModelAndView("addDocument");
		  

	}
	
	
	

}
*/