package com.discord.utilities.fcm;

import b.i.a.f.n.c;
import com.discord.app.AppLog;
import com.google.android.gms.tasks.Task;
import d0.z.d.m;

/* JADX INFO: compiled from: NotificationClient.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class NotificationClient$init$3<TResult> implements c<String> {
    public static final NotificationClient$init$3 INSTANCE = new NotificationClient$init$3();

    @Override // b.i.a.f.n.c
    public final void onComplete(Task<String> task) {
        m.checkNotNullExpressionValue(task, "task");
        if (task.p()) {
            NotificationClient.INSTANCE.onNewToken(task.l());
        } else {
            AppLog.g.w("Fetching FCM registration token failed", task.k());
        }
    }
}
