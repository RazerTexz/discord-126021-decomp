package com.discord.widgets.chat.input.autocomplete;

import a0.a.a.b;
import b.d.b.a.a;
import com.discord.api.channel.Channel;
import com.discord.models.commands.Application;
import com.discord.models.commands.ApplicationCommand;
import com.discord.stores.CommandAutocompleteState;
import com.discord.widgets.chat.input.WidgetChatInputDiscoveryCommandsModel;
import d0.t.h0;
import d0.t.n;
import d0.z.d.m;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: AutocompleteViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class AutocompleteViewModel$StoreState {
    private final List<Application> applications;
    private final Map<LeadingIdentifier, Set<Autocompletable>> autocompletables;
    private final WidgetChatInputDiscoveryCommandsModel browserCommands;
    private final Channel channel;
    private final Map<String, Map<String, CommandAutocompleteState>> commandOptionAutocompleteItems;
    private final List<String> frecencyCommandIds;
    private final List<ApplicationCommand> frecencyCommands;
    private final List<ApplicationCommand> queriedCommands;
    private final long userId;
    private final List<Long> userRoles;

    /* JADX WARN: Multi-variable type inference failed */
    public AutocompleteViewModel$StoreState(long j, List<Long> list, Channel channel, List<? extends ApplicationCommand> list2, List<Application> list3, Map<String, ? extends Map<String, ? extends CommandAutocompleteState>> map, Map<LeadingIdentifier, ? extends Set<? extends Autocompletable>> map2, WidgetChatInputDiscoveryCommandsModel widgetChatInputDiscoveryCommandsModel, List<String> list4, List<? extends ApplicationCommand> list5) {
        m.checkNotNullParameter(list, "userRoles");
        m.checkNotNullParameter(channel, "channel");
        m.checkNotNullParameter(list2, "queriedCommands");
        m.checkNotNullParameter(list3, "applications");
        m.checkNotNullParameter(map, "commandOptionAutocompleteItems");
        m.checkNotNullParameter(map2, "autocompletables");
        m.checkNotNullParameter(list4, "frecencyCommandIds");
        m.checkNotNullParameter(list5, "frecencyCommands");
        this.userId = j;
        this.userRoles = list;
        this.channel = channel;
        this.queriedCommands = list2;
        this.applications = list3;
        this.commandOptionAutocompleteItems = map;
        this.autocompletables = map2;
        this.browserCommands = widgetChatInputDiscoveryCommandsModel;
        this.frecencyCommandIds = list4;
        this.frecencyCommands = list5;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ AutocompleteViewModel$StoreState copy$default(AutocompleteViewModel$StoreState autocompleteViewModel$StoreState, long j, List list, Channel channel, List list2, List list3, Map map, Map map2, WidgetChatInputDiscoveryCommandsModel widgetChatInputDiscoveryCommandsModel, List list4, List list5, int i, Object obj) {
        return autocompleteViewModel$StoreState.copy((i & 1) != 0 ? autocompleteViewModel$StoreState.userId : j, (i & 2) != 0 ? autocompleteViewModel$StoreState.userRoles : list, (i & 4) != 0 ? autocompleteViewModel$StoreState.channel : channel, (i & 8) != 0 ? autocompleteViewModel$StoreState.queriedCommands : list2, (i & 16) != 0 ? autocompleteViewModel$StoreState.applications : list3, (i & 32) != 0 ? autocompleteViewModel$StoreState.commandOptionAutocompleteItems : map, (i & 64) != 0 ? autocompleteViewModel$StoreState.autocompletables : map2, (i & 128) != 0 ? autocompleteViewModel$StoreState.browserCommands : widgetChatInputDiscoveryCommandsModel, (i & 256) != 0 ? autocompleteViewModel$StoreState.frecencyCommandIds : list4, (i & 512) != 0 ? autocompleteViewModel$StoreState.frecencyCommands : list5);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final long getUserId() {
        return this.userId;
    }

    public final List<ApplicationCommand> component10() {
        return this.frecencyCommands;
    }

    public final List<Long> component2() {
        return this.userRoles;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final Channel getChannel() {
        return this.channel;
    }

    public final List<ApplicationCommand> component4() {
        return this.queriedCommands;
    }

    public final List<Application> component5() {
        return this.applications;
    }

    public final Map<String, Map<String, CommandAutocompleteState>> component6() {
        return this.commandOptionAutocompleteItems;
    }

    public final Map<LeadingIdentifier, Set<Autocompletable>> component7() {
        return this.autocompletables;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final WidgetChatInputDiscoveryCommandsModel getBrowserCommands() {
        return this.browserCommands;
    }

    public final List<String> component9() {
        return this.frecencyCommandIds;
    }

    public final AutocompleteViewModel$StoreState copy(long userId, List<Long> userRoles, Channel channel, List<? extends ApplicationCommand> queriedCommands, List<Application> applications, Map<String, ? extends Map<String, ? extends CommandAutocompleteState>> commandOptionAutocompleteItems, Map<LeadingIdentifier, ? extends Set<? extends Autocompletable>> autocompletables, WidgetChatInputDiscoveryCommandsModel browserCommands, List<String> frecencyCommandIds, List<? extends ApplicationCommand> frecencyCommands) {
        m.checkNotNullParameter(userRoles, "userRoles");
        m.checkNotNullParameter(channel, "channel");
        m.checkNotNullParameter(queriedCommands, "queriedCommands");
        m.checkNotNullParameter(applications, "applications");
        m.checkNotNullParameter(commandOptionAutocompleteItems, "commandOptionAutocompleteItems");
        m.checkNotNullParameter(autocompletables, "autocompletables");
        m.checkNotNullParameter(frecencyCommandIds, "frecencyCommandIds");
        m.checkNotNullParameter(frecencyCommands, "frecencyCommands");
        return new AutocompleteViewModel$StoreState(userId, userRoles, channel, queriedCommands, applications, commandOptionAutocompleteItems, autocompletables, browserCommands, frecencyCommandIds, frecencyCommands);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AutocompleteViewModel$StoreState)) {
            return false;
        }
        AutocompleteViewModel$StoreState autocompleteViewModel$StoreState = (AutocompleteViewModel$StoreState) other;
        return this.userId == autocompleteViewModel$StoreState.userId && m.areEqual(this.userRoles, autocompleteViewModel$StoreState.userRoles) && m.areEqual(this.channel, autocompleteViewModel$StoreState.channel) && m.areEqual(this.queriedCommands, autocompleteViewModel$StoreState.queriedCommands) && m.areEqual(this.applications, autocompleteViewModel$StoreState.applications) && m.areEqual(this.commandOptionAutocompleteItems, autocompleteViewModel$StoreState.commandOptionAutocompleteItems) && m.areEqual(this.autocompletables, autocompleteViewModel$StoreState.autocompletables) && m.areEqual(this.browserCommands, autocompleteViewModel$StoreState.browserCommands) && m.areEqual(this.frecencyCommandIds, autocompleteViewModel$StoreState.frecencyCommandIds) && m.areEqual(this.frecencyCommands, autocompleteViewModel$StoreState.frecencyCommands);
    }

    public final List<Application> getApplications() {
        return this.applications;
    }

    public final Map<LeadingIdentifier, Set<Autocompletable>> getAutocompletables() {
        return this.autocompletables;
    }

    public final WidgetChatInputDiscoveryCommandsModel getBrowserCommands() {
        return this.browserCommands;
    }

    public final Channel getChannel() {
        return this.channel;
    }

    public final Map<String, Map<String, CommandAutocompleteState>> getCommandOptionAutocompleteItems() {
        return this.commandOptionAutocompleteItems;
    }

    public final List<String> getFrecencyCommandIds() {
        return this.frecencyCommandIds;
    }

    public final List<ApplicationCommand> getFrecencyCommands() {
        return this.frecencyCommands;
    }

    public final List<ApplicationCommand> getQueriedCommands() {
        return this.queriedCommands;
    }

    public final long getUserId() {
        return this.userId;
    }

    public final List<Long> getUserRoles() {
        return this.userRoles;
    }

    public int hashCode() {
        int iA = b.a(this.userId) * 31;
        List<Long> list = this.userRoles;
        int iHashCode = (iA + (list != null ? list.hashCode() : 0)) * 31;
        Channel channel = this.channel;
        int iHashCode2 = (iHashCode + (channel != null ? channel.hashCode() : 0)) * 31;
        List<ApplicationCommand> list2 = this.queriedCommands;
        int iHashCode3 = (iHashCode2 + (list2 != null ? list2.hashCode() : 0)) * 31;
        List<Application> list3 = this.applications;
        int iHashCode4 = (iHashCode3 + (list3 != null ? list3.hashCode() : 0)) * 31;
        Map<String, Map<String, CommandAutocompleteState>> map = this.commandOptionAutocompleteItems;
        int iHashCode5 = (iHashCode4 + (map != null ? map.hashCode() : 0)) * 31;
        Map<LeadingIdentifier, Set<Autocompletable>> map2 = this.autocompletables;
        int iHashCode6 = (iHashCode5 + (map2 != null ? map2.hashCode() : 0)) * 31;
        WidgetChatInputDiscoveryCommandsModel widgetChatInputDiscoveryCommandsModel = this.browserCommands;
        int iHashCode7 = (iHashCode6 + (widgetChatInputDiscoveryCommandsModel != null ? widgetChatInputDiscoveryCommandsModel.hashCode() : 0)) * 31;
        List<String> list4 = this.frecencyCommandIds;
        int iHashCode8 = (iHashCode7 + (list4 != null ? list4.hashCode() : 0)) * 31;
        List<ApplicationCommand> list5 = this.frecencyCommands;
        return iHashCode8 + (list5 != null ? list5.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("StoreState(userId=");
        sbU.append(this.userId);
        sbU.append(", userRoles=");
        sbU.append(this.userRoles);
        sbU.append(", channel=");
        sbU.append(this.channel);
        sbU.append(", queriedCommands=");
        sbU.append(this.queriedCommands);
        sbU.append(", applications=");
        sbU.append(this.applications);
        sbU.append(", commandOptionAutocompleteItems=");
        sbU.append(this.commandOptionAutocompleteItems);
        sbU.append(", autocompletables=");
        sbU.append(this.autocompletables);
        sbU.append(", browserCommands=");
        sbU.append(this.browserCommands);
        sbU.append(", frecencyCommandIds=");
        sbU.append(this.frecencyCommandIds);
        sbU.append(", frecencyCommands=");
        return a.L(sbU, this.frecencyCommands, ")");
    }

    public /* synthetic */ AutocompleteViewModel$StoreState(long j, List list, Channel channel, List list2, List list3, Map map, Map map2, WidgetChatInputDiscoveryCommandsModel widgetChatInputDiscoveryCommandsModel, List list4, List list5, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, list, channel, (i & 8) != 0 ? n.emptyList() : list2, (i & 16) != 0 ? n.emptyList() : list3, (i & 32) != 0 ? h0.emptyMap() : map, (i & 64) != 0 ? h0.emptyMap() : map2, (i & 128) != 0 ? null : widgetChatInputDiscoveryCommandsModel, (i & 256) != 0 ? n.emptyList() : list4, (i & 512) != 0 ? n.emptyList() : list5);
    }
}
