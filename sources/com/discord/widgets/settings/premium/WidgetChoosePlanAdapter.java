package com.discord.widgets.settings.premium;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.StringRes;
import androidx.recyclerview.widget.RecyclerView;
import com.android.billingclient.api.SkuDetails;
import com.discord.C5419R;
import com.discord.databinding.WidgetChoosePlanAdapterHeaderItemBinding;
import com.discord.databinding.WidgetChoosePlanAdapterPlanItemBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.analytics.Traits;
import com.discord.utilities.billing.GooglePlaySku;
import com.discord.utilities.drawable.DrawableCompat;
import com.discord.utilities.mg_recycler.MGRecyclerAdapterSimple;
import com.discord.utilities.mg_recycler.MGRecyclerDataPayload;
import com.discord.utilities.mg_recycler.MGRecyclerViewHolder;
import com.discord.utilities.premium.PremiumUtils;
import com.discord.widgets.settings.premium.WidgetChoosePlanAdapter;
import com.google.android.material.card.MaterialCardView;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p007b.p008a.p027k.C1107b;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: WidgetChoosePlanAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChoosePlanAdapter extends MGRecyclerAdapterSimple<Item> {
    private Function3<? super GooglePlaySku, ? super String, ? super SkuDetails, Unit> onClickPlan;

    /* JADX INFO: compiled from: WidgetChoosePlanAdapter.kt */
    public static final class DividerViewHolder extends MGRecyclerViewHolder<WidgetChoosePlanAdapter, Item> {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public DividerViewHolder(WidgetChoosePlanAdapter widgetChoosePlanAdapter) {
            super(C5419R.layout.widget_choose_plan_adapter_divider_item, widgetChoosePlanAdapter);
            C12238m.checkNotNullParameter(widgetChoosePlanAdapter, "adapter");
        }
    }

    /* JADX INFO: compiled from: WidgetChoosePlanAdapter.kt */
    public static final class HeaderViewHolder extends MGRecyclerViewHolder<WidgetChoosePlanAdapter, Item> {
        private final WidgetChoosePlanAdapterHeaderItemBinding binding;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public HeaderViewHolder(WidgetChoosePlanAdapter widgetChoosePlanAdapter) {
            super(C5419R.layout.widget_choose_plan_adapter_header_item, widgetChoosePlanAdapter);
            C12238m.checkNotNullParameter(widgetChoosePlanAdapter, "adapter");
            View view = this.itemView;
            TextView textView = (TextView) view.findViewById(C5419R.id.select_subscription_header_text);
            if (textView == null) {
                throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(C5419R.id.select_subscription_header_text)));
            }
            WidgetChoosePlanAdapterHeaderItemBinding widgetChoosePlanAdapterHeaderItemBinding = new WidgetChoosePlanAdapterHeaderItemBinding((FrameLayout) view, textView);
            C12238m.checkNotNullExpressionValue(widgetChoosePlanAdapterHeaderItemBinding, "WidgetChoosePlanAdapterH…temBinding.bind(itemView)");
            this.binding = widgetChoosePlanAdapterHeaderItemBinding;
        }

        @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
        public void onConfigure(int position, Item data) {
            C12238m.checkNotNullParameter(data, "data");
            super.onConfigure(position, data);
            TextView textView = this.binding.f16375b;
            C12238m.checkNotNullExpressionValue(textView, "binding.selectSubscriptionHeaderText");
            C1107b.m221m(textView, ((Item.Header) data).getTitleStringResId(), new Object[0], (4 & 4) != 0 ? C1107b.g.f1495j : null);
        }
    }

    /* JADX INFO: compiled from: WidgetChoosePlanAdapter.kt */
    public static abstract class Item implements MGRecyclerDataPayload {
        public static final int TYPE_DIVIDER = 2;
        public static final int TYPE_HEADER = 0;
        public static final int TYPE_PLAN = 1;
        private final int type;

        /* JADX INFO: compiled from: WidgetChoosePlanAdapter.kt */
        public static final class Divider extends Item {
            private final String key;

            public Divider() {
                super(2, null);
                this.key = String.valueOf(getType());
            }

            @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload, com.discord.utilities.recycler.DiffKeyProvider
            public String getKey() {
                return this.key;
            }
        }

        /* JADX INFO: compiled from: WidgetChoosePlanAdapter.kt */
        public static final /* data */ class Header extends Item {
            private final String key;
            private final int titleStringResId;

            public Header(@StringRes int i) {
                super(0, null);
                this.titleStringResId = i;
                this.key = String.valueOf(getType());
            }

            public static /* synthetic */ Header copy$default(Header header, int i, int i2, Object obj) {
                if ((i2 & 1) != 0) {
                    i = header.titleStringResId;
                }
                return header.copy(i);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final int getTitleStringResId() {
                return this.titleStringResId;
            }

            public final Header copy(@StringRes int titleStringResId) {
                return new Header(titleStringResId);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof Header) && this.titleStringResId == ((Header) other).titleStringResId;
                }
                return true;
            }

            @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload, com.discord.utilities.recycler.DiffKeyProvider
            public String getKey() {
                return this.key;
            }

            public final int getTitleStringResId() {
                return this.titleStringResId;
            }

            public int hashCode() {
                return this.titleStringResId;
            }

            public String toString() {
                return C1643a.m814B(C1643a.m833U("Header(titleStringResId="), this.titleStringResId, ")");
            }
        }

        /* JADX INFO: compiled from: WidgetChoosePlanAdapter.kt */
        public static final /* data */ class Plan extends Item {
            private final GooglePlaySku displaySku;
            private final boolean isCurrentPlan;
            private final String key;
            private final String oldSkuName;
            private final GooglePlaySku purchaseSku;
            private final SkuDetails skuDetails;
            private final SkuDetails upgradeSkuDetails;

            public /* synthetic */ Plan(GooglePlaySku googlePlaySku, SkuDetails skuDetails, GooglePlaySku googlePlaySku2, String str, SkuDetails skuDetails2, boolean z2, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this(googlePlaySku, skuDetails, googlePlaySku2, (i & 8) != 0 ? null : str, (i & 16) != 0 ? null : skuDetails2, (i & 32) != 0 ? false : z2);
            }

            public static /* synthetic */ Plan copy$default(Plan plan, GooglePlaySku googlePlaySku, SkuDetails skuDetails, GooglePlaySku googlePlaySku2, String str, SkuDetails skuDetails2, boolean z2, int i, Object obj) {
                if ((i & 1) != 0) {
                    googlePlaySku = plan.displaySku;
                }
                if ((i & 2) != 0) {
                    skuDetails = plan.skuDetails;
                }
                SkuDetails skuDetails3 = skuDetails;
                if ((i & 4) != 0) {
                    googlePlaySku2 = plan.purchaseSku;
                }
                GooglePlaySku googlePlaySku3 = googlePlaySku2;
                if ((i & 8) != 0) {
                    str = plan.oldSkuName;
                }
                String str2 = str;
                if ((i & 16) != 0) {
                    skuDetails2 = plan.upgradeSkuDetails;
                }
                SkuDetails skuDetails4 = skuDetails2;
                if ((i & 32) != 0) {
                    z2 = plan.isCurrentPlan;
                }
                return plan.copy(googlePlaySku, skuDetails3, googlePlaySku3, str2, skuDetails4, z2);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final GooglePlaySku getDisplaySku() {
                return this.displaySku;
            }

            /* JADX INFO: renamed from: component2, reason: from getter */
            public final SkuDetails getSkuDetails() {
                return this.skuDetails;
            }

            /* JADX INFO: renamed from: component3, reason: from getter */
            public final GooglePlaySku getPurchaseSku() {
                return this.purchaseSku;
            }

            /* JADX INFO: renamed from: component4, reason: from getter */
            public final String getOldSkuName() {
                return this.oldSkuName;
            }

            /* JADX INFO: renamed from: component5, reason: from getter */
            public final SkuDetails getUpgradeSkuDetails() {
                return this.upgradeSkuDetails;
            }

            /* JADX INFO: renamed from: component6, reason: from getter */
            public final boolean getIsCurrentPlan() {
                return this.isCurrentPlan;
            }

            public final Plan copy(GooglePlaySku displaySku, SkuDetails skuDetails, GooglePlaySku purchaseSku, String oldSkuName, SkuDetails upgradeSkuDetails, boolean isCurrentPlan) {
                C12238m.checkNotNullParameter(displaySku, "displaySku");
                C12238m.checkNotNullParameter(skuDetails, "skuDetails");
                return new Plan(displaySku, skuDetails, purchaseSku, oldSkuName, upgradeSkuDetails, isCurrentPlan);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Plan)) {
                    return false;
                }
                Plan plan = (Plan) other;
                return C12238m.areEqual(this.displaySku, plan.displaySku) && C12238m.areEqual(this.skuDetails, plan.skuDetails) && C12238m.areEqual(this.purchaseSku, plan.purchaseSku) && C12238m.areEqual(this.oldSkuName, plan.oldSkuName) && C12238m.areEqual(this.upgradeSkuDetails, plan.upgradeSkuDetails) && this.isCurrentPlan == plan.isCurrentPlan;
            }

            public final GooglePlaySku getDisplaySku() {
                return this.displaySku;
            }

            @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload, com.discord.utilities.recycler.DiffKeyProvider
            public String getKey() {
                return this.key;
            }

            public final String getOldSkuName() {
                return this.oldSkuName;
            }

            public final GooglePlaySku getPurchaseSku() {
                return this.purchaseSku;
            }

            public final SkuDetails getSkuDetails() {
                return this.skuDetails;
            }

            public final SkuDetails getUpgradeSkuDetails() {
                return this.upgradeSkuDetails;
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r0v12, types: [int] */
            /* JADX WARN: Type inference failed for: r1v3, types: [int] */
            /* JADX WARN: Type inference failed for: r1v4 */
            /* JADX WARN: Type inference failed for: r1v6 */
            public int hashCode() {
                GooglePlaySku googlePlaySku = this.displaySku;
                int iHashCode = (googlePlaySku != null ? googlePlaySku.hashCode() : 0) * 31;
                SkuDetails skuDetails = this.skuDetails;
                int iHashCode2 = (iHashCode + (skuDetails != null ? skuDetails.hashCode() : 0)) * 31;
                GooglePlaySku googlePlaySku2 = this.purchaseSku;
                int iHashCode3 = (iHashCode2 + (googlePlaySku2 != null ? googlePlaySku2.hashCode() : 0)) * 31;
                String str = this.oldSkuName;
                int iHashCode4 = (iHashCode3 + (str != null ? str.hashCode() : 0)) * 31;
                SkuDetails skuDetails2 = this.upgradeSkuDetails;
                int iHashCode5 = (iHashCode4 + (skuDetails2 != null ? skuDetails2.hashCode() : 0)) * 31;
                boolean z2 = this.isCurrentPlan;
                ?? r1 = z2;
                if (z2) {
                    r1 = 1;
                }
                return iHashCode5 + r1;
            }

            public final boolean isCurrentPlan() {
                return this.isCurrentPlan;
            }

            public String toString() {
                StringBuilder sbM833U = C1643a.m833U("Plan(displaySku=");
                sbM833U.append(this.displaySku);
                sbM833U.append(", skuDetails=");
                sbM833U.append(this.skuDetails);
                sbM833U.append(", purchaseSku=");
                sbM833U.append(this.purchaseSku);
                sbM833U.append(", oldSkuName=");
                sbM833U.append(this.oldSkuName);
                sbM833U.append(", upgradeSkuDetails=");
                sbM833U.append(this.upgradeSkuDetails);
                sbM833U.append(", isCurrentPlan=");
                return C1643a.m827O(sbM833U, this.isCurrentPlan, ")");
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Plan(GooglePlaySku googlePlaySku, SkuDetails skuDetails, GooglePlaySku googlePlaySku2, String str, SkuDetails skuDetails2, boolean z2) {
                super(1, null);
                C12238m.checkNotNullParameter(googlePlaySku, "displaySku");
                C12238m.checkNotNullParameter(skuDetails, "skuDetails");
                this.displaySku = googlePlaySku;
                this.skuDetails = skuDetails;
                this.purchaseSku = googlePlaySku2;
                this.oldSkuName = str;
                this.upgradeSkuDetails = skuDetails2;
                this.isCurrentPlan = z2;
                this.key = getType() + googlePlaySku.getSkuName();
            }
        }

        private Item(int i) {
            this.type = i;
        }

        @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload
        public int getType() {
            return this.type;
        }

        public /* synthetic */ Item(int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(i);
        }
    }

    /* JADX INFO: compiled from: WidgetChoosePlanAdapter.kt */
    public static final class PlanViewHeader extends MGRecyclerViewHolder<WidgetChoosePlanAdapter, Item> {
        private final WidgetChoosePlanAdapterPlanItemBinding binding;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public PlanViewHeader(WidgetChoosePlanAdapter widgetChoosePlanAdapter) {
            super(C5419R.layout.widget_choose_plan_adapter_plan_item, widgetChoosePlanAdapter);
            C12238m.checkNotNullParameter(widgetChoosePlanAdapter, "adapter");
            WidgetChoosePlanAdapterPlanItemBinding widgetChoosePlanAdapterPlanItemBindingM8412a = WidgetChoosePlanAdapterPlanItemBinding.m8412a(this.itemView);
            C12238m.checkNotNullExpressionValue(widgetChoosePlanAdapterPlanItemBindingM8412a, "WidgetChoosePlanAdapterP…temBinding.bind(itemView)");
            this.binding = widgetChoosePlanAdapterPlanItemBindingM8412a;
        }

        public static final /* synthetic */ WidgetChoosePlanAdapter access$getAdapter$p(PlanViewHeader planViewHeader) {
            return (WidgetChoosePlanAdapter) planViewHeader.adapter;
        }

        @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
        public void onConfigure(int position, final Item data) {
            C12238m.checkNotNullParameter(data, "data");
            super.onConfigure(position, data);
            Item.Plan plan = (Item.Plan) data;
            TextView textView = this.binding.f16381f;
            C12238m.checkNotNullExpressionValue(textView, "binding.planItemName");
            textView.setText(plan.getSkuDetails().m7500a());
            TextView textView2 = this.binding.f16382g;
            C12238m.checkNotNullExpressionValue(textView2, "binding.planItemPrice");
            PremiumUtils premiumUtils = PremiumUtils.INSTANCE;
            MaterialCardView materialCardView = this.binding.f16378c;
            C12238m.checkNotNullExpressionValue(materialCardView, "binding.planItemContainer");
            Context context = materialCardView.getContext();
            C12238m.checkNotNullExpressionValue(context, "binding.planItemContainer.context");
            textView2.setText(premiumUtils.getPlanPriceText(context, plan.getSkuDetails()));
            this.binding.f16380e.setImageResource(plan.getDisplaySku().getIconDrawableResId());
            TextView textView3 = this.binding.f16379d;
            C12238m.checkNotNullExpressionValue(textView3, "binding.planItemCurrentPlan");
            textView3.setVisibility(plan.isCurrentPlan() ? 0 : 8);
            this.binding.f16377b.setImageResource(plan.isCurrentPlan() ? GooglePlaySku.INSTANCE.getBorderResource(plan.getDisplaySku().getType()) : 0);
            if (plan.getPurchaseSku() == null) {
                TextView textView4 = this.binding.f16382g;
                C12238m.checkNotNullExpressionValue(textView4, "binding.planItemPrice");
                DrawableCompat.setCompoundDrawablesCompat$default(textView4, (Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null, 11, (Object) null);
                return;
            }
            View view = this.itemView;
            C12238m.checkNotNullExpressionValue(view, "itemView");
            int themedDrawableRes$default = DrawableCompat.getThemedDrawableRes$default(view, C5419R.attr.ic_navigate_next, 0, 2, (Object) null);
            TextView textView5 = this.binding.f16382g;
            C12238m.checkNotNullExpressionValue(textView5, "binding.planItemPrice");
            DrawableCompat.setCompoundDrawablesCompat$default(textView5, 0, 0, themedDrawableRes$default, 0, 11, (Object) null);
            this.binding.f16378c.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.settings.premium.WidgetChoosePlanAdapter$PlanViewHeader$onConfigure$1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    WidgetChoosePlanAdapter.PlanViewHeader.access$getAdapter$p(this.this$0).onClickPlan.invoke(((WidgetChoosePlanAdapter.Item.Plan) data).getPurchaseSku(), ((WidgetChoosePlanAdapter.Item.Plan) data).getOldSkuName(), ((WidgetChoosePlanAdapter.Item.Plan) data).getUpgradeSkuDetails());
                }
            });
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChoosePlanAdapter(RecyclerView recyclerView) {
        super(recyclerView, false, 2, null);
        C12238m.checkNotNullParameter(recyclerView, "recycler");
        this.onClickPlan = WidgetChoosePlanAdapter$onClickPlan$1.INSTANCE;
    }

    public final void setOnClickPlan(Function3<? super GooglePlaySku, ? super String, ? super SkuDetails, Unit> onClickPlan) {
        C12238m.checkNotNullParameter(onClickPlan, "onClickPlan");
        this.onClickPlan = onClickPlan;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public MGRecyclerViewHolder<WidgetChoosePlanAdapter, Item> onCreateViewHolder(ViewGroup parent, int viewType) {
        C12238m.checkNotNullParameter(parent, "parent");
        if (viewType == 0) {
            return new HeaderViewHolder(this);
        }
        if (viewType == 1) {
            return new PlanViewHeader(this);
        }
        if (viewType == 2) {
            return new DividerViewHolder(this);
        }
        throw invalidViewTypeException(viewType);
    }
}
