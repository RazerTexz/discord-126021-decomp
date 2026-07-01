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
public final class a$d$b extends g$b<a$d, a$d$b> implements o {
    public int k;
    public a$b l = a$b.getDefaultInstance();
    public a$c m = a$c.getDefaultInstance();
    public a$c n = a$c.getDefaultInstance();
    public a$c o = a$c.getDefaultInstance();

    @Override // d0.e0.p.d.m0.i.n$a
    public /* bridge */ /* synthetic */ n build() {
        return build();
    }

    public a$d buildPartial() {
        a$d a_d = new a$d(this, null);
        int i = this.k;
        int i2 = (i & 1) != 1 ? 0 : 1;
        a$d.a(a_d, this.l);
        if ((i & 2) == 2) {
            i2 |= 2;
        }
        a$d.b(a_d, this.m);
        if ((i & 4) == 4) {
            i2 |= 4;
        }
        a$d.c(a_d, this.n);
        if ((i & 8) == 8) {
            i2 |= 8;
        }
        a$d.d(a_d, this.o);
        a$d.e(a_d, i2);
        return a_d;
    }

    @Override // d0.e0.p.d.m0.i.g$b
    /* JADX INFO: renamed from: clone */
    public /* bridge */ /* synthetic */ Object mo88clone() throws CloneNotSupportedException {
        return clone();
    }

    public a$d$b mergeField(a$b a_b) {
        if ((this.k & 1) != 1 || this.l == a$b.getDefaultInstance()) {
            this.l = a_b;
        } else {
            this.l = a$b.newBuilder(this.l).mergeFrom(a_b).buildPartial();
        }
        this.k |= 1;
        return this;
    }

    @Override // d0.e0.p.d.m0.i.a$a, d0.e0.p.d.m0.i.n$a
    public /* bridge */ /* synthetic */ d0.e0.p.d.m0.i.a$a mergeFrom(d dVar, e eVar) throws IOException {
        return mergeFrom(dVar, eVar);
    }

    public a$d$b mergeGetter(a$c a_c) {
        if ((this.k & 4) != 4 || this.n == a$c.getDefaultInstance()) {
            this.n = a_c;
        } else {
            this.n = a$c.newBuilder(this.n).mergeFrom(a_c).buildPartial();
        }
        this.k |= 4;
        return this;
    }

    public a$d$b mergeSetter(a$c a_c) {
        if ((this.k & 8) != 8 || this.o == a$c.getDefaultInstance()) {
            this.o = a_c;
        } else {
            this.o = a$c.newBuilder(this.o).mergeFrom(a_c).buildPartial();
        }
        this.k |= 8;
        return this;
    }

    public a$d$b mergeSyntheticMethod(a$c a_c) {
        if ((this.k & 2) != 2 || this.m == a$c.getDefaultInstance()) {
            this.m = a_c;
        } else {
            this.m = a$c.newBuilder(this.m).mergeFrom(a_c).buildPartial();
        }
        this.k |= 2;
        return this;
    }

    @Override // d0.e0.p.d.m0.i.n$a
    public a$d build() {
        a$d a_dBuildPartial = buildPartial();
        if (a_dBuildPartial.isInitialized()) {
            return a_dBuildPartial;
        }
        throw new UninitializedMessageException(a_dBuildPartial);
    }

    @Override // d0.e0.p.d.m0.i.g$b
    public /* bridge */ /* synthetic */ g$b clone() {
        return clone();
    }

    @Override // d0.e0.p.d.m0.i.g$b
    public /* bridge */ /* synthetic */ g$b mergeFrom(g gVar) {
        return mergeFrom((a$d) gVar);
    }

    @Override // d0.e0.p.d.m0.i.g$b
    public a$d$b clone() {
        return new a$d$b().mergeFrom(buildPartial());
    }

    @Override // d0.e0.p.d.m0.i.a$a, d0.e0.p.d.m0.i.n$a
    public /* bridge */ /* synthetic */ n$a mergeFrom(d dVar, e eVar) throws IOException {
        return mergeFrom(dVar, eVar);
    }

    public a$d$b mergeFrom(a$d a_d) {
        if (a_d == a$d.getDefaultInstance()) {
            return this;
        }
        if (a_d.hasField()) {
            mergeField(a_d.getField());
        }
        if (a_d.hasSyntheticMethod()) {
            mergeSyntheticMethod(a_d.getSyntheticMethod());
        }
        if (a_d.hasGetter()) {
            mergeGetter(a_d.getGetter());
        }
        if (a_d.hasSetter()) {
            mergeSetter(a_d.getSetter());
        }
        setUnknownFields(getUnknownFields().concat(a$d.f(a_d)));
        return this;
    }

    /* JADX WARN: Code duplicated, block: B:15:0x001d  */
    @Override // d0.e0.p.d.m0.i.a$a, d0.e0.p.d.m0.i.n$a
    public a$d$b mergeFrom(d dVar, e eVar) throws Throwable {
        a$d a_d = null;
        try {
            try {
                a$d partialFrom = a$d.k.parsePartialFrom(dVar, eVar);
                if (partialFrom != null) {
                    mergeFrom(partialFrom);
                }
                return this;
            } catch (InvalidProtocolBufferException e) {
                a$d a_d2 = (a$d) e.getUnfinishedMessage();
                try {
                    throw e;
                } catch (Throwable th) {
                    th = th;
                    a_d = a_d2;
                    if (a_d != null) {
                        mergeFrom(a_d);
                    }
                    throw th;
                }
            }
        } catch (Throwable th2) {
            th = th2;
            if (a_d != null) {
                mergeFrom(a_d);
            }
            throw th;
        }
    }
}
