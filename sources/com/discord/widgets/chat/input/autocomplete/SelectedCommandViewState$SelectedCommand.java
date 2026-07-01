package com.discord.widgets.chat.input.autocomplete;

import b.d.b.a.a;
import com.discord.models.commands.Application;
import com.discord.models.commands.ApplicationCommand;
import com.discord.models.commands.ApplicationCommandOption;
import d0.t.h0;
import d0.t.n0;
import d0.z.d.m;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: AutocompleteViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class SelectedCommandViewState$SelectedCommand extends SelectedCommandViewState {
    private final Application selectedApplication;
    private final ApplicationCommand selectedCommand;
    private final ApplicationCommandOption selectedCommandOption;
    private final Set<ApplicationCommandOption> selectedCommandOptionErrors;
    private final Map<ApplicationCommandOption, Boolean> validSelectedCommandOptions;

    public /* synthetic */ SelectedCommandViewState$SelectedCommand(ApplicationCommand applicationCommand, ApplicationCommandOption applicationCommandOption, Set set, Map map, Application application, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(applicationCommand, applicationCommandOption, (i & 4) != 0 ? n0.emptySet() : set, (i & 8) != 0 ? h0.emptyMap() : map, application);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ SelectedCommandViewState$SelectedCommand copy$default(SelectedCommandViewState$SelectedCommand selectedCommandViewState$SelectedCommand, ApplicationCommand applicationCommand, ApplicationCommandOption applicationCommandOption, Set set, Map map, Application application, int i, Object obj) {
        if ((i & 1) != 0) {
            applicationCommand = selectedCommandViewState$SelectedCommand.selectedCommand;
        }
        if ((i & 2) != 0) {
            applicationCommandOption = selectedCommandViewState$SelectedCommand.selectedCommandOption;
        }
        ApplicationCommandOption applicationCommandOption2 = applicationCommandOption;
        if ((i & 4) != 0) {
            set = selectedCommandViewState$SelectedCommand.selectedCommandOptionErrors;
        }
        Set set2 = set;
        if ((i & 8) != 0) {
            map = selectedCommandViewState$SelectedCommand.validSelectedCommandOptions;
        }
        Map map2 = map;
        if ((i & 16) != 0) {
            application = selectedCommandViewState$SelectedCommand.selectedApplication;
        }
        return selectedCommandViewState$SelectedCommand.copy(applicationCommand, applicationCommandOption2, set2, map2, application);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final ApplicationCommand getSelectedCommand() {
        return this.selectedCommand;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final ApplicationCommandOption getSelectedCommandOption() {
        return this.selectedCommandOption;
    }

    public final Set<ApplicationCommandOption> component3() {
        return this.selectedCommandOptionErrors;
    }

    public final Map<ApplicationCommandOption, Boolean> component4() {
        return this.validSelectedCommandOptions;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final Application getSelectedApplication() {
        return this.selectedApplication;
    }

    public final SelectedCommandViewState$SelectedCommand copy(ApplicationCommand selectedCommand, ApplicationCommandOption selectedCommandOption, Set<ApplicationCommandOption> selectedCommandOptionErrors, Map<ApplicationCommandOption, Boolean> validSelectedCommandOptions, Application selectedApplication) {
        m.checkNotNullParameter(selectedCommand, "selectedCommand");
        m.checkNotNullParameter(selectedCommandOptionErrors, "selectedCommandOptionErrors");
        m.checkNotNullParameter(validSelectedCommandOptions, "validSelectedCommandOptions");
        m.checkNotNullParameter(selectedApplication, "selectedApplication");
        return new SelectedCommandViewState$SelectedCommand(selectedCommand, selectedCommandOption, selectedCommandOptionErrors, validSelectedCommandOptions, selectedApplication);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SelectedCommandViewState$SelectedCommand)) {
            return false;
        }
        SelectedCommandViewState$SelectedCommand selectedCommandViewState$SelectedCommand = (SelectedCommandViewState$SelectedCommand) other;
        return m.areEqual(this.selectedCommand, selectedCommandViewState$SelectedCommand.selectedCommand) && m.areEqual(this.selectedCommandOption, selectedCommandViewState$SelectedCommand.selectedCommandOption) && m.areEqual(this.selectedCommandOptionErrors, selectedCommandViewState$SelectedCommand.selectedCommandOptionErrors) && m.areEqual(this.validSelectedCommandOptions, selectedCommandViewState$SelectedCommand.validSelectedCommandOptions) && m.areEqual(this.selectedApplication, selectedCommandViewState$SelectedCommand.selectedApplication);
    }

    public final Application getSelectedApplication() {
        return this.selectedApplication;
    }

    public final ApplicationCommand getSelectedCommand() {
        return this.selectedCommand;
    }

    public final ApplicationCommandOption getSelectedCommandOption() {
        return this.selectedCommandOption;
    }

    public final Set<ApplicationCommandOption> getSelectedCommandOptionErrors() {
        return this.selectedCommandOptionErrors;
    }

    public final Map<ApplicationCommandOption, Boolean> getValidSelectedCommandOptions() {
        return this.validSelectedCommandOptions;
    }

    public int hashCode() {
        ApplicationCommand applicationCommand = this.selectedCommand;
        int iHashCode = (applicationCommand != null ? applicationCommand.hashCode() : 0) * 31;
        ApplicationCommandOption applicationCommandOption = this.selectedCommandOption;
        int iHashCode2 = (iHashCode + (applicationCommandOption != null ? applicationCommandOption.hashCode() : 0)) * 31;
        Set<ApplicationCommandOption> set = this.selectedCommandOptionErrors;
        int iHashCode3 = (iHashCode2 + (set != null ? set.hashCode() : 0)) * 31;
        Map<ApplicationCommandOption, Boolean> map = this.validSelectedCommandOptions;
        int iHashCode4 = (iHashCode3 + (map != null ? map.hashCode() : 0)) * 31;
        Application application = this.selectedApplication;
        return iHashCode4 + (application != null ? application.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("SelectedCommand(selectedCommand=");
        sbU.append(this.selectedCommand);
        sbU.append(", selectedCommandOption=");
        sbU.append(this.selectedCommandOption);
        sbU.append(", selectedCommandOptionErrors=");
        sbU.append(this.selectedCommandOptionErrors);
        sbU.append(", validSelectedCommandOptions=");
        sbU.append(this.validSelectedCommandOptions);
        sbU.append(", selectedApplication=");
        sbU.append(this.selectedApplication);
        sbU.append(")");
        return sbU.toString();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SelectedCommandViewState$SelectedCommand(ApplicationCommand applicationCommand, ApplicationCommandOption applicationCommandOption, Set<ApplicationCommandOption> set, Map<ApplicationCommandOption, Boolean> map, Application application) {
        super(null);
        m.checkNotNullParameter(applicationCommand, "selectedCommand");
        m.checkNotNullParameter(set, "selectedCommandOptionErrors");
        m.checkNotNullParameter(map, "validSelectedCommandOptions");
        m.checkNotNullParameter(application, "selectedApplication");
        this.selectedCommand = applicationCommand;
        this.selectedCommandOption = applicationCommandOption;
        this.selectedCommandOptionErrors = set;
        this.validSelectedCommandOptions = map;
        this.selectedApplication = application;
    }
}
