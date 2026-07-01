package b.o.a.o;

import android.graphics.RectF;
import android.opengl.GLES20;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import b.d.b.a.outline;
import b.i.a.f.e.o.f;
import b.o.a.CameraLogger;
import b.o.a.x.Size3;
import b.o.b.a.Egloo;
import b.o.b.b.Gl2dDrawable;
import b.o.b.b.GlDrawable;
import b.o.b.b.GlRect;
import b.o.b.c.gl;
import b.o.b.d.GlProgramLocation;
import b.o.b.d.GlShader2;
import b.o.b.d.GlTextureProgram;
import b.o.b.g.buffers;
import d0.UInt;
import d0.z.d.Intrinsics3;
import java.nio.Buffer;
import java.util.Objects;

/* JADX INFO: renamed from: b.o.a.o.a, reason: use source file name */
/* JADX INFO: compiled from: BaseFilter.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class BaseFilter implements Filter2 {
    public static final CameraLogger a = new CameraLogger(BaseFilter.class.getSimpleName());

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @VisibleForTesting
    public GlTextureProgram f1944b = null;
    public GlDrawable c = null;

    @VisibleForTesting
    public Size3 d;

    /* JADX WARN: Multi-variable type inference failed */
    @Override // b.o.a.o.Filter2
    @NonNull
    public Filter2 a() {
        try {
            Filter2 filter2 = (BaseFilter) getClass().newInstance();
            Size3 size3 = this.d;
            if (size3 != null) {
                filter2.k(size3.j, size3.k);
            }
            if (this instanceof OneParameterFilter) {
                ((OneParameterFilter) filter2).d(((OneParameterFilter) this).i());
            }
            if (this instanceof TwoParameterFilter) {
                ((TwoParameterFilter) filter2).b(((TwoParameterFilter) this).g());
            }
            return filter2;
        } catch (IllegalAccessException e) {
            throw new RuntimeException("Filters should have a public no-arguments constructor.", e);
        } catch (InstantiationException e2) {
            throw new RuntimeException("Filters should have a public no-arguments constructor.", e2);
        }
    }

    @Override // b.o.a.o.Filter2
    @NonNull
    public String c() {
        StringBuilder sb = new StringBuilder();
        sb.append("uniform mat4 ");
        sb.append("uMVPMatrix");
        sb.append(";\nuniform mat4 ");
        sb.append("uTexMatrix");
        sb.append(";\nattribute vec4 ");
        outline.s0(sb, "aPosition", ";\nattribute vec4 ", "aTextureCoord", ";\nvarying vec2 ");
        outline.s0(sb, "vTextureCoord", ";\nvoid main() {\n    gl_Position = ", "uMVPMatrix", " * ");
        outline.s0(sb, "aPosition", ";\n    ", "vTextureCoord", " = (");
        sb.append("uTexMatrix");
        sb.append(" * ");
        sb.append("aTextureCoord");
        sb.append(").xy;\n}\n");
        return sb.toString();
    }

    @Override // b.o.a.o.Filter2
    public void e(long j, @NonNull float[] fArr) {
        GlTextureProgram glTextureProgram = this.f1944b;
        if (glTextureProgram == null) {
            a.a(2, "Filter.draw() called after destroying the filter. This can happen rarely because of threading.");
            return;
        }
        Objects.requireNonNull(glTextureProgram);
        Intrinsics3.checkNotNullParameter(fArr, "<set-?>");
        glTextureProgram.e = fArr;
        GlTextureProgram glTextureProgram2 = this.f1944b;
        GlDrawable glDrawable = this.c;
        float[] fArr2 = glDrawable.a;
        Objects.requireNonNull(glTextureProgram2);
        Intrinsics3.checkNotNullParameter(glDrawable, "drawable");
        Intrinsics3.checkNotNullParameter(fArr2, "modelViewProjectionMatrix");
        Intrinsics3.checkNotNullParameter(glDrawable, "drawable");
        Intrinsics3.checkNotNullParameter(fArr2, "modelViewProjectionMatrix");
        if (!(glDrawable instanceof Gl2dDrawable)) {
            throw new RuntimeException("GlTextureProgram only supports 2D drawables.");
        }
        GLES20.glUniformMatrix4fv(glTextureProgram2.j.f1965b, 1, false, fArr2, 0);
        Egloo.b("glUniformMatrix4fv");
        GlProgramLocation glProgramLocation = glTextureProgram2.f;
        if (glProgramLocation != null) {
            GLES20.glUniformMatrix4fv(glProgramLocation.f1965b, 1, false, glTextureProgram2.e, 0);
            Egloo.b("glUniformMatrix4fv");
        }
        GlProgramLocation glProgramLocation2 = glTextureProgram2.i;
        GLES20.glEnableVertexAttribArray(glProgramLocation2.c);
        Egloo.b("glEnableVertexAttribArray");
        Gl2dDrawable gl2dDrawable = (Gl2dDrawable) glDrawable;
        GLES20.glVertexAttribPointer(glProgramLocation2.c, 2, gl.a, false, gl2dDrawable.f1960b * 4, (Buffer) glDrawable.b());
        Egloo.b("glVertexAttribPointer");
        GlProgramLocation glProgramLocation3 = glTextureProgram2.h;
        if (glProgramLocation3 != null) {
            if (!Intrinsics3.areEqual(glDrawable, glTextureProgram2.m) || glTextureProgram2.l != 0) {
                glTextureProgram2.m = gl2dDrawable;
                glTextureProgram2.l = 0;
                RectF rectF = glTextureProgram2.k;
                Intrinsics3.checkNotNullParameter(rectF, "rect");
                float fMax = -3.4028235E38f;
                float fMax2 = -3.4028235E38f;
                float fMin = Float.MAX_VALUE;
                float fMin2 = Float.MAX_VALUE;
                int i = 0;
                while (gl2dDrawable.b().hasRemaining()) {
                    float f = gl2dDrawable.b().get();
                    if (i % 2 == 0) {
                        fMin = Math.min(fMin, f);
                        fMax2 = Math.max(fMax2, f);
                    } else {
                        fMax = Math.max(fMax, f);
                        fMin2 = Math.min(fMin2, f);
                    }
                    i++;
                }
                gl2dDrawable.b().rewind();
                rectF.set(fMin, fMax, fMax2, fMin2);
                int iLimit = (glDrawable.b().limit() / gl2dDrawable.f1960b) * 2;
                if (glTextureProgram2.g.capacity() < iLimit) {
                    Object obj = glTextureProgram2.g;
                    Intrinsics3.checkNotNullParameter(obj, "<this>");
                    if (obj instanceof buffers) {
                        ((buffers) obj).dispose();
                    }
                    glTextureProgram2.g = f.X(iLimit);
                }
                glTextureProgram2.g.clear();
                glTextureProgram2.g.limit(iLimit);
                if (iLimit > 0) {
                    int i2 = 0;
                    while (true) {
                        int i3 = i2 + 1;
                        boolean z2 = i2 % 2 == 0;
                        float f2 = glDrawable.b().get(i2);
                        RectF rectF2 = glTextureProgram2.k;
                        float f3 = z2 ? rectF2.left : rectF2.bottom;
                        float f4 = z2 ? rectF2.right : rectF2.top;
                        int i4 = i2 / 2;
                        Intrinsics3.checkNotNullParameter(gl2dDrawable, "drawable");
                        glTextureProgram2.g.put((((f2 - f3) / (f4 - f3)) * 1.0f) + 0.0f);
                        if (i3 >= iLimit) {
                            break;
                        } else {
                            i2 = i3;
                        }
                    }
                }
            }
            glTextureProgram2.g.rewind();
            GLES20.glEnableVertexAttribArray(glProgramLocation3.c);
            Egloo.b("glEnableVertexAttribArray");
            GLES20.glVertexAttribPointer(glProgramLocation3.c, 2, gl.a, false, gl2dDrawable.f1960b * 4, (Buffer) glTextureProgram2.g);
            Egloo.b("glVertexAttribPointer");
        }
        GlTextureProgram glTextureProgram3 = this.f1944b;
        GlDrawable glDrawable2 = this.c;
        Objects.requireNonNull(glTextureProgram3);
        Intrinsics3.checkNotNullParameter(glDrawable2, "drawable");
        glDrawable2.a();
        GlTextureProgram glTextureProgram4 = this.f1944b;
        GlDrawable glDrawable3 = this.c;
        Objects.requireNonNull(glTextureProgram4);
        Intrinsics3.checkNotNullParameter(glDrawable3, "drawable");
        Intrinsics3.checkNotNullParameter(glDrawable3, "drawable");
        GLES20.glDisableVertexAttribArray(glTextureProgram4.i.c);
        GlProgramLocation glProgramLocation4 = glTextureProgram4.h;
        if (glProgramLocation4 != null) {
            GLES20.glDisableVertexAttribArray(glProgramLocation4.c);
        }
        Egloo.b("onPostDraw end");
    }

    @Override // b.o.a.o.Filter2
    public void f() {
        GlTextureProgram glTextureProgram = this.f1944b;
        if (!glTextureProgram.d) {
            if (glTextureProgram.f1964b) {
                GLES20.glDeleteProgram(UInt.m105constructorimpl(glTextureProgram.a));
            }
            for (GlShader2 glShader2 : glTextureProgram.c) {
                GLES20.glDeleteShader(UInt.m105constructorimpl(glShader2.f1966b));
            }
            glTextureProgram.d = true;
        }
        Object obj = glTextureProgram.g;
        Intrinsics3.checkNotNullParameter(obj, "<this>");
        if (obj instanceof buffers) {
            ((buffers) obj).dispose();
        }
        this.f1944b = null;
        this.c = null;
    }

    @Override // b.o.a.o.Filter2
    public void j(int i) {
        this.f1944b = new GlTextureProgram(i, "aPosition", "uMVPMatrix", "aTextureCoord", "uTexMatrix");
        this.c = new GlRect();
    }

    @Override // b.o.a.o.Filter2
    public void k(int i, int i2) {
        this.d = new Size3(i, i2);
    }
}
