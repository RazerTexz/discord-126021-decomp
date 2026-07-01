package com.discord.widgets.user.search;

import com.discord.models.user.User;
import com.discord.widgets.user.search.WidgetGlobalSearchModel;
import d0.z.d.Lambda;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetGlobalSearchModel.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetGlobalSearchModel$Companion$getDefaultUserSearch$1 extends Lambda implements Function1<Long, User> {
    public final /* synthetic */ WidgetGlobalSearchModel.UsersContext $usersContext;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetGlobalSearchModel$Companion$getDefaultUserSearch$1(WidgetGlobalSearchModel.UsersContext usersContext) {
        super(1);
        this.$usersContext = usersContext;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ User invoke(Long l) {
        return invoke(l.longValue());
    }

    public final User invoke(long j) {
        return this.$usersContext.getUsers().get(Long.valueOf(j));
    }
}
