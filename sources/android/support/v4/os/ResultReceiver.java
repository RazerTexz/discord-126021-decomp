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
import x.a.b.c.IResultReceiver;

/* JADX INFO: loaded from: classes.dex */
@SuppressLint({"BanParcelableUsage"})
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class ResultReceiver implements Parcelable {
    public static final Parcelable.Creator<ResultReceiver> CREATOR = new a();
    public IResultReceiver j;

    public class a implements Parcelable.Creator<ResultReceiver> {
        @Override // android.os.Parcelable.Creator
        public ResultReceiver createFromParcel(Parcel parcel) {
            return new ResultReceiver(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public ResultReceiver[] newArray(int i) {
            return new ResultReceiver[i];
        }
    }

    public class b extends IResultReceiver.a {
        public b() {
        }

        @Override // x.a.b.c.IResultReceiver
        public void r0(int i, Bundle bundle) {
            Objects.requireNonNull(ResultReceiver.this);
            ResultReceiver.this.a(i, bundle);
        }
    }

    public ResultReceiver(Parcel parcel) {
        IResultReceiver c0444a;
        IBinder strongBinder = parcel.readStrongBinder();
        int i = IResultReceiver.a.a;
        if (strongBinder == null) {
            c0444a = null;
        } else {
            IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("android.support.v4.os.IResultReceiver");
            c0444a = (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof IResultReceiver)) ? new IResultReceiver.a.C0444a(strongBinder) : (IResultReceiver) iInterfaceQueryLocalInterface;
        }
        this.j = c0444a;
    }

    public void a(int i, Bundle bundle) {
    }

    public void b(int i, Bundle bundle) {
        IResultReceiver iResultReceiver = this.j;
        if (iResultReceiver != null) {
            try {
                iResultReceiver.r0(i, bundle);
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
                this.j = new b();
            }
            parcel.writeStrongBinder(this.j.asBinder());
        }
    }
}
