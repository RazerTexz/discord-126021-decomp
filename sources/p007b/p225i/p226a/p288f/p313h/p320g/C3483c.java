package p007b.p225i.p226a.p288f.p313h.p320g;

import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: renamed from: b.i.a.f.h.g.c */
/* JADX INFO: compiled from: com.google.android.gms:play-services-basement@@17.6.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class C3483c {

    /* JADX INFO: renamed from: a */
    public static final /* synthetic */ int f9650a = 0;

    static {
        C3483c.class.getClassLoader();
    }

    /* JADX INFO: renamed from: a */
    public static <T extends Parcelable> T m4409a(Parcel parcel, Parcelable.Creator<T> creator) {
        if (parcel.readInt() == 0) {
            return null;
        }
        return creator.createFromParcel(parcel);
    }

    /* JADX INFO: renamed from: b */
    public static void m4410b(Parcel parcel, IInterface iInterface) {
        if (iInterface == null) {
            parcel.writeStrongBinder(null);
        } else {
            parcel.writeStrongBinder(iInterface.asBinder());
        }
    }
}
