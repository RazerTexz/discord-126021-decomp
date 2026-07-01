package com.discord.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import b.a.i.y1;
import b.a.k.b;
import com.discord.R$id;
import com.discord.R$layout;
import com.discord.R$plurals;
import com.discord.models.domain.ModelSubscription;
import com.discord.models.domain.ModelSubscription$Status;
import com.discord.utilities.analytics.Traits$Payment$Type;
import com.discord.utilities.billing.GooglePlaySku;
import com.discord.utilities.billing.GooglePlaySku$Type;
import com.discord.utilities.billing.GooglePlaySkuKt;
import com.discord.utilities.drawable.DrawableCompat;
import com.discord.utilities.resources.StringResourceUtilsKt;
import com.google.android.material.button.MaterialButton;
import d0.z.d.m;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: ActiveSubscriptionView.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ActiveSubscriptionView extends FrameLayout {
    public static final /* synthetic */ int j = 0;

    /* JADX INFO: renamed from: k, reason: from kotlin metadata */
    public final y1 binding;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ActiveSubscriptionView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        m.checkNotNullParameter(context, "context");
        View viewInflate = LayoutInflater.from(context).inflate(R$layout.view_active_subscription, (ViewGroup) this, false);
        addView(viewInflate);
        int i = R$id.active_subscription_cancel_button;
        TextView textView = (TextView) viewInflate.findViewById(R$id.active_subscription_cancel_button);
        if (textView != null) {
            i = R$id.active_subscription_header_background;
            ImageView imageView = (ImageView) viewInflate.findViewById(R$id.active_subscription_header_background);
            if (imageView != null) {
                i = R$id.active_subscription_header_icon;
                ImageView imageView2 = (ImageView) viewInflate.findViewById(R$id.active_subscription_header_icon);
                if (imageView2 != null) {
                    i = R$id.active_subscription_header_logo;
                    ImageView imageView3 = (ImageView) viewInflate.findViewById(R$id.active_subscription_header_logo);
                    if (imageView3 != null) {
                        i = R$id.active_subscription_header_text;
                        TextView textView2 = (TextView) viewInflate.findViewById(R$id.active_subscription_header_text);
                        if (textView2 != null) {
                            i = R$id.active_subscription_manage_guild_boost_button;
                            MaterialButton materialButton = (MaterialButton) viewInflate.findViewById(R$id.active_subscription_manage_guild_boost_button);
                            if (materialButton != null) {
                                i = R$id.active_subscription_progress;
                                ProgressBar progressBar = (ProgressBar) viewInflate.findViewById(R$id.active_subscription_progress);
                                if (progressBar != null) {
                                    i = R$id.active_subscription_top_button;
                                    MaterialButton materialButton2 = (MaterialButton) viewInflate.findViewById(R$id.active_subscription_top_button);
                                    if (materialButton2 != null) {
                                        y1 y1Var = new y1((FrameLayout) viewInflate, textView, imageView, imageView2, imageView3, textView2, materialButton, progressBar, materialButton2);
                                        m.checkNotNullExpressionValue(y1Var, "ViewActiveSubscriptionBi…rom(context), this, true)");
                                        this.binding = y1Var;
                                        return;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i)));
    }

    public static final ActiveSubscriptionView$ActiveSubscriptionType b(ModelSubscription modelSubscription) {
        m.checkNotNullParameter(modelSubscription, Traits$Payment$Type.SUBSCRIPTION);
        if (modelSubscription.isGoogleSubscription()) {
            String paymentGatewayPlanId = modelSubscription.getPaymentGatewayPlanId();
            GooglePlaySku googlePlaySkuFromSkuName = paymentGatewayPlanId != null ? GooglePlaySku.Companion.fromSkuName(paymentGatewayPlanId) : null;
            if (googlePlaySkuFromSkuName != null && GooglePlaySkuKt.isBundledSku(googlePlaySkuFromSkuName)) {
                return ActiveSubscriptionView$ActiveSubscriptionType.PREMIUM_AND_PREMIUM_GUILD;
            }
            if ((googlePlaySkuFromSkuName != null ? googlePlaySkuFromSkuName.getType() : null) == GooglePlaySku$Type.PREMIUM_GUILD) {
                return ActiveSubscriptionView$ActiveSubscriptionType.PREMIUM_GUILD;
            }
        }
        int iOrdinal = modelSubscription.getPlanType().ordinal();
        if (iOrdinal != 4 && iOrdinal != 5) {
            switch (iOrdinal) {
                case 8:
                case 9:
                case 10:
                case 11:
                    break;
                case 12:
                    return ActiveSubscriptionView$ActiveSubscriptionType.PREMIUM_BASIC;
                case 13:
                case 14:
                case 15:
                case 16:
                    return ActiveSubscriptionView$ActiveSubscriptionType.PREMIUM_GUILD;
                default:
                    return ActiveSubscriptionView$ActiveSubscriptionType.PREMIUM_CLASSIC;
            }
        }
        return ActiveSubscriptionView$ActiveSubscriptionType.PREMIUM;
    }

    /* JADX WARN: Code duplicated, block: B:15:0x005c  */
    /* JADX WARN: Code duplicated, block: B:8:0x003d  */
    public final void a(ActiveSubscriptionView$ActiveSubscriptionType activeSubscriptionType, ModelSubscription$Status status, boolean isTrialSubscription, CharSequence priceText, boolean isLoading, int guildBoostCount, Function0<Unit> topBtnCallback, Function0<Unit> manageGuildBoostBtnCallback, Function0<Unit> cancelBtnCallback, boolean isBasePlanMutatingToNonePlan) {
        int headerBackgroundError;
        int headerImageError;
        int i;
        CharSequence charSequenceJ;
        int i2;
        m.checkNotNullParameter(activeSubscriptionType, "activeSubscriptionType");
        m.checkNotNullParameter(status, "status");
        m.checkNotNullParameter(priceText, "priceText");
        ImageView imageView = this.binding.c;
        int iOrdinal = status.ordinal();
        if (iOrdinal == 2) {
            headerBackgroundError = activeSubscriptionType.getHeaderBackgroundError();
        } else if (iOrdinal == 3) {
            headerBackgroundError = activeSubscriptionType.getHeaderBackgroundResub();
        } else if (iOrdinal != 5) {
            headerBackgroundError = activeSubscriptionType.getHeaderBackground();
        } else {
            headerBackgroundError = activeSubscriptionType.getHeaderBackgroundError();
        }
        imageView.setImageResource(headerBackgroundError);
        ImageView imageView2 = this.binding.d;
        int iOrdinal2 = status.ordinal();
        if (iOrdinal2 == 2) {
            headerImageError = activeSubscriptionType.getHeaderImageError();
        } else if (iOrdinal2 == 3) {
            headerImageError = activeSubscriptionType.getHeaderImageResub();
        } else if (iOrdinal2 != 5) {
            headerImageError = activeSubscriptionType.getHeaderImage();
        } else {
            headerImageError = activeSubscriptionType.getHeaderImageError();
        }
        imageView2.setImageResource(headerImageError);
        this.binding.e.setImageResource(DrawableCompat.getThemedDrawableRes$default(this, activeSubscriptionType.getHeaderLogo(), 0, 2, (Object) null));
        ImageView imageView3 = this.binding.e;
        m.checkNotNullExpressionValue(imageView3, "binding.activeSubscriptionHeaderLogo");
        int iOrdinal3 = activeSubscriptionType.ordinal();
        if (iOrdinal3 == 0) {
            i = 2131894440;
        } else if (iOrdinal3 == 1) {
            i = 2131894441;
        } else if (iOrdinal3 == 2) {
            i = 2131894444;
        } else if (iOrdinal3 != 3) {
            if (iOrdinal3 != 4) {
                throw new NoWhenBranchMatchedException();
            }
            i = 2131894444;
        } else {
            i = 2131894154;
        }
        imageView3.setContentDescription(b.j(this, i, new Object[0], null, 4));
        TextView textView = this.binding.f;
        m.checkNotNullExpressionValue(textView, "binding.activeSubscriptionHeaderText");
        int iOrdinal4 = activeSubscriptionType.ordinal();
        if (iOrdinal4 == 0) {
            int iOrdinal5 = status.ordinal();
            if (iOrdinal5 != 3) {
                charSequenceJ = iOrdinal5 != 5 ? b.j(this, 2131894364, new Object[]{priceText}, null, 4) : b.j(this, 2131894365, new Object[]{priceText}, null, 4);
            } else {
                charSequenceJ = b.j(this, 2131894368, new Object[]{priceText}, null, 4);
            }
        } else if (iOrdinal4 == 1) {
            int iOrdinal6 = status.ordinal();
            if (iOrdinal6 != 3) {
                charSequenceJ = iOrdinal6 != 5 ? b.j(this, 2131894371, new Object[]{priceText}, null, 4) : b.j(this, 2131894372, new Object[]{priceText}, null, 4);
            } else {
                charSequenceJ = b.j(this, 2131894375, new Object[]{priceText}, null, 4);
            }
        } else if (iOrdinal4 == 2) {
            int iOrdinal7 = status.ordinal();
            if (iOrdinal7 != 3) {
                charSequenceJ = iOrdinal7 != 5 ? b.j(this, 2131894378, new Object[]{2, priceText}, null, 4) : b.j(this, 2131894379, new Object[]{2, priceText}, null, 4);
            } else {
                charSequenceJ = b.j(this, 2131894382, new Object[]{2, priceText}, null, 4);
            }
        } else if (iOrdinal4 == 3) {
            Context context = getContext();
            m.checkNotNullExpressionValue(context, "context");
            CharSequence i18nPluralString = StringResourceUtilsKt.getI18nPluralString(context, R$plurals.premium_guild_subscriptions_renewal_info_quantity, guildBoostCount, Integer.valueOf(guildBoostCount));
            int iOrdinal8 = status.ordinal();
            if (iOrdinal8 != 3) {
                charSequenceJ = iOrdinal8 != 5 ? b.j(this, 2131894194, new Object[]{String.valueOf(guildBoostCount), i18nPluralString, priceText}, null, 4) : b.j(this, 2131894192, new Object[]{Integer.valueOf(guildBoostCount), i18nPluralString, priceText}, null, 4);
            } else {
                charSequenceJ = b.j(this, 2131894197, new Object[]{Integer.valueOf(guildBoostCount), i18nPluralString, priceText}, null, 4);
            }
        } else {
            if (iOrdinal4 != 4) {
                throw new NoWhenBranchMatchedException();
            }
            int iOrdinal9 = status.ordinal();
            if (iOrdinal9 != 3) {
                charSequenceJ = iOrdinal9 != 5 ? b.j(this, 2131894378, new Object[]{Integer.valueOf(guildBoostCount), priceText}, null, 4) : b.j(this, 2131894379, new Object[]{Integer.valueOf(guildBoostCount), priceText}, null, 4);
            } else {
                charSequenceJ = b.j(this, 2131894382, new Object[]{Integer.valueOf(guildBoostCount), priceText}, null, 4);
            }
        }
        textView.setText(charSequenceJ);
        MaterialButton materialButton = this.binding.i;
        m.checkNotNullExpressionValue(materialButton, "binding.activeSubscriptionTopButton");
        materialButton.setVisibility(isLoading ^ true ? 0 : 8);
        TextView textView2 = this.binding.f234b;
        m.checkNotNullExpressionValue(textView2, "binding.activeSubscriptionCancelButton");
        textView2.setVisibility(cancelBtnCallback != null && !isLoading && status != ModelSubscription$Status.CANCELED && !isBasePlanMutatingToNonePlan ? 0 : 8);
        MaterialButton materialButton2 = this.binding.i;
        int iOrdinal10 = status.ordinal();
        if (iOrdinal10 != 3) {
            i2 = iOrdinal10 != 5 ? 2131894434 : 2131887100;
        } else {
            i2 = 2131894842;
        }
        materialButton2.setText(i2);
        this.binding.i.setOnClickListener(new ActiveSubscriptionView$a(0, topBtnCallback));
        MaterialButton materialButton3 = this.binding.i;
        m.checkNotNullExpressionValue(materialButton3, "binding.activeSubscriptionTopButton");
        materialButton3.setVisibility(topBtnCallback != null ? 0 : 8);
        MaterialButton materialButton4 = this.binding.i;
        m.checkNotNullExpressionValue(materialButton4, "binding.activeSubscriptionTopButton");
        materialButton4.setEnabled(!isTrialSubscription);
        MaterialButton materialButton5 = this.binding.g;
        m.checkNotNullExpressionValue(materialButton5, "binding.activeSubscriptionManageGuildBoostButton");
        materialButton5.setVisibility(manageGuildBoostBtnCallback != null ? 0 : 8);
        this.binding.g.setOnClickListener(new ActiveSubscriptionView$a(1, manageGuildBoostBtnCallback));
        this.binding.f234b.setOnClickListener(new ActiveSubscriptionView$a(2, cancelBtnCallback));
        ProgressBar progressBar = this.binding.h;
        m.checkNotNullExpressionValue(progressBar, "binding.activeSubscriptionProgress");
        progressBar.setVisibility(isLoading ? 0 : 8);
    }
}
