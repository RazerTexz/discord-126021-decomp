package com.discord.utilities.analytics;

import com.discord.utilities.lifecycle.ApplicationProvider;
import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.jvm.functions.Function0;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: AnalyticsTracker.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class AnalyticsTracker$firebaseAnalytics$2 extends AbstractC12240o implements Function0<FirebaseAnalytics> {
    public static final AnalyticsTracker$firebaseAnalytics$2 INSTANCE = new AnalyticsTracker$firebaseAnalytics$2();

    public AnalyticsTracker$firebaseAnalytics$2() {
        super(0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final FirebaseAnalytics invoke() {
        FirebaseAnalytics firebaseAnalytics = FirebaseAnalytics.getInstance(ApplicationProvider.INSTANCE.get());
        C12238m.checkNotNullExpressionValue(firebaseAnalytics, "FirebaseAnalytics.getIns…pplicationProvider.get())");
        return firebaseAnalytics;
    }
}
