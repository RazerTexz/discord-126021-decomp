package com.discord.widgets.chat.input.autocomplete;

import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: InputAutocomplete.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class InputAutocomplete$handleEvent$1 extends o implements Function0<Unit> {
    public final /* synthetic */ Event $event;
    public final /* synthetic */ InputAutocomplete this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InputAutocomplete$handleEvent$1(InputAutocomplete inputAutocomplete, Event event) {
        super(0);
        this.this$0 = inputAutocomplete;
        this.$event = event;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        InputAutocomplete.access$getViewModel$p(this.this$0).onAttachmentRemoved(((Event$PreviewAttachment) this.$event).getAttachment());
    }
}
