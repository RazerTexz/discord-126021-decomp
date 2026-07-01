package com.discord.utilities.presence;

import android.content.Context;
import com.discord.utilities.textprocessing.node.EmojiNode$EmojiIdAndType;
import com.discord.utilities.textprocessing.node.EmojiNode$RenderContext;
import com.discord.utilities.textprocessing.node.EmojiNode$RenderContext$DefaultImpls;
import d0.z.d.m;

/* JADX INFO: compiled from: PresenceUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class PresenceUtils$getStatusDraweeSpanStringBuilder$1 implements EmojiNode$RenderContext {
    public final /* synthetic */ boolean $animateCustomStatusEmoji;
    public final /* synthetic */ Context $context;
    private final Context context;
    private final boolean isAnimationEnabled;

    public PresenceUtils$getStatusDraweeSpanStringBuilder$1(Context context, boolean z2) {
        this.$context = context;
        this.$animateCustomStatusEmoji = z2;
        this.context = context;
        this.isAnimationEnabled = z2;
    }

    @Override // com.discord.utilities.textprocessing.node.EmojiNode$RenderContext
    public Context getContext() {
        return this.context;
    }

    @Override // com.discord.utilities.textprocessing.node.EmojiNode$RenderContext
    /* JADX INFO: renamed from: isAnimationEnabled, reason: from getter */
    public boolean getIsAnimationEnabled() {
        return this.isAnimationEnabled;
    }

    @Override // com.discord.utilities.textprocessing.node.EmojiNode$RenderContext
    public void onEmojiClicked(EmojiNode$EmojiIdAndType emojiNode$EmojiIdAndType) {
        m.checkNotNullParameter(emojiNode$EmojiIdAndType, "emojiIdAndType");
        EmojiNode$RenderContext$DefaultImpls.onEmojiClicked(this, emojiNode$EmojiIdAndType);
    }
}
