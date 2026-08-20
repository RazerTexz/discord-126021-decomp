package com.discord.widgets.auth;

import com.discord.stores.StoreStream;
import com.discord.utilities.error.Error;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12215a;
import p507d0.p592z.p594d.C12238m;
import p658rx.Subscription;

/* JADX INFO: compiled from: WidgetAuthLogin.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetAuthLogin$phoneVerifyLoginLauncher$1 extends AbstractC12240o implements Function1<WidgetAuthPhoneVerify.Result, Unit> {
    public final /* synthetic */ WidgetAuthLogin this$0;

    /* JADX INFO: renamed from: com.discord.widgets.auth.WidgetAuthLogin$phoneVerifyLoginLauncher$1$1 */
    /* JADX INFO: compiled from: WidgetAuthLogin.kt */
    public static final /* synthetic */ class C71941 extends C12215a implements Function1<Error, Unit> {
        public C71941(WidgetAuthLogin widgetAuthLogin) {
            super(1, widgetAuthLogin, WidgetAuthLogin.class, "handleError", "handleError(Lcom/discord/utilities/error/Error;Ljava/lang/String;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Error error) {
            invoke2(error);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Error error) {
            C12238m.checkNotNullParameter(error, "p1");
            WidgetAuthLogin.handleError$default((WidgetAuthLogin) this.receiver, error, null, 2, null);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.auth.WidgetAuthLogin$phoneVerifyLoginLauncher$1$2 */
    /* JADX INFO: compiled from: WidgetAuthLogin.kt */
    public static final class C71952 extends AbstractC12240o implements Function1<Void, Unit> {
        public C71952() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Void r1) {
            invoke2(r1);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Void r4) {
            WidgetAuthLogin.login$default(WidgetAuthLogin$phoneVerifyLoginLauncher$1.this.this$0, null, false, 3, null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetAuthLogin$phoneVerifyLoginLauncher$1(WidgetAuthLogin widgetAuthLogin) {
        super(1);
        this.this$0 = widgetAuthLogin;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(WidgetAuthPhoneVerify.Result result) {
        invoke2(result);
        return Unit.f27425a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(WidgetAuthPhoneVerify.Result result) {
        C12238m.checkNotNullParameter(result, "result");
        if (result instanceof WidgetAuthPhoneVerify.Result.Token) {
            ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.withDimmer$default(ObservableExtensionsKt.ui$default(StoreStream.INSTANCE.getAuthentication().authorizeIP(((WidgetAuthPhoneVerify.Result.Token) result).getToken()), this.this$0, null, 2, null), this.this$0.getBinding().f15687h, 0L, 2, null), (Class<?>) this.this$0.getClass(), (58 & 2) != 0 ? null : this.this$0.getContext(), (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : new C71941(this.this$0)), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C71952());
        }
    }
}
