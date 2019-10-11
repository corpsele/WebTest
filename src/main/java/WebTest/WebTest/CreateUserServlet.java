package WebTest.WebTest;

import java.io.BufferedReader;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.google.gson.Gson;


/**
 * Servlet implementation class CreateUserServlet
 */
@WebServlet(
		urlPatterns = { "/CreateUserServlet" }, 
		initParams = { 
				@WebInitParam(name = "username", value = ""), 
				@WebInitParam(name = "password", value = ""), 
				@WebInitParam(name = "date", value = "")
		})
public class CreateUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public CreateUserServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		response.sendRedirect("/index.html");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		doGet(request, response);
//		List<HashMap<String, String>> list = (ArrayList<HashMap<String, String>>) request.getParameterNames();
//		Map<String, String> map = request.getParameterMap();
//		Set<String> keys = map.keySet();
//		for (String key: keys) {
//			String valueString = map.get(key);
//			log("key="+key+"value="+valueString);
//		}


		response.setStatus(200);
		response.getWriter().println(JSONObject.toJSONString(request.getParameterMap()));
        response.getWriter().println("success");

	}

}
