package com.discord.widgets.tos;

import android.view.View;
import android.view.View$OnClickListener;
import b.a.d.o;
import com.discord.restapi.RestAPIParams$UserAgreements;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;

/* JADX INFO: compiled from: WidgetTos.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetTos$configureCommonTosModalUI$1 implements View$OnClickListener {
    public final /* synthetic */ RestAPIParams$UserAgreements $userAgreementsParam;
    public final /* synthetic */ WidgetTos this$0;

    public WidgetTos$configureCommonTosModalUI$1(WidgetTos widgetTos, RestAPIParams$UserAgreements restAPIParams$UserAgreements) {
        this.this$0 = widgetTos;
        this.$userAgreementsParam = restAPIParams$UserAgreements;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.Companion.getApi().userAgreements(this.$userAgreementsParam), false, 1, null), this.this$0, null, 2, null).k(o.a.g(this.this$0.getContext(), WidgetTos$configureCommonTosModalUI$1$1.INSTANCE, null));
        this.this$0.requireActivity().finish();
    }
}
