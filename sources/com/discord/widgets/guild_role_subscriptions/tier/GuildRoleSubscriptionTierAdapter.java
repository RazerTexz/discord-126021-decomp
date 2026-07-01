package com.discord.widgets.guild_role_subscriptions.tier;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.app.AppComponent;
import com.discord.databinding.ViewGuildRoleSubscriptionPlanDetailsReviewBinding;
import com.discord.databinding.ViewGuildRoleSubscriptionSectionHeaderItemBinding;
import com.discord.databinding.ViewGuildRoleSubscriptionTierHeaderBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.recycler.DiffCreator;
import com.discord.widgets.guild_role_subscriptions.GuildRoleSubscriptionBenefitItemView;
import com.discord.widgets.guild_role_subscriptions.tier.GuildRoleSubscriptionTierAdapterItem;
import com.discord.widgets.guild_role_subscriptions.tier.GuildRoleSubscriptionTierViewHolder;
import com.discord.widgets.guild_role_subscriptions.tier.create.GuildRoleSubscriptionMemberPreview;
import com.facebook.drawee.view.SimpleDraweeView;
import d0.t.Collections2;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: GuildRoleSubscriptionTierAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class GuildRoleSubscriptionTierAdapter extends RecyclerView.Adapter<GuildRoleSubscriptionTierViewHolder> {
    public static final int VIEW_TYPE_ALL_CHANNELS_ACCESS_BENEFIT = 5;
    public static final int VIEW_TYPE_PLAN_DETAILS = 4;
    public static final int VIEW_TYPE_TIER_BENEFIT = 3;
    public static final int VIEW_TYPE_TIER_HEADER = 0;
    public static final int VIEW_TYPE_TIER_MEMBER_PREVIEW = 1;
    public static final int VIEW_TYPE_TIER_SECTION_HEADER = 2;
    private final DiffCreator<List<GuildRoleSubscriptionTierAdapterItem>, GuildRoleSubscriptionTierViewHolder> diffCreator;
    private List<? extends GuildRoleSubscriptionTierAdapterItem> items;

    /* JADX INFO: renamed from: com.discord.widgets.guild_role_subscriptions.tier.GuildRoleSubscriptionTierAdapter$setItems$1, reason: invalid class name */
    /* JADX INFO: compiled from: GuildRoleSubscriptionTierAdapter.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<List<? extends GuildRoleSubscriptionTierAdapterItem>, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(List<? extends GuildRoleSubscriptionTierAdapterItem> list) {
            invoke2(list);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(List<? extends GuildRoleSubscriptionTierAdapterItem> list) {
            Intrinsics3.checkNotNullParameter(list, "items");
            GuildRoleSubscriptionTierAdapter.this.items = list;
        }
    }

    public /* synthetic */ GuildRoleSubscriptionTierAdapter(AppComponent appComponent, DiffCreator diffCreator, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(appComponent, (i & 2) != 0 ? new DiffCreator(appComponent) : diffCreator);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* JADX INFO: renamed from: getItemCount */
    public int getPageSize() {
        return this.items.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int position) {
        GuildRoleSubscriptionTierAdapterItem guildRoleSubscriptionTierAdapterItem = this.items.get(position);
        if (guildRoleSubscriptionTierAdapterItem instanceof GuildRoleSubscriptionTierAdapterItem.Header) {
            return 0;
        }
        if (guildRoleSubscriptionTierAdapterItem instanceof GuildRoleSubscriptionTierAdapterItem.MemberPreview) {
            return 1;
        }
        if (guildRoleSubscriptionTierAdapterItem instanceof GuildRoleSubscriptionTierAdapterItem.SectionHeader) {
            return 2;
        }
        if (guildRoleSubscriptionTierAdapterItem instanceof GuildRoleSubscriptionTierAdapterItem.BenefitItem) {
            return 3;
        }
        if (guildRoleSubscriptionTierAdapterItem instanceof GuildRoleSubscriptionTierAdapterItem.PlanDetails) {
            return 4;
        }
        if (guildRoleSubscriptionTierAdapterItem instanceof GuildRoleSubscriptionTierAdapterItem.AllChannelsAccessBenefitItem) {
            return 5;
        }
        throw new NoWhenBranchMatchedException();
    }

    public final void setItems(List<? extends GuildRoleSubscriptionTierAdapterItem> newItems) {
        Intrinsics3.checkNotNullParameter(newItems, "newItems");
        this.diffCreator.dispatchDiffUpdatesAsync(this, new AnonymousClass1(), this.items, newItems);
    }

    public GuildRoleSubscriptionTierAdapter(AppComponent appComponent, DiffCreator<List<GuildRoleSubscriptionTierAdapterItem>, GuildRoleSubscriptionTierViewHolder> diffCreator) {
        Intrinsics3.checkNotNullParameter(appComponent, "appComponent");
        Intrinsics3.checkNotNullParameter(diffCreator, "diffCreator");
        this.diffCreator = diffCreator;
        this.items = Collections2.emptyList();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(GuildRoleSubscriptionTierViewHolder holder, int position) {
        Intrinsics3.checkNotNullParameter(holder, "holder");
        holder.bind(this.items.get(position));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public GuildRoleSubscriptionTierViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics3.checkNotNullParameter(parent, "parent");
        if (viewType == 0) {
            View viewInflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_guild_role_subscription_tier_header, parent, false);
            int i = R.id.guild_role_subscription_tier_header_description;
            TextView textView = (TextView) viewInflate.findViewById(R.id.guild_role_subscription_tier_header_description);
            if (textView != null) {
                i = R.id.guild_role_subscription_tier_header_image;
                SimpleDraweeView simpleDraweeView = (SimpleDraweeView) viewInflate.findViewById(R.id.guild_role_subscription_tier_header_image);
                if (simpleDraweeView != null) {
                    i = R.id.guild_role_subscription_tier_header_name;
                    TextView textView2 = (TextView) viewInflate.findViewById(R.id.guild_role_subscription_tier_header_name);
                    if (textView2 != null) {
                        i = R.id.guild_role_subscription_tier_header_price;
                        TextView textView3 = (TextView) viewInflate.findViewById(R.id.guild_role_subscription_tier_header_price);
                        if (textView3 != null) {
                            i = R.id.guild_role_subscription_tier_header_price_interval;
                            TextView textView4 = (TextView) viewInflate.findViewById(R.id.guild_role_subscription_tier_header_price_interval);
                            if (textView4 != null) {
                                i = R.id.guild_role_subscription_tier_header_subscribe;
                                Button button = (Button) viewInflate.findViewById(R.id.guild_role_subscription_tier_header_subscribe);
                                if (button != null) {
                                    ViewGuildRoleSubscriptionTierHeaderBinding viewGuildRoleSubscriptionTierHeaderBinding = new ViewGuildRoleSubscriptionTierHeaderBinding((LinearLayout) viewInflate, textView, simpleDraweeView, textView2, textView3, textView4, button);
                                    Intrinsics3.checkNotNullExpressionValue(viewGuildRoleSubscriptionTierHeaderBinding, "ViewGuildRoleSubscriptio…rent, false\n            )");
                                    return new GuildRoleSubscriptionTierViewHolder.TierHeaderViewHolder(viewGuildRoleSubscriptionTierHeaderBinding);
                                }
                            }
                        }
                    }
                }
            }
            throw new NullPointerException("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i)));
        }
        if (viewType == 1) {
            Context context = parent.getContext();
            Intrinsics3.checkNotNullExpressionValue(context, "parent.context");
            return new GuildRoleSubscriptionTierViewHolder.MemberPreviewViewHolder(new GuildRoleSubscriptionMemberPreview(context));
        }
        if (viewType == 2) {
            ViewGuildRoleSubscriptionSectionHeaderItemBinding viewGuildRoleSubscriptionSectionHeaderItemBindingA = ViewGuildRoleSubscriptionSectionHeaderItemBinding.a(LayoutInflater.from(parent.getContext()), parent, false);
            Intrinsics3.checkNotNullExpressionValue(viewGuildRoleSubscriptionSectionHeaderItemBindingA, "ViewGuildRoleSubscriptio…rent, false\n            )");
            return new GuildRoleSubscriptionTierViewHolder.SectionHeaderViewHolder(viewGuildRoleSubscriptionSectionHeaderItemBindingA);
        }
        if (viewType == 3) {
            Context context2 = parent.getContext();
            Intrinsics3.checkNotNullExpressionValue(context2, "parent.context");
            return new GuildRoleSubscriptionTierViewHolder.BenefitViewHolder(new GuildRoleSubscriptionBenefitItemView(context2));
        }
        if (viewType != 4) {
            if (viewType == 5) {
                Context context3 = parent.getContext();
                Intrinsics3.checkNotNullExpressionValue(context3, "parent.context");
                return new GuildRoleSubscriptionTierViewHolder.BenefitViewHolder(new GuildRoleSubscriptionBenefitItemView(context3));
            }
            StringBuilder sbV = outline.V("invalid viewType ", viewType, " for ");
            sbV.append(GuildRoleSubscriptionTierAdapter.class.getSimpleName());
            throw new IllegalArgumentException(sbV.toString());
        }
        View viewInflate2 = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_guild_role_subscription_plan_details_review, parent, false);
        int i2 = R.id.guild_role_subscription_plan_review_cover_image;
        SimpleDraweeView simpleDraweeView2 = (SimpleDraweeView) viewInflate2.findViewById(R.id.guild_role_subscription_plan_review_cover_image);
        if (simpleDraweeView2 != null) {
            i2 = R.id.guild_role_subscription_plan_review_description;
            TextView textView5 = (TextView) viewInflate2.findViewById(R.id.guild_role_subscription_plan_review_description);
            if (textView5 != null) {
                ViewGuildRoleSubscriptionPlanDetailsReviewBinding viewGuildRoleSubscriptionPlanDetailsReviewBinding = new ViewGuildRoleSubscriptionPlanDetailsReviewBinding((LinearLayout) viewInflate2, simpleDraweeView2, textView5);
                Intrinsics3.checkNotNullExpressionValue(viewGuildRoleSubscriptionPlanDetailsReviewBinding, "ViewGuildRoleSubscriptio…rent, false\n            )");
                return new GuildRoleSubscriptionTierViewHolder.PlanDetailsViewHolder(viewGuildRoleSubscriptionPlanDetailsReviewBinding);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(viewInflate2.getResources().getResourceName(i2)));
    }
}
