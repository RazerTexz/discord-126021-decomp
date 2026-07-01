package com.discord.widgets.settings.premium;


/* JADX INFO: compiled from: WidgetChoosePlanAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChoosePlanAdapter$Item$Divider extends WidgetChoosePlanAdapter$Item {
    private final String key;

    public WidgetChoosePlanAdapter$Item$Divider() {
        super(2, null);
        this.key = String.valueOf(getType());
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload, com.discord.utilities.recycler.DiffKeyProvider
    public String getKey() {
        return this.key;
    }
}
