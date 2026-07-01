package androidx.recyclerview.widget;

import android.os.Parcel;
import android.os.Parcelable$Creator;

/* JADX INFO: loaded from: classes.dex */
public class LinearLayoutManager$SavedState$1 implements Parcelable$Creator<LinearLayoutManager$SavedState> {
    @Override // android.os.Parcelable$Creator
    public /* bridge */ /* synthetic */ LinearLayoutManager$SavedState createFromParcel(Parcel parcel) {
        return createFromParcel(parcel);
    }

    @Override // android.os.Parcelable$Creator
    public /* bridge */ /* synthetic */ LinearLayoutManager$SavedState[] newArray(int i) {
        return newArray(i);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable$Creator
    public LinearLayoutManager$SavedState createFromParcel(Parcel parcel) {
        return new LinearLayoutManager$SavedState(parcel);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable$Creator
    public LinearLayoutManager$SavedState[] newArray(int i) {
        return new LinearLayoutManager$SavedState[i];
    }
}
