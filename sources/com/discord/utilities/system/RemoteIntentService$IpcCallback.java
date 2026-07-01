package com.discord.utilities.system;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Messenger;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.m;

/* JADX INFO: compiled from: RemoteIntentService.kt */
/* JADX INFO: loaded from: classes2.dex */
public abstract class RemoteIntentService$IpcCallback {
    private final Handler handler;
    private final String name;

    public RemoteIntentService$IpcCallback(String str, Looper looper) {
        m.checkNotNullParameter(str, ModelAuditLogEntry.CHANGE_KEY_NAME);
        m.checkNotNullParameter(looper, "callbackLooper");
        this.name = str;
        this.handler = new Handler(looper, new RemoteIntentService$IpcCallback$handler$1(this));
    }

    public static final /* synthetic */ String access$getName$p(RemoteIntentService$IpcCallback remoteIntentService$IpcCallback) {
        return remoteIntentService$IpcCallback.name;
    }

    public final Messenger getMessenger() {
        return new Messenger(this.handler);
    }

    public abstract void onFailure(Throwable throwable);

    public abstract void onSuccess(Bundle bundle);
}
