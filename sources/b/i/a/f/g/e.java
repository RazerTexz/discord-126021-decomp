package b.i.a.f.g;

import android.content.Context;
import com.google.android.gms.dynamite.DynamiteModule;

/* JADX INFO: compiled from: com.google.android.gms:play-services-basement@@17.6.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class e implements DynamiteModule.a {
    @Override // com.google.android.gms.dynamite.DynamiteModule.a
    public final j a(Context context, String str, i iVar) throws DynamiteModule.LoadingException {
        int iA;
        j jVar = new j();
        int iB = iVar.b(context, str);
        jVar.a = iB;
        int i = 0;
        if (iB != 0) {
            iA = iVar.a(context, str, false);
            jVar.f1402b = iA;
        } else {
            iA = iVar.a(context, str, true);
            jVar.f1402b = iA;
        }
        int i2 = jVar.a;
        if (i2 == 0) {
            if (iA == 0) {
                jVar.c = 0;
            }
            return jVar;
        }
        i = i2;
        if (i >= iA) {
            jVar.c = -1;
        } else {
            jVar.c = 1;
        }
        return jVar;
    }
}
