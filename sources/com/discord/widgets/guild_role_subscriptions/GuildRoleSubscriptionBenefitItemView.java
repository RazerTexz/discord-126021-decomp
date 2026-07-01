package com.discord.widgets.guild_role_subscriptions;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup$LayoutParams;
import android.widget.TextView;
import androidx.annotation.DrawableRes;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import com.discord.R$a;
import com.discord.databinding.ViewGuildRoleSubscriptionBenefitItemBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.domain.emoji.Emoji;
import com.discord.utilities.icon.IconUtils;
import com.discord.utilities.images.MGImages;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.widgets.guild_role_subscriptions.tier.model.Benefit;
import com.discord.widgets.guild_role_subscriptions.tier.model.Benefit$ChannelBenefit;
import com.facebook.drawee.drawable.ScalingUtils$ScaleType;
import com.facebook.drawee.view.SimpleDraweeView;
import d0.d0.f;
import d0.g0.t;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: GuildRoleSubscriptionBenefitItemView.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class GuildRoleSubscriptionBenefitItemView extends ConstraintLayout {
    public static final GuildRoleSubscriptionBenefitItemView$Companion Companion = new GuildRoleSubscriptionBenefitItemView$Companion(null);
    private static final int MAX_EMOJI_SIZE = 64;
    private final ViewGuildRoleSubscriptionBenefitItemBinding binding;
    private final int emojiSizePx;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildRoleSubscriptionBenefitItemView(Context context) {
        super(context);
        m.checkNotNullParameter(context, "context");
        ViewGuildRoleSubscriptionBenefitItemBinding viewGuildRoleSubscriptionBenefitItemBindingA = ViewGuildRoleSubscriptionBenefitItemBinding.a(LayoutInflater.from(getContext()), this);
        m.checkNotNullExpressionValue(viewGuildRoleSubscriptionBenefitItemBindingA, "ViewGuildRoleSubscriptio…ater.from(context), this)");
        this.binding = viewGuildRoleSubscriptionBenefitItemBindingA;
        this.emojiSizePx = getResources().getDimensionPixelSize(2131165453);
        initialize$default(this, null, 1, null);
    }

    private final void configureEmoji(Emoji emoji) {
        String imageUri = emoji.getImageUri(false, f.coerceAtMost(IconUtils.getMediaProxySize(this.emojiSizePx), 64), getContext());
        SimpleDraweeView simpleDraweeView = this.binding.c;
        m.checkNotNullExpressionValue(simpleDraweeView, "binding.guildRoleSubscriptionBenefitImage");
        MGImages.setImage$default(simpleDraweeView, imageUri, 0, 0, true, null, null, 108, null);
        SimpleDraweeView simpleDraweeView2 = this.binding.c;
        m.checkNotNullExpressionValue(simpleDraweeView2, "binding.guildRoleSubscriptionBenefitImage");
        simpleDraweeView2.setContentDescription(emoji.getFirstName());
    }

    private final void configureTitleAndDescription(String title, String description) {
        TextView textView = this.binding.d;
        m.checkNotNullExpressionValue(textView, "binding.guildRoleSubscriptionBenefitName");
        textView.setText(title);
        TextView textView2 = this.binding.f2192b;
        m.checkNotNullExpressionValue(textView2, "binding.guildRoleSubscriptionBenefitDescription");
        ViewExtensions.setTextAndVisibilityBy(textView2, description);
    }

    private final void initialize(AttributeSet attrs) {
        int dimensionPixelSize = getResources().getDimensionPixelSize(2131165456);
        setPadding(dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize);
        setBackground(ContextCompat.getDrawable(getContext(), 2131232516));
        setLayoutParams(new ViewGroup$LayoutParams(-1, -2));
        Context context = getContext();
        m.checkNotNullExpressionValue(context, "context");
        int[] iArr = R$a.GuildRoleSubscriptionBenefitItemView;
        m.checkNotNullExpressionValue(iArr, "R.styleable.GuildRoleSubscriptionBenefitItemView");
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attrs, iArr);
        m.checkNotNullExpressionValue(typedArrayObtainStyledAttributes, "obtainStyledAttributes(attrs, styleable)");
        String string = typedArrayObtainStyledAttributes.getString(2);
        String string2 = typedArrayObtainStyledAttributes.getString(0);
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(1, -1);
        if (!(string == null || t.isBlank(string)) && resourceId != -1) {
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
        m.checkNotNullParameter(title, "title");
        m.checkNotNullParameter(emoji, "emoji");
        configureTitleAndDescription(title, description);
        configureEmoji(emoji);
    }

    public final void configureUI(Benefit benefit) {
        Integer channelIconResId;
        m.checkNotNullParameter(benefit, "benefit");
        configureUI(benefit.getName(), benefit.getEmoji(), benefit.getDescription());
        TextView textView = this.binding.d;
        m.checkNotNullExpressionValue(textView, "binding.guildRoleSubscriptionBenefitName");
        if (!(benefit instanceof Benefit$ChannelBenefit)) {
            benefit = null;
        }
        Benefit$ChannelBenefit benefit$ChannelBenefit = (Benefit$ChannelBenefit) benefit;
        ViewExtensions.setCompoundDrawableWithIntrinsicBounds$default(textView, (benefit$ChannelBenefit == null || (channelIconResId = benefit$ChannelBenefit.getChannelIconResId()) == null) ? 0 : channelIconResId.intValue(), 0, 0, 0, 14, null);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildRoleSubscriptionBenefitItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m.checkNotNullParameter(context, "context");
        ViewGuildRoleSubscriptionBenefitItemBinding viewGuildRoleSubscriptionBenefitItemBindingA = ViewGuildRoleSubscriptionBenefitItemBinding.a(LayoutInflater.from(getContext()), this);
        m.checkNotNullExpressionValue(viewGuildRoleSubscriptionBenefitItemBindingA, "ViewGuildRoleSubscriptio…ater.from(context), this)");
        this.binding = viewGuildRoleSubscriptionBenefitItemBindingA;
        this.emojiSizePx = getResources().getDimensionPixelSize(2131165453);
        initialize(attributeSet);
    }

    public final void configureUI(String title, @DrawableRes int imageRes, String description) {
        m.checkNotNullParameter(title, "title");
        configureTitleAndDescription(title, description);
        MGImages mGImages = MGImages.INSTANCE;
        SimpleDraweeView simpleDraweeView = this.binding.c;
        m.checkNotNullExpressionValue(simpleDraweeView, "binding.guildRoleSubscriptionBenefitImage");
        ScalingUtils$ScaleType scalingUtils$ScaleType = ScalingUtils$ScaleType.a;
        ScalingUtils$ScaleType scalingUtils$ScaleType2 = b.f.g.e.t.l;
        m.checkNotNullExpressionValue(scalingUtils$ScaleType2, "ScalingUtils.ScaleType.CENTER_INSIDE");
        MGImages.setImage$default(mGImages, simpleDraweeView, imageRes, scalingUtils$ScaleType2, null, 8, null);
    }

    public /* synthetic */ GuildRoleSubscriptionBenefitItemView(Context context, AttributeSet attributeSet, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i & 2) != 0 ? null : attributeSet);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildRoleSubscriptionBenefitItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m.checkNotNullParameter(context, "context");
        ViewGuildRoleSubscriptionBenefitItemBinding viewGuildRoleSubscriptionBenefitItemBindingA = ViewGuildRoleSubscriptionBenefitItemBinding.a(LayoutInflater.from(getContext()), this);
        m.checkNotNullExpressionValue(viewGuildRoleSubscriptionBenefitItemBindingA, "ViewGuildRoleSubscriptio…ater.from(context), this)");
        this.binding = viewGuildRoleSubscriptionBenefitItemBindingA;
        this.emojiSizePx = getResources().getDimensionPixelSize(2131165453);
        initialize(attributeSet);
    }

    public /* synthetic */ GuildRoleSubscriptionBenefitItemView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }
}
