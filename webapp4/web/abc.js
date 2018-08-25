function validate(f)
{
	g=f.txt1.value;
	h=f.txt2.value;
	e=f.txt3.value;
	d=f.txt4.value;
	c=f.txt5.value;
	b=f.rad.value;	
	a=f.cnt.value;
	spn=document.getElementById("err");
	if(g=="")
	{
		//alert("Please input first name");
		spn.innerHTML="Please input first name";
		f.txt1.focus();
		return false;
	}
	else if(validateAlpha(g))
	{
		spn.innerHTML="invalid name";
		f.txt1.focus();
		return false;
	}
	else if(h=="")
	{
		//alert("Please input first name");
		spn.innerHTML="Please input last name";
		f.txt2.focus();
		return false;
	}
	else if(e=="")
	{
		//alert("Please input first name");
		spn.innerHTML="Please input email";
		f.txt3.focus();
		return false;
	}
	else if(d=="")
	{
		//alert("Please input first name");
		spn.innerHTML="Please input password";
		f.txt4.focus();
		return false;
	}
	else if(c=="")
	{
		//alert("Please input first name");
		spn.innerHTML="Please input confirm password";
		f.txt5.focus();
		return false;
	} 
	else if(c!=d)
	{
		spn.innerHTML="Passwords do not match";
		f.txt5.focus();
		return false;
	}
}

function validateAlpha(data)
{
	b=false;
	for(i=0;i<data.length;i++)
	{
		ch=data.charAt(i);
		if(!((ch>='A'&&ch<='Z')||(ch>='a'&&ch<='z')))
		{
			b=true;
			break;
		}
	}
	if(b){
		return true;
	}
	return false;
}