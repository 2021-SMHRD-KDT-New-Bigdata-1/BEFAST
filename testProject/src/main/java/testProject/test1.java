package testProject;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/test1")
public class test1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	
	BookingDAO dao =new BookingDAO();
	ArrayList<BookingVO> al = dao.select();
	for(int i=0; i<al.size(); i++) {
	if(al.get(i).getGAMES().equals("·©Å©")) {
		System.out.println("·©Å©: "+al.get(i).getGAMES());
	}
	}
	}
}
