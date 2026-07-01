package com.discord.widgets.servers.auditlog;

import b.d.b.a.a;
import com.discord.models.member.GuildMember;
import com.discord.models.user.User;
import com.discord.stores.StoreAuditLog$AuditLogState;
import d0.z.d.m;
import d0.z.d.o;
import java.util.Map;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetServerSettingsAuditLogFilter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettingsAuditLogFilter$Model$Companion$get$2$listItems$2 extends o implements Function1<User, WidgetServerSettingsAuditLogFilterAdapter$AuditLogUserFilterItem> {
    public final /* synthetic */ StoreAuditLog$AuditLogState $auditLogState;
    public final /* synthetic */ Map $guildMembers;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetServerSettingsAuditLogFilter$Model$Companion$get$2$listItems$2(Map map, StoreAuditLog$AuditLogState storeAuditLog$AuditLogState) {
        super(1);
        this.$guildMembers = map;
        this.$auditLogState = storeAuditLog$AuditLogState;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetServerSettingsAuditLogFilterAdapter$AuditLogUserFilterItem invoke(User user) {
        return invoke2(user);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetServerSettingsAuditLogFilterAdapter$AuditLogUserFilterItem invoke2(User user) {
        m.checkNotNullParameter(user, "user");
        return new WidgetServerSettingsAuditLogFilterAdapter$AuditLogUserFilterItem(user, (GuildMember) a.f(user, this.$guildMembers), user.getId(), null, Integer.valueOf(user.getDiscriminator()), this.$auditLogState.getFilter().getUserFilter() == user.getId());
    }
}
