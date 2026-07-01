package com.discord.views.user;

import com.discord.models.user.User;
import com.discord.utilities.streams.StreamContext;
import com.discord.widgets.user.presence.ModelRichPresence;
import d0.z.d.m;
import rx.functions.Func3;

/* JADX INFO: compiled from: UserAvatarPresenceViewController.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class UserAvatarPresenceViewController$a<T1, T2, T3, R> implements Func3<User, ModelRichPresence, StreamContext, UserAvatarPresenceView$a> {
    public static final UserAvatarPresenceViewController$a a = new UserAvatarPresenceViewController$a();

    @Override // rx.functions.Func3
    public UserAvatarPresenceView$a call(User user, ModelRichPresence modelRichPresence, StreamContext streamContext) {
        User user2 = user;
        ModelRichPresence modelRichPresence2 = modelRichPresence;
        StreamContext streamContext2 = streamContext;
        m.checkNotNullExpressionValue(user2, "user");
        return new UserAvatarPresenceView$a(user2, modelRichPresence2 != null ? modelRichPresence2.getPresence() : null, streamContext2, true, null, 16);
    }
}
