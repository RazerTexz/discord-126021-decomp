package com.discord.widgets.user.search;

import com.discord.models.user.User;
import com.discord.utilities.user.UserUtils;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: ViewGlobalSearchItem.kt */
/* JADX INFO: loaded from: classes.dex */
public final class ViewGlobalSearchItem$onConfigure$2 extends o implements Function1<User, CharSequence> {
    public final /* synthetic */ int $discrimColor;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ViewGlobalSearchItem$onConfigure$2(int i) {
        super(1);
        this.$discrimColor = i;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ CharSequence invoke(User user) {
        return invoke2(user);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final CharSequence invoke2(User user) {
        m.checkNotNullParameter(user, "user");
        return UserUtils.INSTANCE.getUserNameWithDiscriminator(user, Integer.valueOf(this.$discrimColor), Float.valueOf(0.75f));
    }
}
