package com.discord.widgets.chat.input.expression;

import com.discord.widgets.chat.input.gifpicker.GifCategoryItem;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: ExpressionDetailPage.kt */
/* JADX INFO: loaded from: classes2.dex */
public abstract class ExpressionDetailPage {

    /* JADX INFO: compiled from: ExpressionDetailPage.kt */
    public static final /* data */ class GifCategoryPage extends ExpressionDetailPage {
        private final GifCategoryItem gifCategoryItem;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public GifCategoryPage(GifCategoryItem gifCategoryItem) {
            super(null);
            C12238m.checkNotNullParameter(gifCategoryItem, "gifCategoryItem");
            this.gifCategoryItem = gifCategoryItem;
        }

        public static /* synthetic */ GifCategoryPage copy$default(GifCategoryPage gifCategoryPage, GifCategoryItem gifCategoryItem, int i, Object obj) {
            if ((i & 1) != 0) {
                gifCategoryItem = gifCategoryPage.gifCategoryItem;
            }
            return gifCategoryPage.copy(gifCategoryItem);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final GifCategoryItem getGifCategoryItem() {
            return this.gifCategoryItem;
        }

        public final GifCategoryPage copy(GifCategoryItem gifCategoryItem) {
            C12238m.checkNotNullParameter(gifCategoryItem, "gifCategoryItem");
            return new GifCategoryPage(gifCategoryItem);
        }

        public boolean equals(Object other) {
            if (this != other) {
                return (other instanceof GifCategoryPage) && C12238m.areEqual(this.gifCategoryItem, ((GifCategoryPage) other).gifCategoryItem);
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
            StringBuilder sbM833U = C1643a.m833U("GifCategoryPage(gifCategoryItem=");
            sbM833U.append(this.gifCategoryItem);
            sbM833U.append(")");
            return sbM833U.toString();
        }
    }

    private ExpressionDetailPage() {
    }

    public /* synthetic */ ExpressionDetailPage(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
