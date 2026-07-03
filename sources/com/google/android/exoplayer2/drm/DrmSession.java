package com.google.android.exoplayer2.drm;

import androidx.annotation.Nullable;
import java.io.IOException;
import java.util.UUID;
import p007b.p225i.p226a.p242c.p265v2.InterfaceC2954b;
import p007b.p225i.p226a.p242c.p266w2.InterfaceC2988s;

/* JADX INFO: loaded from: classes3.dex */
public interface DrmSession {

    public static class DrmSessionException extends IOException {
        public final int errorCode;

        public DrmSessionException(Throwable th, int i) {
            super(th);
            this.errorCode = i;
        }
    }

    /* JADX INFO: renamed from: a */
    void mo3606a(@Nullable InterfaceC2988s.a aVar);

    /* JADX INFO: renamed from: b */
    void mo3607b(@Nullable InterfaceC2988s.a aVar);

    /* JADX INFO: renamed from: c */
    UUID mo3608c();

    /* JADX INFO: renamed from: d */
    boolean mo3609d();

    /* JADX INFO: renamed from: e */
    boolean mo3610e(String str);

    @Nullable
    /* JADX INFO: renamed from: f */
    DrmSessionException mo3611f();

    @Nullable
    /* JADX INFO: renamed from: g */
    InterfaceC2954b mo3612g();

    int getState();
}
