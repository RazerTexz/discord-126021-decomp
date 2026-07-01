package com.discord.widgets.settings.premium;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView$ViewHolder;
import b.a.k.b;
import com.discord.R$id;
import com.discord.R$layout;
import com.discord.databinding.ViewGiftOutboundPromoListItemBinding;
import com.discord.utilities.icon.IconUtils;
import com.discord.utilities.images.MGImages$DistinctChangeDetector;
import com.discord.utilities.time.TimeUtils;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.card.MaterialCardView;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetSettingsGiftingOutboundPromosAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetSettingsGiftingOutboundPromosAdapter$OutboundPromoViewHolder extends RecyclerView$ViewHolder {
    private final ViewGiftOutboundPromoListItemBinding binding;
    private SettingsGiftingViewModel$OutboundPromoItem boundItem;
    private final Function1<SettingsGiftingViewModel$OutboundPromoItem, Unit> onButtonClick;
    private final Function1<SettingsGiftingViewModel$OutboundPromoItem, Unit> onMoreDetailsClick;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public WidgetSettingsGiftingOutboundPromosAdapter$OutboundPromoViewHolder(ViewGroup viewGroup, Function1<? super SettingsGiftingViewModel$OutboundPromoItem, Unit> function1, Function1<? super SettingsGiftingViewModel$OutboundPromoItem, Unit> function2) {
        super(LayoutInflater.from(viewGroup.getContext()).inflate(R$layout.view_gift_outbound_promo_list_item, viewGroup, false));
        m.checkNotNullParameter(viewGroup, "parent");
        m.checkNotNullParameter(function1, "onMoreDetailsClick");
        m.checkNotNullParameter(function2, "onButtonClick");
        this.onMoreDetailsClick = function1;
        this.onButtonClick = function2;
        View view = this.itemView;
        int i = R$id.giftPromoButton;
        MaterialButton materialButton = (MaterialButton) view.findViewById(R$id.giftPromoButton);
        if (materialButton != null) {
            i = R$id.giftPromoDescription;
            TextView textView = (TextView) view.findViewById(R$id.giftPromoDescription);
            if (textView != null) {
                i = R$id.giftPromoImage;
                SimpleDraweeView simpleDraweeView = (SimpleDraweeView) view.findViewById(R$id.giftPromoImage);
                if (simpleDraweeView != null) {
                    i = R$id.giftPromoMoreDetails;
                    TextView textView2 = (TextView) view.findViewById(R$id.giftPromoMoreDetails);
                    if (textView2 != null) {
                        i = R$id.giftPromoTitle;
                        TextView textView3 = (TextView) view.findViewById(R$id.giftPromoTitle);
                        if (textView3 != null) {
                            ViewGiftOutboundPromoListItemBinding viewGiftOutboundPromoListItemBinding = new ViewGiftOutboundPromoListItemBinding((MaterialCardView) view, materialButton, textView, simpleDraweeView, textView2, textView3);
                            textView2.setOnClickListener(new WidgetSettingsGiftingOutboundPromosAdapter$OutboundPromoViewHolder$$special$$inlined$also$lambda$1(this));
                            materialButton.setOnClickListener(new WidgetSettingsGiftingOutboundPromosAdapter$OutboundPromoViewHolder$$special$$inlined$also$lambda$2(this));
                            m.checkNotNullExpressionValue(viewGiftOutboundPromoListItemBinding, "ViewGiftOutboundPromoLis…nClick(boundItem) }\n    }");
                            this.binding = viewGiftOutboundPromoListItemBinding;
                            return;
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static final /* synthetic */ SettingsGiftingViewModel$OutboundPromoItem access$getBoundItem$p(WidgetSettingsGiftingOutboundPromosAdapter$OutboundPromoViewHolder widgetSettingsGiftingOutboundPromosAdapter$OutboundPromoViewHolder) {
        SettingsGiftingViewModel$OutboundPromoItem settingsGiftingViewModel$OutboundPromoItem = widgetSettingsGiftingOutboundPromosAdapter$OutboundPromoViewHolder.boundItem;
        if (settingsGiftingViewModel$OutboundPromoItem == null) {
            m.throwUninitializedPropertyAccessException("boundItem");
        }
        return settingsGiftingViewModel$OutboundPromoItem;
    }

    public static final /* synthetic */ Function1 access$getOnButtonClick$p(WidgetSettingsGiftingOutboundPromosAdapter$OutboundPromoViewHolder widgetSettingsGiftingOutboundPromosAdapter$OutboundPromoViewHolder) {
        return widgetSettingsGiftingOutboundPromosAdapter$OutboundPromoViewHolder.onButtonClick;
    }

    public static final /* synthetic */ Function1 access$getOnMoreDetailsClick$p(WidgetSettingsGiftingOutboundPromosAdapter$OutboundPromoViewHolder widgetSettingsGiftingOutboundPromosAdapter$OutboundPromoViewHolder) {
        return widgetSettingsGiftingOutboundPromosAdapter$OutboundPromoViewHolder.onMoreDetailsClick;
    }

    public static final /* synthetic */ void access$setBoundItem$p(WidgetSettingsGiftingOutboundPromosAdapter$OutboundPromoViewHolder widgetSettingsGiftingOutboundPromosAdapter$OutboundPromoViewHolder, SettingsGiftingViewModel$OutboundPromoItem settingsGiftingViewModel$OutboundPromoItem) {
        widgetSettingsGiftingOutboundPromosAdapter$OutboundPromoViewHolder.boundItem = settingsGiftingViewModel$OutboundPromoItem;
    }

    public final void bindTo(SettingsGiftingViewModel$OutboundPromoItem item) {
        m.checkNotNullParameter(item, "item");
        this.boundItem = item;
        SimpleDraweeView simpleDraweeView = this.binding.d;
        m.checkNotNullExpressionValue(simpleDraweeView, "binding.giftPromoImage");
        IconUtils.setIcon$default(simpleDraweeView, item.getImageUrl(), 0, (Function1) null, new MGImages$DistinctChangeDetector(), 12, (Object) null);
        TextView textView = this.binding.f;
        m.checkNotNullExpressionValue(textView, "binding.giftPromoTitle");
        textView.setText(item.getTitle());
        ClaimStatus claimStatus = item.getClaimStatus();
        if (claimStatus instanceof ClaimStatus$Unclaimed) {
            long dateTimeMillis = ((ClaimStatus$Unclaimed) item.getClaimStatus()).getClaimBy().getDateTimeMillis();
            TimeUtils timeUtils = TimeUtils.INSTANCE;
            View view = this.itemView;
            m.checkNotNullExpressionValue(view, "itemView");
            Context context = view.getContext();
            m.checkNotNullExpressionValue(context, "itemView.context");
            String strRenderUtcDate = timeUtils.renderUtcDate(dateTimeMillis, context, 1);
            TextView textView2 = this.binding.c;
            m.checkNotNullExpressionValue(textView2, "binding.giftPromoDescription");
            b.n(textView2, 2131893033, new Object[]{strRenderUtcDate}, null, 4);
            MaterialButton materialButton = this.binding.f2187b;
            m.checkNotNullExpressionValue(materialButton, "binding.giftPromoButton");
            b.n(materialButton, 2131894591, new Object[0], null, 4);
            return;
        }
        if (claimStatus instanceof ClaimStatus$Claimed) {
            long dateTimeMillis2 = ((ClaimStatus$Claimed) item.getClaimStatus()).getRedeemBy().getDateTimeMillis();
            TimeUtils timeUtils2 = TimeUtils.INSTANCE;
            View view2 = this.itemView;
            m.checkNotNullExpressionValue(view2, "itemView");
            Context context2 = view2.getContext();
            m.checkNotNullExpressionValue(context2, "itemView.context");
            String strRenderUtcDate2 = timeUtils2.renderUtcDate(dateTimeMillis2, context2, 1);
            TextView textView3 = this.binding.c;
            m.checkNotNullExpressionValue(textView3, "binding.giftPromoDescription");
            b.n(textView3, 2131893032, new Object[]{strRenderUtcDate2}, null, 4);
            MaterialButton materialButton2 = this.binding.f2187b;
            m.checkNotNullExpressionValue(materialButton2, "binding.giftPromoButton");
            b.n(materialButton2, 2131893552, new Object[0], null, 4);
        }
    }
}
