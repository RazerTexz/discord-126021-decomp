package com.discord.views.guildboost;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import b.a.i.l2;
import com.discord.R$id;
import com.discord.R$layout;
import com.discord.models.guild.Guild;
import com.discord.utilities.color.ColorCompatKt;
import com.discord.utilities.drawable.DrawableCompat;
import com.discord.utilities.icon.IconUtils;
import com.discord.utilities.images.MGImages$ChangeDetector;
import com.discord.utilities.premium.GuildBoostUtils;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.android.material.chip.Chip;
import d0.z.d.m;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: GuildBoostConfirmationView.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class GuildBoostConfirmationView extends CardView {

    /* JADX INFO: renamed from: j, reason: from kotlin metadata */
    public final l2 binding;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildBoostConfirmationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m.checkNotNullParameter(context, "context");
        LayoutInflater.from(getContext()).inflate(R$layout.view_guild_boost_confirmation, this);
        int i = R$id.guild_boost_confirmation_avatar;
        SimpleDraweeView simpleDraweeView = (SimpleDraweeView) findViewById(R$id.guild_boost_confirmation_avatar);
        if (simpleDraweeView != null) {
            i = R$id.guild_boost_confirmation_guild_name;
            TextView textView = (TextView) findViewById(R$id.guild_boost_confirmation_guild_name);
            if (textView != null) {
                i = R$id.guild_boost_confirmation_level_info_previous;
                Chip chip = (Chip) findViewById(R$id.guild_boost_confirmation_level_info_previous);
                if (chip != null) {
                    i = R$id.guild_boost_confirmation_level_info_upgrade;
                    Chip chip2 = (Chip) findViewById(R$id.guild_boost_confirmation_level_info_upgrade);
                    if (chip2 != null) {
                        i = R$id.guild_boost_confirmation_upgrade_arrow;
                        ImageView imageView = (ImageView) findViewById(R$id.guild_boost_confirmation_upgrade_arrow);
                        if (imageView != null) {
                            l2 l2Var = new l2(this, simpleDraweeView, textView, chip, chip2, imageView);
                            m.checkNotNullExpressionValue(l2Var, "ViewGuildBoostConfirmati…ater.from(context), this)");
                            this.binding = l2Var;
                            return;
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(getResources().getResourceName(i)));
    }

    public final void b(Guild guild, int netNewSubscriptions) {
        char c;
        m.checkNotNullParameter(guild, "guild");
        int boostTier$default = GuildBoostUtils.getBoostTier$default(GuildBoostUtils.INSTANCE, guild.getId(), guild.getPremiumSubscriptionCount() + netNewSubscriptions, null, null, 12, null);
        if (boostTier$default > guild.getPremiumTier()) {
            c = 1;
        } else {
            c = boostTier$default < guild.getPremiumTier() ? (char) 2 : (char) 3;
        }
        SimpleDraweeView simpleDraweeView = this.binding.f152b;
        m.checkNotNullExpressionValue(simpleDraweeView, "binding.guildBoostConfirmationAvatar");
        IconUtils.setIcon$default(simpleDraweeView, IconUtils.getForGuild$default(guild, null, false, null, 14, null), 0, (Function1) null, (MGImages$ChangeDetector) null, 28, (Object) null);
        TextView textView = this.binding.c;
        m.checkNotNullExpressionValue(textView, "binding.guildBoostConfirmationGuildName");
        textView.setText(guild.getName());
        Chip chip = this.binding.d;
        m.checkNotNullExpressionValue(chip, "binding.guildBoostConfirmationLevelInfoPrevious");
        chip.setChipIcon(ContextCompat.getDrawable(getContext(), c(guild.getPremiumTier())));
        Chip chip2 = this.binding.d;
        m.checkNotNullExpressionValue(chip2, "binding.guildBoostConfirmationLevelInfoPrevious");
        chip2.setText(d(guild.getPremiumTier()));
        ImageView imageView = this.binding.f;
        m.checkNotNullExpressionValue(imageView, "binding.guildBoostConfirmationUpgradeArrow");
        imageView.setVisibility(c != 3 ? 0 : 8);
        Chip chip3 = this.binding.e;
        m.checkNotNullExpressionValue(chip3, "binding.guildBoostConfirmationLevelInfoUpgrade");
        chip3.setVisibility(c != 3 ? 0 : 8);
        if (c == 3) {
            return;
        }
        int i = c == 2 ? 2131100382 : 2131100304;
        ImageView imageView2 = this.binding.f;
        m.checkNotNullExpressionValue(imageView2, "binding.guildBoostConfirmationUpgradeArrow");
        ColorCompatKt.tintWithColorResource(imageView2, i);
        Chip chip4 = this.binding.e;
        m.checkNotNullExpressionValue(chip4, "binding.guildBoostConfirmationLevelInfoUpgrade");
        chip4.setChipIcon(ContextCompat.getDrawable(getContext(), c(boostTier$default)));
        Chip chip5 = this.binding.e;
        m.checkNotNullExpressionValue(chip5, "binding.guildBoostConfirmationLevelInfoUpgrade");
        chip5.setText(d(boostTier$default));
    }

    public final int c(int boostTier) {
        if (boostTier == 0) {
            return 2131231841;
        }
        if (boostTier == 1) {
            Context context = getContext();
            m.checkNotNullExpressionValue(context, "context");
            return DrawableCompat.getThemedDrawableRes$default(context, 2130969411, 0, 2, (Object) null);
        }
        if (boostTier == 2) {
            Context context2 = getContext();
            m.checkNotNullExpressionValue(context2, "context");
            return DrawableCompat.getThemedDrawableRes$default(context2, 2130969412, 0, 2, (Object) null);
        }
        if (boostTier != 3) {
            return 0;
        }
        Context context3 = getContext();
        m.checkNotNullExpressionValue(context3, "context");
        return DrawableCompat.getThemedDrawableRes$default(context3, 2130969413, 0, 2, (Object) null);
    }

    public final String d(int boostTier) {
        String string;
        if (boostTier == 0) {
            string = getContext().getString(2131894022);
        } else if (boostTier == 1) {
            string = getContext().getString(2131894200);
        } else if (boostTier != 2) {
            string = boostTier != 3 ? "" : getContext().getString(2131894204);
        } else {
            string = getContext().getString(2131894202);
        }
        m.checkNotNullExpressionValue(string, "when (boostTier) {\n     …       else -> \"\"\n      }");
        return string;
    }
}
