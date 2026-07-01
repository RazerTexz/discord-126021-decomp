package com.discord.utilities.textprocessing;

import com.discord.utilities.textprocessing.Rules$BlockQuoteState;

/* JADX INFO: compiled from: Rules.kt */
/* JADX INFO: loaded from: classes2.dex */
public interface Rules$BlockQuoteState<Self extends Rules$BlockQuoteState<Self>> {
    boolean isInQuote();

    Self newBlockQuoteState(boolean isInQuote);
}
