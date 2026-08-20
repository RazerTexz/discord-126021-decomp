package com.discord.widgets.guild_automod;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentViewModelLazyKt;
import com.discord.C5419R;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetReportIssueWithAutomodBinding;
import com.discord.utilities.error.Error;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.discord.views.CheckedSetting;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import p007b.p008a.p018d.C0865g0;
import p007b.p008a.p018d.C0869i0;
import p007b.p008a.p018d.C0870j;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.C12083g;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12216a0;
import p507d0.p592z.p594d.C12238m;
import p658rx.Subscription;

/* JADX INFO: compiled from: WidgetReportIssueWithAutoMod.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetReportIssueWithAutoMod extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {C1643a.m846d0(WidgetReportIssueWithAutoMod.class, "binding", "getBinding()Lcom/discord/databinding/WidgetReportIssueWithAutomodBinding;", 0)};

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* JADX INFO: renamed from: channelId$delegate, reason: from kotlin metadata */
    private final Lazy channelId;

    /* JADX INFO: renamed from: messageId$delegate, reason: from kotlin metadata */
    private final Lazy messageId;

    /* JADX INFO: renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    /* JADX INFO: compiled from: WidgetReportIssueWithAutoMod.kt */
    public static final class Companion {
        private Companion() {
        }

        public final void launch(Context context, long channelId, long messageId) {
            C12238m.checkNotNullParameter(context, "context");
            Intent intent = new Intent();
            intent.putExtra("com.discord.intent.extra.EXTRA_CHANNEL_ID", channelId);
            intent.putExtra("com.discord.intent.extra.EXTRA_MESSAGE_ID", messageId);
            C0870j.m156d(context, WidgetReportIssueWithAutoMod.class, intent);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.guild_automod.WidgetReportIssueWithAutoMod$onResume$1 */
    /* JADX INFO: compiled from: WidgetReportIssueWithAutoMod.kt */
    public static final class C84181 extends AbstractC12240o implements Function1<ReportIssueWithAutoModViewModel.ViewState, Unit> {
        public C84181() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ReportIssueWithAutoModViewModel.ViewState viewState) {
            invoke2(viewState);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(ReportIssueWithAutoModViewModel.ViewState viewState) {
            C12238m.checkNotNullParameter(viewState, "viewState");
            WidgetReportIssueWithAutoMod.this.configureUI(viewState);
        }
    }

    public WidgetReportIssueWithAutoMod() {
        super(C5419R.layout.widget_report_issue_with_automod);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetReportIssueWithAutoMod$binding$2.INSTANCE, null, 2, null);
        this.channelId = C12083g.lazy(new WidgetReportIssueWithAutoMod$channelId$2(this));
        this.messageId = C12083g.lazy(new WidgetReportIssueWithAutoMod$messageId$2(this));
        WidgetReportIssueWithAutoMod$viewModel$2 widgetReportIssueWithAutoMod$viewModel$2 = new WidgetReportIssueWithAutoMod$viewModel$2(this);
        C0865g0 c0865g0 = new C0865g0(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, C12216a0.getOrCreateKotlinClass(ReportIssueWithAutoModViewModel.class), new WidgetReportIssueWithAutoMod$appViewModels$$inlined$viewModels$1(c0865g0), new C0869i0(widgetReportIssueWithAutoMod$viewModel$2));
    }

    private final void configureOption(ReportIssueWithAutoModViewModel.ViewState.Valid viewState, CheckedSetting setting, final FeedbackType settingValue) {
        setting.setChecked(C12238m.areEqual(viewState.getSelectedOption(), settingValue.getValue()));
        setting.m8527e(new View.OnClickListener() { // from class: com.discord.widgets.guild_automod.WidgetReportIssueWithAutoMod.configureOption.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WidgetReportIssueWithAutoMod.this.getViewModel().onFeedbackTypeSelected(settingValue);
            }
        });
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

    public final void configureUI(ReportIssueWithAutoModViewModel.ViewState viewState) {
        C12238m.checkNotNullParameter(viewState, "viewState");
        getBinding().f17412b.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.guild_automod.WidgetReportIssueWithAutoMod.configureUI.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FragmentActivity fragmentActivityM95e = WidgetReportIssueWithAutoMod.this.m95e();
                if (fragmentActivityM95e != null) {
                    fragmentActivityM95e.finish();
                }
            }
        });
        getBinding().f17415e.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.guild_automod.WidgetReportIssueWithAutoMod.configureUI.2

            /* JADX INFO: renamed from: com.discord.widgets.guild_automod.WidgetReportIssueWithAutoMod$configureUI$2$1, reason: invalid class name */
            /* JADX INFO: compiled from: WidgetReportIssueWithAutoMod.kt */
            public static final class AnonymousClass1 extends AbstractC12240o implements Function0<Unit> {
                public AnonymousClass1() {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.f27425a;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    FragmentActivity fragmentActivityM95e = WidgetReportIssueWithAutoMod.this.m95e();
                    if (fragmentActivityM95e != null) {
                        fragmentActivityM95e.finish();
                    }
                }
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WidgetReportIssueWithAutoMod.this.getViewModel().onSubmit(new AnonymousClass1());
            }
        });
        if (viewState instanceof ReportIssueWithAutoModViewModel.ViewState.Valid) {
            ReportIssueWithAutoModViewModel.ViewState.Valid valid = (ReportIssueWithAutoModViewModel.ViewState.Valid) viewState;
            CheckedSetting checkedSetting = getBinding().f17413c;
            C12238m.checkNotNullExpressionValue(checkedSetting, "binding.option1");
            configureOption(valid, checkedSetting, FeedbackType.ALLOWED);
            CheckedSetting checkedSetting2 = getBinding().f17414d;
            C12238m.checkNotNullExpressionValue(checkedSetting2, "binding.option2");
            configureOption(valid, checkedSetting2, FeedbackType.BUG);
        }
    }

    @Override // com.discord.app.AppFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeViewState(), this, null, 2, null), (Class<?>) WidgetReportIssueWithAutoMod.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C84181());
    }
}
