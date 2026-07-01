package com.discord.widgets.servers.auditlog;

import androidx.exifinterface.media.ExifInterface;
import d0.u.a;
import java.util.Comparator;

/* JADX INFO: compiled from: Comparisons.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettingsAuditLogFilter$Model$Companion$get$2$$special$$inlined$sortedBy$1<T> implements Comparator {
    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Comparator
    public final int compare(T t, T t2) {
        return a.compareValues(Boolean.valueOf(!((WidgetServerSettingsAuditLogFilterAdapter$AuditLogUserFilterItem) t).getIsChecked()), Boolean.valueOf(!((WidgetServerSettingsAuditLogFilterAdapter$AuditLogUserFilterItem) t2).getIsChecked()));
    }
}
