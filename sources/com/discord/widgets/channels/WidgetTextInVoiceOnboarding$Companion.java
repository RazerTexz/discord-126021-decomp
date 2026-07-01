package com.discord.widgets.channels;

import androidx.fragment.app.FragmentManager;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: WidgetTextInVoiceOnboarding.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetTextInVoiceOnboarding$Companion {
    private WidgetTextInVoiceOnboarding$Companion() {
    }

    public final void show(FragmentManager fragmentManager, Function0<Unit> onCtaClicked) {
        m.checkNotNullParameter(fragmentManager, "fragmentManager");
        m.checkNotNullParameter(onCtaClicked, "onCtaClicked");
        WidgetTextInVoiceOnboarding widgetTextInVoiceOnboarding = new WidgetTextInVoiceOnboarding();
        WidgetTextInVoiceOnboarding.access$setOnCtaClicked$p(widgetTextInVoiceOnboarding, onCtaClicked);
        widgetTextInVoiceOnboarding.show(fragmentManager, "javaClass");
    }

    public /* synthetic */ WidgetTextInVoiceOnboarding$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
