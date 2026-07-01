package com.discord.widgets.servers.auditlog;

import com.discord.models.user.User;
import com.discord.utilities.search.SearchUtils;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.Objects;
import kotlin.jvm.functions.Function1;

/* JADX INFO: renamed from: com.discord.widgets.servers.auditlog.WidgetServerSettingsAuditLogFilter$Model$Companion$get$2$listItems$1, reason: use source file name */
/* JADX INFO: compiled from: WidgetServerSettingsAuditLogFilter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettingsAuditLogFilter4 extends Lambda implements Function1<User, Boolean> {
    public final /* synthetic */ String $filterText;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetServerSettingsAuditLogFilter4(String str) {
        super(1);
        this.$filterText = str;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Boolean invoke(User user) {
        return Boolean.valueOf(invoke2(user));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final boolean invoke2(User user) {
        Intrinsics3.checkNotNullParameter(user, "it");
        SearchUtils searchUtils = SearchUtils.INSTANCE;
        String str = this.$filterText;
        Intrinsics3.checkNotNullExpressionValue(str, "filterText");
        Objects.requireNonNull(str, "null cannot be cast to non-null type java.lang.String");
        String lowerCase = str.toLowerCase();
        Intrinsics3.checkNotNullExpressionValue(lowerCase, "(this as java.lang.String).toLowerCase()");
        String username = user.getUsername();
        Objects.requireNonNull(username, "null cannot be cast to non-null type java.lang.String");
        String lowerCase2 = username.toLowerCase();
        Intrinsics3.checkNotNullExpressionValue(lowerCase2, "(this as java.lang.String).toLowerCase()");
        return searchUtils.fuzzyMatch(lowerCase, lowerCase2);
    }
}
