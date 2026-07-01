package b.i.a.c.x2.i0;

import androidx.annotation.Nullable;
import b.i.a.c.Format2;

/* JADX INFO: renamed from: b.i.a.c.x2.i0.m, reason: use source file name */
/* JADX INFO: compiled from: Track.java */
/* JADX INFO: loaded from: classes3.dex */
public final class Track {
    public final int a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f1230b;
    public final long c;
    public final long d;
    public final long e;
    public final Format2 f;
    public final int g;

    @Nullable
    public final long[] h;

    @Nullable
    public final long[] i;
    public final int j;

    @Nullable
    public final TrackEncryptionBox[] k;

    public Track(int i, int i2, long j, long j2, long j3, Format2 format2, int i3, @Nullable TrackEncryptionBox[] trackEncryptionBoxArr, int i4, @Nullable long[] jArr, @Nullable long[] jArr2) {
        this.a = i;
        this.f1230b = i2;
        this.c = j;
        this.d = j2;
        this.e = j3;
        this.f = format2;
        this.g = i3;
        this.k = trackEncryptionBoxArr;
        this.j = i4;
        this.h = jArr;
        this.i = jArr2;
    }

    @Nullable
    public TrackEncryptionBox a(int i) {
        TrackEncryptionBox[] trackEncryptionBoxArr = this.k;
        if (trackEncryptionBoxArr == null) {
            return null;
        }
        return trackEncryptionBoxArr[i];
    }
}
