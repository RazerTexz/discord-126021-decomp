package com.discord.utilities.system;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.Process;
import android.os.RemoteException;
import android.util.Log;
import androidx.core.app.NotificationCompat;
import b.d.b.a.outline;
import b.m.a.AndroidClockFactory;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.logging.Logger;
import com.discord.utilities.logging.LoggingProvider;
import com.discord.utilities.system.RemoteIntentService;
import com.discord.utilities.time.NtpClock;
import d0.z.d.Intrinsics3;
import java.util.Objects;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: RemoteIntentService.kt */
/* JADX INFO: loaded from: classes2.dex */
public abstract class RemoteIntentService extends IntentService {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String MESSENGER_KEY = "com.discord.utilities.analytics.RemoteIntentService.MESSENGER_KEY";
    private static final String TAG = "RemoteIntentService";
    private static final int WHAT_CALLBACK_RESULT = 1;
    private final String name;

    /* JADX INFO: compiled from: RemoteIntentService.kt */
    public static final class Companion {
        private Companion() {
        }

        private final String messageToString(Message msg) {
            StringBuilder sbU = outline.U("Message(what=");
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

        public final void startRemoteServiceWithCallback(Context context, Class<?> serviceClass, IpcCallback callback) {
            Intrinsics3.checkNotNullParameter(context, "context");
            Intrinsics3.checkNotNullParameter(serviceClass, "serviceClass");
            Intrinsics3.checkNotNullParameter(callback, "callback");
            Logger logger = LoggingProvider.INSTANCE.get();
            StringBuilder sbU = outline.U("Starting service in remote process: ");
            sbU.append(serviceClass.getSimpleName());
            sbU.append(", app pid=");
            sbU.append(Process.myPid());
            Logger.d$default(logger, RemoteIntentService.TAG, sbU.toString(), null, 4, null);
            Intent intent = new Intent(context, serviceClass);
            Bundle bundle = new Bundle();
            bundle.putParcelable(RemoteIntentService.MESSENGER_KEY, callback.getMessenger());
            intent.putExtras(bundle);
            context.startService(intent);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: compiled from: RemoteIntentService.kt */
    public static abstract class IpcCallback {
        private final Handler handler;
        private final String name;

        public IpcCallback(String str, Looper looper) {
            Intrinsics3.checkNotNullParameter(str, ModelAuditLogEntry.CHANGE_KEY_NAME);
            Intrinsics3.checkNotNullParameter(looper, "callbackLooper");
            this.name = str;
            this.handler = new Handler(looper, new Handler.Callback() { // from class: com.discord.utilities.system.RemoteIntentService$IpcCallback$handler$1
                @Override // android.os.Handler.Callback
                public final boolean handleMessage(Message message) {
                    Intrinsics3.checkNotNullParameter(message, NotificationCompat.CATEGORY_MESSAGE);
                    Logger logger = LoggingProvider.INSTANCE.get();
                    if (message.what == 1) {
                        StringBuilder sbQ = outline.Q('[');
                        sbQ.append(this.this$0.name);
                        sbQ.append("] in IpcCallback: app pid=");
                        sbQ.append(Process.myPid());
                        Logger.d$default(logger, "RemoteIntentService", sbQ.toString(), null, 4, null);
                        Object obj = message.obj;
                        if (obj instanceof Bundle) {
                            StringBuilder sbQ2 = outline.Q('[');
                            sbQ2.append(this.this$0.name);
                            sbQ2.append("] success after (");
                            Logger.d$default(logger, "RemoteIntentService", outline.B(sbQ2, message.arg1, " ms)"), null, 4, null);
                            RemoteIntentService.IpcCallback ipcCallback = this.this$0;
                            Object obj2 = message.obj;
                            Objects.requireNonNull(obj2, "null cannot be cast to non-null type android.os.Bundle");
                            ipcCallback.onSuccess((Bundle) obj2);
                            return true;
                        }
                        if ((obj instanceof Throwable) || obj == null) {
                            StringBuilder sbQ3 = outline.Q('[');
                            sbQ3.append(this.this$0.name);
                            sbQ3.append("] failure after (");
                            Logger.d$default(logger, "RemoteIntentService", outline.B(sbQ3, message.arg1, " ms)"), null, 4, null);
                            RemoteIntentService.IpcCallback ipcCallback2 = this.this$0;
                            Object obj3 = message.obj;
                            if (!(obj3 instanceof Throwable)) {
                                obj3 = null;
                            }
                            ipcCallback2.onFailure((Throwable) obj3);
                            return true;
                        }
                    }
                    StringBuilder sbQ4 = outline.Q('[');
                    sbQ4.append(this.this$0.name);
                    sbQ4.append("] unexpected message in handler: ");
                    sbQ4.append(RemoteIntentService.INSTANCE.messageToString(message));
                    Logger.w$default(logger, "RemoteIntentService", sbQ4.toString(), null, 4, null);
                    return false;
                }
            });
        }

        public final Messenger getMessenger() {
            return new Messenger(this.handler);
        }

        public abstract void onFailure(Throwable throwable);

        public abstract void onSuccess(Bundle bundle);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RemoteIntentService(String str) {
        super(str);
        Intrinsics3.checkNotNullParameter(str, ModelAuditLogEntry.CHANGE_KEY_NAME);
        this.name = str;
    }

    public abstract Bundle doWork(Intent intent);

    @Override // android.app.IntentService, android.app.Service
    public final void onCreate() {
        super.onCreate();
        StringBuilder sbQ = outline.Q('[');
        sbQ.append(this.name);
        sbQ.append("] created, remote pid=");
        sbQ.append(Process.myPid());
        Log.d(TAG, sbQ.toString());
    }

    @Override // android.app.IntentService, android.app.Service
    public final void onDestroy() {
        StringBuilder sbQ = outline.Q('[');
        sbQ.append(this.name);
        sbQ.append("] destroyed");
        Log.d(TAG, sbQ.toString());
        super.onDestroy();
    }

    @Override // android.app.IntentService
    public final void onHandleIntent(Intent intent) throws RemoteException {
        StringBuilder sbQ = outline.Q('[');
        sbQ.append(this.name);
        sbQ.append("] onHandleIntent() start, pid=");
        sbQ.append(Process.myPid());
        Log.d(TAG, sbQ.toString());
        if (intent == null) {
            StringBuilder sbQ2 = outline.Q('[');
            sbQ2.append(this.name);
            sbQ2.append("] null intent");
            Log.d(TAG, sbQ2.toString());
            return;
        }
        NtpClock ntpClock = new NtpClock(AndroidClockFactory.a(this, null, null, 0L, 0L, 0L, 62));
        long jCurrentTimeMillis = ntpClock.currentTimeMillis();
        try {
            th = doWork(intent);
        } catch (Throwable th) {
            th = th;
            StringBuilder sbQ3 = outline.Q('[');
            sbQ3.append(this.name);
            sbQ3.append("] doWork returned error: ");
            sbQ3.append(th);
            Log.e(TAG, sbQ3.toString());
        }
        long jCurrentTimeMillis2 = ntpClock.currentTimeMillis() - jCurrentTimeMillis;
        StringBuilder sbQ4 = outline.Q('[');
        sbQ4.append(this.name);
        sbQ4.append("] doWork finished: ");
        sbQ4.append(jCurrentTimeMillis2);
        sbQ4.append(" ms");
        Log.d(TAG, sbQ4.toString());
        Message messageObtain = Message.obtain();
        messageObtain.what = 1;
        messageObtain.arg1 = (int) jCurrentTimeMillis2;
        messageObtain.obj = th;
        Messenger messenger = (Messenger) intent.getParcelableExtra(MESSENGER_KEY);
        if (messenger != null) {
            messenger.send(messageObtain);
            return;
        }
        StringBuilder sbQ5 = outline.Q('[');
        sbQ5.append(this.name);
        sbQ5.append("] reply-to Messenger not set by caller");
        Log.e(TAG, sbQ5.toString());
    }
}
