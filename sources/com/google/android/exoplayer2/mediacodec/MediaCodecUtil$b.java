package com.google.android.exoplayer2.mediacodec;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import b.d.b.a.a;

/* JADX INFO: loaded from: classes3.dex */
public final class MediaCodecUtil$b {
    public final String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f2948b;
    public final boolean c;

    public MediaCodecUtil$b(String str, boolean z2, boolean z3) {
        this.a = str;
        this.f2948b = z2;
        this.c = z3;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || obj.getClass() != MediaCodecUtil$b.class) {
            return false;
        }
        MediaCodecUtil$b mediaCodecUtil$b = (MediaCodecUtil$b) obj;
        return TextUtils.equals(this.a, mediaCodecUtil$b.a) && this.f2948b == mediaCodecUtil$b.f2948b && this.c == mediaCodecUtil$b.c;
    }

    public int hashCode() {
        return ((a.m(this.a, 31, 31) + (this.f2948b ? 1231 : 1237)) * 31) + (this.c ? 1231 : 1237);
    }
}
