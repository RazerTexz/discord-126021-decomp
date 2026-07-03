package com.google.firebase.messaging;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.WorkerThread;
import com.adjust.sdk.Constants;
import com.google.firebase.encoders.EncodingException;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import p007b.p225i.p226a.p228b.C2406a;
import p007b.p225i.p226a.p228b.C2407b;
import p007b.p225i.p226a.p228b.EnumC2409d;
import p007b.p225i.p226a.p228b.InterfaceC2412g;
import p007b.p225i.p226a.p288f.p299e.p308o.p309j.ThreadFactoryC3408a;
import p007b.p225i.p361c.C4542c;
import p007b.p225i.p361c.p362j.p363a.InterfaceC4549a;
import p007b.p225i.p361c.p393p.p395h.C4793d;
import p007b.p225i.p361c.p398s.C4831v;
import p007b.p225i.p361c.p406w.C4865c;
import p007b.p225i.p361c.p406w.C4875m;
import p007b.p225i.p361c.p406w.C4878p;
import p007b.p225i.p361c.p406w.C4879q;
import p007b.p225i.p361c.p406w.C4880r;

/* JADX INFO: compiled from: com.google.firebase:firebase-messaging@@21.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public class FirebaseMessagingService extends EnhancedIntentService {
    public static final String ACTION_DIRECT_BOOT_REMOTE_INTENT = "com.google.firebase.messaging.RECEIVE_DIRECT_BOOT";
    private static final Queue<String> recentlyReceivedMessageIds = new ArrayDeque(10);

    private boolean alreadyReceivedMessage(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        Queue<String> queue = recentlyReceivedMessageIds;
        if (!queue.contains(str)) {
            if (queue.size() >= 10) {
                queue.remove();
            }
            queue.add(str);
            return false;
        }
        if (!Log.isLoggable("FirebaseMessaging", 3)) {
            return true;
        }
        String strValueOf = String.valueOf(str);
        Log.d("FirebaseMessaging", strValueOf.length() != 0 ? "Received duplicate message: ".concat(strValueOf) : new String("Received duplicate message: "));
        return true;
    }

    private void dispatchMessage(Intent intent) {
        Bundle extras = intent.getExtras();
        if (extras == null) {
            extras = new Bundle();
        }
        extras.remove("androidx.content.wakelockid");
        if (C4880r.m6820f(extras)) {
            C4880r c4880r = new C4880r(extras);
            ExecutorService executorServiceNewSingleThreadExecutor = Executors.newSingleThreadExecutor(new ThreadFactoryC3408a("Firebase-Messaging-Network-Io"));
            try {
                if (new C4865c(this, c4880r, executorServiceNewSingleThreadExecutor).m6816a()) {
                    executorServiceNewSingleThreadExecutor.shutdown();
                    return;
                } else {
                    executorServiceNewSingleThreadExecutor.shutdown();
                    if (C4879q.m6819c(intent)) {
                        C4879q.m6818b("_nf", intent);
                    }
                }
            } catch (Throwable th) {
                executorServiceNewSingleThreadExecutor.shutdown();
                throw th;
            }
        }
        onMessageReceived(new RemoteMessage(extras));
    }

    private String getMessageId(Intent intent) {
        String stringExtra = intent.getStringExtra("google.message_id");
        return stringExtra == null ? intent.getStringExtra("message_id") : stringExtra;
    }

    private void handleMessageIntent(Intent intent) {
        if (alreadyReceivedMessage(intent.getStringExtra("google.message_id"))) {
            return;
        }
        passMessageIntentToSdk(intent);
    }

    private void handleNotificationOpen(Intent intent) {
        if (C4879q.m6819c(intent)) {
            if (intent != null) {
                if ("1".equals(intent.getStringExtra("google.c.a.tc"))) {
                    C4542c c4542cM6327b = C4542c.m6327b();
                    c4542cM6327b.m6330a();
                    InterfaceC4549a interfaceC4549a = (InterfaceC4549a) c4542cM6327b.f12121g.mo6346a(InterfaceC4549a.class);
                    if (Log.isLoggable("FirebaseMessaging", 3)) {
                        Log.d("FirebaseMessaging", "Received event with track-conversion=true. Setting user property and reengagement event");
                    }
                    if (interfaceC4549a != null) {
                        String stringExtra = intent.getStringExtra("google.c.a.c_id");
                        interfaceC4549a.mo6339b("fcm", "_ln", stringExtra);
                        Bundle bundle = new Bundle();
                        bundle.putString("source", "Firebase");
                        bundle.putString(Constants.MEDIUM, "notification");
                        bundle.putString("campaign", stringExtra);
                        interfaceC4549a.mo6338a("fcm", "_cmp", bundle);
                    } else {
                        Log.w("FirebaseMessaging", "Unable to set user property for conversion tracking:  analytics library is missing");
                    }
                } else if (Log.isLoggable("FirebaseMessaging", 3)) {
                    Log.d("FirebaseMessaging", "Received event with track-conversion=false. Do not set user property");
                }
            }
            C4879q.m6818b("_no", intent);
        }
    }

    private void passMessageIntentToSdk(Intent intent) {
        ApplicationInfo applicationInfo;
        Bundle bundle;
        String stringExtra = intent.getStringExtra("message_type");
        if (stringExtra == null) {
            stringExtra = "gcm";
        }
        boolean z2 = false;
        switch (stringExtra) {
            case "deleted_messages":
                onDeletedMessages();
                break;
            case "gcm":
                if (C4879q.m6819c(intent)) {
                    C4879q.m6818b("_nr", intent);
                }
                if (!ACTION_DIRECT_BOOT_REMOTE_INTENT.equals(intent.getAction())) {
                    try {
                        C4542c.m6327b();
                        C4542c c4542cM6327b = C4542c.m6327b();
                        c4542cM6327b.m6330a();
                        Context context = c4542cM6327b.f12118d;
                        SharedPreferences sharedPreferences = context.getSharedPreferences("com.google.firebase.messaging", 0);
                        if (sharedPreferences.contains("export_to_big_query")) {
                            z2 = sharedPreferences.getBoolean("export_to_big_query", false);
                        } else {
                            try {
                                PackageManager packageManager = context.getPackageManager();
                                if (packageManager != null && (applicationInfo = packageManager.getApplicationInfo(context.getPackageName(), 128)) != null && (bundle = applicationInfo.metaData) != null && bundle.containsKey("delivery_metrics_exported_to_big_query_enabled")) {
                                    z2 = applicationInfo.metaData.getBoolean("delivery_metrics_exported_to_big_query_enabled", false);
                                }
                                break;
                            } catch (PackageManager.NameNotFoundException unused) {
                            }
                        }
                    } catch (IllegalStateException unused2) {
                        Log.i("FirebaseMessaging", "FirebaseApp has not being initialized. Device might be in direct boot mode. Skip exporting delivery metrics to Big Query");
                    }
                }
                if (z2) {
                    InterfaceC2412g interfaceC2412g = FirebaseMessaging.f21448a;
                    if (interfaceC2412g != null) {
                        try {
                            interfaceC2412g.mo2291a("FCM_CLIENT_EVENT_LOGGING", String.class, new C2407b("json"), C4878p.f13037a).mo2289a(new C2406a(null, ((C4793d) C4879q.f13038a).m6711a(new C4875m.b(new C4875m("MESSAGE_DELIVERED", intent))), EnumC2409d.VERY_LOW));
                        } catch (EncodingException unused3) {
                            Log.d("FirebaseMessaging", "Failed to encode big query analytics payload. Skip sending");
                        }
                    } else {
                        Log.e("FirebaseMessaging", "TransportFactory is null. Skip exporting message delivery metrics to Big Query");
                    }
                    break;
                }
                dispatchMessage(intent);
                break;
            case "send_error":
                onSendError(getMessageId(intent), new SendException(intent.getStringExtra("error")));
                break;
            case "send_event":
                onMessageSent(intent.getStringExtra("google.message_id"));
                break;
            default:
                Log.w("FirebaseMessaging", stringExtra.length() != 0 ? "Received message with unknown type: ".concat(stringExtra) : new String("Received message with unknown type: "));
                break;
        }
    }

    @Override // com.google.firebase.messaging.EnhancedIntentService
    public Intent getStartCommandIntent(Intent intent) {
        return C4831v.m6735a().f12900e.poll();
    }

    @Override // com.google.firebase.messaging.EnhancedIntentService
    public void handleIntent(Intent intent) {
        String action = intent.getAction();
        if ("com.google.android.c2dm.intent.RECEIVE".equals(action) || ACTION_DIRECT_BOOT_REMOTE_INTENT.equals(action)) {
            handleMessageIntent(intent);
            return;
        }
        if ("com.google.firebase.messaging.NOTIFICATION_DISMISS".equals(action)) {
            if (C4879q.m6819c(intent)) {
                C4879q.m6818b("_nd", intent);
            }
        } else if ("com.google.firebase.messaging.NEW_TOKEN".equals(action)) {
            onNewToken(intent.getStringExtra("token"));
        } else {
            String strValueOf = String.valueOf(intent.getAction());
            Log.d("FirebaseMessaging", strValueOf.length() != 0 ? "Unknown intent action: ".concat(strValueOf) : new String("Unknown intent action: "));
        }
    }

    @Override // com.google.firebase.messaging.EnhancedIntentService
    public boolean handleIntentOnMainThread(Intent intent) {
        if (!"com.google.firebase.messaging.NOTIFICATION_OPEN".equals(intent.getAction())) {
            return false;
        }
        handleNotificationOpen(intent);
        return true;
    }

    @WorkerThread
    public void onDeletedMessages() {
    }

    @WorkerThread
    public void onMessageReceived(@NonNull RemoteMessage remoteMessage) {
    }

    @WorkerThread
    public void onMessageSent(@NonNull String str) {
    }

    @WorkerThread
    public void onNewToken(@NonNull String str) {
    }

    @WorkerThread
    public void onSendError(@NonNull String str, @NonNull Exception exc) {
    }
}
