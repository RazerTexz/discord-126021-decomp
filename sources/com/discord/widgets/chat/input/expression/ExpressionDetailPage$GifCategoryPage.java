package com.discord.widgets.chat.input.expression;

import b.d.b.a.a;
import com.discord.widgets.chat.input.gifpicker.GifCategoryItem;
import d0.z.d.m;

/* JADX INFO: compiled from: ExpressionDetailPage.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class ExpressionDetailPage$GifCategoryPage extends ExpressionDetailPage {
    private final GifCategoryItem gifCategoryItem;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ExpressionDetailPage$GifCategoryPage(GifCategoryItem gifCategoryItem) {
        super(null);
        m.checkNotNullParameter(gifCategoryItem, "gifCategoryItem");
        this.gifCategoryItem = gifCategoryItem;
    }

    public static /* synthetic */ ExpressionDetailPage$GifCategoryPage copy$default(ExpressionDetailPage$GifCategoryPage expressionDetailPage$GifCategoryPage, GifCategoryItem gifCategoryItem, int i, Object obj) {
        if ((i & 1) != 0) {
            gifCategoryItem = expressionDetailPage$GifCategoryPage.gifCategoryItem;
        }
        return expressionDetailPage$GifCategoryPage.copy(gifCategoryItem);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final GifCategoryItem getGifCategoryItem() {
        return this.gifCategoryItem;
    }

    public final ExpressionDetailPage$GifCategoryPage copy(GifCategoryItem gifCategoryItem) {
        m.checkNotNullParameter(gifCategoryItem, "gifCategoryItem");
        return new ExpressionDetailPage$GifCategoryPage(gifCategoryItem);
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof ExpressionDetailPage$GifCategoryPage) && m.areEqual(this.gifCategoryItem, ((ExpressionDetailPage$GifCategoryPage) other).gifCategoryItem);
        }
        return true;
    }

    public final GifCategoryItem getGifCategoryItem() {
        return this.gifCategoryItem;
    }

    public int hashCode() {
        GifCategoryItem gifCategoryItem = this.gifCategoryItem;
        if (gifCategoryItem != null) {
            return gifCategoryItem.hashCode();
        }
        return 0;
    }

    public String toString() {
        StringBuilder sbU = a.U("GifCategoryPage(gifCategoryItem=");
        sbU.append(this.gifCategoryItem);
        sbU.append(")");
        return sbU.toString();
    }
}
