package com.discord.stores;

import com.discord.api.channel.Channel;
import com.discord.models.domain.ModelNotificationSettings;
import com.discord.models.domain.ModelNotificationSettings$ChannelOverride;
import com.discord.utilities.analytics.AnalyticsTracker;
import d0.z.d.m;
import d0.z.d.o;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: StoreAnalytics.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreAnalytics$onNotificationSettingsUpdated$1 extends o implements Function0<Unit> {
    public final /* synthetic */ Long $channelId;
    public final /* synthetic */ ModelNotificationSettings $notifSettings;
    public final /* synthetic */ StoreAnalytics this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreAnalytics$onNotificationSettingsUpdated$1(StoreAnalytics storeAnalytics, Long l, ModelNotificationSettings modelNotificationSettings) {
        super(0);
        this.this$0 = storeAnalytics;
        this.$channelId = l;
        this.$notifSettings = modelNotificationSettings;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        ModelNotificationSettings$ChannelOverride modelNotificationSettings$ChannelOverride;
        Long l = this.$channelId;
        Channel channelFindChannelByIdInternal$app_productionGoogleRelease = null;
        if (l != null) {
            long jLongValue = l.longValue();
            List<ModelNotificationSettings$ChannelOverride> channelOverrides = this.$notifSettings.getChannelOverrides();
            m.checkNotNullExpressionValue(channelOverrides, "notifSettings.channelOverrides");
            boolean z2 = true;
            if (!(channelOverrides instanceof Collection) || !channelOverrides.isEmpty()) {
                Iterator<T> it = channelOverrides.iterator();
                do {
                    if (!it.hasNext()) {
                        z2 = false;
                        break;
                    } else {
                        modelNotificationSettings$ChannelOverride = (ModelNotificationSettings$ChannelOverride) it.next();
                        m.checkNotNullExpressionValue(modelNotificationSettings$ChannelOverride, "it");
                    }
                } while (!(modelNotificationSettings$ChannelOverride.getChannelId() == jLongValue));
            } else {
                z2 = false;
                break;
            }
            if (!z2) {
                l = null;
            }
            if (l != null) {
                channelFindChannelByIdInternal$app_productionGoogleRelease = StoreAnalytics.access$getStores$p(this.this$0).getChannels().findChannelByIdInternal$app_productionGoogleRelease(l.longValue());
            }
        }
        AnalyticsTracker.INSTANCE.notificationSettingsUpdated(this.$notifSettings, channelFindChannelByIdInternal$app_productionGoogleRelease);
    }
}
