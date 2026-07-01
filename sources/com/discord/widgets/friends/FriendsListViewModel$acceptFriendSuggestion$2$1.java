package com.discord.widgets.friends;

import com.discord.utilities.error.Error;
import com.discord.widgets.captcha.WidgetCaptchaKt;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: FriendsListViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class FriendsListViewModel$acceptFriendSuggestion$2$1 extends o implements Function0<Unit> {
    public final /* synthetic */ Error $error;
    public final /* synthetic */ FriendsListViewModel$acceptFriendSuggestion$2 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FriendsListViewModel$acceptFriendSuggestion$2$1(FriendsListViewModel$acceptFriendSuggestion$2 friendsListViewModel$acceptFriendSuggestion$2, Error error) {
        super(0);
        this.this$0 = friendsListViewModel$acceptFriendSuggestion$2;
        this.$error = error;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        if (WidgetCaptchaKt.isCaptchaError(this.$error)) {
            FriendsListViewModel$acceptFriendSuggestion$2 friendsListViewModel$acceptFriendSuggestion$2 = this.this$0;
            FriendsListViewModel.access$emitCaptchaErrorEvent(friendsListViewModel$acceptFriendSuggestion$2.this$0, this.$error, friendsListViewModel$acceptFriendSuggestion$2.$username, friendsListViewModel$acceptFriendSuggestion$2.$discriminator);
        }
    }
}
