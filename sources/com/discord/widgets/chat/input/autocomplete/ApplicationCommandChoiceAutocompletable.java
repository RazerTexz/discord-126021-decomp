package com.discord.widgets.chat.input.autocomplete;

import com.discord.api.commands.CommandChoice;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p580t.C12145m;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: Autocompletable.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class ApplicationCommandChoiceAutocompletable extends Autocompletable {
    private final CommandChoice choice;
    private final String optionName;
    private final List<String> textMatchers;

    public /* synthetic */ ApplicationCommandChoiceAutocompletable(CommandChoice commandChoice, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(commandChoice, (i & 2) != 0 ? null : str);
    }

    public static /* synthetic */ ApplicationCommandChoiceAutocompletable copy$default(ApplicationCommandChoiceAutocompletable applicationCommandChoiceAutocompletable, CommandChoice commandChoice, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            commandChoice = applicationCommandChoiceAutocompletable.choice;
        }
        if ((i & 2) != 0) {
            str = applicationCommandChoiceAutocompletable.optionName;
        }
        return applicationCommandChoiceAutocompletable.copy(commandChoice, str);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final CommandChoice getChoice() {
        return this.choice;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getOptionName() {
        return this.optionName;
    }

    public final ApplicationCommandChoiceAutocompletable copy(CommandChoice choice, String optionName) {
        C12238m.checkNotNullParameter(choice, "choice");
        return new ApplicationCommandChoiceAutocompletable(choice, optionName);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ApplicationCommandChoiceAutocompletable)) {
            return false;
        }
        ApplicationCommandChoiceAutocompletable applicationCommandChoiceAutocompletable = (ApplicationCommandChoiceAutocompletable) other;
        return C12238m.areEqual(this.choice, applicationCommandChoiceAutocompletable.choice) && C12238m.areEqual(this.optionName, applicationCommandChoiceAutocompletable.optionName);
    }

    public final CommandChoice getChoice() {
        return this.choice;
    }

    @Override // com.discord.widgets.chat.input.autocomplete.Autocompletable
    public String getInputReplacement() {
        return this.choice.getValue();
    }

    @Override // com.discord.widgets.chat.input.autocomplete.Autocompletable
    public List<String> getInputTextMatchers() {
        return this.textMatchers;
    }

    public final String getOptionName() {
        return this.optionName;
    }

    public final List<String> getTextMatchers() {
        return this.textMatchers;
    }

    public int hashCode() {
        CommandChoice commandChoice = this.choice;
        int iHashCode = (commandChoice != null ? commandChoice.hashCode() : 0) * 31;
        String str = this.optionName;
        return iHashCode + (str != null ? str.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("ApplicationCommandChoiceAutocompletable(choice=");
        sbM833U.append(this.choice);
        sbM833U.append(", optionName=");
        return C1643a.m822J(sbM833U, this.optionName, ")");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ApplicationCommandChoiceAutocompletable(CommandChoice commandChoice, String str) {
        super(null);
        C12238m.checkNotNullParameter(commandChoice, "choice");
        this.choice = commandChoice;
        this.optionName = str;
        this.textMatchers = C12145m.listOf(commandChoice.getName());
    }
}
