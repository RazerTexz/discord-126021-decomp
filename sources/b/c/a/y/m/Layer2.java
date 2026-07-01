package b.c.a.y.m;

import androidx.annotation.Nullable;
import b.c.a.LottieComposition;
import b.c.a.c0.Keyframe;
import b.c.a.y.k.AnimatableFloatValue;
import b.c.a.y.k.AnimatableTextFrame;
import b.c.a.y.k.AnimatableTextProperties;
import b.c.a.y.k.AnimatableTransform;
import b.c.a.y.l.ContentModel2;
import b.c.a.y.l.Mask;
import b.d.b.a.outline;
import java.util.List;
import java.util.Locale;

/* JADX INFO: renamed from: b.c.a.y.m.e, reason: use source file name */
/* JADX INFO: compiled from: Layer.java */
/* JADX INFO: loaded from: classes.dex */
public class Layer2 {
    public final List<ContentModel2> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LottieComposition f438b;
    public final String c;
    public final long d;
    public final a e;
    public final long f;

    @Nullable
    public final String g;
    public final List<Mask> h;
    public final AnimatableTransform i;
    public final int j;
    public final int k;
    public final int l;
    public final float m;
    public final float n;
    public final int o;
    public final int p;

    @Nullable
    public final AnimatableTextFrame q;

    @Nullable
    public final AnimatableTextProperties r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    @Nullable
    public final AnimatableFloatValue f439s;
    public final List<Keyframe<Float>> t;
    public final int u;
    public final boolean v;

    /* JADX INFO: renamed from: b.c.a.y.m.e$a */
    /* JADX INFO: compiled from: Layer.java */
    public enum a {
        PRE_COMP,
        SOLID,
        IMAGE,
        NULL,
        SHAPE,
        TEXT,
        UNKNOWN
    }

    /* JADX WARN: Incorrect types in method signature: (Ljava/util/List<Lb/c/a/y/l/b;>;Lb/c/a/d;Ljava/lang/String;JLb/c/a/y/m/e$a;JLjava/lang/String;Ljava/util/List<Lb/c/a/y/l/f;>;Lb/c/a/y/k/l;IIIFFIILb/c/a/y/k/j;Lb/c/a/y/k/k;Ljava/util/List<Lb/c/a/c0/a<Ljava/lang/Float;>;>;Ljava/lang/Object;Lb/c/a/y/k/b;Z)V */
    public Layer2(List list, LottieComposition lottieComposition, String str, long j, a aVar, long j2, @Nullable String str2, List list2, AnimatableTransform animatableTransform, int i, int i2, int i3, float f, float f2, int i4, int i5, @Nullable AnimatableTextFrame animatableTextFrame, @Nullable AnimatableTextProperties animatableTextProperties, List list3, int i6, @Nullable AnimatableFloatValue animatableFloatValue, boolean z2) {
        this.a = list;
        this.f438b = lottieComposition;
        this.c = str;
        this.d = j;
        this.e = aVar;
        this.f = j2;
        this.g = str2;
        this.h = list2;
        this.i = animatableTransform;
        this.j = i;
        this.k = i2;
        this.l = i3;
        this.m = f;
        this.n = f2;
        this.o = i4;
        this.p = i5;
        this.q = animatableTextFrame;
        this.r = animatableTextProperties;
        this.t = list3;
        this.u = i6;
        this.f439s = animatableFloatValue;
        this.v = z2;
    }

    public String a(String str) {
        StringBuilder sbU = outline.U(str);
        sbU.append(this.c);
        sbU.append("\n");
        Layer2 layer2E = this.f438b.e(this.f);
        if (layer2E != null) {
            sbU.append("\t\tParents: ");
            sbU.append(layer2E.c);
            Layer2 layer2E2 = this.f438b.e(layer2E.f);
            while (layer2E2 != null) {
                sbU.append("->");
                sbU.append(layer2E2.c);
                layer2E2 = this.f438b.e(layer2E2.f);
            }
            sbU.append(str);
            sbU.append("\n");
        }
        if (!this.h.isEmpty()) {
            sbU.append(str);
            sbU.append("\tMasks: ");
            sbU.append(this.h.size());
            sbU.append("\n");
        }
        if (this.j != 0 && this.k != 0) {
            sbU.append(str);
            sbU.append("\tBackground: ");
            sbU.append(String.format(Locale.US, "%dx%d %X\n", Integer.valueOf(this.j), Integer.valueOf(this.k), Integer.valueOf(this.l)));
        }
        if (!this.a.isEmpty()) {
            sbU.append(str);
            sbU.append("\tShapes:\n");
            for (ContentModel2 contentModel2 : this.a) {
                sbU.append(str);
                sbU.append("\t\t");
                sbU.append(contentModel2);
                sbU.append("\n");
            }
        }
        return sbU.toString();
    }

    public String toString() {
        return a("");
    }
}
