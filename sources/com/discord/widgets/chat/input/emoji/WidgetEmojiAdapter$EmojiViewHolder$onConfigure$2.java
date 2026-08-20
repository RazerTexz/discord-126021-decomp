package com.discord.widgets.chat.input.emoji;

import android.view.View;
import com.discord.models.domain.emoji.Emoji;
import com.discord.models.domain.emoji.ModelEmojiCustom;
import com.discord.models.domain.emoji.ModelEmojiUnicode;
import com.discord.utilities.textprocessing.node.EmojiNode;
import com.discord.widgets.emoji.WidgetEmojiSheet;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import p507d0.C12112k;
import p507d0.C12113l;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: WidgetEmojiAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetEmojiAdapter$EmojiViewHolder$onConfigure$2 extends AbstractC12240o implements Function1<View, Unit> {
    public final /* synthetic */ WidgetEmojiAdapter.EmojiItem $emojiItem;
    public final /* synthetic */ WidgetEmojiAdapter.EmojiViewHolder this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetEmojiAdapter$EmojiViewHolder$onConfigure$2(WidgetEmojiAdapter.EmojiViewHolder emojiViewHolder, WidgetEmojiAdapter.EmojiItem emojiItem) {
        super(1);
        this.this$0 = emojiViewHolder;
        this.$emojiItem = emojiItem;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(View view) {
        invoke2(view);
        return Unit.f27425a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(View view) {
        Object objM11474constructorimpl;
        C12238m.checkNotNullParameter(view, "it");
        try {
            C12112k.a aVar = C12112k.f25169j;
            Emoji emoji = this.$emojiItem.getEmoji();
            if (emoji == null) {
                throw new NullPointerException("null cannot be cast to non-null type com.discord.models.domain.emoji.ModelEmojiCustom");
            }
            objM11474constructorimpl = C12112k.m11474constructorimpl(EmojiNode.INSTANCE.generateEmojiIdAndType((ModelEmojiCustom) emoji));
            if (C12112k.m11476exceptionOrNullimpl(objM11474constructorimpl) != null) {
                try {
                    C12112k.a aVar2 = C12112k.f25169j;
                    Emoji emoji2 = this.$emojiItem.getEmoji();
                    if (emoji2 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type com.discord.models.domain.emoji.ModelEmojiUnicode");
                    }
                    objM11474constructorimpl = C12112k.m11474constructorimpl(EmojiNode.INSTANCE.generateEmojiIdAndType((ModelEmojiUnicode) emoji2));
                } catch (Throwable th) {
                    C12112k.a aVar3 = C12112k.f25169j;
                    objM11474constructorimpl = C12112k.m11474constructorimpl(C12113l.createFailure(th));
                }
            }
            if (C12112k.m11479isSuccessimpl(objM11474constructorimpl)) {
                WidgetEmojiAdapter.EmojiViewHolder.access$getAdapter$p(this.this$0).hideKeyboard.invoke();
                WidgetEmojiSheet.INSTANCE.show(WidgetEmojiAdapter.EmojiViewHolder.access$getAdapter$p(this.this$0).fragmentManager, (EmojiNode.EmojiIdAndType) objM11474constructorimpl);
            }
        } catch (Throwable th2) {
            C12112k.a aVar4 = C12112k.f25169j;
            objM11474constructorimpl = C12112k.m11474constructorimpl(C12113l.createFailure(th2));
        }
    }
}
