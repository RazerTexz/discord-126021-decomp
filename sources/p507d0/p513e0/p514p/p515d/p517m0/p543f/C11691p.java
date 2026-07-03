package p507d0.p513e0.p514p.p515d.p517m0.p543f;

import java.io.IOException;
import kotlin.reflect.jvm.internal.impl.protobuf.CodedOutputStream;
import kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException;
import kotlin.reflect.jvm.internal.impl.protobuf.UninitializedMessageException;
import p507d0.p513e0.p514p.p515d.p517m0.p550i.AbstractC11722b;
import p507d0.p513e0.p514p.p515d.p517m0.p550i.AbstractC11723c;
import p507d0.p513e0.p514p.p515d.p517m0.p550i.AbstractC11727g;
import p507d0.p513e0.p514p.p515d.p517m0.p550i.C11724d;
import p507d0.p513e0.p514p.p515d.p517m0.p550i.C11725e;
import p507d0.p513e0.p514p.p515d.p517m0.p550i.C11731k;
import p507d0.p513e0.p514p.p515d.p517m0.p550i.InterfaceC11732l;
import p507d0.p513e0.p514p.p515d.p517m0.p550i.InterfaceC11735o;
import p507d0.p513e0.p514p.p515d.p517m0.p550i.InterfaceC11736p;
import p507d0.p513e0.p514p.p515d.p517m0.p550i.InterfaceC11737q;

/* JADX INFO: renamed from: d0.e0.p.d.m0.f.p */
/* JADX INFO: compiled from: ProtoBuf.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C11691p extends AbstractC11727g implements InterfaceC11735o {

    /* JADX INFO: renamed from: j */
    public static final C11691p f23899j;

    /* JADX INFO: renamed from: k */
    public static InterfaceC11736p<C11691p> f23900k = new a();
    private byte memoizedIsInitialized;
    private int memoizedSerializedSize;
    private InterfaceC11732l string_;
    private final AbstractC11723c unknownFields;

    /* JADX INFO: renamed from: d0.e0.p.d.m0.f.p$a */
    /* JADX INFO: compiled from: ProtoBuf.java */
    public static class a extends AbstractC11722b<C11691p> {
        @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.InterfaceC11736p
        public C11691p parsePartialFrom(C11724d c11724d, C11725e c11725e) throws InvalidProtocolBufferException {
            return new C11691p(c11724d, c11725e, null);
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.f.p$b */
    /* JADX INFO: compiled from: ProtoBuf.java */
    public static final class b extends AbstractC11727g.b<C11691p, b> implements InterfaceC11735o {

        /* JADX INFO: renamed from: k */
        public int f23901k;

        /* JADX INFO: renamed from: l */
        public InterfaceC11732l f23902l = C11731k.f24147j;

        public C11691p buildPartial() {
            C11691p c11691p = new C11691p(this, null);
            if ((this.f23901k & 1) == 1) {
                this.f23902l = this.f23902l.getUnmodifiableView();
                this.f23901k &= -2;
            }
            c11691p.string_ = this.f23902l;
            return c11691p;
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.InterfaceC11734n.a
        public C11691p build() {
            C11691p c11691pBuildPartial = buildPartial();
            if (c11691pBuildPartial.isInitialized()) {
                return c11691pBuildPartial;
            }
            throw new UninitializedMessageException(c11691pBuildPartial);
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.AbstractC11727g.b
        /* JADX INFO: renamed from: clone */
        public b mo11465clone() {
            return new b().mergeFrom(buildPartial());
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.AbstractC11727g.b
        public b mergeFrom(C11691p c11691p) {
            if (c11691p == C11691p.getDefaultInstance()) {
                return this;
            }
            if (!c11691p.string_.isEmpty()) {
                if (this.f23902l.isEmpty()) {
                    this.f23902l = c11691p.string_;
                    this.f23901k &= -2;
                } else {
                    if ((this.f23901k & 1) != 1) {
                        this.f23902l = new C11731k(this.f23902l);
                        this.f23901k |= 1;
                    }
                    this.f23902l.addAll(c11691p.string_);
                }
            }
            setUnknownFields(getUnknownFields().concat(c11691p.unknownFields));
            return this;
        }

        /* JADX WARN: Code duplicated, block: B:15:0x001d  */
        @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.AbstractC11721a.a, p507d0.p513e0.p514p.p515d.p517m0.p550i.InterfaceC11734n.a
        public b mergeFrom(C11724d c11724d, C11725e c11725e) throws Throwable {
            C11691p c11691p = null;
            try {
                try {
                    C11691p partialFrom = C11691p.f23900k.parsePartialFrom(c11724d, c11725e);
                    if (partialFrom != null) {
                        mergeFrom(partialFrom);
                    }
                    return this;
                } catch (InvalidProtocolBufferException e) {
                    C11691p c11691p2 = (C11691p) e.getUnfinishedMessage();
                    try {
                        throw e;
                    } catch (Throwable th) {
                        th = th;
                        c11691p = c11691p2;
                        if (c11691p != null) {
                            mergeFrom(c11691p);
                        }
                        throw th;
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                if (c11691p != null) {
                    mergeFrom(c11691p);
                }
                throw th;
            }
        }
    }

    static {
        C11691p c11691p = new C11691p();
        f23899j = c11691p;
        c11691p.string_ = C11731k.f24147j;
    }

    public C11691p(AbstractC11727g.b bVar, C11666a c11666a) {
        super(bVar);
        this.memoizedIsInitialized = (byte) -1;
        this.memoizedSerializedSize = -1;
        this.unknownFields = bVar.getUnknownFields();
    }

    public static C11691p getDefaultInstance() {
        return f23899j;
    }

    public static b newBuilder(C11691p c11691p) {
        return newBuilder().mergeFrom(c11691p);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.InterfaceC11734n
    public int getSerializedSize() {
        int i = this.memoizedSerializedSize;
        if (i != -1) {
            return i;
        }
        int iComputeBytesSizeNoTag = 0;
        for (int i2 = 0; i2 < this.string_.size(); i2++) {
            iComputeBytesSizeNoTag += CodedOutputStream.computeBytesSizeNoTag(this.string_.getByteString(i2));
        }
        int size = this.unknownFields.size() + (getStringList().size() * 1) + 0 + iComputeBytesSizeNoTag;
        this.memoizedSerializedSize = size;
        return size;
    }

    public String getString(int i) {
        return this.string_.get(i);
    }

    public InterfaceC11737q getStringList() {
        return this.string_;
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
        this.memoizedIsInitialized = (byte) 1;
        return true;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.InterfaceC11734n
    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        getSerializedSize();
        for (int i = 0; i < this.string_.size(); i++) {
            codedOutputStream.writeBytes(1, this.string_.getByteString(i));
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

    public C11691p() {
        this.memoizedIsInitialized = (byte) -1;
        this.memoizedSerializedSize = -1;
        this.unknownFields = AbstractC11723c.f24100j;
    }

    public C11691p(C11724d c11724d, C11725e c11725e, C11666a c11666a) throws InvalidProtocolBufferException {
        this.memoizedIsInitialized = (byte) -1;
        this.memoizedSerializedSize = -1;
        this.string_ = C11731k.f24147j;
        AbstractC11723c.b bVarNewOutput = AbstractC11723c.newOutput();
        CodedOutputStream codedOutputStreamNewInstance = CodedOutputStream.newInstance(bVarNewOutput, 1);
        boolean z2 = false;
        boolean z3 = false;
        while (!z2) {
            try {
                try {
                    try {
                        int tag = c11724d.readTag();
                        if (tag != 0) {
                            if (tag != 10) {
                                if (!c11724d.skipField(tag, codedOutputStreamNewInstance)) {
                                }
                            } else {
                                AbstractC11723c bytes = c11724d.readBytes();
                                if (!(z3 & true)) {
                                    this.string_ = new C11731k();
                                    z3 |= true;
                                }
                                this.string_.add(bytes);
                            }
                        }
                        z2 = true;
                    } catch (IOException e) {
                        throw new InvalidProtocolBufferException(e.getMessage()).setUnfinishedMessage(this);
                    }
                } catch (InvalidProtocolBufferException e2) {
                    throw e2.setUnfinishedMessage(this);
                }
            } catch (Throwable th) {
                if (z3 & true) {
                    this.string_ = this.string_.getUnmodifiableView();
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
            this.string_ = this.string_.getUnmodifiableView();
        }
        try {
            codedOutputStreamNewInstance.flush();
        } catch (IOException unused2) {
        } finally {
            this.unknownFields = bVarNewOutput.toByteString();
        }
    }
}
