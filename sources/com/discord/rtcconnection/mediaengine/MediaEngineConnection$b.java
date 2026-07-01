package com.discord.rtcconnection.mediaengine;

import b.d.b.a.a;

/* JADX INFO: compiled from: MediaEngineConnection.kt */
/* JADX INFO: loaded from: classes.dex */
public final class MediaEngineConnection$b {
    public final int a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f2799b;
    public final int c;
    public final int d;
    public final int e;
    public final int f;

    public MediaEngineConnection$b(int i, int i2, int i3, int i4, int i5, int i6) {
        this.a = i;
        this.f2799b = i2;
        this.c = i3;
        this.d = i4;
        this.e = i5;
        this.f = i6;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MediaEngineConnection$b)) {
            return false;
        }
        MediaEngineConnection$b mediaEngineConnection$b = (MediaEngineConnection$b) obj;
        return this.a == mediaEngineConnection$b.a && this.f2799b == mediaEngineConnection$b.f2799b && this.c == mediaEngineConnection$b.c && this.d == mediaEngineConnection$b.d && this.e == mediaEngineConnection$b.e && this.f == mediaEngineConnection$b.f;
    }

    public int hashCode() {
        return (((((((((this.a * 31) + this.f2799b) * 31) + this.c) * 31) + this.d) * 31) + this.e) * 31) + this.f;
    }

    public String toString() {
        StringBuilder sbU = a.U("EncodingQuality(minBitrate=");
        sbU.append(this.a);
        sbU.append(", maxBitrate=");
        sbU.append(this.f2799b);
        sbU.append(", width=");
        sbU.append(this.c);
        sbU.append(", height=");
        sbU.append(this.d);
        sbU.append(", mutedFramerate=");
        sbU.append(this.e);
        sbU.append(", framerate=");
        return a.B(sbU, this.f, ")");
    }
}
