
package kgn.connector;

import java.io.IOException;

import javax.annotation.Resource;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sap.cloud.account.TenantContext;
import com.sap.core.connectivity.api.authentication.AuthenticationHeader;
import com.sap.core.connectivity.api.authentication.AuthenticationHeaderProvider;
import com.sap.core.connectivity.api.configuration.ConnectivityConfiguration;
import com.sap.core.connectivity.api.configuration.DestinationConfiguration;

/**
 * Servlet implementation class CloudConnector
 */
 
@WebServlet("/")
public class CloudConnector extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Resource
	private TenantContext tenantContext;
	private static final int COPY_CONTENT_BUFFER_SIZE = 1024;
    private static final Logger LOGGER = LoggerFactory.getLogger(CloudConnector.class);
    private static final String ON_PREMISE_PROXY = "OnPremise";
    String proxyHost = null;
    int proxyPort;
    String url = null;
    HttpResponse resp = null;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CloudConnector() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String destinationName = request.getParameter("destName");
		if(destinationName == null){
			destinationName = "outbound-internet-destination";
		}
		
		DestinationConfiguration destconfig = null;
		
		try{
			
			Context context = new InitialContext();
			ConnectivityConfiguration config = (ConnectivityConfiguration)context.lookup("java:comp/env/connectivityConfiguration");
			destconfig = config.getConfiguration(destinationName);
			if(destconfig == null){
				 response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR,
	                        String.format("Destination %s is not found. Hint:"
	                                + " Make sure to have the destination configured.", destinationName));
	                return;
	        }
			url = destconfig.getProperty("URL");
			HttpClient httpClient = new DefaultHttpClient();
			
			/*Context ctx = new InitialContext();
            AuthenticationHeaderProvider authHeaderProvider = (AuthenticationHeaderProvider) ctx.lookup("java:comp/env/myAuthHeaderProvider");
            // retrieve the authorization header for application-to-application SSO
            AuthenticationHeader appToAppSSOHeader = authHeaderProvider.getAppToAppSSOHeader(url);*/
			
			HttpGet httpGet = new HttpGet(url);
		//	httpGet.addHeader(appToAppSSOHeader.getName(), appToAppSSOHeader.getValue());
			
			resp = httpClient.execute(httpGet);
			
			
		}catch(Exception ex){
			LOGGER.error(ex.getMessage());
		}
		
		
		
		LOGGER.info("==> "+tenantContext.getTenant().getAccount().getId());
		response.getWriter().println("Connector start==>"+tenantContext.getTenant().getAccount().getId()+"<==> "+destconfig+"=>url=>"+url+"<==>"+IOUtils.toString(resp.getEntity().getContent(),"UTF-8"));
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
