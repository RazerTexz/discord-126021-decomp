package androidx.fragment.app;

import android.os.Parcel;
import android.os.Parcelable$Creator;

/* JADX INFO: loaded from: classes.dex */
public class FragmentTabHost$SavedState$1 implements Parcelable$Creator<FragmentTabHost$SavedState> {
    @Override // android.os.Parcelable$Creator
    public /* bridge */ /* synthetic */ FragmentTabHost$SavedState createFromParcel(Parcel parcel) {
        return createFromParcel(parcel);
    }

    @Override // android.os.Parcelable$Creator
    public /* bridge */ /* synthetic */ FragmentTabHost$SavedState[] newArray(int i) {
        return newArray(i);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable$Creator
    public FragmentTabHost$SavedState createFromParcel(Parcel parcel) {
        return new FragmentTabHost$SavedState(parcel);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable$Creator
    public FragmentTabHost$SavedState[] newArray(int i) {
        return new FragmentTabHost$SavedState[i];
    }
}
