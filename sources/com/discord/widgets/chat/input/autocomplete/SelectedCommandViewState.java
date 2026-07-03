package com.discord.widgets.chat.input.autocomplete;

import com.discord.models.commands.Application;
import com.discord.models.commands.ApplicationCommand;
import com.discord.models.commands.ApplicationCommandOption;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p580t.C12136h0;
import p507d0.p580t.C12148n0;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: AutocompleteViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public abstract class SelectedCommandViewState {

    /* JADX INFO: compiled from: AutocompleteViewModel.kt */
    public static final class Hidden extends SelectedCommandViewState {
        public static final Hidden INSTANCE = new Hidden();

        private Hidden() {
            super(null);
        }
    }

    private SelectedCommandViewState() {
    }

    /* JADX INFO: compiled from: AutocompleteViewModel.kt */
    public static final /* data */ class SelectedCommand extends SelectedCommandViewState {
        private final Application selectedApplication;
        private final ApplicationCommand selectedCommand;
        private final ApplicationCommandOption selectedCommandOption;
        private final Set<ApplicationCommandOption> selectedCommandOptionErrors;
        private final Map<ApplicationCommandOption, Boolean> validSelectedCommandOptions;

        public /* synthetic */ SelectedCommand(ApplicationCommand applicationCommand, ApplicationCommandOption applicationCommandOption, Set set, Map map, Application application, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(applicationCommand, applicationCommandOption, (i & 4) != 0 ? C12148n0.emptySet() : set, (i & 8) != 0 ? C12136h0.emptyMap() : map, application);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ SelectedCommand copy$default(SelectedCommand selectedCommand, ApplicationCommand applicationCommand, ApplicationCommandOption applicationCommandOption, Set set, Map map, Application application, int i, Object obj) {
            if ((i & 1) != 0) {
                applicationCommand = selectedCommand.selectedCommand;
            }
            if ((i & 2) != 0) {
                applicationCommandOption = selectedCommand.selectedCommandOption;
            }
            ApplicationCommandOption applicationCommandOption2 = applicationCommandOption;
            if ((i & 4) != 0) {
                set = selectedCommand.selectedCommandOptionErrors;
            }
            Set set2 = set;
            if ((i & 8) != 0) {
                map = selectedCommand.validSelectedCommandOptions;
            }
            Map map2 = map;
            if ((i & 16) != 0) {
                application = selectedCommand.selectedApplication;
            }
            return selectedCommand.copy(applicationCommand, applicationCommandOption2, set2, map2, application);
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

        public final SelectedCommand copy(ApplicationCommand selectedCommand, ApplicationCommandOption selectedCommandOption, Set<ApplicationCommandOption> selectedCommandOptionErrors, Map<ApplicationCommandOption, Boolean> validSelectedCommandOptions, Application selectedApplication) {
            C12238m.checkNotNullParameter(selectedCommand, "selectedCommand");
            C12238m.checkNotNullParameter(selectedCommandOptionErrors, "selectedCommandOptionErrors");
            C12238m.checkNotNullParameter(validSelectedCommandOptions, "validSelectedCommandOptions");
            C12238m.checkNotNullParameter(selectedApplication, "selectedApplication");
            return new SelectedCommand(selectedCommand, selectedCommandOption, selectedCommandOptionErrors, validSelectedCommandOptions, selectedApplication);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof SelectedCommand)) {
                return false;
            }
            SelectedCommand selectedCommand = (SelectedCommand) other;
            return C12238m.areEqual(this.selectedCommand, selectedCommand.selectedCommand) && C12238m.areEqual(this.selectedCommandOption, selectedCommand.selectedCommandOption) && C12238m.areEqual(this.selectedCommandOptionErrors, selectedCommand.selectedCommandOptionErrors) && C12238m.areEqual(this.validSelectedCommandOptions, selectedCommand.validSelectedCommandOptions) && C12238m.areEqual(this.selectedApplication, selectedCommand.selectedApplication);
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
            StringBuilder sbM833U = C1643a.m833U("SelectedCommand(selectedCommand=");
            sbM833U.append(this.selectedCommand);
            sbM833U.append(", selectedCommandOption=");
            sbM833U.append(this.selectedCommandOption);
            sbM833U.append(", selectedCommandOptionErrors=");
            sbM833U.append(this.selectedCommandOptionErrors);
            sbM833U.append(", validSelectedCommandOptions=");
            sbM833U.append(this.validSelectedCommandOptions);
            sbM833U.append(", selectedApplication=");
            sbM833U.append(this.selectedApplication);
            sbM833U.append(")");
            return sbM833U.toString();
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SelectedCommand(ApplicationCommand applicationCommand, ApplicationCommandOption applicationCommandOption, Set<ApplicationCommandOption> set, Map<ApplicationCommandOption, Boolean> map, Application application) {
            super(null);
            C12238m.checkNotNullParameter(applicationCommand, "selectedCommand");
            C12238m.checkNotNullParameter(set, "selectedCommandOptionErrors");
            C12238m.checkNotNullParameter(map, "validSelectedCommandOptions");
            C12238m.checkNotNullParameter(application, "selectedApplication");
            this.selectedCommand = applicationCommand;
            this.selectedCommandOption = applicationCommandOption;
            this.selectedCommandOptionErrors = set;
            this.validSelectedCommandOptions = map;
            this.selectedApplication = application;
        }
    }

    public /* synthetic */ SelectedCommandViewState(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
