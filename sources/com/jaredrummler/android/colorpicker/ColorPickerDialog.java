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
import com.discord.models.domain.ModelAuditLogEntry;
import com.jaredrummler.android.colorpicker.ColorPickerView;
import java.util.Arrays;
import java.util.Locale;
import p007b.p440k.p441a.p442a.C5075b;
import p007b.p440k.p441a.p442a.C5078e;
import p007b.p440k.p441a.p442a.InterfaceC5079f;

/* JADX INFO: loaded from: classes3.dex */
public class ColorPickerDialog extends DialogFragment implements ColorPickerView.InterfaceC11166c, TextWatcher {

    /* JADX INFO: renamed from: j */
    public static final int[] f21707j = {-769226, -1499549, -54125, -6543440, -10011977, -12627531, -14575885, -16537100, -16728876, -16738680, -11751600, -7617718, -3285959, -5317, -16121, -26624, -8825528, -10453621, -6381922};

    /* JADX INFO: renamed from: A */
    public EditText f21708A;

    /* JADX INFO: renamed from: B */
    public View f21709B;

    /* JADX INFO: renamed from: C */
    public TextView f21710C;

    /* JADX INFO: renamed from: D */
    public Button f21711D;

    /* JADX INFO: renamed from: E */
    public Button f21712E;

    /* JADX INFO: renamed from: F */
    public TextView f21713F;

    /* JADX INFO: renamed from: G */
    public boolean f21714G;

    /* JADX INFO: renamed from: H */
    public int f21715H;

    /* JADX INFO: renamed from: I */
    public boolean f21716I;

    /* JADX INFO: renamed from: J */
    public int f21717J;

    /* JADX INFO: renamed from: K */
    public final View.OnTouchListener f21718K = new ViewOnTouchListenerC11154b();

    /* JADX INFO: renamed from: k */
    public InterfaceC5079f f21719k;

    /* JADX INFO: renamed from: l */
    public View f21720l;

    /* JADX INFO: renamed from: m */
    public FrameLayout f21721m;

    /* JADX INFO: renamed from: n */
    public int[] f21722n;

    /* JADX INFO: renamed from: o */
    @ColorInt
    public int f21723o;

    /* JADX INFO: renamed from: p */
    public int f21724p;

    /* JADX INFO: renamed from: q */
    public int f21725q;

    /* JADX INFO: renamed from: r */
    public boolean f21726r;

    /* JADX INFO: renamed from: s */
    public int f21727s;

    /* JADX INFO: renamed from: t */
    public C5075b f21728t;

    /* JADX INFO: renamed from: u */
    public LinearLayout f21729u;

    /* JADX INFO: renamed from: v */
    public SeekBar f21730v;

    /* JADX INFO: renamed from: w */
    public TextView f21731w;

    /* JADX INFO: renamed from: x */
    public ColorPickerView f21732x;

    /* JADX INFO: renamed from: y */
    public ColorPanelView f21733y;

    /* JADX INFO: renamed from: z */
    public EditText f21734z;

    /* JADX INFO: renamed from: com.jaredrummler.android.colorpicker.ColorPickerDialog$a */
    public class ViewOnLongClickListenerC11153a implements View.OnLongClickListener {

        /* JADX INFO: renamed from: j */
        public final /* synthetic */ ColorPanelView f21735j;

        public ViewOnLongClickListenerC11153a(ColorPickerDialog colorPickerDialog, ColorPanelView colorPanelView) {
            this.f21735j = colorPanelView;
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            this.f21735j.m9266a();
            return true;
        }
    }

    /* JADX INFO: renamed from: com.jaredrummler.android.colorpicker.ColorPickerDialog$b */
    public class ViewOnTouchListenerC11154b implements View.OnTouchListener {
        public ViewOnTouchListenerC11154b() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            EditText editText = ColorPickerDialog.this.f21708A;
            if (view == editText || !editText.hasFocus()) {
                return false;
            }
            ColorPickerDialog.this.f21708A.clearFocus();
            ((InputMethodManager) ColorPickerDialog.this.m95e().getSystemService("input_method")).hideSoftInputFromWindow(ColorPickerDialog.this.f21708A.getWindowToken(), 0);
            ColorPickerDialog.this.f21708A.clearFocus();
            return true;
        }
    }

    /* JADX INFO: renamed from: com.jaredrummler.android.colorpicker.ColorPickerDialog$c */
    public class ViewOnClickListenerC11155c implements View.OnClickListener {
        public ViewOnClickListenerC11155c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ColorPickerDialog colorPickerDialog = ColorPickerDialog.this;
            ColorPickerDialog.m9267g(colorPickerDialog, colorPickerDialog.f21723o);
            ColorPickerDialog.this.dismiss();
        }
    }

    /* JADX INFO: renamed from: com.jaredrummler.android.colorpicker.ColorPickerDialog$d */
    public class ViewOnClickListenerC11156d implements View.OnClickListener {
        public ViewOnClickListenerC11156d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ColorPickerDialog colorPickerDialog = ColorPickerDialog.this;
            if (colorPickerDialog.f21719k != null) {
                Log.w("ColorPickerDialog", "Using deprecated listener which may be remove in future releases");
                colorPickerDialog.f21719k.onColorReset(colorPickerDialog.f21725q);
            } else {
                KeyEventDispatcher.Component componentM95e = colorPickerDialog.m95e();
                if (!(componentM95e instanceof InterfaceC5079f)) {
                    throw new IllegalStateException("The activity must implement ColorPickerDialogListener");
                }
                ((InterfaceC5079f) componentM95e).onColorReset(colorPickerDialog.f21725q);
            }
            ColorPickerDialog.this.dismiss();
        }
    }

    /* JADX INFO: renamed from: com.jaredrummler.android.colorpicker.ColorPickerDialog$e */
    public class ViewOnClickListenerC11157e implements View.OnClickListener {
        public ViewOnClickListenerC11157e() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ColorPickerDialog.this.f21721m.removeAllViews();
            ColorPickerDialog colorPickerDialog = ColorPickerDialog.this;
            int i = colorPickerDialog.f21724p;
            if (i == 0) {
                colorPickerDialog.f21724p = 1;
                Button button = (Button) view;
                int i2 = colorPickerDialog.f21717J;
                if (i2 == 0) {
                    i2 = C11167R.e.cpv_custom;
                }
                button.setText(i2);
                ColorPickerDialog colorPickerDialog2 = ColorPickerDialog.this;
                colorPickerDialog2.f21721m.addView(colorPickerDialog2.m9270j());
                return;
            }
            if (i != 1) {
                return;
            }
            colorPickerDialog.f21724p = 0;
            Button button2 = (Button) view;
            int i3 = colorPickerDialog.f21715H;
            if (i3 == 0) {
                i3 = C11167R.e.cpv_presets;
            }
            button2.setText(i3);
            ColorPickerDialog colorPickerDialog3 = ColorPickerDialog.this;
            colorPickerDialog3.f21721m.addView(colorPickerDialog3.m9269i());
        }
    }

    /* JADX INFO: renamed from: com.jaredrummler.android.colorpicker.ColorPickerDialog$f */
    public class ViewOnClickListenerC11158f implements View.OnClickListener {
        public ViewOnClickListenerC11158f() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int color = ColorPickerDialog.this.f21733y.getColor();
            ColorPickerDialog colorPickerDialog = ColorPickerDialog.this;
            int i = colorPickerDialog.f21723o;
            if (color == i) {
                ColorPickerDialog.m9267g(colorPickerDialog, i);
                ColorPickerDialog.this.dismiss();
            }
        }
    }

    /* JADX INFO: renamed from: com.jaredrummler.android.colorpicker.ColorPickerDialog$g */
    public class ViewOnFocusChangeListenerC11159g implements View.OnFocusChangeListener {
        public ViewOnFocusChangeListenerC11159g() {
        }

        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z2) {
            if (z2) {
                ((InputMethodManager) ColorPickerDialog.this.m95e().getSystemService("input_method")).showSoftInput(ColorPickerDialog.this.f21708A, 1);
            }
        }
    }

    /* JADX INFO: renamed from: com.jaredrummler.android.colorpicker.ColorPickerDialog$h */
    public class C11160h implements C5075b.a {
        public C11160h() {
        }
    }

    /* JADX INFO: renamed from: com.jaredrummler.android.colorpicker.ColorPickerDialog$i */
    public class RunnableC11161i implements Runnable {

        /* JADX INFO: renamed from: j */
        public final /* synthetic */ ColorPanelView f21743j;

        /* JADX INFO: renamed from: k */
        public final /* synthetic */ int f21744k;

        public RunnableC11161i(ColorPickerDialog colorPickerDialog, ColorPanelView colorPanelView, int i) {
            this.f21743j = colorPanelView;
            this.f21744k = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f21743j.setColor(this.f21744k);
        }
    }

    /* JADX INFO: renamed from: com.jaredrummler.android.colorpicker.ColorPickerDialog$j */
    public class ViewOnClickListenerC11162j implements View.OnClickListener {

        /* JADX INFO: renamed from: j */
        public final /* synthetic */ ColorPanelView f21745j;

        public ViewOnClickListenerC11162j(ColorPanelView colorPanelView) {
            this.f21745j = colorPanelView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if ((view.getTag() instanceof Boolean) && ((Boolean) view.getTag()).booleanValue()) {
                ColorPickerDialog colorPickerDialog = ColorPickerDialog.this;
                ColorPickerDialog.m9267g(colorPickerDialog, colorPickerDialog.f21723o);
                ColorPickerDialog.this.dismiss();
                return;
            }
            ColorPickerDialog.this.f21723o = this.f21745j.getColor();
            C5075b c5075b = ColorPickerDialog.this.f21728t;
            c5075b.f13607l = -1;
            c5075b.notifyDataSetChanged();
            for (int i = 0; i < ColorPickerDialog.this.f21729u.getChildCount(); i++) {
                FrameLayout frameLayout = (FrameLayout) ColorPickerDialog.this.f21729u.getChildAt(i);
                ColorPanelView colorPanelView = (ColorPanelView) frameLayout.findViewById(C11167R.c.cpv_color_panel_view);
                ImageView imageView = (ImageView) frameLayout.findViewById(C11167R.c.cpv_color_image_view);
                imageView.setImageResource(colorPanelView == view ? C11167R.b.cpv_preset_checked : 0);
                if ((colorPanelView != view || ColorUtils.calculateLuminance(colorPanelView.getColor()) < 0.65d) && Color.alpha(colorPanelView.getColor()) > 165) {
                    imageView.setColorFilter((ColorFilter) null);
                } else {
                    imageView.setColorFilter(ViewCompat.MEASURED_STATE_MASK, PorterDuff.Mode.SRC_IN);
                }
                colorPanelView.setTag(Boolean.valueOf(colorPanelView == view));
            }
        }
    }

    /* JADX INFO: renamed from: com.jaredrummler.android.colorpicker.ColorPickerDialog$k */
    public static final class C11163k {

        /* JADX INFO: renamed from: a */
        @StringRes
        public int f21747a = C11167R.e.cpv_default_title;

        /* JADX INFO: renamed from: b */
        @StringRes
        public int f21748b = C11167R.e.cpv_presets;

        /* JADX INFO: renamed from: c */
        @StringRes
        public int f21749c = C11167R.e.cpv_custom;

        /* JADX INFO: renamed from: d */
        @StringRes
        public int f21750d = C11167R.e.cpv_select;

        /* JADX INFO: renamed from: e */
        @StringRes
        public int f21751e = 0;

        /* JADX INFO: renamed from: f */
        public int f21752f = 1;

        /* JADX INFO: renamed from: g */
        public int[] f21753g = ColorPickerDialog.f21707j;

        /* JADX INFO: renamed from: h */
        @ColorInt
        public int f21754h = ViewCompat.MEASURED_STATE_MASK;

        /* JADX INFO: renamed from: i */
        public boolean f21755i = false;

        /* JADX INFO: renamed from: j */
        public boolean f21756j = true;

        /* JADX INFO: renamed from: k */
        public boolean f21757k = true;

        /* JADX INFO: renamed from: l */
        public boolean f21758l = true;

        /* JADX INFO: renamed from: m */
        public boolean f21759m = true;

        /* JADX INFO: renamed from: n */
        public int f21760n = 1;

        /* JADX INFO: renamed from: o */
        @ColorInt
        public int f21761o = 0;

        /* JADX INFO: renamed from: p */
        @ColorInt
        public int f21762p = 0;

        /* JADX INFO: renamed from: q */
        @ColorInt
        public int f21763q = 0;

        /* JADX INFO: renamed from: r */
        @ColorInt
        public int f21764r = 0;

        /* JADX INFO: renamed from: s */
        @ColorInt
        public int f21765s = 0;

        /* JADX INFO: renamed from: t */
        @ColorInt
        public int f21766t = 0;

        /* JADX INFO: renamed from: u */
        @DrawableRes
        public int f21767u = 0;

        /* JADX INFO: renamed from: v */
        @ColorInt
        public int f21768v = 0;

        /* JADX INFO: renamed from: w */
        @ColorInt
        public int f21769w = 0;

        /* JADX INFO: renamed from: x */
        @FontRes
        public int f21770x = 0;

        /* JADX INFO: renamed from: y */
        @FontRes
        public int f21771y = 0;

        /* JADX INFO: renamed from: z */
        @FontRes
        public int f21772z = 0;

        /* JADX INFO: renamed from: a */
        public ColorPickerDialog m9275a() {
            ColorPickerDialog colorPickerDialog = new ColorPickerDialog();
            Bundle bundle = new Bundle();
            bundle.putInt(ModelAuditLogEntry.CHANGE_KEY_ID, 0);
            bundle.putInt("dialogType", this.f21752f);
            bundle.putInt(ModelAuditLogEntry.CHANGE_KEY_COLOR, this.f21754h);
            bundle.putIntArray("presets", this.f21753g);
            bundle.putBoolean(Key.ALPHA, this.f21755i);
            bundle.putBoolean("allowCustom", this.f21757k);
            bundle.putBoolean("allowPresets", this.f21756j);
            bundle.putBoolean("allowReset", this.f21758l);
            bundle.putInt("dialogTitle", this.f21747a);
            bundle.putBoolean("showColorShades", this.f21759m);
            bundle.putInt("colorShape", this.f21760n);
            bundle.putInt("presetsButtonText", this.f21748b);
            bundle.putInt("customButtonText", this.f21749c);
            bundle.putInt("customButtonColor", this.f21761o);
            bundle.putInt("customButtonTextColor", this.f21768v);
            bundle.putInt("selectedButtonText", this.f21750d);
            bundle.putInt("selectedButtonColor", this.f21762p);
            bundle.putInt("selectedButtonTextColor", this.f21769w);
            bundle.putInt("resetButtonText", this.f21751e);
            bundle.putInt("buttonFont", this.f21771y);
            bundle.putInt("titleTextColor", this.f21764r);
            bundle.putInt("titleFont", this.f21770x);
            bundle.putInt("dividerColor", this.f21763q);
            bundle.putInt("backgroundColor", this.f21765s);
            bundle.putInt("inputTextColor", this.f21766t);
            bundle.putInt("inputBackground", this.f21767u);
            bundle.putInt("inputFont", this.f21772z);
            colorPickerDialog.setArguments(bundle);
            return colorPickerDialog;
        }
    }

    /* JADX INFO: renamed from: g */
    public static void m9267g(ColorPickerDialog colorPickerDialog, int i) {
        if (colorPickerDialog.f21719k != null) {
            Log.w("ColorPickerDialog", "Using deprecated listener which may be remove in future releases");
            colorPickerDialog.f21719k.onColorSelected(colorPickerDialog.f21725q, i);
        } else {
            KeyEventDispatcher.Component componentM95e = colorPickerDialog.m95e();
            if (!(componentM95e instanceof InterfaceC5079f)) {
                throw new IllegalStateException("The activity must implement ColorPickerDialogListener");
            }
            ((InterfaceC5079f) componentM95e).onColorSelected(colorPickerDialog.f21725q, i);
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
        if (this.f21708A.isFocused()) {
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
                if (iArgb != this.f21732x.getColor()) {
                    this.f21716I = true;
                    this.f21732x.m9277b(iArgb, true);
                }
            }
            i8 = 0;
            i6 = i8;
            i7 = 0;
            i2 = i7;
            i = i6;
            i10 = 255;
            iArgb = Color.argb(i10, i2, i9, i);
            if (iArgb != this.f21732x.getColor()) {
                this.f21716I = true;
                this.f21732x.m9277b(iArgb, true);
            }
        }
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    /* JADX INFO: renamed from: h */
    public void m9268h(@ColorInt int i) {
        int i2 = 0;
        int[] iArr = {m9273m(i, 0.9d), m9273m(i, 0.7d), m9273m(i, 0.5d), m9273m(i, 0.333d), m9273m(i, 0.166d), m9273m(i, -0.125d), m9273m(i, -0.25d), m9273m(i, -0.375d), m9273m(i, -0.5d), m9273m(i, -0.675d), m9273m(i, -0.7d), m9273m(i, -0.775d)};
        if (this.f21729u.getChildCount() != 0) {
            while (i2 < this.f21729u.getChildCount()) {
                FrameLayout frameLayout = (FrameLayout) this.f21729u.getChildAt(i2);
                ColorPanelView colorPanelView = (ColorPanelView) frameLayout.findViewById(C11167R.c.cpv_color_panel_view);
                ImageView imageView = (ImageView) frameLayout.findViewById(C11167R.c.cpv_color_image_view);
                colorPanelView.setColor(iArr[i2]);
                colorPanelView.setTag(Boolean.FALSE);
                imageView.setImageDrawable(null);
                i2++;
            }
            return;
        }
        int dimensionPixelSize = getResources().getDimensionPixelSize(C11167R.a.cpv_item_horizontal_padding);
        while (i2 < 12) {
            int i3 = iArr[i2];
            View viewInflate = View.inflate(m95e(), this.f21727s == 0 ? C11167R.d.cpv_color_item_square : C11167R.d.cpv_color_item_circle, null);
            ColorPanelView colorPanelView2 = (ColorPanelView) viewInflate.findViewById(C11167R.c.cpv_color_panel_view);
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) colorPanelView2.getLayoutParams();
            marginLayoutParams.rightMargin = dimensionPixelSize;
            marginLayoutParams.leftMargin = dimensionPixelSize;
            colorPanelView2.setLayoutParams(marginLayoutParams);
            colorPanelView2.setColor(i3);
            this.f21729u.addView(viewInflate);
            colorPanelView2.post(new RunnableC11161i(this, colorPanelView2, i3));
            colorPanelView2.setOnClickListener(new ViewOnClickListenerC11162j(colorPanelView2));
            colorPanelView2.setOnLongClickListener(new ViewOnLongClickListenerC11153a(this, colorPanelView2));
            i2++;
        }
    }

    /* JADX INFO: renamed from: i */
    public View m9269i() {
        View viewInflate = View.inflate(m95e(), C11167R.d.cpv_dialog_color_picker, null);
        this.f21732x = (ColorPickerView) viewInflate.findViewById(C11167R.c.cpv_color_picker_view);
        this.f21733y = (ColorPanelView) viewInflate.findViewById(C11167R.c.cpv_color_panel_new);
        this.f21708A = (EditText) viewInflate.findViewById(C11167R.c.cpv_hex);
        this.f21734z = (EditText) viewInflate.findViewById(C11167R.c.cpv_hex_prefix);
        this.f21709B = viewInflate.findViewById(C11167R.c.cpv_hex_container);
        this.f21732x.setAlphaSliderVisible(this.f21714G);
        this.f21732x.m9277b(this.f21723o, true);
        this.f21733y.setColor(this.f21723o);
        m9272l(this.f21723o);
        if (!this.f21714G) {
            this.f21708A.setFilters(new InputFilter[]{new InputFilter.LengthFilter(6)});
        }
        this.f21733y.setOnClickListener(new ViewOnClickListenerC11158f());
        viewInflate.setOnTouchListener(this.f21718K);
        this.f21732x.setOnColorChangedListener(this);
        this.f21708A.addTextChangedListener(this);
        this.f21708A.setOnFocusChangeListener(new ViewOnFocusChangeListenerC11159g());
        int i = getArguments().getInt("inputTextColor", 0);
        if (i != 0) {
            this.f21708A.setTextColor(i);
            this.f21734z.setTextColor(i);
        }
        int i2 = getArguments().getInt("inputBackground", 0);
        if (i2 != 0) {
            this.f21709B.setBackgroundResource(i2);
        }
        int i3 = getArguments().getInt("inputFont", 0);
        if (i3 != 0) {
            this.f21708A.setTypeface(ResourcesCompat.getFont(requireContext(), i3));
            this.f21734z.setTypeface(ResourcesCompat.getFont(requireContext(), i3));
        }
        return viewInflate;
    }

    /* JADX INFO: renamed from: j */
    public View m9270j() {
        boolean z2;
        View viewInflate = View.inflate(m95e(), C11167R.d.cpv_dialog_presets, null);
        this.f21729u = (LinearLayout) viewInflate.findViewById(C11167R.c.shades_layout);
        this.f21730v = (SeekBar) viewInflate.findViewById(C11167R.c.transparency_seekbar);
        this.f21731w = (TextView) viewInflate.findViewById(C11167R.c.transparency_text);
        GridView gridView = (GridView) viewInflate.findViewById(C11167R.c.gridView);
        View viewFindViewById = viewInflate.findViewById(C11167R.c.shades_divider);
        int iAlpha = Color.alpha(this.f21723o);
        int[] intArray = getArguments().getIntArray("presets");
        this.f21722n = intArray;
        if (intArray == null) {
            this.f21722n = f21707j;
        }
        int[] iArr = this.f21722n;
        boolean z3 = iArr == f21707j;
        this.f21722n = Arrays.copyOf(iArr, iArr.length);
        if (iAlpha != 255) {
            int i = 0;
            while (true) {
                int[] iArr2 = this.f21722n;
                if (i >= iArr2.length) {
                    break;
                }
                int i2 = iArr2[i];
                this.f21722n[i] = Color.argb(iAlpha, Color.red(i2), Color.green(i2), Color.blue(i2));
                i++;
            }
        }
        this.f21722n = m9274n(this.f21722n, this.f21723o);
        int i3 = getArguments().getInt(ModelAuditLogEntry.CHANGE_KEY_COLOR);
        if (i3 != this.f21723o) {
            this.f21722n = m9274n(this.f21722n, i3);
        }
        if (z3) {
            int[] iArr3 = this.f21722n;
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
                this.f21722n = iArr3;
            }
        }
        if (this.f21726r) {
            m9268h(this.f21723o);
            viewFindViewById.setVisibility(0);
            int i6 = getArguments().getInt("dividerColor", 0);
            if (i6 != 0) {
                viewFindViewById.setBackgroundTintList(ColorStateList.valueOf(i6));
            }
        } else {
            this.f21729u.setVisibility(8);
            viewFindViewById.setVisibility(8);
        }
        C11160h c11160h = new C11160h();
        int[] iArr5 = this.f21722n;
        int i7 = 0;
        while (true) {
            int[] iArr6 = this.f21722n;
            if (i7 >= iArr6.length) {
                i7 = -1;
                break;
            }
            if (iArr6[i7] == this.f21723o) {
                break;
            }
            i7++;
        }
        C5075b c5075b = new C5075b(c11160h, iArr5, i7, this.f21727s);
        this.f21728t = c5075b;
        gridView.setAdapter((ListAdapter) c5075b);
        if (this.f21714G) {
            int iAlpha2 = 255 - Color.alpha(this.f21723o);
            this.f21730v.setMax(255);
            this.f21730v.setProgress(iAlpha2);
            this.f21731w.setText(String.format(Locale.ENGLISH, "%d%%", Integer.valueOf((int) ((((double) iAlpha2) * 100.0d) / 255.0d))));
            this.f21730v.setOnSeekBarChangeListener(new C5078e(this));
        } else {
            viewInflate.findViewById(C11167R.c.transparency_layout).setVisibility(8);
            viewInflate.findViewById(C11167R.c.transparency_title).setVisibility(8);
        }
        return viewInflate;
    }

    /* JADX INFO: renamed from: k */
    public void m9271k(int i) {
        this.f21723o = i;
        ColorPanelView colorPanelView = this.f21733y;
        if (colorPanelView != null) {
            colorPanelView.setColor(i);
        }
        if (!this.f21716I && this.f21708A != null) {
            m9272l(i);
            if (this.f21708A.hasFocus()) {
                ((InputMethodManager) m95e().getSystemService("input_method")).hideSoftInputFromWindow(this.f21708A.getWindowToken(), 0);
                this.f21708A.clearFocus();
            }
        }
        this.f21716I = false;
    }

    /* JADX INFO: renamed from: l */
    public final void m9272l(int i) {
        if (this.f21714G) {
            this.f21708A.setText(String.format("%08X", Integer.valueOf(i)));
        } else {
            this.f21708A.setText(String.format("%06X", Integer.valueOf(i & ViewCompat.MEASURED_SIZE_MASK)));
        }
    }

    /* JADX INFO: renamed from: m */
    public final int m9273m(@ColorInt int i, double d) {
        long j = Long.parseLong(String.format("#%06X", Integer.valueOf(16777215 & i)).substring(1), 16);
        double d2 = d >= 0.0d ? 255.0d : 0.0d;
        if (d < 0.0d) {
            d *= -1.0d;
        }
        long j2 = j >> 16;
        long j3 = (j >> 8) & 255;
        long j4 = j & 255;
        return Color.argb(Color.alpha(i), (int) (Math.round((d2 - j2) * d) + j2), (int) (Math.round((d2 - j3) * d) + j3), (int) (Math.round((d2 - j4) * d) + j4));
    }

    /* JADX INFO: renamed from: n */
    public final int[] m9274n(int[] iArr, int i) {
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
        this.f21725q = getArguments().getInt(ModelAuditLogEntry.CHANGE_KEY_ID);
        this.f21714G = getArguments().getBoolean(Key.ALPHA);
        this.f21726r = getArguments().getBoolean("showColorShades");
        this.f21727s = getArguments().getInt("colorShape");
        if (bundle == null) {
            this.f21723o = getArguments().getInt(ModelAuditLogEntry.CHANGE_KEY_COLOR);
            this.f21724p = getArguments().getInt("dialogType");
        } else {
            this.f21723o = bundle.getInt(ModelAuditLogEntry.CHANGE_KEY_COLOR);
            this.f21724p = bundle.getInt("dialogType");
        }
        View viewInflate = LayoutInflater.from(requireContext()).inflate(C11167R.d.cpv_dialog, (ViewGroup) null);
        this.f21720l = viewInflate;
        FrameLayout frameLayout = (FrameLayout) viewInflate.findViewById(C11167R.c.cpv_color_picker_content);
        this.f21721m = frameLayout;
        int i = this.f21724p;
        if (i == 0) {
            frameLayout.addView(m9269i());
        } else if (i == 1) {
            frameLayout.addView(m9270j());
        }
        return new AlertDialog.Builder(requireActivity()).setView(this.f21720l).create();
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        return this.f21720l;
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        super.onDismiss(dialogInterface);
        if (this.f21719k != null) {
            Log.w("ColorPickerDialog", "Using deprecated listener which may be remove in future releases");
            this.f21719k.onDialogDismissed(this.f21725q);
        } else {
            KeyEventDispatcher.Component componentM95e = m95e();
            if (componentM95e instanceof InterfaceC5079f) {
                ((InterfaceC5079f) componentM95e).onDialogDismissed(this.f21725q);
            }
        }
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        bundle.putInt(ModelAuditLogEntry.CHANGE_KEY_COLOR, this.f21723o);
        bundle.putInt("dialogType", this.f21724p);
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
        this.f21710C = (TextView) view.findViewById(C11167R.c.cpv_color_picker_title);
        this.f21711D = (Button) view.findViewById(C11167R.c.cpv_color_picker_custom_button);
        this.f21712E = (Button) view.findViewById(C11167R.c.cpv_color_picker_select_button);
        this.f21713F = (TextView) view.findViewById(C11167R.c.cpv_color_picker_custom_reset);
        int i2 = getArguments().getInt("backgroundColor", 0);
        if (i2 != 0) {
            view.setBackgroundColor(i2);
        }
        int i3 = getArguments().getInt("dialogTitle");
        if (i3 != 0) {
            this.f21710C.setText(i3);
        }
        int i4 = getArguments().getInt("titleTextColor", 0);
        if (i4 != 0) {
            this.f21710C.setTextColor(i4);
        }
        int i5 = getArguments().getInt("selectedButtonText");
        if (i5 == 0) {
            i5 = C11167R.e.cpv_select;
        }
        this.f21712E.setText(i5);
        this.f21712E.setOnClickListener(new ViewOnClickListenerC11155c());
        int i6 = getArguments().getInt("resetButtonText");
        if (i6 != 0) {
            this.f21713F.setText(i6);
        }
        this.f21713F.setOnClickListener(new ViewOnClickListenerC11156d());
        this.f21715H = getArguments().getInt("presetsButtonText");
        this.f21717J = getArguments().getInt("customButtonText");
        if (this.f21724p == 0 && getArguments().getBoolean("allowPresets")) {
            i = this.f21715H;
            if (i == 0) {
                i = C11167R.e.cpv_presets;
            }
        } else if (this.f21724p == 1 && getArguments().getBoolean("allowCustom")) {
            i = this.f21717J;
            if (i == 0) {
                i = C11167R.e.cpv_custom;
            }
        } else {
            i = 0;
        }
        if (i != 0) {
            this.f21711D.setText(i);
            this.f21711D.setVisibility(0);
        } else {
            this.f21711D.setVisibility(8);
        }
        if (getArguments().getBoolean("allowReset")) {
            this.f21713F.setVisibility(0);
        } else {
            this.f21713F.setVisibility(8);
        }
        int i7 = getArguments().getInt("customButtonColor", 0);
        if (i7 != 0) {
            this.f21711D.setBackgroundTintList(ColorStateList.valueOf(i7));
        }
        int i8 = getArguments().getInt("selectedButtonColor", 0);
        if (i8 != 0) {
            this.f21712E.setBackgroundTintList(ColorStateList.valueOf(i8));
            this.f21713F.setTextColor(i8);
        }
        int i9 = getArguments().getInt("customButtonTextColor", 0);
        if (i9 != 0) {
            this.f21711D.setTextColor(i9);
        }
        int i10 = getArguments().getInt("selectedButtonTextColor", 0);
        if (i10 != 0) {
            this.f21712E.setTextColor(i10);
        }
        int i11 = getArguments().getInt("titleFont", 0);
        if (i11 != 0) {
            this.f21710C.setTypeface(ResourcesCompat.getFont(requireContext(), i11));
        }
        int i12 = getArguments().getInt("buttonFont", 0);
        if (i12 != 0) {
            this.f21712E.setTypeface(ResourcesCompat.getFont(requireContext(), i12));
            this.f21711D.setTypeface(ResourcesCompat.getFont(requireContext(), i12));
            this.f21713F.setTypeface(ResourcesCompat.getFont(requireContext(), i12));
        }
        this.f21711D.setOnClickListener(new ViewOnClickListenerC11157e());
    }
}
