package p007b.p440k.p441a.p442a;

import android.graphics.Color;
import android.graphics.PorterDuff;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.SeekBar;
import androidx.core.graphics.ColorUtils;
import androidx.core.view.ViewCompat;
import com.jaredrummler.android.colorpicker.C11167R;
import com.jaredrummler.android.colorpicker.ColorPanelView;
import com.jaredrummler.android.colorpicker.ColorPickerDialog;
import java.util.Locale;

/* JADX INFO: renamed from: b.k.a.a.e */
/* JADX INFO: compiled from: ColorPickerDialog.java */
/* JADX INFO: loaded from: classes3.dex */
public class C5078e implements SeekBar.OnSeekBarChangeListener {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ ColorPickerDialog f13617a;

    public C5078e(ColorPickerDialog colorPickerDialog) {
        this.f13617a = colorPickerDialog;
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onProgressChanged(SeekBar seekBar, int i, boolean z2) {
        C5075b c5075b;
        this.f13617a.f21731w.setText(String.format(Locale.ENGLISH, "%d%%", Integer.valueOf((int) ((((double) i) * 100.0d) / 255.0d))));
        int i2 = 255 - i;
        int i3 = 0;
        while (true) {
            c5075b = this.f13617a.f21728t;
            int[] iArr = c5075b.f13606k;
            if (i3 >= iArr.length) {
                break;
            }
            int i4 = iArr[i3];
            this.f13617a.f21728t.f13606k[i3] = Color.argb(i2, Color.red(i4), Color.green(i4), Color.blue(i4));
            i3++;
        }
        c5075b.notifyDataSetChanged();
        for (int i5 = 0; i5 < this.f13617a.f21729u.getChildCount(); i5++) {
            FrameLayout frameLayout = (FrameLayout) this.f13617a.f21729u.getChildAt(i5);
            ColorPanelView colorPanelView = (ColorPanelView) frameLayout.findViewById(C11167R.c.cpv_color_panel_view);
            ImageView imageView = (ImageView) frameLayout.findViewById(C11167R.c.cpv_color_image_view);
            if (frameLayout.getTag() == null) {
                frameLayout.setTag(Integer.valueOf(colorPanelView.getBorderColor()));
            }
            int color = colorPanelView.getColor();
            int iArgb = Color.argb(i2, Color.red(color), Color.green(color), Color.blue(color));
            if (i2 <= 165) {
                colorPanelView.setBorderColor(iArgb | ViewCompat.MEASURED_STATE_MASK);
            } else {
                colorPanelView.setBorderColor(((Integer) frameLayout.getTag()).intValue());
            }
            if (colorPanelView.getTag() != null && ((Boolean) colorPanelView.getTag()).booleanValue()) {
                if (i2 <= 165) {
                    imageView.setColorFilter(ViewCompat.MEASURED_STATE_MASK, PorterDuff.Mode.SRC_IN);
                } else if (ColorUtils.calculateLuminance(iArgb) >= 0.65d) {
                    imageView.setColorFilter(ViewCompat.MEASURED_STATE_MASK, PorterDuff.Mode.SRC_IN);
                } else {
                    imageView.setColorFilter(-1, PorterDuff.Mode.SRC_IN);
                }
            }
            colorPanelView.setColor(iArgb);
        }
        this.f13617a.f21723o = Color.argb(i2, Color.red(this.f13617a.f21723o), Color.green(this.f13617a.f21723o), Color.blue(this.f13617a.f21723o));
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onStartTrackingTouch(SeekBar seekBar) {
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onStopTrackingTouch(SeekBar seekBar) {
    }
}
