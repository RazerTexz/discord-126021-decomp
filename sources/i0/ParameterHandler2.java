package i0;

import java.io.IOException;
import java.lang.reflect.Array;

/* JADX INFO: renamed from: i0.s, reason: use source file name */
/* JADX INFO: compiled from: ParameterHandler.java */
/* JADX INFO: loaded from: classes3.dex */
public class ParameterHandler2 extends ParameterHandler3<Object> {
    public final /* synthetic */ ParameterHandler3 a;

    public ParameterHandler2(ParameterHandler3 parameterHandler3) {
        this.a = parameterHandler3;
    }

    @Override // i0.ParameterHandler3
    public void a(RequestBuilder requestBuilder, Object obj) throws IOException {
        if (obj == null) {
            return;
        }
        int length = Array.getLength(obj);
        for (int i = 0; i < length; i++) {
            this.a.a(requestBuilder, Array.get(obj, i));
        }
    }
}
