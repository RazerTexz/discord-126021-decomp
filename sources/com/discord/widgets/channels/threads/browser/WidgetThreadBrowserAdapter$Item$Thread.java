package com.discord.widgets.channels.threads.browser;

import b.d.b.a.a;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetThreadBrowserAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class WidgetThreadBrowserAdapter$Item$Thread extends WidgetThreadBrowserAdapter$Item {
    private final String key;
    private final ThreadBrowserThreadView$ThreadData threadData;
    private final int type;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetThreadBrowserAdapter$Item$Thread(ThreadBrowserThreadView$ThreadData threadBrowserThreadView$ThreadData) {
        super(null);
        m.checkNotNullParameter(threadBrowserThreadView$ThreadData, "threadData");
        this.threadData = threadBrowserThreadView$ThreadData;
        this.type = WidgetThreadBrowserAdapter$ItemType.THREAD.ordinal();
        this.key = String.valueOf(threadBrowserThreadView$ThreadData.getChannel().getId());
    }

    public static /* synthetic */ WidgetThreadBrowserAdapter$Item$Thread copy$default(WidgetThreadBrowserAdapter$Item$Thread widgetThreadBrowserAdapter$Item$Thread, ThreadBrowserThreadView$ThreadData threadBrowserThreadView$ThreadData, int i, Object obj) {
        if ((i & 1) != 0) {
            threadBrowserThreadView$ThreadData = widgetThreadBrowserAdapter$Item$Thread.threadData;
        }
        return widgetThreadBrowserAdapter$Item$Thread.copy(threadBrowserThreadView$ThreadData);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final ThreadBrowserThreadView$ThreadData getThreadData() {
        return this.threadData;
    }

    public final WidgetThreadBrowserAdapter$Item$Thread copy(ThreadBrowserThreadView$ThreadData threadData) {
        m.checkNotNullParameter(threadData, "threadData");
        return new WidgetThreadBrowserAdapter$Item$Thread(threadData);
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof WidgetThreadBrowserAdapter$Item$Thread) && m.areEqual(this.threadData, ((WidgetThreadBrowserAdapter$Item$Thread) other).threadData);
        }
        return true;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload, com.discord.utilities.recycler.DiffKeyProvider
    public String getKey() {
        return this.key;
    }

    public final ThreadBrowserThreadView$ThreadData getThreadData() {
        return this.threadData;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload
    public int getType() {
        return this.type;
    }

    public int hashCode() {
        ThreadBrowserThreadView$ThreadData threadBrowserThreadView$ThreadData = this.threadData;
        if (threadBrowserThreadView$ThreadData != null) {
            return threadBrowserThreadView$ThreadData.hashCode();
        }
        return 0;
    }

    public String toString() {
        StringBuilder sbU = a.U("Thread(threadData=");
        sbU.append(this.threadData);
        sbU.append(")");
        return sbU.toString();
    }
}
