package com.discord.utilities.analytics;

import androidx.core.app.NotificationCompat;
import com.discord.api.channel.Channel;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.o;
import d0.t.h0;
import d0.z.d.m;
import j0.k.b;
import java.util.Map;

/* JADX INFO: compiled from: AnalyticsTracker.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class AnalyticsTracker$addAttachment$1<T, R> implements b<Channel, Map<String, ? extends Object>> {
    public final /* synthetic */ String $mimeType;
    public final /* synthetic */ String $source;
    public final /* synthetic */ int $totalAttachments;

    public AnalyticsTracker$addAttachment$1(String str, String str2, int i) {
        this.$source = str;
        this.$mimeType = str2;
        this.$totalAttachments = i;
    }

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ Map<String, ? extends Object> call(Channel channel) {
        return call2(channel);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final Map<String, Object> call2(Channel channel) {
        Map mapMapOf = h0.mapOf(o.to("source", this.$source), o.to("action_type", 0), o.to("mime_type", this.$mimeType), o.to("total_attachments", Integer.valueOf(this.$totalAttachments)), o.to(ModelAuditLogEntry.CHANGE_KEY_GUILD_ID, Long.valueOf(channel.getGuildId())));
        AnalyticsUtils analyticsUtils = AnalyticsUtils.INSTANCE;
        m.checkNotNullExpressionValue(channel, "it");
        return h0.plus(mapMapOf, analyticsUtils.getProperties$app_productionGoogleRelease(channel));
    }
}
