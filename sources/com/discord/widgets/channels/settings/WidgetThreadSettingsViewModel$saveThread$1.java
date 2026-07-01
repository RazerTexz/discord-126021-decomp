package com.discord.widgets.channels.settings;

import com.discord.api.channel.Channel;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetThreadSettingsViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetThreadSettingsViewModel$saveThread$1 extends o implements Function1<Channel, Unit> {
    public final /* synthetic */ WidgetThreadSettingsViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetThreadSettingsViewModel$saveThread$1(WidgetThreadSettingsViewModel widgetThreadSettingsViewModel) {
        super(1);
        this.this$0 = widgetThreadSettingsViewModel;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Channel channel) {
        invoke2(channel);
        return Unit.a;
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Channel channel) {
        m.checkNotNullParameter(channel, "it");
        WidgetThreadSettingsViewModel.access$getEventSubject$p(this.this$0).k.onNext((T) new WidgetThreadSettingsViewModel$Event$ShowToast(2131896394));
    }
}
