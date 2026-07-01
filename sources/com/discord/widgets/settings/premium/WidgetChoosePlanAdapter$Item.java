package com.discord.widgets.settings.premium;

import com.discord.utilities.analytics.Traits$Location$Section;
import com.discord.utilities.mg_recycler.MGRecyclerDataPayload;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: WidgetChoosePlanAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public abstract class WidgetChoosePlanAdapter$Item implements MGRecyclerDataPayload {
    public static final WidgetChoosePlanAdapter$Item$Companion Companion = new WidgetChoosePlanAdapter$Item$Companion(null);
    public static final int TYPE_DIVIDER = 2;
    public static final int TYPE_HEADER = 0;
    public static final int TYPE_PLAN = 1;
    private final int type;

    private WidgetChoosePlanAdapter$Item(int i) {
        this.type = i;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload
    public int getType() {
        return this.type;
    }

    public /* synthetic */ WidgetChoosePlanAdapter$Item(int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(i);
    }
}
