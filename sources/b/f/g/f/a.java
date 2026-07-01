package b.f.g.f;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import b.f.g.e.s;
import b.f.g.e.t;
import com.facebook.drawee.drawable.ScalingUtils$ScaleType;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

/* JADX INFO: compiled from: GenericDraweeHierarchyBuilder.java */
/* JADX INFO: loaded from: classes.dex */
public class a {
    public static final ScalingUtils$ScaleType a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ScalingUtils$ScaleType f522b;
    public Resources c;
    public int d = 300;
    public float e = 0.0f;
    public Drawable f = null;
    public ScalingUtils$ScaleType g;
    public Drawable h;
    public ScalingUtils$ScaleType i;
    public Drawable j;
    public ScalingUtils$ScaleType k;
    public Drawable l;
    public ScalingUtils$ScaleType m;
    public ScalingUtils$ScaleType n;
    public Drawable o;
    public List<Drawable> p;
    public Drawable q;
    public c r;

    static {
        ScalingUtils$ScaleType scalingUtils$ScaleType = ScalingUtils$ScaleType.a;
        a = t.l;
        f522b = s.l;
    }

    public a(Resources resources) {
        this.c = resources;
        ScalingUtils$ScaleType scalingUtils$ScaleType = a;
        this.g = scalingUtils$ScaleType;
        this.h = null;
        this.i = scalingUtils$ScaleType;
        this.j = null;
        this.k = scalingUtils$ScaleType;
        this.l = null;
        this.m = scalingUtils$ScaleType;
        this.n = f522b;
        this.o = null;
        this.p = null;
        this.q = null;
        this.r = null;
    }

    public GenericDraweeHierarchy a() {
        List<Drawable> list = this.p;
        if (list != null) {
            Iterator<Drawable> it = list.iterator();
            while (it.hasNext()) {
                Objects.requireNonNull(it.next());
            }
        }
        return new GenericDraweeHierarchy(this);
    }

    public a b(Drawable drawable) {
        if (drawable == null) {
            this.p = null;
        } else {
            this.p = Arrays.asList(drawable);
        }
        return this;
    }
}
