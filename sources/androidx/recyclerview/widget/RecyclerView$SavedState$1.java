package androidx.recyclerview.widget;

import android.os.Parcel;
import android.os.Parcelable$ClassLoaderCreator;

/* JADX INFO: loaded from: classes.dex */
public class RecyclerView$SavedState$1 implements Parcelable$ClassLoaderCreator<RecyclerView$SavedState> {
    @Override // android.os.Parcelable$Creator
    public /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        return createFromParcel(parcel);
    }

    @Override // android.os.Parcelable$Creator
    public /* bridge */ /* synthetic */ Object[] newArray(int i) {
        return newArray(i);
    }

    @Override // android.os.Parcelable$ClassLoaderCreator
    public /* bridge */ /* synthetic */ RecyclerView$SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
        return createFromParcel(parcel, classLoader);
    }

    @Override // android.os.Parcelable$Creator
    public RecyclerView$SavedState[] newArray(int i) {
        return new RecyclerView$SavedState[i];
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable$ClassLoaderCreator
    public RecyclerView$SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
        return new RecyclerView$SavedState(parcel, classLoader);
    }

    @Override // android.os.Parcelable$Creator
    public RecyclerView$SavedState createFromParcel(Parcel parcel) {
        return new RecyclerView$SavedState(parcel, null);
    }
}
