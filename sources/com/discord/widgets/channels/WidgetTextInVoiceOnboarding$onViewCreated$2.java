package com.discord.widgets.channels;

import android.view.View;
import android.view.View$OnClickListener;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: WidgetTextInVoiceOnboarding.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetTextInVoiceOnboarding$onViewCreated$2 implements View$OnClickListener {
    public final /* synthetic */ WidgetTextInVoiceOnboarding this$0;

    public WidgetTextInVoiceOnboarding$onViewCreated$2(WidgetTextInVoiceOnboarding widgetTextInVoiceOnboarding) {
        this.this$0 = widgetTextInVoiceOnboarding;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        Function0 function0Access$getOnCtaClicked$p = WidgetTextInVoiceOnboarding.access$getOnCtaClicked$p(this.this$0);
        if (function0Access$getOnCtaClicked$p != null) {
        }
        this.this$0.dismiss();
    }
}
