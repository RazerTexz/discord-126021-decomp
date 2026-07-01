package com.discord.widgets.servers.guild_role_subscription;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView$Adapter;
import androidx.recyclerview.widget.RecyclerView$ViewHolder;
import b.a.k.b;
import com.discord.R$id;
import com.discord.R$layout;
import com.discord.app.AppComponent;
import com.discord.databinding.ViewServerSettingsGuildRoleSubscriptionAddTierItemBinding;
import com.discord.databinding.ViewServerSettingsGuildRoleSubscriptionTierItemBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.recycler.DiffCreator;
import com.facebook.drawee.view.SimpleDraweeView;
import d0.t.n;
import d0.z.d.m;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: ServerSettingsGuildRoleSubscriptionTierAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ServerSettingsGuildRoleSubscriptionTierAdapter extends RecyclerView$Adapter<TierViewHolder> {
    public static final ServerSettingsGuildRoleSubscriptionTierAdapter$Companion Companion = new ServerSettingsGuildRoleSubscriptionTierAdapter$Companion(null);
    private static final int VIEW_TYPE_ADD_ITEM = 1;
    private static final int VIEW_TYPE_TIER = 0;
    private final DiffCreator<List<ServerSettingsGuildRoleSubscriptionTierAdapterItem>, TierViewHolder> diffCreator;
    private ServerSettingsGuildRoleSubscriptionTierAdapter$ItemClickListener itemClickListener;
    private List<? extends ServerSettingsGuildRoleSubscriptionTierAdapterItem> items;

    public /* synthetic */ ServerSettingsGuildRoleSubscriptionTierAdapter(AppComponent appComponent, DiffCreator diffCreator, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(appComponent, (i & 2) != 0 ? new DiffCreator(appComponent) : diffCreator);
    }

    public static final /* synthetic */ List access$getItems$p(ServerSettingsGuildRoleSubscriptionTierAdapter serverSettingsGuildRoleSubscriptionTierAdapter) {
        return serverSettingsGuildRoleSubscriptionTierAdapter.items;
    }

    public static final /* synthetic */ void access$setItems$p(ServerSettingsGuildRoleSubscriptionTierAdapter serverSettingsGuildRoleSubscriptionTierAdapter, List list) {
        serverSettingsGuildRoleSubscriptionTierAdapter.items = list;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$Adapter
    public int getItemCount() {
        return this.items.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView$Adapter
    public int getItemViewType(int position) {
        ServerSettingsGuildRoleSubscriptionTierAdapterItem serverSettingsGuildRoleSubscriptionTierAdapterItem = this.items.get(position);
        if (serverSettingsGuildRoleSubscriptionTierAdapterItem instanceof ServerSettingsGuildRoleSubscriptionTierAdapterItem$Tier) {
            return 0;
        }
        if (serverSettingsGuildRoleSubscriptionTierAdapterItem instanceof ServerSettingsGuildRoleSubscriptionTierAdapterItem$AddTier) {
            return 1;
        }
        throw new NoWhenBranchMatchedException();
    }

    @Override // androidx.recyclerview.widget.RecyclerView$Adapter
    public /* bridge */ /* synthetic */ void onBindViewHolder(RecyclerView$ViewHolder recyclerView$ViewHolder, int i) {
        onBindViewHolder((TierViewHolder) recyclerView$ViewHolder, i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$Adapter
    public /* bridge */ /* synthetic */ RecyclerView$ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return onCreateViewHolder(viewGroup, i);
    }

    public final void setItemClickListener(ServerSettingsGuildRoleSubscriptionTierAdapter$ItemClickListener itemClickListener) {
        m.checkNotNullParameter(itemClickListener, "itemClickListener");
        this.itemClickListener = itemClickListener;
    }

    public final void setItems(List<? extends ServerSettingsGuildRoleSubscriptionTierAdapterItem> newItems) {
        m.checkNotNullParameter(newItems, "newItems");
        this.diffCreator.dispatchDiffUpdates(this, new ServerSettingsGuildRoleSubscriptionTierAdapter$setItems$1(this), this.items, newItems);
    }

    public ServerSettingsGuildRoleSubscriptionTierAdapter(AppComponent appComponent, DiffCreator<List<ServerSettingsGuildRoleSubscriptionTierAdapterItem>, TierViewHolder> diffCreator) {
        m.checkNotNullParameter(appComponent, "appComponent");
        m.checkNotNullParameter(diffCreator, "diffCreator");
        this.diffCreator = diffCreator;
        this.items = n.emptyList();
    }

    public void onBindViewHolder(TierViewHolder holder, int position) {
        m.checkNotNullParameter(holder, "holder");
        ServerSettingsGuildRoleSubscriptionTierAdapterItem serverSettingsGuildRoleSubscriptionTierAdapterItem = this.items.get(position);
        if ((holder instanceof TierViewHolder$TierItemViewHolder) && (serverSettingsGuildRoleSubscriptionTierAdapterItem instanceof ServerSettingsGuildRoleSubscriptionTierAdapterItem$Tier)) {
            TierViewHolder$TierItemViewHolder tierViewHolder$TierItemViewHolder = (TierViewHolder$TierItemViewHolder) holder;
            ServerSettingsGuildRoleSubscriptionTierAdapterItem$Tier serverSettingsGuildRoleSubscriptionTierAdapterItem$Tier = (ServerSettingsGuildRoleSubscriptionTierAdapterItem$Tier) serverSettingsGuildRoleSubscriptionTierAdapterItem;
            ServerSettingsGuildRoleSubscriptionTierAdapter$ItemClickListener serverSettingsGuildRoleSubscriptionTierAdapter$ItemClickListener = this.itemClickListener;
            if (serverSettingsGuildRoleSubscriptionTierAdapter$ItemClickListener == null) {
                m.throwUninitializedPropertyAccessException("itemClickListener");
            }
            tierViewHolder$TierItemViewHolder.configureUI(serverSettingsGuildRoleSubscriptionTierAdapterItem$Tier, serverSettingsGuildRoleSubscriptionTierAdapter$ItemClickListener);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView$Adapter
    public TierViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        TierViewHolder tierViewHolder$TierItemViewHolder;
        m.checkNotNullParameter(parent, "parent");
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(parent.getContext());
        if (viewType != 0) {
            if (viewType != 1) {
                Context context = parent.getContext();
                m.checkNotNullExpressionValue(context, "parent.context");
                throw new IllegalArgumentException(b.h(context, 2131886424, new Object[]{Integer.valueOf(viewType)}, null, 4).toString());
            }
            View viewInflate = layoutInflaterFrom.inflate(R$layout.view_server_settings_guild_role_subscription_add_tier_item, parent, false);
            int i = R$id.guild_role_subscription_add_tier_image;
            ImageView imageView = (ImageView) viewInflate.findViewById(R$id.guild_role_subscription_add_tier_image);
            if (imageView != null) {
                i = R$id.guild_role_subscription_add_tier_text;
                TextView textView = (TextView) viewInflate.findViewById(R$id.guild_role_subscription_add_tier_text);
                if (textView != null) {
                    ViewServerSettingsGuildRoleSubscriptionAddTierItemBinding viewServerSettingsGuildRoleSubscriptionAddTierItemBinding = new ViewServerSettingsGuildRoleSubscriptionAddTierItemBinding((ConstraintLayout) viewInflate, imageView, textView);
                    m.checkNotNullExpressionValue(viewServerSettingsGuildRoleSubscriptionAddTierItemBinding, "ViewServerSettingsGuildR…rent, false\n            )");
                    ServerSettingsGuildRoleSubscriptionTierAdapter$ItemClickListener serverSettingsGuildRoleSubscriptionTierAdapter$ItemClickListener = this.itemClickListener;
                    if (serverSettingsGuildRoleSubscriptionTierAdapter$ItemClickListener == null) {
                        m.throwUninitializedPropertyAccessException("itemClickListener");
                    }
                    tierViewHolder$TierItemViewHolder = new TierViewHolder$AddTierItemViewHolder(viewServerSettingsGuildRoleSubscriptionAddTierItemBinding, serverSettingsGuildRoleSubscriptionTierAdapter$ItemClickListener);
                }
            }
            throw new NullPointerException("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i)));
        }
        View viewInflate2 = layoutInflaterFrom.inflate(R$layout.view_server_settings_guild_role_subscription_tier_item, parent, false);
        int i2 = R$id.guild_role_subscription_tier_draft_tag;
        TextView textView2 = (TextView) viewInflate2.findViewById(R$id.guild_role_subscription_tier_draft_tag);
        if (textView2 != null) {
            i2 = R$id.guild_role_subscription_tier_edit;
            ImageView imageView2 = (ImageView) viewInflate2.findViewById(R$id.guild_role_subscription_tier_edit);
            if (imageView2 != null) {
                i2 = R$id.guild_role_subscription_tier_icon;
                SimpleDraweeView simpleDraweeView = (SimpleDraweeView) viewInflate2.findViewById(R$id.guild_role_subscription_tier_icon);
                if (simpleDraweeView != null) {
                    i2 = R$id.guild_role_subscription_tier_name;
                    TextView textView3 = (TextView) viewInflate2.findViewById(R$id.guild_role_subscription_tier_name);
                    if (textView3 != null) {
                        i2 = R$id.guild_role_subscription_tier_price;
                        TextView textView4 = (TextView) viewInflate2.findViewById(R$id.guild_role_subscription_tier_price);
                        if (textView4 != null) {
                            ViewServerSettingsGuildRoleSubscriptionTierItemBinding viewServerSettingsGuildRoleSubscriptionTierItemBinding = new ViewServerSettingsGuildRoleSubscriptionTierItemBinding((ConstraintLayout) viewInflate2, textView2, imageView2, simpleDraweeView, textView3, textView4);
                            m.checkNotNullExpressionValue(viewServerSettingsGuildRoleSubscriptionTierItemBinding, "ViewServerSettingsGuildR…(inflater, parent, false)");
                            tierViewHolder$TierItemViewHolder = new TierViewHolder$TierItemViewHolder(viewServerSettingsGuildRoleSubscriptionTierItemBinding);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(viewInflate2.getResources().getResourceName(i2)));
        return tierViewHolder$TierItemViewHolder;
    }
}
