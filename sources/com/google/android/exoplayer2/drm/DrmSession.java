package com.google.android.exoplayer2.drm;

import androidx.annotation.Nullable;
import b.i.a.c.v2.b;
import b.i.a.c.w2.s$a;
import java.util.UUID;

/* JADX INFO: loaded from: classes3.dex */
public interface DrmSession {
    void a(@Nullable s$a s_a);

    void b(@Nullable s$a s_a);

    UUID c();

    boolean d();

    boolean e(String str);

    @Nullable
    DrmSession$DrmSessionException f();

    @Nullable
    b g();

    int getState();
}
