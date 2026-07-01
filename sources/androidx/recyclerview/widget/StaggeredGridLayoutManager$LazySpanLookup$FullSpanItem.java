package androidx.recyclerview.widget;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable$Creator;
import b.d.b.a.a;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
@SuppressLint({"BanParcelableUsage"})
public class StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem implements Parcelable {
    public static final Parcelable$Creator<StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem> CREATOR = new StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem$1();
    public int mGapDir;
    public int[] mGapPerSpan;
    public boolean mHasUnwantedGapAfter;
    public int mPosition;

    public StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem(Parcel parcel) {
        this.mPosition = parcel.readInt();
        this.mGapDir = parcel.readInt();
        this.mHasUnwantedGapAfter = parcel.readInt() == 1;
        int i = parcel.readInt();
        if (i > 0) {
            int[] iArr = new int[i];
            this.mGapPerSpan = iArr;
            parcel.readIntArray(iArr);
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getGapForSpan(int i) {
        int[] iArr = this.mGapPerSpan;
        if (iArr == null) {
            return 0;
        }
        return iArr[i];
    }

    public String toString() {
        StringBuilder sbU = a.U("FullSpanItem{mPosition=");
        sbU.append(this.mPosition);
        sbU.append(", mGapDir=");
        sbU.append(this.mGapDir);
        sbU.append(", mHasUnwantedGapAfter=");
        sbU.append(this.mHasUnwantedGapAfter);
        sbU.append(", mGapPerSpan=");
        sbU.append(Arrays.toString(this.mGapPerSpan));
        sbU.append('}');
        return sbU.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.mPosition);
        parcel.writeInt(this.mGapDir);
        parcel.writeInt(this.mHasUnwantedGapAfter ? 1 : 0);
        int[] iArr = this.mGapPerSpan;
        if (iArr == null || iArr.length <= 0) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(iArr.length);
            parcel.writeIntArray(this.mGapPerSpan);
        }
    }

    public StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem() {
    }
}
