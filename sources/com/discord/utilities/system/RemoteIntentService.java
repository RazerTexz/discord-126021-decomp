package com.discord.utilities.system;

import android.app.IntentService;
import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.os.Messenger;
import android.os.Process;
import android.os.RemoteException;
import android.util.Log;
import b.d.b.a.a;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.time.NtpClock;
import d0.z.d.m;

/* JADX INFO: compiled from: RemoteIntentService.kt */
/* JADX INFO: loaded from: classes2.dex */
public abstract class RemoteIntentService extends IntentService {
    public static final RemoteIntentService$Companion Companion = new RemoteIntentService$Companion(null);
    private static final String MESSENGER_KEY = "com.discord.utilities.analytics.RemoteIntentService.MESSENGER_KEY";
    private static final String TAG = "RemoteIntentService";
    private static final int WHAT_CALLBACK_RESULT = 1;
    private final String name;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RemoteIntentService(String str) {
        super(str);
        m.checkNotNullParameter(str, ModelAuditLogEntry.CHANGE_KEY_NAME);
        this.name = str;
    }

    public abstract Bundle doWork(Intent intent);

    @Override // android.app.IntentService, android.app.Service
    public final void onCreate() {
        super.onCreate();
        StringBuilder sbQ = a.Q('[');
        sbQ.append(this.name);
        sbQ.append("] created, remote pid=");
        sbQ.append(Process.myPid());
        Log.d(TAG, sbQ.toString());
    }

    @Override // android.app.IntentService, android.app.Service
    public final void onDestroy() {
        StringBuilder sbQ = a.Q('[');
        sbQ.append(this.name);
        sbQ.append("] destroyed");
        Log.d(TAG, sbQ.toString());
        super.onDestroy();
    }

    @Override // android.app.IntentService
    public final void onHandleIntent(Intent intent) throws RemoteException {
        StringBuilder sbQ = a.Q('[');
        sbQ.append(this.name);
        sbQ.append("] onHandleIntent() start, pid=");
        sbQ.append(Process.myPid());
        Log.d(TAG, sbQ.toString());
        if (intent == null) {
            StringBuilder sbQ2 = a.Q('[');
            sbQ2.append(this.name);
            sbQ2.append("] null intent");
            Log.d(TAG, sbQ2.toString());
            return;
        }
        NtpClock ntpClock = new NtpClock(b.m.a.a.a(this, null, null, 0L, 0L, 0L, 62));
        long jCurrentTimeMillis = ntpClock.currentTimeMillis();
        try {
            th = doWork(intent);
        } catch (Throwable th) {
            th = th;
            StringBuilder sbQ3 = a.Q('[');
            sbQ3.append(this.name);
            sbQ3.append("] doWork returned error: ");
            sbQ3.append(th);
            Log.e(TAG, sbQ3.toString());
        }
        long jCurrentTimeMillis2 = ntpClock.currentTimeMillis() - jCurrentTimeMillis;
        StringBuilder sbQ4 = a.Q('[');
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
        StringBuilder sbQ5 = a.Q('[');
        sbQ5.append(this.name);
        sbQ5.append("] reply-to Messenger not set by caller");
        Log.e(TAG, sbQ5.toString());
    }
}
