//<canvas id="canvas" width=240 height=240 style="background-color:#808080;"></canvas>

var element = document.createElement('p1');
element.textContent="Hello, World - Java Script";
document.body.appendChild(element);//add the newly created element to the DOM
//window.alert("Wow!!! Hello Nurse Abby!!") ;
var img = new Image() ;
img.onload=function(){    scaleToFill(this);}
img.src = 'file:///e:/project/WebDev/51984873_2343113035732736_8013201160812888064_o.jpg' ;

//document.body.appendChild( img ) ;
console.log("Abby Parece means Love") ;

var canvas = document.getElementById("canvasHtml5");
var ctx = canvas.getContext("2d");
ctx.font="16px Arial";
ctx.drawImage( img, 0, 0 ) ;

canvas.addEventListener("mousemove",function(e)
{
	var cRect = canvas.getBoundingClientRect();// Gets CSS pos, and width/height
	var canvasX =Math.round(e.clientX- cRect.left);// Subtract the 'left' of the canvas
	var canvasY =Math.round(e.clientY- cRect.top);// from the X/Y positions to make      
	//ctx.clearRect(0,0, canvas.width, canvas.height);// (0,0) the top left of the canvas    
	scaleToFill( img ) ;
	ctx.fillText("X: "+canvasX+", Y: "+canvasY,10,20);
} );
/*window.onload(d=(function(){    
// add a canvas element using javascript    
var canvas=document.createElement('canvas');    
canvas.id='canvasJavascript'    
document.body.appendChild(canvas);
} ); // end $(function(){});
*/

//var image =new Image();image.src="imgURL";


function scaleToFill(img)
{
	// get the scale
	var scale =Math.max(canvas.width/ img.width, canvas.height/ img.height);// get the top left position of the image
	var x =(canvas.width/2)-(img.width/2)* scale;
	var y =(canvas.height/2)-(img.height/2)* scale;    
	ctx.drawImage(img, x, y, img.width* scale, img.height* scale);
} 