package com.discord.widgets.voice.fullscreen;

import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetCallFullscreen.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetCallFullscreen$setUpStageRecycler$1 extends o implements Function1<CallParticipant$UserOrStreamParticipant, Unit> {
    public static final WidgetCallFullscreen$setUpStageRecycler$1 INSTANCE = new WidgetCallFullscreen$setUpStageRecycler$1();

    public WidgetCallFullscreen$setUpStageRecycler$1() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(CallParticipant$UserOrStreamParticipant callParticipant$UserOrStreamParticipant) {
        invoke2(callParticipant$UserOrStreamParticipant);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(CallParticipant$UserOrStreamParticipant callParticipant$UserOrStreamParticipant) {
        m.checkNotNullParameter(callParticipant$UserOrStreamParticipant, "it");
    }
}
