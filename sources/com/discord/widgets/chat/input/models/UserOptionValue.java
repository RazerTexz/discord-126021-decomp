package com.discord.widgets.chat.input.models;

import com.discord.models.user.User;
import d0.z.d.m;

/* JADX INFO: compiled from: CommandOptionValue.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class UserOptionValue extends CommandOptionValue {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UserOptionValue(User user) {
        super(String.valueOf(user.getId()), null);
        m.checkNotNullParameter(user, "user");
    }
}
