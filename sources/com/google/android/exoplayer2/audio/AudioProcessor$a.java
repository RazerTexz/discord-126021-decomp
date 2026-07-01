package com.google.android.exoplayer2.audio;

import b.i.a.c.f3.e0;

/* JADX INFO: loaded from: classes3.dex */
public final class AudioProcessor$a {
    public static final AudioProcessor$a a = new AudioProcessor$a(-1, -1, -1);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f2914b;
    public final int c;
    public final int d;
    public final int e;

    public AudioProcessor$a(int i, int i2, int i3) {
        this.f2914b = i;
        this.c = i2;
        this.d = i3;
        this.e = e0.z(i3) ? e0.s(i3, i2) : -1;
    }

    public String toString() {
        int i = this.f2914b;
        int i2 = this.c;
        int i3 = this.d;
        StringBuilder sb = new StringBuilder(83);
        sb.append("AudioFormat[sampleRate=");
        sb.append(i);
        sb.append(", channelCount=");
        sb.append(i2);
        sb.append(", encoding=");
        sb.append(i3);
        sb.append(']');
        return sb.toString();
    }
}
