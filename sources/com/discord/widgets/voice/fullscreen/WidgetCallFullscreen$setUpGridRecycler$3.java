package com.discord.widgets.voice.fullscreen;

import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetCallFullscreen.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetCallFullscreen$setUpGridRecycler$3 extends o implements Function1<String, Unit> {
    public final /* synthetic */ WidgetCallFullscreen this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetCallFullscreen$setUpGridRecycler$3(WidgetCallFullscreen widgetCallFullscreen) {
        super(1);
        this.this$0 = widgetCallFullscreen;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(String str) {
        invoke2(str);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(String str) {
        m.checkNotNullParameter(str, "it");
        WidgetCallFullscreen.access$getViewModel$p(this.this$0).targetAndFocusStream(str);
    }
}
