package p007b.p225i.p226a.p288f.p313h.p318e;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.signin.internal.zam;
import p007b.p225i.p226a.p288f.p299e.p300h.p301j.BinderC3294g0;
import p007b.p225i.p226a.p288f.p299e.p300h.p301j.RunnableC3298i0;
import p007b.p225i.p226a.p288f.p337l.p338b.AbstractBinderC4341f;

/* JADX INFO: renamed from: b.i.a.f.h.e.a */
/* JADX INFO: compiled from: com.google.android.gms:play-services-base@@17.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public class BinderC3477a extends Binder implements IInterface {
    public BinderC3477a(String str) {
        attachInterface(this, str);
    }

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return this;
    }

    @Override // android.os.Binder
    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        boolean zOnTransact;
        if (i > 16777215) {
            zOnTransact = super.onTransact(i, parcel, parcel2, i2);
        } else {
            parcel.enforceInterface(getInterfaceDescriptor());
            zOnTransact = false;
        }
        if (zOnTransact) {
            return true;
        }
        AbstractBinderC4341f abstractBinderC4341f = (AbstractBinderC4341f) this;
        switch (i) {
            case 3:
                break;
            case 4:
                break;
            case 5:
            default:
                return false;
            case 6:
                break;
            case 7:
                break;
            case 8:
                BinderC3294g0 binderC3294g0 = (BinderC3294g0) abstractBinderC4341f;
                binderC3294g0.f9415c.post(new RunnableC3298i0(binderC3294g0, (zam) C3478b.m4406a(parcel, zam.CREATOR)));
                break;
            case 9:
                break;
        }
        parcel2.writeNoException();
        return true;
    }
}
