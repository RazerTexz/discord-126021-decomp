package com.discord.widgets.guild_role_subscriptions.tier.create.benefits;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView$Adapter;
import androidx.recyclerview.widget.RecyclerView$ViewHolder;
import b.a.k.b;
import b.d.b.a.a;
import com.discord.R$id;
import com.discord.R$layout;
import com.discord.app.AppComponent;
import com.discord.app.AppLog;
import com.discord.databinding.ViewGuildRoleSubscriptionAddBenefitItemBinding;
import com.discord.databinding.ViewGuildRoleSubscriptionFreeTrialItemBinding;
import com.discord.databinding.ViewGuildRoleSubscriptionSectionHeaderItemBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.logging.Logger;
import com.discord.utilities.recycler.DiffCreator;
import com.discord.utilities.views.StickyHeaderItemDecoration$StickyHeaderAdapter;
import com.discord.views.CheckedSetting;
import com.discord.widgets.guild_role_subscriptions.GuildRoleSubscriptionBenefitItemView;
import d0.t.n;
import d0.z.d.m;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Objects;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: GuildRoleSubscriptionBenefitAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class GuildRoleSubscriptionBenefitAdapter extends RecyclerView$Adapter<GuildRoleSubscriptionBenefitViewHolder> implements StickyHeaderItemDecoration$StickyHeaderAdapter {
    public static final GuildRoleSubscriptionBenefitAdapter$Companion Companion = new GuildRoleSubscriptionBenefitAdapter$Companion(null);
    private static final int VIEW_TYPE_ADD_ITEM = 3;
    private static final int VIEW_TYPE_BENEFIT = 0;
    private static final int VIEW_TYPE_HEADER = 2;
    private static final int VIEW_TYPE_TRIALS = 4;
    private final DiffCreator<List<GuildRoleSubscriptionBenefitAdapterItem>, GuildRoleSubscriptionBenefitViewHolder> diffCreator;
    private List<Integer> headerIndices;
    private List<? extends GuildRoleSubscriptionBenefitAdapterItem> items;
    private final GuildRoleSubscriptionBenefitAdapter$Listener listener;
    private GuildRoleSubscriptionBenefitAdapter$StickyHeadersManager stickyHeaderManager;

    public /* synthetic */ GuildRoleSubscriptionBenefitAdapter(GuildRoleSubscriptionBenefitAdapter$Listener guildRoleSubscriptionBenefitAdapter$Listener, AppComponent appComponent, DiffCreator diffCreator, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(guildRoleSubscriptionBenefitAdapter$Listener, appComponent, (i & 4) != 0 ? new DiffCreator(appComponent) : diffCreator);
    }

    public static final /* synthetic */ List access$getItems$p(GuildRoleSubscriptionBenefitAdapter guildRoleSubscriptionBenefitAdapter) {
        return guildRoleSubscriptionBenefitAdapter.items;
    }

    public static final /* synthetic */ void access$setItems$p(GuildRoleSubscriptionBenefitAdapter guildRoleSubscriptionBenefitAdapter, List list) {
        guildRoleSubscriptionBenefitAdapter.items = list;
    }

    public final void clearItems() {
        setItems(n.emptyList());
    }

    @Override // com.discord.utilities.views.StickyHeaderItemDecoration$StickyHeaderAdapter
    public View getAndBindHeaderView(int position) {
        GuildRoleSubscriptionBenefitViewHolder$HeaderViewHolder stickyHeaderHolder;
        GuildRoleSubscriptionBenefitAdapterItem guildRoleSubscriptionBenefitAdapterItem = this.items.get(position);
        GuildRoleSubscriptionBenefitAdapter$StickyHeadersManager guildRoleSubscriptionBenefitAdapter$StickyHeadersManager = this.stickyHeaderManager;
        if (guildRoleSubscriptionBenefitAdapter$StickyHeadersManager != null && (stickyHeaderHolder = guildRoleSubscriptionBenefitAdapter$StickyHeadersManager.getStickyHeaderHolder()) != null) {
            Objects.requireNonNull(guildRoleSubscriptionBenefitAdapterItem, "null cannot be cast to non-null type com.discord.widgets.guild_role_subscriptions.tier.create.benefits.GuildRoleSubscriptionBenefitAdapterItem.Header");
            stickyHeaderHolder.configure((GuildRoleSubscriptionBenefitAdapterItem$Header) guildRoleSubscriptionBenefitAdapterItem);
        }
        GuildRoleSubscriptionBenefitAdapter$StickyHeadersManager guildRoleSubscriptionBenefitAdapter$StickyHeadersManager2 = this.stickyHeaderManager;
        if (guildRoleSubscriptionBenefitAdapter$StickyHeadersManager2 != null) {
            return guildRoleSubscriptionBenefitAdapter$StickyHeadersManager2.getCurrentStickyHeaderView();
        }
        return null;
    }

    @Override // com.discord.utilities.views.StickyHeaderItemDecoration$StickyHeaderAdapter
    public Integer getHeaderPositionForItem(int itemPosition) {
        Integer numPrevious;
        List<Integer> list = this.headerIndices;
        ListIterator<Integer> listIterator = list.listIterator(list.size());
        do {
            if (!listIterator.hasPrevious()) {
                numPrevious = null;
                break;
            }
            numPrevious = listIterator.previous();
        } while (!(itemPosition >= numPrevious.intValue()));
        Integer num = numPrevious;
        if (num == null) {
            AppLog appLog = AppLog.g;
            StringBuilder sbU = a.U("failed to find header position for item in ");
            sbU.append(GuildRoleSubscriptionBenefitAdapter.class.getName());
            Logger.e$default(appLog, sbU.toString(), null, null, 6, null);
        }
        return num;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$Adapter
    public int getItemCount() {
        return this.items.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView$Adapter
    public int getItemViewType(int position) {
        GuildRoleSubscriptionBenefitAdapterItem guildRoleSubscriptionBenefitAdapterItem = this.items.get(position);
        if (guildRoleSubscriptionBenefitAdapterItem instanceof GuildRoleSubscriptionBenefitAdapterItem$AddBenefitItem) {
            return 3;
        }
        if (guildRoleSubscriptionBenefitAdapterItem instanceof GuildRoleSubscriptionBenefitAdapterItem$BenefitItem) {
            return 0;
        }
        if (guildRoleSubscriptionBenefitAdapterItem instanceof GuildRoleSubscriptionBenefitAdapterItem$Header) {
            return 2;
        }
        if (guildRoleSubscriptionBenefitAdapterItem instanceof GuildRoleSubscriptionBenefitAdapterItem$FreeTrialItem) {
            return 4;
        }
        throw new NoWhenBranchMatchedException();
    }

    @Override // com.discord.utilities.views.StickyHeaderItemDecoration$StickyHeaderAdapter
    public boolean isHeader(int position) {
        return this.items.get(position) instanceof GuildRoleSubscriptionBenefitAdapterItem$Header;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$Adapter
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        m.checkNotNullParameter(recyclerView, "recyclerView");
        super.onAttachedToRecyclerView(recyclerView);
        GuildRoleSubscriptionBenefitAdapter$StickyHeadersManager guildRoleSubscriptionBenefitAdapter$StickyHeadersManager = new GuildRoleSubscriptionBenefitAdapter$StickyHeadersManager(recyclerView);
        recyclerView.addOnLayoutChangeListener(new GuildRoleSubscriptionBenefitAdapter$onAttachedToRecyclerView$$inlined$also$lambda$1(guildRoleSubscriptionBenefitAdapter$StickyHeadersManager, recyclerView));
        this.stickyHeaderManager = guildRoleSubscriptionBenefitAdapter$StickyHeadersManager;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$Adapter
    public /* bridge */ /* synthetic */ void onBindViewHolder(RecyclerView$ViewHolder recyclerView$ViewHolder, int i) {
        onBindViewHolder((GuildRoleSubscriptionBenefitViewHolder) recyclerView$ViewHolder, i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$Adapter
    public /* bridge */ /* synthetic */ RecyclerView$ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return onCreateViewHolder(viewGroup, i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$Adapter
    public void onDetachedFromRecyclerView(RecyclerView recyclerView) {
        m.checkNotNullParameter(recyclerView, "recyclerView");
        super.onDetachedFromRecyclerView(recyclerView);
        this.stickyHeaderManager = null;
    }

    public final void setItems(List<? extends GuildRoleSubscriptionBenefitAdapterItem> newItems) {
        m.checkNotNullParameter(newItems, "newItems");
        this.diffCreator.dispatchDiffUpdates(this, new GuildRoleSubscriptionBenefitAdapter$setItems$1(this), this.items, newItems);
        ArrayList arrayList = new ArrayList();
        int i = 0;
        for (Object obj : newItems) {
            int i2 = i + 1;
            if (i < 0) {
                n.throwIndexOverflow();
            }
            Integer numValueOf = ((GuildRoleSubscriptionBenefitAdapterItem) obj) instanceof GuildRoleSubscriptionBenefitAdapterItem$Header ? Integer.valueOf(i) : null;
            if (numValueOf != null) {
                arrayList.add(numValueOf);
            }
            i = i2;
        }
        this.headerIndices = arrayList;
    }

    public GuildRoleSubscriptionBenefitAdapter(GuildRoleSubscriptionBenefitAdapter$Listener guildRoleSubscriptionBenefitAdapter$Listener, AppComponent appComponent, DiffCreator<List<GuildRoleSubscriptionBenefitAdapterItem>, GuildRoleSubscriptionBenefitViewHolder> diffCreator) {
        m.checkNotNullParameter(guildRoleSubscriptionBenefitAdapter$Listener, "listener");
        m.checkNotNullParameter(appComponent, "appComponent");
        m.checkNotNullParameter(diffCreator, "diffCreator");
        this.listener = guildRoleSubscriptionBenefitAdapter$Listener;
        this.diffCreator = diffCreator;
        this.items = n.emptyList();
        this.headerIndices = n.emptyList();
    }

    public void onBindViewHolder(GuildRoleSubscriptionBenefitViewHolder holder, int position) {
        m.checkNotNullParameter(holder, "holder");
        holder.configure(this.items.get(position));
    }

    @Override // androidx.recyclerview.widget.RecyclerView$Adapter
    public GuildRoleSubscriptionBenefitViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        m.checkNotNullParameter(parent, "parent");
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(parent.getContext());
        if (viewType == 0) {
            Context context = parent.getContext();
            m.checkNotNullExpressionValue(context, "parent.context");
            return new GuildRoleSubscriptionBenefitViewHolder$ItemViewHolder(new GuildRoleSubscriptionBenefitItemView(context), this.listener);
        }
        if (viewType == 2) {
            ViewGuildRoleSubscriptionSectionHeaderItemBinding viewGuildRoleSubscriptionSectionHeaderItemBindingA = ViewGuildRoleSubscriptionSectionHeaderItemBinding.a(layoutInflaterFrom, parent, false);
            m.checkNotNullExpressionValue(viewGuildRoleSubscriptionSectionHeaderItemBindingA, "ViewGuildRoleSubscriptio…(inflater, parent, false)");
            return new GuildRoleSubscriptionBenefitViewHolder$HeaderViewHolder(viewGuildRoleSubscriptionSectionHeaderItemBindingA);
        }
        if (viewType == 3) {
            View viewInflate = layoutInflaterFrom.inflate(R$layout.view_guild_role_subscription_add_benefit_item, parent, false);
            int i = R$id.guild_role_subscription_add_benefit_image_circle;
            View viewFindViewById = viewInflate.findViewById(R$id.guild_role_subscription_add_benefit_image_circle);
            if (viewFindViewById != null) {
                i = R$id.guild_role_subscription_add_benefit_text;
                TextView textView = (TextView) viewInflate.findViewById(R$id.guild_role_subscription_add_benefit_text);
                if (textView != null) {
                    ViewGuildRoleSubscriptionAddBenefitItemBinding viewGuildRoleSubscriptionAddBenefitItemBinding = new ViewGuildRoleSubscriptionAddBenefitItemBinding((ConstraintLayout) viewInflate, viewFindViewById, textView);
                    m.checkNotNullExpressionValue(viewGuildRoleSubscriptionAddBenefitItemBinding, "ViewGuildRoleSubscriptio…(inflater, parent, false)");
                    return new GuildRoleSubscriptionBenefitViewHolder$AddItemViewHolder(viewGuildRoleSubscriptionAddBenefitItemBinding, this.listener);
                }
            }
            throw new NullPointerException("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i)));
        }
        if (viewType != 4) {
            Context context2 = parent.getContext();
            m.checkNotNullExpressionValue(context2, "parent.context");
            throw new IllegalArgumentException(b.h(context2, 2131886424, new Object[]{Integer.valueOf(viewType)}, null, 4).toString());
        }
        View viewInflate2 = layoutInflaterFrom.inflate(R$layout.view_guild_role_subscription_free_trial_item, parent, false);
        int i2 = R$id.guild_role_subscription_active_user_limit_description;
        TextView textView2 = (TextView) viewInflate2.findViewById(R$id.guild_role_subscription_active_user_limit_description);
        if (textView2 != null) {
            i2 = R$id.guild_role_subscription_active_user_limit_dropdown;
            TextView textView3 = (TextView) viewInflate2.findViewById(R$id.guild_role_subscription_active_user_limit_dropdown);
            if (textView3 != null) {
                i2 = R$id.guild_role_subscription_active_user_limit_title;
                TextView textView4 = (TextView) viewInflate2.findViewById(R$id.guild_role_subscription_active_user_limit_title);
                if (textView4 != null) {
                    i2 = R$id.guild_role_subscription_free_trial_enable_toggle;
                    CheckedSetting checkedSetting = (CheckedSetting) viewInflate2.findViewById(R$id.guild_role_subscription_free_trial_enable_toggle);
                    if (checkedSetting != null) {
                        i2 = R$id.guild_role_subscription_free_trial_subtitle;
                        TextView textView5 = (TextView) viewInflate2.findViewById(R$id.guild_role_subscription_free_trial_subtitle);
                        if (textView5 != null) {
                            i2 = R$id.guild_role_subscription_time_limit_description;
                            TextView textView6 = (TextView) viewInflate2.findViewById(R$id.guild_role_subscription_time_limit_description);
                            if (textView6 != null) {
                                i2 = R$id.guild_role_subscription_time_limit_dropdown;
                                TextView textView7 = (TextView) viewInflate2.findViewById(R$id.guild_role_subscription_time_limit_dropdown);
                                if (textView7 != null) {
                                    i2 = R$id.guild_role_subscription_time_limit_title;
                                    TextView textView8 = (TextView) viewInflate2.findViewById(R$id.guild_role_subscription_time_limit_title);
                                    if (textView8 != null) {
                                        ViewGuildRoleSubscriptionFreeTrialItemBinding viewGuildRoleSubscriptionFreeTrialItemBinding = new ViewGuildRoleSubscriptionFreeTrialItemBinding((LinearLayout) viewInflate2, textView2, textView3, textView4, checkedSetting, textView5, textView6, textView7, textView8);
                                        m.checkNotNullExpressionValue(viewGuildRoleSubscriptionFreeTrialItemBinding, "ViewGuildRoleSubscriptio…(inflater, parent, false)");
                                        return new GuildRoleSubscriptionBenefitViewHolder$FreeTrialViewHolder(viewGuildRoleSubscriptionFreeTrialItemBinding, this.listener);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(viewInflate2.getResources().getResourceName(i2)));
    }
}
