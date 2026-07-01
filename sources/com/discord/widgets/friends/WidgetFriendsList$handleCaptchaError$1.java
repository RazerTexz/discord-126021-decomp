package com.discord.widgets.friends;

import com.discord.app.AppFragment;
import com.discord.utilities.captcha.CaptchaHelper$CaptchaPayload;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: WidgetFriendsList.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetFriendsList$handleCaptchaError$1 extends o implements Function2<AppFragment, CaptchaHelper$CaptchaPayload, Unit> {
    public final /* synthetic */ FriendsListViewModel$Event$CaptchaError $event;
    public final /* synthetic */ WidgetFriendsList this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetFriendsList$handleCaptchaError$1(WidgetFriendsList widgetFriendsList, FriendsListViewModel$Event$CaptchaError friendsListViewModel$Event$CaptchaError) {
        super(2);
        this.this$0 = widgetFriendsList;
        this.$event = friendsListViewModel$Event$CaptchaError;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(AppFragment appFragment, CaptchaHelper$CaptchaPayload captchaHelper$CaptchaPayload) {
        invoke2(appFragment, captchaHelper$CaptchaPayload);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(AppFragment appFragment, CaptchaHelper$CaptchaPayload captchaHelper$CaptchaPayload) {
        m.checkNotNullParameter(appFragment, "<anonymous parameter 0>");
        m.checkNotNullParameter(captchaHelper$CaptchaPayload, "captchaPayload");
        WidgetFriendsList.access$getViewModel$p(this.this$0).acceptFriendSuggestion(this.$event.getUsername(), this.$event.getDiscriminator(), captchaHelper$CaptchaPayload);
    }
}
