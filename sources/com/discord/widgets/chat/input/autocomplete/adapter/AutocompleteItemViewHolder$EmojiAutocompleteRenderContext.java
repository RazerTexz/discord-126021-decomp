package com.discord.widgets.chat.input.autocomplete.adapter;

import android.content.Context;
import com.discord.utilities.textprocessing.node.EmojiNode$EmojiIdAndType;
import com.discord.utilities.textprocessing.node.EmojiNode$RenderContext;
import com.discord.utilities.textprocessing.node.EmojiNode$RenderContext$DefaultImpls;
import d0.z.d.m;

/* JADX INFO: compiled from: AutocompleteItemViewHolder.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class AutocompleteItemViewHolder$EmojiAutocompleteRenderContext implements EmojiNode$RenderContext {
    private final Context context;
    private final boolean isAnimationEnabled;
    public final /* synthetic */ AutocompleteItemViewHolder this$0;

    public AutocompleteItemViewHolder$EmojiAutocompleteRenderContext(AutocompleteItemViewHolder autocompleteItemViewHolder, boolean z2, Context context) {
        m.checkNotNullParameter(context, "context");
        this.this$0 = autocompleteItemViewHolder;
        this.isAnimationEnabled = z2;
        this.context = context;
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
