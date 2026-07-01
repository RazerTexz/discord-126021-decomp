package com.discord.widgets.guilds.profile;

import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetChangeGuildIdentityViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChangeGuildIdentityViewModel$1 extends o implements Function1<WidgetChangeGuildIdentityViewModel$StoreState, Unit> {
    public final /* synthetic */ WidgetChangeGuildIdentityViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChangeGuildIdentityViewModel$1(WidgetChangeGuildIdentityViewModel widgetChangeGuildIdentityViewModel) {
        super(1);
        this.this$0 = widgetChangeGuildIdentityViewModel;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(WidgetChangeGuildIdentityViewModel$StoreState widgetChangeGuildIdentityViewModel$StoreState) {
        invoke2(widgetChangeGuildIdentityViewModel$StoreState);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(WidgetChangeGuildIdentityViewModel$StoreState widgetChangeGuildIdentityViewModel$StoreState) {
        m.checkNotNullParameter(widgetChangeGuildIdentityViewModel$StoreState, "storeState");
        WidgetChangeGuildIdentityViewModel.access$handleStoreState(this.this$0, widgetChangeGuildIdentityViewModel$StoreState);
    }
}
