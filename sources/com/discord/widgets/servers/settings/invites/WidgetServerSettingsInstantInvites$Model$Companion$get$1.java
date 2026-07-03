package com.discord.widgets.servers.settings.invites;

import com.discord.models.domain.ModelInvite;
import com.discord.models.guild.Guild;
import com.discord.models.member.GuildMember;
import com.discord.stores.StoreGuilds;
import com.discord.stores.StoreInstantInvites;
import com.discord.widgets.servers.settings.invites.WidgetServerSettingsInstantInvites;
import java.util.Map;
import kotlin.jvm.functions.Function0;
import p507d0.p580t.C12136h0;
import p507d0.p592z.p594d.AbstractC12240o;

/* JADX INFO: compiled from: WidgetServerSettingsInstantInvites.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettingsInstantInvites$Model$Companion$get$1 extends AbstractC12240o implements Function0<WidgetServerSettingsInstantInvites.Model> {
    public final /* synthetic */ long $guildId;
    public final /* synthetic */ StoreGuilds $storeGuilds;
    public final /* synthetic */ StoreInstantInvites $storeInstantInvites;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetServerSettingsInstantInvites$Model$Companion$get$1(StoreGuilds storeGuilds, long j, StoreInstantInvites storeInstantInvites) {
        super(0);
        this.$storeGuilds = storeGuilds;
        this.$guildId = j;
        this.$storeInstantInvites = storeInstantInvites;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final WidgetServerSettingsInstantInvites.Model invoke() {
        Guild guild = this.$storeGuilds.getGuild(this.$guildId);
        Map<Long, GuildMember> mapEmptyMap = this.$storeGuilds.getMembers().get(Long.valueOf(this.$guildId));
        if (mapEmptyMap == null) {
            mapEmptyMap = C12136h0.emptyMap();
        }
        Map<String, ModelInvite> invites = this.$storeInstantInvites.getInvites(this.$guildId);
        if (guild == null) {
            return null;
        }
        return invites == null ? new WidgetServerSettingsInstantInvites.Model(guild, null) : new WidgetServerSettingsInstantInvites.Model(guild, WidgetServerSettingsInstantInvites.Model.InviteItem.INSTANCE.createList(invites, this.$guildId, mapEmptyMap));
    }
}
