package com.discord.widgets.channels;

import d0.z.d.m;
import d0.z.d.o;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetChannelPickerAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetchannelPickerAdapter$setItems$1 extends o implements Function1<List<? extends ChannelPickerAdapterItem>, Unit> {
    public final /* synthetic */ WidgetchannelPickerAdapter this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetchannelPickerAdapter$setItems$1(WidgetchannelPickerAdapter widgetchannelPickerAdapter) {
        super(1);
        this.this$0 = widgetchannelPickerAdapter;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(List<? extends ChannelPickerAdapterItem> list) {
        invoke2(list);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(List<? extends ChannelPickerAdapterItem> list) {
        m.checkNotNullParameter(list, "items");
        WidgetchannelPickerAdapter.access$setItems$p(this.this$0, list);
    }
}
