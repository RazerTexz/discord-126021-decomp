package com.discord.widgets.channels;

import d0.z.d.Lambda;
import kotlin.jvm.functions.Function1;

/* JADX INFO: renamed from: com.discord.widgets.channels.UserAkaView$configure$1$1, reason: use source file name */
/* JADX INFO: compiled from: UserAkaView.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class UserAkaView2 extends Lambda implements Function1<Integer, String> {
    public final /* synthetic */ String $avatarUrl;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UserAkaView2(String str) {
        super(1);
        this.$avatarUrl = str;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ String invoke(Integer num) {
        return invoke(num.intValue());
    }

    public final String invoke(int i) {
        return this.$avatarUrl;
    }
}
