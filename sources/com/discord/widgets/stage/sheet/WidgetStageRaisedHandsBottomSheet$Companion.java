package com.discord.widgets.stage.sheet;

import androidx.core.os.BundleKt;
import androidx.fragment.app.FragmentManager;
import d0.o;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: WidgetStageRaisedHandsBottomSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetStageRaisedHandsBottomSheet$Companion {
    private WidgetStageRaisedHandsBottomSheet$Companion() {
    }

    public final WidgetStageRaisedHandsBottomSheet show(FragmentManager fragmentManager, long channelId) {
        m.checkNotNullParameter(fragmentManager, "fragmentManager");
        WidgetStageRaisedHandsBottomSheet widgetStageRaisedHandsBottomSheet = new WidgetStageRaisedHandsBottomSheet();
        widgetStageRaisedHandsBottomSheet.setArguments(BundleKt.bundleOf(o.to("com.discord.intent.extra.EXTRA_CHANNEL_ID", Long.valueOf(channelId))));
        widgetStageRaisedHandsBottomSheet.show(fragmentManager, WidgetStageRaisedHandsBottomSheet.class.getSimpleName());
        return widgetStageRaisedHandsBottomSheet;
    }

    public /* synthetic */ WidgetStageRaisedHandsBottomSheet$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
