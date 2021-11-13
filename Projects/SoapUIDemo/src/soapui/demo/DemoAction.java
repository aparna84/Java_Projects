package soapui.demo;

import com.eviware.soapui.model.ModelItem;
import com.eviware.soapui.support.UISupport;
import com.eviware.soapui.support.action.support.AbstractSoapUIAction;

public class DemoAction extends AbstractSoapUIAction
{
  public DemoAction()
  {
    super( "Demo Action", "Demonstrates an extension to soapUI" );
  }
  
  @Override
  public void perform( ModelItem target, Object param )
  {
    UISupport.showInfoMessage( "Welcome to my action in project [" + target.getName() + "]" );
  }

}