package com.discord.stores;

import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: StoreStream.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreStream$guildStickers$1 extends AbstractC12240o implements Function1<List<? extends Long>, Unit> {
    public final /* synthetic */ StoreStream this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreStream$guildStickers$1(StoreStream storeStream) {
        super(1);
        this.this$0 = storeStream;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(List<? extends Long> list) {
        invoke2((List<Long>) list);
        return Unit.f27425a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(List<Long> list) {
        C12238m.checkNotNullParameter(list, "deletedStickers");
        this.this$0.getStickers().handleDeletedStickers(list);
    }
}
