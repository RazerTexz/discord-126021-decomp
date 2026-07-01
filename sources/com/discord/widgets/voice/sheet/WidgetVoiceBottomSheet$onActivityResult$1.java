package com.discord.widgets.voice.sheet;

import android.content.Intent;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetVoiceBottomSheet.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetVoiceBottomSheet$onActivityResult$1 extends o implements Function1<Intent, Unit> {
    public final /* synthetic */ WidgetVoiceBottomSheet this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetVoiceBottomSheet$onActivityResult$1(WidgetVoiceBottomSheet widgetVoiceBottomSheet) {
        super(1);
        this.this$0 = widgetVoiceBottomSheet;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Intent intent) {
        invoke2(intent);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Intent intent) {
        m.checkNotNullParameter(intent, "it");
        WidgetVoiceBottomSheet.access$getViewModel$p(this.this$0).startStream(intent);
    }
}
