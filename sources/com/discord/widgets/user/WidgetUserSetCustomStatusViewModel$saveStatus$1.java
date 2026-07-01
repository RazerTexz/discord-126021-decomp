package com.discord.widgets.user;

import com.discord.models.domain.ModelUserSettings;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetUserSetCustomStatusViewModel.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetUserSetCustomStatusViewModel$saveStatus$1 extends o implements Function1<ModelUserSettings, Unit> {
    public final /* synthetic */ WidgetUserSetCustomStatusViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetUserSetCustomStatusViewModel$saveStatus$1(WidgetUserSetCustomStatusViewModel widgetUserSetCustomStatusViewModel) {
        super(1);
        this.this$0 = widgetUserSetCustomStatusViewModel;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(ModelUserSettings modelUserSettings) {
        invoke2(modelUserSettings);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(ModelUserSettings modelUserSettings) {
        m.checkNotNullParameter(modelUserSettings, "it");
        WidgetUserSetCustomStatusViewModel.access$emitSetStatusSuccessEvent(this.this$0);
    }
}
