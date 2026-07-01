package com.discord.widgets.servers;

import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import b.d.b.a.a;
import com.discord.R$layout;
import com.discord.app.AppBottomSheet;
import com.discord.databinding.WidgetServerSettingsInstantInviteActionsBinding;
import com.discord.models.domain.ModelInvite;
import com.discord.models.invite.InviteUtils;
import com.discord.stores.StoreStream;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import d0.g0.t;
import d0.z.d.m;
import kotlin.reflect.KProperty;

/* JADX INFO: compiled from: WidgetServerSettingsInstantInvitesActions.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettingsInstantInvitesActions extends AppBottomSheet {
    private static final String ARG_INVITE_CODE = "ARG_INVITE_CODE";

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {a.d0(WidgetServerSettingsInstantInvitesActions.class, "binding", "getBinding()Lcom/discord/databinding/WidgetServerSettingsInstantInviteActionsBinding;", 0)};
    public static final WidgetServerSettingsInstantInvitesActions$Companion Companion = new WidgetServerSettingsInstantInvitesActions$Companion(null);

    public WidgetServerSettingsInstantInvitesActions() {
        super(false, 1, null);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetServerSettingsInstantInvitesActions$binding$2.INSTANCE, null, 2, null);
    }

    public static final /* synthetic */ void access$handleInviteRevoked(WidgetServerSettingsInstantInvitesActions widgetServerSettingsInstantInvitesActions, ModelInvite modelInvite) {
        widgetServerSettingsInstantInvitesActions.handleInviteRevoked(modelInvite);
    }

    public static final void create(FragmentManager fragmentManager, String str) {
        Companion.create(fragmentManager, str);
    }

    private final WidgetServerSettingsInstantInviteActionsBinding getBinding() {
        return (WidgetServerSettingsInstantInviteActionsBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final void handleInviteRevoked(ModelInvite invite) {
        StoreStream.Companion.getInstantInvites().onInviteRemoved(invite);
        dismiss();
    }

    @Override // com.discord.app.AppBottomSheet
    public int getContentViewResId() {
        return R$layout.widget_server_settings_instant_invite_actions;
    }

    @Override // com.discord.app.AppBottomSheet, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        String string = getArgumentsOrDefault().getString(ARG_INVITE_CODE);
        if (string == null || t.isBlank(string)) {
            dismiss();
            return;
        }
        String strCreateLinkFromCode = InviteUtils.INSTANCE.createLinkFromCode(string, null);
        if (string.length() == 0) {
            TextView textView = getBinding().e;
            m.checkNotNullExpressionValue(textView, "binding.inviteActionsTitle");
            textView.setVisibility(8);
        } else {
            TextView textView2 = getBinding().e;
            m.checkNotNullExpressionValue(textView2, "binding.inviteActionsTitle");
            textView2.setText(string);
        }
        getBinding().c.setOnClickListener(new WidgetServerSettingsInstantInvitesActions$onResume$1(this, string));
        getBinding().f2573b.setOnClickListener(new WidgetServerSettingsInstantInvitesActions$onResume$2(this, strCreateLinkFromCode));
        getBinding().d.setOnClickListener(new WidgetServerSettingsInstantInvitesActions$onResume$3(this, strCreateLinkFromCode));
    }
}
