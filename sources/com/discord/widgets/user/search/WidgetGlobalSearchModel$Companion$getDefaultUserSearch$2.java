package com.discord.widgets.user.search;

import com.discord.models.user.User;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetGlobalSearchModel.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetGlobalSearchModel$Companion$getDefaultUserSearch$2 extends Lambda implements Function1<User, Boolean> {
    public static final WidgetGlobalSearchModel$Companion$getDefaultUserSearch$2 INSTANCE = new WidgetGlobalSearchModel$Companion$getDefaultUserSearch$2();

    public WidgetGlobalSearchModel$Companion$getDefaultUserSearch$2() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Boolean invoke(User user) {
        return Boolean.valueOf(invoke2(user));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final boolean invoke2(User user) {
        Intrinsics3.checkNotNullParameter(user, "it");
        return user.isBot();
    }
}
