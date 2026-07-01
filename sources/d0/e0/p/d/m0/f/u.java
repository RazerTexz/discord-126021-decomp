package d0.e0.p.d.m0.f;

import d0.e0.p.d.m0.f.q;
import d0.e0.p.d.m0.i.AbstractParser;
import d0.e0.p.d.m0.i.ByteString3;
import d0.e0.p.d.m0.i.CodedInputStream;
import d0.e0.p.d.m0.i.ExtensionRegistryLite;
import d0.e0.p.d.m0.i.GeneratedMessageLite;
import d0.e0.p.d.m0.i.MessageLiteOrBuilder;
import d0.e0.p.d.m0.i.Parser2;
import java.io.IOException;
import kotlin.reflect.jvm.internal.impl.protobuf.CodedOutputStream;
import kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException;
import kotlin.reflect.jvm.internal.impl.protobuf.UninitializedMessageException;

/* JADX INFO: compiled from: ProtoBuf.java */
/* JADX INFO: loaded from: classes3.dex */
public final class u extends GeneratedMessageLite.d<u> implements MessageLiteOrBuilder {
    public static final u j;
    public static Parser2<u> k = new a();
    private int bitField0_;
    private int flags_;
    private byte memoizedIsInitialized;
    private int memoizedSerializedSize;
    private int name_;
    private int typeId_;
    private q type_;
    private final ByteString3 unknownFields;
    private int varargElementTypeId_;
    private q varargElementType_;

    /* JADX INFO: compiled from: ProtoBuf.java */
    public static class a extends AbstractParser<u> {
        @Override // d0.e0.p.d.m0.i.Parser2
        public u parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return new u(codedInputStream, extensionRegistryLite, null);
        }
    }

    /* JADX INFO: compiled from: ProtoBuf.java */
    public static final class b extends GeneratedMessageLite.c<u, b> implements MessageLiteOrBuilder {
        public int m;
        public int n;
        public int o;
        public int q;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public int f3409s;
        public q p = q.getDefaultInstance();
        public q r = q.getDefaultInstance();

        public u buildPartial() {
            u uVar = new u(this, null);
            int i = this.m;
            int i2 = (i & 1) != 1 ? 0 : 1;
            uVar.flags_ = this.n;
            if ((i & 2) == 2) {
                i2 |= 2;
            }
            uVar.name_ = this.o;
            if ((i & 4) == 4) {
                i2 |= 4;
            }
            uVar.type_ = this.p;
            if ((i & 8) == 8) {
                i2 |= 8;
            }
            uVar.typeId_ = this.q;
            if ((i & 16) == 16) {
                i2 |= 16;
            }
            uVar.varargElementType_ = this.r;
            if ((i & 32) == 32) {
                i2 |= 32;
            }
            uVar.varargElementTypeId_ = this.f3409s;
            uVar.bitField0_ = i2;
            return uVar;
        }

        public b mergeType(q qVar) {
            if ((this.m & 4) != 4 || this.p == q.getDefaultInstance()) {
                this.p = qVar;
            } else {
                this.p = q.newBuilder(this.p).mergeFrom(qVar).buildPartial();
            }
            this.m |= 4;
            return this;
        }

        public b mergeVarargElementType(q qVar) {
            if ((this.m & 16) != 16 || this.r == q.getDefaultInstance()) {
                this.r = qVar;
            } else {
                this.r = q.newBuilder(this.r).mergeFrom(qVar).buildPartial();
            }
            this.m |= 16;
            return this;
        }

        public b setFlags(int i) {
            this.m |= 1;
            this.n = i;
            return this;
        }

        public b setName(int i) {
            this.m |= 2;
            this.o = i;
            return this;
        }

        public b setTypeId(int i) {
            this.m |= 8;
            this.q = i;
            return this;
        }

        public b setVarargElementTypeId(int i) {
            this.m |= 32;
            this.f3409s = i;
            return this;
        }

        @Override // d0.e0.p.d.m0.i.MessageLite.a
        public u build() {
            u uVarBuildPartial = buildPartial();
            if (uVarBuildPartial.isInitialized()) {
                return uVarBuildPartial;
            }
            throw new UninitializedMessageException(uVarBuildPartial);
        }

        @Override // d0.e0.p.d.m0.i.GeneratedMessageLite.b
        /* JADX INFO: renamed from: clone */
        public b mo88clone() {
            return new b().mergeFrom(buildPartial());
        }

        @Override // d0.e0.p.d.m0.i.GeneratedMessageLite.b
        public b mergeFrom(u uVar) {
            if (uVar == u.getDefaultInstance()) {
                return this;
            }
            if (uVar.hasFlags()) {
                setFlags(uVar.getFlags());
            }
            if (uVar.hasName()) {
                setName(uVar.getName());
            }
            if (uVar.hasType()) {
                mergeType(uVar.getType());
            }
            if (uVar.hasTypeId()) {
                setTypeId(uVar.getTypeId());
            }
            if (uVar.hasVarargElementType()) {
                mergeVarargElementType(uVar.getVarargElementType());
            }
            if (uVar.hasVarargElementTypeId()) {
                setVarargElementTypeId(uVar.getVarargElementTypeId());
            }
            b(uVar);
            setUnknownFields(getUnknownFields().concat(uVar.unknownFields));
            return this;
        }

        /* JADX WARN: Code duplicated, block: B:15:0x001d  */
        @Override // d0.e0.p.d.m0.i.AbstractMessageLite.a, d0.e0.p.d.m0.i.MessageLite.a
        public b mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws Throwable {
            u uVar = null;
            try {
                try {
                    u partialFrom = u.k.parsePartialFrom(codedInputStream, extensionRegistryLite);
                    if (partialFrom != null) {
                        mergeFrom(partialFrom);
                    }
                    return this;
                } catch (InvalidProtocolBufferException e) {
                    u uVar2 = (u) e.getUnfinishedMessage();
                    try {
                        throw e;
                    } catch (Throwable th) {
                        th = th;
                        uVar = uVar2;
                        if (uVar != null) {
                            mergeFrom(uVar);
                        }
                        throw th;
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                if (uVar != null) {
                    mergeFrom(uVar);
                }
                throw th;
            }
        }
    }

    static {
        u uVar = new u();
        j = uVar;
        uVar.p();
    }

    public u(GeneratedMessageLite.c cVar, d0.e0.p.d.m0.f.a aVar) {
        super(cVar);
        this.memoizedIsInitialized = (byte) -1;
        this.memoizedSerializedSize = -1;
        this.unknownFields = cVar.getUnknownFields();
    }

    public static u getDefaultInstance() {
        return j;
    }

    public static b newBuilder(u uVar) {
        return newBuilder().mergeFrom(uVar);
    }

    public int getFlags() {
        return this.flags_;
    }

    public int getName() {
        return this.name_;
    }

    @Override // d0.e0.p.d.m0.i.MessageLite
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

    @Override // d0.e0.p.d.m0.i.MessageLiteOrBuilder
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

    public final void p() {
        this.flags_ = 0;
        this.name_ = 0;
        this.type_ = q.getDefaultInstance();
        this.typeId_ = 0;
        this.varargElementType_ = q.getDefaultInstance();
        this.varargElementTypeId_ = 0;
    }

    @Override // d0.e0.p.d.m0.i.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        getSerializedSize();
        GeneratedMessageLite.d<MessageType>.a aVarE = e();
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
        aVarE.writeUntil(200, codedOutputStream);
        codedOutputStream.writeRawBytes(this.unknownFields);
    }

    public static b newBuilder() {
        return new b();
    }

    @Override // d0.e0.p.d.m0.i.MessageLiteOrBuilder
    public u getDefaultInstanceForType() {
        return j;
    }

    @Override // d0.e0.p.d.m0.i.MessageLite
    public b newBuilderForType() {
        return newBuilder();
    }

    @Override // d0.e0.p.d.m0.i.MessageLite
    public b toBuilder() {
        return newBuilder(this);
    }

    public u() {
        this.memoizedIsInitialized = (byte) -1;
        this.memoizedSerializedSize = -1;
        this.unknownFields = ByteString3.j;
    }

    public u(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, d0.e0.p.d.m0.f.a aVar) throws InvalidProtocolBufferException {
        q.c builder;
        this.memoizedIsInitialized = (byte) -1;
        this.memoizedSerializedSize = -1;
        p();
        ByteString3.b bVarNewOutput = ByteString3.newOutput();
        CodedOutputStream codedOutputStreamNewInstance = CodedOutputStream.newInstance(bVarNewOutput, 1);
        boolean z2 = false;
        while (!z2) {
            try {
                try {
                    try {
                        int tag = codedInputStream.readTag();
                        if (tag != 0) {
                            if (tag == 8) {
                                this.bitField0_ |= 1;
                                this.flags_ = codedInputStream.readInt32();
                            } else if (tag != 16) {
                                if (tag == 26) {
                                    builder = (this.bitField0_ & 4) == 4 ? this.type_.toBuilder() : null;
                                    q qVar = (q) codedInputStream.readMessage(q.k, extensionRegistryLite);
                                    this.type_ = qVar;
                                    if (builder != null) {
                                        builder.mergeFrom(qVar);
                                        this.type_ = builder.buildPartial();
                                    }
                                    this.bitField0_ |= 4;
                                } else if (tag == 34) {
                                    builder = (this.bitField0_ & 16) == 16 ? this.varargElementType_.toBuilder() : null;
                                    q qVar2 = (q) codedInputStream.readMessage(q.k, extensionRegistryLite);
                                    this.varargElementType_ = qVar2;
                                    if (builder != null) {
                                        builder.mergeFrom(qVar2);
                                        this.varargElementType_ = builder.buildPartial();
                                    }
                                    this.bitField0_ |= 16;
                                } else if (tag == 40) {
                                    this.bitField0_ |= 8;
                                    this.typeId_ = codedInputStream.readInt32();
                                } else if (tag != 48) {
                                    if (!f(codedInputStream, codedOutputStreamNewInstance, extensionRegistryLite, tag)) {
                                    }
                                } else {
                                    this.bitField0_ |= 32;
                                    this.varargElementTypeId_ = codedInputStream.readInt32();
                                }
                            } else {
                                this.bitField0_ |= 2;
                                this.name_ = codedInputStream.readInt32();
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
                    this.unknownFields = bVarNewOutput.toByteString();
                    throw th2;
                }
                this.unknownFields = bVarNewOutput.toByteString();
                d();
                throw th;
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
        d();
    }
}
