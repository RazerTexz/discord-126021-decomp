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
import java.util.Objects;
import kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException;
import kotlin.reflect.jvm.internal.impl.protobuf.UninitializedMessageException;

/* JADX INFO: compiled from: JvmProtoBuf.java */
/* JADX INFO: loaded from: classes3.dex */
public final class a$e$c$b extends g$b<a$e$c, a$e$c$b> implements o {
    public int k;
    public int m;
    public int l = 1;
    public Object n = "";
    public a$e$c$c o = a$e$c$c.NONE;
    public List<Integer> p = Collections.emptyList();
    public List<Integer> q = Collections.emptyList();

    @Override // d0.e0.p.d.m0.i.n$a
    public /* bridge */ /* synthetic */ n build() {
        return build();
    }

    public a$e$c buildPartial() {
        a$e$c a_e_c = new a$e$c(this, null);
        int i = this.k;
        int i2 = (i & 1) != 1 ? 0 : 1;
        a$e$c.c(a_e_c, this.l);
        if ((i & 2) == 2) {
            i2 |= 2;
        }
        a$e$c.d(a_e_c, this.m);
        if ((i & 4) == 4) {
            i2 |= 4;
        }
        a$e$c.f(a_e_c, this.n);
        if ((i & 8) == 8) {
            i2 |= 8;
        }
        a$e$c.g(a_e_c, this.o);
        if ((this.k & 16) == 16) {
            this.p = Collections.unmodifiableList(this.p);
            this.k &= -17;
        }
        a$e$c.i(a_e_c, this.p);
        if ((this.k & 32) == 32) {
            this.q = Collections.unmodifiableList(this.q);
            this.k &= -33;
        }
        a$e$c.k(a_e_c, this.q);
        a$e$c.a(a_e_c, i2);
        return a_e_c;
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

    public a$e$c$b setOperation(a$e$c$c a_e_c_c) {
        Objects.requireNonNull(a_e_c_c);
        this.k |= 8;
        this.o = a_e_c_c;
        return this;
    }

    public a$e$c$b setPredefinedIndex(int i) {
        this.k |= 2;
        this.m = i;
        return this;
    }

    public a$e$c$b setRange(int i) {
        this.k |= 1;
        this.l = i;
        return this;
    }

    @Override // d0.e0.p.d.m0.i.n$a
    public a$e$c build() {
        a$e$c a_e_cBuildPartial = buildPartial();
        if (a_e_cBuildPartial.isInitialized()) {
            return a_e_cBuildPartial;
        }
        throw new UninitializedMessageException(a_e_cBuildPartial);
    }

    @Override // d0.e0.p.d.m0.i.g$b
    public /* bridge */ /* synthetic */ g$b clone() {
        return clone();
    }

    @Override // d0.e0.p.d.m0.i.g$b
    public /* bridge */ /* synthetic */ g$b mergeFrom(g gVar) {
        return mergeFrom((a$e$c) gVar);
    }

    @Override // d0.e0.p.d.m0.i.g$b
    public a$e$c$b clone() {
        return new a$e$c$b().mergeFrom(buildPartial());
    }

    @Override // d0.e0.p.d.m0.i.a$a, d0.e0.p.d.m0.i.n$a
    public /* bridge */ /* synthetic */ n$a mergeFrom(d dVar, e eVar) throws IOException {
        return mergeFrom(dVar, eVar);
    }

    public a$e$c$b mergeFrom(a$e$c a_e_c) {
        if (a_e_c == a$e$c.getDefaultInstance()) {
            return this;
        }
        if (a_e_c.hasRange()) {
            setRange(a_e_c.getRange());
        }
        if (a_e_c.hasPredefinedIndex()) {
            setPredefinedIndex(a_e_c.getPredefinedIndex());
        }
        if (a_e_c.hasString()) {
            this.k |= 4;
            this.n = a$e$c.e(a_e_c);
        }
        if (a_e_c.hasOperation()) {
            setOperation(a_e_c.getOperation());
        }
        if (!a$e$c.h(a_e_c).isEmpty()) {
            if (this.p.isEmpty()) {
                this.p = a$e$c.h(a_e_c);
                this.k &= -17;
            } else {
                if ((this.k & 16) != 16) {
                    this.p = new ArrayList(this.p);
                    this.k |= 16;
                }
                this.p.addAll(a$e$c.h(a_e_c));
            }
        }
        if (!a$e$c.j(a_e_c).isEmpty()) {
            if (this.q.isEmpty()) {
                this.q = a$e$c.j(a_e_c);
                this.k &= -33;
            } else {
                if ((this.k & 32) != 32) {
                    this.q = new ArrayList(this.q);
                    this.k |= 32;
                }
                this.q.addAll(a$e$c.j(a_e_c));
            }
        }
        setUnknownFields(getUnknownFields().concat(a$e$c.b(a_e_c)));
        return this;
    }

    /* JADX WARN: Code duplicated, block: B:15:0x001d  */
    @Override // d0.e0.p.d.m0.i.a$a, d0.e0.p.d.m0.i.n$a
    public a$e$c$b mergeFrom(d dVar, e eVar) throws Throwable {
        a$e$c a_e_c = null;
        try {
            try {
                a$e$c partialFrom = a$e$c.k.parsePartialFrom(dVar, eVar);
                if (partialFrom != null) {
                    mergeFrom(partialFrom);
                }
                return this;
            } catch (InvalidProtocolBufferException e) {
                a$e$c a_e_c2 = (a$e$c) e.getUnfinishedMessage();
                try {
                    throw e;
                } catch (Throwable th) {
                    th = th;
                    a_e_c = a_e_c2;
                    if (a_e_c != null) {
                        mergeFrom(a_e_c);
                    }
                    throw th;
                }
            }
        } catch (Throwable th2) {
            th = th2;
            if (a_e_c != null) {
                mergeFrom(a_e_c);
            }
            throw th;
        }
    }
}
