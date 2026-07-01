package com.discord.widgets.chat.input.autocomplete;

import com.discord.widgets.chat.AutocompleteSelectionTypes;
import com.discord.widgets.chat.AutocompleteTypes;
import com.discord.widgets.chat.input.MentionUtilsKt;

/* JADX INFO: compiled from: Autocompletable.kt */
/* JADX INFO: loaded from: classes2.dex */
public enum LeadingIdentifier {
    APP_COMMAND(Character.valueOf(MentionUtilsKt.SLASH_CHAR)),
    EMOJI_AND_STICKERS(Character.valueOf(MentionUtilsKt.EMOJIS_AND_STICKERS_CHAR)),
    CHANNELS(Character.valueOf(MentionUtilsKt.CHANNELS_CHAR)),
    MENTION(Character.valueOf(MentionUtilsKt.MENTIONS_CHAR)),
    NONE(null);

    public static final LeadingIdentifier$Companion Companion = new LeadingIdentifier$Companion(null);
    private final Character identifier;

    LeadingIdentifier(Character ch) {
        this.identifier = ch;
    }

    public final Character getIdentifier() {
        return this.identifier;
    }
}
