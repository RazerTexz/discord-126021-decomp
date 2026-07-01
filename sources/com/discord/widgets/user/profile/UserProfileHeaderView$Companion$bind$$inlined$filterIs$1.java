package com.discord.widgets.user.profile;

import androidx.core.app.NotificationCompat;
import androidx.exifinterface.media.ExifInterface;
import j0.k.b;

/* JADX INFO: compiled from: ObservableExtensions.kt */
/* JADX INFO: loaded from: classes.dex */
public final class UserProfileHeaderView$Companion$bind$$inlined$filterIs$1<T, R> implements b<Object, Boolean> {
    public static final UserProfileHeaderView$Companion$bind$$inlined$filterIs$1 INSTANCE = new UserProfileHeaderView$Companion$bind$$inlined$filterIs$1();

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // j0.k.b
    public final Boolean call(Object obj) {
        return Boolean.valueOf(obj instanceof UserProfileHeaderViewModel$ViewState$Loaded);
    }

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ Boolean call(Object obj) {
        return call(obj);
    }
}
