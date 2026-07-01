package com.discord.widgets.channels;

import d0.z.d.k;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: WidgetChannelPickerAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetchannelPickerAdapter$onCreateViewHolder$1 extends k implements Function0<Unit> {
    public WidgetchannelPickerAdapter$onCreateViewHolder$1(WidgetchannelPickerAdapter$OnItemClickListener widgetchannelPickerAdapter$OnItemClickListener) {
        super(0, widgetchannelPickerAdapter$OnItemClickListener, WidgetchannelPickerAdapter$OnItemClickListener.class, "onCreateChannelClick", "onCreateChannelClick()V", 0);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        ((WidgetchannelPickerAdapter$OnItemClickListener) this.receiver).onCreateChannelClick();
    }
}
