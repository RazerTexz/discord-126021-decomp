package com.discord.widgets.servers.settings.members;

import android.content.Context;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import b.d.b.a.a;
import com.discord.R$layout;
import com.discord.R$menu;
import com.discord.api.role.GuildRole;
import com.discord.app.AppActivity;
import com.discord.app.AppFragment;
import com.discord.app.AppViewFlipper;
import com.discord.app.LoggingConfig;
import com.discord.databinding.WidgetServerSettingsMembersBinding;
import com.discord.utilities.mg_recycler.MGRecyclerAdapter;
import com.discord.utilities.mg_recycler.MGRecyclerAdapter$Companion;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.view.text.TextWatcher;
import com.discord.utilities.view.text.TextWatcher$Companion;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.google.android.material.textfield.TextInputLayout;
import d0.g;
import d0.z.d.m;
import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.KProperty;
import rx.Observable;
import rx.subjects.BehaviorSubject;
import rx.subjects.Subject;

/* JADX INFO: compiled from: WidgetServerSettingsMembers.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettingsMembers extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {a.d0(WidgetServerSettingsMembers.class, "binding", "getBinding()Lcom/discord/databinding/WidgetServerSettingsMembersBinding;", 0)};
    public static final WidgetServerSettingsMembers$Companion Companion = new WidgetServerSettingsMembers$Companion(null);
    private static final String INTENT_EXTRA_GUILD_ID = "GUILD_ID";
    private static final int VIEW_INDEX_MEMBER_LIST = 0;
    private static final int VIEW_INDEX_NO_RESULTS = 1;
    private WidgetServerSettingsMembersAdapter adapter;

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* JADX INFO: renamed from: guildId$delegate, reason: from kotlin metadata */
    private final Lazy guildId;
    private Map<Long, GuildRole> guildRoles;
    private final LoggingConfig loggingConfig;
    private final Subject<String, String> nameFilterPublisher;
    private final Subject<Long, Long> roleFilterPublisher;

    public WidgetServerSettingsMembers() {
        super(R$layout.widget_server_settings_members);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetServerSettingsMembers$binding$2.INSTANCE, null, 2, null);
        BehaviorSubject behaviorSubjectL0 = BehaviorSubject.l0("");
        m.checkNotNullExpressionValue(behaviorSubjectL0, "BehaviorSubject.create(\"\")");
        this.nameFilterPublisher = behaviorSubjectL0;
        BehaviorSubject behaviorSubjectL1 = BehaviorSubject.l0(-1L);
        m.checkNotNullExpressionValue(behaviorSubjectL1, "BehaviorSubject.create(-1L)");
        this.roleFilterPublisher = behaviorSubjectL1;
        this.guildId = g.lazy(new WidgetServerSettingsMembers$guildId$2(this));
        this.loggingConfig = new LoggingConfig(false, null, WidgetServerSettingsMembers$loggingConfig$1.INSTANCE, 3);
    }

    public static final /* synthetic */ void access$configureUI(WidgetServerSettingsMembers widgetServerSettingsMembers, WidgetServerSettingsMembersModel widgetServerSettingsMembersModel) throws Exception {
        widgetServerSettingsMembers.configureUI(widgetServerSettingsMembersModel);
    }

    public static final /* synthetic */ WidgetServerSettingsMembersBinding access$getBinding$p(WidgetServerSettingsMembers widgetServerSettingsMembers) {
        return widgetServerSettingsMembers.getBinding();
    }

    public static final /* synthetic */ long access$getGuildId$p(WidgetServerSettingsMembers widgetServerSettingsMembers) {
        return widgetServerSettingsMembers.getGuildId();
    }

    public static final /* synthetic */ Subject access$getNameFilterPublisher$p(WidgetServerSettingsMembers widgetServerSettingsMembers) {
        return widgetServerSettingsMembers.nameFilterPublisher;
    }

    public static final /* synthetic */ Subject access$getRoleFilterPublisher$p(WidgetServerSettingsMembers widgetServerSettingsMembers) {
        return widgetServerSettingsMembers.roleFilterPublisher;
    }

    private final void configureUI(WidgetServerSettingsMembersModel model) throws Exception {
        if (model == null) {
            AppActivity appActivity = getAppActivity();
            if (appActivity != null) {
                appActivity.onBackPressed();
                return;
            }
            return;
        }
        AppFragment.setActionBarOptionsMenu$default(this, model.getCanKick() ? R$menu.menu_server_settings_members : R$menu.menu_empty, new WidgetServerSettingsMembers$configureUI$1(this, model), null, 4, null);
        setActionBarTitle(2131892787);
        setActionBarSubtitle(model.getGuild().getName());
        AppViewFlipper appViewFlipper = getBinding().e;
        m.checkNotNullExpressionValue(appViewFlipper, "binding.serverSettingsMembersViewFlipper");
        appViewFlipper.setDisplayedChild((!model.getMemberItems().isEmpty() ? 1 : 0) ^ 1);
        if (!m.areEqual(this.guildRoles, model.getRoles())) {
            this.guildRoles = model.getRoles();
            setupRolesSpinner(model.getGuild().getId(), model.getRoles());
        }
        WidgetServerSettingsMembersAdapter widgetServerSettingsMembersAdapter = this.adapter;
        if (widgetServerSettingsMembersAdapter != null) {
            widgetServerSettingsMembersAdapter.configure(model, new WidgetServerSettingsMembers$configureUI$2(this, model));
        }
    }

    private final WidgetServerSettingsMembersBinding getBinding() {
        return (WidgetServerSettingsMembersBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final long getGuildId() {
        return ((Number) this.guildId.getValue()).longValue();
    }

    private final void setupRolesSpinner(long everyoneRoleId, Map<Long, GuildRole> guildRoles) {
        ArrayList arrayList = new ArrayList(guildRoles.size());
        for (GuildRole guildRole : guildRoles.values()) {
            if (guildRole.getId() != everyoneRoleId) {
                arrayList.add(guildRole);
            } else {
                arrayList.add(0, guildRole);
            }
        }
        WidgetServerSettingsMembers$RolesSpinnerAdapter widgetServerSettingsMembers$RolesSpinnerAdapter = new WidgetServerSettingsMembers$RolesSpinnerAdapter(requireContext(), arrayList);
        Spinner spinner = getBinding().d;
        m.checkNotNullExpressionValue(spinner, "binding.serverSettingsMembersRolesSpinner");
        spinner.setAdapter((SpinnerAdapter) widgetServerSettingsMembers$RolesSpinnerAdapter);
        Spinner spinner2 = getBinding().d;
        m.checkNotNullExpressionValue(spinner2, "binding.serverSettingsMembersRolesSpinner");
        spinner2.setOnItemSelectedListener(new WidgetServerSettingsMembers$setupRolesSpinner$1(this, widgetServerSettingsMembers$RolesSpinnerAdapter));
    }

    @Override // com.discord.app.AppFragment, com.discord.app.AppLogger$a
    public LoggingConfig getLoggingConfig() {
        return this.loggingConfig;
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        m.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        AppFragment.setActionBarDisplayHomeAsUpEnabled$default(this, false, 1, null);
        MGRecyclerAdapter$Companion mGRecyclerAdapter$Companion = MGRecyclerAdapter.Companion;
        RecyclerView recyclerView = getBinding().c;
        m.checkNotNullExpressionValue(recyclerView, "binding.serverSettingsMembersRecycler");
        this.adapter = (WidgetServerSettingsMembersAdapter) mGRecyclerAdapter$Companion.configure(new WidgetServerSettingsMembersAdapter(recyclerView));
        if (getIsRecreated()) {
            return;
        }
        this.roleFilterPublisher.onNext(Long.valueOf(getGuildId()));
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        TextWatcher$Companion textWatcher$Companion = TextWatcher.Companion;
        TextInputLayout textInputLayout = getBinding().f2579b;
        m.checkNotNullExpressionValue(textInputLayout, "binding.serverSettingsMembersNameSearch");
        EditText editText = textInputLayout.getEditText();
        m.checkNotNull(editText);
        m.checkNotNullExpressionValue(editText, "binding.serverSettingsMembersNameSearch.editText!!");
        textWatcher$Companion.addBindedTextWatcher(this, editText, new WidgetServerSettingsMembers$onViewBoundOrOnResume$1(this));
        Subject<String, String> subject = this.nameFilterPublisher;
        TextInputLayout textInputLayout2 = getBinding().f2579b;
        m.checkNotNullExpressionValue(textInputLayout2, "binding.serverSettingsMembersNameSearch");
        EditText editText2 = textInputLayout2.getEditText();
        subject.onNext(String.valueOf(editText2 != null ? editText2.getText() : null));
        Observable<String> observableP = this.nameFilterPublisher.p(750L, TimeUnit.MILLISECONDS);
        m.checkNotNullExpressionValue(observableP, "nameFilterPublisher\n    …0, TimeUnit.MILLISECONDS)");
        ObservableExtensionsKt.appSubscribe$default(observableP, WidgetServerSettingsMembers.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new WidgetServerSettingsMembers$onViewBoundOrOnResume$2(this), 62, (Object) null);
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(WidgetServerSettingsMembersModel.Companion.get(getGuildId(), this.nameFilterPublisher, this.roleFilterPublisher), this, null, 2, null), WidgetServerSettingsMembers.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new WidgetServerSettingsMembers$onViewBoundOrOnResume$3(this), 62, (Object) null);
    }
}
