package com.discord.widgets.chat.input.autocomplete;

import d0.t.c0;
import d0.z.d.o;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.ranges.IntRange;

/* JADX INFO: compiled from: InputAutocomplete.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class InputAutocomplete$configureAutocompleteBrowser$1 extends o implements Function2<Integer, Integer, Unit> {
    public final /* synthetic */ InputAutocomplete this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InputAutocomplete$configureAutocompleteBrowser$1(InputAutocomplete inputAutocomplete) {
        super(2);
        this.this$0 = inputAutocomplete;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(Integer num, Integer num2) {
        invoke(num.intValue(), num2.intValue());
        return Unit.a;
    }

    public final void invoke(int i, int i2) {
        int iMin = Math.min(i2, InputAutocomplete.access$getAutocompleteAdapter$p(this.this$0).getPageSize() - 1);
        if (i >= 0 && iMin >= i) {
            IntRange intRange = new IntRange(i, iMin);
            ArrayList arrayList = new ArrayList(d0.t.o.collectionSizeOrDefault(intRange, 10));
            Iterator<Integer> it = intRange.iterator();
            while (it.hasNext()) {
                arrayList.add(InputAutocomplete.access$getAutocompleteAdapter$p(this.this$0).getItem(((c0) it).nextInt()));
            }
            InputAutocomplete.access$getViewModel$p(this.this$0).checkEmojiAutocompleteUpsellViewed(arrayList);
        }
    }
}
