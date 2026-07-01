package com.discord.widgets.voice.sheet;

import d0.z.d.o;
import java.io.Serializable;
import java.util.Objects;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: WidgetVoiceBottomSheet.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetVoiceBottomSheet$featureContext$2 extends o implements Function0<WidgetVoiceBottomSheet$FeatureContext> {
    public final /* synthetic */ WidgetVoiceBottomSheet this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetVoiceBottomSheet$featureContext$2(WidgetVoiceBottomSheet widgetVoiceBottomSheet) {
        super(0);
        this.this$0 = widgetVoiceBottomSheet;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ WidgetVoiceBottomSheet$FeatureContext invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final WidgetVoiceBottomSheet$FeatureContext invoke() {
        Serializable serializable = this.this$0.requireArguments().getSerializable("ARG_FEATURE_CONTEXT");
        Objects.requireNonNull(serializable, "null cannot be cast to non-null type com.discord.widgets.voice.sheet.WidgetVoiceBottomSheet.FeatureContext");
        return (WidgetVoiceBottomSheet$FeatureContext) serializable;
    }
}
