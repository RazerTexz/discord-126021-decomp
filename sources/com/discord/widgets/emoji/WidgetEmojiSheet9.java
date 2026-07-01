package com.discord.widgets.emoji;

import d0.z.d.Lambda;
import kotlin.jvm.functions.Function0;

/* JADX INFO: renamed from: com.discord.widgets.emoji.WidgetEmojiSheet$viewModel$2, reason: use source file name */
/* JADX INFO: compiled from: WidgetEmojiSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetEmojiSheet9 extends Lambda implements Function0<EmojiSheetViewModel> {
    public final /* synthetic */ WidgetEmojiSheet this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetEmojiSheet9(WidgetEmojiSheet widgetEmojiSheet) {
        super(0);
        this.this$0 = widgetEmojiSheet;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final EmojiSheetViewModel invoke() {
        return new EmojiSheetViewModel(this.this$0.getEmojiIdAndType(), null, null, null, null, null, null, null, null, null, 1022, null);
    }
}
