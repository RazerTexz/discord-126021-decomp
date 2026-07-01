package com.discord.stores;

import com.discord.api.channel.Channel;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.Tuples;
import d0.t.Maps6;
import d0.t.MapsJVM;
import d0.z.d.Lambda;
import java.util.Map;
import kotlin.jvm.functions.Function0;

/* JADX INFO: renamed from: com.discord.stores.StoreAnalytics$trackTextInVoiceOpened$$inlined$let$lambda$1, reason: use source file name */
/* JADX INFO: compiled from: StoreAnalytics.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreAnalytics3 extends Lambda implements Function0<Map<String, ? extends Object>> {
    public final /* synthetic */ StoreChannelsSelected3 $analyticsLocation$inlined;
    public final /* synthetic */ Channel $channel;
    public final /* synthetic */ long $channelId$inlined;
    public final /* synthetic */ StoreAnalytics this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreAnalytics3(Channel channel, StoreAnalytics storeAnalytics, long j, StoreChannelsSelected3 storeChannelsSelected3) {
        super(0);
        this.$channel = channel;
        this.this$0 = storeAnalytics;
        this.$channelId$inlined = j;
        this.$analyticsLocation$inlined = storeChannelsSelected3;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Map<String, ? extends Object> invoke() {
        Map<String, ? extends Object> channelSnapshotAnalyticsProperties = this.this$0.getChannelSnapshotAnalyticsProperties(this.$channel, true);
        StoreChannelsSelected3 storeChannelsSelected3 = this.$analyticsLocation$inlined;
        return storeChannelsSelected3 != null ? Maps6.plus(channelSnapshotAnalyticsProperties, MapsJVM.mapOf(Tuples.to(ModelAuditLogEntry.CHANGE_KEY_LOCATION, storeChannelsSelected3.getAnalyticsValue()))) : channelSnapshotAnalyticsProperties;
    }
}
