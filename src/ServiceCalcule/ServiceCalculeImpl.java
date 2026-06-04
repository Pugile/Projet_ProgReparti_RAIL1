package ServiceCalcule;

import raytracer.Image;

import java.rmi.RemoteException;

public class ServiceCalculeImpl implements ServiceCalcule{
    @Override
    public Image calcule() throws RemoteException {
        return new byte[0];
    }
}
