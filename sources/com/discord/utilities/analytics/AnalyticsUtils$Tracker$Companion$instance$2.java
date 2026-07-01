package com.discord.utilities.analytics;

import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.time.ClockFactory;
import d0.z.d.o;
import java.util.concurrent.ConcurrentLinkedQueue;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: AnalyticsUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class AnalyticsUtils$Tracker$Companion$instance$2 extends o implements Function0<AnalyticsUtils$Tracker> {
    public static final AnalyticsUtils$Tracker$Companion$instance$2 INSTANCE = new AnalyticsUtils$Tracker$Companion$instance$2();

    public AnalyticsUtils$Tracker$Companion$instance$2() {
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ AnalyticsUtils$Tracker invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final AnalyticsUtils$Tracker invoke() {
        return new AnalyticsUtils$Tracker(ClockFactory.get(), RestAPI.Companion.getApi(), new ConcurrentLinkedQueue());
    }
}
