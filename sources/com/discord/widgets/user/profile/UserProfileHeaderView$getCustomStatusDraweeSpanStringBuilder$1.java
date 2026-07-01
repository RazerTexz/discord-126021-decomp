package com.discord.widgets.user.profile;

import android.content.Context;
import com.discord.utilities.textprocessing.node.EmojiNode$EmojiIdAndType;
import com.discord.utilities.textprocessing.node.EmojiNode$RenderContext;
import com.discord.utilities.textprocessing.node.EmojiNode$RenderContext$DefaultImpls;
import d0.z.d.m;

/* JADX INFO: compiled from: UserProfileHeaderView.kt */
/* JADX INFO: loaded from: classes.dex */
public final class UserProfileHeaderView$getCustomStatusDraweeSpanStringBuilder$1 implements EmojiNode$RenderContext {
    public final /* synthetic */ boolean $shouldAnimate;
    private final Context context;
    private final boolean isAnimationEnabled;
    public final /* synthetic */ UserProfileHeaderView this$0;

    public UserProfileHeaderView$getCustomStatusDraweeSpanStringBuilder$1(UserProfileHeaderView userProfileHeaderView, boolean z2) {
        this.this$0 = userProfileHeaderView;
        this.$shouldAnimate = z2;
        this.context = userProfileHeaderView.getContext();
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
