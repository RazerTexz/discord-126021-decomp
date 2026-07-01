package com.discord.widgets.guildscheduledevent;

import android.view.View;
import com.discord.databinding.WidgetEndStageBottomSheetBinding;
import d0.z.d.k;
import d0.z.d.m;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetEndGuildScheduledEventBottomSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetEndGuildScheduledEventBottomSheet$binding$2 extends k implements Function1<View, WidgetEndStageBottomSheetBinding> {
    public static final WidgetEndGuildScheduledEventBottomSheet$binding$2 INSTANCE = new WidgetEndGuildScheduledEventBottomSheet$binding$2();

    public WidgetEndGuildScheduledEventBottomSheet$binding$2() {
        super(1, WidgetEndStageBottomSheetBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetEndStageBottomSheetBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetEndStageBottomSheetBinding invoke(View view) {
        return invoke2(view);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetEndStageBottomSheetBinding invoke2(View view) {
        m.checkNotNullParameter(view, "p1");
        return WidgetEndStageBottomSheetBinding.a(view);
    }
}
