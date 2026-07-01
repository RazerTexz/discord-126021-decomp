package androidx.versionedparcelable;

import android.os.Parcel;
import android.os.Parcelable$Creator;

/* JADX INFO: loaded from: classes.dex */
public class ParcelImpl$1 implements Parcelable$Creator<ParcelImpl> {
    @Override // android.os.Parcelable$Creator
    public /* bridge */ /* synthetic */ ParcelImpl createFromParcel(Parcel parcel) {
        return createFromParcel(parcel);
    }

    @Override // android.os.Parcelable$Creator
    public /* bridge */ /* synthetic */ ParcelImpl[] newArray(int i) {
        return newArray(i);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable$Creator
    public ParcelImpl createFromParcel(Parcel parcel) {
        return new ParcelImpl(parcel);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable$Creator
    public ParcelImpl[] newArray(int i) {
        return new ParcelImpl[i];
    }
}
