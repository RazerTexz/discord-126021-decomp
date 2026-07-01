package com.google.android.exoplayer2.drm;

import androidx.annotation.Nullable;
import b.i.a.c.v2.CryptoConfig;
import b.i.a.c.w2.DrmSessionEventListener;
import java.io.IOException;
import java.util.UUID;

/* JADX INFO: loaded from: classes3.dex */
public interface DrmSession {

    public static class DrmSessionException extends IOException {
        public final int errorCode;

        public DrmSessionException(Throwable th, int i) {
            super(th);
            this.errorCode = i;
        }
    }

    void a(@Nullable DrmSessionEventListener.a aVar);

    void b(@Nullable DrmSessionEventListener.a aVar);

    UUID c();

    boolean d();

    boolean e(String str);

    @Nullable
    DrmSessionException f();

    @Nullable
    CryptoConfig g();

    int getState();
}
