/**
 * 
 */
 function checkID() {
		            let check = String(idNumber.value);
		            check = check.toUpperCase();
		            // document.getElementById("print").innerHTML = check;
		            let firstCheck = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		            if (check.length == 10) {
		                if (firstCheck.indexOf(check[0]) != "-1") {//這邊有問題
		                    if (check[1] == 1 || check[1] == 2) {
		                        let numberCheck = "0123456789"
		                        for (let i = 2; i < check.length; i++) {
		                            if (numberCheck.indexOf(check[i]) == (-1)) {
		                                alert("身分證數字列出現非數字！");
		                                idNumber.value="";
		                                break;
		                            }
		                        }
		                    } else {
		                        alert("性別數字不合規範！");
		                        idNumber.value="";
		                    }
		                } else {
		                    alert("首字不是英文！");
		                    idNumber.value="";
		                }
		            } else {
		                alert("長度不符！");
		                idNumber.value="";
		            }
		            let lastchar = check[9];
		            let firstChar = 0;
		            let num1 = 0, num2 = 0;
		            // 取出第一個字轉換成對應數字
		            for (let i = 0; i < 26; i++) {
		                if (check[0] == firstCheck[i]) {
		                    firstChar = i + 10;
		                    num1 = parseInt(Math.floor(firstChar / 10));
		                    num2 = firstChar - (num1 * 10);
		                    break;
		                }
		            }
		            let total = 0;
		            for (let i = 1; i < check.length - 1; i++) {
		                total += parseInt(check[i]) * (9 - i);
		            }
		            total = total + num1 * 1 + num2 * 9;
		            let checknumber = 10 - (total % 10);
		            if (lastchar != checknumber) {
		            	alert("身分證檢查碼錯誤");
		            	idNumber.value="";
		            }
		        }