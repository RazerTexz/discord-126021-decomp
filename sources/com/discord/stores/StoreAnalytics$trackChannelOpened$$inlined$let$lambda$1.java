package com.discord.stores;

import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.models.domain.ModelAuditLogEntry;
import java.util.Map;
import kotlin.jvm.functions.Function0;
import p507d0.C12116o;
import p507d0.p580t.C12134g0;
import p507d0.p580t.C12136h0;
import p507d0.p592z.p594d.AbstractC12240o;

/* JADX INFO: compiled from: StoreAnalytics.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreAnalytics$trackChannelOpened$$inlined$let$lambda$1 extends AbstractC12240o implements Function0<Map<String, ? extends Object>> {
    public final /* synthetic */ SelectedChannelAnalyticsLocation $analyticsLocation$inlined;
    public final /* synthetic */ Channel $channel;
    public final /* synthetic */ long $channelId$inlined;
    public final /* synthetic */ ChannelAnalyticsViewType $channelView$inlined;
    public final /* synthetic */ StoreAnalytics this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreAnalytics$trackChannelOpened$$inlined$let$lambda$1(Channel channel, StoreAnalytics storeAnalytics, long j, ChannelAnalyticsViewType channelAnalyticsViewType, SelectedChannelAnalyticsLocation selectedChannelAnalyticsLocation) {
        super(0);
        this.$channel = channel;
        this.this$0 = storeAnalytics;
        this.$channelId$inlined = j;
        this.$channelView$inlined = channelAnalyticsViewType;
        this.$analyticsLocation$inlined = selectedChannelAnalyticsLocation;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Map<String, ? extends Object> invoke() {
        Map<String, ? extends Object> mapPlus = C12136h0.plus(ChannelUtils.m7673H(this.$channel) ? this.this$0.getThreadSnapshotAnalyticsProperties(this.$channel) : this.this$0.getChannelSnapshotAnalyticsProperties(this.$channel, true), C12134g0.mapOf(C12116o.m10073to("channel_view", this.$channelView$inlined.getAnalyticsValue())));
        SelectedChannelAnalyticsLocation selectedChannelAnalyticsLocation = this.$analyticsLocation$inlined;
        return selectedChannelAnalyticsLocation != null ? C12136h0.plus(mapPlus, C12134g0.mapOf(C12116o.m10073to(ModelAuditLogEntry.CHANGE_KEY_LOCATION, selectedChannelAnalyticsLocation.getAnalyticsValue()))) : mapPlus;
    }
}
