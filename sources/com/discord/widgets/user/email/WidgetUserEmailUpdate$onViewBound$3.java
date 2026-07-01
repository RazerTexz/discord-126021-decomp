package com.discord.widgets.user.email;

import android.view.View;
import android.view.View$OnClickListener;
import b.a.d.o;
import com.discord.restapi.RestAPIParams$UserInfo;
import com.discord.restapi.RestAPIParams$UserInfo$Companion;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.google.android.material.textfield.TextInputLayout;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetUserEmailUpdate.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetUserEmailUpdate$onViewBound$3 implements View$OnClickListener {
    public final /* synthetic */ WidgetUserEmailUpdate this$0;

    public WidgetUserEmailUpdate$onViewBound$3(WidgetUserEmailUpdate widgetUserEmailUpdate) {
        this.this$0 = widgetUserEmailUpdate;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        RestAPI api = RestAPI.Companion.getApi();
        RestAPIParams$UserInfo$Companion restAPIParams$UserInfo$Companion = RestAPIParams$UserInfo.Companion;
        TextInputLayout textInputLayout = WidgetUserEmailUpdate.access$getBinding$p(this.this$0).c;
        m.checkNotNullExpressionValue(textInputLayout, "binding.alertVerifyEmailChangeEmail");
        String textOrEmpty = ViewExtensions.getTextOrEmpty(textInputLayout);
        TextInputLayout textInputLayout2 = WidgetUserEmailUpdate.access$getBinding$p(this.this$0).d;
        m.checkNotNullExpressionValue(textInputLayout2, "binding.alertVerifyEmailChangePassword");
        ObservableExtensionsKt.ui$default(ObservableExtensionsKt.withDimmer$default(ObservableExtensionsKt.restSubscribeOn$default(api.patchUser(restAPIParams$UserInfo$Companion.createForEmail(textOrEmpty, ViewExtensions.getTextOrEmpty(textInputLayout2))), false, 1, null), WidgetUserEmailUpdate.access$getBinding$p(this.this$0).e, 0L, 2, null), this.this$0, null, 2, null).k(o.i(new WidgetUserEmailUpdate$onViewBound$3$1(this), this.this$0));
    }
}
