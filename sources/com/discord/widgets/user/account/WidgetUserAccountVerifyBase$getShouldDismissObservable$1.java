package com.discord.widgets.user.account;

import androidx.core.app.NotificationCompat;
import com.discord.models.requiredaction.RequiredAction;
import com.discord.models.user.MeUser;
import com.discord.utilities.user.UserUtils;
import d0.z.d.m;
import rx.functions.Func2;

/* JADX INFO: compiled from: WidgetUserAccountVerifyBase.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetUserAccountVerifyBase$getShouldDismissObservable$1<T1, T2, R> implements Func2<RequiredAction, MeUser, Boolean> {
    public final /* synthetic */ WidgetUserAccountVerifyBase this$0;

    public WidgetUserAccountVerifyBase$getShouldDismissObservable$1(WidgetUserAccountVerifyBase widgetUserAccountVerifyBase) {
        this.this$0 = widgetUserAccountVerifyBase;
    }

    @Override // rx.functions.Func2
    public /* bridge */ /* synthetic */ Boolean call(RequiredAction requiredAction, MeUser meUser) {
        return call2(requiredAction, meUser);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x001a  */
    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final Boolean call2(RequiredAction requiredAction, MeUser meUser) {
        boolean z2;
        if (this.this$0.getIsPhoneAllowed()) {
            UserUtils userUtils = UserUtils.INSTANCE;
            m.checkNotNullExpressionValue(meUser, "me");
            if (userUtils.getHasPhone(meUser)) {
                z2 = false;
            } else {
                z2 = true;
            }
        } else {
            z2 = false;
        }
        boolean z3 = this.this$0.getIsEmailAllowed() && !meUser.isVerified();
        WidgetUserAccountVerifyBase widgetUserAccountVerifyBase = this.this$0;
        m.checkNotNullExpressionValue(requiredAction, "requiredAction");
        return Boolean.valueOf(WidgetUserAccountVerifyBase.access$computeShouldDismiss(widgetUserAccountVerifyBase, z2, z3, requiredAction));
    }
}
