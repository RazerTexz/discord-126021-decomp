package com.jaredrummler.android.colorpicker;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
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
import androidx.annotation.DrawableRes;
import androidx.annotation.FontRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.appcompat.app.AlertDialog;
import androidx.constraintlayout.motion.widget.Key;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.graphics.ColorUtils;
import androidx.core.view.KeyEventDispatcher;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.DialogFragment;
import b.k.a.a.ColorPaletteAdapter;
import b.k.a.a.ColorPickerDialog2;
import b.k.a.a.ColorPickerDialogListener;
import com.discord.models.domain.ModelAuditLogEntry;
import com.jaredrummler.android.colorpicker.ColorPickerView;
import java.util.Arrays;
import java.util.Locale;

/* JADX INFO: loaded from: classes3.dex */
public class ColorPickerDialog extends DialogFragment implements ColorPickerView.c, TextWatcher {
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
    public final View.OnTouchListener K = new b();
    public ColorPickerDialogListener k;
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
    public ColorPaletteAdapter t;
    public LinearLayout u;
    public SeekBar v;
    public TextView w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public ColorPickerView f3144x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public ColorPanelView f3145y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public EditText f3146z;

    public class a implements View.OnLongClickListener {
        public final /* synthetic */ ColorPanelView j;

        public a(ColorPickerDialog colorPickerDialog, ColorPanelView colorPanelView) {
            this.j = colorPanelView;
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            this.j.a();
            return true;
        }
    }

    public class b implements View.OnTouchListener {
        public b() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            EditText editText = ColorPickerDialog.this.A;
            if (view == editText || !editText.hasFocus()) {
                return false;
            }
            ColorPickerDialog.this.A.clearFocus();
            ((InputMethodManager) ColorPickerDialog.this.e().getSystemService("input_method")).hideSoftInputFromWindow(ColorPickerDialog.this.A.getWindowToken(), 0);
            ColorPickerDialog.this.A.clearFocus();
            return true;
        }
    }

    public class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ColorPickerDialog colorPickerDialog = ColorPickerDialog.this;
            ColorPickerDialog.g(colorPickerDialog, colorPickerDialog.o);
            ColorPickerDialog.this.dismiss();
        }
    }

    public class d implements View.OnClickListener {
        public d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ColorPickerDialog colorPickerDialog = ColorPickerDialog.this;
            if (colorPickerDialog.k != null) {
                Log.w("ColorPickerDialog", "Using deprecated listener which may be remove in future releases");
                colorPickerDialog.k.onColorReset(colorPickerDialog.q);
            } else {
                KeyEventDispatcher.Component componentE = colorPickerDialog.e();
                if (!(componentE instanceof ColorPickerDialogListener)) {
                    throw new IllegalStateException("The activity must implement ColorPickerDialogListener");
                }
                ((ColorPickerDialogListener) componentE).onColorReset(colorPickerDialog.q);
            }
            ColorPickerDialog.this.dismiss();
        }
    }

    public class e implements View.OnClickListener {
        public e() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ColorPickerDialog.this.m.removeAllViews();
            ColorPickerDialog colorPickerDialog = ColorPickerDialog.this;
            int i = colorPickerDialog.p;
            if (i == 0) {
                colorPickerDialog.p = 1;
                Button button = (Button) view;
                int i2 = colorPickerDialog.J;
                if (i2 == 0) {
                    i2 = R.e.cpv_custom;
                }
                button.setText(i2);
                ColorPickerDialog colorPickerDialog2 = ColorPickerDialog.this;
                colorPickerDialog2.m.addView(colorPickerDialog2.j());
                return;
            }
            if (i != 1) {
                return;
            }
            colorPickerDialog.p = 0;
            Button button2 = (Button) view;
            int i3 = colorPickerDialog.H;
            if (i3 == 0) {
                i3 = R.e.cpv_presets;
            }
            button2.setText(i3);
            ColorPickerDialog colorPickerDialog3 = ColorPickerDialog.this;
            colorPickerDialog3.m.addView(colorPickerDialog3.i());
        }
    }

    public class f implements View.OnClickListener {
        public f() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int color = ColorPickerDialog.this.f3145y.getColor();
            ColorPickerDialog colorPickerDialog = ColorPickerDialog.this;
            int i = colorPickerDialog.o;
            if (color == i) {
                ColorPickerDialog.g(colorPickerDialog, i);
                ColorPickerDialog.this.dismiss();
            }
        }
    }

    public class g implements View.OnFocusChangeListener {
        public g() {
        }

        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z2) {
            if (z2) {
                ((InputMethodManager) ColorPickerDialog.this.e().getSystemService("input_method")).showSoftInput(ColorPickerDialog.this.A, 1);
            }
        }
    }

    public class h implements ColorPaletteAdapter.a {
        public h() {
        }
    }

    public class i implements Runnable {
        public final /* synthetic */ ColorPanelView j;
        public final /* synthetic */ int k;

        public i(ColorPickerDialog colorPickerDialog, ColorPanelView colorPanelView, int i) {
            this.j = colorPanelView;
            this.k = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.j.setColor(this.k);
        }
    }

    public class j implements View.OnClickListener {
        public final /* synthetic */ ColorPanelView j;

        public j(ColorPanelView colorPanelView) {
            this.j = colorPanelView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if ((view.getTag() instanceof Boolean) && ((Boolean) view.getTag()).booleanValue()) {
                ColorPickerDialog colorPickerDialog = ColorPickerDialog.this;
                ColorPickerDialog.g(colorPickerDialog, colorPickerDialog.o);
                ColorPickerDialog.this.dismiss();
                return;
            }
            ColorPickerDialog.this.o = this.j.getColor();
            ColorPaletteAdapter colorPaletteAdapter = ColorPickerDialog.this.t;
            colorPaletteAdapter.l = -1;
            colorPaletteAdapter.notifyDataSetChanged();
            for (int i = 0; i < ColorPickerDialog.this.u.getChildCount(); i++) {
                FrameLayout frameLayout = (FrameLayout) ColorPickerDialog.this.u.getChildAt(i);
                ColorPanelView colorPanelView = (ColorPanelView) frameLayout.findViewById(R.c.cpv_color_panel_view);
                ImageView imageView = (ImageView) frameLayout.findViewById(R.c.cpv_color_image_view);
                imageView.setImageResource(colorPanelView == view ? R.b.cpv_preset_checked : 0);
                if ((colorPanelView != view || ColorUtils.calculateLuminance(colorPanelView.getColor()) < 0.65d) && Color.alpha(colorPanelView.getColor()) > 165) {
                    imageView.setColorFilter((ColorFilter) null);
                } else {
                    imageView.setColorFilter(ViewCompat.MEASURED_STATE_MASK, PorterDuff.Mode.SRC_IN);
                }
                colorPanelView.setTag(Boolean.valueOf(colorPanelView == view));
            }
        }
    }

    public static final class k {

        @StringRes
        public int a = R.e.cpv_default_title;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @StringRes
        public int f3147b = R.e.cpv_presets;

        @StringRes
        public int c = R.e.cpv_custom;

        @StringRes
        public int d = R.e.cpv_select;

        @StringRes
        public int e = 0;
        public int f = 1;
        public int[] g = ColorPickerDialog.j;

        @ColorInt
        public int h = ViewCompat.MEASURED_STATE_MASK;
        public boolean i = false;
        public boolean j = true;
        public boolean k = true;
        public boolean l = true;
        public boolean m = true;
        public int n = 1;

        @ColorInt
        public int o = 0;

        @ColorInt
        public int p = 0;

        @ColorInt
        public int q = 0;

        @ColorInt
        public int r = 0;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        @ColorInt
        public int f3148s = 0;

        @ColorInt
        public int t = 0;

        @DrawableRes
        public int u = 0;

        @ColorInt
        public int v = 0;

        @ColorInt
        public int w = 0;

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        @FontRes
        public int f3149x = 0;

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        @FontRes
        public int f3150y = 0;

        /* JADX INFO: renamed from: z, reason: collision with root package name */
        @FontRes
        public int f3151z = 0;

        public ColorPickerDialog a() {
            ColorPickerDialog colorPickerDialog = new ColorPickerDialog();
            Bundle bundle = new Bundle();
            bundle.putInt(ModelAuditLogEntry.CHANGE_KEY_ID, 0);
            bundle.putInt("dialogType", this.f);
            bundle.putInt(ModelAuditLogEntry.CHANGE_KEY_COLOR, this.h);
            bundle.putIntArray("presets", this.g);
            bundle.putBoolean(Key.ALPHA, this.i);
            bundle.putBoolean("allowCustom", this.k);
            bundle.putBoolean("allowPresets", this.j);
            bundle.putBoolean("allowReset", this.l);
            bundle.putInt("dialogTitle", this.a);
            bundle.putBoolean("showColorShades", this.m);
            bundle.putInt("colorShape", this.n);
            bundle.putInt("presetsButtonText", this.f3147b);
            bundle.putInt("customButtonText", this.c);
            bundle.putInt("customButtonColor", this.o);
            bundle.putInt("customButtonTextColor", this.v);
            bundle.putInt("selectedButtonText", this.d);
            bundle.putInt("selectedButtonColor", this.p);
            bundle.putInt("selectedButtonTextColor", this.w);
            bundle.putInt("resetButtonText", this.e);
            bundle.putInt("buttonFont", this.f3150y);
            bundle.putInt("titleTextColor", this.r);
            bundle.putInt("titleFont", this.f3149x);
            bundle.putInt("dividerColor", this.q);
            bundle.putInt("backgroundColor", this.f3148s);
            bundle.putInt("inputTextColor", this.t);
            bundle.putInt("inputBackground", this.u);
            bundle.putInt("inputFont", this.f3151z);
            colorPickerDialog.setArguments(bundle);
            return colorPickerDialog;
        }
    }

    public static void g(ColorPickerDialog colorPickerDialog, int i2) {
        if (colorPickerDialog.k != null) {
            Log.w("ColorPickerDialog", "Using deprecated listener which may be remove in future releases");
            colorPickerDialog.k.onColorSelected(colorPickerDialog.q, i2);
        } else {
            KeyEventDispatcher.Component componentE = colorPickerDialog.e();
            if (!(componentE instanceof ColorPickerDialogListener)) {
                throw new IllegalStateException("The activity must implement ColorPickerDialogListener");
            }
            ((ColorPickerDialogListener) componentE).onColorSelected(colorPickerDialog.q, i2);
        }
    }

    /* JADX WARN: Code duplicated, block: B:39:0x011b  */
    /* JADX WARN: Code duplicated, block: B:42:? A[RETURN, SYNTHETIC] */
    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int iArgb;
        if (this.A.isFocused()) {
            String string = editable.toString();
            if (string.startsWith("#")) {
                string = string.substring(1);
            }
            int i10 = 0;
            int i11 = -1;
            if (string.length() != 0) {
                if (string.length() <= 2) {
                    i9 = Integer.parseInt(string, 16);
                } else {
                    if (string.length() == 3) {
                        i4 = Integer.parseInt(string.substring(0, 1), 16);
                        i5 = Integer.parseInt(string.substring(1, 2), 16);
                        i6 = Integer.parseInt(string.substring(2, 3), 16);
                    } else if (string.length() == 4) {
                        int i12 = Integer.parseInt(string.substring(0, 2), 16);
                        i7 = Integer.parseInt(string.substring(2, 4), 16);
                        i10 = i12;
                        i8 = 0;
                        i3 = i8;
                        i2 = i7;
                        i11 = 255;
                    } else if (string.length() == 5) {
                        i4 = Integer.parseInt(string.substring(0, 1), 16);
                        i5 = Integer.parseInt(string.substring(1, 3), 16);
                        i6 = Integer.parseInt(string.substring(3, 5), 16);
                    } else if (string.length() == 6) {
                        i4 = Integer.parseInt(string.substring(0, 2), 16);
                        i5 = Integer.parseInt(string.substring(2, 4), 16);
                        i6 = Integer.parseInt(string.substring(4, 6), 16);
                    } else if (string.length() == 7) {
                        i11 = Integer.parseInt(string.substring(0, 1), 16);
                        i3 = Integer.parseInt(string.substring(1, 3), 16);
                        i10 = Integer.parseInt(string.substring(3, 5), 16);
                        i2 = Integer.parseInt(string.substring(5, 7), 16);
                    } else if (string.length() == 8) {
                        i11 = Integer.parseInt(string.substring(0, 2), 16);
                        i3 = Integer.parseInt(string.substring(2, 4), 16);
                        i10 = Integer.parseInt(string.substring(4, 6), 16);
                        i2 = Integer.parseInt(string.substring(6, 8), 16);
                    } else {
                        i2 = -1;
                        i3 = -1;
                        i10 = -1;
                    }
                    i7 = i6;
                    i8 = i4;
                    i10 = i5;
                    i3 = i8;
                    i2 = i7;
                    i11 = 255;
                }
                iArgb = Color.argb(i11, i3, i10, i2);
                if (iArgb != this.f3144x.getColor()) {
                    this.I = true;
                    this.f3144x.b(iArgb, true);
                }
            }
            i9 = 0;
            i7 = i9;
            i8 = 0;
            i3 = i8;
            i2 = i7;
            i11 = 255;
            iArgb = Color.argb(i11, i3, i10, i2);
            if (iArgb != this.f3144x.getColor()) {
                this.I = true;
                this.f3144x.b(iArgb, true);
            }
        }
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
    }

    public void h(@ColorInt int i2) {
        int i3 = 0;
        int[] iArr = {m(i2, 0.9d), m(i2, 0.7d), m(i2, 0.5d), m(i2, 0.333d), m(i2, 0.166d), m(i2, -0.125d), m(i2, -0.25d), m(i2, -0.375d), m(i2, -0.5d), m(i2, -0.675d), m(i2, -0.7d), m(i2, -0.775d)};
        if (this.u.getChildCount() != 0) {
            while (i3 < this.u.getChildCount()) {
                FrameLayout frameLayout = (FrameLayout) this.u.getChildAt(i3);
                ColorPanelView colorPanelView = (ColorPanelView) frameLayout.findViewById(R.c.cpv_color_panel_view);
                ImageView imageView = (ImageView) frameLayout.findViewById(R.c.cpv_color_image_view);
                colorPanelView.setColor(iArr[i3]);
                colorPanelView.setTag(Boolean.FALSE);
                imageView.setImageDrawable(null);
                i3++;
            }
            return;
        }
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.a.cpv_item_horizontal_padding);
        while (i3 < 12) {
            int i4 = iArr[i3];
            View viewInflate = View.inflate(e(), this.f3143s == 0 ? R.d.cpv_color_item_square : R.d.cpv_color_item_circle, null);
            ColorPanelView colorPanelView2 = (ColorPanelView) viewInflate.findViewById(R.c.cpv_color_panel_view);
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) colorPanelView2.getLayoutParams();
            marginLayoutParams.rightMargin = dimensionPixelSize;
            marginLayoutParams.leftMargin = dimensionPixelSize;
            colorPanelView2.setLayoutParams(marginLayoutParams);
            colorPanelView2.setColor(i4);
            this.u.addView(viewInflate);
            colorPanelView2.post(new i(this, colorPanelView2, i4));
            colorPanelView2.setOnClickListener(new j(colorPanelView2));
            colorPanelView2.setOnLongClickListener(new a(this, colorPanelView2));
            i3++;
        }
    }

    public View i() {
        View viewInflate = View.inflate(e(), R.d.cpv_dialog_color_picker, null);
        this.f3144x = (ColorPickerView) viewInflate.findViewById(R.c.cpv_color_picker_view);
        this.f3145y = (ColorPanelView) viewInflate.findViewById(R.c.cpv_color_panel_new);
        this.A = (EditText) viewInflate.findViewById(R.c.cpv_hex);
        this.f3146z = (EditText) viewInflate.findViewById(R.c.cpv_hex_prefix);
        this.B = viewInflate.findViewById(R.c.cpv_hex_container);
        this.f3144x.setAlphaSliderVisible(this.G);
        this.f3144x.b(this.o, true);
        this.f3145y.setColor(this.o);
        l(this.o);
        if (!this.G) {
            this.A.setFilters(new InputFilter[]{new InputFilter.LengthFilter(6)});
        }
        this.f3145y.setOnClickListener(new f());
        viewInflate.setOnTouchListener(this.K);
        this.f3144x.setOnColorChangedListener(this);
        this.A.addTextChangedListener(this);
        this.A.setOnFocusChangeListener(new g());
        int i2 = getArguments().getInt("inputTextColor", 0);
        if (i2 != 0) {
            this.A.setTextColor(i2);
            this.f3146z.setTextColor(i2);
        }
        int i3 = getArguments().getInt("inputBackground", 0);
        if (i3 != 0) {
            this.B.setBackgroundResource(i3);
        }
        int i4 = getArguments().getInt("inputFont", 0);
        if (i4 != 0) {
            this.A.setTypeface(ResourcesCompat.getFont(requireContext(), i4));
            this.f3146z.setTypeface(ResourcesCompat.getFont(requireContext(), i4));
        }
        return viewInflate;
    }

    public View j() {
        boolean z2;
        View viewInflate = View.inflate(e(), R.d.cpv_dialog_presets, null);
        this.u = (LinearLayout) viewInflate.findViewById(R.c.shades_layout);
        this.v = (SeekBar) viewInflate.findViewById(R.c.transparency_seekbar);
        this.w = (TextView) viewInflate.findViewById(R.c.transparency_text);
        GridView gridView = (GridView) viewInflate.findViewById(R.c.gridView);
        View viewFindViewById = viewInflate.findViewById(R.c.shades_divider);
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
            int i2 = 0;
            while (true) {
                int[] iArr2 = this.n;
                if (i2 >= iArr2.length) {
                    break;
                }
                int i3 = iArr2[i2];
                this.n[i2] = Color.argb(iAlpha, Color.red(i3), Color.green(i3), Color.blue(i3));
                i2++;
            }
        }
        this.n = n(this.n, this.o);
        int i4 = getArguments().getInt(ModelAuditLogEntry.CHANGE_KEY_COLOR);
        if (i4 != this.o) {
            this.n = n(this.n, i4);
        }
        if (z3) {
            int[] iArr3 = this.n;
            if (iArr3.length == 19) {
                int iArgb = Color.argb(iAlpha, 0, 0, 0);
                int length = iArr3.length;
                int i5 = 0;
                while (true) {
                    if (i5 >= length) {
                        z2 = false;
                        break;
                    }
                    if (iArr3[i5] == iArgb) {
                        z2 = true;
                        break;
                    }
                    i5++;
                }
                if (!z2) {
                    int length2 = iArr3.length + 1;
                    int[] iArr4 = new int[length2];
                    int i6 = length2 - 1;
                    iArr4[i6] = iArgb;
                    System.arraycopy(iArr3, 0, iArr4, 0, i6);
                    iArr3 = iArr4;
                }
                this.n = iArr3;
            }
        }
        if (this.r) {
            h(this.o);
            viewFindViewById.setVisibility(0);
            int i7 = getArguments().getInt("dividerColor", 0);
            if (i7 != 0) {
                viewFindViewById.setBackgroundTintList(ColorStateList.valueOf(i7));
            }
        } else {
            this.u.setVisibility(8);
            viewFindViewById.setVisibility(8);
        }
        h hVar = new h();
        int[] iArr5 = this.n;
        int i8 = 0;
        while (true) {
            int[] iArr6 = this.n;
            if (i8 >= iArr6.length) {
                i8 = -1;
                break;
            }
            if (iArr6[i8] == this.o) {
                break;
            }
            i8++;
        }
        ColorPaletteAdapter colorPaletteAdapter = new ColorPaletteAdapter(hVar, iArr5, i8, this.f3143s);
        this.t = colorPaletteAdapter;
        gridView.setAdapter((ListAdapter) colorPaletteAdapter);
        if (this.G) {
            int iAlpha2 = 255 - Color.alpha(this.o);
            this.v.setMax(255);
            this.v.setProgress(iAlpha2);
            this.w.setText(String.format(Locale.ENGLISH, "%d%%", Integer.valueOf((int) ((((double) iAlpha2) * 100.0d) / 255.0d))));
            this.v.setOnSeekBarChangeListener(new ColorPickerDialog2(this));
        } else {
            viewInflate.findViewById(R.c.transparency_layout).setVisibility(8);
            viewInflate.findViewById(R.c.transparency_title).setVisibility(8);
        }
        return viewInflate;
    }

    public void k(int i2) {
        this.o = i2;
        ColorPanelView colorPanelView = this.f3145y;
        if (colorPanelView != null) {
            colorPanelView.setColor(i2);
        }
        if (!this.I && this.A != null) {
            l(i2);
            if (this.A.hasFocus()) {
                ((InputMethodManager) e().getSystemService("input_method")).hideSoftInputFromWindow(this.A.getWindowToken(), 0);
                this.A.clearFocus();
            }
        }
        this.I = false;
    }

    public final void l(int i2) {
        if (this.G) {
            this.A.setText(String.format("%08X", Integer.valueOf(i2)));
        } else {
            this.A.setText(String.format("%06X", Integer.valueOf(i2 & ViewCompat.MEASURED_SIZE_MASK)));
        }
    }

    public final int m(@ColorInt int i2, double d2) {
        long j2 = Long.parseLong(String.format("#%06X", Integer.valueOf(16777215 & i2)).substring(1), 16);
        double d3 = d2 >= 0.0d ? 255.0d : 0.0d;
        if (d2 < 0.0d) {
            d2 *= -1.0d;
        }
        long j3 = j2 >> 16;
        long j4 = (j2 >> 8) & 255;
        long j5 = j2 & 255;
        return Color.argb(Color.alpha(i2), (int) (Math.round((d3 - j3) * d2) + j3), (int) (Math.round((d3 - j4) * d2) + j4), (int) (Math.round((d3 - j5) * d2) + j5));
    }

    public final int[] n(int[] iArr, int i2) {
        boolean z2;
        int length = iArr.length;
        int i3 = 0;
        while (true) {
            if (i3 >= length) {
                z2 = false;
                break;
            }
            if (iArr[i3] == i2) {
                z2 = true;
                break;
            }
            i3++;
        }
        if (z2) {
            return iArr;
        }
        int length2 = iArr.length + 1;
        int[] iArr2 = new int[length2];
        iArr2[0] = i2;
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
        View viewInflate = LayoutInflater.from(requireContext()).inflate(R.d.cpv_dialog, (ViewGroup) null);
        this.l = viewInflate;
        FrameLayout frameLayout = (FrameLayout) viewInflate.findViewById(R.c.cpv_color_picker_content);
        this.m = frameLayout;
        int i2 = this.p;
        if (i2 == 0) {
            frameLayout.addView(i());
        } else if (i2 == 1) {
            frameLayout.addView(j());
        }
        return new AlertDialog.Builder(requireActivity()).setView(this.l).create();
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        return this.l;
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        super.onDismiss(dialogInterface);
        if (this.k != null) {
            Log.w("ColorPickerDialog", "Using deprecated listener which may be remove in future releases");
            this.k.onDialogDismissed(this.q);
        } else {
            KeyEventDispatcher.Component componentE = e();
            if (componentE instanceof ColorPickerDialogListener) {
                ((ColorPickerDialogListener) componentE).onDialogDismissed(this.q);
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
    public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NonNull View view, @Nullable Bundle bundle) {
        int i2;
        super.onViewCreated(view, bundle);
        this.C = (TextView) view.findViewById(R.c.cpv_color_picker_title);
        this.D = (Button) view.findViewById(R.c.cpv_color_picker_custom_button);
        this.E = (Button) view.findViewById(R.c.cpv_color_picker_select_button);
        this.F = (TextView) view.findViewById(R.c.cpv_color_picker_custom_reset);
        int i3 = getArguments().getInt("backgroundColor", 0);
        if (i3 != 0) {
            view.setBackgroundColor(i3);
        }
        int i4 = getArguments().getInt("dialogTitle");
        if (i4 != 0) {
            this.C.setText(i4);
        }
        int i5 = getArguments().getInt("titleTextColor", 0);
        if (i5 != 0) {
            this.C.setTextColor(i5);
        }
        int i6 = getArguments().getInt("selectedButtonText");
        if (i6 == 0) {
            i6 = R.e.cpv_select;
        }
        this.E.setText(i6);
        this.E.setOnClickListener(new c());
        int i7 = getArguments().getInt("resetButtonText");
        if (i7 != 0) {
            this.F.setText(i7);
        }
        this.F.setOnClickListener(new d());
        this.H = getArguments().getInt("presetsButtonText");
        this.J = getArguments().getInt("customButtonText");
        if (this.p == 0 && getArguments().getBoolean("allowPresets")) {
            i2 = this.H;
            if (i2 == 0) {
                i2 = R.e.cpv_presets;
            }
        } else if (this.p == 1 && getArguments().getBoolean("allowCustom")) {
            i2 = this.J;
            if (i2 == 0) {
                i2 = R.e.cpv_custom;
            }
        } else {
            i2 = 0;
        }
        if (i2 != 0) {
            this.D.setText(i2);
            this.D.setVisibility(0);
        } else {
            this.D.setVisibility(8);
        }
        if (getArguments().getBoolean("allowReset")) {
            this.F.setVisibility(0);
        } else {
            this.F.setVisibility(8);
        }
        int i8 = getArguments().getInt("customButtonColor", 0);
        if (i8 != 0) {
            this.D.setBackgroundTintList(ColorStateList.valueOf(i8));
        }
        int i9 = getArguments().getInt("selectedButtonColor", 0);
        if (i9 != 0) {
            this.E.setBackgroundTintList(ColorStateList.valueOf(i9));
            this.F.setTextColor(i9);
        }
        int i10 = getArguments().getInt("customButtonTextColor", 0);
        if (i10 != 0) {
            this.D.setTextColor(i10);
        }
        int i11 = getArguments().getInt("selectedButtonTextColor", 0);
        if (i11 != 0) {
            this.E.setTextColor(i11);
        }
        int i12 = getArguments().getInt("titleFont", 0);
        if (i12 != 0) {
            this.C.setTypeface(ResourcesCompat.getFont(requireContext(), i12));
        }
        int i13 = getArguments().getInt("buttonFont", 0);
        if (i13 != 0) {
            this.E.setTypeface(ResourcesCompat.getFont(requireContext(), i13));
            this.D.setTypeface(ResourcesCompat.getFont(requireContext(), i13));
            this.F.setTypeface(ResourcesCompat.getFont(requireContext(), i13));
        }
        this.D.setOnClickListener(new e());
    }
}
