package com.discord.widgets.chat.input.models;

import com.discord.models.commands.Application;
import com.discord.models.commands.ApplicationCommand;
import com.discord.models.commands.ApplicationCommandOption;
import com.discord.stores.CommandAutocompleteState;
import com.discord.widgets.chat.input.WidgetChatInputDiscoveryCommandsModel;
import com.discord.widgets.chat.input.autocomplete.Autocompletable;
import com.discord.widgets.chat.input.autocomplete.LeadingIdentifier;
import d0.t.h0;
import d0.t.n;
import d0.z.d.m;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.ranges.IntRange;

/* JADX INFO: compiled from: MentionInputModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class MentionInputModel$VerifiedCommandInputModel extends MentionInputModel {
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
    private final Map<IntRange, Autocompletable> inputMentionsMap;
    private final List<ApplicationCommand> queryCommands;

    public /* synthetic */ MentionInputModel$VerifiedCommandInputModel(CharSequence charSequence, Map map, Map map2, List list, List list2, WidgetChatInputDiscoveryCommandsModel widgetChatInputDiscoveryCommandsModel, Map map3, InputCommandContext inputCommandContext, AutocompleteApplicationCommands autocompleteApplicationCommands, Map map4, Map map5, Map map6, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(charSequence, map, map2, (i & 8) != 0 ? n.emptyList() : list, (i & 16) != 0 ? n.emptyList() : list2, (i & 32) != 0 ? null : widgetChatInputDiscoveryCommandsModel, (i & 64) != 0 ? h0.emptyMap() : map3, inputCommandContext, autocompleteApplicationCommands, (i & 512) != 0 ? h0.emptyMap() : map4, (i & 1024) != 0 ? h0.emptyMap() : map5, (i & 2048) != 0 ? h0.emptyMap() : map6);
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
    public Map<IntRange, Autocompletable> getInputMentionsMap() {
        return this.inputMentionsMap;
    }

    public final List<ApplicationCommand> getQueryCommands() {
        return this.queryCommands;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public MentionInputModel$VerifiedCommandInputModel(CharSequence charSequence, Map<LeadingIdentifier, ? extends Set<? extends Autocompletable>> map, Map<IntRange, ? extends Autocompletable> map2, List<Application> list, List<? extends ApplicationCommand> list2, WidgetChatInputDiscoveryCommandsModel widgetChatInputDiscoveryCommandsModel, Map<String, ? extends Map<String, ? extends CommandAutocompleteState>> map3, InputCommandContext inputCommandContext, AutocompleteApplicationCommands autocompleteApplicationCommands, Map<ApplicationCommandOption, ? extends CommandOptionValue> map4, Map<ApplicationCommandOption, OptionRange> map5, Map<ApplicationCommandOption, Boolean> map6) {
        super(charSequence, map, map2, null);
        m.checkNotNullParameter(charSequence, "input");
        m.checkNotNullParameter(map, "autocompletables");
        m.checkNotNullParameter(map2, "inputMentionsMap");
        m.checkNotNullParameter(list, "applications");
        m.checkNotNullParameter(list2, "queryCommands");
        m.checkNotNullParameter(map3, "commandOptionAutocompleteItems");
        m.checkNotNullParameter(inputCommandContext, "inputCommandContext");
        m.checkNotNullParameter(autocompleteApplicationCommands, "commands");
        m.checkNotNullParameter(map4, "inputCommandOptionValues");
        m.checkNotNullParameter(map5, "inputCommandOptionsRanges");
        m.checkNotNullParameter(map6, "inputCommandOptionValidity");
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
