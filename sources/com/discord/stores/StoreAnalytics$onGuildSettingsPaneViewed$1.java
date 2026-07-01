package com.discord.stores;

import com.discord.utilities.analytics.AnalyticsTracker;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: StoreAnalytics.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreAnalytics$onGuildSettingsPaneViewed$1 extends o implements Function0<Unit> {
    public final /* synthetic */ long $guildId;
    public final /* synthetic */ String $pane;
    public final /* synthetic */ StoreAnalytics this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreAnalytics$onGuildSettingsPaneViewed$1(StoreAnalytics storeAnalytics, long j, String str) {
        super(0);
        this.this$0 = storeAnalytics;
        this.$guildId = j;
        this.$pane = str;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        AnalyticsTracker.INSTANCE.settingsPaneViewed("guild", this.$pane, StoreAnalytics.access$getGuildAnalyticsPropertiesInternal(this.this$0, this.$guildId));
    }
}
