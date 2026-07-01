package android.support.v4.os;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable$Creator;
import android.os.RemoteException;
import androidx.annotation.RestrictTo;
import androidx.annotation.RestrictTo$Scope;
import x.a.b.c.a;
import x.a.b.c.a$a;
import x.a.b.c.a$a$a;

/* JADX INFO: loaded from: classes.dex */
@SuppressLint({"BanParcelableUsage"})
@RestrictTo({RestrictTo$Scope.LIBRARY_GROUP_PREFIX})
public class ResultReceiver implements Parcelable {
    public static final Parcelable$Creator<ResultReceiver> CREATOR = new ResultReceiver$a();
    public a j;

    public ResultReceiver(Parcel parcel) {
        a a_a_a;
        IBinder strongBinder = parcel.readStrongBinder();
        int i = a$a.a;
        if (strongBinder == null) {
            a_a_a = null;
        } else {
            IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("android.support.v4.os.IResultReceiver");
            a_a_a = (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof a)) ? new a$a$a(strongBinder) : (a) iInterfaceQueryLocalInterface;
        }
        this.j = a_a_a;
    }

    public void a(int i, Bundle bundle) {
    }

    public void b(int i, Bundle bundle) {
        a aVar = this.j;
        if (aVar != null) {
            try {
                aVar.r0(i, bundle);
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
            if (this.j == null) {
                this.j = new ResultReceiver$b(this);
            }
            parcel.writeStrongBinder(this.j.asBinder());
        }
    }
}
