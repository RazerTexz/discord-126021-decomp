package com.discord.widgets.guilds;

import android.content.Context;
import android.graphics.Color;
import android.graphics.PorterDuff$Mode;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.Selection;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import b.a.d.g0;
import b.a.d.i0;
import b.d.b.a.a;
import com.discord.R$array;
import com.discord.R$layout;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetGuildFolderSettingsBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.font.FontUtils;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.discord.widgets.chat.input.MentionUtilsKt;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputLayout;
import com.jaredrummler.android.colorpicker.ColorPickerDialog;
import com.jaredrummler.android.colorpicker.ColorPickerDialog$k;
import d0.z.d.a0;
import d0.z.d.m;
import f0.e0.c;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Objects;
import kotlin.Lazy;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.KProperty;
import rx.Observable;

/* JADX INFO: compiled from: WidgetGuildFolderSettings.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildFolderSettings extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {a.d0(WidgetGuildFolderSettings.class, "binding", "getBinding()Lcom/discord/databinding/WidgetGuildFolderSettingsBinding;", 0)};
    public static final WidgetGuildFolderSettings$Companion Companion = new WidgetGuildFolderSettings$Companion(null);
    private static final String DIALOG_TAG_COLOR_PICKER = "DIALOG_TAG_COLOR_PICKER";

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* JADX INFO: renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    public WidgetGuildFolderSettings() {
        super(R$layout.widget_guild_folder_settings);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetGuildFolderSettings$binding$2.INSTANCE, null, 2, null);
        WidgetGuildFolderSettings$viewModel$2 widgetGuildFolderSettings$viewModel$2 = new WidgetGuildFolderSettings$viewModel$2(this);
        g0 g0Var = new g0(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, a0.getOrCreateKotlinClass(WidgetGuildFolderSettingsViewModel.class), new WidgetGuildFolderSettings$appViewModels$$inlined$viewModels$1(g0Var), new i0(widgetGuildFolderSettings$viewModel$2));
    }

    public static final /* synthetic */ int access$argbColorToRGB(WidgetGuildFolderSettings widgetGuildFolderSettings, int i) {
        return widgetGuildFolderSettings.argbColorToRGB(i);
    }

    public static final /* synthetic */ void access$configureUI(WidgetGuildFolderSettings widgetGuildFolderSettings, WidgetGuildFolderSettingsViewModel$ViewState widgetGuildFolderSettingsViewModel$ViewState) {
        widgetGuildFolderSettings.configureUI(widgetGuildFolderSettingsViewModel$ViewState);
    }

    public static final /* synthetic */ WidgetGuildFolderSettingsViewModel access$getViewModel$p(WidgetGuildFolderSettings widgetGuildFolderSettings) {
        return widgetGuildFolderSettings.getViewModel();
    }

    public static final /* synthetic */ void access$handleEvent(WidgetGuildFolderSettings widgetGuildFolderSettings, WidgetGuildFolderSettingsViewModel$Event widgetGuildFolderSettingsViewModel$Event) {
        widgetGuildFolderSettings.handleEvent(widgetGuildFolderSettingsViewModel$Event);
    }

    public static final /* synthetic */ void access$launchColorPicker(WidgetGuildFolderSettings widgetGuildFolderSettings, WidgetGuildFolderSettingsViewModel$ViewState$Loaded widgetGuildFolderSettingsViewModel$ViewState$Loaded) {
        widgetGuildFolderSettings.launchColorPicker(widgetGuildFolderSettingsViewModel$ViewState$Loaded);
    }

    private final int argbColorToRGB(int color) {
        return Color.argb(0, Color.red(color), Color.green(color), Color.blue(color));
    }

    private final void configureUI(WidgetGuildFolderSettingsViewModel$ViewState state) {
        int themedColor;
        if (state instanceof WidgetGuildFolderSettingsViewModel$ViewState$Loaded) {
            View view = getBinding().e;
            m.checkNotNullExpressionValue(view, "binding.guildFolderSettingsColorDisplay");
            Drawable drawable = ContextCompat.getDrawable(view.getContext(), 2131231192);
            WidgetGuildFolderSettingsViewModel$ViewState$Loaded widgetGuildFolderSettingsViewModel$ViewState$Loaded = (WidgetGuildFolderSettingsViewModel$ViewState$Loaded) state;
            Integer numRgbColorToARGB = rgbColorToARGB(widgetGuildFolderSettingsViewModel$ViewState$Loaded.getFormState().getColor());
            if (numRgbColorToARGB != null) {
                themedColor = numRgbColorToARGB.intValue();
            } else {
                View view2 = getBinding().e;
                m.checkNotNullExpressionValue(view2, "binding.guildFolderSettingsColorDisplay");
                themedColor = ColorCompat.getThemedColor(view2, 2130969062);
            }
            if (drawable != null) {
                drawable.setColorFilter(new PorterDuffColorFilter(themedColor, PorterDuff$Mode.SRC_ATOP));
                View view3 = getBinding().e;
                m.checkNotNullExpressionValue(view3, "binding.guildFolderSettingsColorDisplay");
                view3.setBackground(drawable);
            }
            TextInputLayout textInputLayout = getBinding().f2413b;
            m.checkNotNullExpressionValue(textInputLayout, "binding.editGuildFolderName");
            ViewExtensions.addBindedTextWatcher(textInputLayout, this, new WidgetGuildFolderSettings$configureUI$1(this));
            TextInputLayout textInputLayout2 = getBinding().f2413b;
            m.checkNotNullExpressionValue(textInputLayout2, "binding.editGuildFolderName");
            String textOrEmpty = ViewExtensions.getTextOrEmpty(textInputLayout2);
            if (!m.areEqual(widgetGuildFolderSettingsViewModel$ViewState$Loaded.getFormState().getName(), textOrEmpty)) {
                TextInputLayout textInputLayout3 = getBinding().f2413b;
                m.checkNotNullExpressionValue(textInputLayout3, "binding.editGuildFolderName");
                ViewExtensions.setText(textInputLayout3, widgetGuildFolderSettingsViewModel$ViewState$Loaded.getFormState().getName());
                if (textOrEmpty.length() == 0) {
                    TextInputLayout textInputLayout4 = getBinding().f2413b;
                    m.checkNotNullExpressionValue(textInputLayout4, "binding.editGuildFolderName");
                    EditText editText = textInputLayout4.getEditText();
                    Editable text = editText != null ? editText.getText() : null;
                    TextInputLayout textInputLayout5 = getBinding().f2413b;
                    m.checkNotNullExpressionValue(textInputLayout5, "binding.editGuildFolderName");
                    Selection.setSelection(text, ViewExtensions.getTextOrEmpty(textInputLayout5).length());
                }
            }
            TextView textView = getBinding().c;
            m.checkNotNullExpressionValue(textView, "binding.guildFolderColorName");
            StringBuilder sb = new StringBuilder();
            sb.append(MentionUtilsKt.CHANNELS_CHAR);
            String strX = c.x(themedColor);
            Objects.requireNonNull(strX, "null cannot be cast to non-null type java.lang.String");
            String strSubstring = strX.substring(2);
            m.checkNotNullExpressionValue(strSubstring, "(this as java.lang.String).substring(startIndex)");
            Locale locale = Locale.ROOT;
            m.checkNotNullExpressionValue(locale, "Locale.ROOT");
            Objects.requireNonNull(strSubstring, "null cannot be cast to non-null type java.lang.String");
            String upperCase = strSubstring.toUpperCase(locale);
            m.checkNotNullExpressionValue(upperCase, "(this as java.lang.String).toUpperCase(locale)");
            sb.append(upperCase);
            textView.setText(sb.toString());
            getBinding().d.setOnClickListener(new WidgetGuildFolderSettings$configureUI$2(this, state));
            FloatingActionButton floatingActionButton = getBinding().f;
            m.checkNotNullExpressionValue(floatingActionButton, "binding.guildFolderSettingsSave");
            floatingActionButton.setVisibility(widgetGuildFolderSettingsViewModel$ViewState$Loaded.getShowSave() ? 0 : 8);
            getBinding().f.setOnClickListener(new WidgetGuildFolderSettings$configureUI$3(this));
        }
    }

    private final WidgetGuildFolderSettingsBinding getBinding() {
        return (WidgetGuildFolderSettingsBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    @ColorInt
    private final int[] getColorsToDisplay(@ColorInt int currentColor) {
        int[] intArray = getResources().getIntArray(R$array.color_picker_palette);
        m.checkNotNullExpressionValue(intArray, "resources.getIntArray(R.…ray.color_picker_palette)");
        ArrayList arrayList = new ArrayList();
        boolean z2 = false;
        for (int i : intArray) {
            arrayList.add(Integer.valueOf(i));
            if (i == currentColor) {
                z2 = true;
            }
        }
        if (!z2) {
            arrayList.add(Integer.valueOf(currentColor));
        }
        int[] iArr = new int[arrayList.size()];
        int size = arrayList.size();
        for (int i2 = 0; i2 < size; i2++) {
            iArr[i2] = ((Number) arrayList.get(i2)).intValue();
        }
        return iArr;
    }

    private final WidgetGuildFolderSettingsViewModel getViewModel() {
        return (WidgetGuildFolderSettingsViewModel) this.viewModel.getValue();
    }

    private final void handleEvent(WidgetGuildFolderSettingsViewModel$Event event) {
        if (!(event instanceof WidgetGuildFolderSettingsViewModel$Event$UpdateFolderSettingsSuccess)) {
            if (event instanceof WidgetGuildFolderSettingsViewModel$Event$UpdateFolderSettingsFailure) {
                b.a.d.m.g(getContext(), ((WidgetGuildFolderSettingsViewModel$Event$UpdateFolderSettingsFailure) event).getFailureMessageStringRes(), 0, null, 12);
            }
        } else {
            b.a.d.m.i(this, ((WidgetGuildFolderSettingsViewModel$Event$UpdateFolderSettingsSuccess) event).getSuccessMessageStringRes(), 0, 4);
            AppFragment.hideKeyboard$default(this, null, 1, null);
            FragmentActivity activity = getActivity();
            if (activity != null) {
                activity.onBackPressed();
            }
        }
    }

    private final void launchColorPicker(WidgetGuildFolderSettingsViewModel$ViewState$Loaded data) {
        Integer numRgbColorToARGB = rgbColorToARGB(data.getFormState().getColor());
        int iIntValue = numRgbColorToARGB != null ? numRgbColorToARGB.intValue() : ColorCompat.getThemedColor(getContext(), 2130969062);
        ColorPickerDialog$k colorPickerDialog$k = new ColorPickerDialog$k();
        colorPickerDialog$k.h = iIntValue;
        colorPickerDialog$k.f3148s = ColorCompat.getThemedColor(getContext(), 2130968911);
        colorPickerDialog$k.i = false;
        colorPickerDialog$k.g = getColorsToDisplay(iIntValue);
        colorPickerDialog$k.a = 2131890226;
        colorPickerDialog$k.r = ColorCompat.getThemedColor(getContext(), 2130968989);
        FontUtils fontUtils = FontUtils.INSTANCE;
        colorPickerDialog$k.f3149x = fontUtils.getThemedFontResId(getContext(), 2130969390);
        colorPickerDialog$k.o = ColorCompat.getThemedColor(getContext(), 2130968896);
        colorPickerDialog$k.c = 2131887706;
        colorPickerDialog$k.v = ColorCompat.getColor(getContext(), 2131100487);
        colorPickerDialog$k.f3147b = 2131887707;
        colorPickerDialog$k.p = ColorCompat.getThemedColor(getContext(), 2130969062);
        colorPickerDialog$k.d = 2131895390;
        colorPickerDialog$k.l = true;
        colorPickerDialog$k.e = 2131894833;
        colorPickerDialog$k.w = ColorCompat.getColor(getContext(), 2131100487);
        colorPickerDialog$k.f3150y = fontUtils.getThemedFontResId(getContext(), 2130969396);
        colorPickerDialog$k.q = ColorCompat.getThemedColor(getContext(), 2130968906);
        colorPickerDialog$k.t = ColorCompat.getThemedColor(getContext(), 2130969056);
        colorPickerDialog$k.u = 2131231203;
        colorPickerDialog$k.f3151z = fontUtils.getThemedFontResId(getContext(), 2130969395);
        ColorPickerDialog colorPickerDialogA = colorPickerDialog$k.a();
        colorPickerDialogA.k = new WidgetGuildFolderSettings$launchColorPicker$1(this);
        AppFragment.hideKeyboard$default(this, null, 1, null);
        colorPickerDialogA.show(getParentFragmentManager(), DIALOG_TAG_COLOR_PICKER);
    }

    private final Integer rgbColorToARGB(Integer color) {
        if (color != null) {
            return Integer.valueOf((int) (((long) color.intValue()) + 4278190080L));
        }
        return null;
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        m.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        AppFragment.setActionBarDisplayHomeAsUpEnabled$default(this, false, 1, null);
        setActionBarTitle(2131895580);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        Observable observableR = ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeViewState(), this, null, 2, null).r();
        m.checkNotNullExpressionValue(observableR, "viewModel.observeViewSta…  .distinctUntilChanged()");
        ObservableExtensionsKt.appSubscribe$default(observableR, WidgetGuildFolderSettings.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new WidgetGuildFolderSettings$onViewBoundOrOnResume$1(this), 62, (Object) null);
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeEvents(), this, null, 2, null), WidgetGuildFolderSettings.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new WidgetGuildFolderSettings$onViewBoundOrOnResume$2(this), 62, (Object) null);
        FragmentManager parentFragmentManager = getParentFragmentManager();
        m.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
        Fragment fragmentFindFragmentByTag = parentFragmentManager.findFragmentByTag(DIALOG_TAG_COLOR_PICKER);
        if (fragmentFindFragmentByTag != null) {
            parentFragmentManager.beginTransaction().remove(fragmentFindFragmentByTag).commit();
        }
    }
}
