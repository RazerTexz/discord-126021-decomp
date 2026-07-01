package com.discord.stores;

import com.discord.api.auth.RequiredAction;
import com.discord.models.authentication.AuthState;
import d0.t.n0;
import d0.t.o0;
import d0.z.d.o;
import java.util.Set;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: StoreAuthentication.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreAuthentication$onPasswordChanged$1 extends o implements Function0<Unit> {
    public final /* synthetic */ String $token;
    public final /* synthetic */ StoreAuthentication this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreAuthentication$onPasswordChanged$1(StoreAuthentication storeAuthentication, String str) {
        super(0);
        this.this$0 = storeAuthentication;
        this.$token = str;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        Set<RequiredAction> setEmptySet;
        AuthState authState = this.this$0.getAuthState();
        if (authState == null || (setEmptySet = authState.getRequiredActions()) == null) {
            setEmptySet = n0.emptySet();
        }
        StoreAuthentication.access$publishAuthState(this.this$0, AuthState.Companion.from(this.$token, o0.minus(setEmptySet, RequiredAction.UPDATE_PASSWORD)));
    }
}
