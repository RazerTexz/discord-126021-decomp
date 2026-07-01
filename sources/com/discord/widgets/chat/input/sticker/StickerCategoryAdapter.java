package com.discord.widgets.chat.input.sticker;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.RecyclerView$Adapter;
import androidx.recyclerview.widget.RecyclerView$ViewHolder;
import b.d.b.a.a;
import com.discord.R$id;
import com.discord.R$layout;
import com.discord.app.AppComponent;
import com.discord.databinding.StickerCategoryItemGuildBinding;
import com.discord.databinding.StickerCategoryItemPackBinding;
import com.discord.databinding.StickerCategoryItemRecentBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.recycler.DiffCreator;
import com.discord.views.sticker.StickerView;
import com.discord.widgets.chat.input.emoji.GuildIcon;
import d0.t.n;
import d0.z.d.m;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: StickerCategoryAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StickerCategoryAdapter extends RecyclerView$Adapter<StickerCategoryViewHolder> {
    private final DiffCreator<List<StickerCategoryItem>, StickerCategoryViewHolder> diffCreator;
    private List<? extends StickerCategoryItem> items;
    private final Function1<StickerCategoryItem$GuildItem, Unit> onGuildClicked;
    private final Function1<StickerCategoryItem$PackItem, Unit> onPackClicked;
    private final Function0<Unit> onRecentClicked;
    private final Function1<Integer, Unit> onSelectedItemAdapterPositionUpdated;

    public /* synthetic */ StickerCategoryAdapter(Function1 function1, Function1 function2, Function0 function0, Function1 function3, AppComponent appComponent, DiffCreator diffCreator, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(function1, function2, function0, function3, appComponent, (i & 32) != 0 ? new DiffCreator(appComponent) : diffCreator);
    }

    public static final /* synthetic */ List access$getItems$p(StickerCategoryAdapter stickerCategoryAdapter) {
        return stickerCategoryAdapter.items;
    }

    public static final /* synthetic */ Function1 access$getOnSelectedItemAdapterPositionUpdated$p(StickerCategoryAdapter stickerCategoryAdapter) {
        return stickerCategoryAdapter.onSelectedItemAdapterPositionUpdated;
    }

    public static final /* synthetic */ void access$setItems$p(StickerCategoryAdapter stickerCategoryAdapter, List list) {
        stickerCategoryAdapter.items = list;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$Adapter
    public int getItemCount() {
        return this.items.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView$Adapter
    public long getItemId(int position) {
        StickerCategoryItem stickerCategoryItem = this.items.get(position);
        if (stickerCategoryItem instanceof StickerCategoryItem$RecentItem) {
            return -1L;
        }
        if (stickerCategoryItem instanceof StickerCategoryItem$PackItem) {
            return ((StickerCategoryItem$PackItem) stickerCategoryItem).getPack().getId();
        }
        if (stickerCategoryItem instanceof StickerCategoryItem$GuildItem) {
            return ((StickerCategoryItem$GuildItem) stickerCategoryItem).getGuild().getId();
        }
        throw new NoWhenBranchMatchedException();
    }

    @Override // androidx.recyclerview.widget.RecyclerView$Adapter
    public int getItemViewType(int position) {
        StickerCategoryItem stickerCategoryItem = this.items.get(position);
        if (stickerCategoryItem instanceof StickerCategoryItem$RecentItem) {
            return 0;
        }
        if (stickerCategoryItem instanceof StickerCategoryItem$PackItem) {
            return 1;
        }
        if (stickerCategoryItem instanceof StickerCategoryItem$GuildItem) {
            return 2;
        }
        throw new NoWhenBranchMatchedException();
    }

    @Override // androidx.recyclerview.widget.RecyclerView$Adapter
    public /* bridge */ /* synthetic */ void onBindViewHolder(RecyclerView$ViewHolder recyclerView$ViewHolder, int i) {
        onBindViewHolder((StickerCategoryViewHolder) recyclerView$ViewHolder, i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$Adapter
    public /* bridge */ /* synthetic */ RecyclerView$ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return onCreateViewHolder(viewGroup, i);
    }

    public final void setItems(List<? extends StickerCategoryItem> newItems) {
        m.checkNotNullParameter(newItems, "newItems");
        this.diffCreator.dispatchDiffUpdatesAsync(this, new StickerCategoryAdapter$setItems$1(this), this.items, newItems);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public StickerCategoryAdapter(Function1<? super StickerCategoryItem$GuildItem, Unit> function1, Function1<? super StickerCategoryItem$PackItem, Unit> function2, Function0<Unit> function0, Function1<? super Integer, Unit> function3, AppComponent appComponent, DiffCreator<List<StickerCategoryItem>, StickerCategoryViewHolder> diffCreator) {
        m.checkNotNullParameter(function1, "onGuildClicked");
        m.checkNotNullParameter(function2, "onPackClicked");
        m.checkNotNullParameter(function0, "onRecentClicked");
        m.checkNotNullParameter(function3, "onSelectedItemAdapterPositionUpdated");
        m.checkNotNullParameter(appComponent, "appComponent");
        m.checkNotNullParameter(diffCreator, "diffCreator");
        this.onGuildClicked = function1;
        this.onPackClicked = function2;
        this.onRecentClicked = function0;
        this.onSelectedItemAdapterPositionUpdated = function3;
        this.diffCreator = diffCreator;
        this.items = n.emptyList();
    }

    public void onBindViewHolder(StickerCategoryViewHolder holder, int position) {
        m.checkNotNullParameter(holder, "holder");
        StickerCategoryItem stickerCategoryItem = this.items.get(position);
        if (stickerCategoryItem instanceof StickerCategoryItem$RecentItem) {
            ((StickerCategoryViewHolder$Recent) holder).configure((StickerCategoryItem$RecentItem) stickerCategoryItem, this.onRecentClicked);
        } else if (stickerCategoryItem instanceof StickerCategoryItem$PackItem) {
            ((StickerCategoryViewHolder$Pack) holder).configure((StickerCategoryItem$PackItem) stickerCategoryItem, this.onPackClicked);
        } else if (stickerCategoryItem instanceof StickerCategoryItem$GuildItem) {
            ((StickerCategoryViewHolder$Guild) holder).configure((StickerCategoryItem$GuildItem) stickerCategoryItem, this.onGuildClicked);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView$Adapter
    public StickerCategoryViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        m.checkNotNullParameter(parent, "parent");
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(parent.getContext());
        int i = R$id.overline;
        if (viewType == 0) {
            View viewInflate = layoutInflaterFrom.inflate(R$layout.sticker_category_item_recent, parent, false);
            View viewFindViewById = viewInflate.findViewById(R$id.overline);
            if (viewFindViewById == null) {
                throw new NullPointerException("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(R$id.overline)));
            }
            StickerCategoryItemRecentBinding stickerCategoryItemRecentBinding = new StickerCategoryItemRecentBinding((FrameLayout) viewInflate, new b.a.i.n(viewFindViewById, viewFindViewById));
            m.checkNotNullExpressionValue(stickerCategoryItemRecentBinding, "StickerCategoryItemRecen…(inflater, parent, false)");
            return new StickerCategoryViewHolder$Recent(stickerCategoryItemRecentBinding);
        }
        if (viewType == 1) {
            View viewInflate2 = layoutInflaterFrom.inflate(R$layout.sticker_category_item_pack, parent, false);
            View viewFindViewById2 = viewInflate2.findViewById(R$id.overline);
            if (viewFindViewById2 != null) {
                b.a.i.n nVar = new b.a.i.n(viewFindViewById2, viewFindViewById2);
                StickerView stickerView = (StickerView) viewInflate2.findViewById(R$id.sticker_category_item_pack_avatar);
                if (stickerView != null) {
                    StickerCategoryItemPackBinding stickerCategoryItemPackBinding = new StickerCategoryItemPackBinding((FrameLayout) viewInflate2, nVar, stickerView);
                    m.checkNotNullExpressionValue(stickerCategoryItemPackBinding, "StickerCategoryItemPackB…(inflater, parent, false)");
                    return new StickerCategoryViewHolder$Pack(stickerCategoryItemPackBinding);
                }
                i = R$id.sticker_category_item_pack_avatar;
            }
            throw new NullPointerException("Missing required view with ID: ".concat(viewInflate2.getResources().getResourceName(i)));
        }
        if (viewType != 2) {
            throw new IllegalStateException(a.q("Invalid Sticker Category Type: ", viewType));
        }
        View viewInflate3 = layoutInflaterFrom.inflate(R$layout.sticker_category_item_guild, parent, false);
        View viewFindViewById3 = viewInflate3.findViewById(R$id.overline);
        if (viewFindViewById3 != null) {
            b.a.i.n nVar2 = new b.a.i.n(viewFindViewById3, viewFindViewById3);
            GuildIcon guildIcon = (GuildIcon) viewInflate3.findViewById(R$id.sticker_category_item_guild_icon);
            if (guildIcon != null) {
                StickerCategoryItemGuildBinding stickerCategoryItemGuildBinding = new StickerCategoryItemGuildBinding((FrameLayout) viewInflate3, nVar2, guildIcon);
                m.checkNotNullExpressionValue(stickerCategoryItemGuildBinding, "StickerCategoryItemGuild…(inflater, parent, false)");
                return new StickerCategoryViewHolder$Guild(stickerCategoryItemGuildBinding);
            }
            i = R$id.sticker_category_item_guild_icon;
        }
        throw new NullPointerException("Missing required view with ID: ".concat(viewInflate3.getResources().getResourceName(i)));
    }
}
