package androidx.coordinatorlayout.widget;

import android.os.Parcel;
import android.os.Parcelable$ClassLoaderCreator;

/* JADX INFO: loaded from: classes.dex */
public class CoordinatorLayout$SavedState$1 implements Parcelable$ClassLoaderCreator<CoordinatorLayout$SavedState> {
    @Override // android.os.Parcelable$Creator
    public /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        return createFromParcel(parcel);
    }

    @Override // android.os.Parcelable$Creator
    public /* bridge */ /* synthetic */ Object[] newArray(int i) {
        return newArray(i);
    }

    @Override // android.os.Parcelable$ClassLoaderCreator
    public /* bridge */ /* synthetic */ CoordinatorLayout$SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
        return createFromParcel(parcel, classLoader);
    }

    @Override // android.os.Parcelable$Creator
    public CoordinatorLayout$SavedState[] newArray(int i) {
        return new CoordinatorLayout$SavedState[i];
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable$ClassLoaderCreator
    public CoordinatorLayout$SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
        return new CoordinatorLayout$SavedState(parcel, classLoader);
    }

    @Override // android.os.Parcelable$Creator
    public CoordinatorLayout$SavedState createFromParcel(Parcel parcel) {
        return new CoordinatorLayout$SavedState(parcel, null);
    }
}
