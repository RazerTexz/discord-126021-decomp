package android.support.v4.media.session;

import android.media.MediaDescription;
import android.media.session.MediaSession$QueueItem;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;

/* JADX INFO: loaded from: classes.dex */
@RequiresApi(21)
public class MediaSessionCompat$QueueItem$b {
    @DoNotInline
    public static MediaSession$QueueItem a(MediaDescription mediaDescription, long j) {
        return new MediaSession$QueueItem(mediaDescription, j);
    }

    @DoNotInline
    public static MediaDescription b(MediaSession$QueueItem mediaSession$QueueItem) {
        return mediaSession$QueueItem.getDescription();
    }

    @DoNotInline
    public static long c(MediaSession$QueueItem mediaSession$QueueItem) {
        return mediaSession$QueueItem.getQueueId();
    }
}
