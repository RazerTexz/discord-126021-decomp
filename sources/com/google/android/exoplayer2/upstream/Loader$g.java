package com.google.android.exoplayer2.upstream;

import b.i.a.c.a3.e0;
import b.i.a.c.a3.h0;
import b.i.a.c.a3.m;
import b.i.a.c.x2.h;
import com.google.android.exoplayer2.drm.DrmSession;

/* JADX INFO: loaded from: classes3.dex */
public final class Loader$g implements Runnable {
    public final Loader$f j;

    public Loader$g(Loader$f loader$f) {
        this.j = loader$f;
    }

    @Override // java.lang.Runnable
    public void run() {
        e0 e0Var = (e0) this.j;
        for (h0 h0Var : e0Var.D) {
            h0Var.s(true);
            DrmSession drmSession = h0Var.i;
            if (drmSession != null) {
                drmSession.b(h0Var.e);
                h0Var.i = null;
                h0Var.h = null;
            }
        }
        m mVar = (m) e0Var.w;
        h hVar = mVar.f828b;
        if (hVar != null) {
            hVar.release();
            mVar.f828b = null;
        }
        mVar.c = null;
    }
}
