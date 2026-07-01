package com.discord.widgets.chat.list.sheet;

import b.d.b.a.outline;
import com.discord.api.channel.Channel;
import com.discord.api.commands.ApplicationCommandData3;
import com.discord.api.commands.ApplicationCommandType;
import com.discord.api.role.GuildRole;
import com.discord.models.commands.Application;
import com.discord.models.member.GuildMember;
import com.discord.models.user.User;
import com.discord.stores.StoreApplicationCommands;
import com.discord.stores.StoreApplicationInteractions;
import com.discord.stores.StoreChannels;
import com.discord.stores.StoreGuilds;
import com.discord.stores.StoreUser;
import com.discord.utilities.guilds.RoleUtils;
import com.discord.widgets.chat.input.MentionUtils;
import com.discord.widgets.chat.list.sheet.WidgetApplicationCommandBottomSheetViewModel;
import d0.g0.StringNumberConversions;
import d0.t.Sets5;
import d0.z.d.Lambda;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.functions.Function0;

/* JADX INFO: renamed from: com.discord.widgets.chat.list.sheet.WidgetApplicationCommandBottomSheetViewModel$Companion$observeStores$1, reason: use source file name */
/* JADX INFO: compiled from: WidgetApplicationCommandBottomSheetViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetApplicationCommandBottomSheetViewModel2 extends Lambda implements Function0<WidgetApplicationCommandBottomSheetViewModel.StoreState> {
    public final /* synthetic */ long $applicationId;
    public final /* synthetic */ Long $guildId;
    public final /* synthetic */ long $interactionId;
    public final /* synthetic */ StoreApplicationCommands $storeApplicationCommands;
    public final /* synthetic */ StoreChannels $storeChannels;
    public final /* synthetic */ StoreGuilds $storeGuilds;
    public final /* synthetic */ StoreApplicationInteractions $storeInteractions;
    public final /* synthetic */ StoreUser $storeUsers;
    public final /* synthetic */ long $userId;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetApplicationCommandBottomSheetViewModel2(StoreApplicationInteractions storeApplicationInteractions, long j, StoreApplicationCommands storeApplicationCommands, long j2, long j3, StoreGuilds storeGuilds, Long l, StoreUser storeUser, StoreChannels storeChannels) {
        super(0);
        this.$storeInteractions = storeApplicationInteractions;
        this.$interactionId = j;
        this.$storeApplicationCommands = storeApplicationCommands;
        this.$applicationId = j2;
        this.$userId = j3;
        this.$storeGuilds = storeGuilds;
        this.$guildId = l;
        this.$storeUsers = storeUser;
        this.$storeChannels = storeChannels;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final WidgetApplicationCommandBottomSheetViewModel.StoreState invoke() {
        LinkedHashMap linkedHashMap;
        LinkedHashMap linkedHashMap2;
        List<ApplicationCommandData3> listB;
        List<ApplicationCommandData3> listFlattenOptions;
        Iterator it;
        String stringTruncateZeroDecimal;
        String stringTruncateZeroDecimal2;
        Long l;
        StoreApplicationInteractions.State interactionData = this.$storeInteractions.getInteractionData(this.$interactionId);
        Application application = this.$storeApplicationCommands.getApplicationMap().get(Long.valueOf(this.$applicationId));
        LinkedHashMap linkedHashMap3 = new LinkedHashMap();
        Set setMutableSetOf = Sets5.mutableSetOf(Long.valueOf(this.$userId));
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        LinkedHashMap linkedHashMap4 = new LinkedHashMap();
        if ((interactionData instanceof StoreApplicationInteractions.State.Loaded) && (listB = ((StoreApplicationInteractions.State.Loaded) interactionData).getCommandOptions().b()) != null && (listFlattenOptions = WidgetApplicationCommandBottomSheetViewModel3.flattenOptions(listB)) != null) {
            for (Iterator it2 = listFlattenOptions.iterator(); it2.hasNext(); it2 = it) {
                ApplicationCommandData3 applicationCommandData3 = (ApplicationCommandData3) it2.next();
                if (applicationCommandData3.getType() == ApplicationCommandType.USER.getType()) {
                    Long longOrNull = StringNumberConversions.toLongOrNull(String.valueOf(applicationCommandData3.getValue()));
                    if (longOrNull != null) {
                        setMutableSetOf.add(longOrNull);
                        Map<Long, GuildMember> map = this.$storeGuilds.getMembers().get(this.$guildId);
                        GuildMember guildMember = map != null ? map.get(longOrNull) : null;
                        User user = this.$storeUsers.getUsers().get(longOrNull);
                        String name = applicationCommandData3.getName();
                        String name2 = applicationCommandData3.getName();
                        String strValueOf = String.valueOf(user != null ? user.getUsername() : null);
                        Integer numValueOf = guildMember != null ? Integer.valueOf(guildMember.getColor()) : null;
                        StringBuilder sbQ = outline.Q(MentionUtils.MENTIONS_CHAR);
                        it = it2;
                        sbQ.append(user != null ? user.getUsername() : null);
                        sbQ.append(MentionUtils.CHANNELS_CHAR);
                        sbQ.append(user != null ? Integer.valueOf(user.getDiscriminator()) : null);
                        linkedHashMap3.put(name, new WidgetApplicationCommandBottomSheetViewModel.SlashCommandParam(name2, strValueOf, numValueOf, sbQ.toString()));
                    } else {
                        it = it2;
                    }
                } else {
                    it = it2;
                    if (applicationCommandData3.getType() == ApplicationCommandType.ROLE.getType()) {
                        Long longOrNull2 = StringNumberConversions.toLongOrNull(String.valueOf(applicationCommandData3.getValue()));
                        if (longOrNull2 != null) {
                            Map<Long, GuildRole> map2 = this.$storeGuilds.getRoles().get(this.$guildId);
                            GuildRole guildRole = map2 != null ? map2.get(longOrNull2) : null;
                            String name3 = applicationCommandData3.getName();
                            String name4 = applicationCommandData3.getName();
                            String strValueOf2 = String.valueOf(guildRole != null ? guildRole.getName() : null);
                            Integer numValueOf2 = Integer.valueOf(RoleUtils.getOpaqueColor(guildRole));
                            StringBuilder sbQ2 = outline.Q(MentionUtils.MENTIONS_CHAR);
                            sbQ2.append(guildRole != null ? guildRole.getName() : null);
                            linkedHashMap3.put(name3, new WidgetApplicationCommandBottomSheetViewModel.SlashCommandParam(name4, strValueOf2, numValueOf2, sbQ2.toString()));
                        }
                    } else if (applicationCommandData3.getType() == ApplicationCommandType.MENTIONABLE.getType()) {
                        Long longOrNull3 = StringNumberConversions.toLongOrNull(String.valueOf(applicationCommandData3.getValue()));
                        if (longOrNull3 != null) {
                            Map<Long, GuildRole> map3 = this.$storeGuilds.getRoles().get(this.$guildId);
                            GuildRole guildRole2 = map3 != null ? map3.get(longOrNull3) : null;
                            if (guildRole2 != null) {
                                String name5 = applicationCommandData3.getName();
                                String name6 = applicationCommandData3.getName();
                                String strValueOf3 = String.valueOf(guildRole2.getName());
                                Integer numValueOf3 = Integer.valueOf(RoleUtils.getOpaqueColor(guildRole2));
                                StringBuilder sbQ3 = outline.Q(MentionUtils.MENTIONS_CHAR);
                                sbQ3.append(guildRole2.getName());
                                linkedHashMap3.put(name5, new WidgetApplicationCommandBottomSheetViewModel.SlashCommandParam(name6, strValueOf3, numValueOf3, sbQ3.toString()));
                            } else {
                                Map<Long, GuildMember> map4 = this.$storeGuilds.getMembers().get(this.$guildId);
                                GuildMember guildMember2 = map4 != null ? map4.get(longOrNull3) : null;
                                User user2 = this.$storeUsers.getUsers().get(longOrNull3);
                                String name7 = applicationCommandData3.getName();
                                String name8 = applicationCommandData3.getName();
                                String strValueOf4 = String.valueOf(user2 != null ? user2.getUsername() : null);
                                Integer numValueOf4 = guildMember2 != null ? Integer.valueOf(guildMember2.getColor()) : null;
                                StringBuilder sbQ4 = outline.Q(MentionUtils.MENTIONS_CHAR);
                                sbQ4.append(user2 != null ? user2.getUsername() : null);
                                sbQ4.append(MentionUtils.CHANNELS_CHAR);
                                sbQ4.append(user2 != null ? Integer.valueOf(user2.getDiscriminator()) : null);
                                linkedHashMap3.put(name7, new WidgetApplicationCommandBottomSheetViewModel.SlashCommandParam(name8, strValueOf4, numValueOf4, sbQ4.toString()));
                            }
                        }
                    } else if (applicationCommandData3.getType() == ApplicationCommandType.CHANNEL.getType()) {
                        Long longOrNull4 = StringNumberConversions.toLongOrNull(String.valueOf(applicationCommandData3.getValue()));
                        if (longOrNull4 != null && (l = this.$guildId) != null) {
                            Channel channel = this.$storeChannels.getChannelsForGuild(l.longValue()).get(longOrNull4);
                            String name9 = applicationCommandData3.getName();
                            String name10 = applicationCommandData3.getName();
                            String strValueOf5 = String.valueOf(channel != null ? channel.getName() : null);
                            StringBuilder sbQ5 = outline.Q(MentionUtils.CHANNELS_CHAR);
                            sbQ5.append(channel != null ? channel.getName() : null);
                            linkedHashMap3.put(name9, new WidgetApplicationCommandBottomSheetViewModel.SlashCommandParam(name10, strValueOf5, null, sbQ5.toString()));
                        }
                    } else {
                        String name11 = applicationCommandData3.getName();
                        String name12 = applicationCommandData3.getName();
                        Object value = applicationCommandData3.getValue();
                        String str = "";
                        if (value == null || (stringTruncateZeroDecimal = WidgetApplicationCommandBottomSheetViewModel3.toStringTruncateZeroDecimal(value)) == null) {
                            stringTruncateZeroDecimal = "";
                        }
                        Object value2 = applicationCommandData3.getValue();
                        if (value2 != null && (stringTruncateZeroDecimal2 = WidgetApplicationCommandBottomSheetViewModel3.toStringTruncateZeroDecimal(value2)) != null) {
                            str = stringTruncateZeroDecimal2;
                        }
                        linkedHashMap3.put(name11, new WidgetApplicationCommandBottomSheetViewModel.SlashCommandParam(name12, stringTruncateZeroDecimal, null, str));
                    }
                }
                if (linkedHashMap3.get(applicationCommandData3.getName()) == null) {
                    linkedHashMap3.put(applicationCommandData3.getName(), new WidgetApplicationCommandBottomSheetViewModel.SlashCommandParam(applicationCommandData3.getName(), WidgetApplicationCommandBottomSheetViewModel3.toStringTruncateZeroDecimal(applicationCommandData3.getValue()), null, WidgetApplicationCommandBottomSheetViewModel3.toStringTruncateZeroDecimal(applicationCommandData3.getValue())));
                }
            }
        }
        Map<Long, GuildMember> map5 = this.$storeGuilds.getMembers().get(this.$guildId);
        if (map5 != null) {
            LinkedHashMap linkedHashMap5 = new LinkedHashMap();
            for (Map.Entry<Long, GuildMember> entry : map5.entrySet()) {
                if (setMutableSetOf.contains(entry.getKey())) {
                    linkedHashMap5.put(entry.getKey(), entry.getValue());
                }
            }
            linkedHashMap = linkedHashMap5;
        } else {
            linkedHashMap = null;
        }
        Map<Long, GuildRole> map6 = this.$storeGuilds.getRoles().get(this.$guildId);
        if (map6 != null) {
            LinkedHashMap linkedHashMap6 = new LinkedHashMap();
            for (Map.Entry<Long, GuildRole> entry2 : map6.entrySet()) {
                if (linkedHashSet.contains(entry2.getKey())) {
                    linkedHashMap6.put(entry2.getKey(), entry2.getValue());
                }
            }
            linkedHashMap2 = linkedHashMap6;
        } else {
            linkedHashMap2 = null;
        }
        LinkedHashMap linkedHashMap7 = new LinkedHashMap();
        Iterator it3 = setMutableSetOf.iterator();
        while (it3.hasNext()) {
            long jLongValue = ((Number) it3.next()).longValue();
            User user3 = this.$storeUsers.getUsers().get(Long.valueOf(jLongValue));
            if (user3 != null) {
                linkedHashMap7.put(Long.valueOf(jLongValue), user3);
            }
        }
        User user4 = this.$storeUsers.getUsers().get(Long.valueOf(this.$userId));
        Map<Long, GuildMember> map7 = this.$storeGuilds.getMembers().get(this.$guildId);
        return new WidgetApplicationCommandBottomSheetViewModel.StoreState(user4, map7 != null ? map7.get(Long.valueOf(this.$userId)) : null, interactionData, application, setMutableSetOf, linkedHashMap, linkedHashMap2, linkedHashMap7, linkedHashMap4, linkedHashMap3);
    }
}
