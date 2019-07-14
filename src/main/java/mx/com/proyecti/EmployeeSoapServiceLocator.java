/**
 * EmployeeSoapServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package mx.com.proyecti;

public class EmployeeSoapServiceLocator extends org.apache.axis.client.Service implements mx.com.proyecti.EmployeeSoapService {

    public EmployeeSoapServiceLocator() {
    }


    public EmployeeSoapServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public EmployeeSoapServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for EmployeeSoapPort
    private java.lang.String EmployeeSoapPort_address = "http://localhost:8081/employee/webService";

    public java.lang.String getEmployeeSoapPortAddress() {
        return EmployeeSoapPort_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String EmployeeSoapPortWSDDServiceName = "EmployeeSoapPort";

    public java.lang.String getEmployeeSoapPortWSDDServiceName() {
        return EmployeeSoapPortWSDDServiceName;
    }

    public void setEmployeeSoapPortWSDDServiceName(java.lang.String name) {
        EmployeeSoapPortWSDDServiceName = name;
    }

    public mx.com.proyecti.EmployeeSoap getEmployeeSoapPort() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(EmployeeSoapPort_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getEmployeeSoapPort(endpoint);
    }

    public mx.com.proyecti.EmployeeSoap getEmployeeSoapPort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            mx.com.proyecti.EmployeeSoapPortBindingStub _stub = new mx.com.proyecti.EmployeeSoapPortBindingStub(portAddress, this);
            _stub.setPortName(getEmployeeSoapPortWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setEmployeeSoapPortEndpointAddress(java.lang.String address) {
        EmployeeSoapPort_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (mx.com.proyecti.EmployeeSoap.class.isAssignableFrom(serviceEndpointInterface)) {
                mx.com.proyecti.EmployeeSoapPortBindingStub _stub = new mx.com.proyecti.EmployeeSoapPortBindingStub(new java.net.URL(EmployeeSoapPort_address), this);
                _stub.setPortName(getEmployeeSoapPortWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("EmployeeSoapPort".equals(inputPortName)) {
            return getEmployeeSoapPort();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://proyecti.com.mx/", "EmployeeSoapService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://proyecti.com.mx/", "EmployeeSoapPort"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("EmployeeSoapPort".equals(portName)) {
            setEmployeeSoapPortEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
