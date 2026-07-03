package com.discord.widgets.user;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import com.discord.C5419R;
import com.discord.app.AppDialog;
import com.discord.databinding.WidgetPruneUsersBinding;
import com.discord.utilities.KotlinExtensionsKt;
import com.discord.utilities.error.Error;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.resources.StringResourceUtilsKt;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.discord.views.CheckedSetting;
import com.discord.views.RadioManager;
import com.discord.widgets.user.WidgetPruneUsersViewModel;
import com.google.android.material.button.MaterialButton;
import kotlin.Lazy;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import p007b.p008a.p018d.C0865g0;
import p007b.p008a.p018d.C0869i0;
import p007b.p008a.p027k.C1107b;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.C12083g;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12216a0;
import p507d0.p592z.p594d.C12236k;
import p507d0.p592z.p594d.C12238m;
import p658rx.Observable;
import p658rx.Subscription;

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
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {C1643a.m846d0(WidgetPruneUsers.class, "binding", "getBinding()Lcom/discord/databinding/WidgetPruneUsersBinding;", 0)};

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: compiled from: WidgetPruneUsers.kt */
    public static final class Companion {
        private Companion() {
        }

        public final void create(long guildId, FragmentManager fragmentManager) {
            C12238m.checkNotNullParameter(fragmentManager, "fragmentManager");
            WidgetPruneUsers widgetPruneUsers = new WidgetPruneUsers();
            Bundle bundle = new Bundle();
            bundle.putLong(WidgetPruneUsers.ARG_GUILD_ID, guildId);
            widgetPruneUsers.setArguments(bundle);
            widgetPruneUsers.show(fragmentManager, WidgetPruneUsers.class.getName());
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            WidgetPruneUsersViewModel.PruneDays.values();
            int[] iArr = new int[2];
            $EnumSwitchMapping$0 = iArr;
            iArr[WidgetPruneUsersViewModel.PruneDays.Seven.ordinal()] = 1;
            iArr[WidgetPruneUsersViewModel.PruneDays.Thirty.ordinal()] = 2;
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.user.WidgetPruneUsers$onViewBound$1 */
    /* JADX INFO: compiled from: WidgetPruneUsers.kt */
    public static final class C101911 extends AbstractC12240o implements Function2<Context, Integer, CharSequence> {
        public static final C101911 INSTANCE = new C101911();

        public C101911() {
            super(2);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ CharSequence invoke(Context context, Integer num) {
            return invoke(context, num.intValue());
        }

        public final CharSequence invoke(Context context, int i) {
            C12238m.checkNotNullParameter(context, "$this$formatLastSeenDays");
            return C1107b.m216h(context, C5419R.string.last_seen, new Object[]{StringResourceUtilsKt.getI18nPluralString(context, C5419R.plurals.last_seen_days, i, Integer.valueOf(i))}, null, 4);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.user.WidgetPruneUsers$onViewBoundOrOnResume$1 */
    /* JADX INFO: compiled from: WidgetPruneUsers.kt */
    public static final /* synthetic */ class C101941 extends C12236k implements Function1<WidgetPruneUsersViewModel.ViewState, Unit> {
        public C101941(WidgetPruneUsers widgetPruneUsers) {
            super(1, widgetPruneUsers, WidgetPruneUsers.class, "updateUI", "updateUI(Lcom/discord/widgets/user/WidgetPruneUsersViewModel$ViewState;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(WidgetPruneUsersViewModel.ViewState viewState) {
            invoke2(viewState);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(WidgetPruneUsersViewModel.ViewState viewState) {
            C12238m.checkNotNullParameter(viewState, "p1");
            ((WidgetPruneUsers) this.receiver).updateUI(viewState);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.user.WidgetPruneUsers$onViewBoundOrOnResume$2 */
    /* JADX INFO: compiled from: WidgetPruneUsers.kt */
    public static final /* synthetic */ class C101952 extends C12236k implements Function1<WidgetPruneUsersViewModel.Event, Unit> {
        public C101952(WidgetPruneUsers widgetPruneUsers) {
            super(1, widgetPruneUsers, WidgetPruneUsers.class, "handleEvent", "handleEvent(Lcom/discord/widgets/user/WidgetPruneUsersViewModel$Event;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(WidgetPruneUsersViewModel.Event event) throws Throwable {
            invoke2(event);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(WidgetPruneUsersViewModel.Event event) throws Throwable {
            C12238m.checkNotNullParameter(event, "p1");
            ((WidgetPruneUsers) this.receiver).handleEvent(event);
        }
    }

    public WidgetPruneUsers() {
        super(C5419R.layout.widget_prune_users);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetPruneUsers$binding$2.INSTANCE, null, 2, null);
        this.radioManager = C12083g.lazy(new WidgetPruneUsers$radioManager$2(this));
        WidgetPruneUsers$viewModel$2 widgetPruneUsers$viewModel$2 = new WidgetPruneUsers$viewModel$2(this);
        C0865g0 c0865g0 = new C0865g0(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, C12216a0.getOrCreateKotlinClass(WidgetPruneUsersViewModel.class), new WidgetPruneUsers$appViewModels$$inlined$viewModels$1(c0865g0), new C0869i0(widgetPruneUsers$viewModel$2));
    }

    public static final void create(long j, FragmentManager fragmentManager) {
        INSTANCE.create(j, fragmentManager);
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

    private final void handleEvent(WidgetPruneUsersViewModel.Event event) throws Throwable {
        Unit unit;
        if (event instanceof WidgetPruneUsersViewModel.Event.Dismiss) {
            dismiss();
            unit = Unit.f27425a;
        } else {
            if (!(event instanceof WidgetPruneUsersViewModel.Event.RestClientFailed)) {
                throw new NoWhenBranchMatchedException();
            }
            Error.handle(((WidgetPruneUsersViewModel.Event.RestClientFailed) event).getThrowable(), "restClient", null, getContext());
            unit = Unit.f27425a;
        }
        KotlinExtensionsKt.getExhaustive(unit);
    }

    private final void updateUI(WidgetPruneUsersViewModel.ViewState state) {
        Unit unit;
        CheckedSetting checkedSetting;
        if (state instanceof WidgetPruneUsersViewModel.ViewState.Loading) {
            StringBuilder sb = new StringBuilder();
            sb.append(C1107b.m213e(this, C5419R.string.prune_members, new Object[0], (4 & 4) != 0 ? C1107b.a.f1490j : null));
            sb.append(" - ");
            WidgetPruneUsersViewModel.ViewState.Loading loading = (WidgetPruneUsersViewModel.ViewState.Loading) state;
            sb.append(loading.getGuildName());
            String string = sb.toString();
            TextView textView = getBinding().f17389c;
            C12238m.checkNotNullExpressionValue(textView, "binding.pruneUserHeader");
            textView.setText(string);
            int iOrdinal = loading.getWhichPruneDays().ordinal();
            if (iOrdinal == 0) {
                checkedSetting = getBinding().f17392f;
            } else {
                if (iOrdinal != 1) {
                    throw new NoWhenBranchMatchedException();
                }
                checkedSetting = getBinding().f17393g;
            }
            RadioManager radioManager = getRadioManager();
            C12238m.checkNotNullExpressionValue(checkedSetting, "button");
            radioManager.m8550a(checkedSetting);
            ProgressBar progressBar = getBinding().f17394h;
            C12238m.checkNotNullExpressionValue(progressBar, "binding.pruneUsersLoadingProgressbar");
            progressBar.setVisibility(0);
            TextView textView2 = getBinding().f17391e;
            C12238m.checkNotNullExpressionValue(textView2, "binding.pruneUsersEstimateText");
            textView2.setVisibility(8);
            MaterialButton materialButton = getBinding().f17390d;
            C12238m.checkNotNullExpressionValue(materialButton, "binding.pruneUserPrune");
            ViewExtensions.disable(materialButton);
            unit = Unit.f27425a;
        } else if (state instanceof WidgetPruneUsersViewModel.ViewState.Loaded) {
            ProgressBar progressBar2 = getBinding().f17394h;
            C12238m.checkNotNullExpressionValue(progressBar2, "binding.pruneUsersLoadingProgressbar");
            progressBar2.setVisibility(8);
            Context contextRequireContext = requireContext();
            C12238m.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
            WidgetPruneUsersViewModel.ViewState.Loaded loaded = (WidgetPruneUsersViewModel.ViewState.Loaded) state;
            CharSequence i18nPluralString = StringResourceUtilsKt.getI18nPluralString(contextRequireContext, C5419R.plurals.form_help_last_seen_1_members, loaded.getPruneCount(), Integer.valueOf(loaded.getPruneCount()));
            Context contextRequireContext2 = requireContext();
            C12238m.checkNotNullExpressionValue(contextRequireContext2, "requireContext()");
            CharSequence i18nPluralString2 = StringResourceUtilsKt.getI18nPluralString(contextRequireContext2, C5419R.plurals.form_help_last_seen_1_days, loaded.getPruneDays().getCount(), Integer.valueOf(loaded.getPruneDays().getCount()));
            TextView textView3 = getBinding().f17391e;
            C1107b.m221m(textView3, C5419R.string.form_help_last_seen_1, new Object[]{i18nPluralString, i18nPluralString2}, (4 & 4) != 0 ? C1107b.g.f1495j : null);
            textView3.setVisibility(0);
            MaterialButton materialButton2 = getBinding().f17390d;
            C12238m.checkNotNullExpressionValue(materialButton2, "binding.pruneUserPrune");
            materialButton2.setEnabled(loaded.getPruneButtonEnabled());
            unit = Unit.f27425a;
        } else {
            if (!(state instanceof WidgetPruneUsersViewModel.ViewState.LoadFailed)) {
                throw new NoWhenBranchMatchedException();
            }
            if (((WidgetPruneUsersViewModel.ViewState.LoadFailed) state).getDismiss()) {
                dismiss();
                unit = Unit.f27425a;
            } else {
                ProgressBar progressBar3 = getBinding().f17394h;
                C12238m.checkNotNullExpressionValue(progressBar3, "binding.pruneUsersLoadingProgressbar");
                progressBar3.setVisibility(8);
                TextView textView4 = getBinding().f17391e;
                C12238m.checkNotNullExpressionValue(textView4, "binding.pruneUsersEstimateText");
                textView4.setVisibility(8);
                MaterialButton materialButton3 = getBinding().f17390d;
                C12238m.checkNotNullExpressionValue(materialButton3, "binding.pruneUserPrune");
                ViewExtensions.disable(materialButton3);
                unit = Unit.f27425a;
            }
        }
        KotlinExtensionsKt.getExhaustive(unit);
    }

    @Override // com.discord.app.AppDialog
    public void onViewBound(View view) {
        C12238m.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        C101911 c101911 = C101911.INSTANCE;
        CheckedSetting checkedSetting = getBinding().f17392f;
        Context context = checkedSetting.getContext();
        C12238m.checkNotNullExpressionValue(context, "context");
        checkedSetting.setText(c101911.invoke(context, 7));
        checkedSetting.m8527e(new View.OnClickListener() { // from class: com.discord.widgets.user.WidgetPruneUsers$onViewBound$$inlined$apply$lambda$1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.this$0.getViewModel().pruneDaysSelected(WidgetPruneUsersViewModel.PruneDays.Seven);
            }
        });
        CheckedSetting checkedSetting2 = getBinding().f17393g;
        Context context2 = checkedSetting2.getContext();
        C12238m.checkNotNullExpressionValue(context2, "context");
        checkedSetting2.setText(c101911.invoke(context2, 30));
        checkedSetting2.m8527e(new View.OnClickListener() { // from class: com.discord.widgets.user.WidgetPruneUsers$onViewBound$$inlined$apply$lambda$2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.this$0.getViewModel().pruneDaysSelected(WidgetPruneUsersViewModel.PruneDays.Thirty);
            }
        });
        getBinding().f17388b.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.user.WidgetPruneUsers.onViewBound.4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                WidgetPruneUsers.this.dismiss();
            }
        });
        getBinding().f17390d.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.user.WidgetPruneUsers.onViewBound.5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                WidgetPruneUsers.this.getViewModel().pruneClicked();
            }
        });
    }

    @Override // com.discord.app.AppDialog
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        Observable<WidgetPruneUsersViewModel.ViewState> observableM11112r = getViewModel().observeViewState().m11112r();
        C12238m.checkNotNullExpressionValue(observableM11112r, "viewModel.observeViewSta…  .distinctUntilChanged()");
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.bindToComponentLifecycle$default(observableM11112r, this, null, 2, null), (Class<?>) WidgetPruneUsers.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C101941(this));
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeEvents(), this, null, 2, null), (Class<?>) WidgetPruneUsers.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C101952(this));
    }
}
