package com.discord.utilities.textprocessing.node;

import android.content.Context;

/* JADX INFO: compiled from: EmojiNode.kt */
/* JADX INFO: loaded from: classes2.dex */
public interface EmojiNode$RenderContext {
    Context getContext();

    boolean isAnimationEnabled();

    void onEmojiClicked(EmojiNode$EmojiIdAndType emojiIdAndType);
}
