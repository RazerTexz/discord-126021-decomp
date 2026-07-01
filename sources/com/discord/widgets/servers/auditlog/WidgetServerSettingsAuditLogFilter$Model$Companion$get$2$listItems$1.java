package com.discord.widgets.servers.auditlog;

import com.discord.models.user.User;
import com.discord.utilities.search.SearchUtils;
import d0.z.d.m;
import d0.z.d.o;
import java.util.Objects;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetServerSettingsAuditLogFilter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettingsAuditLogFilter$Model$Companion$get$2$listItems$1 extends o implements Function1<User, Boolean> {
    public final /* synthetic */ String $filterText;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetServerSettingsAuditLogFilter$Model$Companion$get$2$listItems$1(String str) {
        super(1);
        this.$filterText = str;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Boolean invoke(User user) {
        return Boolean.valueOf(invoke2(user));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final boolean invoke2(User user) {
        m.checkNotNullParameter(user, "it");
        SearchUtils searchUtils = SearchUtils.INSTANCE;
        String str = this.$filterText;
        m.checkNotNullExpressionValue(str, "filterText");
        Objects.requireNonNull(str, "null cannot be cast to non-null type java.lang.String");
        String lowerCase = str.toLowerCase();
        m.checkNotNullExpressionValue(lowerCase, "(this as java.lang.String).toLowerCase()");
        String username = user.getUsername();
        Objects.requireNonNull(username, "null cannot be cast to non-null type java.lang.String");
        String lowerCase2 = username.toLowerCase();
        m.checkNotNullExpressionValue(lowerCase2, "(this as java.lang.String).toLowerCase()");
        return searchUtils.fuzzyMatch(lowerCase, lowerCase2);
    }
}
