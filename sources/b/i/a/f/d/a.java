package b.i.a.f.d;

import android.app.PendingIntent;
import android.app.PendingIntent$CanceledException;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.WorkerThread;
import com.google.android.gms.cloudmessaging.CloudMessage;
import com.google.android.gms.tasks.Task;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-cloud-messaging@@16.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class a extends BroadcastReceiver {
    public final ExecutorService a;

    public a() {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1, 1, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new b.i.a.f.e.o.j.a("firebase-iid-executor"));
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        this.a = Executors.unconfigurableExecutorService(threadPoolExecutor);
    }

    @WorkerThread
    public final int a(@NonNull Context context, @NonNull Intent intent) {
        PendingIntent pendingIntent = (PendingIntent) intent.getParcelableExtra("pending_intent");
        if (pendingIntent != null) {
            try {
                pendingIntent.send();
            } catch (PendingIntent$CanceledException unused) {
                Log.e("CloudMessagingReceiver", "Notification pending intent canceled");
            }
        }
        Bundle extras = intent.getExtras();
        if (extras != null) {
            extras.remove("pending_intent");
        } else {
            extras = new Bundle();
        }
        if ("com.google.firebase.messaging.NOTIFICATION_OPEN".equals(intent.getAction())) {
            try {
                b.i.a.f.e.o.f.j(new b.i.c.s.f(context).b(new Intent("com.google.firebase.messaging.NOTIFICATION_OPEN").putExtras(extras)));
                return -1;
            } catch (InterruptedException | ExecutionException e) {
                Log.e("FirebaseInstanceId", "Failed to send notification open event to service.", e);
                return -1;
            }
        }
        if (!"com.google.firebase.messaging.NOTIFICATION_DISMISS".equals(intent.getAction())) {
            Log.e("CloudMessagingReceiver", "Unknown notification action");
            return 500;
        }
        try {
            b.i.a.f.e.o.f.j(new b.i.c.s.f(context).b(new Intent("com.google.firebase.messaging.NOTIFICATION_DISMISS").putExtras(extras)));
            return -1;
        } catch (InterruptedException | ExecutionException e2) {
            Log.e("FirebaseInstanceId", "Failed to send notification dismissed event to service.", e2);
            return -1;
        }
    }

    @WorkerThread
    public final int b(@NonNull Context context, @NonNull Intent intent) {
        int i;
        Task taskB;
        int iIntValue = 500;
        if (intent.getExtras() == null) {
            return 500;
        }
        String stringExtra = intent.getStringExtra("google.message_id");
        if (TextUtils.isEmpty(stringExtra)) {
            taskB = b.i.a.f.e.o.f.Z(null);
        } else {
            Bundle bundle = new Bundle();
            bundle.putString("google.message_id", stringExtra);
            f fVarA = f.a(context);
            synchronized (fVarA) {
                i = fVarA.e;
                fVarA.e = i + 1;
            }
            taskB = fVarA.b(new o(i, bundle));
        }
        try {
            iIntValue = ((Integer) b.i.a.f.e.o.f.j(new b.i.c.s.f(context).b(new CloudMessage(intent).j))).intValue();
        } catch (InterruptedException | ExecutionException e) {
            Log.e("FirebaseInstanceId", "Failed to send message to service.", e);
        }
        try {
            b.i.a.f.e.o.f.k(taskB, TimeUnit.SECONDS.toMillis(1L), TimeUnit.MILLISECONDS);
        } catch (InterruptedException | ExecutionException | TimeoutException e2) {
            String strValueOf = String.valueOf(e2);
            b.d.b.a.a.h0(strValueOf.length() + 20, "Message ack failed: ", strValueOf, "CloudMessagingReceiver");
        }
        return iIntValue;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(@NonNull Context context, @NonNull Intent intent) {
        if (intent == null) {
            return;
        }
        this.a.execute(new e(this, intent, context, isOrderedBroadcast(), goAsync()));
    }
}
