package android.support.v4.media;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable$Creator;
import b.d.b.a.a;

/* JADX INFO: loaded from: classes.dex */
@SuppressLint({"BanParcelableUsage"})
public final class RatingCompat implements Parcelable {
    public static final Parcelable$Creator<RatingCompat> CREATOR = new RatingCompat$a();
    public final int j;
    public final float k;

    public RatingCompat(int i, float f) {
        this.j = i;
        this.k = f;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return this.j;
    }

    public String toString() {
        StringBuilder sbU = a.U("Rating:style=");
        sbU.append(this.j);
        sbU.append(" rating=");
        float f = this.k;
        sbU.append(f < 0.0f ? "unrated" : String.valueOf(f));
        return sbU.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.j);
        parcel.writeFloat(this.k);
    }
}
