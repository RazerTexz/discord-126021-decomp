package com.google.android.gms.common;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.util.TypedValue;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.SimpleArrayMap;
import androidx.core.app.NotificationCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import b.c.a.a0.AnimatableValueParser;
import b.d.b.a.outline;
import b.i.a.f.e.b;
import b.i.a.f.e.c;
import b.i.a.f.e.e;
import b.i.a.f.e.g;
import b.i.a.f.e.h.j.b0;
import b.i.a.f.e.h.j.j;
import b.i.a.f.e.k.l;
import b.i.a.f.e.k.m;
import b.i.a.f.e.k.n;
import b.i.a.f.e.k.o;
import b.i.a.f.e.o.f;
import com.google.android.gms.common.api.internal.LifecycleCallback;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: com.google.android.gms:play-services-base@@17.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public class GoogleApiAvailability extends c {
    public static final Object c = new Object();
    public static final GoogleApiAvailability d = new GoogleApiAvailability();
    public static final int e = c.a;

    /* JADX INFO: compiled from: com.google.android.gms:play-services-base@@17.3.0 */
    @SuppressLint({"HandlerLeak"})
    public class a extends b.i.a.f.h.e.c {
        public final Context a;

        public a(Context context) {
            super(Looper.myLooper() == null ? Looper.getMainLooper() : Looper.myLooper());
            this.a = context.getApplicationContext();
        }

        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            int i = message.what;
            if (i != 1) {
                outline.g0(50, "Don't know how to handle this message: ", i, "GoogleApiAvailability");
                return;
            }
            int iC = GoogleApiAvailability.this.c(this.a);
            if (GoogleApiAvailability.this.d(iC)) {
                GoogleApiAvailability googleApiAvailability = GoogleApiAvailability.this;
                Context context = this.a;
                Intent intentA = googleApiAvailability.a(context, iC, "n");
                googleApiAvailability.i(context, iC, intentA == null ? null : PendingIntent.getActivity(context, 0, intentA, 134217728));
            }
        }
    }

    @Nullable
    public static Dialog g(@NonNull Context context, int i, n nVar, @Nullable DialogInterface.OnCancelListener onCancelListener) {
        String string;
        if (i == 0) {
            return null;
        }
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(android.R.attr.alertDialogTheme, typedValue, true);
        AlertDialog.Builder builder = "Theme.Dialog.Alert".equals(context.getResources().getResourceEntryName(typedValue.resourceId)) ? new AlertDialog.Builder(context, 5) : null;
        if (builder == null) {
            builder = new AlertDialog.Builder(context);
        }
        builder.setMessage(l.e(context, i));
        if (onCancelListener != null) {
            builder.setOnCancelListener(onCancelListener);
        }
        Resources resources = context.getResources();
        if (i == 1) {
            string = resources.getString(com.google.android.gms.base.R.b.common_google_play_services_install_button);
        } else if (i != 2) {
            string = i != 3 ? resources.getString(android.R.string.ok) : resources.getString(com.google.android.gms.base.R.b.common_google_play_services_enable_button);
        } else {
            string = resources.getString(com.google.android.gms.base.R.b.common_google_play_services_update_button);
        }
        if (string != null) {
            builder.setPositiveButton(string, nVar);
        }
        String strA = l.a(context, i);
        if (strA != null) {
            builder.setTitle(strA);
        }
        return builder.create();
    }

    public static void h(Activity activity, Dialog dialog, String str, @Nullable DialogInterface.OnCancelListener onCancelListener) {
        if (activity instanceof FragmentActivity) {
            FragmentManager supportFragmentManager = ((FragmentActivity) activity).getSupportFragmentManager();
            g gVar = new g();
            AnimatableValueParser.z(dialog, "Cannot display null dialog");
            dialog.setOnCancelListener(null);
            dialog.setOnDismissListener(null);
            gVar.j = dialog;
            if (onCancelListener != null) {
                gVar.k = onCancelListener;
            }
            gVar.show(supportFragmentManager, str);
            return;
        }
        android.app.FragmentManager fragmentManager = activity.getFragmentManager();
        b bVar = new b();
        AnimatableValueParser.z(dialog, "Cannot display null dialog");
        dialog.setOnCancelListener(null);
        dialog.setOnDismissListener(null);
        bVar.j = dialog;
        if (onCancelListener != null) {
            bVar.k = onCancelListener;
        }
        bVar.show(fragmentManager, str);
    }

    @Override // b.i.a.f.e.c
    @Nullable
    public Intent a(Context context, int i, @Nullable String str) {
        return super.a(context, i, str);
    }

    @Override // b.i.a.f.e.c
    public int b(Context context, int i) {
        return super.b(context, i);
    }

    public int c(Context context) {
        return b(context, c.a);
    }

    public final boolean d(int i) {
        AtomicBoolean atomicBoolean = e.a;
        return i == 1 || i == 2 || i == 3 || i == 9;
    }

    @NonNull
    @MainThread
    public Task<Void> e(Activity activity) throws PackageManager.NameNotFoundException {
        int i = e;
        AnimatableValueParser.u("makeGooglePlayServicesAvailable must be called from the main thread");
        int iB = super.b(activity, i);
        if (iB == 0) {
            return f.Z(null);
        }
        j jVarC = LifecycleCallback.c(activity);
        b0 b0Var = (b0) jVarC.d("GmsAvailabilityHelper", b0.class);
        if (b0Var == null) {
            b0Var = new b0(jVarC);
        } else if (b0Var.o.a.o()) {
            b0Var.o = new TaskCompletionSource<>();
        }
        b0Var.n(new ConnectionResult(iB, null), 0);
        return b0Var.o.a;
    }

    public boolean f(Activity activity, int i, int i2, @Nullable DialogInterface.OnCancelListener onCancelListener) {
        Dialog dialogG = g(activity, i, new m(super.a(activity, i, "d"), activity, i2), onCancelListener);
        if (dialogG == null) {
            return false;
        }
        h(activity, dialogG, "GooglePlayServicesErrorDialog", onCancelListener);
        return true;
    }

    @TargetApi(20)
    public final void i(Context context, int i, PendingIntent pendingIntent) {
        int i2;
        Log.w("GoogleApiAvailability", String.format("GMS core API Availability. ConnectionResult=%s, tag=%s", Integer.valueOf(i), null), new IllegalArgumentException());
        if (i == 18) {
            new a(context).sendEmptyMessageDelayed(1, 120000L);
            return;
        }
        if (pendingIntent == null) {
            if (i == 6) {
                Log.w("GoogleApiAvailability", "Missing resolution for ConnectionResult.RESOLUTION_REQUIRED. Call GoogleApiAvailability#showErrorNotification(Context, ConnectionResult) instead.");
                return;
            }
            return;
        }
        String strB = i == 6 ? l.b(context, "common_google_play_services_resolution_required_title") : l.a(context, i);
        if (strB == null) {
            strB = context.getResources().getString(com.google.android.gms.base.R.b.common_google_play_services_notification_ticker);
        }
        String strC = (i == 6 || i == 19) ? l.c(context, "common_google_play_services_resolution_required_text", l.d(context)) : l.e(context, i);
        Resources resources = context.getResources();
        NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
        NotificationCompat.Builder style = new NotificationCompat.Builder(context).setLocalOnly(true).setAutoCancel(true).setContentTitle(strB).setStyle(new NotificationCompat.BigTextStyle().bigText(strC));
        if (AnimatableValueParser.Z0(context)) {
            AnimatableValueParser.F(true);
            style.setSmallIcon(context.getApplicationInfo().icon).setPriority(2);
            if (AnimatableValueParser.a1(context)) {
                style.addAction(com.google.android.gms.base.R.a.common_full_open_on_phone, resources.getString(com.google.android.gms.base.R.b.common_open_on_phone), pendingIntent);
            } else {
                style.setContentIntent(pendingIntent);
            }
        } else {
            style.setSmallIcon(android.R.drawable.stat_sys_warning).setTicker(resources.getString(com.google.android.gms.base.R.b.common_google_play_services_notification_ticker)).setWhen(System.currentTimeMillis()).setContentIntent(pendingIntent).setContentText(strC);
        }
        if (f.A0()) {
            AnimatableValueParser.F(f.A0());
            synchronized (c) {
            }
            NotificationChannel notificationChannel = notificationManager.getNotificationChannel("com.google.android.gms.availability");
            SimpleArrayMap<String, String> simpleArrayMap = l.a;
            String string = context.getResources().getString(com.google.android.gms.base.R.b.common_google_play_services_notification_channel_name);
            if (notificationChannel == null) {
                notificationManager.createNotificationChannel(new NotificationChannel("com.google.android.gms.availability", string, 4));
            } else if (!string.contentEquals(notificationChannel.getName())) {
                notificationChannel.setName(string);
                notificationManager.createNotificationChannel(notificationChannel);
            }
            style.setChannelId("com.google.android.gms.availability");
        }
        Notification notificationBuild = style.build();
        if (i == 1 || i == 2 || i == 3) {
            i2 = 10436;
            e.a.set(false);
        } else {
            i2 = 39789;
        }
        notificationManager.notify(i2, notificationBuild);
    }

    public final boolean j(@NonNull Activity activity, @NonNull j jVar, int i, @Nullable DialogInterface.OnCancelListener onCancelListener) {
        Dialog dialogG = g(activity, i, new o(super.a(activity, i, "d"), jVar, 2), onCancelListener);
        if (dialogG == null) {
            return false;
        }
        h(activity, dialogG, "GooglePlayServicesErrorDialog", onCancelListener);
        return true;
    }
}
