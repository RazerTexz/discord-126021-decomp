package com.discord.widgets.chat.list.entries;

import androidx.core.app.NotificationCompat$MessagingStyle$Message;
import b.d.b.a.a;
import d0.z.d.m;

/* JADX INFO: compiled from: EmptyPinsEntry.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class EmptyPinsEntry extends ChatListEntry {
    private final String key;
    private final String text;
    private final int type;

    public EmptyPinsEntry(String str) {
        m.checkNotNullParameter(str, NotificationCompat$MessagingStyle$Message.KEY_TEXT);
        this.text = str;
        this.type = 16;
        this.key = String.valueOf(getType());
    }

    public static /* synthetic */ EmptyPinsEntry copy$default(EmptyPinsEntry emptyPinsEntry, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = emptyPinsEntry.text;
        }
        return emptyPinsEntry.copy(str);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getText() {
        return this.text;
    }

    public final EmptyPinsEntry copy(String text) {
        m.checkNotNullParameter(text, NotificationCompat$MessagingStyle$Message.KEY_TEXT);
        return new EmptyPinsEntry(text);
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof EmptyPinsEntry) && m.areEqual(this.text, ((EmptyPinsEntry) other).text);
        }
        return true;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload, com.discord.utilities.recycler.DiffKeyProvider
    public String getKey() {
        return this.key;
    }

    public final String getText() {
        return this.text;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload
    public int getType() {
        return this.type;
    }

    public int hashCode() {
        String str = this.text;
        if (str != null) {
            return str.hashCode();
        }
        return 0;
    }

    public String toString() {
        return a.J(a.U("EmptyPinsEntry(text="), this.text, ")");
    }
}
