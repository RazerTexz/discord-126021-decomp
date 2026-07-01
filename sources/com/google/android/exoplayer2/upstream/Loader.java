package com.google.android.exoplayer2.upstream;

import androidx.annotation.Nullable;
import b.i.a.c.f3.d;
import b.i.a.c.f3.e0;
import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* JADX INFO: loaded from: classes3.dex */
public final class Loader {
    public static final Loader$c a = new Loader$c(2, -9223372036854775807L, null);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Loader$c f2978b = new Loader$c(3, -9223372036854775807L, null);
    public final ExecutorService c;

    @Nullable
    public Loader$d<? extends Loader$e> d;

    @Nullable
    public IOException e;

    public Loader(String str) {
        String strConcat = str.length() != 0 ? "ExoPlayer:Loader:".concat(str) : new String("ExoPlayer:Loader:");
        int i = e0.a;
        this.c = Executors.newSingleThreadExecutor(new d(strConcat));
    }

    public static Loader$c a(boolean z2, long j) {
        return new Loader$c(z2 ? 1 : 0, j, null);
    }

    public boolean b() {
        return this.d != null;
    }
}
