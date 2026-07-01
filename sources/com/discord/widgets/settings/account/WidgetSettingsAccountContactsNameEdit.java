package com.discord.widgets.settings.account;

import android.content.Context;
import android.view.View;
import androidx.fragment.app.Fragment;
import b.d.b.a.a;
import com.discord.R$layout;
import com.discord.api.connectedaccounts.ConnectedAccount;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetSettingsAccountContactsNameEditBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.restapi.RestAPIParams$ConnectedAccountNameOnly;
import com.discord.stores.StoreStream;
import com.discord.stores.utilities.RestCallStateKt;
import com.discord.utilities.analytics.AnalyticsTracker;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.google.android.material.textfield.TextInputLayout;
import d0.g0.t;
import d0.g0.w;
import d0.z.d.m;
import java.util.List;
import java.util.ListIterator;
import java.util.Objects;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.KProperty;

/* JADX INFO: compiled from: WidgetSettingsAccountContactsNameEdit.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetSettingsAccountContactsNameEdit extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {a.d0(WidgetSettingsAccountContactsNameEdit.class, "binding", "getBinding()Lcom/discord/databinding/WidgetSettingsAccountContactsNameEditBinding;", 0)};
    public static final WidgetSettingsAccountContactsNameEdit$Companion Companion = new WidgetSettingsAccountContactsNameEdit$Companion(null);

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    public WidgetSettingsAccountContactsNameEdit() {
        super(R$layout.widget_settings_account_contacts_name_edit);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetSettingsAccountContactsNameEdit$binding$2.INSTANCE, null, 2, null);
    }

    public static final /* synthetic */ void access$configureUI(WidgetSettingsAccountContactsNameEdit widgetSettingsAccountContactsNameEdit, List list) {
        widgetSettingsAccountContactsNameEdit.configureUI(list);
    }

    public static final /* synthetic */ WidgetSettingsAccountContactsNameEditBinding access$getBinding$p(WidgetSettingsAccountContactsNameEdit widgetSettingsAccountContactsNameEdit) {
        return widgetSettingsAccountContactsNameEdit.getBinding();
    }

    public static final /* synthetic */ void access$submitName(WidgetSettingsAccountContactsNameEdit widgetSettingsAccountContactsNameEdit, String str) {
        widgetSettingsAccountContactsNameEdit.submitName(str);
    }

    private final void configureUI(List<ConnectedAccount> connections) {
        ConnectedAccount connectedAccountPrevious;
        String name;
        ListIterator<ConnectedAccount> listIterator = connections.listIterator(connections.size());
        do {
            if (!listIterator.hasPrevious()) {
                connectedAccountPrevious = null;
                break;
            }
            connectedAccountPrevious = listIterator.previous();
        } while (!m.areEqual(connectedAccountPrevious.getType(), "contacts"));
        ConnectedAccount connectedAccount = connectedAccountPrevious;
        TextInputLayout textInputLayout = getBinding().f2597b;
        m.checkNotNullExpressionValue(textInputLayout, "binding.editAccountNameWrap");
        if (connectedAccount == null || (name = connectedAccount.getName()) == null) {
            name = "";
        }
        ViewExtensions.setText(textInputLayout, name);
        getBinding().c.setOnClickListener(new WidgetSettingsAccountContactsNameEdit$configureUI$1(this));
    }

    private final WidgetSettingsAccountContactsNameEditBinding getBinding() {
        return (WidgetSettingsAccountContactsNameEditBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final void submitName(String name) {
        String string;
        AppFragment.hideKeyboard$default(this, null, 1, null);
        boolean z2 = name == null || t.isBlank(name);
        if (z2) {
            string = null;
        } else {
            if (z2) {
                throw new NoWhenBranchMatchedException();
            }
            Objects.requireNonNull(name, "null cannot be cast to non-null type kotlin.CharSequence");
            string = w.trim(name).toString();
        }
        AnalyticsTracker.INSTANCE.nameSubmitted(w.split$default((CharSequence) name, new String[]{" "}, false, 0, 6, (Object) null).size(), name.length());
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(RestCallStateKt.logNetworkAction(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.Companion.getApiSerializeNulls().updateConnectionName("contacts", "@me", new RestAPIParams$ConnectedAccountNameOnly(string)), false, 1, null), new WidgetSettingsAccountContactsNameEdit$submitName$1(name)), this, null, 2, null), WidgetSettingsAccountContactsNameEdit.class, (Context) null, (Function1) null, WidgetSettingsAccountContactsNameEdit$submitName$3.INSTANCE, (Function0) null, (Function0) null, new WidgetSettingsAccountContactsNameEdit$submitName$2(this), 54, (Object) null);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        m.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        setActionBarSubtitle(2131896797);
        setActionBarTitle(2131887915);
        AppFragment.setActionBarDisplayHomeAsUpEnabled$default(this, false, 1, null);
        TextInputLayout textInputLayout = getBinding().f2597b;
        m.checkNotNullExpressionValue(textInputLayout, "binding.editAccountNameWrap");
        ViewExtensions.setOnImeActionDone$default(textInputLayout, false, new WidgetSettingsAccountContactsNameEdit$onViewBound$1(this), 1, null);
        getBinding().d.setOnClickListener(new WidgetSettingsAccountContactsNameEdit$onViewBound$2(this));
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(StoreStream.Companion.getUserConnections().observeConnectedAccounts(), this, null, 2, null), WidgetSettingsAccountContactsNameEdit.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new WidgetSettingsAccountContactsNameEdit$onViewBoundOrOnResume$1(this), 62, (Object) null);
    }
}
