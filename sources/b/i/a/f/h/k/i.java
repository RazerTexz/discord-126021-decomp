package b.i.a.f.h.k;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable$Creator;

/* JADX INFO: compiled from: com.google.firebase:firebase-appindexing@@19.1.0 */
/* JADX INFO: loaded from: classes3.dex */
public class i {
    public static final /* synthetic */ int a = 0;

    static {
        i.class.getClassLoader();
    }

    public static <T extends Parcelable> T a(Parcel parcel, Parcelable$Creator<T> parcelable$Creator) {
        if (parcel.readInt() == 0) {
            return null;
        }
        return parcelable$Creator.createFromParcel(parcel);
    }
}
