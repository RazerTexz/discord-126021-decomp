package p007b.p452o.p475b.p479d;

import android.graphics.RectF;
import com.discord.models.domain.ModelAuditLogEntry;
import java.nio.FloatBuffer;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;
import p007b.p452o.p475b.p476a.C5252d;
import p007b.p452o.p475b.p477b.AbstractC5253a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: b.o.b.d.d */
/* JADX INFO: compiled from: GlTextureProgram.kt */
/* JADX INFO: loaded from: classes3.dex */
public class C5265d extends C5262a {

    /* JADX INFO: renamed from: e */
    public float[] f14318e;

    /* JADX INFO: renamed from: f */
    public final C5263b f14319f;

    /* JADX INFO: renamed from: g */
    public FloatBuffer f14320g;

    /* JADX INFO: renamed from: h */
    public final C5263b f14321h;

    /* JADX INFO: renamed from: i */
    public final C5263b f14322i;

    /* JADX INFO: renamed from: j */
    public final C5263b f14323j;

    /* JADX INFO: renamed from: k */
    public final RectF f14324k;

    /* JADX INFO: renamed from: l */
    public int f14325l;

    /* JADX INFO: renamed from: m */
    public AbstractC5253a f14326m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C5265d(int i, String str, String str2, String str3, String str4) {
        super(i, false, new C5264c[0]);
        C12238m.checkNotNullParameter(str, "vertexPositionName");
        C12238m.checkNotNullParameter(str2, "vertexMvpMatrixName");
        C5263b.a aVar = C5263b.a.ATTRIB;
        C5263b.a aVar2 = C5263b.a.UNIFORM;
        C12238m.checkNotNullParameter(str, "vertexPositionName");
        C12238m.checkNotNullParameter(str2, "vertexMvpMatrixName");
        this.f14318e = C3404f.m4217J0(C5252d.f14263a);
        C12238m.checkNotNullParameter(str4, ModelAuditLogEntry.CHANGE_KEY_NAME);
        int i2 = this.f14306a;
        C12238m.checkNotNullParameter(str4, ModelAuditLogEntry.CHANGE_KEY_NAME);
        this.f14319f = new C5263b(i2, aVar2, str4, null);
        this.f14320g = C3404f.m4258X(8);
        C12238m.checkNotNullParameter(str3, ModelAuditLogEntry.CHANGE_KEY_NAME);
        int i3 = this.f14306a;
        C12238m.checkNotNullParameter(str3, ModelAuditLogEntry.CHANGE_KEY_NAME);
        this.f14321h = new C5263b(i3, aVar, str3, null);
        C12238m.checkNotNullParameter(str, ModelAuditLogEntry.CHANGE_KEY_NAME);
        int i4 = this.f14306a;
        C12238m.checkNotNullParameter(str, ModelAuditLogEntry.CHANGE_KEY_NAME);
        this.f14322i = new C5263b(i4, aVar, str, null);
        C12238m.checkNotNullParameter(str2, ModelAuditLogEntry.CHANGE_KEY_NAME);
        int i5 = this.f14306a;
        C12238m.checkNotNullParameter(str2, ModelAuditLogEntry.CHANGE_KEY_NAME);
        this.f14323j = new C5263b(i5, aVar2, str2, null);
        this.f14324k = new RectF();
        this.f14325l = -1;
    }
}
