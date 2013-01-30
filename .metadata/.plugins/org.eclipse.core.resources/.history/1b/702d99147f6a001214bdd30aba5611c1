<!-- <script type="text/javascript">

var oDragTargets = [];
var oDragTarget = null;
var oDragItem = null;
var iClickOffsetX = 0;
var iClickOffsetY = 0;

function OnLoad(){
	SetupDragDrop();
}

function SetupDragDrop(){
	oDragTargets = [];
	
	var oList = document.getElementsByTagName("div");
	for(var i=0; i<oList.length; i++){
		var o = oList[i];
		if (o.className == "DropTarget"){
			oDragTargets[oDragTargets.length] = GetObjPos(o);
		}else if (o.className == "Dragable"){
			MakeDragable(o);
		}
	}
}

function MakeDragable(oBox){
	if (navigator.platform=="iPad"){
		oBox.ontouchstart= function(e){TouchStart(e)};
		oBox.ontouchmove=function(e){TouchMove(e)};
		oBox.ontouchend=function(e){TouchEnd(e)};
	}else{
		oBox.onmousemove= function(e){DragMove(oBox,e)};
		oBox.onmouseup=function(e){DragStop(oBox,e)};
		oBox.onmousedown=function(e){DragStart(oBox,e);return false};
	}	
}

function TouchStart(e){
	var oPos = GetObjPos(e.target);
	iClickOffsetX = e.targetTouches[0].pageX - oPos.x;
	iClickOffsetY = e.targetTouches[0].pageY - oPos.y;
}

function DragStart(o,e){
	if(!e) var e = window.event;
	oDragItem = o;
	
	if (e.offsetX){
		iClickOffsetX = e.offsetX;
		iClickOffsetY = e.offsetY;	
	}else{
		var oPos = GetObjPos(o);
		iClickOffsetX = e.clientX - oPos.x;
		iClickOffsetY = e.clientY - oPos.y;
	}
	
	if (o.setCapture){
		o.setCapture();
	}else{
		window.addEventListener ("mousemove", DragMove2, true);
		window.addEventListener ("mouseup",   DragStop2, true);
	}
}

function DragMove2(e){
	DragMove(oDragItem,e);
}

function DragStop2(e){
	DragStop(oDragItem,e);
}

function DragMove(o,e){
	if (oDragItem==null) return;

	if(!e) var e = window.event;
	var x = e.clientX + document.body.scrollLeft - document.body.clientLeft - iClickOffsetX;
	var y = e.clientY + document.body.scrollTop  - document.body.clientTop - iClickOffsetY;
	
	HandleDragMove(x,y);
}

function HandleDragMove(x,y){
	with(oDragItem.style){
		zIndex = 1000;
		position="absolute";
		left=x;
		top=y;
	}
	
	for (var i=0; i< oDragTargets.length; i++){
		var oTarget = oDragTargets[i];
		if (oTarget.x < x && oTarget.y < y && (oTarget.x + oTarget.w) > x && (oTarget.y + oTarget.h) > y){
			if (oDragTarget!=null && oDragTarget != oTarget.o) OnTargetOut();
			oDragTarget = oTarget.o;
			OnTargetOver();
			return;
		}
	}
	
	if (oDragTarget){
		OnTargetOut();
		oDragTarget = null;
	}
}

function TouchMove(e){
    e.preventDefault();
    var x = e.targetTouches[0].pageX - iClickOffsetX;
    var y = e.targetTouches[0].pageY - iClickOffsetY;
    oDragItem = e.targetTouches[0].target;
    HandleDragMove(x,y);
}

function DragStop(o,e){
	if (o.releaseCapture){
		o.releaseCapture();
	}else if (oDragItem){
		window.removeEventListener ("mousemove", DragMove2, true);
		window.removeEventListener ("mouseup",   DragStop2, true);
	}
	
	HandleDragStop();
}

function HandleDragStop(){
	if (oDragItem==null) return;

	if (oDragTarget){
		OnTargetOut();
		OnTargetDrop();
		oDragTarget = null;
	}
	
	oDragItem.style.zIndex = 1;
	oDragItem = null;
}

function TouchEnd(e){
	e.target.innerHTML = "TouchEnd";
	HandleDragStop();
}

function $(s){
	return document.getElementById(s);
}

function GetObjPos(obj){
	var x = 0;
	var y = 0;
	var o = obj;
	
	var w = obj.offsetWidth;
	var h = obj.offsetHeight;
	if (obj.offsetParent) {
		x = obj.offsetLeft
		y = obj.offsetTop
		while (obj = obj.offsetParent){
			x += obj.offsetLeft;
			y += obj.offsetTop;
		}
	}
	return {x:x, y:y, w:w, h:h, o:o};
}

//Drag and Drop Events
function OnTargetOver(){
	oDragTarget.style.border = "3px solid red";
}

function OnTargetOut(){
	oDragTarget.style.border = "";
}

function OnTargetDrop(){
	oDragItem.style.position="";
	oDragTarget.appendChild(oDragItem);
	if (navigator.platform=="iPad") MakeDragable(oDragItem);
}

</script> -->

<!-- <style>
.Dragable{
	cursor:move;
   -moz-user-select: -moz-none;   
   -khtml-user-select: none;   
   -webkit-user-select: none;   
   -o-user-select: none;   
   user-select: none;
   width: 240px; 
   height:90px; 
   padding: 3px;
}

.DropTarget{
	width: 200px; 
	height:200px; 
	background-color: LightBlue;
	border: 3px solid white;
}

</style> -->