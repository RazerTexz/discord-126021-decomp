package com.google.android.flexbox;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable$Creator;
import b.d.b.a.a;

/* JADX INFO: loaded from: classes3.dex */
public class FlexboxLayoutManager$SavedState implements Parcelable {
    public static final Parcelable$Creator<FlexboxLayoutManager$SavedState> CREATOR = new FlexboxLayoutManager$SavedState$a();
    public int j;
    public int k;

    public FlexboxLayoutManager$SavedState() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        StringBuilder sbU = a.U("SavedState{mAnchorPosition=");
        sbU.append(this.j);
        sbU.append(", mAnchorOffset=");
        return a.A(sbU, this.k, '}');
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.j);
        parcel.writeInt(this.k);
    }

    public FlexboxLayoutManager$SavedState(Parcel parcel, FlexboxLayoutManager$a flexboxLayoutManager$a) {
        this.j = parcel.readInt();
        this.k = parcel.readInt();
    }

    public FlexboxLayoutManager$SavedState(FlexboxLayoutManager$SavedState flexboxLayoutManager$SavedState, FlexboxLayoutManager$a flexboxLayoutManager$a) {
        this.j = flexboxLayoutManager$SavedState.j;
        this.k = flexboxLayoutManager$SavedState.k;
    }
}
