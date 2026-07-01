package com.discord.widgets.guildscheduledevent;

import android.view.View;
import com.discord.databinding.WidgetEndStageBottomSheetBinding;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import kotlin.jvm.functions.Function1;

/* JADX INFO: renamed from: com.discord.widgets.guildscheduledevent.WidgetEndGuildScheduledEventBottomSheet$binding$2, reason: use source file name */
/* JADX INFO: compiled from: WidgetEndGuildScheduledEventBottomSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetEndGuildScheduledEventBottomSheet3 extends FunctionReferenceImpl implements Function1<View, WidgetEndStageBottomSheetBinding> {
    public static final WidgetEndGuildScheduledEventBottomSheet3 INSTANCE = new WidgetEndGuildScheduledEventBottomSheet3();

    public WidgetEndGuildScheduledEventBottomSheet3() {
        super(1, WidgetEndStageBottomSheetBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetEndStageBottomSheetBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final WidgetEndStageBottomSheetBinding invoke(View view) {
        Intrinsics3.checkNotNullParameter(view, "p1");
        return WidgetEndStageBottomSheetBinding.a(view);
    }
}
