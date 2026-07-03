package p007b.p440k.p441a.p442a;

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
import com.jaredrummler.android.colorpicker.C11167R;
import com.jaredrummler.android.colorpicker.ColorPanelView;

/* JADX INFO: renamed from: b.k.a.a.b */
/* JADX INFO: compiled from: ColorPaletteAdapter.java */
/* JADX INFO: loaded from: classes3.dex */
public class C5075b extends BaseAdapter {

    /* JADX INFO: renamed from: j */
    public final a f13605j;

    /* JADX INFO: renamed from: k */
    public final int[] f13606k;

    /* JADX INFO: renamed from: l */
    public int f13607l;

    /* JADX INFO: renamed from: m */
    public int f13608m;

    /* JADX INFO: renamed from: b.k.a.a.b$a */
    /* JADX INFO: compiled from: ColorPaletteAdapter.java */
    public interface a {
    }

    /* JADX INFO: renamed from: b.k.a.a.b$b */
    /* JADX INFO: compiled from: ColorPaletteAdapter.java */
    public final class b {

        /* JADX INFO: renamed from: a */
        public View f13609a;

        /* JADX INFO: renamed from: b */
        public ColorPanelView f13610b;

        /* JADX INFO: renamed from: c */
        public ImageView f13611c;

        /* JADX INFO: renamed from: d */
        public int f13612d;

        public b(Context context) {
            View viewInflate = View.inflate(context, C5075b.this.f13608m == 0 ? C11167R.d.cpv_color_item_square : C11167R.d.cpv_color_item_circle, null);
            this.f13609a = viewInflate;
            this.f13610b = (ColorPanelView) viewInflate.findViewById(C11167R.c.cpv_color_panel_view);
            this.f13611c = (ImageView) this.f13609a.findViewById(C11167R.c.cpv_color_image_view);
            this.f13612d = this.f13610b.getBorderColor();
            this.f13609a.setTag(this);
        }
    }

    public C5075b(a aVar, int[] iArr, int i, int i2) {
        this.f13605j = aVar;
        this.f13606k = iArr;
        this.f13607l = i;
        this.f13608m = i2;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f13606k.length;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return Integer.valueOf(this.f13606k[i]);
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
            view2 = bVar.f13609a;
        } else {
            view2 = view;
            bVar = (b) view.getTag();
        }
        int i2 = C5075b.this.f13606k[i];
        int iAlpha = Color.alpha(i2);
        bVar.f13610b.setColor(i2);
        bVar.f13611c.setImageResource(C5075b.this.f13607l == i ? C11167R.b.cpv_preset_checked : 0);
        if (iAlpha == 255) {
            C5075b c5075b = C5075b.this;
            if (i != c5075b.f13607l || ColorUtils.calculateLuminance(c5075b.f13606k[i]) < 0.65d) {
                bVar.f13611c.setColorFilter((ColorFilter) null);
            } else {
                bVar.f13611c.setColorFilter(ViewCompat.MEASURED_STATE_MASK, PorterDuff.Mode.SRC_IN);
            }
        } else if (iAlpha <= 165) {
            bVar.f13610b.setBorderColor(i2 | ViewCompat.MEASURED_STATE_MASK);
            bVar.f13611c.setColorFilter(ViewCompat.MEASURED_STATE_MASK, PorterDuff.Mode.SRC_IN);
        } else {
            bVar.f13610b.setBorderColor(bVar.f13612d);
            bVar.f13611c.setColorFilter(-1, PorterDuff.Mode.SRC_IN);
        }
        bVar.f13610b.setOnClickListener(new ViewOnClickListenerC5076c(bVar, i));
        bVar.f13610b.setOnLongClickListener(new ViewOnLongClickListenerC5077d(bVar));
        return view2;
    }
}
