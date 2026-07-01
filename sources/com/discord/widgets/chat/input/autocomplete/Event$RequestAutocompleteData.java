package com.discord.widgets.chat.input.autocomplete;

import b.d.b.a.a;
import com.discord.models.commands.ApplicationCommandOption;
import d0.z.d.m;

/* JADX INFO: compiled from: AutocompleteViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class Event$RequestAutocompleteData extends Event {
    private final ApplicationCommandOption option;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Event$RequestAutocompleteData(ApplicationCommandOption applicationCommandOption) {
        super(null);
        m.checkNotNullParameter(applicationCommandOption, "option");
        this.option = applicationCommandOption;
    }

    public static /* synthetic */ Event$RequestAutocompleteData copy$default(Event$RequestAutocompleteData event$RequestAutocompleteData, ApplicationCommandOption applicationCommandOption, int i, Object obj) {
        if ((i & 1) != 0) {
            applicationCommandOption = event$RequestAutocompleteData.option;
        }
        return event$RequestAutocompleteData.copy(applicationCommandOption);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final ApplicationCommandOption getOption() {
        return this.option;
    }

    public final Event$RequestAutocompleteData copy(ApplicationCommandOption option) {
        m.checkNotNullParameter(option, "option");
        return new Event$RequestAutocompleteData(option);
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof Event$RequestAutocompleteData) && m.areEqual(this.option, ((Event$RequestAutocompleteData) other).option);
        }
        return true;
    }

    public final ApplicationCommandOption getOption() {
        return this.option;
    }

    public int hashCode() {
        ApplicationCommandOption applicationCommandOption = this.option;
        if (applicationCommandOption != null) {
            return applicationCommandOption.hashCode();
        }
        return 0;
    }

    public String toString() {
        StringBuilder sbU = a.U("RequestAutocompleteData(option=");
        sbU.append(this.option);
        sbU.append(")");
        return sbU.toString();
    }
}
