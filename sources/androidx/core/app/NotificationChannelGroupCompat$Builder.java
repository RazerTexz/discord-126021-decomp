package androidx.core.app;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX INFO: loaded from: classes.dex */
public class NotificationChannelGroupCompat$Builder {
    public final NotificationChannelGroupCompat mGroup;

    public NotificationChannelGroupCompat$Builder(@NonNull String str) {
        this.mGroup = new NotificationChannelGroupCompat(str);
    }

    @NonNull
    public NotificationChannelGroupCompat build() {
        return this.mGroup;
    }

    @NonNull
    public NotificationChannelGroupCompat$Builder setDescription(@Nullable String str) {
        this.mGroup.mDescription = str;
        return this;
    }

    @NonNull
    public NotificationChannelGroupCompat$Builder setName(@Nullable CharSequence charSequence) {
        this.mGroup.mName = charSequence;
        return this;
    }
}
