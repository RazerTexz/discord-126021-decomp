package com.discord.widgets.guildscheduledevent;

import android.content.Context;
import android.content.Intent;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.TextView;
import androidx.activity.result.ActivityResultLauncher;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentViewModelLazyKt;
import com.discord.C5419R;
import com.discord.api.channel.Channel;
import com.discord.api.guildscheduledevent.GuildScheduledEventEntityType;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetGuildScheduledEventLocationSelectBinding;
import com.discord.utilities.error.Error;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.discord.views.CheckedSetting;
import com.discord.widgets.channels.WidgetChannelSelector;
import com.discord.widgets.guildscheduledevent.WidgetGuildScheduledEventLocationSelectViewModel;
import com.discord.widgets.guildscheduledevent.WidgetGuildScheduledEventSettings;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import java.util.Set;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import p007b.p008a.p018d.C0863f0;
import p007b.p008a.p018d.C0865g0;
import p007b.p008a.p018d.C0869i0;
import p007b.p008a.p018d.C0870j;
import p007b.p008a.p027k.C1107b;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.C12083g;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12216a0;
import p507d0.p592z.p594d.C12236k;
import p507d0.p592z.p594d.C12238m;
import p658rx.Subscription;

/* JADX INFO: compiled from: WidgetGuildScheduledEventLocationSelect.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildScheduledEventLocationSelect extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {C1643a.m846d0(WidgetGuildScheduledEventLocationSelect.class, "binding", "getBinding()Lcom/discord/databinding/WidgetGuildScheduledEventLocationSelectBinding;", 0)};

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String GUILD_SCHEDULED_EVENT_LOCATION_SELECT_REQUEST_KEY = "GUILD_SCHEDULED_EVENT_LOCATION_SELECT_REQUEST_KEY";

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private WidgetGuildScheduledEventLocationSelectViewModel.ViewState.Valid currentViewState;

    /* JADX INFO: renamed from: existingGuildScheduledEventId$delegate, reason: from kotlin metadata */
    private final Lazy existingGuildScheduledEventId;

    /* JADX INFO: renamed from: guildId$delegate, reason: from kotlin metadata */
    private final Lazy guildId;

    /* JADX INFO: renamed from: hubViewModel$delegate, reason: from kotlin metadata */
    private final Lazy hubViewModel;
    private final ActivityResultLauncher<Intent> nextStepLauncher;

    /* JADX INFO: renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    /* JADX INFO: compiled from: WidgetGuildScheduledEventLocationSelect.kt */
    public static final class Companion {
        private Companion() {
        }

        public static /* synthetic */ void launch$default(Companion companion, Context context, long j, Long l, int i, Object obj) {
            if ((i & 4) != 0) {
                l = null;
            }
            companion.launch(context, j, l);
        }

        public final void launch(Context context, long guildId, Long channelId) {
            C12238m.checkNotNullParameter(context, "context");
            Intent intent = new Intent();
            intent.putExtra("com.discord.intent.extra.EXTRA_GUILD_ID", guildId);
            if (channelId != null) {
                intent.putExtra("com.discord.intent.extra.EXTRA_CHANNEL_ID", channelId.longValue());
            }
            C0870j.m156d(context, WidgetGuildScheduledEventLocationSelect.class, intent);
        }

        public final void launchForEdit(Context context, long guildId, long guildScheduledEventId) {
            C12238m.checkNotNullParameter(context, "context");
            Intent intent = new Intent();
            intent.putExtra("com.discord.intent.extra.EXTRA_GUILD_ID", guildId);
            intent.putExtra("com.discord.intent.extra.EXTRA_GUILD_SCHEDULED_EVENT_ID", guildScheduledEventId);
            C0870j.m156d(context, WidgetGuildScheduledEventLocationSelect.class, intent);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;
        public static final /* synthetic */ int[] $EnumSwitchMapping$2;

        static {
            GuildScheduledEventEntityType.values();
            int[] iArr = new int[5];
            $EnumSwitchMapping$0 = iArr;
            GuildScheduledEventEntityType guildScheduledEventEntityType = GuildScheduledEventEntityType.VOICE;
            iArr[guildScheduledEventEntityType.ordinal()] = 1;
            GuildScheduledEventEntityType guildScheduledEventEntityType2 = GuildScheduledEventEntityType.STAGE_INSTANCE;
            iArr[guildScheduledEventEntityType2.ordinal()] = 2;
            GuildScheduledEventEntityType.values();
            int[] iArr2 = new int[5];
            $EnumSwitchMapping$1 = iArr2;
            iArr2[guildScheduledEventEntityType2.ordinal()] = 1;
            iArr2[guildScheduledEventEntityType.ordinal()] = 2;
            GuildScheduledEventEntityType guildScheduledEventEntityType3 = GuildScheduledEventEntityType.EXTERNAL;
            iArr2[guildScheduledEventEntityType3.ordinal()] = 3;
            GuildScheduledEventEntityType.values();
            int[] iArr3 = new int[5];
            $EnumSwitchMapping$2 = iArr3;
            iArr3[guildScheduledEventEntityType2.ordinal()] = 1;
            iArr3[guildScheduledEventEntityType.ordinal()] = 2;
            iArr3[guildScheduledEventEntityType3.ordinal()] = 3;
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.guildscheduledevent.WidgetGuildScheduledEventLocationSelect$onResume$1 */
    /* JADX INFO: compiled from: WidgetGuildScheduledEventLocationSelect.kt */
    public static final /* synthetic */ class C88981 extends C12236k implements Function1<WidgetGuildScheduledEventLocationSelectViewModel.ViewState, Unit> {
        public C88981(WidgetGuildScheduledEventLocationSelect widgetGuildScheduledEventLocationSelect) {
            super(1, widgetGuildScheduledEventLocationSelect, WidgetGuildScheduledEventLocationSelect.class, "configureUI", "configureUI(Lcom/discord/widgets/guildscheduledevent/WidgetGuildScheduledEventLocationSelectViewModel$ViewState;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(WidgetGuildScheduledEventLocationSelectViewModel.ViewState viewState) {
            invoke2(viewState);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(WidgetGuildScheduledEventLocationSelectViewModel.ViewState viewState) {
            C12238m.checkNotNullParameter(viewState, "p1");
            ((WidgetGuildScheduledEventLocationSelect) this.receiver).configureUI(viewState);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.guildscheduledevent.WidgetGuildScheduledEventLocationSelect$onViewBound$4 */
    /* JADX INFO: compiled from: WidgetGuildScheduledEventLocationSelect.kt */
    public static final class C89024 extends AbstractC12240o implements Function2<Long, String, Unit> {
        public C89024() {
            super(2);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Long l, String str) {
            invoke(l.longValue(), str);
            return Unit.f27425a;
        }

        public final void invoke(long j, String str) {
            C12238m.checkNotNullParameter(str, "<anonymous parameter 1>");
            WidgetGuildScheduledEventLocationSelect.this.getViewModel().selectChannel(j);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.guildscheduledevent.WidgetGuildScheduledEventLocationSelect$onViewBound$5 */
    /* JADX INFO: compiled from: WidgetGuildScheduledEventLocationSelect.kt */
    public static final class C89035 extends AbstractC12240o implements Function1<TextView, Unit> {
        public C89035() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(TextView textView) {
            invoke2(textView);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(TextView textView) {
            C12238m.checkNotNullParameter(textView, "it");
            WidgetGuildScheduledEventLocationSelect.this.navigateNext();
        }
    }

    public WidgetGuildScheduledEventLocationSelect() {
        super(C5419R.layout.widget_guild_scheduled_event_location_select);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetGuildScheduledEventLocationSelect$binding$2.INSTANCE, null, 2, null);
        this.guildId = C12083g.lazy(new WidgetGuildScheduledEventLocationSelect$guildId$2(this));
        this.existingGuildScheduledEventId = C12083g.lazy(new C8897x6a3ff107(this));
        this.hubViewModel = FragmentViewModelLazyKt.createViewModelLazy(this, C12216a0.getOrCreateKotlinClass(GuildScheduledEventDirectoryAssociationViewModel.class), new C8893x568fcbec(this), new C0863f0(new WidgetGuildScheduledEventLocationSelect$hubViewModel$2(this)));
        WidgetGuildScheduledEventLocationSelect$viewModel$2 widgetGuildScheduledEventLocationSelect$viewModel$2 = new WidgetGuildScheduledEventLocationSelect$viewModel$2(this);
        C0865g0 c0865g0 = new C0865g0(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, C12216a0.getOrCreateKotlinClass(WidgetGuildScheduledEventLocationSelectViewModel.class), new C8895xb045e30e(c0865g0), new C0869i0(widgetGuildScheduledEventLocationSelect$viewModel$2));
        this.nextStepLauncher = WidgetGuildScheduledEventSettings.INSTANCE.registerForResult(this, new WidgetGuildScheduledEventLocationSelect$nextStepLauncher$1(this), new WidgetGuildScheduledEventLocationSelect$nextStepLauncher$2(this));
    }

    private final void configureLocationOption(WidgetGuildScheduledEventLocationSelectViewModel.ViewState.Valid viewState, CheckedSetting setting, final GuildScheduledEventEntityType settingValue, CharSequence disabledMessage) {
        setting.setChecked(viewState.getSelectedLocationOption() == settingValue);
        if (disabledMessage != null) {
            setting.m8526c(disabledMessage);
        } else {
            setting.m8527e(new View.OnClickListener() { // from class: com.discord.widgets.guildscheduledevent.WidgetGuildScheduledEventLocationSelect.configureLocationOption.1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    WidgetGuildScheduledEventLocationSelect.this.getViewModel().selectLocationOption(settingValue);
                }
            });
        }
    }

    private final void configureUI(WidgetGuildScheduledEventLocationSelectViewModel.ViewState viewState) {
        if (viewState instanceof WidgetGuildScheduledEventLocationSelectViewModel.ViewState.Valid) {
            WidgetGuildScheduledEventLocationSelectViewModel.ViewState.Valid valid = (WidgetGuildScheduledEventLocationSelectViewModel.ViewState.Valid) viewState;
            this.currentViewState = valid;
            CheckedSetting checkedSetting = getBinding().f17023j;
            C12238m.checkNotNullExpressionValue(checkedSetting, "binding.stageChannelOption");
            configureLocationOption(valid, checkedSetting, GuildScheduledEventEntityType.STAGE_INSTANCE, getDisabledMessageForChannelOption(valid.getAvailableStageChannelIds(), valid.getCanChangeChannel()));
            CheckedSetting checkedSetting2 = getBinding().f17026m;
            C12238m.checkNotNullExpressionValue(checkedSetting2, "binding.voiceChannelOption");
            configureLocationOption(valid, checkedSetting2, GuildScheduledEventEntityType.VOICE, getDisabledMessageForChannelOption(valid.getAvailableVoiceChannelIds(), valid.getCanChangeChannel()));
            CheckedSetting checkedSetting3 = getBinding().f17020g;
            C12238m.checkNotNullExpressionValue(checkedSetting3, "binding.externalOption");
            configureLocationOption(valid, checkedSetting3, GuildScheduledEventEntityType.EXTERNAL, getDisabledMessageForExternalOption(valid.getCanCreateExternalEvent(), valid.getCanChangeChannel()));
            boolean z2 = (valid.getAvailableStageChannelIds().isEmpty() ^ true) || valid.getShowStageOptionIfUnavailable();
            CheckedSetting checkedSetting4 = getBinding().f17023j;
            C12238m.checkNotNullExpressionValue(checkedSetting4, "binding.stageChannelOption");
            checkedSetting4.setVisibility(z2 ? 0 : 8);
            View view = getBinding().f17025l;
            C12238m.checkNotNullExpressionValue(view, "binding.voiceChannelDivider");
            view.setVisibility(z2 ? 0 : 8);
            int iOrdinal = valid.getSelectedLocationOption().ordinal();
            if (iOrdinal == 1 || iOrdinal == 2) {
                TextView textView = getBinding().f17021h;
                C12238m.checkNotNullExpressionValue(textView, "binding.locationHeader");
                ViewExtensions.setTextAndVisibilityBy(textView, getString(C5419R.string.guild_event_location_voice_field_label));
                TextInputLayout textInputLayout = getBinding().f17016c;
                C12238m.checkNotNullExpressionValue(textInputLayout, "binding.channelLocationLayout");
                textInputLayout.setVisibility(0);
                TextInputLayout textInputLayout2 = getBinding().f17019f;
                C12238m.checkNotNullExpressionValue(textInputLayout2, "binding.externalLocationLayout");
                textInputLayout2.setVisibility(8);
            } else if (iOrdinal != 3) {
                TextView textView2 = getBinding().f17021h;
                C12238m.checkNotNullExpressionValue(textView2, "binding.locationHeader");
                textView2.setVisibility(8);
                TextInputLayout textInputLayout3 = getBinding().f17016c;
                C12238m.checkNotNullExpressionValue(textInputLayout3, "binding.channelLocationLayout");
                textInputLayout3.setVisibility(8);
                TextInputLayout textInputLayout4 = getBinding().f17019f;
                C12238m.checkNotNullExpressionValue(textInputLayout4, "binding.externalLocationLayout");
                textInputLayout4.setVisibility(8);
            } else {
                TextView textView3 = getBinding().f17021h;
                C12238m.checkNotNullExpressionValue(textView3, "binding.locationHeader");
                ViewExtensions.setTextAndVisibilityBy(textView3, getString(C5419R.string.guild_event_location_elsewhere_field_label));
                TextInputLayout textInputLayout5 = getBinding().f17016c;
                C12238m.checkNotNullExpressionValue(textInputLayout5, "binding.channelLocationLayout");
                textInputLayout5.setVisibility(8);
                TextInputLayout textInputLayout6 = getBinding().f17019f;
                C12238m.checkNotNullExpressionValue(textInputLayout6, "binding.externalLocationLayout");
                textInputLayout6.setVisibility(0);
            }
            TextInputEditText textInputEditText = getBinding().f17015b;
            ViewExtensions.setEnabledAndAlpha$default(textInputEditText, valid.getCanChangeChannel(), 0.0f, 2, null);
            Editable text = textInputEditText.getText();
            String string = text != null ? text.toString() : null;
            Channel selectedChannel = valid.getSelectedChannel();
            if (!C12238m.areEqual(string, selectedChannel != null ? selectedChannel.getName() : null)) {
                Channel selectedChannel2 = valid.getSelectedChannel();
                textInputEditText.setText(selectedChannel2 != null ? selectedChannel2.getName() : null);
            }
            TextInputEditText textInputEditText2 = getBinding().f17018e;
            Editable text2 = textInputEditText2.getText();
            if (!C12238m.areEqual(text2 != null ? text2.toString() : null, valid.getExternalLocation())) {
                textInputEditText2.setText(valid.getExternalLocation());
            }
            MaterialButton materialButton = getBinding().f17022i;
            C12238m.checkNotNullExpressionValue(materialButton, "binding.nextButton");
            materialButton.setEnabled(isNextEnabled(valid));
        }
    }

    private final WidgetGuildScheduledEventLocationSelectBinding getBinding() {
        return (WidgetGuildScheduledEventLocationSelectBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final CharSequence getDisabledMessageForChannelOption(Set<Long> channelIds, boolean canChangeEntityType) {
        if (!canChangeEntityType) {
            return getString(C5419R.string.guild_event_location_disabled_cannot_edit);
        }
        if (channelIds.isEmpty()) {
            return getString(C5419R.string.guild_event_location_disabled_no_available_channel);
        }
        return null;
    }

    private final CharSequence getDisabledMessageForExternalOption(boolean canCreateExternalEvent, boolean canChangeEntityType) {
        if (!canChangeEntityType) {
            return getString(C5419R.string.guild_event_location_disabled_cannot_edit);
        }
        if (canCreateExternalEvent) {
            return null;
        }
        return getString(C5419R.string.guild_event_location_disabled_external_no_permission);
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

    private final boolean isNextEnabled(WidgetGuildScheduledEventLocationSelectViewModel.ViewState.Valid viewState) {
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
        WidgetGuildScheduledEventLocationSelectViewModel.ViewState.Valid valid = this.currentViewState;
        if (valid != null) {
            WidgetGuildScheduledEventSettings.Companion companion = WidgetGuildScheduledEventSettings.INSTANCE;
            Context contextRequireContext = requireContext();
            ActivityResultLauncher<Intent> activityResultLauncher = this.nextStepLauncher;
            long guildId = getGuildId();
            GuildScheduledEventEntityType selectedLocationOption = valid.getSelectedLocationOption();
            Channel selectedChannel = valid.getSelectedChannel();
            companion.launch(contextRequireContext, activityResultLauncher, guildId, selectedLocationOption, selectedChannel != null ? Long.valueOf(selectedChannel.getId()) : null, valid.getExternalLocation(), getExistingGuildScheduledEventId());
        }
    }

    @Override // com.discord.app.AppFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeViewState(), this, null, 2, null), (Class<?>) WidgetGuildScheduledEventLocationSelect.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C88981(this));
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        C12238m.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        TextView textView = getBinding().f17024k;
        C12238m.checkNotNullExpressionValue(textView, "binding.stepText");
        C1107b.m221m(textView, C5419R.string.guild_event_step_label, new Object[]{1, 3}, (4 & 4) != 0 ? C1107b.g.f1495j : null);
        getBinding().f17017d.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.guildscheduledevent.WidgetGuildScheduledEventLocationSelect.onViewBound.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                FragmentActivity fragmentActivityM95e = WidgetGuildScheduledEventLocationSelect.this.m95e();
                if (fragmentActivityM95e != null) {
                    fragmentActivityM95e.finish();
                }
            }
        });
        TextInputEditText textInputEditText = getBinding().f17018e;
        C12238m.checkNotNullExpressionValue(textInputEditText, "binding.externalLocationInput");
        textInputEditText.addTextChangedListener(new TextWatcher() { // from class: com.discord.widgets.guildscheduledevent.WidgetGuildScheduledEventLocationSelect$onViewBound$$inlined$addTextChangedListener$1
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable s2) {
                String string;
                if (s2 == null || (string = s2.toString()) == null) {
                    return;
                }
                this.this$0.getViewModel().setExternalLocation(string);
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence text, int start, int count, int after) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence text, int start, int before, int count) {
            }
        });
        getBinding().f17015b.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.guildscheduledevent.WidgetGuildScheduledEventLocationSelect.onViewBound.3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                WidgetGuildScheduledEventLocationSelectViewModel.ViewState.Valid valid = WidgetGuildScheduledEventLocationSelect.this.currentViewState;
                if (valid != null) {
                    int iOrdinal = valid.getSelectedLocationOption().ordinal();
                    if (iOrdinal == 1) {
                        WidgetChannelSelector.Companion companion = WidgetChannelSelector.INSTANCE;
                        WidgetGuildScheduledEventLocationSelect widgetGuildScheduledEventLocationSelect = WidgetGuildScheduledEventLocationSelect.this;
                        companion.launch(widgetGuildScheduledEventLocationSelect, widgetGuildScheduledEventLocationSelect.getGuildId(), WidgetGuildScheduledEventLocationSelect.GUILD_SCHEDULED_EVENT_LOCATION_SELECT_REQUEST_KEY, (24 & 8) != 0 ? false : false, (24 & 16) != 0 ? C5419R.string.none : 0, (24 & 32) != 0 ? null : new WidgetChannelSelector.SetFilterFunction(valid.getAvailableStageChannelIds()));
                    } else {
                        if (iOrdinal != 2) {
                            return;
                        }
                        WidgetChannelSelector.Companion companion2 = WidgetChannelSelector.INSTANCE;
                        WidgetGuildScheduledEventLocationSelect widgetGuildScheduledEventLocationSelect2 = WidgetGuildScheduledEventLocationSelect.this;
                        companion2.launch(widgetGuildScheduledEventLocationSelect2, widgetGuildScheduledEventLocationSelect2.getGuildId(), WidgetGuildScheduledEventLocationSelect.GUILD_SCHEDULED_EVENT_LOCATION_SELECT_REQUEST_KEY, (24 & 8) != 0 ? false : false, (24 & 16) != 0 ? C5419R.string.none : 0, (24 & 32) != 0 ? null : new WidgetChannelSelector.SetFilterFunction(valid.getAvailableVoiceChannelIds()));
                    }
                }
            }
        });
        WidgetChannelSelector.INSTANCE.registerForResult(this, GUILD_SCHEDULED_EVENT_LOCATION_SELECT_REQUEST_KEY, false, new C89024());
        TextInputLayout textInputLayout = getBinding().f17019f;
        C12238m.checkNotNullExpressionValue(textInputLayout, "binding.externalLocationLayout");
        ViewExtensions.setOnImeActionDone$default(textInputLayout, false, new C89035(), 1, null);
        getBinding().f17022i.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.guildscheduledevent.WidgetGuildScheduledEventLocationSelect.onViewBound.6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                WidgetGuildScheduledEventLocationSelect.this.navigateNext();
            }
        });
    }
}
