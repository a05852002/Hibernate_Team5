/**
 * 
 */
 function pasvalid()
 {
	var password = pas1check.value;
	// checking for a specific password pattern
	if (password.match(/[a-z]/g) && password.match(/[A-Z]/g) && password.match(/[0-9]/g) && 
	    password.match(/[^a-zA-Z\d]/g) && password.length >= 6 && password.length <= 12)
	{
	  continue;
	}else{
		 alert("密碼不合規範！");
		 pas1check.value="";
		 }
}