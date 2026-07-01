package com.discord.widgets.friends;

import d0.z.d.k;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetFriendsList.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetFriendsList$onViewBound$11 extends k implements Function1<Long, Unit> {
    public WidgetFriendsList$onViewBound$11(FriendsListViewModel friendsListViewModel) {
        super(1, friendsListViewModel, FriendsListViewModel.class, "ignoreSuggestion", "ignoreSuggestion(J)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Long l) {
        invoke(l.longValue());
        return Unit.a;
    }

    public final void invoke(long j) {
        ((FriendsListViewModel) this.receiver).ignoreSuggestion(j);
    }
}
