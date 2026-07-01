package com.discord.widgets.chat.input.expression;

import b.d.b.a.outline;
import com.discord.widgets.chat.input.gifpicker.GifCategoryItem;
import d0.z.d.Intrinsics3;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: ExpressionDetailPage.kt */
/* JADX INFO: loaded from: classes2.dex */
public abstract class ExpressionDetailPage {

    /* JADX INFO: compiled from: ExpressionDetailPage.kt */
    public static final /* data */ class GifCategoryPage extends ExpressionDetailPage {
        private final GifCategoryItem gifCategoryItem;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public GifCategoryPage(GifCategoryItem gifCategoryItem) {
            super(null);
            Intrinsics3.checkNotNullParameter(gifCategoryItem, "gifCategoryItem");
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
            Intrinsics3.checkNotNullParameter(gifCategoryItem, "gifCategoryItem");
            return new GifCategoryPage(gifCategoryItem);
        }

        public boolean equals(Object other) {
            if (this != other) {
                return (other instanceof GifCategoryPage) && Intrinsics3.areEqual(this.gifCategoryItem, ((GifCategoryPage) other).gifCategoryItem);
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
            StringBuilder sbU = outline.U("GifCategoryPage(gifCategoryItem=");
            sbU.append(this.gifCategoryItem);
            sbU.append(")");
            return sbU.toString();
        }
    }

    private ExpressionDetailPage() {
    }

    public /* synthetic */ ExpressionDetailPage(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
