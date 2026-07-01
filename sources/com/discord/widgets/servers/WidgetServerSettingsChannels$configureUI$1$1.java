package com.discord.widgets.servers;

import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetServerSettingsChannels.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettingsChannels$configureUI$1$1 extends o implements Function1<Integer, Unit> {
    public final /* synthetic */ WidgetServerSettingsChannels$configureUI$1 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetServerSettingsChannels$configureUI$1$1(WidgetServerSettingsChannels$configureUI$1 widgetServerSettingsChannels$configureUI$1) {
        super(1);
        this.this$0 = widgetServerSettingsChannels$configureUI$1;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
        invoke(num.intValue());
        return Unit.a;
    }

    public final void invoke(int i) {
        WidgetServerSettingsChannels.access$getChannelSortTypeSubject$p(this.this$0.this$0).onNext(Integer.valueOf(i));
    }
}
