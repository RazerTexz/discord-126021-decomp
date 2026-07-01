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
public final class a$b$b extends g$b<a$b, a$b$b> implements o {
    public int k;
    public int l;
    public int m;

    @Override // d0.e0.p.d.m0.i.n$a
    public /* bridge */ /* synthetic */ n build() {
        return build();
    }

    public a$b buildPartial() {
        a$b a_b = new a$b(this, null);
        int i = this.k;
        int i2 = (i & 1) != 1 ? 0 : 1;
        a$b.a(a_b, this.l);
        if ((i & 2) == 2) {
            i2 |= 2;
        }
        a$b.b(a_b, this.m);
        a$b.c(a_b, i2);
        return a_b;
    }

    @Override // d0.e0.p.d.m0.i.g$b
    /* JADX INFO: renamed from: clone, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object mo88clone() throws CloneNotSupportedException {
        return clone();
    }

    @Override // d0.e0.p.d.m0.i.a$a, d0.e0.p.d.m0.i.n$a
    public /* bridge */ /* synthetic */ d0.e0.p.d.m0.i.a$a mergeFrom(d dVar, e eVar) throws IOException {
        return mergeFrom(dVar, eVar);
    }

    public a$b$b setDesc(int i) {
        this.k |= 2;
        this.m = i;
        return this;
    }

    public a$b$b setName(int i) {
        this.k |= 1;
        this.l = i;
        return this;
    }

    @Override // d0.e0.p.d.m0.i.n$a
    public a$b build() {
        a$b a_bBuildPartial = buildPartial();
        if (a_bBuildPartial.isInitialized()) {
            return a_bBuildPartial;
        }
        throw new UninitializedMessageException(a_bBuildPartial);
    }

    @Override // d0.e0.p.d.m0.i.g$b
    public /* bridge */ /* synthetic */ g$b clone() {
        return clone();
    }

    @Override // d0.e0.p.d.m0.i.g$b
    public /* bridge */ /* synthetic */ g$b mergeFrom(g gVar) {
        return mergeFrom((a$b) gVar);
    }

    @Override // d0.e0.p.d.m0.i.g$b
    public a$b$b clone() {
        return new a$b$b().mergeFrom(buildPartial());
    }

    @Override // d0.e0.p.d.m0.i.a$a, d0.e0.p.d.m0.i.n$a
    public /* bridge */ /* synthetic */ n$a mergeFrom(d dVar, e eVar) throws IOException {
        return mergeFrom(dVar, eVar);
    }

    public a$b$b mergeFrom(a$b a_b) {
        if (a_b == a$b.getDefaultInstance()) {
            return this;
        }
        if (a_b.hasName()) {
            setName(a_b.getName());
        }
        if (a_b.hasDesc()) {
            setDesc(a_b.getDesc());
        }
        setUnknownFields(getUnknownFields().concat(a$b.d(a_b)));
        return this;
    }

    /* JADX WARN: Code duplicated, block: B:15:0x001d  */
    @Override // d0.e0.p.d.m0.i.a$a, d0.e0.p.d.m0.i.n$a
    public a$b$b mergeFrom(d dVar, e eVar) throws Throwable {
        a$b a_b = null;
        try {
            try {
                a$b partialFrom = a$b.k.parsePartialFrom(dVar, eVar);
                if (partialFrom != null) {
                    mergeFrom(partialFrom);
                }
                return this;
            } catch (InvalidProtocolBufferException e) {
                a$b a_b2 = (a$b) e.getUnfinishedMessage();
                try {
                    throw e;
                } catch (Throwable th) {
                    th = th;
                    a_b = a_b2;
                    if (a_b != null) {
                        mergeFrom(a_b);
                    }
                    throw th;
                }
            }
        } catch (Throwable th2) {
            th = th2;
            if (a_b != null) {
                mergeFrom(a_b);
            }
            throw th;
        }
    }
}
