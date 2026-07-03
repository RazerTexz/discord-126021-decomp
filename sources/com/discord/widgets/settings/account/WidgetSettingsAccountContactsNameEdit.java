package com.discord.widgets.settings.account;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.discord.C5419R;
import com.discord.analytics.generated.events.network_action.TrackNetworkActionUserConnectionsUpdate;
import com.discord.analytics.generated.traits.TrackNetworkMetadataReceiver;
import com.discord.api.connectedaccounts.ConnectedAccount;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetSettingsAccountContactsNameEditBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.restapi.RestAPIParams;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUserConnections;
import com.discord.stores.utilities.RestCallStateKt;
import com.discord.utilities.analytics.AnalyticsTracker;
import com.discord.utilities.error.Error;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.google.android.material.textfield.TextInputLayout;
import java.util.List;
import java.util.ListIterator;
import java.util.Objects;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import p007b.p008a.p018d.C0870j;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p579g0.C12103t;
import p507d0.p579g0.C12106w;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;
import p658rx.Subscription;

/* JADX INFO: compiled from: WidgetSettingsAccountContactsNameEdit.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetSettingsAccountContactsNameEdit extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {C1643a.m846d0(WidgetSettingsAccountContactsNameEdit.class, "binding", "getBinding()Lcom/discord/databinding/WidgetSettingsAccountContactsNameEditBinding;", 0)};

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* JADX INFO: compiled from: WidgetSettingsAccountContactsNameEdit.kt */
    public static final class Companion {
        private Companion() {
        }

        public final void launch(Context context) {
            C12238m.checkNotNullParameter(context, "context");
            C0870j.m157e(context, WidgetSettingsAccountContactsNameEdit.class, null, 4);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.settings.account.WidgetSettingsAccountContactsNameEdit$onViewBound$1 */
    /* JADX INFO: compiled from: WidgetSettingsAccountContactsNameEdit.kt */
    public static final class C97501 extends AbstractC12240o implements Function1<TextView, Unit> {
        public C97501() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(TextView textView) {
            invoke2(textView);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(TextView textView) {
            C12238m.checkNotNullParameter(textView, "it");
            WidgetSettingsAccountContactsNameEdit widgetSettingsAccountContactsNameEdit = WidgetSettingsAccountContactsNameEdit.this;
            TextInputLayout textInputLayout = widgetSettingsAccountContactsNameEdit.getBinding().f17827b;
            C12238m.checkNotNullExpressionValue(textInputLayout, "binding.editAccountNameWrap");
            String textOrEmpty = ViewExtensions.getTextOrEmpty(textInputLayout);
            Objects.requireNonNull(textOrEmpty, "null cannot be cast to non-null type kotlin.CharSequence");
            widgetSettingsAccountContactsNameEdit.submitName(C12106w.trim(textOrEmpty).toString());
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.settings.account.WidgetSettingsAccountContactsNameEdit$onViewBoundOrOnResume$1 */
    /* JADX INFO: compiled from: WidgetSettingsAccountContactsNameEdit.kt */
    public static final class C97521 extends AbstractC12240o implements Function1<StoreUserConnections.State, Unit> {
        public C97521() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(StoreUserConnections.State state) {
            invoke2(state);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(StoreUserConnections.State state) {
            C12238m.checkNotNullParameter(state, "it");
            WidgetSettingsAccountContactsNameEdit.this.configureUI(state);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.settings.account.WidgetSettingsAccountContactsNameEdit$submitName$1 */
    /* JADX INFO: compiled from: WidgetSettingsAccountContactsNameEdit.kt */
    public static final class C97531 extends AbstractC12240o implements Function1<ConnectedAccount, TrackNetworkMetadataReceiver> {
        public final /* synthetic */ String $name;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C97531(String str) {
            super(1);
            this.$name = str;
        }

        @Override // kotlin.jvm.functions.Function1
        public final TrackNetworkMetadataReceiver invoke(ConnectedAccount connectedAccount) {
            return new TrackNetworkActionUserConnectionsUpdate(this.$name, null, null, null, 14);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.settings.account.WidgetSettingsAccountContactsNameEdit$submitName$2 */
    /* JADX INFO: compiled from: WidgetSettingsAccountContactsNameEdit.kt */
    public static final class C97542 extends AbstractC12240o implements Function1<ConnectedAccount, Unit> {
        public C97542() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ConnectedAccount connectedAccount) {
            invoke2(connectedAccount);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(ConnectedAccount connectedAccount) {
            C12238m.checkNotNullParameter(connectedAccount, "it");
            FragmentActivity fragmentActivityM95e = WidgetSettingsAccountContactsNameEdit.this.m95e();
            if (fragmentActivityM95e != null) {
                fragmentActivityM95e.onBackPressed();
            }
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.settings.account.WidgetSettingsAccountContactsNameEdit$submitName$3 */
    /* JADX INFO: compiled from: WidgetSettingsAccountContactsNameEdit.kt */
    public static final class C97553 extends AbstractC12240o implements Function1<Error, Unit> {
        public static final C97553 INSTANCE = new C97553();

        public C97553() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Error error) {
            invoke2(error);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Error error) {
            C12238m.checkNotNullParameter(error, "it");
        }
    }

    public WidgetSettingsAccountContactsNameEdit() {
        super(C5419R.layout.widget_settings_account_contacts_name_edit);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetSettingsAccountContactsNameEdit$binding$2.INSTANCE, null, 2, null);
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
        } while (!C12238m.areEqual(connectedAccountPrevious.getType(), "contacts"));
        ConnectedAccount connectedAccount = connectedAccountPrevious;
        TextInputLayout textInputLayout = getBinding().f17827b;
        C12238m.checkNotNullExpressionValue(textInputLayout, "binding.editAccountNameWrap");
        if (connectedAccount == null || (name = connectedAccount.getName()) == null) {
            name = "";
        }
        ViewExtensions.setText(textInputLayout, name);
        getBinding().f17828c.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.settings.account.WidgetSettingsAccountContactsNameEdit.configureUI.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WidgetSettingsAccountContactsNameEdit.this.submitName("");
            }
        });
    }

    private final WidgetSettingsAccountContactsNameEditBinding getBinding() {
        return (WidgetSettingsAccountContactsNameEditBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final void submitName(String name) {
        String string;
        AppFragment.hideKeyboard$default(this, null, 1, null);
        boolean z2 = name == null || C12103t.isBlank(name);
        if (z2) {
            string = null;
        } else {
            if (z2) {
                throw new NoWhenBranchMatchedException();
            }
            Objects.requireNonNull(name, "null cannot be cast to non-null type kotlin.CharSequence");
            string = C12106w.trim(name).toString();
        }
        AnalyticsTracker.INSTANCE.nameSubmitted(C12106w.split$default((CharSequence) name, new String[]{" "}, false, 0, 6, (Object) null).size(), name.length());
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(RestCallStateKt.logNetworkAction(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.INSTANCE.getApiSerializeNulls().updateConnectionName("contacts", "@me", new RestAPIParams.ConnectedAccountNameOnly(string)), false, 1, null), new C97531(name)), this, null, 2, null), (Class<?>) WidgetSettingsAccountContactsNameEdit.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : C97553.INSTANCE), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C97542());
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        C12238m.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        setActionBarSubtitle(C5419R.string.user_settings);
        setActionBarTitle(C5419R.string.contact_sync_update_name_title);
        AppFragment.setActionBarDisplayHomeAsUpEnabled$default(this, false, 1, null);
        TextInputLayout textInputLayout = getBinding().f17827b;
        C12238m.checkNotNullExpressionValue(textInputLayout, "binding.editAccountNameWrap");
        ViewExtensions.setOnImeActionDone$default(textInputLayout, false, new C97501(), 1, null);
        getBinding().f17829d.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.settings.account.WidgetSettingsAccountContactsNameEdit.onViewBound.2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                WidgetSettingsAccountContactsNameEdit widgetSettingsAccountContactsNameEdit = WidgetSettingsAccountContactsNameEdit.this;
                TextInputLayout textInputLayout2 = widgetSettingsAccountContactsNameEdit.getBinding().f17827b;
                C12238m.checkNotNullExpressionValue(textInputLayout2, "binding.editAccountNameWrap");
                String textOrEmpty = ViewExtensions.getTextOrEmpty(textInputLayout2);
                Objects.requireNonNull(textOrEmpty, "null cannot be cast to non-null type kotlin.CharSequence");
                widgetSettingsAccountContactsNameEdit.submitName(C12106w.trim(textOrEmpty).toString());
            }
        });
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(StoreStream.INSTANCE.getUserConnections().observeConnectedAccounts(), this, null, 2, null), (Class<?>) WidgetSettingsAccountContactsNameEdit.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C97521());
    }
}
