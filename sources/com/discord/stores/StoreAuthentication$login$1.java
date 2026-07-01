package com.discord.stores;

import androidx.core.app.NotificationCompat;
import com.discord.models.domain.auth.ModelLoginResult;
import com.discord.restapi.RestAPIParams$AuthLogin;
import com.discord.stores.utilities.RestCallStateKt;
import com.discord.utilities.captcha.CaptchaHelper$CaptchaPayload;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import j0.k.b;
import rx.Observable;

/* JADX INFO: compiled from: StoreAuthentication.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreAuthentication$login$1<T, R> implements b<String, Observable<? extends ModelLoginResult>> {
    public final /* synthetic */ CaptchaHelper$CaptchaPayload $captchaPayload;
    public final /* synthetic */ String $login;
    public final /* synthetic */ String $loginSource;
    public final /* synthetic */ String $password;
    public final /* synthetic */ boolean $undelete;

    public StoreAuthentication$login$1(String str, String str2, CaptchaHelper$CaptchaPayload captchaHelper$CaptchaPayload, boolean z2, String str3) {
        this.$login = str;
        this.$password = str2;
        this.$captchaPayload = captchaHelper$CaptchaPayload;
        this.$undelete = z2;
        this.$loginSource = str3;
    }

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ Observable<? extends ModelLoginResult> call(String str) {
        return call2(str);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final Observable<? extends ModelLoginResult> call2(String str) {
        RestAPI api = RestAPI.Companion.getApi();
        String str2 = this.$login;
        String str3 = this.$password;
        CaptchaHelper$CaptchaPayload captchaHelper$CaptchaPayload = this.$captchaPayload;
        String captchaKey = captchaHelper$CaptchaPayload != null ? captchaHelper$CaptchaPayload.getCaptchaKey() : null;
        CaptchaHelper$CaptchaPayload captchaHelper$CaptchaPayload2 = this.$captchaPayload;
        return RestCallStateKt.logNetworkAction(ObservableExtensionsKt.restSubscribeOn$default(api.postAuthLogin(new RestAPIParams$AuthLogin(str2, str3, captchaKey, captchaHelper$CaptchaPayload2 != null ? captchaHelper$CaptchaPayload2.getCaptchaRqtoken() : null, Boolean.valueOf(this.$undelete), this.$loginSource)), false, 1, null), StoreAuthentication$login$1$1.INSTANCE);
    }
}
