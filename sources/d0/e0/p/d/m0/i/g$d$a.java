package d0.e0.p.d.m0.i;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map$Entry;
import kotlin.reflect.jvm.internal.impl.protobuf.CodedOutputStream;

/* JADX INFO: compiled from: GeneratedMessageLite.java */
/* JADX INFO: loaded from: classes3.dex */
public class g$d$a {
    public final Iterator<Map$Entry<g$e, Object>> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Map$Entry<g$e, Object> f3430b;
    public final boolean c;
    public final /* synthetic */ g$d d;

    public g$d$a(g$d g_d, boolean z2, g$a g_a) {
        this.d = g_d;
        Iterator<Map$Entry<g$e, Object>> it = g$d.a(g_d).iterator();
        this.a = it;
        if (it.hasNext()) {
            this.f3430b = it.next();
        }
        this.c = z2;
    }

    public void writeUntil(int i, CodedOutputStream codedOutputStream) throws IOException {
        while (true) {
            Map$Entry<g$e, Object> map$Entry = this.f3430b;
            if (map$Entry == null || map$Entry.getKey().getNumber() >= i) {
                return;
            }
            g$e key = this.f3430b.getKey();
            if (this.c && key.getLiteJavaType() == w$c.MESSAGE && !key.isRepeated()) {
                codedOutputStream.writeMessageSetExtension(key.getNumber(), (n) this.f3430b.getValue());
            } else {
                f.writeField(key, this.f3430b.getValue(), codedOutputStream);
            }
            if (this.a.hasNext()) {
                this.f3430b = this.a.next();
            } else {
                this.f3430b = null;
            }
        }
    }
}
