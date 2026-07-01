package com.discord.utilities.textprocessing.node;

import android.view.View;
import androidx.exifinterface.media.ExifInterface;
import com.discord.utilities.textprocessing.node.EmojiNode;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: renamed from: com.discord.utilities.textprocessing.node.EmojiNode$render$clickableSpan$1, reason: use source file name */
/* JADX INFO: compiled from: EmojiNode.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class EmojiNode5 extends Lambda implements Function1<View, Unit> {
    public final /* synthetic */ EmojiNode.RenderContext $renderContext;
    public final /* synthetic */ EmojiNode this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EmojiNode5(EmojiNode emojiNode, EmojiNode.RenderContext renderContext) {
        super(1);
        this.this$0 = emojiNode;
        this.$renderContext = renderContext;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(View view) {
        invoke2(view);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(View view) {
        Intrinsics3.checkNotNullParameter(view, "it");
        this.$renderContext.onEmojiClicked(this.this$0.emojiIdAndType);
    }
}
