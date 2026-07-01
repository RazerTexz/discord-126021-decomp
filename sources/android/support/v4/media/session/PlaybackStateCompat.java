package android.support.v4.media.session;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable$Creator;
import android.text.TextUtils;
import b.d.b.a.a;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
@SuppressLint({"BanParcelableUsage"})
public final class PlaybackStateCompat implements Parcelable {
    public static final Parcelable$Creator<PlaybackStateCompat> CREATOR = new PlaybackStateCompat$a();
    public final int j;
    public final long k;
    public final long l;
    public final float m;
    public final long n;
    public final int o;
    public final CharSequence p;
    public final long q;
    public List<PlaybackStateCompat$CustomAction> r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final long f21s;
    public final Bundle t;

    public PlaybackStateCompat(int i, long j, long j2, float f, long j3, int i2, CharSequence charSequence, long j4, List<PlaybackStateCompat$CustomAction> list, long j5, Bundle bundle) {
        this.j = i;
        this.k = j;
        this.l = j2;
        this.m = f;
        this.n = j3;
        this.o = i2;
        this.p = charSequence;
        this.q = j4;
        this.r = new ArrayList(list);
        this.f21s = j5;
        this.t = bundle;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("PlaybackState {");
        sb.append("state=");
        sb.append(this.j);
        sb.append(", position=");
        sb.append(this.k);
        sb.append(", buffered position=");
        sb.append(this.l);
        sb.append(", speed=");
        sb.append(this.m);
        sb.append(", updated=");
        sb.append(this.q);
        sb.append(", actions=");
        sb.append(this.n);
        sb.append(", error code=");
        sb.append(this.o);
        sb.append(", error message=");
        sb.append(this.p);
        sb.append(", custom actions=");
        sb.append(this.r);
        sb.append(", active item id=");
        return a.C(sb, this.f21s, "}");
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.j);
        parcel.writeLong(this.k);
        parcel.writeFloat(this.m);
        parcel.writeLong(this.q);
        parcel.writeLong(this.l);
        parcel.writeLong(this.n);
        TextUtils.writeToParcel(this.p, parcel, i);
        parcel.writeTypedList(this.r);
        parcel.writeLong(this.f21s);
        parcel.writeBundle(this.t);
        parcel.writeInt(this.o);
    }

    public PlaybackStateCompat(Parcel parcel) {
        this.j = parcel.readInt();
        this.k = parcel.readLong();
        this.m = parcel.readFloat();
        this.q = parcel.readLong();
        this.l = parcel.readLong();
        this.n = parcel.readLong();
        this.p = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.r = parcel.createTypedArrayList(PlaybackStateCompat$CustomAction.CREATOR);
        this.f21s = parcel.readLong();
        this.t = parcel.readBundle(MediaSessionCompat.class.getClassLoader());
        this.o = parcel.readInt();
    }
}
