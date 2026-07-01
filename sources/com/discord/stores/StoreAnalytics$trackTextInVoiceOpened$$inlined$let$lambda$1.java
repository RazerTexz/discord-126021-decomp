package com.discord.stores;

import com.discord.api.channel.Channel;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.t.g0;
import d0.t.h0;
import d0.z.d.o;
import java.util.Map;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: StoreAnalytics.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreAnalytics$trackTextInVoiceOpened$$inlined$let$lambda$1 extends o implements Function0<Map<String, ? extends Object>> {
    public final /* synthetic */ SelectedChannelAnalyticsLocation $analyticsLocation$inlined;
    public final /* synthetic */ Channel $channel;
    public final /* synthetic */ long $channelId$inlined;
    public final /* synthetic */ StoreAnalytics this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreAnalytics$trackTextInVoiceOpened$$inlined$let$lambda$1(Channel channel, StoreAnalytics storeAnalytics, long j, SelectedChannelAnalyticsLocation selectedChannelAnalyticsLocation) {
        super(0);
        this.$channel = channel;
        this.this$0 = storeAnalytics;
        this.$channelId$inlined = j;
        this.$analyticsLocation$inlined = selectedChannelAnalyticsLocation;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Map<String, ? extends Object> invoke() {
        return invoke2();
    }

    @Override // kotlin.jvm.functions.Function0
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Map<String, ? extends Object> invoke2() {
        Map<String, ? extends Object> mapAccess$getChannelSnapshotAnalyticsProperties = StoreAnalytics.access$getChannelSnapshotAnalyticsProperties(this.this$0, this.$channel, true);
        SelectedChannelAnalyticsLocation selectedChannelAnalyticsLocation = this.$analyticsLocation$inlined;
        return selectedChannelAnalyticsLocation != null ? h0.plus(mapAccess$getChannelSnapshotAnalyticsProperties, g0.mapOf(d0.o.to(ModelAuditLogEntry.CHANGE_KEY_LOCATION, selectedChannelAnalyticsLocation.getAnalyticsValue()))) : mapAccess$getChannelSnapshotAnalyticsProperties;
    }
}
