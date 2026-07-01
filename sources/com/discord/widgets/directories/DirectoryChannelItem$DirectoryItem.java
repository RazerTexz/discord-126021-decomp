package com.discord.widgets.directories;

import b.d.b.a.a;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetDirectoryEntryViewHolder.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class DirectoryChannelItem$DirectoryItem extends DirectoryChannelItem {
    private final DirectoryEntryData directoryEntryData;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DirectoryChannelItem$DirectoryItem(DirectoryEntryData directoryEntryData) {
        super(DirectoryChannelItem$ViewType.Item, null);
        m.checkNotNullParameter(directoryEntryData, "directoryEntryData");
        this.directoryEntryData = directoryEntryData;
    }

    public static /* synthetic */ DirectoryChannelItem$DirectoryItem copy$default(DirectoryChannelItem$DirectoryItem directoryChannelItem$DirectoryItem, DirectoryEntryData directoryEntryData, int i, Object obj) {
        if ((i & 1) != 0) {
            directoryEntryData = directoryChannelItem$DirectoryItem.directoryEntryData;
        }
        return directoryChannelItem$DirectoryItem.copy(directoryEntryData);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final DirectoryEntryData getDirectoryEntryData() {
        return this.directoryEntryData;
    }

    public final DirectoryChannelItem$DirectoryItem copy(DirectoryEntryData directoryEntryData) {
        m.checkNotNullParameter(directoryEntryData, "directoryEntryData");
        return new DirectoryChannelItem$DirectoryItem(directoryEntryData);
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof DirectoryChannelItem$DirectoryItem) && m.areEqual(this.directoryEntryData, ((DirectoryChannelItem$DirectoryItem) other).directoryEntryData);
        }
        return true;
    }

    public final DirectoryEntryData getDirectoryEntryData() {
        return this.directoryEntryData;
    }

    public int hashCode() {
        DirectoryEntryData directoryEntryData = this.directoryEntryData;
        if (directoryEntryData != null) {
            return directoryEntryData.hashCode();
        }
        return 0;
    }

    public String toString() {
        StringBuilder sbU = a.U("DirectoryItem(directoryEntryData=");
        sbU.append(this.directoryEntryData);
        sbU.append(")");
        return sbU.toString();
    }
}
