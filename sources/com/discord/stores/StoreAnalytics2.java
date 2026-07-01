package com.discord.stores;

import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.Tuples;
import d0.t.Maps6;
import d0.t.MapsJVM;
import d0.z.d.Lambda;
import java.util.Map;
import kotlin.jvm.functions.Function0;

/* JADX INFO: renamed from: com.discord.stores.StoreAnalytics$trackChannelOpened$$inlined$let$lambda$1, reason: use source file name */
/* JADX INFO: compiled from: StoreAnalytics.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreAnalytics2 extends Lambda implements Function0<Map<String, ? extends Object>> {
    public final /* synthetic */ StoreChannelsSelected3 $analyticsLocation$inlined;
    public final /* synthetic */ Channel $channel;
    public final /* synthetic */ long $channelId$inlined;
    public final /* synthetic */ StoreChannelsSelected2 $channelView$inlined;
    public final /* synthetic */ StoreAnalytics this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreAnalytics2(Channel channel, StoreAnalytics storeAnalytics, long j, StoreChannelsSelected2 storeChannelsSelected2, StoreChannelsSelected3 storeChannelsSelected3) {
        super(0);
        this.$channel = channel;
        this.this$0 = storeAnalytics;
        this.$channelId$inlined = j;
        this.$channelView$inlined = storeChannelsSelected2;
        this.$analyticsLocation$inlined = storeChannelsSelected3;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Map<String, ? extends Object> invoke() {
        Map<String, ? extends Object> mapPlus = Maps6.plus(ChannelUtils.H(this.$channel) ? this.this$0.getThreadSnapshotAnalyticsProperties(this.$channel) : this.this$0.getChannelSnapshotAnalyticsProperties(this.$channel, true), MapsJVM.mapOf(Tuples.to("channel_view", this.$channelView$inlined.getAnalyticsValue())));
        StoreChannelsSelected3 storeChannelsSelected3 = this.$analyticsLocation$inlined;
        return storeChannelsSelected3 != null ? Maps6.plus(mapPlus, MapsJVM.mapOf(Tuples.to(ModelAuditLogEntry.CHANGE_KEY_LOCATION, storeChannelsSelected3.getAnalyticsValue()))) : mapPlus;
    }
}
