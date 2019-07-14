package mx.com.proyecti;

public class EmployeeSoapProxy implements mx.com.proyecti.EmployeeSoap {
  private String _endpoint = null;
  private mx.com.proyecti.EmployeeSoap employeeSoap = null;
  
  public EmployeeSoapProxy() {
    _initEmployeeSoapProxy();
  }
  
  public EmployeeSoapProxy(String endpoint) {
    _endpoint = endpoint;
    _initEmployeeSoapProxy();
  }
  
  private void _initEmployeeSoapProxy() {
    try {
      employeeSoap = (new mx.com.proyecti.EmployeeSoapServiceLocator()).getEmployeeSoapPort();
      if (employeeSoap != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)employeeSoap)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)employeeSoap)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (employeeSoap != null)
      ((javax.xml.rpc.Stub)employeeSoap)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public mx.com.proyecti.EmployeeSoap getEmployeeSoap() {
    if (employeeSoap == null)
      _initEmployeeSoapProxy();
    return employeeSoap;
  }
  
  public mx.com.proyecti.Employee update(int id, java.lang.String firstname, java.lang.String lastname, java.util.Calendar birthdate, double salary, java.lang.String username, java.lang.String password) throws java.rmi.RemoteException{
    if (employeeSoap == null)
      _initEmployeeSoapProxy();
    return employeeSoap.update(id, firstname, lastname, birthdate, salary, username, password);
  }
  
  public void delete(int id) throws java.rmi.RemoteException{
    if (employeeSoap == null)
      _initEmployeeSoapProxy();
    employeeSoap.delete(id);
  }
  
  public mx.com.proyecti.Employee read(int id) throws java.rmi.RemoteException{
    if (employeeSoap == null)
      _initEmployeeSoapProxy();
    return employeeSoap.read(id);
  }
  
  public mx.com.proyecti.Employee create(java.lang.String firstname, java.lang.String lastname, java.util.Calendar birthdate, double salary, java.lang.String username, java.lang.String password) throws java.rmi.RemoteException{
    if (employeeSoap == null)
      _initEmployeeSoapProxy();
    return employeeSoap.create(firstname, lastname, birthdate, salary, username, password);
  }
  
  public mx.com.proyecti.Employee[] readAll() throws java.rmi.RemoteException{
    if (employeeSoap == null)
      _initEmployeeSoapProxy();
    return employeeSoap.readAll();
  }
  
  
}