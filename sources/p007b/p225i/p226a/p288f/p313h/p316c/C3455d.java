package p007b.p225i.p226a.p288f.p313h.p316c;

import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: renamed from: b.i.a.f.h.c.d */
/* JADX INFO: compiled from: com.google.android.gms:play-services-auth@@19.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public class C3455d {
    static {
        C3455d.class.getClassLoader();
    }

    /* JADX INFO: renamed from: a */
    public static <T extends Parcelable> T m4396a(Parcel parcel, Parcelable.Creator<T> creator) {
        if (parcel.readInt() == 0) {
            return null;
        }
        return creator.createFromParcel(parcel);
    }

    /* JADX INFO: renamed from: b */
    public static void m4397b(Parcel parcel, IInterface iInterface) {
        if (iInterface == null) {
            parcel.writeStrongBinder(null);
        } else {
            parcel.writeStrongBinder(iInterface.asBinder());
        }
    }

    /* JADX INFO: renamed from: c */
    public static void m4398c(Parcel parcel, Parcelable parcelable) {
        if (parcelable == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcelable.writeToParcel(parcel, 0);
        }
    }
}
