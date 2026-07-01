package androidx.core.app;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX INFO: loaded from: classes.dex */
public final class NotificationCompat$Action$WearableExtender implements NotificationCompat$Action$Extender {
    private static final int DEFAULT_FLAGS = 1;
    private static final String EXTRA_WEARABLE_EXTENSIONS = "android.wearable.EXTENSIONS";
    private static final int FLAG_AVAILABLE_OFFLINE = 1;
    private static final int FLAG_HINT_DISPLAY_INLINE = 4;
    private static final int FLAG_HINT_LAUNCHES_ACTIVITY = 2;
    private static final String KEY_CANCEL_LABEL = "cancelLabel";
    private static final String KEY_CONFIRM_LABEL = "confirmLabel";
    private static final String KEY_FLAGS = "flags";
    private static final String KEY_IN_PROGRESS_LABEL = "inProgressLabel";
    private CharSequence mCancelLabel;
    private CharSequence mConfirmLabel;
    private int mFlags;
    private CharSequence mInProgressLabel;

    public NotificationCompat$Action$WearableExtender() {
        this.mFlags = 1;
    }

    private void setFlag(int i, boolean z2) {
        if (z2) {
            this.mFlags = i | this.mFlags;
        } else {
            this.mFlags = (~i) & this.mFlags;
        }
    }

    @NonNull
    /* JADX INFO: renamed from: clone, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m3clone() throws CloneNotSupportedException {
        return clone();
    }

    @Override // androidx.core.app.NotificationCompat$Action$Extender
    @NonNull
    public NotificationCompat$Action$Builder extend(@NonNull NotificationCompat$Action$Builder notificationCompat$Action$Builder) {
        Bundle bundle = new Bundle();
        int i = this.mFlags;
        if (i != 1) {
            bundle.putInt(KEY_FLAGS, i);
        }
        CharSequence charSequence = this.mInProgressLabel;
        if (charSequence != null) {
            bundle.putCharSequence(KEY_IN_PROGRESS_LABEL, charSequence);
        }
        CharSequence charSequence2 = this.mConfirmLabel;
        if (charSequence2 != null) {
            bundle.putCharSequence(KEY_CONFIRM_LABEL, charSequence2);
        }
        CharSequence charSequence3 = this.mCancelLabel;
        if (charSequence3 != null) {
            bundle.putCharSequence(KEY_CANCEL_LABEL, charSequence3);
        }
        notificationCompat$Action$Builder.getExtras().putBundle(EXTRA_WEARABLE_EXTENSIONS, bundle);
        return notificationCompat$Action$Builder;
    }

    @Nullable
    @Deprecated
    public CharSequence getCancelLabel() {
        return this.mCancelLabel;
    }

    @Nullable
    @Deprecated
    public CharSequence getConfirmLabel() {
        return this.mConfirmLabel;
    }

    public boolean getHintDisplayActionInline() {
        return (this.mFlags & 4) != 0;
    }

    public boolean getHintLaunchesActivity() {
        return (this.mFlags & 2) != 0;
    }

    @Nullable
    @Deprecated
    public CharSequence getInProgressLabel() {
        return this.mInProgressLabel;
    }

    public boolean isAvailableOffline() {
        return (this.mFlags & 1) != 0;
    }

    @NonNull
    public NotificationCompat$Action$WearableExtender setAvailableOffline(boolean z2) {
        setFlag(1, z2);
        return this;
    }

    @NonNull
    @Deprecated
    public NotificationCompat$Action$WearableExtender setCancelLabel(@Nullable CharSequence charSequence) {
        this.mCancelLabel = charSequence;
        return this;
    }

    @NonNull
    @Deprecated
    public NotificationCompat$Action$WearableExtender setConfirmLabel(@Nullable CharSequence charSequence) {
        this.mConfirmLabel = charSequence;
        return this;
    }

    @NonNull
    public NotificationCompat$Action$WearableExtender setHintDisplayActionInline(boolean z2) {
        setFlag(4, z2);
        return this;
    }

    @NonNull
    public NotificationCompat$Action$WearableExtender setHintLaunchesActivity(boolean z2) {
        setFlag(2, z2);
        return this;
    }

    @NonNull
    @Deprecated
    public NotificationCompat$Action$WearableExtender setInProgressLabel(@Nullable CharSequence charSequence) {
        this.mInProgressLabel = charSequence;
        return this;
    }

    @NonNull
    public NotificationCompat$Action$WearableExtender clone() {
        NotificationCompat$Action$WearableExtender notificationCompat$Action$WearableExtender = new NotificationCompat$Action$WearableExtender();
        notificationCompat$Action$WearableExtender.mFlags = this.mFlags;
        notificationCompat$Action$WearableExtender.mInProgressLabel = this.mInProgressLabel;
        notificationCompat$Action$WearableExtender.mConfirmLabel = this.mConfirmLabel;
        notificationCompat$Action$WearableExtender.mCancelLabel = this.mCancelLabel;
        return notificationCompat$Action$WearableExtender;
    }

    public NotificationCompat$Action$WearableExtender(@NonNull NotificationCompat$Action notificationCompat$Action) {
        this.mFlags = 1;
        Bundle bundle = notificationCompat$Action.getExtras().getBundle(EXTRA_WEARABLE_EXTENSIONS);
        if (bundle != null) {
            this.mFlags = bundle.getInt(KEY_FLAGS, 1);
            this.mInProgressLabel = bundle.getCharSequence(KEY_IN_PROGRESS_LABEL);
            this.mConfirmLabel = bundle.getCharSequence(KEY_CONFIRM_LABEL);
            this.mCancelLabel = bundle.getCharSequence(KEY_CANCEL_LABEL);
        }
    }
}
