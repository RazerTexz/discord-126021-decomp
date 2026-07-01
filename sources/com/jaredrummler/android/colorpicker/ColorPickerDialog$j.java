package com.jaredrummler.android.colorpicker;

import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff$Mode;
import android.view.View;
import android.view.View$OnClickListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.core.graphics.ColorUtils;
import androidx.core.view.ViewCompat;
import b.k.a.a.b;

/* JADX INFO: loaded from: classes3.dex */
public class ColorPickerDialog$j implements View$OnClickListener {
    public final /* synthetic */ ColorPanelView j;
    public final /* synthetic */ ColorPickerDialog k;

    public ColorPickerDialog$j(ColorPickerDialog colorPickerDialog, ColorPanelView colorPanelView) {
        this.k = colorPickerDialog;
        this.j = colorPanelView;
    }

    @Override // android.view.View$OnClickListener
    public void onClick(View view) {
        if ((view.getTag() instanceof Boolean) && ((Boolean) view.getTag()).booleanValue()) {
            ColorPickerDialog colorPickerDialog = this.k;
            ColorPickerDialog.g(colorPickerDialog, colorPickerDialog.o);
            this.k.dismiss();
            return;
        }
        this.k.o = this.j.getColor();
        b bVar = this.k.t;
        bVar.l = -1;
        bVar.notifyDataSetChanged();
        for (int i = 0; i < this.k.u.getChildCount(); i++) {
            FrameLayout frameLayout = (FrameLayout) this.k.u.getChildAt(i);
            ColorPanelView colorPanelView = (ColorPanelView) frameLayout.findViewById(R$c.cpv_color_panel_view);
            ImageView imageView = (ImageView) frameLayout.findViewById(R$c.cpv_color_image_view);
            imageView.setImageResource(colorPanelView == view ? R$b.cpv_preset_checked : 0);
            if ((colorPanelView != view || ColorUtils.calculateLuminance(colorPanelView.getColor()) < 0.65d) && Color.alpha(colorPanelView.getColor()) > 165) {
                imageView.setColorFilter((ColorFilter) null);
            } else {
                imageView.setColorFilter(ViewCompat.MEASURED_STATE_MASK, PorterDuff$Mode.SRC_IN);
            }
            colorPanelView.setTag(Boolean.valueOf(colorPanelView == view));
        }
    }
}
