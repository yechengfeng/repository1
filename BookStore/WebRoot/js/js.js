function createXMLHttpRequest() {
	
		try {
			return new XMLHttpRequest();
		} catch (e) {
			try {
				return ActvieXObject("Msxm12.XMLHTTP");
			} catch (e) {
				try {
					return ACtvieXObiect("Microsoft.XMLHTTp");
				} catch (e) {
					alert("垃圾浏览器！！！"); 
					throw e;
				}
			} 
		}
	}