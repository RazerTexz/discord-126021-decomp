package com.discord.stores;

import com.discord.utilities.analytics.AnalyticsTracker;
import com.discord.utilities.error.Error;
import com.discord.utilities.error.Error$Response;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: StoreInstantInvites.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreInstantInvites$fetchInviteIfNotLoaded$1$3 extends o implements Function1<Error, Unit> {
    public final /* synthetic */ StoreInstantInvites$fetchInviteIfNotLoaded$1 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreInstantInvites$fetchInviteIfNotLoaded$1$3(StoreInstantInvites$fetchInviteIfNotLoaded$1 storeInstantInvites$fetchInviteIfNotLoaded$1) {
        super(1);
        this.this$0 = storeInstantInvites$fetchInviteIfNotLoaded$1;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Error error) {
        invoke2(error);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Error error) {
        m.checkNotNullParameter(error, "error");
        Function0 function0 = this.this$0.$onError;
        if (function0 != null) {
        }
        int iOrdinal = error.getType().ordinal();
        if (iOrdinal != 3) {
            if (iOrdinal != 11) {
                return;
            }
            StoreInstantInvites.access$getDispatcher$p(this.this$0.this$0).schedule(new StoreInstantInvites$fetchInviteIfNotLoaded$1$3$2(this));
            return;
        }
        error.setShowErrorToasts(false);
        StoreInstantInvites.access$getDispatcher$p(this.this$0.this$0).schedule(new StoreInstantInvites$fetchInviteIfNotLoaded$1$3$1(this));
        StoreInstantInvites$fetchInviteIfNotLoaded$1 storeInstantInvites$fetchInviteIfNotLoaded$1 = this.this$0;
        String str = storeInstantInvites$fetchInviteIfNotLoaded$1.$location;
        if (str != null) {
            String str2 = storeInstantInvites$fetchInviteIfNotLoaded$1.$inviteCode;
            Error$Response response = error.getResponse();
            m.checkNotNullExpressionValue(response, "error.response");
            String message = response.getMessage();
            Error$Response response2 = error.getResponse();
            m.checkNotNullExpressionValue(response2, "error.response");
            AnalyticsTracker.inviteResolveFailed(str2, str, message, Integer.valueOf(response2.getCode()));
        }
    }
}
