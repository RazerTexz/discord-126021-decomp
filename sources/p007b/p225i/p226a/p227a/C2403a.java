package p007b.p225i.p226a.p227a;

import android.os.IBinder;
import android.os.IInterface;

/* JADX INFO: renamed from: b.i.a.a.a */
/* JADX INFO: compiled from: BaseProxy.java */
/* JADX INFO: loaded from: classes3.dex */
public class C2403a implements IInterface {

    /* JADX INFO: renamed from: a */
    public final IBinder f5114a;

    public C2403a(IBinder iBinder) {
        this.f5114a = iBinder;
    }

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return this.f5114a;
    }
}
