package p007b.p225i.p226a.p288f.p313h.p328o;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: renamed from: b.i.a.f.h.o.b */
/* JADX INFO: loaded from: classes3.dex */
public class C3955b {

    /* JADX INFO: renamed from: a */
    public static final /* synthetic */ int f10492a = 0;

    static {
        C3955b.class.getClassLoader();
    }

    /* JADX INFO: renamed from: a */
    public static <T extends Parcelable> T m5436a(Parcel parcel, Parcelable.Creator<T> creator) {
        if (parcel.readInt() == 0) {
            return null;
        }
        return creator.createFromParcel(parcel);
    }
}
