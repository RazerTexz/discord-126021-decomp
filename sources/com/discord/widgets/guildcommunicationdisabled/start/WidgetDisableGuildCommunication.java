package com.discord.widgets.guildcommunicationdisabled.start;

import android.content.Context;
import android.widget.EditText;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import b.a.d.f;
import b.a.d.g0;
import b.a.d.i0;
import b.a.k.b;
import b.d.b.a.a;
import com.discord.R$layout;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetDisableGuildCommunicationBinding;
import com.discord.models.user.User;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.user.UserUtils;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.discord.views.CheckedSetting;
import com.google.android.material.textfield.TextInputLayout;
import d0.g;
import d0.z.d.a0;
import d0.z.d.m;
import kotlin.Lazy;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.KProperty;

/* JADX INFO: compiled from: WidgetDisableGuildCommunication.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetDisableGuildCommunication extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {a.d0(WidgetDisableGuildCommunication.class, "binding", "getBinding()Lcom/discord/databinding/WidgetDisableGuildCommunicationBinding;", 0)};
    public static final WidgetDisableGuildCommunication$Companion Companion = new WidgetDisableGuildCommunication$Companion(null);
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

    public WidgetDisableGuildCommunication() {
        super(R$layout.widget_disable_guild_communication);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetDisableGuildCommunication$binding$2.INSTANCE, null, 2, null);
        this.userId = g.lazy(new WidgetDisableGuildCommunication$userId$2(this));
        this.guildId = g.lazy(new WidgetDisableGuildCommunication$guildId$2(this));
        WidgetDisableGuildCommunication$viewModel$2 widgetDisableGuildCommunication$viewModel$2 = new WidgetDisableGuildCommunication$viewModel$2(this);
        g0 g0Var = new g0(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, a0.getOrCreateKotlinClass(DisableGuildCommunicationViewModel.class), new WidgetDisableGuildCommunication$appViewModels$$inlined$viewModels$1(g0Var), new i0(widgetDisableGuildCommunication$viewModel$2));
    }

    public static final /* synthetic */ void access$configureUI(WidgetDisableGuildCommunication widgetDisableGuildCommunication, DisableGuildCommunicationViewModel$ViewState disableGuildCommunicationViewModel$ViewState) {
        widgetDisableGuildCommunication.configureUI(disableGuildCommunicationViewModel$ViewState);
    }

    public static final /* synthetic */ WidgetDisableGuildCommunicationBinding access$getBinding$p(WidgetDisableGuildCommunication widgetDisableGuildCommunication) {
        return widgetDisableGuildCommunication.getBinding();
    }

    public static final /* synthetic */ long access$getGuildId$p(WidgetDisableGuildCommunication widgetDisableGuildCommunication) {
        return widgetDisableGuildCommunication.getGuildId();
    }

    public static final /* synthetic */ long access$getUserId$p(WidgetDisableGuildCommunication widgetDisableGuildCommunication) {
        return widgetDisableGuildCommunication.getUserId();
    }

    public static final /* synthetic */ DisableGuildCommunicationViewModel access$getViewModel$p(WidgetDisableGuildCommunication widgetDisableGuildCommunication) {
        return widgetDisableGuildCommunication.getViewModel();
    }

    private final void configureDurationOption(DisableGuildCommunicationViewModel$ViewState$Valid viewState, CheckedSetting setting, TimeDurationDisabledCommunication settingValue) {
        setting.setChecked(viewState.getSelectedDurationOption() == settingValue);
        setting.setText(GuildCommunicationDisabledDateUtils.INSTANCE.getFriendlyDurationString(getContext(), settingValue));
        setting.e(new WidgetDisableGuildCommunication$configureDurationOption$1(this, settingValue));
    }

    private final void configureUI(DisableGuildCommunicationViewModel$ViewState viewState) {
        if (viewState instanceof DisableGuildCommunicationViewModel$ViewState$Valid) {
            DisableGuildCommunicationViewModel$ViewState$Valid disableGuildCommunicationViewModel$ViewState$Valid = (DisableGuildCommunicationViewModel$ViewState$Valid) viewState;
            CheckedSetting checkedSetting = getBinding().k;
            m.checkNotNullExpressionValue(checkedSetting, "binding.timeUnit60Seconds");
            configureDurationOption(disableGuildCommunicationViewModel$ViewState$Valid, checkedSetting, TimeDurationDisabledCommunication.SECONDS_60);
            CheckedSetting checkedSetting2 = getBinding().j;
            m.checkNotNullExpressionValue(checkedSetting2, "binding.timeUnit5Minutes");
            configureDurationOption(disableGuildCommunicationViewModel$ViewState$Valid, checkedSetting2, TimeDurationDisabledCommunication.MINUTES_5);
            CheckedSetting checkedSetting3 = getBinding().f;
            m.checkNotNullExpressionValue(checkedSetting3, "binding.timeUnit10Minutes");
            configureDurationOption(disableGuildCommunicationViewModel$ViewState$Valid, checkedSetting3, TimeDurationDisabledCommunication.MINUTES_10);
            CheckedSetting checkedSetting4 = getBinding().h;
            m.checkNotNullExpressionValue(checkedSetting4, "binding.timeUnit1Hour");
            configureDurationOption(disableGuildCommunicationViewModel$ViewState$Valid, checkedSetting4, TimeDurationDisabledCommunication.HOUR_1);
            CheckedSetting checkedSetting5 = getBinding().g;
            m.checkNotNullExpressionValue(checkedSetting5, "binding.timeUnit1Day");
            configureDurationOption(disableGuildCommunicationViewModel$ViewState$Valid, checkedSetting5, TimeDurationDisabledCommunication.DAY_1);
            CheckedSetting checkedSetting6 = getBinding().i;
            m.checkNotNullExpressionValue(checkedSetting6, "binding.timeUnit1Week");
            configureDurationOption(disableGuildCommunicationViewModel$ViewState$Valid, checkedSetting6, TimeDurationDisabledCommunication.WEEK_1);
            Context context = getContext();
            CharSequence charSequenceH = context != null ? b.h(context, 2131888467, new Object[]{f.a.a(4413305239191L, null)}, null, 4) : null;
            TextView textView = getBinding().c;
            m.checkNotNullExpressionValue(textView, "binding.disableGuildCommunicationBody");
            textView.setText(charSequenceH);
            getBinding().c.setOnClickListener(new WidgetDisableGuildCommunication$configureUI$1(this));
            TextView textView2 = getBinding().e;
            m.checkNotNullExpressionValue(textView2, "binding.disableGuildCommunicationSubtitle");
            User user = disableGuildCommunicationViewModel$ViewState$Valid.getUser();
            b.o(textView2, user != null ? UserUtils.getUserNameWithDiscriminator$default(UserUtils.INSTANCE, user, null, null, 3, null) : null, new Object[0], null, 4);
            getBinding().f2367b.setOnClickListener(new WidgetDisableGuildCommunication$configureUI$2(this, viewState));
            TextInputLayout textInputLayout = getBinding().d;
            m.checkNotNullExpressionValue(textInputLayout, "binding.disableGuildCommunicationReason");
            EditText editText = textInputLayout.getEditText();
            if (editText != null) {
                editText.setOnFocusChangeListener(new WidgetDisableGuildCommunication$configureUI$$inlined$apply$lambda$1(this));
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
        Companion.launch(j, j2, context);
    }

    @Override // com.discord.app.AppFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeViewState(), this, null, 2, null), WidgetDisableGuildCommunication.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new WidgetDisableGuildCommunication$onResume$1(this), 62, (Object) null);
    }
}
