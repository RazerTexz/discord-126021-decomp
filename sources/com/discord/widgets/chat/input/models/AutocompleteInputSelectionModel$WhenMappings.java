package com.discord.widgets.chat.input.models;

import com.discord.widgets.chat.input.autocomplete.LeadingIdentifier;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class AutocompleteInputSelectionModel$WhenMappings {
    public static final /* synthetic */ int[] $EnumSwitchMapping$0;

    static {
        LeadingIdentifier.values();
        int[] iArr = new int[5];
        $EnumSwitchMapping$0 = iArr;
        iArr[LeadingIdentifier.APP_COMMAND.ordinal()] = 1;
        iArr[LeadingIdentifier.EMOJI_AND_STICKERS.ordinal()] = 2;
        iArr[LeadingIdentifier.CHANNELS.ordinal()] = 3;
        iArr[LeadingIdentifier.MENTION.ordinal()] = 4;
    }
}
