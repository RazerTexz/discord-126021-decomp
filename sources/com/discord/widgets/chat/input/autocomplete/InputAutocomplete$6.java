package com.discord.widgets.chat.input.autocomplete;

import android.content.Context;
import com.discord.api.sticker.Sticker;
import com.discord.widgets.chat.MessageManager;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: InputAutocomplete.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class InputAutocomplete$6 extends o implements Function1<Sticker, Unit> {
    public final /* synthetic */ InputAutocomplete this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InputAutocomplete$6(InputAutocomplete inputAutocomplete) {
        super(1);
        this.this$0 = inputAutocomplete;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Sticker sticker) {
        invoke2(sticker);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Sticker sticker) {
        m.checkNotNullParameter(sticker, "sticker");
        InputAutocomplete.access$getViewModel$p(this.this$0).selectStickerItem(sticker);
        Context context = InputAutocomplete.access$getEditText$p(this.this$0).getContext();
        m.checkNotNullExpressionValue(context, "editText.context");
        MessageManager.sendMessage$default(new MessageManager(context, null, null, null, null, null, null, null, null, 510, null), null, null, null, null, d0.t.m.listOf(sticker), false, null, null, null, 495, null);
    }
}
