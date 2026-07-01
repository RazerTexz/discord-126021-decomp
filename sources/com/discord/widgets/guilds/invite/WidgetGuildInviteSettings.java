package com.discord.widgets.guilds.invite;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup$LayoutParams;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup$LayoutParams;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import androidx.annotation.MainThread;
import androidx.appcompat.widget.AppCompatRadioButton;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import b.a.d.g0;
import b.a.d.i0;
import b.a.i.e0;
import b.d.b.a.a;
import com.discord.R$layout;
import com.discord.api.channel.Channel;
import com.discord.app.AppFragment;
import com.discord.app.LoggingConfig;
import com.discord.databinding.WidgetGuildInviteSettingsBinding;
import com.discord.models.domain.ModelInvite$Settings;
import com.discord.utilities.dimen.DimenUtils;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.discord.views.CheckedSetting;
import d0.d0.f;
import d0.t.c0;
import d0.t.o;
import d0.z.d.a0;
import d0.z.d.m;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import kotlin.Lazy;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.ranges.IntRange;
import kotlin.reflect.KProperty;
import rx.Observable;

/* JADX INFO: compiled from: WidgetGuildInviteSettings.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildInviteSettings extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {a.d0(WidgetGuildInviteSettings.class, "binding", "getBinding()Lcom/discord/databinding/WidgetGuildInviteSettingsBinding;", 0)};
    public static final WidgetGuildInviteSettings$Companion Companion = new WidgetGuildInviteSettings$Companion(null);
    private static final String EXTRA_CREATED_INVITE = "EXTRA_CREATED_INVITE";

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private WidgetGuildInviteSettings$ChannelsSpinnerAdapter channelsSpinnerAdapter;
    private final LoggingConfig loggingConfig;

    /* JADX INFO: renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    public WidgetGuildInviteSettings() {
        super(R$layout.widget_guild_invite_settings);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetGuildInviteSettings$binding$2.INSTANCE, null, 2, null);
        WidgetGuildInviteSettings$viewModel$2 widgetGuildInviteSettings$viewModel$2 = new WidgetGuildInviteSettings$viewModel$2(this);
        g0 g0Var = new g0(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, a0.getOrCreateKotlinClass(GuildInviteSettingsViewModel.class), new WidgetGuildInviteSettings$appViewModels$$inlined$viewModels$1(g0Var), new i0(widgetGuildInviteSettings$viewModel$2));
        this.loggingConfig = new LoggingConfig(false, null, WidgetGuildInviteSettings$loggingConfig$1.INSTANCE, 3);
    }

    public static final /* synthetic */ WidgetGuildInviteSettingsBinding access$getBinding$p(WidgetGuildInviteSettings widgetGuildInviteSettings) {
        return widgetGuildInviteSettings.getBinding();
    }

    public static final /* synthetic */ WidgetGuildInviteSettings$ChannelsSpinnerAdapter access$getChannelsSpinnerAdapter$p(WidgetGuildInviteSettings widgetGuildInviteSettings) {
        WidgetGuildInviteSettings$ChannelsSpinnerAdapter widgetGuildInviteSettings$ChannelsSpinnerAdapter = widgetGuildInviteSettings.channelsSpinnerAdapter;
        if (widgetGuildInviteSettings$ChannelsSpinnerAdapter == null) {
            m.throwUninitializedPropertyAccessException("channelsSpinnerAdapter");
        }
        return widgetGuildInviteSettings$ChannelsSpinnerAdapter;
    }

    public static final /* synthetic */ String access$getMaxUsesString(WidgetGuildInviteSettings widgetGuildInviteSettings, int i) {
        return widgetGuildInviteSettings.getMaxUsesString(i);
    }

    public static final /* synthetic */ GuildInviteSettingsViewModel access$getViewModel$p(WidgetGuildInviteSettings widgetGuildInviteSettings) {
        return widgetGuildInviteSettings.getViewModel();
    }

    public static final /* synthetic */ void access$setChannelsSpinnerAdapter$p(WidgetGuildInviteSettings widgetGuildInviteSettings, WidgetGuildInviteSettings$ChannelsSpinnerAdapter widgetGuildInviteSettings$ChannelsSpinnerAdapter) {
        widgetGuildInviteSettings.channelsSpinnerAdapter = widgetGuildInviteSettings$ChannelsSpinnerAdapter;
    }

    @MainThread
    private final void createHorizontalCheckableButtons(RadioGroup radioGroup, int[] valueSet, Function1<? super Integer, ? extends CharSequence> textFactory) {
        if (radioGroup.getChildCount() > 0) {
            return;
        }
        boolean z2 = false;
        for (int i : valueSet) {
            View viewInflate = LayoutInflater.from(getContext()).inflate(R$layout.invite_settings_radio_button, (ViewGroup) radioGroup, false);
            Objects.requireNonNull(viewInflate, "rootView");
            AppCompatRadioButton appCompatRadioButton = (AppCompatRadioButton) viewInflate;
            m.checkNotNullExpressionValue(new e0(appCompatRadioButton), "InviteSettingsRadioButto…text), radioGroup, false)");
            m.checkNotNullExpressionValue(appCompatRadioButton, "binding.root");
            appCompatRadioButton.setId(i);
            m.checkNotNullExpressionValue(appCompatRadioButton, "binding.root");
            appCompatRadioButton.setText(textFactory.invoke(Integer.valueOf(i)));
            if (!z2) {
                m.checkNotNullExpressionValue(appCompatRadioButton, "binding.root");
                ViewGroup$LayoutParams layoutParams = appCompatRadioButton.getLayoutParams();
                Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type android.widget.RadioGroup.LayoutParams");
                RadioGroup$LayoutParams radioGroup$LayoutParams = (RadioGroup$LayoutParams) layoutParams;
                radioGroup$LayoutParams.leftMargin = DimenUtils.dpToPixels(16);
                m.checkNotNullExpressionValue(appCompatRadioButton, "binding.root");
                appCompatRadioButton.setLayoutParams(radioGroup$LayoutParams);
                z2 = true;
            }
            radioGroup.addView(appCompatRadioButton);
        }
    }

    private final WidgetGuildInviteSettingsBinding getBinding() {
        return (WidgetGuildInviteSettingsBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final String getMaxUsesString(int numUses) {
        return numUses != 0 ? String.valueOf(numUses) : "∞";
    }

    private final GuildInviteSettingsViewModel getViewModel() {
        return (GuildInviteSettingsViewModel) this.viewModel.getValue();
    }

    private final void setOnItemSelected() {
        Spinner spinner = getBinding().f2417b;
        m.checkNotNullExpressionValue(spinner, "binding.guildInviteChannelSpinner");
        spinner.setOnItemSelectedListener(new WidgetGuildInviteSettings$setOnItemSelected$1(this));
    }

    public final void configureUi(GuildInviteSettingsViewModel$ViewState viewState) {
        Object obj;
        Object next;
        m.checkNotNullParameter(viewState, "viewState");
        List<Channel> invitableChannels = viewState.getInvitableChannels();
        WidgetGuildInviteSettings$ChannelsSpinnerAdapter widgetGuildInviteSettings$ChannelsSpinnerAdapter = this.channelsSpinnerAdapter;
        if (widgetGuildInviteSettings$ChannelsSpinnerAdapter == null) {
            m.throwUninitializedPropertyAccessException("channelsSpinnerAdapter");
        }
        Object[] array = invitableChannels.toArray(new Channel[0]);
        Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
        widgetGuildInviteSettings$ChannelsSpinnerAdapter.setData((Channel[]) array);
        Iterator<Channel> it = invitableChannels.iterator();
        int i = 0;
        while (true) {
            if (!it.hasNext()) {
                i = -1;
                break;
            }
            Channel next2 = it.next();
            Channel targetChannel = viewState.getTargetChannel();
            if (targetChannel != null && targetChannel.getId() == next2.getId()) {
                break;
            } else {
                i++;
            }
        }
        getBinding().f2417b.setSelection(Math.max(i, 0), false);
        ModelInvite$Settings inviteSettings = viewState.getInviteSettings();
        RadioGroup radioGroup = getBinding().c;
        m.checkNotNullExpressionValue(radioGroup, "binding.guildInviteExpiresAfterRadiogroup");
        IntRange intRangeUntil = f.until(0, radioGroup.getChildCount());
        ArrayList arrayList = new ArrayList(o.collectionSizeOrDefault(intRangeUntil, 10));
        Iterator<Integer> it2 = intRangeUntil.iterator();
        while (it2.hasNext()) {
            View childAt = getBinding().c.getChildAt(((c0) it2).nextInt());
            Objects.requireNonNull(childAt, "null cannot be cast to non-null type android.widget.RadioButton");
            arrayList.add((RadioButton) childAt);
        }
        Iterator it3 = arrayList.iterator();
        do {
            obj = null;
            if (!it3.hasNext()) {
                next = null;
                break;
            }
            next = it3.next();
        } while (!(((RadioButton) next).getId() == inviteSettings.getMaxAge()));
        RadioButton radioButton = (RadioButton) next;
        if (radioButton != null) {
            radioButton.setChecked(true);
        }
        getBinding().c.setOnCheckedChangeListener(new WidgetGuildInviteSettings$configureUi$4(this, inviteSettings));
        RadioGroup radioGroup2 = getBinding().e;
        m.checkNotNullExpressionValue(radioGroup2, "binding.guildInviteMaxUsesRadiogroup");
        IntRange intRangeUntil2 = f.until(0, radioGroup2.getChildCount());
        ArrayList arrayList2 = new ArrayList(o.collectionSizeOrDefault(intRangeUntil2, 10));
        Iterator<Integer> it4 = intRangeUntil2.iterator();
        while (it4.hasNext()) {
            View childAt2 = getBinding().e.getChildAt(((c0) it4).nextInt());
            Objects.requireNonNull(childAt2, "null cannot be cast to non-null type android.widget.RadioButton");
            arrayList2.add((RadioButton) childAt2);
        }
        for (Object obj2 : arrayList2) {
            if (((RadioButton) obj2).getId() == inviteSettings.getMaxUses()) {
                obj = obj2;
                break;
            }
        }
        RadioButton radioButton2 = (RadioButton) obj;
        if (radioButton2 != null) {
            radioButton2.setChecked(true);
        }
        getBinding().e.setOnCheckedChangeListener(new WidgetGuildInviteSettings$configureUi$8(this, inviteSettings));
        CheckedSetting checkedSetting = getBinding().f;
        m.checkNotNullExpressionValue(checkedSetting, "binding.guildInviteTemporaryMembership");
        checkedSetting.setChecked(inviteSettings.isTemporary());
        getBinding().f.e(new WidgetGuildInviteSettings$configureUi$9(this, inviteSettings));
        getBinding().d.setOnClickListener(new WidgetGuildInviteSettings$configureUi$10(this));
    }

    @Override // com.discord.app.AppFragment, com.discord.app.AppLogger$a
    public LoggingConfig getLoggingConfig() {
        return this.loggingConfig;
    }

    public final void handleEvent(GuildInviteSettingsViewModel$Event event) {
        m.checkNotNullParameter(event, "event");
        if (!(event instanceof GuildInviteSettingsViewModel$Event$InviteCreationSuccess)) {
            if (m.areEqual(event, GuildInviteSettingsViewModel$Event$InviteCreationFailure.INSTANCE)) {
                b.a.d.m.g(requireContext(), 2131888366, 0, null, 12);
            }
        } else {
            Intent intent = new Intent();
            intent.putExtra(EXTRA_CREATED_INVITE, ((GuildInviteSettingsViewModel$Event$InviteCreationSuccess) event).getInvite());
            requireActivity().setResult(-1, intent);
            requireActivity().finish();
        }
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        m.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        this.channelsSpinnerAdapter = new WidgetGuildInviteSettings$ChannelsSpinnerAdapter(requireContext(), R$layout.view_invite_settings_channel_spinner_item, null, 4, null);
        Spinner spinner = getBinding().f2417b;
        m.checkNotNullExpressionValue(spinner, "binding.guildInviteChannelSpinner");
        WidgetGuildInviteSettings$ChannelsSpinnerAdapter widgetGuildInviteSettings$ChannelsSpinnerAdapter = this.channelsSpinnerAdapter;
        if (widgetGuildInviteSettings$ChannelsSpinnerAdapter == null) {
            m.throwUninitializedPropertyAccessException("channelsSpinnerAdapter");
        }
        spinner.setAdapter((SpinnerAdapter) widgetGuildInviteSettings$ChannelsSpinnerAdapter);
        RadioGroup radioGroup = getBinding().c;
        m.checkNotNullExpressionValue(radioGroup, "binding.guildInviteExpiresAfterRadiogroup");
        int[] iArr = ModelInvite$Settings.EXPIRES_AFTER_ARRAY;
        m.checkNotNullExpressionValue(iArr, "ModelInvite.Settings.EXPIRES_AFTER_ARRAY");
        createHorizontalCheckableButtons(radioGroup, iArr, new WidgetGuildInviteSettings$onViewBound$1(this));
        RadioGroup radioGroup2 = getBinding().e;
        m.checkNotNullExpressionValue(radioGroup2, "binding.guildInviteMaxUsesRadiogroup");
        int[] iArr2 = ModelInvite$Settings.MAX_USES_ARRAY;
        m.checkNotNullExpressionValue(iArr2, "ModelInvite.Settings.MAX_USES_ARRAY");
        createHorizontalCheckableButtons(radioGroup2, iArr2, new WidgetGuildInviteSettings$onViewBound$2(this));
        setOnItemSelected();
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        Observable<GuildInviteSettingsViewModel$ViewState> observableR = getViewModel().observeViewState().r();
        m.checkNotNullExpressionValue(observableR, "viewModel.observeViewSta…  .distinctUntilChanged()");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(observableR, this, null, 2, null), WidgetGuildInviteSettings.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new WidgetGuildInviteSettings$onViewBoundOrOnResume$1(this), 62, (Object) null);
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeEvents(), this, null, 2, null), WidgetGuildInviteSettings.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new WidgetGuildInviteSettings$onViewBoundOrOnResume$2(this), 62, (Object) null);
    }
}
