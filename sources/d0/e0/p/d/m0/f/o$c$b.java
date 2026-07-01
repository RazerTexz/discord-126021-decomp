package d0.e0.p.d.m0.f;

import d0.e0.p.d.m0.i.a$a;
import java.io.IOException;
import java.util.Objects;
import kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException;
import kotlin.reflect.jvm.internal.impl.protobuf.UninitializedMessageException;

/* JADX INFO: compiled from: ProtoBuf.java */
/* JADX INFO: loaded from: classes3.dex */
public final class o$c$b extends d0.e0.p.d.m0.i.g$b<o$c, o$c$b> implements d0.e0.p.d.m0.i.o {
    public int k;
    public int m;
    public int l = -1;
    public o$c$c n = o$c$c.PACKAGE;

    @Override // d0.e0.p.d.m0.i.n$a
    public /* bridge */ /* synthetic */ d0.e0.p.d.m0.i.n build() {
        return build();
    }

    public o$c buildPartial() {
        o$c o_c = new o$c(this, null);
        int i = this.k;
        int i2 = (i & 1) != 1 ? 0 : 1;
        o$c.e(o_c, this.l);
        if ((i & 2) == 2) {
            i2 |= 2;
        }
        o$c.a(o_c, this.m);
        if ((i & 4) == 4) {
            i2 |= 4;
        }
        o$c.b(o_c, this.n);
        o$c.c(o_c, i2);
        return o_c;
    }

    @Override // d0.e0.p.d.m0.i.g$b
    /* JADX INFO: renamed from: clone */
    public /* bridge */ /* synthetic */ Object mo88clone() throws CloneNotSupportedException {
        return clone();
    }

    @Override // d0.e0.p.d.m0.i.a$a, d0.e0.p.d.m0.i.n$a
    public /* bridge */ /* synthetic */ a$a mergeFrom(d0.e0.p.d.m0.i.d dVar, d0.e0.p.d.m0.i.e eVar) throws IOException {
        return mergeFrom(dVar, eVar);
    }

    public o$c$b setKind(o$c$c o_c_c) {
        Objects.requireNonNull(o_c_c);
        this.k |= 4;
        this.n = o_c_c;
        return this;
    }

    public o$c$b setParentQualifiedName(int i) {
        this.k |= 1;
        this.l = i;
        return this;
    }

    public o$c$b setShortName(int i) {
        this.k |= 2;
        this.m = i;
        return this;
    }

    @Override // d0.e0.p.d.m0.i.n$a
    public o$c build() {
        o$c o_cBuildPartial = buildPartial();
        if (o_cBuildPartial.isInitialized()) {
            return o_cBuildPartial;
        }
        throw new UninitializedMessageException(o_cBuildPartial);
    }

    @Override // d0.e0.p.d.m0.i.g$b
    public /* bridge */ /* synthetic */ d0.e0.p.d.m0.i.g$b clone() {
        return clone();
    }

    @Override // d0.e0.p.d.m0.i.g$b
    public /* bridge */ /* synthetic */ d0.e0.p.d.m0.i.g$b mergeFrom(d0.e0.p.d.m0.i.g gVar) {
        return mergeFrom((o$c) gVar);
    }

    @Override // d0.e0.p.d.m0.i.g$b
    public o$c$b clone() {
        return new o$c$b().mergeFrom(buildPartial());
    }

    @Override // d0.e0.p.d.m0.i.a$a, d0.e0.p.d.m0.i.n$a
    public /* bridge */ /* synthetic */ d0.e0.p.d.m0.i.n$a mergeFrom(d0.e0.p.d.m0.i.d dVar, d0.e0.p.d.m0.i.e eVar) throws IOException {
        return mergeFrom(dVar, eVar);
    }

    public o$c$b mergeFrom(o$c o_c) {
        if (o_c == o$c.getDefaultInstance()) {
            return this;
        }
        if (o_c.hasParentQualifiedName()) {
            setParentQualifiedName(o_c.getParentQualifiedName());
        }
        if (o_c.hasShortName()) {
            setShortName(o_c.getShortName());
        }
        if (o_c.hasKind()) {
            setKind(o_c.getKind());
        }
        setUnknownFields(getUnknownFields().concat(o$c.d(o_c)));
        return this;
    }

    /* JADX WARN: Code duplicated, block: B:15:0x001d  */
    @Override // d0.e0.p.d.m0.i.a$a, d0.e0.p.d.m0.i.n$a
    public o$c$b mergeFrom(d0.e0.p.d.m0.i.d dVar, d0.e0.p.d.m0.i.e eVar) throws Throwable {
        o$c o_c = null;
        try {
            try {
                o$c partialFrom = o$c.k.parsePartialFrom(dVar, eVar);
                if (partialFrom != null) {
                    mergeFrom(partialFrom);
                }
                return this;
            } catch (InvalidProtocolBufferException e) {
                o$c o_c2 = (o$c) e.getUnfinishedMessage();
                try {
                    throw e;
                } catch (Throwable th) {
                    th = th;
                    o_c = o_c2;
                    if (o_c != null) {
                        mergeFrom(o_c);
                    }
                    throw th;
                }
            }
        } catch (Throwable th2) {
            th = th2;
            if (o_c != null) {
                mergeFrom(o_c);
            }
            throw th;
        }
    }
}
