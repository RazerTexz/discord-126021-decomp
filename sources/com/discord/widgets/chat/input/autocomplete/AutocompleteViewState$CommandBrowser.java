package com.discord.widgets.chat.input.autocomplete;

import b.d.b.a.a;
import com.discord.models.commands.Application;
import com.discord.models.commands.ApplicationCommand;
import com.discord.widgets.chat.input.WidgetChatInputDiscoveryCommandsModel;
import d0.z.d.m;
import java.util.List;

/* JADX INFO: compiled from: AutocompleteViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class AutocompleteViewState$CommandBrowser extends AutocompleteViewState {
    private final List<Application> applications;
    private final WidgetChatInputDiscoveryCommandsModel discoverCommands;
    private final List<ApplicationCommand> frequentCommands;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public AutocompleteViewState$CommandBrowser(List<? extends ApplicationCommand> list, List<Application> list2, WidgetChatInputDiscoveryCommandsModel widgetChatInputDiscoveryCommandsModel) {
        super(null);
        m.checkNotNullParameter(list, "frequentCommands");
        m.checkNotNullParameter(list2, "applications");
        m.checkNotNullParameter(widgetChatInputDiscoveryCommandsModel, "discoverCommands");
        this.frequentCommands = list;
        this.applications = list2;
        this.discoverCommands = widgetChatInputDiscoveryCommandsModel;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ AutocompleteViewState$CommandBrowser copy$default(AutocompleteViewState$CommandBrowser autocompleteViewState$CommandBrowser, List list, List list2, WidgetChatInputDiscoveryCommandsModel widgetChatInputDiscoveryCommandsModel, int i, Object obj) {
        if ((i & 1) != 0) {
            list = autocompleteViewState$CommandBrowser.frequentCommands;
        }
        if ((i & 2) != 0) {
            list2 = autocompleteViewState$CommandBrowser.applications;
        }
        if ((i & 4) != 0) {
            widgetChatInputDiscoveryCommandsModel = autocompleteViewState$CommandBrowser.discoverCommands;
        }
        return autocompleteViewState$CommandBrowser.copy(list, list2, widgetChatInputDiscoveryCommandsModel);
    }

    public final List<ApplicationCommand> component1() {
        return this.frequentCommands;
    }

    public final List<Application> component2() {
        return this.applications;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final WidgetChatInputDiscoveryCommandsModel getDiscoverCommands() {
        return this.discoverCommands;
    }

    public final AutocompleteViewState$CommandBrowser copy(List<? extends ApplicationCommand> frequentCommands, List<Application> applications, WidgetChatInputDiscoveryCommandsModel discoverCommands) {
        m.checkNotNullParameter(frequentCommands, "frequentCommands");
        m.checkNotNullParameter(applications, "applications");
        m.checkNotNullParameter(discoverCommands, "discoverCommands");
        return new AutocompleteViewState$CommandBrowser(frequentCommands, applications, discoverCommands);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AutocompleteViewState$CommandBrowser)) {
            return false;
        }
        AutocompleteViewState$CommandBrowser autocompleteViewState$CommandBrowser = (AutocompleteViewState$CommandBrowser) other;
        return m.areEqual(this.frequentCommands, autocompleteViewState$CommandBrowser.frequentCommands) && m.areEqual(this.applications, autocompleteViewState$CommandBrowser.applications) && m.areEqual(this.discoverCommands, autocompleteViewState$CommandBrowser.discoverCommands);
    }

    public final List<Application> getApplications() {
        return this.applications;
    }

    public final WidgetChatInputDiscoveryCommandsModel getDiscoverCommands() {
        return this.discoverCommands;
    }

    public final List<ApplicationCommand> getFrequentCommands() {
        return this.frequentCommands;
    }

    public int hashCode() {
        List<ApplicationCommand> list = this.frequentCommands;
        int iHashCode = (list != null ? list.hashCode() : 0) * 31;
        List<Application> list2 = this.applications;
        int iHashCode2 = (iHashCode + (list2 != null ? list2.hashCode() : 0)) * 31;
        WidgetChatInputDiscoveryCommandsModel widgetChatInputDiscoveryCommandsModel = this.discoverCommands;
        return iHashCode2 + (widgetChatInputDiscoveryCommandsModel != null ? widgetChatInputDiscoveryCommandsModel.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("CommandBrowser(frequentCommands=");
        sbU.append(this.frequentCommands);
        sbU.append(", applications=");
        sbU.append(this.applications);
        sbU.append(", discoverCommands=");
        sbU.append(this.discoverCommands);
        sbU.append(")");
        return sbU.toString();
    }
}
