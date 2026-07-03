package com.discord.widgets.chat.input.models;

import com.discord.models.commands.Application;
import com.discord.models.commands.ApplicationCommand;
import com.discord.widgets.chat.input.WidgetChatInputDiscoveryCommandsModel;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p580t.C12147n;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: AutocompleteApplicationCommands.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class AutocompleteApplicationCommands {
    private final List<Application> applications;
    private final WidgetChatInputDiscoveryCommandsModel discoveryCommands;
    private final List<ApplicationCommand> queryCommands;

    public AutocompleteApplicationCommands() {
        this(null, null, null, 7, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public AutocompleteApplicationCommands(List<Application> list, List<? extends ApplicationCommand> list2, WidgetChatInputDiscoveryCommandsModel widgetChatInputDiscoveryCommandsModel) {
        C12238m.checkNotNullParameter(list, "applications");
        C12238m.checkNotNullParameter(list2, "queryCommands");
        this.applications = list;
        this.queryCommands = list2;
        this.discoveryCommands = widgetChatInputDiscoveryCommandsModel;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ AutocompleteApplicationCommands copy$default(AutocompleteApplicationCommands autocompleteApplicationCommands, List list, List list2, WidgetChatInputDiscoveryCommandsModel widgetChatInputDiscoveryCommandsModel, int i, Object obj) {
        if ((i & 1) != 0) {
            list = autocompleteApplicationCommands.applications;
        }
        if ((i & 2) != 0) {
            list2 = autocompleteApplicationCommands.queryCommands;
        }
        if ((i & 4) != 0) {
            widgetChatInputDiscoveryCommandsModel = autocompleteApplicationCommands.discoveryCommands;
        }
        return autocompleteApplicationCommands.copy(list, list2, widgetChatInputDiscoveryCommandsModel);
    }

    public final List<Application> component1() {
        return this.applications;
    }

    public final List<ApplicationCommand> component2() {
        return this.queryCommands;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final WidgetChatInputDiscoveryCommandsModel getDiscoveryCommands() {
        return this.discoveryCommands;
    }

    public final AutocompleteApplicationCommands copy(List<Application> applications, List<? extends ApplicationCommand> queryCommands, WidgetChatInputDiscoveryCommandsModel discoveryCommands) {
        C12238m.checkNotNullParameter(applications, "applications");
        C12238m.checkNotNullParameter(queryCommands, "queryCommands");
        return new AutocompleteApplicationCommands(applications, queryCommands, discoveryCommands);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AutocompleteApplicationCommands)) {
            return false;
        }
        AutocompleteApplicationCommands autocompleteApplicationCommands = (AutocompleteApplicationCommands) other;
        return C12238m.areEqual(this.applications, autocompleteApplicationCommands.applications) && C12238m.areEqual(this.queryCommands, autocompleteApplicationCommands.queryCommands) && C12238m.areEqual(this.discoveryCommands, autocompleteApplicationCommands.discoveryCommands);
    }

    public final List<Application> getApplications() {
        return this.applications;
    }

    public final WidgetChatInputDiscoveryCommandsModel getDiscoveryCommands() {
        return this.discoveryCommands;
    }

    public final List<ApplicationCommand> getQueryCommands() {
        return this.queryCommands;
    }

    public int hashCode() {
        List<Application> list = this.applications;
        int iHashCode = (list != null ? list.hashCode() : 0) * 31;
        List<ApplicationCommand> list2 = this.queryCommands;
        int iHashCode2 = (iHashCode + (list2 != null ? list2.hashCode() : 0)) * 31;
        WidgetChatInputDiscoveryCommandsModel widgetChatInputDiscoveryCommandsModel = this.discoveryCommands;
        return iHashCode2 + (widgetChatInputDiscoveryCommandsModel != null ? widgetChatInputDiscoveryCommandsModel.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("AutocompleteApplicationCommands(applications=");
        sbM833U.append(this.applications);
        sbM833U.append(", queryCommands=");
        sbM833U.append(this.queryCommands);
        sbM833U.append(", discoveryCommands=");
        sbM833U.append(this.discoveryCommands);
        sbM833U.append(")");
        return sbM833U.toString();
    }

    public /* synthetic */ AutocompleteApplicationCommands(List list, List list2, WidgetChatInputDiscoveryCommandsModel widgetChatInputDiscoveryCommandsModel, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? C12147n.emptyList() : list, (i & 2) != 0 ? C12147n.emptyList() : list2, (i & 4) != 0 ? null : widgetChatInputDiscoveryCommandsModel);
    }
}
