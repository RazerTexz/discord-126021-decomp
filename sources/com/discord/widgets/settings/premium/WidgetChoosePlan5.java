package com.discord.widgets.settings.premium;

import com.discord.widgets.settings.premium.WidgetChoosePlan;
import d0.z.d.Lambda;
import java.io.Serializable;
import java.util.Objects;
import kotlin.jvm.functions.Function0;

/* JADX INFO: renamed from: com.discord.widgets.settings.premium.WidgetChoosePlan$viewModel$2, reason: use source file name */
/* JADX INFO: compiled from: WidgetChoosePlan.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChoosePlan5 extends Lambda implements Function0<ChoosePlanViewModel> {
    public final /* synthetic */ WidgetChoosePlan this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChoosePlan5(WidgetChoosePlan widgetChoosePlan) {
        super(0);
        this.this$0 = widgetChoosePlan;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final ChoosePlanViewModel invoke() {
        String stringExtra = this.this$0.getMostRecentIntent().getStringExtra(WidgetChoosePlan.RESULT_EXTRA_OLD_SKU_NAME);
        Serializable serializableExtra = this.this$0.getMostRecentIntent().getSerializableExtra(WidgetChoosePlan.RESULT_VIEW_TYPE);
        Objects.requireNonNull(serializableExtra, "null cannot be cast to non-null type com.discord.widgets.settings.premium.WidgetChoosePlan.ViewType");
        return new ChoosePlanViewModel((WidgetChoosePlan.ViewType) serializableExtra, stringExtra, null, 4, null);
    }
}
