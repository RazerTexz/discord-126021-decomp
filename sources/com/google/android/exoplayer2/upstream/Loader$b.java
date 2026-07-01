package com.google.android.exoplayer2.upstream;

import com.google.android.exoplayer2.upstream.Loader$e;
import java.io.IOException;

/* JADX INFO: loaded from: classes3.dex */
public interface Loader$b<T extends Loader$e> {
    void b(T t, long j, long j2, boolean z2);

    void d(T t, long j, long j2);

    Loader$c o(T t, long j, long j2, IOException iOException, int i);
}
