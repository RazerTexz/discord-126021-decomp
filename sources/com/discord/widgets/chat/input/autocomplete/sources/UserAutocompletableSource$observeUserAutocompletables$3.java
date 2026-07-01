package com.discord.widgets.chat.input.autocomplete.sources;

import androidx.core.app.NotificationCompat;
import com.discord.models.user.User;
import j0.k.b;

/* JADX INFO: compiled from: UserMentionableSource.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class UserAutocompletableSource$observeUserAutocompletables$3<T, R> implements b<User, Long> {
    public static final UserAutocompletableSource$observeUserAutocompletables$3 INSTANCE = new UserAutocompletableSource$observeUserAutocompletables$3();

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ Long call(User user) {
        return call2(user);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final Long call2(User user) {
        return Long.valueOf(user.getId());
    }
}
