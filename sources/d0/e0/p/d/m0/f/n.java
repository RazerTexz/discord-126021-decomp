package d0.e0.p.d.m0.f;

import d0.e0.p.d.m0.f.q;
import d0.e0.p.d.m0.f.u;
import d0.e0.p.d.m0.i.AbstractParser;
import d0.e0.p.d.m0.i.ByteString3;
import d0.e0.p.d.m0.i.CodedInputStream;
import d0.e0.p.d.m0.i.ExtensionRegistryLite;
import d0.e0.p.d.m0.i.GeneratedMessageLite;
import d0.e0.p.d.m0.i.MessageLiteOrBuilder;
import d0.e0.p.d.m0.i.Parser2;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.protobuf.CodedOutputStream;
import kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException;
import kotlin.reflect.jvm.internal.impl.protobuf.UninitializedMessageException;

/* JADX INFO: compiled from: ProtoBuf.java */
/* JADX INFO: loaded from: classes3.dex */
public final class n extends GeneratedMessageLite.d<n> implements MessageLiteOrBuilder {
    public static final n j;
    public static Parser2<n> k = new a();
    private int bitField0_;
    private int flags_;
    private int getterFlags_;
    private byte memoizedIsInitialized;
    private int memoizedSerializedSize;
    private int name_;
    private int oldFlags_;
    private int receiverTypeId_;
    private q receiverType_;
    private int returnTypeId_;
    private q returnType_;
    private int setterFlags_;
    private u setterValueParameter_;
    private List<s> typeParameter_;
    private final ByteString3 unknownFields;
    private List<Integer> versionRequirement_;

    /* JADX INFO: compiled from: ProtoBuf.java */
    public static class a extends AbstractParser<n> {
        @Override // d0.e0.p.d.m0.i.Parser2
        public n parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return new n(codedInputStream, extensionRegistryLite, null);
        }
    }

    /* JADX INFO: compiled from: ProtoBuf.java */
    public static final class b extends GeneratedMessageLite.c<n, b> implements MessageLiteOrBuilder {
        public int m;
        public int p;
        public int r;
        public int u;
        public int w;

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        public int f3401x;
        public int n = 518;
        public int o = 2054;
        public q q = q.getDefaultInstance();

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public List<s> f3400s = Collections.emptyList();
        public q t = q.getDefaultInstance();
        public u v = u.getDefaultInstance();

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        public List<Integer> f3402y = Collections.emptyList();

        public n buildPartial() {
            n nVar = new n(this, null);
            int i = this.m;
            int i2 = (i & 1) != 1 ? 0 : 1;
            nVar.flags_ = this.n;
            if ((i & 2) == 2) {
                i2 |= 2;
            }
            nVar.oldFlags_ = this.o;
            if ((i & 4) == 4) {
                i2 |= 4;
            }
            nVar.name_ = this.p;
            if ((i & 8) == 8) {
                i2 |= 8;
            }
            nVar.returnType_ = this.q;
            if ((i & 16) == 16) {
                i2 |= 16;
            }
            nVar.returnTypeId_ = this.r;
            if ((this.m & 32) == 32) {
                this.f3400s = Collections.unmodifiableList(this.f3400s);
                this.m &= -33;
            }
            nVar.typeParameter_ = this.f3400s;
            if ((i & 64) == 64) {
                i2 |= 32;
            }
            nVar.receiverType_ = this.t;
            if ((i & 128) == 128) {
                i2 |= 64;
            }
            nVar.receiverTypeId_ = this.u;
            if ((i & 256) == 256) {
                i2 |= 128;
            }
            nVar.setterValueParameter_ = this.v;
            if ((i & 512) == 512) {
                i2 |= 256;
            }
            nVar.getterFlags_ = this.w;
            if ((i & 1024) == 1024) {
                i2 |= 512;
            }
            nVar.setterFlags_ = this.f3401x;
            if ((this.m & 2048) == 2048) {
                this.f3402y = Collections.unmodifiableList(this.f3402y);
                this.m &= -2049;
            }
            nVar.versionRequirement_ = this.f3402y;
            nVar.bitField0_ = i2;
            return nVar;
        }

        public b mergeReceiverType(q qVar) {
            if ((this.m & 64) != 64 || this.t == q.getDefaultInstance()) {
                this.t = qVar;
            } else {
                this.t = q.newBuilder(this.t).mergeFrom(qVar).buildPartial();
            }
            this.m |= 64;
            return this;
        }

        public b mergeReturnType(q qVar) {
            if ((this.m & 8) != 8 || this.q == q.getDefaultInstance()) {
                this.q = qVar;
            } else {
                this.q = q.newBuilder(this.q).mergeFrom(qVar).buildPartial();
            }
            this.m |= 8;
            return this;
        }

        public b mergeSetterValueParameter(u uVar) {
            if ((this.m & 256) != 256 || this.v == u.getDefaultInstance()) {
                this.v = uVar;
            } else {
                this.v = u.newBuilder(this.v).mergeFrom(uVar).buildPartial();
            }
            this.m |= 256;
            return this;
        }

        public b setFlags(int i) {
            this.m |= 1;
            this.n = i;
            return this;
        }

        public b setGetterFlags(int i) {
            this.m |= 512;
            this.w = i;
            return this;
        }

        public b setName(int i) {
            this.m |= 4;
            this.p = i;
            return this;
        }

        public b setOldFlags(int i) {
            this.m |= 2;
            this.o = i;
            return this;
        }

        public b setReceiverTypeId(int i) {
            this.m |= 128;
            this.u = i;
            return this;
        }

        public b setReturnTypeId(int i) {
            this.m |= 16;
            this.r = i;
            return this;
        }

        public b setSetterFlags(int i) {
            this.m |= 1024;
            this.f3401x = i;
            return this;
        }

        @Override // d0.e0.p.d.m0.i.MessageLite.a
        public n build() {
            n nVarBuildPartial = buildPartial();
            if (nVarBuildPartial.isInitialized()) {
                return nVarBuildPartial;
            }
            throw new UninitializedMessageException(nVarBuildPartial);
        }

        @Override // d0.e0.p.d.m0.i.GeneratedMessageLite.b
        /* JADX INFO: renamed from: clone */
        public b mo88clone() {
            return new b().mergeFrom(buildPartial());
        }

        @Override // d0.e0.p.d.m0.i.GeneratedMessageLite.b
        public b mergeFrom(n nVar) {
            if (nVar == n.getDefaultInstance()) {
                return this;
            }
            if (nVar.hasFlags()) {
                setFlags(nVar.getFlags());
            }
            if (nVar.hasOldFlags()) {
                setOldFlags(nVar.getOldFlags());
            }
            if (nVar.hasName()) {
                setName(nVar.getName());
            }
            if (nVar.hasReturnType()) {
                mergeReturnType(nVar.getReturnType());
            }
            if (nVar.hasReturnTypeId()) {
                setReturnTypeId(nVar.getReturnTypeId());
            }
            if (!nVar.typeParameter_.isEmpty()) {
                if (this.f3400s.isEmpty()) {
                    this.f3400s = nVar.typeParameter_;
                    this.m &= -33;
                } else {
                    if ((this.m & 32) != 32) {
                        this.f3400s = new ArrayList(this.f3400s);
                        this.m |= 32;
                    }
                    this.f3400s.addAll(nVar.typeParameter_);
                }
            }
            if (nVar.hasReceiverType()) {
                mergeReceiverType(nVar.getReceiverType());
            }
            if (nVar.hasReceiverTypeId()) {
                setReceiverTypeId(nVar.getReceiverTypeId());
            }
            if (nVar.hasSetterValueParameter()) {
                mergeSetterValueParameter(nVar.getSetterValueParameter());
            }
            if (nVar.hasGetterFlags()) {
                setGetterFlags(nVar.getGetterFlags());
            }
            if (nVar.hasSetterFlags()) {
                setSetterFlags(nVar.getSetterFlags());
            }
            if (!nVar.versionRequirement_.isEmpty()) {
                if (this.f3402y.isEmpty()) {
                    this.f3402y = nVar.versionRequirement_;
                    this.m &= -2049;
                } else {
                    if ((this.m & 2048) != 2048) {
                        this.f3402y = new ArrayList(this.f3402y);
                        this.m |= 2048;
                    }
                    this.f3402y.addAll(nVar.versionRequirement_);
                }
            }
            b(nVar);
            setUnknownFields(getUnknownFields().concat(nVar.unknownFields));
            return this;
        }

        /* JADX WARN: Code duplicated, block: B:15:0x001d  */
        @Override // d0.e0.p.d.m0.i.AbstractMessageLite.a, d0.e0.p.d.m0.i.MessageLite.a
        public b mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws Throwable {
            n nVar = null;
            try {
                try {
                    n partialFrom = n.k.parsePartialFrom(codedInputStream, extensionRegistryLite);
                    if (partialFrom != null) {
                        mergeFrom(partialFrom);
                    }
                    return this;
                } catch (InvalidProtocolBufferException e) {
                    n nVar2 = (n) e.getUnfinishedMessage();
                    try {
                        throw e;
                    } catch (Throwable th) {
                        th = th;
                        nVar = nVar2;
                        if (nVar != null) {
                            mergeFrom(nVar);
                        }
                        throw th;
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                if (nVar != null) {
                    mergeFrom(nVar);
                }
                throw th;
            }
        }
    }

    static {
        n nVar = new n();
        j = nVar;
        nVar.x();
    }

    public n(GeneratedMessageLite.c cVar, d0.e0.p.d.m0.f.a aVar) {
        super(cVar);
        this.memoizedIsInitialized = (byte) -1;
        this.memoizedSerializedSize = -1;
        this.unknownFields = cVar.getUnknownFields();
    }

    public static n getDefaultInstance() {
        return j;
    }

    public static b newBuilder(n nVar) {
        return newBuilder().mergeFrom(nVar);
    }

    public int getFlags() {
        return this.flags_;
    }

    public int getGetterFlags() {
        return this.getterFlags_;
    }

    public int getName() {
        return this.name_;
    }

    public int getOldFlags() {
        return this.oldFlags_;
    }

    public q getReceiverType() {
        return this.receiverType_;
    }

    public int getReceiverTypeId() {
        return this.receiverTypeId_;
    }

    public q getReturnType() {
        return this.returnType_;
    }

    public int getReturnTypeId() {
        return this.returnTypeId_;
    }

    @Override // d0.e0.p.d.m0.i.MessageLite
    public int getSerializedSize() {
        int i = this.memoizedSerializedSize;
        if (i != -1) {
            return i;
        }
        int iComputeInt32Size = (this.bitField0_ & 2) == 2 ? CodedOutputStream.computeInt32Size(1, this.oldFlags_) + 0 : 0;
        if ((this.bitField0_ & 4) == 4) {
            iComputeInt32Size += CodedOutputStream.computeInt32Size(2, this.name_);
        }
        if ((this.bitField0_ & 8) == 8) {
            iComputeInt32Size += CodedOutputStream.computeMessageSize(3, this.returnType_);
        }
        for (int i2 = 0; i2 < this.typeParameter_.size(); i2++) {
            iComputeInt32Size += CodedOutputStream.computeMessageSize(4, this.typeParameter_.get(i2));
        }
        if ((this.bitField0_ & 32) == 32) {
            iComputeInt32Size += CodedOutputStream.computeMessageSize(5, this.receiverType_);
        }
        if ((this.bitField0_ & 128) == 128) {
            iComputeInt32Size += CodedOutputStream.computeMessageSize(6, this.setterValueParameter_);
        }
        if ((this.bitField0_ & 256) == 256) {
            iComputeInt32Size += CodedOutputStream.computeInt32Size(7, this.getterFlags_);
        }
        if ((this.bitField0_ & 512) == 512) {
            iComputeInt32Size += CodedOutputStream.computeInt32Size(8, this.setterFlags_);
        }
        if ((this.bitField0_ & 16) == 16) {
            iComputeInt32Size += CodedOutputStream.computeInt32Size(9, this.returnTypeId_);
        }
        if ((this.bitField0_ & 64) == 64) {
            iComputeInt32Size += CodedOutputStream.computeInt32Size(10, this.receiverTypeId_);
        }
        if ((this.bitField0_ & 1) == 1) {
            iComputeInt32Size += CodedOutputStream.computeInt32Size(11, this.flags_);
        }
        int iComputeInt32SizeNoTag = 0;
        for (int i3 = 0; i3 < this.versionRequirement_.size(); i3++) {
            iComputeInt32SizeNoTag += CodedOutputStream.computeInt32SizeNoTag(this.versionRequirement_.get(i3).intValue());
        }
        int size = this.unknownFields.size() + c() + (getVersionRequirementList().size() * 2) + iComputeInt32Size + iComputeInt32SizeNoTag;
        this.memoizedSerializedSize = size;
        return size;
    }

    public int getSetterFlags() {
        return this.setterFlags_;
    }

    public u getSetterValueParameter() {
        return this.setterValueParameter_;
    }

    public s getTypeParameter(int i) {
        return this.typeParameter_.get(i);
    }

    public int getTypeParameterCount() {
        return this.typeParameter_.size();
    }

    public List<s> getTypeParameterList() {
        return this.typeParameter_;
    }

    public List<Integer> getVersionRequirementList() {
        return this.versionRequirement_;
    }

    public boolean hasFlags() {
        return (this.bitField0_ & 1) == 1;
    }

    public boolean hasGetterFlags() {
        return (this.bitField0_ & 256) == 256;
    }

    public boolean hasName() {
        return (this.bitField0_ & 4) == 4;
    }

    public boolean hasOldFlags() {
        return (this.bitField0_ & 2) == 2;
    }

    public boolean hasReceiverType() {
        return (this.bitField0_ & 32) == 32;
    }

    public boolean hasReceiverTypeId() {
        return (this.bitField0_ & 64) == 64;
    }

    public boolean hasReturnType() {
        return (this.bitField0_ & 8) == 8;
    }

    public boolean hasReturnTypeId() {
        return (this.bitField0_ & 16) == 16;
    }

    public boolean hasSetterFlags() {
        return (this.bitField0_ & 512) == 512;
    }

    public boolean hasSetterValueParameter() {
        return (this.bitField0_ & 128) == 128;
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
        if (hasReturnType() && !getReturnType().isInitialized()) {
            this.memoizedIsInitialized = (byte) 0;
            return false;
        }
        for (int i = 0; i < getTypeParameterCount(); i++) {
            if (!getTypeParameter(i).isInitialized()) {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            }
        }
        if (hasReceiverType() && !getReceiverType().isInitialized()) {
            this.memoizedIsInitialized = (byte) 0;
            return false;
        }
        if (hasSetterValueParameter() && !getSetterValueParameter().isInitialized()) {
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

    @Override // d0.e0.p.d.m0.i.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        getSerializedSize();
        GeneratedMessageLite.d<MessageType>.a aVarE = e();
        if ((this.bitField0_ & 2) == 2) {
            codedOutputStream.writeInt32(1, this.oldFlags_);
        }
        if ((this.bitField0_ & 4) == 4) {
            codedOutputStream.writeInt32(2, this.name_);
        }
        if ((this.bitField0_ & 8) == 8) {
            codedOutputStream.writeMessage(3, this.returnType_);
        }
        for (int i = 0; i < this.typeParameter_.size(); i++) {
            codedOutputStream.writeMessage(4, this.typeParameter_.get(i));
        }
        if ((this.bitField0_ & 32) == 32) {
            codedOutputStream.writeMessage(5, this.receiverType_);
        }
        if ((this.bitField0_ & 128) == 128) {
            codedOutputStream.writeMessage(6, this.setterValueParameter_);
        }
        if ((this.bitField0_ & 256) == 256) {
            codedOutputStream.writeInt32(7, this.getterFlags_);
        }
        if ((this.bitField0_ & 512) == 512) {
            codedOutputStream.writeInt32(8, this.setterFlags_);
        }
        if ((this.bitField0_ & 16) == 16) {
            codedOutputStream.writeInt32(9, this.returnTypeId_);
        }
        if ((this.bitField0_ & 64) == 64) {
            codedOutputStream.writeInt32(10, this.receiverTypeId_);
        }
        if ((this.bitField0_ & 1) == 1) {
            codedOutputStream.writeInt32(11, this.flags_);
        }
        for (int i2 = 0; i2 < this.versionRequirement_.size(); i2++) {
            codedOutputStream.writeInt32(31, this.versionRequirement_.get(i2).intValue());
        }
        aVarE.writeUntil(19000, codedOutputStream);
        codedOutputStream.writeRawBytes(this.unknownFields);
    }

    public final void x() {
        this.flags_ = 518;
        this.oldFlags_ = 2054;
        this.name_ = 0;
        this.returnType_ = q.getDefaultInstance();
        this.returnTypeId_ = 0;
        this.typeParameter_ = Collections.emptyList();
        this.receiverType_ = q.getDefaultInstance();
        this.receiverTypeId_ = 0;
        this.setterValueParameter_ = u.getDefaultInstance();
        this.getterFlags_ = 0;
        this.setterFlags_ = 0;
        this.versionRequirement_ = Collections.emptyList();
    }

    public static b newBuilder() {
        return new b();
    }

    @Override // d0.e0.p.d.m0.i.MessageLiteOrBuilder
    public n getDefaultInstanceForType() {
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

    public n() {
        this.memoizedIsInitialized = (byte) -1;
        this.memoizedSerializedSize = -1;
        this.unknownFields = ByteString3.j;
    }

    public n(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, d0.e0.p.d.m0.f.a aVar) throws InvalidProtocolBufferException {
        this.memoizedIsInitialized = (byte) -1;
        this.memoizedSerializedSize = -1;
        x();
        ByteString3.b bVarNewOutput = ByteString3.newOutput();
        CodedOutputStream codedOutputStreamNewInstance = CodedOutputStream.newInstance(bVarNewOutput, 1);
        boolean z2 = false;
        int i = 0;
        while (!z2) {
            try {
                try {
                    int tag = codedInputStream.readTag();
                    switch (tag) {
                        case 0:
                            break;
                        case 8:
                            this.bitField0_ |= 2;
                            this.oldFlags_ = codedInputStream.readInt32();
                            continue;
                        case 16:
                            this.bitField0_ |= 4;
                            this.name_ = codedInputStream.readInt32();
                            continue;
                        case 26:
                            q.c builder = (this.bitField0_ & 8) == 8 ? this.returnType_.toBuilder() : null;
                            q qVar = (q) codedInputStream.readMessage(q.k, extensionRegistryLite);
                            this.returnType_ = qVar;
                            if (builder != null) {
                                builder.mergeFrom(qVar);
                                this.returnType_ = builder.buildPartial();
                            }
                            this.bitField0_ |= 8;
                            continue;
                        case 34:
                            if ((i & 32) != 32) {
                                this.typeParameter_ = new ArrayList();
                                i |= 32;
                            }
                            this.typeParameter_.add((s) codedInputStream.readMessage(s.k, extensionRegistryLite));
                            continue;
                        case 42:
                            q.c builder2 = (this.bitField0_ & 32) == 32 ? this.receiverType_.toBuilder() : null;
                            q qVar2 = (q) codedInputStream.readMessage(q.k, extensionRegistryLite);
                            this.receiverType_ = qVar2;
                            if (builder2 != null) {
                                builder2.mergeFrom(qVar2);
                                this.receiverType_ = builder2.buildPartial();
                            }
                            this.bitField0_ |= 32;
                            continue;
                        case 50:
                            u.b builder3 = (this.bitField0_ & 128) == 128 ? this.setterValueParameter_.toBuilder() : null;
                            u uVar = (u) codedInputStream.readMessage(u.k, extensionRegistryLite);
                            this.setterValueParameter_ = uVar;
                            if (builder3 != null) {
                                builder3.mergeFrom(uVar);
                                this.setterValueParameter_ = builder3.buildPartial();
                            }
                            this.bitField0_ |= 128;
                            continue;
                        case 56:
                            this.bitField0_ |= 256;
                            this.getterFlags_ = codedInputStream.readInt32();
                            continue;
                        case 64:
                            this.bitField0_ |= 512;
                            this.setterFlags_ = codedInputStream.readInt32();
                            continue;
                        case 72:
                            this.bitField0_ |= 16;
                            this.returnTypeId_ = codedInputStream.readInt32();
                            continue;
                        case 80:
                            this.bitField0_ |= 64;
                            this.receiverTypeId_ = codedInputStream.readInt32();
                            continue;
                        case 88:
                            this.bitField0_ |= 1;
                            this.flags_ = codedInputStream.readInt32();
                            continue;
                        case 248:
                            if ((i & 2048) != 2048) {
                                this.versionRequirement_ = new ArrayList();
                                i |= 2048;
                            }
                            this.versionRequirement_.add(Integer.valueOf(codedInputStream.readInt32()));
                            continue;
                        case 250:
                            int iPushLimit = codedInputStream.pushLimit(codedInputStream.readRawVarint32());
                            if ((i & 2048) != 2048 && codedInputStream.getBytesUntilLimit() > 0) {
                                this.versionRequirement_ = new ArrayList();
                                i |= 2048;
                            }
                            while (codedInputStream.getBytesUntilLimit() > 0) {
                                this.versionRequirement_.add(Integer.valueOf(codedInputStream.readInt32()));
                            }
                            codedInputStream.popLimit(iPushLimit);
                            continue;
                        default:
                            if (!f(codedInputStream, codedOutputStreamNewInstance, extensionRegistryLite, tag)) {
                                break;
                            }
                            break;
                    }
                    z2 = true;
                } catch (Throwable th) {
                    if ((i & 32) == 32) {
                        this.typeParameter_ = Collections.unmodifiableList(this.typeParameter_);
                    }
                    if ((i & 2048) == 2048) {
                        this.versionRequirement_ = Collections.unmodifiableList(this.versionRequirement_);
                    }
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
            } catch (InvalidProtocolBufferException e) {
                throw e.setUnfinishedMessage(this);
            } catch (IOException e2) {
                throw new InvalidProtocolBufferException(e2.getMessage()).setUnfinishedMessage(this);
            }
        }
        if ((i & 32) == 32) {
            this.typeParameter_ = Collections.unmodifiableList(this.typeParameter_);
        }
        if ((i & 2048) == 2048) {
            this.versionRequirement_ = Collections.unmodifiableList(this.versionRequirement_);
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
