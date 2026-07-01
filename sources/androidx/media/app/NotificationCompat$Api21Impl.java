package androidx.media.app;

import android.app.Notification$Builder;
import android.app.Notification$MediaStyle;
import android.media.session.MediaSession$Token;
import android.support.v4.media.session.MediaSessionCompat$Token;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;

/* JADX INFO: loaded from: classes.dex */
@RequiresApi(21)
public class NotificationCompat$Api21Impl {
    private NotificationCompat$Api21Impl() {
    }

    @DoNotInline
    public static Notification$MediaStyle createMediaStyle() {
        return new Notification$MediaStyle();
    }

    @DoNotInline
    public static Notification$MediaStyle fillInMediaStyle(Notification$MediaStyle notification$MediaStyle, int[] iArr, MediaSessionCompat$Token mediaSessionCompat$Token) {
        if (iArr != null) {
            setShowActionsInCompactView(notification$MediaStyle, iArr);
        }
        if (mediaSessionCompat$Token != null) {
            setMediaSession(notification$MediaStyle, (MediaSession$Token) mediaSessionCompat$Token.k);
        }
        return notification$MediaStyle;
    }

    @DoNotInline
    public static void setMediaSession(Notification$MediaStyle notification$MediaStyle, MediaSession$Token mediaSession$Token) {
        notification$MediaStyle.setMediaSession(mediaSession$Token);
    }

    @DoNotInline
    public static void setMediaStyle(Notification$Builder notification$Builder, Notification$MediaStyle notification$MediaStyle) {
        notification$Builder.setStyle(notification$MediaStyle);
    }

    @DoNotInline
    public static void setShowActionsInCompactView(Notification$MediaStyle notification$MediaStyle, int... iArr) {
        notification$MediaStyle.setShowActionsInCompactView(iArr);
    }
}
