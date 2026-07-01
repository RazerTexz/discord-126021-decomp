package com.discord.stores;

import b.d.b.a.a;
import com.discord.api.commands.ApplicationCommandAutocompleteChoice;
import d0.z.d.m;
import java.util.List;

/* JADX INFO: compiled from: StoreApplicationCommands.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class CommandAutocompleteState$Choices extends CommandAutocompleteState {
    private final List<ApplicationCommandAutocompleteChoice> choices;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CommandAutocompleteState$Choices(List<ApplicationCommandAutocompleteChoice> list) {
        super(null);
        m.checkNotNullParameter(list, "choices");
        this.choices = list;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ CommandAutocompleteState$Choices copy$default(CommandAutocompleteState$Choices commandAutocompleteState$Choices, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            list = commandAutocompleteState$Choices.choices;
        }
        return commandAutocompleteState$Choices.copy(list);
    }

    public final List<ApplicationCommandAutocompleteChoice> component1() {
        return this.choices;
    }

    public final CommandAutocompleteState$Choices copy(List<ApplicationCommandAutocompleteChoice> choices) {
        m.checkNotNullParameter(choices, "choices");
        return new CommandAutocompleteState$Choices(choices);
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof CommandAutocompleteState$Choices) && m.areEqual(this.choices, ((CommandAutocompleteState$Choices) other).choices);
        }
        return true;
    }

    public final List<ApplicationCommandAutocompleteChoice> getChoices() {
        return this.choices;
    }

    public int hashCode() {
        List<ApplicationCommandAutocompleteChoice> list = this.choices;
        if (list != null) {
            return list.hashCode();
        }
        return 0;
    }

    public String toString() {
        return a.L(a.U("Choices(choices="), this.choices, ")");
    }
}
