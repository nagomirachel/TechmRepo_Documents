<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit Profile</title>
<script type="text/javascript">
function validateUser() {
    
    var alphaExp = /^[a-zA-Z]+$/;
    if(EditProfile.firstName.value == ""){
            alert("First Name Must be Provided");
            EditProfile.firstName.focus(true);
            return false;
    }
    else {
            if(!EditProfile.firstName.value.match(alphaExp)){
                    alert("First Name Must Contain only Alphabets");
                    EditProfile.firstName.focus(true);
                    return false;           
    }       
    }
    
    var alphaExp1=/^[a-zA-Z]+$/;
    if(EditProfile.lastName.value== ""){
            alert("LastName Must be Provided");
            EditProfile.lastName.focus(true);
            return false;
    }
    else{
            if(!EditProfile.lastName.value.match(alphaExp1)){
                    alert("Last Name Must Contain only Alphabets");
                    EditProfile.lastName.focus(true);
                    return false;
            }
    }
    if(EditProfile.date.value=="---Select---"||EditProfile.month.value=="---Select---"||EditProfile.year.value=="---Select---"){
        alert("Provide the date");
        EditProfile.date.focus(true);
        return false;
        }
    
    if(EditProfile.m_status.value=="---Select---"){
            alert("Marital status Must be Provided");
            EditProfile.m_status.focus(true);
            return false;
            }
    
    
    if(EditProfile.first_qual.value=="---Select---"){
            alert("First Qualification Must be Provided");
            EditProfile.first_qual.focus(true);
            return false;
            }
    if(EditProfile.skill1.value=="---Select---"&&EditProfile.skill2.value=="---Select---"&&EditProfile.skill3.value=="---Select---"){
        alert("Any one skill must be provided");
        EditProfile.skill1.focus(true);
        return false;
        }
    if(EditProfile.experience.value=="---Select---"){
            alert("Select experience");
            EditProfile.experience.focus(true);
            return false;
            }
    


    if(EditProfile.first_emp.value==""){
            alert("Provide previous employer name");
            EditProfile.first_emp.focus(true);
            return false;
            }
   /*  if(RegistrationForm.mob_no.value==""){
            alert("Provide Mobile number");
            RegistrationForm.mob_no.focus(true);
            return false;
            } */
    var mobExp=/^[7-9]\d{9}$/;
    if(EditProfile.mob_no.value==null ||EditProfile.mob_no.value=="" ){
    	alert("Mobile Number  Must be Provided ");
    	EditProfile.mob_no.focus(true);
    	return false;
    }
    else{
    	if(!EditProfile.mob_no.value.match(mobExp)|| (EditProfile.mob_no.value.length)<10){
    		alert("Mobile Number Must not start with 0 and should be 10 numbers");
    		EditProfile.mob_no.focus(true);
    		return false;
    	}
    }
    
    if(EditProfile.ph_no.value==""){
            alert("Provide Phone number");
            EditProfile.ph_no.focus(true);
            return false;
            }
    else{
            var phExp=/^[0-9]+$/;
            if(!EditProfile.ph_no.value.match(phExp)||(EditProfile.ph_no.value.length)>=11)
            
    {
            alert("Phone Number must be numbers and should not exceed 11 digits");
            EditProfile.ph_no.focus(true);
            return false;
    
    }}
    
    if(EditProfile.line1.value==""&&EditProfile.line3.value==""&&EditProfile.line3.value==""){
        alert("Provide the current address");
        EditProfile.line1.focus(true);
        return false;
        }
    if(EditProfile.state.value==""){
        alert("Provide the state");
        EditProfile.state.focus(true);
        return false;
        }
    if(EditProfile.city.value==""){
        alert("Provide the city");
        EditProfile.city.focus(true);
        return false;
        }
    if(EditProfile.pincode.value==""){
        alert("Provide the pincode");
        EditProfile.pincode.focus(true);
        return false;
        }
    else{
        var pinExp=/^[0-9]+$/;
        if(!EditProfile.pincode.value.match(pinExp)||(EditProfile.pincode.value.length)<6||(EditProfile.pincode.value.length)>6)
        
{
        alert("Pincode must be numbers and should 6 digits");
        EditProfile.ph_no.focus(true);
        return false;

}}
    if(EditProfile.email.value==""){
        alert("Provide the email");
        EditProfile.email.focus(true);
        return false;
        }
    return true;
}

function email_Check(){
	var email=EditProfile.email.value;
	if(!email.match(/^[a-zA-Z](([^<>()[\]\\.,;:\s@\"]+(\.[^<>()[\]\\.,;:\s@\"]+)*)|(\".+\"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/)){
		alert("Email ID Should be in valid format...(E.g nagomi@techmahindra.com");
		EditProfile.email.focus(true);
		//return false;
	}
	
}
</script>

</head>
<body bgcolor="#87CEEB" >
<center>
<h3>Edit Profile</h3></center>	
<form method="post" name="EditProfile"
		action="./jobseekercontroller?option=edit"
		 onsubmit="return validateUser()">
<table>
			<tr>
				<td>First Name</td>
				<td><input name="firstName" /></td>
			</tr>

			<tr>
				<td>Last Name</td>
				<td><input name="lastName" /></td>
			</tr>
			<tr>
				<td>Middle Name</td>
				<td><input name="middleName" /></td>
			</tr>
			<tr>
				<td>Date of Birth</td>
				<td><select name="date">
				<option value="---Select---">---Select---</option>
				<c:forEach var="i" begin="1" end="31" step="1" >
				<option>${i}</option>
				</c:forEach>
				</select><select name="month">
				<option value="---Select---">---Select---</option>
				<option>JAN</option>
				<option>FEB</option>
				<option>MAR</option>
				<option>APR</option>
				<option>MAY</option>
				<option>JUN</option>
				<option>JUL</option>
				<option>AUG</option>
				<option>SEP</option>
				<option>OCT</option>
				<option>NOV</option>
				<option>DEC</option>
				</select><select name="year">
				<option value="---Select---">---Select---</option>
				<c:forEach var="i" begin="1947" end="2013" step="1" >
				<option>${i}</option>
				</c:forEach>
				</select></td>
			</tr>
			<tr>
				<td>Gender</td>
				<td><input type="radio" name="gender" value="Male" checked/>Male
				<input type="radio" name="gender" value="Female" />Female
				</td>
			</tr>
			<tr>
				<td>Marital Status</td>
				<td><select name="m_status">
				<option value="---Select---">---Select---</option>
				<option>Married</option>
				<option>Unmarried</option>
				</select></td>
			</tr>
			<tr>
				<td>First Highest Qualification</td>
				<td><select name="first_qual">
				<option value="---Select---">---Select---</option>
				<option>10+2</option>
				<option>Diploma</option>
				<option>Graduate</option>
				<option>Post Graduate</option>
				<option>Under Graduate</option>
			
				</select></td>
			</tr>
			<tr>
				<td>Domain of Interest 1</td>
				<td><select name="skill1">
				<option value="---Select---">---Select---</option>
				<option value="Analytics and BuisnessIntelligence">Analytics and BuisnessIntelligence</option>
				<option value="Engineering Design and RND">Engineering Design and RND</option>
				<option value="HR Recruitment and Admin">HR Recruitment and Admin</option>
				<option value="IT SOftware-DBA Datawarehousing">IT SOftware-DBA Datawarehousing</option>
				<option value="IT Software Mainframe">IT Software Mainframe</option>
				<option value="Mobile Application Development">Mobile Application Development</option>
				<option value="IT Hardware">IT Hardware</option>
				<option value="TEchnical Support">TEchnical Support</option>
				<option value="Banking and FiniancialServices">Banking and FiniancialServices</option>
				<option value="Travel,Tours and TIcketingAirlines">Travel,Tours and TIcketingAirlines</option>
				
				</select></td>
			</tr>
			<tr>
				<td>Domain of Interest 2</td>
				<td><select name="skill2">
				<option value="---Select---">---Select---</option>
				<option value="Analytics and BuisnessIntelligence">Analytics and BuisnessIntelligence</option>
				<option value="Engineering Design and RND">Engineering Design and RND</option>
				<option value="HR Recruitment and Admin">HR Recruitment and Admin</option>
				<option value="IT SOftware-DBA Datawarehousing">IT SOftware-DBA Datawarehousing</option>
				<option value="IT Software Mainframe">IT Software Mainframe</option>
				<option value="Mobile Application Development">Mobile Application Development</option>
				<option value="IT Hardware">IT Hardware</option>
				<option value="TEchnical Support">TEchnical Support</option>
				<option value="Banking and FiniancialServices">Banking and FiniancialServices</option>
				<option value="Travel,Tours and TIcketingAirlines">Travel,Tours and TIcketingAirlines</option>
				
				</select></td>
			</tr>
			<tr>
				<td>Domain of Interest 3</td>
				<td><select name="skill3">
				<option value="---Select---">---Select---</option>
				<option value="Analytics and BuisnessIntelligence">Analytics and BuisnessIntelligence</option>
				<option value="Engineering Design and RND">Engineering Design and RND</option>
				<option value="HR Recruitment and Admin">HR Recruitment and Admin</option>
				<option value="IT SOftware-DBA Datawarehousing">IT SOftware-DBA Datawarehousing</option>
				<option value="IT Software Mainframe">IT Software Mainframe</option>
				<option value="Mobile Application Development">Mobile Application Development</option>
				<option value="IT Hardware">IT Hardware</option>
				<option value="TEchnical Support">TEchnical Support</option>
				<option value="Banking and FiniancialServices">Banking and FiniancialServices</option>
				<option value="Travel,Tours and TIcketingAirlines">Travel,Tours and TIcketingAirlines</option>
				
				</select></td>
			</tr>
			<tr>
				<td>Second Highest Qualification</td>
				<td><select name="second_qual">
				<option value="---Select---">---Select---</option>
				<option>10+2</option>
				<option>Diploma</option>
				<option>Graduate</option>
				<option>Post Graduate</option>
				<option>Under Graduate</option>
			
				</select></td>
			</tr>
			<tr>
				<td>Experience(in months)</td>
				<td><select name="experience">
				<option value="---Select---">---Select---</option>
				<c:forEach var="i" begin="13" end="150" step="1" >
				<option>${i}</option>
				</c:forEach>
				</select></td>
			</tr>
			<tr>
			<td>First Previous Employer</td>
			<td><input name="first_emp"/></td>
			</tr>
			
			<tr>
			<td>Mobile Number</td>
			<td><input name="mob_no"/></td>
			</tr>
			<tr>
			<td>Phone Number</td>
			<td><input name="ph_no"/></td>
			</tr>
			<tr>
			<td>Current Address</td>
			<td><input name="line1"/></td>
			</tr>
			<tr><td></td>
			<td><input name="line2"/></td>
			</tr>
			<tr><td></td>
			<td><input name="line3"/></td>
			</tr>
			<tr>
			<td>State</td>
			<td><input name="state"/></td>
			</tr>
			<tr>
			<td>City</td>
			<td><input name="city"/></td>
			</tr>
			<tr>
			<td>Pincode</td>
			<td><input name="pincode"/></td>
			</tr>
			
				<tr>
				<td>Email Address</td>
			<td><input name="email" onblur="email_Check()" /></td>
			</tr>
			<tr>
				<th ><input type="submit" value="Save" /> </th>
				<th><input type="reset" value="clear"/></th>
			</tr>
			
		
</table>	</form>		

</body>
</html>