package x.a.a;

import android.net.Uri;
import android.os.Bundle;
import android.os.IInterface;
import android.os.RemoteException;
import java.util.List;

/* JADX INFO: compiled from: ICustomTabsService.java */
/* JADX INFO: loaded from: classes.dex */
public interface b extends IInterface {
    Bundle extraCommand(String str, Bundle bundle) throws RemoteException;

    boolean mayLaunchUrl(a aVar, Uri uri, Bundle bundle, List<Bundle> list) throws RemoteException;

    boolean newSession(a aVar) throws RemoteException;

    boolean newSessionWithExtras(a aVar, Bundle bundle) throws RemoteException;

    int postMessage(a aVar, String str, Bundle bundle) throws RemoteException;

    boolean receiveFile(a aVar, Uri uri, int i, Bundle bundle) throws RemoteException;

    boolean requestPostMessageChannel(a aVar, Uri uri) throws RemoteException;

    boolean requestPostMessageChannelWithExtras(a aVar, Uri uri, Bundle bundle) throws RemoteException;

    boolean updateVisuals(a aVar, Bundle bundle) throws RemoteException;

    boolean validateRelationship(a aVar, int i, Uri uri, Bundle bundle) throws RemoteException;

    boolean warmup(long j) throws RemoteException;
}
