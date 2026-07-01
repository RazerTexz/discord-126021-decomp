package com.discord.api.commands;

import com.discord.widgets.chat.AutocompleteUtils;
import kotlin.jvm.internal.DefaultConstructorMarker;

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


    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final int type;

    /* JADX INFO: compiled from: ApplicationCommandType.kt */
    public static final class Companion {
        public Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
        }
    }

    ApplicationCommandType(int i) {
        this.type = i;
    }

    public final int getType() {
        return this.type;
    }
}
