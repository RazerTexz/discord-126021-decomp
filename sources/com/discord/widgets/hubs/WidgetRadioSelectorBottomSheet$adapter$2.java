package com.discord.widgets.hubs;

import com.discord.utilities.views.SimpleRecyclerAdapter;
import d0.z.d.o;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: WidgetRadioSelectorBottomSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetRadioSelectorBottomSheet$adapter$2 extends o implements Function0<SimpleRecyclerAdapter<RadioSelectorItem, RadioSelectorViewHolder>> {
    public final /* synthetic */ WidgetRadioSelectorBottomSheet this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetRadioSelectorBottomSheet$adapter$2(WidgetRadioSelectorBottomSheet widgetRadioSelectorBottomSheet) {
        super(0);
        this.this$0 = widgetRadioSelectorBottomSheet;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ SimpleRecyclerAdapter<RadioSelectorItem, RadioSelectorViewHolder> invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final SimpleRecyclerAdapter<RadioSelectorItem, RadioSelectorViewHolder> invoke() {
        return new SimpleRecyclerAdapter<>(this.this$0.getArgs().getItems(), new WidgetRadioSelectorBottomSheet$adapter$2$1(this));
    }
}
