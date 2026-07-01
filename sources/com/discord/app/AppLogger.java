package com.discord.app;

import com.discord.api.science.AnalyticsSchema;
import com.discord.utilities.analytics.AnalyticsUtils$Tracker;
import com.discord.utilities.features.GrowthTeamFeatures;
import d0.e0.g;
import d0.z.d.m;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: AppLogger.kt */
/* JADX INFO: loaded from: classes.dex */
public final class AppLogger {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    public boolean hasLoggedImpression;

    /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
    public AnalyticsSchema previousAnalyticsSchema;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    public final AppLogger$a provider;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    public final AnalyticsUtils$Tracker tracker;

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    public final boolean isImpressionLoggingEnabled;

    public AppLogger(AppLogger$a appLogger$a, AnalyticsUtils$Tracker analyticsUtils$Tracker, boolean z2, int i) {
        AnalyticsUtils$Tracker analyticsUtils$Tracker$Companion = (i & 2) != 0 ? AnalyticsUtils$Tracker.Companion.getInstance() : null;
        z2 = (i & 4) != 0 ? GrowthTeamFeatures.INSTANCE.isImpressionLoggingEnabled() : z2;
        m.checkNotNullParameter(appLogger$a, "provider");
        m.checkNotNullParameter(analyticsUtils$Tracker$Companion, "tracker");
        this.provider = appLogger$a;
        this.tracker = analyticsUtils$Tracker$Companion;
        this.isImpressionLoggingEnabled = z2;
    }

    public final void a(AnalyticsSchema analyticsSchema) {
        Function0<AnalyticsSchema> function0;
        AnalyticsSchema analyticsSchemaInvoke;
        if (analyticsSchema != null) {
            this.tracker.track(analyticsSchema);
            return;
        }
        LoggingConfig loggingConfig = this.provider.getLoggingConfig();
        if (loggingConfig == null || (function0 = loggingConfig.impressionSchemaProvider) == null || (analyticsSchemaInvoke = function0.invoke()) == null) {
            return;
        }
        this.tracker.track(analyticsSchemaInvoke);
    }

    /* JADX WARN: Code duplicated, block: B:40:0x0070  */
    public final synchronized void b() {
        AnalyticsSchema analyticsSchemaInvoke;
        boolean z2;
        if (this.isImpressionLoggingEnabled) {
            LoggingConfig loggingConfig = this.provider.getLoggingConfig();
            if (loggingConfig != null) {
                Function0<AnalyticsSchema> function0 = loggingConfig.impressionSchemaProvider;
                if (function0 == null || (analyticsSchemaInvoke = function0.invoke()) == null) {
                    return;
                }
                AnalyticsSchema analyticsSchema = this.previousAnalyticsSchema;
                boolean z3 = false;
                if (analyticsSchema == null) {
                    z3 = true;
                } else if (loggingConfig.autoLogImpressionOnChanged) {
                    if (loggingConfig.autoLogImpressionProperties.isEmpty() && (!m.areEqual(analyticsSchema, analyticsSchemaInvoke))) {
                        z3 = true;
                    } else {
                        List<g<?, ?>> list = loggingConfig.autoLogImpressionProperties;
                        if (!(list instanceof Collection) || !list.isEmpty()) {
                            Iterator<T> it = list.iterator();
                            while (true) {
                                if (it.hasNext()) {
                                    g gVar = (g) it.next();
                                    if ((!(gVar instanceof g) ? null : gVar) != null ? !m.areEqual(gVar.get(analyticsSchemaInvoke), gVar.get(analyticsSchema)) : false) {
                                        z2 = true;
                                        break;
                                    }
                                }
                            }
                            if (z2) {
                                z3 = true;
                            }
                        }
                        z2 = false;
                        if (z2) {
                            z3 = true;
                        }
                    }
                }
                if (!this.hasLoggedImpression || z3) {
                    this.previousAnalyticsSchema = analyticsSchemaInvoke;
                    this.hasLoggedImpression = true;
                    a(analyticsSchemaInvoke);
                }
            }
        }
    }
}
