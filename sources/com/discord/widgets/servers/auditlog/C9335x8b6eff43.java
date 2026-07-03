package com.discord.widgets.servers.auditlog;

import com.discord.models.user.User;
import com.discord.utilities.search.SearchUtils;
import java.util.Objects;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: com.discord.widgets.servers.auditlog.WidgetServerSettingsAuditLogFilter$Model$Companion$get$2$listItems$1 */
/* JADX INFO: compiled from: WidgetServerSettingsAuditLogFilter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class C9335x8b6eff43 extends AbstractC12240o implements Function1<User, Boolean> {
    public final /* synthetic */ String $filterText;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C9335x8b6eff43(String str) {
        super(1);
        this.$filterText = str;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Boolean invoke(User user) {
        return Boolean.valueOf(invoke2(user));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final boolean invoke2(User user) {
        C12238m.checkNotNullParameter(user, "it");
        SearchUtils searchUtils = SearchUtils.INSTANCE;
        String str = this.$filterText;
        C12238m.checkNotNullExpressionValue(str, "filterText");
        Objects.requireNonNull(str, "null cannot be cast to non-null type java.lang.String");
        String lowerCase = str.toLowerCase();
        C12238m.checkNotNullExpressionValue(lowerCase, "(this as java.lang.String).toLowerCase()");
        String username = user.getUsername();
        Objects.requireNonNull(username, "null cannot be cast to non-null type java.lang.String");
        String lowerCase2 = username.toLowerCase();
        C12238m.checkNotNullExpressionValue(lowerCase2, "(this as java.lang.String).toLowerCase()");
        return searchUtils.fuzzyMatch(lowerCase, lowerCase2);
    }
}
