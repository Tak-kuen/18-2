package product_181010;

import java.io.IOException;
import java.util.ArrayList;
import java.sql.*;

import javax.naming.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

/**
 * Servlet implementation class ProductServlet
 */
@WebServlet("/product")
public class ProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		session.setAttribute("productList", getList());
		request.getRequestDispatcher("Product_jsp_181010/Product.jsp").forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("Product_jsp_181010/Product.jsp").forward(request,response);
	}
	
	private ArrayList<ProductBean> getList() {
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
			String sql = "select * from product";
			pstmt=conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				ProductBean bean = new ProductBean();
				bean.setId(rs.getInt("id"));
				bean.setName(rs.getString("name"));
				bean.setInfo(rs.getString("info"));
				bean.setPrice(rs.getInt("price"));
				list.add(bean);
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
		return list;
	}	//getList()

}
