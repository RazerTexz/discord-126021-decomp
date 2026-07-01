package b.k.a.a;

import android.view.View;
import b.k.a.a.ColorPaletteAdapter;
import com.jaredrummler.android.colorpicker.ColorPickerDialog;

/* JADX INFO: renamed from: b.k.a.a.c, reason: use source file name */
/* JADX INFO: compiled from: ColorPaletteAdapter.java */
/* JADX INFO: loaded from: classes3.dex */
public class ColorPaletteAdapter2 implements View.OnClickListener {
    public final /* synthetic */ int j;
    public final /* synthetic */ ColorPaletteAdapter.b k;

    public ColorPaletteAdapter2(ColorPaletteAdapter.b bVar, int i) {
        this.k = bVar;
        this.j = i;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ColorPaletteAdapter colorPaletteAdapter = ColorPaletteAdapter.this;
        int i = colorPaletteAdapter.l;
        int i2 = this.j;
        if (i != i2) {
            colorPaletteAdapter.l = i2;
            colorPaletteAdapter.notifyDataSetChanged();
        }
        ColorPaletteAdapter colorPaletteAdapter2 = ColorPaletteAdapter.this;
        ColorPaletteAdapter.a aVar = colorPaletteAdapter2.j;
        int i3 = colorPaletteAdapter2.k[this.j];
        ColorPickerDialog.h hVar = (ColorPickerDialog.h) aVar;
        ColorPickerDialog colorPickerDialog = ColorPickerDialog.this;
        int i4 = colorPickerDialog.o;
        if (i4 == i3) {
            ColorPickerDialog.g(colorPickerDialog, i4);
            ColorPickerDialog.this.dismiss();
        } else {
            colorPickerDialog.o = i3;
            if (colorPickerDialog.r) {
                colorPickerDialog.h(i3);
            }
        }
    }
}
