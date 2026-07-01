package com.discord.widgets.guild_role_subscriptions;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.DrawableRes;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import b.f.g.e.t;
import com.discord.R;
import com.discord.databinding.ViewGuildRoleSubscriptionBenefitItemBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.domain.emoji.Emoji;
import com.discord.utilities.icon.IconUtils;
import com.discord.utilities.images.MGImages;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.widgets.guild_role_subscriptions.tier.model.Benefit;
import com.facebook.drawee.drawable.ScalingUtils$ScaleType;
import com.facebook.drawee.view.SimpleDraweeView;
import d0.d0._Ranges;
import d0.g0.StringsJVM;
import d0.z.d.Intrinsics3;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: GuildRoleSubscriptionBenefitItemView.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class GuildRoleSubscriptionBenefitItemView extends ConstraintLayout {
    private static final int MAX_EMOJI_SIZE = 64;
    private final ViewGuildRoleSubscriptionBenefitItemBinding binding;
    private final int emojiSizePx;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildRoleSubscriptionBenefitItemView(Context context) {
        super(context);
        Intrinsics3.checkNotNullParameter(context, "context");
        ViewGuildRoleSubscriptionBenefitItemBinding viewGuildRoleSubscriptionBenefitItemBindingA = ViewGuildRoleSubscriptionBenefitItemBinding.a(LayoutInflater.from(getContext()), this);
        Intrinsics3.checkNotNullExpressionValue(viewGuildRoleSubscriptionBenefitItemBindingA, "ViewGuildRoleSubscriptio…ater.from(context), this)");
        this.binding = viewGuildRoleSubscriptionBenefitItemBindingA;
        this.emojiSizePx = getResources().getDimensionPixelSize(R.dimen.guild_role_subscription_benefit_emoji_size);
        initialize$default(this, null, 1, null);
    }

    private final void configureEmoji(Emoji emoji) {
        String imageUri = emoji.getImageUri(false, _Ranges.coerceAtMost(IconUtils.getMediaProxySize(this.emojiSizePx), 64), getContext());
        SimpleDraweeView simpleDraweeView = this.binding.c;
        Intrinsics3.checkNotNullExpressionValue(simpleDraweeView, "binding.guildRoleSubscriptionBenefitImage");
        MGImages.setImage$default(simpleDraweeView, imageUri, 0, 0, true, null, null, 108, null);
        SimpleDraweeView simpleDraweeView2 = this.binding.c;
        Intrinsics3.checkNotNullExpressionValue(simpleDraweeView2, "binding.guildRoleSubscriptionBenefitImage");
        simpleDraweeView2.setContentDescription(emoji.getFirstName());
    }

    private final void configureTitleAndDescription(String title, String description) {
        TextView textView = this.binding.d;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.guildRoleSubscriptionBenefitName");
        textView.setText(title);
        TextView textView2 = this.binding.f2192b;
        Intrinsics3.checkNotNullExpressionValue(textView2, "binding.guildRoleSubscriptionBenefitDescription");
        ViewExtensions.setTextAndVisibilityBy(textView2, description);
    }

    private final void initialize(AttributeSet attrs) {
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.guild_role_subscription_setup_default_padding);
        setPadding(dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize);
        setBackground(ContextCompat.getDrawable(getContext(), R.drawable.ripple_rounded_bg_secondary));
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        Context context = getContext();
        Intrinsics3.checkNotNullExpressionValue(context, "context");
        int[] iArr = R.a.GuildRoleSubscriptionBenefitItemView;
        Intrinsics3.checkNotNullExpressionValue(iArr, "R.styleable.GuildRoleSubscriptionBenefitItemView");
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attrs, iArr);
        Intrinsics3.checkNotNullExpressionValue(typedArrayObtainStyledAttributes, "obtainStyledAttributes(attrs, styleable)");
        String string = typedArrayObtainStyledAttributes.getString(2);
        String string2 = typedArrayObtainStyledAttributes.getString(0);
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(1, -1);
        if (!(string == null || StringsJVM.isBlank(string)) && resourceId != -1) {
            configureUI(string, resourceId, string2);
        }
        typedArrayObtainStyledAttributes.recycle();
    }

    public static /* synthetic */ void initialize$default(GuildRoleSubscriptionBenefitItemView guildRoleSubscriptionBenefitItemView, AttributeSet attributeSet, int i, Object obj) {
        if ((i & 1) != 0) {
            attributeSet = null;
        }
        guildRoleSubscriptionBenefitItemView.initialize(attributeSet);
    }

    public final void configureUI(String title, Emoji emoji, String description) {
        Intrinsics3.checkNotNullParameter(title, "title");
        Intrinsics3.checkNotNullParameter(emoji, "emoji");
        configureTitleAndDescription(title, description);
        configureEmoji(emoji);
    }

    public final void configureUI(Benefit benefit) {
        Integer channelIconResId;
        Intrinsics3.checkNotNullParameter(benefit, "benefit");
        configureUI(benefit.getName(), benefit.getEmoji(), benefit.getDescription());
        TextView textView = this.binding.d;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.guildRoleSubscriptionBenefitName");
        if (!(benefit instanceof Benefit.ChannelBenefit)) {
            benefit = null;
        }
        Benefit.ChannelBenefit channelBenefit = (Benefit.ChannelBenefit) benefit;
        ViewExtensions.setCompoundDrawableWithIntrinsicBounds$default(textView, (channelBenefit == null || (channelIconResId = channelBenefit.getChannelIconResId()) == null) ? 0 : channelIconResId.intValue(), 0, 0, 0, 14, null);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildRoleSubscriptionBenefitItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics3.checkNotNullParameter(context, "context");
        ViewGuildRoleSubscriptionBenefitItemBinding viewGuildRoleSubscriptionBenefitItemBindingA = ViewGuildRoleSubscriptionBenefitItemBinding.a(LayoutInflater.from(getContext()), this);
        Intrinsics3.checkNotNullExpressionValue(viewGuildRoleSubscriptionBenefitItemBindingA, "ViewGuildRoleSubscriptio…ater.from(context), this)");
        this.binding = viewGuildRoleSubscriptionBenefitItemBindingA;
        this.emojiSizePx = getResources().getDimensionPixelSize(R.dimen.guild_role_subscription_benefit_emoji_size);
        initialize(attributeSet);
    }

    public final void configureUI(String title, @DrawableRes int imageRes, String description) {
        Intrinsics3.checkNotNullParameter(title, "title");
        configureTitleAndDescription(title, description);
        MGImages mGImages = MGImages.INSTANCE;
        SimpleDraweeView simpleDraweeView = this.binding.c;
        Intrinsics3.checkNotNullExpressionValue(simpleDraweeView, "binding.guildRoleSubscriptionBenefitImage");
        ScalingUtils$ScaleType scalingUtils$ScaleType = ScalingUtils$ScaleType.a;
        ScalingUtils$ScaleType scalingUtils$ScaleType2 = t.l;
        Intrinsics3.checkNotNullExpressionValue(scalingUtils$ScaleType2, "ScalingUtils.ScaleType.CENTER_INSIDE");
        MGImages.setImage$default(mGImages, simpleDraweeView, imageRes, scalingUtils$ScaleType2, null, 8, null);
    }

    public /* synthetic */ GuildRoleSubscriptionBenefitItemView(Context context, AttributeSet attributeSet, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i & 2) != 0 ? null : attributeSet);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildRoleSubscriptionBenefitItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics3.checkNotNullParameter(context, "context");
        ViewGuildRoleSubscriptionBenefitItemBinding viewGuildRoleSubscriptionBenefitItemBindingA = ViewGuildRoleSubscriptionBenefitItemBinding.a(LayoutInflater.from(getContext()), this);
        Intrinsics3.checkNotNullExpressionValue(viewGuildRoleSubscriptionBenefitItemBindingA, "ViewGuildRoleSubscriptio…ater.from(context), this)");
        this.binding = viewGuildRoleSubscriptionBenefitItemBindingA;
        this.emojiSizePx = getResources().getDimensionPixelSize(R.dimen.guild_role_subscription_benefit_emoji_size);
        initialize(attributeSet);
    }

    public /* synthetic */ GuildRoleSubscriptionBenefitItemView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }
}
