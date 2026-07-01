package com.discord.widgets.servers.guildboost;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import b.a.k.b;
import com.discord.R$plurals;
import com.discord.databinding.ViewNitroBoostPerksBinding;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.drawable.DrawableCompat;
import com.discord.utilities.guilds.GuildUtilsKt;
import com.discord.utilities.mg_recycler.MGRecyclerAdapter;
import com.discord.utilities.mg_recycler.MGRecyclerAdapter$Companion;
import com.discord.utilities.premium.GuildBoostUtils;
import com.discord.utilities.premium.PremiumUtils;
import com.discord.utilities.resources.StringResourceUtilsKt;
import com.discord.utilities.threads.ThreadUtils;
import d0.t.n;
import d0.t.u;
import d0.z.d.m;
import f0.e0.c;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: GuildBoostPerkView.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class GuildBoostPerkView extends RelativeLayout {
    private GuildBoostPerkViewAdapter adapter;
    private final ViewNitroBoostPerksBinding binding;

    public GuildBoostPerkView(Context context) {
        super(context);
        ViewNitroBoostPerksBinding viewNitroBoostPerksBindingA = ViewNitroBoostPerksBinding.a(LayoutInflater.from(getContext()), this, true);
        m.checkNotNullExpressionValue(viewNitroBoostPerksBindingA, "ViewNitroBoostPerksBindi…rom(context), this, true)");
        this.binding = viewNitroBoostPerksBindingA;
    }

    private final void initialize() {
        MGRecyclerAdapter$Companion mGRecyclerAdapter$Companion = MGRecyclerAdapter.Companion;
        RecyclerView recyclerView = this.binding.c;
        m.checkNotNullExpressionValue(recyclerView, "binding.perksLevelContentsRecycler");
        this.adapter = (GuildBoostPerkViewAdapter) mGRecyclerAdapter$Companion.configure(new GuildBoostPerkViewAdapter(recyclerView));
        this.binding.c.addOnItemTouchListener(new GuildBoostPerkView$initialize$1());
    }

    public final void configure(int premiumTier, int currentPremiumTier, long guildId) {
        int i;
        int i2;
        List mutableList;
        GuildBoostPerkView$configure$1 guildBoostPerkView$configure$1 = GuildBoostPerkView$configure$1.INSTANCE;
        boolean z2 = currentPremiumTier >= premiumTier;
        if (z2) {
            this.binding.d.setBackgroundResource(2131231122);
        } else {
            this.binding.d.setBackgroundColor(ColorCompat.getThemedColor(this, 2130969997));
        }
        int boostsRequiredForTier$default = GuildBoostUtils.getBoostsRequiredForTier$default(GuildBoostUtils.INSTANCE, guildId, premiumTier, null, null, 12, null);
        TextView textView = this.binding.f;
        m.checkNotNullExpressionValue(textView, "binding.perksLevelHeaderText");
        if (premiumTier == 1) {
            i = 2131891225;
        } else if (premiumTier != 2) {
            i = premiumTier != 3 ? 0 : 2131891227;
        } else {
            i = 2131891226;
        }
        b.n(textView, i, new Object[0], null, 4);
        if (premiumTier == 1) {
            i2 = z2 ? 2131232000 : 2131232001;
        } else if (premiumTier == 2) {
            i2 = z2 ? 2131232002 : 2131232003;
        } else if (premiumTier != 3) {
            i2 = 0;
        } else {
            i2 = z2 ? 2131232004 : 2131232005;
        }
        TextView textView2 = this.binding.f;
        m.checkNotNullExpressionValue(textView2, "binding.perksLevelHeaderText");
        DrawableCompat.setCompoundDrawablesCompat$default(textView2, i2, 0, 0, 0, 14, (Object) null);
        this.binding.f.setTextColor(z2 ? ColorCompat.getColor(getContext(), 2131100487) : ColorCompat.getThemedColor(getContext(), 2130969978));
        TextView textView3 = this.binding.e;
        m.checkNotNullExpressionValue(textView3, "binding.perksLevelHeaderBoosts");
        Resources resources = getResources();
        m.checkNotNullExpressionValue(resources, "resources");
        Context context = getContext();
        m.checkNotNullExpressionValue(context, "context");
        textView3.setText(StringResourceUtilsKt.getQuantityString(resources, context, R$plurals.guild_settings_premium_guild_tier_requirement_required, boostsRequiredForTier$default, Integer.valueOf(boostsRequiredForTier$default)));
        TextView textView4 = this.binding.e;
        m.checkNotNullExpressionValue(textView4, "binding.perksLevelHeaderBoosts");
        textView4.setVisibility(z2 ^ true ? 0 : 8);
        CardView cardView = this.binding.g;
        m.checkNotNullExpressionValue(cardView, "binding.perksLevelHeaderUnlocked");
        cardView.setVisibility(z2 ? 0 : 8);
        TextView textView5 = this.binding.f2204b;
        m.checkNotNullExpressionValue(textView5, "binding.perksLevelContentsHeader");
        b.n(textView5, premiumTier != 1 ? 2131891223 : 2131891221, new Object[0], null, 4);
        boolean zIsThreadsEnabled = ThreadUtils.INSTANCE.isThreadsEnabled(guildId);
        if (premiumTier == 1) {
            int iInvoke = guildBoostPerkView$configure$1.invoke(2131232131, z2);
            PremiumUtils premiumUtils = PremiumUtils.INSTANCE;
            mutableList = u.toMutableList((Collection) u.filterNotNull(n.mutableListOf(new GuildBoostPerkViewAdapter$GuildBoostPerkViewListItem(iInvoke, b.j(this, 2131891218, new Object[]{50, Integer.valueOf(premiumUtils.getGuildEmojiMaxCount(1, false))}, null, 4)), new GuildBoostPerkViewAdapter$GuildBoostPerkViewListItem(guildBoostPerkView$configure$1.invoke(2131232165, z2), b.j(this, 2131891219, new Object[]{15, Integer.valueOf(premiumUtils.getGuildStickerMaxCount(1, false))}, null, 4)), new GuildBoostPerkViewAdapter$GuildBoostPerkViewListItem(guildBoostPerkView$configure$1.invoke(2131231852, z2), b.j(this, 2131891217, new Object[]{Integer.valueOf(GuildUtilsKt.getMaxVoiceBitrateKbps(1, false))}, null, 4)), new GuildBoostPerkViewAdapter$GuildBoostPerkViewListItem(guildBoostPerkView$configure$1.invoke(2131231965, z2), b.j(this, 2131891208, new Object[0], null, 4)), new GuildBoostPerkViewAdapter$GuildBoostPerkViewListItem(guildBoostPerkView$configure$1.invoke(2131231882, z2), b.j(this, 2131891209, new Object[0], null, 4)), new GuildBoostPerkViewAdapter$GuildBoostPerkViewListItem(guildBoostPerkView$configure$1.invoke(2131231839, z2), b.j(this, 2131891210, new Object[0], null, 4)))));
        } else if (premiumTier == 2) {
            GuildBoostPerkViewAdapter$GuildBoostPerkViewListItem[] guildBoostPerkViewAdapter$GuildBoostPerkViewListItemArr = new GuildBoostPerkViewAdapter$GuildBoostPerkViewListItem[8];
            int iInvoke2 = guildBoostPerkView$configure$1.invoke(2131232131, z2);
            PremiumUtils premiumUtils2 = PremiumUtils.INSTANCE;
            guildBoostPerkViewAdapter$GuildBoostPerkViewListItemArr[0] = new GuildBoostPerkViewAdapter$GuildBoostPerkViewListItem(iInvoke2, b.j(this, 2131891218, new Object[]{50, Integer.valueOf(premiumUtils2.getGuildEmojiMaxCount(2, false))}, null, 4));
            guildBoostPerkViewAdapter$GuildBoostPerkViewListItemArr[1] = new GuildBoostPerkViewAdapter$GuildBoostPerkViewListItem(guildBoostPerkView$configure$1.invoke(2131232165, z2), b.j(this, 2131891219, new Object[]{15, Integer.valueOf(premiumUtils2.getGuildStickerMaxCount(2, false))}, null, 4));
            guildBoostPerkViewAdapter$GuildBoostPerkViewListItemArr[2] = new GuildBoostPerkViewAdapter$GuildBoostPerkViewListItem(guildBoostPerkView$configure$1.invoke(2131231852, z2), b.j(this, 2131891217, new Object[]{Integer.valueOf(GuildUtilsKt.getMaxVoiceBitrateKbps(2, false))}, null, 4));
            guildBoostPerkViewAdapter$GuildBoostPerkViewListItemArr[3] = new GuildBoostPerkViewAdapter$GuildBoostPerkViewListItem(guildBoostPerkView$configure$1.invoke(2131232213, z2), b.j(this, 2131891220, new Object[]{b.j(this, 2131889025, new Object[]{Integer.valueOf(premiumUtils2.getGuildMaxFileSizeMB(2))}, null, 4)}, null, 4));
            guildBoostPerkViewAdapter$GuildBoostPerkViewListItemArr[4] = new GuildBoostPerkViewAdapter$GuildBoostPerkViewListItem(guildBoostPerkView$configure$1.invoke(2131231882, z2), b.j(this, 2131891211, new Object[0], null, 4));
            guildBoostPerkViewAdapter$GuildBoostPerkViewListItemArr[5] = new GuildBoostPerkViewAdapter$GuildBoostPerkViewListItem(guildBoostPerkView$configure$1.invoke(2131231839, z2), b.j(this, 2131891213, new Object[0], null, 4));
            guildBoostPerkViewAdapter$GuildBoostPerkViewListItemArr[6] = zIsThreadsEnabled ? new GuildBoostPerkViewAdapter$GuildBoostPerkViewListItem(guildBoostPerkView$configure$1.invoke(2131232196, z2), b.j(this, 2131891214, new Object[0], null, 4)) : null;
            guildBoostPerkViewAdapter$GuildBoostPerkViewListItemArr[7] = new GuildBoostPerkViewAdapter$GuildBoostPerkViewListItem(guildBoostPerkView$configure$1.invoke(2131232012, z2), b.j(this, 2131894021, new Object[0], null, 4));
            mutableList = u.toMutableList((Collection) u.filterNotNull(n.mutableListOf(guildBoostPerkViewAdapter$GuildBoostPerkViewListItemArr)));
        } else if (premiumTier != 3) {
            mutableList = new ArrayList();
        } else {
            int iInvoke3 = guildBoostPerkView$configure$1.invoke(2131232131, z2);
            PremiumUtils premiumUtils3 = PremiumUtils.INSTANCE;
            mutableList = n.mutableListOf(new GuildBoostPerkViewAdapter$GuildBoostPerkViewListItem(iInvoke3, b.j(this, 2131891218, new Object[]{100, Integer.valueOf(premiumUtils3.getGuildEmojiMaxCount(3, false))}, null, 4)), new GuildBoostPerkViewAdapter$GuildBoostPerkViewListItem(guildBoostPerkView$configure$1.invoke(2131232165, z2), b.j(this, 2131891219, new Object[]{30, Integer.valueOf(premiumUtils3.getGuildStickerMaxCount(3, false))}, null, 4)), new GuildBoostPerkViewAdapter$GuildBoostPerkViewListItem(guildBoostPerkView$configure$1.invoke(2131231852, z2), b.j(this, 2131891217, new Object[]{Integer.valueOf(GuildUtilsKt.getMaxVoiceBitrateKbps(3, false))}, null, 4)), new GuildBoostPerkViewAdapter$GuildBoostPerkViewListItem(guildBoostPerkView$configure$1.invoke(2131232213, z2), b.j(this, 2131891220, new Object[]{b.j(this, 2131889025, new Object[]{Integer.valueOf(premiumUtils3.getGuildMaxFileSizeMB(3))}, null, 4)}, null, 4)), new GuildBoostPerkViewAdapter$GuildBoostPerkViewListItem(guildBoostPerkView$configure$1.invoke(2131232158, z2), b.j(this, 2131891216, new Object[0], null, 4)), new GuildBoostPerkViewAdapter$GuildBoostPerkViewListItem(guildBoostPerkView$configure$1.invoke(2131231965, z2), b.j(this, 2131891202, new Object[0], null, 4)));
        }
        GuildBoostPerkViewAdapter guildBoostPerkViewAdapter = this.adapter;
        if (guildBoostPerkViewAdapter == null) {
            m.throwUninitializedPropertyAccessException("adapter");
        }
        guildBoostPerkViewAdapter.configure(c.z(mutableList));
    }

    public GuildBoostPerkView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        ViewNitroBoostPerksBinding viewNitroBoostPerksBindingA = ViewNitroBoostPerksBinding.a(LayoutInflater.from(getContext()), this, true);
        m.checkNotNullExpressionValue(viewNitroBoostPerksBindingA, "ViewNitroBoostPerksBindi…rom(context), this, true)");
        this.binding = viewNitroBoostPerksBindingA;
        initialize();
    }

    public /* synthetic */ GuildBoostPerkView(Context context, AttributeSet attributeSet, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i & 2) != 0 ? null : attributeSet);
    }

    public /* synthetic */ GuildBoostPerkView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildBoostPerkView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m.checkNotNullParameter(context, "context");
        ViewNitroBoostPerksBinding viewNitroBoostPerksBindingA = ViewNitroBoostPerksBinding.a(LayoutInflater.from(getContext()), this, true);
        m.checkNotNullExpressionValue(viewNitroBoostPerksBindingA, "ViewNitroBoostPerksBindi…rom(context), this, true)");
        this.binding = viewNitroBoostPerksBindingA;
        initialize();
    }
}
