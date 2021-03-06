/**    
 *   Copyright (c) 2014 Zuora, Inc.
 *
 *   Permission is hereby granted, free of charge, to any person obtaining a copy of 
 *   this software and associated documentation files (the "Software"), to use copy, 
 *   modify, merge, publish the Software and to distribute, and sublicense copies of 
 *   the Software, provided no fee is charged for the Software.  In addition the
 *   rights specified above are conditioned upon the following:
 *
 *   The above copyright notice and this permission notice shall be included in all
 *   copies or substantial portions of the Software.
 *
 *   Zuora, Inc. or any other trademarks of Zuora, Inc.  may not be used to endorse
 *   or promote products derived from this Software without specific prior written
 *   permission from Zuora, Inc.
 *
 *   THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 *   IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 *   FITNESS FOR A PARTICULAR PURPOSE AND NON-INFRINGEMENT. IN NO EVENT SHALL
 *   ZUORA, INC. BE LIABLE FOR ANY DIRECT, INDIRECT OR CONSEQUENTIAL DAMAGES
 *   (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 *   LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON
 *   ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 *   (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 *   SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package com.zuora.demo.hosted.lite;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.zuora.hosted.lite.util.HPMHelper;

/**
 * LoadConfigurationListener is a servlet context listener, and will load HPM configuration file when the web application starts. 
 * 
 * @author Tony.Liu, Chunyu.Jia. 
 */
public class LoadConfigurationListener implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent sce) {				
	}

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		try {	
			String webinfRealPath = sce.getServletContext().getRealPath("WEB-INF");
			HPMHelper.loadConfiguration(webinfRealPath + (String)sce.getServletContext().getInitParameter("zuora.hpm.configuration"));
		} catch (Exception e) {
			// TODO: Error handling code should be added here.
			
			System.out.println("Could not load HPM configuration file.");
			
			e.printStackTrace();
		}
	}
}
