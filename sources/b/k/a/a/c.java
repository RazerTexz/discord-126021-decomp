package b.k.a.a;

import android.view.View;
import android.view.View$OnClickListener;
import com.jaredrummler.android.colorpicker.ColorPickerDialog;
import com.jaredrummler.android.colorpicker.ColorPickerDialog$h;

/* JADX INFO: compiled from: ColorPaletteAdapter.java */
/* JADX INFO: loaded from: classes3.dex */
public class c implements View$OnClickListener {
    public final /* synthetic */ int j;
    public final /* synthetic */ b$b k;

    public c(b$b b_b, int i) {
        this.k = b_b;
        this.j = i;
    }

    @Override // android.view.View$OnClickListener
    public void onClick(View view) {
        b bVar = this.k.e;
        int i = bVar.l;
        int i2 = this.j;
        if (i != i2) {
            bVar.l = i2;
            bVar.notifyDataSetChanged();
        }
        b bVar2 = this.k.e;
        b$a b_a = bVar2.j;
        int i3 = bVar2.k[this.j];
        ColorPickerDialog$h colorPickerDialog$h = (ColorPickerDialog$h) b_a;
        ColorPickerDialog colorPickerDialog = colorPickerDialog$h.a;
        int i4 = colorPickerDialog.o;
        if (i4 == i3) {
            ColorPickerDialog.g(colorPickerDialog, i4);
            colorPickerDialog$h.a.dismiss();
        } else {
            colorPickerDialog.o = i3;
            if (colorPickerDialog.r) {
                colorPickerDialog.h(i3);
            }
        }
    }
}
