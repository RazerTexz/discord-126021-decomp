package p007b.p440k.p441a.p442a;

import android.view.View;
import com.jaredrummler.android.colorpicker.ColorPickerDialog;

/* JADX INFO: renamed from: b.k.a.a.c */
/* JADX INFO: compiled from: ColorPaletteAdapter.java */
/* JADX INFO: loaded from: classes3.dex */
public class ViewOnClickListenerC5076c implements View.OnClickListener {

    /* JADX INFO: renamed from: j */
    public final /* synthetic */ int f13614j;

    /* JADX INFO: renamed from: k */
    public final /* synthetic */ C5075b.b f13615k;

    public ViewOnClickListenerC5076c(C5075b.b bVar, int i) {
        this.f13615k = bVar;
        this.f13614j = i;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        C5075b c5075b = C5075b.this;
        int i = c5075b.f13607l;
        int i2 = this.f13614j;
        if (i != i2) {
            c5075b.f13607l = i2;
            c5075b.notifyDataSetChanged();
        }
        C5075b c5075b2 = C5075b.this;
        C5075b.a aVar = c5075b2.f13605j;
        int i3 = c5075b2.f13606k[this.f13614j];
        ColorPickerDialog.C11160h c11160h = (ColorPickerDialog.C11160h) aVar;
        ColorPickerDialog colorPickerDialog = ColorPickerDialog.this;
        int i4 = colorPickerDialog.f21723o;
        if (i4 == i3) {
            ColorPickerDialog.m9267g(colorPickerDialog, i4);
            ColorPickerDialog.this.dismiss();
        } else {
            colorPickerDialog.f21723o = i3;
            if (colorPickerDialog.f21726r) {
                colorPickerDialog.m9268h(i3);
            }
        }
    }
}
