package androidx.preference;

import android.os.Parcel;
import android.os.Parcelable$Creator;

/* JADX INFO: loaded from: classes.dex */
public class Preference$BaseSavedState$1 implements Parcelable$Creator<Preference$BaseSavedState> {
    @Override // android.os.Parcelable$Creator
    public /* bridge */ /* synthetic */ Preference$BaseSavedState createFromParcel(Parcel parcel) {
        return createFromParcel(parcel);
    }

    @Override // android.os.Parcelable$Creator
    public /* bridge */ /* synthetic */ Preference$BaseSavedState[] newArray(int i) {
        return newArray(i);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable$Creator
    public Preference$BaseSavedState createFromParcel(Parcel parcel) {
        return new Preference$BaseSavedState(parcel);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable$Creator
    public Preference$BaseSavedState[] newArray(int i) {
        return new Preference$BaseSavedState[i];
    }
}
