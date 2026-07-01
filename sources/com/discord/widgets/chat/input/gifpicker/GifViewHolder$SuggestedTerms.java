package com.discord.widgets.chat.input.gifpicker;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager$LayoutParams;
import b.a.i.q;
import b.a.k.b;
import com.discord.R$layout;
import com.discord.databinding.GifSuggestedTermViewBinding;
import com.discord.utilities.dimen.DimenUtils;
import com.discord.utilities.drawable.DrawableCompat;
import com.google.android.flexbox.FlexboxLayout;
import d0.z.d.m;
import java.util.List;
import java.util.Objects;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: GifViewHolder.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class GifViewHolder$SuggestedTerms extends GifViewHolder {
    private final GifSuggestedTermViewBinding binding;

    /* JADX WARN: Illegal instructions before constructor call */
    public GifViewHolder$SuggestedTerms(GifSuggestedTermViewBinding gifSuggestedTermViewBinding) {
        m.checkNotNullParameter(gifSuggestedTermViewBinding, "binding");
        LinearLayout linearLayout = gifSuggestedTermViewBinding.a;
        m.checkNotNullExpressionValue(linearLayout, "binding.root");
        super(linearLayout, null);
        this.binding = gifSuggestedTermViewBinding;
    }

    private final void configureSearchTerms(GifAdapterItem$SuggestedTermsItem termsItem, Function1<? super String, Unit> onTermSelected, int layoutHeight) {
        List<String> terms = termsItem.getTerms();
        TextView textView = this.binding.c;
        m.checkNotNullExpressionValue(textView, "binding.gifSearchSuggestedTermsIconText");
        b.n(textView, termsItem.getTitleResId(), new Object[0], null, 4);
        int size = terms.size();
        if (size > 0) {
            for (int i = 0; i < size; i++) {
                FlexboxLayout flexboxLayout = this.binding.f2113b;
                m.checkNotNullExpressionValue(flexboxLayout, "binding.gifSearchSuggestedTermsFlexBox");
                int childCount = flexboxLayout.getChildCount();
                String str = terms.get(i);
                if (i >= childCount) {
                    LinearLayout linearLayout = this.binding.a;
                    m.checkNotNullExpressionValue(linearLayout, "binding.root");
                    View viewInflate = LayoutInflater.from(linearLayout.getContext()).inflate(R$layout.gif_search_empty_state_text_box_view, (ViewGroup) this.binding.f2113b, false);
                    Objects.requireNonNull(viewInflate, "rootView");
                    TextView textView2 = (TextView) viewInflate;
                    m.checkNotNullExpressionValue(new q(textView2), "GifSearchEmptyStateTextB…      false\n            )");
                    m.checkNotNullExpressionValue(textView2, "GifSearchEmptyStateTextB… false\n            ).root");
                    this.binding.f2113b.addView(textView2, i);
                }
                View childAt = this.binding.f2113b.getChildAt(i);
                Objects.requireNonNull(childAt, "null cannot be cast to non-null type android.widget.TextView");
                TextView textView3 = (TextView) childAt;
                textView3.setText(str);
                textView3.setOnClickListener(new GifViewHolder$SuggestedTerms$configureSearchTerms$1(onTermSelected, str));
            }
        }
        FlexboxLayout flexboxLayout2 = this.binding.f2113b;
        m.checkNotNullExpressionValue(flexboxLayout2, "binding.gifSearchSuggestedTermsFlexBox");
        if (size < flexboxLayout2.getChildCount()) {
            FlexboxLayout flexboxLayout3 = this.binding.f2113b;
            m.checkNotNullExpressionValue(flexboxLayout3, "binding.gifSearchSuggestedTermsFlexBox");
            if (flexboxLayout3.getChildCount() > 0) {
                FlexboxLayout flexboxLayout4 = this.binding.f2113b;
                m.checkNotNullExpressionValue(flexboxLayout4, "binding.gifSearchSuggestedTermsFlexBox");
                int childCount2 = flexboxLayout4.getChildCount() - 1;
                if (childCount2 >= size) {
                    while (true) {
                        this.binding.f2113b.removeViewAt(childCount2);
                        if (childCount2 == size) {
                            break;
                        } else {
                            childCount2--;
                        }
                    }
                }
            }
        }
        StaggeredGridLayoutManager$LayoutParams staggeredGridLayoutManager$LayoutParams = new StaggeredGridLayoutManager$LayoutParams(-1, layoutHeight);
        staggeredGridLayoutManager$LayoutParams.setFullSpan(true);
        View view = this.itemView;
        m.checkNotNullExpressionValue(view, "itemView");
        view.setLayoutParams(staggeredGridLayoutManager$LayoutParams);
    }

    public final void configure(GifAdapterItem$SuggestedTermsItem$SuggestedTermsEmptyResults termsItem, Function1<? super String, Unit> onTermSelected) {
        m.checkNotNullParameter(termsItem, "termsItem");
        TextView textView = this.binding.c;
        m.checkNotNullExpressionValue(textView, "binding.gifSearchSuggestedTermsIconText");
        View view = this.itemView;
        m.checkNotNullExpressionValue(view, "itemView");
        DrawableCompat.setCompoundDrawablesCompat$default(textView, 0, DrawableCompat.getThemedDrawableRes$default(view, 2130970296, 0, 2, (Object) null), 0, 0, 13, (Object) null);
        configureSearchTerms(termsItem, onTermSelected, -1);
        View view2 = this.itemView;
        m.checkNotNullExpressionValue(view2, "itemView");
        view2.setPadding(view2.getPaddingLeft(), 0, view2.getPaddingRight(), 0);
    }

    public final void configure(GifAdapterItem$SuggestedTermsItem$SuggestedTermsNonEmptyResults termsItem, Function1<? super String, Unit> onTermSelected) {
        m.checkNotNullParameter(termsItem, "termsItem");
        TextView textView = this.binding.c;
        m.checkNotNullExpressionValue(textView, "binding.gifSearchSuggestedTermsIconText");
        DrawableCompat.setCompoundDrawablesCompat$default(textView, (Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null, 13, (Object) null);
        configureSearchTerms(termsItem, onTermSelected, -2);
        View view = this.itemView;
        m.checkNotNullExpressionValue(view, "itemView");
        view.setPadding(view.getPaddingLeft(), DimenUtils.dpToPixels(32), view.getPaddingRight(), DimenUtils.dpToPixels(40));
    }
}
