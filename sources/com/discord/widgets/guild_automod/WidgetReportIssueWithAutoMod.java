package com.discord.widgets.guild_automod;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentViewModelLazyKt;
import b.a.d.AppScreen2;
import b.a.d.AppViewModelDelegates3;
import b.a.d.AppViewModelDelegates5;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetReportIssueWithAutomodBinding;
import com.discord.utilities.error.Error;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.views.CheckedSetting;
import com.discord.widgets.guild_automod.ReportIssueWithAutoModViewModel;
import d0.LazyJVM;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import d0.z.d.Reflection2;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import rx.Subscription;

/* JADX INFO: compiled from: WidgetReportIssueWithAutoMod.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetReportIssueWithAutoMod extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.d0(WidgetReportIssueWithAutoMod.class, "binding", "getBinding()Lcom/discord/databinding/WidgetReportIssueWithAutomodBinding;", 0)};

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
            Intrinsics3.checkNotNullParameter(context, "context");
            Intent intent = new Intent();
            intent.putExtra("com.discord.intent.extra.EXTRA_CHANNEL_ID", channelId);
            intent.putExtra("com.discord.intent.extra.EXTRA_MESSAGE_ID", messageId);
            AppScreen2.d(context, WidgetReportIssueWithAutoMod.class, intent);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.guild_automod.WidgetReportIssueWithAutoMod$onResume$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetReportIssueWithAutoMod.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<ReportIssueWithAutoModViewModel.ViewState, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ReportIssueWithAutoModViewModel.ViewState viewState) {
            invoke2(viewState);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(ReportIssueWithAutoModViewModel.ViewState viewState) {
            Intrinsics3.checkNotNullParameter(viewState, "viewState");
            WidgetReportIssueWithAutoMod.this.configureUI(viewState);
        }
    }

    public WidgetReportIssueWithAutoMod() {
        super(R.layout.widget_report_issue_with_automod);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetReportIssueWithAutoMod2.INSTANCE, null, 2, null);
        this.channelId = LazyJVM.lazy(new WidgetReportIssueWithAutoMod3(this));
        this.messageId = LazyJVM.lazy(new WidgetReportIssueWithAutoMod4(this));
        WidgetReportIssueWithAutoMod5 widgetReportIssueWithAutoMod5 = new WidgetReportIssueWithAutoMod5(this);
        AppViewModelDelegates3 appViewModelDelegates3 = new AppViewModelDelegates3(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection2.getOrCreateKotlinClass(ReportIssueWithAutoModViewModel.class), new WidgetReportIssueWithAutoMod$appViewModels$$inlined$viewModels$1(appViewModelDelegates3), new AppViewModelDelegates5(widgetReportIssueWithAutoMod5));
    }

    private final void configureOption(ReportIssueWithAutoModViewModel.ViewState.Valid viewState, CheckedSetting setting, final ReportIssueWithAutoModViewModel2 settingValue) {
        setting.setChecked(Intrinsics3.areEqual(viewState.getSelectedOption(), settingValue.getValue()));
        setting.e(new View.OnClickListener() { // from class: com.discord.widgets.guild_automod.WidgetReportIssueWithAutoMod.configureOption.1
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
        Intrinsics3.checkNotNullParameter(viewState, "viewState");
        getBinding().f2520b.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.guild_automod.WidgetReportIssueWithAutoMod.configureUI.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FragmentActivity fragmentActivityE = WidgetReportIssueWithAutoMod.this.e();
                if (fragmentActivityE != null) {
                    fragmentActivityE.finish();
                }
            }
        });
        getBinding().e.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.guild_automod.WidgetReportIssueWithAutoMod.configureUI.2

            /* JADX INFO: renamed from: com.discord.widgets.guild_automod.WidgetReportIssueWithAutoMod$configureUI$2$1, reason: invalid class name */
            /* JADX INFO: compiled from: WidgetReportIssueWithAutoMod.kt */
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
                    FragmentActivity fragmentActivityE = WidgetReportIssueWithAutoMod.this.e();
                    if (fragmentActivityE != null) {
                        fragmentActivityE.finish();
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
            CheckedSetting checkedSetting = getBinding().c;
            Intrinsics3.checkNotNullExpressionValue(checkedSetting, "binding.option1");
            configureOption(valid, checkedSetting, ReportIssueWithAutoModViewModel2.ALLOWED);
            CheckedSetting checkedSetting2 = getBinding().d;
            Intrinsics3.checkNotNullExpressionValue(checkedSetting2, "binding.option2");
            configureOption(valid, checkedSetting2, ReportIssueWithAutoModViewModel2.BUG);
        }
    }

    @Override // com.discord.app.AppFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeViewState(), this, null, 2, null), (Class<?>) WidgetReportIssueWithAutoMod.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass1());
    }
}
