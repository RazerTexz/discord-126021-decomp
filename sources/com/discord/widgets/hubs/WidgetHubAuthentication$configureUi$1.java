package com.discord.widgets.hubs;

import androidx.fragment.app.FragmentActivity;
import b.c.a.a0.d;
import com.discord.R$string;
import com.discord.api.hubs.EmailVerificationCode;
import com.discord.stores.StoreStream;
import com.discord.stores.utilities.Success;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetHubAuthentication.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetHubAuthentication$configureUi$1 extends o implements Function1<Success<? extends EmailVerificationCode>, Unit> {
    public final /* synthetic */ WidgetHubAuthentication this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetHubAuthentication$configureUi$1(WidgetHubAuthentication widgetHubAuthentication) {
        super(1);
        this.this$0 = widgetHubAuthentication;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Success<? extends EmailVerificationCode> success) {
        invoke2((Success<EmailVerificationCode>) success);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Success<EmailVerificationCode> success) {
        m.checkNotNullParameter(success, "response");
        WidgetHubAuthentication widgetHubAuthentication = this.this$0;
        widgetHubAuthentication.hideKeyboard(widgetHubAuthentication.getView());
        EmailVerificationCode emailVerificationCodeInvoke = success.invoke();
        if (!emailVerificationCodeInvoke.getJoined()) {
            b.a.d.m.i(this.this$0, R$string.error_generic_title, 0, 4);
            return;
        }
        FragmentActivity activity = this.this$0.getActivity();
        if (activity != null) {
            activity.setResult(-1, d.g2(new AuthenticationResult(emailVerificationCodeInvoke.getGuild().getId())));
            activity.finish();
        }
        StoreStream.Companion.getNux().updateNux(WidgetHubAuthentication$configureUi$1$1$2.INSTANCE);
    }
}
