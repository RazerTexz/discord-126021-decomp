package com.discord.widgets.chat.input.models;

import b.d.b.a.outline;
import com.discord.models.commands.Application;
import com.discord.models.commands.ApplicationCommand;
import com.discord.widgets.chat.input.WidgetChatInputDiscoveryCommandsModel;
import d0.t.Collections2;
import d0.z.d.Intrinsics3;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;

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
        Intrinsics3.checkNotNullParameter(list, "applications");
        Intrinsics3.checkNotNullParameter(list2, "queryCommands");
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
        Intrinsics3.checkNotNullParameter(applications, "applications");
        Intrinsics3.checkNotNullParameter(queryCommands, "queryCommands");
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
        return Intrinsics3.areEqual(this.applications, autocompleteApplicationCommands.applications) && Intrinsics3.areEqual(this.queryCommands, autocompleteApplicationCommands.queryCommands) && Intrinsics3.areEqual(this.discoveryCommands, autocompleteApplicationCommands.discoveryCommands);
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
        StringBuilder sbU = outline.U("AutocompleteApplicationCommands(applications=");
        sbU.append(this.applications);
        sbU.append(", queryCommands=");
        sbU.append(this.queryCommands);
        sbU.append(", discoveryCommands=");
        sbU.append(this.discoveryCommands);
        sbU.append(")");
        return sbU.toString();
    }

    public /* synthetic */ AutocompleteApplicationCommands(List list, List list2, WidgetChatInputDiscoveryCommandsModel widgetChatInputDiscoveryCommandsModel, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? Collections2.emptyList() : list, (i & 2) != 0 ? Collections2.emptyList() : list2, (i & 4) != 0 ? null : widgetChatInputDiscoveryCommandsModel);
    }
}
