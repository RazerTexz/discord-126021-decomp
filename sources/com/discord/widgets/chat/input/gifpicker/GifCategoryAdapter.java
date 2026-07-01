package com.discord.widgets.chat.input.gifpicker;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView$Adapter;
import androidx.recyclerview.widget.RecyclerView$ViewHolder;
import com.discord.R$id;
import com.discord.R$layout;
import com.discord.app.AppComponent;
import com.discord.databinding.GifCategoryItemViewBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.recycler.DiffCreator;
import com.facebook.drawee.view.SimpleDraweeView;
import d0.t.n;
import d0.z.d.m;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: GifCategoryAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class GifCategoryAdapter extends RecyclerView$Adapter<GifCategoryViewHolder> {
    private final DiffCreator<List<GifCategoryItem>, GifCategoryViewHolder> diffCreator;
    private List<? extends GifCategoryItem> items;
    private final Function1<GifCategoryItem, Unit> onSelectGifCategory;

    public /* synthetic */ GifCategoryAdapter(AppComponent appComponent, Function1 function1, DiffCreator diffCreator, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(appComponent, function1, (i & 4) != 0 ? new DiffCreator(appComponent) : diffCreator);
    }

    public static final /* synthetic */ List access$getItems$p(GifCategoryAdapter gifCategoryAdapter) {
        return gifCategoryAdapter.items;
    }

    public static final /* synthetic */ void access$setItems$p(GifCategoryAdapter gifCategoryAdapter, List list) {
        gifCategoryAdapter.items = list;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$Adapter
    public int getItemCount() {
        return this.items.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView$Adapter
    public /* bridge */ /* synthetic */ void onBindViewHolder(RecyclerView$ViewHolder recyclerView$ViewHolder, int i) {
        onBindViewHolder((GifCategoryViewHolder) recyclerView$ViewHolder, i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$Adapter
    public /* bridge */ /* synthetic */ RecyclerView$ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return onCreateViewHolder(viewGroup, i);
    }

    public final void setItems(List<? extends GifCategoryItem> newItems) {
        m.checkNotNullParameter(newItems, "newItems");
        this.diffCreator.dispatchDiffUpdatesAsync(this, new GifCategoryAdapter$setItems$1(this), this.items, newItems);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public GifCategoryAdapter(AppComponent appComponent, Function1<? super GifCategoryItem, Unit> function1, DiffCreator<List<GifCategoryItem>, GifCategoryViewHolder> diffCreator) {
        m.checkNotNullParameter(appComponent, "appComponent");
        m.checkNotNullParameter(diffCreator, "diffCreator");
        this.onSelectGifCategory = function1;
        this.diffCreator = diffCreator;
        this.items = n.emptyList();
    }

    public void onBindViewHolder(GifCategoryViewHolder holder, int position) {
        m.checkNotNullParameter(holder, "holder");
        holder.configure(this.items.get(position), this.onSelectGifCategory);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$Adapter
    public GifCategoryViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        m.checkNotNullParameter(parent, "parent");
        View viewInflate = LayoutInflater.from(parent.getContext()).inflate(R$layout.gif_category_item_view, parent, false);
        int i = R$id.gif_category_item_icon;
        ImageView imageView = (ImageView) viewInflate.findViewById(R$id.gif_category_item_icon);
        if (imageView != null) {
            i = R$id.gif_category_item_preview;
            SimpleDraweeView simpleDraweeView = (SimpleDraweeView) viewInflate.findViewById(R$id.gif_category_item_preview);
            if (simpleDraweeView != null) {
                i = R$id.gif_category_item_title;
                TextView textView = (TextView) viewInflate.findViewById(R$id.gif_category_item_title);
                if (textView != null) {
                    GifCategoryItemViewBinding gifCategoryItemViewBinding = new GifCategoryItemViewBinding((CardView) viewInflate, imageView, simpleDraweeView, textView);
                    m.checkNotNullExpressionValue(gifCategoryItemViewBinding, "GifCategoryItemViewBindi….context), parent, false)");
                    return new GifCategoryViewHolder(gifCategoryItemViewBinding);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i)));
    }
}
