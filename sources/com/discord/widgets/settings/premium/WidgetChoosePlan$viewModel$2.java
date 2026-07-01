package com.discord.widgets.settings.premium;

import d0.z.d.o;
import java.io.Serializable;
import java.util.Objects;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: WidgetChoosePlan.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChoosePlan$viewModel$2 extends o implements Function0<ChoosePlanViewModel> {
    public final /* synthetic */ WidgetChoosePlan this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChoosePlan$viewModel$2(WidgetChoosePlan widgetChoosePlan) {
        super(0);
        this.this$0 = widgetChoosePlan;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ ChoosePlanViewModel invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final ChoosePlanViewModel invoke() {
        String stringExtra = this.this$0.getMostRecentIntent().getStringExtra(WidgetChoosePlan.RESULT_EXTRA_OLD_SKU_NAME);
        Serializable serializableExtra = this.this$0.getMostRecentIntent().getSerializableExtra(WidgetChoosePlan.RESULT_VIEW_TYPE);
        Objects.requireNonNull(serializableExtra, "null cannot be cast to non-null type com.discord.widgets.settings.premium.WidgetChoosePlan.ViewType");
        return new ChoosePlanViewModel((WidgetChoosePlan$ViewType) serializableExtra, stringExtra, null, 4, null);
    }
}
