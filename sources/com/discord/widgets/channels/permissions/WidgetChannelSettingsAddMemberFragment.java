package com.discord.widgets.channels.permissions;

import android.content.Context;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import b.a.d.i0;
import b.d.b.a.a;
import com.discord.R$layout;
import com.discord.api.permission.PermissionOverwrite$Type;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetChannelSettingsAddMemberBinding;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import d0.g;
import d0.z.d.a0;
import d0.z.d.m;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.KProperty;
import rx.Observable;
import rx.subjects.BehaviorSubject;

/* JADX INFO: compiled from: WidgetChannelSettingsAddMemberFragment.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChannelSettingsAddMemberFragment extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {a.d0(WidgetChannelSettingsAddMemberFragment.class, "binding", "getBinding()Lcom/discord/databinding/WidgetChannelSettingsAddMemberBinding;", 0)};
    public static final WidgetChannelSettingsAddMemberFragment$Companion Companion = new WidgetChannelSettingsAddMemberFragment$Companion(null);
    private static final String EXTRA_SHOW_ROLES_WITH_GUILD_PERMISSION = "EXTRA_SHOW_ROLES_WITH_GUILD_PERMISSION";

    /* JADX INFO: renamed from: adapter$delegate, reason: from kotlin metadata */
    private final Lazy adapter;

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* JADX INFO: renamed from: channelId$delegate, reason: from kotlin metadata */
    private final Lazy channelId;
    private final BehaviorSubject<String> querySubject;
    private final BehaviorSubject<Map<Long, PermissionOverwrite$Type>> selectedSubject;

    /* JADX INFO: renamed from: showRolesWithGuildPermission$delegate, reason: from kotlin metadata */
    private final Lazy showRolesWithGuildPermission;

    /* JADX INFO: renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    public WidgetChannelSettingsAddMemberFragment() {
        super(R$layout.widget_channel_settings_add_member);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetChannelSettingsAddMemberFragment$binding$2.INSTANCE, null, 2, null);
        this.adapter = g.lazy(new WidgetChannelSettingsAddMemberFragment$adapter$2(this));
        this.channelId = g.lazy(new WidgetChannelSettingsAddMemberFragment$channelId$2(this));
        this.showRolesWithGuildPermission = g.lazy(new WidgetChannelSettingsAddMemberFragment$showRolesWithGuildPermission$2(this));
        WidgetChannelSettingsAddMemberFragment$viewModel$2 widgetChannelSettingsAddMemberFragment$viewModel$2 = new WidgetChannelSettingsAddMemberFragment$viewModel$2(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, a0.getOrCreateKotlinClass(WidgetChannelSettingsAddMemberFragmentViewModel.class), new WidgetChannelSettingsAddMemberFragment$appViewModels$$inlined$viewModels$1(widgetChannelSettingsAddMemberFragment$viewModel$2), new i0(new WidgetChannelSettingsAddMemberFragment$viewModel$3(this)));
        this.querySubject = BehaviorSubject.l0("");
        this.selectedSubject = BehaviorSubject.l0(Collections.emptyMap());
    }

    public static final /* synthetic */ void access$configureUI(WidgetChannelSettingsAddMemberFragment widgetChannelSettingsAddMemberFragment, WidgetChannelSettingsAddMemberFragmentViewModel$ViewState widgetChannelSettingsAddMemberFragmentViewModel$ViewState) {
        widgetChannelSettingsAddMemberFragment.configureUI(widgetChannelSettingsAddMemberFragmentViewModel$ViewState);
    }

    public static final /* synthetic */ WidgetChannelSettingsAddMemberBinding access$getBinding$p(WidgetChannelSettingsAddMemberFragment widgetChannelSettingsAddMemberFragment) {
        return widgetChannelSettingsAddMemberFragment.getBinding();
    }

    public static final /* synthetic */ long access$getChannelId$p(WidgetChannelSettingsAddMemberFragment widgetChannelSettingsAddMemberFragment) {
        return widgetChannelSettingsAddMemberFragment.getChannelId();
    }

    public static final /* synthetic */ String access$getEXTRA_SHOW_ROLES_WITH_GUILD_PERMISSION$cp() {
        return EXTRA_SHOW_ROLES_WITH_GUILD_PERMISSION;
    }

    public static final /* synthetic */ BehaviorSubject access$getQuerySubject$p(WidgetChannelSettingsAddMemberFragment widgetChannelSettingsAddMemberFragment) {
        return widgetChannelSettingsAddMemberFragment.querySubject;
    }

    public static final /* synthetic */ BehaviorSubject access$getSelectedSubject$p(WidgetChannelSettingsAddMemberFragment widgetChannelSettingsAddMemberFragment) {
        return widgetChannelSettingsAddMemberFragment.selectedSubject;
    }

    public static final /* synthetic */ boolean access$getShowRolesWithGuildPermission$p(WidgetChannelSettingsAddMemberFragment widgetChannelSettingsAddMemberFragment) {
        return widgetChannelSettingsAddMemberFragment.getShowRolesWithGuildPermission();
    }

    public static final /* synthetic */ WidgetChannelSettingsAddMemberFragmentViewModel access$getViewModel$p(WidgetChannelSettingsAddMemberFragment widgetChannelSettingsAddMemberFragment) {
        return widgetChannelSettingsAddMemberFragment.getViewModel();
    }

    private final void configureUI(WidgetChannelSettingsAddMemberFragmentViewModel$ViewState viewState) {
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

    public final BehaviorSubject<Map<Long, PermissionOverwrite$Type>> getSelectedItemsSubject() {
        return this.selectedSubject;
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        Observable<String> observableR = this.querySubject.p(200L, TimeUnit.MILLISECONDS).r();
        m.checkNotNullExpressionValue(observableR, "querySubject\n        .de…  .distinctUntilChanged()");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(observableR, this, null, 2, null), WidgetChannelSettingsAddMemberFragment.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new WidgetChannelSettingsAddMemberFragment$onViewBoundOrOnResume$1(this), 62, (Object) null);
        getBinding().c.setText(getViewModel().getQuery());
        getBinding().c.a(this, new WidgetChannelSettingsAddMemberFragment$onViewBoundOrOnResume$2(this));
        getAdapter().setOnClickListener(new WidgetChannelSettingsAddMemberFragment$onViewBoundOrOnResume$3(this));
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeViewState(), this, null, 2, null), WidgetChannelSettingsAddMemberFragment.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new WidgetChannelSettingsAddMemberFragment$onViewBoundOrOnResume$4(this), 62, (Object) null);
    }
}
