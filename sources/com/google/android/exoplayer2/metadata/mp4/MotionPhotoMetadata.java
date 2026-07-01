package com.google.android.exoplayer2.metadata.mp4;

import android.os.Parcel;
import android.os.Parcelable$Creator;
import androidx.annotation.Nullable;
import b.i.a.c.j1;
import b.i.a.c.p1$b;
import b.i.a.c.z2.a;
import b.i.a.f.e.o.f;
import com.google.android.exoplayer2.metadata.Metadata$Entry;

/* JADX INFO: loaded from: classes3.dex */
public final class MotionPhotoMetadata implements Metadata$Entry {
    public static final Parcelable$Creator<MotionPhotoMetadata> CREATOR = new MotionPhotoMetadata$a();
    public final long j;
    public final long k;
    public final long l;
    public final long m;
    public final long n;

    public MotionPhotoMetadata(long j, long j2, long j3, long j4, long j5) {
        this.j = j;
        this.k = j2;
        this.l = j3;
        this.m = j4;
        this.n = j5;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || MotionPhotoMetadata.class != obj.getClass()) {
            return false;
        }
        MotionPhotoMetadata motionPhotoMetadata = (MotionPhotoMetadata) obj;
        return this.j == motionPhotoMetadata.j && this.k == motionPhotoMetadata.k && this.l == motionPhotoMetadata.l && this.m == motionPhotoMetadata.m && this.n == motionPhotoMetadata.n;
    }

    public int hashCode() {
        return f.v0(this.n) + ((f.v0(this.m) + ((f.v0(this.l) + ((f.v0(this.k) + ((f.v0(this.j) + 527) * 31)) * 31)) * 31)) * 31);
    }

    @Override // com.google.android.exoplayer2.metadata.Metadata$Entry
    public /* synthetic */ void n(p1$b p1_b) {
        a.c(this, p1_b);
    }

    @Override // com.google.android.exoplayer2.metadata.Metadata$Entry
    public /* synthetic */ byte[] o0() {
        return a.a(this);
    }

    public String toString() {
        long j = this.j;
        long j2 = this.k;
        long j3 = this.l;
        long j4 = this.m;
        long j5 = this.n;
        StringBuilder sbR = b.d.b.a.a.R(218, "Motion photo metadata: photoStartPosition=", j, ", photoSize=");
        sbR.append(j2);
        sbR.append(", photoPresentationTimestampUs=");
        sbR.append(j3);
        sbR.append(", videoStartPosition=");
        sbR.append(j4);
        sbR.append(", videoSize=");
        sbR.append(j5);
        return sbR.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.j);
        parcel.writeLong(this.k);
        parcel.writeLong(this.l);
        parcel.writeLong(this.m);
        parcel.writeLong(this.n);
    }

    @Override // com.google.android.exoplayer2.metadata.Metadata$Entry
    public /* synthetic */ j1 y() {
        return a.b(this);
    }

    public MotionPhotoMetadata(Parcel parcel, MotionPhotoMetadata$a motionPhotoMetadata$a) {
        this.j = parcel.readLong();
        this.k = parcel.readLong();
        this.l = parcel.readLong();
        this.m = parcel.readLong();
        this.n = parcel.readLong();
    }
}
