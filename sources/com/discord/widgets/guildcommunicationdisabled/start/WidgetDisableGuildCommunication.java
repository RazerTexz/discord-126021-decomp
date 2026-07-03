package com.discord.widgets.guildcommunicationdisabled.start;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import com.discord.C5419R;
import com.discord.app.AppActivity;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetDisableGuildCommunicationBinding;
import com.discord.models.user.User;
import com.discord.utilities.analytics.AnalyticsTracker;
import com.discord.utilities.error.Error;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.uri.UriHandler;
import com.discord.utilities.user.UserUtils;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.discord.views.CheckedSetting;
import com.discord.widgets.guildcommunicationdisabled.start.DisableGuildCommunicationViewModel;
import com.google.android.material.textfield.TextInputLayout;
import java.lang.ref.WeakReference;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import p007b.p008a.p018d.C0862f;
import p007b.p008a.p018d.C0865g0;
import p007b.p008a.p018d.C0869i0;
import p007b.p008a.p018d.C0870j;
import p007b.p008a.p018d.C0876m;
import p007b.p008a.p027k.C1107b;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.C12083g;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12216a0;
import p507d0.p592z.p594d.C12236k;
import p507d0.p592z.p594d.C12238m;
import p658rx.Subscription;

/* JADX INFO: compiled from: WidgetDisableGuildCommunication.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetDisableGuildCommunication extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {C1643a.m846d0(WidgetDisableGuildCommunication.class, "binding", "getBinding()Lcom/discord/databinding/WidgetDisableGuildCommunicationBinding;", 0)};

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
            C12238m.checkNotNullParameter(context, "context");
            Intent intent = new Intent();
            intent.putExtra("INTENT_EXTRA_GUILD_ID", guildId);
            intent.putExtra(WidgetDisableGuildCommunication.INTENT_EXTRA_USER_ID, userId);
            C0870j.m156d(context, WidgetDisableGuildCommunication.class, intent);
            AnalyticsTracker.INSTANCE.viewedDisableCommunicationModal(guildId, userId);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.guildcommunicationdisabled.start.WidgetDisableGuildCommunication$onResume$1 */
    /* JADX INFO: compiled from: WidgetDisableGuildCommunication.kt */
    public static final /* synthetic */ class C85641 extends C12236k implements Function1<DisableGuildCommunicationViewModel.ViewState, Unit> {
        public C85641(WidgetDisableGuildCommunication widgetDisableGuildCommunication) {
            super(1, widgetDisableGuildCommunication, WidgetDisableGuildCommunication.class, "configureUI", "configureUI(Lcom/discord/widgets/guildcommunicationdisabled/start/DisableGuildCommunicationViewModel$ViewState;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(DisableGuildCommunicationViewModel.ViewState viewState) {
            invoke2(viewState);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(DisableGuildCommunicationViewModel.ViewState viewState) {
            C12238m.checkNotNullParameter(viewState, "p1");
            ((WidgetDisableGuildCommunication) this.receiver).configureUI(viewState);
        }
    }

    public WidgetDisableGuildCommunication() {
        super(C5419R.layout.widget_disable_guild_communication);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetDisableGuildCommunication$binding$2.INSTANCE, null, 2, null);
        this.userId = C12083g.lazy(new WidgetDisableGuildCommunication$userId$2(this));
        this.guildId = C12083g.lazy(new WidgetDisableGuildCommunication$guildId$2(this));
        WidgetDisableGuildCommunication$viewModel$2 widgetDisableGuildCommunication$viewModel$2 = new WidgetDisableGuildCommunication$viewModel$2(this);
        C0865g0 c0865g0 = new C0865g0(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, C12216a0.getOrCreateKotlinClass(DisableGuildCommunicationViewModel.class), new C8559x1ed01bc8(c0865g0), new C0869i0(widgetDisableGuildCommunication$viewModel$2));
    }

    private final void configureDurationOption(DisableGuildCommunicationViewModel.ViewState.Valid viewState, CheckedSetting setting, final TimeDurationDisabledCommunication settingValue) {
        setting.setChecked(viewState.getSelectedDurationOption() == settingValue);
        setting.setText(GuildCommunicationDisabledDateUtils.INSTANCE.getFriendlyDurationString(getContext(), settingValue));
        setting.m8527e(new View.OnClickListener() { // from class: com.discord.widgets.guildcommunicationdisabled.start.WidgetDisableGuildCommunication.configureDurationOption.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WidgetDisableGuildCommunication.this.getBinding().f16477d.clearFocus();
                AppFragment.hideKeyboard$default(WidgetDisableGuildCommunication.this, null, 1, null);
                WidgetDisableGuildCommunication.this.getViewModel().onDurationLengthSelected(settingValue);
            }
        });
    }

    private final void configureUI(final DisableGuildCommunicationViewModel.ViewState viewState) {
        if (viewState instanceof DisableGuildCommunicationViewModel.ViewState.Valid) {
            DisableGuildCommunicationViewModel.ViewState.Valid valid = (DisableGuildCommunicationViewModel.ViewState.Valid) viewState;
            CheckedSetting checkedSetting = getBinding().f16484k;
            C12238m.checkNotNullExpressionValue(checkedSetting, "binding.timeUnit60Seconds");
            configureDurationOption(valid, checkedSetting, TimeDurationDisabledCommunication.SECONDS_60);
            CheckedSetting checkedSetting2 = getBinding().f16483j;
            C12238m.checkNotNullExpressionValue(checkedSetting2, "binding.timeUnit5Minutes");
            configureDurationOption(valid, checkedSetting2, TimeDurationDisabledCommunication.MINUTES_5);
            CheckedSetting checkedSetting3 = getBinding().f16479f;
            C12238m.checkNotNullExpressionValue(checkedSetting3, "binding.timeUnit10Minutes");
            configureDurationOption(valid, checkedSetting3, TimeDurationDisabledCommunication.MINUTES_10);
            CheckedSetting checkedSetting4 = getBinding().f16481h;
            C12238m.checkNotNullExpressionValue(checkedSetting4, "binding.timeUnit1Hour");
            configureDurationOption(valid, checkedSetting4, TimeDurationDisabledCommunication.HOUR_1);
            CheckedSetting checkedSetting5 = getBinding().f16480g;
            C12238m.checkNotNullExpressionValue(checkedSetting5, "binding.timeUnit1Day");
            configureDurationOption(valid, checkedSetting5, TimeDurationDisabledCommunication.DAY_1);
            CheckedSetting checkedSetting6 = getBinding().f16482i;
            C12238m.checkNotNullExpressionValue(checkedSetting6, "binding.timeUnit1Week");
            configureDurationOption(valid, checkedSetting6, TimeDurationDisabledCommunication.WEEK_1);
            Context context = getContext();
            CharSequence charSequenceM210b = context != null ? C1107b.m210b(context, C5419R.string.disable_guild_communication_body_header, new Object[]{C0862f.f507a.m149a(4413305239191L, null)}, (4 & 4) != 0 ? C1107b.b.f1491j : null) : null;
            TextView textView = getBinding().f16476c;
            C12238m.checkNotNullExpressionValue(textView, "binding.disableGuildCommunicationBody");
            textView.setText(charSequenceM210b);
            getBinding().f16476c.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.guildcommunicationdisabled.start.WidgetDisableGuildCommunication.configureUI.1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    UriHandler.handle$default(UriHandler.INSTANCE, C1643a.m821I(WidgetDisableGuildCommunication.this.getBinding().f16476c, "binding.disableGuildCommunicationBody", "binding.disableGuildCommunicationBody.context"), C0862f.f507a.m149a(4413305239191L, null), false, false, null, 28, null);
                }
            });
            TextView textView2 = getBinding().f16478e;
            C12238m.checkNotNullExpressionValue(textView2, "binding.disableGuildCommunicationSubtitle");
            User user = valid.getUser();
            C1107b.m223o(textView2, user != null ? UserUtils.getUserNameWithDiscriminator$default(UserUtils.INSTANCE, user, null, null, 3, null) : null, new Object[0], null, 4);
            getBinding().f16475b.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.guildcommunicationdisabled.start.WidgetDisableGuildCommunication.configureUI.2

                /* JADX INFO: renamed from: com.discord.widgets.guildcommunicationdisabled.start.WidgetDisableGuildCommunication$configureUI$2$1, reason: invalid class name */
                /* JADX INFO: compiled from: WidgetDisableGuildCommunication.kt */
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
                        CharSequence charSequenceM210b;
                        Context context = WidgetDisableGuildCommunication.this.getContext();
                        Context context2 = WidgetDisableGuildCommunication.this.getContext();
                        if (context2 != null) {
                            Object[] objArr = new Object[2];
                            User user = ((DisableGuildCommunicationViewModel.ViewState.Valid) viewState).getUser();
                            objArr[0] = user != null ? UserUtils.getUserNameWithDiscriminator$default(UserUtils.INSTANCE, user, null, null, 3, null) : null;
                            objArr[1] = GuildCommunicationDisabledDateUtils.INSTANCE.getFriendlyDurationString(WidgetDisableGuildCommunication.this.getContext(), ((DisableGuildCommunicationViewModel.ViewState.Valid) viewState).getSelectedDurationOption());
                            charSequenceM210b = C1107b.m210b(context2, C5419R.string.disable_guild_communication_confirmed, objArr, (4 & 4) != 0 ? C1107b.b.f1491j : null);
                        } else {
                            charSequenceM210b = null;
                        }
                        C0876m.m170h(context, charSequenceM210b, 0, null, 12);
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
                    TextInputLayout textInputLayout = WidgetDisableGuildCommunication.this.getBinding().f16477d;
                    C12238m.checkNotNullExpressionValue(textInputLayout, "binding.disableGuildCommunicationReason");
                    viewModel.onDisableCommunicationConfirm(weakReference, ViewExtensions.getTextOrEmpty(textInputLayout), new AnonymousClass1());
                }
            });
            TextInputLayout textInputLayout = getBinding().f16477d;
            C12238m.checkNotNullExpressionValue(textInputLayout, "binding.disableGuildCommunicationReason");
            EditText editText = textInputLayout.getEditText();
            if (editText != null) {
                editText.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.discord.widgets.guildcommunicationdisabled.start.WidgetDisableGuildCommunication$configureUI$$inlined$apply$lambda$1
                    @Override // android.view.View.OnFocusChangeListener
                    public final void onFocusChange(View view, boolean z2) {
                        if (!z2) {
                            this.this$0.getBinding().f16477d.setHint(C5419R.string.guild_communication_disabled_reason_hint_android);
                            return;
                        }
                        TextInputLayout textInputLayout2 = this.this$0.getBinding().f16477d;
                        C12238m.checkNotNullExpressionValue(textInputLayout2, "binding.disableGuildCommunicationReason");
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
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeViewState(), this, null, 2, null), (Class<?>) WidgetDisableGuildCommunication.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C85641(this));
    }
}
