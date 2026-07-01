package com.google.android.exoplayer2.drm;

import androidx.annotation.Nullable;
import b.i.b.b.a;
import b.i.b.b.p;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes3.dex */
public class DefaultDrmSessionManager$e implements DefaultDrmSession$a {
    public final Set<DefaultDrmSession> a = new HashSet();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    public DefaultDrmSession f2933b;

    public void a(Exception exc, boolean z2) {
        this.f2933b = null;
        p pVarN = p.n(this.a);
        this.a.clear();
        a aVarP = pVarN.p();
        while (aVarP.hasNext()) {
            ((DefaultDrmSession) aVarP.next()).k(exc, z2 ? 1 : 3);
        }
    }
}
