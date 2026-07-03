package p507d0.p513e0.p514p.p515d.p517m0.p543f;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.protobuf.CodedOutputStream;
import kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException;
import kotlin.reflect.jvm.internal.impl.protobuf.UninitializedMessageException;
import p507d0.p513e0.p514p.p515d.p517m0.p550i.AbstractC11722b;
import p507d0.p513e0.p514p.p515d.p517m0.p550i.AbstractC11723c;
import p507d0.p513e0.p514p.p515d.p517m0.p550i.AbstractC11727g;
import p507d0.p513e0.p514p.p515d.p517m0.p550i.C11724d;
import p507d0.p513e0.p514p.p515d.p517m0.p550i.C11725e;
import p507d0.p513e0.p514p.p515d.p517m0.p550i.InterfaceC11735o;
import p507d0.p513e0.p514p.p515d.p517m0.p550i.InterfaceC11736p;

/* JADX INFO: renamed from: d0.e0.p.d.m0.f.e */
/* JADX INFO: compiled from: ProtoBuf.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C11680e extends AbstractC11727g implements InterfaceC11735o {

    /* JADX INFO: renamed from: j */
    public static final C11680e f23793j;

    /* JADX INFO: renamed from: k */
    public static InterfaceC11736p<C11680e> f23794k = new a();
    private List<C11681f> effect_;
    private byte memoizedIsInitialized;
    private int memoizedSerializedSize;
    private final AbstractC11723c unknownFields;

    /* JADX INFO: renamed from: d0.e0.p.d.m0.f.e$a */
    /* JADX INFO: compiled from: ProtoBuf.java */
    public static class a extends AbstractC11722b<C11680e> {
        @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.InterfaceC11736p
        public C11680e parsePartialFrom(C11724d c11724d, C11725e c11725e) throws InvalidProtocolBufferException {
            return new C11680e(c11724d, c11725e, null);
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.f.e$b */
    /* JADX INFO: compiled from: ProtoBuf.java */
    public static final class b extends AbstractC11727g.b<C11680e, b> implements InterfaceC11735o {

        /* JADX INFO: renamed from: k */
        public int f23795k;

        /* JADX INFO: renamed from: l */
        public List<C11681f> f23796l = Collections.emptyList();

        public C11680e buildPartial() {
            C11680e c11680e = new C11680e(this, null);
            if ((this.f23795k & 1) == 1) {
                this.f23796l = Collections.unmodifiableList(this.f23796l);
                this.f23795k &= -2;
            }
            c11680e.effect_ = this.f23796l;
            return c11680e;
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.InterfaceC11734n.a
        public C11680e build() {
            C11680e c11680eBuildPartial = buildPartial();
            if (c11680eBuildPartial.isInitialized()) {
                return c11680eBuildPartial;
            }
            throw new UninitializedMessageException(c11680eBuildPartial);
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.AbstractC11727g.b
        /* JADX INFO: renamed from: clone */
        public b mo11465clone() {
            return new b().mergeFrom(buildPartial());
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.AbstractC11727g.b
        public b mergeFrom(C11680e c11680e) {
            if (c11680e == C11680e.getDefaultInstance()) {
                return this;
            }
            if (!c11680e.effect_.isEmpty()) {
                if (this.f23796l.isEmpty()) {
                    this.f23796l = c11680e.effect_;
                    this.f23795k &= -2;
                } else {
                    if ((this.f23795k & 1) != 1) {
                        this.f23796l = new ArrayList(this.f23796l);
                        this.f23795k |= 1;
                    }
                    this.f23796l.addAll(c11680e.effect_);
                }
            }
            setUnknownFields(getUnknownFields().concat(c11680e.unknownFields));
            return this;
        }

        /* JADX WARN: Code duplicated, block: B:15:0x001d  */
        @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.AbstractC11721a.a, p507d0.p513e0.p514p.p515d.p517m0.p550i.InterfaceC11734n.a
        public b mergeFrom(C11724d c11724d, C11725e c11725e) throws Throwable {
            C11680e c11680e = null;
            try {
                try {
                    C11680e partialFrom = C11680e.f23794k.parsePartialFrom(c11724d, c11725e);
                    if (partialFrom != null) {
                        mergeFrom(partialFrom);
                    }
                    return this;
                } catch (InvalidProtocolBufferException e) {
                    C11680e c11680e2 = (C11680e) e.getUnfinishedMessage();
                    try {
                        throw e;
                    } catch (Throwable th) {
                        th = th;
                        c11680e = c11680e2;
                        if (c11680e != null) {
                            mergeFrom(c11680e);
                        }
                        throw th;
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                if (c11680e != null) {
                    mergeFrom(c11680e);
                }
                throw th;
            }
        }
    }

    static {
        C11680e c11680e = new C11680e();
        f23793j = c11680e;
        c11680e.effect_ = Collections.emptyList();
    }

    public C11680e(AbstractC11727g.b bVar, C11666a c11666a) {
        super(bVar);
        this.memoizedIsInitialized = (byte) -1;
        this.memoizedSerializedSize = -1;
        this.unknownFields = bVar.getUnknownFields();
    }

    public static C11680e getDefaultInstance() {
        return f23793j;
    }

    public static b newBuilder(C11680e c11680e) {
        return newBuilder().mergeFrom(c11680e);
    }

    public C11681f getEffect(int i) {
        return this.effect_.get(i);
    }

    public int getEffectCount() {
        return this.effect_.size();
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.InterfaceC11734n
    public int getSerializedSize() {
        int i = this.memoizedSerializedSize;
        if (i != -1) {
            return i;
        }
        int iComputeMessageSize = 0;
        for (int i2 = 0; i2 < this.effect_.size(); i2++) {
            iComputeMessageSize += CodedOutputStream.computeMessageSize(1, this.effect_.get(i2));
        }
        int size = this.unknownFields.size() + iComputeMessageSize;
        this.memoizedSerializedSize = size;
        return size;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.InterfaceC11735o
    public final boolean isInitialized() {
        byte b2 = this.memoizedIsInitialized;
        if (b2 == 1) {
            return true;
        }
        if (b2 == 0) {
            return false;
        }
        for (int i = 0; i < getEffectCount(); i++) {
            if (!getEffect(i).isInitialized()) {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            }
        }
        this.memoizedIsInitialized = (byte) 1;
        return true;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.InterfaceC11734n
    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        getSerializedSize();
        for (int i = 0; i < this.effect_.size(); i++) {
            codedOutputStream.writeMessage(1, this.effect_.get(i));
        }
        codedOutputStream.writeRawBytes(this.unknownFields);
    }

    public static b newBuilder() {
        return new b();
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.InterfaceC11734n
    public b newBuilderForType() {
        return newBuilder();
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.InterfaceC11734n
    public b toBuilder() {
        return newBuilder(this);
    }

    public C11680e() {
        this.memoizedIsInitialized = (byte) -1;
        this.memoizedSerializedSize = -1;
        this.unknownFields = AbstractC11723c.f24100j;
    }

    public C11680e(C11724d c11724d, C11725e c11725e, C11666a c11666a) throws InvalidProtocolBufferException {
        this.memoizedIsInitialized = (byte) -1;
        this.memoizedSerializedSize = -1;
        this.effect_ = Collections.emptyList();
        AbstractC11723c.b bVarNewOutput = AbstractC11723c.newOutput();
        CodedOutputStream codedOutputStreamNewInstance = CodedOutputStream.newInstance(bVarNewOutput, 1);
        boolean z2 = false;
        boolean z3 = false;
        while (!z2) {
            try {
                try {
                    int tag = c11724d.readTag();
                    if (tag != 0) {
                        if (tag != 10) {
                            if (!c11724d.skipField(tag, codedOutputStreamNewInstance)) {
                            }
                        } else {
                            if (!(z3 & true)) {
                                this.effect_ = new ArrayList();
                                z3 |= true;
                            }
                            this.effect_.add((C11681f) c11724d.readMessage(C11681f.f23798k, c11725e));
                        }
                    }
                    z2 = true;
                } catch (InvalidProtocolBufferException e) {
                    throw e.setUnfinishedMessage(this);
                } catch (IOException e2) {
                    throw new InvalidProtocolBufferException(e2.getMessage()).setUnfinishedMessage(this);
                }
            } catch (Throwable th) {
                if (z3 & true) {
                    this.effect_ = Collections.unmodifiableList(this.effect_);
                }
                try {
                    codedOutputStreamNewInstance.flush();
                } catch (IOException unused) {
                } finally {
                    this.unknownFields = bVarNewOutput.toByteString();
                }
                throw th;
            }
        }
        if (z3 & true) {
            this.effect_ = Collections.unmodifiableList(this.effect_);
        }
        try {
            codedOutputStreamNewInstance.flush();
        } catch (IOException unused2) {
        } finally {
            this.unknownFields = bVarNewOutput.toByteString();
        }
    }
}
