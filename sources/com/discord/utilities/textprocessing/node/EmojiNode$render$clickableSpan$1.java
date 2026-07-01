package com.discord.utilities.textprocessing.node;

import android.view.View;
import androidx.exifinterface.media.ExifInterface;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: EmojiNode.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class EmojiNode$render$clickableSpan$1 extends o implements Function1<View, Unit> {
    public final /* synthetic */ EmojiNode$RenderContext $renderContext;
    public final /* synthetic */ EmojiNode this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EmojiNode$render$clickableSpan$1(EmojiNode emojiNode, EmojiNode$RenderContext emojiNode$RenderContext) {
        super(1);
        this.this$0 = emojiNode;
        this.$renderContext = emojiNode$RenderContext;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(View view) {
        invoke2(view);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(View view) {
        m.checkNotNullParameter(view, "it");
        this.$renderContext.onEmojiClicked(EmojiNode.access$getEmojiIdAndType$p(this.this$0));
    }
}
