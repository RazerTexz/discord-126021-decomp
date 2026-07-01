package androidx.core.app;

import android.app.PendingIntent;
import androidx.annotation.Nullable;

/* JADX INFO: loaded from: classes.dex */
@Deprecated
public class NotificationCompat$CarExtender$UnreadConversation {
    private final long mLatestTimestamp;
    private final String[] mMessages;
    private final String[] mParticipants;
    private final PendingIntent mReadPendingIntent;
    private final RemoteInput mRemoteInput;
    private final PendingIntent mReplyPendingIntent;

    public NotificationCompat$CarExtender$UnreadConversation(@Nullable String[] strArr, @Nullable RemoteInput remoteInput, @Nullable PendingIntent pendingIntent, @Nullable PendingIntent pendingIntent2, @Nullable String[] strArr2, long j) {
        this.mMessages = strArr;
        this.mRemoteInput = remoteInput;
        this.mReadPendingIntent = pendingIntent2;
        this.mReplyPendingIntent = pendingIntent;
        this.mParticipants = strArr2;
        this.mLatestTimestamp = j;
    }

    public long getLatestTimestamp() {
        return this.mLatestTimestamp;
    }

    @Nullable
    public String[] getMessages() {
        return this.mMessages;
    }

    @Nullable
    public String getParticipant() {
        String[] strArr = this.mParticipants;
        if (strArr.length > 0) {
            return strArr[0];
        }
        return null;
    }

    @Nullable
    public String[] getParticipants() {
        return this.mParticipants;
    }

    @Nullable
    public PendingIntent getReadPendingIntent() {
        return this.mReadPendingIntent;
    }

    @Nullable
    public RemoteInput getRemoteInput() {
        return this.mRemoteInput;
    }

    @Nullable
    public PendingIntent getReplyPendingIntent() {
        return this.mReplyPendingIntent;
    }
}
