package com.discord.widgets.settings.premium;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup$LayoutParams;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import b.a.k.b;
import com.discord.R$id;
import com.discord.R$layout;
import com.discord.app.AppViewFlipper;
import com.discord.databinding.ViewGiftEntitlementListItemBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.drawable.DrawableCompat;
import com.discord.utilities.gifting.GiftingUtils;
import com.discord.utilities.mg_recycler.MGRecyclerViewHolder;
import com.discord.utilities.time.ClockFactory;
import com.discord.utilities.view.text.LinkifiedTextView;
import com.google.android.material.button.MaterialButton;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetSettingsGiftingAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetSettingsGiftingAdapter$EntitlementListItem extends MGRecyclerViewHolder<WidgetSettingsGiftingAdapter, WidgetSettingsGiftingAdapter$GiftItem> {
    public static final WidgetSettingsGiftingAdapter$EntitlementListItem$Companion Companion = new WidgetSettingsGiftingAdapter$EntitlementListItem$Companion(null);
    private static final int VIEW_INDEX_CODE = 0;
    private static final int VIEW_INDEX_GENERATE = 1;
    private final ViewGiftEntitlementListItemBinding binding;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetSettingsGiftingAdapter$EntitlementListItem(WidgetSettingsGiftingAdapter widgetSettingsGiftingAdapter) {
        super(R$layout.view_gift_entitlement_list_item, widgetSettingsGiftingAdapter);
        m.checkNotNullParameter(widgetSettingsGiftingAdapter, "adapter");
        View view = this.itemView;
        int i = R$id.gift_entitlement_code;
        TextView textView = (TextView) view.findViewById(R$id.gift_entitlement_code);
        if (textView != null) {
            i = R$id.gift_entitlement_code_container;
            RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R$id.gift_entitlement_code_container);
            if (relativeLayout != null) {
                FrameLayout frameLayout = (FrameLayout) view;
                i = R$id.gift_entitlement_copy;
                MaterialButton materialButton = (MaterialButton) view.findViewById(R$id.gift_entitlement_copy);
                if (materialButton != null) {
                    i = R$id.gift_entitlement_divider;
                    View viewFindViewById = view.findViewById(R$id.gift_entitlement_divider);
                    if (viewFindViewById != null) {
                        i = R$id.gift_entitlement_flipper;
                        AppViewFlipper appViewFlipper = (AppViewFlipper) view.findViewById(R$id.gift_entitlement_flipper);
                        if (appViewFlipper != null) {
                            i = R$id.gift_entitlement_generate;
                            MaterialButton materialButton2 = (MaterialButton) view.findViewById(R$id.gift_entitlement_generate);
                            if (materialButton2 != null) {
                                i = R$id.gift_entitlement_revoke;
                                LinkifiedTextView linkifiedTextView = (LinkifiedTextView) view.findViewById(R$id.gift_entitlement_revoke);
                                if (linkifiedTextView != null) {
                                    ViewGiftEntitlementListItemBinding viewGiftEntitlementListItemBinding = new ViewGiftEntitlementListItemBinding(frameLayout, textView, relativeLayout, frameLayout, materialButton, viewFindViewById, appViewFlipper, materialButton2, linkifiedTextView);
                                    m.checkNotNullExpressionValue(viewGiftEntitlementListItemBinding, "ViewGiftEntitlementListItemBinding.bind(itemView)");
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

    public static final /* synthetic */ WidgetSettingsGiftingAdapter access$getAdapter$p(WidgetSettingsGiftingAdapter$EntitlementListItem widgetSettingsGiftingAdapter$EntitlementListItem) {
        return (WidgetSettingsGiftingAdapter) widgetSettingsGiftingAdapter$EntitlementListItem.adapter;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
    public /* bridge */ /* synthetic */ void onConfigure(int i, WidgetSettingsGiftingAdapter$GiftItem widgetSettingsGiftingAdapter$GiftItem) {
        onConfigure2(i, widgetSettingsGiftingAdapter$GiftItem);
    }

    /* JADX INFO: renamed from: onConfigure, reason: avoid collision after fix types in other method */
    public void onConfigure2(int position, WidgetSettingsGiftingAdapter$GiftItem data) {
        int themedDrawableRes$default;
        m.checkNotNullParameter(data, "data");
        super.onConfigure(position, data);
        if (m.areEqual(data.getExpanded(), Boolean.FALSE)) {
            View view = this.itemView;
            m.checkNotNullExpressionValue(view, "itemView");
            View view2 = this.itemView;
            m.checkNotNullExpressionValue(view2, "itemView");
            ViewGroup$LayoutParams layoutParams = view2.getLayoutParams();
            layoutParams.height = 0;
            view.setLayoutParams(layoutParams);
            return;
        }
        View view3 = this.itemView;
        m.checkNotNullExpressionValue(view3, "itemView");
        View view4 = this.itemView;
        m.checkNotNullExpressionValue(view4, "itemView");
        ViewGroup$LayoutParams layoutParams2 = view4.getLayoutParams();
        layoutParams2.height = -2;
        view3.setLayoutParams(layoutParams2);
        View view5 = this.itemView;
        m.checkNotNullExpressionValue(view5, "itemView");
        Context context = view5.getContext();
        if (data.getEntitlement() == null || data.isLastItem() == null) {
            return;
        }
        if (data.getGift() != null) {
            AppViewFlipper appViewFlipper = this.binding.g;
            m.checkNotNullExpressionValue(appViewFlipper, "binding.giftEntitlementFlipper");
            appViewFlipper.setDisplayedChild(0);
            boolean zAreEqual = m.areEqual(data.getWasCopied(), Boolean.TRUE);
            MaterialButton materialButton = this.binding.e;
            m.checkNotNullExpressionValue(materialButton, "binding.giftEntitlementCopy");
            View view6 = this.itemView;
            m.checkNotNullExpressionValue(view6, "itemView");
            materialButton.setText(b.j(view6, zAreEqual ? 2131887923 : 2131887926, new Object[0], null, 4));
            RelativeLayout relativeLayout = this.binding.c;
            if (zAreEqual) {
                m.checkNotNullExpressionValue(context, "context");
                themedDrawableRes$default = DrawableCompat.getThemedDrawableRes$default(context, 2130969404, 0, 2, (Object) null);
            } else {
                m.checkNotNullExpressionValue(context, "context");
                themedDrawableRes$default = DrawableCompat.getThemedDrawableRes$default(context, 2130969996, 0, 2, (Object) null);
            }
            relativeLayout.setBackgroundResource(themedDrawableRes$default);
            this.binding.e.setOnClickListener(new WidgetSettingsGiftingAdapter$EntitlementListItem$onConfigure$3(this, data));
            GiftingUtils giftingUtils = GiftingUtils.INSTANCE;
            CharSequence timeString = giftingUtils.getTimeString(data.getGift().getExpiresDiff(ClockFactory.get().currentTimeMillis()), context);
            LinkifiedTextView linkifiedTextView = this.binding.i;
            m.checkNotNullExpressionValue(linkifiedTextView, "binding.giftEntitlementRevoke");
            b.m(linkifiedTextView, 2131889743, new Object[]{timeString}, new WidgetSettingsGiftingAdapter$EntitlementListItem$onConfigure$4(this, data));
            TextView textView = this.binding.f2186b;
            m.checkNotNullExpressionValue(textView, "binding.giftEntitlementCode");
            textView.setText(giftingUtils.generateGiftUrl(data.getGift().getCode()));
        } else {
            AppViewFlipper appViewFlipper2 = this.binding.g;
            m.checkNotNullExpressionValue(appViewFlipper2, "binding.giftEntitlementFlipper");
            appViewFlipper2.setDisplayedChild(1);
            this.binding.h.setOnClickListener(new WidgetSettingsGiftingAdapter$EntitlementListItem$onConfigure$5(this, data));
        }
        View view7 = this.binding.f;
        m.checkNotNullExpressionValue(view7, "binding.giftEntitlementDivider");
        view7.setVisibility(data.isLastItem().booleanValue() ^ true ? 0 : 8);
        if (!data.isLastItem().booleanValue()) {
            FrameLayout frameLayout = this.binding.d;
            View view8 = this.itemView;
            m.checkNotNullExpressionValue(view8, "itemView");
            frameLayout.setBackgroundColor(ColorCompat.getThemedColor(view8.getContext(), 2130969991));
            return;
        }
        FrameLayout frameLayout2 = this.binding.d;
        View view9 = this.itemView;
        m.checkNotNullExpressionValue(view9, "itemView");
        Context context2 = view9.getContext();
        m.checkNotNullExpressionValue(context2, "itemView.context");
        frameLayout2.setBackgroundResource(DrawableCompat.getThemedDrawableRes$default(context2, 2130969993, 0, 2, (Object) null));
    }
}
