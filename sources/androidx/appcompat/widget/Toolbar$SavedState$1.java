package androidx.appcompat.widget;

import android.os.Parcel;
import android.os.Parcelable$ClassLoaderCreator;

/* JADX INFO: loaded from: classes.dex */
public class Toolbar$SavedState$1 implements Parcelable$ClassLoaderCreator<Toolbar$SavedState> {
    @Override // android.os.Parcelable$Creator
    public /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        return createFromParcel(parcel);
    }

    @Override // android.os.Parcelable$Creator
    public /* bridge */ /* synthetic */ Object[] newArray(int i) {
        return newArray(i);
    }

    @Override // android.os.Parcelable$ClassLoaderCreator
    public /* bridge */ /* synthetic */ Toolbar$SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
        return createFromParcel(parcel, classLoader);
    }

    @Override // android.os.Parcelable$Creator
    public Toolbar$SavedState[] newArray(int i) {
        return new Toolbar$SavedState[i];
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable$ClassLoaderCreator
    public Toolbar$SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
        return new Toolbar$SavedState(parcel, classLoader);
    }

    @Override // android.os.Parcelable$Creator
    public Toolbar$SavedState createFromParcel(Parcel parcel) {
        return new Toolbar$SavedState(parcel, null);
    }
}
