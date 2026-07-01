package com.discord.widgets.chat.input.gifpicker;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import b.a.i.GifSearchEmptyStateTextBoxViewBinding;
import b.a.k.FormatUtils;
import com.discord.R;
import com.discord.databinding.GifItemViewBinding;
import com.discord.databinding.GifSuggestedTermViewBinding;
import com.discord.models.gifpicker.dto.ModelGif;
import com.discord.utilities.dimen.DimenUtils;
import com.discord.utilities.drawable.DrawableCompat;
import com.discord.utilities.icon.IconUtils;
import com.discord.utilities.images.MGImages;
import com.discord.widgets.chat.input.gifpicker.GifAdapterItem;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.android.flexbox.FlexboxLayout;
import d0.t.CollectionsJVM;
import d0.z.d.Intrinsics3;
import java.util.List;
import java.util.Objects;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: GifViewHolder.kt */
/* JADX INFO: loaded from: classes2.dex */
public abstract class GifViewHolder extends RecyclerView.ViewHolder {

    /* JADX INFO: compiled from: GifViewHolder.kt */
    public static final class Gif extends GifViewHolder {
        private final GifItemViewBinding binding;

        /* JADX WARN: Illegal instructions before constructor call */
        public Gif(GifItemViewBinding gifItemViewBinding) {
            Intrinsics3.checkNotNullParameter(gifItemViewBinding, "binding");
            CardView cardView = gifItemViewBinding.a;
            Intrinsics3.checkNotNullExpressionValue(cardView, "binding.root");
            super(cardView, null);
            this.binding = gifItemViewBinding;
            this.itemView.setOnTouchListener(new ViewScalingOnTouchListener(0.9f));
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void configure$default(Gif gif, GifAdapterItem.GifItem gifItem, int i, Function1 function1, int i2, Object obj) {
            if ((i2 & 4) != 0) {
                function1 = null;
            }
            gif.configure(gifItem, i, function1);
        }

        private final void setGifImage(ModelGif gif) {
            String gifImageUrl = gif.getGifImageUrl();
            SimpleDraweeView simpleDraweeView = this.binding.f2112b;
            Intrinsics3.checkNotNullExpressionValue(simpleDraweeView, "binding.gifItemImage");
            MGImages.setImage$default(simpleDraweeView, CollectionsJVM.listOf(gifImageUrl), 0, 0, false, null, null, null, 252, null);
        }

        public final void configure(final GifAdapterItem.GifItem gifItem, int columnWidthPx, final Function1<? super GifAdapterItem.GifItem, Unit> onSelectGif) {
            Intrinsics3.checkNotNullParameter(gifItem, "gifItem");
            ModelGif gif = gifItem.getGif();
            float height = columnWidthPx * (gif.getHeight() / gif.getWidth());
            CardView cardView = this.binding.a;
            Intrinsics3.checkNotNullExpressionValue(cardView, "binding.root");
            cardView.getLayoutParams().height = (int) height;
            setGifImage(gif);
            this.binding.a.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.chat.input.gifpicker.GifViewHolder$Gif$configure$1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    Function1 function1 = onSelectGif;
                    if (function1 != null) {
                    }
                }
            });
        }
    }

    private GifViewHolder(View view) {
        super(view);
    }

    public /* synthetic */ GifViewHolder(View view, DefaultConstructorMarker defaultConstructorMarker) {
        this(view);
    }

    /* JADX INFO: compiled from: GifViewHolder.kt */
    public static final class SuggestedTerms extends GifViewHolder {
        private final GifSuggestedTermViewBinding binding;

        /* JADX WARN: Illegal instructions before constructor call */
        public SuggestedTerms(GifSuggestedTermViewBinding gifSuggestedTermViewBinding) {
            Intrinsics3.checkNotNullParameter(gifSuggestedTermViewBinding, "binding");
            LinearLayout linearLayout = gifSuggestedTermViewBinding.a;
            Intrinsics3.checkNotNullExpressionValue(linearLayout, "binding.root");
            super(linearLayout, null);
            this.binding = gifSuggestedTermViewBinding;
        }

        private final void configureSearchTerms(GifAdapterItem.SuggestedTermsItem termsItem, final Function1<? super String, Unit> onTermSelected, int layoutHeight) {
            List<String> terms = termsItem.getTerms();
            TextView textView = this.binding.c;
            Intrinsics3.checkNotNullExpressionValue(textView, "binding.gifSearchSuggestedTermsIconText");
            FormatUtils.m(textView, termsItem.getTitleResId(), new Object[0], (4 & 4) != 0 ? FormatUtils.g.j : null);
            int size = terms.size();
            if (size > 0) {
                for (int i = 0; i < size; i++) {
                    FlexboxLayout flexboxLayout = this.binding.f2113b;
                    Intrinsics3.checkNotNullExpressionValue(flexboxLayout, "binding.gifSearchSuggestedTermsFlexBox");
                    int childCount = flexboxLayout.getChildCount();
                    final String str = terms.get(i);
                    if (i >= childCount) {
                        LinearLayout linearLayout = this.binding.a;
                        Intrinsics3.checkNotNullExpressionValue(linearLayout, "binding.root");
                        View viewInflate = LayoutInflater.from(linearLayout.getContext()).inflate(R.layout.gif_search_empty_state_text_box_view, (ViewGroup) this.binding.f2113b, false);
                        Objects.requireNonNull(viewInflate, "rootView");
                        TextView textView2 = (TextView) viewInflate;
                        Intrinsics3.checkNotNullExpressionValue(new GifSearchEmptyStateTextBoxViewBinding(textView2), "GifSearchEmptyStateTextB…      false\n            )");
                        Intrinsics3.checkNotNullExpressionValue(textView2, "GifSearchEmptyStateTextB… false\n            ).root");
                        this.binding.f2113b.addView(textView2, i);
                    }
                    View childAt = this.binding.f2113b.getChildAt(i);
                    Objects.requireNonNull(childAt, "null cannot be cast to non-null type android.widget.TextView");
                    TextView textView3 = (TextView) childAt;
                    textView3.setText(str);
                    textView3.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.chat.input.gifpicker.GifViewHolder$SuggestedTerms$configureSearchTerms$1
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            Function1 function1 = onTermSelected;
                            if (function1 != null) {
                            }
                        }
                    });
                }
            }
            FlexboxLayout flexboxLayout2 = this.binding.f2113b;
            Intrinsics3.checkNotNullExpressionValue(flexboxLayout2, "binding.gifSearchSuggestedTermsFlexBox");
            if (size < flexboxLayout2.getChildCount()) {
                FlexboxLayout flexboxLayout3 = this.binding.f2113b;
                Intrinsics3.checkNotNullExpressionValue(flexboxLayout3, "binding.gifSearchSuggestedTermsFlexBox");
                if (flexboxLayout3.getChildCount() > 0) {
                    FlexboxLayout flexboxLayout4 = this.binding.f2113b;
                    Intrinsics3.checkNotNullExpressionValue(flexboxLayout4, "binding.gifSearchSuggestedTermsFlexBox");
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
            StaggeredGridLayoutManager.LayoutParams layoutParams = new StaggeredGridLayoutManager.LayoutParams(-1, layoutHeight);
            layoutParams.setFullSpan(true);
            View view = this.itemView;
            Intrinsics3.checkNotNullExpressionValue(view, "itemView");
            view.setLayoutParams(layoutParams);
        }

        public final void configure(GifAdapterItem.SuggestedTermsItem.SuggestedTermsEmptyResults termsItem, Function1<? super String, Unit> onTermSelected) {
            Intrinsics3.checkNotNullParameter(termsItem, "termsItem");
            TextView textView = this.binding.c;
            Intrinsics3.checkNotNullExpressionValue(textView, "binding.gifSearchSuggestedTermsIconText");
            View view = this.itemView;
            Intrinsics3.checkNotNullExpressionValue(view, "itemView");
            DrawableCompat.setCompoundDrawablesCompat$default(textView, 0, DrawableCompat.getThemedDrawableRes$default(view, R.attr.theme_expression_tray_search_icon_empty, 0, 2, (Object) null), 0, 0, 13, (Object) null);
            configureSearchTerms(termsItem, onTermSelected, -1);
            View view2 = this.itemView;
            Intrinsics3.checkNotNullExpressionValue(view2, "itemView");
            view2.setPadding(view2.getPaddingLeft(), 0, view2.getPaddingRight(), 0);
        }

        public final void configure(GifAdapterItem.SuggestedTermsItem.SuggestedTermsNonEmptyResults termsItem, Function1<? super String, Unit> onTermSelected) {
            Intrinsics3.checkNotNullParameter(termsItem, "termsItem");
            TextView textView = this.binding.c;
            Intrinsics3.checkNotNullExpressionValue(textView, "binding.gifSearchSuggestedTermsIconText");
            DrawableCompat.setCompoundDrawablesCompat$default(textView, (Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null, 13, (Object) null);
            configureSearchTerms(termsItem, onTermSelected, -2);
            View view = this.itemView;
            Intrinsics3.checkNotNullExpressionValue(view, "itemView");
            view.setPadding(view.getPaddingLeft(), DimenUtils.dpToPixels(32), view.getPaddingRight(), DimenUtils.dpToPixels(40));
        }
    }
}
