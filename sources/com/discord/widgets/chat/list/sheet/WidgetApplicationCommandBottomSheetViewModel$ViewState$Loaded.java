package com.discord.widgets.chat.list.sheet;

import com.discord.api.channel.Channel;
import com.discord.api.commands.ApplicationCommandData;
import com.discord.api.role.GuildRole;
import com.discord.models.commands.Application;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.member.GuildMember;
import com.discord.models.user.User;
import d0.z.d.m;
import java.util.Map;

/* JADX INFO: compiled from: WidgetApplicationCommandBottomSheetViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetApplicationCommandBottomSheetViewModel$ViewState$Loaded extends WidgetApplicationCommandBottomSheetViewModel$ViewState {
    private final Application application;
    private final ApplicationCommandData applicationCommandData;
    private final Long channelId;
    private final Map<Long, Channel> channels;
    private final Map<String, WidgetApplicationCommandBottomSheetViewModel$SlashCommandParam> commandValues;
    private final Long guildId;
    private final Map<Long, GuildMember> guildMembers;
    private final Map<Long, GuildRole> guildRoles;
    private final long id;
    private final GuildMember interactionUser;
    private final User user;
    private final Map<Long, String> usernamesOrNicks;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetApplicationCommandBottomSheetViewModel$ViewState$Loaded(long j, User user, GuildMember guildMember, Application application, ApplicationCommandData applicationCommandData, Long l, Long l2, Map<Long, GuildMember> map, Map<Long, GuildRole> map2, Map<Long, Channel> map3, Map<Long, String> map4, Map<String, WidgetApplicationCommandBottomSheetViewModel$SlashCommandParam> map5) {
        super(null);
        m.checkNotNullParameter(applicationCommandData, "applicationCommandData");
        m.checkNotNullParameter(map4, "usernamesOrNicks");
        m.checkNotNullParameter(map5, "commandValues");
        this.id = j;
        this.user = user;
        this.interactionUser = guildMember;
        this.application = application;
        this.applicationCommandData = applicationCommandData;
        this.guildId = l;
        this.channelId = l2;
        this.guildMembers = map;
        this.guildRoles = map2;
        this.channels = map3;
        this.usernamesOrNicks = map4;
        this.commandValues = map5;
    }

    public final Application getApplication() {
        return this.application;
    }

    public final ApplicationCommandData getApplicationCommandData() {
        return this.applicationCommandData;
    }

    public final Long getChannelId() {
        return this.channelId;
    }

    public final Map<Long, Channel> getChannels() {
        return this.channels;
    }

    public final Map<String, WidgetApplicationCommandBottomSheetViewModel$SlashCommandParam> getCommandValues() {
        return this.commandValues;
    }

    public final Long getGuildId() {
        return this.guildId;
    }

    public final Map<Long, GuildMember> getGuildMembers() {
        return this.guildMembers;
    }

    public final Map<Long, GuildRole> getGuildRoles() {
        return this.guildRoles;
    }

    public final long getId() {
        return this.id;
    }

    public final GuildMember getInteractionUser() {
        return this.interactionUser;
    }

    public final User getUser() {
        return this.user;
    }

    public final Map<Long, String> getUsernamesOrNicks() {
        return this.usernamesOrNicks;
    }
}
