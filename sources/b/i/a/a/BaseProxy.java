package b.i.a.a;

import android.os.IBinder;
import android.os.IInterface;

/* JADX INFO: renamed from: b.i.a.a.a, reason: use source file name */
/* JADX INFO: compiled from: BaseProxy.java */
/* JADX INFO: loaded from: classes3.dex */
public class BaseProxy implements IInterface {
    public final IBinder a;

    public BaseProxy(IBinder iBinder) {
        this.a = iBinder;
    }

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return this.a;
    }
}
