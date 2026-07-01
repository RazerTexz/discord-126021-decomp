package com.discord.widgets.chat.input.emoji;

import android.view.View;
import com.discord.models.domain.emoji.Emoji;
import com.discord.models.domain.emoji.ModelEmojiCustom;
import com.discord.models.domain.emoji.ModelEmojiUnicode;
import com.discord.utilities.textprocessing.node.EmojiNode;
import com.discord.utilities.textprocessing.node.EmojiNode$EmojiIdAndType;
import com.discord.widgets.emoji.WidgetEmojiSheet;
import d0.k;
import d0.k$a;
import d0.l;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetEmojiAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetEmojiAdapter$EmojiViewHolder$onConfigure$2 extends o implements Function1<View, Unit> {
    public final /* synthetic */ WidgetEmojiAdapter$EmojiItem $emojiItem;
    public final /* synthetic */ WidgetEmojiAdapter$EmojiViewHolder this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetEmojiAdapter$EmojiViewHolder$onConfigure$2(WidgetEmojiAdapter$EmojiViewHolder widgetEmojiAdapter$EmojiViewHolder, WidgetEmojiAdapter$EmojiItem widgetEmojiAdapter$EmojiItem) {
        super(1);
        this.this$0 = widgetEmojiAdapter$EmojiViewHolder;
        this.$emojiItem = widgetEmojiAdapter$EmojiItem;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(View view) {
        invoke2(view);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(View view) {
        Object objM97constructorimpl;
        m.checkNotNullParameter(view, "it");
        try {
            k$a k_a = k.j;
            Emoji emoji = this.$emojiItem.getEmoji();
            if (emoji == null) {
                throw new NullPointerException("null cannot be cast to non-null type com.discord.models.domain.emoji.ModelEmojiCustom");
            }
            objM97constructorimpl = k.m97constructorimpl(EmojiNode.Companion.generateEmojiIdAndType((ModelEmojiCustom) emoji));
            if (k.m99exceptionOrNullimpl(objM97constructorimpl) != null) {
                try {
                    k$a k_a2 = k.j;
                    Emoji emoji2 = this.$emojiItem.getEmoji();
                    if (emoji2 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type com.discord.models.domain.emoji.ModelEmojiUnicode");
                    }
                    objM97constructorimpl = k.m97constructorimpl(EmojiNode.Companion.generateEmojiIdAndType((ModelEmojiUnicode) emoji2));
                } catch (Throwable th) {
                    k$a k_a3 = k.j;
                    objM97constructorimpl = k.m97constructorimpl(l.createFailure(th));
                }
            }
            if (k.m102isSuccessimpl(objM97constructorimpl)) {
                WidgetEmojiAdapter.access$getHideKeyboard$p(WidgetEmojiAdapter$EmojiViewHolder.access$getAdapter$p(this.this$0)).invoke();
                WidgetEmojiSheet.Companion.show(WidgetEmojiAdapter.access$getFragmentManager$p(WidgetEmojiAdapter$EmojiViewHolder.access$getAdapter$p(this.this$0)), (EmojiNode$EmojiIdAndType) objM97constructorimpl);
            }
        } catch (Throwable th2) {
            k$a k_a4 = k.j;
            objM97constructorimpl = k.m97constructorimpl(l.createFailure(th2));
        }
    }
}
