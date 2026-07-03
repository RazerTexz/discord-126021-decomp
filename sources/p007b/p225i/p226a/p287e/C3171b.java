package p007b.p225i.p226a.p287e;

import android.view.View;
import com.google.android.flexbox.FlexItem;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: renamed from: b.i.a.e.b */
/* JADX INFO: compiled from: FlexLine.java */
/* JADX INFO: loaded from: classes3.dex */
public class C3171b {

    /* JADX INFO: renamed from: e */
    public int f9167e;

    /* JADX INFO: renamed from: f */
    public int f9168f;

    /* JADX INFO: renamed from: g */
    public int f9169g;

    /* JADX INFO: renamed from: h */
    public int f9170h;

    /* JADX INFO: renamed from: i */
    public int f9171i;

    /* JADX INFO: renamed from: j */
    public float f9172j;

    /* JADX INFO: renamed from: k */
    public float f9173k;

    /* JADX INFO: renamed from: l */
    public int f9174l;

    /* JADX INFO: renamed from: m */
    public int f9175m;

    /* JADX INFO: renamed from: o */
    public int f9177o;

    /* JADX INFO: renamed from: p */
    public int f9178p;

    /* JADX INFO: renamed from: q */
    public boolean f9179q;

    /* JADX INFO: renamed from: r */
    public boolean f9180r;

    /* JADX INFO: renamed from: a */
    public int f9163a = Integer.MAX_VALUE;

    /* JADX INFO: renamed from: b */
    public int f9164b = Integer.MAX_VALUE;

    /* JADX INFO: renamed from: c */
    public int f9165c = Integer.MIN_VALUE;

    /* JADX INFO: renamed from: d */
    public int f9166d = Integer.MIN_VALUE;

    /* JADX INFO: renamed from: n */
    public List<Integer> f9176n = new ArrayList();

    /* JADX INFO: renamed from: a */
    public int m3934a() {
        return this.f9170h - this.f9171i;
    }

    /* JADX INFO: renamed from: b */
    public void m3935b(View view, int i, int i2, int i3, int i4) {
        FlexItem flexItem = (FlexItem) view.getLayoutParams();
        this.f9163a = Math.min(this.f9163a, (view.getLeft() - flexItem.mo8958J()) - i);
        this.f9164b = Math.min(this.f9164b, (view.getTop() - flexItem.mo8959N()) - i2);
        this.f9165c = Math.max(this.f9165c, flexItem.mo8963d0() + view.getRight() + i3);
        this.f9166d = Math.max(this.f9166d, flexItem.mo8957I() + view.getBottom() + i4);
    }
}
