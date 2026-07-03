package com.discord.models.commands;

import com.discord.api.user.User;
import com.discord.nullserializable.NullSerializable;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: Application.kt */
/* JADX INFO: loaded from: classes.dex */
public final class ApplicationKt {
    public static final boolean hasBotAvatar(Application application) {
        C12238m.checkNotNullParameter(application, "$this$hasBotAvatar");
        User bot = application.getBot();
        return (bot != null ? bot.m8288a() : null) instanceof NullSerializable.C5566b;
    }
}
