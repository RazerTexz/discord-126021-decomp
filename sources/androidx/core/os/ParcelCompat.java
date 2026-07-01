package androidx.core.os;

import android.os.Parcel;
import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes.dex */
public final class ParcelCompat {
    private ParcelCompat() {
    }

    public static boolean readBoolean(@NonNull Parcel parcel) {
        return parcel.readInt() != 0;
    }

    public static void writeBoolean(@NonNull Parcel parcel, boolean z2) {
        parcel.writeInt(z2 ? 1 : 0);
    }
}
