package com.discord.widgets.servers.guild_role_subscription;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.C5419R;
import com.discord.app.AppComponent;
import com.discord.databinding.ViewServerSettingsGuildRoleSubscriptionAddTierItemBinding;
import com.discord.databinding.ViewServerSettingsGuildRoleSubscriptionTierItemBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.recycler.DiffCreator;
import com.discord.widgets.servers.guild_role_subscription.ServerSettingsGuildRoleSubscriptionTierAdapterItem;
import com.discord.widgets.servers.guild_role_subscription.TierViewHolder;
import com.facebook.drawee.view.SimpleDraweeView;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p007b.p008a.p027k.C1107b;
import p507d0.p580t.C12147n;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: ServerSettingsGuildRoleSubscriptionTierAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ServerSettingsGuildRoleSubscriptionTierAdapter extends RecyclerView.Adapter<TierViewHolder> {
    private static final int VIEW_TYPE_ADD_ITEM = 1;
    private static final int VIEW_TYPE_TIER = 0;
    private final DiffCreator<List<ServerSettingsGuildRoleSubscriptionTierAdapterItem>, TierViewHolder> diffCreator;
    private ItemClickListener itemClickListener;
    private List<? extends ServerSettingsGuildRoleSubscriptionTierAdapterItem> items;

    /* JADX INFO: compiled from: ServerSettingsGuildRoleSubscriptionTierAdapter.kt */
    public interface ItemClickListener {
        void onAddTierItemClick();

        void onTierItemClick(long tierListingId);
    }

    /* JADX INFO: renamed from: com.discord.widgets.servers.guild_role_subscription.ServerSettingsGuildRoleSubscriptionTierAdapter$setItems$1 */
    /* JADX INFO: compiled from: ServerSettingsGuildRoleSubscriptionTierAdapter.kt */
    public static final class C94411 extends AbstractC12240o implements Function1<List<? extends ServerSettingsGuildRoleSubscriptionTierAdapterItem>, Unit> {
        public C94411() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(List<? extends ServerSettingsGuildRoleSubscriptionTierAdapterItem> list) {
            invoke2(list);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(List<? extends ServerSettingsGuildRoleSubscriptionTierAdapterItem> list) {
            C12238m.checkNotNullParameter(list, "items");
            ServerSettingsGuildRoleSubscriptionTierAdapter.this.items = list;
        }
    }

    public /* synthetic */ ServerSettingsGuildRoleSubscriptionTierAdapter(AppComponent appComponent, DiffCreator diffCreator, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(appComponent, (i & 2) != 0 ? new DiffCreator(appComponent) : diffCreator);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* JADX INFO: renamed from: getItemCount */
    public int getPageSize() {
        return this.items.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int position) {
        ServerSettingsGuildRoleSubscriptionTierAdapterItem serverSettingsGuildRoleSubscriptionTierAdapterItem = this.items.get(position);
        if (serverSettingsGuildRoleSubscriptionTierAdapterItem instanceof ServerSettingsGuildRoleSubscriptionTierAdapterItem.Tier) {
            return 0;
        }
        if (serverSettingsGuildRoleSubscriptionTierAdapterItem instanceof ServerSettingsGuildRoleSubscriptionTierAdapterItem.AddTier) {
            return 1;
        }
        throw new NoWhenBranchMatchedException();
    }

    public final void setItemClickListener(ItemClickListener itemClickListener) {
        C12238m.checkNotNullParameter(itemClickListener, "itemClickListener");
        this.itemClickListener = itemClickListener;
    }

    public final void setItems(List<? extends ServerSettingsGuildRoleSubscriptionTierAdapterItem> newItems) {
        C12238m.checkNotNullParameter(newItems, "newItems");
        this.diffCreator.dispatchDiffUpdates(this, new C94411(), this.items, newItems);
    }

    public ServerSettingsGuildRoleSubscriptionTierAdapter(AppComponent appComponent, DiffCreator<List<ServerSettingsGuildRoleSubscriptionTierAdapterItem>, TierViewHolder> diffCreator) {
        C12238m.checkNotNullParameter(appComponent, "appComponent");
        C12238m.checkNotNullParameter(diffCreator, "diffCreator");
        this.diffCreator = diffCreator;
        this.items = C12147n.emptyList();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(TierViewHolder holder, int position) {
        C12238m.checkNotNullParameter(holder, "holder");
        ServerSettingsGuildRoleSubscriptionTierAdapterItem serverSettingsGuildRoleSubscriptionTierAdapterItem = this.items.get(position);
        if ((holder instanceof TierViewHolder.TierItemViewHolder) && (serverSettingsGuildRoleSubscriptionTierAdapterItem instanceof ServerSettingsGuildRoleSubscriptionTierAdapterItem.Tier)) {
            TierViewHolder.TierItemViewHolder tierItemViewHolder = (TierViewHolder.TierItemViewHolder) holder;
            ServerSettingsGuildRoleSubscriptionTierAdapterItem.Tier tier = (ServerSettingsGuildRoleSubscriptionTierAdapterItem.Tier) serverSettingsGuildRoleSubscriptionTierAdapterItem;
            ItemClickListener itemClickListener = this.itemClickListener;
            if (itemClickListener == null) {
                C12238m.throwUninitializedPropertyAccessException("itemClickListener");
            }
            tierItemViewHolder.configureUI(tier, itemClickListener);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public TierViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        TierViewHolder tierItemViewHolder;
        C12238m.checkNotNullParameter(parent, "parent");
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(parent.getContext());
        if (viewType != 0) {
            if (viewType != 1) {
                Context context = parent.getContext();
                C12238m.checkNotNullExpressionValue(context, "parent.context");
                throw new IllegalArgumentException(C1107b.m210b(context, C5419R.string.android_unknown_view_holder, new Object[]{Integer.valueOf(viewType)}, (4 & 4) != 0 ? C1107b.b.f1491j : null).toString());
            }
            View viewInflate = layoutInflaterFrom.inflate(C5419R.layout.view_server_settings_guild_role_subscription_add_tier_item, parent, false);
            int i = C5419R.id.guild_role_subscription_add_tier_image;
            ImageView imageView = (ImageView) viewInflate.findViewById(C5419R.id.guild_role_subscription_add_tier_image);
            if (imageView != null) {
                i = C5419R.id.guild_role_subscription_add_tier_text;
                TextView textView = (TextView) viewInflate.findViewById(C5419R.id.guild_role_subscription_add_tier_text);
                if (textView != null) {
                    ViewServerSettingsGuildRoleSubscriptionAddTierItemBinding viewServerSettingsGuildRoleSubscriptionAddTierItemBinding = new ViewServerSettingsGuildRoleSubscriptionAddTierItemBinding((ConstraintLayout) viewInflate, imageView, textView);
                    C12238m.checkNotNullExpressionValue(viewServerSettingsGuildRoleSubscriptionAddTierItemBinding, "ViewServerSettingsGuildR…rent, false\n            )");
                    ItemClickListener itemClickListener = this.itemClickListener;
                    if (itemClickListener == null) {
                        C12238m.throwUninitializedPropertyAccessException("itemClickListener");
                    }
                    tierItemViewHolder = new TierViewHolder.AddTierItemViewHolder(viewServerSettingsGuildRoleSubscriptionAddTierItemBinding, itemClickListener);
                }
            }
            throw new NullPointerException("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i)));
        }
        View viewInflate2 = layoutInflaterFrom.inflate(C5419R.layout.view_server_settings_guild_role_subscription_tier_item, parent, false);
        int i2 = C5419R.id.guild_role_subscription_tier_draft_tag;
        TextView textView2 = (TextView) viewInflate2.findViewById(C5419R.id.guild_role_subscription_tier_draft_tag);
        if (textView2 != null) {
            i2 = C5419R.id.guild_role_subscription_tier_edit;
            ImageView imageView2 = (ImageView) viewInflate2.findViewById(C5419R.id.guild_role_subscription_tier_edit);
            if (imageView2 != null) {
                i2 = C5419R.id.guild_role_subscription_tier_icon;
                SimpleDraweeView simpleDraweeView = (SimpleDraweeView) viewInflate2.findViewById(C5419R.id.guild_role_subscription_tier_icon);
                if (simpleDraweeView != null) {
                    i2 = C5419R.id.guild_role_subscription_tier_name;
                    TextView textView3 = (TextView) viewInflate2.findViewById(C5419R.id.guild_role_subscription_tier_name);
                    if (textView3 != null) {
                        i2 = C5419R.id.guild_role_subscription_tier_price;
                        TextView textView4 = (TextView) viewInflate2.findViewById(C5419R.id.guild_role_subscription_tier_price);
                        if (textView4 != null) {
                            ViewServerSettingsGuildRoleSubscriptionTierItemBinding viewServerSettingsGuildRoleSubscriptionTierItemBinding = new ViewServerSettingsGuildRoleSubscriptionTierItemBinding((ConstraintLayout) viewInflate2, textView2, imageView2, simpleDraweeView, textView3, textView4);
                            C12238m.checkNotNullExpressionValue(viewServerSettingsGuildRoleSubscriptionTierItemBinding, "ViewServerSettingsGuildR…(inflater, parent, false)");
                            tierItemViewHolder = new TierViewHolder.TierItemViewHolder(viewServerSettingsGuildRoleSubscriptionTierItemBinding);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(viewInflate2.getResources().getResourceName(i2)));
        return tierItemViewHolder;
    }
}
