package com.discord.views.guildboost;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import b.a.i.x2;
import com.discord.R$id;
import com.discord.R$layout;
import com.discord.utilities.drawable.DrawableCompat;
import com.discord.utilities.premium.GuildBoostUtils;
import d0.z.d.m;

/* JADX INFO: compiled from: GuildBoostProgressView.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class GuildBoostProgressView extends FrameLayout {

    /* JADX INFO: renamed from: j, reason: from kotlin metadata */
    public final x2 binding;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildBoostProgressView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m.checkNotNullParameter(context, "context");
        View viewInflate = LayoutInflater.from(getContext()).inflate(R$layout.view_premium_guild_progress, (ViewGroup) this, false);
        addView(viewInflate);
        int i = R$id.progress_gem_icon;
        ImageView imageView = (ImageView) viewInflate.findViewById(R$id.progress_gem_icon);
        if (imageView != null) {
            i = R$id.progress_level_text;
            TextView textView = (TextView) viewInflate.findViewById(R$id.progress_level_text);
            if (textView != null) {
                i = R$id.progress_progress;
                ProgressBar progressBar = (ProgressBar) viewInflate.findViewById(R$id.progress_progress);
                if (progressBar != null) {
                    x2 x2Var = new x2((FrameLayout) viewInflate, imageView, textView, progressBar);
                    m.checkNotNullExpressionValue(x2Var, "ViewPremiumGuildProgress…rom(context), this, true)");
                    this.binding = x2Var;
                    return;
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i)));
    }

    public final void a(long guildId, int premiumTier, int premiumSubscriptionCount) {
        String string;
        ImageView imageView = this.binding.f228b;
        int themedDrawableRes$default = 0;
        if (premiumTier == 0) {
            Context context = getContext();
            m.checkNotNullExpressionValue(context, "context");
            themedDrawableRes$default = DrawableCompat.getThemedDrawableRes$default(context, 2130968724, 0, 2, (Object) null);
        } else if (premiumTier == 1) {
            themedDrawableRes$default = 2131231584;
        } else if (premiumTier == 2) {
            themedDrawableRes$default = 2131231585;
        } else if (premiumTier == 3) {
            themedDrawableRes$default = 2131231586;
        }
        imageView.setImageResource(themedDrawableRes$default);
        TextView textView = this.binding.c;
        m.checkNotNullExpressionValue(textView, "binding.progressLevelText");
        if (premiumTier == 0) {
            string = getContext().getString(2131894022);
        } else if (premiumTier == 1) {
            string = getContext().getString(2131894200);
        } else if (premiumTier != 2) {
            string = premiumTier != 3 ? "" : getContext().getString(2131894204);
        } else {
            string = getContext().getString(2131894202);
        }
        textView.setText(string);
        ProgressBar progressBar = this.binding.d;
        m.checkNotNullExpressionValue(progressBar, "binding.progressProgress");
        progressBar.setProgress(GuildBoostUtils.calculatePercentToNextTier$default(GuildBoostUtils.INSTANCE, guildId, premiumTier, premiumSubscriptionCount, null, null, 24, null));
    }
}
