package com.discord.widgets.stage.sheet;

import androidx.core.os.BundleKt;
import androidx.fragment.app.FragmentManager;
import d0.o;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: WidgetStageModeratorJoinBottomSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetStageModeratorJoinBottomSheet$Companion {
    private WidgetStageModeratorJoinBottomSheet$Companion() {
    }

    public final void show(FragmentManager fragmentManager, long channelId) {
        m.checkNotNullParameter(fragmentManager, "fragmentManager");
        WidgetStageModeratorJoinBottomSheet widgetStageModeratorJoinBottomSheet = new WidgetStageModeratorJoinBottomSheet();
        widgetStageModeratorJoinBottomSheet.setArguments(BundleKt.bundleOf(o.to("com.discord.intent.extra.EXTRA_CHANNEL_ID", Long.valueOf(channelId))));
        widgetStageModeratorJoinBottomSheet.show(fragmentManager, WidgetStageModeratorJoinBottomSheet.class.getSimpleName());
    }

    public /* synthetic */ WidgetStageModeratorJoinBottomSheet$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
