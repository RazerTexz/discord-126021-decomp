package com.discord.widgets.chat.input.emoji;

import d0.z.d.m;
import d0.z.d.o;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: EmojiCategoryAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class EmojiCategoryAdapter$setItems$1 extends o implements Function1<List<? extends EmojiCategoryItem>, Unit> {
    public final /* synthetic */ EmojiCategoryAdapter this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EmojiCategoryAdapter$setItems$1(EmojiCategoryAdapter emojiCategoryAdapter) {
        super(1);
        this.this$0 = emojiCategoryAdapter;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(List<? extends EmojiCategoryItem> list) {
        invoke2(list);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(List<? extends EmojiCategoryItem> list) {
        m.checkNotNullParameter(list, "items");
        EmojiCategoryAdapter.access$setItems$p(this.this$0, list);
        Iterator<? extends EmojiCategoryItem> it = list.iterator();
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
            EmojiCategoryAdapter.access$getOnSelectedItemAdapterPositionUpdated$p(this.this$0).invoke(Integer.valueOf(i));
        }
    }
}
