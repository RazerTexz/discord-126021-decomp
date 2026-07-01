package b.i.a.f.g;

import android.content.Context;
import com.google.android.gms.dynamite.DynamiteModule$LoadingException;
import com.google.android.gms.dynamite.DynamiteModule$a;

/* JADX INFO: compiled from: com.google.android.gms:play-services-basement@@17.6.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class d implements DynamiteModule$a {
    @Override // com.google.android.gms.dynamite.DynamiteModule$a
    public final j a(Context context, String str, i iVar) throws DynamiteModule$LoadingException {
        j jVar = new j();
        int iB = iVar.b(context, str);
        jVar.a = iB;
        if (iB != 0) {
            jVar.c = -1;
        } else {
            int iA = iVar.a(context, str, true);
            jVar.f1402b = iA;
            if (iA != 0) {
                jVar.c = 1;
            }
        }
        return jVar;
    }
}
