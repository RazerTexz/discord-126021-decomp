package b.o.a.o;

import android.graphics.RectF;
import android.opengl.GLES20;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import b.o.b.c.f;
import d0.p;
import d0.z.d.m;
import java.nio.Buffer;
import java.util.Objects;

/* JADX INFO: compiled from: BaseFilter.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class a implements b {
    public static final b.o.a.b a = new b.o.a.b(a.class.getSimpleName());

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @VisibleForTesting
    public b.o.b.d.d f1944b = null;
    public b.o.b.b.b c = null;

    @VisibleForTesting
    public b.o.a.x.b d;

    /* JADX WARN: Multi-variable type inference failed */
    @Override // b.o.a.o.b
    @NonNull
    public b a() {
        try {
            b bVar = (a) getClass().newInstance();
            b.o.a.x.b bVar2 = this.d;
            if (bVar2 != null) {
                bVar.k(bVar2.j, bVar2.k);
            }
            if (this instanceof d) {
                ((d) bVar).d(((d) this).i());
            }
            if (this instanceof e) {
                ((e) bVar).b(((e) this).g());
            }
            return bVar;
        } catch (IllegalAccessException e) {
            throw new RuntimeException("Filters should have a public no-arguments constructor.", e);
        } catch (InstantiationException e2) {
            throw new RuntimeException("Filters should have a public no-arguments constructor.", e2);
        }
    }

    @Override // b.o.a.o.b
    @NonNull
    public String c() {
        StringBuilder sb = new StringBuilder();
        sb.append("uniform mat4 ");
        sb.append("uMVPMatrix");
        sb.append(";\nuniform mat4 ");
        sb.append("uTexMatrix");
        sb.append(";\nattribute vec4 ");
        b.d.b.a.a.s0(sb, "aPosition", ";\nattribute vec4 ", "aTextureCoord", ";\nvarying vec2 ");
        b.d.b.a.a.s0(sb, "vTextureCoord", ";\nvoid main() {\n    gl_Position = ", "uMVPMatrix", " * ");
        b.d.b.a.a.s0(sb, "aPosition", ";\n    ", "vTextureCoord", " = (");
        sb.append("uTexMatrix");
        sb.append(" * ");
        sb.append("aTextureCoord");
        sb.append(").xy;\n}\n");
        return sb.toString();
    }

    @Override // b.o.a.o.b
    public void e(long j, @NonNull float[] fArr) {
        b.o.b.d.d dVar = this.f1944b;
        if (dVar == null) {
            a.a(2, "Filter.draw() called after destroying the filter. This can happen rarely because of threading.");
            return;
        }
        Objects.requireNonNull(dVar);
        m.checkNotNullParameter(fArr, "<set-?>");
        dVar.e = fArr;
        b.o.b.d.d dVar2 = this.f1944b;
        b.o.b.b.b bVar = this.c;
        float[] fArr2 = bVar.a;
        Objects.requireNonNull(dVar2);
        m.checkNotNullParameter(bVar, "drawable");
        m.checkNotNullParameter(fArr2, "modelViewProjectionMatrix");
        m.checkNotNullParameter(bVar, "drawable");
        m.checkNotNullParameter(fArr2, "modelViewProjectionMatrix");
        if (!(bVar instanceof b.o.b.b.a)) {
            throw new RuntimeException("GlTextureProgram only supports 2D drawables.");
        }
        GLES20.glUniformMatrix4fv(dVar2.j.f1965b, 1, false, fArr2, 0);
        b.o.b.a.d.b("glUniformMatrix4fv");
        b.o.b.d.b bVar2 = dVar2.f;
        if (bVar2 != null) {
            GLES20.glUniformMatrix4fv(bVar2.f1965b, 1, false, dVar2.e, 0);
            b.o.b.a.d.b("glUniformMatrix4fv");
        }
        b.o.b.d.b bVar3 = dVar2.i;
        GLES20.glEnableVertexAttribArray(bVar3.c);
        b.o.b.a.d.b("glEnableVertexAttribArray");
        b.o.b.b.a aVar = (b.o.b.b.a) bVar;
        GLES20.glVertexAttribPointer(bVar3.c, 2, f.a, false, aVar.f1960b * 4, (Buffer) bVar.b());
        b.o.b.a.d.b("glVertexAttribPointer");
        b.o.b.d.b bVar4 = dVar2.h;
        if (bVar4 != null) {
            if (!m.areEqual(bVar, dVar2.m) || dVar2.l != 0) {
                dVar2.m = aVar;
                dVar2.l = 0;
                RectF rectF = dVar2.k;
                m.checkNotNullParameter(rectF, "rect");
                float fMax = -3.4028235E38f;
                float fMax2 = -3.4028235E38f;
                float fMin = Float.MAX_VALUE;
                float fMin2 = Float.MAX_VALUE;
                int i = 0;
                while (aVar.b().hasRemaining()) {
                    float f = aVar.b().get();
                    if (i % 2 == 0) {
                        fMin = Math.min(fMin, f);
                        fMax2 = Math.max(fMax2, f);
                    } else {
                        fMax = Math.max(fMax, f);
                        fMin2 = Math.min(fMin2, f);
                    }
                    i++;
                }
                aVar.b().rewind();
                rectF.set(fMin, fMax, fMax2, fMin2);
                int iLimit = (bVar.b().limit() / aVar.f1960b) * 2;
                if (dVar2.g.capacity() < iLimit) {
                    Object obj = dVar2.g;
                    m.checkNotNullParameter(obj, "<this>");
                    if (obj instanceof b.o.b.g.a) {
                        ((b.o.b.g.a) obj).dispose();
                    }
                    dVar2.g = b.i.a.f.e.o.f.X(iLimit);
                }
                dVar2.g.clear();
                dVar2.g.limit(iLimit);
                if (iLimit > 0) {
                    int i2 = 0;
                    while (true) {
                        int i3 = i2 + 1;
                        boolean z2 = i2 % 2 == 0;
                        float f2 = bVar.b().get(i2);
                        RectF rectF2 = dVar2.k;
                        float f3 = z2 ? rectF2.left : rectF2.bottom;
                        float f4 = z2 ? rectF2.right : rectF2.top;
                        int i4 = i2 / 2;
                        m.checkNotNullParameter(aVar, "drawable");
                        dVar2.g.put((((f2 - f3) / (f4 - f3)) * 1.0f) + 0.0f);
                        if (i3 >= iLimit) {
                            break;
                        } else {
                            i2 = i3;
                        }
                    }
                }
            }
            dVar2.g.rewind();
            GLES20.glEnableVertexAttribArray(bVar4.c);
            b.o.b.a.d.b("glEnableVertexAttribArray");
            GLES20.glVertexAttribPointer(bVar4.c, 2, f.a, false, aVar.f1960b * 4, (Buffer) dVar2.g);
            b.o.b.a.d.b("glVertexAttribPointer");
        }
        b.o.b.d.d dVar3 = this.f1944b;
        b.o.b.b.b bVar5 = this.c;
        Objects.requireNonNull(dVar3);
        m.checkNotNullParameter(bVar5, "drawable");
        bVar5.a();
        b.o.b.d.d dVar4 = this.f1944b;
        b.o.b.b.b bVar6 = this.c;
        Objects.requireNonNull(dVar4);
        m.checkNotNullParameter(bVar6, "drawable");
        m.checkNotNullParameter(bVar6, "drawable");
        GLES20.glDisableVertexAttribArray(dVar4.i.c);
        b.o.b.d.b bVar7 = dVar4.h;
        if (bVar7 != null) {
            GLES20.glDisableVertexAttribArray(bVar7.c);
        }
        b.o.b.a.d.b("onPostDraw end");
    }

    @Override // b.o.a.o.b
    public void f() {
        b.o.b.d.d dVar = this.f1944b;
        if (!dVar.d) {
            if (dVar.f1964b) {
                GLES20.glDeleteProgram(p.m105constructorimpl(dVar.a));
            }
            for (b.o.b.d.c cVar : dVar.c) {
                GLES20.glDeleteShader(p.m105constructorimpl(cVar.f1966b));
            }
            dVar.d = true;
        }
        Object obj = dVar.g;
        m.checkNotNullParameter(obj, "<this>");
        if (obj instanceof b.o.b.g.a) {
            ((b.o.b.g.a) obj).dispose();
        }
        this.f1944b = null;
        this.c = null;
    }

    @Override // b.o.a.o.b
    public void j(int i) {
        this.f1944b = new b.o.b.d.d(i, "aPosition", "uMVPMatrix", "aTextureCoord", "uTexMatrix");
        this.c = new b.o.b.b.c();
    }

    @Override // b.o.a.o.b
    public void k(int i, int i2) {
        this.d = new b.o.a.x.b(i, i2);
    }
}
