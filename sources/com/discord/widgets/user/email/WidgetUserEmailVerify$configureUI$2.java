package com.discord.widgets.user.email;

import android.view.View;
import android.view.View$OnClickListener;
import com.discord.restapi.RestAPIParams$EmptyBody;
import com.discord.stores.utilities.RestCallStateKt;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetUserEmailVerify.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetUserEmailVerify$configureUI$2 implements View$OnClickListener {
    public final /* synthetic */ WidgetUserEmailVerify$Model $model;
    public final /* synthetic */ WidgetUserEmailVerify this$0;

    public WidgetUserEmailVerify$configureUI$2(WidgetUserEmailVerify widgetUserEmailVerify, WidgetUserEmailVerify$Model widgetUserEmailVerify$Model) {
        this.this$0 = widgetUserEmailVerify;
        this.$model = widgetUserEmailVerify$Model;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(RestCallStateKt.logNetworkAction(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.Companion.getApi().postAuthVerifyResend(new RestAPIParams$EmptyBody()), false, 1, null), WidgetUserEmailVerify$configureUI$2$1.INSTANCE), this.this$0, null, 2, null), this.this$0.getClass(), this.this$0.getContext(), (Function1) null, (Function1) null, (Function0) null, (Function0) null, new WidgetUserEmailVerify$configureUI$2$2(this), 60, (Object) null);
    }
}
