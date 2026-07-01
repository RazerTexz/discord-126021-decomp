package com.google.android.exoplayer2.drm;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import b.i.a.c.f3.e0;
import java.util.Arrays;

/* JADX INFO: loaded from: classes3.dex */
@SuppressLint({"HandlerLeak"})
public class DefaultDrmSessionManager$c extends Handler {
    public final /* synthetic */ DefaultDrmSessionManager a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DefaultDrmSessionManager$c(DefaultDrmSessionManager defaultDrmSessionManager, Looper looper) {
        super(looper);
        this.a = defaultDrmSessionManager;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        byte[] bArr = (byte[]) message.obj;
        if (bArr == null) {
            return;
        }
        for (DefaultDrmSession defaultDrmSession : this.a.m) {
            if (Arrays.equals(defaultDrmSession.t, bArr)) {
                if (message.what == 2 && defaultDrmSession.e == 0 && defaultDrmSession.n == 4) {
                    int i = e0.a;
                    defaultDrmSession.i(false);
                    return;
                }
                return;
            }
        }
    }
}
