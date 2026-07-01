package com.discord.widgets.user.profile;

import androidx.core.app.NotificationCompat;
import androidx.exifinterface.media.ExifInterface;
import j0.k.b;
import java.util.Objects;

/* JADX INFO: compiled from: ObservableExtensions.kt */
/* JADX INFO: loaded from: classes.dex */
public final class UserProfileHeaderView$Companion$bind$$inlined$filterIs$2<T, R> implements b<Object, T> {
    public static final UserProfileHeaderView$Companion$bind$$inlined$filterIs$2 INSTANCE = new UserProfileHeaderView$Companion$bind$$inlined$filterIs$2();

    @Override // j0.k.b
    public final T call(Object obj) {
        Objects.requireNonNull(obj, "null cannot be cast to non-null type com.discord.widgets.user.profile.UserProfileHeaderViewModel.ViewState.Loaded");
        return (T) ((UserProfileHeaderViewModel$ViewState$Loaded) obj);
    }
}
