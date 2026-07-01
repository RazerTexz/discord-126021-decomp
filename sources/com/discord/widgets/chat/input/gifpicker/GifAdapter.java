package com.discord.widgets.chat.input.gifpicker;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView$Adapter;
import androidx.recyclerview.widget.RecyclerView$ViewHolder;
import com.discord.R$id;
import com.discord.R$layout;
import com.discord.app.AppComponent;
import com.discord.databinding.GifItemViewBinding;
import com.discord.databinding.GifSuggestedTermViewBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.recycler.DiffCreator;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.android.flexbox.FlexboxLayout;
import d0.t.n;
import d0.z.d.m;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: GifAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class GifAdapter extends RecyclerView$Adapter<GifViewHolder> {
    public static final GifAdapter$Companion Companion = new GifAdapter$Companion(null);
    private static final int DEFAULT_COLUMN_COUNT = 2;
    private static final int MIN_COLUMN_WIDTH_DP = 164;
    private final int columnWidthPx;
    private final DiffCreator<List<GifAdapterItem>, GifViewHolder> diffCreator;
    private List<? extends GifAdapterItem> items;
    private final Function1<GifAdapterItem$GifItem, Unit> onSelectGif;
    private final Function1<String, Unit> onSelectSuggestedTerm;

    public /* synthetic */ GifAdapter(AppComponent appComponent, Function1 function1, int i, Function1 function2, DiffCreator diffCreator, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(appComponent, (i2 & 2) != 0 ? null : function1, i, (i2 & 8) != 0 ? null : function2, (i2 & 16) != 0 ? new DiffCreator(appComponent) : diffCreator);
    }

    public static final /* synthetic */ List access$getItems$p(GifAdapter gifAdapter) {
        return gifAdapter.items;
    }

    public static final /* synthetic */ void access$setItems$p(GifAdapter gifAdapter, List list) {
        gifAdapter.items = list;
    }

    public final void clearItems() {
        setItems(n.emptyList());
    }

    @Override // androidx.recyclerview.widget.RecyclerView$Adapter
    public int getItemCount() {
        return this.items.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView$Adapter
    public int getItemViewType(int position) {
        return this.items.get(position).getType().ordinal();
    }

    @Override // androidx.recyclerview.widget.RecyclerView$Adapter
    public /* bridge */ /* synthetic */ void onBindViewHolder(RecyclerView$ViewHolder recyclerView$ViewHolder, int i) {
        onBindViewHolder((GifViewHolder) recyclerView$ViewHolder, i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$Adapter
    public /* bridge */ /* synthetic */ RecyclerView$ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return onCreateViewHolder(viewGroup, i);
    }

    public final void setItems(List<? extends GifAdapterItem> newItems) {
        m.checkNotNullParameter(newItems, "newItems");
        this.diffCreator.dispatchDiffUpdatesAsync(this, new GifAdapter$setItems$1(this), this.items, newItems);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public GifAdapter(AppComponent appComponent, Function1<? super GifAdapterItem$GifItem, Unit> function1, int i, Function1<? super String, Unit> function2, DiffCreator<List<GifAdapterItem>, GifViewHolder> diffCreator) {
        m.checkNotNullParameter(appComponent, "appComponent");
        m.checkNotNullParameter(diffCreator, "diffCreator");
        this.onSelectGif = function1;
        this.columnWidthPx = i;
        this.onSelectSuggestedTerm = function2;
        this.diffCreator = diffCreator;
        this.items = n.emptyList();
    }

    public void onBindViewHolder(GifViewHolder holder, int position) {
        m.checkNotNullParameter(holder, "holder");
        GifAdapterItem gifAdapterItem = this.items.get(position);
        if (gifAdapterItem instanceof GifAdapterItem$GifItem) {
            ((GifViewHolder$Gif) holder).configure((GifAdapterItem$GifItem) gifAdapterItem, this.columnWidthPx, this.onSelectGif);
        } else if (gifAdapterItem instanceof GifAdapterItem$SuggestedTermsItem$SuggestedTermsEmptyResults) {
            ((GifViewHolder$SuggestedTerms) holder).configure((GifAdapterItem$SuggestedTermsItem$SuggestedTermsEmptyResults) gifAdapterItem, this.onSelectSuggestedTerm);
        } else if (gifAdapterItem instanceof GifAdapterItem$SuggestedTermsItem$SuggestedTermsNonEmptyResults) {
            ((GifViewHolder$SuggestedTerms) holder).configure((GifAdapterItem$SuggestedTermsItem$SuggestedTermsNonEmptyResults) gifAdapterItem, this.onSelectSuggestedTerm);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView$Adapter
    public GifViewHolder onCreateViewHolder(ViewGroup parent, int viewTypeInt) {
        GifViewHolder gifViewHolder$Gif;
        m.checkNotNullParameter(parent, "parent");
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(parent.getContext());
        int iOrdinal = GifAdapterItem$ViewType.Companion.fromInt(viewTypeInt).ordinal();
        if (iOrdinal != 0) {
            if (iOrdinal != 1 && iOrdinal != 2) {
                throw new NoWhenBranchMatchedException();
            }
            View viewInflate = layoutInflaterFrom.inflate(R$layout.gif_suggested_term_view, parent, false);
            LinearLayout linearLayout = (LinearLayout) viewInflate;
            int i = R$id.gif_search_suggested_terms_flex_box;
            FlexboxLayout flexboxLayout = (FlexboxLayout) viewInflate.findViewById(R$id.gif_search_suggested_terms_flex_box);
            if (flexboxLayout != null) {
                i = R$id.gif_search_suggested_terms_icon_text;
                TextView textView = (TextView) viewInflate.findViewById(R$id.gif_search_suggested_terms_icon_text);
                if (textView != null) {
                    GifSuggestedTermViewBinding gifSuggestedTermViewBinding = new GifSuggestedTermViewBinding((LinearLayout) viewInflate, linearLayout, flexboxLayout, textView);
                    m.checkNotNullExpressionValue(gifSuggestedTermViewBinding, "GifSuggestedTermViewBind…(inflater, parent, false)");
                    gifViewHolder$Gif = new GifViewHolder$SuggestedTerms(gifSuggestedTermViewBinding);
                }
            }
            throw new NullPointerException("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i)));
        }
        View viewInflate2 = layoutInflaterFrom.inflate(R$layout.gif_item_view, parent, false);
        SimpleDraweeView simpleDraweeView = (SimpleDraweeView) viewInflate2.findViewById(R$id.gif_item_image);
        if (simpleDraweeView == null) {
            throw new NullPointerException("Missing required view with ID: ".concat(viewInflate2.getResources().getResourceName(R$id.gif_item_image)));
        }
        GifItemViewBinding gifItemViewBinding = new GifItemViewBinding((CardView) viewInflate2, simpleDraweeView);
        m.checkNotNullExpressionValue(gifItemViewBinding, "GifItemViewBinding.infla…(inflater, parent, false)");
        gifViewHolder$Gif = new GifViewHolder$Gif(gifItemViewBinding);
        return gifViewHolder$Gif;
    }
}
