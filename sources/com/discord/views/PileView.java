package com.discord.views;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.ColorDrawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import b.a.i.PileItemOverflowViewBinding;
import b.a.i.ViewPileItemBinding;
import com.discord.R;
import com.discord.utilities.dimen.DimenUtils;
import com.discord.utilities.icon.IconUtils;
import com.discord.utilities.images.MGImages;
import com.discord.views.CutoutView;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.ShapeAppearanceModel;
import d0.t.Collections2;
import d0.t._Collections;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.Collection;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: PileView.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class PileView extends FrameLayout {

    /* JADX INFO: renamed from: j, reason: from kotlin metadata */
    public int maxItems;

    /* JADX INFO: renamed from: k, reason: from kotlin metadata */
    public boolean doRoundItem;

    /* JADX INFO: renamed from: l, reason: from kotlin metadata */
    public boolean doRoundBg;

    /* JADX INFO: renamed from: m, reason: from kotlin metadata */
    public int itemSizePx;

    /* JADX INFO: renamed from: n, reason: from kotlin metadata */
    public int overlapPx;

    /* JADX INFO: renamed from: o, reason: from kotlin metadata */
    @ColorInt
    public int itemBackgroundColor;

    /* JADX INFO: renamed from: p, reason: from kotlin metadata */
    public int itemPaddingPx;

    /* JADX INFO: renamed from: q, reason: from kotlin metadata */
    @ColorInt
    public int itemTextColor;

    /* JADX INFO: renamed from: r, reason: from kotlin metadata */
    public int cutoutThicknessPx;

    /* JADX INFO: renamed from: s, reason: collision with root package name and from kotlin metadata */
    public final CutoutView.a cutoutStyle;

    /* JADX INFO: renamed from: t, reason: from kotlin metadata */
    public int overflowTextSizePx;

    /* JADX INFO: renamed from: u, reason: from kotlin metadata */
    public boolean showOverFlowItem;

    /* JADX INFO: renamed from: v, reason: from kotlin metadata */
    @ColorInt
    public int overflowBackgroundColor;

    /* JADX INFO: compiled from: kotlin-style lambda group */
    public static final class a extends Lambda implements Function1<Integer, String> {
        public static final a j = new a(0);
        public static final a k = new a(1);
        public static final a l = new a(2);
        public final /* synthetic */ int m;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(int i) {
            super(1);
            this.m = i;
        }

        @Override // kotlin.jvm.functions.Function1
        public final String invoke(Integer num) {
            int i = this.m;
            if (i == 0) {
                num.intValue();
                return "asset://asset/images/default_avatar_0.jpg";
            }
            if (i == 1) {
                num.intValue();
                return "asset://asset/images/default_avatar_1.jpg";
            }
            if (i != 2) {
                throw null;
            }
            num.intValue();
            return "asset://asset/images/default_avatar_2.jpg";
        }
    }

    /* JADX INFO: compiled from: kotlin-style lambda group */
    public static final class b extends Lambda implements Function0<String> {
        public static final b j = new b(0);
        public static final b k = new b(1);
        public static final b l = new b(2);
        public final /* synthetic */ int m;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(int i) {
            super(0);
            this.m = i;
        }

        @Override // kotlin.jvm.functions.Function0
        public final String invoke() {
            int i = this.m;
            if (i == 0 || i == 1 || i == 2) {
                return "";
            }
            throw null;
        }
    }

    /* JADX INFO: compiled from: PileView.kt */
    public static final class c {
        public final Function1<Integer, String> a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Function0<String> f2835b;

        /* JADX WARN: Multi-variable type inference failed */
        public c(Function1<? super Integer, String> function1, Function0<String> function0) {
            Intrinsics3.checkNotNullParameter(function1, "getImageURI");
            this.a = function1;
            this.f2835b = function0;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PileView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics3.checkNotNullParameter(context, "context");
        this.maxItems = 3;
        this.doRoundItem = true;
        this.doRoundBg = true;
        this.itemSizePx = DimenUtils.dpToPixels(16);
        this.cutoutThicknessPx = DimenUtils.dpToPixels(2);
        this.overflowTextSizePx = DimenUtils.dpToPixels(14);
        int[] iArr = R.a.PileView;
        Intrinsics3.checkNotNullExpressionValue(iArr, "R.styleable.PileView");
        Context context2 = getContext();
        Intrinsics3.checkNotNullExpressionValue(context2, "context");
        TypedArray typedArrayObtainStyledAttributes = context2.obtainStyledAttributes(attributeSet, iArr);
        Intrinsics3.checkNotNullExpressionValue(typedArrayObtainStyledAttributes, "obtainStyledAttributes(attrs, styleable)");
        this.maxItems = typedArrayObtainStyledAttributes.getInt(6, this.maxItems);
        this.itemSizePx = typedArrayObtainStyledAttributes.getDimensionPixelSize(4, this.itemSizePx);
        this.itemBackgroundColor = typedArrayObtainStyledAttributes.getColor(0, this.itemBackgroundColor);
        this.itemPaddingPx = typedArrayObtainStyledAttributes.getDimensionPixelSize(3, this.itemPaddingPx);
        this.itemTextColor = typedArrayObtainStyledAttributes.getColor(5, this.itemTextColor);
        this.overlapPx = typedArrayObtainStyledAttributes.getDimensionPixelSize(2, this.overlapPx);
        this.cutoutThicknessPx = typedArrayObtainStyledAttributes.getDimensionPixelSize(1, this.cutoutThicknessPx);
        this.doRoundItem = typedArrayObtainStyledAttributes.getBoolean(10, this.doRoundItem);
        this.doRoundBg = typedArrayObtainStyledAttributes.getBoolean(9, this.doRoundBg);
        this.overflowTextSizePx = typedArrayObtainStyledAttributes.getDimensionPixelSize(7, this.overflowTextSizePx);
        this.showOverFlowItem = typedArrayObtainStyledAttributes.getBoolean(11, this.showOverFlowItem);
        this.overflowBackgroundColor = typedArrayObtainStyledAttributes.getColor(8, this.overflowBackgroundColor);
        typedArrayObtainStyledAttributes.recycle();
        int i = this.itemSizePx / 2;
        int i2 = this.overlapPx;
        int i3 = this.cutoutThicknessPx;
        this.cutoutStyle = new CutoutView.a.b(i + i3, i2 + i3);
        if (isInEditMode()) {
            setItems(Collections2.listOf((Object[]) new c[]{new c(a.j, b.j), new c(a.k, b.k), new c(a.l, b.l)}));
        }
    }

    public final void setItems(Collection<c> items) {
        Intrinsics3.checkNotNullParameter(items, "items");
        removeAllViews();
        boolean z2 = false;
        int size = items.size() > this.maxItems ? (items.size() - this.maxItems) + 1 : 0;
        int size2 = size > 0 ? this.maxItems - 1 : items.size();
        int i = size2 - 1;
        int i2 = 0;
        for (Object obj : _Collections.take(items, size2)) {
            int i3 = i2 + 1;
            if (i2 < 0) {
                Collections2.throwIndexOverflow();
            }
            c cVar = (c) obj;
            int i4 = this.itemSizePx * i2;
            int i5 = this.overlapPx * i2;
            View viewInflate = LayoutInflater.from(getContext()).inflate(R.layout.view_pile_item, this, z2);
            int i6 = R.id.pileItemBg;
            SimpleDraweeView simpleDraweeView = (SimpleDraweeView) viewInflate.findViewById(R.id.pileItemBg);
            if (simpleDraweeView != null) {
                i6 = R.id.pileItemImage;
                SimpleDraweeView simpleDraweeView2 = (SimpleDraweeView) viewInflate.findViewById(R.id.pileItemImage);
                if (simpleDraweeView2 != null) {
                    TextView textView = (TextView) viewInflate.findViewById(R.id.pileItemInitials);
                    if (textView != null) {
                        CutoutView cutoutView = (CutoutView) viewInflate;
                        Intrinsics3.checkNotNullExpressionValue(new ViewPileItemBinding(cutoutView, simpleDraweeView, simpleDraweeView2, textView), "ViewPileItemBinding.infl…om(context), this, false)");
                        cutoutView.setId(FrameLayout.generateViewId());
                        int i7 = this.itemSizePx;
                        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i7, i7);
                        layoutParams.setMarginStart(i4 - i5);
                        cutoutView.setLayoutParams(layoutParams);
                        Intrinsics3.checkNotNullExpressionValue(cutoutView, "itemBinding.root");
                        addView(cutoutView, cutoutView.getLayoutParams());
                        Intrinsics3.checkNotNullExpressionValue(simpleDraweeView2, "itemBinding.pileItemImage");
                        int i8 = this.itemPaddingPx;
                        simpleDraweeView2.setPadding(i8, i8, i8, i8);
                        if (!this.doRoundItem) {
                            Intrinsics3.checkNotNullExpressionValue(simpleDraweeView2, "itemBinding.pileItemImage");
                            GenericDraweeHierarchy hierarchy = simpleDraweeView2.getHierarchy();
                            Intrinsics3.checkNotNullExpressionValue(hierarchy, "itemBinding.pileItemImage.hierarchy");
                            hierarchy.s(null);
                        }
                        if (!this.doRoundBg) {
                            Intrinsics3.checkNotNullExpressionValue(simpleDraweeView, "itemBinding.pileItemBg");
                            GenericDraweeHierarchy hierarchy2 = simpleDraweeView.getHierarchy();
                            Intrinsics3.checkNotNullExpressionValue(hierarchy2, "itemBinding.pileItemBg.hierarchy");
                            hierarchy2.s(null);
                        }
                        if (this.itemBackgroundColor != 0) {
                            Intrinsics3.checkNotNullExpressionValue(simpleDraweeView, "itemBinding.pileItemBg");
                            simpleDraweeView.getHierarchy().o(1, new ColorDrawable(this.itemBackgroundColor));
                            Intrinsics3.checkNotNullExpressionValue(simpleDraweeView, "itemBinding.pileItemBg");
                            simpleDraweeView.setVisibility(0);
                        }
                        if (i2 != i || size > 0) {
                            cutoutView.setStyle(this.cutoutStyle);
                        }
                        String strInvoke = cVar.a.invoke(Integer.valueOf(IconUtils.getMediaProxySize(this.itemSizePx)));
                        Function0<String> function0 = cVar.f2835b;
                        String strInvoke2 = function0 != null ? function0.invoke() : null;
                        Intrinsics3.checkNotNullExpressionValue(textView, "itemBinding.pileItemInitials");
                        textView.setVisibility(strInvoke == null ? 0 : 8);
                        Intrinsics3.checkNotNullExpressionValue(textView, "itemBinding.pileItemInitials");
                        textView.setText(strInvoke2);
                        int i9 = this.itemTextColor;
                        if (i9 != 0) {
                            textView.setTextColor(i9);
                        }
                        Intrinsics3.checkNotNullExpressionValue(simpleDraweeView2, "itemBinding.pileItemImage");
                        simpleDraweeView2.setVisibility(strInvoke != null ? 0 : 8);
                        if (strInvoke != null) {
                            Intrinsics3.checkNotNullExpressionValue(simpleDraweeView2, "itemBinding.pileItemImage");
                            MGImages.setImage$default(simpleDraweeView2, strInvoke, 0, 0, true, null, null, 108, null);
                        }
                        i2 = i3;
                        z2 = false;
                    } else {
                        i6 = R.id.pileItemInitials;
                    }
                }
            }
            throw new NullPointerException("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i6)));
        }
        if (size > 0) {
            int i10 = this.maxItems - 1;
            int i11 = this.itemSizePx * i10;
            int i12 = i10 * this.overlapPx;
            View viewInflate2 = LayoutInflater.from(getContext()).inflate(R.layout.pile_item_overflow_view, (ViewGroup) this, false);
            TextView textView2 = (TextView) viewInflate2.findViewById(R.id.pile_item_text);
            if (textView2 == null) {
                throw new NullPointerException("Missing required view with ID: ".concat(viewInflate2.getResources().getResourceName(R.id.pile_item_text)));
            }
            CutoutView cutoutView2 = (CutoutView) viewInflate2;
            Intrinsics3.checkNotNullExpressionValue(new PileItemOverflowViewBinding(cutoutView2, textView2), "PileItemOverflowViewBind…om(context), this, false)");
            cutoutView2.setId(FrameLayout.generateViewId());
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, this.itemSizePx);
            layoutParams2.setMarginStart(i11 - i12);
            cutoutView2.setLayoutParams(layoutParams2);
            Intrinsics3.checkNotNullExpressionValue(textView2, "overflowItemBinding.pileItemText");
            StringBuilder sb = new StringBuilder();
            sb.append('+');
            sb.append(size);
            textView2.setText(sb.toString());
            textView2.setTextSize(0, this.overflowTextSizePx);
            Intrinsics3.checkNotNullExpressionValue(cutoutView2, "overflowItemBinding.root");
            addView(cutoutView2, cutoutView2.getLayoutParams());
            Intrinsics3.checkNotNullExpressionValue(textView2, "overflowItemBinding.pileItemText");
            MaterialShapeDrawable materialShapeDrawable = new MaterialShapeDrawable(new ShapeAppearanceModel.Builder().setAllCornerSizes(ShapeAppearanceModel.PILL).build());
            int i13 = this.overflowBackgroundColor;
            if (i13 == 0) {
                i13 = this.itemBackgroundColor;
            }
            materialShapeDrawable.setFillColor(ColorStateList.valueOf(i13));
            textView2.setBackground(materialShapeDrawable);
        }
    }
}
