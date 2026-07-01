package androidx.viewpager2.widget;

import android.os.Build$VERSION;
import android.os.Parcel;
import android.os.Parcelable$ClassLoaderCreator;

/* JADX INFO: loaded from: classes.dex */
public class ViewPager2$SavedState$1 implements Parcelable$ClassLoaderCreator<ViewPager2$SavedState> {
    @Override // android.os.Parcelable$Creator
    public /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        return createFromParcel(parcel);
    }

    @Override // android.os.Parcelable$Creator
    public /* bridge */ /* synthetic */ Object[] newArray(int i) {
        return newArray(i);
    }

    @Override // android.os.Parcelable$ClassLoaderCreator
    public /* bridge */ /* synthetic */ ViewPager2$SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
        return createFromParcel(parcel, classLoader);
    }

    @Override // android.os.Parcelable$Creator
    public ViewPager2$SavedState[] newArray(int i) {
        return new ViewPager2$SavedState[i];
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable$ClassLoaderCreator
    public ViewPager2$SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
        return Build$VERSION.SDK_INT >= 24 ? new ViewPager2$SavedState(parcel, classLoader) : new ViewPager2$SavedState(parcel);
    }

    @Override // android.os.Parcelable$Creator
    public ViewPager2$SavedState createFromParcel(Parcel parcel) {
        return createFromParcel(parcel, (ClassLoader) null);
    }
}
