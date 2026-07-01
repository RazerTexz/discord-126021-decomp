package b.o.b.f;

import android.opengl.GLES20;
import b.o.b.a.d;
import b.o.b.c.f;
import d0.p;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: GlTexture.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class a extends o implements Function0<Unit> {
    public final /* synthetic */ Integer $internalFormat;
    public final /* synthetic */ b this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(b bVar, Integer num) {
        super(0);
        this.this$0 = bVar;
        this.$internalFormat = num;
    }

    @Override // kotlin.jvm.functions.Function0
    public Unit invoke() {
        b bVar = this.this$0;
        if (bVar.c != null && bVar.d != null && bVar.e != null && this.$internalFormat != null && bVar.f != null) {
            GLES20.glTexImage2D(p.m105constructorimpl(bVar.f1968b), 0, this.$internalFormat.intValue(), this.this$0.c.intValue(), this.this$0.d.intValue(), 0, p.m105constructorimpl(this.this$0.e.intValue()), p.m105constructorimpl(this.this$0.f.intValue()), null);
        }
        GLES20.glTexParameterf(p.m105constructorimpl(this.this$0.f1968b), f.e, f.j);
        GLES20.glTexParameterf(p.m105constructorimpl(this.this$0.f1968b), f.f, f.k);
        int iM105constructorimpl = p.m105constructorimpl(this.this$0.f1968b);
        int i = f.g;
        int i2 = f.i;
        GLES20.glTexParameteri(iM105constructorimpl, i, i2);
        GLES20.glTexParameteri(p.m105constructorimpl(this.this$0.f1968b), f.h, i2);
        d.b("glTexParameter");
        return Unit.a;
    }
}
