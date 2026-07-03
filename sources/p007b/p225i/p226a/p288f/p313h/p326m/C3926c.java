package p007b.p225i.p226a.p288f.p313h.p326m;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: renamed from: b.i.a.f.h.m.c */
/* JADX INFO: loaded from: classes3.dex */
public class C3926c {

    /* JADX INFO: renamed from: a */
    public static final /* synthetic */ int f10449a = 0;

    static {
        C3926c.class.getClassLoader();
    }

    /* JADX INFO: renamed from: a */
    public static <T extends Parcelable> T m5401a(Parcel parcel, Parcelable.Creator<T> creator) {
        if (parcel.readInt() == 0) {
            return null;
        }
        return creator.createFromParcel(parcel);
    }

    /* JADX INFO: renamed from: b */
    public static void m5402b(Parcel parcel, Parcelable parcelable) {
        if (parcelable == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcelable.writeToParcel(parcel, 0);
        }
    }
}
