package com.discord.widgets.hubs.events;

import com.discord.utilities.analytics.Traits$Location$Section;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: WidgetHubEventsPageAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public abstract class HubEventsPage {
    public static final HubEventsPage$Companion Companion = new HubEventsPage$Companion(null);
    public static final int ENTRY = 2;
    public static final int FOOTER = 1;
    public static final int HEADER = 0;
    private final int viewType;

    private HubEventsPage(int i) {
        this.viewType = i;
    }

    public final int getViewType() {
        return this.viewType;
    }

    public /* synthetic */ HubEventsPage(int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(i);
    }
}
