package b.i.c.w;

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
import b.d.b.a.outline;
import com.esotericsoftware.kryo.io.Util;
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

/* JADX INFO: compiled from: com.google.firebase:firebase-messaging@@21.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public class c {
    public final Executor a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Context f1794b;
    public final r c;

    public c(Context context, r rVar, Executor executor) {
        this.a = executor;
        this.f1794b = context;
        this.c = rVar;
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
    public boolean a() {
        boolean z2;
        final o oVar;
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
        if (this.c.a("gcm.n.noui")) {
            return true;
        }
        if (!((KeyguardManager) this.f1794b.getSystemService("keyguard")).inKeyguardRestrictedInputMode()) {
            int iMyPid = Process.myPid();
            List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) this.f1794b.getSystemService(ActivityChooserModel.ATTRIBUTE_ACTIVITY)).getRunningAppProcesses();
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
        String strE = this.c.e("gcm.n.image");
        if (TextUtils.isEmpty(strE)) {
            oVar = null;
        } else {
            try {
                oVar = new o(new URL(strE));
            } catch (MalformedURLException unused) {
                String strValueOf = String.valueOf(strE);
                Log.w("FirebaseMessaging", strValueOf.length() != 0 ? "Not downloading image, bad URL: ".concat(strValueOf) : new String("Not downloading image, bad URL: "));
                oVar = null;
            }
        }
        if (oVar != null) {
            oVar.k = b.i.a.f.e.o.f.o(this.a, new Callable(oVar) { // from class: b.i.c.w.n
                public final o j;

                {
                    this.j = oVar;
                }

                @Override // java.util.concurrent.Callable
                public final Object call() throws IOException {
                    byte[] bArrA;
                    o oVar2 = this.j;
                    String strValueOf2 = String.valueOf(oVar2.j);
                    StringBuilder sb = new StringBuilder(strValueOf2.length() + 22);
                    sb.append("Starting download of: ");
                    sb.append(strValueOf2);
                    Log.i("FirebaseMessaging", sb.toString());
                    URLConnection uRLConnectionOpenConnection = oVar2.j.openConnection();
                    if (uRLConnectionOpenConnection.getContentLength() > 1048576) {
                        throw new IOException("Content-Length exceeds max size of 1048576");
                    }
                    InputStream inputStream = uRLConnectionOpenConnection.getInputStream();
                    try {
                        oVar2.l = inputStream;
                        int i3 = b.i.a.f.h.i.b.a;
                        b.i.a.f.h.i.d dVar = new b.i.a.f.h.i.d(inputStream);
                        ArrayDeque arrayDeque = new ArrayDeque(20);
                        int i4 = 8192;
                        int i5 = 0;
                        loop0: while (true) {
                            if (i5 >= 2147483639) {
                                if (dVar.read() != -1) {
                                    throw new OutOfMemoryError("input is too large to fit in a byte array");
                                }
                                bArrA = b.i.a.f.h.i.b.a(arrayDeque, Util.MAX_SAFE_ARRAY_SIZE);
                                break;
                            }
                            int iMin = Math.min(i4, Util.MAX_SAFE_ARRAY_SIZE - i5);
                            byte[] bArr = new byte[iMin];
                            arrayDeque.add(bArr);
                            int i6 = 0;
                            while (i6 < iMin) {
                                int i7 = dVar.read(bArr, i6, iMin - i6);
                                if (i7 == -1) {
                                    bArrA = b.i.a.f.h.i.b.a(arrayDeque, i5);
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
                            int length = bArrA.length;
                            String strValueOf3 = String.valueOf(oVar2.j);
                            StringBuilder sb2 = new StringBuilder(strValueOf3.length() + 34);
                            sb2.append("Downloaded ");
                            sb2.append(length);
                            sb2.append(" bytes from ");
                            sb2.append(strValueOf3);
                            Log.v("FirebaseMessaging", sb2.toString());
                        }
                        if (bArrA.length > 1048576) {
                            throw new IOException("Image exceeds max size of 1048576");
                        }
                        Bitmap bitmapDecodeByteArray = BitmapFactory.decodeByteArray(bArrA, 0, bArrA.length);
                        if (bitmapDecodeByteArray == null) {
                            String strValueOf4 = String.valueOf(oVar2.j);
                            throw new IOException(outline.j(strValueOf4.length() + 24, "Failed to decode image: ", strValueOf4));
                        }
                        if (Log.isLoggable("FirebaseMessaging", 3)) {
                            String strValueOf5 = String.valueOf(oVar2.j);
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
                                b.i.a.f.h.i.e.a.a(th, th2);
                            }
                        }
                        throw th;
                    }
                }
            });
        }
        Context context = this.f1794b;
        r rVar = this.c;
        AtomicInteger atomicInteger = a.a;
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
            if (applicationInfo == null || (bundle = applicationInfo.metaData) == null) {
                bundle = Bundle.EMPTY;
            }
        } catch (PackageManager.NameNotFoundException e) {
            String strValueOf2 = String.valueOf(e);
            outline.h0(strValueOf2.length() + 35, "Couldn't get own application info: ", strValueOf2, "FirebaseMessaging");
        }
        String packageName = context.getPackageName();
        String strE2 = rVar.e("gcm.n.android_channel_id");
        if (Build.VERSION.SDK_INT < 26) {
            strE2 = null;
        } else {
            try {
                if (context.getPackageManager().getApplicationInfo(context.getPackageName(), 0).targetSdkVersion < 26) {
                    strE2 = null;
                } else {
                    NotificationManager notificationManager = (NotificationManager) context.getSystemService(NotificationManager.class);
                    if (TextUtils.isEmpty(strE2)) {
                        strE2 = bundle.getString("com.google.firebase.messaging.default_notification_channel_id");
                        if (!TextUtils.isEmpty(strE2)) {
                            Log.w("FirebaseMessaging", "Missing Default Notification Channel metadata in AndroidManifest. Default value will be used.");
                        } else if (notificationManager.getNotificationChannel(strE2) == null) {
                            Log.w("FirebaseMessaging", "Notification Channel set in AndroidManifest.xml has not been created by the app. Default value will be used.");
                        }
                        strE2 = "fcm_fallback_notification_channel";
                        if (notificationManager.getNotificationChannel("fcm_fallback_notification_channel") == null) {
                            notificationManager.createNotificationChannel(new NotificationChannel("fcm_fallback_notification_channel", context.getString(context.getResources().getIdentifier("fcm_fallback_notification_channel_label", "string", context.getPackageName())), 3));
                        }
                    } else if (notificationManager.getNotificationChannel(strE2) == null) {
                        outline.i0(outline.b(strE2, 122), "Notification Channel requested (", strE2, ") has not been created by the app. Manifest configuration, or default, value will be used.", "FirebaseMessaging");
                        strE2 = bundle.getString("com.google.firebase.messaging.default_notification_channel_id");
                        if (!TextUtils.isEmpty(strE2)) {
                            Log.w("FirebaseMessaging", "Missing Default Notification Channel metadata in AndroidManifest. Default value will be used.");
                        } else if (notificationManager.getNotificationChannel(strE2) == null) {
                            Log.w("FirebaseMessaging", "Notification Channel set in AndroidManifest.xml has not been created by the app. Default value will be used.");
                        }
                        strE2 = "fcm_fallback_notification_channel";
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
        NotificationCompat.Builder builder = new NotificationCompat.Builder(context, strE2);
        CharSequence charSequenceD = rVar.d(resources, packageName, "gcm.n.title");
        if (!TextUtils.isEmpty(charSequenceD)) {
            builder.setContentTitle(charSequenceD);
        }
        CharSequence charSequenceD2 = rVar.d(resources, packageName, "gcm.n.body");
        if (!TextUtils.isEmpty(charSequenceD2)) {
            builder.setContentText(charSequenceD2);
            builder.setStyle(new NotificationCompat.BigTextStyle().bigText(charSequenceD2));
        }
        String strE3 = rVar.e("gcm.n.icon");
        if (TextUtils.isEmpty(strE3)) {
            i = bundle.getInt("com.google.firebase.messaging.default_notification_icon", 0);
            if (i == 0 && a.b(resources, i)) {
                identifier = i;
            } else {
                try {
                } catch (PackageManager.NameNotFoundException e2) {
                    String strValueOf3 = String.valueOf(e2);
                    outline.h0(strValueOf3.length() + 35, "Couldn't get own application info: ", strValueOf3, "FirebaseMessaging");
                    identifier = i;
                }
            }
            if (identifier != 0 || !a.b(resources, identifier)) {
                identifier = R.drawable.sym_def_app_icon;
            }
        } else {
            identifier = resources.getIdentifier(strE3, "drawable", packageName);
            if ((identifier == 0 || !a.b(resources, identifier)) && ((identifier = resources.getIdentifier(strE3, "mipmap", packageName)) == 0 || !a.b(resources, identifier))) {
                outline.i0(outline.b(strE3, 61), "Icon resource ", strE3, " not found. Notification will use default icon.", "FirebaseMessaging");
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
        String strE4 = rVar.e("gcm.n.sound2");
        if (TextUtils.isEmpty(strE4)) {
            strE4 = rVar.e("gcm.n.sound");
        }
        if (TextUtils.isEmpty(strE4)) {
            defaultUri = null;
        } else if ("default".equals(strE4) || resources.getIdentifier(strE4, "raw", packageName) == 0) {
            defaultUri = RingtoneManager.getDefaultUri(2);
        } else {
            StringBuilder sb = new StringBuilder(outline.b(strE4, outline.b(packageName, 24)));
            sb.append("android.resource://");
            sb.append(packageName);
            sb.append("/raw/");
            sb.append(strE4);
            defaultUri = Uri.parse(sb.toString());
        }
        if (defaultUri != null) {
            builder.setSound(defaultUri);
        }
        String strE5 = rVar.e("gcm.n.click_action");
        if (TextUtils.isEmpty(strE5)) {
            String strE6 = rVar.e("gcm.n.link_android");
            if (TextUtils.isEmpty(strE6)) {
                strE6 = rVar.e("gcm.n.link");
            }
            Uri uri = !TextUtils.isEmpty(strE6) ? Uri.parse(strE6) : null;
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
            launchIntentForPackage = new Intent(strE5);
            launchIntentForPackage.setPackage(packageName);
            launchIntentForPackage.setFlags(268435456);
        }
        if (launchIntentForPackage == null) {
            activity = null;
        } else {
            launchIntentForPackage.addFlags(67108864);
            Bundle bundle2 = new Bundle(rVar.a);
            for (String str : rVar.a.keySet()) {
                if (str.startsWith("google.c.") || str.startsWith("gcm.n.") || str.startsWith("gcm.notification.")) {
                    bundle2.remove(str);
                }
            }
            launchIntentForPackage.putExtras(bundle2);
            activity = PendingIntent.getActivity(context, a.a.incrementAndGet(), launchIntentForPackage, BasicMeasure.EXACTLY);
            if (rVar.a("google.c.a.e")) {
                activity = a.a(context, new Intent("com.google.firebase.messaging.NOTIFICATION_OPEN").putExtras(rVar.g()).putExtra("pending_intent", activity));
            }
        }
        builder.setContentIntent(activity);
        PendingIntent pendingIntentA = !rVar.a("google.c.a.e") ? null : a.a(context, new Intent("com.google.firebase.messaging.NOTIFICATION_DISMISS").putExtras(rVar.g()));
        if (pendingIntentA != null) {
            builder.setDeleteIntent(pendingIntentA);
        }
        String strE7 = rVar.e("gcm.n.color");
        if (TextUtils.isEmpty(strE7)) {
            i2 = bundle.getInt("com.google.firebase.messaging.default_notification_color", 0);
            if (i2 != 0) {
                numValueOf = Integer.valueOf(ContextCompat.getColor(context, i2));
            } else {
                numValueOf = null;
            }
        } else {
            try {
                numValueOf = Integer.valueOf(Color.parseColor(strE7));
            } catch (IllegalArgumentException unused3) {
                outline.i0(outline.b(strE7, 56), "Color is invalid: ", strE7, ". Notification will use default color.", "FirebaseMessaging");
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
        builder.setAutoCancel(!rVar.a("gcm.n.sticky"));
        builder.setLocalOnly(rVar.a("gcm.n.local_only"));
        CharSequence charSequenceE = rVar.e("gcm.n.ticker");
        if (charSequenceE != null) {
            builder.setTicker(charSequenceE);
        }
        Integer numB = rVar.b("gcm.n.notification_priority");
        if (numB == null) {
            numB = null;
        } else if (numB.intValue() < -2 || numB.intValue() > 2) {
            String strValueOf4 = String.valueOf(numB);
            outline.i0(strValueOf4.length() + 72, "notificationPriority is invalid ", strValueOf4, ". Skipping setting notificationPriority.", "FirebaseMessaging");
            numB = null;
        }
        if (numB != null) {
            builder.setPriority(numB.intValue());
        }
        Integer numB2 = rVar.b("gcm.n.visibility");
        if (numB2 == null) {
            numB2 = null;
        } else if (numB2.intValue() < -1 || numB2.intValue() > 1) {
            String strValueOf5 = String.valueOf(numB2);
            outline.i0(strValueOf5.length() + 53, "visibility is invalid: ", strValueOf5, ". Skipping setting visibility.", "NotificationParams");
            numB2 = null;
        }
        if (numB2 != null) {
            builder.setVisibility(numB2.intValue());
        }
        Integer numB3 = rVar.b("gcm.n.notification_count");
        if (numB3 == null) {
            numB3 = null;
        } else if (numB3.intValue() < 0) {
            String strValueOf6 = String.valueOf(numB3);
            outline.i0(strValueOf6.length() + 67, "notificationCount is invalid: ", strValueOf6, ". Skipping setting notificationCount.", "FirebaseMessaging");
            numB3 = null;
        }
        if (numB3 != null) {
            builder.setNumber(numB3.intValue());
        }
        String strE8 = rVar.e("gcm.n.event_time");
        if (TextUtils.isEmpty(strE8)) {
            lValueOf = null;
        } else {
            try {
                lValueOf = Long.valueOf(Long.parseLong(strE8));
            } catch (NumberFormatException unused5) {
                String strH = r.h("gcm.n.event_time");
                outline.r0(outline.S(outline.b(strE8, outline.b(strH, 38)), "Couldn't parse value of ", strH, "(", strE8), ") into a long", "NotificationParams");
                lValueOf = null;
            }
        }
        if (lValueOf != null) {
            builder.setShowWhen(true);
            builder.setWhen(lValueOf.longValue());
        }
        JSONArray jSONArrayC = rVar.c("gcm.n.vibrate_timings");
        if (jSONArrayC == null) {
            jArr = null;
        } else {
            try {
                if (jSONArrayC.length() <= 1) {
                    throw new JSONException("vibrateTimings have invalid length");
                }
                int length = jSONArrayC.length();
                jArr = new long[length];
                for (int i3 = 0; i3 < length; i3++) {
                    jArr[i3] = jSONArrayC.optLong(i3);
                }
            } catch (NumberFormatException | JSONException unused6) {
                String strValueOf7 = String.valueOf(jSONArrayC);
                outline.i0(strValueOf7.length() + 74, "User defined vibrateTimings is invalid: ", strValueOf7, ". Skipping setting vibrateTimings.", "NotificationParams");
                jArr = null;
            }
        }
        if (jArr != null) {
            builder.setVibrate(jArr);
        }
        JSONArray jSONArrayC2 = rVar.c("gcm.n.light_settings");
        if (jSONArrayC2 == null) {
            iArr = null;
        } else {
            iArr = new int[3];
            try {
                if (jSONArrayC2.length() != 3) {
                    throw new JSONException("lightSettings don't have all three fields");
                }
                int color = Color.parseColor(jSONArrayC2.optString(0));
                if (color == -16777216) {
                    throw new IllegalArgumentException("Transparent color is invalid");
                }
                iArr[0] = color;
                iArr[1] = jSONArrayC2.optInt(1);
                iArr[2] = jSONArrayC2.optInt(2);
            } catch (IllegalArgumentException e3) {
                String strValueOf8 = String.valueOf(jSONArrayC2);
                String message = e3.getMessage();
                outline.r0(outline.S(outline.b(message, strValueOf8.length() + 60), "LightSettings is invalid: ", strValueOf8, ". ", message), ". Skipping setting LightSettings", "NotificationParams");
                iArr = null;
            } catch (JSONException unused7) {
                String strValueOf9 = String.valueOf(jSONArrayC2);
                outline.i0(strValueOf9.length() + 58, "LightSettings is invalid: ", strValueOf9, ". Skipping setting LightSettings", "NotificationParams");
                iArr = null;
            }
        }
        if (iArr != null) {
            builder.setLights(iArr[0], iArr[1], iArr[2]);
        }
        boolean zA = rVar.a("gcm.n.default_sound");
        ?? r0 = zA;
        if (rVar.a("gcm.n.default_vibrate_timings")) {
            r0 = (zA ? 1 : 0) | 2;
        }
        int i4 = r0;
        if (rVar.a("gcm.n.default_light_settings")) {
            i4 = (r0 == true ? 1 : 0) | 4;
        }
        builder.setDefaults(i4);
        String strE9 = rVar.e("gcm.n.tag");
        if (TextUtils.isEmpty(strE9)) {
            long jUptimeMillis = SystemClock.uptimeMillis();
            StringBuilder sb2 = new StringBuilder(37);
            sb2.append("FCM-Notification:");
            sb2.append(jUptimeMillis);
            strE9 = sb2.toString();
        }
        if (oVar != null) {
            try {
                Task<Bitmap> task = oVar.k;
                Objects.requireNonNull(task, "null reference");
                Bitmap bitmap = (Bitmap) b.i.a.f.e.o.f.k(task, 5L, TimeUnit.SECONDS);
                builder.setLargeIcon(bitmap);
                builder.setStyle(new NotificationCompat.BigPictureStyle().bigPicture(bitmap).bigLargeIcon(null));
            } catch (InterruptedException unused8) {
                Log.w("FirebaseMessaging", "Interrupted while downloading image, showing notification without it");
                oVar.close();
                Thread.currentThread().interrupt();
            } catch (ExecutionException e4) {
                String strValueOf10 = String.valueOf(e4.getCause());
                outline.h0(strValueOf10.length() + 26, "Failed to download image: ", strValueOf10, "FirebaseMessaging");
            } catch (TimeoutException unused9) {
                Log.w("FirebaseMessaging", "Failed to download image in time, showing notification without it");
                oVar.close();
            }
        }
        if (Log.isLoggable("FirebaseMessaging", 3)) {
            Log.d("FirebaseMessaging", "Showing notification");
        }
        ((NotificationManager) this.f1794b.getSystemService("notification")).notify(strE9, 0, builder.build());
        return true;
    }
}
