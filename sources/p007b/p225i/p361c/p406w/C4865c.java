package p007b.p225i.p361c.p406w;

import android.R;
import android.app.ActivityManager;
import android.app.KeyguardManager;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Process;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import androidx.appcompat.widget.ActivityChooserModel;
import androidx.constraintlayout.solver.widgets.analyzer.BasicMeasure;
import androidx.core.app.NotificationCompat;
import androidx.core.content.ContextCompat;
import com.esotericsoftware.kryo.p502io.Util;
import com.google.android.gms.tasks.Task;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONArray;
import org.json.JSONException;
import p007b.p100d.p104b.p105a.C1643a;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;
import p007b.p225i.p226a.p288f.p313h.p322i.C3488b;
import p007b.p225i.p226a.p288f.p313h.p322i.C3490d;
import p007b.p225i.p226a.p288f.p313h.p322i.C3491e;

/* JADX INFO: renamed from: b.i.c.w.c */
/* JADX INFO: compiled from: com.google.firebase:firebase-messaging@@21.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public class C4865c {

    /* JADX INFO: renamed from: a */
    public final Executor f13014a;

    /* JADX INFO: renamed from: b */
    public final Context f13015b;

    /* JADX INFO: renamed from: c */
    public final C4880r f13016c;

    public C4865c(Context context, C4880r c4880r, Executor executor) {
        this.f13014a = executor;
        this.f13015b = context;
        this.f13016c = c4880r;
    }

    /* JADX WARN: Code duplicated, block: B:163:0x0373  */
    /* JADX WARN: Code duplicated, block: B:18:0x004e A[EDGE_INSN: B:18:0x004e->B:19:0x004f BREAK  A[LOOP:0: B:11:0x0036->B:285:?]] */
    /* JADX WARN: Code duplicated, block: B:270:0x01cb A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:272:0x0365 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:57:0x0117  */
    /* JADX WARN: Code duplicated, block: B:60:0x011e  */
    /* JADX WARN: Code duplicated, block: B:61:0x0124  */
    /* JADX WARN: Code duplicated, block: B:64:0x0131  */
    /* JADX WARN: Code duplicated, block: B:65:0x014e  */
    /* JADX WARN: Code duplicated, block: B:97:0x01ea  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v49 */
    /* JADX WARN: Type inference failed for: r0v81 */
    /* JADX WARN: Type inference failed for: r0v82 */
    /* JADX INFO: renamed from: a */
    public boolean m6816a() {
        boolean z2;
        final C4877o c4877o;
        Bundle bundle;
        int i;
        int identifier;
        Uri defaultUri;
        Intent launchIntentForPackage;
        PendingIntent activity;
        Integer numValueOf;
        Long lValueOf;
        long[] jArr;
        int[] iArr;
        int i2;
        if (this.f13016c.m6822a("gcm.n.noui")) {
            return true;
        }
        if (!((KeyguardManager) this.f13015b.getSystemService("keyguard")).inKeyguardRestrictedInputMode()) {
            int iMyPid = Process.myPid();
            List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) this.f13015b.getSystemService(ActivityChooserModel.ATTRIBUTE_ACTIVITY)).getRunningAppProcesses();
            if (runningAppProcesses == null) {
                z2 = false;
                break;
            }
            Iterator<ActivityManager.RunningAppProcessInfo> it = runningAppProcesses.iterator();
            while (true) {
                if (it.hasNext()) {
                    ActivityManager.RunningAppProcessInfo next = it.next();
                    if (next.pid == iMyPid) {
                        if (next.importance == 100) {
                            z2 = true;
                            break;
                        }
                    }
                }
                z2 = false;
                break;
            }
        }
        z2 = false;
        break;
        if (z2) {
            return false;
        }
        String strM6826e = this.f13016c.m6826e("gcm.n.image");
        if (TextUtils.isEmpty(strM6826e)) {
            c4877o = null;
        } else {
            try {
                c4877o = new C4877o(new URL(strM6826e));
            } catch (MalformedURLException unused) {
                String strValueOf = String.valueOf(strM6826e);
                Log.w("FirebaseMessaging", strValueOf.length() != 0 ? "Not downloading image, bad URL: ".concat(strValueOf) : new String("Not downloading image, bad URL: "));
                c4877o = null;
            }
        }
        if (c4877o != null) {
            c4877o.f13035k = C3404f.m4323o(this.f13014a, new Callable(c4877o) { // from class: b.i.c.w.n

                /* JADX INFO: renamed from: j */
                public final C4877o f13033j;

                {
                    this.f13033j = c4877o;
                }

                @Override // java.util.concurrent.Callable
                public final Object call() throws IOException {
                    byte[] bArrM4412a;
                    C4877o c4877o2 = this.f13033j;
                    String strValueOf2 = String.valueOf(c4877o2.f13034j);
                    StringBuilder sb = new StringBuilder(strValueOf2.length() + 22);
                    sb.append("Starting download of: ");
                    sb.append(strValueOf2);
                    Log.i("FirebaseMessaging", sb.toString());
                    URLConnection uRLConnectionOpenConnection = c4877o2.f13034j.openConnection();
                    if (uRLConnectionOpenConnection.getContentLength() > 1048576) {
                        throw new IOException("Content-Length exceeds max size of 1048576");
                    }
                    InputStream inputStream = uRLConnectionOpenConnection.getInputStream();
                    try {
                        c4877o2.f13036l = inputStream;
                        int i3 = C3488b.f9652a;
                        C3490d c3490d = new C3490d(inputStream);
                        ArrayDeque arrayDeque = new ArrayDeque(20);
                        int i4 = 8192;
                        int i5 = 0;
                        loop0: while (true) {
                            if (i5 >= 2147483639) {
                                if (c3490d.read() != -1) {
                                    throw new OutOfMemoryError("input is too large to fit in a byte array");
                                }
                                bArrM4412a = C3488b.m4412a(arrayDeque, Util.MAX_SAFE_ARRAY_SIZE);
                                break;
                            }
                            int iMin = Math.min(i4, Util.MAX_SAFE_ARRAY_SIZE - i5);
                            byte[] bArr = new byte[iMin];
                            arrayDeque.add(bArr);
                            int i6 = 0;
                            while (i6 < iMin) {
                                int i7 = c3490d.read(bArr, i6, iMin - i6);
                                if (i7 == -1) {
                                    bArrM4412a = C3488b.m4412a(arrayDeque, i5);
                                    break loop0;
                                }
                                i6 += i7;
                                i5 += i7;
                            }
                            long j = ((long) i4) << 1;
                            if (j > 2147483647L) {
                                i4 = Integer.MAX_VALUE;
                            } else {
                                i4 = j < -2147483648L ? Integer.MIN_VALUE : (int) j;
                            }
                        }
                        if (inputStream != null) {
                            inputStream.close();
                        }
                        if (Log.isLoggable("FirebaseMessaging", 2)) {
                            int length = bArrM4412a.length;
                            String strValueOf3 = String.valueOf(c4877o2.f13034j);
                            StringBuilder sb2 = new StringBuilder(strValueOf3.length() + 34);
                            sb2.append("Downloaded ");
                            sb2.append(length);
                            sb2.append(" bytes from ");
                            sb2.append(strValueOf3);
                            Log.v("FirebaseMessaging", sb2.toString());
                        }
                        if (bArrM4412a.length > 1048576) {
                            throw new IOException("Image exceeds max size of 1048576");
                        }
                        Bitmap bitmapDecodeByteArray = BitmapFactory.decodeByteArray(bArrM4412a, 0, bArrM4412a.length);
                        if (bitmapDecodeByteArray == null) {
                            String strValueOf4 = String.valueOf(c4877o2.f13034j);
                            throw new IOException(C1643a.m857j(strValueOf4.length() + 24, "Failed to decode image: ", strValueOf4));
                        }
                        if (Log.isLoggable("FirebaseMessaging", 3)) {
                            String strValueOf5 = String.valueOf(c4877o2.f13034j);
                            StringBuilder sb3 = new StringBuilder(strValueOf5.length() + 31);
                            sb3.append("Successfully downloaded image: ");
                            sb3.append(strValueOf5);
                            Log.d("FirebaseMessaging", sb3.toString());
                        }
                        return bitmapDecodeByteArray;
                    } catch (Throwable th) {
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (Throwable th2) {
                                C3491e.f9656a.mo4413a(th, th2);
                            }
                        }
                        throw th;
                    }
                }
            });
        }
        Context context = this.f13015b;
        C4880r c4880r = this.f13016c;
        AtomicInteger atomicInteger = C4863a.f13012a;
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
            if (applicationInfo == null || (bundle = applicationInfo.metaData) == null) {
                bundle = Bundle.EMPTY;
            }
        } catch (PackageManager.NameNotFoundException e) {
            String strValueOf2 = String.valueOf(e);
            C1643a.m854h0(strValueOf2.length() + 35, "Couldn't get own application info: ", strValueOf2, "FirebaseMessaging");
        }
        String packageName = context.getPackageName();
        String strM6826e2 = c4880r.m6826e("gcm.n.android_channel_id");
        if (Build.VERSION.SDK_INT < 26) {
            strM6826e2 = null;
        } else {
            try {
                if (context.getPackageManager().getApplicationInfo(context.getPackageName(), 0).targetSdkVersion < 26) {
                    strM6826e2 = null;
                } else {
                    NotificationManager notificationManager = (NotificationManager) context.getSystemService(NotificationManager.class);
                    if (TextUtils.isEmpty(strM6826e2)) {
                        strM6826e2 = bundle.getString("com.google.firebase.messaging.default_notification_channel_id");
                        if (!TextUtils.isEmpty(strM6826e2)) {
                            Log.w("FirebaseMessaging", "Missing Default Notification Channel metadata in AndroidManifest. Default value will be used.");
                        } else if (notificationManager.getNotificationChannel(strM6826e2) == null) {
                            Log.w("FirebaseMessaging", "Notification Channel set in AndroidManifest.xml has not been created by the app. Default value will be used.");
                        }
                        strM6826e2 = "fcm_fallback_notification_channel";
                        if (notificationManager.getNotificationChannel("fcm_fallback_notification_channel") == null) {
                            notificationManager.createNotificationChannel(new NotificationChannel("fcm_fallback_notification_channel", context.getString(context.getResources().getIdentifier("fcm_fallback_notification_channel_label", "string", context.getPackageName())), 3));
                        }
                    } else if (notificationManager.getNotificationChannel(strM6826e2) == null) {
                        C1643a.m856i0(C1643a.m841b(strM6826e2, 122), "Notification Channel requested (", strM6826e2, ") has not been created by the app. Manifest configuration, or default, value will be used.", "FirebaseMessaging");
                        strM6826e2 = bundle.getString("com.google.firebase.messaging.default_notification_channel_id");
                        if (!TextUtils.isEmpty(strM6826e2)) {
                            Log.w("FirebaseMessaging", "Missing Default Notification Channel metadata in AndroidManifest. Default value will be used.");
                        } else if (notificationManager.getNotificationChannel(strM6826e2) == null) {
                            Log.w("FirebaseMessaging", "Notification Channel set in AndroidManifest.xml has not been created by the app. Default value will be used.");
                        }
                        strM6826e2 = "fcm_fallback_notification_channel";
                        if (notificationManager.getNotificationChannel("fcm_fallback_notification_channel") == null) {
                            notificationManager.createNotificationChannel(new NotificationChannel("fcm_fallback_notification_channel", context.getString(context.getResources().getIdentifier("fcm_fallback_notification_channel_label", "string", context.getPackageName())), 3));
                        }
                    }
                }
            } catch (PackageManager.NameNotFoundException unused2) {
            }
        }
        Resources resources = context.getResources();
        PackageManager packageManager = context.getPackageManager();
        NotificationCompat.Builder builder = new NotificationCompat.Builder(context, strM6826e2);
        CharSequence charSequenceM6825d = c4880r.m6825d(resources, packageName, "gcm.n.title");
        if (!TextUtils.isEmpty(charSequenceM6825d)) {
            builder.setContentTitle(charSequenceM6825d);
        }
        CharSequence charSequenceM6825d2 = c4880r.m6825d(resources, packageName, "gcm.n.body");
        if (!TextUtils.isEmpty(charSequenceM6825d2)) {
            builder.setContentText(charSequenceM6825d2);
            builder.setStyle(new NotificationCompat.BigTextStyle().bigText(charSequenceM6825d2));
        }
        String strM6826e3 = c4880r.m6826e("gcm.n.icon");
        if (TextUtils.isEmpty(strM6826e3)) {
            i = bundle.getInt("com.google.firebase.messaging.default_notification_icon", 0);
            if (i == 0 && C4863a.m6815b(resources, i)) {
                identifier = i;
            } else {
                try {
                } catch (PackageManager.NameNotFoundException e2) {
                    String strValueOf3 = String.valueOf(e2);
                    C1643a.m854h0(strValueOf3.length() + 35, "Couldn't get own application info: ", strValueOf3, "FirebaseMessaging");
                    identifier = i;
                }
            }
            if (identifier != 0 || !C4863a.m6815b(resources, identifier)) {
                identifier = R.drawable.sym_def_app_icon;
            }
        } else {
            identifier = resources.getIdentifier(strM6826e3, "drawable", packageName);
            if ((identifier == 0 || !C4863a.m6815b(resources, identifier)) && ((identifier = resources.getIdentifier(strM6826e3, "mipmap", packageName)) == 0 || !C4863a.m6815b(resources, identifier))) {
                C1643a.m856i0(C1643a.m841b(strM6826e3, 61), "Icon resource ", strM6826e3, " not found. Notification will use default icon.", "FirebaseMessaging");
                i = bundle.getInt("com.google.firebase.messaging.default_notification_icon", 0);
                identifier = i == 0 ? packageManager.getApplicationInfo(packageName, 0).icon : packageManager.getApplicationInfo(packageName, 0).icon;
                if (identifier != 0) {
                    identifier = R.drawable.sym_def_app_icon;
                } else {
                    identifier = R.drawable.sym_def_app_icon;
                }
            }
        }
        builder.setSmallIcon(identifier);
        String strM6826e4 = c4880r.m6826e("gcm.n.sound2");
        if (TextUtils.isEmpty(strM6826e4)) {
            strM6826e4 = c4880r.m6826e("gcm.n.sound");
        }
        if (TextUtils.isEmpty(strM6826e4)) {
            defaultUri = null;
        } else if ("default".equals(strM6826e4) || resources.getIdentifier(strM6826e4, "raw", packageName) == 0) {
            defaultUri = RingtoneManager.getDefaultUri(2);
        } else {
            StringBuilder sb = new StringBuilder(C1643a.m841b(strM6826e4, C1643a.m841b(packageName, 24)));
            sb.append("android.resource://");
            sb.append(packageName);
            sb.append("/raw/");
            sb.append(strM6826e4);
            defaultUri = Uri.parse(sb.toString());
        }
        if (defaultUri != null) {
            builder.setSound(defaultUri);
        }
        String strM6826e5 = c4880r.m6826e("gcm.n.click_action");
        if (TextUtils.isEmpty(strM6826e5)) {
            String strM6826e6 = c4880r.m6826e("gcm.n.link_android");
            if (TextUtils.isEmpty(strM6826e6)) {
                strM6826e6 = c4880r.m6826e("gcm.n.link");
            }
            Uri uri = !TextUtils.isEmpty(strM6826e6) ? Uri.parse(strM6826e6) : null;
            if (uri != null) {
                launchIntentForPackage = new Intent("android.intent.action.VIEW");
                launchIntentForPackage.setPackage(packageName);
                launchIntentForPackage.setData(uri);
            } else {
                launchIntentForPackage = packageManager.getLaunchIntentForPackage(packageName);
                if (launchIntentForPackage == null) {
                    Log.w("FirebaseMessaging", "No activity found to launch app");
                }
            }
        } else {
            launchIntentForPackage = new Intent(strM6826e5);
            launchIntentForPackage.setPackage(packageName);
            launchIntentForPackage.setFlags(268435456);
        }
        if (launchIntentForPackage == null) {
            activity = null;
        } else {
            launchIntentForPackage.addFlags(67108864);
            Bundle bundle2 = new Bundle(c4880r.f13039a);
            for (String str : c4880r.f13039a.keySet()) {
                if (str.startsWith("google.c.") || str.startsWith("gcm.n.") || str.startsWith("gcm.notification.")) {
                    bundle2.remove(str);
                }
            }
            launchIntentForPackage.putExtras(bundle2);
            activity = PendingIntent.getActivity(context, C4863a.f13012a.incrementAndGet(), launchIntentForPackage, BasicMeasure.EXACTLY);
            if (c4880r.m6822a("google.c.a.e")) {
                activity = C4863a.m6814a(context, new Intent("com.google.firebase.messaging.NOTIFICATION_OPEN").putExtras(c4880r.m6827g()).putExtra("pending_intent", activity));
            }
        }
        builder.setContentIntent(activity);
        PendingIntent pendingIntentM6814a = !c4880r.m6822a("google.c.a.e") ? null : C4863a.m6814a(context, new Intent("com.google.firebase.messaging.NOTIFICATION_DISMISS").putExtras(c4880r.m6827g()));
        if (pendingIntentM6814a != null) {
            builder.setDeleteIntent(pendingIntentM6814a);
        }
        String strM6826e7 = c4880r.m6826e("gcm.n.color");
        if (TextUtils.isEmpty(strM6826e7)) {
            i2 = bundle.getInt("com.google.firebase.messaging.default_notification_color", 0);
            if (i2 != 0) {
                numValueOf = Integer.valueOf(ContextCompat.getColor(context, i2));
            } else {
                numValueOf = null;
            }
        } else {
            try {
                numValueOf = Integer.valueOf(Color.parseColor(strM6826e7));
            } catch (IllegalArgumentException unused3) {
                C1643a.m856i0(C1643a.m841b(strM6826e7, 56), "Color is invalid: ", strM6826e7, ". Notification will use default color.", "FirebaseMessaging");
                i2 = bundle.getInt("com.google.firebase.messaging.default_notification_color", 0);
                if (i2 != 0) {
                    try {
                        numValueOf = Integer.valueOf(ContextCompat.getColor(context, i2));
                    } catch (Resources.NotFoundException unused4) {
                        Log.w("FirebaseMessaging", "Cannot find the color resource referenced in AndroidManifest.");
                        numValueOf = null;
                    }
                } else {
                    numValueOf = null;
                }
            }
        }
        if (numValueOf != null) {
            builder.setColor(numValueOf.intValue());
        }
        builder.setAutoCancel(!c4880r.m6822a("gcm.n.sticky"));
        builder.setLocalOnly(c4880r.m6822a("gcm.n.local_only"));
        CharSequence charSequenceM6826e = c4880r.m6826e("gcm.n.ticker");
        if (charSequenceM6826e != null) {
            builder.setTicker(charSequenceM6826e);
        }
        Integer numM6823b = c4880r.m6823b("gcm.n.notification_priority");
        if (numM6823b == null) {
            numM6823b = null;
        } else if (numM6823b.intValue() < -2 || numM6823b.intValue() > 2) {
            String strValueOf4 = String.valueOf(numM6823b);
            C1643a.m856i0(strValueOf4.length() + 72, "notificationPriority is invalid ", strValueOf4, ". Skipping setting notificationPriority.", "FirebaseMessaging");
            numM6823b = null;
        }
        if (numM6823b != null) {
            builder.setPriority(numM6823b.intValue());
        }
        Integer numM6823b2 = c4880r.m6823b("gcm.n.visibility");
        if (numM6823b2 == null) {
            numM6823b2 = null;
        } else if (numM6823b2.intValue() < -1 || numM6823b2.intValue() > 1) {
            String strValueOf5 = String.valueOf(numM6823b2);
            C1643a.m856i0(strValueOf5.length() + 53, "visibility is invalid: ", strValueOf5, ". Skipping setting visibility.", "NotificationParams");
            numM6823b2 = null;
        }
        if (numM6823b2 != null) {
            builder.setVisibility(numM6823b2.intValue());
        }
        Integer numM6823b3 = c4880r.m6823b("gcm.n.notification_count");
        if (numM6823b3 == null) {
            numM6823b3 = null;
        } else if (numM6823b3.intValue() < 0) {
            String strValueOf6 = String.valueOf(numM6823b3);
            C1643a.m856i0(strValueOf6.length() + 67, "notificationCount is invalid: ", strValueOf6, ". Skipping setting notificationCount.", "FirebaseMessaging");
            numM6823b3 = null;
        }
        if (numM6823b3 != null) {
            builder.setNumber(numM6823b3.intValue());
        }
        String strM6826e8 = c4880r.m6826e("gcm.n.event_time");
        if (TextUtils.isEmpty(strM6826e8)) {
            lValueOf = null;
        } else {
            try {
                lValueOf = Long.valueOf(Long.parseLong(strM6826e8));
            } catch (NumberFormatException unused5) {
                String strM6821h = C4880r.m6821h("gcm.n.event_time");
                C1643a.m874r0(C1643a.m831S(C1643a.m841b(strM6826e8, C1643a.m841b(strM6821h, 38)), "Couldn't parse value of ", strM6821h, "(", strM6826e8), ") into a long", "NotificationParams");
                lValueOf = null;
            }
        }
        if (lValueOf != null) {
            builder.setShowWhen(true);
            builder.setWhen(lValueOf.longValue());
        }
        JSONArray jSONArrayM6824c = c4880r.m6824c("gcm.n.vibrate_timings");
        if (jSONArrayM6824c == null) {
            jArr = null;
        } else {
            try {
                if (jSONArrayM6824c.length() <= 1) {
                    throw new JSONException("vibrateTimings have invalid length");
                }
                int length = jSONArrayM6824c.length();
                jArr = new long[length];
                for (int i3 = 0; i3 < length; i3++) {
                    jArr[i3] = jSONArrayM6824c.optLong(i3);
                }
            } catch (NumberFormatException | JSONException unused6) {
                String strValueOf7 = String.valueOf(jSONArrayM6824c);
                C1643a.m856i0(strValueOf7.length() + 74, "User defined vibrateTimings is invalid: ", strValueOf7, ". Skipping setting vibrateTimings.", "NotificationParams");
                jArr = null;
            }
        }
        if (jArr != null) {
            builder.setVibrate(jArr);
        }
        JSONArray jSONArrayM6824c2 = c4880r.m6824c("gcm.n.light_settings");
        if (jSONArrayM6824c2 == null) {
            iArr = null;
        } else {
            iArr = new int[3];
            try {
                if (jSONArrayM6824c2.length() != 3) {
                    throw new JSONException("lightSettings don't have all three fields");
                }
                int color = Color.parseColor(jSONArrayM6824c2.optString(0));
                if (color == -16777216) {
                    throw new IllegalArgumentException("Transparent color is invalid");
                }
                iArr[0] = color;
                iArr[1] = jSONArrayM6824c2.optInt(1);
                iArr[2] = jSONArrayM6824c2.optInt(2);
            } catch (IllegalArgumentException e3) {
                String strValueOf8 = String.valueOf(jSONArrayM6824c2);
                String message = e3.getMessage();
                C1643a.m874r0(C1643a.m831S(C1643a.m841b(message, strValueOf8.length() + 60), "LightSettings is invalid: ", strValueOf8, ". ", message), ". Skipping setting LightSettings", "NotificationParams");
                iArr = null;
            } catch (JSONException unused7) {
                String strValueOf9 = String.valueOf(jSONArrayM6824c2);
                C1643a.m856i0(strValueOf9.length() + 58, "LightSettings is invalid: ", strValueOf9, ". Skipping setting LightSettings", "NotificationParams");
                iArr = null;
            }
        }
        if (iArr != null) {
            builder.setLights(iArr[0], iArr[1], iArr[2]);
        }
        boolean zM6822a = c4880r.m6822a("gcm.n.default_sound");
        ?? r0 = zM6822a;
        if (c4880r.m6822a("gcm.n.default_vibrate_timings")) {
            r0 = (zM6822a ? 1 : 0) | 2;
        }
        int i4 = r0;
        if (c4880r.m6822a("gcm.n.default_light_settings")) {
            i4 = (r0 == true ? 1 : 0) | 4;
        }
        builder.setDefaults(i4);
        String strM6826e9 = c4880r.m6826e("gcm.n.tag");
        if (TextUtils.isEmpty(strM6826e9)) {
            long jUptimeMillis = SystemClock.uptimeMillis();
            StringBuilder sb2 = new StringBuilder(37);
            sb2.append("FCM-Notification:");
            sb2.append(jUptimeMillis);
            strM6826e9 = sb2.toString();
        }
        if (c4877o != null) {
            try {
                Task<Bitmap> task = c4877o.f13035k;
                Objects.requireNonNull(task, "null reference");
                Bitmap bitmap = (Bitmap) C3404f.m4307k(task, 5L, TimeUnit.SECONDS);
                builder.setLargeIcon(bitmap);
                builder.setStyle(new NotificationCompat.BigPictureStyle().bigPicture(bitmap).bigLargeIcon(null));
            } catch (InterruptedException unused8) {
                Log.w("FirebaseMessaging", "Interrupted while downloading image, showing notification without it");
                c4877o.close();
                Thread.currentThread().interrupt();
            } catch (ExecutionException e4) {
                String strValueOf10 = String.valueOf(e4.getCause());
                C1643a.m854h0(strValueOf10.length() + 26, "Failed to download image: ", strValueOf10, "FirebaseMessaging");
            } catch (TimeoutException unused9) {
                Log.w("FirebaseMessaging", "Failed to download image in time, showing notification without it");
                c4877o.close();
            }
        }
        if (Log.isLoggable("FirebaseMessaging", 3)) {
            Log.d("FirebaseMessaging", "Showing notification");
        }
        ((NotificationManager) this.f13015b.getSystemService("notification")).notify(strM6826e9, 0, builder.build());
        return true;
    }
}
