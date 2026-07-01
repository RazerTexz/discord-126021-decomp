package com.discord.utilities.textprocessing;


/* JADX INFO: compiled from: MessageParseState.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class MessageParseState implements Rules$BlockQuoteState<MessageParseState> {
    public static final MessageParseState$Companion Companion = new MessageParseState$Companion(null);
    private static final MessageParseState initialState = new MessageParseState(false);
    private final boolean isInQuote;

    private MessageParseState(boolean z2) {
        this.isInQuote = z2;
    }

    public static final /* synthetic */ MessageParseState access$getInitialState$cp() {
        return initialState;
    }

    @Override // com.discord.utilities.textprocessing.Rules$BlockQuoteState
    /* JADX INFO: renamed from: isInQuote, reason: from getter */
    public boolean getIsInQuote() {
        return this.isInQuote;
    }

    @Override // com.discord.utilities.textprocessing.Rules$BlockQuoteState
    public /* bridge */ /* synthetic */ Rules$BlockQuoteState newBlockQuoteState(boolean z2) {
        return newBlockQuoteState(z2);
    }

    @Override // com.discord.utilities.textprocessing.Rules$BlockQuoteState
    public MessageParseState newBlockQuoteState(boolean isInQuote) {
        return new MessageParseState(isInQuote);
    }
}
