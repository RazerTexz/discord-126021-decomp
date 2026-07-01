package com.google.android.gms.common.api.internal;

import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.util.Pair;
import b.d.b.a.a;
import b.i.a.f.e.h.h;
import b.i.a.f.e.h.i;
import b.i.a.f.h.e.c;
import com.google.android.gms.common.api.Status;

/* JADX INFO: compiled from: com.google.android.gms:play-services-base@@17.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public class BasePendingResult$a<R extends h> extends c {
    public BasePendingResult$a(Looper looper) {
        super(looper);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.os.Handler
    public void handleMessage(Message message) {
        int i = message.what;
        if (i != 1) {
            if (i != 2) {
                Log.wtf("BasePendingResult", a.g(45, "Don't know how to handle message: ", i), new Exception());
                return;
            } else {
                ((BasePendingResult) message.obj).e(Status.m);
                return;
            }
        }
        Pair pair = (Pair) message.obj;
        i iVar = (i) pair.first;
        h hVar = (h) pair.second;
        try {
            iVar.a(hVar);
        } catch (RuntimeException e) {
            BasePendingResult.h(hVar);
            throw e;
        }
    }
}
