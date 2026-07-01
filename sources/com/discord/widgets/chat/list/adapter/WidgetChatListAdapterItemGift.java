package com.discord.widgets.chat.list.adapter;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.Barrier;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.ViewGroupKt;
import androidx.exifinterface.media.ExifInterface;
import b.a.k.b;
import com.discord.R$id;
import com.discord.R$layout;
import com.discord.api.application.Application;
import com.discord.api.user.User;
import com.discord.databinding.WidgetChatListAdapterItemGiftBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.domain.ModelGift;
import com.discord.models.domain.ModelSku;
import com.discord.models.domain.ModelStoreListing;
import com.discord.utilities.analytics.Traits$Payment$Type;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.drawable.DrawableCompat;
import com.discord.utilities.fresco.GrayscalePostprocessor;
import com.discord.utilities.gifting.GiftStyleKt;
import com.discord.utilities.gifting.GiftingUtils;
import com.discord.utilities.icon.IconUtils;
import com.discord.utilities.images.MGImages;
import com.discord.utilities.images.MGImages$ChangeDetector;
import com.discord.utilities.premium.PremiumUtils;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.time.ClockFactory;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.widgets.chat.list.entries.ChatListEntry;
import com.discord.widgets.chat.list.entries.GiftEntry;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.android.material.button.MaterialButton;
import d0.g0.t;
import d0.z.d.m;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function0;
import rx.Observable;
import rx.Subscription;

/* JADX INFO: compiled from: WidgetChatListAdapterItemGift.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChatListAdapterItemGift extends WidgetChatListItem {
    public static final WidgetChatListAdapterItemGift$Companion Companion = new WidgetChatListAdapterItemGift$Companion(null);
    private static final GrayscalePostprocessor SPLASH_IMAGE_POSTPROCESSOR = new GrayscalePostprocessor();
    private final WidgetChatListAdapterItemGiftBinding binding;
    private GiftEntry item;
    private Subscription subscription;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChatListAdapterItemGift(WidgetChatListAdapter widgetChatListAdapter) {
        super(R$layout.widget_chat_list_adapter_item_gift, widgetChatListAdapter);
        m.checkNotNullParameter(widgetChatListAdapter, "adapter");
        View view = this.itemView;
        int i = 2131362146;
        Barrier barrier = (Barrier) view.findViewById(2131362146);
        if (barrier != null) {
            i = R$id.buttonsContainer;
            FrameLayout frameLayout = (FrameLayout) view.findViewById(R$id.buttonsContainer);
            if (frameLayout != null) {
                i = R$id.item_gift_accept_button;
                MaterialButton materialButton = (MaterialButton) view.findViewById(R$id.item_gift_accept_button);
                if (materialButton != null) {
                    i = R$id.item_gift_cannot_claim_button;
                    MaterialButton materialButton2 = (MaterialButton) view.findViewById(R$id.item_gift_cannot_claim_button);
                    if (materialButton2 != null) {
                        i = R$id.item_gift_details;
                        LinearLayout linearLayout = (LinearLayout) view.findViewById(R$id.item_gift_details);
                        if (linearLayout != null) {
                            i = R$id.item_gift_expires;
                            TextView textView = (TextView) view.findViewById(R$id.item_gift_expires);
                            if (textView != null) {
                                i = R$id.item_gift_header;
                                TextView textView2 = (TextView) view.findViewById(R$id.item_gift_header);
                                if (textView2 != null) {
                                    i = R$id.item_gift_image;
                                    SimpleDraweeView simpleDraweeView = (SimpleDraweeView) view.findViewById(R$id.item_gift_image);
                                    if (simpleDraweeView != null) {
                                        i = R$id.item_gift_image_background;
                                        SimpleDraweeView simpleDraweeView2 = (SimpleDraweeView) view.findViewById(R$id.item_gift_image_background);
                                        if (simpleDraweeView2 != null) {
                                            i = R$id.item_gift_loading_button_placeholder;
                                            View viewFindViewById = view.findViewById(R$id.item_gift_loading_button_placeholder);
                                            if (viewFindViewById != null) {
                                                i = R$id.item_gift_name;
                                                TextView textView3 = (TextView) view.findViewById(R$id.item_gift_name);
                                                if (textView3 != null) {
                                                    i = R$id.item_gift_open_button;
                                                    MaterialButton materialButton3 = (MaterialButton) view.findViewById(R$id.item_gift_open_button);
                                                    if (materialButton3 != null) {
                                                        i = R$id.item_gift_subtext;
                                                        TextView textView4 = (TextView) view.findViewById(R$id.item_gift_subtext);
                                                        if (textView4 != null) {
                                                            i = R$id.item_gift_verify_button;
                                                            MaterialButton materialButton4 = (MaterialButton) view.findViewById(R$id.item_gift_verify_button);
                                                            if (materialButton4 != null) {
                                                                ConstraintLayout constraintLayout = (ConstraintLayout) view;
                                                                WidgetChatListAdapterItemGiftBinding widgetChatListAdapterItemGiftBinding = new WidgetChatListAdapterItemGiftBinding(constraintLayout, barrier, frameLayout, materialButton, materialButton2, linearLayout, textView, textView2, simpleDraweeView, simpleDraweeView2, viewFindViewById, textView3, materialButton3, textView4, materialButton4, constraintLayout);
                                                                m.checkNotNullExpressionValue(widgetChatListAdapterItemGiftBinding, "WidgetChatListAdapterIte…iftBinding.bind(itemView)");
                                                                this.binding = widgetChatListAdapterItemGiftBinding;
                                                                return;
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static final /* synthetic */ void access$configureInvalidUI(WidgetChatListAdapterItemGift widgetChatListAdapterItemGift, WidgetChatListAdapterItemGift$Model$Invalid widgetChatListAdapterItemGift$Model$Invalid) {
        widgetChatListAdapterItemGift.configureInvalidUI(widgetChatListAdapterItemGift$Model$Invalid);
    }

    public static final /* synthetic */ void access$configureUI(WidgetChatListAdapterItemGift widgetChatListAdapterItemGift, WidgetChatListAdapterItemGift$Model widgetChatListAdapterItemGift$Model) {
        widgetChatListAdapterItemGift.configureUI(widgetChatListAdapterItemGift$Model);
    }

    public static final /* synthetic */ GiftEntry access$getItem$p(WidgetChatListAdapterItemGift widgetChatListAdapterItemGift) {
        GiftEntry giftEntry = widgetChatListAdapterItemGift.item;
        if (giftEntry == null) {
            m.throwUninitializedPropertyAccessException("item");
        }
        return giftEntry;
    }

    public static final /* synthetic */ GrayscalePostprocessor access$getSPLASH_IMAGE_POSTPROCESSOR$cp() {
        return SPLASH_IMAGE_POSTPROCESSOR;
    }

    public static final /* synthetic */ Subscription access$getSubscription$p(WidgetChatListAdapterItemGift widgetChatListAdapterItemGift) {
        return widgetChatListAdapterItemGift.subscription;
    }

    public static final /* synthetic */ void access$setItem$p(WidgetChatListAdapterItemGift widgetChatListAdapterItemGift, GiftEntry giftEntry) {
        widgetChatListAdapterItemGift.item = giftEntry;
    }

    public static final /* synthetic */ void access$setSubscription$p(WidgetChatListAdapterItemGift widgetChatListAdapterItemGift, Subscription subscription) {
        widgetChatListAdapterItemGift.subscription = subscription;
    }

    private final void configureInvalidUI(WidgetChatListAdapterItemGift$Model$Invalid model) {
        View view = this.itemView;
        m.checkNotNullExpressionValue(view, "itemView");
        Context context = view.getContext();
        boolean zAreEqual = m.areEqual(model != null ? model.getGifterUserId() : null, model != null ? Long.valueOf(model.getMeId()) : null);
        SimpleDraweeView simpleDraweeView = this.binding.h;
        m.checkNotNullExpressionValue(simpleDraweeView, "binding.itemGiftImageBackground");
        simpleDraweeView.setVisibility(4);
        TextView textView = this.binding.f;
        m.checkNotNullExpressionValue(textView, "binding.itemGiftHeader");
        b.o(textView, zAreEqual ? context.getString(2131889731) : context.getString(2131889730), new Object[0], null, 4);
        TextView textView2 = this.binding.j;
        m.checkNotNullExpressionValue(textView2, "binding.itemGiftName");
        b.n(textView2, 2131889727, new Object[0], null, 4);
        this.binding.j.setTextColor(ColorCompat.getColor(context, 2131100382));
        this.binding.j.setBackgroundResource(0);
        m.checkNotNullExpressionValue(context, "context");
        this.binding.g.setImageResource(DrawableCompat.getThemedDrawableRes(context, 2130969610, 2131232414));
        TextView textView3 = this.binding.l;
        m.checkNotNullExpressionValue(textView3, "binding.itemGiftSubtext");
        textView3.setVisibility(8);
        TextView textView4 = this.binding.e;
        m.checkNotNullExpressionValue(textView4, "binding.itemGiftExpires");
        textView4.setVisibility(8);
        MaterialButton materialButton = this.binding.c;
        m.checkNotNullExpressionValue(materialButton, "binding.itemGiftAcceptButton");
        materialButton.setVisibility(8);
        MaterialButton materialButton2 = this.binding.d;
        m.checkNotNullExpressionValue(materialButton2, "binding.itemGiftCannotClaimButton");
        materialButton2.setVisibility(8);
        View view2 = this.binding.i;
        m.checkNotNullExpressionValue(view2, "binding.itemGiftLoadingButtonPlaceholder");
        view2.setVisibility(8);
        this.itemView.setOnClickListener(null);
    }

    private final void configureLoadingUI() {
        View view = this.itemView;
        m.checkNotNullExpressionValue(view, "itemView");
        Context context = view.getContext();
        TextView textView = this.binding.f;
        m.checkNotNullExpressionValue(textView, "binding.itemGiftHeader");
        b.n(textView, 2131889732, new Object[0], null, 4);
        TextView textView2 = this.binding.j;
        m.checkNotNullExpressionValue(textView2, "binding.itemGiftName");
        textView2.setText((CharSequence) null);
        this.binding.j.setTextColor(ColorCompat.getThemedColor(context, 2130969971));
        this.binding.j.setBackgroundResource(2131231211);
        this.binding.g.setActualImageResource(2131231211);
        SimpleDraweeView simpleDraweeView = this.binding.h;
        m.checkNotNullExpressionValue(simpleDraweeView, "binding.itemGiftImageBackground");
        simpleDraweeView.setVisibility(4);
        TextView textView3 = this.binding.l;
        m.checkNotNullExpressionValue(textView3, "binding.itemGiftSubtext");
        textView3.setVisibility(8);
        TextView textView4 = this.binding.e;
        m.checkNotNullExpressionValue(textView4, "binding.itemGiftExpires");
        textView4.setVisibility(8);
        MaterialButton materialButton = this.binding.c;
        m.checkNotNullExpressionValue(materialButton, "binding.itemGiftAcceptButton");
        materialButton.setVisibility(8);
        MaterialButton materialButton2 = this.binding.d;
        m.checkNotNullExpressionValue(materialButton2, "binding.itemGiftCannotClaimButton");
        materialButton2.setVisibility(8);
        View view2 = this.binding.i;
        m.checkNotNullExpressionValue(view2, "binding.itemGiftLoadingButtonPlaceholder");
        view2.setVisibility(0);
        this.itemView.setOnClickListener(null);
    }

    private final void configureResolvedUI(WidgetChatListAdapterItemGift$Model$Resolved model) {
        String applicationIcon$default;
        ModelSku sku;
        Application application;
        String icon;
        ModelSku sku2;
        String string;
        MaterialButton materialButton;
        ModelSku sku3;
        ModelSku sku4;
        Application application2;
        ModelSku sku5;
        View view = this.itemView;
        m.checkNotNullExpressionValue(view, "itemView");
        Context context = view.getContext();
        User user = model.getGift().getUser();
        boolean z2 = user != null && user.getId() == model.getMeUser().getId();
        boolean zIsClaimedByMe = model.getGift().isClaimedByMe();
        boolean z3 = model.getGift().getUses() == model.getGift().getMaxUses();
        boolean z4 = (model.getInLibrary() || z3 || model.getRedeeming() || !model.getMeUser().isVerified() || zIsClaimedByMe) ? false : true;
        IconUtils iconUtils = IconUtils.INSTANCE;
        ModelStoreListing storeListing = model.getGift().getStoreListing();
        long applicationId = (storeListing == null || (sku5 = storeListing.getSku()) == null) ? 0L : sku5.getApplicationId();
        ModelStoreListing storeListing2 = model.getGift().getStoreListing();
        String splash = (storeListing2 == null || (sku4 = storeListing2.getSku()) == null || (application2 = sku4.getApplication()) == null) ? null : application2.getSplash();
        View view2 = this.itemView;
        m.checkNotNullExpressionValue(view2, "itemView");
        String giftSplashUrl = iconUtils.getGiftSplashUrl(applicationId, splash, Integer.valueOf(view2.getWidth()));
        if (model.getGift().isAnyNitroGift()) {
            SimpleDraweeView simpleDraweeView = this.binding.h;
            PremiumUtils premiumUtils = PremiumUtils.INSTANCE;
            ModelGift gift = model.getGift();
            m.checkNotNullExpressionValue(context, "context");
            simpleDraweeView.setActualImageResource(premiumUtils.getNitroGiftBackground(gift, context));
            SimpleDraweeView simpleDraweeView2 = this.binding.h;
            m.checkNotNullExpressionValue(simpleDraweeView2, "binding.itemGiftImageBackground");
            simpleDraweeView2.setVisibility(0);
        } else if (giftSplashUrl != null) {
            SimpleDraweeView simpleDraweeView3 = this.binding.h;
            m.checkNotNullExpressionValue(simpleDraweeView3, "binding.itemGiftImageBackground");
            MGImages.setImage$default(simpleDraweeView3, giftSplashUrl, 0, 0, false, WidgetChatListAdapterItemGift$configureResolvedUI$1.INSTANCE, null, 92, null);
            SimpleDraweeView simpleDraweeView4 = this.binding.h;
            m.checkNotNullExpressionValue(simpleDraweeView4, "binding.itemGiftImageBackground");
            simpleDraweeView4.setVisibility(0);
        } else {
            SimpleDraweeView simpleDraweeView5 = this.binding.h;
            m.checkNotNullExpressionValue(simpleDraweeView5, "binding.itemGiftImageBackground");
            simpleDraweeView5.setVisibility(8);
        }
        TextView textView = this.binding.f;
        m.checkNotNullExpressionValue(textView, "binding.itemGiftHeader");
        b.o(textView, z2 ? context.getString(2131889737) : context.getString(2131889735), new Object[0], null, 4);
        TextView textView2 = this.binding.j;
        m.checkNotNullExpressionValue(textView2, "binding.itemGiftName");
        ModelStoreListing storeListing3 = model.getGift().getStoreListing();
        textView2.setText((storeListing3 == null || (sku3 = storeListing3.getSku()) == null) ? null : sku3.getName());
        this.binding.j.setTextColor(ColorCompat.getThemedColor(context, 2130969971));
        this.binding.j.setBackgroundResource(0);
        TextView textView3 = this.binding.e;
        m.checkNotNullExpressionValue(textView3, "binding.itemGiftExpires");
        textView3.setVisibility(model.getGift().getExpiresAt() != null ? 0 : 8);
        if (model.getGift().getExpiresAt() != null) {
            TextView textView4 = this.binding.e;
            m.checkNotNullExpressionValue(textView4, "binding.itemGiftExpires");
            m.checkNotNullExpressionValue(context, "context");
            textView4.setText(b.h(context, 2131889722, new Object[]{GiftingUtils.INSTANCE.getTimeString(model.getGift().getExpiresDiff(ClockFactory.get().currentTimeMillis()), context)}, null, 4));
        }
        if (model.getGift().isAnyNitroGift()) {
            MGImages mGImages = MGImages.INSTANCE;
            SimpleDraweeView simpleDraweeView6 = this.binding.g;
            m.checkNotNullExpressionValue(simpleDraweeView6, "binding.itemGiftImage");
            MGImages.setImage$default(mGImages, simpleDraweeView6, PremiumUtils.INSTANCE.getNitroGiftIcon(model.getGift()), (MGImages$ChangeDetector) null, 4, (Object) null);
        } else {
            ModelStoreListing storeListing4 = model.getGift().getStoreListing();
            if (storeListing4 == null || (sku = storeListing4.getSku()) == null || (application = sku.getApplication()) == null || (icon = application.getIcon()) == null) {
                applicationIcon$default = null;
            } else {
                ModelStoreListing storeListing5 = model.getGift().getStoreListing();
                applicationIcon$default = IconUtils.getApplicationIcon$default((storeListing5 == null || (sku2 = storeListing5.getSku()) == null) ? 0L : sku2.getApplicationId(), icon, 0, 4, (Object) null);
            }
            this.binding.g.setImageURI(applicationIcon$default);
        }
        if (!model.getMeUser().isVerified()) {
            String string2 = context.getString(2131889643);
            m.checkNotNullExpressionValue(string2, "context.getString(R.stri…xt_verification_required)");
            string = t.replace$default(t.replace$default(t.replace$default(string2, "(onClick)", "", false, 4, (Object) null), "[", "", false, 4, (Object) null), "]", "", false, 4, (Object) null);
        } else if (zIsClaimedByMe) {
            string = context.getString(2131889695);
        } else if (model.getInLibrary()) {
            m.checkNotNullExpressionValue(context, "context");
            string = t.replace$default(t.replace$default(t.replace$default(b.h(context, 2131889642, new Object[]{""}, null, 4).toString(), "()", "", false, 4, (Object) null), "[", "", false, 4, (Object) null), "]", "", false, 4, (Object) null);
        } else {
            string = z3 ? context.getString(2131889641) : null;
        }
        TextView textView5 = this.binding.l;
        m.checkNotNullExpressionValue(textView5, "binding.itemGiftSubtext");
        ViewExtensions.setTextAndVisibilityBy(textView5, string);
        if (z4) {
            materialButton = GiftStyleKt.hasCustomStyle(model.getGift()) ? this.binding.k : this.binding.c;
            materialButton.setOnClickListener(new WidgetChatListAdapterItemGift$configureResolvedUI$$inlined$apply$lambda$1(this, model));
        } else if (model.getMeUser().isVerified()) {
            materialButton = this.binding.d;
            int i = 2131889717;
            if (model.getRedeeming()) {
                i = 2131889718;
            } else if (!zIsClaimedByMe && model.getInLibrary()) {
                i = 2131889720;
            }
            b.n(materialButton, i, new Object[0], null, 4);
        } else {
            materialButton = this.binding.m;
            materialButton.setOnClickListener(WidgetChatListAdapterItemGift$configureResolvedUI$visibleButton$2$1.INSTANCE);
        }
        m.checkNotNullExpressionValue(materialButton, "if (canAccept) {\n      i…}\n        )\n      }\n    }");
        FrameLayout frameLayout = this.binding.f2320b;
        m.checkNotNullExpressionValue(frameLayout, "binding.buttonsContainer");
        for (View view3 : ViewGroupKt.getChildren(frameLayout)) {
            if (view3 == materialButton) {
                ((MaterialButton) view3).setVisibility(0);
            } else {
                view3.setVisibility(8);
            }
        }
        if (model.getGift().isAnyNitroGift()) {
            this.itemView.setOnClickListener(WidgetChatListAdapterItemGift$configureResolvedUI$3.INSTANCE);
        } else {
            this.itemView.setOnClickListener(new WidgetChatListAdapterItemGift$configureResolvedUI$4(context, model));
        }
    }

    private final void configureUI(WidgetChatListAdapterItemGift$Model model) {
        if (model instanceof WidgetChatListAdapterItemGift$Model$Loading) {
            configureLoadingUI();
        } else if (model instanceof WidgetChatListAdapterItemGift$Model$Resolved) {
            configureResolvedUI((WidgetChatListAdapterItemGift$Model$Resolved) model);
        } else {
            if (!(model instanceof WidgetChatListAdapterItemGift$Model$Invalid)) {
                throw new NoWhenBranchMatchedException();
            }
            configureInvalidUI((WidgetChatListAdapterItemGift$Model$Invalid) model);
        }
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
    public Subscription getSubscription() {
        return this.subscription;
    }

    @Override // com.discord.widgets.chat.list.adapter.WidgetChatListItem, com.discord.utilities.mg_recycler.MGRecyclerViewHolder
    public /* bridge */ /* synthetic */ void onConfigure(int i, ChatListEntry chatListEntry) {
        onConfigure(i, chatListEntry);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.discord.widgets.chat.list.adapter.WidgetChatListItem
    public void onConfigure(int position, ChatListEntry data) {
        m.checkNotNullParameter(data, "data");
        super.onConfigure(position, data);
        GiftEntry giftEntry = (GiftEntry) data;
        this.item = giftEntry;
        WidgetChatListAdapterItemGift$ModelProvider widgetChatListAdapterItemGift$ModelProvider = WidgetChatListAdapterItemGift$ModelProvider.INSTANCE;
        if (giftEntry == null) {
            m.throwUninitializedPropertyAccessException("item");
        }
        Observable observableUi = ObservableExtensionsKt.ui(widgetChatListAdapterItemGift$ModelProvider.get(giftEntry));
        WidgetChatListAdapterItemGift$onConfigure$1 widgetChatListAdapterItemGift$onConfigure$1 = new WidgetChatListAdapterItemGift$onConfigure$1(this);
        ObservableExtensionsKt.appSubscribe$default(observableUi, WidgetChatListAdapterItemGift.class, (Context) null, new WidgetChatListAdapterItemGift$onConfigure$3(this), new WidgetChatListAdapterItemGift$onConfigure$2(this), (Function0) null, (Function0) null, widgetChatListAdapterItemGift$onConfigure$1, 50, (Object) null);
    }
}
