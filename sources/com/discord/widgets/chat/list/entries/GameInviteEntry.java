package com.discord.widgets.chat.list.entries;

import a0.a.a.b;
import androidx.appcompat.widget.ActivityChooserModel;
import b.d.b.a.outline;
import com.discord.api.application.Application;
import com.discord.api.message.activity.MessageActivity;
import d0.z.d.Intrinsics3;

/* JADX INFO: compiled from: GameInviteEntry.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class GameInviteEntry extends ChatListEntry {
    private final MessageActivity activity;
    private final Application application;
    private final long authorId;
    private final String key;
    private final long messageId;
    private final int type;

    public GameInviteEntry(long j, long j2, MessageActivity messageActivity, Application application) {
        Intrinsics3.checkNotNullParameter(messageActivity, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
        Intrinsics3.checkNotNullParameter(application, "application");
        this.authorId = j;
        this.messageId = j2;
        this.activity = messageActivity;
        this.application = application;
        this.type = 22;
        this.key = outline.t("22 -- ", j2);
    }

    public static /* synthetic */ GameInviteEntry copy$default(GameInviteEntry gameInviteEntry, long j, long j2, MessageActivity messageActivity, Application application, int i, Object obj) {
        if ((i & 1) != 0) {
            j = gameInviteEntry.authorId;
        }
        long j3 = j;
        if ((i & 2) != 0) {
            j2 = gameInviteEntry.messageId;
        }
        long j4 = j2;
        if ((i & 4) != 0) {
            messageActivity = gameInviteEntry.activity;
        }
        MessageActivity messageActivity2 = messageActivity;
        if ((i & 8) != 0) {
            application = gameInviteEntry.application;
        }
        return gameInviteEntry.copy(j3, j4, messageActivity2, application);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final long getAuthorId() {
        return this.authorId;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final long getMessageId() {
        return this.messageId;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final MessageActivity getActivity() {
        return this.activity;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final Application getApplication() {
        return this.application;
    }

    public final GameInviteEntry copy(long authorId, long messageId, MessageActivity activity, Application application) {
        Intrinsics3.checkNotNullParameter(activity, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
        Intrinsics3.checkNotNullParameter(application, "application");
        return new GameInviteEntry(authorId, messageId, activity, application);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GameInviteEntry)) {
            return false;
        }
        GameInviteEntry gameInviteEntry = (GameInviteEntry) other;
        return this.authorId == gameInviteEntry.authorId && this.messageId == gameInviteEntry.messageId && Intrinsics3.areEqual(this.activity, gameInviteEntry.activity) && Intrinsics3.areEqual(this.application, gameInviteEntry.application);
    }

    public final MessageActivity getActivity() {
        return this.activity;
    }

    public final Application getApplication() {
        return this.application;
    }

    public final long getAuthorId() {
        return this.authorId;
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

    public int hashCode() {
        int iA = (b.a(this.messageId) + (b.a(this.authorId) * 31)) * 31;
        MessageActivity messageActivity = this.activity;
        int iHashCode = (iA + (messageActivity != null ? messageActivity.hashCode() : 0)) * 31;
        Application application = this.application;
        return iHashCode + (application != null ? application.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("GameInviteEntry(authorId=");
        sbU.append(this.authorId);
        sbU.append(", messageId=");
        sbU.append(this.messageId);
        sbU.append(", activity=");
        sbU.append(this.activity);
        sbU.append(", application=");
        sbU.append(this.application);
        sbU.append(")");
        return sbU.toString();
    }
}
