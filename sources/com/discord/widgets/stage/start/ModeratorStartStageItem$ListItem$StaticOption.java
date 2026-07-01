package com.discord.widgets.stage.start;

import androidx.annotation.StringRes;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: ModeratorStartStageItem.kt */
/* JADX INFO: loaded from: classes2.dex */
public abstract class ModeratorStartStageItem$ListItem$StaticOption extends ModeratorStartStageItem$ListItem {
    private final int iconBgColorRes;
    private final int iconRes;
    private final String key;
    private final int subtitleRes;
    private final int titleRes;

    public /* synthetic */ ModeratorStartStageItem$ListItem$StaticOption(String str, int i, int i2, int i3, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, i, i2, i3, i4);
    }

    @Override // com.discord.widgets.stage.start.ModeratorStartStageItem$ListItem
    public int getIconBgColorRes() {
        return this.iconBgColorRes;
    }

    @Override // com.discord.widgets.stage.start.ModeratorStartStageItem$ListItem
    public int getIconRes() {
        return this.iconRes;
    }

    @Override // com.discord.widgets.stage.start.ModeratorStartStageItem$ListItem, com.discord.utilities.mg_recycler.MGRecyclerDataPayload, com.discord.utilities.recycler.DiffKeyProvider
    public String getKey() {
        return this.key;
    }

    public final int getSubtitleRes() {
        return this.subtitleRes;
    }

    public final int getTitleRes() {
        return this.titleRes;
    }

    private ModeratorStartStageItem$ListItem$StaticOption(String str, int i, int i2, @StringRes int i3, @StringRes int i4) {
        super(0, str, i, i2, 1, null);
        this.key = str;
        this.iconRes = i;
        this.iconBgColorRes = i2;
        this.titleRes = i3;
        this.subtitleRes = i4;
    }
}
