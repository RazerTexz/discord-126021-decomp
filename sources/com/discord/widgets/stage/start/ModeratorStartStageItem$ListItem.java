package com.discord.widgets.stage.start;

import androidx.annotation.ColorRes;
import androidx.annotation.DrawableRes;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: ModeratorStartStageItem.kt */
/* JADX INFO: loaded from: classes2.dex */
public abstract class ModeratorStartStageItem$ListItem extends ModeratorStartStageItem {
    private final int iconBgColorRes;
    private final int iconRes;
    private final String key;
    private final int type;

    public /* synthetic */ ModeratorStartStageItem$ListItem(int i, String str, int i2, int i3, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this((i4 & 1) != 0 ? 1 : i, str, i2, i3);
    }

    public int getIconBgColorRes() {
        return this.iconBgColorRes;
    }

    public int getIconRes() {
        return this.iconRes;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload, com.discord.utilities.recycler.DiffKeyProvider
    public String getKey() {
        return this.key;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload
    public int getType() {
        return this.type;
    }

    private ModeratorStartStageItem$ListItem(int i, String str, @DrawableRes int i2, @ColorRes int i3) {
        super(null);
        this.type = i;
        this.key = str;
        this.iconRes = i2;
        this.iconBgColorRes = i3;
    }
}
