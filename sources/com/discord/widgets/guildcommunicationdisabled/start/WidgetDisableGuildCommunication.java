package com.discord.widgets.guildcommunicationdisabled.start;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import b.a.d.AppHelpDesk;
import b.a.d.AppScreen2;
import b.a.d.AppToast;
import b.a.d.AppViewModelDelegates3;
import b.a.d.AppViewModelDelegates5;
import b.a.k.FormatUtils;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.app.AppActivity;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetDisableGuildCommunicationBinding;
import com.discord.models.user.User;
import com.discord.utilities.analytics.AnalyticsTracker;
import com.discord.utilities.error.Error;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.uri.UriHandler;
import com.discord.utilities.user.UserUtils;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.views.CheckedSetting;
import com.discord.widgets.guildcommunicationdisabled.start.DisableGuildCommunicationViewModel;
import com.google.android.material.textfield.TextInputLayout;
import d0.LazyJVM;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import d0.z.d.Reflection2;
import java.lang.ref.WeakReference;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import rx.Subscription;

/* JADX INFO: compiled from: WidgetDisableGuildCommunication.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetDisableGuildCommunication extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.d0(WidgetDisableGuildCommunication.class, "binding", "getBinding()Lcom/discord/databinding/WidgetDisableGuildCommunicationBinding;", 0)};

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String INTENT_EXTRA_GUILD_ID = "INTENT_EXTRA_GUILD_ID";
    private static final String INTENT_EXTRA_USER_ID = "INTENT_EXTRA_USER_ID";

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* JADX INFO: renamed from: guildId$delegate, reason: from kotlin metadata */
    private final Lazy guildId;

    /* JADX INFO: renamed from: userId$delegate, reason: from kotlin metadata */
    private final Lazy userId;

    /* JADX INFO: renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    /* JADX INFO: compiled from: WidgetDisableGuildCommunication.kt */
    public static final class Companion {
        private Companion() {
        }

        public final void launch(long userId, long guildId, Context context) {
            Intrinsics3.checkNotNullParameter(context, "context");
            Intent intent = new Intent();
            intent.putExtra("INTENT_EXTRA_GUILD_ID", guildId);
            intent.putExtra(WidgetDisableGuildCommunication.INTENT_EXTRA_USER_ID, userId);
            AppScreen2.d(context, WidgetDisableGuildCommunication.class, intent);
            AnalyticsTracker.INSTANCE.viewedDisableCommunicationModal(guildId, userId);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.guildcommunicationdisabled.start.WidgetDisableGuildCommunication$onResume$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetDisableGuildCommunication.kt */
    public static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<DisableGuildCommunicationViewModel.ViewState, Unit> {
        public AnonymousClass1(WidgetDisableGuildCommunication widgetDisableGuildCommunication) {
            super(1, widgetDisableGuildCommunication, WidgetDisableGuildCommunication.class, "configureUI", "configureUI(Lcom/discord/widgets/guildcommunicationdisabled/start/DisableGuildCommunicationViewModel$ViewState;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(DisableGuildCommunicationViewModel.ViewState viewState) {
            invoke2(viewState);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(DisableGuildCommunicationViewModel.ViewState viewState) {
            Intrinsics3.checkNotNullParameter(viewState, "p1");
            ((WidgetDisableGuildCommunication) this.receiver).configureUI(viewState);
        }
    }

    public WidgetDisableGuildCommunication() {
        super(R.layout.widget_disable_guild_communication);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetDisableGuildCommunication2.INSTANCE, null, 2, null);
        this.userId = LazyJVM.lazy(new WidgetDisableGuildCommunication5(this));
        this.guildId = LazyJVM.lazy(new WidgetDisableGuildCommunication4(this));
        WidgetDisableGuildCommunication6 widgetDisableGuildCommunication6 = new WidgetDisableGuildCommunication6(this);
        AppViewModelDelegates3 appViewModelDelegates3 = new AppViewModelDelegates3(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection2.getOrCreateKotlinClass(DisableGuildCommunicationViewModel.class), new WidgetDisableGuildCommunication$appViewModels$$inlined$viewModels$1(appViewModelDelegates3), new AppViewModelDelegates5(widgetDisableGuildCommunication6));
    }

    private final void configureDurationOption(DisableGuildCommunicationViewModel.ViewState.Valid viewState, CheckedSetting setting, final GuildCommunicationDisabledDateUtils2 settingValue) {
        setting.setChecked(viewState.getSelectedDurationOption() == settingValue);
        setting.setText(GuildCommunicationDisabledDateUtils.INSTANCE.getFriendlyDurationString(getContext(), settingValue));
        setting.e(new View.OnClickListener() { // from class: com.discord.widgets.guildcommunicationdisabled.start.WidgetDisableGuildCommunication.configureDurationOption.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WidgetDisableGuildCommunication.this.getBinding().d.clearFocus();
                AppFragment.hideKeyboard$default(WidgetDisableGuildCommunication.this, null, 1, null);
                WidgetDisableGuildCommunication.this.getViewModel().onDurationLengthSelected(settingValue);
            }
        });
    }

    private final void configureUI(final DisableGuildCommunicationViewModel.ViewState viewState) {
        if (viewState instanceof DisableGuildCommunicationViewModel.ViewState.Valid) {
            DisableGuildCommunicationViewModel.ViewState.Valid valid = (DisableGuildCommunicationViewModel.ViewState.Valid) viewState;
            CheckedSetting checkedSetting = getBinding().k;
            Intrinsics3.checkNotNullExpressionValue(checkedSetting, "binding.timeUnit60Seconds");
            configureDurationOption(valid, checkedSetting, GuildCommunicationDisabledDateUtils2.SECONDS_60);
            CheckedSetting checkedSetting2 = getBinding().j;
            Intrinsics3.checkNotNullExpressionValue(checkedSetting2, "binding.timeUnit5Minutes");
            configureDurationOption(valid, checkedSetting2, GuildCommunicationDisabledDateUtils2.MINUTES_5);
            CheckedSetting checkedSetting3 = getBinding().f;
            Intrinsics3.checkNotNullExpressionValue(checkedSetting3, "binding.timeUnit10Minutes");
            configureDurationOption(valid, checkedSetting3, GuildCommunicationDisabledDateUtils2.MINUTES_10);
            CheckedSetting checkedSetting4 = getBinding().h;
            Intrinsics3.checkNotNullExpressionValue(checkedSetting4, "binding.timeUnit1Hour");
            configureDurationOption(valid, checkedSetting4, GuildCommunicationDisabledDateUtils2.HOUR_1);
            CheckedSetting checkedSetting5 = getBinding().g;
            Intrinsics3.checkNotNullExpressionValue(checkedSetting5, "binding.timeUnit1Day");
            configureDurationOption(valid, checkedSetting5, GuildCommunicationDisabledDateUtils2.DAY_1);
            CheckedSetting checkedSetting6 = getBinding().i;
            Intrinsics3.checkNotNullExpressionValue(checkedSetting6, "binding.timeUnit1Week");
            configureDurationOption(valid, checkedSetting6, GuildCommunicationDisabledDateUtils2.WEEK_1);
            Context context = getContext();
            CharSequence charSequenceB = context != null ? FormatUtils.b(context, R.string.disable_guild_communication_body_header, new Object[]{AppHelpDesk.a.a(4413305239191L, null)}, (4 & 4) != 0 ? FormatUtils.b.j : null) : null;
            TextView textView = getBinding().c;
            Intrinsics3.checkNotNullExpressionValue(textView, "binding.disableGuildCommunicationBody");
            textView.setText(charSequenceB);
            getBinding().c.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.guildcommunicationdisabled.start.WidgetDisableGuildCommunication.configureUI.1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    UriHandler.handle$default(UriHandler.INSTANCE, outline.I(WidgetDisableGuildCommunication.this.getBinding().c, "binding.disableGuildCommunicationBody", "binding.disableGuildCommunicationBody.context"), AppHelpDesk.a.a(4413305239191L, null), false, false, null, 28, null);
                }
            });
            TextView textView2 = getBinding().e;
            Intrinsics3.checkNotNullExpressionValue(textView2, "binding.disableGuildCommunicationSubtitle");
            User user = valid.getUser();
            FormatUtils.o(textView2, user != null ? UserUtils.getUserNameWithDiscriminator$default(UserUtils.INSTANCE, user, null, null, 3, null) : null, new Object[0], null, 4);
            getBinding().f2367b.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.guildcommunicationdisabled.start.WidgetDisableGuildCommunication.configureUI.2

                /* JADX INFO: renamed from: com.discord.widgets.guildcommunicationdisabled.start.WidgetDisableGuildCommunication$configureUI$2$1, reason: invalid class name */
                /* JADX INFO: compiled from: WidgetDisableGuildCommunication.kt */
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
                        CharSequence charSequenceB;
                        Context context = WidgetDisableGuildCommunication.this.getContext();
                        Context context2 = WidgetDisableGuildCommunication.this.getContext();
                        if (context2 != null) {
                            Object[] objArr = new Object[2];
                            User user = ((DisableGuildCommunicationViewModel.ViewState.Valid) viewState).getUser();
                            objArr[0] = user != null ? UserUtils.getUserNameWithDiscriminator$default(UserUtils.INSTANCE, user, null, null, 3, null) : null;
                            objArr[1] = GuildCommunicationDisabledDateUtils.INSTANCE.getFriendlyDurationString(WidgetDisableGuildCommunication.this.getContext(), ((DisableGuildCommunicationViewModel.ViewState.Valid) viewState).getSelectedDurationOption());
                            charSequenceB = FormatUtils.b(context2, R.string.disable_guild_communication_confirmed, objArr, (4 & 4) != 0 ? FormatUtils.b.j : null);
                        } else {
                            charSequenceB = null;
                        }
                        AppToast.h(context, charSequenceB, 0, null, 12);
                        AppActivity appActivity = WidgetDisableGuildCommunication.this.getAppActivity();
                        if (appActivity != null) {
                            appActivity.finish();
                        }
                    }
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    WeakReference<Context> weakReference = new WeakReference<>(WidgetDisableGuildCommunication.this.requireContext());
                    DisableGuildCommunicationViewModel viewModel = WidgetDisableGuildCommunication.this.getViewModel();
                    TextInputLayout textInputLayout = WidgetDisableGuildCommunication.this.getBinding().d;
                    Intrinsics3.checkNotNullExpressionValue(textInputLayout, "binding.disableGuildCommunicationReason");
                    viewModel.onDisableCommunicationConfirm(weakReference, ViewExtensions.getTextOrEmpty(textInputLayout), new AnonymousClass1());
                }
            });
            TextInputLayout textInputLayout = getBinding().d;
            Intrinsics3.checkNotNullExpressionValue(textInputLayout, "binding.disableGuildCommunicationReason");
            EditText editText = textInputLayout.getEditText();
            if (editText != null) {
                editText.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.discord.widgets.guildcommunicationdisabled.start.WidgetDisableGuildCommunication$configureUI$$inlined$apply$lambda$1
                    @Override // android.view.View.OnFocusChangeListener
                    public final void onFocusChange(View view, boolean z2) {
                        if (!z2) {
                            this.this$0.getBinding().d.setHint(R.string.guild_communication_disabled_reason_hint_android);
                            return;
                        }
                        TextInputLayout textInputLayout2 = this.this$0.getBinding().d;
                        Intrinsics3.checkNotNullExpressionValue(textInputLayout2, "binding.disableGuildCommunicationReason");
                        textInputLayout2.setHint("");
                    }
                });
            }
        }
    }

    private final WidgetDisableGuildCommunicationBinding getBinding() {
        return (WidgetDisableGuildCommunicationBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final long getGuildId() {
        return ((Number) this.guildId.getValue()).longValue();
    }

    private final long getUserId() {
        return ((Number) this.userId.getValue()).longValue();
    }

    private final DisableGuildCommunicationViewModel getViewModel() {
        return (DisableGuildCommunicationViewModel) this.viewModel.getValue();
    }

    public static final void launch(long j, long j2, Context context) {
        INSTANCE.launch(j, j2, context);
    }

    @Override // com.discord.app.AppFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeViewState(), this, null, 2, null), (Class<?>) WidgetDisableGuildCommunication.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass1(this));
    }
}
