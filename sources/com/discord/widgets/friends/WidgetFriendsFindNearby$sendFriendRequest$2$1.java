package com.discord.widgets.friends;

import android.content.Context;
import com.discord.utilities.error.Error;
import com.discord.utilities.error.Error$Response;
import com.discord.utilities.rest.RestAPIAbortMessages$ResponseResolver;
import com.discord.utilities.user.UserUtils;
import com.discord.widgets.captcha.WidgetCaptchaKt;
import com.discord.widgets.chat.input.MentionUtilsKt;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: WidgetFriendsFindNearby.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetFriendsFindNearby$sendFriendRequest$2$1 extends o implements Function0<Unit> {
    public final /* synthetic */ Error $error;
    public final /* synthetic */ WidgetFriendsFindNearby$sendFriendRequest$2 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetFriendsFindNearby$sendFriendRequest$2$1(WidgetFriendsFindNearby$sendFriendRequest$2 widgetFriendsFindNearby$sendFriendRequest$2, Error error) {
        super(0);
        this.this$0 = widgetFriendsFindNearby$sendFriendRequest$2;
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
            WidgetFriendsFindNearby widgetFriendsFindNearby = this.this$0.this$0;
            Error error2 = this.$error;
            m.checkNotNullExpressionValue(error2, "error");
            WidgetFriendsFindNearby.access$launchCaptchaFlow(widgetFriendsFindNearby, error2);
            return;
        }
        RestAPIAbortMessages$ResponseResolver restAPIAbortMessages$ResponseResolver = RestAPIAbortMessages$ResponseResolver.INSTANCE;
        Context context = this.this$0.this$0.getContext();
        Error error3 = this.$error;
        m.checkNotNullExpressionValue(error3, "error");
        Error$Response response = error3.getResponse();
        m.checkNotNullExpressionValue(response, "error.response");
        b.a.d.m.h(this.this$0.this$0.getContext(), restAPIAbortMessages$ResponseResolver.getRelationshipResponse(context, response.getCode(), this.this$0.$username + MentionUtilsKt.CHANNELS_CHAR + UserUtils.INSTANCE.padDiscriminator(this.this$0.$discriminator)), 0, null, 12);
    }
}
