package b.o.b.d;

import android.graphics.RectF;
import b.i.a.f.e.o.f;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.m;
import java.nio.FloatBuffer;

/* JADX INFO: compiled from: GlTextureProgram.kt */
/* JADX INFO: loaded from: classes3.dex */
public class d extends a {
    public float[] e;
    public final b f;
    public FloatBuffer g;
    public final b h;
    public final b i;
    public final b j;
    public final RectF k;
    public int l;
    public b.o.b.b.a m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(int i, String str, String str2, String str3, String str4) {
        super(i, false, new c[0]);
        m.checkNotNullParameter(str, "vertexPositionName");
        m.checkNotNullParameter(str2, "vertexMvpMatrixName");
        b$a b_a = b$a.ATTRIB;
        b$a b_a2 = b$a.UNIFORM;
        m.checkNotNullParameter(str, "vertexPositionName");
        m.checkNotNullParameter(str2, "vertexMvpMatrixName");
        this.e = f.J0(b.o.b.a.d.a);
        m.checkNotNullParameter(str4, ModelAuditLogEntry.CHANGE_KEY_NAME);
        int i2 = this.a;
        m.checkNotNullParameter(str4, ModelAuditLogEntry.CHANGE_KEY_NAME);
        this.f = new b(i2, b_a2, str4, null);
        this.g = f.X(8);
        m.checkNotNullParameter(str3, ModelAuditLogEntry.CHANGE_KEY_NAME);
        int i3 = this.a;
        m.checkNotNullParameter(str3, ModelAuditLogEntry.CHANGE_KEY_NAME);
        this.h = new b(i3, b_a, str3, null);
        m.checkNotNullParameter(str, ModelAuditLogEntry.CHANGE_KEY_NAME);
        int i4 = this.a;
        m.checkNotNullParameter(str, ModelAuditLogEntry.CHANGE_KEY_NAME);
        this.i = new b(i4, b_a, str, null);
        m.checkNotNullParameter(str2, ModelAuditLogEntry.CHANGE_KEY_NAME);
        int i5 = this.a;
        m.checkNotNullParameter(str2, ModelAuditLogEntry.CHANGE_KEY_NAME);
        this.j = new b(i5, b_a2, str2, null);
        this.k = new RectF();
        this.l = -1;
    }
}
