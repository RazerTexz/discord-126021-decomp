package com.discord.widgets.servers.auditlog;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;
import b.a.d.AppScreen2;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.api.permission.Permission;
import com.discord.api.role.GuildRole;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetAuditLogFilterBinding;
import com.discord.models.guild.Guild;
import com.discord.models.member.GuildMember;
import com.discord.models.user.User;
import com.discord.stores.StoreAuditLog;
import com.discord.stores.StoreGuilds;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUser;
import com.discord.utilities.auditlogs.AuditLogUtils;
import com.discord.utilities.error.Error;
import com.discord.utilities.mg_recycler.MGRecyclerAdapter;
import com.discord.utilities.mg_recycler.MGRecyclerDataPayload;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.search.SearchUtils;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.widgets.servers.auditlog.WidgetServerSettingsAuditLogFilter;
import com.discord.widgets.servers.auditlog.WidgetServerSettingsAuditLogFilterAdapter;
import com.google.android.material.textfield.TextInputLayout;
import d0.f0._Sequences2;
import d0.f0.n;
import d0.g0.StringsJVM;
import d0.t.CollectionsJVM;
import d0.t._Collections;
import d0.t._Maps;
import d0.u.a;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import j0.k.Func1;
import j0.l.e.ScalarSynchronousObservable;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import kotlin.sequences.Sequence;
import rx.Observable;
import rx.Subscription;
import rx.functions.Func3;
import rx.functions.Func5;
import rx.subjects.BehaviorSubject;

/* JADX INFO: compiled from: WidgetServerSettingsAuditLogFilter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettingsAuditLogFilter extends AppFragment {
    private static final String ARG_FILTER_TYPE = "ARG_FILTER_TYPE";
    private static final String ARG_GUILD_ID = "ARG_GUILD_ID";
    private WidgetServerSettingsAuditLogFilterAdapter adapter;

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private final BehaviorSubject<String> filterPublisher;
    private Integer filterType;
    private Long guildId;
    private final Function0<Unit> onFilterSelectedCallback;
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.d0(WidgetServerSettingsAuditLogFilter.class, "binding", "getBinding()Lcom/discord/databinding/WidgetAuditLogFilterBinding;", 0)};

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: compiled from: WidgetServerSettingsAuditLogFilter.kt */
    public static final class Companion {
        private Companion() {
        }

        public final void show(Context context, long guildId, int filterType) {
            Intrinsics3.checkNotNullParameter(context, "context");
            Intent intentPutExtra = new Intent().putExtra(WidgetServerSettingsAuditLogFilter.ARG_GUILD_ID, guildId).putExtra(WidgetServerSettingsAuditLogFilter.ARG_FILTER_TYPE, filterType);
            Intrinsics3.checkNotNullExpressionValue(intentPutExtra, "Intent()\n          .putE…_FILTER_TYPE, filterType)");
            AppScreen2.d(context, WidgetServerSettingsAuditLogFilter.class, intentPutExtra);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: compiled from: WidgetServerSettingsAuditLogFilter.kt */
    public static final class Model {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final List<MGRecyclerDataPayload> listItems;

        /* JADX INFO: compiled from: WidgetServerSettingsAuditLogFilter.kt */
        public static final class Companion {
            private Companion() {
            }

            private final Observable<Set<Long>> getPermissionUserIds(long guildId) {
                StoreGuilds guilds = StoreStream.INSTANCE.getGuilds();
                Observable<Set<Long>> observableR = Observable.i(guilds.observeGuild(guildId), guilds.observeRoles(guildId), guilds.observeComputed(guildId), new Func3<Guild, Map<Long, ? extends GuildRole>, Map<Long, ? extends GuildMember>, Set<? extends Long>>() { // from class: com.discord.widgets.servers.auditlog.WidgetServerSettingsAuditLogFilter$Model$Companion$getPermissionUserIds$1

                    /* JADX INFO: renamed from: com.discord.widgets.servers.auditlog.WidgetServerSettingsAuditLogFilter$Model$Companion$getPermissionUserIds$1$1, reason: invalid class name */
                    /* JADX INFO: compiled from: WidgetServerSettingsAuditLogFilter.kt */
                    public static final class AnonymousClass1 extends Lambda implements Function1<Map.Entry<? extends Long, ? extends GuildMember>, Boolean> {
                        public final /* synthetic */ Guild $guild;
                        public final /* synthetic */ Map $roles;

                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        public AnonymousClass1(Guild guild, Map map) {
                            super(1);
                            this.$guild = guild;
                            this.$roles = map;
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Boolean invoke(Map.Entry<? extends Long, ? extends GuildMember> entry) {
                            return Boolean.valueOf(invoke2((Map.Entry<Long, GuildMember>) entry));
                        }

                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final boolean invoke2(Map.Entry<Long, GuildMember> entry) {
                            boolean z2;
                            Intrinsics3.checkNotNullParameter(entry, "<name for destructuring parameter 0>");
                            long jLongValue = entry.getKey().longValue();
                            GuildMember value = entry.getValue();
                            Guild guild = this.$guild;
                            if (guild != null && jLongValue == guild.getOwnerId()) {
                                return true;
                            }
                            List<Long> roles = value.getRoles();
                            if ((roles instanceof Collection) && roles.isEmpty()) {
                                z2 = false;
                            } else {
                                Iterator<T> it = roles.iterator();
                                while (it.hasNext()) {
                                    GuildRole guildRole = (GuildRole) this.$roles.get(Long.valueOf(((Number) it.next()).longValue()));
                                    if (((guildRole != null ? guildRole.getPermissions() : 0L) & Permission.MANAGEMENT_PERMISSIONS) > 0) {
                                        z2 = true;
                                    }
                                }
                                z2 = false;
                            }
                            return z2;
                        }
                    }

                    /* JADX INFO: renamed from: com.discord.widgets.servers.auditlog.WidgetServerSettingsAuditLogFilter$Model$Companion$getPermissionUserIds$1$2, reason: invalid class name */
                    /* JADX INFO: compiled from: WidgetServerSettingsAuditLogFilter.kt */
                    public static final class AnonymousClass2 extends Lambda implements Function1<Map.Entry<? extends Long, ? extends GuildMember>, Long> {
                        public static final AnonymousClass2 INSTANCE = new AnonymousClass2();

                        public AnonymousClass2() {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Long invoke(Map.Entry<? extends Long, ? extends GuildMember> entry) {
                            return Long.valueOf(invoke2((Map.Entry<Long, GuildMember>) entry));
                        }

                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final long invoke2(Map.Entry<Long, GuildMember> entry) {
                            Intrinsics3.checkNotNullParameter(entry, "it");
                            return entry.getKey().longValue();
                        }
                    }

                    @Override // rx.functions.Func3
                    public /* bridge */ /* synthetic */ Set<? extends Long> call(Guild guild, Map<Long, ? extends GuildRole> map, Map<Long, ? extends GuildMember> map2) {
                        return call2(guild, (Map<Long, GuildRole>) map, (Map<Long, GuildMember>) map2);
                    }

                    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
                    public final Set<Long> call2(Guild guild, Map<Long, GuildRole> map, Map<Long, GuildMember> map2) {
                        Intrinsics3.checkNotNullExpressionValue(map2, "members");
                        return _Sequences2.toSet(_Sequences2.map(_Sequences2.filter(_Maps.asSequence(map2), new AnonymousClass1(guild, map)), AnonymousClass2.INSTANCE));
                    }
                }).r();
                Intrinsics3.checkNotNullExpressionValue(observableR, "Observable\n            .…  .distinctUntilChanged()");
                return observableR;
            }

            @SuppressLint({"DefaultLocale"})
            public final Observable<Model> get(final Context context, long guildId, final int filterType, Observable<String> filterPublisher) {
                Intrinsics3.checkNotNullParameter(context, "context");
                Intrinsics3.checkNotNullParameter(filterPublisher, "filterPublisher");
                StoreStream.Companion companion = StoreStream.INSTANCE;
                Observable<Model> observableR = Observable.g(companion.getAuditLog().observeAuditLogState(guildId), getPermissionUserIds(guildId).Y(new Func1<Set<? extends Long>, Observable<? extends Map<Long, ? extends User>>>() { // from class: com.discord.widgets.servers.auditlog.WidgetServerSettingsAuditLogFilter$Model$Companion$get$1
                    @Override // j0.k.Func1
                    public /* bridge */ /* synthetic */ Observable<? extends Map<Long, ? extends User>> call(Set<? extends Long> set) {
                        return call2((Set<Long>) set);
                    }

                    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
                    public final Observable<? extends Map<Long, User>> call2(Set<Long> set) {
                        StoreUser users = StoreStream.INSTANCE.getUsers();
                        Intrinsics3.checkNotNullExpressionValue(set, "it");
                        return users.observeUsers(set);
                    }
                }), companion.getGuilds().observeComputed(guildId), new ScalarSynchronousObservable(AuditLogUtils.INSTANCE.getALL_ACTION_TYPES()), ObservableExtensionsKt.leadingEdgeThrottle(filterPublisher, 100L, TimeUnit.MILLISECONDS).r(), new Func5<StoreAuditLog.AuditLogState, Map<Long, ? extends User>, Map<Long, ? extends GuildMember>, List<? extends Integer>, String, Model>() { // from class: com.discord.widgets.servers.auditlog.WidgetServerSettingsAuditLogFilter$Model$Companion$get$2

                    /* JADX INFO: renamed from: com.discord.widgets.servers.auditlog.WidgetServerSettingsAuditLogFilter$Model$Companion$get$2$1, reason: invalid class name */
                    /* JADX INFO: compiled from: WidgetServerSettingsAuditLogFilter.kt */
                    public static final class AnonymousClass1 extends Lambda implements Function1<Integer, Boolean> {
                        public final /* synthetic */ String $filterText;

                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        public AnonymousClass1(String str) {
                            super(1);
                            this.$filterText = str;
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Boolean invoke(Integer num) {
                            return Boolean.valueOf(invoke(num.intValue()));
                        }

                        public final boolean invoke(int i) {
                            SearchUtils searchUtils = SearchUtils.INSTANCE;
                            String str = this.$filterText;
                            Intrinsics3.checkNotNullExpressionValue(str, "filterText");
                            Objects.requireNonNull(str, "null cannot be cast to non-null type java.lang.String");
                            String lowerCase = str.toLowerCase();
                            Intrinsics3.checkNotNullExpressionValue(lowerCase, "(this as java.lang.String).toLowerCase()");
                            String string = context.getString(AuditLogUtils.INSTANCE.getActionName(i));
                            Intrinsics3.checkNotNullExpressionValue(string, "context.getString(AuditLogUtils.getActionName(it))");
                            Objects.requireNonNull(string, "null cannot be cast to non-null type java.lang.String");
                            String lowerCase2 = string.toLowerCase();
                            Intrinsics3.checkNotNullExpressionValue(lowerCase2, "(this as java.lang.String).toLowerCase()");
                            return searchUtils.fuzzyMatch(lowerCase, lowerCase2);
                        }
                    }

                    /* JADX INFO: renamed from: com.discord.widgets.servers.auditlog.WidgetServerSettingsAuditLogFilter$Model$Companion$get$2$2, reason: invalid class name */
                    /* JADX INFO: compiled from: WidgetServerSettingsAuditLogFilter.kt */
                    public static final class AnonymousClass2 extends Lambda implements Function1<Integer, WidgetServerSettingsAuditLogFilterAdapter.AuditLogActionFilterItem> {
                        public final /* synthetic */ StoreAuditLog.AuditLogState $auditLogState;

                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        public AnonymousClass2(StoreAuditLog.AuditLogState auditLogState) {
                            super(1);
                            this.$auditLogState = auditLogState;
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ WidgetServerSettingsAuditLogFilterAdapter.AuditLogActionFilterItem invoke(Integer num) {
                            return invoke(num.intValue());
                        }

                        public final WidgetServerSettingsAuditLogFilterAdapter.AuditLogActionFilterItem invoke(int i) {
                            String string = context.getString(AuditLogUtils.INSTANCE.getActionName(i));
                            Intrinsics3.checkNotNullExpressionValue(string, "context.getString(AuditLogUtils.getActionName(it))");
                            return new WidgetServerSettingsAuditLogFilterAdapter.AuditLogActionFilterItem(i, string, this.$auditLogState.getFilter().getActionFilter() == i);
                        }
                    }

                    @Override // rx.functions.Func5
                    public /* bridge */ /* synthetic */ WidgetServerSettingsAuditLogFilter.Model call(StoreAuditLog.AuditLogState auditLogState, Map<Long, ? extends User> map, Map<Long, ? extends GuildMember> map2, List<? extends Integer> list, String str) {
                        return call2(auditLogState, map, (Map<Long, GuildMember>) map2, (List<Integer>) list, str);
                    }

                    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
                    public final WidgetServerSettingsAuditLogFilter.Model call2(StoreAuditLog.AuditLogState auditLogState, Map<Long, ? extends User> map, Map<Long, GuildMember> map2, List<Integer> list, String str) {
                        Sequence sequenceEmptySequence;
                        if (filterType != 0) {
                            Intrinsics3.checkNotNullExpressionValue(list, "actions");
                            return new WidgetServerSettingsAuditLogFilter.Model(_Sequences2.toList(_Sequences2.sortedWith(_Sequences2.map(_Sequences2.filter(_Collections.asSequence(list), new AnonymousClass1(str)), new AnonymousClass2(auditLogState)), new Comparator() { // from class: com.discord.widgets.servers.auditlog.WidgetServerSettingsAuditLogFilter$Model$Companion$get$2$$special$$inlined$sortedBy$2
                                /* JADX WARN: Multi-variable type inference failed */
                                @Override // java.util.Comparator
                                public final int compare(T t, T t2) {
                                    return a.compareValues(Boolean.valueOf(!((WidgetServerSettingsAuditLogFilterAdapter.AuditLogActionFilterItem) t).getIsChecked()), Boolean.valueOf(!((WidgetServerSettingsAuditLogFilterAdapter.AuditLogActionFilterItem) t2).getIsChecked()));
                                }
                            })));
                        }
                        Intrinsics3.checkNotNullExpressionValue(str, "filterText");
                        if (StringsJVM.isBlank(str)) {
                            sequenceEmptySequence = _Collections.asSequence(CollectionsJVM.listOf(new WidgetServerSettingsAuditLogFilterAdapter.AuditLogUserFilterItem(null, null, 0L, context.getString(R.string.guild_settings_filter_all_users), null, auditLogState.getFilter().getUserFilter() == 0)));
                        } else {
                            sequenceEmptySequence = n.emptySequence();
                        }
                        return new WidgetServerSettingsAuditLogFilter.Model(_Sequences2.toList(_Sequences2.sortedWith(_Sequences2.plus(sequenceEmptySequence, _Sequences2.map(_Sequences2.filterNotNull(_Sequences2.filter(_Collections.asSequence(map.values()), new WidgetServerSettingsAuditLogFilter4(str))), new WidgetServerSettingsAuditLogFilter5(map2, auditLogState))), new Comparator() { // from class: com.discord.widgets.servers.auditlog.WidgetServerSettingsAuditLogFilter$Model$Companion$get$2$$special$$inlined$sortedBy$1
                            /* JADX WARN: Multi-variable type inference failed */
                            @Override // java.util.Comparator
                            public final int compare(T t, T t2) {
                                return a.compareValues(Boolean.valueOf(!((WidgetServerSettingsAuditLogFilterAdapter.AuditLogUserFilterItem) t).getIsChecked()), Boolean.valueOf(!((WidgetServerSettingsAuditLogFilterAdapter.AuditLogUserFilterItem) t2).getIsChecked()));
                            }
                        })));
                    }
                }).r();
                Intrinsics3.checkNotNullExpressionValue(observableR, "Observable\n             …  .distinctUntilChanged()");
                return observableR;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public Model(List<? extends MGRecyclerDataPayload> list) {
            Intrinsics3.checkNotNullParameter(list, "listItems");
            this.listItems = list;
        }

        public final List<MGRecyclerDataPayload> getListItems() {
            return this.listItems;
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.servers.auditlog.WidgetServerSettingsAuditLogFilter$onViewBoundOrOnResume$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetServerSettingsAuditLogFilter.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<Error, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Error error) {
            invoke2(error);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Error error) {
            Intrinsics3.checkNotNullParameter(error, "it");
            FragmentActivity fragmentActivityE = WidgetServerSettingsAuditLogFilter.this.e();
            if (fragmentActivityE != null) {
                fragmentActivityE.finish();
            }
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.servers.auditlog.WidgetServerSettingsAuditLogFilter$onViewBoundOrOnResume$2, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetServerSettingsAuditLogFilter.kt */
    public static final /* synthetic */ class AnonymousClass2 extends FunctionReferenceImpl implements Function1<Model, Unit> {
        public AnonymousClass2(WidgetServerSettingsAuditLogFilter widgetServerSettingsAuditLogFilter) {
            super(1, widgetServerSettingsAuditLogFilter, WidgetServerSettingsAuditLogFilter.class, "configureUI", "configureUI(Lcom/discord/widgets/servers/auditlog/WidgetServerSettingsAuditLogFilter$Model;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Model model) {
            invoke2(model);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Model model) {
            Intrinsics3.checkNotNullParameter(model, "p1");
            ((WidgetServerSettingsAuditLogFilter) this.receiver).configureUI(model);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.servers.auditlog.WidgetServerSettingsAuditLogFilter$onViewCreated$2, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetServerSettingsAuditLogFilter.kt */
    public static final class AnonymousClass2 extends Lambda implements Function1<Editable, Unit> {
        public AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Editable editable) {
            invoke2(editable);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Editable editable) {
            Intrinsics3.checkNotNullParameter(editable, "it");
            WidgetServerSettingsAuditLogFilter.this.filterPublisher.onNext(editable.toString());
        }
    }

    public WidgetServerSettingsAuditLogFilter() {
        super(R.layout.widget_audit_log_filter);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetServerSettingsAuditLogFilter7.INSTANCE, null, 2, null);
        this.filterPublisher = BehaviorSubject.l0("");
        this.onFilterSelectedCallback = new WidgetServerSettingsAuditLogFilter8(this);
    }

    private final void configureUI(Model model) {
        if (this.filterType == null) {
            FragmentActivity fragmentActivityE = e();
            if (fragmentActivityE != null) {
                fragmentActivityE.finish();
                return;
            }
            return;
        }
        WidgetServerSettingsAuditLogFilterAdapter widgetServerSettingsAuditLogFilterAdapter = this.adapter;
        if (widgetServerSettingsAuditLogFilterAdapter != null) {
            widgetServerSettingsAuditLogFilterAdapter.configure(model.getListItems(), this.onFilterSelectedCallback);
        }
    }

    private final WidgetAuditLogFilterBinding getBinding() {
        return (WidgetAuditLogFilterBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    @Override // com.discord.app.AppFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        AppFragment.hideKeyboard$default(this, null, 1, null);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        this.filterType = Integer.valueOf(getMostRecentIntent().getIntExtra(ARG_FILTER_TYPE, -1));
        this.guildId = Long.valueOf(getMostRecentIntent().getLongExtra(ARG_GUILD_ID, 0L));
        Model.Companion companion = Model.INSTANCE;
        Context contextRequireContext = requireContext();
        Long l = this.guildId;
        long jLongValue = l != null ? l.longValue() : 0L;
        Integer num = this.filterType;
        if (num != null) {
            int iIntValue = num.intValue();
            BehaviorSubject<String> behaviorSubject = this.filterPublisher;
            Intrinsics3.checkNotNullExpressionValue(behaviorSubject, "filterPublisher");
            ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.computationLatest(companion.get(contextRequireContext, jLongValue, iIntValue, behaviorSubject)), this, null, 2, null), (Class<?>) WidgetServerSettingsAuditLogFilter.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : new AnonymousClass1()), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass2(this));
        }
    }

    @Override // com.discord.app.AppFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        AppFragment.setActionBarDisplayHomeAsUpEnabled$default(this, false, 1, null);
        MGRecyclerAdapter.Companion companion = MGRecyclerAdapter.INSTANCE;
        RecyclerView recyclerView = getBinding().c;
        Intrinsics3.checkNotNullExpressionValue(recyclerView, "binding.auditLogFilterRecycler");
        WidgetServerSettingsAuditLogFilterAdapter widgetServerSettingsAuditLogFilterAdapter = (WidgetServerSettingsAuditLogFilterAdapter) companion.configure(new WidgetServerSettingsAuditLogFilterAdapter(recyclerView));
        widgetServerSettingsAuditLogFilterAdapter.setOnAuditLogAvatarClicked(new WidgetServerSettingsAuditLogFilter9(this));
        this.adapter = widgetServerSettingsAuditLogFilterAdapter;
        setActionBarTitle(R.string.guild_settings_label_audit_log);
        Integer num = this.filterType;
        setActionBarSubtitle((num != null && num.intValue() == 0) ? R.string.guild_settings_filter_user : R.string.guild_settings_filter_action);
        TextInputLayout textInputLayout = getBinding().f2228b;
        Intrinsics3.checkNotNullExpressionValue(textInputLayout, "binding.auditLogFilterInput");
        Integer num2 = this.filterType;
        ViewExtensions.setSingleLineHint(textInputLayout, (num2 != null && num2.intValue() == 0) ? R.string.search_members : R.string.search_actions);
        TextInputLayout textInputLayout2 = getBinding().f2228b;
        Intrinsics3.checkNotNullExpressionValue(textInputLayout2, "binding.auditLogFilterInput");
        ViewExtensions.addBindedTextWatcher(textInputLayout2, this, new AnonymousClass2());
    }
}
