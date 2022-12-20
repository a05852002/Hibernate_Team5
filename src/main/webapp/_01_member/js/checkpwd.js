/**
 * 
 */
 function checkpwd(){
					if(document.getElementById("pas1check").value != document.getElementById("pas2check").value){
						alert("密碼不一致");
						pas2check.value="";
					}
				}