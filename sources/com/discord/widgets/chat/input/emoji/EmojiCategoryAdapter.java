package com.discord.widgets.chat.input.emoji;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;
import b.a.i.ExpressionPickerCategorySelectionOverlineViewBinding;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.app.AppComponent;
import com.discord.databinding.EmojiCategoryItemGuildBinding;
import com.discord.databinding.EmojiCategoryItemStandardBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.recycler.DiffCreator;
import com.discord.widgets.chat.input.emoji.EmojiCategoryItem;
import com.discord.widgets.chat.input.emoji.EmojiCategoryViewHolder;
import d0.t.Collections2;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: EmojiCategoryAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class EmojiCategoryAdapter extends RecyclerView.Adapter<EmojiCategoryViewHolder> {
    private final DiffCreator<List<EmojiCategoryItem>, EmojiCategoryViewHolder> diffCreator;
    private List<? extends EmojiCategoryItem> items;
    private final Function1<EmojiCategoryItem, Unit> onCategoryClicked;
    private final Function1<Integer, Unit> onSelectedItemAdapterPositionUpdated;

    /* JADX INFO: renamed from: com.discord.widgets.chat.input.emoji.EmojiCategoryAdapter$setItems$1, reason: invalid class name */
    /* JADX INFO: compiled from: EmojiCategoryAdapter.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<List<? extends EmojiCategoryItem>, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(List<? extends EmojiCategoryItem> list) {
            invoke2(list);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(List<? extends EmojiCategoryItem> list) {
            Intrinsics3.checkNotNullParameter(list, "items");
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
        Intrinsics3.checkNotNullParameter(newItems, "newItems");
        this.diffCreator.dispatchDiffUpdatesAsync(this, new AnonymousClass1(), this.items, newItems);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public EmojiCategoryAdapter(Function1<? super EmojiCategoryItem, Unit> function1, Function1<? super Integer, Unit> function2, AppComponent appComponent, DiffCreator<List<EmojiCategoryItem>, EmojiCategoryViewHolder> diffCreator) {
        Intrinsics3.checkNotNullParameter(function1, "onCategoryClicked");
        Intrinsics3.checkNotNullParameter(function2, "onSelectedItemAdapterPositionUpdated");
        Intrinsics3.checkNotNullParameter(appComponent, "appComponent");
        Intrinsics3.checkNotNullParameter(diffCreator, "diffCreator");
        this.onCategoryClicked = function1;
        this.onSelectedItemAdapterPositionUpdated = function2;
        this.diffCreator = diffCreator;
        this.items = Collections2.emptyList();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(EmojiCategoryViewHolder holder, int position) {
        Intrinsics3.checkNotNullParameter(holder, "holder");
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
        Intrinsics3.checkNotNullParameter(parent, "parent");
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(parent.getContext());
        int i = R.id.overline;
        if (viewType == 0) {
            View viewInflate = layoutInflaterFrom.inflate(R.layout.emoji_category_item_standard, parent, false);
            ImageView imageView = (ImageView) viewInflate.findViewById(R.id.emoji_category_item_standard_icon);
            if (imageView != null) {
                View viewFindViewById = viewInflate.findViewById(R.id.overline);
                if (viewFindViewById != null) {
                    EmojiCategoryItemStandardBinding emojiCategoryItemStandardBinding = new EmojiCategoryItemStandardBinding((FrameLayout) viewInflate, imageView, new ExpressionPickerCategorySelectionOverlineViewBinding(viewFindViewById, viewFindViewById));
                    Intrinsics3.checkNotNullExpressionValue(emojiCategoryItemStandardBinding, "EmojiCategoryItemStandar…(inflater, parent, false)");
                    return new EmojiCategoryViewHolder.Standard(emojiCategoryItemStandardBinding);
                }
            } else {
                i = R.id.emoji_category_item_standard_icon;
            }
            throw new NullPointerException("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i)));
        }
        if (viewType != 1) {
            StringBuilder sbV = outline.V("invalid viewType ", viewType, " for ");
            sbV.append(EmojiCategoryAdapter.class.getSimpleName());
            throw new IllegalArgumentException(sbV.toString());
        }
        View viewInflate2 = layoutInflaterFrom.inflate(R.layout.emoji_category_item_guild, parent, false);
        GuildIcon guildIcon = (GuildIcon) viewInflate2.findViewById(R.id.emoji_category_item_guild_icon);
        if (guildIcon != null) {
            View viewFindViewById2 = viewInflate2.findViewById(R.id.overline);
            if (viewFindViewById2 != null) {
                EmojiCategoryItemGuildBinding emojiCategoryItemGuildBinding = new EmojiCategoryItemGuildBinding((FrameLayout) viewInflate2, guildIcon, new ExpressionPickerCategorySelectionOverlineViewBinding(viewFindViewById2, viewFindViewById2));
                Intrinsics3.checkNotNullExpressionValue(emojiCategoryItemGuildBinding, "EmojiCategoryItemGuildBi…(inflater, parent, false)");
                return new EmojiCategoryViewHolder.Guild(emojiCategoryItemGuildBinding);
            }
        } else {
            i = R.id.emoji_category_item_guild_icon;
        }
        throw new NullPointerException("Missing required view with ID: ".concat(viewInflate2.getResources().getResourceName(i)));
    }
}
