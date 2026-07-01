package com.discord.widgets.chat.input.emoji;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView$Adapter;
import androidx.recyclerview.widget.RecyclerView$ViewHolder;
import b.d.b.a.a;
import com.discord.R$id;
import com.discord.R$layout;
import com.discord.app.AppComponent;
import com.discord.databinding.EmojiCategoryItemGuildBinding;
import com.discord.databinding.EmojiCategoryItemStandardBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.recycler.DiffCreator;
import d0.t.n;
import d0.z.d.m;
import java.util.List;
import java.util.Objects;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: EmojiCategoryAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class EmojiCategoryAdapter extends RecyclerView$Adapter<EmojiCategoryViewHolder> {
    private final DiffCreator<List<EmojiCategoryItem>, EmojiCategoryViewHolder> diffCreator;
    private List<? extends EmojiCategoryItem> items;
    private final Function1<EmojiCategoryItem, Unit> onCategoryClicked;
    private final Function1<Integer, Unit> onSelectedItemAdapterPositionUpdated;

    public /* synthetic */ EmojiCategoryAdapter(Function1 function1, Function1 function2, AppComponent appComponent, DiffCreator diffCreator, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(function1, function2, appComponent, (i & 8) != 0 ? new DiffCreator(appComponent) : diffCreator);
    }

    public static final /* synthetic */ List access$getItems$p(EmojiCategoryAdapter emojiCategoryAdapter) {
        return emojiCategoryAdapter.items;
    }

    public static final /* synthetic */ Function1 access$getOnSelectedItemAdapterPositionUpdated$p(EmojiCategoryAdapter emojiCategoryAdapter) {
        return emojiCategoryAdapter.onSelectedItemAdapterPositionUpdated;
    }

    public static final /* synthetic */ void access$setItems$p(EmojiCategoryAdapter emojiCategoryAdapter, List list) {
        emojiCategoryAdapter.items = list;
    }

    public final EmojiCategoryItem getItemAtPosition(int position) {
        return this.items.get(position);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$Adapter
    public int getItemCount() {
        return this.items.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView$Adapter
    public long getItemId(int position) {
        return this.items.get(position).getStableId();
    }

    @Override // androidx.recyclerview.widget.RecyclerView$Adapter
    public int getItemViewType(int position) {
        EmojiCategoryItem emojiCategoryItem = this.items.get(position);
        if (emojiCategoryItem instanceof EmojiCategoryItem$StandardItem) {
            return 0;
        }
        if (emojiCategoryItem instanceof EmojiCategoryItem$GuildItem) {
            return 1;
        }
        throw new NoWhenBranchMatchedException();
    }

    @Override // androidx.recyclerview.widget.RecyclerView$Adapter
    public /* bridge */ /* synthetic */ void onBindViewHolder(RecyclerView$ViewHolder recyclerView$ViewHolder, int i) {
        onBindViewHolder((EmojiCategoryViewHolder) recyclerView$ViewHolder, i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$Adapter
    public /* bridge */ /* synthetic */ RecyclerView$ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return onCreateViewHolder(viewGroup, i);
    }

    public final void setItems(List<? extends EmojiCategoryItem> newItems) {
        m.checkNotNullParameter(newItems, "newItems");
        this.diffCreator.dispatchDiffUpdatesAsync(this, new EmojiCategoryAdapter$setItems$1(this), this.items, newItems);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public EmojiCategoryAdapter(Function1<? super EmojiCategoryItem, Unit> function1, Function1<? super Integer, Unit> function2, AppComponent appComponent, DiffCreator<List<EmojiCategoryItem>, EmojiCategoryViewHolder> diffCreator) {
        m.checkNotNullParameter(function1, "onCategoryClicked");
        m.checkNotNullParameter(function2, "onSelectedItemAdapterPositionUpdated");
        m.checkNotNullParameter(appComponent, "appComponent");
        m.checkNotNullParameter(diffCreator, "diffCreator");
        this.onCategoryClicked = function1;
        this.onSelectedItemAdapterPositionUpdated = function2;
        this.diffCreator = diffCreator;
        this.items = n.emptyList();
    }

    public void onBindViewHolder(EmojiCategoryViewHolder holder, int position) {
        m.checkNotNullParameter(holder, "holder");
        if (holder instanceof EmojiCategoryViewHolder$Standard) {
            EmojiCategoryItem emojiCategoryItem = this.items.get(position);
            Objects.requireNonNull(emojiCategoryItem, "null cannot be cast to non-null type com.discord.widgets.chat.input.emoji.EmojiCategoryItem.StandardItem");
            ((EmojiCategoryViewHolder$Standard) holder).configure((EmojiCategoryItem$StandardItem) emojiCategoryItem, this.onCategoryClicked);
        } else if (holder instanceof EmojiCategoryViewHolder$Guild) {
            EmojiCategoryItem emojiCategoryItem2 = this.items.get(position);
            Objects.requireNonNull(emojiCategoryItem2, "null cannot be cast to non-null type com.discord.widgets.chat.input.emoji.EmojiCategoryItem.GuildItem");
            ((EmojiCategoryViewHolder$Guild) holder).configure((EmojiCategoryItem$GuildItem) emojiCategoryItem2, this.onCategoryClicked);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView$Adapter
    public EmojiCategoryViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        m.checkNotNullParameter(parent, "parent");
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(parent.getContext());
        int i = R$id.overline;
        if (viewType == 0) {
            View viewInflate = layoutInflaterFrom.inflate(R$layout.emoji_category_item_standard, parent, false);
            ImageView imageView = (ImageView) viewInflate.findViewById(R$id.emoji_category_item_standard_icon);
            if (imageView != null) {
                View viewFindViewById = viewInflate.findViewById(R$id.overline);
                if (viewFindViewById != null) {
                    EmojiCategoryItemStandardBinding emojiCategoryItemStandardBinding = new EmojiCategoryItemStandardBinding((FrameLayout) viewInflate, imageView, new b.a.i.n(viewFindViewById, viewFindViewById));
                    m.checkNotNullExpressionValue(emojiCategoryItemStandardBinding, "EmojiCategoryItemStandar…(inflater, parent, false)");
                    return new EmojiCategoryViewHolder$Standard(emojiCategoryItemStandardBinding);
                }
            } else {
                i = R$id.emoji_category_item_standard_icon;
            }
            throw new NullPointerException("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i)));
        }
        if (viewType != 1) {
            StringBuilder sbV = a.V("invalid viewType ", viewType, " for ");
            sbV.append(EmojiCategoryAdapter.class.getSimpleName());
            throw new IllegalArgumentException(sbV.toString());
        }
        View viewInflate2 = layoutInflaterFrom.inflate(R$layout.emoji_category_item_guild, parent, false);
        GuildIcon guildIcon = (GuildIcon) viewInflate2.findViewById(R$id.emoji_category_item_guild_icon);
        if (guildIcon != null) {
            View viewFindViewById2 = viewInflate2.findViewById(R$id.overline);
            if (viewFindViewById2 != null) {
                EmojiCategoryItemGuildBinding emojiCategoryItemGuildBinding = new EmojiCategoryItemGuildBinding((FrameLayout) viewInflate2, guildIcon, new b.a.i.n(viewFindViewById2, viewFindViewById2));
                m.checkNotNullExpressionValue(emojiCategoryItemGuildBinding, "EmojiCategoryItemGuildBi…(inflater, parent, false)");
                return new EmojiCategoryViewHolder$Guild(emojiCategoryItemGuildBinding);
            }
        } else {
            i = R$id.emoji_category_item_guild_icon;
        }
        throw new NullPointerException("Missing required view with ID: ".concat(viewInflate2.getResources().getResourceName(i)));
    }
}
