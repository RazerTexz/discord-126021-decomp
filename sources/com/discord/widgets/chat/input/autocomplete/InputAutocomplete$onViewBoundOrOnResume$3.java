package com.discord.widgets.chat.input.autocomplete;

import d0.z.d.k;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: InputAutocomplete.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class InputAutocomplete$onViewBoundOrOnResume$3 extends k implements Function1<Event, Unit> {
    public InputAutocomplete$onViewBoundOrOnResume$3(InputAutocomplete inputAutocomplete) {
        super(1, inputAutocomplete, InputAutocomplete.class, "handleEvent", "handleEvent(Lcom/discord/widgets/chat/input/autocomplete/Event;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Event event) {
        invoke2(event);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Event event) {
        m.checkNotNullParameter(event, "p1");
        InputAutocomplete.access$handleEvent((InputAutocomplete) this.receiver, event);
    }
}
