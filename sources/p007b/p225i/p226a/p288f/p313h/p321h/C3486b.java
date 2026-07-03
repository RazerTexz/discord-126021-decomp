package p007b.p225i.p226a.p288f.p313h.p321h;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: renamed from: b.i.a.f.h.h.b */
/* JADX INFO: compiled from: com.google.firebase:firebase-dynamic-links@@19.1.1 */
/* JADX INFO: loaded from: classes3.dex */
public class C3486b {

    /* JADX INFO: renamed from: a */
    public static final /* synthetic */ int f9651a = 0;

    static {
        C3486b.class.getClassLoader();
    }

    /* JADX INFO: renamed from: a */
    public static <T extends Parcelable> T m4411a(Parcel parcel, Parcelable.Creator<T> creator) {
        if (parcel.readInt() == 0) {
            return null;
        }
        return creator.createFromParcel(parcel);
    }
}
