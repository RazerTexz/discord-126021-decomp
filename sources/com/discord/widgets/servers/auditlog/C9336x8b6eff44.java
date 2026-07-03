package com.discord.widgets.servers.auditlog;

import com.discord.models.member.GuildMember;
import com.discord.models.user.User;
import com.discord.stores.StoreAuditLog;
import com.discord.widgets.servers.auditlog.WidgetServerSettingsAuditLogFilterAdapter;
import java.util.Map;
import kotlin.jvm.functions.Function1;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: com.discord.widgets.servers.auditlog.WidgetServerSettingsAuditLogFilter$Model$Companion$get$2$listItems$2 */
/* JADX INFO: compiled from: WidgetServerSettingsAuditLogFilter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class C9336x8b6eff44 extends AbstractC12240o implements Function1<User, WidgetServerSettingsAuditLogFilterAdapter.AuditLogUserFilterItem> {
    public final /* synthetic */ StoreAuditLog.AuditLogState $auditLogState;
    public final /* synthetic */ Map $guildMembers;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C9336x8b6eff44(Map map, StoreAuditLog.AuditLogState auditLogState) {
        super(1);
        this.$guildMembers = map;
        this.$auditLogState = auditLogState;
    }

    @Override // kotlin.jvm.functions.Function1
    public final WidgetServerSettingsAuditLogFilterAdapter.AuditLogUserFilterItem invoke(User user) {
        C12238m.checkNotNullParameter(user, "user");
        return new WidgetServerSettingsAuditLogFilterAdapter.AuditLogUserFilterItem(user, (GuildMember) C1643a.m849f(user, this.$guildMembers), user.getId(), null, Integer.valueOf(user.getDiscriminator()), this.$auditLogState.getFilter().getUserFilter() == user.getId());
    }
}
