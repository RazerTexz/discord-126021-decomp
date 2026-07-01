package com.discord.widgets.directories;

import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: WidgetDirectoryEntryViewHolder.kt */
/* JADX INFO: loaded from: classes2.dex */
public abstract class DirectoryChannelItem {
    private final DirectoryChannelItem$ViewType viewType;

    private DirectoryChannelItem(DirectoryChannelItem$ViewType directoryChannelItem$ViewType) {
        this.viewType = directoryChannelItem$ViewType;
    }

    public final DirectoryChannelItem$ViewType getViewType() {
        return this.viewType;
    }

    public /* synthetic */ DirectoryChannelItem(DirectoryChannelItem$ViewType directoryChannelItem$ViewType, DefaultConstructorMarker defaultConstructorMarker) {
        this(directoryChannelItem$ViewType);
    }
}
