package d0.e0.p.d.m0.f;

import d0.e0.p.d.m0.i.g$c;
import d0.e0.p.d.m0.i.g$d;
import d0.e0.p.d.m0.i.g$d$a;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.protobuf.CodedOutputStream;
import kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException;

/* JADX INFO: compiled from: ProtoBuf.java */
/* JADX INFO: loaded from: classes3.dex */
public final class n extends g$d<n> implements d0.e0.p.d.m0.i.o {
    public static final n j;
    public static d0.e0.p.d.m0.i.p<n> k = new n$a();
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
    private final d0.e0.p.d.m0.i.c unknownFields;
    private List<Integer> versionRequirement_;

    static {
        n nVar = new n();
        j = nVar;
        nVar.x();
    }

    public n(g$c g_c, a aVar) {
        super(g_c);
        this.memoizedIsInitialized = (byte) -1;
        this.memoizedSerializedSize = -1;
        this.unknownFields = g_c.getUnknownFields();
    }

    public static n getDefaultInstance() {
        return j;
    }

    public static /* synthetic */ int h(n nVar, int i) {
        nVar.flags_ = i;
        return i;
    }

    public static /* synthetic */ int i(n nVar, int i) {
        nVar.oldFlags_ = i;
        return i;
    }

    public static /* synthetic */ int j(n nVar, int i) {
        nVar.name_ = i;
        return i;
    }

    public static /* synthetic */ q k(n nVar, q qVar) {
        nVar.returnType_ = qVar;
        return qVar;
    }

    public static /* synthetic */ int l(n nVar, int i) {
        nVar.returnTypeId_ = i;
        return i;
    }

    public static /* synthetic */ List m(n nVar) {
        return nVar.typeParameter_;
    }

    public static /* synthetic */ List n(n nVar, List list) {
        nVar.typeParameter_ = list;
        return list;
    }

    public static n$b newBuilder(n nVar) {
        return newBuilder().mergeFrom(nVar);
    }

    public static /* synthetic */ q o(n nVar, q qVar) {
        nVar.receiverType_ = qVar;
        return qVar;
    }

    public static /* synthetic */ int p(n nVar, int i) {
        nVar.receiverTypeId_ = i;
        return i;
    }

    public static /* synthetic */ u q(n nVar, u uVar) {
        nVar.setterValueParameter_ = uVar;
        return uVar;
    }

    public static /* synthetic */ int r(n nVar, int i) {
        nVar.getterFlags_ = i;
        return i;
    }

    public static /* synthetic */ int s(n nVar, int i) {
        nVar.setterFlags_ = i;
        return i;
    }

    public static /* synthetic */ List t(n nVar) {
        return nVar.versionRequirement_;
    }

    public static /* synthetic */ List u(n nVar, List list) {
        nVar.versionRequirement_ = list;
        return list;
    }

    public static /* synthetic */ int v(n nVar, int i) {
        nVar.bitField0_ = i;
        return i;
    }

    public static /* synthetic */ d0.e0.p.d.m0.i.c w(n nVar) {
        return nVar.unknownFields;
    }

    @Override // d0.e0.p.d.m0.i.o
    public /* bridge */ /* synthetic */ d0.e0.p.d.m0.i.n getDefaultInstanceForType() {
        return getDefaultInstanceForType();
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
        g_d_aE.writeUntil(19000, codedOutputStream);
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

    public static n$b newBuilder() {
        return new n$b();
    }

    @Override // d0.e0.p.d.m0.i.o
    public n getDefaultInstanceForType() {
        return j;
    }

    @Override // d0.e0.p.d.m0.i.n
    public n$b newBuilderForType() {
        return newBuilder();
    }

    @Override // d0.e0.p.d.m0.i.n
    public n$b toBuilder() {
        return newBuilder(this);
    }

    public n() {
        this.memoizedIsInitialized = (byte) -1;
        this.memoizedSerializedSize = -1;
        this.unknownFields = d0.e0.p.d.m0.i.c.j;
    }

    public n(d0.e0.p.d.m0.i.d dVar, d0.e0.p.d.m0.i.e eVar, a aVar) throws InvalidProtocolBufferException {
        this.memoizedIsInitialized = (byte) -1;
        this.memoizedSerializedSize = -1;
        x();
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
                            u$b builder3 = (this.bitField0_ & 128) == 128 ? this.setterValueParameter_.toBuilder() : null;
                            u uVar = (u) dVar.readMessage(u.k, eVar);
                            this.setterValueParameter_ = uVar;
                            if (builder3 != null) {
                                builder3.mergeFrom(uVar);
                                this.setterValueParameter_ = builder3.buildPartial();
                            }
                            this.bitField0_ |= 128;
                            continue;
                        case 56:
                            this.bitField0_ |= 256;
                            this.getterFlags_ = dVar.readInt32();
                            continue;
                        case 64:
                            this.bitField0_ |= 512;
                            this.setterFlags_ = dVar.readInt32();
                            continue;
                        case 72:
                            this.bitField0_ |= 16;
                            this.returnTypeId_ = dVar.readInt32();
                            continue;
                        case 80:
                            this.bitField0_ |= 64;
                            this.receiverTypeId_ = dVar.readInt32();
                            continue;
                        case 88:
                            this.bitField0_ |= 1;
                            this.flags_ = dVar.readInt32();
                            continue;
                        case 248:
                            if ((i & 2048) != 2048) {
                                this.versionRequirement_ = new ArrayList();
                                i |= 2048;
                            }
                            this.versionRequirement_.add(Integer.valueOf(dVar.readInt32()));
                            continue;
                        case 250:
                            int iPushLimit = dVar.pushLimit(dVar.readRawVarint32());
                            if ((i & 2048) != 2048 && dVar.getBytesUntilLimit() > 0) {
                                this.versionRequirement_ = new ArrayList();
                                i |= 2048;
                            }
                            while (dVar.getBytesUntilLimit() > 0) {
                                this.versionRequirement_.add(Integer.valueOf(dVar.readInt32()));
                            }
                            dVar.popLimit(iPushLimit);
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
                    if ((i & 2048) == 2048) {
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
        if ((i & 2048) == 2048) {
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
