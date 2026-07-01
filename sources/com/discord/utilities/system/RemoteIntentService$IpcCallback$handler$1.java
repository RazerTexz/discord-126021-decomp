package com.discord.utilities.system;

import android.os.Bundle;
import android.os.Handler$Callback;
import android.os.Message;
import android.os.Process;
import androidx.core.app.NotificationCompat;
import b.d.b.a.a;
import com.discord.utilities.logging.Logger;
import com.discord.utilities.logging.LoggingProvider;
import d0.z.d.m;
import java.util.Objects;

/* JADX INFO: compiled from: RemoteIntentService.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class RemoteIntentService$IpcCallback$handler$1 implements Handler$Callback {
    public final /* synthetic */ RemoteIntentService$IpcCallback this$0;

    public RemoteIntentService$IpcCallback$handler$1(RemoteIntentService$IpcCallback remoteIntentService$IpcCallback) {
        this.this$0 = remoteIntentService$IpcCallback;
    }

    @Override // android.os.Handler$Callback
    public final boolean handleMessage(Message message) {
        m.checkNotNullParameter(message, NotificationCompat.CATEGORY_MESSAGE);
        Logger logger = LoggingProvider.INSTANCE.get();
        if (message.what == 1) {
            StringBuilder sbQ = a.Q('[');
            sbQ.append(RemoteIntentService$IpcCallback.access$getName$p(this.this$0));
            sbQ.append("] in IpcCallback: app pid=");
            sbQ.append(Process.myPid());
            Logger.d$default(logger, "RemoteIntentService", sbQ.toString(), null, 4, null);
            Object obj = message.obj;
            if (obj instanceof Bundle) {
                StringBuilder sbQ2 = a.Q('[');
                sbQ2.append(RemoteIntentService$IpcCallback.access$getName$p(this.this$0));
                sbQ2.append("] success after (");
                Logger.d$default(logger, "RemoteIntentService", a.B(sbQ2, message.arg1, " ms)"), null, 4, null);
                RemoteIntentService$IpcCallback remoteIntentService$IpcCallback = this.this$0;
                Object obj2 = message.obj;
                Objects.requireNonNull(obj2, "null cannot be cast to non-null type android.os.Bundle");
                remoteIntentService$IpcCallback.onSuccess((Bundle) obj2);
                return true;
            }
            if ((obj instanceof Throwable) || obj == null) {
                StringBuilder sbQ3 = a.Q('[');
                sbQ3.append(RemoteIntentService$IpcCallback.access$getName$p(this.this$0));
                sbQ3.append("] failure after (");
                Logger.d$default(logger, "RemoteIntentService", a.B(sbQ3, message.arg1, " ms)"), null, 4, null);
                RemoteIntentService$IpcCallback remoteIntentService$IpcCallback2 = this.this$0;
                Object obj3 = message.obj;
                if (!(obj3 instanceof Throwable)) {
                    obj3 = null;
                }
                remoteIntentService$IpcCallback2.onFailure((Throwable) obj3);
                return true;
            }
        }
        StringBuilder sbQ4 = a.Q('[');
        sbQ4.append(RemoteIntentService$IpcCallback.access$getName$p(this.this$0));
        sbQ4.append("] unexpected message in handler: ");
        sbQ4.append(RemoteIntentService$Companion.access$messageToString(RemoteIntentService.Companion, message));
        Logger.w$default(logger, "RemoteIntentService", sbQ4.toString(), null, 4, null);
        return false;
    }
}
