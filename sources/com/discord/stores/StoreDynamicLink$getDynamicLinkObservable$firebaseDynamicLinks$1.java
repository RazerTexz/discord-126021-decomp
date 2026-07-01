package com.discord.stores;

import android.content.Intent;
import android.net.Uri;
import androidx.core.app.NotificationCompat;
import b.i.c.c;
import b.i.c.o.a;
import rx.Emitter;
import rx.functions.Action1;

/* JADX INFO: compiled from: StoreDynamicLink.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreDynamicLink$getDynamicLinkObservable$firebaseDynamicLinks$1<T> implements Action1<Emitter<Uri>> {
    public final /* synthetic */ Intent $intent;

    public StoreDynamicLink$getDynamicLinkObservable$firebaseDynamicLinks$1(Intent intent) {
        this.$intent = intent;
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final void call2(Emitter<Uri> emitter) {
        a aVar;
        synchronized (a.class) {
            c cVarB = c.b();
            synchronized (a.class) {
                cVarB.a();
                aVar = (a) cVarB.g.a(a.class);
            }
            aVar.a(this.$intent).d(new StoreDynamicLink$sam$com_google_android_gms_tasks_OnFailureListener$0(new StoreDynamicLink$getDynamicLinkObservable$firebaseDynamicLinks$1$1(emitter))).f(new StoreDynamicLink$getDynamicLinkObservable$firebaseDynamicLinks$1$2(emitter));
        }
        aVar.a(this.$intent).d(new StoreDynamicLink$sam$com_google_android_gms_tasks_OnFailureListener$0(new StoreDynamicLink$getDynamicLinkObservable$firebaseDynamicLinks$1$1(emitter))).f(new StoreDynamicLink$getDynamicLinkObservable$firebaseDynamicLinks$1$2(emitter));
    }

    @Override // rx.functions.Action1
    public /* bridge */ /* synthetic */ void call(Emitter<Uri> emitter) {
        call2(emitter);
    }
}
