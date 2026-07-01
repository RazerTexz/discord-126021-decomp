package com.discord.widgets.settings;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AlertDialog$Builder;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import b.a.d.f;
import b.a.d.o;
import b.a.i.b6;
import b.a.k.b;
import b.d.b.a.a;
import com.discord.R$id;
import com.discord.R$layout;
import com.discord.api.connectedaccounts.ConnectedAccount;
import com.discord.app.AppFragment;
import com.discord.databinding.ViewDialogConfirmationBinding;
import com.discord.databinding.WidgetSettingsPrivacyBinding;
import com.discord.models.domain.Harvest;
import com.discord.models.domain.ModelUserSettings$FriendSourceFlags;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreStream$Companion;
import com.discord.stores.StoreUserSettings;
import com.discord.utilities.accessibility.AccessibilityUtils;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rest.RestAPI$HarvestState;
import com.discord.utilities.rest.RestAPI$HarvestState$LastRequested;
import com.discord.utilities.rest.RestAPI$HarvestState$NeverRequested;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.time.TimeUtils;
import com.discord.utilities.user.UserUtils;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.discord.views.CheckedSetting;
import com.discord.views.RadioManager;
import com.discord.widgets.notice.WidgetNoticeDialog$Builder;
import com.google.android.material.button.MaterialButton;
import d0.g;
import d0.t.n;
import d0.t.n0;
import d0.z.d.m;
import j0.l.e.k;
import java.util.List;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function5;
import kotlin.reflect.KProperty;
import rx.Observable;

/* JADX INFO: compiled from: WidgetSettingsPrivacy.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetSettingsPrivacy extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {a.d0(WidgetSettingsPrivacy.class, "binding", "getBinding()Lcom/discord/databinding/WidgetSettingsPrivacyBinding;", 0)};
    public static final WidgetSettingsPrivacy$Companion Companion = new WidgetSettingsPrivacy$Companion(null);

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private AlertDialog dialog;

    /* JADX INFO: renamed from: explicitContentRadios$delegate, reason: from kotlin metadata */
    private final Lazy explicitContentRadios;

    /* JADX INFO: renamed from: friendSourceRadios$delegate, reason: from kotlin metadata */
    private final Lazy friendSourceRadios;
    private RadioManager radioManagerExplicit;
    private final StoreUserSettings userSettings;

    public WidgetSettingsPrivacy() {
        super(R$layout.widget_settings_privacy);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetSettingsPrivacy$binding$2.INSTANCE, null, 2, null);
        this.explicitContentRadios = g.lazy(new WidgetSettingsPrivacy$explicitContentRadios$2(this));
        this.friendSourceRadios = g.lazy(new WidgetSettingsPrivacy$friendSourceRadios$2(this));
        this.userSettings = StoreStream.Companion.getUserSettings();
    }

    public static final /* synthetic */ void access$configureRequestDataButton(WidgetSettingsPrivacy widgetSettingsPrivacy, boolean z2, RestAPI$HarvestState restAPI$HarvestState) {
        widgetSettingsPrivacy.configureRequestDataButton(z2, restAPI$HarvestState);
    }

    public static final /* synthetic */ void access$configureUI(WidgetSettingsPrivacy widgetSettingsPrivacy, WidgetSettingsPrivacy$Model widgetSettingsPrivacy$Model) {
        widgetSettingsPrivacy.configureUI(widgetSettingsPrivacy$Model);
    }

    public static final /* synthetic */ void access$confirmConsent(WidgetSettingsPrivacy widgetSettingsPrivacy, Context context, Function5 function5) {
        widgetSettingsPrivacy.confirmConsent(context, function5);
    }

    public static final /* synthetic */ void access$deleteContactSync(WidgetSettingsPrivacy widgetSettingsPrivacy) {
        widgetSettingsPrivacy.deleteContactSync();
    }

    public static final /* synthetic */ WidgetSettingsPrivacyBinding access$getBinding$p(WidgetSettingsPrivacy widgetSettingsPrivacy) {
        return widgetSettingsPrivacy.getBinding();
    }

    public static final /* synthetic */ StoreUserSettings access$getUserSettings$p(WidgetSettingsPrivacy widgetSettingsPrivacy) {
        return widgetSettingsPrivacy.userSettings;
    }

    public static final /* synthetic */ void access$onRequestDataClick(WidgetSettingsPrivacy widgetSettingsPrivacy, Context context, RestAPI$HarvestState restAPI$HarvestState) {
        widgetSettingsPrivacy.onRequestDataClick(context, restAPI$HarvestState);
    }

    public static final /* synthetic */ void access$showDefaultGuildsRestrictedExistingServers(WidgetSettingsPrivacy widgetSettingsPrivacy, boolean z2) {
        widgetSettingsPrivacy.showDefaultGuildsRestrictedExistingServers(z2);
    }

    public static final /* synthetic */ void access$toggleConsent(WidgetSettingsPrivacy widgetSettingsPrivacy, boolean z2, String str, CheckedSetting checkedSetting) {
        widgetSettingsPrivacy.toggleConsent(z2, str, checkedSetting);
    }

    public static final /* synthetic */ void access$toggleContactSync(WidgetSettingsPrivacy widgetSettingsPrivacy, ConnectedAccount connectedAccount, boolean z2) {
        widgetSettingsPrivacy.toggleContactSync(connectedAccount, z2);
    }

    public static final /* synthetic */ void access$updateDefaultGuildsRestricted(WidgetSettingsPrivacy widgetSettingsPrivacy, boolean z2, boolean z3) {
        widgetSettingsPrivacy.updateDefaultGuildsRestricted(z2, z3);
    }

    public static final /* synthetic */ void access$updateFriendDiscoveryFlags(WidgetSettingsPrivacy widgetSettingsPrivacy, boolean z2, boolean z3) {
        widgetSettingsPrivacy.updateFriendDiscoveryFlags(z2, z3);
    }

    public static final /* synthetic */ void access$updateFriendSourceFlags(WidgetSettingsPrivacy widgetSettingsPrivacy, int i, boolean z2) {
        widgetSettingsPrivacy.updateFriendSourceFlags(i, z2);
    }

    private final void configureContactSyncOptions(WidgetSettingsPrivacy$Model model) {
        LinearLayout linearLayout = getBinding().j;
        m.checkNotNullExpressionValue(linearLayout, "binding.settingsPrivacyContactSync");
        linearLayout.setVisibility(model.getShowContactSync() ? 0 : 8);
        if (model.getShowContactSync()) {
            TextView textView = getBinding().d;
            m.checkNotNullExpressionValue(textView, "binding.contactSyncSettingInfo");
            b.m(textView, 2131887888, new Object[0], new WidgetSettingsPrivacy$configureContactSyncOptions$1(this));
            TextView textView2 = getBinding().d;
            m.checkNotNullExpressionValue(textView2, "binding.contactSyncSettingInfo");
            textView2.setMovementMethod(LinkMovementMethod.getInstance());
            CheckedSetting checkedSetting = getBinding().c;
            m.checkNotNullExpressionValue(checkedSetting, "binding.contactSyncSettingEnabled");
            ConnectedAccount contactSyncConnection = model.getContactSyncConnection();
            checkedSetting.setChecked(contactSyncConnection != null && contactSyncConnection.getFriendSync());
            CheckedSetting checkedSetting2 = getBinding().e;
            m.checkNotNullExpressionValue(checkedSetting2, "binding.contactSyncSettingPhone");
            checkedSetting2.setChecked((model.getUserDiscoveryFlags() & 2) == 2);
            CheckedSetting checkedSetting3 = getBinding().f2635b;
            m.checkNotNullExpressionValue(checkedSetting3, "binding.contactSyncSettingEmail");
            checkedSetting3.setChecked((model.getUserDiscoveryFlags() & 4) == 4);
            getBinding().c.e(new WidgetSettingsPrivacy$configureContactSyncOptions$2(this, model));
            getBinding().e.e(new WidgetSettingsPrivacy$configureContactSyncOptions$3(this));
            getBinding().f2635b.e(new WidgetSettingsPrivacy$configureContactSyncOptions$4(this));
            CheckedSetting checkedSetting4 = getBinding().f;
            m.checkNotNullExpressionValue(checkedSetting4, "binding.contactSyncSettingStaffOnly");
            checkedSetting4.setVisibility(UserUtils.INSTANCE.isStaff(model.getMe()) ? 0 : 8);
            CheckedSetting checkedSetting5 = getBinding().f;
            m.checkNotNullExpressionValue(checkedSetting5, "binding.contactSyncSettingStaffOnly");
            checkedSetting5.setChecked(true);
            getBinding().f.e(new WidgetSettingsPrivacy$configureContactSyncOptions$5(this, model));
        }
    }

    private final void configureDefaultGuildsRestricted(WidgetSettingsPrivacy$Model model) {
        CheckedSetting checkedSetting = getBinding().m;
        m.checkNotNullExpressionValue(checkedSetting, "binding.settingsPrivacyDefaultRestrictedGuilds");
        checkedSetting.setChecked(!model.getDefaultRestrictedGuilds());
        getBinding().m.e(new WidgetSettingsPrivacy$configureDefaultGuildsRestricted$1(this, model));
    }

    private final void configureExplicitContentRadio(WidgetSettingsPrivacy$Model model, CheckedSetting radio, int explicitContentFilter) {
        RadioManager radioManager;
        radio.e(new WidgetSettingsPrivacy$configureExplicitContentRadio$1(this, explicitContentFilter));
        if (this.radioManagerExplicit == null || model.getExplicitContentFilter() != explicitContentFilter || (radioManager = this.radioManagerExplicit) == null) {
            return;
        }
        radioManager.a(radio);
    }

    private final void configureFriendSourceRadio(WidgetSettingsPrivacy$Model model) {
        getFriendSourceRadios().get(0).setOnCheckedListener(new WidgetSettingsPrivacy$configureFriendSourceRadio$1(this));
        getFriendSourceRadios().get(1).setOnCheckedListener(new WidgetSettingsPrivacy$configureFriendSourceRadio$2(this));
        getFriendSourceRadios().get(2).setOnCheckedListener(new WidgetSettingsPrivacy$configureFriendSourceRadio$3(this));
        ModelUserSettings$FriendSourceFlags friendSourceFlags = model.getFriendSourceFlags();
        boolean zIsAll = friendSourceFlags != null ? friendSourceFlags.isAll() : false;
        CheckedSetting checkedSetting = getFriendSourceRadios().get(0);
        m.checkNotNullExpressionValue(checkedSetting, "friendSourceRadios[0]");
        checkedSetting.setChecked(zIsAll);
        CheckedSetting checkedSetting2 = getFriendSourceRadios().get(1);
        m.checkNotNullExpressionValue(checkedSetting2, "friendSourceRadios[1]");
        CheckedSetting checkedSetting3 = checkedSetting2;
        ModelUserSettings$FriendSourceFlags friendSourceFlags2 = model.getFriendSourceFlags();
        checkedSetting3.setChecked((friendSourceFlags2 != null ? friendSourceFlags2.isMutualFriends() : false) || zIsAll);
        CheckedSetting checkedSetting4 = getFriendSourceRadios().get(2);
        m.checkNotNullExpressionValue(checkedSetting4, "friendSourceRadios[2]");
        CheckedSetting checkedSetting5 = checkedSetting4;
        ModelUserSettings$FriendSourceFlags friendSourceFlags3 = model.getFriendSourceFlags();
        checkedSetting5.setChecked((friendSourceFlags3 != null ? friendSourceFlags3.isMutualGuilds() : false) || zIsAll);
    }

    private final void configurePrivacyControls(WidgetSettingsPrivacy$Model model) {
        Context context = getContext();
        if (context != null) {
            m.checkNotNullExpressionValue(context, "context ?: return");
            LinearLayout linearLayout = getBinding().k;
            m.checkNotNullExpressionValue(linearLayout, "binding.settingsPrivacyControls");
            linearLayout.setVisibility(0);
            CheckedSetting checkedSetting = getBinding().f2639z;
            m.checkNotNullExpressionValue(checkedSetting, "binding.settingsPrivacyStatistics");
            checkedSetting.setChecked(model.getConsents().getUsageStatistics().getConsented());
            getBinding().f2639z.setOnCheckedListener(new WidgetSettingsPrivacy$configurePrivacyControls$1(this, context));
            CheckedSetting checkedSetting2 = getBinding().v;
            m.checkNotNullExpressionValue(checkedSetting2, "binding.settingsPrivacyPersonalization");
            checkedSetting2.setChecked(model.getConsents().getPersonalization().getConsented());
            getBinding().v.setOnCheckedListener(new WidgetSettingsPrivacy$configurePrivacyControls$2(this, context));
        }
    }

    private final void configureRequestDataButton(boolean isMeVerified, RestAPI$HarvestState harvestState) {
        getBinding().w.setOnClickListener(new WidgetSettingsPrivacy$configureRequestDataButton$1(this, isMeVerified, harvestState));
    }

    private final void configureUI(WidgetSettingsPrivacy$Model model) {
        configureDefaultGuildsRestricted(model);
        configureFriendSourceRadio(model);
        configureContactSyncOptions(model);
        CheckedSetting checkedSetting = getExplicitContentRadios().get(0);
        m.checkNotNullExpressionValue(checkedSetting, "explicitContentRadios[0]");
        configureExplicitContentRadio(model, checkedSetting, 0);
        CheckedSetting checkedSetting2 = getExplicitContentRadios().get(1);
        m.checkNotNullExpressionValue(checkedSetting2, "explicitContentRadios[1]");
        configureExplicitContentRadio(model, checkedSetting2, 1);
        CheckedSetting checkedSetting3 = getExplicitContentRadios().get(2);
        m.checkNotNullExpressionValue(checkedSetting3, "explicitContentRadios[2]");
        configureExplicitContentRadio(model, checkedSetting3, 2);
        configurePrivacyControls(model);
        configureRequestDataButton(model.getMe().isVerified(), model.getHarvestState());
    }

    private final void confirmConsent(Context context, Function5<? super AlertDialog, ? super TextView, ? super TextView, ? super TextView, ? super TextView, Unit> function5) {
        ViewDialogConfirmationBinding viewDialogConfirmationBindingA = ViewDialogConfirmationBinding.a(getLayoutInflater().inflate(R$layout.view_dialog_confirmation, (ViewGroup) null, false));
        m.checkNotNullExpressionValue(viewDialogConfirmationBindingA, "ViewDialogConfirmationBi…outInflater, null, false)");
        AlertDialog alertDialogCreate = new AlertDialog$Builder(context).setView(viewDialogConfirmationBindingA.a).setCancelable(false).create();
        m.checkNotNullExpressionValue(alertDialogCreate, "AlertDialog.Builder(this…(false)\n        .create()");
        TextView textView = viewDialogConfirmationBindingA.d;
        m.checkNotNullExpressionValue(textView, "binding.viewDialogConfirmationHeader");
        TextView textView2 = viewDialogConfirmationBindingA.e;
        m.checkNotNullExpressionValue(textView2, "binding.viewDialogConfirmationText");
        MaterialButton materialButton = viewDialogConfirmationBindingA.f2185b;
        m.checkNotNullExpressionValue(materialButton, "binding.viewDialogConfirmationCancel");
        MaterialButton materialButton2 = viewDialogConfirmationBindingA.c;
        m.checkNotNullExpressionValue(materialButton2, "binding.viewDialogConfirmationConfirm");
        function5.invoke(alertDialogCreate, textView, textView2, materialButton, materialButton2);
        alertDialogCreate.show();
    }

    private final void deleteContactSync() {
        StoreStream$Companion storeStream$Companion = StoreStream.Companion;
        storeStream$Companion.getContactSync().clearDismissStates();
        storeStream$Companion.getUserConnections().deleteUserConnection("contacts", "@me");
    }

    private final WidgetSettingsPrivacyBinding getBinding() {
        return (WidgetSettingsPrivacyBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final List<CheckedSetting> getExplicitContentRadios() {
        return (List) this.explicitContentRadios.getValue();
    }

    private final List<CheckedSetting> getFriendSourceRadios() {
        return (List) this.friendSourceRadios.getValue();
    }

    public static final void launch(Context context) {
        Companion.launch(context);
    }

    private final void onRequestDataClick(Context context, RestAPI$HarvestState harvestState) {
        WidgetSettingsPrivacy$onRequestDataClick$4 widgetSettingsPrivacy$onRequestDataClick$4 = new WidgetSettingsPrivacy$onRequestDataClick$4(this, context, new WidgetSettingsPrivacy$onRequestDataClick$3(this, context, new WidgetSettingsPrivacy$onRequestDataClick$2(this, context), new WidgetSettingsPrivacy$onRequestDataClick$1(this, context)));
        if (harvestState instanceof RestAPI$HarvestState$NeverRequested) {
            widgetSettingsPrivacy$onRequestDataClick$4.invoke2();
            return;
        }
        if (harvestState instanceof RestAPI$HarvestState$LastRequested) {
            Harvest data = ((RestAPI$HarvestState$LastRequested) harvestState).getData();
            if (Harvest.canRequest$default(data, 0L, 1, null)) {
                widgetSettingsPrivacy$onRequestDataClick$4.invoke2();
            } else {
                showNextAvailableRequestAlert(data.nextAvailableRequestInMillis());
            }
        }
    }

    private final void showDefaultGuildsRestrictedExistingServers(boolean defaultGuildsRestricted) {
        View viewInflate = getLayoutInflater().inflate(R$layout.widget_settings_privacy_defaults, (ViewGroup) null, false);
        int i = R$id.settings_privacy_defaults_existing_no;
        MaterialButton materialButton = (MaterialButton) viewInflate.findViewById(R$id.settings_privacy_defaults_existing_no);
        if (materialButton != null) {
            i = R$id.settings_privacy_defaults_existing_yes;
            MaterialButton materialButton2 = (MaterialButton) viewInflate.findViewById(R$id.settings_privacy_defaults_existing_yes);
            if (materialButton2 != null) {
                LinearLayout linearLayout = (LinearLayout) viewInflate;
                m.checkNotNullExpressionValue(new b6(linearLayout, materialButton, materialButton2), "WidgetSettingsPrivacyDef…outInflater, null, false)");
                materialButton.setOnClickListener(new WidgetSettingsPrivacy$showDefaultGuildsRestrictedExistingServers$$inlined$apply$lambda$1(this, defaultGuildsRestricted));
                materialButton2.setOnClickListener(new WidgetSettingsPrivacy$showDefaultGuildsRestrictedExistingServers$$inlined$apply$lambda$2(this, defaultGuildsRestricted));
                AlertDialog alertDialog = this.dialog;
                if (alertDialog != null) {
                    alertDialog.dismiss();
                }
                m.checkNotNullExpressionValue(linearLayout, "binding.root");
                AlertDialog alertDialogCreate = new AlertDialog$Builder(linearLayout.getContext()).setView(linearLayout).create();
                this.dialog = alertDialogCreate;
                if (alertDialogCreate != null) {
                    alertDialogCreate.show();
                    return;
                }
                return;
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i)));
    }

    private final void showNextAvailableRequestAlert(long nextAvailableRequestMillis) {
        Context context = getContext();
        if (context != null) {
            m.checkNotNullExpressionValue(context, "context ?: return");
            WidgetNoticeDialog$Builder positiveButton$default = WidgetNoticeDialog$Builder.setPositiveButton$default(new WidgetNoticeDialog$Builder(context).setTitle(2131888350).setMessage(b.h(context, 2131888327, new Object[]{TimeUtils.renderUtcDate$default(TimeUtils.INSTANCE, nextAvailableRequestMillis, context, 0, 4, null)}, null, 4)), 2131893499, (Function1) null, 2, (Object) null);
            FragmentManager parentFragmentManager = getParentFragmentManager();
            m.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
            positiveButton$default.show(parentFragmentManager);
        }
    }

    private final void toggleConsent(boolean consented, String consentType, CheckedSetting toggle) {
        ObservableExtensionsKt.withDimmer(ObservableExtensionsKt.ui$default(RestAPI.Companion.getApi().setConsent(consented, consentType), this, null, 2, null), getBinding().g, 100L).k(o.a.g(getContext(), new WidgetSettingsPrivacy$toggleConsent$1(toggle), new WidgetSettingsPrivacy$toggleConsent$2(toggle, consented)));
    }

    private final void toggleContactSync(ConnectedAccount contactsAccount, boolean syncFriends) {
        if (contactsAccount == null) {
            return;
        }
        StoreStream$Companion storeStream$Companion = StoreStream.Companion;
        storeStream$Companion.getUserConnections().updateUserConnection(contactsAccount, syncFriends, contactsAccount.getShowActivity(), contactsAccount.getVisibility() == 1);
        if (syncFriends) {
            storeStream$Companion.getContactSync().backgroundUploadContacts();
        }
    }

    private final void updateDefaultGuildsRestricted(boolean defaultGuildsRestricted, boolean applyToExistingGuilds) {
        Observable kVar;
        if (applyToExistingGuilds) {
            kVar = !defaultGuildsRestricted ? new k(n0.emptySet()) : StoreStream.Companion.getGuilds().observeGuilds().G(WidgetSettingsPrivacy$updateDefaultGuildsRestricted$1.INSTANCE);
        } else {
            kVar = new k(null);
        }
        Observable observableZ = kVar.Z(1);
        m.checkNotNullExpressionValue(observableZ, "when {\n      !applyToExi… }\n    }\n        .take(1)");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.computationLatest(observableZ), this, null, 2, null), WidgetSettingsPrivacy.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new WidgetSettingsPrivacy$updateDefaultGuildsRestricted$2(this, defaultGuildsRestricted), 62, (Object) null);
        AlertDialog alertDialog = this.dialog;
        if (alertDialog != null) {
            alertDialog.dismiss();
        }
    }

    private final void updateFriendDiscoveryFlags(boolean allowPhone, boolean allowEmail) {
        int i = allowPhone ? 2 : 0;
        if (allowEmail) {
            i |= 4;
        }
        StoreStream.Companion.getUserSettings().setFriendDiscoveryFlags(getAppActivity(), i);
    }

    private final void updateFriendSourceFlags(int index, boolean checked) {
        boolean z2 = false;
        CheckedSetting checkedSetting = getFriendSourceRadios().get(0);
        m.checkNotNullExpressionValue(checkedSetting, "friendSourceRadios[0]");
        boolean zIsChecked = checkedSetting.isChecked();
        CheckedSetting checkedSetting2 = getFriendSourceRadios().get(1);
        m.checkNotNullExpressionValue(checkedSetting2, "friendSourceRadios[1]");
        boolean zIsChecked2 = checkedSetting2.isChecked();
        CheckedSetting checkedSetting3 = getFriendSourceRadios().get(2);
        m.checkNotNullExpressionValue(checkedSetting3, "friendSourceRadios[2]");
        boolean zIsChecked3 = checkedSetting3.isChecked();
        if ((zIsChecked && zIsChecked2 && zIsChecked3) || (index == 0 && checked)) {
            z2 = true;
        }
        StoreStream.Companion.getUserSettings().setFriendSourceFlags(getAppActivity(), Boolean.valueOf(z2), Boolean.valueOf(zIsChecked3), Boolean.valueOf(zIsChecked2));
    }

    @Override // com.discord.app.AppFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        AlertDialog alertDialog = this.dialog;
        if (alertDialog != null) {
            alertDialog.dismiss();
        }
    }

    @Override // com.discord.app.AppFragment
    @SuppressLint({"SetTextI18n"})
    public void onViewBound(View view) {
        m.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        AppFragment.setActionBarDisplayHomeAsUpEnabled$default(this, false, 1, null);
        setActionBarSubtitle(2131896797);
        setActionBarTitle(2131894537);
        this.radioManagerExplicit = new RadioManager(getExplicitContentRadios());
        CheckedSetting checkedSetting = getBinding().v;
        CheckedSetting checkedSetting2 = getBinding().v;
        m.checkNotNullExpressionValue(checkedSetting2, "binding.settingsPrivacyPersonalization");
        f fVar = f.a;
        checkedSetting.h(b.j(checkedSetting2, 2131888334, new Object[]{fVar.a(360004109911L, null)}, null, 4), true);
        CheckedSetting checkedSetting3 = getBinding().f2638y;
        CheckedSetting checkedSetting4 = getBinding().f2638y;
        m.checkNotNullExpressionValue(checkedSetting4, "binding.settingsPrivacyScreenreaderDetection");
        checkedSetting3.h(b.j(checkedSetting4, 2131888329, new Object[]{fVar.a(360035966492L, null)}, null, 4), true);
        CheckedSetting checkedSetting5 = getBinding().f2638y;
        checkedSetting5.setOnCheckedListener(new WidgetSettingsPrivacy$onViewBound$$inlined$apply$lambda$1(checkedSetting5, this));
        getBinding().i.setButtonVisibility(false);
        CheckedSetting checkedSetting6 = getBinding().i;
        CheckedSetting checkedSetting7 = getBinding().i;
        m.checkNotNullExpressionValue(checkedSetting7, "binding.settingsPrivacyBasicService");
        checkedSetting6.h(b.d(checkedSetting7, 2131888331, new Object[0], WidgetSettingsPrivacy$onViewBound$2.INSTANCE), true);
        getBinding().i.e(WidgetSettingsPrivacy$onViewBound$3.INSTANCE);
        String strA = fVar.a(360004027692L, null);
        TextView textView = getBinding().h;
        m.checkNotNullExpressionValue(textView, "binding.requestDataLink");
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        TextView textView2 = getBinding().h;
        m.checkNotNullExpressionValue(textView2, "binding.requestDataLink");
        sb.append(b.j(textView2, 2131893363, new Object[0], null, 4));
        sb.append("](");
        sb.append(strA);
        sb.append(')');
        textView.setText(b.l(sb.toString(), new Object[0], null, 2));
        getBinding().h.setOnClickListener(new WidgetSettingsPrivacy$onViewBound$4(strA));
        CheckedSetting checkedSetting8 = getBinding().f2639z;
        CheckedSetting checkedSetting9 = getBinding().f2639z;
        m.checkNotNullExpressionValue(checkedSetting9, "binding.settingsPrivacyStatistics");
        checkedSetting8.h(b.j(checkedSetting9, 2131888348, new Object[]{fVar.a(360004109911L, null)}, null, 4), true);
        for (TextView textView3 : n.listOf((Object[]) new TextView[]{getBinding().f2637x, getBinding().n, getBinding().u, getBinding().l})) {
            AccessibilityUtils accessibilityUtils = AccessibilityUtils.INSTANCE;
            m.checkNotNullExpressionValue(textView3, "header");
            accessibilityUtils.setViewIsHeading(textView3);
        }
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(WidgetSettingsPrivacy$Model.Companion.get(), this, null, 2, null), WidgetSettingsPrivacy.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new WidgetSettingsPrivacy$onViewBoundOrOnResume$1(this), 62, (Object) null);
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(this.userSettings.observeIsAccessibilityDetectionAllowed(), this, null, 2, null), WidgetSettingsPrivacy.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new WidgetSettingsPrivacy$onViewBoundOrOnResume$2(this), 62, (Object) null);
    }
}
