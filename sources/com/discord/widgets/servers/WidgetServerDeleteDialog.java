package com.discord.widgets.servers;

import android.content.Context;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import b.a.k.b;
import b.d.b.a.a;
import com.discord.R$layout;
import com.discord.app.AppDialog;
import com.discord.databinding.WidgetServerDeleteDialogBinding;
import com.discord.models.experiments.domain.Experiment;
import com.discord.stores.StoreStream;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.discord.widgets.guild_delete_feedback.GuildDeleteFeedbackSheetNavigator;
import com.google.android.material.button.MaterialButton;
import d0.z.d.m;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.KProperty;
import rx.Observable;

/* JADX INFO: compiled from: WidgetServerDeleteDialog.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerDeleteDialog extends AppDialog {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {a.d0(WidgetServerDeleteDialog.class, "binding", "getBinding()Lcom/discord/databinding/WidgetServerDeleteDialogBinding;", 0)};
    public static final WidgetServerDeleteDialog$Companion Companion = new WidgetServerDeleteDialog$Companion(null);
    private static final String INTENT_GUILD_ID = "INTENT_GUILD_ID";

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    public WidgetServerDeleteDialog() {
        super(R$layout.widget_server_delete_dialog);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetServerDeleteDialog$binding$2.INSTANCE, null, 2, null);
    }

    public static final /* synthetic */ void access$afterDeleteGuild(WidgetServerDeleteDialog widgetServerDeleteDialog, long j) {
        widgetServerDeleteDialog.afterDeleteGuild(j);
    }

    public static final /* synthetic */ void access$configureUI(WidgetServerDeleteDialog widgetServerDeleteDialog, WidgetServerDeleteDialog$Model widgetServerDeleteDialog$Model) {
        widgetServerDeleteDialog.configureUI(widgetServerDeleteDialog$Model);
    }

    public static final /* synthetic */ WidgetServerDeleteDialogBinding access$getBinding$p(WidgetServerDeleteDialog widgetServerDeleteDialog) {
        return widgetServerDeleteDialog.getBinding();
    }

    private final void afterDeleteGuild(long guildId) {
        dismiss();
        Experiment userExperiment = StoreStream.Companion.getExperiments().getUserExperiment("2020-12_guild_delete_feedback", true);
        if (userExperiment == null || userExperiment.getBucket() != 1) {
            return;
        }
        GuildDeleteFeedbackSheetNavigator.INSTANCE.enqueueNotice(guildId);
    }

    private final void configureUI(WidgetServerDeleteDialog$Model widgetServerDeleteDialog$Model) {
        if (widgetServerDeleteDialog$Model.getGuild() == null) {
            dismiss();
            return;
        }
        TextView textView = getBinding().d;
        m.checkNotNullExpressionValue(textView, "binding.serverSettingsDeleteServerHeader");
        Context context = getContext();
        textView.setText(context != null ? b.h(context, 2131888402, new Object[]{widgetServerDeleteDialog$Model.getGuild().getName()}, null, 4) : null);
        LinearLayout linearLayout = getBinding().f;
        m.checkNotNullExpressionValue(linearLayout, "binding.serverSettingsDeleteServerMfaWrap");
        linearLayout.setVisibility(widgetServerDeleteDialog$Model.getMe().getMfaEnabled() ? 0 : 8);
        TextView textView2 = getBinding().g;
        m.checkNotNullExpressionValue(textView2, "binding.serverSettingsDeleteServerText");
        b.n(textView2, 2131888399, new Object[]{widgetServerDeleteDialog$Model.getGuild().getName()}, null, 4);
        getBinding().f2536b.setOnClickListener(new WidgetServerDeleteDialog$configureUI$1(this));
        MaterialButton materialButton = getBinding().c;
        m.checkNotNullExpressionValue(materialButton, "binding.serverSettingsDeleteServerConfirm");
        materialButton.setEnabled(widgetServerDeleteDialog$Model.getGuild().isOwner(widgetServerDeleteDialog$Model.getMe().getId()));
        getBinding().c.setOnClickListener(new WidgetServerDeleteDialog$configureUI$2(this, widgetServerDeleteDialog$Model));
    }

    private final WidgetServerDeleteDialogBinding getBinding() {
        return (WidgetServerDeleteDialogBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    public static final void show(FragmentManager fragmentManager, long j) {
        Companion.show(fragmentManager, j);
    }

    @Override // com.discord.app.AppDialog
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        Observable<WidgetServerDeleteDialog$Model> observable = WidgetServerDeleteDialog$Model.Companion.get$app_productionGoogleRelease(getArgumentsOrDefault().getLong(INTENT_GUILD_ID));
        m.checkNotNullExpressionValue(observable, "Model.get(guildId)");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(observable, this, null, 2, null), WidgetServerDeleteDialog.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new WidgetServerDeleteDialog$onViewBoundOrOnResume$1(this), 62, (Object) null);
    }
}
