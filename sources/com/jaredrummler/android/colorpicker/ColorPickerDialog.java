package com.jaredrummler.android.colorpicker;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputFilter;
import android.text.InputFilter$LengthFilter;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View$OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup$MarginLayoutParams;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AlertDialog$Builder;
import androidx.constraintlayout.motion.widget.Key;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.view.KeyEventDispatcher$Component;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.DialogFragment;
import b.k.a.a.b;
import b.k.a.a.e;
import b.k.a.a.f;
import com.discord.models.domain.ModelAuditLogEntry;
import java.util.Arrays;
import java.util.Locale;

/* JADX INFO: loaded from: classes3.dex */
public class ColorPickerDialog extends DialogFragment implements ColorPickerView$c, TextWatcher {
    public static final int[] j = {-769226, -1499549, -54125, -6543440, -10011977, -12627531, -14575885, -16537100, -16728876, -16738680, -11751600, -7617718, -3285959, -5317, -16121, -26624, -8825528, -10453621, -6381922};
    public EditText A;
    public View B;
    public TextView C;
    public Button D;
    public Button E;
    public TextView F;
    public boolean G;
    public int H;
    public boolean I;
    public int J;
    public final View$OnTouchListener K = new ColorPickerDialog$b(this);
    public f k;
    public View l;
    public FrameLayout m;
    public int[] n;

    @ColorInt
    public int o;
    public int p;
    public int q;
    public boolean r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f3143s;
    public b t;
    public LinearLayout u;
    public SeekBar v;
    public TextView w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public ColorPickerView f3144x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public ColorPanelView f3145y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public EditText f3146z;

    public static void g(ColorPickerDialog colorPickerDialog, int i) {
        if (colorPickerDialog.k != null) {
            Log.w("ColorPickerDialog", "Using deprecated listener which may be remove in future releases");
            colorPickerDialog.k.onColorSelected(colorPickerDialog.q, i);
        } else {
            KeyEventDispatcher$Component activity = colorPickerDialog.getActivity();
            if (!(activity instanceof f)) {
                throw new IllegalStateException("The activity must implement ColorPickerDialogListener");
            }
            ((f) activity).onColorSelected(colorPickerDialog.q, i);
        }
    }

    /* JADX WARN: Code duplicated, block: B:39:0x011b  */
    /* JADX WARN: Code duplicated, block: B:42:? A[RETURN, SYNTHETIC] */
    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int iArgb;
        if (this.A.isFocused()) {
            String string = editable.toString();
            if (string.startsWith("#")) {
                string = string.substring(1);
            }
            int i9 = 0;
            int i10 = -1;
            if (string.length() != 0) {
                if (string.length() <= 2) {
                    i8 = Integer.parseInt(string, 16);
                } else {
                    if (string.length() == 3) {
                        i3 = Integer.parseInt(string.substring(0, 1), 16);
                        i4 = Integer.parseInt(string.substring(1, 2), 16);
                        i5 = Integer.parseInt(string.substring(2, 3), 16);
                    } else if (string.length() == 4) {
                        int i11 = Integer.parseInt(string.substring(0, 2), 16);
                        i6 = Integer.parseInt(string.substring(2, 4), 16);
                        i9 = i11;
                        i7 = 0;
                        i2 = i7;
                        i = i6;
                        i10 = 255;
                    } else if (string.length() == 5) {
                        i3 = Integer.parseInt(string.substring(0, 1), 16);
                        i4 = Integer.parseInt(string.substring(1, 3), 16);
                        i5 = Integer.parseInt(string.substring(3, 5), 16);
                    } else if (string.length() == 6) {
                        i3 = Integer.parseInt(string.substring(0, 2), 16);
                        i4 = Integer.parseInt(string.substring(2, 4), 16);
                        i5 = Integer.parseInt(string.substring(4, 6), 16);
                    } else if (string.length() == 7) {
                        i10 = Integer.parseInt(string.substring(0, 1), 16);
                        i2 = Integer.parseInt(string.substring(1, 3), 16);
                        i9 = Integer.parseInt(string.substring(3, 5), 16);
                        i = Integer.parseInt(string.substring(5, 7), 16);
                    } else if (string.length() == 8) {
                        i10 = Integer.parseInt(string.substring(0, 2), 16);
                        i2 = Integer.parseInt(string.substring(2, 4), 16);
                        i9 = Integer.parseInt(string.substring(4, 6), 16);
                        i = Integer.parseInt(string.substring(6, 8), 16);
                    } else {
                        i = -1;
                        i2 = -1;
                        i9 = -1;
                    }
                    i6 = i5;
                    i7 = i3;
                    i9 = i4;
                    i2 = i7;
                    i = i6;
                    i10 = 255;
                }
                iArgb = Color.argb(i10, i2, i9, i);
                if (iArgb != this.f3144x.getColor()) {
                    this.I = true;
                    this.f3144x.b(iArgb, true);
                }
            }
            i8 = 0;
            i6 = i8;
            i7 = 0;
            i2 = i7;
            i = i6;
            i10 = 255;
            iArgb = Color.argb(i10, i2, i9, i);
            if (iArgb != this.f3144x.getColor()) {
                this.I = true;
                this.f3144x.b(iArgb, true);
            }
        }
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public void h(@ColorInt int i) {
        int i2 = 0;
        int[] iArr = {m(i, 0.9d), m(i, 0.7d), m(i, 0.5d), m(i, 0.333d), m(i, 0.166d), m(i, -0.125d), m(i, -0.25d), m(i, -0.375d), m(i, -0.5d), m(i, -0.675d), m(i, -0.7d), m(i, -0.775d)};
        if (this.u.getChildCount() != 0) {
            while (i2 < this.u.getChildCount()) {
                FrameLayout frameLayout = (FrameLayout) this.u.getChildAt(i2);
                ColorPanelView colorPanelView = (ColorPanelView) frameLayout.findViewById(R$c.cpv_color_panel_view);
                ImageView imageView = (ImageView) frameLayout.findViewById(R$c.cpv_color_image_view);
                colorPanelView.setColor(iArr[i2]);
                colorPanelView.setTag(Boolean.FALSE);
                imageView.setImageDrawable(null);
                i2++;
            }
            return;
        }
        int dimensionPixelSize = getResources().getDimensionPixelSize(R$a.cpv_item_horizontal_padding);
        while (i2 < 12) {
            int i3 = iArr[i2];
            View viewInflate = View.inflate(getActivity(), this.f3143s == 0 ? R$d.cpv_color_item_square : R$d.cpv_color_item_circle, null);
            ColorPanelView colorPanelView2 = (ColorPanelView) viewInflate.findViewById(R$c.cpv_color_panel_view);
            ViewGroup$MarginLayoutParams viewGroup$MarginLayoutParams = (ViewGroup$MarginLayoutParams) colorPanelView2.getLayoutParams();
            viewGroup$MarginLayoutParams.rightMargin = dimensionPixelSize;
            viewGroup$MarginLayoutParams.leftMargin = dimensionPixelSize;
            colorPanelView2.setLayoutParams(viewGroup$MarginLayoutParams);
            colorPanelView2.setColor(i3);
            this.u.addView(viewInflate);
            colorPanelView2.post(new ColorPickerDialog$i(this, colorPanelView2, i3));
            colorPanelView2.setOnClickListener(new ColorPickerDialog$j(this, colorPanelView2));
            colorPanelView2.setOnLongClickListener(new ColorPickerDialog$a(this, colorPanelView2));
            i2++;
        }
    }

    public View i() {
        View viewInflate = View.inflate(getActivity(), R$d.cpv_dialog_color_picker, null);
        this.f3144x = (ColorPickerView) viewInflate.findViewById(R$c.cpv_color_picker_view);
        this.f3145y = (ColorPanelView) viewInflate.findViewById(R$c.cpv_color_panel_new);
        this.A = (EditText) viewInflate.findViewById(R$c.cpv_hex);
        this.f3146z = (EditText) viewInflate.findViewById(R$c.cpv_hex_prefix);
        this.B = viewInflate.findViewById(R$c.cpv_hex_container);
        this.f3144x.setAlphaSliderVisible(this.G);
        this.f3144x.b(this.o, true);
        this.f3145y.setColor(this.o);
        l(this.o);
        if (!this.G) {
            this.A.setFilters(new InputFilter[]{new InputFilter$LengthFilter(6)});
        }
        this.f3145y.setOnClickListener(new ColorPickerDialog$f(this));
        viewInflate.setOnTouchListener(this.K);
        this.f3144x.setOnColorChangedListener(this);
        this.A.addTextChangedListener(this);
        this.A.setOnFocusChangeListener(new ColorPickerDialog$g(this));
        int i = getArguments().getInt("inputTextColor", 0);
        if (i != 0) {
            this.A.setTextColor(i);
            this.f3146z.setTextColor(i);
        }
        int i2 = getArguments().getInt("inputBackground", 0);
        if (i2 != 0) {
            this.B.setBackgroundResource(i2);
        }
        int i3 = getArguments().getInt("inputFont", 0);
        if (i3 != 0) {
            this.A.setTypeface(ResourcesCompat.getFont(requireContext(), i3));
            this.f3146z.setTypeface(ResourcesCompat.getFont(requireContext(), i3));
        }
        return viewInflate;
    }

    public View j() {
        boolean z2;
        View viewInflate = View.inflate(getActivity(), R$d.cpv_dialog_presets, null);
        this.u = (LinearLayout) viewInflate.findViewById(R$c.shades_layout);
        this.v = (SeekBar) viewInflate.findViewById(R$c.transparency_seekbar);
        this.w = (TextView) viewInflate.findViewById(R$c.transparency_text);
        GridView gridView = (GridView) viewInflate.findViewById(R$c.gridView);
        View viewFindViewById = viewInflate.findViewById(R$c.shades_divider);
        int iAlpha = Color.alpha(this.o);
        int[] intArray = getArguments().getIntArray("presets");
        this.n = intArray;
        if (intArray == null) {
            this.n = j;
        }
        int[] iArr = this.n;
        boolean z3 = iArr == j;
        this.n = Arrays.copyOf(iArr, iArr.length);
        if (iAlpha != 255) {
            int i = 0;
            while (true) {
                int[] iArr2 = this.n;
                if (i >= iArr2.length) {
                    break;
                }
                int i2 = iArr2[i];
                this.n[i] = Color.argb(iAlpha, Color.red(i2), Color.green(i2), Color.blue(i2));
                i++;
            }
        }
        this.n = n(this.n, this.o);
        int i3 = getArguments().getInt(ModelAuditLogEntry.CHANGE_KEY_COLOR);
        if (i3 != this.o) {
            this.n = n(this.n, i3);
        }
        if (z3) {
            int[] iArr3 = this.n;
            if (iArr3.length == 19) {
                int iArgb = Color.argb(iAlpha, 0, 0, 0);
                int length = iArr3.length;
                int i4 = 0;
                while (true) {
                    if (i4 >= length) {
                        z2 = false;
                        break;
                    }
                    if (iArr3[i4] == iArgb) {
                        z2 = true;
                        break;
                    }
                    i4++;
                }
                if (!z2) {
                    int length2 = iArr3.length + 1;
                    int[] iArr4 = new int[length2];
                    int i5 = length2 - 1;
                    iArr4[i5] = iArgb;
                    System.arraycopy(iArr3, 0, iArr4, 0, i5);
                    iArr3 = iArr4;
                }
                this.n = iArr3;
            }
        }
        if (this.r) {
            h(this.o);
            viewFindViewById.setVisibility(0);
            int i6 = getArguments().getInt("dividerColor", 0);
            if (i6 != 0) {
                viewFindViewById.setBackgroundTintList(ColorStateList.valueOf(i6));
            }
        } else {
            this.u.setVisibility(8);
            viewFindViewById.setVisibility(8);
        }
        ColorPickerDialog$h colorPickerDialog$h = new ColorPickerDialog$h(this);
        int[] iArr5 = this.n;
        int i7 = 0;
        while (true) {
            int[] iArr6 = this.n;
            if (i7 >= iArr6.length) {
                i7 = -1;
                break;
            }
            if (iArr6[i7] == this.o) {
                break;
            }
            i7++;
        }
        b bVar = new b(colorPickerDialog$h, iArr5, i7, this.f3143s);
        this.t = bVar;
        gridView.setAdapter((ListAdapter) bVar);
        if (this.G) {
            int iAlpha2 = 255 - Color.alpha(this.o);
            this.v.setMax(255);
            this.v.setProgress(iAlpha2);
            this.w.setText(String.format(Locale.ENGLISH, "%d%%", Integer.valueOf((int) ((((double) iAlpha2) * 100.0d) / 255.0d))));
            this.v.setOnSeekBarChangeListener(new e(this));
        } else {
            viewInflate.findViewById(R$c.transparency_layout).setVisibility(8);
            viewInflate.findViewById(R$c.transparency_title).setVisibility(8);
        }
        return viewInflate;
    }

    public void k(int i) {
        this.o = i;
        ColorPanelView colorPanelView = this.f3145y;
        if (colorPanelView != null) {
            colorPanelView.setColor(i);
        }
        if (!this.I && this.A != null) {
            l(i);
            if (this.A.hasFocus()) {
                ((InputMethodManager) getActivity().getSystemService("input_method")).hideSoftInputFromWindow(this.A.getWindowToken(), 0);
                this.A.clearFocus();
            }
        }
        this.I = false;
    }

    public final void l(int i) {
        if (this.G) {
            this.A.setText(String.format("%08X", Integer.valueOf(i)));
        } else {
            this.A.setText(String.format("%06X", Integer.valueOf(i & ViewCompat.MEASURED_SIZE_MASK)));
        }
    }

    public final int m(@ColorInt int i, double d) {
        long j2 = Long.parseLong(String.format("#%06X", Integer.valueOf(16777215 & i)).substring(1), 16);
        double d2 = d >= 0.0d ? 255.0d : 0.0d;
        if (d < 0.0d) {
            d *= -1.0d;
        }
        long j3 = j2 >> 16;
        long j4 = (j2 >> 8) & 255;
        long j5 = j2 & 255;
        return Color.argb(Color.alpha(i), (int) (Math.round((d2 - j3) * d) + j3), (int) (Math.round((d2 - j4) * d) + j4), (int) (Math.round((d2 - j5) * d) + j5));
    }

    public final int[] n(int[] iArr, int i) {
        boolean z2;
        int length = iArr.length;
        int i2 = 0;
        while (true) {
            if (i2 >= length) {
                z2 = false;
                break;
            }
            if (iArr[i2] == i) {
                z2 = true;
                break;
            }
            i2++;
        }
        if (z2) {
            return iArr;
        }
        int length2 = iArr.length + 1;
        int[] iArr2 = new int[length2];
        iArr2[0] = i;
        System.arraycopy(iArr, 0, iArr2, 1, length2 - 1);
        return iArr2;
    }

    @Override // androidx.fragment.app.DialogFragment
    public Dialog onCreateDialog(Bundle bundle) {
        this.q = getArguments().getInt(ModelAuditLogEntry.CHANGE_KEY_ID);
        this.G = getArguments().getBoolean(Key.ALPHA);
        this.r = getArguments().getBoolean("showColorShades");
        this.f3143s = getArguments().getInt("colorShape");
        if (bundle == null) {
            this.o = getArguments().getInt(ModelAuditLogEntry.CHANGE_KEY_COLOR);
            this.p = getArguments().getInt("dialogType");
        } else {
            this.o = bundle.getInt(ModelAuditLogEntry.CHANGE_KEY_COLOR);
            this.p = bundle.getInt("dialogType");
        }
        View viewInflate = LayoutInflater.from(requireContext()).inflate(R$d.cpv_dialog, (ViewGroup) null);
        this.l = viewInflate;
        FrameLayout frameLayout = (FrameLayout) viewInflate.findViewById(R$c.cpv_color_picker_content);
        this.m = frameLayout;
        int i = this.p;
        if (i == 0) {
            frameLayout.addView(i());
        } else if (i == 1) {
            frameLayout.addView(j());
        }
        return new AlertDialog$Builder(requireActivity()).setView(this.l).create();
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        return this.l;
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface$OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        super.onDismiss(dialogInterface);
        if (this.k != null) {
            Log.w("ColorPickerDialog", "Using deprecated listener which may be remove in future releases");
            this.k.onDialogDismissed(this.q);
        } else {
            KeyEventDispatcher$Component activity = getActivity();
            if (activity instanceof f) {
                ((f) activity).onDialogDismissed(this.q);
            }
        }
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        bundle.putInt(ModelAuditLogEntry.CHANGE_KEY_COLOR, this.o);
        bundle.putInt("dialogType", this.p);
        super.onSaveInstanceState(bundle);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        AlertDialog alertDialog = (AlertDialog) getDialog();
        alertDialog.getWindow().clearFlags(131080);
        alertDialog.getWindow().setSoftInputMode(4);
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NonNull View view, @Nullable Bundle bundle) {
        int i;
        super.onViewCreated(view, bundle);
        this.C = (TextView) view.findViewById(R$c.cpv_color_picker_title);
        this.D = (Button) view.findViewById(R$c.cpv_color_picker_custom_button);
        this.E = (Button) view.findViewById(R$c.cpv_color_picker_select_button);
        this.F = (TextView) view.findViewById(R$c.cpv_color_picker_custom_reset);
        int i2 = getArguments().getInt("backgroundColor", 0);
        if (i2 != 0) {
            view.setBackgroundColor(i2);
        }
        int i3 = getArguments().getInt("dialogTitle");
        if (i3 != 0) {
            this.C.setText(i3);
        }
        int i4 = getArguments().getInt("titleTextColor", 0);
        if (i4 != 0) {
            this.C.setTextColor(i4);
        }
        int i5 = getArguments().getInt("selectedButtonText");
        if (i5 == 0) {
            i5 = R$e.cpv_select;
        }
        this.E.setText(i5);
        this.E.setOnClickListener(new ColorPickerDialog$c(this));
        int i6 = getArguments().getInt("resetButtonText");
        if (i6 != 0) {
            this.F.setText(i6);
        }
        this.F.setOnClickListener(new ColorPickerDialog$d(this));
        this.H = getArguments().getInt("presetsButtonText");
        this.J = getArguments().getInt("customButtonText");
        if (this.p == 0 && getArguments().getBoolean("allowPresets")) {
            i = this.H;
            if (i == 0) {
                i = R$e.cpv_presets;
            }
        } else if (this.p == 1 && getArguments().getBoolean("allowCustom")) {
            i = this.J;
            if (i == 0) {
                i = R$e.cpv_custom;
            }
        } else {
            i = 0;
        }
        if (i != 0) {
            this.D.setText(i);
            this.D.setVisibility(0);
        } else {
            this.D.setVisibility(8);
        }
        if (getArguments().getBoolean("allowReset")) {
            this.F.setVisibility(0);
        } else {
            this.F.setVisibility(8);
        }
        int i7 = getArguments().getInt("customButtonColor", 0);
        if (i7 != 0) {
            this.D.setBackgroundTintList(ColorStateList.valueOf(i7));
        }
        int i8 = getArguments().getInt("selectedButtonColor", 0);
        if (i8 != 0) {
            this.E.setBackgroundTintList(ColorStateList.valueOf(i8));
            this.F.setTextColor(i8);
        }
        int i9 = getArguments().getInt("customButtonTextColor", 0);
        if (i9 != 0) {
            this.D.setTextColor(i9);
        }
        int i10 = getArguments().getInt("selectedButtonTextColor", 0);
        if (i10 != 0) {
            this.E.setTextColor(i10);
        }
        int i11 = getArguments().getInt("titleFont", 0);
        if (i11 != 0) {
            this.C.setTypeface(ResourcesCompat.getFont(requireContext(), i11));
        }
        int i12 = getArguments().getInt("buttonFont", 0);
        if (i12 != 0) {
            this.E.setTypeface(ResourcesCompat.getFont(requireContext(), i12));
            this.D.setTypeface(ResourcesCompat.getFont(requireContext(), i12));
            this.F.setTypeface(ResourcesCompat.getFont(requireContext(), i12));
        }
        this.D.setOnClickListener(new ColorPickerDialog$e(this));
    }
}
