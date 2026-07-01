package com.discord.widgets.settings.premium;

import androidx.annotation.StringRes;
import b.d.b.a.a;

/* JADX INFO: compiled from: WidgetChoosePlanAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class WidgetChoosePlanAdapter$Item$Header extends WidgetChoosePlanAdapter$Item {
    private final String key;
    private final int titleStringResId;

    public WidgetChoosePlanAdapter$Item$Header(@StringRes int i) {
        super(0, null);
        this.titleStringResId = i;
        this.key = String.valueOf(getType());
    }

    public static /* synthetic */ WidgetChoosePlanAdapter$Item$Header copy$default(WidgetChoosePlanAdapter$Item$Header widgetChoosePlanAdapter$Item$Header, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = widgetChoosePlanAdapter$Item$Header.titleStringResId;
        }
        return widgetChoosePlanAdapter$Item$Header.copy(i);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getTitleStringResId() {
        return this.titleStringResId;
    }

    public final WidgetChoosePlanAdapter$Item$Header copy(@StringRes int titleStringResId) {
        return new WidgetChoosePlanAdapter$Item$Header(titleStringResId);
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof WidgetChoosePlanAdapter$Item$Header) && this.titleStringResId == ((WidgetChoosePlanAdapter$Item$Header) other).titleStringResId;
        }
        return true;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload, com.discord.utilities.recycler.DiffKeyProvider
    public String getKey() {
        return this.key;
    }

    public final int getTitleStringResId() {
        return this.titleStringResId;
    }

    public int hashCode() {
        return this.titleStringResId;
    }

    public String toString() {
        return a.B(a.U("Header(titleStringResId="), this.titleStringResId, ")");
    }
}
