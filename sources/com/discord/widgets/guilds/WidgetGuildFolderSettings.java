package com.discord.widgets.guilds;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
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
import com.discord.C5419R;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetGuildFolderSettingsBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.error.Error;
import com.discord.utilities.font.FontUtils;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.discord.widgets.chat.input.MentionUtilsKt;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputLayout;
import com.jaredrummler.android.colorpicker.ColorPickerDialog;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Objects;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import p007b.p008a.p018d.C0865g0;
import p007b.p008a.p018d.C0869i0;
import p007b.p008a.p018d.C0870j;
import p007b.p008a.p018d.C0876m;
import p007b.p100d.p104b.p105a.C1643a;
import p007b.p440k.p441a.p442a.InterfaceC5079f;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12216a0;
import p507d0.p592z.p594d.C12236k;
import p507d0.p592z.p594d.C12238m;
import p600f0.p601e0.C12272c;
import p658rx.Observable;
import p658rx.Subscription;

/* JADX INFO: compiled from: WidgetGuildFolderSettings.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildFolderSettings extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {C1643a.m846d0(WidgetGuildFolderSettings.class, "binding", "getBinding()Lcom/discord/databinding/WidgetGuildFolderSettingsBinding;", 0)};

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String DIALOG_TAG_COLOR_PICKER = "DIALOG_TAG_COLOR_PICKER";

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* JADX INFO: renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    /* JADX INFO: compiled from: WidgetGuildFolderSettings.kt */
    public static final class Companion {
        private Companion() {
        }

        public final void create(Context context, long folderId) {
            C12238m.checkNotNullParameter(context, "context");
            C0870j.m156d(context, WidgetGuildFolderSettings.class, new Intent().putExtra("com.discord.intent.extra.EXTRA_GUILD_FOLDER_ID", folderId));
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.guilds.WidgetGuildFolderSettings$configureUI$1 */
    /* JADX INFO: compiled from: WidgetGuildFolderSettings.kt */
    public static final class C85721 extends AbstractC12240o implements Function1<Editable, Unit> {
        public C85721() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Editable editable) {
            invoke2(editable);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Editable editable) {
            C12238m.checkNotNullParameter(editable, "editable");
            WidgetGuildFolderSettings.this.getViewModel().setName(editable.toString());
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.guilds.WidgetGuildFolderSettings$onViewBoundOrOnResume$1 */
    /* JADX INFO: compiled from: WidgetGuildFolderSettings.kt */
    public static final /* synthetic */ class C85761 extends C12236k implements Function1<WidgetGuildFolderSettingsViewModel.ViewState, Unit> {
        public C85761(WidgetGuildFolderSettings widgetGuildFolderSettings) {
            super(1, widgetGuildFolderSettings, WidgetGuildFolderSettings.class, "configureUI", "configureUI(Lcom/discord/widgets/guilds/WidgetGuildFolderSettingsViewModel$ViewState;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(WidgetGuildFolderSettingsViewModel.ViewState viewState) {
            invoke2(viewState);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(WidgetGuildFolderSettingsViewModel.ViewState viewState) {
            C12238m.checkNotNullParameter(viewState, "p1");
            ((WidgetGuildFolderSettings) this.receiver).configureUI(viewState);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.guilds.WidgetGuildFolderSettings$onViewBoundOrOnResume$2 */
    /* JADX INFO: compiled from: WidgetGuildFolderSettings.kt */
    public static final /* synthetic */ class C85772 extends C12236k implements Function1<WidgetGuildFolderSettingsViewModel.Event, Unit> {
        public C85772(WidgetGuildFolderSettings widgetGuildFolderSettings) {
            super(1, widgetGuildFolderSettings, WidgetGuildFolderSettings.class, "handleEvent", "handleEvent(Lcom/discord/widgets/guilds/WidgetGuildFolderSettingsViewModel$Event;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(WidgetGuildFolderSettingsViewModel.Event event) {
            invoke2(event);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(WidgetGuildFolderSettingsViewModel.Event event) {
            C12238m.checkNotNullParameter(event, "p1");
            ((WidgetGuildFolderSettings) this.receiver).handleEvent(event);
        }
    }

    public WidgetGuildFolderSettings() {
        super(C5419R.layout.widget_guild_folder_settings);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetGuildFolderSettings$binding$2.INSTANCE, null, 2, null);
        WidgetGuildFolderSettings$viewModel$2 widgetGuildFolderSettings$viewModel$2 = new WidgetGuildFolderSettings$viewModel$2(this);
        C0865g0 c0865g0 = new C0865g0(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, C12216a0.getOrCreateKotlinClass(WidgetGuildFolderSettingsViewModel.class), new WidgetGuildFolderSettings$appViewModels$$inlined$viewModels$1(c0865g0), new C0869i0(widgetGuildFolderSettings$viewModel$2));
    }

    private final int argbColorToRGB(int color) {
        return Color.argb(0, Color.red(color), Color.green(color), Color.blue(color));
    }

    private final void configureUI(final WidgetGuildFolderSettingsViewModel.ViewState state) {
        int themedColor;
        if (state instanceof WidgetGuildFolderSettingsViewModel.ViewState.Loaded) {
            View view = getBinding().f16778e;
            C12238m.checkNotNullExpressionValue(view, "binding.guildFolderSettingsColorDisplay");
            Drawable drawable = ContextCompat.getDrawable(view.getContext(), C5419R.drawable.drawable_circle_white_1);
            WidgetGuildFolderSettingsViewModel.ViewState.Loaded loaded = (WidgetGuildFolderSettingsViewModel.ViewState.Loaded) state;
            Integer numRgbColorToARGB = rgbColorToARGB(loaded.getFormState().getColor());
            if (numRgbColorToARGB != null) {
                themedColor = numRgbColorToARGB.intValue();
            } else {
                View view2 = getBinding().f16778e;
                C12238m.checkNotNullExpressionValue(view2, "binding.guildFolderSettingsColorDisplay");
                themedColor = ColorCompat.getThemedColor(view2, C5419R.attr.color_brand);
            }
            if (drawable != null) {
                drawable.setColorFilter(new PorterDuffColorFilter(themedColor, PorterDuff.Mode.SRC_ATOP));
                View view3 = getBinding().f16778e;
                C12238m.checkNotNullExpressionValue(view3, "binding.guildFolderSettingsColorDisplay");
                view3.setBackground(drawable);
            }
            TextInputLayout textInputLayout = getBinding().f16775b;
            C12238m.checkNotNullExpressionValue(textInputLayout, "binding.editGuildFolderName");
            ViewExtensions.addBindedTextWatcher(textInputLayout, this, new C85721());
            TextInputLayout textInputLayout2 = getBinding().f16775b;
            C12238m.checkNotNullExpressionValue(textInputLayout2, "binding.editGuildFolderName");
            String textOrEmpty = ViewExtensions.getTextOrEmpty(textInputLayout2);
            if (!C12238m.areEqual(loaded.getFormState().getName(), textOrEmpty)) {
                TextInputLayout textInputLayout3 = getBinding().f16775b;
                C12238m.checkNotNullExpressionValue(textInputLayout3, "binding.editGuildFolderName");
                ViewExtensions.setText(textInputLayout3, loaded.getFormState().getName());
                if (textOrEmpty.length() == 0) {
                    TextInputLayout textInputLayout4 = getBinding().f16775b;
                    C12238m.checkNotNullExpressionValue(textInputLayout4, "binding.editGuildFolderName");
                    EditText editText = textInputLayout4.getEditText();
                    Editable text = editText != null ? editText.getText() : null;
                    TextInputLayout textInputLayout5 = getBinding().f16775b;
                    C12238m.checkNotNullExpressionValue(textInputLayout5, "binding.editGuildFolderName");
                    Selection.setSelection(text, ViewExtensions.getTextOrEmpty(textInputLayout5).length());
                }
            }
            TextView textView = getBinding().f16776c;
            C12238m.checkNotNullExpressionValue(textView, "binding.guildFolderColorName");
            StringBuilder sb = new StringBuilder();
            sb.append(MentionUtilsKt.CHANNELS_CHAR);
            String strM10143x = C12272c.m10143x(themedColor);
            Objects.requireNonNull(strM10143x, "null cannot be cast to non-null type java.lang.String");
            String strSubstring = strM10143x.substring(2);
            C12238m.checkNotNullExpressionValue(strSubstring, "(this as java.lang.String).substring(startIndex)");
            Locale locale = Locale.ROOT;
            C12238m.checkNotNullExpressionValue(locale, "Locale.ROOT");
            Objects.requireNonNull(strSubstring, "null cannot be cast to non-null type java.lang.String");
            String upperCase = strSubstring.toUpperCase(locale);
            C12238m.checkNotNullExpressionValue(upperCase, "(this as java.lang.String).toUpperCase(locale)");
            sb.append(upperCase);
            textView.setText(sb.toString());
            getBinding().f16777d.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.guilds.WidgetGuildFolderSettings.configureUI.2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view4) {
                    WidgetGuildFolderSettings.this.launchColorPicker((WidgetGuildFolderSettingsViewModel.ViewState.Loaded) state);
                }
            });
            FloatingActionButton floatingActionButton = getBinding().f16779f;
            C12238m.checkNotNullExpressionValue(floatingActionButton, "binding.guildFolderSettingsSave");
            floatingActionButton.setVisibility(loaded.getShowSave() ? 0 : 8);
            getBinding().f16779f.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.guilds.WidgetGuildFolderSettings.configureUI.3
                @Override // android.view.View.OnClickListener
                public final void onClick(View view4) {
                    WidgetGuildFolderSettings.this.getViewModel().saveFolder();
                }
            });
        }
    }

    private final WidgetGuildFolderSettingsBinding getBinding() {
        return (WidgetGuildFolderSettingsBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    @ColorInt
    private final int[] getColorsToDisplay(@ColorInt int currentColor) {
        int[] intArray = getResources().getIntArray(C5419R.array.color_picker_palette);
        C12238m.checkNotNullExpressionValue(intArray, "resources.getIntArray(R.…ray.color_picker_palette)");
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

    private final void handleEvent(WidgetGuildFolderSettingsViewModel.Event event) {
        if (!(event instanceof WidgetGuildFolderSettingsViewModel.Event.UpdateFolderSettingsSuccess)) {
            if (event instanceof WidgetGuildFolderSettingsViewModel.Event.UpdateFolderSettingsFailure) {
                C0876m.m169g(getContext(), ((WidgetGuildFolderSettingsViewModel.Event.UpdateFolderSettingsFailure) event).getFailureMessageStringRes(), 0, null, 12);
            }
        } else {
            C0876m.m171i(this, ((WidgetGuildFolderSettingsViewModel.Event.UpdateFolderSettingsSuccess) event).getSuccessMessageStringRes(), 0, 4);
            AppFragment.hideKeyboard$default(this, null, 1, null);
            FragmentActivity fragmentActivityM95e = m95e();
            if (fragmentActivityM95e != null) {
                fragmentActivityM95e.onBackPressed();
            }
        }
    }

    private final void launchColorPicker(WidgetGuildFolderSettingsViewModel.ViewState.Loaded data) {
        Integer numRgbColorToARGB = rgbColorToARGB(data.getFormState().getColor());
        int iIntValue = numRgbColorToARGB != null ? numRgbColorToARGB.intValue() : ColorCompat.getThemedColor(getContext(), C5419R.attr.color_brand);
        ColorPickerDialog.C11163k c11163k = new ColorPickerDialog.C11163k();
        c11163k.f21754h = iIntValue;
        c11163k.f21765s = ColorCompat.getThemedColor(getContext(), C5419R.attr.colorBackgroundPrimary);
        c11163k.f21755i = false;
        c11163k.f21753g = getColorsToDisplay(iIntValue);
        c11163k.f21747a = C5419R.string.guild_folder_color;
        c11163k.f21764r = ColorCompat.getThemedColor(getContext(), C5419R.attr.colorHeaderPrimary);
        FontUtils fontUtils = FontUtils.INSTANCE;
        c11163k.f21770x = fontUtils.getThemedFontResId(getContext(), C5419R.attr.font_display_bold);
        c11163k.f21761o = ColorCompat.getThemedColor(getContext(), C5419R.attr.colorBackgroundAccent);
        c11163k.f21749c = C5419R.string.color_picker_custom;
        c11163k.f21768v = ColorCompat.getColor(getContext(), C5419R.color.white);
        c11163k.f21748b = C5419R.string.color_picker_presets;
        c11163k.f21762p = ColorCompat.getThemedColor(getContext(), C5419R.attr.color_brand);
        c11163k.f21750d = C5419R.string.select;
        c11163k.f21758l = true;
        c11163k.f21751e = C5419R.string.reset;
        c11163k.f21769w = ColorCompat.getColor(getContext(), C5419R.color.white);
        c11163k.f21771y = fontUtils.getThemedFontResId(getContext(), C5419R.attr.font_primary_semibold);
        c11163k.f21763q = ColorCompat.getThemedColor(getContext(), C5419R.attr.colorBackgroundModifierAccent);
        c11163k.f21766t = ColorCompat.getThemedColor(getContext(), C5419R.attr.colorTextMuted);
        c11163k.f21767u = C5419R.drawable.drawable_cpv_edit_text_background;
        c11163k.f21772z = fontUtils.getThemedFontResId(getContext(), C5419R.attr.font_primary_normal);
        ColorPickerDialog colorPickerDialogM9275a = c11163k.m9275a();
        colorPickerDialogM9275a.f21719k = new InterfaceC5079f() { // from class: com.discord.widgets.guilds.WidgetGuildFolderSettings.launchColorPicker.1
            @Override // p007b.p440k.p441a.p442a.InterfaceC5079f
            public void onColorReset(int dialogId) {
                WidgetGuildFolderSettings.this.getViewModel().setColor(Integer.valueOf(WidgetGuildFolderSettings.this.argbColorToRGB(ColorCompat.getThemedColor(WidgetGuildFolderSettings.this.getContext(), C5419R.attr.color_brand))));
            }

            @Override // p007b.p440k.p441a.p442a.InterfaceC5079f
            public void onColorSelected(int dialogId, int selectedColor) {
                WidgetGuildFolderSettings.this.getViewModel().setColor(Integer.valueOf(WidgetGuildFolderSettings.this.argbColorToRGB(selectedColor)));
            }

            @Override // p007b.p440k.p441a.p442a.InterfaceC5079f
            public void onDialogDismissed(int dialogId) {
            }
        };
        AppFragment.hideKeyboard$default(this, null, 1, null);
        colorPickerDialogM9275a.show(getParentFragmentManager(), DIALOG_TAG_COLOR_PICKER);
    }

    private final Integer rgbColorToARGB(Integer color) {
        if (color != null) {
            return Integer.valueOf((int) (((long) color.intValue()) + 4278190080L));
        }
        return null;
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        C12238m.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        AppFragment.setActionBarDisplayHomeAsUpEnabled$default(this, false, 1, null);
        setActionBarTitle(C5419R.string.server_folder_settings);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        Observable observableM11112r = ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeViewState(), this, null, 2, null).m11112r();
        C12238m.checkNotNullExpressionValue(observableM11112r, "viewModel.observeViewSta…  .distinctUntilChanged()");
        ObservableExtensionsKt.appSubscribe(observableM11112r, (Class<?>) WidgetGuildFolderSettings.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C85761(this));
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeEvents(), this, null, 2, null), (Class<?>) WidgetGuildFolderSettings.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C85772(this));
        FragmentManager parentFragmentManager = getParentFragmentManager();
        C12238m.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
        Fragment fragmentFindFragmentByTag = parentFragmentManager.findFragmentByTag(DIALOG_TAG_COLOR_PICKER);
        if (fragmentFindFragmentByTag != null) {
            parentFragmentManager.beginTransaction().remove(fragmentFindFragmentByTag).commit();
        }
    }
}
