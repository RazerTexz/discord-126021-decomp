package com.discord.widgets.guild_automod;

import android.content.Context;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import b.a.d.g0;
import b.a.d.i0;
import b.d.b.a.a;
import com.discord.R$layout;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetReportIssueWithAutomodBinding;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.discord.views.CheckedSetting;
import d0.g;
import d0.z.d.a0;
import d0.z.d.m;
import kotlin.Lazy;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.KProperty;

/* JADX INFO: compiled from: WidgetReportIssueWithAutoMod.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetReportIssueWithAutoMod extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {a.d0(WidgetReportIssueWithAutoMod.class, "binding", "getBinding()Lcom/discord/databinding/WidgetReportIssueWithAutomodBinding;", 0)};
    public static final WidgetReportIssueWithAutoMod$Companion Companion = new WidgetReportIssueWithAutoMod$Companion(null);

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* JADX INFO: renamed from: channelId$delegate, reason: from kotlin metadata */
    private final Lazy channelId;

    /* JADX INFO: renamed from: messageId$delegate, reason: from kotlin metadata */
    private final Lazy messageId;

    /* JADX INFO: renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    public WidgetReportIssueWithAutoMod() {
        super(R$layout.widget_report_issue_with_automod);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetReportIssueWithAutoMod$binding$2.INSTANCE, null, 2, null);
        this.channelId = g.lazy(new WidgetReportIssueWithAutoMod$channelId$2(this));
        this.messageId = g.lazy(new WidgetReportIssueWithAutoMod$messageId$2(this));
        WidgetReportIssueWithAutoMod$viewModel$2 widgetReportIssueWithAutoMod$viewModel$2 = new WidgetReportIssueWithAutoMod$viewModel$2(this);
        g0 g0Var = new g0(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, a0.getOrCreateKotlinClass(ReportIssueWithAutoModViewModel.class), new WidgetReportIssueWithAutoMod$appViewModels$$inlined$viewModels$1(g0Var), new i0(widgetReportIssueWithAutoMod$viewModel$2));
    }

    public static final /* synthetic */ long access$getChannelId$p(WidgetReportIssueWithAutoMod widgetReportIssueWithAutoMod) {
        return widgetReportIssueWithAutoMod.getChannelId();
    }

    public static final /* synthetic */ long access$getMessageId$p(WidgetReportIssueWithAutoMod widgetReportIssueWithAutoMod) {
        return widgetReportIssueWithAutoMod.getMessageId();
    }

    public static final /* synthetic */ ReportIssueWithAutoModViewModel access$getViewModel$p(WidgetReportIssueWithAutoMod widgetReportIssueWithAutoMod) {
        return widgetReportIssueWithAutoMod.getViewModel();
    }

    private final void configureOption(ReportIssueWithAutoModViewModel$ViewState$Valid viewState, CheckedSetting setting, FeedbackType settingValue) {
        setting.setChecked(m.areEqual(viewState.getSelectedOption(), settingValue.getValue()));
        setting.e(new WidgetReportIssueWithAutoMod$configureOption$1(this, settingValue));
    }

    private final WidgetReportIssueWithAutomodBinding getBinding() {
        return (WidgetReportIssueWithAutomodBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final long getChannelId() {
        return ((Number) this.channelId.getValue()).longValue();
    }

    private final long getMessageId() {
        return ((Number) this.messageId.getValue()).longValue();
    }

    private final ReportIssueWithAutoModViewModel getViewModel() {
        return (ReportIssueWithAutoModViewModel) this.viewModel.getValue();
    }

    public final void configureUI(ReportIssueWithAutoModViewModel$ViewState viewState) {
        m.checkNotNullParameter(viewState, "viewState");
        getBinding().f2520b.setOnClickListener(new WidgetReportIssueWithAutoMod$configureUI$1(this));
        getBinding().e.setOnClickListener(new WidgetReportIssueWithAutoMod$configureUI$2(this));
        if (viewState instanceof ReportIssueWithAutoModViewModel$ViewState$Valid) {
            ReportIssueWithAutoModViewModel$ViewState$Valid reportIssueWithAutoModViewModel$ViewState$Valid = (ReportIssueWithAutoModViewModel$ViewState$Valid) viewState;
            CheckedSetting checkedSetting = getBinding().c;
            m.checkNotNullExpressionValue(checkedSetting, "binding.option1");
            configureOption(reportIssueWithAutoModViewModel$ViewState$Valid, checkedSetting, FeedbackType.ALLOWED);
            CheckedSetting checkedSetting2 = getBinding().d;
            m.checkNotNullExpressionValue(checkedSetting2, "binding.option2");
            configureOption(reportIssueWithAutoModViewModel$ViewState$Valid, checkedSetting2, FeedbackType.BUG);
        }
    }

    @Override // com.discord.app.AppFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeViewState(), this, null, 2, null), WidgetReportIssueWithAutoMod.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new WidgetReportIssueWithAutoMod$onResume$1(this), 62, (Object) null);
    }
}
