package com.discord.widgets.guild_role_subscriptions.tier.create.benefits;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import b.a.k.FormatUtils;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.app.AppComponent;
import com.discord.app.AppLog;
import com.discord.databinding.ViewGuildRoleSubscriptionAddBenefitItemBinding;
import com.discord.databinding.ViewGuildRoleSubscriptionFreeTrialItemBinding;
import com.discord.databinding.ViewGuildRoleSubscriptionSectionHeaderItemBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.logging.Logger;
import com.discord.utilities.recycler.DiffCreator;
import com.discord.utilities.views.StickyHeaderItemDecoration;
import com.discord.views.CheckedSetting;
import com.discord.widgets.guild_role_subscriptions.GuildRoleSubscriptionBenefitItemView;
import com.discord.widgets.guild_role_subscriptions.tier.create.benefits.GuildRoleSubscriptionBenefitAdapterItem;
import com.discord.widgets.guild_role_subscriptions.tier.create.benefits.GuildRoleSubscriptionBenefitViewHolder;
import d0.t.Collections2;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Objects;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: GuildRoleSubscriptionBenefitAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class GuildRoleSubscriptionBenefitAdapter extends RecyclerView.Adapter<GuildRoleSubscriptionBenefitViewHolder> implements StickyHeaderItemDecoration.StickyHeaderAdapter {
    private static final int VIEW_TYPE_ADD_ITEM = 3;
    private static final int VIEW_TYPE_BENEFIT = 0;
    private static final int VIEW_TYPE_HEADER = 2;
    private static final int VIEW_TYPE_TRIALS = 4;
    private final DiffCreator<List<GuildRoleSubscriptionBenefitAdapterItem>, GuildRoleSubscriptionBenefitViewHolder> diffCreator;
    private List<Integer> headerIndices;
    private List<? extends GuildRoleSubscriptionBenefitAdapterItem> items;
    private final Listener listener;
    private StickyHeadersManager stickyHeaderManager;

    /* JADX INFO: compiled from: GuildRoleSubscriptionBenefitAdapter.kt */
    public interface Listener {
        void onActiveTrialUserLimitClick();

        void onAddBenefitItemClick(GuildRoleSubscriptionBenefitAdapterItem.AddBenefitItem benefitAdapterItem);

        void onBenefitItemClick(GuildRoleSubscriptionBenefitAdapterItem benefitAdapterItem);

        void onFreeTrialToggle(boolean isEnabled);

        void onTrialIntervalClick();
    }

    /* JADX INFO: compiled from: GuildRoleSubscriptionBenefitAdapter.kt */
    public static final class StickyHeadersManager {
        private final View currentStickyHeaderView;
        private final GuildRoleSubscriptionBenefitViewHolder.HeaderViewHolder stickyHeaderHolder;

        public StickyHeadersManager(RecyclerView recyclerView) {
            Intrinsics3.checkNotNullParameter(recyclerView, "recyclerView");
            ViewGuildRoleSubscriptionSectionHeaderItemBinding viewGuildRoleSubscriptionSectionHeaderItemBindingA = ViewGuildRoleSubscriptionSectionHeaderItemBinding.a(LayoutInflater.from(recyclerView.getContext()), recyclerView, false);
            Intrinsics3.checkNotNullExpressionValue(viewGuildRoleSubscriptionSectionHeaderItemBindingA, "ViewGuildRoleSubscriptio…          false\n        )");
            GuildRoleSubscriptionBenefitViewHolder.HeaderViewHolder headerViewHolder = new GuildRoleSubscriptionBenefitViewHolder.HeaderViewHolder(viewGuildRoleSubscriptionSectionHeaderItemBindingA);
            this.stickyHeaderHolder = headerViewHolder;
            View view = headerViewHolder.itemView;
            Intrinsics3.checkNotNullExpressionValue(view, "stickyHeaderHolder.itemView");
            this.currentStickyHeaderView = view;
        }

        public final View getCurrentStickyHeaderView() {
            return this.currentStickyHeaderView;
        }

        public final GuildRoleSubscriptionBenefitViewHolder.HeaderViewHolder getStickyHeaderHolder() {
            return this.stickyHeaderHolder;
        }

        public final void layoutViews(RecyclerView recyclerView) {
            Intrinsics3.checkNotNullParameter(recyclerView, "recyclerView");
            StickyHeaderItemDecoration.LayoutManager.layoutHeaderView(recyclerView, this.currentStickyHeaderView);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.guild_role_subscriptions.tier.create.benefits.GuildRoleSubscriptionBenefitAdapter$setItems$1, reason: invalid class name */
    /* JADX INFO: compiled from: GuildRoleSubscriptionBenefitAdapter.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<List<? extends GuildRoleSubscriptionBenefitAdapterItem>, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(List<? extends GuildRoleSubscriptionBenefitAdapterItem> list) {
            invoke2(list);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(List<? extends GuildRoleSubscriptionBenefitAdapterItem> list) {
            Intrinsics3.checkNotNullParameter(list, "itemsToDispatch");
            GuildRoleSubscriptionBenefitAdapter.this.items = list;
        }
    }

    public /* synthetic */ GuildRoleSubscriptionBenefitAdapter(Listener listener, AppComponent appComponent, DiffCreator diffCreator, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(listener, appComponent, (i & 4) != 0 ? new DiffCreator(appComponent) : diffCreator);
    }

    public final void clearItems() {
        setItems(Collections2.emptyList());
    }

    @Override // com.discord.utilities.views.StickyHeaderItemDecoration.StickyHeaderAdapter
    public View getAndBindHeaderView(int position) {
        GuildRoleSubscriptionBenefitViewHolder.HeaderViewHolder stickyHeaderHolder;
        GuildRoleSubscriptionBenefitAdapterItem guildRoleSubscriptionBenefitAdapterItem = this.items.get(position);
        StickyHeadersManager stickyHeadersManager = this.stickyHeaderManager;
        if (stickyHeadersManager != null && (stickyHeaderHolder = stickyHeadersManager.getStickyHeaderHolder()) != null) {
            Objects.requireNonNull(guildRoleSubscriptionBenefitAdapterItem, "null cannot be cast to non-null type com.discord.widgets.guild_role_subscriptions.tier.create.benefits.GuildRoleSubscriptionBenefitAdapterItem.Header");
            stickyHeaderHolder.configure((GuildRoleSubscriptionBenefitAdapterItem.Header) guildRoleSubscriptionBenefitAdapterItem);
        }
        StickyHeadersManager stickyHeadersManager2 = this.stickyHeaderManager;
        if (stickyHeadersManager2 != null) {
            return stickyHeadersManager2.getCurrentStickyHeaderView();
        }
        return null;
    }

    @Override // com.discord.utilities.views.StickyHeaderItemDecoration.StickyHeaderAdapter
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
            StringBuilder sbU = outline.U("failed to find header position for item in ");
            sbU.append(GuildRoleSubscriptionBenefitAdapter.class.getName());
            Logger.e$default(appLog, sbU.toString(), null, null, 6, null);
        }
        return num;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* JADX INFO: renamed from: getItemCount */
    public int getPageSize() {
        return this.items.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int position) {
        GuildRoleSubscriptionBenefitAdapterItem guildRoleSubscriptionBenefitAdapterItem = this.items.get(position);
        if (guildRoleSubscriptionBenefitAdapterItem instanceof GuildRoleSubscriptionBenefitAdapterItem.AddBenefitItem) {
            return 3;
        }
        if (guildRoleSubscriptionBenefitAdapterItem instanceof GuildRoleSubscriptionBenefitAdapterItem.BenefitItem) {
            return 0;
        }
        if (guildRoleSubscriptionBenefitAdapterItem instanceof GuildRoleSubscriptionBenefitAdapterItem.Header) {
            return 2;
        }
        if (guildRoleSubscriptionBenefitAdapterItem instanceof GuildRoleSubscriptionBenefitAdapterItem.FreeTrialItem) {
            return 4;
        }
        throw new NoWhenBranchMatchedException();
    }

    @Override // com.discord.utilities.views.StickyHeaderItemDecoration.StickyHeaderAdapter
    public boolean isHeader(int position) {
        return this.items.get(position) instanceof GuildRoleSubscriptionBenefitAdapterItem.Header;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onAttachedToRecyclerView(final RecyclerView recyclerView) {
        Intrinsics3.checkNotNullParameter(recyclerView, "recyclerView");
        super.onAttachedToRecyclerView(recyclerView);
        final StickyHeadersManager stickyHeadersManager = new StickyHeadersManager(recyclerView);
        recyclerView.addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: com.discord.widgets.guild_role_subscriptions.tier.create.benefits.GuildRoleSubscriptionBenefitAdapter$onAttachedToRecyclerView$$inlined$also$lambda$1
            @Override // android.view.View.OnLayoutChangeListener
            public final void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
                stickyHeadersManager.layoutViews(recyclerView);
            }
        });
        this.stickyHeaderManager = stickyHeadersManager;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onDetachedFromRecyclerView(RecyclerView recyclerView) {
        Intrinsics3.checkNotNullParameter(recyclerView, "recyclerView");
        super.onDetachedFromRecyclerView(recyclerView);
        this.stickyHeaderManager = null;
    }

    public final void setItems(List<? extends GuildRoleSubscriptionBenefitAdapterItem> newItems) {
        Intrinsics3.checkNotNullParameter(newItems, "newItems");
        this.diffCreator.dispatchDiffUpdates(this, new AnonymousClass1(), this.items, newItems);
        ArrayList arrayList = new ArrayList();
        int i = 0;
        for (Object obj : newItems) {
            int i2 = i + 1;
            if (i < 0) {
                Collections2.throwIndexOverflow();
            }
            Integer numValueOf = ((GuildRoleSubscriptionBenefitAdapterItem) obj) instanceof GuildRoleSubscriptionBenefitAdapterItem.Header ? Integer.valueOf(i) : null;
            if (numValueOf != null) {
                arrayList.add(numValueOf);
            }
            i = i2;
        }
        this.headerIndices = arrayList;
    }

    public GuildRoleSubscriptionBenefitAdapter(Listener listener, AppComponent appComponent, DiffCreator<List<GuildRoleSubscriptionBenefitAdapterItem>, GuildRoleSubscriptionBenefitViewHolder> diffCreator) {
        Intrinsics3.checkNotNullParameter(listener, "listener");
        Intrinsics3.checkNotNullParameter(appComponent, "appComponent");
        Intrinsics3.checkNotNullParameter(diffCreator, "diffCreator");
        this.listener = listener;
        this.diffCreator = diffCreator;
        this.items = Collections2.emptyList();
        this.headerIndices = Collections2.emptyList();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(GuildRoleSubscriptionBenefitViewHolder holder, int position) {
        Intrinsics3.checkNotNullParameter(holder, "holder");
        holder.configure(this.items.get(position));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public GuildRoleSubscriptionBenefitViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics3.checkNotNullParameter(parent, "parent");
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(parent.getContext());
        if (viewType == 0) {
            Context context = parent.getContext();
            Intrinsics3.checkNotNullExpressionValue(context, "parent.context");
            return new GuildRoleSubscriptionBenefitViewHolder.ItemViewHolder(new GuildRoleSubscriptionBenefitItemView(context), this.listener);
        }
        if (viewType == 2) {
            ViewGuildRoleSubscriptionSectionHeaderItemBinding viewGuildRoleSubscriptionSectionHeaderItemBindingA = ViewGuildRoleSubscriptionSectionHeaderItemBinding.a(layoutInflaterFrom, parent, false);
            Intrinsics3.checkNotNullExpressionValue(viewGuildRoleSubscriptionSectionHeaderItemBindingA, "ViewGuildRoleSubscriptio…(inflater, parent, false)");
            return new GuildRoleSubscriptionBenefitViewHolder.HeaderViewHolder(viewGuildRoleSubscriptionSectionHeaderItemBindingA);
        }
        if (viewType == 3) {
            View viewInflate = layoutInflaterFrom.inflate(R.layout.view_guild_role_subscription_add_benefit_item, parent, false);
            int i = R.id.guild_role_subscription_add_benefit_image_circle;
            View viewFindViewById = viewInflate.findViewById(R.id.guild_role_subscription_add_benefit_image_circle);
            if (viewFindViewById != null) {
                i = R.id.guild_role_subscription_add_benefit_text;
                TextView textView = (TextView) viewInflate.findViewById(R.id.guild_role_subscription_add_benefit_text);
                if (textView != null) {
                    ViewGuildRoleSubscriptionAddBenefitItemBinding viewGuildRoleSubscriptionAddBenefitItemBinding = new ViewGuildRoleSubscriptionAddBenefitItemBinding((ConstraintLayout) viewInflate, viewFindViewById, textView);
                    Intrinsics3.checkNotNullExpressionValue(viewGuildRoleSubscriptionAddBenefitItemBinding, "ViewGuildRoleSubscriptio…(inflater, parent, false)");
                    return new GuildRoleSubscriptionBenefitViewHolder.AddItemViewHolder(viewGuildRoleSubscriptionAddBenefitItemBinding, this.listener);
                }
            }
            throw new NullPointerException("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i)));
        }
        if (viewType != 4) {
            Context context2 = parent.getContext();
            Intrinsics3.checkNotNullExpressionValue(context2, "parent.context");
            throw new IllegalArgumentException(FormatUtils.b(context2, R.string.android_unknown_view_holder, new Object[]{Integer.valueOf(viewType)}, (4 & 4) != 0 ? FormatUtils.b.j : null).toString());
        }
        View viewInflate2 = layoutInflaterFrom.inflate(R.layout.view_guild_role_subscription_free_trial_item, parent, false);
        int i2 = R.id.guild_role_subscription_active_user_limit_description;
        TextView textView2 = (TextView) viewInflate2.findViewById(R.id.guild_role_subscription_active_user_limit_description);
        if (textView2 != null) {
            i2 = R.id.guild_role_subscription_active_user_limit_dropdown;
            TextView textView3 = (TextView) viewInflate2.findViewById(R.id.guild_role_subscription_active_user_limit_dropdown);
            if (textView3 != null) {
                i2 = R.id.guild_role_subscription_active_user_limit_title;
                TextView textView4 = (TextView) viewInflate2.findViewById(R.id.guild_role_subscription_active_user_limit_title);
                if (textView4 != null) {
                    i2 = R.id.guild_role_subscription_free_trial_enable_toggle;
                    CheckedSetting checkedSetting = (CheckedSetting) viewInflate2.findViewById(R.id.guild_role_subscription_free_trial_enable_toggle);
                    if (checkedSetting != null) {
                        i2 = R.id.guild_role_subscription_free_trial_subtitle;
                        TextView textView5 = (TextView) viewInflate2.findViewById(R.id.guild_role_subscription_free_trial_subtitle);
                        if (textView5 != null) {
                            i2 = R.id.guild_role_subscription_time_limit_description;
                            TextView textView6 = (TextView) viewInflate2.findViewById(R.id.guild_role_subscription_time_limit_description);
                            if (textView6 != null) {
                                i2 = R.id.guild_role_subscription_time_limit_dropdown;
                                TextView textView7 = (TextView) viewInflate2.findViewById(R.id.guild_role_subscription_time_limit_dropdown);
                                if (textView7 != null) {
                                    i2 = R.id.guild_role_subscription_time_limit_title;
                                    TextView textView8 = (TextView) viewInflate2.findViewById(R.id.guild_role_subscription_time_limit_title);
                                    if (textView8 != null) {
                                        ViewGuildRoleSubscriptionFreeTrialItemBinding viewGuildRoleSubscriptionFreeTrialItemBinding = new ViewGuildRoleSubscriptionFreeTrialItemBinding((LinearLayout) viewInflate2, textView2, textView3, textView4, checkedSetting, textView5, textView6, textView7, textView8);
                                        Intrinsics3.checkNotNullExpressionValue(viewGuildRoleSubscriptionFreeTrialItemBinding, "ViewGuildRoleSubscriptio…(inflater, parent, false)");
                                        return new GuildRoleSubscriptionBenefitViewHolder.FreeTrialViewHolder(viewGuildRoleSubscriptionFreeTrialItemBinding, this.listener);
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
