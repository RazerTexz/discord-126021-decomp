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
import p507d0.p513e0.p514p.p515d.p517m0.p550i.InterfaceC11735o;
import p507d0.p513e0.p514p.p515d.p517m0.p550i.InterfaceC11736p;

/* JADX INFO: renamed from: d0.e0.p.d.m0.f.g */
/* JADX INFO: compiled from: ProtoBuf.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C11682g extends AbstractC11727g.d<C11682g> implements InterfaceC11735o {

    /* JADX INFO: renamed from: j */
    public static final C11682g f23812j;

    /* JADX INFO: renamed from: k */
    public static InterfaceC11736p<C11682g> f23813k = new a();
    private int bitField0_;
    private byte memoizedIsInitialized;
    private int memoizedSerializedSize;
    private int name_;
    private final AbstractC11723c unknownFields;

    /* JADX INFO: renamed from: d0.e0.p.d.m0.f.g$a */
    /* JADX INFO: compiled from: ProtoBuf.java */
    public static class a extends AbstractC11722b<C11682g> {
        @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.InterfaceC11736p
        public C11682g parsePartialFrom(C11724d c11724d, C11725e c11725e) throws InvalidProtocolBufferException {
            return new C11682g(c11724d, c11725e, null);
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.f.g$b */
    /* JADX INFO: compiled from: ProtoBuf.java */
    public static final class b extends AbstractC11727g.c<C11682g, b> implements InterfaceC11735o {

        /* JADX INFO: renamed from: m */
        public int f23814m;

        /* JADX INFO: renamed from: n */
        public int f23815n;

        public C11682g buildPartial() {
            C11682g c11682g = new C11682g(this, null);
            int i = (this.f23814m & 1) != 1 ? 0 : 1;
            c11682g.name_ = this.f23815n;
            c11682g.bitField0_ = i;
            return c11682g;
        }

        public b setName(int i) {
            this.f23814m |= 1;
            this.f23815n = i;
            return this;
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.InterfaceC11734n.a
        public C11682g build() {
            C11682g c11682gBuildPartial = buildPartial();
            if (c11682gBuildPartial.isInitialized()) {
                return c11682gBuildPartial;
            }
            throw new UninitializedMessageException(c11682gBuildPartial);
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.AbstractC11727g.b
        /* JADX INFO: renamed from: clone */
        public b mo11465clone() {
            return new b().mergeFrom(buildPartial());
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.AbstractC11727g.b
        public b mergeFrom(C11682g c11682g) {
            if (c11682g == C11682g.getDefaultInstance()) {
                return this;
            }
            if (c11682g.hasName()) {
                setName(c11682g.getName());
            }
            m9846b(c11682g);
            setUnknownFields(getUnknownFields().concat(c11682g.unknownFields));
            return this;
        }

        /* JADX WARN: Code duplicated, block: B:15:0x001d  */
        @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.AbstractC11721a.a, p507d0.p513e0.p514p.p515d.p517m0.p550i.InterfaceC11734n.a
        public b mergeFrom(C11724d c11724d, C11725e c11725e) throws Throwable {
            C11682g c11682g = null;
            try {
                try {
                    C11682g partialFrom = C11682g.f23813k.parsePartialFrom(c11724d, c11725e);
                    if (partialFrom != null) {
                        mergeFrom(partialFrom);
                    }
                    return this;
                } catch (InvalidProtocolBufferException e) {
                    C11682g c11682g2 = (C11682g) e.getUnfinishedMessage();
                    try {
                        throw e;
                    } catch (Throwable th) {
                        th = th;
                        c11682g = c11682g2;
                        if (c11682g != null) {
                            mergeFrom(c11682g);
                        }
                        throw th;
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                if (c11682g != null) {
                    mergeFrom(c11682g);
                }
                throw th;
            }
        }
    }

    static {
        C11682g c11682g = new C11682g();
        f23812j = c11682g;
        c11682g.name_ = 0;
    }

    public C11682g(AbstractC11727g.c cVar, C11666a c11666a) {
        super(cVar);
        this.memoizedIsInitialized = (byte) -1;
        this.memoizedSerializedSize = -1;
        this.unknownFields = cVar.getUnknownFields();
    }

    public static C11682g getDefaultInstance() {
        return f23812j;
    }

    public static b newBuilder(C11682g c11682g) {
        return newBuilder().mergeFrom(c11682g);
    }

    public int getName() {
        return this.name_;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.InterfaceC11734n
    public int getSerializedSize() {
        int i = this.memoizedSerializedSize;
        if (i != -1) {
            return i;
        }
        int size = this.unknownFields.size() + m9849c() + ((this.bitField0_ & 1) == 1 ? 0 + CodedOutputStream.computeInt32Size(1, this.name_) : 0);
        this.memoizedSerializedSize = size;
        return size;
    }

    public boolean hasName() {
        return (this.bitField0_ & 1) == 1;
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
        if (m9848b()) {
            this.memoizedIsInitialized = (byte) 1;
            return true;
        }
        this.memoizedIsInitialized = (byte) 0;
        return false;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.InterfaceC11734n
    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        getSerializedSize();
        AbstractC11727g.d<MessageType>.a aVarM9851e = m9851e();
        if ((this.bitField0_ & 1) == 1) {
            codedOutputStream.writeInt32(1, this.name_);
        }
        aVarM9851e.writeUntil(200, codedOutputStream);
        codedOutputStream.writeRawBytes(this.unknownFields);
    }

    public static b newBuilder() {
        return new b();
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.InterfaceC11735o
    public C11682g getDefaultInstanceForType() {
        return f23812j;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.InterfaceC11734n
    public b newBuilderForType() {
        return newBuilder();
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.InterfaceC11734n
    public b toBuilder() {
        return newBuilder(this);
    }

    public C11682g() {
        this.memoizedIsInitialized = (byte) -1;
        this.memoizedSerializedSize = -1;
        this.unknownFields = AbstractC11723c.f24100j;
    }

    public C11682g(C11724d c11724d, C11725e c11725e, C11666a c11666a) throws InvalidProtocolBufferException {
        this.memoizedIsInitialized = (byte) -1;
        this.memoizedSerializedSize = -1;
        boolean z2 = false;
        this.name_ = 0;
        AbstractC11723c.b bVarNewOutput = AbstractC11723c.newOutput();
        CodedOutputStream codedOutputStreamNewInstance = CodedOutputStream.newInstance(bVarNewOutput, 1);
        while (!z2) {
            try {
                try {
                    int tag = c11724d.readTag();
                    if (tag != 0) {
                        if (tag != 8) {
                            if (!m9852f(c11724d, codedOutputStreamNewInstance, c11725e, tag)) {
                            }
                        } else {
                            this.bitField0_ |= 1;
                            this.name_ = c11724d.readInt32();
                        }
                    }
                    z2 = true;
                } catch (Throwable th) {
                    try {
                        codedOutputStreamNewInstance.flush();
                    } catch (IOException unused) {
                    } catch (Throwable th2) {
                        this.unknownFields = bVarNewOutput.toByteString();
                        throw th2;
                    }
                    this.unknownFields = bVarNewOutput.toByteString();
                    m9850d();
                    throw th;
                }
            } catch (InvalidProtocolBufferException e) {
                throw e.setUnfinishedMessage(this);
            } catch (IOException e2) {
                throw new InvalidProtocolBufferException(e2.getMessage()).setUnfinishedMessage(this);
            }
        }
        try {
            codedOutputStreamNewInstance.flush();
        } catch (IOException unused2) {
        } catch (Throwable th3) {
            this.unknownFields = bVarNewOutput.toByteString();
            throw th3;
        }
        this.unknownFields = bVarNewOutput.toByteString();
        m9850d();
    }
}
