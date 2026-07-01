package com.discord.widgets.servers;

import android.view.View;
import android.view.View$OnClickListener;
import com.discord.restapi.RestAPIParams$TransferGuildOwnership;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import d0.z.d.m;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import rx.Observable;

/* JADX INFO: compiled from: WidgetServerSettingsTransferOwnership.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettingsTransferOwnership$configureUI$3 implements View$OnClickListener {
    public final /* synthetic */ WidgetServerSettingsTransferOwnership$Model $model;
    public final /* synthetic */ WidgetServerSettingsTransferOwnership this$0;

    public WidgetServerSettingsTransferOwnership$configureUI$3(WidgetServerSettingsTransferOwnership widgetServerSettingsTransferOwnership, WidgetServerSettingsTransferOwnership$Model widgetServerSettingsTransferOwnership$Model) {
        this.this$0 = widgetServerSettingsTransferOwnership;
        this.$model = widgetServerSettingsTransferOwnership$Model;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        Observable observableUi$default = ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.Companion.getApi().transferGuildOwnership(this.$model.getGuild().getId(), new RestAPIParams$TransferGuildOwnership(this.$model.getUser().getId(), WidgetServerSettingsTransferOwnership.access$getMfaCode$p(this.this$0))), false, 1, null), this.this$0, null, 2, null);
        Class<?> cls = this.this$0.getClass();
        m.checkNotNullExpressionValue(view, "view");
        ObservableExtensionsKt.appSubscribe$default(observableUi$default, cls, view.getContext(), (Function1) null, (Function1) null, (Function0) null, (Function0) null, new WidgetServerSettingsTransferOwnership$configureUI$3$1(this), 60, (Object) null);
    }
}
