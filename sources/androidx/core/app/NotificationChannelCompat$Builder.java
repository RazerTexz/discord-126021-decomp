package androidx.core.app;

import android.media.AudioAttributes;
import android.net.Uri;
import android.os.Build$VERSION;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX INFO: loaded from: classes.dex */
public class NotificationChannelCompat$Builder {
    private final NotificationChannelCompat mChannel;

    public NotificationChannelCompat$Builder(@NonNull String str, int i) {
        this.mChannel = new NotificationChannelCompat(str, i);
    }

    @NonNull
    public NotificationChannelCompat build() {
        return this.mChannel;
    }

    @NonNull
    public NotificationChannelCompat$Builder setConversationId(@NonNull String str, @NonNull String str2) {
        if (Build$VERSION.SDK_INT >= 30) {
            NotificationChannelCompat notificationChannelCompat = this.mChannel;
            notificationChannelCompat.mParentId = str;
            notificationChannelCompat.mConversationId = str2;
        }
        return this;
    }

    @NonNull
    public NotificationChannelCompat$Builder setDescription(@Nullable String str) {
        this.mChannel.mDescription = str;
        return this;
    }

    @NonNull
    public NotificationChannelCompat$Builder setGroup(@Nullable String str) {
        this.mChannel.mGroupId = str;
        return this;
    }

    @NonNull
    public NotificationChannelCompat$Builder setImportance(int i) {
        this.mChannel.mImportance = i;
        return this;
    }

    @NonNull
    public NotificationChannelCompat$Builder setLightColor(int i) {
        this.mChannel.mLightColor = i;
        return this;
    }

    @NonNull
    public NotificationChannelCompat$Builder setLightsEnabled(boolean z2) {
        this.mChannel.mLights = z2;
        return this;
    }

    @NonNull
    public NotificationChannelCompat$Builder setName(@Nullable CharSequence charSequence) {
        this.mChannel.mName = charSequence;
        return this;
    }

    @NonNull
    public NotificationChannelCompat$Builder setShowBadge(boolean z2) {
        this.mChannel.mShowBadge = z2;
        return this;
    }

    @NonNull
    public NotificationChannelCompat$Builder setSound(@Nullable Uri uri, @Nullable AudioAttributes audioAttributes) {
        NotificationChannelCompat notificationChannelCompat = this.mChannel;
        notificationChannelCompat.mSound = uri;
        notificationChannelCompat.mAudioAttributes = audioAttributes;
        return this;
    }

    @NonNull
    public NotificationChannelCompat$Builder setVibrationEnabled(boolean z2) {
        this.mChannel.mVibrationEnabled = z2;
        return this;
    }

    @NonNull
    public NotificationChannelCompat$Builder setVibrationPattern(@Nullable long[] jArr) {
        NotificationChannelCompat notificationChannelCompat = this.mChannel;
        notificationChannelCompat.mVibrationEnabled = jArr != null && jArr.length > 0;
        notificationChannelCompat.mVibrationPattern = jArr;
        return this;
    }
}
