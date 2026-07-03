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
import com.google.android.gms.base.C10796R;
import com.google.android.gms.common.api.internal.LifecycleCallback;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.concurrent.atomic.AtomicBoolean;
import p007b.p085c.p086a.p087a0.C1460d;
import p007b.p100d.p104b.p105a.C1643a;
import p007b.p225i.p226a.p288f.p299e.C3256c;
import p007b.p225i.p226a.p288f.p299e.C3260e;
import p007b.p225i.p226a.p288f.p299e.C3264g;
import p007b.p225i.p226a.p288f.p299e.DialogFragmentC3254b;
import p007b.p225i.p226a.p288f.p299e.p300h.p301j.C3279b0;
import p007b.p225i.p226a.p288f.p299e.p300h.p301j.InterfaceC3299j;
import p007b.p225i.p226a.p288f.p299e.p304k.AbstractDialogInterfaceOnClickListenerC3369n;
import p007b.p225i.p226a.p288f.p299e.p304k.C3365l;
import p007b.p225i.p226a.p288f.p299e.p304k.C3367m;
import p007b.p225i.p226a.p288f.p299e.p304k.C3371o;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;
import p007b.p225i.p226a.p288f.p313h.p318e.HandlerC3479c;

/* JADX INFO: compiled from: com.google.android.gms:play-services-base@@17.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public class GoogleApiAvailability extends C3256c {

    /* JADX INFO: renamed from: c */
    public static final Object f20480c = new Object();

    /* JADX INFO: renamed from: d */
    public static final GoogleApiAvailability f20481d = new GoogleApiAvailability();

    /* JADX INFO: renamed from: e */
    public static final int f20482e = C3256c.f9306a;

    /* JADX INFO: renamed from: com.google.android.gms.common.GoogleApiAvailability$a */
    /* JADX INFO: compiled from: com.google.android.gms:play-services-base@@17.3.0 */
    @SuppressLint({"HandlerLeak"})
    public class HandlerC10799a extends HandlerC3479c {

        /* JADX INFO: renamed from: a */
        public final Context f20483a;

        public HandlerC10799a(Context context) {
            super(Looper.myLooper() == null ? Looper.getMainLooper() : Looper.myLooper());
            this.f20483a = context.getApplicationContext();
        }

        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            int i = message.what;
            if (i != 1) {
                C1643a.m852g0(50, "Don't know how to handle this message: ", i, "GoogleApiAvailability");
                return;
            }
            int iM9024c = GoogleApiAvailability.this.m9024c(this.f20483a);
            if (GoogleApiAvailability.this.m9025d(iM9024c)) {
                GoogleApiAvailability googleApiAvailability = GoogleApiAvailability.this;
                Context context = this.f20483a;
                Intent intentMo4017a = googleApiAvailability.mo4017a(context, iM9024c, "n");
                googleApiAvailability.m9028i(context, iM9024c, intentMo4017a == null ? null : PendingIntent.getActivity(context, 0, intentMo4017a, 134217728));
            }
        }
    }

    @Nullable
    /* JADX INFO: renamed from: g */
    public static Dialog m9022g(@NonNull Context context, int i, AbstractDialogInterfaceOnClickListenerC3369n abstractDialogInterfaceOnClickListenerC3369n, @Nullable DialogInterface.OnCancelListener onCancelListener) {
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
        builder.setMessage(C3365l.m4170e(context, i));
        if (onCancelListener != null) {
            builder.setOnCancelListener(onCancelListener);
        }
        Resources resources = context.getResources();
        if (i == 1) {
            string = resources.getString(C10796R.b.common_google_play_services_install_button);
        } else if (i != 2) {
            string = i != 3 ? resources.getString(android.R.string.ok) : resources.getString(C10796R.b.common_google_play_services_enable_button);
        } else {
            string = resources.getString(C10796R.b.common_google_play_services_update_button);
        }
        if (string != null) {
            builder.setPositiveButton(string, abstractDialogInterfaceOnClickListenerC3369n);
        }
        String strM4166a = C3365l.m4166a(context, i);
        if (strM4166a != null) {
            builder.setTitle(strM4166a);
        }
        return builder.create();
    }

    /* JADX INFO: renamed from: h */
    public static void m9023h(Activity activity, Dialog dialog, String str, @Nullable DialogInterface.OnCancelListener onCancelListener) {
        if (activity instanceof FragmentActivity) {
            FragmentManager supportFragmentManager = ((FragmentActivity) activity).getSupportFragmentManager();
            C3264g c3264g = new C3264g();
            C1460d.m595z(dialog, "Cannot display null dialog");
            dialog.setOnCancelListener(null);
            dialog.setOnDismissListener(null);
            c3264g.f9317j = dialog;
            if (onCancelListener != null) {
                c3264g.f9318k = onCancelListener;
            }
            c3264g.show(supportFragmentManager, str);
            return;
        }
        android.app.FragmentManager fragmentManager = activity.getFragmentManager();
        DialogFragmentC3254b dialogFragmentC3254b = new DialogFragmentC3254b();
        C1460d.m595z(dialog, "Cannot display null dialog");
        dialog.setOnCancelListener(null);
        dialog.setOnDismissListener(null);
        dialogFragmentC3254b.f9299j = dialog;
        if (onCancelListener != null) {
            dialogFragmentC3254b.f9300k = onCancelListener;
        }
        dialogFragmentC3254b.show(fragmentManager, str);
    }

    @Override // p007b.p225i.p226a.p288f.p299e.C3256c
    @Nullable
    /* JADX INFO: renamed from: a */
    public Intent mo4017a(Context context, int i, @Nullable String str) {
        return super.mo4017a(context, i, str);
    }

    @Override // p007b.p225i.p226a.p288f.p299e.C3256c
    /* JADX INFO: renamed from: b */
    public int mo4018b(Context context, int i) {
        return super.mo4018b(context, i);
    }

    /* JADX INFO: renamed from: c */
    public int m9024c(Context context) {
        return mo4018b(context, C3256c.f9306a);
    }

    /* JADX INFO: renamed from: d */
    public final boolean m9025d(int i) {
        AtomicBoolean atomicBoolean = C3260e.f9309a;
        return i == 1 || i == 2 || i == 3 || i == 9;
    }

    @NonNull
    @MainThread
    /* JADX INFO: renamed from: e */
    public Task<Void> m9026e(Activity activity) throws PackageManager.NameNotFoundException {
        int i = f20482e;
        C1460d.m575u("makeGooglePlayServicesAvailable must be called from the main thread");
        int iMo4018b = super.mo4018b(activity, i);
        if (iMo4018b == 0) {
            return C3404f.m4264Z(null);
        }
        InterfaceC3299j interfaceC3299jM9038c = LifecycleCallback.m9038c(activity);
        C3279b0 c3279b0 = (C3279b0) interfaceC3299jM9038c.mo4070d("GmsAvailabilityHelper", C3279b0.class);
        if (c3279b0 == null) {
            c3279b0 = new C3279b0(interfaceC3299jM9038c);
        } else if (c3279b0.f9348o.f20845a.mo6020o()) {
            c3279b0.f9348o = new TaskCompletionSource<>();
        }
        c3279b0.m4119n(new ConnectionResult(iMo4018b, null), 0);
        return c3279b0.f9348o.f20845a;
    }

    /* JADX INFO: renamed from: f */
    public boolean m9027f(Activity activity, int i, int i2, @Nullable DialogInterface.OnCancelListener onCancelListener) {
        Dialog dialogM9022g = m9022g(activity, i, new C3367m(super.mo4017a(activity, i, "d"), activity, i2), onCancelListener);
        if (dialogM9022g == null) {
            return false;
        }
        m9023h(activity, dialogM9022g, "GooglePlayServicesErrorDialog", onCancelListener);
        return true;
    }

    @TargetApi(20)
    /* JADX INFO: renamed from: i */
    public final void m9028i(Context context, int i, PendingIntent pendingIntent) {
        int i2;
        Log.w("GoogleApiAvailability", String.format("GMS core API Availability. ConnectionResult=%s, tag=%s", Integer.valueOf(i), null), new IllegalArgumentException());
        if (i == 18) {
            new HandlerC10799a(context).sendEmptyMessageDelayed(1, 120000L);
            return;
        }
        if (pendingIntent == null) {
            if (i == 6) {
                Log.w("GoogleApiAvailability", "Missing resolution for ConnectionResult.RESOLUTION_REQUIRED. Call GoogleApiAvailability#showErrorNotification(Context, ConnectionResult) instead.");
                return;
            }
            return;
        }
        String strM4167b = i == 6 ? C3365l.m4167b(context, "common_google_play_services_resolution_required_title") : C3365l.m4166a(context, i);
        if (strM4167b == null) {
            strM4167b = context.getResources().getString(C10796R.b.common_google_play_services_notification_ticker);
        }
        String strM4168c = (i == 6 || i == 19) ? C3365l.m4168c(context, "common_google_play_services_resolution_required_text", C3365l.m4169d(context)) : C3365l.m4170e(context, i);
        Resources resources = context.getResources();
        NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
        NotificationCompat.Builder style = new NotificationCompat.Builder(context).setLocalOnly(true).setAutoCancel(true).setContentTitle(strM4167b).setStyle(new NotificationCompat.BigTextStyle().bigText(strM4168c));
        if (C1460d.m493Z0(context)) {
            C1460d.m432F(true);
            style.setSmallIcon(context.getApplicationInfo().icon).setPriority(2);
            if (C1460d.m497a1(context)) {
                style.addAction(C10796R.a.common_full_open_on_phone, resources.getString(C10796R.b.common_open_on_phone), pendingIntent);
            } else {
                style.setContentIntent(pendingIntent);
            }
        } else {
            style.setSmallIcon(android.R.drawable.stat_sys_warning).setTicker(resources.getString(C10796R.b.common_google_play_services_notification_ticker)).setWhen(System.currentTimeMillis()).setContentIntent(pendingIntent).setContentText(strM4168c);
        }
        if (C3404f.m4190A0()) {
            C1460d.m432F(C3404f.m4190A0());
            synchronized (f20480c) {
            }
            NotificationChannel notificationChannel = notificationManager.getNotificationChannel("com.google.android.gms.availability");
            SimpleArrayMap<String, String> simpleArrayMap = C3365l.f9534a;
            String string = context.getResources().getString(C10796R.b.common_google_play_services_notification_channel_name);
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
            C3260e.f9309a.set(false);
        } else {
            i2 = 39789;
        }
        notificationManager.notify(i2, notificationBuild);
    }

    /* JADX INFO: renamed from: j */
    public final boolean m9029j(@NonNull Activity activity, @NonNull InterfaceC3299j interfaceC3299j, int i, @Nullable DialogInterface.OnCancelListener onCancelListener) {
        Dialog dialogM9022g = m9022g(activity, i, new C3371o(super.mo4017a(activity, i, "d"), interfaceC3299j, 2), onCancelListener);
        if (dialogM9022g == null) {
            return false;
        }
        m9023h(activity, dialogM9022g, "GooglePlayServicesErrorDialog", onCancelListener);
        return true;
    }
}
