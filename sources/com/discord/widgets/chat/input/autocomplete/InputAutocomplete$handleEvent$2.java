package com.discord.widgets.chat.input.autocomplete;

import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: InputAutocomplete.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class InputAutocomplete$handleEvent$2 extends o implements Function1<Boolean, Unit> {
    public final /* synthetic */ Event $event;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InputAutocomplete$handleEvent$2(Event event) {
        super(1);
        this.$event = event;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
        invoke(bool.booleanValue());
        return Unit.a;
    }

    public final void invoke(boolean z2) {
        ((Event$PreviewAttachment) this.$event).getAttachment().setSpoiler(z2);
    }
}
