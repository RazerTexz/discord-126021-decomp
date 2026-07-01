package com.discord.widgets.user.phone;

import androidx.core.app.NotificationCompat;
import com.discord.models.domain.ModelPhoneVerificationToken;
import rx.functions.Action1;

/* JADX INFO: compiled from: WidgetUserPhoneVerify.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetUserPhoneVerify$handleCodeEntered$2<T> implements Action1<ModelPhoneVerificationToken> {
    public final /* synthetic */ WidgetUserPhoneVerify this$0;

    public WidgetUserPhoneVerify$handleCodeEntered$2(WidgetUserPhoneVerify widgetUserPhoneVerify) {
        this.this$0 = widgetUserPhoneVerify;
    }

    @Override // rx.functions.Action1
    public /* bridge */ /* synthetic */ void call(ModelPhoneVerificationToken modelPhoneVerificationToken) {
        call2(modelPhoneVerificationToken);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final void call2(ModelPhoneVerificationToken modelPhoneVerificationToken) {
        WidgetUserPhoneVerify.access$handleCodeReceived(this.this$0, modelPhoneVerificationToken.getToken());
    }
}
