package com.discord.widgets.voice.sheet;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: WidgetNoiseCancellationBottomSheet.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetNoiseCancellationBottomSheet$Companion {
    private WidgetNoiseCancellationBottomSheet$Companion() {
    }

    public final void show(Fragment fragment) {
        m.checkNotNullParameter(fragment, "fragment");
        WidgetNoiseCancellationBottomSheet widgetNoiseCancellationBottomSheet = new WidgetNoiseCancellationBottomSheet();
        FragmentManager parentFragmentManager = fragment.getParentFragmentManager();
        m.checkNotNullExpressionValue(parentFragmentManager, "fragment.parentFragmentManager");
        widgetNoiseCancellationBottomSheet.show(parentFragmentManager, WidgetNoiseCancellationBottomSheet.class.getName());
    }

    public /* synthetic */ WidgetNoiseCancellationBottomSheet$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
