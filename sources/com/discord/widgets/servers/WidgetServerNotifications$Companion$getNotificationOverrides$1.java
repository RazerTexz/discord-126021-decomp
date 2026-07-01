package com.discord.widgets.servers;

import androidx.core.app.NotificationCompat;
import com.discord.models.domain.ModelNotificationSettings;
import com.discord.models.domain.ModelNotificationSettings$ChannelOverride;
import d0.z.d.m;
import j0.k.b;
import java.util.List;

/* JADX INFO: compiled from: WidgetServerNotifications.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerNotifications$Companion$getNotificationOverrides$1<T, R> implements b<ModelNotificationSettings, List<ModelNotificationSettings$ChannelOverride>> {
    public static final WidgetServerNotifications$Companion$getNotificationOverrides$1 INSTANCE = new WidgetServerNotifications$Companion$getNotificationOverrides$1();

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ List<ModelNotificationSettings$ChannelOverride> call(ModelNotificationSettings modelNotificationSettings) {
        return call2(modelNotificationSettings);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final List<ModelNotificationSettings$ChannelOverride> call2(ModelNotificationSettings modelNotificationSettings) {
        m.checkNotNullExpressionValue(modelNotificationSettings, "it");
        return modelNotificationSettings.getChannelOverrides();
    }
}
