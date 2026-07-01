package com.discord.widgets.guildscheduledevent;

import android.content.Context;
import android.content.Intent;
import android.text.Editable;
import android.text.format.DateUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.activity.result.ActivityResultLauncher;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentViewModelLazyKt;
import b.a.d.f0;
import b.a.d.g0;
import b.a.d.i0;
import b.a.k.b;
import b.d.b.a.a;
import com.discord.R$layout;
import com.discord.api.guildscheduledevent.GuildScheduledEvent;
import com.discord.api.guildscheduledevent.GuildScheduledEventBroadcast;
import com.discord.api.guildscheduledevent.GuildScheduledEventEntityType;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetGuildScheduledEventSettingsBinding;
import com.discord.utilities.guildscheduledevent.GuildScheduledEventTiming;
import com.discord.utilities.guildscheduledevent.GuildScheduledEventUtilities;
import com.discord.utilities.guildscheduledevent.GuildScheduledEventUtilitiesKt;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.checkbox.MaterialCheckBox;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import d0.g;
import d0.z.d.a0;
import d0.z.d.m;
import java.util.Objects;
import kotlin.Lazy;
import kotlin.Pair;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.KProperty;
import rx.Observable;

/* JADX INFO: compiled from: WidgetGuildScheduledEventSettings.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildScheduledEventSettings extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {a.d0(WidgetGuildScheduledEventSettings.class, "binding", "getBinding()Lcom/discord/databinding/WidgetGuildScheduledEventSettingsBinding;", 0)};
    public static final WidgetGuildScheduledEventSettings$Companion Companion = new WidgetGuildScheduledEventSettings$Companion(null);
    private static final String EXTRA_ENTITY_TYPE = "EXTRA_ENTITY_TYPE";
    private static final String EXTRA_EXTERNAL_LOCATION = "EXTRA_EXTERNAL_LOCATION";
    private static final int RESULT_QUIT = 2;

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private GuildScheduledEventSettingsViewModel$ViewState$Initialized currentViewState;

    /* JADX INFO: renamed from: existingGuildScheduledEventId$delegate, reason: from kotlin metadata */
    private final Lazy existingGuildScheduledEventId;

    /* JADX INFO: renamed from: guildId$delegate, reason: from kotlin metadata */
    private final Lazy guildId;

    /* JADX INFO: renamed from: hubViewModel$delegate, reason: from kotlin metadata */
    private final Lazy hubViewModel;
    private final ActivityResultLauncher<Intent> previewLauncher;

    /* JADX INFO: renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    public WidgetGuildScheduledEventSettings() {
        super(R$layout.widget_guild_scheduled_event_settings);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetGuildScheduledEventSettings$binding$2.INSTANCE, null, 2, null);
        this.guildId = g.lazy(new WidgetGuildScheduledEventSettings$guildId$2(this));
        this.existingGuildScheduledEventId = g.lazy(new WidgetGuildScheduledEventSettings$existingGuildScheduledEventId$2(this));
        this.hubViewModel = FragmentViewModelLazyKt.createViewModelLazy(this, a0.getOrCreateKotlinClass(GuildScheduledEventDirectoryAssociationViewModel.class), new WidgetGuildScheduledEventSettings$appActivityViewModels$$inlined$activityViewModels$1(this), new f0(new WidgetGuildScheduledEventSettings$hubViewModel$2(this)));
        WidgetGuildScheduledEventSettings$viewModel$2 widgetGuildScheduledEventSettings$viewModel$2 = new WidgetGuildScheduledEventSettings$viewModel$2(this);
        g0 g0Var = new g0(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, a0.getOrCreateKotlinClass(GuildScheduledEventSettingsViewModel.class), new WidgetGuildScheduledEventSettings$appViewModels$$inlined$viewModels$1(g0Var), new i0(widgetGuildScheduledEventSettings$viewModel$2));
        this.previewLauncher = WidgetPreviewGuildScheduledEvent.Companion.registerForResult(this, new WidgetGuildScheduledEventSettings$previewLauncher$1(this), new WidgetGuildScheduledEventSettings$previewLauncher$2(this));
    }

    public static final /* synthetic */ void access$configureUi(WidgetGuildScheduledEventSettings widgetGuildScheduledEventSettings, GuildScheduledEventSettingsViewModel$ViewState guildScheduledEventSettingsViewModel$ViewState) {
        widgetGuildScheduledEventSettings.configureUi(guildScheduledEventSettingsViewModel$ViewState);
    }

    public static final /* synthetic */ void access$configureVisibilitySettings(WidgetGuildScheduledEventSettings widgetGuildScheduledEventSettings, Pair pair) {
        widgetGuildScheduledEventSettings.configureVisibilitySettings(pair);
    }

    public static final /* synthetic */ WidgetGuildScheduledEventSettingsBinding access$getBinding$p(WidgetGuildScheduledEventSettings widgetGuildScheduledEventSettings) {
        return widgetGuildScheduledEventSettings.getBinding();
    }

    public static final /* synthetic */ GuildScheduledEventSettingsViewModel$ViewState$Initialized access$getCurrentViewState$p(WidgetGuildScheduledEventSettings widgetGuildScheduledEventSettings) {
        return widgetGuildScheduledEventSettings.currentViewState;
    }

    public static final /* synthetic */ Long access$getExistingGuildScheduledEventId$p(WidgetGuildScheduledEventSettings widgetGuildScheduledEventSettings) {
        return widgetGuildScheduledEventSettings.getExistingGuildScheduledEventId();
    }

    public static final /* synthetic */ long access$getGuildId$p(WidgetGuildScheduledEventSettings widgetGuildScheduledEventSettings) {
        return widgetGuildScheduledEventSettings.getGuildId();
    }

    public static final /* synthetic */ ActivityResultLauncher access$getPreviewLauncher$p(WidgetGuildScheduledEventSettings widgetGuildScheduledEventSettings) {
        return widgetGuildScheduledEventSettings.previewLauncher;
    }

    public static final /* synthetic */ GuildScheduledEventSettingsViewModel access$getViewModel$p(WidgetGuildScheduledEventSettings widgetGuildScheduledEventSettings) {
        return widgetGuildScheduledEventSettings.getViewModel();
    }

    public static final /* synthetic */ void access$setCurrentViewState$p(WidgetGuildScheduledEventSettings widgetGuildScheduledEventSettings, GuildScheduledEventSettingsViewModel$ViewState$Initialized guildScheduledEventSettingsViewModel$ViewState$Initialized) {
        widgetGuildScheduledEventSettings.currentViewState = guildScheduledEventSettingsViewModel$ViewState$Initialized;
    }

    public static final /* synthetic */ void access$showDateErrorToast(WidgetGuildScheduledEventSettings widgetGuildScheduledEventSettings, GuildScheduledEventSettingsViewModel$DateError guildScheduledEventSettingsViewModel$DateError) {
        widgetGuildScheduledEventSettings.showDateErrorToast(guildScheduledEventSettingsViewModel$DateError);
    }

    private final void configureEndDateTime(GuildScheduledEventSettingsViewModel$ViewState$Initialized viewState) {
        String dateTime;
        if (viewState.getEventModel().getEntityType() != GuildScheduledEventEntityType.EXTERNAL) {
            TextView textView = getBinding().d;
            m.checkNotNullExpressionValue(textView, "binding.endDateHeader");
            textView.setVisibility(8);
            TextView textView2 = getBinding().g;
            m.checkNotNullExpressionValue(textView2, "binding.endTimeHeader");
            textView2.setVisibility(8);
            TextInputLayout textInputLayout = getBinding().f;
            m.checkNotNullExpressionValue(textInputLayout, "binding.endDateLayout");
            textInputLayout.setVisibility(8);
            TextInputLayout textInputLayout2 = getBinding().i;
            m.checkNotNullExpressionValue(textInputLayout2, "binding.endTimeLayout");
            textInputLayout2.setVisibility(8);
            return;
        }
        TextView textView3 = getBinding().d;
        m.checkNotNullExpressionValue(textView3, "binding.endDateHeader");
        textView3.setVisibility(0);
        TextView textView4 = getBinding().g;
        m.checkNotNullExpressionValue(textView4, "binding.endTimeHeader");
        textView4.setVisibility(0);
        TextInputLayout textInputLayout3 = getBinding().f;
        m.checkNotNullExpressionValue(textInputLayout3, "binding.endDateLayout");
        textInputLayout3.setVisibility(0);
        TextInputLayout textInputLayout4 = getBinding().i;
        m.checkNotNullExpressionValue(textInputLayout4, "binding.endTimeLayout");
        textInputLayout4.setVisibility(0);
        GuildScheduledEventPickerDate endDate = viewState.getEventModel().getEndDate();
        GuildScheduledEventPickerTime endTime = viewState.getEventModel().getEndTime();
        String str = "";
        if (endDate == null || (dateTime = DateUtils.formatDateTime(getContext(), endDate.toMillis(), 524292)) == null) {
            dateTime = "";
        }
        if (endTime != null) {
            GuildScheduledEventPickerDateTime guildScheduledEventPickerDateTime = GuildScheduledEventPickerDateTime.INSTANCE;
            if (endDate == null) {
                endDate = GuildScheduledEventPickerDate.Companion.now();
            }
            String dateTime2 = DateUtils.formatDateTime(getContext(), guildScheduledEventPickerDateTime.toMillis(endDate, endTime), 257);
            if (dateTime2 != null) {
                str = dateTime2;
            }
        }
        getBinding().e.setText(dateTime);
        getBinding().h.setText(str);
    }

    private final void configureStartDateTime(GuildScheduledEventSettingsViewModel$ViewState$Initialized viewState) {
        long millis = GuildScheduledEventPickerDateTime.INSTANCE.toMillis(viewState.getEventModel().getStartDate(), viewState.getEventModel().getStartTime());
        GuildScheduledEvent existingEvent = viewState.getExistingEvent();
        boolean z2 = (existingEvent != null ? GuildScheduledEventUtilitiesKt.getEventTiming(existingEvent) : null) == GuildScheduledEventTiming.LIVE;
        TextInputEditText textInputEditText = getBinding().l;
        ViewExtensions.setEnabledAndAlpha$default(textInputEditText, !z2, 0.0f, 2, null);
        textInputEditText.setText(DateUtils.formatDateTime(textInputEditText.getContext(), millis, 524292));
        TextInputEditText textInputEditText2 = getBinding().m;
        ViewExtensions.setEnabledAndAlpha$default(textInputEditText2, !z2, 0.0f, 2, null);
        textInputEditText2.setText(DateUtils.formatDateTime(textInputEditText2.getContext(), millis, 1));
    }

    private final void configureUi(GuildScheduledEventSettingsViewModel$ViewState viewState) {
        if (viewState instanceof GuildScheduledEventSettingsViewModel$ViewState$Invalid) {
            FragmentActivity activity = getActivity();
            if (activity != null) {
                activity.finish();
                return;
            }
            return;
        }
        Objects.requireNonNull(viewState, "null cannot be cast to non-null type com.discord.widgets.guildscheduledevent.GuildScheduledEventSettingsViewModel.ViewState.Initialized");
        GuildScheduledEventSettingsViewModel$ViewState$Initialized guildScheduledEventSettingsViewModel$ViewState$Initialized = (GuildScheduledEventSettingsViewModel$ViewState$Initialized) viewState;
        this.currentViewState = guildScheduledEventSettingsViewModel$ViewState$Initialized;
        GuildScheduledEventModel eventModel = guildScheduledEventSettingsViewModel$ViewState$Initialized.getEventModel();
        TextInputEditText textInputEditText = getBinding().o;
        Editable text = textInputEditText.getText();
        if (!m.areEqual(text != null ? text.toString() : null, eventModel.getName())) {
            textInputEditText.setText(eventModel.getName());
        }
        TextInputEditText textInputEditText2 = getBinding().j;
        Editable text2 = textInputEditText2.getText();
        if (!m.areEqual(text2 != null ? text2.toString() : null, eventModel.getDescription())) {
            textInputEditText2.setText(eventModel.getDescription());
        }
        configureStartDateTime(guildScheduledEventSettingsViewModel$ViewState$Initialized);
        configureEndDateTime(guildScheduledEventSettingsViewModel$ViewState$Initialized);
        MaterialButton materialButton = getBinding().k;
        m.checkNotNullExpressionValue(materialButton, "binding.guildScheduledEventSettingsNextButton");
        materialButton.setEnabled(getViewModel().isNextButtonEnabled());
    }

    private final void configureVisibilitySettings(Pair<? extends GuildScheduledEventSettingsViewModel$ViewState, GuildScheduledEventDirectoryAssociationState> states) {
        GuildScheduledEventSettingsViewModel$ViewState guildScheduledEventSettingsViewModel$ViewStateComponent1 = states.component1();
        GuildScheduledEventBroadcast guildScheduledEventBroadcastInvoke = states.component2().getEnabledAsync().invoke();
        if (guildScheduledEventBroadcastInvoke == null || !(guildScheduledEventSettingsViewModel$ViewStateComponent1 instanceof GuildScheduledEventSettingsViewModel$ViewState$Initialized)) {
            return;
        }
        toggleVisibilityOptions(guildScheduledEventBroadcastInvoke.getCanBroadcast());
        GuildScheduledEventSettingsViewModel$ViewState$Initialized guildScheduledEventSettingsViewModel$ViewState$Initialized = (GuildScheduledEventSettingsViewModel$ViewState$Initialized) guildScheduledEventSettingsViewModel$ViewStateComponent1;
        boolean zIsEventViewableByEveryone = GuildScheduledEventUtilities.Companion.isEventViewableByEveryone(guildScheduledEventSettingsViewModel$ViewState$Initialized.getEventModel().getChannelId());
        LinearLayout linearLayout = getBinding().q;
        m.checkNotNullExpressionValue(linearLayout, "binding.guildScheduledEv…ttingsVisibilityContainer");
        linearLayout.setClickable(zIsEventViewableByEveryone);
        View view = getBinding().r;
        m.checkNotNullExpressionValue(view, "binding.guildScheduledEv…sibilityContainerDisabled");
        boolean zBooleanValue = false;
        view.setVisibility(zIsEventViewableByEveryone ^ true ? 0 : 8);
        MaterialCheckBox materialCheckBox = getBinding().p;
        m.checkNotNullExpressionValue(materialCheckBox, "binding.guildScheduledEv…ettingsVisibilityCheckbox");
        materialCheckBox.setClickable(zIsEventViewableByEveryone);
        MaterialCheckBox materialCheckBox2 = getBinding().p;
        m.checkNotNullExpressionValue(materialCheckBox2, "binding.guildScheduledEv…ettingsVisibilityCheckbox");
        materialCheckBox2.setChecked(m.areEqual(guildScheduledEventSettingsViewModel$ViewState$Initialized.getEventModel().getBroadcastToDirectoryChannels(), Boolean.TRUE));
        if (guildScheduledEventBroadcastInvoke.getCanBroadcast() && guildScheduledEventSettingsViewModel$ViewState$Initialized.getEventModel().getBroadcastToDirectoryChannels() == null) {
            if (zIsEventViewableByEveryone) {
                Boolean hasBroadcast = guildScheduledEventBroadcastInvoke.getHasBroadcast();
                zBooleanValue = hasBroadcast != null ? hasBroadcast.booleanValue() : true;
            }
            getViewModel().toggleBroadcastToDirectoryChannel(zBooleanValue);
        }
    }

    private final WidgetGuildScheduledEventSettingsBinding getBinding() {
        return (WidgetGuildScheduledEventSettingsBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
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

    private final GuildScheduledEventSettingsViewModel getViewModel() {
        return (GuildScheduledEventSettingsViewModel) this.viewModel.getValue();
    }

    private final void showDateErrorToast(GuildScheduledEventSettingsViewModel$DateError error) {
        int iOrdinal = error.ordinal();
        if (iOrdinal == 1) {
            b.a.d.m.g(requireContext(), 2131890112, 0, null, 12);
        } else if (iOrdinal == 2) {
            b.a.d.m.g(requireContext(), 2131890111, 0, null, 12);
        } else {
            if (iOrdinal != 3) {
                return;
            }
            b.a.d.m.g(requireContext(), 2131890076, 0, null, 12);
        }
    }

    private final void toggleVisibilityOptions(boolean show) {
        TextView textView = getBinding().t;
        m.checkNotNullExpressionValue(textView, "binding.guildScheduledEv…tSettingsVisibilityHeader");
        textView.setVisibility(show ? 0 : 8);
        LinearLayout linearLayout = getBinding().q;
        m.checkNotNullExpressionValue(linearLayout, "binding.guildScheduledEv…ttingsVisibilityContainer");
        linearLayout.setVisibility(show ? 0 : 8);
        TextView textView2 = getBinding().f2449s;
        m.checkNotNullExpressionValue(textView2, "binding.guildScheduledEv…ingsVisibilityDescription");
        textView2.setVisibility(show ? 0 : 8);
    }

    @Override // com.discord.app.AppFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeViewState(), this, null, 2, null), WidgetGuildScheduledEventSettings.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new WidgetGuildScheduledEventSettings$onResume$1(this), 62, (Object) null);
        Observable observableJ = Observable.j(getViewModel().observeViewState(), getHubViewModel().observeViewState(), WidgetGuildScheduledEventSettings$onResume$2.INSTANCE);
        m.checkNotNullExpressionValue(observableJ, "Observable.combineLatest…ttingsState to hubState }");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(ObservableExtensionsKt.ui(observableJ), this, null, 2, null), WidgetGuildScheduledEventSettings.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new WidgetGuildScheduledEventSettings$onResume$3(this), 62, (Object) null);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        m.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        TextView textView = getBinding().n;
        m.checkNotNullExpressionValue(textView, "binding.guildScheduledEventSettingsStepText");
        b.n(textView, 2131890132, new Object[]{2, 3}, null, 4);
        getBinding().f2448b.setOnClickListener(new WidgetGuildScheduledEventSettings$onViewBound$1(this));
        getBinding().c.setOnClickListener(new WidgetGuildScheduledEventSettings$onViewBound$2(this));
        TextInputEditText textInputEditText = getBinding().o;
        m.checkNotNullExpressionValue(textInputEditText, "binding.guildScheduledEventSettingsTopicInput");
        textInputEditText.addTextChangedListener(new WidgetGuildScheduledEventSettings$onViewBound$$inlined$addTextChangedListener$1(this));
        TextInputEditText textInputEditText2 = getBinding().j;
        m.checkNotNullExpressionValue(textInputEditText2, "binding.guildScheduledEv…tSettingsDescriptionInput");
        textInputEditText2.addTextChangedListener(new WidgetGuildScheduledEventSettings$onViewBound$$inlined$addTextChangedListener$2(this));
        getBinding().m.setOnClickListener(new WidgetGuildScheduledEventSettings$onViewBound$5(this));
        getBinding().l.setOnClickListener(new WidgetGuildScheduledEventSettings$onViewBound$6(this));
        getBinding().h.setOnClickListener(new WidgetGuildScheduledEventSettings$onViewBound$7(this));
        getBinding().e.setOnClickListener(new WidgetGuildScheduledEventSettings$onViewBound$8(this));
        getBinding().k.setOnClickListener(new WidgetGuildScheduledEventSettings$onViewBound$9(this));
        getBinding().q.setOnClickListener(new WidgetGuildScheduledEventSettings$onViewBound$10(this));
        getBinding().p.setOnClickListener(new WidgetGuildScheduledEventSettings$onViewBound$11(this));
    }
}
