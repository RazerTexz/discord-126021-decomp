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
import androidx.annotation.DrawableRes;
import b.a.i.ViewActiveSubscriptionBinding;
import b.a.k.FormatUtils;
import com.discord.R;
import com.discord.models.domain.ModelSubscription;
import com.discord.utilities.analytics.Traits;
import com.discord.utilities.billing.GooglePlaySku;
import com.discord.utilities.billing.GooglePlaySku2;
import com.discord.utilities.drawable.DrawableCompat;
import com.discord.utilities.resources.StringResourceUtils;
import com.google.android.material.button.MaterialButton;
import d0.z.d.Intrinsics3;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: ActiveSubscriptionView.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ActiveSubscriptionView extends FrameLayout {
    public static final /* synthetic */ int j = 0;

    /* JADX INFO: renamed from: k, reason: from kotlin metadata */
    public final ViewActiveSubscriptionBinding binding;

    /* JADX INFO: compiled from: ActiveSubscriptionView.kt */
    public enum ActiveSubscriptionType {
        PREMIUM_BASIC(R.attr.img_premium_basic_subscription_header_logo, R.drawable.img_premium_basic_subscription_header, R.drawable.img_premium_subscription_header_resub, R.drawable.img_premium_subscription_header_error, R.drawable.bg_premium_basic_subscription_header, R.drawable.bg_premium_subscription_header_resub, R.drawable.bg_premium_subscription_header_error),
        PREMIUM_CLASSIC(R.attr.img_premium_classic_subscription_header_logo, R.drawable.img_premium_classic_subscription_header, R.drawable.img_premium_classic_subscription_header_resub, R.drawable.img_premium_classic_subscription_header_error, R.drawable.bg_premium_classic_subscription_header, R.drawable.bg_premium_subscription_header_resub, R.drawable.bg_premium_subscription_header_error),
        PREMIUM(R.attr.img_premium_subscription_header_logo, R.drawable.img_premium_subscription_header, R.drawable.img_premium_subscription_header_resub, R.drawable.img_premium_subscription_header_error, R.drawable.bg_premium_subscription_header, R.drawable.bg_premium_subscription_header_resub, R.drawable.bg_premium_subscription_header_error),
        PREMIUM_GUILD(R.attr.img_premium_guild_subscription_header_logo, R.drawable.img_premium_guild_subscription_header, R.drawable.img_premium_guild_subscription_header_resub, R.drawable.img_premium_guild_subscription_header_error, R.drawable.bg_premium_guild_subscription_header, R.drawable.bg_premium_guild_subscription_header_resub, R.drawable.bg_premium_guild_subscription_header_error),
        PREMIUM_AND_PREMIUM_GUILD(R.attr.img_logo_discord_nitro_and_boost_horizontal, R.drawable.img_premium_and_premium_guild_subscription_header, R.drawable.img_premium_and_premium_guild_subscription_header, R.drawable.img_premium_and_premium_guild_subscription_header, R.drawable.bg_premium_bundle_header, R.drawable.bg_premium_subscription_header_resub, R.drawable.bg_premium_subscription_header_error);

        private final int headerBackground;
        private final int headerBackgroundError;
        private final int headerBackgroundResub;
        private final int headerImage;
        private final int headerImageError;
        private final int headerImageResub;
        private final int headerLogo;

        ActiveSubscriptionType(@DrawableRes int i, @DrawableRes int i2, @DrawableRes int i3, @DrawableRes int i4, @DrawableRes int i5, int i6, int i7) {
            this.headerLogo = i;
            this.headerImage = i2;
            this.headerImageResub = i3;
            this.headerImageError = i4;
            this.headerBackground = i5;
            this.headerBackgroundResub = i6;
            this.headerBackgroundError = i7;
        }

        public final int getHeaderBackground() {
            return this.headerBackground;
        }

        public final int getHeaderBackgroundError() {
            return this.headerBackgroundError;
        }

        public final int getHeaderBackgroundResub() {
            return this.headerBackgroundResub;
        }

        public final int getHeaderImage() {
            return this.headerImage;
        }

        public final int getHeaderImageError() {
            return this.headerImageError;
        }

        public final int getHeaderImageResub() {
            return this.headerImageResub;
        }

        public final int getHeaderLogo() {
            return this.headerLogo;
        }
    }

    /* JADX INFO: compiled from: java-style lambda group */
    public static final class a implements View.OnClickListener {
        public final /* synthetic */ int j;
        public final /* synthetic */ Object k;

        public a(int i, Object obj) {
            this.j = i;
            this.k = obj;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            int i = this.j;
            if (i == 0) {
                Function0 function0 = (Function0) this.k;
                if (function0 != null) {
                    return;
                }
                return;
            }
            if (i == 1) {
                Function0 function1 = (Function0) this.k;
                if (function1 != null) {
                    return;
                }
                return;
            }
            if (i != 2) {
                throw null;
            }
            Function0 function2 = (Function0) this.k;
            if (function2 != null) {
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ActiveSubscriptionView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        Intrinsics3.checkNotNullParameter(context, "context");
        View viewInflate = LayoutInflater.from(context).inflate(R.layout.view_active_subscription, (ViewGroup) this, false);
        addView(viewInflate);
        int i = R.id.active_subscription_cancel_button;
        TextView textView = (TextView) viewInflate.findViewById(R.id.active_subscription_cancel_button);
        if (textView != null) {
            i = R.id.active_subscription_header_background;
            ImageView imageView = (ImageView) viewInflate.findViewById(R.id.active_subscription_header_background);
            if (imageView != null) {
                i = R.id.active_subscription_header_icon;
                ImageView imageView2 = (ImageView) viewInflate.findViewById(R.id.active_subscription_header_icon);
                if (imageView2 != null) {
                    i = R.id.active_subscription_header_logo;
                    ImageView imageView3 = (ImageView) viewInflate.findViewById(R.id.active_subscription_header_logo);
                    if (imageView3 != null) {
                        i = R.id.active_subscription_header_text;
                        TextView textView2 = (TextView) viewInflate.findViewById(R.id.active_subscription_header_text);
                        if (textView2 != null) {
                            i = R.id.active_subscription_manage_guild_boost_button;
                            MaterialButton materialButton = (MaterialButton) viewInflate.findViewById(R.id.active_subscription_manage_guild_boost_button);
                            if (materialButton != null) {
                                i = R.id.active_subscription_progress;
                                ProgressBar progressBar = (ProgressBar) viewInflate.findViewById(R.id.active_subscription_progress);
                                if (progressBar != null) {
                                    i = R.id.active_subscription_top_button;
                                    MaterialButton materialButton2 = (MaterialButton) viewInflate.findViewById(R.id.active_subscription_top_button);
                                    if (materialButton2 != null) {
                                        ViewActiveSubscriptionBinding viewActiveSubscriptionBinding = new ViewActiveSubscriptionBinding((FrameLayout) viewInflate, textView, imageView, imageView2, imageView3, textView2, materialButton, progressBar, materialButton2);
                                        Intrinsics3.checkNotNullExpressionValue(viewActiveSubscriptionBinding, "ViewActiveSubscriptionBi…rom(context), this, true)");
                                        this.binding = viewActiveSubscriptionBinding;
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

    public static final ActiveSubscriptionType b(ModelSubscription modelSubscription) {
        Intrinsics3.checkNotNullParameter(modelSubscription, Traits.Payment.Type.SUBSCRIPTION);
        if (modelSubscription.isGoogleSubscription()) {
            String paymentGatewayPlanId = modelSubscription.getPaymentGatewayPlanId();
            GooglePlaySku googlePlaySkuFromSkuName = paymentGatewayPlanId != null ? GooglePlaySku.INSTANCE.fromSkuName(paymentGatewayPlanId) : null;
            if (googlePlaySkuFromSkuName != null && GooglePlaySku2.isBundledSku(googlePlaySkuFromSkuName)) {
                return ActiveSubscriptionType.PREMIUM_AND_PREMIUM_GUILD;
            }
            if ((googlePlaySkuFromSkuName != null ? googlePlaySkuFromSkuName.getType() : null) == GooglePlaySku.Type.PREMIUM_GUILD) {
                return ActiveSubscriptionType.PREMIUM_GUILD;
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
                    return ActiveSubscriptionType.PREMIUM_BASIC;
                case 13:
                case 14:
                case 15:
                case 16:
                    return ActiveSubscriptionType.PREMIUM_GUILD;
                default:
                    return ActiveSubscriptionType.PREMIUM_CLASSIC;
            }
        }
        return ActiveSubscriptionType.PREMIUM;
    }

    /* JADX WARN: Code duplicated, block: B:15:0x005c  */
    /* JADX WARN: Code duplicated, block: B:8:0x003d  */
    public final void a(ActiveSubscriptionType activeSubscriptionType, ModelSubscription.Status status, boolean isTrialSubscription, CharSequence priceText, boolean isLoading, int guildBoostCount, Function0<Unit> topBtnCallback, Function0<Unit> manageGuildBoostBtnCallback, Function0<Unit> cancelBtnCallback, boolean isBasePlanMutatingToNonePlan) {
        int headerBackgroundError;
        int headerImageError;
        int i;
        CharSequence charSequenceD;
        int i2;
        Intrinsics3.checkNotNullParameter(activeSubscriptionType, "activeSubscriptionType");
        Intrinsics3.checkNotNullParameter(status, "status");
        Intrinsics3.checkNotNullParameter(priceText, "priceText");
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
        Intrinsics3.checkNotNullExpressionValue(imageView3, "binding.activeSubscriptionHeaderLogo");
        int iOrdinal3 = activeSubscriptionType.ordinal();
        if (iOrdinal3 == 0) {
            i = R.string.premium_tier_0;
        } else if (iOrdinal3 == 1) {
            i = R.string.premium_tier_1;
        } else if (iOrdinal3 == 2) {
            i = R.string.premium_tier_2;
        } else if (iOrdinal3 != 3) {
            if (iOrdinal3 != 4) {
                throw new NoWhenBranchMatchedException();
            }
            i = R.string.premium_tier_2;
        } else {
            i = R.string.premium_guild_subscription_title;
        }
        imageView3.setContentDescription(FormatUtils.d(this, i, new Object[0], (4 & 4) != 0 ? FormatUtils.c.j : null));
        TextView textView = this.binding.f;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.activeSubscriptionHeaderText");
        int iOrdinal4 = activeSubscriptionType.ordinal();
        if (iOrdinal4 == 0) {
            int iOrdinal5 = status.ordinal();
            if (iOrdinal5 != 3) {
                charSequenceD = iOrdinal5 != 5 ? FormatUtils.d(this, R.string.premium_subscription_description_tier_0, new Object[]{priceText}, (4 & 4) != 0 ? FormatUtils.c.j : null) : FormatUtils.d(this, R.string.premium_subscription_description_tier_0_account_hold, new Object[]{priceText}, (4 & 4) != 0 ? FormatUtils.c.j : null);
            } else {
                charSequenceD = FormatUtils.d(this, R.string.premium_subscription_description_tier_0_pending_cancelation, new Object[]{priceText}, (4 & 4) != 0 ? FormatUtils.c.j : null);
            }
        } else if (iOrdinal4 == 1) {
            int iOrdinal6 = status.ordinal();
            if (iOrdinal6 != 3) {
                charSequenceD = iOrdinal6 != 5 ? FormatUtils.d(this, R.string.premium_subscription_description_tier_1, new Object[]{priceText}, (4 & 4) != 0 ? FormatUtils.c.j : null) : FormatUtils.d(this, R.string.premium_subscription_description_tier_1_account_hold, new Object[]{priceText}, (4 & 4) != 0 ? FormatUtils.c.j : null);
            } else {
                charSequenceD = FormatUtils.d(this, R.string.premium_subscription_description_tier_1_pending_cancelation, new Object[]{priceText}, (4 & 4) != 0 ? FormatUtils.c.j : null);
            }
        } else if (iOrdinal4 == 2) {
            int iOrdinal7 = status.ordinal();
            if (iOrdinal7 != 3) {
                charSequenceD = iOrdinal7 != 5 ? FormatUtils.d(this, R.string.premium_subscription_description_tier_2, new Object[]{2, priceText}, (4 & 4) != 0 ? FormatUtils.c.j : null) : FormatUtils.d(this, R.string.premium_subscription_description_tier_2_account_hold, new Object[]{2, priceText}, (4 & 4) != 0 ? FormatUtils.c.j : null);
            } else {
                charSequenceD = FormatUtils.d(this, R.string.premium_subscription_description_tier_2_pending_cancelation, new Object[]{2, priceText}, (4 & 4) != 0 ? FormatUtils.c.j : null);
            }
        } else if (iOrdinal4 == 3) {
            Context context = getContext();
            Intrinsics3.checkNotNullExpressionValue(context, "context");
            CharSequence i18nPluralString = StringResourceUtils.getI18nPluralString(context, R.plurals.premium_guild_subscriptions_renewal_info_quantity, guildBoostCount, Integer.valueOf(guildBoostCount));
            int iOrdinal8 = status.ordinal();
            if (iOrdinal8 != 3) {
                charSequenceD = iOrdinal8 != 5 ? FormatUtils.d(this, R.string.premium_guild_subscriptions_renewal_info_android, new Object[]{String.valueOf(guildBoostCount), i18nPluralString, priceText}, (4 & 4) != 0 ? FormatUtils.c.j : null) : FormatUtils.d(this, R.string.premium_guild_subscriptions_renewal_info_account_hold, new Object[]{Integer.valueOf(guildBoostCount), i18nPluralString, priceText}, (4 & 4) != 0 ? FormatUtils.c.j : null);
            } else {
                charSequenceD = FormatUtils.d(this, R.string.premium_guild_subscriptions_renewal_info_pending_cancelation_android, new Object[]{Integer.valueOf(guildBoostCount), i18nPluralString, priceText}, (4 & 4) != 0 ? FormatUtils.c.j : null);
            }
        } else {
            if (iOrdinal4 != 4) {
                throw new NoWhenBranchMatchedException();
            }
            int iOrdinal9 = status.ordinal();
            if (iOrdinal9 != 3) {
                charSequenceD = iOrdinal9 != 5 ? FormatUtils.d(this, R.string.premium_subscription_description_tier_2, new Object[]{Integer.valueOf(guildBoostCount), priceText}, (4 & 4) != 0 ? FormatUtils.c.j : null) : FormatUtils.d(this, R.string.premium_subscription_description_tier_2_account_hold, new Object[]{Integer.valueOf(guildBoostCount), priceText}, (4 & 4) != 0 ? FormatUtils.c.j : null);
            } else {
                charSequenceD = FormatUtils.d(this, R.string.premium_subscription_description_tier_2_pending_cancelation, new Object[]{Integer.valueOf(guildBoostCount), priceText}, (4 & 4) != 0 ? FormatUtils.c.j : null);
            }
        }
        textView.setText(charSequenceD);
        MaterialButton materialButton = this.binding.i;
        Intrinsics3.checkNotNullExpressionValue(materialButton, "binding.activeSubscriptionTopButton");
        materialButton.setVisibility(isLoading ^ true ? 0 : 8);
        TextView textView2 = this.binding.f234b;
        Intrinsics3.checkNotNullExpressionValue(textView2, "binding.activeSubscriptionCancelButton");
        textView2.setVisibility(cancelBtnCallback != null && !isLoading && status != ModelSubscription.Status.CANCELED && !isBasePlanMutatingToNonePlan ? 0 : 8);
        MaterialButton materialButton2 = this.binding.i;
        int iOrdinal10 = status.ordinal();
        if (iOrdinal10 != 3) {
            i2 = iOrdinal10 != 5 ? R.string.premium_switch_plans : R.string.billing_manage_billing;
        } else {
            i2 = R.string.resubscribe;
        }
        materialButton2.setText(i2);
        this.binding.i.setOnClickListener(new a(0, topBtnCallback));
        MaterialButton materialButton3 = this.binding.i;
        Intrinsics3.checkNotNullExpressionValue(materialButton3, "binding.activeSubscriptionTopButton");
        materialButton3.setVisibility(topBtnCallback != null ? 0 : 8);
        MaterialButton materialButton4 = this.binding.i;
        Intrinsics3.checkNotNullExpressionValue(materialButton4, "binding.activeSubscriptionTopButton");
        materialButton4.setEnabled(!isTrialSubscription);
        MaterialButton materialButton5 = this.binding.g;
        Intrinsics3.checkNotNullExpressionValue(materialButton5, "binding.activeSubscriptionManageGuildBoostButton");
        materialButton5.setVisibility(manageGuildBoostBtnCallback != null ? 0 : 8);
        this.binding.g.setOnClickListener(new a(1, manageGuildBoostBtnCallback));
        this.binding.f234b.setOnClickListener(new a(2, cancelBtnCallback));
        ProgressBar progressBar = this.binding.h;
        Intrinsics3.checkNotNullExpressionValue(progressBar, "binding.activeSubscriptionProgress");
        progressBar.setVisibility(isLoading ? 0 : 8);
    }
}
