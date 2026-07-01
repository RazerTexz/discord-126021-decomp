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
import b.a.d.AppScreen2;
import b.a.d.AppToast;
import b.a.d.AppViewModelDelegates3;
import b.a.d.AppViewModelDelegates5;
import b.a.i.InviteSettingsRadioButtonBinding;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.app.AppFragment;
import com.discord.app.AppLogger2;
import com.discord.databinding.WidgetGuildInviteSettingsBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.domain.ModelInvite;
import com.discord.utilities.analytics.AnalyticsTracker;
import com.discord.utilities.dimen.DimenUtils;
import com.discord.utilities.error.Error;
import com.discord.utilities.resources.DurationUtils3;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.views.CheckedSetting;
import com.discord.widgets.guilds.invite.GuildInviteSettingsViewModel;
import d0.d0._Ranges;
import d0.t.Iterables2;
import d0.t.Iterators4;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import d0.z.d.Reflection2;
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
import kotlin.ranges.Ranges2;
import kotlin.reflect.KProperty;
import rx.Observable;
import rx.Subscription;

/* JADX INFO: compiled from: WidgetGuildInviteSettings.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildInviteSettings extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.d0(WidgetGuildInviteSettings.class, "binding", "getBinding()Lcom/discord/databinding/WidgetGuildInviteSettingsBinding;", 0)};

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String EXTRA_CREATED_INVITE = "EXTRA_CREATED_INVITE";

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private ChannelsSpinnerAdapter channelsSpinnerAdapter;
    private final AppLogger2 loggingConfig;

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
            Intrinsics3.checkNotNullExpressionValue(convertView, "view");
            setupViews(convertView, position, dropDownMode);
            return convertView;
        }

        private final void setupViews(View convertView, int position, boolean dropDownMode) {
            TextView textView = (TextView) convertView.findViewById(new WidgetGuildInviteSettings2(dropDownMode).invoke2());
            Intrinsics3.checkNotNullExpressionValue(textView, "label");
            String str = String.format("#%s", Arrays.copyOf(new Object[]{ChannelUtils.c(this.channels[position])}, 1));
            Intrinsics3.checkNotNullExpressionValue(str, "java.lang.String.format(format, *args)");
            textView.setText(str);
        }

        @Override // android.widget.ArrayAdapter, android.widget.Adapter
        public int getCount() {
            return this.channels.length;
        }

        @Override // android.widget.ArrayAdapter, android.widget.BaseAdapter, android.widget.SpinnerAdapter
        public View getDropDownView(int position, View convertView, ViewGroup parent) {
            Intrinsics3.checkNotNullParameter(parent, "parent");
            return getItemView(position, R.layout.view_invite_settngs_channel_spinner_item_open, convertView, true);
        }

        @Override // android.widget.ArrayAdapter, android.widget.Adapter
        public View getView(int position, View convertView, ViewGroup parent) {
            Intrinsics3.checkNotNullParameter(parent, "parent");
            return getItemView(position, R.layout.view_invite_settings_channel_spinner_item, convertView, false);
        }

        public final void setData(Channel[] newData) {
            Intrinsics3.checkNotNullParameter(newData, "newData");
            this.channels = newData;
            notifyDataSetChanged();
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ChannelsSpinnerAdapter(Context context, int i, Channel[] channelArr) {
            super(context, i, channelArr);
            Intrinsics3.checkNotNullParameter(context, "context");
            Intrinsics3.checkNotNullParameter(channelArr, "channels");
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
            Intrinsics3.checkNotNullParameter(context, "context");
            Intrinsics3.checkNotNullParameter(launcher, "launcher");
            Intrinsics3.checkNotNullParameter(source, "source");
            AnalyticsTracker.openModal$default("Link Settings", source, null, 4, null);
            Intent intent = new Intent();
            if (channelId != null) {
                intent.putExtra("com.discord.intent.extra.EXTRA_CHANNEL_ID", channelId.longValue());
            }
            intent.putExtra("com.discord.intent.extra.EXTRA_GUILD_ID", guildId);
            AppScreen2.g.f(context, launcher, WidgetGuildInviteSettings.class, intent);
        }

        public final ActivityResultLauncher<Intent> registerForResult(DialogFragment fragment, final Function1<? super GuildInvite, Unit> callback) {
            Intrinsics3.checkNotNullParameter(fragment, "fragment");
            Intrinsics3.checkNotNullParameter(callback, "callback");
            ActivityResultLauncher<Intent> activityResultLauncherRegisterForActivityResult = fragment.registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() { // from class: com.discord.widgets.guilds.invite.WidgetGuildInviteSettings$Companion$registerForResult$1
                @Override // androidx.activity.result.ActivityResultCallback
                public final void onActivityResult(ActivityResult activityResult) {
                    Intrinsics3.checkNotNullExpressionValue(activityResult, "activityResult");
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
            Intrinsics3.checkNotNullExpressionValue(activityResultLauncherRegisterForActivityResult, "fragment.registerForActi…  }\n          }\n        }");
            return activityResultLauncherRegisterForActivityResult;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.guilds.invite.WidgetGuildInviteSettings$onViewBound$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetGuildInviteSettings.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<Integer, CharSequence> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ CharSequence invoke(Integer num) {
            return invoke(num.intValue());
        }

        public final CharSequence invoke(int i) {
            return DurationUtils3.formatInviteExpireAfterString(WidgetGuildInviteSettings.this.requireContext(), i);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.guilds.invite.WidgetGuildInviteSettings$onViewBound$2, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetGuildInviteSettings.kt */
    public static final /* synthetic */ class AnonymousClass2 extends FunctionReferenceImpl implements Function1<Integer, String> {
        public AnonymousClass2(WidgetGuildInviteSettings widgetGuildInviteSettings) {
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

    /* JADX INFO: renamed from: com.discord.widgets.guilds.invite.WidgetGuildInviteSettings$onViewBoundOrOnResume$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetGuildInviteSettings.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<GuildInviteSettingsViewModel.ViewState, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(GuildInviteSettingsViewModel.ViewState viewState) {
            invoke2(viewState);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(GuildInviteSettingsViewModel.ViewState viewState) {
            WidgetGuildInviteSettings widgetGuildInviteSettings = WidgetGuildInviteSettings.this;
            Intrinsics3.checkNotNullExpressionValue(viewState, "viewState");
            widgetGuildInviteSettings.configureUi(viewState);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.guilds.invite.WidgetGuildInviteSettings$onViewBoundOrOnResume$2, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetGuildInviteSettings.kt */
    public static final class AnonymousClass2 extends Lambda implements Function1<GuildInviteSettingsViewModel.Event, Unit> {
        public AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(GuildInviteSettingsViewModel.Event event) {
            invoke2(event);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(GuildInviteSettingsViewModel.Event event) {
            Intrinsics3.checkNotNullParameter(event, "event");
            WidgetGuildInviteSettings.this.handleEvent(event);
        }
    }

    public WidgetGuildInviteSettings() {
        super(R.layout.widget_guild_invite_settings);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetGuildInviteSettings4.INSTANCE, null, 2, null);
        WidgetGuildInviteSettings6 widgetGuildInviteSettings6 = new WidgetGuildInviteSettings6(this);
        AppViewModelDelegates3 appViewModelDelegates3 = new AppViewModelDelegates3(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection2.getOrCreateKotlinClass(GuildInviteSettingsViewModel.class), new WidgetGuildInviteSettings$appViewModels$$inlined$viewModels$1(appViewModelDelegates3), new AppViewModelDelegates5(widgetGuildInviteSettings6));
        this.loggingConfig = new AppLogger2(false, null, WidgetGuildInviteSettings5.INSTANCE, 3);
    }

    public static final /* synthetic */ ChannelsSpinnerAdapter access$getChannelsSpinnerAdapter$p(WidgetGuildInviteSettings widgetGuildInviteSettings) {
        ChannelsSpinnerAdapter channelsSpinnerAdapter = widgetGuildInviteSettings.channelsSpinnerAdapter;
        if (channelsSpinnerAdapter == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("channelsSpinnerAdapter");
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
            View viewInflate = LayoutInflater.from(getContext()).inflate(R.layout.invite_settings_radio_button, (ViewGroup) radioGroup, false);
            Objects.requireNonNull(viewInflate, "rootView");
            AppCompatRadioButton appCompatRadioButton = (AppCompatRadioButton) viewInflate;
            Intrinsics3.checkNotNullExpressionValue(new InviteSettingsRadioButtonBinding(appCompatRadioButton), "InviteSettingsRadioButto…text), radioGroup, false)");
            Intrinsics3.checkNotNullExpressionValue(appCompatRadioButton, "binding.root");
            appCompatRadioButton.setId(i);
            Intrinsics3.checkNotNullExpressionValue(appCompatRadioButton, "binding.root");
            appCompatRadioButton.setText(textFactory.invoke(Integer.valueOf(i)));
            if (!z2) {
                Intrinsics3.checkNotNullExpressionValue(appCompatRadioButton, "binding.root");
                ViewGroup.LayoutParams layoutParams = appCompatRadioButton.getLayoutParams();
                Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type android.widget.RadioGroup.LayoutParams");
                RadioGroup.LayoutParams layoutParams2 = (RadioGroup.LayoutParams) layoutParams;
                layoutParams2.leftMargin = DimenUtils.dpToPixels(16);
                Intrinsics3.checkNotNullExpressionValue(appCompatRadioButton, "binding.root");
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
        Spinner spinner = getBinding().f2417b;
        Intrinsics3.checkNotNullExpressionValue(spinner, "binding.guildInviteChannelSpinner");
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { // from class: com.discord.widgets.guilds.invite.WidgetGuildInviteSettings.setOnItemSelected.1
            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id2) {
                Intrinsics3.checkNotNullParameter(parent, "parent");
                Intrinsics3.checkNotNullParameter(view, "view");
                WidgetGuildInviteSettings.this.getViewModel().selectChannel(WidgetGuildInviteSettings.access$getChannelsSpinnerAdapter$p(WidgetGuildInviteSettings.this).getItem(position));
            }

            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onNothingSelected(AdapterView<?> parent) {
                Intrinsics3.checkNotNullParameter(parent, "parent");
            }
        });
    }

    public final void configureUi(GuildInviteSettingsViewModel.ViewState viewState) {
        Object obj;
        Object next;
        Intrinsics3.checkNotNullParameter(viewState, "viewState");
        List<Channel> invitableChannels = viewState.getInvitableChannels();
        ChannelsSpinnerAdapter channelsSpinnerAdapter = this.channelsSpinnerAdapter;
        if (channelsSpinnerAdapter == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("channelsSpinnerAdapter");
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
        getBinding().f2417b.setSelection(Math.max(i, 0), false);
        final ModelInvite.Settings inviteSettings = viewState.getInviteSettings();
        RadioGroup radioGroup = getBinding().c;
        Intrinsics3.checkNotNullExpressionValue(radioGroup, "binding.guildInviteExpiresAfterRadiogroup");
        Ranges2 ranges2Until = _Ranges.until(0, radioGroup.getChildCount());
        ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(ranges2Until, 10));
        Iterator<Integer> it2 = ranges2Until.iterator();
        while (it2.hasNext()) {
            View childAt = getBinding().c.getChildAt(((Iterators4) it2).nextInt());
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
        getBinding().c.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() { // from class: com.discord.widgets.guilds.invite.WidgetGuildInviteSettings.configureUi.4
            @Override // android.widget.RadioGroup.OnCheckedChangeListener
            public final void onCheckedChanged(RadioGroup radioGroup2, int i2) {
                GuildInviteSettingsViewModel viewModel = WidgetGuildInviteSettings.this.getViewModel();
                ModelInvite.Settings settingsMergeMaxAge = inviteSettings.mergeMaxAge(i2);
                Intrinsics3.checkNotNullExpressionValue(settingsMergeMaxAge, "inviteSettings.mergeMaxAge(checkedId)");
                viewModel.updatePendingInviteSettings(settingsMergeMaxAge);
            }
        });
        RadioGroup radioGroup2 = getBinding().e;
        Intrinsics3.checkNotNullExpressionValue(radioGroup2, "binding.guildInviteMaxUsesRadiogroup");
        Ranges2 ranges2Until2 = _Ranges.until(0, radioGroup2.getChildCount());
        ArrayList arrayList2 = new ArrayList(Iterables2.collectionSizeOrDefault(ranges2Until2, 10));
        Iterator<Integer> it4 = ranges2Until2.iterator();
        while (it4.hasNext()) {
            View childAt2 = getBinding().e.getChildAt(((Iterators4) it4).nextInt());
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
        getBinding().e.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() { // from class: com.discord.widgets.guilds.invite.WidgetGuildInviteSettings.configureUi.8
            @Override // android.widget.RadioGroup.OnCheckedChangeListener
            public final void onCheckedChanged(RadioGroup radioGroup3, int i2) {
                GuildInviteSettingsViewModel viewModel = WidgetGuildInviteSettings.this.getViewModel();
                ModelInvite.Settings settingsMergeMaxUses = inviteSettings.mergeMaxUses(i2);
                Intrinsics3.checkNotNullExpressionValue(settingsMergeMaxUses, "inviteSettings.mergeMaxUses(checkedId)");
                viewModel.updatePendingInviteSettings(settingsMergeMaxUses);
            }
        });
        CheckedSetting checkedSetting = getBinding().f;
        Intrinsics3.checkNotNullExpressionValue(checkedSetting, "binding.guildInviteTemporaryMembership");
        checkedSetting.setChecked(inviteSettings.isTemporary());
        getBinding().f.e(new View.OnClickListener() { // from class: com.discord.widgets.guilds.invite.WidgetGuildInviteSettings.configureUi.9
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WidgetGuildInviteSettings.this.getBinding().f.toggle();
                GuildInviteSettingsViewModel viewModel = WidgetGuildInviteSettings.this.getViewModel();
                ModelInvite.Settings settings = inviteSettings;
                CheckedSetting checkedSetting2 = WidgetGuildInviteSettings.this.getBinding().f;
                Intrinsics3.checkNotNullExpressionValue(checkedSetting2, "binding.guildInviteTemporaryMembership");
                ModelInvite.Settings settingsMergeTemporary = settings.mergeTemporary(checkedSetting2.isChecked());
                Intrinsics3.checkNotNullExpressionValue(settingsMergeTemporary, "inviteSettings.mergeTemp…raryMembership.isChecked)");
                viewModel.updatePendingInviteSettings(settingsMergeTemporary);
            }
        });
        getBinding().d.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.guilds.invite.WidgetGuildInviteSettings.configureUi.10
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WidgetGuildInviteSettings.this.getViewModel().saveInviteSettings();
            }
        });
    }

    @Override // com.discord.app.AppFragment, com.discord.app.AppLogger.a
    public AppLogger2 getLoggingConfig() {
        return this.loggingConfig;
    }

    public final void handleEvent(GuildInviteSettingsViewModel.Event event) {
        Intrinsics3.checkNotNullParameter(event, "event");
        if (!(event instanceof GuildInviteSettingsViewModel.Event.InviteCreationSuccess)) {
            if (Intrinsics3.areEqual(event, GuildInviteSettingsViewModel.Event.InviteCreationFailure.INSTANCE)) {
                AppToast.g(requireContext(), R.string.default_failure_to_perform_action_message, 0, null, 12);
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
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        this.channelsSpinnerAdapter = new ChannelsSpinnerAdapter(requireContext(), R.layout.view_invite_settings_channel_spinner_item, null, 4, null);
        Spinner spinner = getBinding().f2417b;
        Intrinsics3.checkNotNullExpressionValue(spinner, "binding.guildInviteChannelSpinner");
        ChannelsSpinnerAdapter channelsSpinnerAdapter = this.channelsSpinnerAdapter;
        if (channelsSpinnerAdapter == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("channelsSpinnerAdapter");
        }
        spinner.setAdapter((SpinnerAdapter) channelsSpinnerAdapter);
        RadioGroup radioGroup = getBinding().c;
        Intrinsics3.checkNotNullExpressionValue(radioGroup, "binding.guildInviteExpiresAfterRadiogroup");
        int[] iArr = ModelInvite.Settings.EXPIRES_AFTER_ARRAY;
        Intrinsics3.checkNotNullExpressionValue(iArr, "ModelInvite.Settings.EXPIRES_AFTER_ARRAY");
        createHorizontalCheckableButtons(radioGroup, iArr, new AnonymousClass1());
        RadioGroup radioGroup2 = getBinding().e;
        Intrinsics3.checkNotNullExpressionValue(radioGroup2, "binding.guildInviteMaxUsesRadiogroup");
        int[] iArr2 = ModelInvite.Settings.MAX_USES_ARRAY;
        Intrinsics3.checkNotNullExpressionValue(iArr2, "ModelInvite.Settings.MAX_USES_ARRAY");
        createHorizontalCheckableButtons(radioGroup2, iArr2, new AnonymousClass2(this));
        setOnItemSelected();
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        Observable<GuildInviteSettingsViewModel.ViewState> observableR = getViewModel().observeViewState().r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "viewModel.observeViewSta…  .distinctUntilChanged()");
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.bindToComponentLifecycle$default(observableR, this, null, 2, null), (Class<?>) WidgetGuildInviteSettings.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass1());
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeEvents(), this, null, 2, null), (Class<?>) WidgetGuildInviteSettings.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass2());
    }
}
