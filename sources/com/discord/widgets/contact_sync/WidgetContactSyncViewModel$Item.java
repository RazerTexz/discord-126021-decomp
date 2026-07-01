package com.discord.widgets.contact_sync;

import com.discord.utilities.mg_recycler.MGRecyclerDataPayload;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: WidgetContactSyncViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public abstract class WidgetContactSyncViewModel$Item implements MGRecyclerDataPayload {
    private final int type;

    private WidgetContactSyncViewModel$Item(int i) {
        this.type = i;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload
    public int getType() {
        return this.type;
    }

    public /* synthetic */ WidgetContactSyncViewModel$Item(int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(i);
    }
}
