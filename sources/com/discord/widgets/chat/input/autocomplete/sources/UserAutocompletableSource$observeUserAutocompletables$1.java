package com.discord.widgets.chat.input.autocomplete.sources;

import androidx.core.app.NotificationCompat;
import com.discord.models.guild.Guild;
import j0.k.b;

/* JADX INFO: compiled from: UserMentionableSource.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class UserAutocompletableSource$observeUserAutocompletables$1<T, R> implements b<Guild, Long> {
    public static final UserAutocompletableSource$observeUserAutocompletables$1 INSTANCE = new UserAutocompletableSource$observeUserAutocompletables$1();

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ Long call(Guild guild) {
        return call2(guild);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final Long call2(Guild guild) {
        return Long.valueOf(guild.getOwnerId());
    }
}
