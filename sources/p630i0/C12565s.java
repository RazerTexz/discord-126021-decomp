package p630i0;

import java.io.IOException;
import java.lang.reflect.Array;

/* JADX INFO: renamed from: i0.s */
/* JADX INFO: compiled from: ParameterHandler.java */
/* JADX INFO: loaded from: classes3.dex */
public class C12565s extends AbstractC12566t<Object> {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ AbstractC12566t f26570a;

    public C12565s(AbstractC12566t abstractC12566t) {
        this.f26570a = abstractC12566t;
    }

    @Override // p630i0.AbstractC12566t
    /* JADX INFO: renamed from: a */
    public void mo10715a(C12568v c12568v, Object obj) throws IOException {
        if (obj == null) {
            return;
        }
        int length = Array.getLength(obj);
        for (int i = 0; i < length; i++) {
            this.f26570a.mo10715a(c12568v, Array.get(obj, i));
        }
    }
}
