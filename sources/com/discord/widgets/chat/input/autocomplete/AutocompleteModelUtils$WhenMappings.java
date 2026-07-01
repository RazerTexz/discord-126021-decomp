package com.discord.widgets.chat.input.autocomplete;

import com.discord.api.commands.ApplicationCommandType;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class AutocompleteModelUtils$WhenMappings {
    public static final /* synthetic */ int[] $EnumSwitchMapping$0;

    static {
        ApplicationCommandType.values();
        int[] iArr = new int[12];
        $EnumSwitchMapping$0 = iArr;
        iArr[ApplicationCommandType.CHANNEL.ordinal()] = 1;
        iArr[ApplicationCommandType.USER.ordinal()] = 2;
        iArr[ApplicationCommandType.ROLE.ordinal()] = 3;
        iArr[ApplicationCommandType.MENTIONABLE.ordinal()] = 4;
        iArr[ApplicationCommandType.BOOLEAN.ordinal()] = 5;
    }
}
