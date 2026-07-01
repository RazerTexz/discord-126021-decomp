package com.discord.widgets.friends;

import d0.z.d.Lambda;
import kotlin.jvm.functions.Function0;

/* JADX INFO: renamed from: com.discord.widgets.friends.WidgetFriendsList$viewModel$2, reason: use source file name */
/* JADX INFO: compiled from: WidgetFriendsList.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetFriendsList4 extends Lambda implements Function0<FriendsListViewModel> {
    public static final WidgetFriendsList4 INSTANCE = new WidgetFriendsList4();

    public WidgetFriendsList4() {
        super(0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final FriendsListViewModel invoke() {
        return new FriendsListViewModel(null, null, null, 7, null);
    }
}
