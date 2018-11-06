package product_181017;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import product_181010.ProductBean;

/**
 * Servlet implementation class ProductSearchServlet
 */
@WebServlet("/ProductSearchServlet")
public class ProductSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductSearchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getRequestDispatcher("Product_jsp_181017/productSearch.jsp").forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String name=request.getParameter("name");
		HttpSession session = request.getSession();
		session.setAttribute("productList", getList(name));
		request.getRequestDispatcher("Product_jsp_181017/productSearch.jsp").forward(request,response);
	}
	
	
	private ArrayList<ProductBean> getList(String name) {
		int count=0;
		ArrayList<ProductBean> list =null;
		Connection conn=null;
		PreparedStatement pstmt =null;
		ResultSet rs =null;	
		try {
			Context initCtx = new InitialContext();
			Context envCtx = (Context) initCtx.lookup("java:comp/env");
			DataSource ds = (DataSource) envCtx.lookup("jdbc/test");
			conn = ds.getConnection();
			
			list = new ArrayList<>();
			String sql = "select * from product ";
			pstmt=conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				if(name.equals(rs.getString("name"))) {
					ProductBean bean = new ProductBean();
					bean.setId(rs.getInt("id"));
					bean.setName(rs.getString("name"));
					bean.setInfo(rs.getString("info"));
					bean.setPrice(rs.getInt("price"));
					list.add(bean);
					count++;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(rs!=null){
				try{rs.close();}catch(SQLException sqle) {}
			}
			if(pstmt!=null){
				try{pstmt.close();}catch(SQLException sqle){}
			}
			if(conn!=null) {
				try{conn.close();} catch(SQLException sqle){}
			}
		}
		if(count==0) {
			list=null;
		}
		return list;
	}	//getList()

	

}
