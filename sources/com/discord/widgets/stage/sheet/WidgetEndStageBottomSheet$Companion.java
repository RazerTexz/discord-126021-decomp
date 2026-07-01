package com.discord.widgets.stage.sheet;

import androidx.core.os.BundleKt;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentKt;
import androidx.fragment.app.FragmentManager;
import d0.o;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: WidgetEndStageBottomSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetEndStageBottomSheet$Companion {
    private WidgetEndStageBottomSheet$Companion() {
    }

    public final void registerForResult(Fragment fragment, String requestKey, Function0<Unit> onActionTaken) {
        m.checkNotNullParameter(fragment, "fragment");
        m.checkNotNullParameter(requestKey, "requestKey");
        m.checkNotNullParameter(onActionTaken, "onActionTaken");
        FragmentKt.setFragmentResultListener(fragment, requestKey, new WidgetEndStageBottomSheet$Companion$registerForResult$1(requestKey, onActionTaken));
    }

    public final void show(FragmentManager fragmentManager, String requestKey, long channelId) {
        m.checkNotNullParameter(fragmentManager, "fragmentManager");
        m.checkNotNullParameter(requestKey, "requestKey");
        WidgetEndStageBottomSheet widgetEndStageBottomSheet = new WidgetEndStageBottomSheet();
        widgetEndStageBottomSheet.setArguments(BundleKt.bundleOf(o.to("com.discord.intent.extra.EXTRA_CHANNEL_ID", Long.valueOf(channelId)), o.to("INTENT_EXTRA_REQUEST_KEY", requestKey)));
        widgetEndStageBottomSheet.show(fragmentManager, WidgetEndStageBottomSheet.class.getSimpleName());
    }

    public /* synthetic */ WidgetEndStageBottomSheet$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
