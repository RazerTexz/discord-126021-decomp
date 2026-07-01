package com.discord.utilities.analytics;

import d0.z.d.Lambda;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: renamed from: com.discord.utilities.analytics.AnalyticsUtils$Tracker$drainEventsQueue$1, reason: use source file name */
/* JADX INFO: compiled from: AnalyticsUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class AnalyticsUtils3 extends Lambda implements Function1<Void, Unit> {
    public static final AnalyticsUtils3 INSTANCE = new AnalyticsUtils3();

    public AnalyticsUtils3() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Void r1) {
        invoke2(r1);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Void r1) {
    }
}
