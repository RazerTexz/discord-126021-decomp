package com.discord.widgets.guilds.invite;

import android.content.Context;
import android.util.AttributeSet;
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
import androidx.core.widget.NestedScrollView;
import b.a.i.d3;
import b.a.k.b;
import com.discord.R$layout;
import com.discord.api.channel.Channel;
import com.discord.databinding.ViewGuildInviteBottomSheetBinding;
import com.discord.models.domain.ModelInvite$Settings;
import com.discord.utilities.dimen.DimenUtils;
import com.discord.views.CheckedSetting;
import d0.d0.f;
import d0.t.c0;
import d0.t.o;
import d0.z.d.m;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.ranges.IntRange;

/* JADX INFO: compiled from: ViewInviteSettingsSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ViewInviteSettingsSheet extends NestedScrollView {
    private final ViewGuildInviteBottomSheetBinding binding;
    private final ViewInviteSettingsSheet$ChannelsSpinnerAdapter channelsSpinnerAdapter;
    private Function0<Unit> onGenerateLinkListener;
    private ModelInvite$Settings pendingInviteSettings;
    private Function1<? super ModelInvite$Settings, Unit> updateSettings;
    public WidgetGuildInviteShareViewModel viewModel;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ViewInviteSettingsSheet(Context context) {
        super(context);
        m.checkNotNullParameter(context, "ctx");
        ViewGuildInviteBottomSheetBinding viewGuildInviteBottomSheetBindingA = ViewGuildInviteBottomSheetBinding.a(LayoutInflater.from(getContext()), this);
        m.checkNotNullExpressionValue(viewGuildInviteBottomSheetBindingA, "ViewGuildInviteBottomShe…ater.from(context), this)");
        this.binding = viewGuildInviteBottomSheetBindingA;
        Context context2 = getContext();
        m.checkNotNullExpressionValue(context2, "context");
        ViewInviteSettingsSheet$ChannelsSpinnerAdapter viewInviteSettingsSheet$ChannelsSpinnerAdapter = new ViewInviteSettingsSheet$ChannelsSpinnerAdapter(context2, R$layout.view_invite_settings_channel_spinner_item, null, 4, null);
        this.channelsSpinnerAdapter = viewInviteSettingsSheet$ChannelsSpinnerAdapter;
        this.updateSettings = ViewInviteSettingsSheet$updateSettings$1.INSTANCE;
        this.onGenerateLinkListener = ViewInviteSettingsSheet$onGenerateLinkListener$1.INSTANCE;
        setFocusable(true);
        setContentDescription(b.j(this, 2131892325, new Object[0], null, 4));
        Spinner spinner = viewGuildInviteBottomSheetBindingA.f2190b;
        m.checkNotNullExpressionValue(spinner, "binding.guildInviteChannelSpinner");
        spinner.setAdapter((SpinnerAdapter) viewInviteSettingsSheet$ChannelsSpinnerAdapter);
        RadioGroup radioGroup = viewGuildInviteBottomSheetBindingA.c;
        m.checkNotNullExpressionValue(radioGroup, "binding.guildInviteExpiresAfterRadiogroup");
        int[] iArr = ModelInvite$Settings.EXPIRES_AFTER_ARRAY;
        m.checkNotNullExpressionValue(iArr, "ModelInvite.Settings.EXPIRES_AFTER_ARRAY");
        createHorizontalCheckableButtons(radioGroup, iArr, new ViewInviteSettingsSheet$1(this));
        RadioGroup radioGroup2 = viewGuildInviteBottomSheetBindingA.e;
        m.checkNotNullExpressionValue(radioGroup2, "binding.guildInviteMaxUsesRadiogroup");
        int[] iArr2 = ModelInvite$Settings.MAX_USES_ARRAY;
        m.checkNotNullExpressionValue(iArr2, "ModelInvite.Settings.MAX_USES_ARRAY");
        createHorizontalCheckableButtons(radioGroup2, iArr2, new ViewInviteSettingsSheet$2(this));
        setOnItemSelected();
    }

    public static final /* synthetic */ ViewGuildInviteBottomSheetBinding access$getBinding$p(ViewInviteSettingsSheet viewInviteSettingsSheet) {
        return viewInviteSettingsSheet.binding;
    }

    public static final /* synthetic */ ViewInviteSettingsSheet$ChannelsSpinnerAdapter access$getChannelsSpinnerAdapter$p(ViewInviteSettingsSheet viewInviteSettingsSheet) {
        return viewInviteSettingsSheet.channelsSpinnerAdapter;
    }

    public static final /* synthetic */ String access$getMaxUsesString(ViewInviteSettingsSheet viewInviteSettingsSheet, int i) {
        return viewInviteSettingsSheet.getMaxUsesString(i);
    }

    public static final /* synthetic */ ModelInvite$Settings access$getPendingInviteSettings$p(ViewInviteSettingsSheet viewInviteSettingsSheet) {
        return viewInviteSettingsSheet.pendingInviteSettings;
    }

    public static final /* synthetic */ void access$setPendingInviteSettings$p(ViewInviteSettingsSheet viewInviteSettingsSheet, ModelInvite$Settings modelInvite$Settings) {
        viewInviteSettingsSheet.pendingInviteSettings = modelInvite$Settings;
    }

    @MainThread
    private final void createHorizontalCheckableButtons(RadioGroup radioGroup, int[] valueSet, Function1<? super Integer, ? extends CharSequence> textFactory) {
        if (radioGroup.getChildCount() > 0) {
            return;
        }
        boolean z2 = false;
        for (int i : valueSet) {
            View viewInflate = LayoutInflater.from(getContext()).inflate(R$layout.view_radio_button, (ViewGroup) radioGroup, false);
            Objects.requireNonNull(viewInflate, "rootView");
            RadioButton radioButton = (RadioButton) viewInflate;
            m.checkNotNullExpressionValue(new d3(radioButton), "ViewRadioButtonBinding.i…text), radioGroup, false)");
            m.checkNotNullExpressionValue(radioButton, "binding.root");
            radioButton.setId(i);
            m.checkNotNullExpressionValue(radioButton, "binding.root");
            radioButton.setText(textFactory.invoke(Integer.valueOf(i)));
            if (!z2) {
                m.checkNotNullExpressionValue(radioButton, "binding.root");
                ViewGroup$LayoutParams layoutParams = radioButton.getLayoutParams();
                Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type android.widget.RadioGroup.LayoutParams");
                RadioGroup$LayoutParams radioGroup$LayoutParams = (RadioGroup$LayoutParams) layoutParams;
                radioGroup$LayoutParams.leftMargin = DimenUtils.dpToPixels(16);
                m.checkNotNullExpressionValue(radioButton, "binding.root");
                radioButton.setLayoutParams(radioGroup$LayoutParams);
                z2 = true;
            }
            radioGroup.addView(radioButton);
        }
    }

    private final String getMaxUsesString(int numUses) {
        return numUses != 0 ? String.valueOf(numUses) : "∞";
    }

    private final void setOnItemSelected() {
        Spinner spinner = this.binding.f2190b;
        m.checkNotNullExpressionValue(spinner, "binding.guildInviteChannelSpinner");
        spinner.setOnItemSelectedListener(new ViewInviteSettingsSheet$setOnItemSelected$1(this));
    }

    public final void configureUi(WidgetInviteModel data) {
        Object obj;
        Object next;
        int id2;
        ModelInvite$Settings modelInvite$Settings;
        m.checkNotNullParameter(data, "data");
        ViewInviteSettingsSheet$ChannelsSpinnerAdapter viewInviteSettingsSheet$ChannelsSpinnerAdapter = this.channelsSpinnerAdapter;
        Object[] array = data.getInvitableChannels().toArray(new Channel[0]);
        Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
        viewInviteSettingsSheet$ChannelsSpinnerAdapter.setData((Channel[]) array);
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
        this.binding.f2190b.setSelection(Math.max(i, 0), false);
        ModelInvite$Settings settings = data.getSettings();
        if (settings != null) {
            this.pendingInviteSettings = settings;
            RadioGroup radioGroup = this.binding.c;
            m.checkNotNullExpressionValue(radioGroup, "binding.guildInviteExpiresAfterRadiogroup");
            IntRange intRangeUntil = f.until(0, radioGroup.getChildCount());
            ArrayList arrayList = new ArrayList(o.collectionSizeOrDefault(intRangeUntil, 10));
            Iterator<Integer> it2 = intRangeUntil.iterator();
            while (it2.hasNext()) {
                View childAt = this.binding.c.getChildAt(((c0) it2).nextInt());
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
                    modelInvite$Settings = this.pendingInviteSettings;
                }
            } while (!(modelInvite$Settings != null && id2 == modelInvite$Settings.getMaxAge()));
            RadioButton radioButton = (RadioButton) next;
            if (radioButton != null) {
                radioButton.setChecked(true);
            }
            this.binding.c.setOnCheckedChangeListener(new ViewInviteSettingsSheet$configureUi$4(this));
            RadioGroup radioGroup2 = this.binding.e;
            m.checkNotNullExpressionValue(radioGroup2, "binding.guildInviteMaxUsesRadiogroup");
            IntRange intRangeUntil2 = f.until(0, radioGroup2.getChildCount());
            ArrayList arrayList2 = new ArrayList(o.collectionSizeOrDefault(intRangeUntil2, 10));
            Iterator<Integer> it4 = intRangeUntil2.iterator();
            while (it4.hasNext()) {
                View childAt2 = this.binding.e.getChildAt(((c0) it4).nextInt());
                Objects.requireNonNull(childAt2, "null cannot be cast to non-null type android.widget.RadioButton");
                arrayList2.add((RadioButton) childAt2);
            }
            for (Object obj2 : arrayList2) {
                int id3 = ((RadioButton) obj2).getId();
                ModelInvite$Settings modelInvite$Settings2 = this.pendingInviteSettings;
                if (modelInvite$Settings2 != null && id3 == modelInvite$Settings2.getMaxUses()) {
                    obj = obj2;
                    break;
                }
            }
            RadioButton radioButton2 = (RadioButton) obj;
            if (radioButton2 != null) {
                radioButton2.setChecked(true);
            }
            this.binding.e.setOnCheckedChangeListener(new ViewInviteSettingsSheet$configureUi$8(this));
            CheckedSetting checkedSetting = this.binding.f;
            m.checkNotNullExpressionValue(checkedSetting, "binding.guildInviteTemporaryMembership");
            ModelInvite$Settings modelInvite$Settings3 = this.pendingInviteSettings;
            checkedSetting.setChecked(modelInvite$Settings3 != null ? modelInvite$Settings3.isTemporary() : false);
            this.binding.f.e(new ViewInviteSettingsSheet$configureUi$9(this));
            this.binding.d.setOnClickListener(new ViewInviteSettingsSheet$configureUi$10(this, data));
        }
    }

    public final Function0<Unit> getOnGenerateLinkListener() {
        return this.onGenerateLinkListener;
    }

    public final WidgetGuildInviteShareViewModel getViewModel() {
        WidgetGuildInviteShareViewModel widgetGuildInviteShareViewModel = this.viewModel;
        if (widgetGuildInviteShareViewModel == null) {
            m.throwUninitializedPropertyAccessException("viewModel");
        }
        return widgetGuildInviteShareViewModel;
    }

    public final void setOnGenerateLinkListener(Function0<Unit> function0) {
        m.checkNotNullParameter(function0, "<set-?>");
        this.onGenerateLinkListener = function0;
    }

    public final void setViewModel(WidgetGuildInviteShareViewModel widgetGuildInviteShareViewModel) {
        m.checkNotNullParameter(widgetGuildInviteShareViewModel, "<set-?>");
        this.viewModel = widgetGuildInviteShareViewModel;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ViewInviteSettingsSheet(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m.checkNotNullParameter(context, "ctx");
        m.checkNotNullParameter(attributeSet, "attrSet");
        ViewGuildInviteBottomSheetBinding viewGuildInviteBottomSheetBindingA = ViewGuildInviteBottomSheetBinding.a(LayoutInflater.from(getContext()), this);
        m.checkNotNullExpressionValue(viewGuildInviteBottomSheetBindingA, "ViewGuildInviteBottomShe…ater.from(context), this)");
        this.binding = viewGuildInviteBottomSheetBindingA;
        Context context2 = getContext();
        m.checkNotNullExpressionValue(context2, "context");
        ViewInviteSettingsSheet$ChannelsSpinnerAdapter viewInviteSettingsSheet$ChannelsSpinnerAdapter = new ViewInviteSettingsSheet$ChannelsSpinnerAdapter(context2, R$layout.view_invite_settings_channel_spinner_item, null, 4, null);
        this.channelsSpinnerAdapter = viewInviteSettingsSheet$ChannelsSpinnerAdapter;
        this.updateSettings = ViewInviteSettingsSheet$updateSettings$1.INSTANCE;
        this.onGenerateLinkListener = ViewInviteSettingsSheet$onGenerateLinkListener$1.INSTANCE;
        setFocusable(true);
        setContentDescription(b.j(this, 2131892325, new Object[0], null, 4));
        Spinner spinner = viewGuildInviteBottomSheetBindingA.f2190b;
        m.checkNotNullExpressionValue(spinner, "binding.guildInviteChannelSpinner");
        spinner.setAdapter((SpinnerAdapter) viewInviteSettingsSheet$ChannelsSpinnerAdapter);
        RadioGroup radioGroup = viewGuildInviteBottomSheetBindingA.c;
        m.checkNotNullExpressionValue(radioGroup, "binding.guildInviteExpiresAfterRadiogroup");
        int[] iArr = ModelInvite$Settings.EXPIRES_AFTER_ARRAY;
        m.checkNotNullExpressionValue(iArr, "ModelInvite.Settings.EXPIRES_AFTER_ARRAY");
        createHorizontalCheckableButtons(radioGroup, iArr, new ViewInviteSettingsSheet$1(this));
        RadioGroup radioGroup2 = viewGuildInviteBottomSheetBindingA.e;
        m.checkNotNullExpressionValue(radioGroup2, "binding.guildInviteMaxUsesRadiogroup");
        int[] iArr2 = ModelInvite$Settings.MAX_USES_ARRAY;
        m.checkNotNullExpressionValue(iArr2, "ModelInvite.Settings.MAX_USES_ARRAY");
        createHorizontalCheckableButtons(radioGroup2, iArr2, new ViewInviteSettingsSheet$2(this));
        setOnItemSelected();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ViewInviteSettingsSheet(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m.checkNotNullParameter(context, "ctx");
        m.checkNotNullParameter(attributeSet, "attrSet");
        ViewGuildInviteBottomSheetBinding viewGuildInviteBottomSheetBindingA = ViewGuildInviteBottomSheetBinding.a(LayoutInflater.from(getContext()), this);
        m.checkNotNullExpressionValue(viewGuildInviteBottomSheetBindingA, "ViewGuildInviteBottomShe…ater.from(context), this)");
        this.binding = viewGuildInviteBottomSheetBindingA;
        Context context2 = getContext();
        m.checkNotNullExpressionValue(context2, "context");
        ViewInviteSettingsSheet$ChannelsSpinnerAdapter viewInviteSettingsSheet$ChannelsSpinnerAdapter = new ViewInviteSettingsSheet$ChannelsSpinnerAdapter(context2, R$layout.view_invite_settings_channel_spinner_item, null, 4, null);
        this.channelsSpinnerAdapter = viewInviteSettingsSheet$ChannelsSpinnerAdapter;
        this.updateSettings = ViewInviteSettingsSheet$updateSettings$1.INSTANCE;
        this.onGenerateLinkListener = ViewInviteSettingsSheet$onGenerateLinkListener$1.INSTANCE;
        setFocusable(true);
        setContentDescription(b.j(this, 2131892325, new Object[0], null, 4));
        Spinner spinner = viewGuildInviteBottomSheetBindingA.f2190b;
        m.checkNotNullExpressionValue(spinner, "binding.guildInviteChannelSpinner");
        spinner.setAdapter((SpinnerAdapter) viewInviteSettingsSheet$ChannelsSpinnerAdapter);
        RadioGroup radioGroup = viewGuildInviteBottomSheetBindingA.c;
        m.checkNotNullExpressionValue(radioGroup, "binding.guildInviteExpiresAfterRadiogroup");
        int[] iArr = ModelInvite$Settings.EXPIRES_AFTER_ARRAY;
        m.checkNotNullExpressionValue(iArr, "ModelInvite.Settings.EXPIRES_AFTER_ARRAY");
        createHorizontalCheckableButtons(radioGroup, iArr, new ViewInviteSettingsSheet$1(this));
        RadioGroup radioGroup2 = viewGuildInviteBottomSheetBindingA.e;
        m.checkNotNullExpressionValue(radioGroup2, "binding.guildInviteMaxUsesRadiogroup");
        int[] iArr2 = ModelInvite$Settings.MAX_USES_ARRAY;
        m.checkNotNullExpressionValue(iArr2, "ModelInvite.Settings.MAX_USES_ARRAY");
        createHorizontalCheckableButtons(radioGroup2, iArr2, new ViewInviteSettingsSheet$2(this));
        setOnItemSelected();
    }
}
