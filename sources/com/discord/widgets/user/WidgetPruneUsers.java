package com.discord.widgets.user;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import b.a.d.g0;
import b.a.d.i0;
import b.a.k.b;
import b.d.b.a.a;
import com.discord.R$layout;
import com.discord.R$plurals;
import com.discord.app.AppDialog;
import com.discord.databinding.WidgetPruneUsersBinding;
import com.discord.utilities.KotlinExtensionsKt;
import com.discord.utilities.error.Error;
import com.discord.utilities.resources.StringResourceUtilsKt;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.discord.views.CheckedSetting;
import com.discord.views.RadioManager;
import com.google.android.material.button.MaterialButton;
import d0.g;
import d0.z.d.a0;
import d0.z.d.m;
import kotlin.Lazy;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.KProperty;
import rx.Observable;

/* JADX INFO: compiled from: WidgetPruneUsers.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetPruneUsers extends AppDialog {
    private static final String ARG_GUILD_ID = "ARG_GUILD_ID";

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* JADX INFO: renamed from: radioManager$delegate, reason: from kotlin metadata */
    private final Lazy radioManager;

    /* JADX INFO: renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {a.d0(WidgetPruneUsers.class, "binding", "getBinding()Lcom/discord/databinding/WidgetPruneUsersBinding;", 0)};
    public static final WidgetPruneUsers$Companion Companion = new WidgetPruneUsers$Companion(null);

    public WidgetPruneUsers() {
        super(R$layout.widget_prune_users);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetPruneUsers$binding$2.INSTANCE, null, 2, null);
        this.radioManager = g.lazy(new WidgetPruneUsers$radioManager$2(this));
        WidgetPruneUsers$viewModel$2 widgetPruneUsers$viewModel$2 = new WidgetPruneUsers$viewModel$2(this);
        g0 g0Var = new g0(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, a0.getOrCreateKotlinClass(WidgetPruneUsersViewModel.class), new WidgetPruneUsers$appViewModels$$inlined$viewModels$1(g0Var), new i0(widgetPruneUsers$viewModel$2));
    }

    public static final /* synthetic */ Bundle access$getArgumentsOrDefault$p(WidgetPruneUsers widgetPruneUsers) {
        return widgetPruneUsers.getArgumentsOrDefault();
    }

    public static final /* synthetic */ WidgetPruneUsersBinding access$getBinding$p(WidgetPruneUsers widgetPruneUsers) {
        return widgetPruneUsers.getBinding();
    }

    public static final /* synthetic */ WidgetPruneUsersViewModel access$getViewModel$p(WidgetPruneUsers widgetPruneUsers) {
        return widgetPruneUsers.getViewModel();
    }

    public static final /* synthetic */ void access$handleEvent(WidgetPruneUsers widgetPruneUsers, WidgetPruneUsersViewModel$Event widgetPruneUsersViewModel$Event) {
        widgetPruneUsers.handleEvent(widgetPruneUsersViewModel$Event);
    }

    public static final /* synthetic */ void access$updateUI(WidgetPruneUsers widgetPruneUsers, WidgetPruneUsersViewModel$ViewState widgetPruneUsersViewModel$ViewState) {
        widgetPruneUsers.updateUI(widgetPruneUsersViewModel$ViewState);
    }

    public static final void create(long j, FragmentManager fragmentManager) {
        Companion.create(j, fragmentManager);
    }

    private final WidgetPruneUsersBinding getBinding() {
        return (WidgetPruneUsersBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final RadioManager getRadioManager() {
        return (RadioManager) this.radioManager.getValue();
    }

    private final WidgetPruneUsersViewModel getViewModel() {
        return (WidgetPruneUsersViewModel) this.viewModel.getValue();
    }

    private final void handleEvent(WidgetPruneUsersViewModel$Event event) throws Throwable {
        Unit unit;
        if (event instanceof WidgetPruneUsersViewModel$Event$Dismiss) {
            dismiss();
            unit = Unit.a;
        } else {
            if (!(event instanceof WidgetPruneUsersViewModel$Event$RestClientFailed)) {
                throw new NoWhenBranchMatchedException();
            }
            Error.handle(((WidgetPruneUsersViewModel$Event$RestClientFailed) event).getThrowable(), "restClient", null, getContext());
            unit = Unit.a;
        }
        KotlinExtensionsKt.getExhaustive(unit);
    }

    private final void updateUI(WidgetPruneUsersViewModel$ViewState state) {
        Unit unit;
        CheckedSetting checkedSetting;
        if (state instanceof WidgetPruneUsersViewModel$ViewState$Loading) {
            StringBuilder sb = new StringBuilder();
            sb.append(b.k(this, 2131894609, new Object[0], null, 4));
            sb.append(" - ");
            WidgetPruneUsersViewModel$ViewState$Loading widgetPruneUsersViewModel$ViewState$Loading = (WidgetPruneUsersViewModel$ViewState$Loading) state;
            sb.append(widgetPruneUsersViewModel$ViewState$Loading.getGuildName());
            String string = sb.toString();
            TextView textView = getBinding().c;
            m.checkNotNullExpressionValue(textView, "binding.pruneUserHeader");
            textView.setText(string);
            int iOrdinal = widgetPruneUsersViewModel$ViewState$Loading.getWhichPruneDays().ordinal();
            if (iOrdinal == 0) {
                checkedSetting = getBinding().f;
            } else {
                if (iOrdinal != 1) {
                    throw new NoWhenBranchMatchedException();
                }
                checkedSetting = getBinding().g;
            }
            RadioManager radioManager = getRadioManager();
            m.checkNotNullExpressionValue(checkedSetting, "button");
            radioManager.a(checkedSetting);
            ProgressBar progressBar = getBinding().h;
            m.checkNotNullExpressionValue(progressBar, "binding.pruneUsersLoadingProgressbar");
            progressBar.setVisibility(0);
            TextView textView2 = getBinding().e;
            m.checkNotNullExpressionValue(textView2, "binding.pruneUsersEstimateText");
            textView2.setVisibility(8);
            MaterialButton materialButton = getBinding().d;
            m.checkNotNullExpressionValue(materialButton, "binding.pruneUserPrune");
            ViewExtensions.disable(materialButton);
            unit = Unit.a;
        } else if (state instanceof WidgetPruneUsersViewModel$ViewState$Loaded) {
            ProgressBar progressBar2 = getBinding().h;
            m.checkNotNullExpressionValue(progressBar2, "binding.pruneUsersLoadingProgressbar");
            progressBar2.setVisibility(8);
            Context contextRequireContext = requireContext();
            m.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
            WidgetPruneUsersViewModel$ViewState$Loaded widgetPruneUsersViewModel$ViewState$Loaded = (WidgetPruneUsersViewModel$ViewState$Loaded) state;
            CharSequence i18nPluralString = StringResourceUtilsKt.getI18nPluralString(contextRequireContext, R$plurals.form_help_last_seen_1_members, widgetPruneUsersViewModel$ViewState$Loaded.getPruneCount(), Integer.valueOf(widgetPruneUsersViewModel$ViewState$Loaded.getPruneCount()));
            Context contextRequireContext2 = requireContext();
            m.checkNotNullExpressionValue(contextRequireContext2, "requireContext()");
            CharSequence i18nPluralString2 = StringResourceUtilsKt.getI18nPluralString(contextRequireContext2, R$plurals.form_help_last_seen_1_days, widgetPruneUsersViewModel$ViewState$Loaded.getPruneDays().getCount(), Integer.valueOf(widgetPruneUsersViewModel$ViewState$Loaded.getPruneDays().getCount()));
            TextView textView3 = getBinding().e;
            b.n(textView3, 2131889099, new Object[]{i18nPluralString, i18nPluralString2}, null, 4);
            textView3.setVisibility(0);
            MaterialButton materialButton2 = getBinding().d;
            m.checkNotNullExpressionValue(materialButton2, "binding.pruneUserPrune");
            materialButton2.setEnabled(widgetPruneUsersViewModel$ViewState$Loaded.getPruneButtonEnabled());
            unit = Unit.a;
        } else {
            if (!(state instanceof WidgetPruneUsersViewModel$ViewState$LoadFailed)) {
                throw new NoWhenBranchMatchedException();
            }
            if (((WidgetPruneUsersViewModel$ViewState$LoadFailed) state).getDismiss()) {
                dismiss();
                unit = Unit.a;
            } else {
                ProgressBar progressBar3 = getBinding().h;
                m.checkNotNullExpressionValue(progressBar3, "binding.pruneUsersLoadingProgressbar");
                progressBar3.setVisibility(8);
                TextView textView4 = getBinding().e;
                m.checkNotNullExpressionValue(textView4, "binding.pruneUsersEstimateText");
                textView4.setVisibility(8);
                MaterialButton materialButton3 = getBinding().d;
                m.checkNotNullExpressionValue(materialButton3, "binding.pruneUserPrune");
                ViewExtensions.disable(materialButton3);
                unit = Unit.a;
            }
        }
        KotlinExtensionsKt.getExhaustive(unit);
    }

    @Override // com.discord.app.AppDialog
    public void onViewBound(View view) {
        m.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        WidgetPruneUsers$onViewBound$1 widgetPruneUsers$onViewBound$1 = WidgetPruneUsers$onViewBound$1.INSTANCE;
        CheckedSetting checkedSetting = getBinding().f;
        Context context = checkedSetting.getContext();
        m.checkNotNullExpressionValue(context, "context");
        checkedSetting.setText(widgetPruneUsers$onViewBound$1.invoke(context, 7));
        checkedSetting.e(new WidgetPruneUsers$onViewBound$$inlined$apply$lambda$1(this));
        CheckedSetting checkedSetting2 = getBinding().g;
        Context context2 = checkedSetting2.getContext();
        m.checkNotNullExpressionValue(context2, "context");
        checkedSetting2.setText(widgetPruneUsers$onViewBound$1.invoke(context2, 30));
        checkedSetting2.e(new WidgetPruneUsers$onViewBound$$inlined$apply$lambda$2(this));
        getBinding().f2514b.setOnClickListener(new WidgetPruneUsers$onViewBound$4(this));
        getBinding().d.setOnClickListener(new WidgetPruneUsers$onViewBound$5(this));
    }

    @Override // com.discord.app.AppDialog
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        Observable<WidgetPruneUsersViewModel$ViewState> observableR = getViewModel().observeViewState().r();
        m.checkNotNullExpressionValue(observableR, "viewModel.observeViewSta…  .distinctUntilChanged()");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(observableR, this, null, 2, null), WidgetPruneUsers.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new WidgetPruneUsers$onViewBoundOrOnResume$1(this), 62, (Object) null);
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeEvents(), this, null, 2, null), WidgetPruneUsers.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new WidgetPruneUsers$onViewBoundOrOnResume$2(this), 62, (Object) null);
    }
}
