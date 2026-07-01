package com.discord.widgets.settings.premium;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;
import b.a.k.FormatUtils;
import com.discord.R;
import com.discord.databinding.ViewGiftOutboundPromoListItemBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.icon.IconUtils;
import com.discord.utilities.images.MGImages;
import com.discord.utilities.time.TimeUtils;
import com.discord.utilities.view.recycler.SimpleItemCallback;
import com.discord.widgets.settings.premium.ClaimStatus;
import com.discord.widgets.settings.premium.SettingsGiftingViewModel;
import com.discord.widgets.settings.premium.WidgetSettingsGiftingOutboundPromosAdapter;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.card.MaterialCardView;
import d0.z.d.Intrinsics3;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetSettingsGiftingOutboundPromosAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetSettingsGiftingOutboundPromosAdapter extends ListAdapter<SettingsGiftingViewModel.OutboundPromoItem, OutboundPromoViewHolder> {
    private static final SimpleItemCallback<SettingsGiftingViewModel.OutboundPromoItem> DIFF_CALLBACK = new SimpleItemCallback<>(WidgetSettingsGiftingOutboundPromosAdapter2.INSTANCE);
    private final Function1<SettingsGiftingViewModel.OutboundPromoItem, Unit> onButtonClick;
    private final Function1<SettingsGiftingViewModel.OutboundPromoItem, Unit> onMoreDetailsClick;

    /* JADX INFO: compiled from: WidgetSettingsGiftingOutboundPromosAdapter.kt */
    public static final class OutboundPromoViewHolder extends RecyclerView.ViewHolder {
        private final ViewGiftOutboundPromoListItemBinding binding;
        private SettingsGiftingViewModel.OutboundPromoItem boundItem;
        private final Function1<SettingsGiftingViewModel.OutboundPromoItem, Unit> onButtonClick;
        private final Function1<SettingsGiftingViewModel.OutboundPromoItem, Unit> onMoreDetailsClick;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public OutboundPromoViewHolder(ViewGroup viewGroup, Function1<? super SettingsGiftingViewModel.OutboundPromoItem, Unit> function1, Function1<? super SettingsGiftingViewModel.OutboundPromoItem, Unit> function2) {
            super(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.view_gift_outbound_promo_list_item, viewGroup, false));
            Intrinsics3.checkNotNullParameter(viewGroup, "parent");
            Intrinsics3.checkNotNullParameter(function1, "onMoreDetailsClick");
            Intrinsics3.checkNotNullParameter(function2, "onButtonClick");
            this.onMoreDetailsClick = function1;
            this.onButtonClick = function2;
            View view = this.itemView;
            int i = R.id.giftPromoButton;
            MaterialButton materialButton = (MaterialButton) view.findViewById(R.id.giftPromoButton);
            if (materialButton != null) {
                i = R.id.giftPromoDescription;
                TextView textView = (TextView) view.findViewById(R.id.giftPromoDescription);
                if (textView != null) {
                    i = R.id.giftPromoImage;
                    SimpleDraweeView simpleDraweeView = (SimpleDraweeView) view.findViewById(R.id.giftPromoImage);
                    if (simpleDraweeView != null) {
                        i = R.id.giftPromoMoreDetails;
                        TextView textView2 = (TextView) view.findViewById(R.id.giftPromoMoreDetails);
                        if (textView2 != null) {
                            i = R.id.giftPromoTitle;
                            TextView textView3 = (TextView) view.findViewById(R.id.giftPromoTitle);
                            if (textView3 != null) {
                                ViewGiftOutboundPromoListItemBinding viewGiftOutboundPromoListItemBinding = new ViewGiftOutboundPromoListItemBinding((MaterialCardView) view, materialButton, textView, simpleDraweeView, textView2, textView3);
                                textView2.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.settings.premium.WidgetSettingsGiftingOutboundPromosAdapter$OutboundPromoViewHolder$$special$$inlined$also$lambda$1
                                    @Override // android.view.View.OnClickListener
                                    public final void onClick(View view2) {
                                        this.this$0.onMoreDetailsClick.invoke(WidgetSettingsGiftingOutboundPromosAdapter.OutboundPromoViewHolder.access$getBoundItem$p(this.this$0));
                                    }
                                });
                                materialButton.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.settings.premium.WidgetSettingsGiftingOutboundPromosAdapter$OutboundPromoViewHolder$$special$$inlined$also$lambda$2
                                    @Override // android.view.View.OnClickListener
                                    public final void onClick(View view2) {
                                        this.this$0.onButtonClick.invoke(WidgetSettingsGiftingOutboundPromosAdapter.OutboundPromoViewHolder.access$getBoundItem$p(this.this$0));
                                    }
                                });
                                Intrinsics3.checkNotNullExpressionValue(viewGiftOutboundPromoListItemBinding, "ViewGiftOutboundPromoLis…nClick(boundItem) }\n    }");
                                this.binding = viewGiftOutboundPromoListItemBinding;
                                return;
                            }
                        }
                    }
                }
            }
            throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
        }

        public static final /* synthetic */ SettingsGiftingViewModel.OutboundPromoItem access$getBoundItem$p(OutboundPromoViewHolder outboundPromoViewHolder) {
            SettingsGiftingViewModel.OutboundPromoItem outboundPromoItem = outboundPromoViewHolder.boundItem;
            if (outboundPromoItem == null) {
                Intrinsics3.throwUninitializedPropertyAccessException("boundItem");
            }
            return outboundPromoItem;
        }

        public final void bindTo(SettingsGiftingViewModel.OutboundPromoItem item) {
            Intrinsics3.checkNotNullParameter(item, "item");
            this.boundItem = item;
            SimpleDraweeView simpleDraweeView = this.binding.d;
            Intrinsics3.checkNotNullExpressionValue(simpleDraweeView, "binding.giftPromoImage");
            IconUtils.setIcon$default(simpleDraweeView, item.getImageUrl(), 0, (Function1) null, new MGImages.DistinctChangeDetector(), 12, (Object) null);
            TextView textView = this.binding.f;
            Intrinsics3.checkNotNullExpressionValue(textView, "binding.giftPromoTitle");
            textView.setText(item.getTitle());
            ClaimStatus claimStatus = item.getClaimStatus();
            if (claimStatus instanceof ClaimStatus.Unclaimed) {
                long dateTimeMillis = ((ClaimStatus.Unclaimed) item.getClaimStatus()).getClaimBy().getDateTimeMillis();
                TimeUtils timeUtils = TimeUtils.INSTANCE;
                View view = this.itemView;
                Intrinsics3.checkNotNullExpressionValue(view, "itemView");
                Context context = view.getContext();
                Intrinsics3.checkNotNullExpressionValue(context, "itemView.context");
                String strRenderUtcDate = timeUtils.renderUtcDate(dateTimeMillis, context, 1);
                TextView textView2 = this.binding.c;
                Intrinsics3.checkNotNullExpressionValue(textView2, "binding.giftPromoDescription");
                FormatUtils.m(textView2, R.string.mobile_outbound_promotion_card_unclaimed_body, new Object[]{strRenderUtcDate}, (4 & 4) != 0 ? FormatUtils.g.j : null);
                MaterialButton materialButton = this.binding.f2187b;
                Intrinsics3.checkNotNullExpressionValue(materialButton, "binding.giftPromoButton");
                FormatUtils.m(materialButton, R.string.promotion_card_action_claim, new Object[0], (4 & 4) != 0 ? FormatUtils.g.j : null);
                return;
            }
            if (claimStatus instanceof ClaimStatus.Claimed) {
                long dateTimeMillis2 = ((ClaimStatus.Claimed) item.getClaimStatus()).getRedeemBy().getDateTimeMillis();
                TimeUtils timeUtils2 = TimeUtils.INSTANCE;
                View view2 = this.itemView;
                Intrinsics3.checkNotNullExpressionValue(view2, "itemView");
                Context context2 = view2.getContext();
                Intrinsics3.checkNotNullExpressionValue(context2, "itemView.context");
                String strRenderUtcDate2 = timeUtils2.renderUtcDate(dateTimeMillis2, context2, 1);
                TextView textView3 = this.binding.c;
                Intrinsics3.checkNotNullExpressionValue(textView3, "binding.giftPromoDescription");
                FormatUtils.m(textView3, R.string.mobile_outbound_promotion_card_claimed_body, new Object[]{strRenderUtcDate2}, (4 & 4) != 0 ? FormatUtils.g.j : null);
                MaterialButton materialButton2 = this.binding.f2187b;
                Intrinsics3.checkNotNullExpressionValue(materialButton2, "binding.giftPromoButton");
                FormatUtils.m(materialButton2, R.string.outbound_promotion_see_code, new Object[0], (4 & 4) != 0 ? FormatUtils.g.j : null);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public WidgetSettingsGiftingOutboundPromosAdapter(Function1<? super SettingsGiftingViewModel.OutboundPromoItem, Unit> function1, Function1<? super SettingsGiftingViewModel.OutboundPromoItem, Unit> function2) {
        super(DIFF_CALLBACK);
        Intrinsics3.checkNotNullParameter(function1, "onMoreDetailsClick");
        Intrinsics3.checkNotNullParameter(function2, "onButtonClick");
        this.onMoreDetailsClick = function1;
        this.onButtonClick = function2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(OutboundPromoViewHolder holder, int position) {
        Intrinsics3.checkNotNullParameter(holder, "holder");
        SettingsGiftingViewModel.OutboundPromoItem item = getItem(position);
        Intrinsics3.checkNotNullExpressionValue(item, "getItem(position)");
        holder.bindTo(item);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public OutboundPromoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics3.checkNotNullParameter(parent, "parent");
        return new OutboundPromoViewHolder(parent, this.onMoreDetailsClick, this.onButtonClick);
    }
}
