package x.a.a;

import android.os.Bundle;
import android.os.IInterface;
import android.os.RemoteException;

/* JADX INFO: compiled from: IPostMessageService.java */
/* JADX INFO: loaded from: classes.dex */
public interface c extends IInterface {
    void onMessageChannelReady(a aVar, Bundle bundle) throws RemoteException;

    void onPostMessage(a aVar, String str, Bundle bundle) throws RemoteException;
}
