package com.discord.utilities.system;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.os.Process;
import androidx.core.app.NotificationCompat;
import b.d.b.a.a;
import com.discord.utilities.logging.Logger;
import com.discord.utilities.logging.LoggingProvider;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: RemoteIntentService.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class RemoteIntentService$Companion {
    private RemoteIntentService$Companion() {
    }

    public static final /* synthetic */ String access$messageToString(RemoteIntentService$Companion remoteIntentService$Companion, Message message) {
        return remoteIntentService$Companion.messageToString(message);
    }

    private final String messageToString(Message msg) {
        StringBuilder sbU = a.U("Message(what=");
        sbU.append(msg.what);
        sbU.append(", arg1=");
        sbU.append(msg.arg1);
        sbU.append(", arg2=");
        sbU.append(msg.arg2);
        sbU.append(", obj=");
        sbU.append(msg.obj);
        sbU.append(", replyTo=");
        sbU.append(msg.replyTo);
        sbU.append(')');
        return sbU.toString();
    }

    public final void startRemoteServiceWithCallback(Context context, Class<?> serviceClass, RemoteIntentService$IpcCallback callback) {
        m.checkNotNullParameter(context, "context");
        m.checkNotNullParameter(serviceClass, "serviceClass");
        m.checkNotNullParameter(callback, "callback");
        Logger logger = LoggingProvider.INSTANCE.get();
        StringBuilder sbU = a.U("Starting service in remote process: ");
        sbU.append(serviceClass.getSimpleName());
        sbU.append(", app pid=");
        sbU.append(Process.myPid());
        Logger.d$default(logger, "RemoteIntentService", sbU.toString(), null, 4, null);
        Intent intent = new Intent(context, serviceClass);
        Bundle bundle = new Bundle();
        bundle.putParcelable("com.discord.utilities.analytics.RemoteIntentService.MESSENGER_KEY", callback.getMessenger());
        intent.putExtras(bundle);
        context.startService(intent);
    }

    public /* synthetic */ RemoteIntentService$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
