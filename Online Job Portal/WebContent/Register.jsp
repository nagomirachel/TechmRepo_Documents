<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registration Page</title>
<script type="text/javascript">
function validateUser() {
    
    var alphaExp = /^[a-zA-Z]+$/;
    if(RegistrationForm.firstName.value == ""){
            alert("First Name Must be Provided");
            RegistrationForm.firstName.focus(true);
            return false;
    }
    else {
            if(!RegistrationForm.firstName.value.match(alphaExp)){
                    alert("First Name Must Contain only Alphabets");
                    RegistrationForm.firstName.focus(true);
                    return false;           
    }       
    }
    
    var alphaExp1=/^[a-zA-Z]+$/;
    if(RegistrationForm.lastName.value== ""){
            alert("LastName Must be Provided");
            RegistrationForm.lastName.focus(true);
            return false;
    }
    else{
            if(!RegistrationForm.lastName.value.match(alphaExp1)){
                    alert("Last Name Must Contain only Alphabets");
                    RegistrationForm.lastName.focus(true);
                    return false;
            }
    }
    if(RegistrationForm.date.value=="---Select---"||RegistrationForm.month.value=="---Select---"||RegistrationForm.year.value=="---Select---"){
        alert("Provide the date");
        RegistrationForm.date.focus(true);
        return false;
        }
    
    if(RegistrationForm.m_status.value=="---Select---"){
            alert("Marital status Must be Provided");
            RegistrationForm.m_status.focus(true);
            return false;
            }
    
    
    if(RegistrationForm.first_qual.value=="---Select---"){
            alert("First Qualification Must be Provided");
            RegistrationForm.first_qual.focus(true);
            return false;
            }
    if(RegistrationForm.skill1.value=="---Select---"&&RegistrationForm.skill2.value=="---Select---"&&RegistrationForm.skill3.value=="---Select---"){
        alert("Any one skill must be provided");
        RegistrationForm.skill1.focus(true);
        return false;
        }
    if(RegistrationForm.experience.value=="---Select---"){
            alert("Select experience");
            RegistrationForm.experience.focus(true);
            return false;
            }
    


    if(RegistrationForm.first_emp.value==""){
            alert("Provide previous employer name");
            RegistrationForm.first_emp.focus(true);
            return false;
            }
   /*  if(RegistrationForm.mob_no.value==""){
            alert("Provide Mobile number");
            RegistrationForm.mob_no.focus(true);
            return false;
            } */
    var mobExp=/^[7-9]\d{9}$/;
    if(RegistrationForm.mob_no.value==null || RegistrationForm.mob_no.value=="" ){
    	alert("Mobile Number  Must be Provided ");
    	RegistrationForm.mob_no.focus(true);
    	return false;
    }
    else{
    	if(!RegistrationForm.mob_no.value.match(mobExp)|| (RegistrationForm.mob_no.value.length)<10){
    		alert("Mobile Number Must not start with 0 and should be 10 numbers");
    		RegistrationForm.mob_no.focus(true);
    		return false;
    	}
    }
    
    if(RegistrationForm.ph_no.value==""){
            alert("Provide Phone number");
            RegistrationForm.ph_no.focus(true);
            return false;
            }
    else{
            var phExp=/^[0-9]+$/;
            if(!RegistrationForm.ph_no.value.match(phExp)||(RegistrationForm.ph_no.value.length)>=11)
            
    {
            alert("Phone Number must be numbers and should not exceed 11 digits");
            RegistrationForm.ph_no.focus(true);
            return false;
    
    }}
    
    if(RegistrationForm.line1.value==""&&RegistrationForm.line3.value==""&&RegistrationForm.line3.value==""){
        alert("Provide the current address");
        RegistrationForm.line1.focus(true);
        return false;
        }
    if(RegistrationForm.state.value==""){
        alert("Provide the state");
        RegistrationForm.state.focus(true);
        return false;
        }
    if(RegistrationForm.city.value==""){
        alert("Provide the city");
        RegistrationForm.city.focus(true);
        return false;
        }
    if(RegistrationForm.pincode.value==""){
        alert("Provide the pincode");
        RegistrationForm.pincode.focus(true);
        return false;
        }
    if(RegistrationForm.p_line1.value==""&&RegistrationForm.p_line3.value==""&&RegistrationForm.p_line3.value==""){
        alert("Provide the current address");
        RegistrationForm.p_line1.focus(true);
        return false;
        }
    if(RegistrationForm.p_state.value==""){
        alert("Provide the state");
        RegistrationForm.p_state.focus(true);
        return false;
        }
    if(RegistrationForm.p_city.value==""){
        alert("Provide the city");
        RegistrationForm.p_city.focus(true);
        return false;
        }
    if(RegistrationForm.p_pincode.value==""){
        alert("Provide the pincode");
        RegistrationForm.p_pincode.focus(true);
        return false;
        }
    if(RegistrationForm.email.value==""){
        alert("Provide the email");
        RegistrationForm.email.focus(true);
        return false;
        }
    
    if(RegistrationForm.ddno.value==""){
        alert("Provide the DDNo");
        RegistrationForm.ddno.focus(true);
        return false;
        }
    else{
    	var ddExp=/^[0-9]+$/;
		if(!RegistrationForm.ddno.value.match(ddExp)||(RegistrationForm.ddno.value.length)>=11)
		{
			alert("DDno should be in Numbers and should not exceed 11");
			RegistrationForm.ddno.focus(true);
			return false;
		}
		}
    if(RegistrationForm.ddamt.value==""){
        alert("Provide the DD Amount");
        RegistrationForm.ddamt.focus(true);
        return false;
        }
    if(RegistrationForm.bankname.value==""){
        alert("Provide Bank Name");
        RegistrationForm.bankname.focus(true);
        return false;
        }
    if(RegistrationForm.branch.value==""){
        alert("Provide the Branch");
        RegistrationForm.branch.focus(true);
        return false;
        }
    if(RegistrationForm.pass.value==""){
        alert("Provide the desired password");
        RegistrationForm.pass.focus(true);
        return false;
        }
    if(RegistrationForm.repass.value==""){
        alert("Please re-enter the password");
        RegistrationForm.repass.focus(true);
        return false;
        }
    if(RegistrationForm.repass.value!=RegistrationForm.pass.value){
        alert("Password does not match");
        RegistrationForm.pass.focus(true);
        return false;
        }
    
    return true;
}
function FillBilling(f) {
	  if(f.select.checked == true) {
	    f.p_line1.value = f.line1.value;
	    f.p_line2.value = f.line2.value;
	    f.p_line3.value = f.line3.value;
	    f.p_state.value = f.state.value;
	    f.p_city.value = f.city.value;
	    f.p_pincode.value = f.pincode.value;
	  }
	}
function email_Check(){
	var email=RegistrationForm.email.value;
	if(!email.match(/^[a-zA-Z](([^<>()[\]\\.,;:\s@\"]+(\.[^<>()[\]\\.,;:\s@\"]+)*)|(\".+\"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/)){
		alert("Email ID Should be in valid format...(E.g nagomi@techmahindra.com");
		RegistrationForm.email.focus(true);
		//return false;
	}
	
}

</script>

</head>
<body bgcolor="#87CEEB"  >
<center><h3>Registration Form</h3></center>
	<form method="post" name="RegistrationForm" action="./jobseekercontroller?option=register"
		 onsubmit="return validateUser()" >
		<table>
			<tr>
				<td>First Name *</td>
				<td><input name="firstName" /></td>
			</tr>

			<tr>
				<td>Last Name *</td>
				<td><input name="lastName" /></td>
			</tr>
			<tr>
				<td>Middle Name</td>
				<td><input name="middleName" /></td>
			</tr>
			<tr>
				<td>Date of Birth *</td>
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
				<td>Gender *</td>
				<td><input type="radio" name="gender" value="Male" checked/>Male
				<input type="radio" name="gender" value="Female" />Female
				</td>
			</tr>
			<tr>
				<td>Marital Status *</td>
				<td><select name="m_status">
				<option value="---Select---">---Select---</option>
				<option value="Married">Married</option>
				<option value="Unmarried">Unmarried</option>
				</select></td>
			</tr>
			<tr>
				<td>First Highest Qualification *</td>
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
				<td>Domain of Interest 1*</td>
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
				<td>Experience(in months)*</td>
				<td><select name="experience">
				<option value="---Select---">---Select---</option>
				<c:forEach var="i" begin="13" end="150" step="1" >
				<option>${i}</option>
				</c:forEach>
				</select></td>
			</tr>
			<tr>
			<td>Previous Employer*</td>
			<td><input name="first_emp"/></td>
			</tr>
			<tr>
			<td>Mobile Number *</td>
			<td><input name="mob_no"/></td>
			</tr>
			<tr>
			<td>Phone Number *</td>
			<td><input name="ph_no"/></td>
			</tr>
			<tr>
			<td>Current Address *</td>
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
			<tr><td><input type="checkbox"  name="select" id="check" onclick="FillBilling(this.form)"/>Same as Current Address</td></tr>
				<tr>
			<td>Permanent Address *</td>
			<td><input name="p_line1"/></td>
			</tr>
			<tr><td></td>
			<td><input name="p_line2"/></td>
			</tr>
			<tr><td></td>
			<td><input name="p_line3"/></td>
			</tr>
			<tr>
			<td>State</td>
			<td><input name="p_state"/></td>
			</tr>
			<tr>
			<td>City</td>
			<td><input name="p_city"/></td>
			</tr>
			<tr>
			<td>Pincode</td>
			<td><input name="p_pincode"/></td>
			</tr>
			<tr>
			<td>Email Address *</td>
			<td><input name="email" onblur="email_Check()"/></td>
			</tr>
			<tr><td align="center" colspan=2>DD Details</td></tr>
			 <tr>
			<td>DD Number</td>
			<td><input name="ddno"/></td>
			</tr>
				<tr>
			<td>DD Amount</td>
			<td><input name="ddamt"/></td>
			</tr>
				<tr>
			<td>Bank Name</td>
			<td><input name="bankname"/></td>
			</tr>
				<tr>
			<td>Branch</td>
			<td><input name="branch"/></td>
			</tr>
			<tr><td align="center" colspan="2">Login Details</td></tr>
			<tr>
			<td>Password</td>
			<td><input type="password" name="pass"/></td>
			</tr>
			<tr>
			<td>Re-enter Password</td>
			<td><input type="password" name="repass"/></td>
			</tr>
			<tr>
				<th colspan=2><input type="submit" value="Register"  /> <input
					type="reset" value="Clear All" /></th>
			</tr>

			<tr>
				<th colspan="2">${param.msg}</th>
			</tr>

		</table>


	</form>


</body>
</html>