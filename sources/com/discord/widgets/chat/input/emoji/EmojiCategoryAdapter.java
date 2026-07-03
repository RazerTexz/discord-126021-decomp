package com.discord.widgets.chat.input.emoji;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.C5419R;
import com.discord.app.AppComponent;
import com.discord.databinding.EmojiCategoryItemGuildBinding;
import com.discord.databinding.EmojiCategoryItemStandardBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.recycler.DiffCreator;
import com.discord.widgets.chat.input.emoji.EmojiCategoryItem;
import com.discord.widgets.chat.input.emoji.EmojiCategoryViewHolder;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p007b.p008a.p025i.C1009n;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p580t.C12147n;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: EmojiCategoryAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class EmojiCategoryAdapter extends RecyclerView.Adapter<EmojiCategoryViewHolder> {
    private final DiffCreator<List<EmojiCategoryItem>, EmojiCategoryViewHolder> diffCreator;
    private List<? extends EmojiCategoryItem> items;
    private final Function1<EmojiCategoryItem, Unit> onCategoryClicked;
    private final Function1<Integer, Unit> onSelectedItemAdapterPositionUpdated;

    /* JADX INFO: renamed from: com.discord.widgets.chat.input.emoji.EmojiCategoryAdapter$setItems$1 */
    /* JADX INFO: compiled from: EmojiCategoryAdapter.kt */
    public static final class C78111 extends AbstractC12240o implements Function1<List<? extends EmojiCategoryItem>, Unit> {
        public C78111() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(List<? extends EmojiCategoryItem> list) {
            invoke2(list);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(List<? extends EmojiCategoryItem> list) {
            C12238m.checkNotNullParameter(list, "items");
            EmojiCategoryAdapter.this.items = list;
            Iterator<? extends EmojiCategoryItem> it = list.iterator();
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
                EmojiCategoryAdapter.this.onSelectedItemAdapterPositionUpdated.invoke(Integer.valueOf(i));
            }
        }
    }

    public /* synthetic */ EmojiCategoryAdapter(Function1 function1, Function1 function2, AppComponent appComponent, DiffCreator diffCreator, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(function1, function2, appComponent, (i & 8) != 0 ? new DiffCreator(appComponent) : diffCreator);
    }

    public final EmojiCategoryItem getItemAtPosition(int position) {
        return this.items.get(position);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* JADX INFO: renamed from: getItemCount */
    public int getPageSize() {
        return this.items.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public long getItemId(int position) {
        return this.items.get(position).getStableId();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int position) {
        EmojiCategoryItem emojiCategoryItem = this.items.get(position);
        if (emojiCategoryItem instanceof EmojiCategoryItem.StandardItem) {
            return 0;
        }
        if (emojiCategoryItem instanceof EmojiCategoryItem.GuildItem) {
            return 1;
        }
        throw new NoWhenBranchMatchedException();
    }

    public final void setItems(List<? extends EmojiCategoryItem> newItems) {
        C12238m.checkNotNullParameter(newItems, "newItems");
        this.diffCreator.dispatchDiffUpdatesAsync(this, new C78111(), this.items, newItems);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public EmojiCategoryAdapter(Function1<? super EmojiCategoryItem, Unit> function1, Function1<? super Integer, Unit> function2, AppComponent appComponent, DiffCreator<List<EmojiCategoryItem>, EmojiCategoryViewHolder> diffCreator) {
        C12238m.checkNotNullParameter(function1, "onCategoryClicked");
        C12238m.checkNotNullParameter(function2, "onSelectedItemAdapterPositionUpdated");
        C12238m.checkNotNullParameter(appComponent, "appComponent");
        C12238m.checkNotNullParameter(diffCreator, "diffCreator");
        this.onCategoryClicked = function1;
        this.onSelectedItemAdapterPositionUpdated = function2;
        this.diffCreator = diffCreator;
        this.items = C12147n.emptyList();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(EmojiCategoryViewHolder holder, int position) {
        C12238m.checkNotNullParameter(holder, "holder");
        if (holder instanceof EmojiCategoryViewHolder.Standard) {
            EmojiCategoryItem emojiCategoryItem = this.items.get(position);
            Objects.requireNonNull(emojiCategoryItem, "null cannot be cast to non-null type com.discord.widgets.chat.input.emoji.EmojiCategoryItem.StandardItem");
            ((EmojiCategoryViewHolder.Standard) holder).configure((EmojiCategoryItem.StandardItem) emojiCategoryItem, this.onCategoryClicked);
        } else if (holder instanceof EmojiCategoryViewHolder.Guild) {
            EmojiCategoryItem emojiCategoryItem2 = this.items.get(position);
            Objects.requireNonNull(emojiCategoryItem2, "null cannot be cast to non-null type com.discord.widgets.chat.input.emoji.EmojiCategoryItem.GuildItem");
            ((EmojiCategoryViewHolder.Guild) holder).configure((EmojiCategoryItem.GuildItem) emojiCategoryItem2, this.onCategoryClicked);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public EmojiCategoryViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        C12238m.checkNotNullParameter(parent, "parent");
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(parent.getContext());
        int i = C5419R.id.overline;
        if (viewType == 0) {
            View viewInflate = layoutInflaterFrom.inflate(C5419R.layout.emoji_category_item_standard, parent, false);
            ImageView imageView = (ImageView) viewInflate.findViewById(C5419R.id.emoji_category_item_standard_icon);
            if (imageView != null) {
                View viewFindViewById = viewInflate.findViewById(C5419R.id.overline);
                if (viewFindViewById != null) {
                    EmojiCategoryItemStandardBinding emojiCategoryItemStandardBinding = new EmojiCategoryItemStandardBinding((FrameLayout) viewInflate, imageView, new C1009n(viewFindViewById, viewFindViewById));
                    C12238m.checkNotNullExpressionValue(emojiCategoryItemStandardBinding, "EmojiCategoryItemStandar…(inflater, parent, false)");
                    return new EmojiCategoryViewHolder.Standard(emojiCategoryItemStandardBinding);
                }
            } else {
                i = C5419R.id.emoji_category_item_standard_icon;
            }
            throw new NullPointerException("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i)));
        }
        if (viewType != 1) {
            StringBuilder sbM834V = C1643a.m834V("invalid viewType ", viewType, " for ");
            sbM834V.append(EmojiCategoryAdapter.class.getSimpleName());
            throw new IllegalArgumentException(sbM834V.toString());
        }
        View viewInflate2 = layoutInflaterFrom.inflate(C5419R.layout.emoji_category_item_guild, parent, false);
        GuildIcon guildIcon = (GuildIcon) viewInflate2.findViewById(C5419R.id.emoji_category_item_guild_icon);
        if (guildIcon != null) {
            View viewFindViewById2 = viewInflate2.findViewById(C5419R.id.overline);
            if (viewFindViewById2 != null) {
                EmojiCategoryItemGuildBinding emojiCategoryItemGuildBinding = new EmojiCategoryItemGuildBinding((FrameLayout) viewInflate2, guildIcon, new C1009n(viewFindViewById2, viewFindViewById2));
                C12238m.checkNotNullExpressionValue(emojiCategoryItemGuildBinding, "EmojiCategoryItemGuildBi…(inflater, parent, false)");
                return new EmojiCategoryViewHolder.Guild(emojiCategoryItemGuildBinding);
            }
        } else {
            i = C5419R.id.emoji_category_item_guild_icon;
        }
        throw new NullPointerException("Missing required view with ID: ".concat(viewInflate2.getResources().getResourceName(i)));
    }
}
