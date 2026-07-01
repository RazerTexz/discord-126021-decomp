package b.o.b.d;

import android.graphics.RectF;
import b.i.a.f.e.o.f;
import b.o.b.a.Egloo;
import b.o.b.b.Gl2dDrawable;
import b.o.b.d.GlProgramLocation;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.Intrinsics3;
import java.nio.FloatBuffer;

/* JADX INFO: renamed from: b.o.b.d.d, reason: use source file name */
/* JADX INFO: compiled from: GlTextureProgram.kt */
/* JADX INFO: loaded from: classes3.dex */
public class GlTextureProgram extends GlProgram {
    public float[] e;
    public final GlProgramLocation f;
    public FloatBuffer g;
    public final GlProgramLocation h;
    public final GlProgramLocation i;
    public final GlProgramLocation j;
    public final RectF k;
    public int l;
    public Gl2dDrawable m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GlTextureProgram(int i, String str, String str2, String str3, String str4) {
        super(i, false, new GlShader2[0]);
        Intrinsics3.checkNotNullParameter(str, "vertexPositionName");
        Intrinsics3.checkNotNullParameter(str2, "vertexMvpMatrixName");
        GlProgramLocation.a aVar = GlProgramLocation.a.ATTRIB;
        GlProgramLocation.a aVar2 = GlProgramLocation.a.UNIFORM;
        Intrinsics3.checkNotNullParameter(str, "vertexPositionName");
        Intrinsics3.checkNotNullParameter(str2, "vertexMvpMatrixName");
        this.e = f.J0(Egloo.a);
        Intrinsics3.checkNotNullParameter(str4, ModelAuditLogEntry.CHANGE_KEY_NAME);
        int i2 = this.a;
        Intrinsics3.checkNotNullParameter(str4, ModelAuditLogEntry.CHANGE_KEY_NAME);
        this.f = new GlProgramLocation(i2, aVar2, str4, null);
        this.g = f.X(8);
        Intrinsics3.checkNotNullParameter(str3, ModelAuditLogEntry.CHANGE_KEY_NAME);
        int i3 = this.a;
        Intrinsics3.checkNotNullParameter(str3, ModelAuditLogEntry.CHANGE_KEY_NAME);
        this.h = new GlProgramLocation(i3, aVar, str3, null);
        Intrinsics3.checkNotNullParameter(str, ModelAuditLogEntry.CHANGE_KEY_NAME);
        int i4 = this.a;
        Intrinsics3.checkNotNullParameter(str, ModelAuditLogEntry.CHANGE_KEY_NAME);
        this.i = new GlProgramLocation(i4, aVar, str, null);
        Intrinsics3.checkNotNullParameter(str2, ModelAuditLogEntry.CHANGE_KEY_NAME);
        int i5 = this.a;
        Intrinsics3.checkNotNullParameter(str2, ModelAuditLogEntry.CHANGE_KEY_NAME);
        this.j = new GlProgramLocation(i5, aVar2, str2, null);
        this.k = new RectF();
        this.l = -1;
    }
}
