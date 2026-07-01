package com.discord.widgets.chat.input.autocomplete;

import com.discord.models.domain.emoji.Emoji;
import d0.t.Collections2;
import d0.z.d.Intrinsics3;
import java.util.List;

/* JADX INFO: compiled from: Autocompletable.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class EmojiUpsellPlaceholder extends Autocompletable {
    public static final int EMOJI_PREVIEW_COUNT = 3;
    private final boolean allowEmojiToAnimate;
    private final List<Emoji> lockedFirstThree;
    private final int lockedTotal;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public EmojiUpsellPlaceholder(int i, List<? extends Emoji> list, boolean z2) {
        super(null);
        Intrinsics3.checkNotNullParameter(list, "lockedFirstThree");
        this.lockedTotal = i;
        this.lockedFirstThree = list;
        this.allowEmojiToAnimate = z2;
    }

    public final boolean getAllowEmojiToAnimate() {
        return this.allowEmojiToAnimate;
    }

    @Override // com.discord.widgets.chat.input.autocomplete.Autocompletable
    public String getInputReplacement() {
        return "";
    }

    @Override // com.discord.widgets.chat.input.autocomplete.Autocompletable
    public List<String> getInputTextMatchers() {
        return Collections2.emptyList();
    }

    public final List<Emoji> getLockedFirstThree() {
        return this.lockedFirstThree;
    }

    public final int getLockedTotal() {
        return this.lockedTotal;
    }
}
