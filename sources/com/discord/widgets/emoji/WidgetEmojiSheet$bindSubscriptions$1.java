package com.discord.widgets.emoji;

import com.discord.utilities.KotlinExtensionsKt;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetEmojiSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetEmojiSheet$bindSubscriptions$1 extends o implements Function1<EmojiSheetViewModel$ViewState, Unit> {
    public final /* synthetic */ WidgetEmojiSheet this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetEmojiSheet$bindSubscriptions$1(WidgetEmojiSheet widgetEmojiSheet) {
        super(1);
        this.this$0 = widgetEmojiSheet;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(EmojiSheetViewModel$ViewState emojiSheetViewModel$ViewState) {
        invoke2(emojiSheetViewModel$ViewState);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(EmojiSheetViewModel$ViewState emojiSheetViewModel$ViewState) {
        Unit unit;
        m.checkNotNullParameter(emojiSheetViewModel$ViewState, "it");
        if (m.areEqual(emojiSheetViewModel$ViewState, EmojiSheetViewModel$ViewState$Loading.INSTANCE)) {
            WidgetEmojiSheet.access$showLoading(this.this$0);
            unit = Unit.a;
        } else if (emojiSheetViewModel$ViewState instanceof EmojiSheetViewModel$ViewState$EmojiCustom) {
            WidgetEmojiSheet.access$configureCustomEmoji(this.this$0, (EmojiSheetViewModel$ViewState$EmojiCustom) emojiSheetViewModel$ViewState);
            unit = Unit.a;
        } else if (emojiSheetViewModel$ViewState instanceof EmojiSheetViewModel$ViewState$EmojiUnicode) {
            WidgetEmojiSheet.access$configureUnicodeEmoji(this.this$0, (EmojiSheetViewModel$ViewState$EmojiUnicode) emojiSheetViewModel$ViewState);
            unit = Unit.a;
        } else {
            if (!m.areEqual(emojiSheetViewModel$ViewState, EmojiSheetViewModel$ViewState$Invalid.INSTANCE) && !m.areEqual(emojiSheetViewModel$ViewState, EmojiSheetViewModel$ViewState$Dismiss.INSTANCE)) {
                throw new NoWhenBranchMatchedException();
            }
            this.this$0.dismiss();
            unit = Unit.a;
        }
        KotlinExtensionsKt.getExhaustive(unit);
    }
}
