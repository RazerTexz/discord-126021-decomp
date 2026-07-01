package b.k.a.a;

import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff$Mode;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import androidx.core.graphics.ColorUtils;
import androidx.core.view.ViewCompat;
import com.jaredrummler.android.colorpicker.R$b;

/* JADX INFO: compiled from: ColorPaletteAdapter.java */
/* JADX INFO: loaded from: classes3.dex */
public class b extends BaseAdapter {
    public final b$a j;
    public final int[] k;
    public int l;
    public int m;

    public b(b$a b_a, int[] iArr, int i, int i2) {
        this.j = b_a;
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
        b$b b_b;
        if (view == null) {
            b_b = new b$b(this, viewGroup.getContext());
            view2 = b_b.a;
        } else {
            view2 = view;
            b_b = (b$b) view.getTag();
        }
        int i2 = b_b.e.k[i];
        int iAlpha = Color.alpha(i2);
        b_b.f1899b.setColor(i2);
        b_b.c.setImageResource(b_b.e.l == i ? R$b.cpv_preset_checked : 0);
        if (iAlpha == 255) {
            b bVar = b_b.e;
            if (i != bVar.l || ColorUtils.calculateLuminance(bVar.k[i]) < 0.65d) {
                b_b.c.setColorFilter((ColorFilter) null);
            } else {
                b_b.c.setColorFilter(ViewCompat.MEASURED_STATE_MASK, PorterDuff$Mode.SRC_IN);
            }
        } else if (iAlpha <= 165) {
            b_b.f1899b.setBorderColor(i2 | ViewCompat.MEASURED_STATE_MASK);
            b_b.c.setColorFilter(ViewCompat.MEASURED_STATE_MASK, PorterDuff$Mode.SRC_IN);
        } else {
            b_b.f1899b.setBorderColor(b_b.d);
            b_b.c.setColorFilter(-1, PorterDuff$Mode.SRC_IN);
        }
        b_b.f1899b.setOnClickListener(new c(b_b, i));
        b_b.f1899b.setOnLongClickListener(new d(b_b));
        return view2;
    }
}
