package com.discord.widgets.voice.controls;

import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: AnchoredVoiceControlsView.kt */
/* JADX INFO: loaded from: classes.dex */
public final class AnchoredVoiceControlsView$setOnPttPressedListener$1 extends o implements Function1<Boolean, Unit> {
    public final /* synthetic */ Function1 $onPttPressed;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AnchoredVoiceControlsView$setOnPttPressedListener$1(Function1 function1) {
        super(1);
        this.$onPttPressed = function1;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
        invoke(bool.booleanValue());
        return Unit.a;
    }

    public final void invoke(boolean z2) {
        this.$onPttPressed.invoke(Boolean.valueOf(z2));
    }
}
