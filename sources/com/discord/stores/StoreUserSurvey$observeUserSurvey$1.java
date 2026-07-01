package com.discord.stores;

import com.discord.api.user.UserSurvey;
import d0.z.d.o;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: StoreUserSurvey.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreUserSurvey$observeUserSurvey$1 extends o implements Function0<UserSurvey> {
    public final /* synthetic */ StoreUserSurvey this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreUserSurvey$observeUserSurvey$1(StoreUserSurvey storeUserSurvey) {
        super(0);
        this.this$0 = storeUserSurvey;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ UserSurvey invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final UserSurvey invoke() {
        return StoreUserSurvey.access$getUserSurvey(this.this$0);
    }
}
