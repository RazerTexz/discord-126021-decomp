package com.discord.widgets.chat.input.gifpicker;

import d0.z.d.m;
import d0.z.d.o;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: GifCategoryAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class GifCategoryAdapter$setItems$1 extends o implements Function1<List<? extends GifCategoryItem>, Unit> {
    public final /* synthetic */ GifCategoryAdapter this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GifCategoryAdapter$setItems$1(GifCategoryAdapter gifCategoryAdapter) {
        super(1);
        this.this$0 = gifCategoryAdapter;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(List<? extends GifCategoryItem> list) {
        invoke2(list);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(List<? extends GifCategoryItem> list) {
        m.checkNotNullParameter(list, "items");
        GifCategoryAdapter.access$setItems$p(this.this$0, list);
    }
}
