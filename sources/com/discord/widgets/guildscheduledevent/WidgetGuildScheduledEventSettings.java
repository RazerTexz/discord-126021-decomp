package com.discord.widgets.guildscheduledevent;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.text.Editable;
import android.text.TextWatcher;
import android.text.format.DateFormat;
import android.text.format.DateUtils;
import android.view.View;
import android.widget.DatePicker;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.TimePicker;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentViewModelLazyKt;
import com.discord.C5419R;
import com.discord.api.guildscheduledevent.GuildScheduledEvent;
import com.discord.api.guildscheduledevent.GuildScheduledEventBroadcast;
import com.discord.api.guildscheduledevent.GuildScheduledEventEntityType;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetGuildScheduledEventSettingsBinding;
import com.discord.utilities.error.Error;
import com.discord.utilities.guildscheduledevent.GuildScheduledEventTiming;
import com.discord.utilities.guildscheduledevent.GuildScheduledEventUtilities;
import com.discord.utilities.guildscheduledevent.GuildScheduledEventUtilitiesKt;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.time.ClockFactory;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.discord.widgets.guildscheduledevent.GuildScheduledEventSettingsViewModel;
import com.discord.widgets.guildscheduledevent.WidgetPreviewGuildScheduledEvent;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.checkbox.MaterialCheckBox;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import java.util.Objects;
import kotlin.Lazy;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import p007b.p008a.p018d.C0863f0;
import p007b.p008a.p018d.C0865g0;
import p007b.p008a.p018d.C0869i0;
import p007b.p008a.p018d.C0870j;
import p007b.p008a.p018d.C0876m;
import p007b.p008a.p027k.C1107b;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.C12083g;
import p507d0.C12116o;
import p507d0.p592z.p594d.C12216a0;
import p507d0.p592z.p594d.C12236k;
import p507d0.p592z.p594d.C12238m;
import p658rx.Observable;
import p658rx.Subscription;
import p658rx.functions.Func2;

/* JADX INFO: compiled from: WidgetGuildScheduledEventSettings.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildScheduledEventSettings extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {C1643a.m846d0(WidgetGuildScheduledEventSettings.class, "binding", "getBinding()Lcom/discord/databinding/WidgetGuildScheduledEventSettingsBinding;", 0)};

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String EXTRA_ENTITY_TYPE = "EXTRA_ENTITY_TYPE";
    private static final String EXTRA_EXTERNAL_LOCATION = "EXTRA_EXTERNAL_LOCATION";
    private static final int RESULT_QUIT = 2;

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private GuildScheduledEventSettingsViewModel.ViewState.Initialized currentViewState;

    /* JADX INFO: renamed from: existingGuildScheduledEventId$delegate, reason: from kotlin metadata */
    private final Lazy existingGuildScheduledEventId;

    /* JADX INFO: renamed from: guildId$delegate, reason: from kotlin metadata */
    private final Lazy guildId;

    /* JADX INFO: renamed from: hubViewModel$delegate, reason: from kotlin metadata */
    private final Lazy hubViewModel;
    private final ActivityResultLauncher<Intent> previewLauncher;

    /* JADX INFO: renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    /* JADX INFO: compiled from: WidgetGuildScheduledEventSettings.kt */
    public static final class Companion {
        private Companion() {
        }

        public final void launch(Context context, ActivityResultLauncher<Intent> launcher, long guildId, GuildScheduledEventEntityType entityType, Long channelId, String externalLocation, Long existingGuildScheduledEventId) {
            C12238m.checkNotNullParameter(context, "context");
            C12238m.checkNotNullParameter(launcher, "launcher");
            C12238m.checkNotNullParameter(entityType, "entityType");
            Intent intent = new Intent();
            intent.putExtra("com.discord.intent.extra.EXTRA_GUILD_ID", guildId);
            intent.putExtra(WidgetGuildScheduledEventSettings.EXTRA_ENTITY_TYPE, entityType);
            if (channelId != null) {
                intent.putExtra("com.discord.intent.extra.EXTRA_CHANNEL_ID", channelId.longValue());
            }
            if (externalLocation != null) {
                intent.putExtra(WidgetGuildScheduledEventSettings.EXTRA_EXTERNAL_LOCATION, externalLocation);
            }
            if (existingGuildScheduledEventId != null) {
                intent.putExtra("com.discord.intent.extra.EXTRA_GUILD_SCHEDULED_EVENT_ID", existingGuildScheduledEventId.longValue());
            }
            C0870j.f524g.m160f(context, launcher, WidgetGuildScheduledEventSettings.class, intent);
        }

        public final ActivityResultLauncher<Intent> registerForResult(Fragment fragment, final Function0<Unit> onFinished, final Function0<Unit> onQuit) {
            C12238m.checkNotNullParameter(fragment, "fragment");
            C12238m.checkNotNullParameter(onFinished, "onFinished");
            C12238m.checkNotNullParameter(onQuit, "onQuit");
            ActivityResultLauncher<Intent> activityResultLauncherRegisterForActivityResult = fragment.registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() { // from class: com.discord.widgets.guildscheduledevent.WidgetGuildScheduledEventSettings$Companion$registerForResult$1
                @Override // androidx.activity.result.ActivityResultCallback
                public final void onActivityResult(ActivityResult activityResult) {
                    C12238m.checkNotNullExpressionValue(activityResult, "result");
                    int resultCode = activityResult.getResultCode();
                    if (resultCode == -1) {
                        onFinished.invoke();
                    } else {
                        if (resultCode != 2) {
                            return;
                        }
                        onQuit.invoke();
                    }
                }
            });
            C12238m.checkNotNullExpressionValue(activityResultLauncherRegisterForActivityResult, "fragment.registerForActi…  }\n          }\n        }");
            return activityResultLauncherRegisterForActivityResult;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            GuildScheduledEventSettingsViewModel.DateError.values();
            int[] iArr = new int[4];
            $EnumSwitchMapping$0 = iArr;
            iArr[GuildScheduledEventSettingsViewModel.DateError.INVALID_VIEW_STATE.ordinal()] = 1;
            iArr[GuildScheduledEventSettingsViewModel.DateError.START_DATE_IN_PAST.ordinal()] = 2;
            iArr[GuildScheduledEventSettingsViewModel.DateError.END_DATE_IN_PAST.ordinal()] = 3;
            iArr[GuildScheduledEventSettingsViewModel.DateError.END_DATE_BEFORE_START_DATE.ordinal()] = 4;
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.guildscheduledevent.WidgetGuildScheduledEventSettings$onResume$1 */
    /* JADX INFO: compiled from: WidgetGuildScheduledEventSettings.kt */
    public static final /* synthetic */ class C89111 extends C12236k implements Function1<GuildScheduledEventSettingsViewModel.ViewState, Unit> {
        public C89111(WidgetGuildScheduledEventSettings widgetGuildScheduledEventSettings) {
            super(1, widgetGuildScheduledEventSettings, WidgetGuildScheduledEventSettings.class, "configureUi", "configureUi(Lcom/discord/widgets/guildscheduledevent/GuildScheduledEventSettingsViewModel$ViewState;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(GuildScheduledEventSettingsViewModel.ViewState viewState) {
            invoke2(viewState);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(GuildScheduledEventSettingsViewModel.ViewState viewState) {
            C12238m.checkNotNullParameter(viewState, "p1");
            ((WidgetGuildScheduledEventSettings) this.receiver).configureUi(viewState);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.guildscheduledevent.WidgetGuildScheduledEventSettings$onResume$3 */
    /* JADX INFO: compiled from: WidgetGuildScheduledEventSettings.kt */
    public static final /* synthetic */ class C89133 extends C12236k implements Function1<Pair<? extends GuildScheduledEventSettingsViewModel.ViewState, ? extends GuildScheduledEventDirectoryAssociationState>, Unit> {
        public C89133(WidgetGuildScheduledEventSettings widgetGuildScheduledEventSettings) {
            super(1, widgetGuildScheduledEventSettings, WidgetGuildScheduledEventSettings.class, "configureVisibilitySettings", "configureVisibilitySettings(Lkotlin/Pair;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Pair<? extends GuildScheduledEventSettingsViewModel.ViewState, ? extends GuildScheduledEventDirectoryAssociationState> pair) {
            invoke2((Pair<? extends GuildScheduledEventSettingsViewModel.ViewState, GuildScheduledEventDirectoryAssociationState>) pair);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Pair<? extends GuildScheduledEventSettingsViewModel.ViewState, GuildScheduledEventDirectoryAssociationState> pair) {
            C12238m.checkNotNullParameter(pair, "p1");
            ((WidgetGuildScheduledEventSettings) this.receiver).configureVisibilitySettings(pair);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.guildscheduledevent.WidgetGuildScheduledEventSettings$onViewBound$5 */
    /* JADX INFO: compiled from: WidgetGuildScheduledEventSettings.kt */
    public static final class ViewOnClickListenerC89205 implements View.OnClickListener {
        public ViewOnClickListenerC89205() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            GuildScheduledEventModel eventModel;
            GuildScheduledEventPickerTime startTime;
            GuildScheduledEventSettingsViewModel.ViewState.Initialized initialized = WidgetGuildScheduledEventSettings.this.currentViewState;
            if (initialized == null || (eventModel = initialized.getEventModel()) == null || (startTime = eventModel.getStartTime()) == null) {
                return;
            }
            new TimePickerDialog(WidgetGuildScheduledEventSettings.this.requireContext(), new TimePickerDialog.OnTimeSetListener() { // from class: com.discord.widgets.guildscheduledevent.WidgetGuildScheduledEventSettings$onViewBound$5$$special$$inlined$let$lambda$1
                @Override // android.app.TimePickerDialog.OnTimeSetListener
                public final void onTimeSet(TimePicker timePicker, int i, int i2) {
                    GuildScheduledEventSettingsViewModel.DateError startTime2 = WidgetGuildScheduledEventSettings.this.getViewModel().setStartTime(i, i2);
                    if (startTime2 != null) {
                        WidgetGuildScheduledEventSettings.this.showDateErrorToast(startTime2);
                    }
                }
            }, startTime.getHourOfDay(), startTime.getMinute(), DateFormat.is24HourFormat(WidgetGuildScheduledEventSettings.this.requireContext())).show();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.guildscheduledevent.WidgetGuildScheduledEventSettings$onViewBound$6 */
    /* JADX INFO: compiled from: WidgetGuildScheduledEventSettings.kt */
    public static final class ViewOnClickListenerC89226 implements View.OnClickListener {
        public ViewOnClickListenerC89226() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            GuildScheduledEventModel eventModel;
            GuildScheduledEventPickerDate startDate;
            GuildScheduledEventSettingsViewModel.ViewState.Initialized initialized = WidgetGuildScheduledEventSettings.this.currentViewState;
            if (initialized == null || (eventModel = initialized.getEventModel()) == null || (startDate = eventModel.getStartDate()) == null) {
                return;
            }
            DatePickerDialog datePickerDialog = new DatePickerDialog(WidgetGuildScheduledEventSettings.this.requireContext(), new DatePickerDialog.OnDateSetListener() { // from class: com.discord.widgets.guildscheduledevent.WidgetGuildScheduledEventSettings$onViewBound$6$$special$$inlined$let$lambda$1
                @Override // android.app.DatePickerDialog.OnDateSetListener
                public final void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
                    GuildScheduledEventSettingsViewModel.DateError startDate2 = WidgetGuildScheduledEventSettings.this.getViewModel().setStartDate(i, i2, i3);
                    if (startDate2 != null) {
                        WidgetGuildScheduledEventSettings.this.showDateErrorToast(startDate2);
                    }
                }
            }, startDate.getYear(), startDate.getMonth(), startDate.getDayOfMonth());
            DatePicker datePicker = datePickerDialog.getDatePicker();
            C12238m.checkNotNullExpressionValue(datePicker, "datePicker");
            datePicker.setMinDate(ClockFactory.get().currentTimeMillis());
            datePickerDialog.show();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.guildscheduledevent.WidgetGuildScheduledEventSettings$onViewBound$7 */
    /* JADX INFO: compiled from: WidgetGuildScheduledEventSettings.kt */
    public static final class ViewOnClickListenerC89247 implements View.OnClickListener {
        public ViewOnClickListenerC89247() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            GuildScheduledEventModel eventModel;
            GuildScheduledEventSettingsViewModel.ViewState.Initialized initialized = WidgetGuildScheduledEventSettings.this.currentViewState;
            if (initialized == null || (eventModel = initialized.getEventModel()) == null) {
                return;
            }
            GuildScheduledEventPickerTime second = GuildScheduledEventPickerDateTime.INSTANCE.generateDefaultEndDateTime(eventModel.getStartDate(), eventModel.getStartTime()).getSecond();
            Context contextRequireContext = WidgetGuildScheduledEventSettings.this.requireContext();
            TimePickerDialog.OnTimeSetListener onTimeSetListener = new TimePickerDialog.OnTimeSetListener() { // from class: com.discord.widgets.guildscheduledevent.WidgetGuildScheduledEventSettings$onViewBound$7$$special$$inlined$let$lambda$1
                @Override // android.app.TimePickerDialog.OnTimeSetListener
                public final void onTimeSet(TimePicker timePicker, int i, int i2) {
                    GuildScheduledEventSettingsViewModel.DateError endTime = WidgetGuildScheduledEventSettings.this.getViewModel().setEndTime(i, i2);
                    if (endTime != null) {
                        WidgetGuildScheduledEventSettings.this.showDateErrorToast(endTime);
                    }
                }
            };
            GuildScheduledEventPickerTime endTime = eventModel.getEndTime();
            int hourOfDay = endTime != null ? endTime.getHourOfDay() : second.getHourOfDay();
            GuildScheduledEventPickerTime endTime2 = eventModel.getEndTime();
            new TimePickerDialog(contextRequireContext, onTimeSetListener, hourOfDay, endTime2 != null ? endTime2.getMinute() : second.getMinute(), false).show();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.guildscheduledevent.WidgetGuildScheduledEventSettings$onViewBound$8 */
    /* JADX INFO: compiled from: WidgetGuildScheduledEventSettings.kt */
    public static final class ViewOnClickListenerC89268 implements View.OnClickListener {
        public ViewOnClickListenerC89268() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            GuildScheduledEventModel eventModel;
            GuildScheduledEventSettingsViewModel.ViewState.Initialized initialized = WidgetGuildScheduledEventSettings.this.currentViewState;
            if (initialized == null || (eventModel = initialized.getEventModel()) == null) {
                return;
            }
            GuildScheduledEventPickerDate first = GuildScheduledEventPickerDateTime.INSTANCE.generateDefaultEndDateTime(eventModel.getStartDate(), eventModel.getStartTime()).getFirst();
            Context contextRequireContext = WidgetGuildScheduledEventSettings.this.requireContext();
            DatePickerDialog.OnDateSetListener onDateSetListener = new DatePickerDialog.OnDateSetListener() { // from class: com.discord.widgets.guildscheduledevent.WidgetGuildScheduledEventSettings$onViewBound$8$$special$$inlined$let$lambda$1
                @Override // android.app.DatePickerDialog.OnDateSetListener
                public final void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
                    GuildScheduledEventSettingsViewModel.DateError endDate = WidgetGuildScheduledEventSettings.this.getViewModel().setEndDate(i, i2, i3);
                    if (endDate != null) {
                        WidgetGuildScheduledEventSettings.this.showDateErrorToast(endDate);
                    }
                }
            };
            GuildScheduledEventPickerDate endDate = eventModel.getEndDate();
            int year = endDate != null ? endDate.getYear() : first.getYear();
            GuildScheduledEventPickerDate endDate2 = eventModel.getEndDate();
            int month = endDate2 != null ? endDate2.getMonth() : first.getMonth();
            GuildScheduledEventPickerDate endDate3 = eventModel.getEndDate();
            DatePickerDialog datePickerDialog = new DatePickerDialog(contextRequireContext, onDateSetListener, year, month, endDate3 != null ? endDate3.getDayOfMonth() : first.getDayOfMonth());
            DatePicker datePicker = datePickerDialog.getDatePicker();
            C12238m.checkNotNullExpressionValue(datePicker, "datePicker");
            datePicker.setMinDate(Math.max(eventModel.getStartDate().toMillis(), ClockFactory.get().currentTimeMillis()));
            datePickerDialog.show();
        }
    }

    public WidgetGuildScheduledEventSettings() {
        super(C5419R.layout.widget_guild_scheduled_event_settings);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetGuildScheduledEventSettings$binding$2.INSTANCE, null, 2, null);
        this.guildId = C12083g.lazy(new WidgetGuildScheduledEventSettings$guildId$2(this));
        this.existingGuildScheduledEventId = C12083g.lazy(new C8910xc479d519(this));
        this.hubViewModel = FragmentViewModelLazyKt.createViewModelLazy(this, C12216a0.getOrCreateKotlinClass(GuildScheduledEventDirectoryAssociationViewModel.class), new C8907x77b0f2fe(this), new C0863f0(new WidgetGuildScheduledEventSettings$hubViewModel$2(this)));
        WidgetGuildScheduledEventSettings$viewModel$2 widgetGuildScheduledEventSettings$viewModel$2 = new WidgetGuildScheduledEventSettings$viewModel$2(this);
        C0865g0 c0865g0 = new C0865g0(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, C12216a0.getOrCreateKotlinClass(GuildScheduledEventSettingsViewModel.class), new C8909xd3eb6e20(c0865g0), new C0869i0(widgetGuildScheduledEventSettings$viewModel$2));
        this.previewLauncher = WidgetPreviewGuildScheduledEvent.INSTANCE.registerForResult(this, new WidgetGuildScheduledEventSettings$previewLauncher$1(this), new WidgetGuildScheduledEventSettings$previewLauncher$2(this));
    }

    private final void configureEndDateTime(GuildScheduledEventSettingsViewModel.ViewState.Initialized viewState) {
        String dateTime;
        if (viewState.getEventModel().getEntityType() != GuildScheduledEventEntityType.EXTERNAL) {
            TextView textView = getBinding().f17030d;
            C12238m.checkNotNullExpressionValue(textView, "binding.endDateHeader");
            textView.setVisibility(8);
            TextView textView2 = getBinding().f17033g;
            C12238m.checkNotNullExpressionValue(textView2, "binding.endTimeHeader");
            textView2.setVisibility(8);
            TextInputLayout textInputLayout = getBinding().f17032f;
            C12238m.checkNotNullExpressionValue(textInputLayout, "binding.endDateLayout");
            textInputLayout.setVisibility(8);
            TextInputLayout textInputLayout2 = getBinding().f17035i;
            C12238m.checkNotNullExpressionValue(textInputLayout2, "binding.endTimeLayout");
            textInputLayout2.setVisibility(8);
            return;
        }
        TextView textView3 = getBinding().f17030d;
        C12238m.checkNotNullExpressionValue(textView3, "binding.endDateHeader");
        textView3.setVisibility(0);
        TextView textView4 = getBinding().f17033g;
        C12238m.checkNotNullExpressionValue(textView4, "binding.endTimeHeader");
        textView4.setVisibility(0);
        TextInputLayout textInputLayout3 = getBinding().f17032f;
        C12238m.checkNotNullExpressionValue(textInputLayout3, "binding.endDateLayout");
        textInputLayout3.setVisibility(0);
        TextInputLayout textInputLayout4 = getBinding().f17035i;
        C12238m.checkNotNullExpressionValue(textInputLayout4, "binding.endTimeLayout");
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
                endDate = GuildScheduledEventPickerDate.INSTANCE.now();
            }
            String dateTime2 = DateUtils.formatDateTime(getContext(), guildScheduledEventPickerDateTime.toMillis(endDate, endTime), 257);
            if (dateTime2 != null) {
                str = dateTime2;
            }
        }
        getBinding().f17031e.setText(dateTime);
        getBinding().f17034h.setText(str);
    }

    private final void configureStartDateTime(GuildScheduledEventSettingsViewModel.ViewState.Initialized viewState) {
        long millis = GuildScheduledEventPickerDateTime.INSTANCE.toMillis(viewState.getEventModel().getStartDate(), viewState.getEventModel().getStartTime());
        GuildScheduledEvent existingEvent = viewState.getExistingEvent();
        boolean z2 = (existingEvent != null ? GuildScheduledEventUtilitiesKt.getEventTiming(existingEvent) : null) == GuildScheduledEventTiming.LIVE;
        TextInputEditText textInputEditText = getBinding().f17038l;
        ViewExtensions.setEnabledAndAlpha$default(textInputEditText, !z2, 0.0f, 2, null);
        textInputEditText.setText(DateUtils.formatDateTime(textInputEditText.getContext(), millis, 524292));
        TextInputEditText textInputEditText2 = getBinding().f17039m;
        ViewExtensions.setEnabledAndAlpha$default(textInputEditText2, !z2, 0.0f, 2, null);
        textInputEditText2.setText(DateUtils.formatDateTime(textInputEditText2.getContext(), millis, 1));
    }

    private final void configureUi(GuildScheduledEventSettingsViewModel.ViewState viewState) {
        if (viewState instanceof GuildScheduledEventSettingsViewModel.ViewState.Invalid) {
            FragmentActivity fragmentActivityM95e = m95e();
            if (fragmentActivityM95e != null) {
                fragmentActivityM95e.finish();
                return;
            }
            return;
        }
        Objects.requireNonNull(viewState, "null cannot be cast to non-null type com.discord.widgets.guildscheduledevent.GuildScheduledEventSettingsViewModel.ViewState.Initialized");
        GuildScheduledEventSettingsViewModel.ViewState.Initialized initialized = (GuildScheduledEventSettingsViewModel.ViewState.Initialized) viewState;
        this.currentViewState = initialized;
        GuildScheduledEventModel eventModel = initialized.getEventModel();
        TextInputEditText textInputEditText = getBinding().f17041o;
        Editable text = textInputEditText.getText();
        if (!C12238m.areEqual(text != null ? text.toString() : null, eventModel.getName())) {
            textInputEditText.setText(eventModel.getName());
        }
        TextInputEditText textInputEditText2 = getBinding().f17036j;
        Editable text2 = textInputEditText2.getText();
        if (!C12238m.areEqual(text2 != null ? text2.toString() : null, eventModel.getDescription())) {
            textInputEditText2.setText(eventModel.getDescription());
        }
        configureStartDateTime(initialized);
        configureEndDateTime(initialized);
        MaterialButton materialButton = getBinding().f17037k;
        C12238m.checkNotNullExpressionValue(materialButton, "binding.guildScheduledEventSettingsNextButton");
        materialButton.setEnabled(getViewModel().isNextButtonEnabled());
    }

    private final void configureVisibilitySettings(Pair<? extends GuildScheduledEventSettingsViewModel.ViewState, GuildScheduledEventDirectoryAssociationState> states) {
        GuildScheduledEventSettingsViewModel.ViewState viewStateComponent1 = states.component1();
        GuildScheduledEventBroadcast guildScheduledEventBroadcastInvoke = states.component2().getEnabledAsync().invoke();
        if (guildScheduledEventBroadcastInvoke == null || !(viewStateComponent1 instanceof GuildScheduledEventSettingsViewModel.ViewState.Initialized)) {
            return;
        }
        toggleVisibilityOptions(guildScheduledEventBroadcastInvoke.getCanBroadcast());
        GuildScheduledEventSettingsViewModel.ViewState.Initialized initialized = (GuildScheduledEventSettingsViewModel.ViewState.Initialized) viewStateComponent1;
        boolean zIsEventViewableByEveryone = GuildScheduledEventUtilities.INSTANCE.isEventViewableByEveryone(initialized.getEventModel().getChannelId());
        LinearLayout linearLayout = getBinding().f17043q;
        C12238m.checkNotNullExpressionValue(linearLayout, "binding.guildScheduledEv…ttingsVisibilityContainer");
        linearLayout.setClickable(zIsEventViewableByEveryone);
        View view = getBinding().f17044r;
        C12238m.checkNotNullExpressionValue(view, "binding.guildScheduledEv…sibilityContainerDisabled");
        boolean zBooleanValue = false;
        view.setVisibility(zIsEventViewableByEveryone ^ true ? 0 : 8);
        MaterialCheckBox materialCheckBox = getBinding().f17042p;
        C12238m.checkNotNullExpressionValue(materialCheckBox, "binding.guildScheduledEv…ettingsVisibilityCheckbox");
        materialCheckBox.setClickable(zIsEventViewableByEveryone);
        MaterialCheckBox materialCheckBox2 = getBinding().f17042p;
        C12238m.checkNotNullExpressionValue(materialCheckBox2, "binding.guildScheduledEv…ettingsVisibilityCheckbox");
        materialCheckBox2.setChecked(C12238m.areEqual(initialized.getEventModel().getBroadcastToDirectoryChannels(), Boolean.TRUE));
        if (guildScheduledEventBroadcastInvoke.getCanBroadcast() && initialized.getEventModel().getBroadcastToDirectoryChannels() == null) {
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

    private final void showDateErrorToast(GuildScheduledEventSettingsViewModel.DateError error) {
        int iOrdinal = error.ordinal();
        if (iOrdinal == 1) {
            C0876m.m169g(requireContext(), C5419R.string.guild_event_past_start_date, 0, null, 12);
        } else if (iOrdinal == 2) {
            C0876m.m169g(requireContext(), C5419R.string.guild_event_past_end_date_1, 0, null, 12);
        } else {
            if (iOrdinal != 3) {
                return;
            }
            C0876m.m169g(requireContext(), C5419R.string.guild_event_end_date_before_start_date, 0, null, 12);
        }
    }

    private final void toggleVisibilityOptions(boolean show) {
        TextView textView = getBinding().f17046t;
        C12238m.checkNotNullExpressionValue(textView, "binding.guildScheduledEv…tSettingsVisibilityHeader");
        textView.setVisibility(show ? 0 : 8);
        LinearLayout linearLayout = getBinding().f17043q;
        C12238m.checkNotNullExpressionValue(linearLayout, "binding.guildScheduledEv…ttingsVisibilityContainer");
        linearLayout.setVisibility(show ? 0 : 8);
        TextView textView2 = getBinding().f17045s;
        C12238m.checkNotNullExpressionValue(textView2, "binding.guildScheduledEv…ingsVisibilityDescription");
        textView2.setVisibility(show ? 0 : 8);
    }

    @Override // com.discord.app.AppFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeViewState(), this, null, 2, null), (Class<?>) WidgetGuildScheduledEventSettings.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C89111(this));
        Observable observableM11076j = Observable.m11076j(getViewModel().observeViewState(), getHubViewModel().observeViewState(), new Func2<GuildScheduledEventSettingsViewModel.ViewState, GuildScheduledEventDirectoryAssociationState, Pair<? extends GuildScheduledEventSettingsViewModel.ViewState, ? extends GuildScheduledEventDirectoryAssociationState>>() { // from class: com.discord.widgets.guildscheduledevent.WidgetGuildScheduledEventSettings.onResume.2
            @Override // p658rx.functions.Func2
            public final Pair<GuildScheduledEventSettingsViewModel.ViewState, GuildScheduledEventDirectoryAssociationState> call(GuildScheduledEventSettingsViewModel.ViewState viewState, GuildScheduledEventDirectoryAssociationState guildScheduledEventDirectoryAssociationState) {
                return C12116o.m10073to(viewState, guildScheduledEventDirectoryAssociationState);
            }
        });
        C12238m.checkNotNullExpressionValue(observableM11076j, "Observable.combineLatest…ttingsState to hubState }");
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.bindToComponentLifecycle$default(ObservableExtensionsKt.m8518ui(observableM11076j), this, null, 2, null), (Class<?>) WidgetGuildScheduledEventSettings.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C89133(this));
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        C12238m.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        TextView textView = getBinding().f17040n;
        C12238m.checkNotNullExpressionValue(textView, "binding.guildScheduledEventSettingsStepText");
        C1107b.m221m(textView, C5419R.string.guild_event_step_label, new Object[]{2, 3}, (4 & 4) != 0 ? C1107b.g.f1495j : null);
        getBinding().f17028b.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.guildscheduledevent.WidgetGuildScheduledEventSettings.onViewBound.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                FragmentActivity fragmentActivityM95e = WidgetGuildScheduledEventSettings.this.m95e();
                if (fragmentActivityM95e != null) {
                    fragmentActivityM95e.finish();
                }
            }
        });
        getBinding().f17029c.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.guildscheduledevent.WidgetGuildScheduledEventSettings.onViewBound.2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                FragmentActivity fragmentActivityM95e = WidgetGuildScheduledEventSettings.this.m95e();
                if (fragmentActivityM95e != null) {
                    fragmentActivityM95e.setResult(2);
                    fragmentActivityM95e.finish();
                }
            }
        });
        TextInputEditText textInputEditText = getBinding().f17041o;
        C12238m.checkNotNullExpressionValue(textInputEditText, "binding.guildScheduledEventSettingsTopicInput");
        textInputEditText.addTextChangedListener(new TextWatcher() { // from class: com.discord.widgets.guildscheduledevent.WidgetGuildScheduledEventSettings$onViewBound$$inlined$addTextChangedListener$1
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable s2) {
                String string;
                if (s2 == null || (string = s2.toString()) == null) {
                    return;
                }
                this.this$0.getViewModel().setTopic(string);
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence text, int start, int count, int after) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence text, int start, int before, int count) {
            }
        });
        TextInputEditText textInputEditText2 = getBinding().f17036j;
        C12238m.checkNotNullExpressionValue(textInputEditText2, "binding.guildScheduledEv…tSettingsDescriptionInput");
        textInputEditText2.addTextChangedListener(new TextWatcher() { // from class: com.discord.widgets.guildscheduledevent.WidgetGuildScheduledEventSettings$onViewBound$$inlined$addTextChangedListener$2
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable s2) {
                String string;
                if (s2 == null || (string = s2.toString()) == null) {
                    return;
                }
                this.this$0.getViewModel().setDescription(string);
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence text, int start, int count, int after) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence text, int start, int before, int count) {
            }
        });
        getBinding().f17039m.setOnClickListener(new ViewOnClickListenerC89205());
        getBinding().f17038l.setOnClickListener(new ViewOnClickListenerC89226());
        getBinding().f17034h.setOnClickListener(new ViewOnClickListenerC89247());
        getBinding().f17031e.setOnClickListener(new ViewOnClickListenerC89268());
        getBinding().f17037k.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.guildscheduledevent.WidgetGuildScheduledEventSettings.onViewBound.9
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                GuildScheduledEventSettingsViewModel.ViewState.Initialized initialized = WidgetGuildScheduledEventSettings.this.currentViewState;
                if (initialized != null) {
                    if (WidgetGuildScheduledEventSettings.this.getViewModel().hasStartTimeChanged(initialized) && !WidgetGuildScheduledEventSettings.this.getViewModel().isDateInFuture(initialized.getEventModel().getStartDate(), initialized.getEventModel().getStartTime())) {
                        WidgetGuildScheduledEventSettings.this.showDateErrorToast(GuildScheduledEventSettingsViewModel.DateError.START_DATE_IN_PAST);
                        return;
                    }
                    if (WidgetGuildScheduledEventSettings.this.getViewModel().hasEndTimeChanged(initialized) && !WidgetGuildScheduledEventSettings.this.getViewModel().isDateInFuture(initialized.getEventModel().getEndDate(), initialized.getEventModel().getEndTime())) {
                        WidgetGuildScheduledEventSettings.this.showDateErrorToast(GuildScheduledEventSettingsViewModel.DateError.END_DATE_IN_PAST);
                        return;
                    }
                    if (!WidgetGuildScheduledEventSettings.this.getViewModel().isStartDateBeforeEndDate(initialized)) {
                        WidgetGuildScheduledEventSettings.this.showDateErrorToast(GuildScheduledEventSettingsViewModel.DateError.END_DATE_BEFORE_START_DATE);
                        return;
                    }
                    WidgetPreviewGuildScheduledEvent.Companion companion = WidgetPreviewGuildScheduledEvent.INSTANCE;
                    Context contextRequireContext = WidgetGuildScheduledEventSettings.this.requireContext();
                    GuildScheduledEventModel eventModel = initialized.getEventModel();
                    Long existingGuildScheduledEventId = WidgetGuildScheduledEventSettings.this.getExistingGuildScheduledEventId();
                    companion.launch(contextRequireContext, eventModel, existingGuildScheduledEventId != null ? new WidgetPreviewGuildScheduledEvent.Companion.ExistingEventData(existingGuildScheduledEventId.longValue(), WidgetPreviewGuildScheduledEvent.Companion.Action.EDIT_EVENT) : null, WidgetGuildScheduledEventSettings.this.previewLauncher, true);
                }
            }
        });
        getBinding().f17043q.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.guildscheduledevent.WidgetGuildScheduledEventSettings.onViewBound.10
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                GuildScheduledEventSettingsViewModel viewModel = WidgetGuildScheduledEventSettings.this.getViewModel();
                MaterialCheckBox materialCheckBox = WidgetGuildScheduledEventSettings.this.getBinding().f17042p;
                C12238m.checkNotNullExpressionValue(materialCheckBox, "binding.guildScheduledEv…ettingsVisibilityCheckbox");
                viewModel.toggleBroadcastToDirectoryChannel(!materialCheckBox.isChecked());
            }
        });
        getBinding().f17042p.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.guildscheduledevent.WidgetGuildScheduledEventSettings.onViewBound.11
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                GuildScheduledEventSettingsViewModel viewModel = WidgetGuildScheduledEventSettings.this.getViewModel();
                MaterialCheckBox materialCheckBox = WidgetGuildScheduledEventSettings.this.getBinding().f17042p;
                C12238m.checkNotNullExpressionValue(materialCheckBox, "binding.guildScheduledEv…ettingsVisibilityCheckbox");
                viewModel.toggleBroadcastToDirectoryChannel(materialCheckBox.isChecked());
            }
        });
    }
}
