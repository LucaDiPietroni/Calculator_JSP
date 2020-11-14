package atj;

import java.io.IOException;
import java.util.regex.Pattern;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class CalculatorServlet
 */
@WebServlet("/CalculatorServlet")
public class CalculatorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CalculatorServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	    String url = "/Keyboard.jsp";
	    request.setCharacterEncoding("UTF-8");
	    HttpSession session = request.getSession();
	    Calculations calcObject = (Calculations)session.getAttribute("calcObject");
	    String buttValue = (String)request.getParameter("button");
	    
	    if (buttValue==null) {
	    	calcObject = new Calculations();
	    	buttValue = "";
	    	session.setAttribute("calcObject",calcObject);

	    }
	    
	    try {
	    	
	    	if(Pattern.compile("[0-9]").matcher(buttValue).matches()) {
	    		if(calcObject.isFirstValueAResult()) {
	    			calcObject = new Calculations();
		    	}
	    		
	    		if(calcObject.isFirstValueActive()) {
	    			calcObject.setFirstValue(calcObject.getFirstValue() + buttValue);
	    			
	    		} else {
	    			calcObject.setSecondValue(calcObject.getSecondValue() + buttValue);
	    			
	    		}
	    			
	    	} else if (buttValue.equals("=")) {
	    		if (Pattern.compile(".*\\.")
				.matcher(calcObject.getFirstValue())
				.matches()) {
	    			throw new Exception();
	    			
	    		} else if (Pattern.compile(".*\\.")
	    		.matcher(calcObject.getSecondValue())
	    		.matches()) {
	    			throw new Exception();
	    	    	
	    	    } else if (!calcObject.isFirstValueActive() && !calcObject.getSecondValue().equals("")) {
	    	    	String resultOfCounting = (calcObject.counting());
	    	    	System.out.println(resultOfCounting);
	    	    	calcObject = new Calculations();
	    	    	calcObject.setFirstValue(resultOfCounting);
	    	    	calcObject.setFirstValueAResult(true);
	    	    }
	    		
	    	} else if (buttValue.equals("C")) {
	    		calcObject = new Calculations();
	    		
	    	} else if (buttValue.equals(".")) {
	    		 if (!Pattern.compile("[^\\.]+\\.[^\\.]*")
	    				.matcher(calcObject.getFirstValue())
	    				.matches() 
	    				&& calcObject.isFirstValueActive()
	    				&& !calcObject.getFirstValue().equals("")
	    				&& !calcObject.getFirstValue().equals("-")) {
	    			calcObject.setFirstValue(calcObject.getFirstValue() + buttValue);
	    			
	    		} else if (!Pattern.compile("[^\\.]+\\.[^\\.]*")
	    				.matcher(calcObject.getSecondValue())
	    				.matches() 
	    				&& !calcObject.isFirstValueActive()
	    				&& !calcObject.getSecondValue().equals("")
	    				&& !calcObject.getSecondValue().equals("-")) {
	    			calcObject.setSecondValue(calcObject.getSecondValue() + buttValue);
	    		}
	    		
	    	} else if (buttValue.equals("+/-")) {
	    		if (calcObject.isFirstValueActive()) {
	    			calcObject.setFirstValue(calcObject.changeMinus(calcObject.getFirstValue()));
	    		} else {
	    			calcObject.setSecondValue(calcObject.changeMinus(calcObject.getSecondValue()));
	    		}
	    		
	    	} else if (buttValue.equals("√") && (!calcObject.getFirstValue().equals(""))) {
	    		if (Pattern.compile(".*\\.")
	    	    .matcher(calcObject.getFirstValue())
	    	    .matches()) {
	    			throw new Exception();
	    	    	    			
	    	    } else if (Pattern.compile(".*\\.")
	    	    .matcher(calcObject.getSecondValue())
	    	    .matches()) {
	    	    	throw new Exception();
	    	    	    	    	
	    	    } else if (calcObject.isFirstValueActive()
	    	    		|| (!calcObject.isFirstValueActive() && calcObject.getSecondValue().equals(""))) {
	    	    	String resultOfCounting = (calcObject.squareValues());
	    	    	calcObject = new Calculations();
	    	    	calcObject.setFirstValue(resultOfCounting);
	    	    	calcObject.setFirstValueAResult(true);
	    	    	
	    	    } else if (!calcObject.isFirstValueActive() && !calcObject.getSecondValue().equals("")) {
	    	    	String resultOfCounting = (calcObject.counting());
	    	    	calcObject = new Calculations();
	    	    	calcObject.setFirstValue(resultOfCounting);
	    	    	resultOfCounting = (calcObject.squareValues());
	    	    	System.out.println(resultOfCounting);
	    	    	calcObject = new Calculations();
	    	    	calcObject.setFirstValue(resultOfCounting);
	    	    	calcObject.setFirstValueAResult(true);
	    	    }
	    	
	    	} else if (Pattern.compile("[+-/*%]")
    				.matcher(buttValue)
    				.matches()
    				&& (!calcObject.getFirstValue().equals(""))) {
	    		calcObject.setFirstValueAResult(false);
	    		
	    		if (Pattern.compile(".*\\.")
	    		.matcher(calcObject.getFirstValue())
	    		.matches()) {
	    			throw new Exception();
	    	    			
	    	    } else if (Pattern.compile(".*\\.")
	    	    .matcher(calcObject.getSecondValue())
	    	    .matches()) {
	    	    	throw new Exception();
	    	    	
	    	    } else if (calcObject.isFirstValueActive()) {
	    	    	calcObject.setSign(buttValue);
	    	    	calcObject.setFirstValueActive(false);
	    			
	    		} else if (!calcObject.isFirstValueActive() && calcObject.getSecondValue().equals("")) {
	    			calcObject.setSign(buttValue);
	    			
	    		} else if (!calcObject.isFirstValueActive() && !calcObject.getSecondValue().equals("")) {
	    			String resultOfCounting = (calcObject.counting());
	    			calcObject = new Calculations();
	    			calcObject.setFirstValue(resultOfCounting);
	    			calcObject.setSign(buttValue);
	    			calcObject.setFirstValueActive(false);
	    			
	    		}
	    	}
	    } catch(Exception e) {
	    	e.printStackTrace();
	    	url = "/KeyboardErr.jsp";
	    }
	    
	    CalculationsVO vo = new CalculationsVO();
	    vo.setFirstValue(calcObject.getFirstValue());
	    vo.setSecondValue(calcObject.getSecondValue());
	    vo.setSign(calcObject.getSign());
	    vo.setFirstValueActive(calcObject.isFirstValueActive());
	    vo.setFirstValueAResult(calcObject.isFirstValueAResult());
	    
	    session.setAttribute("calcObject",calcObject);
		request.setAttribute("vo",vo);
		
		RequestDispatcher requestDispatcher =
			      getServletContext().getRequestDispatcher(url);
			    requestDispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
