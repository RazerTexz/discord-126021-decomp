package com.discord.widgets.settings.premium;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.C5419R;
import com.discord.api.application.Application;
import com.discord.api.premium.SubscriptionInterval;
import com.discord.api.premium.SubscriptionPlan;
import com.discord.app.AppViewFlipper;
import com.discord.databinding.ViewGiftEntitlementListItemBinding;
import com.discord.databinding.ViewGiftSkuListItemBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.domain.ModelEntitlement;
import com.discord.models.domain.ModelGift;
import com.discord.models.domain.ModelSku;
import com.discord.models.domain.premium.SubscriptionPlanType;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.drawable.DrawableCompat;
import com.discord.utilities.gifting.GiftingUtils;
import com.discord.utilities.icon.IconUtils;
import com.discord.utilities.mg_recycler.MGRecyclerAdapterSimple;
import com.discord.utilities.mg_recycler.MGRecyclerDataPayload;
import com.discord.utilities.mg_recycler.MGRecyclerViewHolder;
import com.discord.utilities.premium.PremiumUtils;
import com.discord.utilities.resources.StringResourceUtilsKt;
import com.discord.utilities.time.ClockFactory;
import com.discord.utilities.view.text.LinkifiedTextView;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.android.material.button.MaterialButton;
import java.util.List;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p007b.p008a.p027k.C1107b;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: WidgetSettingsGiftingAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetSettingsGiftingAdapter extends MGRecyclerAdapterSimple<GiftItem> {
    private Function1<? super String, Unit> onClickCopyListener;
    private Function2<? super Long, ? super Long, Unit> onClickSkuListener;
    private Function2<? super Long, ? super Long, Unit> onGenerateClickListener;
    private Function1<? super ModelGift, Unit> onRevokeClickListener;

    /* JADX INFO: compiled from: WidgetSettingsGiftingAdapter.kt */
    public static final class EntitlementListItem extends MGRecyclerViewHolder<WidgetSettingsGiftingAdapter, GiftItem> {
        private static final int VIEW_INDEX_CODE = 0;
        private static final int VIEW_INDEX_GENERATE = 1;
        private final ViewGiftEntitlementListItemBinding binding;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public EntitlementListItem(WidgetSettingsGiftingAdapter widgetSettingsGiftingAdapter) {
            super(C5419R.layout.view_gift_entitlement_list_item, widgetSettingsGiftingAdapter);
            C12238m.checkNotNullParameter(widgetSettingsGiftingAdapter, "adapter");
            View view = this.itemView;
            int i = C5419R.id.gift_entitlement_code;
            TextView textView = (TextView) view.findViewById(C5419R.id.gift_entitlement_code);
            if (textView != null) {
                i = C5419R.id.gift_entitlement_code_container;
                RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(C5419R.id.gift_entitlement_code_container);
                if (relativeLayout != null) {
                    FrameLayout frameLayout = (FrameLayout) view;
                    i = C5419R.id.gift_entitlement_copy;
                    MaterialButton materialButton = (MaterialButton) view.findViewById(C5419R.id.gift_entitlement_copy);
                    if (materialButton != null) {
                        i = C5419R.id.gift_entitlement_divider;
                        View viewFindViewById = view.findViewById(C5419R.id.gift_entitlement_divider);
                        if (viewFindViewById != null) {
                            i = C5419R.id.gift_entitlement_flipper;
                            AppViewFlipper appViewFlipper = (AppViewFlipper) view.findViewById(C5419R.id.gift_entitlement_flipper);
                            if (appViewFlipper != null) {
                                i = C5419R.id.gift_entitlement_generate;
                                MaterialButton materialButton2 = (MaterialButton) view.findViewById(C5419R.id.gift_entitlement_generate);
                                if (materialButton2 != null) {
                                    i = C5419R.id.gift_entitlement_revoke;
                                    LinkifiedTextView linkifiedTextView = (LinkifiedTextView) view.findViewById(C5419R.id.gift_entitlement_revoke);
                                    if (linkifiedTextView != null) {
                                        ViewGiftEntitlementListItemBinding viewGiftEntitlementListItemBinding = new ViewGiftEntitlementListItemBinding(frameLayout, textView, relativeLayout, frameLayout, materialButton, viewFindViewById, appViewFlipper, materialButton2, linkifiedTextView);
                                        C12238m.checkNotNullExpressionValue(viewGiftEntitlementListItemBinding, "ViewGiftEntitlementListItemBinding.bind(itemView)");
                                        this.binding = viewGiftEntitlementListItemBinding;
                                        return;
                                    }
                                }
                            }
                        }
                    }
                }
            }
            throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
        }

        public static final /* synthetic */ WidgetSettingsGiftingAdapter access$getAdapter$p(EntitlementListItem entitlementListItem) {
            return (WidgetSettingsGiftingAdapter) entitlementListItem.adapter;
        }

        @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
        public void onConfigure(int position, final GiftItem data) {
            int themedDrawableRes$default;
            C12238m.checkNotNullParameter(data, "data");
            super.onConfigure(position, data);
            if (C12238m.areEqual(data.getExpanded(), Boolean.FALSE)) {
                View view = this.itemView;
                C12238m.checkNotNullExpressionValue(view, "itemView");
                View view2 = this.itemView;
                C12238m.checkNotNullExpressionValue(view2, "itemView");
                ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
                layoutParams.height = 0;
                view.setLayoutParams(layoutParams);
                return;
            }
            View view3 = this.itemView;
            C12238m.checkNotNullExpressionValue(view3, "itemView");
            View view4 = this.itemView;
            C12238m.checkNotNullExpressionValue(view4, "itemView");
            ViewGroup.LayoutParams layoutParams2 = view4.getLayoutParams();
            layoutParams2.height = -2;
            view3.setLayoutParams(layoutParams2);
            View view5 = this.itemView;
            C12238m.checkNotNullExpressionValue(view5, "itemView");
            Context context = view5.getContext();
            if (data.getEntitlement() == null || data.isLastItem() == null) {
                return;
            }
            if (data.getGift() != null) {
                AppViewFlipper appViewFlipper = this.binding.f15431g;
                C12238m.checkNotNullExpressionValue(appViewFlipper, "binding.giftEntitlementFlipper");
                appViewFlipper.setDisplayedChild(0);
                boolean zAreEqual = C12238m.areEqual(data.getWasCopied(), Boolean.TRUE);
                MaterialButton materialButton = this.binding.f15429e;
                C12238m.checkNotNullExpressionValue(materialButton, "binding.giftEntitlementCopy");
                View view6 = this.itemView;
                C12238m.checkNotNullExpressionValue(view6, "itemView");
                materialButton.setText(C1107b.m212d(view6, zAreEqual ? C5419R.string.copied : C5419R.string.copy, new Object[0], (4 & 4) != 0 ? C1107b.c.f1492j : null));
                RelativeLayout relativeLayout = this.binding.f15427c;
                if (zAreEqual) {
                    C12238m.checkNotNullExpressionValue(context, "context");
                    themedDrawableRes$default = DrawableCompat.getThemedDrawableRes$default(context, C5419R.attr.gift_code_copied_outline, 0, 2, (Object) null);
                } else {
                    C12238m.checkNotNullExpressionValue(context, "context");
                    themedDrawableRes$default = DrawableCompat.getThemedDrawableRes$default(context, C5419R.attr.primary_660_bg_outline, 0, 2, (Object) null);
                }
                relativeLayout.setBackgroundResource(themedDrawableRes$default);
                this.binding.f15429e.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.settings.premium.WidgetSettingsGiftingAdapter$EntitlementListItem$onConfigure$3
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view7) {
                        WidgetSettingsGiftingAdapter.EntitlementListItem.access$getAdapter$p(this.this$0).onClickCopyListener.invoke(data.getGift().getCode());
                    }
                });
                GiftingUtils giftingUtils = GiftingUtils.INSTANCE;
                CharSequence timeString = giftingUtils.getTimeString(data.getGift().getExpiresDiff(ClockFactory.get().currentTimeMillis()), context);
                LinkifiedTextView linkifiedTextView = this.binding.f15433i;
                C12238m.checkNotNullExpressionValue(linkifiedTextView, "binding.giftEntitlementRevoke");
                C1107b.m221m(linkifiedTextView, C5419R.string.gift_inventory_expires_in_mobile, new Object[]{timeString}, new WidgetSettingsGiftingAdapter$EntitlementListItem$onConfigure$4(this, data));
                TextView textView = this.binding.f15426b;
                C12238m.checkNotNullExpressionValue(textView, "binding.giftEntitlementCode");
                textView.setText(giftingUtils.generateGiftUrl(data.getGift().getCode()));
            } else {
                AppViewFlipper appViewFlipper2 = this.binding.f15431g;
                C12238m.checkNotNullExpressionValue(appViewFlipper2, "binding.giftEntitlementFlipper");
                appViewFlipper2.setDisplayedChild(1);
                this.binding.f15432h.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.settings.premium.WidgetSettingsGiftingAdapter$EntitlementListItem$onConfigure$5
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view7) {
                        Function2 function2 = WidgetSettingsGiftingAdapter.EntitlementListItem.access$getAdapter$p(this.this$0).onGenerateClickListener;
                        Long lValueOf = Long.valueOf(data.getEntitlement().getSkuId());
                        SubscriptionPlan subscriptionPlan = data.getEntitlement().getSubscriptionPlan();
                        function2.invoke(lValueOf, subscriptionPlan != null ? Long.valueOf(subscriptionPlan.getId()) : null);
                    }
                });
            }
            View view7 = this.binding.f15430f;
            C12238m.checkNotNullExpressionValue(view7, "binding.giftEntitlementDivider");
            view7.setVisibility(data.isLastItem().booleanValue() ^ true ? 0 : 8);
            if (!data.isLastItem().booleanValue()) {
                FrameLayout frameLayout = this.binding.f15428d;
                View view8 = this.itemView;
                C12238m.checkNotNullExpressionValue(view8, "itemView");
                frameLayout.setBackgroundColor(ColorCompat.getThemedColor(view8.getContext(), C5419R.attr.primary_630));
                return;
            }
            FrameLayout frameLayout2 = this.binding.f15428d;
            View view9 = this.itemView;
            C12238m.checkNotNullExpressionValue(view9, "itemView");
            Context context2 = view9.getContext();
            C12238m.checkNotNullExpressionValue(context2, "itemView.context");
            frameLayout2.setBackgroundResource(DrawableCompat.getThemedDrawableRes$default(context2, C5419R.attr.primary_630_bg_bottom_corners, 0, 2, (Object) null));
        }
    }

    /* JADX INFO: compiled from: WidgetSettingsGiftingAdapter.kt */
    public static final class NoGiftsListItem extends MGRecyclerViewHolder<WidgetSettingsGiftingAdapter, GiftItem> {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public NoGiftsListItem(WidgetSettingsGiftingAdapter widgetSettingsGiftingAdapter) {
            super(C5419R.layout.view_no_gifts_list_item, widgetSettingsGiftingAdapter);
            C12238m.checkNotNullParameter(widgetSettingsGiftingAdapter, "adapter");
        }
    }

    /* JADX INFO: compiled from: WidgetSettingsGiftingAdapter.kt */
    public static final class SkuListItem extends MGRecyclerViewHolder<WidgetSettingsGiftingAdapter, GiftItem> {
        private final ViewGiftSkuListItemBinding binding;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SkuListItem(WidgetSettingsGiftingAdapter widgetSettingsGiftingAdapter) {
            super(C5419R.layout.view_gift_sku_list_item, widgetSettingsGiftingAdapter);
            C12238m.checkNotNullParameter(widgetSettingsGiftingAdapter, "adapter");
            View view = this.itemView;
            int i = C5419R.id.gift_sku_arrow;
            ImageView imageView = (ImageView) view.findViewById(C5419R.id.gift_sku_arrow);
            if (imageView != null) {
                i = C5419R.id.gift_sku_copies;
                TextView textView = (TextView) view.findViewById(C5419R.id.gift_sku_copies);
                if (textView != null) {
                    i = C5419R.id.gift_sku_icon;
                    SimpleDraweeView simpleDraweeView = (SimpleDraweeView) view.findViewById(C5419R.id.gift_sku_icon);
                    if (simpleDraweeView != null) {
                        i = C5419R.id.gift_sku_name;
                        TextView textView2 = (TextView) view.findViewById(C5419R.id.gift_sku_name);
                        if (textView2 != null) {
                            ViewGiftSkuListItemBinding viewGiftSkuListItemBinding = new ViewGiftSkuListItemBinding((CardView) view, imageView, textView, simpleDraweeView, textView2);
                            C12238m.checkNotNullExpressionValue(viewGiftSkuListItemBinding, "ViewGiftSkuListItemBinding.bind(itemView)");
                            this.binding = viewGiftSkuListItemBinding;
                            return;
                        }
                    }
                }
            }
            throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
        }

        public static final /* synthetic */ WidgetSettingsGiftingAdapter access$getAdapter$p(SkuListItem skuListItem) {
            return (WidgetSettingsGiftingAdapter) skuListItem.adapter;
        }

        @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
        public void onConfigure(int position, final GiftItem data) {
            CharSequence name;
            String icon;
            C12238m.checkNotNullParameter(data, "data");
            super.onConfigure(position, data);
            if (data.getSku() == null || data.getCopies() == null || data.getExpanded() == null) {
                return;
            }
            TextView textView = this.binding.f15444e;
            C12238m.checkNotNullExpressionValue(textView, "binding.giftSkuName");
            textView.setText(data.getSku().getName());
            String applicationIcon$default = null;
            SubscriptionPlanType subscriptionPlanTypeFrom = data.getPlanId() != null ? SubscriptionPlanType.INSTANCE.from(data.getPlanId().longValue()) : null;
            TextView textView2 = this.binding.f15444e;
            C12238m.checkNotNullExpressionValue(textView2, "binding.giftSkuName");
            if (subscriptionPlanTypeFrom != null) {
                Pair pair = subscriptionPlanTypeFrom.getInterval() == SubscriptionInterval.MONTHLY ? new Pair(Integer.valueOf(C5419R.string.gift_inventory_subscription_months), Integer.valueOf(C5419R.plurals.gift_inventory_subscription_months_intervalCount)) : new Pair(Integer.valueOf(C5419R.string.gift_inventory_subscription_years), Integer.valueOf(C5419R.plurals.gift_inventory_subscription_years_intervalCount));
                int iIntValue = ((Number) pair.component1()).intValue();
                int iIntValue2 = ((Number) pair.component2()).intValue();
                View view = this.itemView;
                C12238m.checkNotNullExpressionValue(view, "itemView");
                name = C1107b.m212d(view, iIntValue, new Object[0], new WidgetSettingsGiftingAdapter$SkuListItem$onConfigure$1(this, data, iIntValue2, 1));
            } else {
                name = data.getSku().getName();
            }
            textView2.setText(name);
            TextView textView3 = this.binding.f15442c;
            C12238m.checkNotNullExpressionValue(textView3, "binding.giftSkuCopies");
            textView3.setText(StringResourceUtilsKt.getI18nPluralString(C1643a.m885x(this.itemView, "itemView", "itemView.context"), C5419R.plurals.gift_inventory_copies_copies, data.getCopies().intValue(), data.getCopies()));
            this.binding.f15441b.setImageResource(data.getExpanded().booleanValue() ? C5419R.drawable.ic_chevron_down_primary_300_12dp : C5419R.drawable.ic_chevron_right_primary_300_12dp);
            PremiumUtils premiumUtils = PremiumUtils.INSTANCE;
            if (premiumUtils.isNitroSku(data.getSku())) {
                this.binding.f15443d.setImageResource(premiumUtils.getNitroGiftIcon(data.getSku()));
            } else {
                Application application = data.getSku().getApplication();
                if (application != null && (icon = application.getIcon()) != null) {
                    applicationIcon$default = IconUtils.getApplicationIcon$default(data.getSku().getApplicationId(), icon, 0, 4, (Object) null);
                }
                this.binding.f15443d.setImageURI(applicationIcon$default);
            }
            this.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.settings.premium.WidgetSettingsGiftingAdapter$SkuListItem$onConfigure$2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    WidgetSettingsGiftingAdapter.SkuListItem.access$getAdapter$p(this.this$0).onClickSkuListener.invoke(Long.valueOf(data.getSku().getId()), data.getPlanId());
                }
            });
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetSettingsGiftingAdapter(RecyclerView recyclerView) {
        super(recyclerView, false, 2, null);
        C12238m.checkNotNullParameter(recyclerView, "recycler");
        this.onClickSkuListener = WidgetSettingsGiftingAdapter$onClickSkuListener$1.INSTANCE;
        this.onClickCopyListener = WidgetSettingsGiftingAdapter$onClickCopyListener$1.INSTANCE;
        this.onRevokeClickListener = WidgetSettingsGiftingAdapter$onRevokeClickListener$1.INSTANCE;
        this.onGenerateClickListener = WidgetSettingsGiftingAdapter$onGenerateClickListener$1.INSTANCE;
    }

    public final void configure(List<GiftItem> giftItems, Function2<? super Long, ? super Long, Unit> onClickSkuListener, Function1<? super String, Unit> onClickCopyListener, Function1<? super ModelGift, Unit> onRevokeClickListener, Function2<? super Long, ? super Long, Unit> onGenerateClickListener) {
        C12238m.checkNotNullParameter(giftItems, "giftItems");
        C12238m.checkNotNullParameter(onClickSkuListener, "onClickSkuListener");
        C12238m.checkNotNullParameter(onClickCopyListener, "onClickCopyListener");
        C12238m.checkNotNullParameter(onRevokeClickListener, "onRevokeClickListener");
        C12238m.checkNotNullParameter(onGenerateClickListener, "onGenerateClickListener");
        setData(giftItems);
        this.onClickSkuListener = onClickSkuListener;
        this.onClickCopyListener = onClickCopyListener;
        this.onRevokeClickListener = onRevokeClickListener;
        this.onGenerateClickListener = onGenerateClickListener;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public MGRecyclerViewHolder<WidgetSettingsGiftingAdapter, GiftItem> onCreateViewHolder(ViewGroup parent, int viewType) {
        C12238m.checkNotNullParameter(parent, "parent");
        if (viewType == 0) {
            return new NoGiftsListItem(this);
        }
        if (viewType == 1) {
            return new SkuListItem(this);
        }
        if (viewType == 2) {
            return new EntitlementListItem(this);
        }
        throw invalidViewTypeException(viewType);
    }

    /* JADX INFO: compiled from: WidgetSettingsGiftingAdapter.kt */
    public static final /* data */ class GiftItem implements MGRecyclerDataPayload {
        public static final int TYPE_GIFT = 2;
        public static final int TYPE_NO_GIFTS = 0;
        public static final int TYPE_SKU = 1;
        private final Integer copies;
        private final ModelEntitlement entitlement;
        private final Boolean expanded;
        private final ModelGift gift;
        private final Boolean isLastItem;
        private final String key;
        private final Long planId;
        private final ModelSku sku;
        private final int type;
        private final int typeInt;
        private final Boolean wasCopied;

        public GiftItem(int i, ModelGift modelGift, ModelEntitlement modelEntitlement, Boolean bool, ModelSku modelSku, Integer num, Long l, Boolean bool2, Boolean bool3) {
            this.typeInt = i;
            this.gift = modelGift;
            this.entitlement = modelEntitlement;
            this.expanded = bool;
            this.sku = modelSku;
            this.copies = num;
            this.planId = l;
            this.isLastItem = bool2;
            this.wasCopied = bool3;
            this.type = i;
            int type = getType();
            String strValueOf = "";
            if (type != 0) {
                if (type == 1) {
                    strValueOf = String.valueOf(modelSku != null ? Long.valueOf(modelSku.getId()) : null);
                } else if (type == 2) {
                    strValueOf = String.valueOf(modelEntitlement != null ? Long.valueOf(modelEntitlement.getId()) : null);
                }
            }
            this.key = strValueOf;
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final int getTypeInt() {
            return this.typeInt;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final ModelGift getGift() {
            return this.gift;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final ModelEntitlement getEntitlement() {
            return this.entitlement;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final Boolean getExpanded() {
            return this.expanded;
        }

        /* JADX INFO: renamed from: component5, reason: from getter */
        public final ModelSku getSku() {
            return this.sku;
        }

        /* JADX INFO: renamed from: component6, reason: from getter */
        public final Integer getCopies() {
            return this.copies;
        }

        /* JADX INFO: renamed from: component7, reason: from getter */
        public final Long getPlanId() {
            return this.planId;
        }

        /* JADX INFO: renamed from: component8, reason: from getter */
        public final Boolean getIsLastItem() {
            return this.isLastItem;
        }

        /* JADX INFO: renamed from: component9, reason: from getter */
        public final Boolean getWasCopied() {
            return this.wasCopied;
        }

        public final GiftItem copy(int typeInt, ModelGift gift, ModelEntitlement entitlement, Boolean expanded, ModelSku sku, Integer copies, Long planId, Boolean isLastItem, Boolean wasCopied) {
            return new GiftItem(typeInt, gift, entitlement, expanded, sku, copies, planId, isLastItem, wasCopied);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof GiftItem)) {
                return false;
            }
            GiftItem giftItem = (GiftItem) other;
            return this.typeInt == giftItem.typeInt && C12238m.areEqual(this.gift, giftItem.gift) && C12238m.areEqual(this.entitlement, giftItem.entitlement) && C12238m.areEqual(this.expanded, giftItem.expanded) && C12238m.areEqual(this.sku, giftItem.sku) && C12238m.areEqual(this.copies, giftItem.copies) && C12238m.areEqual(this.planId, giftItem.planId) && C12238m.areEqual(this.isLastItem, giftItem.isLastItem) && C12238m.areEqual(this.wasCopied, giftItem.wasCopied);
        }

        public final Integer getCopies() {
            return this.copies;
        }

        public final ModelEntitlement getEntitlement() {
            return this.entitlement;
        }

        public final Boolean getExpanded() {
            return this.expanded;
        }

        public final ModelGift getGift() {
            return this.gift;
        }

        @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload, com.discord.utilities.recycler.DiffKeyProvider
        public String getKey() {
            return this.key;
        }

        public final Long getPlanId() {
            return this.planId;
        }

        public final ModelSku getSku() {
            return this.sku;
        }

        @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload
        public int getType() {
            return this.type;
        }

        public final int getTypeInt() {
            return this.typeInt;
        }

        public final Boolean getWasCopied() {
            return this.wasCopied;
        }

        public int hashCode() {
            int i = this.typeInt * 31;
            ModelGift modelGift = this.gift;
            int iHashCode = (i + (modelGift != null ? modelGift.hashCode() : 0)) * 31;
            ModelEntitlement modelEntitlement = this.entitlement;
            int iHashCode2 = (iHashCode + (modelEntitlement != null ? modelEntitlement.hashCode() : 0)) * 31;
            Boolean bool = this.expanded;
            int iHashCode3 = (iHashCode2 + (bool != null ? bool.hashCode() : 0)) * 31;
            ModelSku modelSku = this.sku;
            int iHashCode4 = (iHashCode3 + (modelSku != null ? modelSku.hashCode() : 0)) * 31;
            Integer num = this.copies;
            int iHashCode5 = (iHashCode4 + (num != null ? num.hashCode() : 0)) * 31;
            Long l = this.planId;
            int iHashCode6 = (iHashCode5 + (l != null ? l.hashCode() : 0)) * 31;
            Boolean bool2 = this.isLastItem;
            int iHashCode7 = (iHashCode6 + (bool2 != null ? bool2.hashCode() : 0)) * 31;
            Boolean bool3 = this.wasCopied;
            return iHashCode7 + (bool3 != null ? bool3.hashCode() : 0);
        }

        public final Boolean isLastItem() {
            return this.isLastItem;
        }

        public String toString() {
            StringBuilder sbM833U = C1643a.m833U("GiftItem(typeInt=");
            sbM833U.append(this.typeInt);
            sbM833U.append(", gift=");
            sbM833U.append(this.gift);
            sbM833U.append(", entitlement=");
            sbM833U.append(this.entitlement);
            sbM833U.append(", expanded=");
            sbM833U.append(this.expanded);
            sbM833U.append(", sku=");
            sbM833U.append(this.sku);
            sbM833U.append(", copies=");
            sbM833U.append(this.copies);
            sbM833U.append(", planId=");
            sbM833U.append(this.planId);
            sbM833U.append(", isLastItem=");
            sbM833U.append(this.isLastItem);
            sbM833U.append(", wasCopied=");
            return C1643a.m816D(sbM833U, this.wasCopied, ")");
        }

        public /* synthetic */ GiftItem(int i, ModelGift modelGift, ModelEntitlement modelEntitlement, Boolean bool, ModelSku modelSku, Integer num, Long l, Boolean bool2, Boolean bool3, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this(i, (i2 & 2) != 0 ? null : modelGift, (i2 & 4) != 0 ? null : modelEntitlement, (i2 & 8) != 0 ? null : bool, (i2 & 16) != 0 ? null : modelSku, (i2 & 32) != 0 ? null : num, (i2 & 64) != 0 ? null : l, (i2 & 128) != 0 ? null : bool2, (i2 & 256) == 0 ? bool3 : null);
        }
    }
}
