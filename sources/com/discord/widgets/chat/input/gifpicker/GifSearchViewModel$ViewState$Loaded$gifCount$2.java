package com.discord.widgets.chat.input.gifpicker;

import d0.t.n;
import d0.z.d.o;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: GifSearchViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class GifSearchViewModel$ViewState$Loaded$gifCount$2 extends o implements Function0<Integer> {
    public final /* synthetic */ GifSearchViewModel$ViewState$Loaded this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GifSearchViewModel$ViewState$Loaded$gifCount$2(GifSearchViewModel$ViewState$Loaded gifSearchViewModel$ViewState$Loaded) {
        super(0);
        this.this$0 = gifSearchViewModel$ViewState$Loaded;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Integer invoke() {
        return Integer.valueOf(invoke2());
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final int invoke2() {
        List<GifAdapterItem> adapterItems = this.this$0.getAdapterItems();
        int i = 0;
        if (!(adapterItems instanceof Collection) || !adapterItems.isEmpty()) {
            Iterator<T> it = adapterItems.iterator();
            while (it.hasNext()) {
                if ((((GifAdapterItem) it.next()) instanceof GifAdapterItem$GifItem) && (i = i + 1) < 0) {
                    n.throwCountOverflow();
                }
            }
        }
        return i;
    }
}
