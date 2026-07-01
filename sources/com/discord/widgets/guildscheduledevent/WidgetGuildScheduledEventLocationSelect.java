package com.discord.widgets.guildscheduledevent;

import android.content.Context;
import android.content.Intent;
import android.text.Editable;
import android.view.View;
import android.widget.TextView;
import androidx.activity.result.ActivityResultLauncher;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import b.a.d.f0;
import b.a.d.g0;
import b.a.d.i0;
import b.a.k.b;
import b.d.b.a.a;
import com.discord.R$layout;
import com.discord.api.channel.Channel;
import com.discord.api.guildscheduledevent.GuildScheduledEventEntityType;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetGuildScheduledEventLocationSelectBinding;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.discord.views.CheckedSetting;
import com.discord.widgets.channels.WidgetChannelSelector;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import d0.g;
import d0.z.d.a0;
import d0.z.d.m;
import java.util.Set;
import kotlin.Lazy;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.KProperty;

/* JADX INFO: compiled from: WidgetGuildScheduledEventLocationSelect.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildScheduledEventLocationSelect extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {a.d0(WidgetGuildScheduledEventLocationSelect.class, "binding", "getBinding()Lcom/discord/databinding/WidgetGuildScheduledEventLocationSelectBinding;", 0)};
    public static final WidgetGuildScheduledEventLocationSelect$Companion Companion = new WidgetGuildScheduledEventLocationSelect$Companion(null);
    private static final String GUILD_SCHEDULED_EVENT_LOCATION_SELECT_REQUEST_KEY = "GUILD_SCHEDULED_EVENT_LOCATION_SELECT_REQUEST_KEY";

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private WidgetGuildScheduledEventLocationSelectViewModel$ViewState$Valid currentViewState;

    /* JADX INFO: renamed from: existingGuildScheduledEventId$delegate, reason: from kotlin metadata */
    private final Lazy existingGuildScheduledEventId;

    /* JADX INFO: renamed from: guildId$delegate, reason: from kotlin metadata */
    private final Lazy guildId;

    /* JADX INFO: renamed from: hubViewModel$delegate, reason: from kotlin metadata */
    private final Lazy hubViewModel;
    private final ActivityResultLauncher<Intent> nextStepLauncher;

    /* JADX INFO: renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    public WidgetGuildScheduledEventLocationSelect() {
        super(R$layout.widget_guild_scheduled_event_location_select);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetGuildScheduledEventLocationSelect$binding$2.INSTANCE, null, 2, null);
        this.guildId = g.lazy(new WidgetGuildScheduledEventLocationSelect$guildId$2(this));
        this.existingGuildScheduledEventId = g.lazy(new WidgetGuildScheduledEventLocationSelect$existingGuildScheduledEventId$2(this));
        this.hubViewModel = FragmentViewModelLazyKt.createViewModelLazy(this, a0.getOrCreateKotlinClass(GuildScheduledEventDirectoryAssociationViewModel.class), new WidgetGuildScheduledEventLocationSelect$appActivityViewModels$$inlined$activityViewModels$1(this), new f0(new WidgetGuildScheduledEventLocationSelect$hubViewModel$2(this)));
        WidgetGuildScheduledEventLocationSelect$viewModel$2 widgetGuildScheduledEventLocationSelect$viewModel$2 = new WidgetGuildScheduledEventLocationSelect$viewModel$2(this);
        g0 g0Var = new g0(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, a0.getOrCreateKotlinClass(WidgetGuildScheduledEventLocationSelectViewModel.class), new WidgetGuildScheduledEventLocationSelect$appViewModels$$inlined$viewModels$1(g0Var), new i0(widgetGuildScheduledEventLocationSelect$viewModel$2));
        this.nextStepLauncher = WidgetGuildScheduledEventSettings.Companion.registerForResult(this, new WidgetGuildScheduledEventLocationSelect$nextStepLauncher$1(this), new WidgetGuildScheduledEventLocationSelect$nextStepLauncher$2(this));
    }

    public static final /* synthetic */ void access$configureUI(WidgetGuildScheduledEventLocationSelect widgetGuildScheduledEventLocationSelect, WidgetGuildScheduledEventLocationSelectViewModel$ViewState widgetGuildScheduledEventLocationSelectViewModel$ViewState) {
        widgetGuildScheduledEventLocationSelect.configureUI(widgetGuildScheduledEventLocationSelectViewModel$ViewState);
    }

    public static final /* synthetic */ WidgetGuildScheduledEventLocationSelectViewModel$ViewState$Valid access$getCurrentViewState$p(WidgetGuildScheduledEventLocationSelect widgetGuildScheduledEventLocationSelect) {
        return widgetGuildScheduledEventLocationSelect.currentViewState;
    }

    public static final /* synthetic */ Long access$getExistingGuildScheduledEventId$p(WidgetGuildScheduledEventLocationSelect widgetGuildScheduledEventLocationSelect) {
        return widgetGuildScheduledEventLocationSelect.getExistingGuildScheduledEventId();
    }

    public static final /* synthetic */ long access$getGuildId$p(WidgetGuildScheduledEventLocationSelect widgetGuildScheduledEventLocationSelect) {
        return widgetGuildScheduledEventLocationSelect.getGuildId();
    }

    public static final /* synthetic */ WidgetGuildScheduledEventLocationSelectViewModel access$getViewModel$p(WidgetGuildScheduledEventLocationSelect widgetGuildScheduledEventLocationSelect) {
        return widgetGuildScheduledEventLocationSelect.getViewModel();
    }

    public static final /* synthetic */ void access$navigateNext(WidgetGuildScheduledEventLocationSelect widgetGuildScheduledEventLocationSelect) {
        widgetGuildScheduledEventLocationSelect.navigateNext();
    }

    public static final /* synthetic */ void access$setCurrentViewState$p(WidgetGuildScheduledEventLocationSelect widgetGuildScheduledEventLocationSelect, WidgetGuildScheduledEventLocationSelectViewModel$ViewState$Valid widgetGuildScheduledEventLocationSelectViewModel$ViewState$Valid) {
        widgetGuildScheduledEventLocationSelect.currentViewState = widgetGuildScheduledEventLocationSelectViewModel$ViewState$Valid;
    }

    private final void configureLocationOption(WidgetGuildScheduledEventLocationSelectViewModel$ViewState$Valid viewState, CheckedSetting setting, GuildScheduledEventEntityType settingValue, CharSequence disabledMessage) {
        setting.setChecked(viewState.getSelectedLocationOption() == settingValue);
        if (disabledMessage != null) {
            setting.c(disabledMessage);
        } else {
            setting.e(new WidgetGuildScheduledEventLocationSelect$configureLocationOption$1(this, settingValue));
        }
    }

    private final void configureUI(WidgetGuildScheduledEventLocationSelectViewModel$ViewState viewState) {
        if (viewState instanceof WidgetGuildScheduledEventLocationSelectViewModel$ViewState$Valid) {
            WidgetGuildScheduledEventLocationSelectViewModel$ViewState$Valid widgetGuildScheduledEventLocationSelectViewModel$ViewState$Valid = (WidgetGuildScheduledEventLocationSelectViewModel$ViewState$Valid) viewState;
            this.currentViewState = widgetGuildScheduledEventLocationSelectViewModel$ViewState$Valid;
            CheckedSetting checkedSetting = getBinding().j;
            m.checkNotNullExpressionValue(checkedSetting, "binding.stageChannelOption");
            configureLocationOption(widgetGuildScheduledEventLocationSelectViewModel$ViewState$Valid, checkedSetting, GuildScheduledEventEntityType.STAGE_INSTANCE, getDisabledMessageForChannelOption(widgetGuildScheduledEventLocationSelectViewModel$ViewState$Valid.getAvailableStageChannelIds(), widgetGuildScheduledEventLocationSelectViewModel$ViewState$Valid.getCanChangeChannel()));
            CheckedSetting checkedSetting2 = getBinding().m;
            m.checkNotNullExpressionValue(checkedSetting2, "binding.voiceChannelOption");
            configureLocationOption(widgetGuildScheduledEventLocationSelectViewModel$ViewState$Valid, checkedSetting2, GuildScheduledEventEntityType.VOICE, getDisabledMessageForChannelOption(widgetGuildScheduledEventLocationSelectViewModel$ViewState$Valid.getAvailableVoiceChannelIds(), widgetGuildScheduledEventLocationSelectViewModel$ViewState$Valid.getCanChangeChannel()));
            CheckedSetting checkedSetting3 = getBinding().g;
            m.checkNotNullExpressionValue(checkedSetting3, "binding.externalOption");
            configureLocationOption(widgetGuildScheduledEventLocationSelectViewModel$ViewState$Valid, checkedSetting3, GuildScheduledEventEntityType.EXTERNAL, getDisabledMessageForExternalOption(widgetGuildScheduledEventLocationSelectViewModel$ViewState$Valid.getCanCreateExternalEvent(), widgetGuildScheduledEventLocationSelectViewModel$ViewState$Valid.getCanChangeChannel()));
            boolean z2 = (widgetGuildScheduledEventLocationSelectViewModel$ViewState$Valid.getAvailableStageChannelIds().isEmpty() ^ true) || widgetGuildScheduledEventLocationSelectViewModel$ViewState$Valid.getShowStageOptionIfUnavailable();
            CheckedSetting checkedSetting4 = getBinding().j;
            m.checkNotNullExpressionValue(checkedSetting4, "binding.stageChannelOption");
            checkedSetting4.setVisibility(z2 ? 0 : 8);
            View view = getBinding().l;
            m.checkNotNullExpressionValue(view, "binding.voiceChannelDivider");
            view.setVisibility(z2 ? 0 : 8);
            int iOrdinal = widgetGuildScheduledEventLocationSelectViewModel$ViewState$Valid.getSelectedLocationOption().ordinal();
            if (iOrdinal == 1 || iOrdinal == 2) {
                TextView textView = getBinding().h;
                m.checkNotNullExpressionValue(textView, "binding.locationHeader");
                ViewExtensions.setTextAndVisibilityBy(textView, getString(2131890105));
                TextInputLayout textInputLayout = getBinding().c;
                m.checkNotNullExpressionValue(textInputLayout, "binding.channelLocationLayout");
                textInputLayout.setVisibility(0);
                TextInputLayout textInputLayout2 = getBinding().f;
                m.checkNotNullExpressionValue(textInputLayout2, "binding.externalLocationLayout");
                textInputLayout2.setVisibility(8);
            } else if (iOrdinal != 3) {
                TextView textView2 = getBinding().h;
                m.checkNotNullExpressionValue(textView2, "binding.locationHeader");
                textView2.setVisibility(8);
                TextInputLayout textInputLayout3 = getBinding().c;
                m.checkNotNullExpressionValue(textInputLayout3, "binding.channelLocationLayout");
                textInputLayout3.setVisibility(8);
                TextInputLayout textInputLayout4 = getBinding().f;
                m.checkNotNullExpressionValue(textInputLayout4, "binding.externalLocationLayout");
                textInputLayout4.setVisibility(8);
            } else {
                TextView textView3 = getBinding().h;
                m.checkNotNullExpressionValue(textView3, "binding.locationHeader");
                ViewExtensions.setTextAndVisibilityBy(textView3, getString(2131890096));
                TextInputLayout textInputLayout5 = getBinding().c;
                m.checkNotNullExpressionValue(textInputLayout5, "binding.channelLocationLayout");
                textInputLayout5.setVisibility(8);
                TextInputLayout textInputLayout6 = getBinding().f;
                m.checkNotNullExpressionValue(textInputLayout6, "binding.externalLocationLayout");
                textInputLayout6.setVisibility(0);
            }
            TextInputEditText textInputEditText = getBinding().f2447b;
            ViewExtensions.setEnabledAndAlpha$default(textInputEditText, widgetGuildScheduledEventLocationSelectViewModel$ViewState$Valid.getCanChangeChannel(), 0.0f, 2, null);
            Editable text = textInputEditText.getText();
            String string = text != null ? text.toString() : null;
            Channel selectedChannel = widgetGuildScheduledEventLocationSelectViewModel$ViewState$Valid.getSelectedChannel();
            if (!m.areEqual(string, selectedChannel != null ? selectedChannel.getName() : null)) {
                Channel selectedChannel2 = widgetGuildScheduledEventLocationSelectViewModel$ViewState$Valid.getSelectedChannel();
                textInputEditText.setText(selectedChannel2 != null ? selectedChannel2.getName() : null);
            }
            TextInputEditText textInputEditText2 = getBinding().e;
            Editable text2 = textInputEditText2.getText();
            if (!m.areEqual(text2 != null ? text2.toString() : null, widgetGuildScheduledEventLocationSelectViewModel$ViewState$Valid.getExternalLocation())) {
                textInputEditText2.setText(widgetGuildScheduledEventLocationSelectViewModel$ViewState$Valid.getExternalLocation());
            }
            MaterialButton materialButton = getBinding().i;
            m.checkNotNullExpressionValue(materialButton, "binding.nextButton");
            materialButton.setEnabled(isNextEnabled(widgetGuildScheduledEventLocationSelectViewModel$ViewState$Valid));
        }
    }

    private final WidgetGuildScheduledEventLocationSelectBinding getBinding() {
        return (WidgetGuildScheduledEventLocationSelectBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final CharSequence getDisabledMessageForChannelOption(Set<Long> channelIds, boolean canChangeEntityType) {
        if (!canChangeEntityType) {
            return getString(2131890092);
        }
        if (channelIds.isEmpty()) {
            return getString(2131890094);
        }
        return null;
    }

    private final CharSequence getDisabledMessageForExternalOption(boolean canCreateExternalEvent, boolean canChangeEntityType) {
        if (!canChangeEntityType) {
            return getString(2131890092);
        }
        if (canCreateExternalEvent) {
            return null;
        }
        return getString(2131890093);
    }

    private final Long getExistingGuildScheduledEventId() {
        return (Long) this.existingGuildScheduledEventId.getValue();
    }

    private final long getGuildId() {
        return ((Number) this.guildId.getValue()).longValue();
    }

    private final GuildScheduledEventDirectoryAssociationViewModel getHubViewModel() {
        return (GuildScheduledEventDirectoryAssociationViewModel) this.hubViewModel.getValue();
    }

    private static /* synthetic */ void getHubViewModel$annotations() {
    }

    private final WidgetGuildScheduledEventLocationSelectViewModel getViewModel() {
        return (WidgetGuildScheduledEventLocationSelectViewModel) this.viewModel.getValue();
    }

    private final boolean isNextEnabled(WidgetGuildScheduledEventLocationSelectViewModel$ViewState$Valid viewState) {
        int iOrdinal = viewState.getSelectedLocationOption().ordinal();
        if (iOrdinal == 1 || iOrdinal == 2) {
            if (viewState.getSelectedChannel() == null) {
                return false;
            }
        } else if (iOrdinal != 3 || viewState.getExternalLocation().length() <= 0) {
            return false;
        }
        return true;
    }

    private final void navigateNext() {
        WidgetGuildScheduledEventLocationSelectViewModel$ViewState$Valid widgetGuildScheduledEventLocationSelectViewModel$ViewState$Valid = this.currentViewState;
        if (widgetGuildScheduledEventLocationSelectViewModel$ViewState$Valid != null) {
            WidgetGuildScheduledEventSettings$Companion widgetGuildScheduledEventSettings$Companion = WidgetGuildScheduledEventSettings.Companion;
            Context contextRequireContext = requireContext();
            ActivityResultLauncher<Intent> activityResultLauncher = this.nextStepLauncher;
            long guildId = getGuildId();
            GuildScheduledEventEntityType selectedLocationOption = widgetGuildScheduledEventLocationSelectViewModel$ViewState$Valid.getSelectedLocationOption();
            Channel selectedChannel = widgetGuildScheduledEventLocationSelectViewModel$ViewState$Valid.getSelectedChannel();
            widgetGuildScheduledEventSettings$Companion.launch(contextRequireContext, activityResultLauncher, guildId, selectedLocationOption, selectedChannel != null ? Long.valueOf(selectedChannel.getId()) : null, widgetGuildScheduledEventLocationSelectViewModel$ViewState$Valid.getExternalLocation(), getExistingGuildScheduledEventId());
        }
    }

    @Override // com.discord.app.AppFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeViewState(), this, null, 2, null), WidgetGuildScheduledEventLocationSelect.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new WidgetGuildScheduledEventLocationSelect$onResume$1(this), 62, (Object) null);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        m.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        TextView textView = getBinding().k;
        m.checkNotNullExpressionValue(textView, "binding.stepText");
        b.n(textView, 2131890132, new Object[]{1, 3}, null, 4);
        getBinding().d.setOnClickListener(new WidgetGuildScheduledEventLocationSelect$onViewBound$1(this));
        TextInputEditText textInputEditText = getBinding().e;
        m.checkNotNullExpressionValue(textInputEditText, "binding.externalLocationInput");
        textInputEditText.addTextChangedListener(new WidgetGuildScheduledEventLocationSelect$onViewBound$$inlined$addTextChangedListener$1(this));
        getBinding().f2447b.setOnClickListener(new WidgetGuildScheduledEventLocationSelect$onViewBound$3(this));
        WidgetChannelSelector.Companion.registerForResult(this, GUILD_SCHEDULED_EVENT_LOCATION_SELECT_REQUEST_KEY, false, new WidgetGuildScheduledEventLocationSelect$onViewBound$4(this));
        TextInputLayout textInputLayout = getBinding().f;
        m.checkNotNullExpressionValue(textInputLayout, "binding.externalLocationLayout");
        ViewExtensions.setOnImeActionDone$default(textInputLayout, false, new WidgetGuildScheduledEventLocationSelect$onViewBound$5(this), 1, null);
        getBinding().i.setOnClickListener(new WidgetGuildScheduledEventLocationSelect$onViewBound$6(this));
    }
}
