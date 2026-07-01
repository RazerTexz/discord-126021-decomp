package b.i.a.f.h.n;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable$Creator;

/* JADX INFO: compiled from: com.android.billingclient:billing@@4.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class g {
    public static final /* synthetic */ int a = 0;

    static {
        g.class.getClassLoader();
    }

    public static <T extends Parcelable> T a(Parcel parcel, Parcelable$Creator<T> parcelable$Creator) {
        if (parcel.readInt() == 0) {
            return null;
        }
        return parcelable$Creator.createFromParcel(parcel);
    }
}
