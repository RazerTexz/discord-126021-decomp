package com.discord.widgets.settings.account;

import android.view.View;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import b.a.d.o;
import b.a.k.b;
import b.d.b.a.a;
import com.discord.R$layout;
import com.discord.api.auth.mfa.GetBackupCodesSendVerificationKeyRequestBody;
import com.discord.api.auth.mfa.GetBackupCodesVerificationRequestBody;
import com.discord.app.AppActivity;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetSettingsAccountBackupCodesBinding;
import com.discord.stores.StoreNotices$InputDialog$Type;
import com.discord.utilities.mg_recycler.MGRecyclerAdapter;
import com.discord.utilities.mg_recycler.MGRecyclerAdapter$Companion;
import com.discord.utilities.mg_recycler.MGRecyclerDataPayload;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.discord.widgets.notice.WidgetNoticeDialog;
import com.discord.widgets.notice.WidgetNoticeDialog$Companion;
import d0.z.d.m;
import java.util.List;
import kotlin.reflect.KProperty;

/* JADX INFO: compiled from: WidgetSettingsAccountBackupCodes.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetSettingsAccountBackupCodes extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {a.d0(WidgetSettingsAccountBackupCodes.class, "binding", "getBinding()Lcom/discord/databinding/WidgetSettingsAccountBackupCodesBinding;", 0)};
    public static final WidgetSettingsAccountBackupCodes$Companion Companion = new WidgetSettingsAccountBackupCodes$Companion(null);
    private WidgetSettingsAccountBackupCodes$Adapter backupCodesAdapter;

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private String nonce;
    private String password;
    private String regenerateNonce;
    private String verificationKey;

    public WidgetSettingsAccountBackupCodes() {
        super(R$layout.widget_settings_account_backup_codes);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetSettingsAccountBackupCodes$binding$2.INSTANCE, null, 2, null);
        this.password = "";
        this.nonce = "";
        this.regenerateNonce = "";
        this.verificationKey = "";
    }

    public static final /* synthetic */ void access$configureUI(WidgetSettingsAccountBackupCodes widgetSettingsAccountBackupCodes, List list) {
        widgetSettingsAccountBackupCodes.configureUI(list);
    }

    public static final /* synthetic */ void access$getBackupCodes(WidgetSettingsAccountBackupCodes widgetSettingsAccountBackupCodes, boolean z2) {
        widgetSettingsAccountBackupCodes.getBackupCodes(z2);
    }

    public static final /* synthetic */ String access$getNonce$p(WidgetSettingsAccountBackupCodes widgetSettingsAccountBackupCodes) {
        return widgetSettingsAccountBackupCodes.nonce;
    }

    public static final /* synthetic */ String access$getPassword$p(WidgetSettingsAccountBackupCodes widgetSettingsAccountBackupCodes) {
        return widgetSettingsAccountBackupCodes.password;
    }

    public static final /* synthetic */ String access$getRegenerateNonce$p(WidgetSettingsAccountBackupCodes widgetSettingsAccountBackupCodes) {
        return widgetSettingsAccountBackupCodes.regenerateNonce;
    }

    public static final /* synthetic */ String access$getVerificationKey$p(WidgetSettingsAccountBackupCodes widgetSettingsAccountBackupCodes) {
        return widgetSettingsAccountBackupCodes.verificationKey;
    }

    public static final /* synthetic */ void access$sendVerificationKey(WidgetSettingsAccountBackupCodes widgetSettingsAccountBackupCodes) {
        widgetSettingsAccountBackupCodes.sendVerificationKey();
    }

    public static final /* synthetic */ void access$setNonce$p(WidgetSettingsAccountBackupCodes widgetSettingsAccountBackupCodes, String str) {
        widgetSettingsAccountBackupCodes.nonce = str;
    }

    public static final /* synthetic */ void access$setPassword$p(WidgetSettingsAccountBackupCodes widgetSettingsAccountBackupCodes, String str) {
        widgetSettingsAccountBackupCodes.password = str;
    }

    public static final /* synthetic */ void access$setRegenerateNonce$p(WidgetSettingsAccountBackupCodes widgetSettingsAccountBackupCodes, String str) {
        widgetSettingsAccountBackupCodes.regenerateNonce = str;
    }

    public static final /* synthetic */ void access$setVerificationKey$p(WidgetSettingsAccountBackupCodes widgetSettingsAccountBackupCodes, String str) {
        widgetSettingsAccountBackupCodes.verificationKey = str;
    }

    public static final /* synthetic */ void access$showPasswordModal(WidgetSettingsAccountBackupCodes widgetSettingsAccountBackupCodes) {
        widgetSettingsAccountBackupCodes.showPasswordModal();
    }

    public static final /* synthetic */ void access$showVerificationKeyModal(WidgetSettingsAccountBackupCodes widgetSettingsAccountBackupCodes) {
        widgetSettingsAccountBackupCodes.showVerificationKeyModal();
    }

    private final void configureUI(List<? extends MGRecyclerDataPayload> data) {
        WidgetSettingsAccountBackupCodes$Adapter widgetSettingsAccountBackupCodes$Adapter = this.backupCodesAdapter;
        if (widgetSettingsAccountBackupCodes$Adapter == null) {
            m.throwUninitializedPropertyAccessException("backupCodesAdapter");
        }
        widgetSettingsAccountBackupCodes$Adapter.setData(data);
    }

    private final void getBackupCodes(boolean regenerate) {
        ObservableExtensionsKt.restSubscribeOn$default(ObservableExtensionsKt.withDimmer(ObservableExtensionsKt.ui$default(RestAPI.Companion.getApi().getBackupCodesVerification(new GetBackupCodesVerificationRequestBody(this.verificationKey, regenerate ? this.regenerateNonce : this.nonce, regenerate)), this, null, 2, null), getBinding().f2590b, 100L), false, 1, null).k(o.a.g(getContext(), new WidgetSettingsAccountBackupCodes$getBackupCodes$1(this), null));
    }

    public static /* synthetic */ void getBackupCodes$default(WidgetSettingsAccountBackupCodes widgetSettingsAccountBackupCodes, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            z2 = false;
        }
        widgetSettingsAccountBackupCodes.getBackupCodes(z2);
    }

    private final WidgetSettingsAccountBackupCodesBinding getBinding() {
        return (WidgetSettingsAccountBackupCodesBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final void sendVerificationKey() {
        ObservableExtensionsKt.restSubscribeOn$default(ObservableExtensionsKt.ui$default(RestAPI.Companion.getApi().getBackupCodesSendVerificationKey(new GetBackupCodesSendVerificationKeyRequestBody(this.password)), this, null, 2, null), false, 1, null).k(o.a.g(getContext(), new WidgetSettingsAccountBackupCodes$sendVerificationKey$1(this), new WidgetSettingsAccountBackupCodes$sendVerificationKey$2(this)));
    }

    private final void showPasswordModal() {
        AppActivity appActivity = getAppActivity();
        if (appActivity != null) {
            WidgetNoticeDialog$Companion widgetNoticeDialog$Companion = WidgetNoticeDialog.Companion;
            CharSequence charSequenceH = b.h(requireContext(), 2131896892, new Object[0], null, 4);
            CharSequence charSequenceH2 = b.h(requireContext(), 2131889240, new Object[0], null, 4);
            WidgetNoticeDialog$Companion.showInputModal$default(widgetNoticeDialog$Companion, appActivity, b.h(requireContext(), 2131896496, new Object[0], null, 4), charSequenceH, charSequenceH2, new WidgetSettingsAccountBackupCodes$showPasswordModal$$inlined$let$lambda$1(this), new WidgetSettingsAccountBackupCodes$showPasswordModal$$inlined$let$lambda$2(this), Boolean.FALSE, null, b.h(requireContext(), 2131896497, new Object[0], null, 4), false, 640, null);
        }
    }

    private final void showVerificationKeyModal() {
        AppActivity appActivity = getAppActivity();
        if (appActivity != null) {
            WidgetNoticeDialog$Companion.showInputModal$default(WidgetNoticeDialog.Companion, appActivity, b.h(requireContext(), 2131896505, new Object[0], null, 4), b.h(requireContext(), 2131896503, new Object[0], null, 4), b.h(requireContext(), 2131896504, new Object[0], null, 4), new WidgetSettingsAccountBackupCodes$showVerificationKeyModal$$inlined$let$lambda$1(this), new WidgetSettingsAccountBackupCodes$showVerificationKeyModal$$inlined$let$lambda$2(this), Boolean.FALSE, StoreNotices$InputDialog$Type.TEXT_NO_SUGGESTIONS, null, true, 256, null);
        }
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        m.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        setActionBarSubtitle(2131896797);
        setActionBarTitle(2131896496);
        AppFragment.setActionBarDisplayHomeAsUpEnabled$default(this, false, 1, null);
        TextView textView = getBinding().d;
        m.checkNotNullExpressionValue(textView, "binding.settingsBackupCodesInfo");
        b.n(textView, 2131896495, new Object[0], null, 4);
        RecyclerView recyclerView = getBinding().e;
        m.checkNotNullExpressionValue(recyclerView, "binding.settingsBackupCodesRv");
        this.backupCodesAdapter = new WidgetSettingsAccountBackupCodes$Adapter(recyclerView);
        if (getActivity() != null) {
            MGRecyclerAdapter$Companion mGRecyclerAdapter$Companion = MGRecyclerAdapter.Companion;
            RecyclerView recyclerView2 = getBinding().e;
            m.checkNotNullExpressionValue(recyclerView2, "binding.settingsBackupCodesRv");
            this.backupCodesAdapter = (WidgetSettingsAccountBackupCodes$Adapter) mGRecyclerAdapter$Companion.configure(new WidgetSettingsAccountBackupCodes$Adapter(recyclerView2));
        }
        getBinding().c.setOnClickListener(new WidgetSettingsAccountBackupCodes$onViewBound$2(this));
        getBinding().f2590b.setDimmed(true, true);
        showPasswordModal();
    }
}
