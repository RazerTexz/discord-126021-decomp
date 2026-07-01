package com.discord.widgets.chat.input.gifpicker;

import d0.z.d.m;
import d0.z.d.o;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: GifAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class GifAdapter$setItems$1 extends o implements Function1<List<? extends GifAdapterItem>, Unit> {
    public final /* synthetic */ GifAdapter this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GifAdapter$setItems$1(GifAdapter gifAdapter) {
        super(1);
        this.this$0 = gifAdapter;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(List<? extends GifAdapterItem> list) {
        invoke2(list);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(List<? extends GifAdapterItem> list) {
        m.checkNotNullParameter(list, "items");
        GifAdapter.access$setItems$p(this.this$0, list);
    }
}
