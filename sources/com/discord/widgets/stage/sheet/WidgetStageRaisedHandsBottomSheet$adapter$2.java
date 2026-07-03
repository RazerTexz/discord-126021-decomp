package com.discord.widgets.stage.sheet;

import com.discord.utilities.view.recycler.MaxHeightRecyclerView;
import kotlin.jvm.functions.Function0;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: WidgetStageRaisedHandsBottomSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetStageRaisedHandsBottomSheet$adapter$2 extends AbstractC12240o implements Function0<WidgetStageRaisedHandsBottomSheetAdapter> {
    public final /* synthetic */ WidgetStageRaisedHandsBottomSheet this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetStageRaisedHandsBottomSheet$adapter$2(WidgetStageRaisedHandsBottomSheet widgetStageRaisedHandsBottomSheet) {
        super(0);
        this.this$0 = widgetStageRaisedHandsBottomSheet;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final WidgetStageRaisedHandsBottomSheetAdapter invoke() {
        MaxHeightRecyclerView maxHeightRecyclerView = this.this$0.getBinding().f18169e;
        C12238m.checkNotNullExpressionValue(maxHeightRecyclerView, "binding.stageRaisedHandsRecycler");
        return new WidgetStageRaisedHandsBottomSheetAdapter(maxHeightRecyclerView);
    }
}
