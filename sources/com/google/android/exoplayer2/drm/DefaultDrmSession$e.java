package com.google.android.exoplayer2.drm;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Pair;
import b.i.a.c.f3.e0;
import b.i.a.c.w2.a0;
import b.i.b.b.a;
import b.i.b.b.p;

/* JADX INFO: loaded from: classes3.dex */
@SuppressLint({"HandlerLeak"})
public class DefaultDrmSession$e extends Handler {
    public final /* synthetic */ DefaultDrmSession a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DefaultDrmSession$e(DefaultDrmSession defaultDrmSession, Looper looper) {
        super(looper);
        this.a = defaultDrmSession;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        Pair pair = (Pair) message.obj;
        Object obj = pair.first;
        Object obj2 = pair.second;
        int i = message.what;
        if (i == 0) {
            DefaultDrmSession defaultDrmSession = this.a;
            if (obj == defaultDrmSession.w) {
                if (defaultDrmSession.n == 2 || defaultDrmSession.j()) {
                    defaultDrmSession.w = null;
                    if (obj2 instanceof Exception) {
                        ((DefaultDrmSessionManager$e) defaultDrmSession.c).a((Exception) obj2, false);
                        return;
                    }
                    try {
                        defaultDrmSession.f2925b.j((byte[]) obj2);
                        DefaultDrmSessionManager$e defaultDrmSessionManager$e = (DefaultDrmSessionManager$e) defaultDrmSession.c;
                        defaultDrmSessionManager$e.f2933b = null;
                        p pVarN = p.n(defaultDrmSessionManager$e.a);
                        defaultDrmSessionManager$e.a.clear();
                        a aVarP = pVarN.p();
                        while (aVarP.hasNext()) {
                            DefaultDrmSession defaultDrmSession2 = (DefaultDrmSession) aVarP.next();
                            if (defaultDrmSession2.m()) {
                                defaultDrmSession2.i(true);
                            }
                        }
                        return;
                    } catch (Exception e) {
                        ((DefaultDrmSessionManager$e) defaultDrmSession.c).a(e, true);
                        return;
                    }
                }
                return;
            }
            return;
        }
        if (i != 1) {
            return;
        }
        DefaultDrmSession defaultDrmSession3 = this.a;
        if (obj == defaultDrmSession3.v && defaultDrmSession3.j()) {
            defaultDrmSession3.v = null;
            if (obj2 instanceof Exception) {
                defaultDrmSession3.l((Exception) obj2, false);
                return;
            }
            try {
                byte[] bArr = (byte[]) obj2;
                if (defaultDrmSession3.e == 3) {
                    a0 a0Var = defaultDrmSession3.f2925b;
                    byte[] bArr2 = defaultDrmSession3.u;
                    int i2 = e0.a;
                    a0Var.i(bArr2, bArr);
                    defaultDrmSession3.h(b.i.a.c.w2.a.a);
                    return;
                }
                byte[] bArrI = defaultDrmSession3.f2925b.i(defaultDrmSession3.t, bArr);
                int i3 = defaultDrmSession3.e;
                if ((i3 == 2 || (i3 == 0 && defaultDrmSession3.u != null)) && bArrI != null && bArrI.length != 0) {
                    defaultDrmSession3.u = bArrI;
                }
                defaultDrmSession3.n = 4;
                defaultDrmSession3.h(b.i.a.c.w2.p.a);
            } catch (Exception e2) {
                defaultDrmSession3.l(e2, true);
            }
        }
    }
}
