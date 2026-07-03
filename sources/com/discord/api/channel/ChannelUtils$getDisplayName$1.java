package com.discord.api.channel;

import com.discord.api.user.User;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: ChannelUtils.kt */
/* JADX INFO: loaded from: classes.dex */
public final class ChannelUtils$getDisplayName$1 extends AbstractC12240o implements Function1<User, CharSequence> {
    public static final ChannelUtils$getDisplayName$1 INSTANCE = new ChannelUtils$getDisplayName$1();

    public ChannelUtils$getDisplayName$1() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public CharSequence invoke(User user) {
        User user2 = user;
        C12238m.checkNotNullParameter(user2, "it");
        return user2.getUsername();
    }
}
