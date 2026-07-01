package i0;

import java.io.IOException;
import java.lang.reflect.Array;

/* JADX INFO: compiled from: ParameterHandler.java */
/* JADX INFO: loaded from: classes3.dex */
public class s extends t<Object> {
    public final /* synthetic */ t a;

    public s(t tVar) {
        this.a = tVar;
    }

    @Override // i0.t
    public void a(v vVar, Object obj) throws IOException {
        if (obj == null) {
            return;
        }
        int length = Array.getLength(obj);
        for (int i = 0; i < length; i++) {
            this.a.a(vVar, Array.get(obj, i));
        }
    }
}
