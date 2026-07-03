package p007b.p225i.p226a.p288f.p313h.p325l;

import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: renamed from: b.i.a.f.h.l.v */
/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-base@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public class C3859v {

    /* JADX INFO: renamed from: a */
    public static final ClassLoader f10357a = C3859v.class.getClassLoader();

    /* JADX INFO: renamed from: a */
    public static <T extends Parcelable> T m5326a(Parcel parcel, Parcelable.Creator<T> creator) {
        if (parcel.readInt() == 0) {
            return null;
        }
        return creator.createFromParcel(parcel);
    }

    /* JADX INFO: renamed from: b */
    public static void m5327b(Parcel parcel, IInterface iInterface) {
        if (iInterface == null) {
            parcel.writeStrongBinder(null);
        } else {
            parcel.writeStrongBinder(iInterface.asBinder());
        }
    }

    /* JADX INFO: renamed from: c */
    public static void m5328c(Parcel parcel, Parcelable parcelable) {
        if (parcelable == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcelable.writeToParcel(parcel, 0);
        }
    }
}
