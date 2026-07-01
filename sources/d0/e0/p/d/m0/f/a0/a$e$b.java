package d0.e0.p.d.m0.f.a0;

import d0.e0.p.d.m0.i.d;
import d0.e0.p.d.m0.i.e;
import d0.e0.p.d.m0.i.g;
import d0.e0.p.d.m0.i.g$b;
import d0.e0.p.d.m0.i.n;
import d0.e0.p.d.m0.i.n$a;
import d0.e0.p.d.m0.i.o;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException;
import kotlin.reflect.jvm.internal.impl.protobuf.UninitializedMessageException;

/* JADX INFO: compiled from: JvmProtoBuf.java */
/* JADX INFO: loaded from: classes3.dex */
public final class a$e$b extends g$b<a$e, a$e$b> implements o {
    public int k;
    public List<a$e$c> l = Collections.emptyList();
    public List<Integer> m = Collections.emptyList();

    @Override // d0.e0.p.d.m0.i.n$a
    public /* bridge */ /* synthetic */ n build() {
        return build();
    }

    public a$e buildPartial() {
        a$e a_e = new a$e(this, null);
        if ((this.k & 1) == 1) {
            this.l = Collections.unmodifiableList(this.l);
            this.k &= -2;
        }
        a$e.b(a_e, this.l);
        if ((this.k & 2) == 2) {
            this.m = Collections.unmodifiableList(this.m);
            this.k &= -3;
        }
        a$e.d(a_e, this.m);
        return a_e;
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

    @Override // d0.e0.p.d.m0.i.n$a
    public a$e build() {
        a$e a_eBuildPartial = buildPartial();
        if (a_eBuildPartial.isInitialized()) {
            return a_eBuildPartial;
        }
        throw new UninitializedMessageException(a_eBuildPartial);
    }

    @Override // d0.e0.p.d.m0.i.g$b
    public /* bridge */ /* synthetic */ g$b clone() {
        return clone();
    }

    @Override // d0.e0.p.d.m0.i.g$b
    public /* bridge */ /* synthetic */ g$b mergeFrom(g gVar) {
        return mergeFrom((a$e) gVar);
    }

    @Override // d0.e0.p.d.m0.i.g$b
    public a$e$b clone() {
        return new a$e$b().mergeFrom(buildPartial());
    }

    @Override // d0.e0.p.d.m0.i.a$a, d0.e0.p.d.m0.i.n$a
    public /* bridge */ /* synthetic */ n$a mergeFrom(d dVar, e eVar) throws IOException {
        return mergeFrom(dVar, eVar);
    }

    public a$e$b mergeFrom(a$e a_e) {
        if (a_e == a$e.getDefaultInstance()) {
            return this;
        }
        if (!a$e.a(a_e).isEmpty()) {
            if (this.l.isEmpty()) {
                this.l = a$e.a(a_e);
                this.k &= -2;
            } else {
                if ((this.k & 1) != 1) {
                    this.l = new ArrayList(this.l);
                    this.k |= 1;
                }
                this.l.addAll(a$e.a(a_e));
            }
        }
        if (!a$e.c(a_e).isEmpty()) {
            if (this.m.isEmpty()) {
                this.m = a$e.c(a_e);
                this.k &= -3;
            } else {
                if ((this.k & 2) != 2) {
                    this.m = new ArrayList(this.m);
                    this.k |= 2;
                }
                this.m.addAll(a$e.c(a_e));
            }
        }
        setUnknownFields(getUnknownFields().concat(a$e.e(a_e)));
        return this;
    }

    /* JADX WARN: Code duplicated, block: B:15:0x001d  */
    @Override // d0.e0.p.d.m0.i.a$a, d0.e0.p.d.m0.i.n$a
    public a$e$b mergeFrom(d dVar, e eVar) throws Throwable {
        a$e a_e = null;
        try {
            try {
                a$e partialFrom = a$e.k.parsePartialFrom(dVar, eVar);
                if (partialFrom != null) {
                    mergeFrom(partialFrom);
                }
                return this;
            } catch (InvalidProtocolBufferException e) {
                a$e a_e2 = (a$e) e.getUnfinishedMessage();
                try {
                    throw e;
                } catch (Throwable th) {
                    th = th;
                    a_e = a_e2;
                    if (a_e != null) {
                        mergeFrom(a_e);
                    }
                    throw th;
                }
            }
        } catch (Throwable th2) {
            th = th2;
            if (a_e != null) {
                mergeFrom(a_e);
            }
            throw th;
        }
    }
}
