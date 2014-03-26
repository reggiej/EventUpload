package com.acnc.mm.util;

import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;
import javax.servlet.http.HttpServletResponse;

public class CacheControlPhaseListener implements PhaseListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1450696887052633432L;
	
	public PhaseId getPhaseId()
    {
        return PhaseId.RENDER_RESPONSE;
    }

	@Override
	public void afterPhase(PhaseEvent event) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void beforePhase(PhaseEvent event) {
		FacesContext facesContext = event.getFacesContext();
        HttpServletResponse response = (HttpServletResponse) facesContext
                .getExternalContext().getResponse();
        response.addHeader("Pragma", "no-cache");
        response.addHeader("Cache-Control", "no-cache");
        // Stronger according to blog comment below that references HTTP spec
        
        // some date in the past
        response.addHeader("Expires", "-1");
	}

	
}
