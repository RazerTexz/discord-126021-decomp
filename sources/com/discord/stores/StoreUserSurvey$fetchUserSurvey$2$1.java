package com.discord.stores;

import com.discord.api.user.UserSurveyFetchResponse;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: StoreUserSurvey.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreUserSurvey$fetchUserSurvey$2$1 extends o implements Function0<Unit> {
    public final /* synthetic */ UserSurveyFetchResponse $res;
    public final /* synthetic */ StoreUserSurvey$fetchUserSurvey$2 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreUserSurvey$fetchUserSurvey$2$1(StoreUserSurvey$fetchUserSurvey$2 storeUserSurvey$fetchUserSurvey$2, UserSurveyFetchResponse userSurveyFetchResponse) {
        super(0);
        this.this$0 = storeUserSurvey$fetchUserSurvey$2;
        this.$res = userSurveyFetchResponse;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        StoreUserSurvey.access$handleUserSurveyFetchSuccess(this.this$0.this$0, this.$res);
    }
}
