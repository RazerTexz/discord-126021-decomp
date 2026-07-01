package com.discord.widgets.chat.input.models;

import b.d.b.a.outline;
import com.discord.models.commands.Application;
import com.discord.models.commands.ApplicationCommand;
import com.discord.models.commands.ApplicationCommandOption;
import com.discord.stores.CommandAutocompleteState;
import com.discord.widgets.chat.input.WidgetChatInputDiscoveryCommandsModel;
import com.discord.widgets.chat.input.autocomplete.Autocompletable;
import com.discord.widgets.chat.input.autocomplete.LeadingIdentifier;
import d0.t.Collections2;
import d0.t.Maps6;
import d0.z.d.Intrinsics3;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.ranges.Ranges2;

/* JADX INFO: compiled from: MentionInputModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public abstract class MentionInputModel {
    private final Map<LeadingIdentifier, Set<Autocompletable>> autocompletables;
    private final CharSequence input;
    private final Map<Ranges2, Autocompletable> inputMentionsMap;

    /* JADX INFO: compiled from: MentionInputModel.kt */
    public static final /* data */ class VerifiedMessageInputModel extends MentionInputModel {
        private final Map<LeadingIdentifier, Set<Autocompletable>> autocompletables;
        private final CharSequence input;
        private final Map<Ranges2, Autocompletable> inputMentionsMap;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public VerifiedMessageInputModel(CharSequence charSequence, Map<LeadingIdentifier, ? extends Set<? extends Autocompletable>> map, Map<Ranges2, ? extends Autocompletable> map2) {
            super(charSequence, map, map2, null);
            Intrinsics3.checkNotNullParameter(charSequence, "input");
            Intrinsics3.checkNotNullParameter(map, "autocompletables");
            Intrinsics3.checkNotNullParameter(map2, "inputMentionsMap");
            this.input = charSequence;
            this.autocompletables = map;
            this.inputMentionsMap = map2;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ VerifiedMessageInputModel copy$default(VerifiedMessageInputModel verifiedMessageInputModel, CharSequence charSequence, Map map, Map map2, int i, Object obj) {
            if ((i & 1) != 0) {
                charSequence = verifiedMessageInputModel.getInput();
            }
            if ((i & 2) != 0) {
                map = verifiedMessageInputModel.getAutocompletables();
            }
            if ((i & 4) != 0) {
                map2 = verifiedMessageInputModel.getInputMentionsMap();
            }
            return verifiedMessageInputModel.copy(charSequence, map, map2);
        }

        public final CharSequence component1() {
            return getInput();
        }

        public final Map<LeadingIdentifier, Set<Autocompletable>> component2() {
            return getAutocompletables();
        }

        public final Map<Ranges2, Autocompletable> component3() {
            return getInputMentionsMap();
        }

        public final VerifiedMessageInputModel copy(CharSequence input, Map<LeadingIdentifier, ? extends Set<? extends Autocompletable>> autocompletables, Map<Ranges2, ? extends Autocompletable> inputMentionsMap) {
            Intrinsics3.checkNotNullParameter(input, "input");
            Intrinsics3.checkNotNullParameter(autocompletables, "autocompletables");
            Intrinsics3.checkNotNullParameter(inputMentionsMap, "inputMentionsMap");
            return new VerifiedMessageInputModel(input, autocompletables, inputMentionsMap);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof VerifiedMessageInputModel)) {
                return false;
            }
            VerifiedMessageInputModel verifiedMessageInputModel = (VerifiedMessageInputModel) other;
            return Intrinsics3.areEqual(getInput(), verifiedMessageInputModel.getInput()) && Intrinsics3.areEqual(getAutocompletables(), verifiedMessageInputModel.getAutocompletables()) && Intrinsics3.areEqual(getInputMentionsMap(), verifiedMessageInputModel.getInputMentionsMap());
        }

        @Override // com.discord.widgets.chat.input.models.MentionInputModel
        public Map<LeadingIdentifier, Set<Autocompletable>> getAutocompletables() {
            return this.autocompletables;
        }

        @Override // com.discord.widgets.chat.input.models.MentionInputModel
        public CharSequence getInput() {
            return this.input;
        }

        @Override // com.discord.widgets.chat.input.models.MentionInputModel
        public Map<Ranges2, Autocompletable> getInputMentionsMap() {
            return this.inputMentionsMap;
        }

        public int hashCode() {
            CharSequence input = getInput();
            int iHashCode = (input != null ? input.hashCode() : 0) * 31;
            Map<LeadingIdentifier, Set<Autocompletable>> autocompletables = getAutocompletables();
            int iHashCode2 = (iHashCode + (autocompletables != null ? autocompletables.hashCode() : 0)) * 31;
            Map<Ranges2, Autocompletable> inputMentionsMap = getInputMentionsMap();
            return iHashCode2 + (inputMentionsMap != null ? inputMentionsMap.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbU = outline.U("VerifiedMessageInputModel(input=");
            sbU.append(getInput());
            sbU.append(", autocompletables=");
            sbU.append(getAutocompletables());
            sbU.append(", inputMentionsMap=");
            sbU.append(getInputMentionsMap());
            sbU.append(")");
            return sbU.toString();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private MentionInputModel(CharSequence charSequence, Map<LeadingIdentifier, ? extends Set<? extends Autocompletable>> map, Map<Ranges2, ? extends Autocompletable> map2) {
        this.input = charSequence;
        this.autocompletables = map;
        this.inputMentionsMap = map2;
    }

    public Map<LeadingIdentifier, Set<Autocompletable>> getAutocompletables() {
        return this.autocompletables;
    }

    public CharSequence getInput() {
        return this.input;
    }

    public Map<Ranges2, Autocompletable> getInputMentionsMap() {
        return this.inputMentionsMap;
    }

    public /* synthetic */ MentionInputModel(CharSequence charSequence, Map map, Map map2, DefaultConstructorMarker defaultConstructorMarker) {
        this(charSequence, map, map2);
    }

    /* JADX INFO: compiled from: MentionInputModel.kt */
    public static final class VerifiedCommandInputModel extends MentionInputModel {
        private final List<Application> applications;
        private final Map<LeadingIdentifier, Set<Autocompletable>> autocompletables;
        private final Map<String, Map<String, CommandAutocompleteState>> commandOptionAutocompleteItems;
        private final AutocompleteApplicationCommands commands;
        private final WidgetChatInputDiscoveryCommandsModel discoveryCommands;
        private final CharSequence input;
        private final InputCommandContext inputCommandContext;
        private final Map<ApplicationCommandOption, Boolean> inputCommandOptionValidity;
        private final Map<ApplicationCommandOption, CommandOptionValue> inputCommandOptionValues;
        private final Map<ApplicationCommandOption, OptionRange> inputCommandOptionsRanges;
        private final Map<Ranges2, Autocompletable> inputMentionsMap;
        private final List<ApplicationCommand> queryCommands;

        public /* synthetic */ VerifiedCommandInputModel(CharSequence charSequence, Map map, Map map2, List list, List list2, WidgetChatInputDiscoveryCommandsModel widgetChatInputDiscoveryCommandsModel, Map map3, InputCommandContext inputCommandContext, AutocompleteApplicationCommands autocompleteApplicationCommands, Map map4, Map map5, Map map6, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(charSequence, map, map2, (i & 8) != 0 ? Collections2.emptyList() : list, (i & 16) != 0 ? Collections2.emptyList() : list2, (i & 32) != 0 ? null : widgetChatInputDiscoveryCommandsModel, (i & 64) != 0 ? Maps6.emptyMap() : map3, inputCommandContext, autocompleteApplicationCommands, (i & 512) != 0 ? Maps6.emptyMap() : map4, (i & 1024) != 0 ? Maps6.emptyMap() : map5, (i & 2048) != 0 ? Maps6.emptyMap() : map6);
        }

        public final List<Application> getApplications() {
            return this.applications;
        }

        @Override // com.discord.widgets.chat.input.models.MentionInputModel
        public Map<LeadingIdentifier, Set<Autocompletable>> getAutocompletables() {
            return this.autocompletables;
        }

        public final Map<String, Map<String, CommandAutocompleteState>> getCommandOptionAutocompleteItems() {
            return this.commandOptionAutocompleteItems;
        }

        public final AutocompleteApplicationCommands getCommands() {
            return this.commands;
        }

        public final WidgetChatInputDiscoveryCommandsModel getDiscoveryCommands() {
            return this.discoveryCommands;
        }

        @Override // com.discord.widgets.chat.input.models.MentionInputModel
        public CharSequence getInput() {
            return this.input;
        }

        public final InputCommandContext getInputCommandContext() {
            return this.inputCommandContext;
        }

        public final Map<ApplicationCommandOption, Boolean> getInputCommandOptionValidity() {
            return this.inputCommandOptionValidity;
        }

        public final Map<ApplicationCommandOption, CommandOptionValue> getInputCommandOptionValues() {
            return this.inputCommandOptionValues;
        }

        public final Map<ApplicationCommandOption, OptionRange> getInputCommandOptionsRanges() {
            return this.inputCommandOptionsRanges;
        }

        @Override // com.discord.widgets.chat.input.models.MentionInputModel
        public Map<Ranges2, Autocompletable> getInputMentionsMap() {
            return this.inputMentionsMap;
        }

        public final List<ApplicationCommand> getQueryCommands() {
            return this.queryCommands;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public VerifiedCommandInputModel(CharSequence charSequence, Map<LeadingIdentifier, ? extends Set<? extends Autocompletable>> map, Map<Ranges2, ? extends Autocompletable> map2, List<Application> list, List<? extends ApplicationCommand> list2, WidgetChatInputDiscoveryCommandsModel widgetChatInputDiscoveryCommandsModel, Map<String, ? extends Map<String, ? extends CommandAutocompleteState>> map3, InputCommandContext inputCommandContext, AutocompleteApplicationCommands autocompleteApplicationCommands, Map<ApplicationCommandOption, ? extends CommandOptionValue> map4, Map<ApplicationCommandOption, OptionRange> map5, Map<ApplicationCommandOption, Boolean> map6) {
            super(charSequence, map, map2, null);
            Intrinsics3.checkNotNullParameter(charSequence, "input");
            Intrinsics3.checkNotNullParameter(map, "autocompletables");
            Intrinsics3.checkNotNullParameter(map2, "inputMentionsMap");
            Intrinsics3.checkNotNullParameter(list, "applications");
            Intrinsics3.checkNotNullParameter(list2, "queryCommands");
            Intrinsics3.checkNotNullParameter(map3, "commandOptionAutocompleteItems");
            Intrinsics3.checkNotNullParameter(inputCommandContext, "inputCommandContext");
            Intrinsics3.checkNotNullParameter(autocompleteApplicationCommands, "commands");
            Intrinsics3.checkNotNullParameter(map4, "inputCommandOptionValues");
            Intrinsics3.checkNotNullParameter(map5, "inputCommandOptionsRanges");
            Intrinsics3.checkNotNullParameter(map6, "inputCommandOptionValidity");
            this.input = charSequence;
            this.autocompletables = map;
            this.inputMentionsMap = map2;
            this.applications = list;
            this.queryCommands = list2;
            this.discoveryCommands = widgetChatInputDiscoveryCommandsModel;
            this.commandOptionAutocompleteItems = map3;
            this.inputCommandContext = inputCommandContext;
            this.commands = autocompleteApplicationCommands;
            this.inputCommandOptionValues = map4;
            this.inputCommandOptionsRanges = map5;
            this.inputCommandOptionValidity = map6;
        }
    }
}
