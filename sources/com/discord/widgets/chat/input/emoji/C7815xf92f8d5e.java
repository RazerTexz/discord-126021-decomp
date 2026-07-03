package com.discord.widgets.chat.input.emoji;

import com.discord.widgets.chat.input.emoji.EmojiCategoryItem;
import com.discord.widgets.chat.input.emoji.EmojiPickerViewModel;
import java.util.Iterator;
import kotlin.jvm.functions.Function0;
import p507d0.p592z.p594d.AbstractC12240o;

/* JADX INFO: renamed from: com.discord.widgets.chat.input.emoji.EmojiPickerViewModel$ViewState$Results$firstUnicodeEmojiCategoryItem$2 */
/* JADX INFO: compiled from: EmojiPickerViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class C7815xf92f8d5e extends AbstractC12240o implements Function0<EmojiCategoryItem.StandardItem> {
    public final /* synthetic */ EmojiPickerViewModel.ViewState.Results this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C7815xf92f8d5e(EmojiPickerViewModel.ViewState.Results results) {
        super(0);
        this.this$0 = results;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final EmojiCategoryItem.StandardItem invoke() {
        Object next;
        Iterator<T> it = this.this$0.getCategoryItems().iterator();
        do {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
        } while (!((EmojiCategoryItem) next).containsOnlyUnicodeEmoji());
        return (EmojiCategoryItem.StandardItem) (next instanceof EmojiCategoryItem.StandardItem ? next : null);
    }
}
