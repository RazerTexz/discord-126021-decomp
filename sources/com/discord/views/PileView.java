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
import com.discord.C5419R;
import com.discord.utilities.dimen.DimenUtils;
import com.discord.utilities.icon.IconUtils;
import com.discord.utilities.images.MGImages;
import com.discord.views.CutoutView;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.ShapeAppearanceModel;
import java.util.Collection;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import p007b.p008a.p025i.C0929c1;
import p007b.p008a.p025i.C1068v2;
import p507d0.p580t.C12147n;
import p507d0.p580t.C12163u;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

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

    /* JADX INFO: renamed from: s, reason: from kotlin metadata */
    public final CutoutView.InterfaceC7075a cutoutStyle;

    /* JADX INFO: renamed from: t, reason: from kotlin metadata */
    public int overflowTextSizePx;

    /* JADX INFO: renamed from: u, reason: from kotlin metadata */
    public boolean showOverFlowItem;

    /* JADX INFO: renamed from: v, reason: from kotlin metadata */
    @ColorInt
    public int overflowBackgroundColor;

    /* JADX INFO: renamed from: com.discord.views.PileView$a */
    /* JADX INFO: compiled from: kotlin-style lambda group */
    public static final class C7087a extends AbstractC12240o implements Function1<Integer, String> {

        /* JADX INFO: renamed from: j */
        public static final C7087a f19119j = new C7087a(0);

        /* JADX INFO: renamed from: k */
        public static final C7087a f19120k = new C7087a(1);

        /* JADX INFO: renamed from: l */
        public static final C7087a f19121l = new C7087a(2);

        /* JADX INFO: renamed from: m */
        public final /* synthetic */ int f19122m;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C7087a(int i) {
            super(1);
            this.f19122m = i;
        }

        @Override // kotlin.jvm.functions.Function1
        public final String invoke(Integer num) {
            int i = this.f19122m;
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

    /* JADX INFO: renamed from: com.discord.views.PileView$b */
    /* JADX INFO: compiled from: kotlin-style lambda group */
    public static final class C7088b extends AbstractC12240o implements Function0<String> {

        /* JADX INFO: renamed from: j */
        public static final C7088b f19123j = new C7088b(0);

        /* JADX INFO: renamed from: k */
        public static final C7088b f19124k = new C7088b(1);

        /* JADX INFO: renamed from: l */
        public static final C7088b f19125l = new C7088b(2);

        /* JADX INFO: renamed from: m */
        public final /* synthetic */ int f19126m;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C7088b(int i) {
            super(0);
            this.f19126m = i;
        }

        @Override // kotlin.jvm.functions.Function0
        public final String invoke() {
            int i = this.f19126m;
            if (i == 0 || i == 1 || i == 2) {
                return "";
            }
            throw null;
        }
    }

    /* JADX INFO: renamed from: com.discord.views.PileView$c */
    /* JADX INFO: compiled from: PileView.kt */
    public static final class C7089c {

        /* JADX INFO: renamed from: a */
        public final Function1<Integer, String> f19127a;

        /* JADX INFO: renamed from: b */
        public final Function0<String> f19128b;

        /* JADX WARN: Multi-variable type inference failed */
        public C7089c(Function1<? super Integer, String> function1, Function0<String> function0) {
            C12238m.checkNotNullParameter(function1, "getImageURI");
            this.f19127a = function1;
            this.f19128b = function0;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PileView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        C12238m.checkNotNullParameter(context, "context");
        this.maxItems = 3;
        this.doRoundItem = true;
        this.doRoundBg = true;
        this.itemSizePx = DimenUtils.dpToPixels(16);
        this.cutoutThicknessPx = DimenUtils.dpToPixels(2);
        this.overflowTextSizePx = DimenUtils.dpToPixels(14);
        int[] iArr = C5419R.a.PileView;
        C12238m.checkNotNullExpressionValue(iArr, "R.styleable.PileView");
        Context context2 = getContext();
        C12238m.checkNotNullExpressionValue(context2, "context");
        TypedArray typedArrayObtainStyledAttributes = context2.obtainStyledAttributes(attributeSet, iArr);
        C12238m.checkNotNullExpressionValue(typedArrayObtainStyledAttributes, "obtainStyledAttributes(attrs, styleable)");
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
        this.cutoutStyle = new CutoutView.InterfaceC7075a.b(i + i3, i2 + i3);
        if (isInEditMode()) {
            setItems(C12147n.listOf((Object[]) new C7089c[]{new C7089c(C7087a.f19119j, C7088b.f19123j), new C7089c(C7087a.f19120k, C7088b.f19124k), new C7089c(C7087a.f19121l, C7088b.f19125l)}));
        }
    }

    public final void setItems(Collection<C7089c> items) {
        C12238m.checkNotNullParameter(items, "items");
        removeAllViews();
        boolean z2 = false;
        int size = items.size() > this.maxItems ? (items.size() - this.maxItems) + 1 : 0;
        int size2 = size > 0 ? this.maxItems - 1 : items.size();
        int i = size2 - 1;
        int i2 = 0;
        for (Object obj : C12163u.take(items, size2)) {
            int i3 = i2 + 1;
            if (i2 < 0) {
                C12147n.throwIndexOverflow();
            }
            C7089c c7089c = (C7089c) obj;
            int i4 = this.itemSizePx * i2;
            int i5 = this.overlapPx * i2;
            View viewInflate = LayoutInflater.from(getContext()).inflate(C5419R.layout.view_pile_item, this, z2);
            int i6 = C5419R.id.pileItemBg;
            SimpleDraweeView simpleDraweeView = (SimpleDraweeView) viewInflate.findViewById(C5419R.id.pileItemBg);
            if (simpleDraweeView != null) {
                i6 = C5419R.id.pileItemImage;
                SimpleDraweeView simpleDraweeView2 = (SimpleDraweeView) viewInflate.findViewById(C5419R.id.pileItemImage);
                if (simpleDraweeView2 != null) {
                    TextView textView = (TextView) viewInflate.findViewById(C5419R.id.pileItemInitials);
                    if (textView != null) {
                        CutoutView cutoutView = (CutoutView) viewInflate;
                        C12238m.checkNotNullExpressionValue(new C1068v2(cutoutView, simpleDraweeView, simpleDraweeView2, textView), "ViewPileItemBinding.infl…om(context), this, false)");
                        cutoutView.setId(FrameLayout.generateViewId());
                        int i7 = this.itemSizePx;
                        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i7, i7);
                        layoutParams.setMarginStart(i4 - i5);
                        cutoutView.setLayoutParams(layoutParams);
                        C12238m.checkNotNullExpressionValue(cutoutView, "itemBinding.root");
                        addView(cutoutView, cutoutView.getLayoutParams());
                        C12238m.checkNotNullExpressionValue(simpleDraweeView2, "itemBinding.pileItemImage");
                        int i8 = this.itemPaddingPx;
                        simpleDraweeView2.setPadding(i8, i8, i8, i8);
                        if (!this.doRoundItem) {
                            C12238m.checkNotNullExpressionValue(simpleDraweeView2, "itemBinding.pileItemImage");
                            GenericDraweeHierarchy hierarchy = simpleDraweeView2.getHierarchy();
                            C12238m.checkNotNullExpressionValue(hierarchy, "itemBinding.pileItemImage.hierarchy");
                            hierarchy.m8683s(null);
                        }
                        if (!this.doRoundBg) {
                            C12238m.checkNotNullExpressionValue(simpleDraweeView, "itemBinding.pileItemBg");
                            GenericDraweeHierarchy hierarchy2 = simpleDraweeView.getHierarchy();
                            C12238m.checkNotNullExpressionValue(hierarchy2, "itemBinding.pileItemBg.hierarchy");
                            hierarchy2.m8683s(null);
                        }
                        if (this.itemBackgroundColor != 0) {
                            C12238m.checkNotNullExpressionValue(simpleDraweeView, "itemBinding.pileItemBg");
                            simpleDraweeView.getHierarchy().m8679o(1, new ColorDrawable(this.itemBackgroundColor));
                            C12238m.checkNotNullExpressionValue(simpleDraweeView, "itemBinding.pileItemBg");
                            simpleDraweeView.setVisibility(0);
                        }
                        if (i2 != i || size > 0) {
                            cutoutView.setStyle(this.cutoutStyle);
                        }
                        String strInvoke = c7089c.f19127a.invoke(Integer.valueOf(IconUtils.getMediaProxySize(this.itemSizePx)));
                        Function0<String> function0 = c7089c.f19128b;
                        String strInvoke2 = function0 != null ? function0.invoke() : null;
                        C12238m.checkNotNullExpressionValue(textView, "itemBinding.pileItemInitials");
                        textView.setVisibility(strInvoke == null ? 0 : 8);
                        C12238m.checkNotNullExpressionValue(textView, "itemBinding.pileItemInitials");
                        textView.setText(strInvoke2);
                        int i9 = this.itemTextColor;
                        if (i9 != 0) {
                            textView.setTextColor(i9);
                        }
                        C12238m.checkNotNullExpressionValue(simpleDraweeView2, "itemBinding.pileItemImage");
                        simpleDraweeView2.setVisibility(strInvoke != null ? 0 : 8);
                        if (strInvoke != null) {
                            C12238m.checkNotNullExpressionValue(simpleDraweeView2, "itemBinding.pileItemImage");
                            MGImages.setImage$default(simpleDraweeView2, strInvoke, 0, 0, true, null, null, 108, null);
                        }
                        i2 = i3;
                        z2 = false;
                    } else {
                        i6 = C5419R.id.pileItemInitials;
                    }
                }
            }
            throw new NullPointerException("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i6)));
        }
        if (size > 0) {
            int i10 = this.maxItems - 1;
            int i11 = this.itemSizePx * i10;
            int i12 = i10 * this.overlapPx;
            View viewInflate2 = LayoutInflater.from(getContext()).inflate(C5419R.layout.pile_item_overflow_view, (ViewGroup) this, false);
            TextView textView2 = (TextView) viewInflate2.findViewById(C5419R.id.pile_item_text);
            if (textView2 == null) {
                throw new NullPointerException("Missing required view with ID: ".concat(viewInflate2.getResources().getResourceName(C5419R.id.pile_item_text)));
            }
            CutoutView cutoutView2 = (CutoutView) viewInflate2;
            C12238m.checkNotNullExpressionValue(new C0929c1(cutoutView2, textView2), "PileItemOverflowViewBind…om(context), this, false)");
            cutoutView2.setId(FrameLayout.generateViewId());
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, this.itemSizePx);
            layoutParams2.setMarginStart(i11 - i12);
            cutoutView2.setLayoutParams(layoutParams2);
            C12238m.checkNotNullExpressionValue(textView2, "overflowItemBinding.pileItemText");
            StringBuilder sb = new StringBuilder();
            sb.append('+');
            sb.append(size);
            textView2.setText(sb.toString());
            textView2.setTextSize(0, this.overflowTextSizePx);
            C12238m.checkNotNullExpressionValue(cutoutView2, "overflowItemBinding.root");
            addView(cutoutView2, cutoutView2.getLayoutParams());
            C12238m.checkNotNullExpressionValue(textView2, "overflowItemBinding.pileItemText");
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
