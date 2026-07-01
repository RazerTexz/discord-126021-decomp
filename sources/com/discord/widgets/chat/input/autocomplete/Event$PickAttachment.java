package com.discord.widgets.chat.input.autocomplete;

import b.d.b.a.a;
import com.discord.models.commands.ApplicationCommandOption;
import d0.z.d.m;

/* JADX INFO: compiled from: AutocompleteViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class Event$PickAttachment extends Event {
    private final ApplicationCommandOption commandOption;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Event$PickAttachment(ApplicationCommandOption applicationCommandOption) {
        super(null);
        m.checkNotNullParameter(applicationCommandOption, "commandOption");
        this.commandOption = applicationCommandOption;
    }

    public static /* synthetic */ Event$PickAttachment copy$default(Event$PickAttachment event$PickAttachment, ApplicationCommandOption applicationCommandOption, int i, Object obj) {
        if ((i & 1) != 0) {
            applicationCommandOption = event$PickAttachment.commandOption;
        }
        return event$PickAttachment.copy(applicationCommandOption);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final ApplicationCommandOption getCommandOption() {
        return this.commandOption;
    }

    public final Event$PickAttachment copy(ApplicationCommandOption commandOption) {
        m.checkNotNullParameter(commandOption, "commandOption");
        return new Event$PickAttachment(commandOption);
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof Event$PickAttachment) && m.areEqual(this.commandOption, ((Event$PickAttachment) other).commandOption);
        }
        return true;
    }

    public final ApplicationCommandOption getCommandOption() {
        return this.commandOption;
    }

    public int hashCode() {
        ApplicationCommandOption applicationCommandOption = this.commandOption;
        if (applicationCommandOption != null) {
            return applicationCommandOption.hashCode();
        }
        return 0;
    }

    public String toString() {
        StringBuilder sbU = a.U("PickAttachment(commandOption=");
        sbU.append(this.commandOption);
        sbU.append(")");
        return sbU.toString();
    }
}
