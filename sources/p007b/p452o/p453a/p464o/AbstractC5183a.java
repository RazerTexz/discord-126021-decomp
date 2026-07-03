package p007b.p452o.p453a.p464o;

import android.graphics.RectF;
import android.opengl.GLES20;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import java.nio.Buffer;
import java.util.Objects;
import p007b.p100d.p104b.p105a.C1643a;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;
import p007b.p452o.p453a.C5103b;
import p007b.p452o.p453a.p473x.C5236b;
import p007b.p452o.p475b.p476a.C5252d;
import p007b.p452o.p475b.p477b.AbstractC5253a;
import p007b.p452o.p475b.p477b.AbstractC5254b;
import p007b.p452o.p475b.p477b.C5255c;
import p007b.p452o.p475b.p478c.C5261f;
import p007b.p452o.p475b.p479d.C5263b;
import p007b.p452o.p475b.p479d.C5264c;
import p007b.p452o.p475b.p479d.C5265d;
import p007b.p452o.p475b.p482g.InterfaceC5270a;
import p507d0.C12117p;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: b.o.a.o.a */
/* JADX INFO: compiled from: BaseFilter.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC5183a implements InterfaceC5184b {

    /* JADX INFO: renamed from: a */
    public static final C5103b f14046a = new C5103b(AbstractC5183a.class.getSimpleName());

    /* JADX INFO: renamed from: b */
    @VisibleForTesting
    public C5265d f14047b = null;

    /* JADX INFO: renamed from: c */
    public AbstractC5254b f14048c = null;

    /* JADX INFO: renamed from: d */
    @VisibleForTesting
    public C5236b f14049d;

    /* JADX WARN: Multi-variable type inference failed */
    @Override // p007b.p452o.p453a.p464o.InterfaceC5184b
    @NonNull
    /* JADX INFO: renamed from: a */
    public InterfaceC5184b mo7369a() {
        try {
            InterfaceC5184b interfaceC5184b = (AbstractC5183a) getClass().newInstance();
            C5236b c5236b = this.f14049d;
            if (c5236b != null) {
                interfaceC5184b.mo7374k(c5236b.f14251j, c5236b.f14252k);
            }
            if (this instanceof InterfaceC5186d) {
                ((InterfaceC5186d) interfaceC5184b).m7376d(((InterfaceC5186d) this).m7377i());
            }
            if (this instanceof InterfaceC5187e) {
                ((InterfaceC5187e) interfaceC5184b).m7378b(((InterfaceC5187e) this).m7379g());
            }
            return interfaceC5184b;
        } catch (IllegalAccessException e) {
            throw new RuntimeException("Filters should have a public no-arguments constructor.", e);
        } catch (InstantiationException e2) {
            throw new RuntimeException("Filters should have a public no-arguments constructor.", e2);
        }
    }

    @Override // p007b.p452o.p453a.p464o.InterfaceC5184b
    @NonNull
    /* JADX INFO: renamed from: c */
    public String mo7370c() {
        StringBuilder sb = new StringBuilder();
        sb.append("uniform mat4 ");
        sb.append("uMVPMatrix");
        sb.append(";\nuniform mat4 ");
        sb.append("uTexMatrix");
        sb.append(";\nattribute vec4 ");
        C1643a.m876s0(sb, "aPosition", ";\nattribute vec4 ", "aTextureCoord", ";\nvarying vec2 ");
        C1643a.m876s0(sb, "vTextureCoord", ";\nvoid main() {\n    gl_Position = ", "uMVPMatrix", " * ");
        C1643a.m876s0(sb, "aPosition", ";\n    ", "vTextureCoord", " = (");
        sb.append("uTexMatrix");
        sb.append(" * ");
        sb.append("aTextureCoord");
        sb.append(").xy;\n}\n");
        return sb.toString();
    }

    @Override // p007b.p452o.p453a.p464o.InterfaceC5184b
    /* JADX INFO: renamed from: e */
    public void mo7371e(long j, @NonNull float[] fArr) {
        C5265d c5265d = this.f14047b;
        if (c5265d == null) {
            f14046a.m7159a(2, "Filter.draw() called after destroying the filter. This can happen rarely because of threading.");
            return;
        }
        Objects.requireNonNull(c5265d);
        C12238m.checkNotNullParameter(fArr, "<set-?>");
        c5265d.f14318e = fArr;
        C5265d c5265d2 = this.f14047b;
        AbstractC5254b abstractC5254b = this.f14048c;
        float[] fArr2 = abstractC5254b.f14265a;
        Objects.requireNonNull(c5265d2);
        C12238m.checkNotNullParameter(abstractC5254b, "drawable");
        C12238m.checkNotNullParameter(fArr2, "modelViewProjectionMatrix");
        C12238m.checkNotNullParameter(abstractC5254b, "drawable");
        C12238m.checkNotNullParameter(fArr2, "modelViewProjectionMatrix");
        if (!(abstractC5254b instanceof AbstractC5253a)) {
            throw new RuntimeException("GlTextureProgram only supports 2D drawables.");
        }
        GLES20.glUniformMatrix4fv(c5265d2.f14323j.f14311b, 1, false, fArr2, 0);
        C5252d.m7457b("glUniformMatrix4fv");
        C5263b c5263b = c5265d2.f14319f;
        if (c5263b != null) {
            GLES20.glUniformMatrix4fv(c5263b.f14311b, 1, false, c5265d2.f14318e, 0);
            C5252d.m7457b("glUniformMatrix4fv");
        }
        C5263b c5263b2 = c5265d2.f14322i;
        GLES20.glEnableVertexAttribArray(c5263b2.f14312c);
        C5252d.m7457b("glEnableVertexAttribArray");
        AbstractC5253a abstractC5253a = (AbstractC5253a) abstractC5254b;
        GLES20.glVertexAttribPointer(c5263b2.f14312c, 2, C5261f.f14291a, false, abstractC5253a.f14264b * 4, (Buffer) abstractC5254b.mo7459b());
        C5252d.m7457b("glVertexAttribPointer");
        C5263b c5263b3 = c5265d2.f14321h;
        if (c5263b3 != null) {
            if (!C12238m.areEqual(abstractC5254b, c5265d2.f14326m) || c5265d2.f14325l != 0) {
                c5265d2.f14326m = abstractC5253a;
                c5265d2.f14325l = 0;
                RectF rectF = c5265d2.f14324k;
                C12238m.checkNotNullParameter(rectF, "rect");
                float fMax = -3.4028235E38f;
                float fMax2 = -3.4028235E38f;
                float fMin = Float.MAX_VALUE;
                float fMin2 = Float.MAX_VALUE;
                int i = 0;
                while (abstractC5253a.mo7459b().hasRemaining()) {
                    float f = abstractC5253a.mo7459b().get();
                    if (i % 2 == 0) {
                        fMin = Math.min(fMin, f);
                        fMax2 = Math.max(fMax2, f);
                    } else {
                        fMax = Math.max(fMax, f);
                        fMin2 = Math.min(fMin2, f);
                    }
                    i++;
                }
                abstractC5253a.mo7459b().rewind();
                rectF.set(fMin, fMax, fMax2, fMin2);
                int iLimit = (abstractC5254b.mo7459b().limit() / abstractC5253a.f14264b) * 2;
                if (c5265d2.f14320g.capacity() < iLimit) {
                    Object obj = c5265d2.f14320g;
                    C12238m.checkNotNullParameter(obj, "<this>");
                    if (obj instanceof InterfaceC5270a) {
                        ((InterfaceC5270a) obj).dispose();
                    }
                    c5265d2.f14320g = C3404f.m4258X(iLimit);
                }
                c5265d2.f14320g.clear();
                c5265d2.f14320g.limit(iLimit);
                if (iLimit > 0) {
                    int i2 = 0;
                    while (true) {
                        int i3 = i2 + 1;
                        boolean z2 = i2 % 2 == 0;
                        float f2 = abstractC5254b.mo7459b().get(i2);
                        RectF rectF2 = c5265d2.f14324k;
                        float f3 = z2 ? rectF2.left : rectF2.bottom;
                        float f4 = z2 ? rectF2.right : rectF2.top;
                        int i4 = i2 / 2;
                        C12238m.checkNotNullParameter(abstractC5253a, "drawable");
                        c5265d2.f14320g.put((((f2 - f3) / (f4 - f3)) * 1.0f) + 0.0f);
                        if (i3 >= iLimit) {
                            break;
                        } else {
                            i2 = i3;
                        }
                    }
                }
            }
            c5265d2.f14320g.rewind();
            GLES20.glEnableVertexAttribArray(c5263b3.f14312c);
            C5252d.m7457b("glEnableVertexAttribArray");
            GLES20.glVertexAttribPointer(c5263b3.f14312c, 2, C5261f.f14291a, false, abstractC5253a.f14264b * 4, (Buffer) c5265d2.f14320g);
            C5252d.m7457b("glVertexAttribPointer");
        }
        C5265d c5265d3 = this.f14047b;
        AbstractC5254b abstractC5254b2 = this.f14048c;
        Objects.requireNonNull(c5265d3);
        C12238m.checkNotNullParameter(abstractC5254b2, "drawable");
        abstractC5254b2.mo7458a();
        C5265d c5265d4 = this.f14047b;
        AbstractC5254b abstractC5254b3 = this.f14048c;
        Objects.requireNonNull(c5265d4);
        C12238m.checkNotNullParameter(abstractC5254b3, "drawable");
        C12238m.checkNotNullParameter(abstractC5254b3, "drawable");
        GLES20.glDisableVertexAttribArray(c5265d4.f14322i.f14312c);
        C5263b c5263b4 = c5265d4.f14321h;
        if (c5263b4 != null) {
            GLES20.glDisableVertexAttribArray(c5263b4.f14312c);
        }
        C5252d.m7457b("onPostDraw end");
    }

    @Override // p007b.p452o.p453a.p464o.InterfaceC5184b
    /* JADX INFO: renamed from: f */
    public void mo7372f() {
        C5265d c5265d = this.f14047b;
        if (!c5265d.f14309d) {
            if (c5265d.f14307b) {
                GLES20.glDeleteProgram(C12117p.m11482constructorimpl(c5265d.f14306a));
            }
            for (C5264c c5264c : c5265d.f14308c) {
                GLES20.glDeleteShader(C12117p.m11482constructorimpl(c5264c.f14317b));
            }
            c5265d.f14309d = true;
        }
        Object obj = c5265d.f14320g;
        C12238m.checkNotNullParameter(obj, "<this>");
        if (obj instanceof InterfaceC5270a) {
            ((InterfaceC5270a) obj).dispose();
        }
        this.f14047b = null;
        this.f14048c = null;
    }

    @Override // p007b.p452o.p453a.p464o.InterfaceC5184b
    /* JADX INFO: renamed from: j */
    public void mo7373j(int i) {
        this.f14047b = new C5265d(i, "aPosition", "uMVPMatrix", "aTextureCoord", "uTexMatrix");
        this.f14048c = new C5255c();
    }

    @Override // p007b.p452o.p453a.p464o.InterfaceC5184b
    /* JADX INFO: renamed from: k */
    public void mo7374k(int i, int i2) {
        this.f14049d = new C5236b(i, i2);
    }
}
