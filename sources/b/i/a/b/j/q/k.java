package b.i.a.b.j.q;

import android.content.Context;
import androidx.annotation.Nullable;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: MetadataBackendRegistry.java */
/* JADX INFO: loaded from: classes3.dex */
public class k implements e {
    public final k$a a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final i f776b;
    public final Map<String, m> c;

    public k(Context context, i iVar) {
        k$a k_a = new k$a(context);
        this.c = new HashMap();
        this.a = k_a;
        this.f776b = iVar;
    }

    @Override // b.i.a.b.j.q.e
    @Nullable
    public synchronized m get(String str) {
        if (this.c.containsKey(str)) {
            return this.c.get(str);
        }
        d dVarA = this.a.a(str);
        if (dVarA == null) {
            return null;
        }
        i iVar = this.f776b;
        m mVarCreate = dVarA.create(new c(iVar.a, iVar.f774b, iVar.c, str));
        this.c.put(str, mVarCreate);
        return mVarCreate;
    }
}
