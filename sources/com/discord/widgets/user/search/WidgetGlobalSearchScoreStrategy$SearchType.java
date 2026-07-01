package com.discord.widgets.user.search;


/* JADX INFO: compiled from: WidgetGlobalSearchScoreStrategy.kt */
/* JADX INFO: loaded from: classes.dex */
public enum WidgetGlobalSearchScoreStrategy$SearchType {
    USER(10, 5),
    NONE(1, 1);

    private final int dmChannelWeight;
    private final int friendWeight;

    WidgetGlobalSearchScoreStrategy$SearchType(int i, int i2) {
        this.friendWeight = i;
        this.dmChannelWeight = i2;
    }

    public final int getDmChannelWeight() {
        return this.dmChannelWeight;
    }

    public final int getFriendWeight() {
        return this.friendWeight;
    }
}
