package com.discord.utilities.analytics;

import b.i.a.f.h.l.g;
import b.i.a.f.h.l.n;
import com.discord.app.AppLog;
import com.discord.models.user.MeUser;
import com.discord.utilities.user.UserUtils;
import com.google.firebase.analytics.FirebaseAnalytics;
import d0.z.d.m;
import d0.z.d.o;
import java.util.Objects;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: AnalyticsUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class AnalyticsUtils$initAppOpen$1 extends o implements Function1<MeUser, Unit> {
    public static final AnalyticsUtils$initAppOpen$1 INSTANCE = new AnalyticsUtils$initAppOpen$1();

    public AnalyticsUtils$initAppOpen$1() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(MeUser meUser) {
        invoke2(meUser);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(MeUser meUser) {
        m.checkNotNullParameter(meUser, "meUser");
        if (m.areEqual(meUser, UserUtils.INSTANCE.getEMPTY_USER())) {
            AppLog.g(0L, null, null);
            FirebaseAnalytics firebaseAnalyticsAccess$getFireBaseInstance$p = AnalyticsUtils.access$getFireBaseInstance$p(AnalyticsUtils.INSTANCE);
            if (firebaseAnalyticsAccess$getFireBaseInstance$p != null) {
                g gVar = firebaseAnalyticsAccess$getFireBaseInstance$p.f3109b;
                Objects.requireNonNull(gVar);
                gVar.e.execute(new n(gVar, null));
                return;
            }
            return;
        }
        FirebaseAnalytics firebaseAnalyticsAccess$getFireBaseInstance$p2 = AnalyticsUtils.access$getFireBaseInstance$p(AnalyticsUtils.INSTANCE);
        if (firebaseAnalyticsAccess$getFireBaseInstance$p2 != null) {
            String strValueOf = String.valueOf(meUser.getId());
            g gVar2 = firebaseAnalyticsAccess$getFireBaseInstance$p2.f3109b;
            Objects.requireNonNull(gVar2);
            gVar2.e.execute(new n(gVar2, strValueOf));
        }
        AppLog.g(Long.valueOf(meUser.getId()), meUser.getEmail(), meUser.getUsername());
    }
}
