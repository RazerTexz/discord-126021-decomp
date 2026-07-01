package com.google.android.exoplayer2.drm;

import android.os.Handler;
import androidx.annotation.Nullable;
import b.i.a.c.f3.e0;
import b.i.a.c.w2.d;
import b.i.a.c.w2.s$a;
import b.i.a.c.w2.u$b;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
public class DefaultDrmSessionManager$d implements u$b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    public final s$a f2932b;

    @Nullable
    public DrmSession c;
    public boolean d;
    public final /* synthetic */ DefaultDrmSessionManager e;

    public DefaultDrmSessionManager$d(@Nullable DefaultDrmSessionManager defaultDrmSessionManager, s$a s_a) {
        this.e = defaultDrmSessionManager;
        this.f2932b = s_a;
    }

    @Override // b.i.a.c.w2.u$b
    public void release() {
        Handler handler = this.e.u;
        Objects.requireNonNull(handler);
        e0.E(handler, new d(this));
    }
}
