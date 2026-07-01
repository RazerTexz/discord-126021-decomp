package com.discord.widgets.servers;

import a0.a.a.b;
import b.d.b.a.a;
import com.discord.utilities.mg_recycler.DragAndDropAdapter$Payload;

/* JADX INFO: compiled from: WidgetServerSettingsRolesAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class WidgetServerSettingsRolesAdapter$HelpItem implements DragAndDropAdapter$Payload {
    private final long guildId;
    private final String key = "key0";
    private final int type;

    public WidgetServerSettingsRolesAdapter$HelpItem(long j) {
        this.guildId = j;
    }

    public static /* synthetic */ WidgetServerSettingsRolesAdapter$HelpItem copy$default(WidgetServerSettingsRolesAdapter$HelpItem widgetServerSettingsRolesAdapter$HelpItem, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            j = widgetServerSettingsRolesAdapter$HelpItem.guildId;
        }
        return widgetServerSettingsRolesAdapter$HelpItem.copy(j);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final long getGuildId() {
        return this.guildId;
    }

    public final WidgetServerSettingsRolesAdapter$HelpItem copy(long guildId) {
        return new WidgetServerSettingsRolesAdapter$HelpItem(guildId);
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof WidgetServerSettingsRolesAdapter$HelpItem) && this.guildId == ((WidgetServerSettingsRolesAdapter$HelpItem) other).guildId;
        }
        return true;
    }

    public final long getGuildId() {
        return this.guildId;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload, com.discord.utilities.recycler.DiffKeyProvider
    public String getKey() {
        return this.key;
    }

    @Override // com.discord.utilities.mg_recycler.DragAndDropAdapter$Payload
    public int getPosition() {
        return 0;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload
    public int getType() {
        return this.type;
    }

    public int hashCode() {
        return b.a(this.guildId);
    }

    public String toString() {
        return a.C(a.U("HelpItem(guildId="), this.guildId, ")");
    }
}
