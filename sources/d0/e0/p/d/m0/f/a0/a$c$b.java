package d0.e0.p.d.m0.f.a0;

import d0.e0.p.d.m0.i.d;
import d0.e0.p.d.m0.i.e;
import d0.e0.p.d.m0.i.g;
import d0.e0.p.d.m0.i.g$b;
import d0.e0.p.d.m0.i.n;
import d0.e0.p.d.m0.i.n$a;
import d0.e0.p.d.m0.i.o;
import java.io.IOException;
import kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException;
import kotlin.reflect.jvm.internal.impl.protobuf.UninitializedMessageException;

/* JADX INFO: compiled from: JvmProtoBuf.java */
/* JADX INFO: loaded from: classes3.dex */
public final class a$c$b extends g$b<a$c, a$c$b> implements o {
    public int k;
    public int l;
    public int m;

    @Override // d0.e0.p.d.m0.i.n$a
    public /* bridge */ /* synthetic */ n build() {
        return build();
    }

    public a$c buildPartial() {
        a$c a_c = new a$c(this, null);
        int i = this.k;
        int i2 = (i & 1) != 1 ? 0 : 1;
        a$c.a(a_c, this.l);
        if ((i & 2) == 2) {
            i2 |= 2;
        }
        a$c.b(a_c, this.m);
        a$c.c(a_c, i2);
        return a_c;
    }

    @Override // d0.e0.p.d.m0.i.g$b
    /* JADX INFO: renamed from: clone */
    public /* bridge */ /* synthetic */ Object mo88clone() throws CloneNotSupportedException {
        return clone();
    }

    @Override // d0.e0.p.d.m0.i.a$a, d0.e0.p.d.m0.i.n$a
    public /* bridge */ /* synthetic */ d0.e0.p.d.m0.i.a$a mergeFrom(d dVar, e eVar) throws IOException {
        return mergeFrom(dVar, eVar);
    }

    public a$c$b setDesc(int i) {
        this.k |= 2;
        this.m = i;
        return this;
    }

    public a$c$b setName(int i) {
        this.k |= 1;
        this.l = i;
        return this;
    }

    @Override // d0.e0.p.d.m0.i.n$a
    public a$c build() {
        a$c a_cBuildPartial = buildPartial();
        if (a_cBuildPartial.isInitialized()) {
            return a_cBuildPartial;
        }
        throw new UninitializedMessageException(a_cBuildPartial);
    }

    @Override // d0.e0.p.d.m0.i.g$b
    public /* bridge */ /* synthetic */ g$b clone() {
        return clone();
    }

    @Override // d0.e0.p.d.m0.i.g$b
    public /* bridge */ /* synthetic */ g$b mergeFrom(g gVar) {
        return mergeFrom((a$c) gVar);
    }

    @Override // d0.e0.p.d.m0.i.g$b
    public a$c$b clone() {
        return new a$c$b().mergeFrom(buildPartial());
    }

    @Override // d0.e0.p.d.m0.i.a$a, d0.e0.p.d.m0.i.n$a
    public /* bridge */ /* synthetic */ n$a mergeFrom(d dVar, e eVar) throws IOException {
        return mergeFrom(dVar, eVar);
    }

    public a$c$b mergeFrom(a$c a_c) {
        if (a_c == a$c.getDefaultInstance()) {
            return this;
        }
        if (a_c.hasName()) {
            setName(a_c.getName());
        }
        if (a_c.hasDesc()) {
            setDesc(a_c.getDesc());
        }
        setUnknownFields(getUnknownFields().concat(a$c.d(a_c)));
        return this;
    }

    /* JADX WARN: Code duplicated, block: B:15:0x001d  */
    @Override // d0.e0.p.d.m0.i.a$a, d0.e0.p.d.m0.i.n$a
    public a$c$b mergeFrom(d dVar, e eVar) throws Throwable {
        a$c a_c = null;
        try {
            try {
                a$c partialFrom = a$c.k.parsePartialFrom(dVar, eVar);
                if (partialFrom != null) {
                    mergeFrom(partialFrom);
                }
                return this;
            } catch (InvalidProtocolBufferException e) {
                a$c a_c2 = (a$c) e.getUnfinishedMessage();
                try {
                    throw e;
                } catch (Throwable th) {
                    th = th;
                    a_c = a_c2;
                    if (a_c != null) {
                        mergeFrom(a_c);
                    }
                    throw th;
                }
            }
        } catch (Throwable th2) {
            th = th2;
            if (a_c != null) {
                mergeFrom(a_c);
            }
            throw th;
        }
    }
}
