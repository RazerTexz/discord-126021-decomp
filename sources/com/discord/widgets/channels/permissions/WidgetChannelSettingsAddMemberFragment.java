package com.discord.widgets.channels.permissions;

import androidx.core.os.Bundle2;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import b.a.d.AppViewModelDelegates5;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.api.permission.PermissionOverwrite;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetChannelSettingsAddMemberBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.error.Error;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.widgets.channels.permissions.WidgetChannelSettingsAddMemberFragmentViewModel;
import d0.LazyJVM;
import d0.Tuples;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import d0.z.d.Reflection2;
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
import rx.Observable;
import rx.Subscription;
import rx.subjects.BehaviorSubject;

/* JADX INFO: compiled from: WidgetChannelSettingsAddMemberFragment.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChannelSettingsAddMemberFragment extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.d0(WidgetChannelSettingsAddMemberFragment.class, "binding", "getBinding()Lcom/discord/databinding/WidgetChannelSettingsAddMemberBinding;", 0)};

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
            widgetChannelSettingsAddMemberFragment.setArguments(Bundle2.bundleOf(Tuples.to("com.discord.intent.extra.EXTRA_CHANNEL_ID", Long.valueOf(channelId)), Tuples.to(WidgetChannelSettingsAddMemberFragment.EXTRA_SHOW_ROLES_WITH_GUILD_PERMISSION, Boolean.valueOf(showRolesWithGuildPermission))));
            return widgetChannelSettingsAddMemberFragment;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.channels.permissions.WidgetChannelSettingsAddMemberFragment$onViewBoundOrOnResume$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetChannelSettingsAddMemberFragment.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<String, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(String str) {
            invoke2(str);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(String str) {
            WidgetChannelSettingsAddMemberFragmentViewModel viewModel = WidgetChannelSettingsAddMemberFragment.this.getViewModel();
            Intrinsics3.checkNotNullExpressionValue(str, "it");
            viewModel.updateQuery(str);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.channels.permissions.WidgetChannelSettingsAddMemberFragment$onViewBoundOrOnResume$2, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetChannelSettingsAddMemberFragment.kt */
    public static final class AnonymousClass2 extends Lambda implements Function1<String, Unit> {
        public AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(String str) {
            invoke2(str);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(String str) {
            Intrinsics3.checkNotNullParameter(str, "it");
            WidgetChannelSettingsAddMemberFragment.this.querySubject.onNext(str);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.channels.permissions.WidgetChannelSettingsAddMemberFragment$onViewBoundOrOnResume$3, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetChannelSettingsAddMemberFragment.kt */
    public static final class AnonymousClass3 extends Lambda implements Function2<Long, PermissionOverwrite.Type, Unit> {
        public AnonymousClass3() {
            super(2);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Long l, PermissionOverwrite.Type type) {
            invoke(l.longValue(), type);
            return Unit.a;
        }

        public final void invoke(long j, PermissionOverwrite.Type type) {
            Intrinsics3.checkNotNullParameter(type, "type");
            WidgetChannelSettingsAddMemberFragment.this.getViewModel().toggleItem(j, type);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.channels.permissions.WidgetChannelSettingsAddMemberFragment$onViewBoundOrOnResume$4, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetChannelSettingsAddMemberFragment.kt */
    public static final class AnonymousClass4 extends Lambda implements Function1<WidgetChannelSettingsAddMemberFragmentViewModel.ViewState, Unit> {
        public AnonymousClass4() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(WidgetChannelSettingsAddMemberFragmentViewModel.ViewState viewState) {
            invoke2(viewState);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(WidgetChannelSettingsAddMemberFragmentViewModel.ViewState viewState) {
            Intrinsics3.checkNotNullParameter(viewState, "viewState");
            WidgetChannelSettingsAddMemberFragment.this.configureUI(viewState);
            WidgetChannelSettingsAddMemberFragment.this.selectedSubject.onNext(viewState.getSelected());
        }
    }

    public WidgetChannelSettingsAddMemberFragment() {
        super(R.layout.widget_channel_settings_add_member);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetChannelSettingsAddMemberFragment3.INSTANCE, null, 2, null);
        this.adapter = LazyJVM.lazy(new WidgetChannelSettingsAddMemberFragment2(this));
        this.channelId = LazyJVM.lazy(new WidgetChannelSettingsAddMemberFragment4(this));
        this.showRolesWithGuildPermission = LazyJVM.lazy(new WidgetChannelSettingsAddMemberFragment5(this));
        WidgetChannelSettingsAddMemberFragment6 widgetChannelSettingsAddMemberFragment6 = new WidgetChannelSettingsAddMemberFragment6(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection2.getOrCreateKotlinClass(WidgetChannelSettingsAddMemberFragmentViewModel.class), new WidgetChannelSettingsAddMemberFragment$appViewModels$$inlined$viewModels$1(widgetChannelSettingsAddMemberFragment6), new AppViewModelDelegates5(new WidgetChannelSettingsAddMemberFragment7(this)));
        this.querySubject = BehaviorSubject.l0("");
        this.selectedSubject = BehaviorSubject.l0(Collections.emptyMap());
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
        Observable<String> observableR = this.querySubject.p(200L, TimeUnit.MILLISECONDS).r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "querySubject\n        .de…  .distinctUntilChanged()");
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(observableR, this, null, 2, null), (Class<?>) WidgetChannelSettingsAddMemberFragment.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass1());
        getBinding().c.setText(getViewModel().getQuery());
        getBinding().c.a(this, new AnonymousClass2());
        getAdapter().setOnClickListener(new AnonymousClass3());
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeViewState(), this, null, 2, null), (Class<?>) WidgetChannelSettingsAddMemberFragment.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass4());
    }
}
