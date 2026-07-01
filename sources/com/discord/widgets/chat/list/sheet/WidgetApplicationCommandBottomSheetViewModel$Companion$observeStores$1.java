package com.discord.widgets.chat.list.sheet;

import b.d.b.a.a;
import com.discord.api.channel.Channel;
import com.discord.api.commands.ApplicationCommandType;
import com.discord.api.commands.ApplicationCommandValue;
import com.discord.api.role.GuildRole;
import com.discord.models.commands.Application;
import com.discord.models.member.GuildMember;
import com.discord.models.user.User;
import com.discord.stores.StoreApplicationCommands;
import com.discord.stores.StoreApplicationInteractions;
import com.discord.stores.StoreApplicationInteractions$State;
import com.discord.stores.StoreApplicationInteractions$State$Loaded;
import com.discord.stores.StoreChannels;
import com.discord.stores.StoreGuilds;
import com.discord.stores.StoreUser;
import com.discord.utilities.guilds.RoleUtils;
import com.discord.widgets.chat.input.MentionUtilsKt;
import d0.g0.s;
import d0.t.n0;
import d0.z.d.o;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Map$Entry;
import java.util.Set;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: WidgetApplicationCommandBottomSheetViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetApplicationCommandBottomSheetViewModel$Companion$observeStores$1 extends o implements Function0<WidgetApplicationCommandBottomSheetViewModel$StoreState> {
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
    public WidgetApplicationCommandBottomSheetViewModel$Companion$observeStores$1(StoreApplicationInteractions storeApplicationInteractions, long j, StoreApplicationCommands storeApplicationCommands, long j2, long j3, StoreGuilds storeGuilds, Long l, StoreUser storeUser, StoreChannels storeChannels) {
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

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ WidgetApplicationCommandBottomSheetViewModel$StoreState invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final WidgetApplicationCommandBottomSheetViewModel$StoreState invoke() {
        LinkedHashMap linkedHashMap;
        LinkedHashMap linkedHashMap2;
        List<ApplicationCommandValue> listB;
        List<ApplicationCommandValue> listFlattenOptions;
        Iterator it;
        String stringTruncateZeroDecimal;
        String stringTruncateZeroDecimal2;
        Long l;
        StoreApplicationInteractions$State interactionData = this.$storeInteractions.getInteractionData(this.$interactionId);
        Application application = this.$storeApplicationCommands.getApplicationMap().get(Long.valueOf(this.$applicationId));
        LinkedHashMap linkedHashMap3 = new LinkedHashMap();
        Set setMutableSetOf = n0.mutableSetOf(Long.valueOf(this.$userId));
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        LinkedHashMap linkedHashMap4 = new LinkedHashMap();
        if ((interactionData instanceof StoreApplicationInteractions$State$Loaded) && (listB = ((StoreApplicationInteractions$State$Loaded) interactionData).getCommandOptions().b()) != null && (listFlattenOptions = WidgetApplicationCommandBottomSheetViewModelKt.flattenOptions(listB)) != null) {
            for (Iterator it2 = listFlattenOptions.iterator(); it2.hasNext(); it2 = it) {
                ApplicationCommandValue applicationCommandValue = (ApplicationCommandValue) it2.next();
                if (applicationCommandValue.getType() == ApplicationCommandType.USER.getType()) {
                    Long longOrNull = s.toLongOrNull(String.valueOf(applicationCommandValue.getValue()));
                    if (longOrNull != null) {
                        setMutableSetOf.add(longOrNull);
                        Map<Long, GuildMember> map = this.$storeGuilds.getMembers().get(this.$guildId);
                        GuildMember guildMember = map != null ? map.get(longOrNull) : null;
                        User user = this.$storeUsers.getUsers().get(longOrNull);
                        String name = applicationCommandValue.getName();
                        String name2 = applicationCommandValue.getName();
                        String strValueOf = String.valueOf(user != null ? user.getUsername() : null);
                        Integer numValueOf = guildMember != null ? Integer.valueOf(guildMember.getColor()) : null;
                        StringBuilder sbQ = a.Q(MentionUtilsKt.MENTIONS_CHAR);
                        it = it2;
                        sbQ.append(user != null ? user.getUsername() : null);
                        sbQ.append(MentionUtilsKt.CHANNELS_CHAR);
                        sbQ.append(user != null ? Integer.valueOf(user.getDiscriminator()) : null);
                        linkedHashMap3.put(name, new WidgetApplicationCommandBottomSheetViewModel$SlashCommandParam(name2, strValueOf, numValueOf, sbQ.toString()));
                    } else {
                        it = it2;
                    }
                } else {
                    it = it2;
                    if (applicationCommandValue.getType() == ApplicationCommandType.ROLE.getType()) {
                        Long longOrNull2 = s.toLongOrNull(String.valueOf(applicationCommandValue.getValue()));
                        if (longOrNull2 != null) {
                            Map<Long, GuildRole> map2 = this.$storeGuilds.getRoles().get(this.$guildId);
                            GuildRole guildRole = map2 != null ? map2.get(longOrNull2) : null;
                            String name3 = applicationCommandValue.getName();
                            String name4 = applicationCommandValue.getName();
                            String strValueOf2 = String.valueOf(guildRole != null ? guildRole.getName() : null);
                            Integer numValueOf2 = Integer.valueOf(RoleUtils.getOpaqueColor(guildRole));
                            StringBuilder sbQ2 = a.Q(MentionUtilsKt.MENTIONS_CHAR);
                            sbQ2.append(guildRole != null ? guildRole.getName() : null);
                            linkedHashMap3.put(name3, new WidgetApplicationCommandBottomSheetViewModel$SlashCommandParam(name4, strValueOf2, numValueOf2, sbQ2.toString()));
                        }
                    } else if (applicationCommandValue.getType() == ApplicationCommandType.MENTIONABLE.getType()) {
                        Long longOrNull3 = s.toLongOrNull(String.valueOf(applicationCommandValue.getValue()));
                        if (longOrNull3 != null) {
                            Map<Long, GuildRole> map3 = this.$storeGuilds.getRoles().get(this.$guildId);
                            GuildRole guildRole2 = map3 != null ? map3.get(longOrNull3) : null;
                            if (guildRole2 != null) {
                                String name5 = applicationCommandValue.getName();
                                String name6 = applicationCommandValue.getName();
                                String strValueOf3 = String.valueOf(guildRole2.getName());
                                Integer numValueOf3 = Integer.valueOf(RoleUtils.getOpaqueColor(guildRole2));
                                StringBuilder sbQ3 = a.Q(MentionUtilsKt.MENTIONS_CHAR);
                                sbQ3.append(guildRole2.getName());
                                linkedHashMap3.put(name5, new WidgetApplicationCommandBottomSheetViewModel$SlashCommandParam(name6, strValueOf3, numValueOf3, sbQ3.toString()));
                            } else {
                                Map<Long, GuildMember> map4 = this.$storeGuilds.getMembers().get(this.$guildId);
                                GuildMember guildMember2 = map4 != null ? map4.get(longOrNull3) : null;
                                User user2 = this.$storeUsers.getUsers().get(longOrNull3);
                                String name7 = applicationCommandValue.getName();
                                String name8 = applicationCommandValue.getName();
                                String strValueOf4 = String.valueOf(user2 != null ? user2.getUsername() : null);
                                Integer numValueOf4 = guildMember2 != null ? Integer.valueOf(guildMember2.getColor()) : null;
                                StringBuilder sbQ4 = a.Q(MentionUtilsKt.MENTIONS_CHAR);
                                sbQ4.append(user2 != null ? user2.getUsername() : null);
                                sbQ4.append(MentionUtilsKt.CHANNELS_CHAR);
                                sbQ4.append(user2 != null ? Integer.valueOf(user2.getDiscriminator()) : null);
                                linkedHashMap3.put(name7, new WidgetApplicationCommandBottomSheetViewModel$SlashCommandParam(name8, strValueOf4, numValueOf4, sbQ4.toString()));
                            }
                        }
                    } else if (applicationCommandValue.getType() == ApplicationCommandType.CHANNEL.getType()) {
                        Long longOrNull4 = s.toLongOrNull(String.valueOf(applicationCommandValue.getValue()));
                        if (longOrNull4 != null && (l = this.$guildId) != null) {
                            Channel channel = this.$storeChannels.getChannelsForGuild(l.longValue()).get(longOrNull4);
                            String name9 = applicationCommandValue.getName();
                            String name10 = applicationCommandValue.getName();
                            String strValueOf5 = String.valueOf(channel != null ? channel.getName() : null);
                            StringBuilder sbQ5 = a.Q(MentionUtilsKt.CHANNELS_CHAR);
                            sbQ5.append(channel != null ? channel.getName() : null);
                            linkedHashMap3.put(name9, new WidgetApplicationCommandBottomSheetViewModel$SlashCommandParam(name10, strValueOf5, null, sbQ5.toString()));
                        }
                    } else {
                        String name11 = applicationCommandValue.getName();
                        String name12 = applicationCommandValue.getName();
                        Object value = applicationCommandValue.getValue();
                        String str = "";
                        if (value == null || (stringTruncateZeroDecimal = WidgetApplicationCommandBottomSheetViewModelKt.toStringTruncateZeroDecimal(value)) == null) {
                            stringTruncateZeroDecimal = "";
                        }
                        Object value2 = applicationCommandValue.getValue();
                        if (value2 != null && (stringTruncateZeroDecimal2 = WidgetApplicationCommandBottomSheetViewModelKt.toStringTruncateZeroDecimal(value2)) != null) {
                            str = stringTruncateZeroDecimal2;
                        }
                        linkedHashMap3.put(name11, new WidgetApplicationCommandBottomSheetViewModel$SlashCommandParam(name12, stringTruncateZeroDecimal, null, str));
                    }
                }
                if (linkedHashMap3.get(applicationCommandValue.getName()) == null) {
                    linkedHashMap3.put(applicationCommandValue.getName(), new WidgetApplicationCommandBottomSheetViewModel$SlashCommandParam(applicationCommandValue.getName(), WidgetApplicationCommandBottomSheetViewModelKt.toStringTruncateZeroDecimal(applicationCommandValue.getValue()), null, WidgetApplicationCommandBottomSheetViewModelKt.toStringTruncateZeroDecimal(applicationCommandValue.getValue())));
                }
            }
        }
        Map<Long, GuildMember> map5 = this.$storeGuilds.getMembers().get(this.$guildId);
        if (map5 != null) {
            LinkedHashMap linkedHashMap5 = new LinkedHashMap();
            for (Map$Entry<Long, GuildMember> map$Entry : map5.entrySet()) {
                if (setMutableSetOf.contains(map$Entry.getKey())) {
                    linkedHashMap5.put(map$Entry.getKey(), map$Entry.getValue());
                }
            }
            linkedHashMap = linkedHashMap5;
        } else {
            linkedHashMap = null;
        }
        Map<Long, GuildRole> map6 = this.$storeGuilds.getRoles().get(this.$guildId);
        if (map6 != null) {
            LinkedHashMap linkedHashMap6 = new LinkedHashMap();
            for (Map$Entry<Long, GuildRole> map$Entry2 : map6.entrySet()) {
                if (linkedHashSet.contains(map$Entry2.getKey())) {
                    linkedHashMap6.put(map$Entry2.getKey(), map$Entry2.getValue());
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
        return new WidgetApplicationCommandBottomSheetViewModel$StoreState(user4, map7 != null ? map7.get(Long.valueOf(this.$userId)) : null, interactionData, application, setMutableSetOf, linkedHashMap, linkedHashMap2, linkedHashMap7, linkedHashMap4, linkedHashMap3);
    }
}
