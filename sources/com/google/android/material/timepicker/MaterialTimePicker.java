package com.google.android.material.timepicker;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
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
import androidx.annotation.StringRes;
import androidx.fragment.app.DialogFragment;
import com.google.android.material.C10817R;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.resources.MaterialAttributes;
import com.google.android.material.shape.MaterialShapeDrawable;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;
import p007b.p100d.p104b.p105a.C1643a;
import p007b.p225i.p226a.p341g.p352k.C4451f;
import p007b.p225i.p226a.p341g.p352k.C4454i;
import p007b.p225i.p226a.p341g.p352k.InterfaceC4452g;

/* JADX INFO: loaded from: classes3.dex */
public final class MaterialTimePicker extends DialogFragment {
    public static final int INPUT_MODE_CLOCK = 0;
    public static final String INPUT_MODE_EXTRA = "TIME_PICKER_INPUT_MODE";
    public static final int INPUT_MODE_KEYBOARD = 1;
    public static final String TIME_MODEL_EXTRA = "TIME_PICKER_TIME_MODEL";
    public static final String TITLE_RES_EXTRA = "TIME_PICKER_TITLE_RES";
    public static final String TITLE_TEXT_EXTRA = "TIME_PICKER_TITLE_TEXT";

    @Nullable
    private InterfaceC4452g activePresenter;

    @DrawableRes
    private int clockIcon;

    @DrawableRes
    private int keyboardIcon;
    private MaterialButton modeButton;
    private ViewStub textInputStub;
    private LinearLayout textInputView;
    private TimeModel time;

    @Nullable
    private C4451f timePickerClockPresenter;

    @Nullable
    private C4454i timePickerTextInputPresenter;
    private TimePickerView timePickerView;
    private String titleText;
    private final Set<View.OnClickListener> positiveButtonListeners = new LinkedHashSet();
    private final Set<View.OnClickListener> negativeButtonListeners = new LinkedHashSet();
    private final Set<DialogInterface.OnCancelListener> cancelListeners = new LinkedHashSet();
    private final Set<DialogInterface.OnDismissListener> dismissListeners = new LinkedHashSet();
    private int titleResId = 0;
    private int inputMode = 0;

    public static final class Builder {
        private int inputMode;
        private CharSequence titleText;
        private TimeModel time = new TimeModel(0, 0, 10, 0);
        private int titleTextResId = 0;

        @NonNull
        public MaterialTimePicker build() {
            return MaterialTimePicker.newInstance(this);
        }

        @NonNull
        public Builder setHour(@IntRange(from = 0, m76to = 23) int i) {
            TimeModel timeModel = this.time;
            timeModel.f21226p = i >= 12 ? 1 : 0;
            timeModel.f21223m = i;
            return this;
        }

        @NonNull
        public Builder setInputMode(int i) {
            this.inputMode = i;
            return this;
        }

        @NonNull
        public Builder setMinute(@IntRange(from = 0, m76to = 60) int i) {
            TimeModel timeModel = this.time;
            Objects.requireNonNull(timeModel);
            timeModel.f21224n = i % 60;
            return this;
        }

        @NonNull
        public Builder setTimeFormat(int i) {
            TimeModel timeModel = this.time;
            int i2 = timeModel.f21223m;
            int i3 = timeModel.f21224n;
            TimeModel timeModel2 = new TimeModel(0, 0, 10, i);
            this.time = timeModel2;
            timeModel2.f21224n = i3 % 60;
            timeModel2.f21226p = i2 >= 12 ? 1 : 0;
            timeModel2.f21223m = i2;
            return this;
        }

        @NonNull
        public Builder setTitleText(@StringRes int i) {
            this.titleTextResId = i;
            return this;
        }

        @NonNull
        public Builder setTitleText(@Nullable CharSequence charSequence) {
            this.titleText = charSequence;
            return this;
        }
    }

    /* JADX INFO: renamed from: com.google.android.material.timepicker.MaterialTimePicker$a */
    public class C11023a implements TimePickerView.InterfaceC11029b {
        public C11023a() {
        }
    }

    /* JADX INFO: renamed from: com.google.android.material.timepicker.MaterialTimePicker$b */
    public class ViewOnClickListenerC11024b implements View.OnClickListener {
        public ViewOnClickListenerC11024b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Iterator it = MaterialTimePicker.this.positiveButtonListeners.iterator();
            while (it.hasNext()) {
                ((View.OnClickListener) it.next()).onClick(view);
            }
            MaterialTimePicker.this.dismiss();
        }
    }

    /* JADX INFO: renamed from: com.google.android.material.timepicker.MaterialTimePicker$c */
    public class ViewOnClickListenerC11025c implements View.OnClickListener {
        public ViewOnClickListenerC11025c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Iterator it = MaterialTimePicker.this.negativeButtonListeners.iterator();
            while (it.hasNext()) {
                ((View.OnClickListener) it.next()).onClick(view);
            }
            MaterialTimePicker.this.dismiss();
        }
    }

    /* JADX INFO: renamed from: com.google.android.material.timepicker.MaterialTimePicker$d */
    public class ViewOnClickListenerC11026d implements View.OnClickListener {
        public ViewOnClickListenerC11026d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            MaterialTimePicker materialTimePicker = MaterialTimePicker.this;
            materialTimePicker.inputMode = materialTimePicker.inputMode == 0 ? 1 : 0;
            MaterialTimePicker materialTimePicker2 = MaterialTimePicker.this;
            materialTimePicker2.updateInputMode(materialTimePicker2.modeButton);
        }
    }

    private Pair<Integer, Integer> dataForMode(int i) {
        if (i == 0) {
            return new Pair<>(Integer.valueOf(this.keyboardIcon), Integer.valueOf(C10817R.string.material_timepicker_text_input_mode_description));
        }
        if (i == 1) {
            return new Pair<>(Integer.valueOf(this.clockIcon), Integer.valueOf(C10817R.string.material_timepicker_clock_mode_description));
        }
        throw new IllegalArgumentException(C1643a.m871q("no icon for mode: ", i));
    }

    private InterfaceC4452g initializeOrRetrieveActivePresenterForMode(int i) {
        if (i == 0) {
            C4451f c4451f = this.timePickerClockPresenter;
            if (c4451f == null) {
                c4451f = new C4451f(this.timePickerView, this.time);
            }
            this.timePickerClockPresenter = c4451f;
            return c4451f;
        }
        if (this.timePickerTextInputPresenter == null) {
            LinearLayout linearLayout = (LinearLayout) this.textInputStub.inflate();
            this.textInputView = linearLayout;
            this.timePickerTextInputPresenter = new C4454i(linearLayout, this.time);
        }
        C4454i c4454i = this.timePickerTextInputPresenter;
        c4454i.f11881n.setChecked(false);
        c4454i.f11882o.setChecked(false);
        return this.timePickerTextInputPresenter;
    }

    @NonNull
    private static MaterialTimePicker newInstance(@NonNull Builder builder) {
        MaterialTimePicker materialTimePicker = new MaterialTimePicker();
        Bundle bundle = new Bundle();
        bundle.putParcelable(TIME_MODEL_EXTRA, builder.time);
        bundle.putInt(INPUT_MODE_EXTRA, builder.inputMode);
        bundle.putInt(TITLE_RES_EXTRA, builder.titleTextResId);
        if (builder.titleText != null) {
            bundle.putString(TITLE_TEXT_EXTRA, builder.titleText.toString());
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
        InterfaceC4452g interfaceC4452g = this.activePresenter;
        if (interfaceC4452g != null) {
            interfaceC4452g.mo6173c();
        }
        InterfaceC4452g interfaceC4452gInitializeOrRetrieveActivePresenterForMode = initializeOrRetrieveActivePresenterForMode(this.inputMode);
        this.activePresenter = interfaceC4452gInitializeOrRetrieveActivePresenterForMode;
        interfaceC4452gInitializeOrRetrieveActivePresenterForMode.show();
        this.activePresenter.mo6171a();
        Pair<Integer, Integer> pairDataForMode = dataForMode(this.inputMode);
        materialButton.setIconResource(((Integer) pairDataForMode.first).intValue());
        materialButton.setContentDescription(getResources().getString(((Integer) pairDataForMode.second).intValue()));
    }

    public boolean addOnCancelListener(@NonNull DialogInterface.OnCancelListener onCancelListener) {
        return this.cancelListeners.add(onCancelListener);
    }

    public boolean addOnDismissListener(@NonNull DialogInterface.OnDismissListener onDismissListener) {
        return this.dismissListeners.add(onDismissListener);
    }

    public boolean addOnNegativeButtonClickListener(@NonNull View.OnClickListener onClickListener) {
        return this.negativeButtonListeners.add(onClickListener);
    }

    public boolean addOnPositiveButtonClickListener(@NonNull View.OnClickListener onClickListener) {
        return this.positiveButtonListeners.add(onClickListener);
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

    @IntRange(from = 0, m76to = 23)
    public int getHour() {
        return this.time.f21223m % 24;
    }

    public int getInputMode() {
        return this.inputMode;
    }

    @IntRange(from = 0, m76to = 60)
    public int getMinute() {
        return this.time.f21224n;
    }

    @Nullable
    public C4451f getTimePickerClockPresenter() {
        return this.timePickerClockPresenter;
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnCancelListener
    public final void onCancel(@NonNull DialogInterface dialogInterface) {
        Iterator<DialogInterface.OnCancelListener> it = this.cancelListeners.iterator();
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
        TypedValue typedValueResolve = MaterialAttributes.resolve(requireContext(), C10817R.attr.materialTimePickerTheme);
        Dialog dialog = new Dialog(requireContext(), typedValueResolve == null ? 0 : typedValueResolve.data);
        Context context = dialog.getContext();
        int iResolveOrThrow = MaterialAttributes.resolveOrThrow(context, C10817R.attr.colorSurface, MaterialTimePicker.class.getCanonicalName());
        int i = C10817R.attr.materialTimePickerStyle;
        int i2 = C10817R.style.Widget_MaterialComponents_TimePicker;
        MaterialShapeDrawable materialShapeDrawable = new MaterialShapeDrawable(context, null, i, i2);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(null, C10817R.styleable.MaterialTimePicker, i, i2);
        this.clockIcon = typedArrayObtainStyledAttributes.getResourceId(C10817R.styleable.MaterialTimePicker_clockIcon, 0);
        this.keyboardIcon = typedArrayObtainStyledAttributes.getResourceId(C10817R.styleable.MaterialTimePicker_keyboardIcon, 0);
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
        ViewGroup viewGroup2 = (ViewGroup) layoutInflater.inflate(C10817R.layout.material_timepicker_dialog, viewGroup);
        TimePickerView timePickerView = (TimePickerView) viewGroup2.findViewById(C10817R.id.material_timepicker_view);
        this.timePickerView = timePickerView;
        timePickerView.f21235r = new C11023a();
        this.textInputStub = (ViewStub) viewGroup2.findViewById(C10817R.id.material_textinput_timepicker);
        this.modeButton = (MaterialButton) viewGroup2.findViewById(C10817R.id.material_timepicker_mode_button);
        TextView textView = (TextView) viewGroup2.findViewById(C10817R.id.header_title);
        if (!TextUtils.isEmpty(this.titleText)) {
            textView.setText(this.titleText);
        }
        int i = this.titleResId;
        if (i != 0) {
            textView.setText(i);
        }
        updateInputMode(this.modeButton);
        ((Button) viewGroup2.findViewById(C10817R.id.material_timepicker_ok_button)).setOnClickListener(new ViewOnClickListenerC11024b());
        ((Button) viewGroup2.findViewById(C10817R.id.material_timepicker_cancel_button)).setOnClickListener(new ViewOnClickListenerC11025c());
        this.modeButton.setOnClickListener(new ViewOnClickListenerC11026d());
        return viewGroup2;
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public final void onDismiss(@NonNull DialogInterface dialogInterface) {
        Iterator<DialogInterface.OnDismissListener> it = this.dismissListeners.iterator();
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

    public boolean removeOnCancelListener(@NonNull DialogInterface.OnCancelListener onCancelListener) {
        return this.cancelListeners.remove(onCancelListener);
    }

    public boolean removeOnDismissListener(@NonNull DialogInterface.OnDismissListener onDismissListener) {
        return this.dismissListeners.remove(onDismissListener);
    }

    public boolean removeOnNegativeButtonClickListener(@NonNull View.OnClickListener onClickListener) {
        return this.negativeButtonListeners.remove(onClickListener);
    }

    public boolean removeOnPositiveButtonClickListener(@NonNull View.OnClickListener onClickListener) {
        return this.positiveButtonListeners.remove(onClickListener);
    }
}
