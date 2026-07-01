package com.discord.stores;

import com.discord.utilities.analytics.AnalyticsTracker;
import d0.z.d.o;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: StoreAnalytics.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreAnalytics$trackVoiceConnectionFailure$1 extends o implements Function0<Unit> {
    public final /* synthetic */ Map $properties;
    public final /* synthetic */ StoreAnalytics this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreAnalytics$trackVoiceConnectionFailure$1(StoreAnalytics storeAnalytics, Map map) {
        super(0);
        this.this$0 = storeAnalytics;
        this.$properties = map;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        AnalyticsTracker.INSTANCE.voiceConnectionFailure(this.$properties, StoreAnalytics.access$getStores$p(this.this$0).getChannels().findChannelByIdInternal$app_productionGoogleRelease(StoreAnalytics.access$getStores$p(this.this$0).getVoiceChannelSelected().getSelectedVoiceChannelId()), StoreAnalytics.access$getStores$p(this.this$0).getRtcRegion().getPreferredRegion());
    }
}
