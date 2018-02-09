alert("ajax test");
$.ajax(
	{
		url: "./test",
		type: "GET",
		data: {"name":"heo"},
		error: function(error){
			var str = "Error\n";
			for(var i in error){
				str += (error[i] + "\n");
			}
			alert( str );
		},
		success: function(result){
			var str = "Success\n";
			alert( result.toString() );
		},
		complete: function(completed){
			alert("complete");
		}
	}
);