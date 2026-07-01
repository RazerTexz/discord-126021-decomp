package androidx.room;

import android.os.IInterface;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes.dex */
public interface IMultiInstanceInvalidationCallback extends IInterface {
    void onInvalidation(String[] strArr) throws RemoteException;
}
