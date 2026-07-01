package com.discord.widgets.servers.guild_role_subscription;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import b.a.k.FormatUtils;
import com.discord.R;
import com.discord.app.AppComponent;
import com.discord.databinding.ViewServerSettingsGuildRoleSubscriptionAddTierItemBinding;
import com.discord.databinding.ViewServerSettingsGuildRoleSubscriptionTierItemBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.recycler.DiffCreator;
import com.discord.widgets.servers.guild_role_subscription.ServerSettingsGuildRoleSubscriptionTierAdapter2;
import com.discord.widgets.servers.guild_role_subscription.ServerSettingsGuildRoleSubscriptionTierAdapter3;
import com.facebook.drawee.view.SimpleDraweeView;
import d0.t.Collections2;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: ServerSettingsGuildRoleSubscriptionTierAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ServerSettingsGuildRoleSubscriptionTierAdapter extends RecyclerView.Adapter<ServerSettingsGuildRoleSubscriptionTierAdapter3> {
    private static final int VIEW_TYPE_ADD_ITEM = 1;
    private static final int VIEW_TYPE_TIER = 0;
    private final DiffCreator<List<ServerSettingsGuildRoleSubscriptionTierAdapter2>, ServerSettingsGuildRoleSubscriptionTierAdapter3> diffCreator;
    private ItemClickListener itemClickListener;
    private List<? extends ServerSettingsGuildRoleSubscriptionTierAdapter2> items;

    /* JADX INFO: compiled from: ServerSettingsGuildRoleSubscriptionTierAdapter.kt */
    public interface ItemClickListener {
        void onAddTierItemClick();

        void onTierItemClick(long tierListingId);
    }

    /* JADX INFO: renamed from: com.discord.widgets.servers.guild_role_subscription.ServerSettingsGuildRoleSubscriptionTierAdapter$setItems$1, reason: invalid class name */
    /* JADX INFO: compiled from: ServerSettingsGuildRoleSubscriptionTierAdapter.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<List<? extends ServerSettingsGuildRoleSubscriptionTierAdapter2>, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(List<? extends ServerSettingsGuildRoleSubscriptionTierAdapter2> list) {
            invoke2(list);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(List<? extends ServerSettingsGuildRoleSubscriptionTierAdapter2> list) {
            Intrinsics3.checkNotNullParameter(list, "items");
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
        ServerSettingsGuildRoleSubscriptionTierAdapter2 serverSettingsGuildRoleSubscriptionTierAdapter2 = this.items.get(position);
        if (serverSettingsGuildRoleSubscriptionTierAdapter2 instanceof ServerSettingsGuildRoleSubscriptionTierAdapter2.Tier) {
            return 0;
        }
        if (serverSettingsGuildRoleSubscriptionTierAdapter2 instanceof ServerSettingsGuildRoleSubscriptionTierAdapter2.AddTier) {
            return 1;
        }
        throw new NoWhenBranchMatchedException();
    }

    public final void setItemClickListener(ItemClickListener itemClickListener) {
        Intrinsics3.checkNotNullParameter(itemClickListener, "itemClickListener");
        this.itemClickListener = itemClickListener;
    }

    public final void setItems(List<? extends ServerSettingsGuildRoleSubscriptionTierAdapter2> newItems) {
        Intrinsics3.checkNotNullParameter(newItems, "newItems");
        this.diffCreator.dispatchDiffUpdates(this, new AnonymousClass1(), this.items, newItems);
    }

    public ServerSettingsGuildRoleSubscriptionTierAdapter(AppComponent appComponent, DiffCreator<List<ServerSettingsGuildRoleSubscriptionTierAdapter2>, ServerSettingsGuildRoleSubscriptionTierAdapter3> diffCreator) {
        Intrinsics3.checkNotNullParameter(appComponent, "appComponent");
        Intrinsics3.checkNotNullParameter(diffCreator, "diffCreator");
        this.diffCreator = diffCreator;
        this.items = Collections2.emptyList();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(ServerSettingsGuildRoleSubscriptionTierAdapter3 holder, int position) {
        Intrinsics3.checkNotNullParameter(holder, "holder");
        ServerSettingsGuildRoleSubscriptionTierAdapter2 serverSettingsGuildRoleSubscriptionTierAdapter2 = this.items.get(position);
        if ((holder instanceof ServerSettingsGuildRoleSubscriptionTierAdapter3.TierItemViewHolder) && (serverSettingsGuildRoleSubscriptionTierAdapter2 instanceof ServerSettingsGuildRoleSubscriptionTierAdapter2.Tier)) {
            ServerSettingsGuildRoleSubscriptionTierAdapter3.TierItemViewHolder tierItemViewHolder = (ServerSettingsGuildRoleSubscriptionTierAdapter3.TierItemViewHolder) holder;
            ServerSettingsGuildRoleSubscriptionTierAdapter2.Tier tier = (ServerSettingsGuildRoleSubscriptionTierAdapter2.Tier) serverSettingsGuildRoleSubscriptionTierAdapter2;
            ItemClickListener itemClickListener = this.itemClickListener;
            if (itemClickListener == null) {
                Intrinsics3.throwUninitializedPropertyAccessException("itemClickListener");
            }
            tierItemViewHolder.configureUI(tier, itemClickListener);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public ServerSettingsGuildRoleSubscriptionTierAdapter3 onCreateViewHolder(ViewGroup parent, int viewType) {
        ServerSettingsGuildRoleSubscriptionTierAdapter3 tierItemViewHolder;
        Intrinsics3.checkNotNullParameter(parent, "parent");
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(parent.getContext());
        if (viewType != 0) {
            if (viewType != 1) {
                Context context = parent.getContext();
                Intrinsics3.checkNotNullExpressionValue(context, "parent.context");
                throw new IllegalArgumentException(FormatUtils.b(context, R.string.android_unknown_view_holder, new Object[]{Integer.valueOf(viewType)}, (4 & 4) != 0 ? FormatUtils.b.j : null).toString());
            }
            View viewInflate = layoutInflaterFrom.inflate(R.layout.view_server_settings_guild_role_subscription_add_tier_item, parent, false);
            int i = R.id.guild_role_subscription_add_tier_image;
            ImageView imageView = (ImageView) viewInflate.findViewById(R.id.guild_role_subscription_add_tier_image);
            if (imageView != null) {
                i = R.id.guild_role_subscription_add_tier_text;
                TextView textView = (TextView) viewInflate.findViewById(R.id.guild_role_subscription_add_tier_text);
                if (textView != null) {
                    ViewServerSettingsGuildRoleSubscriptionAddTierItemBinding viewServerSettingsGuildRoleSubscriptionAddTierItemBinding = new ViewServerSettingsGuildRoleSubscriptionAddTierItemBinding((ConstraintLayout) viewInflate, imageView, textView);
                    Intrinsics3.checkNotNullExpressionValue(viewServerSettingsGuildRoleSubscriptionAddTierItemBinding, "ViewServerSettingsGuildR…rent, false\n            )");
                    ItemClickListener itemClickListener = this.itemClickListener;
                    if (itemClickListener == null) {
                        Intrinsics3.throwUninitializedPropertyAccessException("itemClickListener");
                    }
                    tierItemViewHolder = new ServerSettingsGuildRoleSubscriptionTierAdapter3.AddTierItemViewHolder(viewServerSettingsGuildRoleSubscriptionAddTierItemBinding, itemClickListener);
                }
            }
            throw new NullPointerException("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i)));
        }
        View viewInflate2 = layoutInflaterFrom.inflate(R.layout.view_server_settings_guild_role_subscription_tier_item, parent, false);
        int i2 = R.id.guild_role_subscription_tier_draft_tag;
        TextView textView2 = (TextView) viewInflate2.findViewById(R.id.guild_role_subscription_tier_draft_tag);
        if (textView2 != null) {
            i2 = R.id.guild_role_subscription_tier_edit;
            ImageView imageView2 = (ImageView) viewInflate2.findViewById(R.id.guild_role_subscription_tier_edit);
            if (imageView2 != null) {
                i2 = R.id.guild_role_subscription_tier_icon;
                SimpleDraweeView simpleDraweeView = (SimpleDraweeView) viewInflate2.findViewById(R.id.guild_role_subscription_tier_icon);
                if (simpleDraweeView != null) {
                    i2 = R.id.guild_role_subscription_tier_name;
                    TextView textView3 = (TextView) viewInflate2.findViewById(R.id.guild_role_subscription_tier_name);
                    if (textView3 != null) {
                        i2 = R.id.guild_role_subscription_tier_price;
                        TextView textView4 = (TextView) viewInflate2.findViewById(R.id.guild_role_subscription_tier_price);
                        if (textView4 != null) {
                            ViewServerSettingsGuildRoleSubscriptionTierItemBinding viewServerSettingsGuildRoleSubscriptionTierItemBinding = new ViewServerSettingsGuildRoleSubscriptionTierItemBinding((ConstraintLayout) viewInflate2, textView2, imageView2, simpleDraweeView, textView3, textView4);
                            Intrinsics3.checkNotNullExpressionValue(viewServerSettingsGuildRoleSubscriptionTierItemBinding, "ViewServerSettingsGuildR…(inflater, parent, false)");
                            tierItemViewHolder = new ServerSettingsGuildRoleSubscriptionTierAdapter3.TierItemViewHolder(viewServerSettingsGuildRoleSubscriptionTierItemBinding);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(viewInflate2.getResources().getResourceName(i2)));
        return tierItemViewHolder;
    }
}
