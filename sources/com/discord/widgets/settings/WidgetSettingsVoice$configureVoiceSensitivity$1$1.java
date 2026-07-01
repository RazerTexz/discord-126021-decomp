package com.discord.widgets.settings;

import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: WidgetSettingsVoice.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetSettingsVoice$configureVoiceSensitivity$1$1 extends o implements Function0<Unit> {
    public final /* synthetic */ WidgetSettingsVoice$configureVoiceSensitivity$1 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetSettingsVoice$configureVoiceSensitivity$1$1(WidgetSettingsVoice$configureVoiceSensitivity$1 widgetSettingsVoice$configureVoiceSensitivity$1) {
        super(0);
        this.this$0 = widgetSettingsVoice$configureVoiceSensitivity$1;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        WidgetSettingsVoice.access$getRequestListenForSensitivitySubject$p(this.this$0.this$0).onNext(Boolean.TRUE);
    }
}
