package com.discord.app;

import b.d.b.a.outline;
import com.discord.api.science.AnalyticsSchema;
import d0.e0.KProperty3;
import d0.t.Collections2;
import d0.z.d.Intrinsics3;
import java.util.List;
import kotlin.jvm.functions.Function0;

/* JADX INFO: renamed from: com.discord.app.LoggingConfig, reason: use source file name */
/* JADX INFO: compiled from: AppLogger.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class AppLogger2 {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    public final boolean autoLogImpressionOnChanged;

    /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final List<KProperty3<?, ?>> autoLogImpressionProperties;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    public final Function0<AnalyticsSchema> impressionSchemaProvider;

    public AppLogger2() {
        this(false, null, null, 7);
    }

    public AppLogger2(boolean z2, List list, Function0 function0, int i) {
        z2 = (i & 1) != 0 ? true : z2;
        List<KProperty3<?, ?>> listEmptyList = (i & 2) != 0 ? Collections2.emptyList() : null;
        function0 = (i & 4) != 0 ? null : function0;
        Intrinsics3.checkNotNullParameter(listEmptyList, "autoLogImpressionProperties");
        this.autoLogImpressionOnChanged = z2;
        this.autoLogImpressionProperties = listEmptyList;
        this.impressionSchemaProvider = function0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AppLogger2)) {
            return false;
        }
        AppLogger2 appLogger2 = (AppLogger2) other;
        return this.autoLogImpressionOnChanged == appLogger2.autoLogImpressionOnChanged && Intrinsics3.areEqual(this.autoLogImpressionProperties, appLogger2.autoLogImpressionProperties) && Intrinsics3.areEqual(this.impressionSchemaProvider, appLogger2.impressionSchemaProvider);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    public int hashCode() {
        boolean z2 = this.autoLogImpressionOnChanged;
        ?? r0 = z2;
        if (z2) {
            r0 = 1;
        }
        int i = r0 * 31;
        List<KProperty3<?, ?>> list = this.autoLogImpressionProperties;
        int iHashCode = (i + (list != null ? list.hashCode() : 0)) * 31;
        Function0<AnalyticsSchema> function0 = this.impressionSchemaProvider;
        return iHashCode + (function0 != null ? function0.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("LoggingConfig(autoLogImpressionOnChanged=");
        sbU.append(this.autoLogImpressionOnChanged);
        sbU.append(", autoLogImpressionProperties=");
        sbU.append(this.autoLogImpressionProperties);
        sbU.append(", impressionSchemaProvider=");
        sbU.append(this.impressionSchemaProvider);
        sbU.append(")");
        return sbU.toString();
    }
}
