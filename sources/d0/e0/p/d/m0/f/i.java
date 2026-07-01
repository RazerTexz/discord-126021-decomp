package d0.e0.p.d.m0.f;

import d0.e0.p.d.m0.f.e;
import d0.e0.p.d.m0.f.q;
import d0.e0.p.d.m0.f.t;
import d0.e0.p.d.m0.i.AbstractParser;
import d0.e0.p.d.m0.i.ByteString3;
import d0.e0.p.d.m0.i.CodedInputStream;
import d0.e0.p.d.m0.i.ExtensionRegistryLite;
import d0.e0.p.d.m0.i.GeneratedMessageLite;
import d0.e0.p.d.m0.i.MessageLiteOrBuilder;
import d0.e0.p.d.m0.i.Parser2;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.protobuf.CodedOutputStream;
import kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException;
import kotlin.reflect.jvm.internal.impl.protobuf.UninitializedMessageException;

/* JADX INFO: compiled from: ProtoBuf.java */
/* JADX INFO: loaded from: classes3.dex */
public final class i extends GeneratedMessageLite.d<i> implements MessageLiteOrBuilder {
    public static final i j;
    public static Parser2<i> k = new a();
    private int bitField0_;
    private e contract_;
    private int flags_;
    private byte memoizedIsInitialized;
    private int memoizedSerializedSize;
    private int name_;
    private int oldFlags_;
    private int receiverTypeId_;
    private q receiverType_;
    private int returnTypeId_;
    private q returnType_;
    private List<s> typeParameter_;
    private t typeTable_;
    private final ByteString3 unknownFields;
    private List<u> valueParameter_;
    private List<Integer> versionRequirement_;

    /* JADX INFO: compiled from: ProtoBuf.java */
    public static class a extends AbstractParser<i> {
        @Override // d0.e0.p.d.m0.i.Parser2
        public i parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return new i(codedInputStream, extensionRegistryLite, null);
        }
    }

    /* JADX INFO: compiled from: ProtoBuf.java */
    public static final class b extends GeneratedMessageLite.c<i, b> implements MessageLiteOrBuilder {
        public int m;
        public int p;
        public int r;
        public int u;
        public int n = 6;
        public int o = 6;
        public q q = q.getDefaultInstance();

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public List<s> f3397s = Collections.emptyList();
        public q t = q.getDefaultInstance();
        public List<u> v = Collections.emptyList();
        public t w = t.getDefaultInstance();

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        public List<Integer> f3398x = Collections.emptyList();

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        public e f3399y = e.getDefaultInstance();

        public i buildPartial() {
            i iVar = new i(this, null);
            int i = this.m;
            int i2 = (i & 1) != 1 ? 0 : 1;
            iVar.flags_ = this.n;
            if ((i & 2) == 2) {
                i2 |= 2;
            }
            iVar.oldFlags_ = this.o;
            if ((i & 4) == 4) {
                i2 |= 4;
            }
            iVar.name_ = this.p;
            if ((i & 8) == 8) {
                i2 |= 8;
            }
            iVar.returnType_ = this.q;
            if ((i & 16) == 16) {
                i2 |= 16;
            }
            iVar.returnTypeId_ = this.r;
            if ((this.m & 32) == 32) {
                this.f3397s = Collections.unmodifiableList(this.f3397s);
                this.m &= -33;
            }
            iVar.typeParameter_ = this.f3397s;
            if ((i & 64) == 64) {
                i2 |= 32;
            }
            iVar.receiverType_ = this.t;
            if ((i & 128) == 128) {
                i2 |= 64;
            }
            iVar.receiverTypeId_ = this.u;
            if ((this.m & 256) == 256) {
                this.v = Collections.unmodifiableList(this.v);
                this.m &= -257;
            }
            iVar.valueParameter_ = this.v;
            if ((i & 512) == 512) {
                i2 |= 128;
            }
            iVar.typeTable_ = this.w;
            if ((this.m & 1024) == 1024) {
                this.f3398x = Collections.unmodifiableList(this.f3398x);
                this.m &= -1025;
            }
            iVar.versionRequirement_ = this.f3398x;
            if ((i & 2048) == 2048) {
                i2 |= 256;
            }
            iVar.contract_ = this.f3399y;
            iVar.bitField0_ = i2;
            return iVar;
        }

        public b mergeContract(e eVar) {
            if ((this.m & 2048) != 2048 || this.f3399y == e.getDefaultInstance()) {
                this.f3399y = eVar;
            } else {
                this.f3399y = e.newBuilder(this.f3399y).mergeFrom(eVar).buildPartial();
            }
            this.m |= 2048;
            return this;
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

        public b mergeTypeTable(t tVar) {
            if ((this.m & 512) != 512 || this.w == t.getDefaultInstance()) {
                this.w = tVar;
            } else {
                this.w = t.newBuilder(this.w).mergeFrom(tVar).buildPartial();
            }
            this.m |= 512;
            return this;
        }

        public b setFlags(int i) {
            this.m |= 1;
            this.n = i;
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

        @Override // d0.e0.p.d.m0.i.MessageLite.a
        public i build() {
            i iVarBuildPartial = buildPartial();
            if (iVarBuildPartial.isInitialized()) {
                return iVarBuildPartial;
            }
            throw new UninitializedMessageException(iVarBuildPartial);
        }

        @Override // d0.e0.p.d.m0.i.GeneratedMessageLite.b
        /* JADX INFO: renamed from: clone */
        public b mo88clone() {
            return new b().mergeFrom(buildPartial());
        }

        @Override // d0.e0.p.d.m0.i.GeneratedMessageLite.b
        public b mergeFrom(i iVar) {
            if (iVar == i.getDefaultInstance()) {
                return this;
            }
            if (iVar.hasFlags()) {
                setFlags(iVar.getFlags());
            }
            if (iVar.hasOldFlags()) {
                setOldFlags(iVar.getOldFlags());
            }
            if (iVar.hasName()) {
                setName(iVar.getName());
            }
            if (iVar.hasReturnType()) {
                mergeReturnType(iVar.getReturnType());
            }
            if (iVar.hasReturnTypeId()) {
                setReturnTypeId(iVar.getReturnTypeId());
            }
            if (!iVar.typeParameter_.isEmpty()) {
                if (this.f3397s.isEmpty()) {
                    this.f3397s = iVar.typeParameter_;
                    this.m &= -33;
                } else {
                    if ((this.m & 32) != 32) {
                        this.f3397s = new ArrayList(this.f3397s);
                        this.m |= 32;
                    }
                    this.f3397s.addAll(iVar.typeParameter_);
                }
            }
            if (iVar.hasReceiverType()) {
                mergeReceiverType(iVar.getReceiverType());
            }
            if (iVar.hasReceiverTypeId()) {
                setReceiverTypeId(iVar.getReceiverTypeId());
            }
            if (!iVar.valueParameter_.isEmpty()) {
                if (this.v.isEmpty()) {
                    this.v = iVar.valueParameter_;
                    this.m &= -257;
                } else {
                    if ((this.m & 256) != 256) {
                        this.v = new ArrayList(this.v);
                        this.m |= 256;
                    }
                    this.v.addAll(iVar.valueParameter_);
                }
            }
            if (iVar.hasTypeTable()) {
                mergeTypeTable(iVar.getTypeTable());
            }
            if (!iVar.versionRequirement_.isEmpty()) {
                if (this.f3398x.isEmpty()) {
                    this.f3398x = iVar.versionRequirement_;
                    this.m &= -1025;
                } else {
                    if ((this.m & 1024) != 1024) {
                        this.f3398x = new ArrayList(this.f3398x);
                        this.m |= 1024;
                    }
                    this.f3398x.addAll(iVar.versionRequirement_);
                }
            }
            if (iVar.hasContract()) {
                mergeContract(iVar.getContract());
            }
            b(iVar);
            setUnknownFields(getUnknownFields().concat(iVar.unknownFields));
            return this;
        }

        /* JADX WARN: Code duplicated, block: B:15:0x001d  */
        @Override // d0.e0.p.d.m0.i.AbstractMessageLite.a, d0.e0.p.d.m0.i.MessageLite.a
        public b mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws Throwable {
            i iVar = null;
            try {
                try {
                    i partialFrom = i.k.parsePartialFrom(codedInputStream, extensionRegistryLite);
                    if (partialFrom != null) {
                        mergeFrom(partialFrom);
                    }
                    return this;
                } catch (InvalidProtocolBufferException e) {
                    i iVar2 = (i) e.getUnfinishedMessage();
                    try {
                        throw e;
                    } catch (Throwable th) {
                        th = th;
                        iVar = iVar2;
                        if (iVar != null) {
                            mergeFrom(iVar);
                        }
                        throw th;
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                if (iVar != null) {
                    mergeFrom(iVar);
                }
                throw th;
            }
        }
    }

    static {
        i iVar = new i();
        j = iVar;
        iVar.y();
    }

    public i(GeneratedMessageLite.c cVar, d0.e0.p.d.m0.f.a aVar) {
        super(cVar);
        this.memoizedIsInitialized = (byte) -1;
        this.memoizedSerializedSize = -1;
        this.unknownFields = cVar.getUnknownFields();
    }

    public static i getDefaultInstance() {
        return j;
    }

    public static b newBuilder(i iVar) {
        return newBuilder().mergeFrom(iVar);
    }

    public static i parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (i) ((AbstractParser) k).m90parseFrom(inputStream, extensionRegistryLite);
    }

    public e getContract() {
        return this.contract_;
    }

    public int getFlags() {
        return this.flags_;
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
        for (int i3 = 0; i3 < this.valueParameter_.size(); i3++) {
            iComputeInt32Size += CodedOutputStream.computeMessageSize(6, this.valueParameter_.get(i3));
        }
        if ((this.bitField0_ & 16) == 16) {
            iComputeInt32Size += CodedOutputStream.computeInt32Size(7, this.returnTypeId_);
        }
        if ((this.bitField0_ & 64) == 64) {
            iComputeInt32Size += CodedOutputStream.computeInt32Size(8, this.receiverTypeId_);
        }
        if ((this.bitField0_ & 1) == 1) {
            iComputeInt32Size += CodedOutputStream.computeInt32Size(9, this.flags_);
        }
        if ((this.bitField0_ & 128) == 128) {
            iComputeInt32Size += CodedOutputStream.computeMessageSize(30, this.typeTable_);
        }
        int iComputeInt32SizeNoTag = 0;
        for (int i4 = 0; i4 < this.versionRequirement_.size(); i4++) {
            iComputeInt32SizeNoTag += CodedOutputStream.computeInt32SizeNoTag(this.versionRequirement_.get(i4).intValue());
        }
        int size = (getVersionRequirementList().size() * 2) + iComputeInt32Size + iComputeInt32SizeNoTag;
        if ((this.bitField0_ & 256) == 256) {
            size += CodedOutputStream.computeMessageSize(32, this.contract_);
        }
        int size2 = this.unknownFields.size() + c() + size;
        this.memoizedSerializedSize = size2;
        return size2;
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

    public t getTypeTable() {
        return this.typeTable_;
    }

    public u getValueParameter(int i) {
        return this.valueParameter_.get(i);
    }

    public int getValueParameterCount() {
        return this.valueParameter_.size();
    }

    public List<u> getValueParameterList() {
        return this.valueParameter_;
    }

    public List<Integer> getVersionRequirementList() {
        return this.versionRequirement_;
    }

    public boolean hasContract() {
        return (this.bitField0_ & 256) == 256;
    }

    public boolean hasFlags() {
        return (this.bitField0_ & 1) == 1;
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

    public boolean hasTypeTable() {
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
        for (int i2 = 0; i2 < getValueParameterCount(); i2++) {
            if (!getValueParameter(i2).isInitialized()) {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            }
        }
        if (hasTypeTable() && !getTypeTable().isInitialized()) {
            this.memoizedIsInitialized = (byte) 0;
            return false;
        }
        if (hasContract() && !getContract().isInitialized()) {
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
        for (int i2 = 0; i2 < this.valueParameter_.size(); i2++) {
            codedOutputStream.writeMessage(6, this.valueParameter_.get(i2));
        }
        if ((this.bitField0_ & 16) == 16) {
            codedOutputStream.writeInt32(7, this.returnTypeId_);
        }
        if ((this.bitField0_ & 64) == 64) {
            codedOutputStream.writeInt32(8, this.receiverTypeId_);
        }
        if ((this.bitField0_ & 1) == 1) {
            codedOutputStream.writeInt32(9, this.flags_);
        }
        if ((this.bitField0_ & 128) == 128) {
            codedOutputStream.writeMessage(30, this.typeTable_);
        }
        for (int i3 = 0; i3 < this.versionRequirement_.size(); i3++) {
            codedOutputStream.writeInt32(31, this.versionRequirement_.get(i3).intValue());
        }
        if ((this.bitField0_ & 256) == 256) {
            codedOutputStream.writeMessage(32, this.contract_);
        }
        aVarE.writeUntil(19000, codedOutputStream);
        codedOutputStream.writeRawBytes(this.unknownFields);
    }

    public final void y() {
        this.flags_ = 6;
        this.oldFlags_ = 6;
        this.name_ = 0;
        this.returnType_ = q.getDefaultInstance();
        this.returnTypeId_ = 0;
        this.typeParameter_ = Collections.emptyList();
        this.receiverType_ = q.getDefaultInstance();
        this.receiverTypeId_ = 0;
        this.valueParameter_ = Collections.emptyList();
        this.typeTable_ = t.getDefaultInstance();
        this.versionRequirement_ = Collections.emptyList();
        this.contract_ = e.getDefaultInstance();
    }

    public static b newBuilder() {
        return new b();
    }

    @Override // d0.e0.p.d.m0.i.MessageLiteOrBuilder
    public i getDefaultInstanceForType() {
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

    public i() {
        this.memoizedIsInitialized = (byte) -1;
        this.memoizedSerializedSize = -1;
        this.unknownFields = ByteString3.j;
    }

    public i(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, d0.e0.p.d.m0.f.a aVar) throws InvalidProtocolBufferException {
        this.memoizedIsInitialized = (byte) -1;
        this.memoizedSerializedSize = -1;
        y();
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
                            if ((i & 256) != 256) {
                                this.valueParameter_ = new ArrayList();
                                i |= 256;
                            }
                            this.valueParameter_.add((u) codedInputStream.readMessage(u.k, extensionRegistryLite));
                            continue;
                        case 56:
                            this.bitField0_ |= 16;
                            this.returnTypeId_ = codedInputStream.readInt32();
                            continue;
                        case 64:
                            this.bitField0_ |= 64;
                            this.receiverTypeId_ = codedInputStream.readInt32();
                            continue;
                        case 72:
                            this.bitField0_ |= 1;
                            this.flags_ = codedInputStream.readInt32();
                            continue;
                        case 242:
                            t.b builder3 = (this.bitField0_ & 128) == 128 ? this.typeTable_.toBuilder() : null;
                            t tVar = (t) codedInputStream.readMessage(t.k, extensionRegistryLite);
                            this.typeTable_ = tVar;
                            if (builder3 != null) {
                                builder3.mergeFrom(tVar);
                                this.typeTable_ = builder3.buildPartial();
                            }
                            this.bitField0_ |= 128;
                            continue;
                        case 248:
                            if ((i & 1024) != 1024) {
                                this.versionRequirement_ = new ArrayList();
                                i |= 1024;
                            }
                            this.versionRequirement_.add(Integer.valueOf(codedInputStream.readInt32()));
                            continue;
                        case 250:
                            int iPushLimit = codedInputStream.pushLimit(codedInputStream.readRawVarint32());
                            if ((i & 1024) != 1024 && codedInputStream.getBytesUntilLimit() > 0) {
                                this.versionRequirement_ = new ArrayList();
                                i |= 1024;
                            }
                            while (codedInputStream.getBytesUntilLimit() > 0) {
                                this.versionRequirement_.add(Integer.valueOf(codedInputStream.readInt32()));
                            }
                            codedInputStream.popLimit(iPushLimit);
                            continue;
                        case 258:
                            e.b builder4 = (this.bitField0_ & 256) == 256 ? this.contract_.toBuilder() : null;
                            e eVar = (e) codedInputStream.readMessage(e.k, extensionRegistryLite);
                            this.contract_ = eVar;
                            if (builder4 != null) {
                                builder4.mergeFrom(eVar);
                                this.contract_ = builder4.buildPartial();
                            }
                            this.bitField0_ |= 256;
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
                    if ((i & 256) == 256) {
                        this.valueParameter_ = Collections.unmodifiableList(this.valueParameter_);
                    }
                    if ((i & 1024) == 1024) {
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
        if ((i & 256) == 256) {
            this.valueParameter_ = Collections.unmodifiableList(this.valueParameter_);
        }
        if ((i & 1024) == 1024) {
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
