package com.google.android.material.timepicker;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface$OnCancelListener;
import android.content.DialogInterface$OnDismissListener;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View$OnClickListener;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.Window;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.DrawableRes;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import b.d.b.a.a;
import b.i.a.g.k.f;
import b.i.a.g.k.g;
import b.i.a.g.k.i;
import com.google.android.material.R$attr;
import com.google.android.material.R$id;
import com.google.android.material.R$layout;
import com.google.android.material.R$string;
import com.google.android.material.R$style;
import com.google.android.material.R$styleable;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.resources.MaterialAttributes;
import com.google.android.material.shape.MaterialShapeDrawable;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes3.dex */
public final class MaterialTimePicker extends DialogFragment {
    public static final int INPUT_MODE_CLOCK = 0;
    public static final String INPUT_MODE_EXTRA = "TIME_PICKER_INPUT_MODE";
    public static final int INPUT_MODE_KEYBOARD = 1;
    public static final String TIME_MODEL_EXTRA = "TIME_PICKER_TIME_MODEL";
    public static final String TITLE_RES_EXTRA = "TIME_PICKER_TITLE_RES";
    public static final String TITLE_TEXT_EXTRA = "TIME_PICKER_TITLE_TEXT";

    @Nullable
    private g activePresenter;

    @DrawableRes
    private int clockIcon;

    @DrawableRes
    private int keyboardIcon;
    private MaterialButton modeButton;
    private ViewStub textInputStub;
    private LinearLayout textInputView;
    private TimeModel time;

    @Nullable
    private f timePickerClockPresenter;

    @Nullable
    private i timePickerTextInputPresenter;
    private TimePickerView timePickerView;
    private String titleText;
    private final Set<View$OnClickListener> positiveButtonListeners = new LinkedHashSet();
    private final Set<View$OnClickListener> negativeButtonListeners = new LinkedHashSet();
    private final Set<DialogInterface$OnCancelListener> cancelListeners = new LinkedHashSet();
    private final Set<DialogInterface$OnDismissListener> dismissListeners = new LinkedHashSet();
    private int titleResId = 0;
    private int inputMode = 0;

    public static /* synthetic */ MaterialTimePicker access$1000(MaterialTimePicker$Builder materialTimePicker$Builder) {
        return newInstance(materialTimePicker$Builder);
    }

    public static /* synthetic */ int access$400(MaterialTimePicker materialTimePicker) {
        return materialTimePicker.inputMode;
    }

    public static /* synthetic */ int access$402(MaterialTimePicker materialTimePicker, int i) {
        materialTimePicker.inputMode = i;
        return i;
    }

    public static /* synthetic */ MaterialButton access$500(MaterialTimePicker materialTimePicker) {
        return materialTimePicker.modeButton;
    }

    public static /* synthetic */ void access$600(MaterialTimePicker materialTimePicker, MaterialButton materialButton) {
        materialTimePicker.updateInputMode(materialButton);
    }

    public static /* synthetic */ i access$700(MaterialTimePicker materialTimePicker) {
        return materialTimePicker.timePickerTextInputPresenter;
    }

    public static /* synthetic */ Set access$800(MaterialTimePicker materialTimePicker) {
        return materialTimePicker.positiveButtonListeners;
    }

    public static /* synthetic */ Set access$900(MaterialTimePicker materialTimePicker) {
        return materialTimePicker.negativeButtonListeners;
    }

    private Pair<Integer, Integer> dataForMode(int i) {
        if (i == 0) {
            return new Pair<>(Integer.valueOf(this.keyboardIcon), Integer.valueOf(R$string.material_timepicker_text_input_mode_description));
        }
        if (i == 1) {
            return new Pair<>(Integer.valueOf(this.clockIcon), Integer.valueOf(R$string.material_timepicker_clock_mode_description));
        }
        throw new IllegalArgumentException(a.q("no icon for mode: ", i));
    }

    private g initializeOrRetrieveActivePresenterForMode(int i) {
        if (i == 0) {
            f fVar = this.timePickerClockPresenter;
            if (fVar == null) {
                fVar = new f(this.timePickerView, this.time);
            }
            this.timePickerClockPresenter = fVar;
            return fVar;
        }
        if (this.timePickerTextInputPresenter == null) {
            LinearLayout linearLayout = (LinearLayout) this.textInputStub.inflate();
            this.textInputView = linearLayout;
            this.timePickerTextInputPresenter = new i(linearLayout, this.time);
        }
        i iVar = this.timePickerTextInputPresenter;
        iVar.n.setChecked(false);
        iVar.o.setChecked(false);
        return this.timePickerTextInputPresenter;
    }

    @NonNull
    private static MaterialTimePicker newInstance(@NonNull MaterialTimePicker$Builder materialTimePicker$Builder) {
        MaterialTimePicker materialTimePicker = new MaterialTimePicker();
        Bundle bundle = new Bundle();
        bundle.putParcelable(TIME_MODEL_EXTRA, MaterialTimePicker$Builder.access$000(materialTimePicker$Builder));
        bundle.putInt(INPUT_MODE_EXTRA, MaterialTimePicker$Builder.access$100(materialTimePicker$Builder));
        bundle.putInt(TITLE_RES_EXTRA, MaterialTimePicker$Builder.access$200(materialTimePicker$Builder));
        if (MaterialTimePicker$Builder.access$300(materialTimePicker$Builder) != null) {
            bundle.putString(TITLE_TEXT_EXTRA, MaterialTimePicker$Builder.access$300(materialTimePicker$Builder).toString());
        }
        materialTimePicker.setArguments(bundle);
        return materialTimePicker;
    }

    private void restoreState(@Nullable Bundle bundle) {
        if (bundle == null) {
            return;
        }
        TimeModel timeModel = (TimeModel) bundle.getParcelable(TIME_MODEL_EXTRA);
        this.time = timeModel;
        if (timeModel == null) {
            this.time = new TimeModel(0, 0, 10, 0);
        }
        this.inputMode = bundle.getInt(INPUT_MODE_EXTRA, 0);
        this.titleResId = bundle.getInt(TITLE_RES_EXTRA, 0);
        this.titleText = bundle.getString(TITLE_TEXT_EXTRA);
    }

    private void updateInputMode(MaterialButton materialButton) {
        g gVar = this.activePresenter;
        if (gVar != null) {
            gVar.c();
        }
        g gVarInitializeOrRetrieveActivePresenterForMode = initializeOrRetrieveActivePresenterForMode(this.inputMode);
        this.activePresenter = gVarInitializeOrRetrieveActivePresenterForMode;
        gVarInitializeOrRetrieveActivePresenterForMode.show();
        this.activePresenter.a();
        Pair<Integer, Integer> pairDataForMode = dataForMode(this.inputMode);
        materialButton.setIconResource(((Integer) pairDataForMode.first).intValue());
        materialButton.setContentDescription(getResources().getString(((Integer) pairDataForMode.second).intValue()));
    }

    public boolean addOnCancelListener(@NonNull DialogInterface$OnCancelListener dialogInterface$OnCancelListener) {
        return this.cancelListeners.add(dialogInterface$OnCancelListener);
    }

    public boolean addOnDismissListener(@NonNull DialogInterface$OnDismissListener dialogInterface$OnDismissListener) {
        return this.dismissListeners.add(dialogInterface$OnDismissListener);
    }

    public boolean addOnNegativeButtonClickListener(@NonNull View$OnClickListener view$OnClickListener) {
        return this.negativeButtonListeners.add(view$OnClickListener);
    }

    public boolean addOnPositiveButtonClickListener(@NonNull View$OnClickListener view$OnClickListener) {
        return this.positiveButtonListeners.add(view$OnClickListener);
    }

    public void clearOnCancelListeners() {
        this.cancelListeners.clear();
    }

    public void clearOnDismissListeners() {
        this.dismissListeners.clear();
    }

    public void clearOnNegativeButtonClickListeners() {
        this.negativeButtonListeners.clear();
    }

    public void clearOnPositiveButtonClickListeners() {
        this.positiveButtonListeners.clear();
    }

    @IntRange(from = 0, to = 23)
    public int getHour() {
        return this.time.m % 24;
    }

    public int getInputMode() {
        return this.inputMode;
    }

    @IntRange(from = 0, to = 60)
    public int getMinute() {
        return this.time.n;
    }

    @Nullable
    public f getTimePickerClockPresenter() {
        return this.timePickerClockPresenter;
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface$OnCancelListener
    public final void onCancel(@NonNull DialogInterface dialogInterface) {
        Iterator<DialogInterface$OnCancelListener> it = this.cancelListeners.iterator();
        while (it.hasNext()) {
            it.next().onCancel(dialogInterface);
        }
        super.onCancel(dialogInterface);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        if (bundle == null) {
            bundle = getArguments();
        }
        restoreState(bundle);
    }

    @Override // androidx.fragment.app.DialogFragment
    @NonNull
    public final Dialog onCreateDialog(@Nullable Bundle bundle) {
        TypedValue typedValueResolve = MaterialAttributes.resolve(requireContext(), R$attr.materialTimePickerTheme);
        Dialog dialog = new Dialog(requireContext(), typedValueResolve == null ? 0 : typedValueResolve.data);
        Context context = dialog.getContext();
        int iResolveOrThrow = MaterialAttributes.resolveOrThrow(context, R$attr.colorSurface, MaterialTimePicker.class.getCanonicalName());
        int i = R$attr.materialTimePickerStyle;
        int i2 = R$style.Widget_MaterialComponents_TimePicker;
        MaterialShapeDrawable materialShapeDrawable = new MaterialShapeDrawable(context, null, i, i2);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(null, R$styleable.MaterialTimePicker, i, i2);
        this.clockIcon = typedArrayObtainStyledAttributes.getResourceId(R$styleable.MaterialTimePicker_clockIcon, 0);
        this.keyboardIcon = typedArrayObtainStyledAttributes.getResourceId(R$styleable.MaterialTimePicker_keyboardIcon, 0);
        typedArrayObtainStyledAttributes.recycle();
        materialShapeDrawable.initializeElevationOverlay(context);
        materialShapeDrawable.setFillColor(ColorStateList.valueOf(iResolveOrThrow));
        Window window = dialog.getWindow();
        window.setBackgroundDrawable(materialShapeDrawable);
        window.requestFeature(1);
        window.setLayout(-2, -2);
        return dialog;
    }

    @Override // androidx.fragment.app.Fragment
    @NonNull
    public final View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        ViewGroup viewGroup2 = (ViewGroup) layoutInflater.inflate(R$layout.material_timepicker_dialog, viewGroup);
        TimePickerView timePickerView = (TimePickerView) viewGroup2.findViewById(R$id.material_timepicker_view);
        this.timePickerView = timePickerView;
        timePickerView.r = new MaterialTimePicker$a(this);
        this.textInputStub = (ViewStub) viewGroup2.findViewById(R$id.material_textinput_timepicker);
        this.modeButton = (MaterialButton) viewGroup2.findViewById(R$id.material_timepicker_mode_button);
        TextView textView = (TextView) viewGroup2.findViewById(R$id.header_title);
        if (!TextUtils.isEmpty(this.titleText)) {
            textView.setText(this.titleText);
        }
        int i = this.titleResId;
        if (i != 0) {
            textView.setText(i);
        }
        updateInputMode(this.modeButton);
        ((Button) viewGroup2.findViewById(R$id.material_timepicker_ok_button)).setOnClickListener(new MaterialTimePicker$b(this));
        ((Button) viewGroup2.findViewById(R$id.material_timepicker_cancel_button)).setOnClickListener(new MaterialTimePicker$c(this));
        this.modeButton.setOnClickListener(new MaterialTimePicker$d(this));
        return viewGroup2;
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface$OnDismissListener
    public final void onDismiss(@NonNull DialogInterface dialogInterface) {
        Iterator<DialogInterface$OnDismissListener> it = this.dismissListeners.iterator();
        while (it.hasNext()) {
            it.next().onDismiss(dialogInterface);
        }
        ViewGroup viewGroup = (ViewGroup) getView();
        if (viewGroup != null) {
            viewGroup.removeAllViews();
        }
        super.onDismiss(dialogInterface);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onSaveInstanceState(@NonNull Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putParcelable(TIME_MODEL_EXTRA, this.time);
        bundle.putInt(INPUT_MODE_EXTRA, this.inputMode);
        bundle.putInt(TITLE_RES_EXTRA, this.titleResId);
        bundle.putString(TITLE_TEXT_EXTRA, this.titleText);
    }

    public boolean removeOnCancelListener(@NonNull DialogInterface$OnCancelListener dialogInterface$OnCancelListener) {
        return this.cancelListeners.remove(dialogInterface$OnCancelListener);
    }

    public boolean removeOnDismissListener(@NonNull DialogInterface$OnDismissListener dialogInterface$OnDismissListener) {
        return this.dismissListeners.remove(dialogInterface$OnDismissListener);
    }

    public boolean removeOnNegativeButtonClickListener(@NonNull View$OnClickListener view$OnClickListener) {
        return this.negativeButtonListeners.remove(view$OnClickListener);
    }

    public boolean removeOnPositiveButtonClickListener(@NonNull View$OnClickListener view$OnClickListener) {
        return this.positiveButtonListeners.remove(view$OnClickListener);
    }
}
