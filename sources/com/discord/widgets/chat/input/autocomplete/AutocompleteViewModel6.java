package com.discord.widgets.chat.input.autocomplete;

import b.d.b.a.outline;
import com.discord.models.commands.Application;
import com.discord.models.commands.ApplicationCommand;
import com.discord.models.commands.ApplicationCommandOption;
import d0.t.Maps6;
import d0.t.Sets5;
import d0.z.d.Intrinsics3;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: renamed from: com.discord.widgets.chat.input.autocomplete.SelectedCommandViewState, reason: use source file name */
/* JADX INFO: compiled from: AutocompleteViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public abstract class AutocompleteViewModel6 {

    /* JADX INFO: renamed from: com.discord.widgets.chat.input.autocomplete.SelectedCommandViewState$Hidden */
    /* JADX INFO: compiled from: AutocompleteViewModel.kt */
    public static final class Hidden extends AutocompleteViewModel6 {
        public static final Hidden INSTANCE = new Hidden();

        private Hidden() {
            super(null);
        }
    }

    private AutocompleteViewModel6() {
    }

    /* JADX INFO: renamed from: com.discord.widgets.chat.input.autocomplete.SelectedCommandViewState$SelectedCommand */
    /* JADX INFO: compiled from: AutocompleteViewModel.kt */
    public static final /* data */ class SelectedCommand extends AutocompleteViewModel6 {
        private final Application selectedApplication;
        private final ApplicationCommand selectedCommand;
        private final ApplicationCommandOption selectedCommandOption;
        private final Set<ApplicationCommandOption> selectedCommandOptionErrors;
        private final Map<ApplicationCommandOption, Boolean> validSelectedCommandOptions;

        public /* synthetic */ SelectedCommand(ApplicationCommand applicationCommand, ApplicationCommandOption applicationCommandOption, Set set, Map map, Application application, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(applicationCommand, applicationCommandOption, (i & 4) != 0 ? Sets5.emptySet() : set, (i & 8) != 0 ? Maps6.emptyMap() : map, application);
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
            Intrinsics3.checkNotNullParameter(selectedCommand, "selectedCommand");
            Intrinsics3.checkNotNullParameter(selectedCommandOptionErrors, "selectedCommandOptionErrors");
            Intrinsics3.checkNotNullParameter(validSelectedCommandOptions, "validSelectedCommandOptions");
            Intrinsics3.checkNotNullParameter(selectedApplication, "selectedApplication");
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
            return Intrinsics3.areEqual(this.selectedCommand, selectedCommand.selectedCommand) && Intrinsics3.areEqual(this.selectedCommandOption, selectedCommand.selectedCommandOption) && Intrinsics3.areEqual(this.selectedCommandOptionErrors, selectedCommand.selectedCommandOptionErrors) && Intrinsics3.areEqual(this.validSelectedCommandOptions, selectedCommand.validSelectedCommandOptions) && Intrinsics3.areEqual(this.selectedApplication, selectedCommand.selectedApplication);
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
            StringBuilder sbU = outline.U("SelectedCommand(selectedCommand=");
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
        public SelectedCommand(ApplicationCommand applicationCommand, ApplicationCommandOption applicationCommandOption, Set<ApplicationCommandOption> set, Map<ApplicationCommandOption, Boolean> map, Application application) {
            super(null);
            Intrinsics3.checkNotNullParameter(applicationCommand, "selectedCommand");
            Intrinsics3.checkNotNullParameter(set, "selectedCommandOptionErrors");
            Intrinsics3.checkNotNullParameter(map, "validSelectedCommandOptions");
            Intrinsics3.checkNotNullParameter(application, "selectedApplication");
            this.selectedCommand = applicationCommand;
            this.selectedCommandOption = applicationCommandOption;
            this.selectedCommandOptionErrors = set;
            this.validSelectedCommandOptions = map;
            this.selectedApplication = application;
        }
    }

    public /* synthetic */ AutocompleteViewModel6(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
