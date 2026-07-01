package com.discord.widgets.servers.community;

import android.content.Context;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import b.a.d.f0;
import b.d.b.a.a;
import com.discord.R$layout;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetEnableCommunityStepsBinding;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.discord.views.steps.StepsView$b$a;
import com.discord.views.steps.StepsView$d;
import d0.g;
import d0.t.n;
import d0.z.d.a0;
import d0.z.d.m;
import kotlin.Lazy;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.KProperty;
import rx.Observable;

/* JADX INFO: compiled from: WidgetServerSettingsEnableCommunitySteps.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettingsEnableCommunitySteps extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {a.d0(WidgetServerSettingsEnableCommunitySteps.class, "binding", "getBinding()Lcom/discord/databinding/WidgetEnableCommunityStepsBinding;", 0)};
    public static final WidgetServerSettingsEnableCommunitySteps$Companion Companion = new WidgetServerSettingsEnableCommunitySteps$Companion(null);
    private static final String INTENT_EXTRA_GUILD_ID = "INTENT_EXTRA_GUILD_ID";

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* JADX INFO: renamed from: guildId$delegate, reason: from kotlin metadata */
    private final Lazy guildId;

    /* JADX INFO: renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    public WidgetServerSettingsEnableCommunitySteps() {
        super(R$layout.widget_enable_community_steps);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetServerSettingsEnableCommunitySteps$binding$2.INSTANCE, null, 2, null);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, a0.getOrCreateKotlinClass(WidgetServerSettingsEnableCommunityViewModel.class), new WidgetServerSettingsEnableCommunitySteps$appActivityViewModels$$inlined$activityViewModels$1(this), new f0(new WidgetServerSettingsEnableCommunitySteps$viewModel$2(this)));
        this.guildId = g.lazy(new WidgetServerSettingsEnableCommunitySteps$guildId$2(this));
    }

    public static final /* synthetic */ void access$configureUI(WidgetServerSettingsEnableCommunitySteps widgetServerSettingsEnableCommunitySteps, WidgetServerSettingsEnableCommunityViewModel$ViewState widgetServerSettingsEnableCommunityViewModel$ViewState) {
        widgetServerSettingsEnableCommunitySteps.configureUI(widgetServerSettingsEnableCommunityViewModel$ViewState);
    }

    public static final /* synthetic */ WidgetEnableCommunityStepsBinding access$getBinding$p(WidgetServerSettingsEnableCommunitySteps widgetServerSettingsEnableCommunitySteps) {
        return widgetServerSettingsEnableCommunitySteps.getBinding();
    }

    public static final /* synthetic */ WidgetServerSettingsEnableCommunityViewModel access$getViewModel$p(WidgetServerSettingsEnableCommunitySteps widgetServerSettingsEnableCommunitySteps) {
        return widgetServerSettingsEnableCommunitySteps.getViewModel();
    }

    private final void configureUI(WidgetServerSettingsEnableCommunityViewModel$ViewState viewState) {
        if (m.areEqual(viewState, WidgetServerSettingsEnableCommunityViewModel$ViewState$Invalid.INSTANCE)) {
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
        m.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        getBinding().f2378b.a(new StepsView$d(this, n.listOf((Object[]) new StepsView$b$a[]{new StepsView$b$a(WidgetServerSettingsEnableCommunity.class, 0, 0, 0, null, null, null, null, false, false, false, 254), new StepsView$b$a(WidgetServerSettingsCommunityFirstStep.class, 0, 0, 0, null, null, null, null, false, false, false, 510), new StepsView$b$a(WidgetServerSettingsCommunitySecondStep.class, 0, 0, 0, null, null, null, null, false, false, false, 510), new StepsView$b$a(WidgetServerSettingsCommunityThirdStep.class, 0, 0, 2131888825, null, null, null, new WidgetServerSettingsEnableCommunitySteps$onViewBound$steps$1(this), false, false, false, 374)})), new WidgetServerSettingsEnableCommunitySteps$onViewBound$1(this), new WidgetServerSettingsEnableCommunitySteps$onViewBound$2(this));
        AppFragment.setOnBackPressed$default(this, new WidgetServerSettingsEnableCommunitySteps$onViewBound$3(this), 0, 2, null);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        Observable<WidgetServerSettingsEnableCommunityViewModel$ViewState> observableR = getViewModel().observeViewState().r();
        m.checkNotNullExpressionValue(observableR, "viewModel\n        .obser…  .distinctUntilChanged()");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(observableR, this, null, 2, null), WidgetServerSettingsEnableCommunitySteps.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new WidgetServerSettingsEnableCommunitySteps$onViewBoundOrOnResume$1(this), 62, (Object) null);
        Observable observableG = ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeViewState(), this, null, 2, null).y(WidgetServerSettingsEnableCommunitySteps$onViewBoundOrOnResume$$inlined$filterIs$1.INSTANCE).G(WidgetServerSettingsEnableCommunitySteps$onViewBoundOrOnResume$$inlined$filterIs$2.INSTANCE);
        m.checkNotNullExpressionValue(observableG, "filter { it is T }.map { it as T }");
        ObservableExtensionsKt.appSubscribe$default(observableG, WidgetServerSettingsEnableCommunitySteps.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new WidgetServerSettingsEnableCommunitySteps$onViewBoundOrOnResume$2(this), 62, (Object) null);
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeEvents(), this, null, 2, null), WidgetServerSettingsEnableCommunitySteps.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new WidgetServerSettingsEnableCommunitySteps$onViewBoundOrOnResume$3(this), 62, (Object) null);
    }
}
