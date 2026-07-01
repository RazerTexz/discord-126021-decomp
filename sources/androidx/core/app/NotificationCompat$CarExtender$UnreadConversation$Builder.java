package androidx.core.app;

import android.app.PendingIntent;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class NotificationCompat$CarExtender$UnreadConversation$Builder {
    private long mLatestTimestamp;
    private final List<String> mMessages = new ArrayList();
    private final String mParticipant;
    private PendingIntent mReadPendingIntent;
    private RemoteInput mRemoteInput;
    private PendingIntent mReplyPendingIntent;

    public NotificationCompat$CarExtender$UnreadConversation$Builder(@NonNull String str) {
        this.mParticipant = str;
    }

    @NonNull
    public NotificationCompat$CarExtender$UnreadConversation$Builder addMessage(@Nullable String str) {
        if (str != null) {
            this.mMessages.add(str);
        }
        return this;
    }

    @NonNull
    public NotificationCompat$CarExtender$UnreadConversation build() {
        List<String> list = this.mMessages;
        return new NotificationCompat$CarExtender$UnreadConversation((String[]) list.toArray(new String[list.size()]), this.mRemoteInput, this.mReplyPendingIntent, this.mReadPendingIntent, new String[]{this.mParticipant}, this.mLatestTimestamp);
    }

    @NonNull
    public NotificationCompat$CarExtender$UnreadConversation$Builder setLatestTimestamp(long j) {
        this.mLatestTimestamp = j;
        return this;
    }

    @NonNull
    public NotificationCompat$CarExtender$UnreadConversation$Builder setReadPendingIntent(@Nullable PendingIntent pendingIntent) {
        this.mReadPendingIntent = pendingIntent;
        return this;
    }

    @NonNull
    public NotificationCompat$CarExtender$UnreadConversation$Builder setReplyAction(@Nullable PendingIntent pendingIntent, @Nullable RemoteInput remoteInput) {
        this.mRemoteInput = remoteInput;
        this.mReplyPendingIntent = pendingIntent;
        return this;
    }
}
