package com.discord.widgets.guilds.invite;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.MainThread;
import androidx.appcompat.widget.AppCompatRadioButton;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import com.discord.C5419R;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.app.AppFragment;
import com.discord.app.LoggingConfig;
import com.discord.databinding.WidgetGuildInviteSettingsBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.domain.ModelInvite;
import com.discord.utilities.analytics.AnalyticsTracker;
import com.discord.utilities.dimen.DimenUtils;
import com.discord.utilities.error.Error;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.resources.DurationUtilsKt;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.discord.views.CheckedSetting;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.ranges.IntRange;
import kotlin.reflect.KProperty;
import p007b.p008a.p018d.C0865g0;
import p007b.p008a.p018d.C0869i0;
import p007b.p008a.p018d.C0870j;
import p007b.p008a.p018d.C0876m;
import p007b.p008a.p025i.C0944e0;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p512d0.C11226f;
import p507d0.p580t.AbstractC12126c0;
import p507d0.p580t.C12149o;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12216a0;
import p507d0.p592z.p594d.C12236k;
import p507d0.p592z.p594d.C12238m;
import p658rx.Observable;
import p658rx.Subscription;

/* JADX INFO: compiled from: WidgetGuildInviteSettings.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildInviteSettings extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {C1643a.m846d0(WidgetGuildInviteSettings.class, "binding", "getBinding()Lcom/discord/databinding/WidgetGuildInviteSettingsBinding;", 0)};

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String EXTRA_CREATED_INVITE = "EXTRA_CREATED_INVITE";

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private ChannelsSpinnerAdapter channelsSpinnerAdapter;
    private final LoggingConfig loggingConfig;

    /* JADX INFO: renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    /* JADX INFO: compiled from: WidgetGuildInviteSettings.kt */
    public static final class ChannelsSpinnerAdapter extends ArrayAdapter<Channel> {
        private Channel[] channels;

        public /* synthetic */ ChannelsSpinnerAdapter(Context context, int i, Channel[] channelArr, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this(context, i, (i2 & 4) != 0 ? new Channel[0] : channelArr);
        }

        private final View getItemView(int position, int layoutId, View convertView, boolean dropDownMode) {
            if (convertView == null) {
                convertView = View.inflate(getContext(), layoutId, null);
            }
            C12238m.checkNotNullExpressionValue(convertView, "view");
            setupViews(convertView, position, dropDownMode);
            return convertView;
        }

        private final void setupViews(View convertView, int position, boolean dropDownMode) {
            TextView textView = (TextView) convertView.findViewById(new WidgetGuildInviteSettings$ChannelsSpinnerAdapter$setupViews$1(dropDownMode).invoke2());
            C12238m.checkNotNullExpressionValue(textView, "label");
            String str = String.format("#%s", Arrays.copyOf(new Object[]{ChannelUtils.m7679c(this.channels[position])}, 1));
            C12238m.checkNotNullExpressionValue(str, "java.lang.String.format(format, *args)");
            textView.setText(str);
        }

        @Override // android.widget.ArrayAdapter, android.widget.Adapter
        public int getCount() {
            return this.channels.length;
        }

        @Override // android.widget.ArrayAdapter, android.widget.BaseAdapter, android.widget.SpinnerAdapter
        public View getDropDownView(int position, View convertView, ViewGroup parent) {
            C12238m.checkNotNullParameter(parent, "parent");
            return getItemView(position, C5419R.layout.view_invite_settngs_channel_spinner_item_open, convertView, true);
        }

        @Override // android.widget.ArrayAdapter, android.widget.Adapter
        public View getView(int position, View convertView, ViewGroup parent) {
            C12238m.checkNotNullParameter(parent, "parent");
            return getItemView(position, C5419R.layout.view_invite_settings_channel_spinner_item, convertView, false);
        }

        public final void setData(Channel[] newData) {
            C12238m.checkNotNullParameter(newData, "newData");
            this.channels = newData;
            notifyDataSetChanged();
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ChannelsSpinnerAdapter(Context context, int i, Channel[] channelArr) {
            super(context, i, channelArr);
            C12238m.checkNotNullParameter(context, "context");
            C12238m.checkNotNullParameter(channelArr, "channels");
            this.channels = channelArr;
        }

        @Override // android.widget.ArrayAdapter, android.widget.Adapter
        public Channel getItem(int position) {
            return this.channels[position];
        }
    }

    /* JADX INFO: compiled from: WidgetGuildInviteSettings.kt */
    public static final class Companion {
        private Companion() {
        }

        public final void launch(Context context, ActivityResultLauncher<Intent> launcher, Long channelId, long guildId, String source) {
            C12238m.checkNotNullParameter(context, "context");
            C12238m.checkNotNullParameter(launcher, "launcher");
            C12238m.checkNotNullParameter(source, "source");
            AnalyticsTracker.openModal$default("Link Settings", source, null, 4, null);
            Intent intent = new Intent();
            if (channelId != null) {
                intent.putExtra("com.discord.intent.extra.EXTRA_CHANNEL_ID", channelId.longValue());
            }
            intent.putExtra("com.discord.intent.extra.EXTRA_GUILD_ID", guildId);
            C0870j.f524g.m160f(context, launcher, WidgetGuildInviteSettings.class, intent);
        }

        public final ActivityResultLauncher<Intent> registerForResult(DialogFragment fragment, final Function1<? super GuildInvite, Unit> callback) {
            C12238m.checkNotNullParameter(fragment, "fragment");
            C12238m.checkNotNullParameter(callback, "callback");
            ActivityResultLauncher<Intent> activityResultLauncherRegisterForActivityResult = fragment.registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() { // from class: com.discord.widgets.guilds.invite.WidgetGuildInviteSettings$Companion$registerForResult$1
                @Override // androidx.activity.result.ActivityResultCallback
                public final void onActivityResult(ActivityResult activityResult) {
                    C12238m.checkNotNullExpressionValue(activityResult, "activityResult");
                    if (activityResult.getResultCode() == -1) {
                        Intent data = activityResult.getData();
                        Serializable serializableExtra = data != null ? data.getSerializableExtra("EXTRA_CREATED_INVITE") : null;
                        GuildInvite guildInvite = (GuildInvite) (serializableExtra instanceof GuildInvite ? serializableExtra : null);
                        if (guildInvite != null) {
                            callback.invoke(guildInvite);
                        }
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

    /* JADX INFO: renamed from: com.discord.widgets.guilds.invite.WidgetGuildInviteSettings$onViewBound$1 */
    /* JADX INFO: compiled from: WidgetGuildInviteSettings.kt */
    public static final class C86541 extends AbstractC12240o implements Function1<Integer, CharSequence> {
        public C86541() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ CharSequence invoke(Integer num) {
            return invoke(num.intValue());
        }

        public final CharSequence invoke(int i) {
            return DurationUtilsKt.formatInviteExpireAfterString(WidgetGuildInviteSettings.this.requireContext(), i);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.guilds.invite.WidgetGuildInviteSettings$onViewBound$2 */
    /* JADX INFO: compiled from: WidgetGuildInviteSettings.kt */
    public static final /* synthetic */ class C86552 extends C12236k implements Function1<Integer, String> {
        public C86552(WidgetGuildInviteSettings widgetGuildInviteSettings) {
            super(1, widgetGuildInviteSettings, WidgetGuildInviteSettings.class, "getMaxUsesString", "getMaxUsesString(I)Ljava/lang/String;", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ String invoke(Integer num) {
            return invoke(num.intValue());
        }

        public final String invoke(int i) {
            return ((WidgetGuildInviteSettings) this.receiver).getMaxUsesString(i);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.guilds.invite.WidgetGuildInviteSettings$onViewBoundOrOnResume$1 */
    /* JADX INFO: compiled from: WidgetGuildInviteSettings.kt */
    public static final class C86561 extends AbstractC12240o implements Function1<GuildInviteSettingsViewModel.ViewState, Unit> {
        public C86561() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(GuildInviteSettingsViewModel.ViewState viewState) {
            invoke2(viewState);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(GuildInviteSettingsViewModel.ViewState viewState) {
            WidgetGuildInviteSettings widgetGuildInviteSettings = WidgetGuildInviteSettings.this;
            C12238m.checkNotNullExpressionValue(viewState, "viewState");
            widgetGuildInviteSettings.configureUi(viewState);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.guilds.invite.WidgetGuildInviteSettings$onViewBoundOrOnResume$2 */
    /* JADX INFO: compiled from: WidgetGuildInviteSettings.kt */
    public static final class C86572 extends AbstractC12240o implements Function1<GuildInviteSettingsViewModel.Event, Unit> {
        public C86572() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(GuildInviteSettingsViewModel.Event event) {
            invoke2(event);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(GuildInviteSettingsViewModel.Event event) {
            C12238m.checkNotNullParameter(event, "event");
            WidgetGuildInviteSettings.this.handleEvent(event);
        }
    }

    public WidgetGuildInviteSettings() {
        super(C5419R.layout.widget_guild_invite_settings);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetGuildInviteSettings$binding$2.INSTANCE, null, 2, null);
        WidgetGuildInviteSettings$viewModel$2 widgetGuildInviteSettings$viewModel$2 = new WidgetGuildInviteSettings$viewModel$2(this);
        C0865g0 c0865g0 = new C0865g0(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, C12216a0.getOrCreateKotlinClass(GuildInviteSettingsViewModel.class), new WidgetGuildInviteSettings$appViewModels$$inlined$viewModels$1(c0865g0), new C0869i0(widgetGuildInviteSettings$viewModel$2));
        this.loggingConfig = new LoggingConfig(false, null, WidgetGuildInviteSettings$loggingConfig$1.INSTANCE, 3);
    }

    public static final /* synthetic */ ChannelsSpinnerAdapter access$getChannelsSpinnerAdapter$p(WidgetGuildInviteSettings widgetGuildInviteSettings) {
        ChannelsSpinnerAdapter channelsSpinnerAdapter = widgetGuildInviteSettings.channelsSpinnerAdapter;
        if (channelsSpinnerAdapter == null) {
            C12238m.throwUninitializedPropertyAccessException("channelsSpinnerAdapter");
        }
        return channelsSpinnerAdapter;
    }

    @MainThread
    private final void createHorizontalCheckableButtons(RadioGroup radioGroup, int[] valueSet, Function1<? super Integer, ? extends CharSequence> textFactory) {
        if (radioGroup.getChildCount() > 0) {
            return;
        }
        boolean z2 = false;
        for (int i : valueSet) {
            View viewInflate = LayoutInflater.from(getContext()).inflate(C5419R.layout.invite_settings_radio_button, (ViewGroup) radioGroup, false);
            Objects.requireNonNull(viewInflate, "rootView");
            AppCompatRadioButton appCompatRadioButton = (AppCompatRadioButton) viewInflate;
            C12238m.checkNotNullExpressionValue(new C0944e0(appCompatRadioButton), "InviteSettingsRadioButto…text), radioGroup, false)");
            C12238m.checkNotNullExpressionValue(appCompatRadioButton, "binding.root");
            appCompatRadioButton.setId(i);
            C12238m.checkNotNullExpressionValue(appCompatRadioButton, "binding.root");
            appCompatRadioButton.setText(textFactory.invoke(Integer.valueOf(i)));
            if (!z2) {
                C12238m.checkNotNullExpressionValue(appCompatRadioButton, "binding.root");
                ViewGroup.LayoutParams layoutParams = appCompatRadioButton.getLayoutParams();
                Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type android.widget.RadioGroup.LayoutParams");
                RadioGroup.LayoutParams layoutParams2 = (RadioGroup.LayoutParams) layoutParams;
                layoutParams2.leftMargin = DimenUtils.dpToPixels(16);
                C12238m.checkNotNullExpressionValue(appCompatRadioButton, "binding.root");
                appCompatRadioButton.setLayoutParams(layoutParams2);
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
        Spinner spinner = getBinding().f16799b;
        C12238m.checkNotNullExpressionValue(spinner, "binding.guildInviteChannelSpinner");
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { // from class: com.discord.widgets.guilds.invite.WidgetGuildInviteSettings.setOnItemSelected.1
            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id2) {
                C12238m.checkNotNullParameter(parent, "parent");
                C12238m.checkNotNullParameter(view, "view");
                WidgetGuildInviteSettings.this.getViewModel().selectChannel(WidgetGuildInviteSettings.access$getChannelsSpinnerAdapter$p(WidgetGuildInviteSettings.this).getItem(position));
            }

            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onNothingSelected(AdapterView<?> parent) {
                C12238m.checkNotNullParameter(parent, "parent");
            }
        });
    }

    public final void configureUi(GuildInviteSettingsViewModel.ViewState viewState) {
        Object obj;
        Object next;
        C12238m.checkNotNullParameter(viewState, "viewState");
        List<Channel> invitableChannels = viewState.getInvitableChannels();
        ChannelsSpinnerAdapter channelsSpinnerAdapter = this.channelsSpinnerAdapter;
        if (channelsSpinnerAdapter == null) {
            C12238m.throwUninitializedPropertyAccessException("channelsSpinnerAdapter");
        }
        Object[] array = invitableChannels.toArray(new Channel[0]);
        Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
        channelsSpinnerAdapter.setData((Channel[]) array);
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
        getBinding().f16799b.setSelection(Math.max(i, 0), false);
        final ModelInvite.Settings inviteSettings = viewState.getInviteSettings();
        RadioGroup radioGroup = getBinding().f16800c;
        C12238m.checkNotNullExpressionValue(radioGroup, "binding.guildInviteExpiresAfterRadiogroup");
        IntRange intRangeUntil = C11226f.until(0, radioGroup.getChildCount());
        ArrayList arrayList = new ArrayList(C12149o.collectionSizeOrDefault(intRangeUntil, 10));
        Iterator<Integer> it2 = intRangeUntil.iterator();
        while (it2.hasNext()) {
            View childAt = getBinding().f16800c.getChildAt(((AbstractC12126c0) it2).nextInt());
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
        getBinding().f16800c.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() { // from class: com.discord.widgets.guilds.invite.WidgetGuildInviteSettings.configureUi.4
            @Override // android.widget.RadioGroup.OnCheckedChangeListener
            public final void onCheckedChanged(RadioGroup radioGroup2, int i2) {
                GuildInviteSettingsViewModel viewModel = WidgetGuildInviteSettings.this.getViewModel();
                ModelInvite.Settings settingsMergeMaxAge = inviteSettings.mergeMaxAge(i2);
                C12238m.checkNotNullExpressionValue(settingsMergeMaxAge, "inviteSettings.mergeMaxAge(checkedId)");
                viewModel.updatePendingInviteSettings(settingsMergeMaxAge);
            }
        });
        RadioGroup radioGroup2 = getBinding().f16802e;
        C12238m.checkNotNullExpressionValue(radioGroup2, "binding.guildInviteMaxUsesRadiogroup");
        IntRange intRangeUntil2 = C11226f.until(0, radioGroup2.getChildCount());
        ArrayList arrayList2 = new ArrayList(C12149o.collectionSizeOrDefault(intRangeUntil2, 10));
        Iterator<Integer> it4 = intRangeUntil2.iterator();
        while (it4.hasNext()) {
            View childAt2 = getBinding().f16802e.getChildAt(((AbstractC12126c0) it4).nextInt());
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
        getBinding().f16802e.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() { // from class: com.discord.widgets.guilds.invite.WidgetGuildInviteSettings.configureUi.8
            @Override // android.widget.RadioGroup.OnCheckedChangeListener
            public final void onCheckedChanged(RadioGroup radioGroup3, int i2) {
                GuildInviteSettingsViewModel viewModel = WidgetGuildInviteSettings.this.getViewModel();
                ModelInvite.Settings settingsMergeMaxUses = inviteSettings.mergeMaxUses(i2);
                C12238m.checkNotNullExpressionValue(settingsMergeMaxUses, "inviteSettings.mergeMaxUses(checkedId)");
                viewModel.updatePendingInviteSettings(settingsMergeMaxUses);
            }
        });
        CheckedSetting checkedSetting = getBinding().f16803f;
        C12238m.checkNotNullExpressionValue(checkedSetting, "binding.guildInviteTemporaryMembership");
        checkedSetting.setChecked(inviteSettings.isTemporary());
        getBinding().f16803f.m8527e(new View.OnClickListener() { // from class: com.discord.widgets.guilds.invite.WidgetGuildInviteSettings.configureUi.9
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WidgetGuildInviteSettings.this.getBinding().f16803f.toggle();
                GuildInviteSettingsViewModel viewModel = WidgetGuildInviteSettings.this.getViewModel();
                ModelInvite.Settings settings = inviteSettings;
                CheckedSetting checkedSetting2 = WidgetGuildInviteSettings.this.getBinding().f16803f;
                C12238m.checkNotNullExpressionValue(checkedSetting2, "binding.guildInviteTemporaryMembership");
                ModelInvite.Settings settingsMergeTemporary = settings.mergeTemporary(checkedSetting2.isChecked());
                C12238m.checkNotNullExpressionValue(settingsMergeTemporary, "inviteSettings.mergeTemp…raryMembership.isChecked)");
                viewModel.updatePendingInviteSettings(settingsMergeTemporary);
            }
        });
        getBinding().f16801d.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.guilds.invite.WidgetGuildInviteSettings.configureUi.10
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WidgetGuildInviteSettings.this.getViewModel().saveInviteSettings();
            }
        });
    }

    @Override // com.discord.app.AppFragment, com.discord.app.AppLogger.InterfaceC5455a
    public LoggingConfig getLoggingConfig() {
        return this.loggingConfig;
    }

    public final void handleEvent(GuildInviteSettingsViewModel.Event event) {
        C12238m.checkNotNullParameter(event, "event");
        if (!(event instanceof GuildInviteSettingsViewModel.Event.InviteCreationSuccess)) {
            if (C12238m.areEqual(event, GuildInviteSettingsViewModel.Event.InviteCreationFailure.INSTANCE)) {
                C0876m.m169g(requireContext(), C5419R.string.default_failure_to_perform_action_message, 0, null, 12);
            }
        } else {
            Intent intent = new Intent();
            intent.putExtra(EXTRA_CREATED_INVITE, ((GuildInviteSettingsViewModel.Event.InviteCreationSuccess) event).getInvite());
            requireActivity().setResult(-1, intent);
            requireActivity().finish();
        }
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        C12238m.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        this.channelsSpinnerAdapter = new ChannelsSpinnerAdapter(requireContext(), C5419R.layout.view_invite_settings_channel_spinner_item, null, 4, null);
        Spinner spinner = getBinding().f16799b;
        C12238m.checkNotNullExpressionValue(spinner, "binding.guildInviteChannelSpinner");
        ChannelsSpinnerAdapter channelsSpinnerAdapter = this.channelsSpinnerAdapter;
        if (channelsSpinnerAdapter == null) {
            C12238m.throwUninitializedPropertyAccessException("channelsSpinnerAdapter");
        }
        spinner.setAdapter((SpinnerAdapter) channelsSpinnerAdapter);
        RadioGroup radioGroup = getBinding().f16800c;
        C12238m.checkNotNullExpressionValue(radioGroup, "binding.guildInviteExpiresAfterRadiogroup");
        int[] iArr = ModelInvite.Settings.EXPIRES_AFTER_ARRAY;
        C12238m.checkNotNullExpressionValue(iArr, "ModelInvite.Settings.EXPIRES_AFTER_ARRAY");
        createHorizontalCheckableButtons(radioGroup, iArr, new C86541());
        RadioGroup radioGroup2 = getBinding().f16802e;
        C12238m.checkNotNullExpressionValue(radioGroup2, "binding.guildInviteMaxUsesRadiogroup");
        int[] iArr2 = ModelInvite.Settings.MAX_USES_ARRAY;
        C12238m.checkNotNullExpressionValue(iArr2, "ModelInvite.Settings.MAX_USES_ARRAY");
        createHorizontalCheckableButtons(radioGroup2, iArr2, new C86552(this));
        setOnItemSelected();
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        Observable<GuildInviteSettingsViewModel.ViewState> observableM11112r = getViewModel().observeViewState().m11112r();
        C12238m.checkNotNullExpressionValue(observableM11112r, "viewModel.observeViewSta…  .distinctUntilChanged()");
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.bindToComponentLifecycle$default(observableM11112r, this, null, 2, null), (Class<?>) WidgetGuildInviteSettings.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C86561());
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeEvents(), this, null, 2, null), (Class<?>) WidgetGuildInviteSettings.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C86572());
    }
}
