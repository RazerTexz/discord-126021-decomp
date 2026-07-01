package b.k.a.a;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import com.jaredrummler.android.colorpicker.ColorPanelView;
import com.jaredrummler.android.colorpicker.R$c;
import com.jaredrummler.android.colorpicker.R$d;

/* JADX INFO: compiled from: ColorPaletteAdapter.java */
/* JADX INFO: loaded from: classes3.dex */
public final class b$b {
    public View a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ColorPanelView f1899b;
    public ImageView c;
    public int d;
    public final /* synthetic */ b e;

    public b$b(b bVar, Context context) {
        this.e = bVar;
        View viewInflate = View.inflate(context, bVar.m == 0 ? R$d.cpv_color_item_square : R$d.cpv_color_item_circle, null);
        this.a = viewInflate;
        this.f1899b = (ColorPanelView) viewInflate.findViewById(R$c.cpv_color_panel_view);
        this.c = (ImageView) this.a.findViewById(R$c.cpv_color_image_view);
        this.d = this.f1899b.getBorderColor();
        this.a.setTag(this);
    }
}
