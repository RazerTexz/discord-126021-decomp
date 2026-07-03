package com.discord.widgets.channels.permissions;

import androidx.core.os.BundleKt;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import com.discord.C5419R;
import com.discord.api.permission.PermissionOverwrite;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetChannelSettingsAddMemberBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.error.Error;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.discord.widgets.channels.permissions.WidgetChannelSettingsAddMemberFragmentViewModel;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import p007b.p008a.p018d.C0869i0;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.C12083g;
import p507d0.C12116o;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12216a0;
import p507d0.p592z.p594d.C12238m;
import p658rx.Observable;
import p658rx.Subscription;
import p658rx.subjects.BehaviorSubject;

/* JADX INFO: compiled from: WidgetChannelSettingsAddMemberFragment.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChannelSettingsAddMemberFragment extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {C1643a.m846d0(WidgetChannelSettingsAddMemberFragment.class, "binding", "getBinding()Lcom/discord/databinding/WidgetChannelSettingsAddMemberBinding;", 0)};

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String EXTRA_SHOW_ROLES_WITH_GUILD_PERMISSION = "EXTRA_SHOW_ROLES_WITH_GUILD_PERMISSION";

    /* JADX INFO: renamed from: adapter$delegate, reason: from kotlin metadata */
    private final Lazy adapter;

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* JADX INFO: renamed from: channelId$delegate, reason: from kotlin metadata */
    private final Lazy channelId;
    private final BehaviorSubject<String> querySubject;
    private final BehaviorSubject<Map<Long, PermissionOverwrite.Type>> selectedSubject;

    /* JADX INFO: renamed from: showRolesWithGuildPermission$delegate, reason: from kotlin metadata */
    private final Lazy showRolesWithGuildPermission;

    /* JADX INFO: renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    /* JADX INFO: compiled from: WidgetChannelSettingsAddMemberFragment.kt */
    public static final class Companion {
        private Companion() {
        }

        public final WidgetChannelSettingsAddMemberFragment create(long channelId, boolean showRolesWithGuildPermission) {
            WidgetChannelSettingsAddMemberFragment widgetChannelSettingsAddMemberFragment = new WidgetChannelSettingsAddMemberFragment();
            widgetChannelSettingsAddMemberFragment.setArguments(BundleKt.bundleOf(C12116o.m10073to("com.discord.intent.extra.EXTRA_CHANNEL_ID", Long.valueOf(channelId)), C12116o.m10073to(WidgetChannelSettingsAddMemberFragment.EXTRA_SHOW_ROLES_WITH_GUILD_PERMISSION, Boolean.valueOf(showRolesWithGuildPermission))));
            return widgetChannelSettingsAddMemberFragment;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.channels.permissions.WidgetChannelSettingsAddMemberFragment$onViewBoundOrOnResume$1 */
    /* JADX INFO: compiled from: WidgetChannelSettingsAddMemberFragment.kt */
    public static final class C75241 extends AbstractC12240o implements Function1<String, Unit> {
        public C75241() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(String str) {
            invoke2(str);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(String str) {
            WidgetChannelSettingsAddMemberFragmentViewModel viewModel = WidgetChannelSettingsAddMemberFragment.this.getViewModel();
            C12238m.checkNotNullExpressionValue(str, "it");
            viewModel.updateQuery(str);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.channels.permissions.WidgetChannelSettingsAddMemberFragment$onViewBoundOrOnResume$2 */
    /* JADX INFO: compiled from: WidgetChannelSettingsAddMemberFragment.kt */
    public static final class C75252 extends AbstractC12240o implements Function1<String, Unit> {
        public C75252() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(String str) {
            invoke2(str);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(String str) {
            C12238m.checkNotNullParameter(str, "it");
            WidgetChannelSettingsAddMemberFragment.this.querySubject.onNext(str);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.channels.permissions.WidgetChannelSettingsAddMemberFragment$onViewBoundOrOnResume$3 */
    /* JADX INFO: compiled from: WidgetChannelSettingsAddMemberFragment.kt */
    public static final class C75263 extends AbstractC12240o implements Function2<Long, PermissionOverwrite.Type, Unit> {
        public C75263() {
            super(2);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Long l, PermissionOverwrite.Type type) {
            invoke(l.longValue(), type);
            return Unit.f27425a;
        }

        public final void invoke(long j, PermissionOverwrite.Type type) {
            C12238m.checkNotNullParameter(type, "type");
            WidgetChannelSettingsAddMemberFragment.this.getViewModel().toggleItem(j, type);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.channels.permissions.WidgetChannelSettingsAddMemberFragment$onViewBoundOrOnResume$4 */
    /* JADX INFO: compiled from: WidgetChannelSettingsAddMemberFragment.kt */
    public static final class C75274 extends AbstractC12240o implements Function1<WidgetChannelSettingsAddMemberFragmentViewModel.ViewState, Unit> {
        public C75274() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(WidgetChannelSettingsAddMemberFragmentViewModel.ViewState viewState) {
            invoke2(viewState);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(WidgetChannelSettingsAddMemberFragmentViewModel.ViewState viewState) {
            C12238m.checkNotNullParameter(viewState, "viewState");
            WidgetChannelSettingsAddMemberFragment.this.configureUI(viewState);
            WidgetChannelSettingsAddMemberFragment.this.selectedSubject.onNext(viewState.getSelected());
        }
    }

    public WidgetChannelSettingsAddMemberFragment() {
        super(C5419R.layout.widget_channel_settings_add_member);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetChannelSettingsAddMemberFragment$binding$2.INSTANCE, null, 2, null);
        this.adapter = C12083g.lazy(new WidgetChannelSettingsAddMemberFragment$adapter$2(this));
        this.channelId = C12083g.lazy(new WidgetChannelSettingsAddMemberFragment$channelId$2(this));
        this.showRolesWithGuildPermission = C12083g.lazy(new C7528x94d74945(this));
        WidgetChannelSettingsAddMemberFragment$viewModel$2 widgetChannelSettingsAddMemberFragment$viewModel$2 = new WidgetChannelSettingsAddMemberFragment$viewModel$2(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, C12216a0.getOrCreateKotlinClass(WidgetChannelSettingsAddMemberFragmentViewModel.class), new C7523xeed7a80a(widgetChannelSettingsAddMemberFragment$viewModel$2), new C0869i0(new WidgetChannelSettingsAddMemberFragment$viewModel$3(this)));
        this.querySubject = BehaviorSubject.m11130l0("");
        this.selectedSubject = BehaviorSubject.m11130l0(Collections.emptyMap());
    }

    private final void configureUI(WidgetChannelSettingsAddMemberFragmentViewModel.ViewState viewState) {
        getAdapter().setData(viewState.getItems());
    }

    private final AddMemberAdapter getAdapter() {
        return (AddMemberAdapter) this.adapter.getValue();
    }

    private final WidgetChannelSettingsAddMemberBinding getBinding() {
        return (WidgetChannelSettingsAddMemberBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final long getChannelId() {
        return ((Number) this.channelId.getValue()).longValue();
    }

    private final boolean getShowRolesWithGuildPermission() {
        return ((Boolean) this.showRolesWithGuildPermission.getValue()).booleanValue();
    }

    private final WidgetChannelSettingsAddMemberFragmentViewModel getViewModel() {
        return (WidgetChannelSettingsAddMemberFragmentViewModel) this.viewModel.getValue();
    }

    public final BehaviorSubject<Map<Long, PermissionOverwrite.Type>> getSelectedItemsSubject() {
        return this.selectedSubject;
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        Observable<String> observableM11112r = this.querySubject.m11110p(200L, TimeUnit.MILLISECONDS).m11112r();
        C12238m.checkNotNullExpressionValue(observableM11112r, "querySubject\n        .de…  .distinctUntilChanged()");
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(observableM11112r, this, null, 2, null), (Class<?>) WidgetChannelSettingsAddMemberFragment.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C75241());
        getBinding().f15897c.setText(getViewModel().getQuery());
        getBinding().f15897c.m8553a(this, new C75252());
        getAdapter().setOnClickListener(new C75263());
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeViewState(), this, null, 2, null), (Class<?>) WidgetChannelSettingsAddMemberFragment.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C75274());
    }
}
