/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.30
 * Generated at: 2013-01-30 00:50:59 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.jsp.backlog;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.io.*;
import java.util.*;
import java.text.*;
import mantenedores.MBackLogSelect;
import dto.DTOBackLog;

public final class MuestraPosIt_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=ISO-8859-1");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");

	String Fecha = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
	String Hora  = new SimpleDateFormat("HH:mm:ss").format(new Date()); 

      out.write("\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">\r\n");
      out.write("<link type=text/css rel=stylesheet media=all href=\"../../css/kanban.css\">\r\n");
      out.write("<script type=\"text/javascript\" src=\"../../js/kanbanOff.js\"></script>\r\n");
      out.write("<title>KANBAN::POS-IT</title>\r\n");
      out.write("</head>\r\n");
      out.write("<body bgcolor=#000000 onload=\"OnLoad()\">\r\n");
      out.write("\r\n");
      out.write("<div align=center>\r\n");
      out.write("\r\n");
      out.write("\t<table width=1024 align=center border=0 cellspacing=2 celpadding=2>\r\n");
      out.write("\t\t<tr>\r\n");
      out.write("\t\t\t<td align=left>\r\n");
      out.write("\t\t\t\t<img src=\"../../images/BrandingKanbanL.png\"> \r\n");
      out.write("\t\t\t</td>\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\t\t<tr>\r\n");
      out.write("\t\t\t<td align=center>\r\n");
      out.write("\t\t\t\t<img src=\"../../images/LineaTiempo.png\">\r\n");
      out.write("\t\t\t</td>\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\t</table>\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t<table width=1024  height=100% border=0 cellspacing=1 celpadding=1 bgcolor=#ffffff>\r\n");
      out.write("\r\n");
      out.write("\t\t<!-- <tr bgcolor=#fffcfc>\r\n");
      out.write("\t\t\t<td colspan=3 height=40 align=center>\r\n");
      out.write("\t\t\t<font face=Tahoma size=5 color=#000000><b>KANBAN BOARD  (Mueve la Etiqueta)</b></font>\r\n");
      out.write("\t\t\t</td>\r\n");
      out.write("\t\t</tr> -->\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t<tr bgcolor=#000000>\r\n");
      out.write("\t\t\t<td width=424 height=20 align=center bgcolor=#1C1C1C>\r\n");
      out.write("\t\t\t<font face=Tahoma size=3 color=#fffcfc><b><i>HISTORIAS</i></b> (BackLog Product)</font>\r\n");
      out.write("\t\t\t</td>\r\n");
      out.write("\t\t\t<td width=300 align=center bgcolor=#1C1C1C>\r\n");
      out.write("\t\t\t<font face=Tahoma size=3 color=#fffcfc><b><i>EN CURSO</i></b> (WIP)</font>\r\n");
      out.write("\t\t\t</td>\r\n");
      out.write("\t\t\t<td width=300 align=center bgcolor=#1C1C1C>\r\n");
      out.write("\t\t\t<font face=Tahoma size=3 color=#fffcfc><b><i>CERRADO</i></b>(Close)</font>\r\n");
      out.write("\t\t\t</td>\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\t\t<tr>              \r\n");
      out.write("\t\t\t<td width=424 align=center  bgcolor=#1C1C1C > <!-- BACKGROUND=\"../../images/movilidad.png\" -->\r\n");
      out.write("\t\t\t\t");

				/* -------------------------------  */
				MBackLogSelect backlog   = new MBackLogSelect();
				ArrayList backlogs = backlog.ListaBackLogs();
				/* -------------------------------  */
				Iterator itBL = backlogs.iterator();
				while (itBL.hasNext()){
					DTOBackLog obBL = (DTOBackLog) itBL.next();
      out.write("\r\n");
      out.write("\t\t\t\t\t<div id=");
      out.print(obBL.getID());
      out.write(" class=\"Dragable\" selectable=\"no\" style=\"background-color:");
      out.print(obBL.getDetalle3());
      out.write("; border-width: 2px; border-style: dotted; border-color: #FFDD2A;\">\r\n");
      out.write("\t\t\t\t\t\t<font face=Tahoma size=1 color=#00000f><b>");
      out.print(obBL.getActividad() );
      out.write("</b><br>");
      out.print(obBL.getDetalle1());
      out.write("<br>");
      out.print(obBL.getDetalle2());
      out.write("</font>\r\n");
      out.write("\t\t\t\t\t\t<br><br>\r\n");
      out.write("\t\t\t\t\t\t<div style=\"background-color:#FFDD2A; border-color:red; border-width: 1px; border-style:solid\">\r\n");
      out.write("\t\t\t\t\t\t\t<font face=Tahoma size=1 color=#ff0000>");
      out.print(obBL.getFecha());
      out.write("</font>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t");
}
      out.write("\r\n");
      out.write("\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t<td width=300 align=center bgcolor=#1C1C1C>\r\n");
      out.write("\t\t\t\t\t<div style=\"height : 240px\">&nbsp;</div> \r\n");
      out.write("\t\t\t\t\t<table width=300 border=0 cellspacing=1 celpadding=1 bgcolor=#ffffff>\r\n");
      out.write("\t\t\t\t\t\t<tr bgcolor=#000000>\r\n");
      out.write("\t\t\t\t\t\t\t<td width=300 bgcolor=#1C1C1C>\r\n");
      out.write("\t\t\t\t\t\t\t\t<font face=Tahoma size=2 color=#fffcfc><b><i>EN ESPERA</i></b> (Waiting)</font>\r\n");
      out.write("\t\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t<tr bgcolor=#000000>\r\n");
      out.write("\t\t\t\t\t\t\t<td width=300 bgcolor=#1C1C1C>\r\n");
      out.write("\t\t\t\t\t\t\t\t<div style=\"height : 340px\">&nbsp;</div>\r\n");
      out.write("\t\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t</table>\r\n");
      out.write("\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t<td width=300 align=center bgcolor=#1C1C1C>\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t</td>\r\n");
      out.write("\t\t\t</tr>\t\t\t\t\r\n");
      out.write("\t</table>\r\n");
      out.write("\t<br />\r\n");
      out.write("</div>\r\n");
      out.write("\t<!-- </form> -->\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
