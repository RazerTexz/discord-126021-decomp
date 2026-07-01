package com.discord.widgets.servers.auditlog;

import com.discord.utilities.auditlogs.AuditLogUtils;
import com.discord.utilities.search.SearchUtils;
import d0.z.d.m;
import d0.z.d.o;
import java.util.Objects;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetServerSettingsAuditLogFilter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettingsAuditLogFilter$Model$Companion$get$2$1 extends o implements Function1<Integer, Boolean> {
    public final /* synthetic */ String $filterText;
    public final /* synthetic */ WidgetServerSettingsAuditLogFilter$Model$Companion$get$2 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetServerSettingsAuditLogFilter$Model$Companion$get$2$1(WidgetServerSettingsAuditLogFilter$Model$Companion$get$2 widgetServerSettingsAuditLogFilter$Model$Companion$get$2, String str) {
        super(1);
        this.this$0 = widgetServerSettingsAuditLogFilter$Model$Companion$get$2;
        this.$filterText = str;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Boolean invoke(Integer num) {
        return Boolean.valueOf(invoke(num.intValue()));
    }

    public final boolean invoke(int i) {
        SearchUtils searchUtils = SearchUtils.INSTANCE;
        String str = this.$filterText;
        m.checkNotNullExpressionValue(str, "filterText");
        Objects.requireNonNull(str, "null cannot be cast to non-null type java.lang.String");
        String lowerCase = str.toLowerCase();
        m.checkNotNullExpressionValue(lowerCase, "(this as java.lang.String).toLowerCase()");
        String string = this.this$0.$context.getString(AuditLogUtils.INSTANCE.getActionName(i));
        m.checkNotNullExpressionValue(string, "context.getString(AuditLogUtils.getActionName(it))");
        Objects.requireNonNull(string, "null cannot be cast to non-null type java.lang.String");
        String lowerCase2 = string.toLowerCase();
        m.checkNotNullExpressionValue(lowerCase2, "(this as java.lang.String).toLowerCase()");
        return searchUtils.fuzzyMatch(lowerCase, lowerCase2);
    }
}
