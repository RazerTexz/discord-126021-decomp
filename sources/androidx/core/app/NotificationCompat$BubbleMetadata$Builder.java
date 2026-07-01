package androidx.core.app;

import android.annotation.SuppressLint;
import android.app.PendingIntent;
import android.text.TextUtils;
import androidx.annotation.DimenRes;
import androidx.annotation.Dimension;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.graphics.drawable.IconCompat;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public final class NotificationCompat$BubbleMetadata$Builder {
    private PendingIntent mDeleteIntent;
    private int mDesiredHeight;

    @DimenRes
    private int mDesiredHeightResId;
    private int mFlags;
    private IconCompat mIcon;
    private PendingIntent mPendingIntent;
    private String mShortcutId;

    @Deprecated
    public NotificationCompat$BubbleMetadata$Builder() {
    }

    @NonNull
    private NotificationCompat$BubbleMetadata$Builder setFlag(int i, boolean z2) {
        if (z2) {
            this.mFlags = i | this.mFlags;
        } else {
            this.mFlags = (~i) & this.mFlags;
        }
        return this;
    }

    @NonNull
    @SuppressLint({"SyntheticAccessor"})
    public NotificationCompat$BubbleMetadata build() {
        String str = this.mShortcutId;
        if (str == null) {
            Objects.requireNonNull(this.mPendingIntent, "Must supply pending intent or shortcut to bubble");
        }
        if (str == null) {
            Objects.requireNonNull(this.mIcon, "Must supply an icon or shortcut for the bubble");
        }
        NotificationCompat$BubbleMetadata notificationCompat$BubbleMetadata = new NotificationCompat$BubbleMetadata(this.mPendingIntent, this.mDeleteIntent, this.mIcon, this.mDesiredHeight, this.mDesiredHeightResId, this.mFlags, str, null);
        notificationCompat$BubbleMetadata.setFlags(this.mFlags);
        return notificationCompat$BubbleMetadata;
    }

    @NonNull
    public NotificationCompat$BubbleMetadata$Builder setAutoExpandBubble(boolean z2) {
        setFlag(1, z2);
        return this;
    }

    @NonNull
    public NotificationCompat$BubbleMetadata$Builder setDeleteIntent(@Nullable PendingIntent pendingIntent) {
        this.mDeleteIntent = pendingIntent;
        return this;
    }

    @NonNull
    public NotificationCompat$BubbleMetadata$Builder setDesiredHeight(@Dimension(unit = 0) int i) {
        this.mDesiredHeight = Math.max(i, 0);
        this.mDesiredHeightResId = 0;
        return this;
    }

    @NonNull
    public NotificationCompat$BubbleMetadata$Builder setDesiredHeightResId(@DimenRes int i) {
        this.mDesiredHeightResId = i;
        this.mDesiredHeight = 0;
        return this;
    }

    @NonNull
    public NotificationCompat$BubbleMetadata$Builder setIcon(@NonNull IconCompat iconCompat) {
        if (this.mShortcutId != null) {
            throw new IllegalStateException("Created as a shortcut bubble, cannot set an Icon. Consider using BubbleMetadata.Builder(PendingIntent,Icon) instead.");
        }
        Objects.requireNonNull(iconCompat, "Bubbles require non-null icon");
        this.mIcon = iconCompat;
        return this;
    }

    @NonNull
    public NotificationCompat$BubbleMetadata$Builder setIntent(@NonNull PendingIntent pendingIntent) {
        if (this.mShortcutId != null) {
            throw new IllegalStateException("Created as a shortcut bubble, cannot set a PendingIntent. Consider using BubbleMetadata.Builder(PendingIntent,Icon) instead.");
        }
        Objects.requireNonNull(pendingIntent, "Bubble requires non-null pending intent");
        this.mPendingIntent = pendingIntent;
        return this;
    }

    @NonNull
    public NotificationCompat$BubbleMetadata$Builder setSuppressNotification(boolean z2) {
        setFlag(2, z2);
        return this;
    }

    @RequiresApi(30)
    public NotificationCompat$BubbleMetadata$Builder(@NonNull String str) {
        if (TextUtils.isEmpty(str)) {
            throw new NullPointerException("Bubble requires a non-null shortcut id");
        }
        this.mShortcutId = str;
    }

    public NotificationCompat$BubbleMetadata$Builder(@NonNull PendingIntent pendingIntent, @NonNull IconCompat iconCompat) {
        Objects.requireNonNull(pendingIntent, "Bubble requires non-null pending intent");
        Objects.requireNonNull(iconCompat, "Bubbles require non-null icon");
        this.mPendingIntent = pendingIntent;
        this.mIcon = iconCompat;
    }
}
