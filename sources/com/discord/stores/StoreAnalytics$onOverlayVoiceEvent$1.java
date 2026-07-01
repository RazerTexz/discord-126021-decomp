package com.discord.stores;

import com.discord.api.channel.Channel;
import com.discord.rtcconnection.RtcConnection;
import com.discord.utilities.analytics.AnalyticsTracker;
import com.discord.utilities.analytics.AnalyticsUtils;
import d0.t.h0;
import d0.z.d.o;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: StoreAnalytics.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreAnalytics$onOverlayVoiceEvent$1 extends o implements Function0<Unit> {
    public final /* synthetic */ boolean $isActive;
    public final /* synthetic */ StoreAnalytics this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreAnalytics$onOverlayVoiceEvent$1(StoreAnalytics storeAnalytics, boolean z2) {
        super(0);
        this.this$0 = storeAnalytics;
        this.$isActive = z2;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        Map<String, String> mapEmptyMap;
        RtcConnection rtcConnection = StoreAnalytics.access$getStores$p(this.this$0).getRtcConnection().getRtcConnection();
        if (rtcConnection == null || (mapEmptyMap = AnalyticsUtils.INSTANCE.getProperties$app_productionGoogleRelease(rtcConnection)) == null) {
            mapEmptyMap = h0.emptyMap();
        }
        if (!this.$isActive) {
            AnalyticsTracker.INSTANCE.overlayVoiceClosed(mapEmptyMap);
            return;
        }
        Channel channelAccess$getSelectedVoiceChannel$p = StoreAnalytics.access$getSelectedVoiceChannel$p(this.this$0);
        Map mapAccess$getGuildAnalyticsPropertiesInternal = channelAccess$getSelectedVoiceChannel$p != null ? StoreAnalytics.access$getGuildAnalyticsPropertiesInternal(this.this$0, channelAccess$getSelectedVoiceChannel$p.getGuildId()) : null;
        if (mapAccess$getGuildAnalyticsPropertiesInternal == null) {
            mapAccess$getGuildAnalyticsPropertiesInternal = h0.emptyMap();
        }
        Map mapPlus = h0.plus(mapAccess$getGuildAnalyticsPropertiesInternal, mapEmptyMap);
        Channel channelAccess$getSelectedVoiceChannel$p2 = StoreAnalytics.access$getSelectedVoiceChannel$p(this.this$0);
        Map<String, Object> properties$app_productionGoogleRelease = channelAccess$getSelectedVoiceChannel$p2 != null ? AnalyticsUtils.INSTANCE.getProperties$app_productionGoogleRelease(channelAccess$getSelectedVoiceChannel$p2) : null;
        if (properties$app_productionGoogleRelease == null) {
            properties$app_productionGoogleRelease = h0.emptyMap();
        }
        AnalyticsTracker.INSTANCE.overlayVoiceOpened(h0.plus(mapPlus, properties$app_productionGoogleRelease));
    }
}
