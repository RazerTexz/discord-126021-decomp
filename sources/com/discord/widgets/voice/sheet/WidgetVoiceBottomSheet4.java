package com.discord.widgets.voice.sheet;

import com.discord.widgets.voice.sheet.WidgetVoiceBottomSheet;
import d0.z.d.Lambda;
import java.io.Serializable;
import java.util.Objects;
import kotlin.jvm.functions.Function0;

/* JADX INFO: renamed from: com.discord.widgets.voice.sheet.WidgetVoiceBottomSheet$featureContext$2, reason: use source file name */
/* JADX INFO: compiled from: WidgetVoiceBottomSheet.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetVoiceBottomSheet4 extends Lambda implements Function0<WidgetVoiceBottomSheet.FeatureContext> {
    public final /* synthetic */ WidgetVoiceBottomSheet this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetVoiceBottomSheet4(WidgetVoiceBottomSheet widgetVoiceBottomSheet) {
        super(0);
        this.this$0 = widgetVoiceBottomSheet;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final WidgetVoiceBottomSheet.FeatureContext invoke() {
        Serializable serializable = this.this$0.requireArguments().getSerializable("ARG_FEATURE_CONTEXT");
        Objects.requireNonNull(serializable, "null cannot be cast to non-null type com.discord.widgets.voice.sheet.WidgetVoiceBottomSheet.FeatureContext");
        return (WidgetVoiceBottomSheet.FeatureContext) serializable;
    }
}
