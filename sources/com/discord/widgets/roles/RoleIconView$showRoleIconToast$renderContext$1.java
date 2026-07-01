package com.discord.widgets.roles;

import android.annotation.SuppressLint;
import android.content.Context;
import com.discord.utilities.textprocessing.node.EmojiNode$EmojiIdAndType;
import com.discord.utilities.textprocessing.node.EmojiNode$RenderContext;
import com.discord.utilities.textprocessing.node.EmojiNode$RenderContext$DefaultImpls;
import d0.z.d.m;

/* JADX INFO: compiled from: RoleIconView.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class RoleIconView$showRoleIconToast$renderContext$1 implements EmojiNode$RenderContext {
    public final /* synthetic */ Context $context;

    @SuppressLint({"StaticFieldLeak"})
    private final Context context;
    private final boolean isAnimationEnabled;

    public RoleIconView$showRoleIconToast$renderContext$1(Context context) {
        this.$context = context;
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
