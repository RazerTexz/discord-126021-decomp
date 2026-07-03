package com.discord.widgets.chat.list.entries;

import androidx.appcompat.widget.ActivityChooserModel;
import com.discord.api.message.activity.MessageActivity;
import p001a0.p002a.p003a.C0002b;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: SpotifyListenTogetherEntry.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class SpotifyListenTogetherEntry extends ChatListEntry {
    private final MessageActivity activity;
    private final String key;
    private final long messageId;
    private final int type;
    private final long userId;

    public SpotifyListenTogetherEntry(long j, long j2, MessageActivity messageActivity) {
        C12238m.checkNotNullParameter(messageActivity, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
        this.userId = j;
        this.messageId = j2;
        this.activity = messageActivity;
        this.type = 23;
        this.key = C1643a.m877t("23 -- ", j2);
    }

    public static /* synthetic */ SpotifyListenTogetherEntry copy$default(SpotifyListenTogetherEntry spotifyListenTogetherEntry, long j, long j2, MessageActivity messageActivity, int i, Object obj) {
        if ((i & 1) != 0) {
            j = spotifyListenTogetherEntry.userId;
        }
        long j3 = j;
        if ((i & 2) != 0) {
            j2 = spotifyListenTogetherEntry.messageId;
        }
        long j4 = j2;
        if ((i & 4) != 0) {
            messageActivity = spotifyListenTogetherEntry.activity;
        }
        return spotifyListenTogetherEntry.copy(j3, j4, messageActivity);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final long getUserId() {
        return this.userId;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final long getMessageId() {
        return this.messageId;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final MessageActivity getActivity() {
        return this.activity;
    }

    public final SpotifyListenTogetherEntry copy(long userId, long messageId, MessageActivity activity) {
        C12238m.checkNotNullParameter(activity, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
        return new SpotifyListenTogetherEntry(userId, messageId, activity);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SpotifyListenTogetherEntry)) {
            return false;
        }
        SpotifyListenTogetherEntry spotifyListenTogetherEntry = (SpotifyListenTogetherEntry) other;
        return this.userId == spotifyListenTogetherEntry.userId && this.messageId == spotifyListenTogetherEntry.messageId && C12238m.areEqual(this.activity, spotifyListenTogetherEntry.activity);
    }

    public final MessageActivity getActivity() {
        return this.activity;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload, com.discord.utilities.recycler.DiffKeyProvider
    public String getKey() {
        return this.key;
    }

    public final long getMessageId() {
        return this.messageId;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload
    public int getType() {
        return this.type;
    }

    public final long getUserId() {
        return this.userId;
    }

    public int hashCode() {
        int iM3a = (C0002b.m3a(this.messageId) + (C0002b.m3a(this.userId) * 31)) * 31;
        MessageActivity messageActivity = this.activity;
        return iM3a + (messageActivity != null ? messageActivity.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("SpotifyListenTogetherEntry(userId=");
        sbM833U.append(this.userId);
        sbM833U.append(", messageId=");
        sbM833U.append(this.messageId);
        sbM833U.append(", activity=");
        sbM833U.append(this.activity);
        sbM833U.append(")");
        return sbM833U.toString();
    }
}
