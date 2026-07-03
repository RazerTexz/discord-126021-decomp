package com.discord.app;

import com.discord.api.science.AnalyticsSchema;
import com.discord.utilities.analytics.AnalyticsUtils;
import com.discord.utilities.features.GrowthTeamFeatures;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.functions.Function0;
import p507d0.p513e0.InterfaceC11234g;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: AppLogger.kt */
/* JADX INFO: loaded from: classes.dex */
public final class AppLogger {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    public boolean hasLoggedImpression;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    public AnalyticsSchema previousAnalyticsSchema;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    public final InterfaceC5455a provider;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    public final AnalyticsUtils.Tracker tracker;

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    public final boolean isImpressionLoggingEnabled;

    /* JADX INFO: renamed from: com.discord.app.AppLogger$a */
    /* JADX INFO: compiled from: AppLogger.kt */
    public interface InterfaceC5455a {
        LoggingConfig getLoggingConfig();
    }

    public AppLogger(InterfaceC5455a interfaceC5455a, AnalyticsUtils.Tracker tracker, boolean z2, int i) {
        AnalyticsUtils.Tracker companion = (i & 2) != 0 ? AnalyticsUtils.Tracker.INSTANCE.getInstance() : null;
        z2 = (i & 4) != 0 ? GrowthTeamFeatures.INSTANCE.isImpressionLoggingEnabled() : z2;
        C12238m.checkNotNullParameter(interfaceC5455a, "provider");
        C12238m.checkNotNullParameter(companion, "tracker");
        this.provider = interfaceC5455a;
        this.tracker = companion;
        this.isImpressionLoggingEnabled = z2;
    }

    /* JADX INFO: renamed from: a */
    public final void m8371a(AnalyticsSchema analyticsSchema) {
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
    /* JADX INFO: renamed from: b */
    public final synchronized void m8372b() {
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
                    if (loggingConfig.autoLogImpressionProperties.isEmpty() && (!C12238m.areEqual(analyticsSchema, analyticsSchemaInvoke))) {
                        z3 = true;
                    } else {
                        List<InterfaceC11234g<?, ?>> list = loggingConfig.autoLogImpressionProperties;
                        if (!(list instanceof Collection) || !list.isEmpty()) {
                            Iterator<T> it = list.iterator();
                            while (true) {
                                if (it.hasNext()) {
                                    InterfaceC11234g interfaceC11234g = (InterfaceC11234g) it.next();
                                    if ((!(interfaceC11234g instanceof InterfaceC11234g) ? null : interfaceC11234g) != null ? !C12238m.areEqual(interfaceC11234g.get(analyticsSchemaInvoke), interfaceC11234g.get(analyticsSchema)) : false) {
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
                    m8371a(analyticsSchemaInvoke);
                }
            }
        }
    }
}
