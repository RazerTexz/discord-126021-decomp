package com.discord.widgets.chat.input.sticker;

import d0.z.d.m;
import d0.z.d.o;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: StickerCategoryAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StickerCategoryAdapter$setItems$1 extends o implements Function1<List<? extends StickerCategoryItem>, Unit> {
    public final /* synthetic */ StickerCategoryAdapter this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StickerCategoryAdapter$setItems$1(StickerCategoryAdapter stickerCategoryAdapter) {
        super(1);
        this.this$0 = stickerCategoryAdapter;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(List<? extends StickerCategoryItem> list) {
        invoke2(list);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(List<? extends StickerCategoryItem> list) {
        m.checkNotNullParameter(list, "items");
        StickerCategoryAdapter.access$setItems$p(this.this$0, list);
        Iterator<? extends StickerCategoryItem> it = list.iterator();
        int i = 0;
        while (true) {
            if (!it.hasNext()) {
                i = -1;
                break;
            } else if (it.next().getIsSelected()) {
                break;
            } else {
                i++;
            }
        }
        if (i != -1) {
            StickerCategoryAdapter.access$getOnSelectedItemAdapterPositionUpdated$p(this.this$0).invoke(Integer.valueOf(i));
        }
    }
}
