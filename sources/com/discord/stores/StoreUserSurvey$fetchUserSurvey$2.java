package com.discord.stores;

import com.discord.api.user.UserSurveyFetchResponse;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: StoreUserSurvey.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreUserSurvey$fetchUserSurvey$2 extends o implements Function1<UserSurveyFetchResponse, Unit> {
    public final /* synthetic */ StoreUserSurvey this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreUserSurvey$fetchUserSurvey$2(StoreUserSurvey storeUserSurvey) {
        super(1);
        this.this$0 = storeUserSurvey;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(UserSurveyFetchResponse userSurveyFetchResponse) {
        invoke2(userSurveyFetchResponse);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(UserSurveyFetchResponse userSurveyFetchResponse) {
        m.checkNotNullParameter(userSurveyFetchResponse, "res");
        StoreUserSurvey.access$getDispatcher$p(this.this$0).schedule(new StoreUserSurvey$fetchUserSurvey$2$1(this, userSurveyFetchResponse));
    }
}
