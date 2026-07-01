package androidx.recyclerview.widget;

import android.os.Parcel;
import android.os.Parcelable$Creator;

/* JADX INFO: loaded from: classes.dex */
public class StaggeredGridLayoutManager$SavedState$1 implements Parcelable$Creator<StaggeredGridLayoutManager$SavedState> {
    @Override // android.os.Parcelable$Creator
    public /* bridge */ /* synthetic */ StaggeredGridLayoutManager$SavedState createFromParcel(Parcel parcel) {
        return createFromParcel(parcel);
    }

    @Override // android.os.Parcelable$Creator
    public /* bridge */ /* synthetic */ StaggeredGridLayoutManager$SavedState[] newArray(int i) {
        return newArray(i);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable$Creator
    public StaggeredGridLayoutManager$SavedState createFromParcel(Parcel parcel) {
        return new StaggeredGridLayoutManager$SavedState(parcel);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable$Creator
    public StaggeredGridLayoutManager$SavedState[] newArray(int i) {
        return new StaggeredGridLayoutManager$SavedState[i];
    }
}
