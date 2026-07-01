package d0.e0.p.d.m0.f;

import d0.e0.p.d.m0.i.g$c;
import d0.e0.p.d.m0.i.g$d;
import d0.e0.p.d.m0.i.g$d$a;
import java.io.IOException;
import kotlin.reflect.jvm.internal.impl.protobuf.CodedOutputStream;
import kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException;

/* JADX INFO: compiled from: ProtoBuf.java */
/* JADX INFO: loaded from: classes3.dex */
public final class u extends g$d<u> implements d0.e0.p.d.m0.i.o {
    public static final u j;
    public static d0.e0.p.d.m0.i.p<u> k = new u$a();
    private int bitField0_;
    private int flags_;
    private byte memoizedIsInitialized;
    private int memoizedSerializedSize;
    private int name_;
    private int typeId_;
    private q type_;
    private final d0.e0.p.d.m0.i.c unknownFields;
    private int varargElementTypeId_;
    private q varargElementType_;

    static {
        u uVar = new u();
        j = uVar;
        uVar.p();
    }

    public u(g$c g_c, a aVar) {
        super(g_c);
        this.memoizedIsInitialized = (byte) -1;
        this.memoizedSerializedSize = -1;
        this.unknownFields = g_c.getUnknownFields();
    }

    public static u getDefaultInstance() {
        return j;
    }

    public static /* synthetic */ int h(u uVar, int i) {
        uVar.flags_ = i;
        return i;
    }

    public static /* synthetic */ int i(u uVar, int i) {
        uVar.name_ = i;
        return i;
    }

    public static /* synthetic */ q j(u uVar, q qVar) {
        uVar.type_ = qVar;
        return qVar;
    }

    public static /* synthetic */ int k(u uVar, int i) {
        uVar.typeId_ = i;
        return i;
    }

    public static /* synthetic */ q l(u uVar, q qVar) {
        uVar.varargElementType_ = qVar;
        return qVar;
    }

    public static /* synthetic */ int m(u uVar, int i) {
        uVar.varargElementTypeId_ = i;
        return i;
    }

    public static /* synthetic */ int n(u uVar, int i) {
        uVar.bitField0_ = i;
        return i;
    }

    public static u$b newBuilder(u uVar) {
        return newBuilder().mergeFrom(uVar);
    }

    public static /* synthetic */ d0.e0.p.d.m0.i.c o(u uVar) {
        return uVar.unknownFields;
    }

    @Override // d0.e0.p.d.m0.i.o
    public /* bridge */ /* synthetic */ d0.e0.p.d.m0.i.n getDefaultInstanceForType() {
        return getDefaultInstanceForType();
    }

    public int getFlags() {
        return this.flags_;
    }

    public int getName() {
        return this.name_;
    }

    @Override // d0.e0.p.d.m0.i.n
    public int getSerializedSize() {
        int i = this.memoizedSerializedSize;
        if (i != -1) {
            return i;
        }
        int iComputeInt32Size = (this.bitField0_ & 1) == 1 ? 0 + CodedOutputStream.computeInt32Size(1, this.flags_) : 0;
        if ((this.bitField0_ & 2) == 2) {
            iComputeInt32Size += CodedOutputStream.computeInt32Size(2, this.name_);
        }
        if ((this.bitField0_ & 4) == 4) {
            iComputeInt32Size += CodedOutputStream.computeMessageSize(3, this.type_);
        }
        if ((this.bitField0_ & 16) == 16) {
            iComputeInt32Size += CodedOutputStream.computeMessageSize(4, this.varargElementType_);
        }
        if ((this.bitField0_ & 8) == 8) {
            iComputeInt32Size += CodedOutputStream.computeInt32Size(5, this.typeId_);
        }
        if ((this.bitField0_ & 32) == 32) {
            iComputeInt32Size += CodedOutputStream.computeInt32Size(6, this.varargElementTypeId_);
        }
        int size = this.unknownFields.size() + c() + iComputeInt32Size;
        this.memoizedSerializedSize = size;
        return size;
    }

    public q getType() {
        return this.type_;
    }

    public int getTypeId() {
        return this.typeId_;
    }

    public q getVarargElementType() {
        return this.varargElementType_;
    }

    public int getVarargElementTypeId() {
        return this.varargElementTypeId_;
    }

    public boolean hasFlags() {
        return (this.bitField0_ & 1) == 1;
    }

    public boolean hasName() {
        return (this.bitField0_ & 2) == 2;
    }

    public boolean hasType() {
        return (this.bitField0_ & 4) == 4;
    }

    public boolean hasTypeId() {
        return (this.bitField0_ & 8) == 8;
    }

    public boolean hasVarargElementType() {
        return (this.bitField0_ & 16) == 16;
    }

    public boolean hasVarargElementTypeId() {
        return (this.bitField0_ & 32) == 32;
    }

    @Override // d0.e0.p.d.m0.i.o
    public final boolean isInitialized() {
        byte b2 = this.memoizedIsInitialized;
        if (b2 == 1) {
            return true;
        }
        if (b2 == 0) {
            return false;
        }
        if (!hasName()) {
            this.memoizedIsInitialized = (byte) 0;
            return false;
        }
        if (hasType() && !getType().isInitialized()) {
            this.memoizedIsInitialized = (byte) 0;
            return false;
        }
        if (hasVarargElementType() && !getVarargElementType().isInitialized()) {
            this.memoizedIsInitialized = (byte) 0;
            return false;
        }
        if (b()) {
            this.memoizedIsInitialized = (byte) 1;
            return true;
        }
        this.memoizedIsInitialized = (byte) 0;
        return false;
    }

    @Override // d0.e0.p.d.m0.i.n
    public /* bridge */ /* synthetic */ d0.e0.p.d.m0.i.n$a newBuilderForType() {
        return newBuilderForType();
    }

    public final void p() {
        this.flags_ = 0;
        this.name_ = 0;
        this.type_ = q.getDefaultInstance();
        this.typeId_ = 0;
        this.varargElementType_ = q.getDefaultInstance();
        this.varargElementTypeId_ = 0;
    }

    @Override // d0.e0.p.d.m0.i.n
    public /* bridge */ /* synthetic */ d0.e0.p.d.m0.i.n$a toBuilder() {
        return toBuilder();
    }

    @Override // d0.e0.p.d.m0.i.n
    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        getSerializedSize();
        g$d$a g_d_aE = e();
        if ((this.bitField0_ & 1) == 1) {
            codedOutputStream.writeInt32(1, this.flags_);
        }
        if ((this.bitField0_ & 2) == 2) {
            codedOutputStream.writeInt32(2, this.name_);
        }
        if ((this.bitField0_ & 4) == 4) {
            codedOutputStream.writeMessage(3, this.type_);
        }
        if ((this.bitField0_ & 16) == 16) {
            codedOutputStream.writeMessage(4, this.varargElementType_);
        }
        if ((this.bitField0_ & 8) == 8) {
            codedOutputStream.writeInt32(5, this.typeId_);
        }
        if ((this.bitField0_ & 32) == 32) {
            codedOutputStream.writeInt32(6, this.varargElementTypeId_);
        }
        g_d_aE.writeUntil(200, codedOutputStream);
        codedOutputStream.writeRawBytes(this.unknownFields);
    }

    public static u$b newBuilder() {
        return new u$b();
    }

    @Override // d0.e0.p.d.m0.i.o
    public u getDefaultInstanceForType() {
        return j;
    }

    @Override // d0.e0.p.d.m0.i.n
    public u$b newBuilderForType() {
        return newBuilder();
    }

    @Override // d0.e0.p.d.m0.i.n
    public u$b toBuilder() {
        return newBuilder(this);
    }

    public u() {
        this.memoizedIsInitialized = (byte) -1;
        this.memoizedSerializedSize = -1;
        this.unknownFields = d0.e0.p.d.m0.i.c.j;
    }

    public u(d0.e0.p.d.m0.i.d dVar, d0.e0.p.d.m0.i.e eVar, a aVar) throws InvalidProtocolBufferException {
        q$c builder;
        this.memoizedIsInitialized = (byte) -1;
        this.memoizedSerializedSize = -1;
        p();
        d0.e0.p.d.m0.i.c$b c_bNewOutput = d0.e0.p.d.m0.i.c.newOutput();
        CodedOutputStream codedOutputStreamNewInstance = CodedOutputStream.newInstance(c_bNewOutput, 1);
        boolean z2 = false;
        while (!z2) {
            try {
                try {
                    try {
                        int tag = dVar.readTag();
                        if (tag != 0) {
                            if (tag == 8) {
                                this.bitField0_ |= 1;
                                this.flags_ = dVar.readInt32();
                            } else if (tag != 16) {
                                if (tag == 26) {
                                    builder = (this.bitField0_ & 4) == 4 ? this.type_.toBuilder() : null;
                                    q qVar = (q) dVar.readMessage(q.k, eVar);
                                    this.type_ = qVar;
                                    if (builder != null) {
                                        builder.mergeFrom(qVar);
                                        this.type_ = builder.buildPartial();
                                    }
                                    this.bitField0_ |= 4;
                                } else if (tag == 34) {
                                    builder = (this.bitField0_ & 16) == 16 ? this.varargElementType_.toBuilder() : null;
                                    q qVar2 = (q) dVar.readMessage(q.k, eVar);
                                    this.varargElementType_ = qVar2;
                                    if (builder != null) {
                                        builder.mergeFrom(qVar2);
                                        this.varargElementType_ = builder.buildPartial();
                                    }
                                    this.bitField0_ |= 16;
                                } else if (tag == 40) {
                                    this.bitField0_ |= 8;
                                    this.typeId_ = dVar.readInt32();
                                } else if (tag != 48) {
                                    if (!f(dVar, codedOutputStreamNewInstance, eVar, tag)) {
                                    }
                                } else {
                                    this.bitField0_ |= 32;
                                    this.varargElementTypeId_ = dVar.readInt32();
                                }
                            } else {
                                this.bitField0_ |= 2;
                                this.name_ = dVar.readInt32();
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
                try {
                    codedOutputStreamNewInstance.flush();
                } catch (IOException unused) {
                } catch (Throwable th2) {
                    this.unknownFields = c_bNewOutput.toByteString();
                    throw th2;
                }
                this.unknownFields = c_bNewOutput.toByteString();
                d();
                throw th;
            }
        }
        try {
            codedOutputStreamNewInstance.flush();
        } catch (IOException unused2) {
        } catch (Throwable th3) {
            this.unknownFields = c_bNewOutput.toByteString();
            throw th3;
        }
        this.unknownFields = c_bNewOutput.toByteString();
        d();
    }
}
