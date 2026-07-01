package com.google.android.exoplayer2.audio;

import android.os.SystemClock;
import androidx.annotation.Nullable;
import java.lang.Exception;

/* JADX INFO: loaded from: classes3.dex */
public final class DefaultAudioSink$f<T extends Exception> {

    @Nullable
    public T a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f2923b;

    public DefaultAudioSink$f(long j) {
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: T extends java.lang.Exception */
    public void a(T t) throws Exception {
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        if (this.a == null) {
            this.a = t;
            this.f2923b = 100 + jElapsedRealtime;
        }
        if (jElapsedRealtime >= this.f2923b) {
            T t2 = this.a;
            if (t2 != t) {
                t2.addSuppressed(t);
            }
            T t3 = this.a;
            this.a = null;
            throw t3;
        }
    }
}
