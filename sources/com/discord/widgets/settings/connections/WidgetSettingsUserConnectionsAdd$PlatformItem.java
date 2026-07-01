package com.discord.widgets.settings.connections;

import b.d.b.a.a;
import com.discord.utilities.mg_recycler.MGRecyclerDataPayload;
import com.discord.utilities.platform.Platform;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetSettingsUserConnectionsAdd.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class WidgetSettingsUserConnectionsAdd$PlatformItem implements MGRecyclerDataPayload {
    private final String key;
    private final Platform platform;
    private final int type;

    public WidgetSettingsUserConnectionsAdd$PlatformItem(Platform platform) {
        m.checkNotNullParameter(platform, "platform");
        this.platform = platform;
        this.key = platform.name();
    }

    public static /* synthetic */ WidgetSettingsUserConnectionsAdd$PlatformItem copy$default(WidgetSettingsUserConnectionsAdd$PlatformItem widgetSettingsUserConnectionsAdd$PlatformItem, Platform platform, int i, Object obj) {
        if ((i & 1) != 0) {
            platform = widgetSettingsUserConnectionsAdd$PlatformItem.platform;
        }
        return widgetSettingsUserConnectionsAdd$PlatformItem.copy(platform);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Platform getPlatform() {
        return this.platform;
    }

    public final WidgetSettingsUserConnectionsAdd$PlatformItem copy(Platform platform) {
        m.checkNotNullParameter(platform, "platform");
        return new WidgetSettingsUserConnectionsAdd$PlatformItem(platform);
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof WidgetSettingsUserConnectionsAdd$PlatformItem) && m.areEqual(this.platform, ((WidgetSettingsUserConnectionsAdd$PlatformItem) other).platform);
        }
        return true;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload, com.discord.utilities.recycler.DiffKeyProvider
    public String getKey() {
        return this.key;
    }

    public final Platform getPlatform() {
        return this.platform;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload
    public int getType() {
        return this.type;
    }

    public int hashCode() {
        Platform platform = this.platform;
        if (platform != null) {
            return platform.hashCode();
        }
        return 0;
    }

    public String toString() {
        StringBuilder sbU = a.U("PlatformItem(platform=");
        sbU.append(this.platform);
        sbU.append(")");
        return sbU.toString();
    }
}
