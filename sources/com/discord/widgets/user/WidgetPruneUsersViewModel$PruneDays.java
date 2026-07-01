package com.discord.widgets.user;


/* JADX INFO: compiled from: WidgetPruneUsersViewModel.kt */
/* JADX INFO: loaded from: classes.dex */
public enum WidgetPruneUsersViewModel$PruneDays {
    Seven(7),
    Thirty(30);

    private final int count;

    WidgetPruneUsersViewModel$PruneDays(int i) {
        this.count = i;
    }

    public final int getCount() {
        return this.count;
    }
}
