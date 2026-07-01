package com.discord.widgets.servers.auditlog;

import com.discord.api.permission.Permission;
import com.discord.api.role.GuildRole;
import com.discord.models.guild.Guild;
import com.discord.models.member.GuildMember;
import d0.z.d.m;
import d0.z.d.o;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map$Entry;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetServerSettingsAuditLogFilter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettingsAuditLogFilter$Model$Companion$getPermissionUserIds$1$1 extends o implements Function1<Map$Entry<? extends Long, ? extends GuildMember>, Boolean> {
    public final /* synthetic */ Guild $guild;
    public final /* synthetic */ Map $roles;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetServerSettingsAuditLogFilter$Model$Companion$getPermissionUserIds$1$1(Guild guild, Map map) {
        super(1);
        this.$guild = guild;
        this.$roles = map;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Boolean invoke(Map$Entry<? extends Long, ? extends GuildMember> map$Entry) {
        return Boolean.valueOf(invoke2((Map$Entry<Long, GuildMember>) map$Entry));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final boolean invoke2(Map$Entry<Long, GuildMember> map$Entry) {
        boolean z2;
        m.checkNotNullParameter(map$Entry, "<name for destructuring parameter 0>");
        long jLongValue = map$Entry.getKey().longValue();
        GuildMember value = map$Entry.getValue();
        Guild guild = this.$guild;
        if (guild != null && jLongValue == guild.getOwnerId()) {
            return true;
        }
        List<Long> roles = value.getRoles();
        if ((roles instanceof Collection) && roles.isEmpty()) {
            z2 = false;
        } else {
            Iterator<T> it = roles.iterator();
            while (it.hasNext()) {
                GuildRole guildRole = (GuildRole) this.$roles.get(Long.valueOf(((Number) it.next()).longValue()));
                if (((guildRole != null ? guildRole.getPermissions() : 0L) & Permission.MANAGEMENT_PERMISSIONS) > 0) {
                    z2 = true;
                }
            }
            z2 = false;
        }
        return z2;
    }
}
