package com.discord.utilities.search.suggestion.entries;

import d0.g0.w;
import d0.g0.y;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: ChannelSuggestion.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ChannelSuggestion$Companion {
    private ChannelSuggestion$Companion() {
    }

    public final boolean canComplete(String channelName, CharSequence currentInput) {
        m.checkNotNullParameter(channelName, "channelName");
        m.checkNotNullParameter(currentInput, "currentInput");
        if ((currentInput.length() > 0) && currentInput.charAt(0) == '#') {
            currentInput = y.drop(currentInput, 1);
        }
        return w.contains((CharSequence) channelName, currentInput, true);
    }

    public /* synthetic */ ChannelSuggestion$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
