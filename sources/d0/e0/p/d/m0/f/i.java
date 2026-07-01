package d0.e0.p.d.m0.f;

import d0.e0.p.d.m0.i.g$c;
import d0.e0.p.d.m0.i.g$d;
import d0.e0.p.d.m0.i.g$d$a;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.protobuf.CodedOutputStream;
import kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException;

/* JADX INFO: compiled from: ProtoBuf.java */
/* JADX INFO: loaded from: classes3.dex */
public final class i extends g$d<i> implements d0.e0.p.d.m0.i.o {
    public static final i j;
    public static d0.e0.p.d.m0.i.p<i> k = new i$a();
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
    private final d0.e0.p.d.m0.i.c unknownFields;
    private List<u> valueParameter_;
    private List<Integer> versionRequirement_;

    static {
        i iVar = new i();
        j = iVar;
        iVar.y();
    }

    public i(g$c g_c, a aVar) {
        super(g_c);
        this.memoizedIsInitialized = (byte) -1;
        this.memoizedSerializedSize = -1;
        this.unknownFields = g_c.getUnknownFields();
    }

    public static i getDefaultInstance() {
        return j;
    }

    public static /* synthetic */ int h(i iVar, int i) {
        iVar.flags_ = i;
        return i;
    }

    public static /* synthetic */ int i(i iVar, int i) {
        iVar.oldFlags_ = i;
        return i;
    }

    public static /* synthetic */ int j(i iVar, int i) {
        iVar.name_ = i;
        return i;
    }

    public static /* synthetic */ q k(i iVar, q qVar) {
        iVar.returnType_ = qVar;
        return qVar;
    }

    public static /* synthetic */ int l(i iVar, int i) {
        iVar.returnTypeId_ = i;
        return i;
    }

    public static /* synthetic */ List m(i iVar) {
        return iVar.typeParameter_;
    }

    public static /* synthetic */ List n(i iVar, List list) {
        iVar.typeParameter_ = list;
        return list;
    }

    public static i$b newBuilder(i iVar) {
        return newBuilder().mergeFrom(iVar);
    }

    public static /* synthetic */ q o(i iVar, q qVar) {
        iVar.receiverType_ = qVar;
        return qVar;
    }

    public static /* synthetic */ int p(i iVar, int i) {
        iVar.receiverTypeId_ = i;
        return i;
    }

    public static i parseFrom(InputStream inputStream, d0.e0.p.d.m0.i.e eVar) throws IOException {
        return (i) ((d0.e0.p.d.m0.i.b) k).m90parseFrom(inputStream, eVar);
    }

    public static /* synthetic */ List q(i iVar) {
        return iVar.valueParameter_;
    }

    public static /* synthetic */ List r(i iVar, List list) {
        iVar.valueParameter_ = list;
        return list;
    }

    public static /* synthetic */ t s(i iVar, t tVar) {
        iVar.typeTable_ = tVar;
        return tVar;
    }

    public static /* synthetic */ List t(i iVar) {
        return iVar.versionRequirement_;
    }

    public static /* synthetic */ List u(i iVar, List list) {
        iVar.versionRequirement_ = list;
        return list;
    }

    public static /* synthetic */ e v(i iVar, e eVar) {
        iVar.contract_ = eVar;
        return eVar;
    }

    public static /* synthetic */ int w(i iVar, int i) {
        iVar.bitField0_ = i;
        return i;
    }

    public static /* synthetic */ d0.e0.p.d.m0.i.c x(i iVar) {
        return iVar.unknownFields;
    }

    public e getContract() {
        return this.contract_;
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

    @Override // d0.e0.p.d.m0.i.n
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

    @Override // d0.e0.p.d.m0.i.n
    public /* bridge */ /* synthetic */ d0.e0.p.d.m0.i.n$a newBuilderForType() {
        return newBuilderForType();
    }

    @Override // d0.e0.p.d.m0.i.n
    public /* bridge */ /* synthetic */ d0.e0.p.d.m0.i.n$a toBuilder() {
        return toBuilder();
    }

    @Override // d0.e0.p.d.m0.i.n
    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        getSerializedSize();
        g$d$a g_d_aE = e();
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
        g_d_aE.writeUntil(19000, codedOutputStream);
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

    public static i$b newBuilder() {
        return new i$b();
    }

    @Override // d0.e0.p.d.m0.i.o
    public i getDefaultInstanceForType() {
        return j;
    }

    @Override // d0.e0.p.d.m0.i.n
    public i$b newBuilderForType() {
        return newBuilder();
    }

    @Override // d0.e0.p.d.m0.i.n
    public i$b toBuilder() {
        return newBuilder(this);
    }

    public i() {
        this.memoizedIsInitialized = (byte) -1;
        this.memoizedSerializedSize = -1;
        this.unknownFields = d0.e0.p.d.m0.i.c.j;
    }

    public i(d0.e0.p.d.m0.i.d dVar, d0.e0.p.d.m0.i.e eVar, a aVar) throws InvalidProtocolBufferException {
        this.memoizedIsInitialized = (byte) -1;
        this.memoizedSerializedSize = -1;
        y();
        d0.e0.p.d.m0.i.c$b c_bNewOutput = d0.e0.p.d.m0.i.c.newOutput();
        CodedOutputStream codedOutputStreamNewInstance = CodedOutputStream.newInstance(c_bNewOutput, 1);
        boolean z2 = false;
        int i = 0;
        while (!z2) {
            try {
                try {
                    int tag = dVar.readTag();
                    switch (tag) {
                        case 0:
                            break;
                        case 8:
                            this.bitField0_ |= 2;
                            this.oldFlags_ = dVar.readInt32();
                            continue;
                        case 16:
                            this.bitField0_ |= 4;
                            this.name_ = dVar.readInt32();
                            continue;
                        case 26:
                            q$c builder = (this.bitField0_ & 8) == 8 ? this.returnType_.toBuilder() : null;
                            q qVar = (q) dVar.readMessage(q.k, eVar);
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
                            this.typeParameter_.add((s) dVar.readMessage(s.k, eVar));
                            continue;
                        case 42:
                            q$c builder2 = (this.bitField0_ & 32) == 32 ? this.receiverType_.toBuilder() : null;
                            q qVar2 = (q) dVar.readMessage(q.k, eVar);
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
                            this.valueParameter_.add((u) dVar.readMessage(u.k, eVar));
                            continue;
                        case 56:
                            this.bitField0_ |= 16;
                            this.returnTypeId_ = dVar.readInt32();
                            continue;
                        case 64:
                            this.bitField0_ |= 64;
                            this.receiverTypeId_ = dVar.readInt32();
                            continue;
                        case 72:
                            this.bitField0_ |= 1;
                            this.flags_ = dVar.readInt32();
                            continue;
                        case 242:
                            t$b builder3 = (this.bitField0_ & 128) == 128 ? this.typeTable_.toBuilder() : null;
                            t tVar = (t) dVar.readMessage(t.k, eVar);
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
                            this.versionRequirement_.add(Integer.valueOf(dVar.readInt32()));
                            continue;
                        case 250:
                            int iPushLimit = dVar.pushLimit(dVar.readRawVarint32());
                            if ((i & 1024) != 1024 && dVar.getBytesUntilLimit() > 0) {
                                this.versionRequirement_ = new ArrayList();
                                i |= 1024;
                            }
                            while (dVar.getBytesUntilLimit() > 0) {
                                this.versionRequirement_.add(Integer.valueOf(dVar.readInt32()));
                            }
                            dVar.popLimit(iPushLimit);
                            continue;
                        case 258:
                            e$b builder4 = (this.bitField0_ & 256) == 256 ? this.contract_.toBuilder() : null;
                            e eVar2 = (e) dVar.readMessage(e.k, eVar);
                            this.contract_ = eVar2;
                            if (builder4 != null) {
                                builder4.mergeFrom(eVar2);
                                this.contract_ = builder4.buildPartial();
                            }
                            this.bitField0_ |= 256;
                            continue;
                        default:
                            if (!f(dVar, codedOutputStreamNewInstance, eVar, tag)) {
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
                        this.unknownFields = c_bNewOutput.toByteString();
                        throw th2;
                    }
                    this.unknownFields = c_bNewOutput.toByteString();
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
            this.unknownFields = c_bNewOutput.toByteString();
            throw th3;
        }
        this.unknownFields = c_bNewOutput.toByteString();
        d();
    }
}
