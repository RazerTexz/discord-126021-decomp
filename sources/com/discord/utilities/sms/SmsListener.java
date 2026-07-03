package com.discord.utilities.sms;

import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.IntentFilter;
import com.discord.utilities.lifecycle.ApplicationProvider;
import com.discord.widgets.auth.SmsAuthCodeBroadcastReceiver;
import com.google.android.gms.common.Feature;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p007b.p085c.p086a.p087a0.C1460d;
import p007b.p225i.p226a.p288f.p299e.p300h.p301j.AbstractC3311p;
import p007b.p225i.p226a.p288f.p299e.p300h.p301j.C3302k0;
import p007b.p225i.p226a.p288f.p313h.p315b.C3442b;
import p007b.p225i.p226a.p288f.p313h.p315b.C3448h;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: SmsListener.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class SmsListener {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static BroadcastReceiver broadcastReceiver;

    /* JADX INFO: compiled from: SmsListener.kt */
    public static final class Companion {
        private Companion() {
        }

        public final BroadcastReceiver getBroadcastReceiver() {
            return SmsListener.broadcastReceiver;
        }

        public final void setBroadcastReceiver(BroadcastReceiver broadcastReceiver) {
            SmsListener.broadcastReceiver = broadcastReceiver;
        }

        /* JADX WARN: Type inference failed for: r3v1, types: [b.i.a.f.h.b.j, b.i.a.f.h.b.j<A extends b.i.a.f.e.h.a$b, com.google.android.gms.tasks.TaskCompletionSource<ResultT>>] */
        public final void startSmsListener(Function1<? super String, Unit> onSuccess) {
            C12238m.checkNotNullParameter(onSuccess, "onSuccess");
            Application application = ApplicationProvider.INSTANCE.get();
            final C3448h c3448h = new C3448h(application);
            AbstractC3311p.a aVar = new AbstractC3311p.a(null);
            aVar.f9440a = new Object(c3448h) { // from class: b.i.a.f.h.b.j

                /* JADX INFO: renamed from: a */
                public final C3448h f9632a;

                {
                    this.f9632a = c3448h;
                }
            };
            aVar.f9441b = new Feature[]{C3442b.f9626b};
            C1460d.m551o(true, "execute parameter required");
            c3448h.m4046c(new C3302k0(aVar, aVar.f9441b, true));
            setBroadcastReceiver(new SmsAuthCodeBroadcastReceiver(onSuccess));
            application.registerReceiver(getBroadcastReceiver(), new IntentFilter("com.google.android.gms.auth.api.phone.SMS_RETRIEVED"));
        }

        public final void stopSmsListener() {
            try {
                ApplicationProvider.INSTANCE.get().unregisterReceiver(getBroadcastReceiver());
            } catch (Exception unused) {
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }
}
