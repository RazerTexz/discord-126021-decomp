package android.support.v4.os;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import androidx.annotation.RestrictTo;
import java.util.Objects;
import p668x.p669a.p672b.p676c.InterfaceC13185a;

/* JADX INFO: loaded from: classes.dex */
@SuppressLint({"BanParcelableUsage"})
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class ResultReceiver implements Parcelable {
    public static final Parcelable.Creator<ResultReceiver> CREATOR = new C0030a();

    /* JADX INFO: renamed from: j */
    public InterfaceC13185a f74j;

    /* JADX INFO: renamed from: android.support.v4.os.ResultReceiver$a */
    public class C0030a implements Parcelable.Creator<ResultReceiver> {
        @Override // android.os.Parcelable.Creator
        public ResultReceiver createFromParcel(Parcel parcel) {
            return new ResultReceiver(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public ResultReceiver[] newArray(int i) {
            return new ResultReceiver[i];
        }
    }

    /* JADX INFO: renamed from: android.support.v4.os.ResultReceiver$b */
    public class BinderC0031b extends InterfaceC13185a.a {
        public BinderC0031b() {
        }

        @Override // p668x.p669a.p672b.p676c.InterfaceC13185a
        /* JADX INFO: renamed from: r0 */
        public void mo74r0(int i, Bundle bundle) {
            Objects.requireNonNull(ResultReceiver.this);
            ResultReceiver.this.mo4a(i, bundle);
        }
    }

    public ResultReceiver(Parcel parcel) {
        InterfaceC13185a c13362a;
        IBinder strongBinder = parcel.readStrongBinder();
        int i = InterfaceC13185a.a.f27948a;
        if (strongBinder == null) {
            c13362a = null;
        } else {
            IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("android.support.v4.os.IResultReceiver");
            c13362a = (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof InterfaceC13185a)) ? new InterfaceC13185a.a.C13362a(strongBinder) : (InterfaceC13185a) iInterfaceQueryLocalInterface;
        }
        this.f74j = c13362a;
    }

    /* JADX INFO: renamed from: a */
    public void mo4a(int i, Bundle bundle) {
    }

    /* JADX INFO: renamed from: b */
    public void m73b(int i, Bundle bundle) {
        InterfaceC13185a interfaceC13185a = this.f74j;
        if (interfaceC13185a != null) {
            try {
                interfaceC13185a.mo74r0(i, bundle);
            } catch (RemoteException unused) {
            }
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        synchronized (this) {
            if (this.f74j == null) {
                this.f74j = new BinderC0031b();
            }
            parcel.writeStrongBinder(this.f74j.asBinder());
        }
    }
}
