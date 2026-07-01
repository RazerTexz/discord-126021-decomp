package com.discord.widgets.servers.auditlog;

import com.discord.analytics.generated.events.impression.TrackImpressionGuildSettingsAuditLog;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.Lambda;
import kotlin.jvm.functions.Function0;

/* JADX INFO: renamed from: com.discord.widgets.servers.auditlog.WidgetServerSettingsAuditLog$loggingConfig$1, reason: use source file name */
/* JADX INFO: compiled from: WidgetServerSettingsAuditLog.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettingsAuditLog4 extends Lambda implements Function0<AnalyticsSchema> {
    public static final WidgetServerSettingsAuditLog4 INSTANCE = new WidgetServerSettingsAuditLog4();

    public WidgetServerSettingsAuditLog4() {
        super(0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final AnalyticsSchema invoke() {
        return new TrackImpressionGuildSettingsAuditLog();
    }
}
