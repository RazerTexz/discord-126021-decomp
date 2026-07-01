package com.discord.stores;

import androidx.core.app.NotificationCompat;
import com.discord.api.auth.RegisterResponse;
import com.discord.restapi.RestAPIParams$AuthRegister;
import com.discord.stores.utilities.RestCallStateKt;
import com.discord.utilities.captcha.CaptchaHelper$CaptchaPayload;
import com.discord.utilities.rest.RestAPI;
import j0.k.b;
import rx.Observable;

/* JADX INFO: compiled from: StoreAuthentication.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreAuthentication$register$1$2<T, R> implements b<StoreAuthentication$AuthRequestParams, Observable<? extends RegisterResponse>> {
    public final /* synthetic */ String $fingerprint;
    public final /* synthetic */ StoreAuthentication$register$1 this$0;

    public StoreAuthentication$register$1$2(StoreAuthentication$register$1 storeAuthentication$register$1, String str) {
        this.this$0 = storeAuthentication$register$1;
        this.$fingerprint = str;
    }

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ Observable<? extends RegisterResponse> call(StoreAuthentication$AuthRequestParams storeAuthentication$AuthRequestParams) {
        return call2(storeAuthentication$AuthRequestParams);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final Observable<? extends RegisterResponse> call2(StoreAuthentication$AuthRequestParams storeAuthentication$AuthRequestParams) {
        StoreInviteSettings$InviteCode inviteCode = storeAuthentication$AuthRequestParams.getInviteCode();
        String inviteCode2 = inviteCode != null ? inviteCode.getInviteCode() : null;
        if (inviteCode2 == null || inviteCode2.length() == 0) {
            StoreStream.Companion.getNux().setPostRegister(true);
        } else {
            StoreStream.Companion.getNux().setPostRegisterWithInvite(true);
        }
        RestAPI api = RestAPI.Companion.getApi();
        String str = this.$fingerprint;
        StoreAuthentication$register$1 storeAuthentication$register$1 = this.this$0;
        String str2 = storeAuthentication$register$1.$username;
        String str3 = storeAuthentication$register$1.$email;
        String str4 = storeAuthentication$register$1.$phoneToken;
        String str5 = storeAuthentication$register$1.$password;
        CaptchaHelper$CaptchaPayload captchaHelper$CaptchaPayload = storeAuthentication$register$1.$captchaPayload;
        String captchaKey = captchaHelper$CaptchaPayload != null ? captchaHelper$CaptchaPayload.getCaptchaKey() : null;
        CaptchaHelper$CaptchaPayload captchaHelper$CaptchaPayload2 = this.this$0.$captchaPayload;
        String captchaRqtoken = captchaHelper$CaptchaPayload2 != null ? captchaHelper$CaptchaPayload2.getCaptchaRqtoken() : null;
        String guildTemplateCode = storeAuthentication$AuthRequestParams.getGuildTemplateCode();
        StoreAuthentication$register$1 storeAuthentication$register$2 = this.this$0;
        return RestCallStateKt.logNetworkAction(api.postAuthRegister(new RestAPIParams$AuthRegister(str, str2, str3, str4, str5, captchaKey, captchaRqtoken, inviteCode2, guildTemplateCode, storeAuthentication$register$2.$consent, storeAuthentication$register$2.$dateOfBirth)), new StoreAuthentication$register$1$2$1(this, inviteCode2));
    }
}
