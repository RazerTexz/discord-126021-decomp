package com.discord.stores;

import b.d.b.a.a;
import d0.z.d.m;

/* JADX INFO: compiled from: StoreApplicationCommands.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class CommandOptionAutocompleteQuery {
    private final String commandOptionName;
    private final String queryString;

    public CommandOptionAutocompleteQuery(String str, String str2) {
        m.checkNotNullParameter(str, "queryString");
        m.checkNotNullParameter(str2, "commandOptionName");
        this.queryString = str;
        this.commandOptionName = str2;
    }

    public static /* synthetic */ CommandOptionAutocompleteQuery copy$default(CommandOptionAutocompleteQuery commandOptionAutocompleteQuery, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = commandOptionAutocompleteQuery.queryString;
        }
        if ((i & 2) != 0) {
            str2 = commandOptionAutocompleteQuery.commandOptionName;
        }
        return commandOptionAutocompleteQuery.copy(str, str2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getQueryString() {
        return this.queryString;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getCommandOptionName() {
        return this.commandOptionName;
    }

    public final CommandOptionAutocompleteQuery copy(String queryString, String commandOptionName) {
        m.checkNotNullParameter(queryString, "queryString");
        m.checkNotNullParameter(commandOptionName, "commandOptionName");
        return new CommandOptionAutocompleteQuery(queryString, commandOptionName);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CommandOptionAutocompleteQuery)) {
            return false;
        }
        CommandOptionAutocompleteQuery commandOptionAutocompleteQuery = (CommandOptionAutocompleteQuery) other;
        return m.areEqual(this.queryString, commandOptionAutocompleteQuery.queryString) && m.areEqual(this.commandOptionName, commandOptionAutocompleteQuery.commandOptionName);
    }

    public final String getCommandOptionName() {
        return this.commandOptionName;
    }

    public final String getQueryString() {
        return this.queryString;
    }

    public int hashCode() {
        String str = this.queryString;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.commandOptionName;
        return iHashCode + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("CommandOptionAutocompleteQuery(queryString=");
        sbU.append(this.queryString);
        sbU.append(", commandOptionName=");
        return a.J(sbU, this.commandOptionName, ")");
    }
}
