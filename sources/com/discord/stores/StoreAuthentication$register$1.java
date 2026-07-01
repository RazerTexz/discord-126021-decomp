package com.discord.stores;

import androidx.core.app.NotificationCompat;
import com.discord.api.auth.RegisterResponse;
import com.discord.utilities.captcha.CaptchaHelper$CaptchaPayload;
import com.discord.utilities.rx.ObservableExtensionsKt;
import d0.z.d.m;
import j0.k.b;
import rx.Observable;
import rx.functions.Func2;

/* JADX INFO: compiled from: StoreAuthentication.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreAuthentication$register$1<T, R> implements b<String, Observable<? extends RegisterResponse>> {
    public final /* synthetic */ CaptchaHelper$CaptchaPayload $captchaPayload;
    public final /* synthetic */ boolean $consent;
    public final /* synthetic */ String $dateOfBirth;
    public final /* synthetic */ String $email;
    public final /* synthetic */ String $password;
    public final /* synthetic */ String $phoneToken;
    public final /* synthetic */ String $username;
    public final /* synthetic */ StoreAuthentication this$0;

    public StoreAuthentication$register$1(StoreAuthentication storeAuthentication, String str, String str2, String str3, String str4, CaptchaHelper$CaptchaPayload captchaHelper$CaptchaPayload, boolean z2, String str5) {
        this.this$0 = storeAuthentication;
        this.$username = str;
        this.$email = str2;
        this.$phoneToken = str3;
        this.$password = str4;
        this.$captchaPayload = captchaHelper$CaptchaPayload;
        this.$consent = z2;
        this.$dateOfBirth = str5;
    }

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ Observable<? extends RegisterResponse> call(String str) {
        return call2(str);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final Observable<? extends RegisterResponse> call2(String str) {
        StoreStream$Companion storeStream$Companion = StoreStream.Companion;
        Observable<StoreInviteSettings$InviteCode> inviteCode = storeStream$Companion.getInviteSettings().getInviteCode();
        Observable<String> observableObserveDynamicLinkGuildTemplateCode = storeStream$Companion.getGuildTemplates().observeDynamicLinkGuildTemplateCode();
        StoreAuthentication$register$1$1 storeAuthentication$register$1$1 = StoreAuthentication$register$1$1.INSTANCE;
        Object storeAuthentication$sam$rx_functions_Func2$0 = storeAuthentication$register$1$1;
        if (storeAuthentication$register$1$1 != null) {
            storeAuthentication$sam$rx_functions_Func2$0 = new StoreAuthentication$sam$rx_functions_Func2$0(storeAuthentication$register$1$1);
        }
        Observable observableJ = Observable.j(inviteCode, observableObserveDynamicLinkGuildTemplateCode, (Func2) storeAuthentication$sam$rx_functions_Func2$0);
        m.checkNotNullExpressionValue(observableJ, "Observable.combineLatest…RequestParams\n          )");
        Observable<R> observableA = ObservableExtensionsKt.takeSingleUntilTimeout$default(observableJ, 500L, false, 2, null).A(new StoreAuthentication$register$1$2(this, str));
        m.checkNotNullExpressionValue(observableA, "Observable.combineLatest…        }\n              }");
        return ObservableExtensionsKt.takeSingleUntilTimeout$default(ObservableExtensionsKt.restSubscribeOn$default(observableA, false, 1, null), 0L, false, 3, null).u(new StoreAuthentication$register$1$3(this));
    }
}
