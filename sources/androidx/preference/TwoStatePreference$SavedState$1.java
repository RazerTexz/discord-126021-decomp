package androidx.preference;

import android.os.Parcel;
import android.os.Parcelable$Creator;

/* JADX INFO: loaded from: classes.dex */
public class TwoStatePreference$SavedState$1 implements Parcelable$Creator<TwoStatePreference$SavedState> {
    @Override // android.os.Parcelable$Creator
    public /* bridge */ /* synthetic */ TwoStatePreference$SavedState createFromParcel(Parcel parcel) {
        return createFromParcel(parcel);
    }

    @Override // android.os.Parcelable$Creator
    public /* bridge */ /* synthetic */ TwoStatePreference$SavedState[] newArray(int i) {
        return newArray(i);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable$Creator
    public TwoStatePreference$SavedState createFromParcel(Parcel parcel) {
        return new TwoStatePreference$SavedState(parcel);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable$Creator
    public TwoStatePreference$SavedState[] newArray(int i) {
        return new TwoStatePreference$SavedState[i];
    }
}
