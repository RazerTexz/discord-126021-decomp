package com.discord.widgets.chat.input.autocomplete;

import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: Autocompletable.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class LeadingIdentifier$Companion {
    private LeadingIdentifier$Companion() {
    }

    public final LeadingIdentifier fromChar(Character identifier) {
        if (identifier != null && identifier.charValue() == '/') {
            return LeadingIdentifier.APP_COMMAND;
        }
        if (identifier != null && identifier.charValue() == ':') {
            return LeadingIdentifier.EMOJI_AND_STICKERS;
        }
        if (identifier != null && identifier.charValue() == '#') {
            return LeadingIdentifier.CHANNELS;
        }
        return (identifier != null && identifier.charValue() == '@') ? LeadingIdentifier.MENTION : LeadingIdentifier.NONE;
    }

    public /* synthetic */ LeadingIdentifier$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
