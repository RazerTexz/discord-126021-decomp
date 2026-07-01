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
public final class s extends g$d<s> implements d0.e0.p.d.m0.i.o {
    public static final s j;
    public static d0.e0.p.d.m0.i.p<s> k = new s$a();
    private int bitField0_;
    private int id_;
    private byte memoizedIsInitialized;
    private int memoizedSerializedSize;
    private int name_;
    private boolean reified_;
    private final d0.e0.p.d.m0.i.c unknownFields;
    private int upperBoundIdMemoizedSerializedSize;
    private List<Integer> upperBoundId_;
    private List<q> upperBound_;
    private s$c variance_;

    static {
        s sVar = new s();
        j = sVar;
        sVar.r();
    }

    public s(g$c g_c, a aVar) {
        super(g_c);
        this.upperBoundIdMemoizedSerializedSize = -1;
        this.memoizedIsInitialized = (byte) -1;
        this.memoizedSerializedSize = -1;
        this.unknownFields = g_c.getUnknownFields();
    }

    public static s getDefaultInstance() {
        return j;
    }

    public static /* synthetic */ int h(s sVar, int i) {
        sVar.id_ = i;
        return i;
    }

    public static /* synthetic */ int i(s sVar, int i) {
        sVar.name_ = i;
        return i;
    }

    public static /* synthetic */ boolean j(s sVar, boolean z2) {
        sVar.reified_ = z2;
        return z2;
    }

    public static /* synthetic */ s$c k(s sVar, s$c s_c) {
        sVar.variance_ = s_c;
        return s_c;
    }

    public static /* synthetic */ List l(s sVar) {
        return sVar.upperBound_;
    }

    public static /* synthetic */ List m(s sVar, List list) {
        sVar.upperBound_ = list;
        return list;
    }

    public static /* synthetic */ List n(s sVar) {
        return sVar.upperBoundId_;
    }

    public static s$b newBuilder(s sVar) {
        return newBuilder().mergeFrom(sVar);
    }

    public static /* synthetic */ List o(s sVar, List list) {
        sVar.upperBoundId_ = list;
        return list;
    }

    public static /* synthetic */ int p(s sVar, int i) {
        sVar.bitField0_ = i;
        return i;
    }

    public static /* synthetic */ d0.e0.p.d.m0.i.c q(s sVar) {
        return sVar.unknownFields;
    }

    @Override // d0.e0.p.d.m0.i.o
    public /* bridge */ /* synthetic */ d0.e0.p.d.m0.i.n getDefaultInstanceForType() {
        return getDefaultInstanceForType();
    }

    public int getId() {
        return this.id_;
    }

    public int getName() {
        return this.name_;
    }

    public boolean getReified() {
        return this.reified_;
    }

    @Override // d0.e0.p.d.m0.i.n
    public int getSerializedSize() {
        int i = this.memoizedSerializedSize;
        if (i != -1) {
            return i;
        }
        int iComputeInt32Size = (this.bitField0_ & 1) == 1 ? CodedOutputStream.computeInt32Size(1, this.id_) + 0 : 0;
        if ((this.bitField0_ & 2) == 2) {
            iComputeInt32Size += CodedOutputStream.computeInt32Size(2, this.name_);
        }
        if ((this.bitField0_ & 4) == 4) {
            iComputeInt32Size += CodedOutputStream.computeBoolSize(3, this.reified_);
        }
        if ((this.bitField0_ & 8) == 8) {
            iComputeInt32Size += CodedOutputStream.computeEnumSize(4, this.variance_.getNumber());
        }
        for (int i2 = 0; i2 < this.upperBound_.size(); i2++) {
            iComputeInt32Size += CodedOutputStream.computeMessageSize(5, this.upperBound_.get(i2));
        }
        int iComputeInt32SizeNoTag = 0;
        for (int i3 = 0; i3 < this.upperBoundId_.size(); i3++) {
            iComputeInt32SizeNoTag += CodedOutputStream.computeInt32SizeNoTag(this.upperBoundId_.get(i3).intValue());
        }
        int iComputeInt32SizeNoTag2 = iComputeInt32Size + iComputeInt32SizeNoTag;
        if (!getUpperBoundIdList().isEmpty()) {
            iComputeInt32SizeNoTag2 = iComputeInt32SizeNoTag2 + 1 + CodedOutputStream.computeInt32SizeNoTag(iComputeInt32SizeNoTag);
        }
        this.upperBoundIdMemoizedSerializedSize = iComputeInt32SizeNoTag;
        int size = this.unknownFields.size() + c() + iComputeInt32SizeNoTag2;
        this.memoizedSerializedSize = size;
        return size;
    }

    public q getUpperBound(int i) {
        return this.upperBound_.get(i);
    }

    public int getUpperBoundCount() {
        return this.upperBound_.size();
    }

    public List<Integer> getUpperBoundIdList() {
        return this.upperBoundId_;
    }

    public List<q> getUpperBoundList() {
        return this.upperBound_;
    }

    public s$c getVariance() {
        return this.variance_;
    }

    public boolean hasId() {
        return (this.bitField0_ & 1) == 1;
    }

    public boolean hasName() {
        return (this.bitField0_ & 2) == 2;
    }

    public boolean hasReified() {
        return (this.bitField0_ & 4) == 4;
    }

    public boolean hasVariance() {
        return (this.bitField0_ & 8) == 8;
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
        if (!hasId()) {
            this.memoizedIsInitialized = (byte) 0;
            return false;
        }
        if (!hasName()) {
            this.memoizedIsInitialized = (byte) 0;
            return false;
        }
        for (int i = 0; i < getUpperBoundCount(); i++) {
            if (!getUpperBound(i).isInitialized()) {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            }
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

    public final void r() {
        this.id_ = 0;
        this.name_ = 0;
        this.reified_ = false;
        this.variance_ = s$c.INV;
        this.upperBound_ = Collections.emptyList();
        this.upperBoundId_ = Collections.emptyList();
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
            codedOutputStream.writeInt32(1, this.id_);
        }
        if ((this.bitField0_ & 2) == 2) {
            codedOutputStream.writeInt32(2, this.name_);
        }
        if ((this.bitField0_ & 4) == 4) {
            codedOutputStream.writeBool(3, this.reified_);
        }
        if ((this.bitField0_ & 8) == 8) {
            codedOutputStream.writeEnum(4, this.variance_.getNumber());
        }
        for (int i = 0; i < this.upperBound_.size(); i++) {
            codedOutputStream.writeMessage(5, this.upperBound_.get(i));
        }
        if (getUpperBoundIdList().size() > 0) {
            codedOutputStream.writeRawVarint32(50);
            codedOutputStream.writeRawVarint32(this.upperBoundIdMemoizedSerializedSize);
        }
        for (int i2 = 0; i2 < this.upperBoundId_.size(); i2++) {
            codedOutputStream.writeInt32NoTag(this.upperBoundId_.get(i2).intValue());
        }
        g_d_aE.writeUntil(1000, codedOutputStream);
        codedOutputStream.writeRawBytes(this.unknownFields);
    }

    public static s$b newBuilder() {
        return new s$b();
    }

    @Override // d0.e0.p.d.m0.i.o
    public s getDefaultInstanceForType() {
        return j;
    }

    @Override // d0.e0.p.d.m0.i.n
    public s$b newBuilderForType() {
        return newBuilder();
    }

    @Override // d0.e0.p.d.m0.i.n
    public s$b toBuilder() {
        return newBuilder(this);
    }

    public s() {
        this.upperBoundIdMemoizedSerializedSize = -1;
        this.memoizedIsInitialized = (byte) -1;
        this.memoizedSerializedSize = -1;
        this.unknownFields = d0.e0.p.d.m0.i.c.j;
    }

    public s(d0.e0.p.d.m0.i.d dVar, d0.e0.p.d.m0.i.e eVar, a aVar) throws InvalidProtocolBufferException {
        this.upperBoundIdMemoizedSerializedSize = -1;
        this.memoizedIsInitialized = (byte) -1;
        this.memoizedSerializedSize = -1;
        r();
        d0.e0.p.d.m0.i.c$b c_bNewOutput = d0.e0.p.d.m0.i.c.newOutput();
        CodedOutputStream codedOutputStreamNewInstance = CodedOutputStream.newInstance(c_bNewOutput, 1);
        boolean z2 = false;
        int i = 0;
        while (!z2) {
            try {
                try {
                    try {
                        int tag = dVar.readTag();
                        if (tag != 0) {
                            if (tag == 8) {
                                this.bitField0_ |= 1;
                                this.id_ = dVar.readInt32();
                            } else if (tag == 16) {
                                this.bitField0_ |= 2;
                                this.name_ = dVar.readInt32();
                            } else if (tag == 24) {
                                this.bitField0_ |= 4;
                                this.reified_ = dVar.readBool();
                            } else if (tag == 32) {
                                int i2 = dVar.readEnum();
                                s$c s_cValueOf = s$c.valueOf(i2);
                                if (s_cValueOf == null) {
                                    codedOutputStreamNewInstance.writeRawVarint32(tag);
                                    codedOutputStreamNewInstance.writeRawVarint32(i2);
                                } else {
                                    this.bitField0_ |= 8;
                                    this.variance_ = s_cValueOf;
                                }
                            } else if (tag == 42) {
                                if ((i & 16) != 16) {
                                    this.upperBound_ = new ArrayList();
                                    i |= 16;
                                }
                                this.upperBound_.add((q) dVar.readMessage(q.k, eVar));
                            } else if (tag == 48) {
                                if ((i & 32) != 32) {
                                    this.upperBoundId_ = new ArrayList();
                                    i |= 32;
                                }
                                this.upperBoundId_.add(Integer.valueOf(dVar.readInt32()));
                            } else if (tag != 50) {
                                if (!f(dVar, codedOutputStreamNewInstance, eVar, tag)) {
                                }
                            } else {
                                int iPushLimit = dVar.pushLimit(dVar.readRawVarint32());
                                if ((i & 32) != 32 && dVar.getBytesUntilLimit() > 0) {
                                    this.upperBoundId_ = new ArrayList();
                                    i |= 32;
                                }
                                while (dVar.getBytesUntilLimit() > 0) {
                                    this.upperBoundId_.add(Integer.valueOf(dVar.readInt32()));
                                }
                                dVar.popLimit(iPushLimit);
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
                if ((i & 16) == 16) {
                    this.upperBound_ = Collections.unmodifiableList(this.upperBound_);
                }
                if ((i & 32) == 32) {
                    this.upperBoundId_ = Collections.unmodifiableList(this.upperBoundId_);
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
        }
        if ((i & 16) == 16) {
            this.upperBound_ = Collections.unmodifiableList(this.upperBound_);
        }
        if ((i & 32) == 32) {
            this.upperBoundId_ = Collections.unmodifiableList(this.upperBoundId_);
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
