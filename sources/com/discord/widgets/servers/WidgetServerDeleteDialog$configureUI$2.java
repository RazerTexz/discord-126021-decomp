package com.discord.widgets.servers;

import android.view.View;
import android.view.View$OnClickListener;
import b.a.d.o;
import com.discord.restapi.RestAPIParams$DeleteGuild;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.google.android.material.textfield.TextInputLayout;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetServerDeleteDialog.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerDeleteDialog$configureUI$2 implements View$OnClickListener {
    public final /* synthetic */ WidgetServerDeleteDialog$Model $this_configureUI;
    public final /* synthetic */ WidgetServerDeleteDialog this$0;

    public WidgetServerDeleteDialog$configureUI$2(WidgetServerDeleteDialog widgetServerDeleteDialog, WidgetServerDeleteDialog$Model widgetServerDeleteDialog$Model) {
        this.this$0 = widgetServerDeleteDialog;
        this.$this_configureUI = widgetServerDeleteDialog$Model;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        RestAPI api = RestAPI.Companion.getApi();
        long id2 = this.$this_configureUI.getGuild().getId();
        TextInputLayout textInputLayout = WidgetServerDeleteDialog.access$getBinding$p(this.this$0).e;
        m.checkNotNullExpressionValue(textInputLayout, "binding.serverSettingsDeleteServerMfaCode");
        ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(api.deleteGuild(id2, new RestAPIParams$DeleteGuild(ViewExtensions.getTextOrEmpty(textInputLayout))), false, 1, null), this.this$0, null, 2, null).k(o.j(new WidgetServerDeleteDialog$configureUI$2$1(this), this.this$0.getContext(), null, 4));
    }
}
