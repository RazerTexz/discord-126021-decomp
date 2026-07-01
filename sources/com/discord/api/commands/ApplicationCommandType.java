package com.discord.api.commands;

import com.discord.widgets.chat.AutocompleteSelectionTypes;

/* JADX INFO: compiled from: ApplicationCommandType.kt */
/* JADX INFO: loaded from: classes.dex */
public enum ApplicationCommandType {
    SUBCOMMAND(1),
    SUBCOMMAND_GROUP(2),
    STRING(3),
    INTEGER(4),
    BOOLEAN(5),
    USER(6),
    CHANNEL(7),
    ROLE(8),
    MENTIONABLE(9),
    NUMBER(10),
    ATTACHMENT(11),
    UNKNOWN(0);

    public static final ApplicationCommandType$Companion Companion = new ApplicationCommandType$Companion(null);
    private final int type;

    ApplicationCommandType(int i) {
        this.type = i;
    }

    public final int getType() {
        return this.type;
    }
}
