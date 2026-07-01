package androidx.slidingpanelayout.widget;

import android.os.Parcel;
import android.os.Parcelable$ClassLoaderCreator;

/* JADX INFO: loaded from: classes.dex */
public class SlidingPaneLayout$SavedState$1 implements Parcelable$ClassLoaderCreator<SlidingPaneLayout$SavedState> {
    @Override // android.os.Parcelable$Creator
    public /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        return createFromParcel(parcel);
    }

    @Override // android.os.Parcelable$Creator
    public /* bridge */ /* synthetic */ Object[] newArray(int i) {
        return newArray(i);
    }

    @Override // android.os.Parcelable$ClassLoaderCreator
    public /* bridge */ /* synthetic */ SlidingPaneLayout$SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
        return createFromParcel(parcel, classLoader);
    }

    @Override // android.os.Parcelable$Creator
    public SlidingPaneLayout$SavedState[] newArray(int i) {
        return new SlidingPaneLayout$SavedState[i];
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable$ClassLoaderCreator
    public SlidingPaneLayout$SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
        return new SlidingPaneLayout$SavedState(parcel, null);
    }

    @Override // android.os.Parcelable$Creator
    public SlidingPaneLayout$SavedState createFromParcel(Parcel parcel) {
        return new SlidingPaneLayout$SavedState(parcel, null);
    }
}
