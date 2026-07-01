package com.discord.widgets.friends;

import com.discord.widgets.user.search.WidgetGlobalSearchModel$ItemUser;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: WidgetFriendsAddUserAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetFriendsAddUserAdapter$ItemUser$Companion {
    private WidgetFriendsAddUserAdapter$ItemUser$Companion() {
    }

    public final WidgetFriendsAddUserAdapter$ItemUser create(WidgetGlobalSearchModel$ItemUser item) {
        m.checkNotNullParameter(item, "item");
        return new WidgetFriendsAddUserAdapter$ItemUser(item.getUser(), item.getAliases(), item.getPresence(), item.isFriend());
    }

    public /* synthetic */ WidgetFriendsAddUserAdapter$ItemUser$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
