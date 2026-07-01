package com.discord.widgets.servers.guildboost;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.m;
import java.util.Objects;

/* JADX INFO: compiled from: WidgetGuildBoost.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildBoost$PerksPagerAdapter extends PagerAdapter {
    private long guildId;
    private int premiumTier;
    private int subscriptionCount;

    public WidgetGuildBoost$PerksPagerAdapter(long j) {
        this.guildId = j;
    }

    public final void configureViews(ViewPager viewPager) {
        m.checkNotNullParameter(viewPager, "viewPager");
        int childCount = viewPager.getChildCount();
        if (childCount <= 0) {
            return;
        }
        int i = 0;
        while (true) {
            int i2 = i + 1;
            View childAt = viewPager.getChildAt(i);
            m.checkNotNullExpressionValue(childAt, "getChildAt(index)");
            Object tag = childAt.getTag();
            Objects.requireNonNull(tag, "null cannot be cast to non-null type kotlin.Int");
            ((GuildBoostPerkView) childAt).configure(((Integer) tag).intValue(), this.premiumTier, this.guildId);
            if (i2 >= childCount) {
                return;
            } else {
                i = i2;
            }
        }
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void destroyItem(ViewGroup container, int position, Object view) {
        m.checkNotNullParameter(container, "container");
        m.checkNotNullParameter(view, "view");
        container.removeView((View) view);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        return 3;
    }

    public final long getGuildId() {
        return this.guildId;
    }

    public final int getPremiumTier() {
        return this.premiumTier;
    }

    public final int getSubscriptionCount() {
        return this.subscriptionCount;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public /* bridge */ /* synthetic */ Object instantiateItem(ViewGroup viewGroup, int i) {
        return instantiateItem(viewGroup, i);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public boolean isViewFromObject(View view, Object any) {
        m.checkNotNullParameter(view, "view");
        m.checkNotNullParameter(any, "any");
        return m.areEqual(view, any);
    }

    public final void setGuildId(long j) {
        this.guildId = j;
    }

    public final void setPremiumTier(int i) {
        this.premiumTier = i;
    }

    public final void setSubscriptionCount(int i) {
        this.subscriptionCount = i;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public View instantiateItem(ViewGroup container, int position) {
        m.checkNotNullParameter(container, "container");
        int i = position + 1;
        Context context = container.getContext();
        m.checkNotNullExpressionValue(context, "container.context");
        GuildBoostPerkView guildBoostPerkView = new GuildBoostPerkView(context, null, 0, 6, null);
        guildBoostPerkView.configure(i, this.premiumTier, this.guildId);
        guildBoostPerkView.setTag(Integer.valueOf(i));
        container.addView(guildBoostPerkView);
        return guildBoostPerkView;
    }
}
