package b.i.a.e;

import android.view.View;
import com.google.android.flexbox.FlexItem;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: renamed from: b.i.a.e.b, reason: use source file name */
/* JADX INFO: compiled from: FlexLine.java */
/* JADX INFO: loaded from: classes3.dex */
public class FlexLine {
    public int e;
    public int f;
    public int g;
    public int h;
    public int i;
    public float j;
    public float k;
    public int l;
    public int m;
    public int o;
    public int p;
    public boolean q;
    public boolean r;
    public int a = Integer.MAX_VALUE;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f1327b = Integer.MAX_VALUE;
    public int c = Integer.MIN_VALUE;
    public int d = Integer.MIN_VALUE;
    public List<Integer> n = new ArrayList();

    public int a() {
        return this.h - this.i;
    }

    public void b(View view, int i, int i2, int i3, int i4) {
        FlexItem flexItem = (FlexItem) view.getLayoutParams();
        this.a = Math.min(this.a, (view.getLeft() - flexItem.J()) - i);
        this.f1327b = Math.min(this.f1327b, (view.getTop() - flexItem.N()) - i2);
        this.c = Math.max(this.c, flexItem.d0() + view.getRight() + i3);
        this.d = Math.max(this.d, flexItem.I() + view.getBottom() + i4);
    }
}
