window.onload=function(){
  
	var studentList =document.getElementById("stu-list");

	var btn = document.getElementById("btn");

	btn.addEventListener("click", function(){
	var ourRequest = new XMLHttpRequest();
	ourRequest.open('GET', 'http://localhost:8080/students');
	ourRequest.onload = function(){
		var ourData = JSON.parse(ourRequest.responseText);
		//console.log(ourData[0]);
		if (this.readyState == 4 && this.status == 200){
			renderHTML(ourData);
		}	
	}
	    ourRequest.send();
	});
	
	function renderHTML(data){
		
		var html = "";
		
		for (var i = 0; i < data.length; i++) {
			html += `<div class="col-md-4 mb-3 mb-md-0">
          <div class="card py-4 h-100">
            <div class="card-body text-center">
             <i class="fas fa-map-marked-alt text-primary mb-2"></i> 
              <h4 class="text-uppercase m-0">` + data[i].name + `</h4>
			  
              <hr class="my-4">
              <div class="small text-black-50"><h4 class="text-uppercase m-0">` + data[i].email + `</h4> </div>
            </div>
          </div>
        </div>`
		}
		studentList.insertAdjacentHTML('beforeend', html);
	}
	
}
