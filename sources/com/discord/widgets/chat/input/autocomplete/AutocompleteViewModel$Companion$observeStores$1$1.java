package com.discord.widgets.chat.input.autocomplete;

import androidx.core.app.NotificationCompat;
import com.discord.api.channel.Channel;
import com.discord.models.commands.Application;
import com.discord.models.commands.ApplicationCommand;
import com.discord.models.member.GuildMember;
import com.discord.stores.CommandAutocompleteState;
import com.discord.widgets.chat.input.WidgetChatInputDiscoveryCommandsModel;
import d0.t.n;
import d0.z.d.m;
import java.util.List;
import java.util.Map;
import java.util.Set;
import rx.functions.Func9;

/* JADX INFO: compiled from: AutocompleteViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class AutocompleteViewModel$Companion$observeStores$1$1<T1, T2, T3, T4, T5, T6, T7, T8, T9, R> implements Func9<Long, Map<Long, ? extends GuildMember>, WidgetChatInputDiscoveryCommandsModel, List<? extends ApplicationCommand>, Map<LeadingIdentifier, ? extends Set<? extends Autocompletable>>, List<? extends Application>, Map<String, ? extends Map<String, ? extends CommandAutocompleteState>>, List<? extends String>, List<? extends ApplicationCommand>, AutocompleteViewModel$StoreState> {
    public final /* synthetic */ Channel $channel;

    public AutocompleteViewModel$Companion$observeStores$1$1(Channel channel) {
        this.$channel = channel;
    }

    @Override // rx.functions.Func9
    public /* bridge */ /* synthetic */ AutocompleteViewModel$StoreState call(Long l, Map<Long, ? extends GuildMember> map, WidgetChatInputDiscoveryCommandsModel widgetChatInputDiscoveryCommandsModel, List<? extends ApplicationCommand> list, Map<LeadingIdentifier, ? extends Set<? extends Autocompletable>> map2, List<? extends Application> list2, Map<String, ? extends Map<String, ? extends CommandAutocompleteState>> map3, List<? extends String> list3, List<? extends ApplicationCommand> list4) {
        return call2(l, (Map<Long, GuildMember>) map, widgetChatInputDiscoveryCommandsModel, list, map2, (List<Application>) list2, map3, (List<String>) list3, list4);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final AutocompleteViewModel$StoreState call2(Long l, Map<Long, GuildMember> map, WidgetChatInputDiscoveryCommandsModel widgetChatInputDiscoveryCommandsModel, List<? extends ApplicationCommand> list, Map<LeadingIdentifier, ? extends Set<? extends Autocompletable>> map2, List<Application> list2, Map<String, ? extends Map<String, ? extends CommandAutocompleteState>> map3, List<String> list3, List<? extends ApplicationCommand> list4) {
        m.checkNotNullExpressionValue(l, "userId");
        long jLongValue = l.longValue();
        GuildMember guildMember = map.get(l);
        List<Long> roles = guildMember != null ? guildMember.getRoles() : null;
        if (roles == null) {
            roles = n.emptyList();
        }
        Channel channel = this.$channel;
        m.checkNotNullExpressionValue(channel, "channel");
        m.checkNotNullExpressionValue(list, "queriedCommands");
        m.checkNotNullExpressionValue(list2, "apps");
        m.checkNotNullExpressionValue(map3, "autoOptions");
        m.checkNotNullExpressionValue(map2, "autocompletables");
        m.checkNotNullExpressionValue(list3, "frecencyIds");
        m.checkNotNullExpressionValue(list4, "frecencyApps");
        return new AutocompleteViewModel$StoreState(jLongValue, roles, channel, list, list2, map3, map2, widgetChatInputDiscoveryCommandsModel, list3, list4);
    }
}
