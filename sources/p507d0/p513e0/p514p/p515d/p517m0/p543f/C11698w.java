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

/* JADX INFO: renamed from: d0.e0.p.d.m0.f.w */
/* JADX INFO: compiled from: ProtoBuf.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C11698w extends AbstractC11727g implements InterfaceC11735o {

    /* JADX INFO: renamed from: j */
    public static final C11698w f23987j;

    /* JADX INFO: renamed from: k */
    public static InterfaceC11736p<C11698w> f23988k = new a();
    private byte memoizedIsInitialized;
    private int memoizedSerializedSize;
    private List<C11697v> requirement_;
    private final AbstractC11723c unknownFields;

    /* JADX INFO: renamed from: d0.e0.p.d.m0.f.w$a */
    /* JADX INFO: compiled from: ProtoBuf.java */
    public static class a extends AbstractC11722b<C11698w> {
        @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.InterfaceC11736p
        public C11698w parsePartialFrom(C11724d c11724d, C11725e c11725e) throws InvalidProtocolBufferException {
            return new C11698w(c11724d, c11725e, null);
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.f.w$b */
    /* JADX INFO: compiled from: ProtoBuf.java */
    public static final class b extends AbstractC11727g.b<C11698w, b> implements InterfaceC11735o {

        /* JADX INFO: renamed from: k */
        public int f23989k;

        /* JADX INFO: renamed from: l */
        public List<C11697v> f23990l = Collections.emptyList();

        public C11698w buildPartial() {
            C11698w c11698w = new C11698w(this, null);
            if ((this.f23989k & 1) == 1) {
                this.f23990l = Collections.unmodifiableList(this.f23990l);
                this.f23989k &= -2;
            }
            c11698w.requirement_ = this.f23990l;
            return c11698w;
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.InterfaceC11734n.a
        public C11698w build() {
            C11698w c11698wBuildPartial = buildPartial();
            if (c11698wBuildPartial.isInitialized()) {
                return c11698wBuildPartial;
            }
            throw new UninitializedMessageException(c11698wBuildPartial);
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.AbstractC11727g.b
        /* JADX INFO: renamed from: clone */
        public b mo11465clone() {
            return new b().mergeFrom(buildPartial());
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.AbstractC11727g.b
        public b mergeFrom(C11698w c11698w) {
            if (c11698w == C11698w.getDefaultInstance()) {
                return this;
            }
            if (!c11698w.requirement_.isEmpty()) {
                if (this.f23990l.isEmpty()) {
                    this.f23990l = c11698w.requirement_;
                    this.f23989k &= -2;
                } else {
                    if ((this.f23989k & 1) != 1) {
                        this.f23990l = new ArrayList(this.f23990l);
                        this.f23989k |= 1;
                    }
                    this.f23990l.addAll(c11698w.requirement_);
                }
            }
            setUnknownFields(getUnknownFields().concat(c11698w.unknownFields));
            return this;
        }

        /* JADX WARN: Code duplicated, block: B:15:0x001d  */
        @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.AbstractC11721a.a, p507d0.p513e0.p514p.p515d.p517m0.p550i.InterfaceC11734n.a
        public b mergeFrom(C11724d c11724d, C11725e c11725e) throws Throwable {
            C11698w c11698w = null;
            try {
                try {
                    C11698w partialFrom = C11698w.f23988k.parsePartialFrom(c11724d, c11725e);
                    if (partialFrom != null) {
                        mergeFrom(partialFrom);
                    }
                    return this;
                } catch (InvalidProtocolBufferException e) {
                    C11698w c11698w2 = (C11698w) e.getUnfinishedMessage();
                    try {
                        throw e;
                    } catch (Throwable th) {
                        th = th;
                        c11698w = c11698w2;
                        if (c11698w != null) {
                            mergeFrom(c11698w);
                        }
                        throw th;
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                if (c11698w != null) {
                    mergeFrom(c11698w);
                }
                throw th;
            }
        }
    }

    static {
        C11698w c11698w = new C11698w();
        f23987j = c11698w;
        c11698w.requirement_ = Collections.emptyList();
    }

    public C11698w(AbstractC11727g.b bVar, C11666a c11666a) {
        super(bVar);
        this.memoizedIsInitialized = (byte) -1;
        this.memoizedSerializedSize = -1;
        this.unknownFields = bVar.getUnknownFields();
    }

    public static C11698w getDefaultInstance() {
        return f23987j;
    }

    public static b newBuilder(C11698w c11698w) {
        return newBuilder().mergeFrom(c11698w);
    }

    public int getRequirementCount() {
        return this.requirement_.size();
    }

    public List<C11697v> getRequirementList() {
        return this.requirement_;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.InterfaceC11734n
    public int getSerializedSize() {
        int i = this.memoizedSerializedSize;
        if (i != -1) {
            return i;
        }
        int iComputeMessageSize = 0;
        for (int i2 = 0; i2 < this.requirement_.size(); i2++) {
            iComputeMessageSize += CodedOutputStream.computeMessageSize(1, this.requirement_.get(i2));
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
        this.memoizedIsInitialized = (byte) 1;
        return true;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.InterfaceC11734n
    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        getSerializedSize();
        for (int i = 0; i < this.requirement_.size(); i++) {
            codedOutputStream.writeMessage(1, this.requirement_.get(i));
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

    public C11698w() {
        this.memoizedIsInitialized = (byte) -1;
        this.memoizedSerializedSize = -1;
        this.unknownFields = AbstractC11723c.f24100j;
    }

    public C11698w(C11724d c11724d, C11725e c11725e, C11666a c11666a) throws InvalidProtocolBufferException {
        this.memoizedIsInitialized = (byte) -1;
        this.memoizedSerializedSize = -1;
        this.requirement_ = Collections.emptyList();
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
                                this.requirement_ = new ArrayList();
                                z3 |= true;
                            }
                            this.requirement_.add((C11697v) c11724d.readMessage(C11697v.f23971k, c11725e));
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
                    this.requirement_ = Collections.unmodifiableList(this.requirement_);
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
            this.requirement_ = Collections.unmodifiableList(this.requirement_);
        }
        try {
            codedOutputStreamNewInstance.flush();
        } catch (IOException unused2) {
        } finally {
            this.unknownFields = bVarNewOutput.toByteString();
        }
    }
}
