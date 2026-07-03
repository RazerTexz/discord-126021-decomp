package android.support.v4.media;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;
import p007b.p100d.p104b.p105a.C1643a;

/* JADX INFO: loaded from: classes.dex */
@SuppressLint({"BanParcelableUsage"})
public final class RatingCompat implements Parcelable {
    public static final Parcelable.Creator<RatingCompat> CREATOR = new C0019a();

    /* JADX INFO: renamed from: j */
    public final int f38j;

    /* JADX INFO: renamed from: k */
    public final float f39k;

    /* JADX INFO: renamed from: android.support.v4.media.RatingCompat$a */
    public class C0019a implements Parcelable.Creator<RatingCompat> {
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
        this.f38j = i;
        this.f39k = f;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return this.f38j;
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("Rating:style=");
        sbM833U.append(this.f38j);
        sbM833U.append(" rating=");
        float f = this.f39k;
        sbM833U.append(f < 0.0f ? "unrated" : String.valueOf(f));
        return sbM833U.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f38j);
        parcel.writeFloat(this.f39k);
    }
}
