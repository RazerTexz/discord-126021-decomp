package com.discord.utilities.textprocessing;

import com.discord.utilities.textprocessing.Rules;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: MessageParseState.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class MessageParseState implements Rules.BlockQuoteState<MessageParseState> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final MessageParseState initialState = new MessageParseState(false);
    private final boolean isInQuote;

    /* JADX INFO: compiled from: MessageParseState.kt */
    public static final class Companion {
        private Companion() {
        }

        public final MessageParseState getInitialState() {
            return MessageParseState.initialState;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    private MessageParseState(boolean z2) {
        this.isInQuote = z2;
    }

    @Override // com.discord.utilities.textprocessing.Rules.BlockQuoteState
    /* JADX INFO: renamed from: isInQuote, reason: from getter */
    public boolean getIsInQuote() {
        return this.isInQuote;
    }

    @Override // com.discord.utilities.textprocessing.Rules.BlockQuoteState
    public MessageParseState newBlockQuoteState(boolean isInQuote) {
        return new MessageParseState(isInQuote);
    }
}
