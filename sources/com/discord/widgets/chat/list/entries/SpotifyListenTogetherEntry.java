package com.discord.widgets.chat.list.entries;

import a0.a.a.b;
import androidx.appcompat.widget.ActivityChooserModel;
import b.d.b.a.a;
import com.discord.api.message.activity.MessageActivity;
import d0.z.d.m;

/* JADX INFO: compiled from: SpotifyListenTogetherEntry.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class SpotifyListenTogetherEntry extends ChatListEntry {
    private final MessageActivity activity;
    private final String key;
    private final long messageId;
    private final int type;
    private final long userId;

    public SpotifyListenTogetherEntry(long j, long j2, MessageActivity messageActivity) {
        m.checkNotNullParameter(messageActivity, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
        this.userId = j;
        this.messageId = j2;
        this.activity = messageActivity;
        this.type = 23;
        this.key = a.t("23 -- ", j2);
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
        m.checkNotNullParameter(activity, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
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
        return this.userId == spotifyListenTogetherEntry.userId && this.messageId == spotifyListenTogetherEntry.messageId && m.areEqual(this.activity, spotifyListenTogetherEntry.activity);
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
        int iA = (b.a(this.messageId) + (b.a(this.userId) * 31)) * 31;
        MessageActivity messageActivity = this.activity;
        return iA + (messageActivity != null ? messageActivity.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("SpotifyListenTogetherEntry(userId=");
        sbU.append(this.userId);
        sbU.append(", messageId=");
        sbU.append(this.messageId);
        sbU.append(", activity=");
        sbU.append(this.activity);
        sbU.append(")");
        return sbU.toString();
    }
}
