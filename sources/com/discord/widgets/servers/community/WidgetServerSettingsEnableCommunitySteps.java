package com.discord.widgets.servers.community;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentViewModelLazyKt;
import com.discord.C5419R;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetEnableCommunityStepsBinding;
import com.discord.utilities.error.Error;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.discord.views.steps.StepsView;
import com.discord.widgets.servers.community.WidgetServerSettingsCommunityOverview;
import com.discord.widgets.servers.community.WidgetServerSettingsEnableCommunityViewModel;
import java.util.Objects;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import p007b.p008a.p018d.C0863f0;
import p007b.p008a.p018d.C0870j;
import p007b.p008a.p018d.C0876m;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.C12083g;
import p507d0.p580t.C12147n;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12216a0;
import p507d0.p592z.p594d.C12236k;
import p507d0.p592z.p594d.C12238m;
import p637j0.p641k.InterfaceC12589b;
import p658rx.Observable;
import p658rx.Subscription;
import p658rx.functions.Func0;

/* JADX INFO: compiled from: WidgetServerSettingsEnableCommunitySteps.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettingsEnableCommunitySteps extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {C1643a.m846d0(WidgetServerSettingsEnableCommunitySteps.class, "binding", "getBinding()Lcom/discord/databinding/WidgetEnableCommunityStepsBinding;", 0)};

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
            C12238m.checkNotNullParameter(context, "context");
            Intent intentPutExtra = new Intent().putExtra("INTENT_EXTRA_GUILD_ID", guildId);
            C12238m.checkNotNullExpressionValue(intentPutExtra, "Intent().putExtra(INTENT_EXTRA_GUILD_ID, guildId)");
            C0870j.m156d(context, WidgetServerSettingsEnableCommunitySteps.class, intentPutExtra);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.servers.community.WidgetServerSettingsEnableCommunitySteps$onViewBound$1 */
    /* JADX INFO: compiled from: WidgetServerSettingsEnableCommunitySteps.kt */
    public static final class C93971 extends AbstractC12240o implements Function0<Unit> {
        public C93971() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            FragmentActivity fragmentActivityM95e = WidgetServerSettingsEnableCommunitySteps.this.m95e();
            if (fragmentActivityM95e != null) {
                fragmentActivityM95e.finish();
            }
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.servers.community.WidgetServerSettingsEnableCommunitySteps$onViewBound$2 */
    /* JADX INFO: compiled from: WidgetServerSettingsEnableCommunitySteps.kt */
    public static final class C93982 extends AbstractC12240o implements Function1<Integer, Unit> {
        public C93982() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
            invoke(num.intValue());
            return Unit.f27425a;
        }

        public final void invoke(int i) {
            WidgetServerSettingsEnableCommunitySteps.this.getViewModel().updateCurrentPage(i);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.servers.community.WidgetServerSettingsEnableCommunitySteps$onViewBoundOrOnResume$1 */
    /* JADX INFO: compiled from: WidgetServerSettingsEnableCommunitySteps.kt */
    public static final /* synthetic */ class C94021 extends C12236k implements Function1<WidgetServerSettingsEnableCommunityViewModel.ViewState, Unit> {
        public C94021(WidgetServerSettingsEnableCommunitySteps widgetServerSettingsEnableCommunitySteps) {
            super(1, widgetServerSettingsEnableCommunitySteps, WidgetServerSettingsEnableCommunitySteps.class, "configureUI", "configureUI(Lcom/discord/widgets/servers/community/WidgetServerSettingsEnableCommunityViewModel$ViewState;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(WidgetServerSettingsEnableCommunityViewModel.ViewState viewState) {
            invoke2(viewState);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(WidgetServerSettingsEnableCommunityViewModel.ViewState viewState) {
            C12238m.checkNotNullParameter(viewState, "p1");
            ((WidgetServerSettingsEnableCommunitySteps) this.receiver).configureUI(viewState);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.servers.community.WidgetServerSettingsEnableCommunitySteps$onViewBoundOrOnResume$2 */
    /* JADX INFO: compiled from: WidgetServerSettingsEnableCommunitySteps.kt */
    public static final class C94032 extends AbstractC12240o implements Function1<WidgetServerSettingsEnableCommunityViewModel.ViewState.Loaded, Unit> {
        public C94032() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(WidgetServerSettingsEnableCommunityViewModel.ViewState.Loaded loaded) {
            invoke2(loaded);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(WidgetServerSettingsEnableCommunityViewModel.ViewState.Loaded loaded) {
            C12238m.checkNotNullParameter(loaded, "it");
            int currentPage = loaded.getCurrentPage();
            if (currentPage < 0) {
                WidgetServerSettingsEnableCommunitySteps.this.requireActivity().finish();
            } else {
                WidgetServerSettingsEnableCommunitySteps.this.getBinding().f16583b.m8610b(currentPage);
            }
            WidgetServerSettingsEnableCommunitySteps.this.getBinding().f16583b.setIsNextButtonEnabled(loaded.getCommunityGuildConfig().getExplicitContentFilter() && loaded.getCommunityGuildConfig().getVerificationLevel());
            WidgetServerSettingsEnableCommunitySteps.this.getBinding().f16583b.setIsDoneButtonEnabled(loaded.getCommunityGuildConfig().isPrivacyPolicyAccepted());
            WidgetServerSettingsEnableCommunitySteps.this.getBinding().f16583b.setIsLoading(loaded.isLoading());
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.servers.community.WidgetServerSettingsEnableCommunitySteps$onViewBoundOrOnResume$3 */
    /* JADX INFO: compiled from: WidgetServerSettingsEnableCommunitySteps.kt */
    public static final class C94043 extends AbstractC12240o implements Function1<WidgetServerSettingsEnableCommunityViewModel.Event, Unit> {
        public C94043() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(WidgetServerSettingsEnableCommunityViewModel.Event event) {
            invoke2(event);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(WidgetServerSettingsEnableCommunityViewModel.Event event) {
            C12238m.checkNotNullParameter(event, "event");
            if (!C12238m.areEqual(event, WidgetServerSettingsEnableCommunityViewModel.Event.SaveSuccess.INSTANCE)) {
                if (C12238m.areEqual(event, WidgetServerSettingsEnableCommunityViewModel.Event.Error.INSTANCE)) {
                    C0876m.m171i(WidgetServerSettingsEnableCommunitySteps.this, C5419R.string.guild_settings_public_update_failed, 0, 4);
                }
            } else {
                WidgetServerSettingsEnableCommunitySteps.this.requireActivity().finish();
                WidgetServerSettingsCommunityOverview.Companion companion = WidgetServerSettingsCommunityOverview.INSTANCE;
                FragmentActivity fragmentActivityRequireActivity = WidgetServerSettingsEnableCommunitySteps.this.requireActivity();
                C12238m.checkNotNullExpressionValue(fragmentActivityRequireActivity, "requireActivity()");
                companion.create(fragmentActivityRequireActivity, WidgetServerSettingsEnableCommunitySteps.this.getGuildId());
            }
        }
    }

    public WidgetServerSettingsEnableCommunitySteps() {
        super(C5419R.layout.widget_enable_community_steps);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetServerSettingsEnableCommunitySteps$binding$2.INSTANCE, null, 2, null);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, C12216a0.getOrCreateKotlinClass(WidgetServerSettingsEnableCommunityViewModel.class), new C9395x4876c14a(this), new C0863f0(new WidgetServerSettingsEnableCommunitySteps$viewModel$2(this)));
        this.guildId = C12083g.lazy(new WidgetServerSettingsEnableCommunitySteps$guildId$2(this));
    }

    private final void configureUI(WidgetServerSettingsEnableCommunityViewModel.ViewState viewState) {
        if (C12238m.areEqual(viewState, WidgetServerSettingsEnableCommunityViewModel.ViewState.Invalid.INSTANCE)) {
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
        C12238m.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        getBinding().f16583b.m8609a(new StepsView.C7125d(this, C12147n.listOf((Object[]) new StepsView.AbstractC7123b.a[]{new StepsView.AbstractC7123b.a(WidgetServerSettingsEnableCommunity.class, 0, 0, 0, null, null, null, null, false, false, false, 254), new StepsView.AbstractC7123b.a(WidgetServerSettingsCommunityFirstStep.class, 0, 0, 0, null, null, null, null, false, false, false, 510), new StepsView.AbstractC7123b.a(WidgetServerSettingsCommunitySecondStep.class, 0, 0, 0, null, null, null, null, false, false, false, 510), new StepsView.AbstractC7123b.a(WidgetServerSettingsCommunityThirdStep.class, 0, 0, C5419R.string.enable_community_button_text, null, null, null, new WidgetServerSettingsEnableCommunitySteps$onViewBound$steps$1(this), false, false, false, 374)})), new C93971(), new C93982());
        AppFragment.setOnBackPressed$default(this, new Func0<Boolean>() { // from class: com.discord.widgets.servers.community.WidgetServerSettingsEnableCommunitySteps.onViewBound.3
            @Override // p658rx.functions.Func0, java.util.concurrent.Callable
            public final Boolean call() {
                WidgetServerSettingsEnableCommunitySteps.this.getViewModel().goBackToPreviousPage();
                return Boolean.TRUE;
            }
        }, 0, 2, null);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        Observable<WidgetServerSettingsEnableCommunityViewModel.ViewState> observableM11112r = getViewModel().observeViewState().m11112r();
        C12238m.checkNotNullExpressionValue(observableM11112r, "viewModel\n        .obser…  .distinctUntilChanged()");
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.bindToComponentLifecycle$default(observableM11112r, this, null, 2, null), (Class<?>) WidgetServerSettingsEnableCommunitySteps.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C94021(this));
        Observable observableM11083G = ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeViewState(), this, null, 2, null).m11118y(new InterfaceC12589b<Object, Boolean>() { // from class: com.discord.widgets.servers.community.WidgetServerSettingsEnableCommunitySteps$onViewBoundOrOnResume$$inlined$filterIs$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // p637j0.p641k.InterfaceC12589b
            public final Boolean call(Object obj) {
                return Boolean.valueOf(obj instanceof WidgetServerSettingsEnableCommunityViewModel.ViewState.Loaded);
            }
        }).m11083G(new InterfaceC12589b<Object, T>() { // from class: com.discord.widgets.servers.community.WidgetServerSettingsEnableCommunitySteps$onViewBoundOrOnResume$$inlined$filterIs$2
            @Override // p637j0.p641k.InterfaceC12589b
            public final T call(Object obj) {
                Objects.requireNonNull(obj, "null cannot be cast to non-null type com.discord.widgets.servers.community.WidgetServerSettingsEnableCommunityViewModel.ViewState.Loaded");
                return (T) ((WidgetServerSettingsEnableCommunityViewModel.ViewState.Loaded) obj);
            }
        });
        C12238m.checkNotNullExpressionValue(observableM11083G, "filter { it is T }.map { it as T }");
        ObservableExtensionsKt.appSubscribe(observableM11083G, (Class<?>) WidgetServerSettingsEnableCommunitySteps.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C94032());
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeEvents(), this, null, 2, null), (Class<?>) WidgetServerSettingsEnableCommunitySteps.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C94043());
    }
}
