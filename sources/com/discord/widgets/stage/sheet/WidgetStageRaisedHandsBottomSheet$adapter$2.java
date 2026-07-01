package com.discord.widgets.stage.sheet;

import com.discord.utilities.view.recycler.MaxHeightRecyclerView;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: WidgetStageRaisedHandsBottomSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetStageRaisedHandsBottomSheet$adapter$2 extends o implements Function0<WidgetStageRaisedHandsBottomSheetAdapter> {
    public final /* synthetic */ WidgetStageRaisedHandsBottomSheet this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetStageRaisedHandsBottomSheet$adapter$2(WidgetStageRaisedHandsBottomSheet widgetStageRaisedHandsBottomSheet) {
        super(0);
        this.this$0 = widgetStageRaisedHandsBottomSheet;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ WidgetStageRaisedHandsBottomSheetAdapter invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final WidgetStageRaisedHandsBottomSheetAdapter invoke() {
        MaxHeightRecyclerView maxHeightRecyclerView = WidgetStageRaisedHandsBottomSheet.access$getBinding$p(this.this$0).e;
        m.checkNotNullExpressionValue(maxHeightRecyclerView, "binding.stageRaisedHandsRecycler");
        return new WidgetStageRaisedHandsBottomSheetAdapter(maxHeightRecyclerView);
    }
}
