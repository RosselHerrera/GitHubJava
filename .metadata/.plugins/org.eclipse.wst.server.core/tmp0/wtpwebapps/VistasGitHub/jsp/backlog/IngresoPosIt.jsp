<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<%@ page import="java.io.*, java.util.*, java.text.*"%>
<%@ page import = "mantenedores.MBackLogSelect" %>
<%@ page import = "persistencia.HelperHSQL" %>
<%@ page import = "dto.DTOBackLog" %>

<%
String Fecha = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
String Hora  = new SimpleDateFormat("HH:mm:ss").format(new Date());

String Flag = "";

int id = 0;
String[] list = {"#deac2f", "7FFF00 ", "#fff000", "#56c4e8", "#e9e74a"}; //FF8C00 

Random r = new Random();
String color = "";
	   color = list[r.nextInt(list.length)];


if (request.getParameter("flag") != null) {
	Flag = "1";
	//Recoger parametros submited
	String Actividad = request.getParameter("tipo");
	String Detalle1 = request.getParameter("det1");
	String Detalle2 = request.getParameter("det2");
	String Detalle3 = "0";
	String FechaBL = request.getParameter("fecha");
	//Grabar Registro
	/* -------------------------------  */
	MBackLogSelect backlog   = new MBackLogSelect();
	id = backlog.identidad();
	int Ret = backlog.GrabaBackLog(id, Actividad, Detalle1, Detalle2, color, FechaBL);   //(Actividad, Detalle1, Detalle2, Detalle3, FechaBL);
	/* -------------------------------  */
}

%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link type="text/css" rel="stylesheet" media="all" href="../../css/formulario.css">
<link rel="stylesheet" type="text/css" media="all" href="../../css/jsDatePick_ltr.min.css" />
<script type="text/javascript" src="../../js/jsDatePick.min.1.3.js"></script>
<title>KANBAN::BACKLOG</title>
<script type="text/javascript">
window.onload = function(){
	new JsDatePick({
		useMode:2,
		target:"fecha",
		dateFormat:"%d-%m-%Y"
	});
};
</script>

</head>
<body>
	<div height=1>&nbsp;</div>
	<div align=center>
		<table width=1024 align=center border=0 cellspacing=1 celpadding=1>
			<tr>
				<td align=left>
					<img src="../../images/BrandingKanbanL.png"> 
				</td>
			</tr>
		</table>
	</div>
	<!-- <form id='upData' name='upData' action='MuestraPosIt.jsp' method='post'>  -->   
	<form id='upData' name='upData' action=# method='post'>        
		<div class="box">            
			 <h1>Datos&nbsp;&nbsp;BackLog: <%=Fecha%></h1>             
			 <table border=0>
			 	<tr>
			 	   <td width=35%>
				 	   	<label>                
							 <span>Actividad : </span><input type="text" class="input_text" name="tipo" id="tipo" maxlenght=19 >
					  	 </label>
			 	   </td>
			 	   <td>
			 	   		<label>
							 <span>Detalle 1 : </span><input type="text" class="input_text" name="det1" id="det1"/>  
						</label>
			 	   </td>
			 	   <td>
				 		 <label>
							 <span>Detalle 2 : </span><input type="text" class="input_text" name="det2" id="det2"/>            
						</label>
			 	   </td>
			 	</tr>
			 	<tr>
			 	   <td colspan=2>
				 	   	<label>                
							<span>&nbsp;&nbsp;&nbsp;Fecha : </span>
							 <input type="text" class="input_text" size="12" id="fecha" name="fecha"/>  	 
						 </label>
			 	   </td>

			 	   <td width=34%>
				 		 <label>
							 <input type="submit" class="button" value="Graba Pos-it" />             
						</label>
			 	   </td>
			 	</tr>
			</table>
		</div>
		
		<!-- /* ---------------------------- CUERPO --------------------------- */ -->
		<div hight=30>&nbsp;</div>
		<!-- /* ---------------------------- CUERPO --------------------------- */ -->
	 	<%if (Flag != ""){%>
	 	<div class="box">            
			<h1>Pos-It&nbsp;&nbsp;BackLog:</h1>   
			<%
			/* -------------------------------  */
			/* MBackLogSelect backlog   = new MBackLogSelect();
				     ArrayList backlogs = backlog.ListaBackLogs(); */
			/* -------------------------------  */
			HelperHSQL backlog = new HelperHSQL();
			ArrayList backlogs = backlog.HelperListaBackLogs();
			/* -------------------------------  */
			Iterator itBL = backlogs.iterator();%>
			<div align=center>
			<div id=tableContainer class=tableContainer>
				<table border=0 cellspacing=0 cellpadding=0 width=1020px;>
				<%
				    
					while (itBL.hasNext()){
						DTOBackLog obBL = (DTOBackLog) itBL.next();%>
						<tr bgcolor=#262626>
							<td align=left width=24%>
								<label>
									<font face=Tahoma size=2 color=#deac2f><b><%=obBL.getID()%>: :<%=obBL.getActividad() %></b></font>
								</label> 
							</td>
							<td align=left width=24%> 
								<label>
									<font face=Tahoma size=2 color=#ffff00><%=obBL.getDetalle1()%></font>
								</label>
							</td>
							<td align=left width=24%>
								<label>
									<font face=Tahoma size=2 color=#ffff00><%=obBL.getDetalle2()%></font>
								</label>
							</td>
							<td align=left width=24%>
								<label>
									<font face=Tahoma size=2 color=#ff0000><%=obBL.getFecha()%></font>
								</label>
							</td>
							<td width=4% bgcolor='<%=obBL.getDetalle3()%>'>
								<label><span><%=obBL.getDetalle3()%></span></label>
							</td>
						</tr>
					<%}%>
					<%-- <input type="hidden" name="id" id="id" value='<%=idp%>' /> --%>
				</table>
			</div>
			</div>
		</div> 
		<%} else {%>
		<div class="box">            
			<h1>Pos-It&nbsp;&nbsp;BackLog: <%=Fecha%></h1>  
			<%
			/* -------------------------------  */
			MBackLogSelect backlog   = new MBackLogSelect();
			ArrayList backlogs = backlog.ListaBackLogs();
			/* -------------------------------  */
			Iterator itBL = backlogs.iterator();%>
			<div align=center>
			<div id=tableContainer class=tableContainer>
				<table border=0 cellspacing=0 cellpadding=0 width=1020px;>
				<%
				    
					while (itBL.hasNext()){
						DTOBackLog obBL = (DTOBackLog) itBL.next();%>
						<tr bgcolor=#262626>
							<td align=left width=24%>
								<label>
									<font face=Tahoma size=2 color=#deac2f><b><%=obBL.getID()%>: :<%=obBL.getActividad() %></b></font>
								</label> 
							</td>
							<td align=left width=24%> 
								<label>
									<font face=Tahoma size=2 color=#ffff00><%=obBL.getDetalle1()%></font>
								</label>
							</td>
							<td align=left width=24%>
								<label>
									<font face=Tahoma size=2 color=#ffff00><%=obBL.getDetalle2()%></font>
								</label>
							</td>
							<td align=left width=24%>
								<label>
									<font face=Tahoma size=2 color=#ff0000><%=obBL.getFecha()%></font>
								</label>
							</td>
							<td width=4% bgcolor='<%=obBL.getDetalle3()%>'>
								<label><span><%=obBL.getDetalle3()%></span></label>
							</td>
						</tr>
					<%}%>
					<%-- <input type="hidden" name="id" id="id" value='<%=idp%>' /> --%>
				</table>
			</div>
			</div>
		 <%}%>
		</div>
			                                   
	 <input type="hidden" name="flag" id="flag" value='<%=Flag%>' /> 
	 	       
	 </form>
	
</body>
</html>