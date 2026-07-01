package com.discord.widgets.chat.input.autocomplete.commands;

import com.discord.api.commands.ApplicationCommandType;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class AutocompleteCommandUtils$WhenMappings {
    public static final /* synthetic */ int[] $EnumSwitchMapping$0;
    public static final /* synthetic */ int[] $EnumSwitchMapping$1;
    public static final /* synthetic */ int[] $EnumSwitchMapping$2;

    static {
        ApplicationCommandType.values();
        int[] iArr = new int[12];
        $EnumSwitchMapping$0 = iArr;
        ApplicationCommandType applicationCommandType = ApplicationCommandType.USER;
        iArr[applicationCommandType.ordinal()] = 1;
        ApplicationCommandType applicationCommandType2 = ApplicationCommandType.CHANNEL;
        iArr[applicationCommandType2.ordinal()] = 2;
        ApplicationCommandType applicationCommandType3 = ApplicationCommandType.ROLE;
        iArr[applicationCommandType3.ordinal()] = 3;
        ApplicationCommandType applicationCommandType4 = ApplicationCommandType.MENTIONABLE;
        iArr[applicationCommandType4.ordinal()] = 4;
        ApplicationCommandType.values();
        int[] iArr2 = new int[12];
        $EnumSwitchMapping$1 = iArr2;
        iArr2[ApplicationCommandType.SUBCOMMAND.ordinal()] = 1;
        iArr2[ApplicationCommandType.SUBCOMMAND_GROUP.ordinal()] = 2;
        ApplicationCommandType applicationCommandType5 = ApplicationCommandType.STRING;
        iArr2[applicationCommandType5.ordinal()] = 3;
        ApplicationCommandType applicationCommandType6 = ApplicationCommandType.INTEGER;
        iArr2[applicationCommandType6.ordinal()] = 4;
        ApplicationCommandType applicationCommandType7 = ApplicationCommandType.NUMBER;
        iArr2[applicationCommandType7.ordinal()] = 5;
        ApplicationCommandType applicationCommandType8 = ApplicationCommandType.BOOLEAN;
        iArr2[applicationCommandType8.ordinal()] = 6;
        iArr2[applicationCommandType.ordinal()] = 7;
        iArr2[applicationCommandType2.ordinal()] = 8;
        iArr2[applicationCommandType3.ordinal()] = 9;
        iArr2[applicationCommandType4.ordinal()] = 10;
        iArr2[ApplicationCommandType.UNKNOWN.ordinal()] = 11;
        ApplicationCommandType applicationCommandType9 = ApplicationCommandType.ATTACHMENT;
        iArr2[applicationCommandType9.ordinal()] = 12;
        ApplicationCommandType.values();
        int[] iArr3 = new int[12];
        $EnumSwitchMapping$2 = iArr3;
        iArr3[applicationCommandType5.ordinal()] = 1;
        iArr3[applicationCommandType6.ordinal()] = 2;
        iArr3[applicationCommandType7.ordinal()] = 3;
        iArr3[applicationCommandType8.ordinal()] = 4;
        iArr3[applicationCommandType.ordinal()] = 5;
        iArr3[applicationCommandType2.ordinal()] = 6;
        iArr3[applicationCommandType3.ordinal()] = 7;
        iArr3[applicationCommandType4.ordinal()] = 8;
        iArr3[applicationCommandType9.ordinal()] = 9;
    }
}
