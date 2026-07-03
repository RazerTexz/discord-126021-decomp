package p007b.p225i.p226a.p288f.p299e.p304k;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.internal.zzi;
import java.util.Objects;
import p007b.p085c.p086a.p087a0.C1460d;
import p007b.p225i.p226a.p288f.p313h.p320g.BinderC3482b;
import p007b.p225i.p226a.p288f.p313h.p320g.C3483c;

/* JADX INFO: renamed from: b.i.a.f.e.k.a0 */
/* JADX INFO: compiled from: com.google.android.gms:play-services-basement@@17.6.0 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractBinderC3344a0 extends BinderC3482b implements InterfaceC3357h {
    public AbstractBinderC3344a0() {
        super("com.google.android.gms.common.internal.IGmsCallbacks");
    }

    @Override // p007b.p225i.p226a.p288f.p313h.p320g.BinderC3482b
    /* JADX INFO: renamed from: c */
    public final boolean mo4121c(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (i == 1) {
            ((BinderC3362j0) this).m4163g(parcel.readInt(), parcel.readStrongBinder(), (Bundle) C3483c.m4409a(parcel, Bundle.CREATOR));
        } else if (i == 2) {
            parcel.readInt();
            Log.wtf("GmsClient", "received deprecated onAccountValidationComplete callback, ignoring", new Exception());
        } else {
            if (i != 3) {
                return false;
            }
            int i3 = parcel.readInt();
            IBinder strongBinder = parcel.readStrongBinder();
            zzi zziVar = (zzi) C3483c.m4409a(parcel, zzi.CREATOR);
            BinderC3362j0 binderC3362j0 = (BinderC3362j0) this;
            AbstractC3345b abstractC3345b = binderC3362j0.f9529a;
            C1460d.m595z(abstractC3345b, "onPostInitCompleteWithConnectionInfo can be called only once per call togetRemoteService");
            Objects.requireNonNull(zziVar, "null reference");
            abstractC3345b.f9497v = zziVar;
            binderC3362j0.m4163g(i3, strongBinder, zziVar.f20555j);
        }
        parcel2.writeNoException();
        return true;
    }
}
