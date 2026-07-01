package com.discord.widgets.servers.community;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentViewModelLazyKt;
import b.a.d.AppScreen2;
import b.a.d.AppToast;
import b.a.d.AppViewModelDelegates2;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetEnableCommunityStepsBinding;
import com.discord.utilities.error.Error;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.views.steps.StepsView;
import com.discord.widgets.servers.community.WidgetServerSettingsCommunityOverview;
import com.discord.widgets.servers.community.WidgetServerSettingsEnableCommunityViewModel;
import d0.LazyJVM;
import d0.t.Collections2;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import d0.z.d.Reflection2;
import j0.k.Func1;
import java.util.Objects;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import rx.Observable;
import rx.Subscription;
import rx.functions.Func0;

/* JADX INFO: compiled from: WidgetServerSettingsEnableCommunitySteps.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettingsEnableCommunitySteps extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.d0(WidgetServerSettingsEnableCommunitySteps.class, "binding", "getBinding()Lcom/discord/databinding/WidgetEnableCommunityStepsBinding;", 0)};

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String INTENT_EXTRA_GUILD_ID = "INTENT_EXTRA_GUILD_ID";

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* JADX INFO: renamed from: guildId$delegate, reason: from kotlin metadata */
    private final Lazy guildId;

    /* JADX INFO: renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    /* JADX INFO: compiled from: WidgetServerSettingsEnableCommunitySteps.kt */
    public static final class Companion {
        private Companion() {
        }

        public final void create(Context context, long guildId) {
            Intrinsics3.checkNotNullParameter(context, "context");
            Intent intentPutExtra = new Intent().putExtra("INTENT_EXTRA_GUILD_ID", guildId);
            Intrinsics3.checkNotNullExpressionValue(intentPutExtra, "Intent().putExtra(INTENT_EXTRA_GUILD_ID, guildId)");
            AppScreen2.d(context, WidgetServerSettingsEnableCommunitySteps.class, intentPutExtra);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.servers.community.WidgetServerSettingsEnableCommunitySteps$onViewBound$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetServerSettingsEnableCommunitySteps.kt */
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public AnonymousClass1() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            FragmentActivity fragmentActivityE = WidgetServerSettingsEnableCommunitySteps.this.e();
            if (fragmentActivityE != null) {
                fragmentActivityE.finish();
            }
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.servers.community.WidgetServerSettingsEnableCommunitySteps$onViewBound$2, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetServerSettingsEnableCommunitySteps.kt */
    public static final class AnonymousClass2 extends Lambda implements Function1<Integer, Unit> {
        public AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
            invoke(num.intValue());
            return Unit.a;
        }

        public final void invoke(int i) {
            WidgetServerSettingsEnableCommunitySteps.this.getViewModel().updateCurrentPage(i);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.servers.community.WidgetServerSettingsEnableCommunitySteps$onViewBoundOrOnResume$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetServerSettingsEnableCommunitySteps.kt */
    public static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<WidgetServerSettingsEnableCommunityViewModel.ViewState, Unit> {
        public AnonymousClass1(WidgetServerSettingsEnableCommunitySteps widgetServerSettingsEnableCommunitySteps) {
            super(1, widgetServerSettingsEnableCommunitySteps, WidgetServerSettingsEnableCommunitySteps.class, "configureUI", "configureUI(Lcom/discord/widgets/servers/community/WidgetServerSettingsEnableCommunityViewModel$ViewState;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(WidgetServerSettingsEnableCommunityViewModel.ViewState viewState) {
            invoke2(viewState);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(WidgetServerSettingsEnableCommunityViewModel.ViewState viewState) {
            Intrinsics3.checkNotNullParameter(viewState, "p1");
            ((WidgetServerSettingsEnableCommunitySteps) this.receiver).configureUI(viewState);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.servers.community.WidgetServerSettingsEnableCommunitySteps$onViewBoundOrOnResume$2, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetServerSettingsEnableCommunitySteps.kt */
    public static final class AnonymousClass2 extends Lambda implements Function1<WidgetServerSettingsEnableCommunityViewModel.ViewState.Loaded, Unit> {
        public AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(WidgetServerSettingsEnableCommunityViewModel.ViewState.Loaded loaded) {
            invoke2(loaded);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(WidgetServerSettingsEnableCommunityViewModel.ViewState.Loaded loaded) {
            Intrinsics3.checkNotNullParameter(loaded, "it");
            int currentPage = loaded.getCurrentPage();
            if (currentPage < 0) {
                WidgetServerSettingsEnableCommunitySteps.this.requireActivity().finish();
            } else {
                WidgetServerSettingsEnableCommunitySteps.this.getBinding().f2378b.b(currentPage);
            }
            WidgetServerSettingsEnableCommunitySteps.this.getBinding().f2378b.setIsNextButtonEnabled(loaded.getCommunityGuildConfig().getExplicitContentFilter() && loaded.getCommunityGuildConfig().getVerificationLevel());
            WidgetServerSettingsEnableCommunitySteps.this.getBinding().f2378b.setIsDoneButtonEnabled(loaded.getCommunityGuildConfig().isPrivacyPolicyAccepted());
            WidgetServerSettingsEnableCommunitySteps.this.getBinding().f2378b.setIsLoading(loaded.isLoading());
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.servers.community.WidgetServerSettingsEnableCommunitySteps$onViewBoundOrOnResume$3, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetServerSettingsEnableCommunitySteps.kt */
    public static final class AnonymousClass3 extends Lambda implements Function1<WidgetServerSettingsEnableCommunityViewModel.Event, Unit> {
        public AnonymousClass3() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(WidgetServerSettingsEnableCommunityViewModel.Event event) {
            invoke2(event);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(WidgetServerSettingsEnableCommunityViewModel.Event event) {
            Intrinsics3.checkNotNullParameter(event, "event");
            if (!Intrinsics3.areEqual(event, WidgetServerSettingsEnableCommunityViewModel.Event.SaveSuccess.INSTANCE)) {
                if (Intrinsics3.areEqual(event, WidgetServerSettingsEnableCommunityViewModel.Event.Error.INSTANCE)) {
                    AppToast.i(WidgetServerSettingsEnableCommunitySteps.this, R.string.guild_settings_public_update_failed, 0, 4);
                }
            } else {
                WidgetServerSettingsEnableCommunitySteps.this.requireActivity().finish();
                WidgetServerSettingsCommunityOverview.Companion companion = WidgetServerSettingsCommunityOverview.INSTANCE;
                FragmentActivity fragmentActivityRequireActivity = WidgetServerSettingsEnableCommunitySteps.this.requireActivity();
                Intrinsics3.checkNotNullExpressionValue(fragmentActivityRequireActivity, "requireActivity()");
                companion.create(fragmentActivityRequireActivity, WidgetServerSettingsEnableCommunitySteps.this.getGuildId());
            }
        }
    }

    public WidgetServerSettingsEnableCommunitySteps() {
        super(R.layout.widget_enable_community_steps);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetServerSettingsEnableCommunitySteps2.INSTANCE, null, 2, null);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection2.getOrCreateKotlinClass(WidgetServerSettingsEnableCommunityViewModel.class), new WidgetServerSettingsEnableCommunitySteps$appActivityViewModels$$inlined$activityViewModels$1(this), new AppViewModelDelegates2(new WidgetServerSettingsEnableCommunitySteps5(this)));
        this.guildId = LazyJVM.lazy(new WidgetServerSettingsEnableCommunitySteps3(this));
    }

    private final void configureUI(WidgetServerSettingsEnableCommunityViewModel.ViewState viewState) {
        if (Intrinsics3.areEqual(viewState, WidgetServerSettingsEnableCommunityViewModel.ViewState.Invalid.INSTANCE)) {
            requireActivity().finish();
        }
    }

    private final WidgetEnableCommunityStepsBinding getBinding() {
        return (WidgetEnableCommunityStepsBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final WidgetServerSettingsEnableCommunityViewModel getViewModel() {
        return (WidgetServerSettingsEnableCommunityViewModel) this.viewModel.getValue();
    }

    public final long getGuildId() {
        return ((Number) this.guildId.getValue()).longValue();
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        getBinding().f2378b.a(new StepsView.d(this, Collections2.listOf((Object[]) new StepsView.b.a[]{new StepsView.b.a(WidgetServerSettingsEnableCommunity.class, 0, 0, 0, null, null, null, null, false, false, false, 254), new StepsView.b.a(WidgetServerSettingsCommunityFirstStep.class, 0, 0, 0, null, null, null, null, false, false, false, 510), new StepsView.b.a(WidgetServerSettingsCommunitySecondStep.class, 0, 0, 0, null, null, null, null, false, false, false, 510), new StepsView.b.a(WidgetServerSettingsCommunityThirdStep.class, 0, 0, R.string.enable_community_button_text, null, null, null, new WidgetServerSettingsEnableCommunitySteps4(this), false, false, false, 374)})), new AnonymousClass1(), new AnonymousClass2());
        AppFragment.setOnBackPressed$default(this, new Func0<Boolean>() { // from class: com.discord.widgets.servers.community.WidgetServerSettingsEnableCommunitySteps.onViewBound.3
            @Override // rx.functions.Func0, java.util.concurrent.Callable
            public final Boolean call() {
                WidgetServerSettingsEnableCommunitySteps.this.getViewModel().goBackToPreviousPage();
                return Boolean.TRUE;
            }
        }, 0, 2, null);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        Observable<WidgetServerSettingsEnableCommunityViewModel.ViewState> observableR = getViewModel().observeViewState().r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "viewModel\n        .obser…  .distinctUntilChanged()");
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.bindToComponentLifecycle$default(observableR, this, null, 2, null), (Class<?>) WidgetServerSettingsEnableCommunitySteps.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass1(this));
        Observable observableG = ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeViewState(), this, null, 2, null).y(new Func1<Object, Boolean>() { // from class: com.discord.widgets.servers.community.WidgetServerSettingsEnableCommunitySteps$onViewBoundOrOnResume$$inlined$filterIs$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // j0.k.Func1
            public final Boolean call(Object obj) {
                return Boolean.valueOf(obj instanceof WidgetServerSettingsEnableCommunityViewModel.ViewState.Loaded);
            }
        }).G(new Func1<Object, T>() { // from class: com.discord.widgets.servers.community.WidgetServerSettingsEnableCommunitySteps$onViewBoundOrOnResume$$inlined$filterIs$2
            @Override // j0.k.Func1
            public final T call(Object obj) {
                Objects.requireNonNull(obj, "null cannot be cast to non-null type com.discord.widgets.servers.community.WidgetServerSettingsEnableCommunityViewModel.ViewState.Loaded");
                return (T) ((WidgetServerSettingsEnableCommunityViewModel.ViewState.Loaded) obj);
            }
        });
        Intrinsics3.checkNotNullExpressionValue(observableG, "filter { it is T }.map { it as T }");
        ObservableExtensionsKt.appSubscribe(observableG, (Class<?>) WidgetServerSettingsEnableCommunitySteps.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass2());
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeEvents(), this, null, 2, null), (Class<?>) WidgetServerSettingsEnableCommunitySteps.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass3());
    }
}
