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
import b.a.k.FormatUtils;
import b.d.b.a.outline;
import com.discord.R;
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
import com.discord.utilities.resources.StringResourceUtils;
import com.discord.utilities.time.ClockFactory;
import com.discord.utilities.view.text.LinkifiedTextView;
import com.discord.widgets.settings.premium.WidgetSettingsGiftingAdapter;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.android.material.button.MaterialButton;
import d0.z.d.Intrinsics3;
import java.util.List;
import kotlin.Tuples2;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;

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
            super(R.layout.view_gift_entitlement_list_item, widgetSettingsGiftingAdapter);
            Intrinsics3.checkNotNullParameter(widgetSettingsGiftingAdapter, "adapter");
            View view = this.itemView;
            int i = R.id.gift_entitlement_code;
            TextView textView = (TextView) view.findViewById(R.id.gift_entitlement_code);
            if (textView != null) {
                i = R.id.gift_entitlement_code_container;
                RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R.id.gift_entitlement_code_container);
                if (relativeLayout != null) {
                    FrameLayout frameLayout = (FrameLayout) view;
                    i = R.id.gift_entitlement_copy;
                    MaterialButton materialButton = (MaterialButton) view.findViewById(R.id.gift_entitlement_copy);
                    if (materialButton != null) {
                        i = R.id.gift_entitlement_divider;
                        View viewFindViewById = view.findViewById(R.id.gift_entitlement_divider);
                        if (viewFindViewById != null) {
                            i = R.id.gift_entitlement_flipper;
                            AppViewFlipper appViewFlipper = (AppViewFlipper) view.findViewById(R.id.gift_entitlement_flipper);
                            if (appViewFlipper != null) {
                                i = R.id.gift_entitlement_generate;
                                MaterialButton materialButton2 = (MaterialButton) view.findViewById(R.id.gift_entitlement_generate);
                                if (materialButton2 != null) {
                                    i = R.id.gift_entitlement_revoke;
                                    LinkifiedTextView linkifiedTextView = (LinkifiedTextView) view.findViewById(R.id.gift_entitlement_revoke);
                                    if (linkifiedTextView != null) {
                                        ViewGiftEntitlementListItemBinding viewGiftEntitlementListItemBinding = new ViewGiftEntitlementListItemBinding(frameLayout, textView, relativeLayout, frameLayout, materialButton, viewFindViewById, appViewFlipper, materialButton2, linkifiedTextView);
                                        Intrinsics3.checkNotNullExpressionValue(viewGiftEntitlementListItemBinding, "ViewGiftEntitlementListItemBinding.bind(itemView)");
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
            Intrinsics3.checkNotNullParameter(data, "data");
            super.onConfigure(position, data);
            if (Intrinsics3.areEqual(data.getExpanded(), Boolean.FALSE)) {
                View view = this.itemView;
                Intrinsics3.checkNotNullExpressionValue(view, "itemView");
                View view2 = this.itemView;
                Intrinsics3.checkNotNullExpressionValue(view2, "itemView");
                ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
                layoutParams.height = 0;
                view.setLayoutParams(layoutParams);
                return;
            }
            View view3 = this.itemView;
            Intrinsics3.checkNotNullExpressionValue(view3, "itemView");
            View view4 = this.itemView;
            Intrinsics3.checkNotNullExpressionValue(view4, "itemView");
            ViewGroup.LayoutParams layoutParams2 = view4.getLayoutParams();
            layoutParams2.height = -2;
            view3.setLayoutParams(layoutParams2);
            View view5 = this.itemView;
            Intrinsics3.checkNotNullExpressionValue(view5, "itemView");
            Context context = view5.getContext();
            if (data.getEntitlement() == null || data.isLastItem() == null) {
                return;
            }
            if (data.getGift() != null) {
                AppViewFlipper appViewFlipper = this.binding.g;
                Intrinsics3.checkNotNullExpressionValue(appViewFlipper, "binding.giftEntitlementFlipper");
                appViewFlipper.setDisplayedChild(0);
                boolean zAreEqual = Intrinsics3.areEqual(data.getWasCopied(), Boolean.TRUE);
                MaterialButton materialButton = this.binding.e;
                Intrinsics3.checkNotNullExpressionValue(materialButton, "binding.giftEntitlementCopy");
                View view6 = this.itemView;
                Intrinsics3.checkNotNullExpressionValue(view6, "itemView");
                materialButton.setText(FormatUtils.d(view6, zAreEqual ? R.string.copied : R.string.copy, new Object[0], (4 & 4) != 0 ? FormatUtils.c.j : null));
                RelativeLayout relativeLayout = this.binding.c;
                if (zAreEqual) {
                    Intrinsics3.checkNotNullExpressionValue(context, "context");
                    themedDrawableRes$default = DrawableCompat.getThemedDrawableRes$default(context, R.attr.gift_code_copied_outline, 0, 2, (Object) null);
                } else {
                    Intrinsics3.checkNotNullExpressionValue(context, "context");
                    themedDrawableRes$default = DrawableCompat.getThemedDrawableRes$default(context, R.attr.primary_660_bg_outline, 0, 2, (Object) null);
                }
                relativeLayout.setBackgroundResource(themedDrawableRes$default);
                this.binding.e.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.settings.premium.WidgetSettingsGiftingAdapter$EntitlementListItem$onConfigure$3
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view7) {
                        WidgetSettingsGiftingAdapter.EntitlementListItem.access$getAdapter$p(this.this$0).onClickCopyListener.invoke(data.getGift().getCode());
                    }
                });
                GiftingUtils giftingUtils = GiftingUtils.INSTANCE;
                CharSequence timeString = giftingUtils.getTimeString(data.getGift().getExpiresDiff(ClockFactory.get().currentTimeMillis()), context);
                LinkifiedTextView linkifiedTextView = this.binding.i;
                Intrinsics3.checkNotNullExpressionValue(linkifiedTextView, "binding.giftEntitlementRevoke");
                FormatUtils.m(linkifiedTextView, R.string.gift_inventory_expires_in_mobile, new Object[]{timeString}, new WidgetSettingsGiftingAdapter$EntitlementListItem$onConfigure$4(this, data));
                TextView textView = this.binding.f2186b;
                Intrinsics3.checkNotNullExpressionValue(textView, "binding.giftEntitlementCode");
                textView.setText(giftingUtils.generateGiftUrl(data.getGift().getCode()));
            } else {
                AppViewFlipper appViewFlipper2 = this.binding.g;
                Intrinsics3.checkNotNullExpressionValue(appViewFlipper2, "binding.giftEntitlementFlipper");
                appViewFlipper2.setDisplayedChild(1);
                this.binding.h.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.settings.premium.WidgetSettingsGiftingAdapter$EntitlementListItem$onConfigure$5
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view7) {
                        Function2 function2 = WidgetSettingsGiftingAdapter.EntitlementListItem.access$getAdapter$p(this.this$0).onGenerateClickListener;
                        Long lValueOf = Long.valueOf(data.getEntitlement().getSkuId());
                        SubscriptionPlan subscriptionPlan = data.getEntitlement().getSubscriptionPlan();
                        function2.invoke(lValueOf, subscriptionPlan != null ? Long.valueOf(subscriptionPlan.getId()) : null);
                    }
                });
            }
            View view7 = this.binding.f;
            Intrinsics3.checkNotNullExpressionValue(view7, "binding.giftEntitlementDivider");
            view7.setVisibility(data.isLastItem().booleanValue() ^ true ? 0 : 8);
            if (!data.isLastItem().booleanValue()) {
                FrameLayout frameLayout = this.binding.d;
                View view8 = this.itemView;
                Intrinsics3.checkNotNullExpressionValue(view8, "itemView");
                frameLayout.setBackgroundColor(ColorCompat.getThemedColor(view8.getContext(), R.attr.primary_630));
                return;
            }
            FrameLayout frameLayout2 = this.binding.d;
            View view9 = this.itemView;
            Intrinsics3.checkNotNullExpressionValue(view9, "itemView");
            Context context2 = view9.getContext();
            Intrinsics3.checkNotNullExpressionValue(context2, "itemView.context");
            frameLayout2.setBackgroundResource(DrawableCompat.getThemedDrawableRes$default(context2, R.attr.primary_630_bg_bottom_corners, 0, 2, (Object) null));
        }
    }

    /* JADX INFO: compiled from: WidgetSettingsGiftingAdapter.kt */
    public static final class NoGiftsListItem extends MGRecyclerViewHolder<WidgetSettingsGiftingAdapter, GiftItem> {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public NoGiftsListItem(WidgetSettingsGiftingAdapter widgetSettingsGiftingAdapter) {
            super(R.layout.view_no_gifts_list_item, widgetSettingsGiftingAdapter);
            Intrinsics3.checkNotNullParameter(widgetSettingsGiftingAdapter, "adapter");
        }
    }

    /* JADX INFO: compiled from: WidgetSettingsGiftingAdapter.kt */
    public static final class SkuListItem extends MGRecyclerViewHolder<WidgetSettingsGiftingAdapter, GiftItem> {
        private final ViewGiftSkuListItemBinding binding;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SkuListItem(WidgetSettingsGiftingAdapter widgetSettingsGiftingAdapter) {
            super(R.layout.view_gift_sku_list_item, widgetSettingsGiftingAdapter);
            Intrinsics3.checkNotNullParameter(widgetSettingsGiftingAdapter, "adapter");
            View view = this.itemView;
            int i = R.id.gift_sku_arrow;
            ImageView imageView = (ImageView) view.findViewById(R.id.gift_sku_arrow);
            if (imageView != null) {
                i = R.id.gift_sku_copies;
                TextView textView = (TextView) view.findViewById(R.id.gift_sku_copies);
                if (textView != null) {
                    i = R.id.gift_sku_icon;
                    SimpleDraweeView simpleDraweeView = (SimpleDraweeView) view.findViewById(R.id.gift_sku_icon);
                    if (simpleDraweeView != null) {
                        i = R.id.gift_sku_name;
                        TextView textView2 = (TextView) view.findViewById(R.id.gift_sku_name);
                        if (textView2 != null) {
                            ViewGiftSkuListItemBinding viewGiftSkuListItemBinding = new ViewGiftSkuListItemBinding((CardView) view, imageView, textView, simpleDraweeView, textView2);
                            Intrinsics3.checkNotNullExpressionValue(viewGiftSkuListItemBinding, "ViewGiftSkuListItemBinding.bind(itemView)");
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
            Intrinsics3.checkNotNullParameter(data, "data");
            super.onConfigure(position, data);
            if (data.getSku() == null || data.getCopies() == null || data.getExpanded() == null) {
                return;
            }
            TextView textView = this.binding.e;
            Intrinsics3.checkNotNullExpressionValue(textView, "binding.giftSkuName");
            textView.setText(data.getSku().getName());
            String applicationIcon$default = null;
            SubscriptionPlanType subscriptionPlanTypeFrom = data.getPlanId() != null ? SubscriptionPlanType.INSTANCE.from(data.getPlanId().longValue()) : null;
            TextView textView2 = this.binding.e;
            Intrinsics3.checkNotNullExpressionValue(textView2, "binding.giftSkuName");
            if (subscriptionPlanTypeFrom != null) {
                Tuples2 tuples2 = subscriptionPlanTypeFrom.getInterval() == SubscriptionInterval.MONTHLY ? new Tuples2(Integer.valueOf(R.string.gift_inventory_subscription_months), Integer.valueOf(R.plurals.gift_inventory_subscription_months_intervalCount)) : new Tuples2(Integer.valueOf(R.string.gift_inventory_subscription_years), Integer.valueOf(R.plurals.gift_inventory_subscription_years_intervalCount));
                int iIntValue = ((Number) tuples2.component1()).intValue();
                int iIntValue2 = ((Number) tuples2.component2()).intValue();
                View view = this.itemView;
                Intrinsics3.checkNotNullExpressionValue(view, "itemView");
                name = FormatUtils.d(view, iIntValue, new Object[0], new WidgetSettingsGiftingAdapter$SkuListItem$onConfigure$1(this, data, iIntValue2, 1));
            } else {
                name = data.getSku().getName();
            }
            textView2.setText(name);
            TextView textView3 = this.binding.c;
            Intrinsics3.checkNotNullExpressionValue(textView3, "binding.giftSkuCopies");
            textView3.setText(StringResourceUtils.getI18nPluralString(outline.x(this.itemView, "itemView", "itemView.context"), R.plurals.gift_inventory_copies_copies, data.getCopies().intValue(), data.getCopies()));
            this.binding.f2188b.setImageResource(data.getExpanded().booleanValue() ? R.drawable.ic_chevron_down_primary_300_12dp : R.drawable.ic_chevron_right_primary_300_12dp);
            PremiumUtils premiumUtils = PremiumUtils.INSTANCE;
            if (premiumUtils.isNitroSku(data.getSku())) {
                this.binding.d.setImageResource(premiumUtils.getNitroGiftIcon(data.getSku()));
            } else {
                Application application = data.getSku().getApplication();
                if (application != null && (icon = application.getIcon()) != null) {
                    applicationIcon$default = IconUtils.getApplicationIcon$default(data.getSku().getApplicationId(), icon, 0, 4, (Object) null);
                }
                this.binding.d.setImageURI(applicationIcon$default);
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
        Intrinsics3.checkNotNullParameter(recyclerView, "recycler");
        this.onClickSkuListener = WidgetSettingsGiftingAdapter$onClickSkuListener$1.INSTANCE;
        this.onClickCopyListener = WidgetSettingsGiftingAdapter$onClickCopyListener$1.INSTANCE;
        this.onRevokeClickListener = WidgetSettingsGiftingAdapter$onRevokeClickListener$1.INSTANCE;
        this.onGenerateClickListener = WidgetSettingsGiftingAdapter$onGenerateClickListener$1.INSTANCE;
    }

    public final void configure(List<GiftItem> giftItems, Function2<? super Long, ? super Long, Unit> onClickSkuListener, Function1<? super String, Unit> onClickCopyListener, Function1<? super ModelGift, Unit> onRevokeClickListener, Function2<? super Long, ? super Long, Unit> onGenerateClickListener) {
        Intrinsics3.checkNotNullParameter(giftItems, "giftItems");
        Intrinsics3.checkNotNullParameter(onClickSkuListener, "onClickSkuListener");
        Intrinsics3.checkNotNullParameter(onClickCopyListener, "onClickCopyListener");
        Intrinsics3.checkNotNullParameter(onRevokeClickListener, "onRevokeClickListener");
        Intrinsics3.checkNotNullParameter(onGenerateClickListener, "onGenerateClickListener");
        setData(giftItems);
        this.onClickSkuListener = onClickSkuListener;
        this.onClickCopyListener = onClickCopyListener;
        this.onRevokeClickListener = onRevokeClickListener;
        this.onGenerateClickListener = onGenerateClickListener;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public MGRecyclerViewHolder<WidgetSettingsGiftingAdapter, GiftItem> onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics3.checkNotNullParameter(parent, "parent");
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
            return this.typeInt == giftItem.typeInt && Intrinsics3.areEqual(this.gift, giftItem.gift) && Intrinsics3.areEqual(this.entitlement, giftItem.entitlement) && Intrinsics3.areEqual(this.expanded, giftItem.expanded) && Intrinsics3.areEqual(this.sku, giftItem.sku) && Intrinsics3.areEqual(this.copies, giftItem.copies) && Intrinsics3.areEqual(this.planId, giftItem.planId) && Intrinsics3.areEqual(this.isLastItem, giftItem.isLastItem) && Intrinsics3.areEqual(this.wasCopied, giftItem.wasCopied);
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
            StringBuilder sbU = outline.U("GiftItem(typeInt=");
            sbU.append(this.typeInt);
            sbU.append(", gift=");
            sbU.append(this.gift);
            sbU.append(", entitlement=");
            sbU.append(this.entitlement);
            sbU.append(", expanded=");
            sbU.append(this.expanded);
            sbU.append(", sku=");
            sbU.append(this.sku);
            sbU.append(", copies=");
            sbU.append(this.copies);
            sbU.append(", planId=");
            sbU.append(this.planId);
            sbU.append(", isLastItem=");
            sbU.append(this.isLastItem);
            sbU.append(", wasCopied=");
            return outline.D(sbU, this.wasCopied, ")");
        }

        public /* synthetic */ GiftItem(int i, ModelGift modelGift, ModelEntitlement modelEntitlement, Boolean bool, ModelSku modelSku, Integer num, Long l, Boolean bool2, Boolean bool3, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this(i, (i2 & 2) != 0 ? null : modelGift, (i2 & 4) != 0 ? null : modelEntitlement, (i2 & 8) != 0 ? null : bool, (i2 & 16) != 0 ? null : modelSku, (i2 & 32) != 0 ? null : num, (i2 & 64) != 0 ? null : l, (i2 & 128) != 0 ? null : bool2, (i2 & 256) == 0 ? bool3 : null);
        }
    }
}
