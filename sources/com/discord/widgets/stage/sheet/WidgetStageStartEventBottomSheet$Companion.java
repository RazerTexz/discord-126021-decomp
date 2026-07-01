package com.discord.widgets.stage.sheet;

import androidx.core.os.BundleKt;
import androidx.fragment.app.FragmentManager;
import d0.o;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: WidgetStageStartEventBottomSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetStageStartEventBottomSheet$Companion {
    private WidgetStageStartEventBottomSheet$Companion() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ WidgetStageStartEventBottomSheet show$default(WidgetStageStartEventBottomSheet$Companion widgetStageStartEventBottomSheet$Companion, FragmentManager fragmentManager, long j, Function0 function0, int i, Object obj) {
        if ((i & 4) != 0) {
            function0 = null;
        }
        return widgetStageStartEventBottomSheet$Companion.show(fragmentManager, j, function0);
    }

    public final WidgetStageStartEventBottomSheet show(FragmentManager fragmentManager, long channelId, Function0<Unit> onDismiss) {
        m.checkNotNullParameter(fragmentManager, "fragmentManager");
        WidgetStageStartEventBottomSheet widgetStageStartEventBottomSheet = new WidgetStageStartEventBottomSheet();
        widgetStageStartEventBottomSheet.setOnDismiss(onDismiss);
        widgetStageStartEventBottomSheet.setArguments(BundleKt.bundleOf(o.to("com.discord.intent.extra.EXTRA_CHANNEL_ID", Long.valueOf(channelId))));
        widgetStageStartEventBottomSheet.show(fragmentManager, WidgetStageStartEventBottomSheet.class.getSimpleName());
        return widgetStageStartEventBottomSheet;
    }

    public /* synthetic */ WidgetStageStartEventBottomSheet$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
