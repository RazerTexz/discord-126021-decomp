package com.discord.widgets.auth;

import com.discord.stores.StoreStream;
import com.discord.utilities.error.Error;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.widgets.auth.WidgetAuthPhoneVerify;
import d0.z.d.AdaptedFunctionReference;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import rx.Subscription;

/* JADX INFO: renamed from: com.discord.widgets.auth.WidgetAuthLogin$phoneVerifyLoginLauncher$1, reason: use source file name */
/* JADX INFO: compiled from: WidgetAuthLogin.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetAuthLogin6 extends Lambda implements Function1<WidgetAuthPhoneVerify.Result, Unit> {
    public final /* synthetic */ WidgetAuthLogin this$0;

    /* JADX INFO: renamed from: com.discord.widgets.auth.WidgetAuthLogin$phoneVerifyLoginLauncher$1$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetAuthLogin.kt */
    public static final /* synthetic */ class AnonymousClass1 extends AdaptedFunctionReference implements Function1<Error, Unit> {
        public AnonymousClass1(WidgetAuthLogin widgetAuthLogin) {
            super(1, widgetAuthLogin, WidgetAuthLogin.class, "handleError", "handleError(Lcom/discord/utilities/error/Error;Ljava/lang/String;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Error error) {
            invoke2(error);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Error error) {
            Intrinsics3.checkNotNullParameter(error, "p1");
            WidgetAuthLogin.handleError$default((WidgetAuthLogin) this.receiver, error, null, 2, null);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.auth.WidgetAuthLogin$phoneVerifyLoginLauncher$1$2, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetAuthLogin.kt */
    public static final class AnonymousClass2 extends Lambda implements Function1<Void, Unit> {
        public AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Void r1) {
            invoke2(r1);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Void r4) {
            WidgetAuthLogin.login$default(WidgetAuthLogin6.this.this$0, null, false, 3, null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetAuthLogin6(WidgetAuthLogin widgetAuthLogin) {
        super(1);
        this.this$0 = widgetAuthLogin;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(WidgetAuthPhoneVerify.Result result) {
        invoke2(result);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(WidgetAuthPhoneVerify.Result result) {
        Intrinsics3.checkNotNullParameter(result, "result");
        if (result instanceof WidgetAuthPhoneVerify.Result.Token) {
            ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.withDimmer$default(ObservableExtensionsKt.ui$default(StoreStream.INSTANCE.getAuthentication().authorizeIP(((WidgetAuthPhoneVerify.Result.Token) result).getToken()), this.this$0, null, 2, null), this.this$0.getBinding().h, 0L, 2, null), (Class<?>) this.this$0.getClass(), (58 & 2) != 0 ? null : this.this$0.getContext(), (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : new AnonymousClass1(this.this$0)), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass2());
        }
    }
}
