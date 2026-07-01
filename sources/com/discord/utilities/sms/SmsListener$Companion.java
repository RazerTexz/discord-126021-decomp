package com.discord.utilities.sms;

import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.IntentFilter;
import b.c.a.a0.d;
import b.i.a.f.e.h.j.k0;
import b.i.a.f.e.h.j.p$a;
import b.i.a.f.h.b.b;
import b.i.a.f.h.b.h;
import b.i.a.f.h.b.j;
import com.discord.utilities.lifecycle.ApplicationProvider;
import com.discord.widgets.auth.SmsAuthCodeBroadcastReceiver;
import com.google.android.gms.common.Feature;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: SmsListener.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class SmsListener$Companion {
    private SmsListener$Companion() {
    }

    public final BroadcastReceiver getBroadcastReceiver() {
        return SmsListener.access$getBroadcastReceiver$cp();
    }

    public final void setBroadcastReceiver(BroadcastReceiver broadcastReceiver) {
        SmsListener.access$setBroadcastReceiver$cp(broadcastReceiver);
    }

    public final void startSmsListener(Function1<? super String, Unit> onSuccess) {
        m.checkNotNullParameter(onSuccess, "onSuccess");
        Application application = ApplicationProvider.INSTANCE.get();
        h hVar = new h(application);
        p$a p_a = new p$a(null);
        p_a.a = new j(hVar);
        p_a.f1370b = new Feature[]{b.f1404b};
        d.o(true, "execute parameter required");
        hVar.c(new k0(p_a, p_a.f1370b, true));
        setBroadcastReceiver(new SmsAuthCodeBroadcastReceiver(onSuccess));
        application.registerReceiver(getBroadcastReceiver(), new IntentFilter("com.google.android.gms.auth.api.phone.SMS_RETRIEVED"));
    }

    public final void stopSmsListener() {
        try {
            ApplicationProvider.INSTANCE.get().unregisterReceiver(getBroadcastReceiver());
        } catch (Exception unused) {
        }
    }

    public /* synthetic */ SmsListener$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
