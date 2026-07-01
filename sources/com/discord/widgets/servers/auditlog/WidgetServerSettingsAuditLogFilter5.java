package com.discord.widgets.servers.auditlog;

import b.d.b.a.outline;
import com.discord.models.member.GuildMember;
import com.discord.models.user.User;
import com.discord.stores.StoreAuditLog;
import com.discord.widgets.servers.auditlog.WidgetServerSettingsAuditLogFilterAdapter;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.Map;
import kotlin.jvm.functions.Function1;

/* JADX INFO: renamed from: com.discord.widgets.servers.auditlog.WidgetServerSettingsAuditLogFilter$Model$Companion$get$2$listItems$2, reason: use source file name */
/* JADX INFO: compiled from: WidgetServerSettingsAuditLogFilter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettingsAuditLogFilter5 extends Lambda implements Function1<User, WidgetServerSettingsAuditLogFilterAdapter.AuditLogUserFilterItem> {
    public final /* synthetic */ StoreAuditLog.AuditLogState $auditLogState;
    public final /* synthetic */ Map $guildMembers;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetServerSettingsAuditLogFilter5(Map map, StoreAuditLog.AuditLogState auditLogState) {
        super(1);
        this.$guildMembers = map;
        this.$auditLogState = auditLogState;
    }

    @Override // kotlin.jvm.functions.Function1
    public final WidgetServerSettingsAuditLogFilterAdapter.AuditLogUserFilterItem invoke(User user) {
        Intrinsics3.checkNotNullParameter(user, "user");
        return new WidgetServerSettingsAuditLogFilterAdapter.AuditLogUserFilterItem(user, (GuildMember) outline.f(user, this.$guildMembers), user.getId(), null, Integer.valueOf(user.getDiscriminator()), this.$auditLogState.getFilter().getUserFilter() == user.getId());
    }
}
