package com.discord.widgets.chat.input.gifpicker;

import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.core.view.MarginLayoutParamsCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.R;
import com.discord.app.AppComponent;
import com.discord.databinding.GifItemViewBinding;
import com.discord.databinding.GifSuggestedTermViewBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.dimen.DimenUtils;
import com.discord.utilities.recycler.DiffCreator;
import com.discord.widgets.chat.input.gifpicker.GifAdapterItem;
import com.discord.widgets.chat.input.gifpicker.GifViewHolder;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.android.flexbox.FlexboxLayout;
import d0.t.Collections2;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: GifAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class GifAdapter extends RecyclerView.Adapter<GifViewHolder> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final int DEFAULT_COLUMN_COUNT = 2;
    private static final int MIN_COLUMN_WIDTH_DP = 164;
    private final int columnWidthPx;
    private final DiffCreator<List<GifAdapterItem>, GifViewHolder> diffCreator;
    private List<? extends GifAdapterItem> items;
    private final Function1<GifAdapterItem.GifItem, Unit> onSelectGif;
    private final Function1<String, Unit> onSelectSuggestedTerm;

    /* JADX INFO: compiled from: GifAdapter.kt */
    public static final class Companion {
        private Companion() {
        }

        public final int calculateColumnCount(RecyclerView recyclerView) {
            Intrinsics3.checkNotNullParameter(recyclerView, "recyclerView");
            Resources resources = recyclerView.getResources();
            Intrinsics3.checkNotNullExpressionValue(resources, "recyclerView.resources");
            return Math.max(2, Math.max(resources.getDisplayMetrics().widthPixels, 1) / DimenUtils.dpToPixels(164));
        }

        public final int calculateColumnWidth(RecyclerView recyclerView, int numColumns, int columnSpacePx) {
            Intrinsics3.checkNotNullParameter(recyclerView, "recyclerView");
            Resources resources = recyclerView.getResources();
            Intrinsics3.checkNotNullExpressionValue(resources, "resources");
            int i = resources.getDisplayMetrics().widthPixels;
            ViewGroup.LayoutParams layoutParams = recyclerView.getLayoutParams();
            int marginStart = i - (layoutParams instanceof ViewGroup.MarginLayoutParams ? MarginLayoutParamsCompat.getMarginStart((ViewGroup.MarginLayoutParams) layoutParams) : 0);
            ViewGroup.LayoutParams layoutParams2 = recyclerView.getLayoutParams();
            return (int) (((((marginStart - (layoutParams2 instanceof ViewGroup.MarginLayoutParams ? MarginLayoutParamsCompat.getMarginEnd((ViewGroup.MarginLayoutParams) layoutParams2) : 0)) - recyclerView.getPaddingStart()) - recyclerView.getPaddingEnd()) - ((numColumns - 1) * columnSpacePx)) / numColumns);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            GifAdapterItem.ViewType.values();
            int[] iArr = new int[3];
            $EnumSwitchMapping$0 = iArr;
            iArr[GifAdapterItem.ViewType.VIEW_TYPE_GIF_ITEM.ordinal()] = 1;
            iArr[GifAdapterItem.ViewType.VIEW_TYPE_GIF_SEARCH_TERMS_EMPTY_RESULTS.ordinal()] = 2;
            iArr[GifAdapterItem.ViewType.VIEW_TYPE_GIF_SEARCH_TERMS_NON_EMPTY_RESULTS.ordinal()] = 3;
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.chat.input.gifpicker.GifAdapter$setItems$1, reason: invalid class name */
    /* JADX INFO: compiled from: GifAdapter.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<List<? extends GifAdapterItem>, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(List<? extends GifAdapterItem> list) {
            invoke2(list);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(List<? extends GifAdapterItem> list) {
            Intrinsics3.checkNotNullParameter(list, "items");
            GifAdapter.this.items = list;
        }
    }

    public /* synthetic */ GifAdapter(AppComponent appComponent, Function1 function1, int i, Function1 function2, DiffCreator diffCreator, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(appComponent, (i2 & 2) != 0 ? null : function1, i, (i2 & 8) != 0 ? null : function2, (i2 & 16) != 0 ? new DiffCreator(appComponent) : diffCreator);
    }

    public final void clearItems() {
        setItems(Collections2.emptyList());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* JADX INFO: renamed from: getItemCount */
    public int getPageSize() {
        return this.items.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int position) {
        return this.items.get(position).getType().ordinal();
    }

    public final void setItems(List<? extends GifAdapterItem> newItems) {
        Intrinsics3.checkNotNullParameter(newItems, "newItems");
        this.diffCreator.dispatchDiffUpdatesAsync(this, new AnonymousClass1(), this.items, newItems);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public GifAdapter(AppComponent appComponent, Function1<? super GifAdapterItem.GifItem, Unit> function1, int i, Function1<? super String, Unit> function2, DiffCreator<List<GifAdapterItem>, GifViewHolder> diffCreator) {
        Intrinsics3.checkNotNullParameter(appComponent, "appComponent");
        Intrinsics3.checkNotNullParameter(diffCreator, "diffCreator");
        this.onSelectGif = function1;
        this.columnWidthPx = i;
        this.onSelectSuggestedTerm = function2;
        this.diffCreator = diffCreator;
        this.items = Collections2.emptyList();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(GifViewHolder holder, int position) {
        Intrinsics3.checkNotNullParameter(holder, "holder");
        GifAdapterItem gifAdapterItem = this.items.get(position);
        if (gifAdapterItem instanceof GifAdapterItem.GifItem) {
            ((GifViewHolder.Gif) holder).configure((GifAdapterItem.GifItem) gifAdapterItem, this.columnWidthPx, this.onSelectGif);
        } else if (gifAdapterItem instanceof GifAdapterItem.SuggestedTermsItem.SuggestedTermsEmptyResults) {
            ((GifViewHolder.SuggestedTerms) holder).configure((GifAdapterItem.SuggestedTermsItem.SuggestedTermsEmptyResults) gifAdapterItem, this.onSelectSuggestedTerm);
        } else if (gifAdapterItem instanceof GifAdapterItem.SuggestedTermsItem.SuggestedTermsNonEmptyResults) {
            ((GifViewHolder.SuggestedTerms) holder).configure((GifAdapterItem.SuggestedTermsItem.SuggestedTermsNonEmptyResults) gifAdapterItem, this.onSelectSuggestedTerm);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public GifViewHolder onCreateViewHolder(ViewGroup parent, int viewTypeInt) {
        GifViewHolder gif;
        Intrinsics3.checkNotNullParameter(parent, "parent");
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(parent.getContext());
        int iOrdinal = GifAdapterItem.ViewType.INSTANCE.fromInt(viewTypeInt).ordinal();
        if (iOrdinal != 0) {
            if (iOrdinal != 1 && iOrdinal != 2) {
                throw new NoWhenBranchMatchedException();
            }
            View viewInflate = layoutInflaterFrom.inflate(R.layout.gif_suggested_term_view, parent, false);
            LinearLayout linearLayout = (LinearLayout) viewInflate;
            int i = R.id.gif_search_suggested_terms_flex_box;
            FlexboxLayout flexboxLayout = (FlexboxLayout) viewInflate.findViewById(R.id.gif_search_suggested_terms_flex_box);
            if (flexboxLayout != null) {
                i = R.id.gif_search_suggested_terms_icon_text;
                TextView textView = (TextView) viewInflate.findViewById(R.id.gif_search_suggested_terms_icon_text);
                if (textView != null) {
                    GifSuggestedTermViewBinding gifSuggestedTermViewBinding = new GifSuggestedTermViewBinding((LinearLayout) viewInflate, linearLayout, flexboxLayout, textView);
                    Intrinsics3.checkNotNullExpressionValue(gifSuggestedTermViewBinding, "GifSuggestedTermViewBind…(inflater, parent, false)");
                    gif = new GifViewHolder.SuggestedTerms(gifSuggestedTermViewBinding);
                }
            }
            throw new NullPointerException("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i)));
        }
        View viewInflate2 = layoutInflaterFrom.inflate(R.layout.gif_item_view, parent, false);
        SimpleDraweeView simpleDraweeView = (SimpleDraweeView) viewInflate2.findViewById(R.id.gif_item_image);
        if (simpleDraweeView == null) {
            throw new NullPointerException("Missing required view with ID: ".concat(viewInflate2.getResources().getResourceName(R.id.gif_item_image)));
        }
        GifItemViewBinding gifItemViewBinding = new GifItemViewBinding((CardView) viewInflate2, simpleDraweeView);
        Intrinsics3.checkNotNullExpressionValue(gifItemViewBinding, "GifItemViewBinding.infla…(inflater, parent, false)");
        gif = new GifViewHolder.Gif(gifItemViewBinding);
        return gif;
    }
}
