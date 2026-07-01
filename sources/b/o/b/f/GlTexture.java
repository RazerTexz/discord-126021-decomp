package b.o.b.f;

import android.opengl.GLES20;
import b.o.b.a.Egloo;
import b.o.b.c.gl;
import d0.UInt;
import d0.z.d.Lambda;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: renamed from: b.o.b.f.a, reason: use source file name */
/* JADX INFO: compiled from: GlTexture.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class GlTexture extends Lambda implements Function0<Unit> {
    public final /* synthetic */ Integer $internalFormat;
    public final /* synthetic */ GlTexture2 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GlTexture(GlTexture2 glTexture2, Integer num) {
        super(0);
        this.this$0 = glTexture2;
        this.$internalFormat = num;
    }

    @Override // kotlin.jvm.functions.Function0
    public Unit invoke() {
        GlTexture2 glTexture2 = this.this$0;
        if (glTexture2.c != null && glTexture2.d != null && glTexture2.e != null && this.$internalFormat != null && glTexture2.f != null) {
            GLES20.glTexImage2D(UInt.m105constructorimpl(glTexture2.f1968b), 0, this.$internalFormat.intValue(), this.this$0.c.intValue(), this.this$0.d.intValue(), 0, UInt.m105constructorimpl(this.this$0.e.intValue()), UInt.m105constructorimpl(this.this$0.f.intValue()), null);
        }
        GLES20.glTexParameterf(UInt.m105constructorimpl(this.this$0.f1968b), gl.e, gl.j);
        GLES20.glTexParameterf(UInt.m105constructorimpl(this.this$0.f1968b), gl.f, gl.k);
        int iM105constructorimpl = UInt.m105constructorimpl(this.this$0.f1968b);
        int i = gl.g;
        int i2 = gl.i;
        GLES20.glTexParameteri(iM105constructorimpl, i, i2);
        GLES20.glTexParameteri(UInt.m105constructorimpl(this.this$0.f1968b), gl.h, i2);
        Egloo.b("glTexParameter");
        return Unit.a;
    }
}
