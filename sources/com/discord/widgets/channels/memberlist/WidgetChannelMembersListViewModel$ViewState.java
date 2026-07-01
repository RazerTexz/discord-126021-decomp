package com.discord.widgets.channels.memberlist;

import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: WidgetChannelMembersListViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public abstract class WidgetChannelMembersListViewModel$ViewState {
    private final String listId;

    private WidgetChannelMembersListViewModel$ViewState(String str) {
        this.listId = str;
    }

    public final String getListId() {
        return this.listId;
    }

    public /* synthetic */ WidgetChannelMembersListViewModel$ViewState(String str, DefaultConstructorMarker defaultConstructorMarker) {
        this(str);
    }
}
