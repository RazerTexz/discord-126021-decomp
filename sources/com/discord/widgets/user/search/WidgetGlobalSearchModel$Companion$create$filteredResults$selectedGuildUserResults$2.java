package com.discord.widgets.user.search;

import com.discord.models.user.User;
import com.discord.widgets.user.search.WidgetGlobalSearchModel;
import d0.z.d.Lambda;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetGlobalSearchModel.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetGlobalSearchModel$Companion$create$filteredResults$selectedGuildUserResults$2 extends Lambda implements Function1<Long, WidgetGlobalSearchModel.ItemUser> {
    public final /* synthetic */ String $sanitizedFilter;
    public final /* synthetic */ WidgetGlobalSearchModel$Companion$create$2 $toItemUser$2;
    public final /* synthetic */ WidgetGlobalSearchModel.UsersContext $usersContext;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetGlobalSearchModel$Companion$create$filteredResults$selectedGuildUserResults$2(WidgetGlobalSearchModel$Companion$create$2 widgetGlobalSearchModel$Companion$create$2, WidgetGlobalSearchModel.UsersContext usersContext, String str) {
        super(1);
        this.$toItemUser$2 = widgetGlobalSearchModel$Companion$create$2;
        this.$usersContext = usersContext;
        this.$sanitizedFilter = str;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetGlobalSearchModel.ItemUser invoke(Long l) {
        return invoke(l.longValue());
    }

    public final WidgetGlobalSearchModel.ItemUser invoke(long j) {
        User user = this.$usersContext.getUsers().get(Long.valueOf(j));
        if (user != null) {
            return WidgetGlobalSearchModel$Companion$create$2.invoke$default(this.$toItemUser$2, user, this.$sanitizedFilter, null, 2, null);
        }
        return null;
    }
}
