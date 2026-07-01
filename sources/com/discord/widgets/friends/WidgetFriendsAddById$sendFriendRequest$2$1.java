package com.discord.widgets.friends;

import android.content.Context;
import com.discord.utilities.error.Error;
import com.discord.utilities.error.Error$Response;
import com.discord.utilities.rest.RestAPIAbortMessages$ResponseResolver;
import com.discord.utilities.user.UserUtils;
import com.discord.widgets.captcha.WidgetCaptchaKt;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: WidgetFriendsAddById.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetFriendsAddById$sendFriendRequest$2$1 extends o implements Function0<Unit> {
    public final /* synthetic */ Error $error;
    public final /* synthetic */ WidgetFriendsAddById$sendFriendRequest$2 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetFriendsAddById$sendFriendRequest$2$1(WidgetFriendsAddById$sendFriendRequest$2 widgetFriendsAddById$sendFriendRequest$2, Error error) {
        super(0);
        this.this$0 = widgetFriendsAddById$sendFriendRequest$2;
        this.$error = error;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        Error error = this.$error;
        m.checkNotNullExpressionValue(error, "error");
        if (WidgetCaptchaKt.isCaptchaError(error)) {
            WidgetFriendsAddById widgetFriendsAddById = this.this$0.this$0;
            Error error2 = this.$error;
            m.checkNotNullExpressionValue(error2, "error");
            WidgetFriendsAddById.access$launchCaptchaFlow(widgetFriendsAddById, error2);
            return;
        }
        WidgetFriendsAddById.access$getBinding$p(this.this$0.this$0).e.setErrorTextAppearance(2131952238);
        RestAPIAbortMessages$ResponseResolver restAPIAbortMessages$ResponseResolver = RestAPIAbortMessages$ResponseResolver.INSTANCE;
        Context context = this.this$0.this$0.getContext();
        Error error3 = this.$error;
        m.checkNotNullExpressionValue(error3, "error");
        Error$Response response = error3.getResponse();
        m.checkNotNullExpressionValue(response, "error.response");
        WidgetFriendsAddById.access$setInputEditError(this.this$0.this$0, String.valueOf(restAPIAbortMessages$ResponseResolver.getRelationshipResponse(context, response.getCode(), this.this$0.$username + UserUtils.INSTANCE.padDiscriminator(this.this$0.$discriminator))));
    }
}
