package androidx.core.app;

import android.annotation.SuppressLint;
import android.app.Notification$BubbleMetadata;
import android.app.PendingIntent;
import android.os.Build$VERSION;
import androidx.annotation.DimenRes;
import androidx.annotation.Dimension;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.RestrictTo$Scope;
import androidx.core.graphics.drawable.IconCompat;

/* JADX INFO: loaded from: classes.dex */
public final class NotificationCompat$BubbleMetadata {
    private static final int FLAG_AUTO_EXPAND_BUBBLE = 1;
    private static final int FLAG_SUPPRESS_NOTIFICATION = 2;
    private PendingIntent mDeleteIntent;
    private int mDesiredHeight;

    @DimenRes
    private int mDesiredHeightResId;
    private int mFlags;
    private IconCompat mIcon;
    private PendingIntent mPendingIntent;
    private String mShortcutId;

    public /* synthetic */ NotificationCompat$BubbleMetadata(PendingIntent pendingIntent, PendingIntent pendingIntent2, IconCompat iconCompat, int i, int i2, int i3, String str, NotificationCompat$1 notificationCompat$1) {
        this(pendingIntent, pendingIntent2, iconCompat, i, i2, i3, str);
    }

    @Nullable
    public static NotificationCompat$BubbleMetadata fromPlatform(@Nullable Notification$BubbleMetadata notification$BubbleMetadata) {
        if (notification$BubbleMetadata == null) {
            return null;
        }
        int i = Build$VERSION.SDK_INT;
        if (i >= 30) {
            return NotificationCompat$BubbleMetadata$Api30Impl.fromPlatform(notification$BubbleMetadata);
        }
        if (i == 29) {
            return NotificationCompat$BubbleMetadata$Api29Impl.fromPlatform(notification$BubbleMetadata);
        }
        return null;
    }

    @Nullable
    public static Notification$BubbleMetadata toPlatform(@Nullable NotificationCompat$BubbleMetadata notificationCompat$BubbleMetadata) {
        if (notificationCompat$BubbleMetadata == null) {
            return null;
        }
        int i = Build$VERSION.SDK_INT;
        if (i >= 30) {
            return NotificationCompat$BubbleMetadata$Api30Impl.toPlatform(notificationCompat$BubbleMetadata);
        }
        if (i == 29) {
            return NotificationCompat$BubbleMetadata$Api29Impl.toPlatform(notificationCompat$BubbleMetadata);
        }
        return null;
    }

    public boolean getAutoExpandBubble() {
        return (this.mFlags & 1) != 0;
    }

    @Nullable
    public PendingIntent getDeleteIntent() {
        return this.mDeleteIntent;
    }

    @Dimension(unit = 0)
    public int getDesiredHeight() {
        return this.mDesiredHeight;
    }

    @DimenRes
    public int getDesiredHeightResId() {
        return this.mDesiredHeightResId;
    }

    @Nullable
    @SuppressLint({"InvalidNullConversion"})
    public IconCompat getIcon() {
        return this.mIcon;
    }

    @Nullable
    @SuppressLint({"InvalidNullConversion"})
    public PendingIntent getIntent() {
        return this.mPendingIntent;
    }

    @Nullable
    public String getShortcutId() {
        return this.mShortcutId;
    }

    public boolean isNotificationSuppressed() {
        return (this.mFlags & 2) != 0;
    }

    @RestrictTo({RestrictTo$Scope.LIBRARY_GROUP_PREFIX})
    public void setFlags(int i) {
        this.mFlags = i;
    }

    private NotificationCompat$BubbleMetadata(@Nullable PendingIntent pendingIntent, @Nullable PendingIntent pendingIntent2, @Nullable IconCompat iconCompat, int i, @DimenRes int i2, int i3, @Nullable String str) {
        this.mPendingIntent = pendingIntent;
        this.mIcon = iconCompat;
        this.mDesiredHeight = i;
        this.mDesiredHeightResId = i2;
        this.mDeleteIntent = pendingIntent2;
        this.mFlags = i3;
        this.mShortcutId = str;
    }
}
