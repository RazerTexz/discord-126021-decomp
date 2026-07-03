package com.discord.widgets.chat.input.gifpicker;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.C5419R;
import com.discord.app.AppComponent;
import com.discord.databinding.GifCategoryItemViewBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.recycler.DiffCreator;
import com.facebook.drawee.view.SimpleDraweeView;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p507d0.p580t.C12147n;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: GifCategoryAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class GifCategoryAdapter extends RecyclerView.Adapter<GifCategoryViewHolder> {
    private final DiffCreator<List<GifCategoryItem>, GifCategoryViewHolder> diffCreator;
    private List<? extends GifCategoryItem> items;
    private final Function1<GifCategoryItem, Unit> onSelectGifCategory;

    /* JADX INFO: renamed from: com.discord.widgets.chat.input.gifpicker.GifCategoryAdapter$setItems$1 */
    /* JADX INFO: compiled from: GifCategoryAdapter.kt */
    public static final class C78661 extends AbstractC12240o implements Function1<List<? extends GifCategoryItem>, Unit> {
        public C78661() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(List<? extends GifCategoryItem> list) {
            invoke2(list);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(List<? extends GifCategoryItem> list) {
            C12238m.checkNotNullParameter(list, "items");
            GifCategoryAdapter.this.items = list;
        }
    }

    public /* synthetic */ GifCategoryAdapter(AppComponent appComponent, Function1 function1, DiffCreator diffCreator, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(appComponent, function1, (i & 4) != 0 ? new DiffCreator(appComponent) : diffCreator);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* JADX INFO: renamed from: getItemCount */
    public int getPageSize() {
        return this.items.size();
    }

    public final void setItems(List<? extends GifCategoryItem> newItems) {
        C12238m.checkNotNullParameter(newItems, "newItems");
        this.diffCreator.dispatchDiffUpdatesAsync(this, new C78661(), this.items, newItems);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public GifCategoryAdapter(AppComponent appComponent, Function1<? super GifCategoryItem, Unit> function1, DiffCreator<List<GifCategoryItem>, GifCategoryViewHolder> diffCreator) {
        C12238m.checkNotNullParameter(appComponent, "appComponent");
        C12238m.checkNotNullParameter(diffCreator, "diffCreator");
        this.onSelectGifCategory = function1;
        this.diffCreator = diffCreator;
        this.items = C12147n.emptyList();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(GifCategoryViewHolder holder, int position) {
        C12238m.checkNotNullParameter(holder, "holder");
        holder.configure(this.items.get(position), this.onSelectGifCategory);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public GifCategoryViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        C12238m.checkNotNullParameter(parent, "parent");
        View viewInflate = LayoutInflater.from(parent.getContext()).inflate(C5419R.layout.gif_category_item_view, parent, false);
        int i = C5419R.id.gif_category_item_icon;
        ImageView imageView = (ImageView) viewInflate.findViewById(C5419R.id.gif_category_item_icon);
        if (imageView != null) {
            i = C5419R.id.gif_category_item_preview;
            SimpleDraweeView simpleDraweeView = (SimpleDraweeView) viewInflate.findViewById(C5419R.id.gif_category_item_preview);
            if (simpleDraweeView != null) {
                i = C5419R.id.gif_category_item_title;
                TextView textView = (TextView) viewInflate.findViewById(C5419R.id.gif_category_item_title);
                if (textView != null) {
                    GifCategoryItemViewBinding gifCategoryItemViewBinding = new GifCategoryItemViewBinding((CardView) viewInflate, imageView, simpleDraweeView, textView);
                    C12238m.checkNotNullExpressionValue(gifCategoryItemViewBinding, "GifCategoryItemViewBindi….context), parent, false)");
                    return new GifCategoryViewHolder(gifCategoryItemViewBinding);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i)));
    }
}
