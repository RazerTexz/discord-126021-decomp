package androidx.fragment.app;

import android.os.Parcel;
import android.os.Parcelable$ClassLoaderCreator;

/* JADX INFO: loaded from: classes.dex */
public class Fragment$SavedState$1 implements Parcelable$ClassLoaderCreator<Fragment$SavedState> {
    @Override // android.os.Parcelable$Creator
    public /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        return createFromParcel(parcel);
    }

    @Override // android.os.Parcelable$Creator
    public /* bridge */ /* synthetic */ Object[] newArray(int i) {
        return newArray(i);
    }

    @Override // android.os.Parcelable$ClassLoaderCreator
    public /* bridge */ /* synthetic */ Fragment$SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
        return createFromParcel(parcel, classLoader);
    }

    @Override // android.os.Parcelable$Creator
    public Fragment$SavedState[] newArray(int i) {
        return new Fragment$SavedState[i];
    }

    @Override // android.os.Parcelable$Creator
    public Fragment$SavedState createFromParcel(Parcel parcel) {
        return new Fragment$SavedState(parcel, null);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable$ClassLoaderCreator
    public Fragment$SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
        return new Fragment$SavedState(parcel, classLoader);
    }
}
