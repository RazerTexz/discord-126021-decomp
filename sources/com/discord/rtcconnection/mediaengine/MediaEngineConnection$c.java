package com.discord.rtcconnection.mediaengine;

import b.d.b.a.a;

/* JADX INFO: compiled from: MediaEngineConnection.kt */
/* JADX INFO: loaded from: classes.dex */
public final class MediaEngineConnection$c {
    public final int a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f2800b;
    public final int c;
    public final boolean d;
    public final boolean e;
    public final int f;

    public MediaEngineConnection$c() {
        this(0, 0, 0, false, false, 0, 63);
    }

    public MediaEngineConnection$c(int i, int i2, int i3, boolean z2, boolean z3, int i4) {
        this.a = i;
        this.f2800b = i2;
        this.c = i3;
        this.d = z2;
        this.e = z3;
        this.f = i4;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MediaEngineConnection$c)) {
            return false;
        }
        MediaEngineConnection$c mediaEngineConnection$c = (MediaEngineConnection$c) obj;
        return this.a == mediaEngineConnection$c.a && this.f2800b == mediaEngineConnection$c.f2800b && this.c == mediaEngineConnection$c.c && this.d == mediaEngineConnection$c.d && this.e == mediaEngineConnection$c.e && this.f == mediaEngineConnection$c.f;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v6, types: [int] */
    /* JADX WARN: Type inference failed for: r0v8, types: [int] */
    /* JADX WARN: Type inference failed for: r1v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARN: Type inference failed for: r1v7 */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v2 */
    public int hashCode() {
        int i = ((((this.a * 31) + this.f2800b) * 31) + this.c) * 31;
        boolean z2 = this.d;
        ?? r1 = z2;
        if (z2) {
            r1 = 1;
        }
        int i2 = (i + r1) * 31;
        boolean z3 = this.e;
        return ((i2 + (z3 ? 1 : z3)) * 31) + this.f;
    }

    public String toString() {
        StringBuilder sbU = a.U("InputModeOptions(vadThreshold=");
        sbU.append(this.a);
        sbU.append(", vadLeadingFrames=");
        sbU.append(this.f2800b);
        sbU.append(", vadTrailingFrames=");
        sbU.append(this.c);
        sbU.append(", vadAutoThreshold=");
        sbU.append(this.d);
        sbU.append(", vadUseKrisp=");
        sbU.append(this.e);
        sbU.append(", pttReleaseDelayMs=");
        return a.B(sbU, this.f, ")");
    }

    public MediaEngineConnection$c(int i, int i2, int i3, boolean z2, boolean z3, int i4, int i5) {
        i = (i5 & 1) != 0 ? 0 : i;
        i2 = (i5 & 2) != 0 ? 10 : i2;
        i3 = (i5 & 4) != 0 ? 40 : i3;
        z2 = (i5 & 8) != 0 ? true : z2;
        z3 = (i5 & 16) != 0 ? true : z3;
        i4 = (i5 & 32) != 0 ? 5 : i4;
        this.a = i;
        this.f2800b = i2;
        this.c = i3;
        this.d = z2;
        this.e = z3;
        this.f = i4;
    }
}
