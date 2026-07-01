package com.discord.widgets.servers.guildboost;

import androidx.viewpager.widget.ViewPager$OnPageChangeListener;
import com.discord.models.domain.ModelAuditLogEntry;

/* JADX INFO: compiled from: WidgetGuildBoost.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildBoost$onViewBound$1 implements ViewPager$OnPageChangeListener {
    public final /* synthetic */ WidgetGuildBoost this$0;

    public WidgetGuildBoost$onViewBound$1(WidgetGuildBoost widgetGuildBoost) {
        this.this$0 = widgetGuildBoost;
    }

    @Override // androidx.viewpager.widget.ViewPager$OnPageChangeListener
    public void onPageScrollStateChanged(int state) {
    }

    @Override // androidx.viewpager.widget.ViewPager$OnPageChangeListener
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
    }

    @Override // androidx.viewpager.widget.ViewPager$OnPageChangeListener
    public void onPageSelected(int position) {
        WidgetGuildBoost.access$configureLevelBubbles(this.this$0, position + 1);
    }
}
