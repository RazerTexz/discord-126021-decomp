package com.discord.widgets.channels.settings;

import android.text.Editable;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetThreadSettings.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetThreadSettings$onViewBound$1 extends o implements Function1<Editable, Unit> {
    public final /* synthetic */ WidgetThreadSettings this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetThreadSettings$onViewBound$1(WidgetThreadSettings widgetThreadSettings) {
        super(1);
        this.this$0 = widgetThreadSettings;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Editable editable) {
        invoke2(editable);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Editable editable) {
        m.checkNotNullParameter(editable, "editable");
        WidgetThreadSettings.access$getViewModel$p(this.this$0).onChannelNameInputChanged(editable.toString());
    }
}
