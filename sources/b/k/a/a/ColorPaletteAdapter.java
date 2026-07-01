package b.k.a.a;

import android.content.Context;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import androidx.core.graphics.ColorUtils;
import androidx.core.view.ViewCompat;
import com.jaredrummler.android.colorpicker.ColorPanelView;
import com.jaredrummler.android.colorpicker.R;

/* JADX INFO: renamed from: b.k.a.a.b, reason: use source file name */
/* JADX INFO: compiled from: ColorPaletteAdapter.java */
/* JADX INFO: loaded from: classes3.dex */
public class ColorPaletteAdapter extends BaseAdapter {
    public final a j;
    public final int[] k;
    public int l;
    public int m;

    /* JADX INFO: renamed from: b.k.a.a.b$a */
    /* JADX INFO: compiled from: ColorPaletteAdapter.java */
    public interface a {
    }

    /* JADX INFO: renamed from: b.k.a.a.b$b */
    /* JADX INFO: compiled from: ColorPaletteAdapter.java */
    public final class b {
        public View a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public ColorPanelView f1899b;
        public ImageView c;
        public int d;

        public b(Context context) {
            View viewInflate = View.inflate(context, ColorPaletteAdapter.this.m == 0 ? R.d.cpv_color_item_square : R.d.cpv_color_item_circle, null);
            this.a = viewInflate;
            this.f1899b = (ColorPanelView) viewInflate.findViewById(R.c.cpv_color_panel_view);
            this.c = (ImageView) this.a.findViewById(R.c.cpv_color_image_view);
            this.d = this.f1899b.getBorderColor();
            this.a.setTag(this);
        }
    }

    public ColorPaletteAdapter(a aVar, int[] iArr, int i, int i2) {
        this.j = aVar;
        this.k = iArr;
        this.l = i;
        this.m = i2;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.k.length;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return Integer.valueOf(this.k[i]);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        View view2;
        b bVar;
        if (view == null) {
            bVar = new b(viewGroup.getContext());
            view2 = bVar.a;
        } else {
            view2 = view;
            bVar = (b) view.getTag();
        }
        int i2 = ColorPaletteAdapter.this.k[i];
        int iAlpha = Color.alpha(i2);
        bVar.f1899b.setColor(i2);
        bVar.c.setImageResource(ColorPaletteAdapter.this.l == i ? R.b.cpv_preset_checked : 0);
        if (iAlpha == 255) {
            ColorPaletteAdapter colorPaletteAdapter = ColorPaletteAdapter.this;
            if (i != colorPaletteAdapter.l || ColorUtils.calculateLuminance(colorPaletteAdapter.k[i]) < 0.65d) {
                bVar.c.setColorFilter((ColorFilter) null);
            } else {
                bVar.c.setColorFilter(ViewCompat.MEASURED_STATE_MASK, PorterDuff.Mode.SRC_IN);
            }
        } else if (iAlpha <= 165) {
            bVar.f1899b.setBorderColor(i2 | ViewCompat.MEASURED_STATE_MASK);
            bVar.c.setColorFilter(ViewCompat.MEASURED_STATE_MASK, PorterDuff.Mode.SRC_IN);
        } else {
            bVar.f1899b.setBorderColor(bVar.d);
            bVar.c.setColorFilter(-1, PorterDuff.Mode.SRC_IN);
        }
        bVar.f1899b.setOnClickListener(new ColorPaletteAdapter2(bVar, i));
        bVar.f1899b.setOnLongClickListener(new ColorPaletteAdapter3(bVar));
        return view2;
    }
}
