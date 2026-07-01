package b.i.a.f.g;

import android.content.Context;
import com.google.android.gms.dynamite.DynamiteModule$LoadingException;
import com.google.android.gms.dynamite.DynamiteModule$a;

/* JADX INFO: compiled from: com.google.android.gms:play-services-basement@@17.6.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class f implements DynamiteModule$a {
    /* JADX WARN: Code duplicated, block: B:8:0x001f  */
    /* JADX WARN: Code duplicated, block: B:9:0x0022  */
    @Override // com.google.android.gms.dynamite.DynamiteModule$a
    public final j a(Context context, String str, i iVar) throws DynamiteModule$LoadingException {
        j jVar = new j();
        jVar.a = iVar.b(context, str);
        int iA = iVar.a(context, str, true);
        jVar.f1402b = iA;
        int i = jVar.a;
        if (i != 0) {
            if (iA >= i) {
                jVar.c = 1;
            } else {
                jVar.c = -1;
            }
        } else if (iA == 0) {
            jVar.c = 0;
        } else {
            i = 0;
            if (iA >= i) {
                jVar.c = 1;
            } else {
                jVar.c = -1;
            }
        }
        return jVar;
    }
}
