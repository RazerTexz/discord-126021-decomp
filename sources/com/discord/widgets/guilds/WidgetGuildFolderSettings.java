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
import b.a.d.AppScreen2;
import b.a.d.AppToast;
import b.a.d.AppViewModelDelegates3;
import b.a.d.AppViewModelDelegates5;
import b.d.b.a.outline;
import b.k.a.a.ColorPickerDialogListener;
import com.discord.R;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetGuildFolderSettingsBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.error.Error;
import com.discord.utilities.font.FontUtils;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.widgets.chat.input.MentionUtils;
import com.discord.widgets.guilds.WidgetGuildFolderSettingsViewModel;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputLayout;
import com.jaredrummler.android.colorpicker.ColorPickerDialog;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import d0.z.d.Reflection2;
import f0.e0.Util7;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Objects;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import rx.Observable;
import rx.Subscription;

/* JADX INFO: compiled from: WidgetGuildFolderSettings.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildFolderSettings extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.d0(WidgetGuildFolderSettings.class, "binding", "getBinding()Lcom/discord/databinding/WidgetGuildFolderSettingsBinding;", 0)};

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
            Intrinsics3.checkNotNullParameter(context, "context");
            AppScreen2.d(context, WidgetGuildFolderSettings.class, new Intent().putExtra("com.discord.intent.extra.EXTRA_GUILD_FOLDER_ID", folderId));
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.guilds.WidgetGuildFolderSettings$configureUI$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetGuildFolderSettings.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<Editable, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Editable editable) {
            invoke2(editable);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Editable editable) {
            Intrinsics3.checkNotNullParameter(editable, "editable");
            WidgetGuildFolderSettings.this.getViewModel().setName(editable.toString());
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.guilds.WidgetGuildFolderSettings$onViewBoundOrOnResume$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetGuildFolderSettings.kt */
    public static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<WidgetGuildFolderSettingsViewModel.ViewState, Unit> {
        public AnonymousClass1(WidgetGuildFolderSettings widgetGuildFolderSettings) {
            super(1, widgetGuildFolderSettings, WidgetGuildFolderSettings.class, "configureUI", "configureUI(Lcom/discord/widgets/guilds/WidgetGuildFolderSettingsViewModel$ViewState;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(WidgetGuildFolderSettingsViewModel.ViewState viewState) {
            invoke2(viewState);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(WidgetGuildFolderSettingsViewModel.ViewState viewState) {
            Intrinsics3.checkNotNullParameter(viewState, "p1");
            ((WidgetGuildFolderSettings) this.receiver).configureUI(viewState);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.guilds.WidgetGuildFolderSettings$onViewBoundOrOnResume$2, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetGuildFolderSettings.kt */
    public static final /* synthetic */ class AnonymousClass2 extends FunctionReferenceImpl implements Function1<WidgetGuildFolderSettingsViewModel.Event, Unit> {
        public AnonymousClass2(WidgetGuildFolderSettings widgetGuildFolderSettings) {
            super(1, widgetGuildFolderSettings, WidgetGuildFolderSettings.class, "handleEvent", "handleEvent(Lcom/discord/widgets/guilds/WidgetGuildFolderSettingsViewModel$Event;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(WidgetGuildFolderSettingsViewModel.Event event) {
            invoke2(event);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(WidgetGuildFolderSettingsViewModel.Event event) {
            Intrinsics3.checkNotNullParameter(event, "p1");
            ((WidgetGuildFolderSettings) this.receiver).handleEvent(event);
        }
    }

    public WidgetGuildFolderSettings() {
        super(R.layout.widget_guild_folder_settings);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetGuildFolderSettings2.INSTANCE, null, 2, null);
        WidgetGuildFolderSettings3 widgetGuildFolderSettings3 = new WidgetGuildFolderSettings3(this);
        AppViewModelDelegates3 appViewModelDelegates3 = new AppViewModelDelegates3(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection2.getOrCreateKotlinClass(WidgetGuildFolderSettingsViewModel.class), new WidgetGuildFolderSettings$appViewModels$$inlined$viewModels$1(appViewModelDelegates3), new AppViewModelDelegates5(widgetGuildFolderSettings3));
    }

    private final int argbColorToRGB(int color) {
        return Color.argb(0, Color.red(color), Color.green(color), Color.blue(color));
    }

    private final void configureUI(final WidgetGuildFolderSettingsViewModel.ViewState state) {
        int themedColor;
        if (state instanceof WidgetGuildFolderSettingsViewModel.ViewState.Loaded) {
            View view = getBinding().e;
            Intrinsics3.checkNotNullExpressionValue(view, "binding.guildFolderSettingsColorDisplay");
            Drawable drawable = ContextCompat.getDrawable(view.getContext(), R.drawable.drawable_circle_white_1);
            WidgetGuildFolderSettingsViewModel.ViewState.Loaded loaded = (WidgetGuildFolderSettingsViewModel.ViewState.Loaded) state;
            Integer numRgbColorToARGB = rgbColorToARGB(loaded.getFormState().getColor());
            if (numRgbColorToARGB != null) {
                themedColor = numRgbColorToARGB.intValue();
            } else {
                View view2 = getBinding().e;
                Intrinsics3.checkNotNullExpressionValue(view2, "binding.guildFolderSettingsColorDisplay");
                themedColor = ColorCompat.getThemedColor(view2, R.attr.color_brand);
            }
            if (drawable != null) {
                drawable.setColorFilter(new PorterDuffColorFilter(themedColor, PorterDuff.Mode.SRC_ATOP));
                View view3 = getBinding().e;
                Intrinsics3.checkNotNullExpressionValue(view3, "binding.guildFolderSettingsColorDisplay");
                view3.setBackground(drawable);
            }
            TextInputLayout textInputLayout = getBinding().f2413b;
            Intrinsics3.checkNotNullExpressionValue(textInputLayout, "binding.editGuildFolderName");
            ViewExtensions.addBindedTextWatcher(textInputLayout, this, new AnonymousClass1());
            TextInputLayout textInputLayout2 = getBinding().f2413b;
            Intrinsics3.checkNotNullExpressionValue(textInputLayout2, "binding.editGuildFolderName");
            String textOrEmpty = ViewExtensions.getTextOrEmpty(textInputLayout2);
            if (!Intrinsics3.areEqual(loaded.getFormState().getName(), textOrEmpty)) {
                TextInputLayout textInputLayout3 = getBinding().f2413b;
                Intrinsics3.checkNotNullExpressionValue(textInputLayout3, "binding.editGuildFolderName");
                ViewExtensions.setText(textInputLayout3, loaded.getFormState().getName());
                if (textOrEmpty.length() == 0) {
                    TextInputLayout textInputLayout4 = getBinding().f2413b;
                    Intrinsics3.checkNotNullExpressionValue(textInputLayout4, "binding.editGuildFolderName");
                    EditText editText = textInputLayout4.getEditText();
                    Editable text = editText != null ? editText.getText() : null;
                    TextInputLayout textInputLayout5 = getBinding().f2413b;
                    Intrinsics3.checkNotNullExpressionValue(textInputLayout5, "binding.editGuildFolderName");
                    Selection.setSelection(text, ViewExtensions.getTextOrEmpty(textInputLayout5).length());
                }
            }
            TextView textView = getBinding().c;
            Intrinsics3.checkNotNullExpressionValue(textView, "binding.guildFolderColorName");
            StringBuilder sb = new StringBuilder();
            sb.append(MentionUtils.CHANNELS_CHAR);
            String strX = Util7.x(themedColor);
            Objects.requireNonNull(strX, "null cannot be cast to non-null type java.lang.String");
            String strSubstring = strX.substring(2);
            Intrinsics3.checkNotNullExpressionValue(strSubstring, "(this as java.lang.String).substring(startIndex)");
            Locale locale = Locale.ROOT;
            Intrinsics3.checkNotNullExpressionValue(locale, "Locale.ROOT");
            Objects.requireNonNull(strSubstring, "null cannot be cast to non-null type java.lang.String");
            String upperCase = strSubstring.toUpperCase(locale);
            Intrinsics3.checkNotNullExpressionValue(upperCase, "(this as java.lang.String).toUpperCase(locale)");
            sb.append(upperCase);
            textView.setText(sb.toString());
            getBinding().d.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.guilds.WidgetGuildFolderSettings.configureUI.2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view4) {
                    WidgetGuildFolderSettings.this.launchColorPicker((WidgetGuildFolderSettingsViewModel.ViewState.Loaded) state);
                }
            });
            FloatingActionButton floatingActionButton = getBinding().f;
            Intrinsics3.checkNotNullExpressionValue(floatingActionButton, "binding.guildFolderSettingsSave");
            floatingActionButton.setVisibility(loaded.getShowSave() ? 0 : 8);
            getBinding().f.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.guilds.WidgetGuildFolderSettings.configureUI.3
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
        int[] intArray = getResources().getIntArray(R.array.color_picker_palette);
        Intrinsics3.checkNotNullExpressionValue(intArray, "resources.getIntArray(R.…ray.color_picker_palette)");
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
                AppToast.g(getContext(), ((WidgetGuildFolderSettingsViewModel.Event.UpdateFolderSettingsFailure) event).getFailureMessageStringRes(), 0, null, 12);
            }
        } else {
            AppToast.i(this, ((WidgetGuildFolderSettingsViewModel.Event.UpdateFolderSettingsSuccess) event).getSuccessMessageStringRes(), 0, 4);
            AppFragment.hideKeyboard$default(this, null, 1, null);
            FragmentActivity fragmentActivityE = e();
            if (fragmentActivityE != null) {
                fragmentActivityE.onBackPressed();
            }
        }
    }

    private final void launchColorPicker(WidgetGuildFolderSettingsViewModel.ViewState.Loaded data) {
        Integer numRgbColorToARGB = rgbColorToARGB(data.getFormState().getColor());
        int iIntValue = numRgbColorToARGB != null ? numRgbColorToARGB.intValue() : ColorCompat.getThemedColor(getContext(), R.attr.color_brand);
        ColorPickerDialog.k kVar = new ColorPickerDialog.k();
        kVar.h = iIntValue;
        kVar.f3148s = ColorCompat.getThemedColor(getContext(), R.attr.colorBackgroundPrimary);
        kVar.i = false;
        kVar.g = getColorsToDisplay(iIntValue);
        kVar.a = R.string.guild_folder_color;
        kVar.r = ColorCompat.getThemedColor(getContext(), R.attr.colorHeaderPrimary);
        FontUtils fontUtils = FontUtils.INSTANCE;
        kVar.f3149x = fontUtils.getThemedFontResId(getContext(), R.attr.font_display_bold);
        kVar.o = ColorCompat.getThemedColor(getContext(), R.attr.colorBackgroundAccent);
        kVar.c = R.string.color_picker_custom;
        kVar.v = ColorCompat.getColor(getContext(), R.color.white);
        kVar.f3147b = R.string.color_picker_presets;
        kVar.p = ColorCompat.getThemedColor(getContext(), R.attr.color_brand);
        kVar.d = R.string.select;
        kVar.l = true;
        kVar.e = R.string.reset;
        kVar.w = ColorCompat.getColor(getContext(), R.color.white);
        kVar.f3150y = fontUtils.getThemedFontResId(getContext(), R.attr.font_primary_semibold);
        kVar.q = ColorCompat.getThemedColor(getContext(), R.attr.colorBackgroundModifierAccent);
        kVar.t = ColorCompat.getThemedColor(getContext(), R.attr.colorTextMuted);
        kVar.u = R.drawable.drawable_cpv_edit_text_background;
        kVar.f3151z = fontUtils.getThemedFontResId(getContext(), R.attr.font_primary_normal);
        ColorPickerDialog colorPickerDialogA = kVar.a();
        colorPickerDialogA.k = new ColorPickerDialogListener() { // from class: com.discord.widgets.guilds.WidgetGuildFolderSettings.launchColorPicker.1
            @Override // b.k.a.a.ColorPickerDialogListener
            public void onColorReset(int dialogId) {
                WidgetGuildFolderSettings.this.getViewModel().setColor(Integer.valueOf(WidgetGuildFolderSettings.this.argbColorToRGB(ColorCompat.getThemedColor(WidgetGuildFolderSettings.this.getContext(), R.attr.color_brand))));
            }

            @Override // b.k.a.a.ColorPickerDialogListener
            public void onColorSelected(int dialogId, int selectedColor) {
                WidgetGuildFolderSettings.this.getViewModel().setColor(Integer.valueOf(WidgetGuildFolderSettings.this.argbColorToRGB(selectedColor)));
            }

            @Override // b.k.a.a.ColorPickerDialogListener
            public void onDialogDismissed(int dialogId) {
            }
        };
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
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        AppFragment.setActionBarDisplayHomeAsUpEnabled$default(this, false, 1, null);
        setActionBarTitle(R.string.server_folder_settings);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        Observable observableR = ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeViewState(), this, null, 2, null).r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "viewModel.observeViewSta…  .distinctUntilChanged()");
        ObservableExtensionsKt.appSubscribe(observableR, (Class<?>) WidgetGuildFolderSettings.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass1(this));
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeEvents(), this, null, 2, null), (Class<?>) WidgetGuildFolderSettings.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass2(this));
        FragmentManager parentFragmentManager = getParentFragmentManager();
        Intrinsics3.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
        Fragment fragmentFindFragmentByTag = parentFragmentManager.findFragmentByTag(DIALOG_TAG_COLOR_PICKER);
        if (fragmentFindFragmentByTag != null) {
            parentFragmentManager.beginTransaction().remove(fragmentFindFragmentByTag).commit();
        }
    }
}
