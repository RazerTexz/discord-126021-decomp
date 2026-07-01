package com.discord.widgets.chat.input.emoji;

import android.view.View;
import com.discord.models.domain.emoji.Emoji;
import com.discord.models.domain.emoji.ModelEmojiCustom;
import com.discord.models.domain.emoji.ModelEmojiUnicode;
import com.discord.utilities.textprocessing.node.EmojiNode;
import com.discord.widgets.chat.input.emoji.WidgetEmojiAdapter;
import com.discord.widgets.emoji.WidgetEmojiSheet;
import d0.Result2;
import d0.Result3;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: renamed from: com.discord.widgets.chat.input.emoji.WidgetEmojiAdapter$EmojiViewHolder$onConfigure$2, reason: use source file name */
/* JADX INFO: compiled from: WidgetEmojiAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetEmojiAdapter3 extends Lambda implements Function1<View, Unit> {
    public final /* synthetic */ WidgetEmojiAdapter.EmojiItem $emojiItem;
    public final /* synthetic */ WidgetEmojiAdapter.EmojiViewHolder this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetEmojiAdapter3(WidgetEmojiAdapter.EmojiViewHolder emojiViewHolder, WidgetEmojiAdapter.EmojiItem emojiItem) {
        super(1);
        this.this$0 = emojiViewHolder;
        this.$emojiItem = emojiItem;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(View view) {
        invoke2(view);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(View view) {
        Object objM97constructorimpl;
        Intrinsics3.checkNotNullParameter(view, "it");
        try {
            Result2.a aVar = Result2.j;
            Emoji emoji = this.$emojiItem.getEmoji();
            if (emoji == null) {
                throw new NullPointerException("null cannot be cast to non-null type com.discord.models.domain.emoji.ModelEmojiCustom");
            }
            objM97constructorimpl = Result2.m97constructorimpl(EmojiNode.INSTANCE.generateEmojiIdAndType((ModelEmojiCustom) emoji));
            if (Result2.m99exceptionOrNullimpl(objM97constructorimpl) != null) {
                try {
                    Result2.a aVar2 = Result2.j;
                    Emoji emoji2 = this.$emojiItem.getEmoji();
                    if (emoji2 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type com.discord.models.domain.emoji.ModelEmojiUnicode");
                    }
                    objM97constructorimpl = Result2.m97constructorimpl(EmojiNode.INSTANCE.generateEmojiIdAndType((ModelEmojiUnicode) emoji2));
                } catch (Throwable th) {
                    Result2.a aVar3 = Result2.j;
                    objM97constructorimpl = Result2.m97constructorimpl(Result3.createFailure(th));
                }
            }
            if (Result2.m102isSuccessimpl(objM97constructorimpl)) {
                WidgetEmojiAdapter.EmojiViewHolder.access$getAdapter$p(this.this$0).hideKeyboard.invoke();
                WidgetEmojiSheet.INSTANCE.show(WidgetEmojiAdapter.EmojiViewHolder.access$getAdapter$p(this.this$0).fragmentManager, (EmojiNode.EmojiIdAndType) objM97constructorimpl);
            }
        } catch (Throwable th2) {
            Result2.a aVar4 = Result2.j;
            objM97constructorimpl = Result2.m97constructorimpl(Result3.createFailure(th2));
        }
    }
}
