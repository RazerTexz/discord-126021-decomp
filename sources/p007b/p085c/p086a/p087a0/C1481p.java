package p007b.p085c.p086a.p087a0;

import android.graphics.Color;
import android.graphics.PointF;
import androidx.annotation.ColorInt;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import p007b.p085c.p086a.p087a0.p088i0.AbstractC1473c;
import p007b.p100d.p104b.p105a.C1643a;

/* JADX INFO: renamed from: b.c.a.a0.p */
/* JADX INFO: compiled from: JsonUtils.java */
/* JADX INFO: loaded from: classes.dex */
public class C1481p {

    /* JADX INFO: renamed from: a */
    public static final AbstractC1473c.a f2275a = AbstractC1473c.a.m616a("x", "y");

    @ColorInt
    /* JADX INFO: renamed from: a */
    public static int m627a(AbstractC1473c abstractC1473c) throws IOException {
        abstractC1473c.mo603a();
        int iMo609n = (int) (abstractC1473c.mo609n() * 255.0d);
        int iMo609n2 = (int) (abstractC1473c.mo609n() * 255.0d);
        int iMo609n3 = (int) (abstractC1473c.mo609n() * 255.0d);
        while (abstractC1473c.mo607e()) {
            abstractC1473c.mo601C();
        }
        abstractC1473c.mo605c();
        return Color.argb(255, iMo609n, iMo609n2, iMo609n3);
    }

    /* JADX INFO: renamed from: b */
    public static PointF m628b(AbstractC1473c abstractC1473c, float f) throws IOException {
        int iOrdinal = abstractC1473c.mo613u().ordinal();
        if (iOrdinal == 0) {
            abstractC1473c.mo603a();
            float fMo609n = (float) abstractC1473c.mo609n();
            float fMo609n2 = (float) abstractC1473c.mo609n();
            while (abstractC1473c.mo613u() != AbstractC1473c.b.END_ARRAY) {
                abstractC1473c.mo601C();
            }
            abstractC1473c.mo605c();
            return new PointF(fMo609n * f, fMo609n2 * f);
        }
        if (iOrdinal != 2) {
            if (iOrdinal != 6) {
                StringBuilder sbM833U = C1643a.m833U("Unknown point starts with ");
                sbM833U.append(abstractC1473c.mo613u());
                throw new IllegalArgumentException(sbM833U.toString());
            }
            float fMo609n3 = (float) abstractC1473c.mo609n();
            float fMo609n4 = (float) abstractC1473c.mo609n();
            while (abstractC1473c.mo607e()) {
                abstractC1473c.mo601C();
            }
            return new PointF(fMo609n3 * f, fMo609n4 * f);
        }
        abstractC1473c.mo604b();
        float fM630d = 0.0f;
        float fM630d2 = 0.0f;
        while (abstractC1473c.mo607e()) {
            int iMo615y = abstractC1473c.mo615y(f2275a);
            if (iMo615y == 0) {
                fM630d = m630d(abstractC1473c);
            } else if (iMo615y != 1) {
                abstractC1473c.mo600A();
                abstractC1473c.mo601C();
            } else {
                fM630d2 = m630d(abstractC1473c);
            }
        }
        abstractC1473c.mo606d();
        return new PointF(fM630d * f, fM630d2 * f);
    }

    /* JADX INFO: renamed from: c */
    public static List<PointF> m629c(AbstractC1473c abstractC1473c, float f) throws IOException {
        ArrayList arrayList = new ArrayList();
        abstractC1473c.mo603a();
        while (abstractC1473c.mo613u() == AbstractC1473c.b.BEGIN_ARRAY) {
            abstractC1473c.mo603a();
            arrayList.add(m628b(abstractC1473c, f));
            abstractC1473c.mo605c();
        }
        abstractC1473c.mo605c();
        return arrayList;
    }

    /* JADX INFO: renamed from: d */
    public static float m630d(AbstractC1473c abstractC1473c) throws IOException {
        AbstractC1473c.b bVarMo613u = abstractC1473c.mo613u();
        int iOrdinal = bVarMo613u.ordinal();
        if (iOrdinal != 0) {
            if (iOrdinal == 6) {
                return (float) abstractC1473c.mo609n();
            }
            throw new IllegalArgumentException("Unknown value for token of type " + bVarMo613u);
        }
        abstractC1473c.mo603a();
        float fMo609n = (float) abstractC1473c.mo609n();
        while (abstractC1473c.mo607e()) {
            abstractC1473c.mo601C();
        }
        abstractC1473c.mo605c();
        return fMo609n;
    }
}
