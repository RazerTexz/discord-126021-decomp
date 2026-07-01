package android.support.v4.media;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;
import b.d.b.a.outline;

/* JADX INFO: loaded from: classes.dex */
@SuppressLint({"BanParcelableUsage"})
public final class RatingCompat implements Parcelable {
    public static final Parcelable.Creator<RatingCompat> CREATOR = new a();
    public final int j;
    public final float k;

    public class a implements Parcelable.Creator<RatingCompat> {
        @Override // android.os.Parcelable.Creator
        public RatingCompat createFromParcel(Parcel parcel) {
            return new RatingCompat(parcel.readInt(), parcel.readFloat());
        }

        @Override // android.os.Parcelable.Creator
        public RatingCompat[] newArray(int i) {
            return new RatingCompat[i];
        }
    }

    public RatingCompat(int i, float f) {
        this.j = i;
        this.k = f;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return this.j;
    }

    public String toString() {
        StringBuilder sbU = outline.U("Rating:style=");
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
