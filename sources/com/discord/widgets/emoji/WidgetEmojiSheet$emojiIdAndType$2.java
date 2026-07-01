package com.discord.widgets.emoji;

import com.discord.utilities.textprocessing.node.EmojiNode$EmojiIdAndType;
import d0.z.d.o;
import java.io.Serializable;
import java.util.Objects;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: WidgetEmojiSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetEmojiSheet$emojiIdAndType$2 extends o implements Function0<EmojiNode$EmojiIdAndType> {
    public final /* synthetic */ WidgetEmojiSheet this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetEmojiSheet$emojiIdAndType$2(WidgetEmojiSheet widgetEmojiSheet) {
        super(0);
        this.this$0 = widgetEmojiSheet;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ EmojiNode$EmojiIdAndType invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final EmojiNode$EmojiIdAndType invoke() {
        Serializable serializable = WidgetEmojiSheet.access$getArgumentsOrDefault$p(this.this$0).getSerializable("EXTRA_EMOJI_ID_AND_TYPE");
        Objects.requireNonNull(serializable, "null cannot be cast to non-null type com.discord.utilities.textprocessing.node.EmojiNode.EmojiIdAndType");
        return (EmojiNode$EmojiIdAndType) serializable;
    }
}
