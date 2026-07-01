package com.discord.utilities.voice;

import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: ScreenShareManager.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ScreenShareManager$subscribeToStores$3 extends o implements Function1<ScreenShareManager$State, Unit> {
    public final /* synthetic */ ScreenShareManager this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ScreenShareManager$subscribeToStores$3(ScreenShareManager screenShareManager) {
        super(1);
        this.this$0 = screenShareManager;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(ScreenShareManager$State screenShareManager$State) {
        invoke2(screenShareManager$State);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(ScreenShareManager$State screenShareManager$State) {
        ScreenShareManager screenShareManager = this.this$0;
        m.checkNotNullExpressionValue(screenShareManager$State, "it");
        ScreenShareManager.access$handleStateUpdate(screenShareManager, screenShareManager$State);
    }
}
