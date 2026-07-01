package b.k.a.a;

import android.graphics.Color;
import android.graphics.PorterDuff;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.SeekBar;
import androidx.core.graphics.ColorUtils;
import androidx.core.view.ViewCompat;
import com.jaredrummler.android.colorpicker.ColorPanelView;
import com.jaredrummler.android.colorpicker.ColorPickerDialog;
import com.jaredrummler.android.colorpicker.R;
import java.util.Locale;

/* JADX INFO: renamed from: b.k.a.a.e, reason: use source file name */
/* JADX INFO: compiled from: ColorPickerDialog.java */
/* JADX INFO: loaded from: classes3.dex */
public class ColorPickerDialog2 implements SeekBar.OnSeekBarChangeListener {
    public final /* synthetic */ ColorPickerDialog a;

    public ColorPickerDialog2(ColorPickerDialog colorPickerDialog) {
        this.a = colorPickerDialog;
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onProgressChanged(SeekBar seekBar, int i, boolean z2) {
        ColorPaletteAdapter colorPaletteAdapter;
        this.a.w.setText(String.format(Locale.ENGLISH, "%d%%", Integer.valueOf((int) ((((double) i) * 100.0d) / 255.0d))));
        int i2 = 255 - i;
        int i3 = 0;
        while (true) {
            colorPaletteAdapter = this.a.t;
            int[] iArr = colorPaletteAdapter.k;
            if (i3 >= iArr.length) {
                break;
            }
            int i4 = iArr[i3];
            this.a.t.k[i3] = Color.argb(i2, Color.red(i4), Color.green(i4), Color.blue(i4));
            i3++;
        }
        colorPaletteAdapter.notifyDataSetChanged();
        for (int i5 = 0; i5 < this.a.u.getChildCount(); i5++) {
            FrameLayout frameLayout = (FrameLayout) this.a.u.getChildAt(i5);
            ColorPanelView colorPanelView = (ColorPanelView) frameLayout.findViewById(R.c.cpv_color_panel_view);
            ImageView imageView = (ImageView) frameLayout.findViewById(R.c.cpv_color_image_view);
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
        this.a.o = Color.argb(i2, Color.red(this.a.o), Color.green(this.a.o), Color.blue(this.a.o));
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onStartTrackingTouch(SeekBar seekBar) {
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onStopTrackingTouch(SeekBar seekBar) {
    }
}
