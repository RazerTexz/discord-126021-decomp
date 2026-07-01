package b.g.a.c.i0;

import b.g.a.b.JsonLocation;
import b.g.a.b.JsonStreamContext;

/* JADX INFO: renamed from: b.g.a.c.i0.t, reason: use source file name */
/* JADX INFO: compiled from: TokenBufferReadContext.java */
/* JADX INFO: loaded from: classes3.dex */
public class TokenBufferReadContext extends JsonStreamContext {
    public final JsonStreamContext c;
    public final JsonLocation d;
    public String e;
    public Object f;

    public TokenBufferReadContext() {
        super(0, -1);
        this.c = null;
        this.d = JsonLocation.j;
    }

    @Override // b.g.a.b.JsonStreamContext
    public String a() {
        return this.e;
    }

    @Override // b.g.a.b.JsonStreamContext
    public void d(Object obj) {
        this.f = obj;
    }
}
