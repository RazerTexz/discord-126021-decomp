package com.discord.widgets.servers.settings.members;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.C5419R;
import com.discord.api.role.GuildRole;
import com.discord.app.AppActivity;
import com.discord.app.AppFragment;
import com.discord.app.AppViewFlipper;
import com.discord.app.LoggingConfig;
import com.discord.databinding.WidgetServerSettingsMembersBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.stores.StoreGatewayConnection;
import com.discord.stores.StoreStream;
import com.discord.utilities.error.Error;
import com.discord.utilities.guilds.RoleUtils;
import com.discord.utilities.mg_recycler.MGRecyclerAdapter;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.view.text.TextWatcher;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.discord.widgets.servers.WidgetServerSettingsChannels;
import com.discord.widgets.servers.WidgetServerSettingsEditMember;
import com.discord.widgets.user.WidgetPruneUsers;
import com.google.android.material.textfield.TextInputLayout;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import p007b.p008a.p018d.C0870j;
import p007b.p008a.p018d.C0876m;
import p007b.p008a.p025i.C0990k1;
import p007b.p008a.p025i.C0997l1;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.C12083g;
import p507d0.p579g0.C12102s;
import p507d0.p580t.C12145m;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;
import p658rx.Observable;
import p658rx.Subscription;
import p658rx.functions.Action1;
import p658rx.functions.Action2;
import p658rx.subjects.BehaviorSubject;
import p658rx.subjects.Subject;

/* JADX INFO: compiled from: WidgetServerSettingsMembers.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettingsMembers extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {C1643a.m846d0(WidgetServerSettingsMembers.class, "binding", "getBinding()Lcom/discord/databinding/WidgetServerSettingsMembersBinding;", 0)};

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
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

    /* JADX INFO: compiled from: WidgetServerSettingsMembers.kt */
    public static final class Companion {
        private Companion() {
        }

        public final void create(Context context, long guildId) {
            C12238m.checkNotNullParameter(context, "context");
            Intent intentPutExtra = new Intent().putExtra(WidgetServerSettingsMembers.INTENT_EXTRA_GUILD_ID, guildId);
            C12238m.checkNotNullExpressionValue(intentPutExtra, "Intent()\n          .putE…_EXTRA_GUILD_ID, guildId)");
            C0870j.m156d(context, WidgetServerSettingsMembers.class, intentPutExtra);
            StoreStream.INSTANCE.getAnalytics().onGuildSettingsPaneViewed("MEMBERS", guildId);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: compiled from: WidgetServerSettingsMembers.kt */
    public static final class RolesSpinnerAdapter extends ArrayAdapter<GuildRole> {
        private final ArrayList<GuildRole> roles;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public RolesSpinnerAdapter(Context context, ArrayList<GuildRole> arrayList) {
            super(context, C5419R.layout.server_settings_members_role_spinner_item, arrayList);
            C12238m.checkNotNullParameter(context, "context");
            C12238m.checkNotNullParameter(arrayList, "roles");
            this.roles = arrayList;
        }

        private final void configureLabel(TextView label, int position) {
            GuildRole item = getItem(position);
            Context context = getContext();
            C12238m.checkNotNullExpressionValue(context, "context");
            label.setTextColor(RoleUtils.getRoleColor$default(item, context, null, 2, null));
            label.setText(item.getName());
        }

        @Override // android.widget.ArrayAdapter, android.widget.Adapter
        public int getCount() {
            return this.roles.size();
        }

        @Override // android.widget.ArrayAdapter, android.widget.BaseAdapter, android.widget.SpinnerAdapter
        public View getDropDownView(int position, View convertView, ViewGroup parent) {
            C0997l1 c0997l1;
            C12238m.checkNotNullParameter(parent, "parent");
            if (convertView == null) {
                View viewInflate = LayoutInflater.from(parent.getContext()).inflate(C5419R.layout.server_settings_members_role_spinner_item_open, (ViewGroup) null, false);
                Objects.requireNonNull(viewInflate, "rootView");
                TextView textView = (TextView) viewInflate;
                c0997l1 = new C0997l1(textView, textView);
            } else {
                TextView textView2 = (TextView) convertView;
                c0997l1 = new C0997l1(textView2, textView2);
            }
            C12238m.checkNotNullExpressionValue(c0997l1, "if (convertView == null)…bind(convertView)\n      }");
            TextView textView3 = c0997l1.f1018b;
            C12238m.checkNotNullExpressionValue(textView3, "binding.roleSpinnerItemTextview");
            configureLabel(textView3, position);
            TextView textView4 = c0997l1.f1017a;
            C12238m.checkNotNullExpressionValue(textView4, "binding.root");
            return textView4;
        }

        @Override // android.widget.ArrayAdapter, android.widget.Adapter
        public long getItemId(int position) {
            return position;
        }

        @Override // android.widget.ArrayAdapter, android.widget.Adapter
        public View getView(int position, View convertView, ViewGroup parent) {
            C0990k1 c0990k1;
            C12238m.checkNotNullParameter(parent, "parent");
            if (convertView == null) {
                View viewInflate = LayoutInflater.from(parent.getContext()).inflate(C5419R.layout.server_settings_members_role_spinner_item, (ViewGroup) null, false);
                Objects.requireNonNull(viewInflate, "rootView");
                TextView textView = (TextView) viewInflate;
                c0990k1 = new C0990k1(textView, textView);
            } else {
                TextView textView2 = (TextView) convertView;
                c0990k1 = new C0990k1(textView2, textView2);
            }
            C12238m.checkNotNullExpressionValue(c0990k1, "if (convertView == null)…bind(convertView)\n      }");
            TextView textView3 = c0990k1.f997b;
            C12238m.checkNotNullExpressionValue(textView3, "binding.roleSpinnerItemTextview");
            configureLabel(textView3, position);
            TextView textView4 = c0990k1.f996a;
            C12238m.checkNotNullExpressionValue(textView4, "binding.root");
            return textView4;
        }

        @Override // android.widget.ArrayAdapter, android.widget.Adapter
        public GuildRole getItem(int position) {
            GuildRole guildRole = this.roles.get(position);
            C12238m.checkNotNullExpressionValue(guildRole, "roles[position]");
            return guildRole;
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.servers.settings.members.WidgetServerSettingsMembers$configureUI$2 */
    /* JADX INFO: compiled from: WidgetServerSettingsMembers.kt */
    public static final class C95902 extends AbstractC12240o implements Function2<Long, List<? extends Long>, Unit> {
        public final /* synthetic */ WidgetServerSettingsMembersModel $model;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C95902(WidgetServerSettingsMembersModel widgetServerSettingsMembersModel) {
            super(2);
            this.$model = widgetServerSettingsMembersModel;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Long l, List<? extends Long> list) {
            invoke(l.longValue(), (List<Long>) list);
            return Unit.f27425a;
        }

        public final void invoke(long j, List<Long> list) {
            C12238m.checkNotNullParameter(list, "userRoles");
            boolean z2 = j == this.$model.getMeUser().getId();
            if (this.$model.getGuild().getOwnerId() == j && !z2) {
                C0876m.m171i(WidgetServerSettingsMembers.this, C5419R.string.cannot_manage_is_owner, 0, 4);
                return;
            }
            GuildRole highestRole = RoleUtils.getHighestRole(this.$model.getRoles(), list);
            if (!RoleUtils.rankIsHigher(this.$model.getMyHighestRole(), highestRole) && !this.$model.getGuild().isOwner(this.$model.getMeUser().getId()) && !z2) {
                if (RoleUtils.rankEquals(this.$model.getMyHighestRole(), highestRole)) {
                    C0876m.m171i(WidgetServerSettingsMembers.this, C5419R.string.cannot_manage_same_rank, 0, 4);
                    return;
                } else {
                    C0876m.m171i(WidgetServerSettingsMembers.this, C5419R.string.cannot_manage_higher_rank, 0, 4);
                    return;
                }
            }
            WidgetServerSettingsEditMember.Companion companion = WidgetServerSettingsEditMember.INSTANCE;
            long id2 = this.$model.getGuild().getId();
            WidgetServerSettingsMembersBinding binding = WidgetServerSettingsMembers.this.getBinding();
            C12238m.checkNotNullExpressionValue(binding, "binding");
            CoordinatorLayout coordinatorLayout = binding.f17708a;
            C12238m.checkNotNullExpressionValue(coordinatorLayout, "binding.root");
            Context context = coordinatorLayout.getContext();
            C12238m.checkNotNullExpressionValue(context, "binding.root.context");
            companion.launch(id2, j, context);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.servers.settings.members.WidgetServerSettingsMembers$onViewBoundOrOnResume$2 */
    /* JADX INFO: compiled from: WidgetServerSettingsMembers.kt */
    public static final class C95922 extends AbstractC12240o implements Function1<String, Unit> {
        public C95922() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(String str) {
            invoke2(str);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(String str) {
            C12238m.checkNotNullExpressionValue(str, "filterString");
            Long longOrNull = C12102s.toLongOrNull(str);
            StoreGatewayConnection.requestGuildMembers$default(StoreStream.INSTANCE.getGatewaySocket(), WidgetServerSettingsMembers.this.getGuildId(), str, longOrNull != null ? C12145m.listOf(Long.valueOf(longOrNull.longValue())) : null, null, 8, null);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.servers.settings.members.WidgetServerSettingsMembers$onViewBoundOrOnResume$3 */
    /* JADX INFO: compiled from: WidgetServerSettingsMembers.kt */
    public static final class C95933 extends AbstractC12240o implements Function1<WidgetServerSettingsMembersModel, Unit> {
        public C95933() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(WidgetServerSettingsMembersModel widgetServerSettingsMembersModel) throws Exception {
            invoke2(widgetServerSettingsMembersModel);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(WidgetServerSettingsMembersModel widgetServerSettingsMembersModel) throws Exception {
            WidgetServerSettingsMembers.this.configureUI(widgetServerSettingsMembersModel);
        }
    }

    public WidgetServerSettingsMembers() {
        super(C5419R.layout.widget_server_settings_members);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetServerSettingsMembers$binding$2.INSTANCE, null, 2, null);
        BehaviorSubject behaviorSubjectM11130l0 = BehaviorSubject.m11130l0("");
        C12238m.checkNotNullExpressionValue(behaviorSubjectM11130l0, "BehaviorSubject.create(\"\")");
        this.nameFilterPublisher = behaviorSubjectM11130l0;
        BehaviorSubject behaviorSubjectM11130l1 = BehaviorSubject.m11130l0(-1L);
        C12238m.checkNotNullExpressionValue(behaviorSubjectM11130l1, "BehaviorSubject.create(-1L)");
        this.roleFilterPublisher = behaviorSubjectM11130l1;
        this.guildId = C12083g.lazy(new WidgetServerSettingsMembers$guildId$2(this));
        this.loggingConfig = new LoggingConfig(false, null, WidgetServerSettingsMembers$loggingConfig$1.INSTANCE, 3);
    }

    private final void configureUI(final WidgetServerSettingsMembersModel model) throws Exception {
        if (model == null) {
            AppActivity appActivity = getAppActivity();
            if (appActivity != null) {
                appActivity.onBackPressed();
                return;
            }
            return;
        }
        AppFragment.setActionBarOptionsMenu$default(this, model.getCanKick() ? C5419R.menu.menu_server_settings_members : C5419R.menu.menu_empty, new Action2<MenuItem, Context>() { // from class: com.discord.widgets.servers.settings.members.WidgetServerSettingsMembers.configureUI.1
            @Override // p658rx.functions.Action2
            public final void call(MenuItem menuItem, Context context) {
                C12238m.checkNotNullExpressionValue(menuItem, "menuItem");
                if (menuItem.getItemId() != C5419R.id.menu_server_settings_members_prune) {
                    return;
                }
                WidgetPruneUsers.Companion companion = WidgetPruneUsers.INSTANCE;
                long id2 = model.getGuild().getId();
                FragmentManager parentFragmentManager = WidgetServerSettingsMembers.this.getParentFragmentManager();
                C12238m.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
                companion.create(id2, parentFragmentManager);
            }
        }, null, 4, null);
        setActionBarTitle(C5419R.string.member_list);
        setActionBarSubtitle(model.getGuild().getName());
        AppViewFlipper appViewFlipper = getBinding().f17712e;
        C12238m.checkNotNullExpressionValue(appViewFlipper, "binding.serverSettingsMembersViewFlipper");
        appViewFlipper.setDisplayedChild((!model.getMemberItems().isEmpty() ? 1 : 0) ^ 1);
        if (!C12238m.areEqual(this.guildRoles, model.getRoles())) {
            this.guildRoles = model.getRoles();
            setupRolesSpinner(model.getGuild().getId(), model.getRoles());
        }
        WidgetServerSettingsMembersAdapter widgetServerSettingsMembersAdapter = this.adapter;
        if (widgetServerSettingsMembersAdapter != null) {
            widgetServerSettingsMembersAdapter.configure(model, new C95902(model));
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
        final RolesSpinnerAdapter rolesSpinnerAdapter = new RolesSpinnerAdapter(requireContext(), arrayList);
        Spinner spinner = getBinding().f17711d;
        C12238m.checkNotNullExpressionValue(spinner, "binding.serverSettingsMembersRolesSpinner");
        spinner.setAdapter((SpinnerAdapter) rolesSpinnerAdapter);
        Spinner spinner2 = getBinding().f17711d;
        C12238m.checkNotNullExpressionValue(spinner2, "binding.serverSettingsMembersRolesSpinner");
        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { // from class: com.discord.widgets.servers.settings.members.WidgetServerSettingsMembers.setupRolesSpinner.1
            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id2) {
                C12238m.checkNotNullParameter(view, "view");
                WidgetServerSettingsMembers.this.roleFilterPublisher.onNext(Long.valueOf(rolesSpinnerAdapter.getItem(position).getId()));
            }

            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
    }

    @Override // com.discord.app.AppFragment, com.discord.app.AppLogger.InterfaceC5455a
    public LoggingConfig getLoggingConfig() {
        return this.loggingConfig;
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        C12238m.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        AppFragment.setActionBarDisplayHomeAsUpEnabled$default(this, false, 1, null);
        MGRecyclerAdapter.Companion companion = MGRecyclerAdapter.INSTANCE;
        RecyclerView recyclerView = getBinding().f17710c;
        C12238m.checkNotNullExpressionValue(recyclerView, "binding.serverSettingsMembersRecycler");
        this.adapter = (WidgetServerSettingsMembersAdapter) companion.configure(new WidgetServerSettingsMembersAdapter(recyclerView));
        if (getIsRecreated()) {
            return;
        }
        this.roleFilterPublisher.onNext(Long.valueOf(getGuildId()));
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        TextWatcher.Companion companion = TextWatcher.INSTANCE;
        TextInputLayout textInputLayout = getBinding().f17709b;
        C12238m.checkNotNullExpressionValue(textInputLayout, "binding.serverSettingsMembersNameSearch");
        EditText editText = textInputLayout.getEditText();
        C12238m.checkNotNull(editText);
        C12238m.checkNotNullExpressionValue(editText, "binding.serverSettingsMembersNameSearch.editText!!");
        companion.addBindedTextWatcher(this, editText, new Action1<String>() { // from class: com.discord.widgets.servers.settings.members.WidgetServerSettingsMembers.onViewBoundOrOnResume.1
            @Override // p658rx.functions.Action1
            public final void call(String str) {
                WidgetServerSettingsMembers.this.nameFilterPublisher.onNext(str);
            }
        });
        Subject<String, String> subject = this.nameFilterPublisher;
        TextInputLayout textInputLayout2 = getBinding().f17709b;
        C12238m.checkNotNullExpressionValue(textInputLayout2, "binding.serverSettingsMembersNameSearch");
        EditText editText2 = textInputLayout2.getEditText();
        subject.onNext(String.valueOf(editText2 != null ? editText2.getText() : null));
        Observable<String> observableM11110p = this.nameFilterPublisher.m11110p(750L, TimeUnit.MILLISECONDS);
        C12238m.checkNotNullExpressionValue(observableM11110p, "nameFilterPublisher\n    …0, TimeUnit.MILLISECONDS)");
        ObservableExtensionsKt.appSubscribe(observableM11110p, (Class<?>) WidgetServerSettingsMembers.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C95922());
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(WidgetServerSettingsMembersModel.INSTANCE.get(getGuildId(), this.nameFilterPublisher, this.roleFilterPublisher), this, null, 2, null), (Class<?>) WidgetServerSettingsMembers.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C95933());
    }
}
