package androidx.browser.customtabs;

import android.net.Uri;
import android.os.Bundle;
import android.os.RemoteException;
import java.util.List;
import x.a.a.a;
import x.a.a.b$a;

/* JADX INFO: loaded from: classes.dex */
public class CustomTabsSession$MockSession extends b$a {
    @Override // x.a.a.b
    public Bundle extraCommand(String str, Bundle bundle) throws RemoteException {
        return null;
    }

    @Override // x.a.a.b
    public boolean mayLaunchUrl(a aVar, Uri uri, Bundle bundle, List<Bundle> list) throws RemoteException {
        return false;
    }

    @Override // x.a.a.b
    public boolean newSession(a aVar) throws RemoteException {
        return false;
    }

    @Override // x.a.a.b
    public boolean newSessionWithExtras(a aVar, Bundle bundle) throws RemoteException {
        return false;
    }

    @Override // x.a.a.b
    public int postMessage(a aVar, String str, Bundle bundle) throws RemoteException {
        return 0;
    }

    @Override // x.a.a.b
    public boolean receiveFile(a aVar, Uri uri, int i, Bundle bundle) throws RemoteException {
        return false;
    }

    @Override // x.a.a.b
    public boolean requestPostMessageChannel(a aVar, Uri uri) throws RemoteException {
        return false;
    }

    @Override // x.a.a.b
    public boolean requestPostMessageChannelWithExtras(a aVar, Uri uri, Bundle bundle) throws RemoteException {
        return false;
    }

    @Override // x.a.a.b
    public boolean updateVisuals(a aVar, Bundle bundle) throws RemoteException {
        return false;
    }

    @Override // x.a.a.b
    public boolean validateRelationship(a aVar, int i, Uri uri, Bundle bundle) throws RemoteException {
        return false;
    }

    @Override // x.a.a.b
    public boolean warmup(long j) throws RemoteException {
        return false;
    }
}
