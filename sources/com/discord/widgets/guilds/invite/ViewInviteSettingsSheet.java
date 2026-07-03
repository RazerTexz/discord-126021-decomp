package com.discord.widgets.guilds.invite;

import android.content.Context;
import android.util.AttributeSet;
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
import androidx.annotation.MainThread;
import androidx.core.widget.NestedScrollView;
import com.discord.C5419R;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.databinding.ViewGuildInviteBottomSheetBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.domain.ModelInvite;
import com.discord.utilities.dimen.DimenUtils;
import com.discord.utilities.resources.DurationUtilsKt;
import com.discord.views.CheckedSetting;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Objects;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.ranges.IntRange;
import p007b.p008a.p025i.C0939d3;
import p007b.p008a.p027k.C1107b;
import p507d0.p512d0.C11226f;
import p507d0.p580t.AbstractC12126c0;
import p507d0.p580t.C12149o;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12236k;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: ViewInviteSettingsSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ViewInviteSettingsSheet extends NestedScrollView {
    private final ViewGuildInviteBottomSheetBinding binding;
    private final ChannelsSpinnerAdapter channelsSpinnerAdapter;
    private Function0<Unit> onGenerateLinkListener;
    private ModelInvite.Settings pendingInviteSettings;
    private Function1<? super ModelInvite.Settings, Unit> updateSettings;
    public WidgetGuildInviteShareViewModel viewModel;

    /* JADX INFO: renamed from: com.discord.widgets.guilds.invite.ViewInviteSettingsSheet$1 */
    /* JADX INFO: compiled from: ViewInviteSettingsSheet.kt */
    public static final class C86391 extends AbstractC12240o implements Function1<Integer, CharSequence> {
        public C86391() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ CharSequence invoke(Integer num) {
            return invoke(num.intValue());
        }

        public final CharSequence invoke(int i) {
            Context context = ViewInviteSettingsSheet.this.getContext();
            C12238m.checkNotNullExpressionValue(context, "context");
            return DurationUtilsKt.formatInviteExpireAfterString(context, i);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.guilds.invite.ViewInviteSettingsSheet$2 */
    /* JADX INFO: compiled from: ViewInviteSettingsSheet.kt */
    public static final /* synthetic */ class C86402 extends C12236k implements Function1<Integer, String> {
        public C86402(ViewInviteSettingsSheet viewInviteSettingsSheet) {
            super(1, viewInviteSettingsSheet, ViewInviteSettingsSheet.class, "getMaxUsesString", "getMaxUsesString(I)Ljava/lang/String;", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ String invoke(Integer num) {
            return invoke(num.intValue());
        }

        public final String invoke(int i) {
            return ((ViewInviteSettingsSheet) this.receiver).getMaxUsesString(i);
        }
    }

    /* JADX INFO: compiled from: ViewInviteSettingsSheet.kt */
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
            TextView textView = (TextView) convertView.findViewById(new ViewInviteSettingsSheet$ChannelsSpinnerAdapter$setupViews$1(dropDownMode).invoke2());
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

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ViewInviteSettingsSheet(Context context) {
        super(context);
        C12238m.checkNotNullParameter(context, "ctx");
        ViewGuildInviteBottomSheetBinding viewGuildInviteBottomSheetBindingM8395a = ViewGuildInviteBottomSheetBinding.m8395a(LayoutInflater.from(getContext()), this);
        C12238m.checkNotNullExpressionValue(viewGuildInviteBottomSheetBindingM8395a, "ViewGuildInviteBottomShe…ater.from(context), this)");
        this.binding = viewGuildInviteBottomSheetBindingM8395a;
        Context context2 = getContext();
        C12238m.checkNotNullExpressionValue(context2, "context");
        ChannelsSpinnerAdapter channelsSpinnerAdapter = new ChannelsSpinnerAdapter(context2, C5419R.layout.view_invite_settings_channel_spinner_item, null, 4, null);
        this.channelsSpinnerAdapter = channelsSpinnerAdapter;
        this.updateSettings = ViewInviteSettingsSheet$updateSettings$1.INSTANCE;
        this.onGenerateLinkListener = ViewInviteSettingsSheet$onGenerateLinkListener$1.INSTANCE;
        setFocusable(true);
        setContentDescription(C1107b.m212d(this, C5419R.string.invite_settings_title, new Object[0], (4 & 4) != 0 ? C1107b.c.f1492j : null));
        Spinner spinner = viewGuildInviteBottomSheetBindingM8395a.f15453b;
        C12238m.checkNotNullExpressionValue(spinner, "binding.guildInviteChannelSpinner");
        spinner.setAdapter((SpinnerAdapter) channelsSpinnerAdapter);
        RadioGroup radioGroup = viewGuildInviteBottomSheetBindingM8395a.f15454c;
        C12238m.checkNotNullExpressionValue(radioGroup, "binding.guildInviteExpiresAfterRadiogroup");
        int[] iArr = ModelInvite.Settings.EXPIRES_AFTER_ARRAY;
        C12238m.checkNotNullExpressionValue(iArr, "ModelInvite.Settings.EXPIRES_AFTER_ARRAY");
        createHorizontalCheckableButtons(radioGroup, iArr, new C86391());
        RadioGroup radioGroup2 = viewGuildInviteBottomSheetBindingM8395a.f15456e;
        C12238m.checkNotNullExpressionValue(radioGroup2, "binding.guildInviteMaxUsesRadiogroup");
        int[] iArr2 = ModelInvite.Settings.MAX_USES_ARRAY;
        C12238m.checkNotNullExpressionValue(iArr2, "ModelInvite.Settings.MAX_USES_ARRAY");
        createHorizontalCheckableButtons(radioGroup2, iArr2, new C86402(this));
        setOnItemSelected();
    }

    @MainThread
    private final void createHorizontalCheckableButtons(RadioGroup radioGroup, int[] valueSet, Function1<? super Integer, ? extends CharSequence> textFactory) {
        if (radioGroup.getChildCount() > 0) {
            return;
        }
        boolean z2 = false;
        for (int i : valueSet) {
            View viewInflate = LayoutInflater.from(getContext()).inflate(C5419R.layout.view_radio_button, (ViewGroup) radioGroup, false);
            Objects.requireNonNull(viewInflate, "rootView");
            RadioButton radioButton = (RadioButton) viewInflate;
            C12238m.checkNotNullExpressionValue(new C0939d3(radioButton), "ViewRadioButtonBinding.i…text), radioGroup, false)");
            C12238m.checkNotNullExpressionValue(radioButton, "binding.root");
            radioButton.setId(i);
            C12238m.checkNotNullExpressionValue(radioButton, "binding.root");
            radioButton.setText(textFactory.invoke(Integer.valueOf(i)));
            if (!z2) {
                C12238m.checkNotNullExpressionValue(radioButton, "binding.root");
                ViewGroup.LayoutParams layoutParams = radioButton.getLayoutParams();
                Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type android.widget.RadioGroup.LayoutParams");
                RadioGroup.LayoutParams layoutParams2 = (RadioGroup.LayoutParams) layoutParams;
                layoutParams2.leftMargin = DimenUtils.dpToPixels(16);
                C12238m.checkNotNullExpressionValue(radioButton, "binding.root");
                radioButton.setLayoutParams(layoutParams2);
                z2 = true;
            }
            radioGroup.addView(radioButton);
        }
    }

    private final String getMaxUsesString(int numUses) {
        return numUses != 0 ? String.valueOf(numUses) : "∞";
    }

    private final void setOnItemSelected() {
        Spinner spinner = this.binding.f15453b;
        C12238m.checkNotNullExpressionValue(spinner, "binding.guildInviteChannelSpinner");
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { // from class: com.discord.widgets.guilds.invite.ViewInviteSettingsSheet.setOnItemSelected.1
            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id2) {
                C12238m.checkNotNullParameter(parent, "parent");
                C12238m.checkNotNullParameter(view, "view");
                ViewInviteSettingsSheet.this.getViewModel().selectChannel(ViewInviteSettingsSheet.this.channelsSpinnerAdapter.getItem(position).getId());
            }

            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onNothingSelected(AdapterView<?> parent) {
                C12238m.checkNotNullParameter(parent, "parent");
            }
        });
    }

    public final void configureUi(final WidgetInviteModel data) {
        Object obj;
        Object next;
        int id2;
        ModelInvite.Settings settings;
        C12238m.checkNotNullParameter(data, "data");
        ChannelsSpinnerAdapter channelsSpinnerAdapter = this.channelsSpinnerAdapter;
        Object[] array = data.getInvitableChannels().toArray(new Channel[0]);
        Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
        channelsSpinnerAdapter.setData((Channel[]) array);
        Iterator<Channel> it = data.getInvitableChannels().iterator();
        int i = 0;
        while (true) {
            if (!it.hasNext()) {
                i = -1;
                break;
            }
            Channel next2 = it.next();
            Channel targetChannel = data.getTargetChannel();
            if (targetChannel != null && targetChannel.getId() == next2.getId()) {
                break;
            } else {
                i++;
            }
        }
        this.binding.f15453b.setSelection(Math.max(i, 0), false);
        ModelInvite.Settings settings2 = data.getSettings();
        if (settings2 != null) {
            this.pendingInviteSettings = settings2;
            RadioGroup radioGroup = this.binding.f15454c;
            C12238m.checkNotNullExpressionValue(radioGroup, "binding.guildInviteExpiresAfterRadiogroup");
            IntRange intRangeUntil = C11226f.until(0, radioGroup.getChildCount());
            ArrayList arrayList = new ArrayList(C12149o.collectionSizeOrDefault(intRangeUntil, 10));
            Iterator<Integer> it2 = intRangeUntil.iterator();
            while (it2.hasNext()) {
                View childAt = this.binding.f15454c.getChildAt(((AbstractC12126c0) it2).nextInt());
                Objects.requireNonNull(childAt, "null cannot be cast to non-null type android.widget.RadioButton");
                arrayList.add((RadioButton) childAt);
            }
            Iterator it3 = arrayList.iterator();
            do {
                obj = null;
                if (!it3.hasNext()) {
                    next = null;
                    break;
                } else {
                    next = it3.next();
                    id2 = ((RadioButton) next).getId();
                    settings = this.pendingInviteSettings;
                }
            } while (!(settings != null && id2 == settings.getMaxAge()));
            RadioButton radioButton = (RadioButton) next;
            if (radioButton != null) {
                radioButton.setChecked(true);
            }
            this.binding.f15454c.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() { // from class: com.discord.widgets.guilds.invite.ViewInviteSettingsSheet.configureUi.4
                @Override // android.widget.RadioGroup.OnCheckedChangeListener
                public final void onCheckedChanged(RadioGroup radioGroup2, int i2) {
                    ViewInviteSettingsSheet viewInviteSettingsSheet = ViewInviteSettingsSheet.this;
                    ModelInvite.Settings settings3 = viewInviteSettingsSheet.pendingInviteSettings;
                    viewInviteSettingsSheet.pendingInviteSettings = settings3 != null ? settings3.mergeMaxAge(i2) : null;
                }
            });
            RadioGroup radioGroup2 = this.binding.f15456e;
            C12238m.checkNotNullExpressionValue(radioGroup2, "binding.guildInviteMaxUsesRadiogroup");
            IntRange intRangeUntil2 = C11226f.until(0, radioGroup2.getChildCount());
            ArrayList arrayList2 = new ArrayList(C12149o.collectionSizeOrDefault(intRangeUntil2, 10));
            Iterator<Integer> it4 = intRangeUntil2.iterator();
            while (it4.hasNext()) {
                View childAt2 = this.binding.f15456e.getChildAt(((AbstractC12126c0) it4).nextInt());
                Objects.requireNonNull(childAt2, "null cannot be cast to non-null type android.widget.RadioButton");
                arrayList2.add((RadioButton) childAt2);
            }
            for (Object obj2 : arrayList2) {
                int id3 = ((RadioButton) obj2).getId();
                ModelInvite.Settings settings3 = this.pendingInviteSettings;
                if (settings3 != null && id3 == settings3.getMaxUses()) {
                    obj = obj2;
                    break;
                }
            }
            RadioButton radioButton2 = (RadioButton) obj;
            if (radioButton2 != null) {
                radioButton2.setChecked(true);
            }
            this.binding.f15456e.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() { // from class: com.discord.widgets.guilds.invite.ViewInviteSettingsSheet.configureUi.8
                @Override // android.widget.RadioGroup.OnCheckedChangeListener
                public final void onCheckedChanged(RadioGroup radioGroup3, int i2) {
                    ViewInviteSettingsSheet viewInviteSettingsSheet = ViewInviteSettingsSheet.this;
                    ModelInvite.Settings settings4 = viewInviteSettingsSheet.pendingInviteSettings;
                    viewInviteSettingsSheet.pendingInviteSettings = settings4 != null ? settings4.mergeMaxUses(i2) : null;
                }
            });
            CheckedSetting checkedSetting = this.binding.f15457f;
            C12238m.checkNotNullExpressionValue(checkedSetting, "binding.guildInviteTemporaryMembership");
            ModelInvite.Settings settings4 = this.pendingInviteSettings;
            checkedSetting.setChecked(settings4 != null ? settings4.isTemporary() : false);
            this.binding.f15457f.m8527e(new View.OnClickListener() { // from class: com.discord.widgets.guilds.invite.ViewInviteSettingsSheet.configureUi.9
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ModelInvite.Settings settingsMergeTemporary;
                    ViewInviteSettingsSheet.this.binding.f15457f.toggle();
                    ViewInviteSettingsSheet viewInviteSettingsSheet = ViewInviteSettingsSheet.this;
                    ModelInvite.Settings settings5 = viewInviteSettingsSheet.pendingInviteSettings;
                    if (settings5 != null) {
                        CheckedSetting checkedSetting2 = ViewInviteSettingsSheet.this.binding.f15457f;
                        C12238m.checkNotNullExpressionValue(checkedSetting2, "binding.guildInviteTemporaryMembership");
                        settingsMergeTemporary = settings5.mergeTemporary(checkedSetting2.isChecked());
                    } else {
                        settingsMergeTemporary = null;
                    }
                    viewInviteSettingsSheet.pendingInviteSettings = settingsMergeTemporary;
                }
            });
            this.binding.f15455d.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.guilds.invite.ViewInviteSettingsSheet.configureUi.10
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ModelInvite.Settings settings5 = ViewInviteSettingsSheet.this.pendingInviteSettings;
                    if (settings5 != null) {
                        ViewInviteSettingsSheet.this.getViewModel().updateInviteSettings(settings5);
                    }
                    Channel targetChannel2 = data.getTargetChannel();
                    if (targetChannel2 != null) {
                        ViewInviteSettingsSheet.this.getViewModel().generateInviteLink(Long.valueOf(targetChannel2.getId()).longValue());
                    }
                    ViewInviteSettingsSheet.this.getOnGenerateLinkListener().invoke();
                }
            });
        }
    }

    public final Function0<Unit> getOnGenerateLinkListener() {
        return this.onGenerateLinkListener;
    }

    public final WidgetGuildInviteShareViewModel getViewModel() {
        WidgetGuildInviteShareViewModel widgetGuildInviteShareViewModel = this.viewModel;
        if (widgetGuildInviteShareViewModel == null) {
            C12238m.throwUninitializedPropertyAccessException("viewModel");
        }
        return widgetGuildInviteShareViewModel;
    }

    public final void setOnGenerateLinkListener(Function0<Unit> function0) {
        C12238m.checkNotNullParameter(function0, "<set-?>");
        this.onGenerateLinkListener = function0;
    }

    public final void setViewModel(WidgetGuildInviteShareViewModel widgetGuildInviteShareViewModel) {
        C12238m.checkNotNullParameter(widgetGuildInviteShareViewModel, "<set-?>");
        this.viewModel = widgetGuildInviteShareViewModel;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ViewInviteSettingsSheet(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        C12238m.checkNotNullParameter(context, "ctx");
        C12238m.checkNotNullParameter(attributeSet, "attrSet");
        ViewGuildInviteBottomSheetBinding viewGuildInviteBottomSheetBindingM8395a = ViewGuildInviteBottomSheetBinding.m8395a(LayoutInflater.from(getContext()), this);
        C12238m.checkNotNullExpressionValue(viewGuildInviteBottomSheetBindingM8395a, "ViewGuildInviteBottomShe…ater.from(context), this)");
        this.binding = viewGuildInviteBottomSheetBindingM8395a;
        Context context2 = getContext();
        C12238m.checkNotNullExpressionValue(context2, "context");
        ChannelsSpinnerAdapter channelsSpinnerAdapter = new ChannelsSpinnerAdapter(context2, C5419R.layout.view_invite_settings_channel_spinner_item, null, 4, null);
        this.channelsSpinnerAdapter = channelsSpinnerAdapter;
        this.updateSettings = ViewInviteSettingsSheet$updateSettings$1.INSTANCE;
        this.onGenerateLinkListener = ViewInviteSettingsSheet$onGenerateLinkListener$1.INSTANCE;
        setFocusable(true);
        setContentDescription(C1107b.m212d(this, C5419R.string.invite_settings_title, new Object[0], (4 & 4) != 0 ? C1107b.c.f1492j : null));
        Spinner spinner = viewGuildInviteBottomSheetBindingM8395a.f15453b;
        C12238m.checkNotNullExpressionValue(spinner, "binding.guildInviteChannelSpinner");
        spinner.setAdapter((SpinnerAdapter) channelsSpinnerAdapter);
        RadioGroup radioGroup = viewGuildInviteBottomSheetBindingM8395a.f15454c;
        C12238m.checkNotNullExpressionValue(radioGroup, "binding.guildInviteExpiresAfterRadiogroup");
        int[] iArr = ModelInvite.Settings.EXPIRES_AFTER_ARRAY;
        C12238m.checkNotNullExpressionValue(iArr, "ModelInvite.Settings.EXPIRES_AFTER_ARRAY");
        createHorizontalCheckableButtons(radioGroup, iArr, new C86391());
        RadioGroup radioGroup2 = viewGuildInviteBottomSheetBindingM8395a.f15456e;
        C12238m.checkNotNullExpressionValue(radioGroup2, "binding.guildInviteMaxUsesRadiogroup");
        int[] iArr2 = ModelInvite.Settings.MAX_USES_ARRAY;
        C12238m.checkNotNullExpressionValue(iArr2, "ModelInvite.Settings.MAX_USES_ARRAY");
        createHorizontalCheckableButtons(radioGroup2, iArr2, new C86402(this));
        setOnItemSelected();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ViewInviteSettingsSheet(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        C12238m.checkNotNullParameter(context, "ctx");
        C12238m.checkNotNullParameter(attributeSet, "attrSet");
        ViewGuildInviteBottomSheetBinding viewGuildInviteBottomSheetBindingM8395a = ViewGuildInviteBottomSheetBinding.m8395a(LayoutInflater.from(getContext()), this);
        C12238m.checkNotNullExpressionValue(viewGuildInviteBottomSheetBindingM8395a, "ViewGuildInviteBottomShe…ater.from(context), this)");
        this.binding = viewGuildInviteBottomSheetBindingM8395a;
        Context context2 = getContext();
        C12238m.checkNotNullExpressionValue(context2, "context");
        ChannelsSpinnerAdapter channelsSpinnerAdapter = new ChannelsSpinnerAdapter(context2, C5419R.layout.view_invite_settings_channel_spinner_item, null, 4, null);
        this.channelsSpinnerAdapter = channelsSpinnerAdapter;
        this.updateSettings = ViewInviteSettingsSheet$updateSettings$1.INSTANCE;
        this.onGenerateLinkListener = ViewInviteSettingsSheet$onGenerateLinkListener$1.INSTANCE;
        setFocusable(true);
        setContentDescription(C1107b.m212d(this, C5419R.string.invite_settings_title, new Object[0], (4 & 4) != 0 ? C1107b.c.f1492j : null));
        Spinner spinner = viewGuildInviteBottomSheetBindingM8395a.f15453b;
        C12238m.checkNotNullExpressionValue(spinner, "binding.guildInviteChannelSpinner");
        spinner.setAdapter((SpinnerAdapter) channelsSpinnerAdapter);
        RadioGroup radioGroup = viewGuildInviteBottomSheetBindingM8395a.f15454c;
        C12238m.checkNotNullExpressionValue(radioGroup, "binding.guildInviteExpiresAfterRadiogroup");
        int[] iArr = ModelInvite.Settings.EXPIRES_AFTER_ARRAY;
        C12238m.checkNotNullExpressionValue(iArr, "ModelInvite.Settings.EXPIRES_AFTER_ARRAY");
        createHorizontalCheckableButtons(radioGroup, iArr, new C86391());
        RadioGroup radioGroup2 = viewGuildInviteBottomSheetBindingM8395a.f15456e;
        C12238m.checkNotNullExpressionValue(radioGroup2, "binding.guildInviteMaxUsesRadiogroup");
        int[] iArr2 = ModelInvite.Settings.MAX_USES_ARRAY;
        C12238m.checkNotNullExpressionValue(iArr2, "ModelInvite.Settings.MAX_USES_ARRAY");
        createHorizontalCheckableButtons(radioGroup2, iArr2, new C86402(this));
        setOnItemSelected();
    }
}
