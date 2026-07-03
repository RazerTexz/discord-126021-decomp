package p007b.p452o.p475b.p481f;

import android.opengl.GLES20;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import p007b.p452o.p475b.p476a.C5252d;
import p007b.p452o.p475b.p478c.C5261f;
import p507d0.C12117p;
import p507d0.p592z.p594d.AbstractC12240o;

/* JADX INFO: renamed from: b.o.b.f.a */
/* JADX INFO: compiled from: GlTexture.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C5268a extends AbstractC12240o implements Function0<Unit> {
    public final /* synthetic */ Integer $internalFormat;
    public final /* synthetic */ C5269b this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C5268a(C5269b c5269b, Integer num) {
        super(0);
        this.this$0 = c5269b;
        this.$internalFormat = num;
    }

    @Override // kotlin.jvm.functions.Function0
    public Unit invoke() {
        C5269b c5269b = this.this$0;
        if (c5269b.f14333c != null && c5269b.f14334d != null && c5269b.f14335e != null && this.$internalFormat != null && c5269b.f14336f != null) {
            GLES20.glTexImage2D(C12117p.m11482constructorimpl(c5269b.f14332b), 0, this.$internalFormat.intValue(), this.this$0.f14333c.intValue(), this.this$0.f14334d.intValue(), 0, C12117p.m11482constructorimpl(this.this$0.f14335e.intValue()), C12117p.m11482constructorimpl(this.this$0.f14336f.intValue()), null);
        }
        GLES20.glTexParameterf(C12117p.m11482constructorimpl(this.this$0.f14332b), C5261f.f14295e, C5261f.f14300j);
        GLES20.glTexParameterf(C12117p.m11482constructorimpl(this.this$0.f14332b), C5261f.f14296f, C5261f.f14301k);
        int iM11482constructorimpl = C12117p.m11482constructorimpl(this.this$0.f14332b);
        int i = C5261f.f14297g;
        int i2 = C5261f.f14299i;
        GLES20.glTexParameteri(iM11482constructorimpl, i, i2);
        GLES20.glTexParameteri(C12117p.m11482constructorimpl(this.this$0.f14332b), C5261f.f14298h, i2);
        C5252d.m7457b("glTexParameter");
        return Unit.f27425a;
    }
}
