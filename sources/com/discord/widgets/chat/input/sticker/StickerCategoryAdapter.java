package com.discord.widgets.chat.input.sticker;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.C5419R;
import com.discord.app.AppComponent;
import com.discord.databinding.StickerCategoryItemGuildBinding;
import com.discord.databinding.StickerCategoryItemPackBinding;
import com.discord.databinding.StickerCategoryItemRecentBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.recycler.DiffCreator;
import com.discord.views.sticker.StickerView;
import com.discord.widgets.chat.input.emoji.GuildIcon;
import java.util.Iterator;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p007b.p008a.p025i.C1009n;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p580t.C12147n;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: StickerCategoryAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StickerCategoryAdapter extends RecyclerView.Adapter<StickerCategoryViewHolder> {
    private final DiffCreator<List<StickerCategoryItem>, StickerCategoryViewHolder> diffCreator;
    private List<? extends StickerCategoryItem> items;
    private final Function1<StickerCategoryItem.GuildItem, Unit> onGuildClicked;
    private final Function1<StickerCategoryItem.PackItem, Unit> onPackClicked;
    private final Function0<Unit> onRecentClicked;
    private final Function1<Integer, Unit> onSelectedItemAdapterPositionUpdated;

    /* JADX INFO: renamed from: com.discord.widgets.chat.input.sticker.StickerCategoryAdapter$setItems$1 */
    /* JADX INFO: compiled from: StickerCategoryAdapter.kt */
    public static final class C78921 extends AbstractC12240o implements Function1<List<? extends StickerCategoryItem>, Unit> {
        public C78921() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(List<? extends StickerCategoryItem> list) {
            invoke2(list);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(List<? extends StickerCategoryItem> list) {
            C12238m.checkNotNullParameter(list, "items");
            StickerCategoryAdapter.this.items = list;
            Iterator<? extends StickerCategoryItem> it = list.iterator();
            int i = 0;
            while (true) {
                if (!it.hasNext()) {
                    i = -1;
                    break;
                } else if (it.next().getIsSelected()) {
                    break;
                } else {
                    i++;
                }
            }
            if (i != -1) {
                StickerCategoryAdapter.this.onSelectedItemAdapterPositionUpdated.invoke(Integer.valueOf(i));
            }
        }
    }

    public /* synthetic */ StickerCategoryAdapter(Function1 function1, Function1 function2, Function0 function0, Function1 function3, AppComponent appComponent, DiffCreator diffCreator, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(function1, function2, function0, function3, appComponent, (i & 32) != 0 ? new DiffCreator(appComponent) : diffCreator);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* JADX INFO: renamed from: getItemCount */
    public int getPageSize() {
        return this.items.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public long getItemId(int position) {
        StickerCategoryItem stickerCategoryItem = this.items.get(position);
        if (stickerCategoryItem instanceof StickerCategoryItem.RecentItem) {
            return -1L;
        }
        if (stickerCategoryItem instanceof StickerCategoryItem.PackItem) {
            return ((StickerCategoryItem.PackItem) stickerCategoryItem).getPack().getId();
        }
        if (stickerCategoryItem instanceof StickerCategoryItem.GuildItem) {
            return ((StickerCategoryItem.GuildItem) stickerCategoryItem).getGuild().getId();
        }
        throw new NoWhenBranchMatchedException();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int position) {
        StickerCategoryItem stickerCategoryItem = this.items.get(position);
        if (stickerCategoryItem instanceof StickerCategoryItem.RecentItem) {
            return 0;
        }
        if (stickerCategoryItem instanceof StickerCategoryItem.PackItem) {
            return 1;
        }
        if (stickerCategoryItem instanceof StickerCategoryItem.GuildItem) {
            return 2;
        }
        throw new NoWhenBranchMatchedException();
    }

    public final void setItems(List<? extends StickerCategoryItem> newItems) {
        C12238m.checkNotNullParameter(newItems, "newItems");
        this.diffCreator.dispatchDiffUpdatesAsync(this, new C78921(), this.items, newItems);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public StickerCategoryAdapter(Function1<? super StickerCategoryItem.GuildItem, Unit> function1, Function1<? super StickerCategoryItem.PackItem, Unit> function2, Function0<Unit> function0, Function1<? super Integer, Unit> function3, AppComponent appComponent, DiffCreator<List<StickerCategoryItem>, StickerCategoryViewHolder> diffCreator) {
        C12238m.checkNotNullParameter(function1, "onGuildClicked");
        C12238m.checkNotNullParameter(function2, "onPackClicked");
        C12238m.checkNotNullParameter(function0, "onRecentClicked");
        C12238m.checkNotNullParameter(function3, "onSelectedItemAdapterPositionUpdated");
        C12238m.checkNotNullParameter(appComponent, "appComponent");
        C12238m.checkNotNullParameter(diffCreator, "diffCreator");
        this.onGuildClicked = function1;
        this.onPackClicked = function2;
        this.onRecentClicked = function0;
        this.onSelectedItemAdapterPositionUpdated = function3;
        this.diffCreator = diffCreator;
        this.items = C12147n.emptyList();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(StickerCategoryViewHolder holder, int position) {
        C12238m.checkNotNullParameter(holder, "holder");
        StickerCategoryItem stickerCategoryItem = this.items.get(position);
        if (stickerCategoryItem instanceof StickerCategoryItem.RecentItem) {
            ((StickerCategoryViewHolder.Recent) holder).configure((StickerCategoryItem.RecentItem) stickerCategoryItem, this.onRecentClicked);
        } else if (stickerCategoryItem instanceof StickerCategoryItem.PackItem) {
            ((StickerCategoryViewHolder.Pack) holder).configure((StickerCategoryItem.PackItem) stickerCategoryItem, this.onPackClicked);
        } else if (stickerCategoryItem instanceof StickerCategoryItem.GuildItem) {
            ((StickerCategoryViewHolder.Guild) holder).configure((StickerCategoryItem.GuildItem) stickerCategoryItem, this.onGuildClicked);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public StickerCategoryViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        C12238m.checkNotNullParameter(parent, "parent");
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(parent.getContext());
        int i = C5419R.id.overline;
        if (viewType == 0) {
            View viewInflate = layoutInflaterFrom.inflate(C5419R.layout.sticker_category_item_recent, parent, false);
            View viewFindViewById = viewInflate.findViewById(C5419R.id.overline);
            if (viewFindViewById == null) {
                throw new NullPointerException("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(C5419R.id.overline)));
            }
            StickerCategoryItemRecentBinding stickerCategoryItemRecentBinding = new StickerCategoryItemRecentBinding((FrameLayout) viewInflate, new C1009n(viewFindViewById, viewFindViewById));
            C12238m.checkNotNullExpressionValue(stickerCategoryItemRecentBinding, "StickerCategoryItemRecen…(inflater, parent, false)");
            return new StickerCategoryViewHolder.Recent(stickerCategoryItemRecentBinding);
        }
        if (viewType == 1) {
            View viewInflate2 = layoutInflaterFrom.inflate(C5419R.layout.sticker_category_item_pack, parent, false);
            View viewFindViewById2 = viewInflate2.findViewById(C5419R.id.overline);
            if (viewFindViewById2 != null) {
                C1009n c1009n = new C1009n(viewFindViewById2, viewFindViewById2);
                StickerView stickerView = (StickerView) viewInflate2.findViewById(C5419R.id.sticker_category_item_pack_avatar);
                if (stickerView != null) {
                    StickerCategoryItemPackBinding stickerCategoryItemPackBinding = new StickerCategoryItemPackBinding((FrameLayout) viewInflate2, c1009n, stickerView);
                    C12238m.checkNotNullExpressionValue(stickerCategoryItemPackBinding, "StickerCategoryItemPackB…(inflater, parent, false)");
                    return new StickerCategoryViewHolder.Pack(stickerCategoryItemPackBinding);
                }
                i = C5419R.id.sticker_category_item_pack_avatar;
            }
            throw new NullPointerException("Missing required view with ID: ".concat(viewInflate2.getResources().getResourceName(i)));
        }
        if (viewType != 2) {
            throw new IllegalStateException(C1643a.m871q("Invalid Sticker Category Type: ", viewType));
        }
        View viewInflate3 = layoutInflaterFrom.inflate(C5419R.layout.sticker_category_item_guild, parent, false);
        View viewFindViewById3 = viewInflate3.findViewById(C5419R.id.overline);
        if (viewFindViewById3 != null) {
            C1009n c1009n2 = new C1009n(viewFindViewById3, viewFindViewById3);
            GuildIcon guildIcon = (GuildIcon) viewInflate3.findViewById(C5419R.id.sticker_category_item_guild_icon);
            if (guildIcon != null) {
                StickerCategoryItemGuildBinding stickerCategoryItemGuildBinding = new StickerCategoryItemGuildBinding((FrameLayout) viewInflate3, c1009n2, guildIcon);
                C12238m.checkNotNullExpressionValue(stickerCategoryItemGuildBinding, "StickerCategoryItemGuild…(inflater, parent, false)");
                return new StickerCategoryViewHolder.Guild(stickerCategoryItemGuildBinding);
            }
            i = C5419R.id.sticker_category_item_guild_icon;
        }
        throw new NullPointerException("Missing required view with ID: ".concat(viewInflate3.getResources().getResourceName(i)));
    }
}
