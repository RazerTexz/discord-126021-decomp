package com.discord.widgets.user.search;

import com.discord.models.member.GuildMember;
import com.discord.widgets.user.search.WidgetGlobalSearchModel;
import d0.z.d.Lambda;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetGlobalSearchModel.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetGlobalSearchModel$Companion$getDefaultUserSearch$smallGuildUserIds$1 extends Lambda implements Function1<Long, Set<? extends Long>> {
    public final /* synthetic */ WidgetGlobalSearchModel.UsersContext $usersContext;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetGlobalSearchModel$Companion$getDefaultUserSearch$smallGuildUserIds$1(WidgetGlobalSearchModel.UsersContext usersContext) {
        super(1);
        this.$usersContext = usersContext;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Set<? extends Long> invoke(Long l) {
        return invoke(l.longValue());
    }

    public final Set<Long> invoke(long j) {
        Map<Long, GuildMember> map = this.$usersContext.getMembers().get(Long.valueOf(j));
        if (map != null) {
            return map.keySet();
        }
        return null;
    }
}
