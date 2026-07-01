package com.discord.widgets.servers;

import android.content.Context;
import android.widget.LinearLayout;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import b.a.k.b;
import b.d.b.a.a;
import com.discord.R$layout;
import com.discord.app.AppDialog;
import com.discord.databinding.WidgetGuildTransferOwnershipBinding;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.discord.views.CheckedSetting;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputLayout;
import d0.z.d.m;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.KProperty;

/* JADX INFO: compiled from: WidgetServerSettingsTransferOwnership.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettingsTransferOwnership extends AppDialog {
    private static final String ARG_GUILD_ID = "ARG_GUILD_ID";
    private static final String ARG_USER_ID = "ARG_USER_ID";

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {a.d0(WidgetServerSettingsTransferOwnership.class, "binding", "getBinding()Lcom/discord/databinding/WidgetGuildTransferOwnershipBinding;", 0)};
    public static final WidgetServerSettingsTransferOwnership$Companion Companion = new WidgetServerSettingsTransferOwnership$Companion(null);
    private static final String TAG = WidgetServerSettingsTransferOwnership.class.getSimpleName();

    public WidgetServerSettingsTransferOwnership() {
        super(R$layout.widget_guild_transfer_ownership);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetServerSettingsTransferOwnership$binding$2.INSTANCE, null, 2, null);
    }

    public static final /* synthetic */ void access$configureUI(WidgetServerSettingsTransferOwnership widgetServerSettingsTransferOwnership, WidgetServerSettingsTransferOwnership$Model widgetServerSettingsTransferOwnership$Model) {
        widgetServerSettingsTransferOwnership.configureUI(widgetServerSettingsTransferOwnership$Model);
    }

    public static final /* synthetic */ WidgetGuildTransferOwnershipBinding access$getBinding$p(WidgetServerSettingsTransferOwnership widgetServerSettingsTransferOwnership) {
        return widgetServerSettingsTransferOwnership.getBinding();
    }

    public static final /* synthetic */ String access$getMfaCode$p(WidgetServerSettingsTransferOwnership widgetServerSettingsTransferOwnership) {
        return widgetServerSettingsTransferOwnership.getMfaCode();
    }

    public static final /* synthetic */ String access$getTAG$cp() {
        return TAG;
    }

    private final void configureUI(WidgetServerSettingsTransferOwnership$Model model) {
        if (model == null) {
            dismiss();
            return;
        }
        LinearLayout linearLayout = getBinding().f;
        m.checkNotNullExpressionValue(linearLayout, "binding.guildTransferOwnershipMfaWrap");
        linearLayout.setVisibility(model.isMfaEnabled() ? 0 : 8);
        getBinding().c.setOnClickListener(new WidgetServerSettingsTransferOwnership$configureUI$1(this));
        MaterialButton materialButton = getBinding().d;
        m.checkNotNullExpressionValue(materialButton, "binding.guildTransferOwnershipConfirm");
        CheckedSetting checkedSetting = getBinding().f2455b;
        m.checkNotNullExpressionValue(checkedSetting, "binding.guildTransferOwnershipAcknowledgeCheck");
        materialButton.setEnabled(checkedSetting.isChecked());
        getBinding().f2455b.setText(b.k(this, 2131896470, new Object[]{model.getUser().getUsername()}, null, 4));
        getBinding().f2455b.e(new WidgetServerSettingsTransferOwnership$configureUI$2(this));
        getBinding().d.setOnClickListener(new WidgetServerSettingsTransferOwnership$configureUI$3(this, model));
    }

    private final WidgetGuildTransferOwnershipBinding getBinding() {
        return (WidgetGuildTransferOwnershipBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final String getMfaCode() {
        TextInputLayout textInputLayout = getBinding().e;
        m.checkNotNullExpressionValue(textInputLayout, "binding.guildTransferOwnershipMfaCode");
        if (textInputLayout.getVisibility() == 0) {
            TextInputLayout textInputLayout2 = getBinding().e;
            m.checkNotNullExpressionValue(textInputLayout2, "binding.guildTransferOwnershipMfaCode");
            if (!(ViewExtensions.getTextOrEmpty(textInputLayout2).length() == 0)) {
                TextInputLayout textInputLayout3 = getBinding().e;
                m.checkNotNullExpressionValue(textInputLayout3, "binding.guildTransferOwnershipMfaCode");
                return ViewExtensions.getTextOrEmpty(textInputLayout3);
            }
        }
        return null;
    }

    @Override // com.discord.app.AppDialog
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(WidgetServerSettingsTransferOwnership$Model.Companion.get(getArgumentsOrDefault().getLong(ARG_GUILD_ID, -1L), getArgumentsOrDefault().getLong(ARG_USER_ID, -1L)), this, null, 2, null), WidgetServerSettingsTransferOwnership.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new WidgetServerSettingsTransferOwnership$onViewBoundOrOnResume$1(this), 62, (Object) null);
    }
}
