package p507d0.p513e0.p514p.p515d.p517m0.p543f;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import kotlin.reflect.jvm.internal.impl.protobuf.CodedOutputStream;
import kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException;
import kotlin.reflect.jvm.internal.impl.protobuf.UninitializedMessageException;
import p507d0.p513e0.p514p.p515d.p517m0.p550i.AbstractC11722b;
import p507d0.p513e0.p514p.p515d.p517m0.p550i.AbstractC11723c;
import p507d0.p513e0.p514p.p515d.p517m0.p550i.AbstractC11727g;
import p507d0.p513e0.p514p.p515d.p517m0.p550i.C11724d;
import p507d0.p513e0.p514p.p515d.p517m0.p550i.C11725e;
import p507d0.p513e0.p514p.p515d.p517m0.p550i.C11728h;
import p507d0.p513e0.p514p.p515d.p517m0.p550i.InterfaceC11735o;
import p507d0.p513e0.p514p.p515d.p517m0.p550i.InterfaceC11736p;

/* JADX INFO: renamed from: d0.e0.p.d.m0.f.s */
/* JADX INFO: compiled from: ProtoBuf.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C11694s extends AbstractC11727g.d<C11694s> implements InterfaceC11735o {

    /* JADX INFO: renamed from: j */
    public static final C11694s f23943j;

    /* JADX INFO: renamed from: k */
    public static InterfaceC11736p<C11694s> f23944k = new a();
    private int bitField0_;
    private int id_;
    private byte memoizedIsInitialized;
    private int memoizedSerializedSize;
    private int name_;
    private boolean reified_;
    private final AbstractC11723c unknownFields;
    private int upperBoundIdMemoizedSerializedSize;
    private List<Integer> upperBoundId_;
    private List<C11692q> upperBound_;
    private c variance_;

    /* JADX INFO: renamed from: d0.e0.p.d.m0.f.s$a */
    /* JADX INFO: compiled from: ProtoBuf.java */
    public static class a extends AbstractC11722b<C11694s> {
        @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.InterfaceC11736p
        public C11694s parsePartialFrom(C11724d c11724d, C11725e c11725e) throws InvalidProtocolBufferException {
            return new C11694s(c11724d, c11725e, null);
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.f.s$b */
    /* JADX INFO: compiled from: ProtoBuf.java */
    public static final class b extends AbstractC11727g.c<C11694s, b> implements InterfaceC11735o {

        /* JADX INFO: renamed from: m */
        public int f23945m;

        /* JADX INFO: renamed from: n */
        public int f23946n;

        /* JADX INFO: renamed from: o */
        public int f23947o;

        /* JADX INFO: renamed from: p */
        public boolean f23948p;

        /* JADX INFO: renamed from: q */
        public c f23949q = c.INV;

        /* JADX INFO: renamed from: r */
        public List<C11692q> f23950r = Collections.emptyList();

        /* JADX INFO: renamed from: s */
        public List<Integer> f23951s = Collections.emptyList();

        public C11694s buildPartial() {
            C11694s c11694s = new C11694s(this, null);
            int i = this.f23945m;
            int i2 = (i & 1) != 1 ? 0 : 1;
            c11694s.id_ = this.f23946n;
            if ((i & 2) == 2) {
                i2 |= 2;
            }
            c11694s.name_ = this.f23947o;
            if ((i & 4) == 4) {
                i2 |= 4;
            }
            c11694s.reified_ = this.f23948p;
            if ((i & 8) == 8) {
                i2 |= 8;
            }
            c11694s.variance_ = this.f23949q;
            if ((this.f23945m & 16) == 16) {
                this.f23950r = Collections.unmodifiableList(this.f23950r);
                this.f23945m &= -17;
            }
            c11694s.upperBound_ = this.f23950r;
            if ((this.f23945m & 32) == 32) {
                this.f23951s = Collections.unmodifiableList(this.f23951s);
                this.f23945m &= -33;
            }
            c11694s.upperBoundId_ = this.f23951s;
            c11694s.bitField0_ = i2;
            return c11694s;
        }

        public b setId(int i) {
            this.f23945m |= 1;
            this.f23946n = i;
            return this;
        }

        public b setName(int i) {
            this.f23945m |= 2;
            this.f23947o = i;
            return this;
        }

        public b setReified(boolean z2) {
            this.f23945m |= 4;
            this.f23948p = z2;
            return this;
        }

        public b setVariance(c cVar) {
            Objects.requireNonNull(cVar);
            this.f23945m |= 8;
            this.f23949q = cVar;
            return this;
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.InterfaceC11734n.a
        public C11694s build() {
            C11694s c11694sBuildPartial = buildPartial();
            if (c11694sBuildPartial.isInitialized()) {
                return c11694sBuildPartial;
            }
            throw new UninitializedMessageException(c11694sBuildPartial);
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.AbstractC11727g.b
        /* JADX INFO: renamed from: clone */
        public b mo11465clone() {
            return new b().mergeFrom(buildPartial());
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.AbstractC11727g.b
        public b mergeFrom(C11694s c11694s) {
            if (c11694s == C11694s.getDefaultInstance()) {
                return this;
            }
            if (c11694s.hasId()) {
                setId(c11694s.getId());
            }
            if (c11694s.hasName()) {
                setName(c11694s.getName());
            }
            if (c11694s.hasReified()) {
                setReified(c11694s.getReified());
            }
            if (c11694s.hasVariance()) {
                setVariance(c11694s.getVariance());
            }
            if (!c11694s.upperBound_.isEmpty()) {
                if (this.f23950r.isEmpty()) {
                    this.f23950r = c11694s.upperBound_;
                    this.f23945m &= -17;
                } else {
                    if ((this.f23945m & 16) != 16) {
                        this.f23950r = new ArrayList(this.f23950r);
                        this.f23945m |= 16;
                    }
                    this.f23950r.addAll(c11694s.upperBound_);
                }
            }
            if (!c11694s.upperBoundId_.isEmpty()) {
                if (this.f23951s.isEmpty()) {
                    this.f23951s = c11694s.upperBoundId_;
                    this.f23945m &= -33;
                } else {
                    if ((this.f23945m & 32) != 32) {
                        this.f23951s = new ArrayList(this.f23951s);
                        this.f23945m |= 32;
                    }
                    this.f23951s.addAll(c11694s.upperBoundId_);
                }
            }
            m9846b(c11694s);
            setUnknownFields(getUnknownFields().concat(c11694s.unknownFields));
            return this;
        }

        /* JADX WARN: Code duplicated, block: B:15:0x001d  */
        @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.AbstractC11721a.a, p507d0.p513e0.p514p.p515d.p517m0.p550i.InterfaceC11734n.a
        public b mergeFrom(C11724d c11724d, C11725e c11725e) throws Throwable {
            C11694s c11694s = null;
            try {
                try {
                    C11694s partialFrom = C11694s.f23944k.parsePartialFrom(c11724d, c11725e);
                    if (partialFrom != null) {
                        mergeFrom(partialFrom);
                    }
                    return this;
                } catch (InvalidProtocolBufferException e) {
                    C11694s c11694s2 = (C11694s) e.getUnfinishedMessage();
                    try {
                        throw e;
                    } catch (Throwable th) {
                        th = th;
                        c11694s = c11694s2;
                        if (c11694s != null) {
                            mergeFrom(c11694s);
                        }
                        throw th;
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                if (c11694s != null) {
                    mergeFrom(c11694s);
                }
                throw th;
            }
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.f.s$c */
    /* JADX INFO: compiled from: ProtoBuf.java */
    public enum c implements C11728h.a {
        IN(0),
        OUT(1),
        INV(2);

        private final int value;

        c(int i) {
            this.value = i;
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.C11728h.a
        public final int getNumber() {
            return this.value;
        }

        public static c valueOf(int i) {
            if (i == 0) {
                return IN;
            }
            if (i == 1) {
                return OUT;
            }
            if (i != 2) {
                return null;
            }
            return INV;
        }
    }

    static {
        C11694s c11694s = new C11694s();
        f23943j = c11694s;
        c11694s.m9787r();
    }

    public C11694s(AbstractC11727g.c cVar, C11666a c11666a) {
        super(cVar);
        this.upperBoundIdMemoizedSerializedSize = -1;
        this.memoizedIsInitialized = (byte) -1;
        this.memoizedSerializedSize = -1;
        this.unknownFields = cVar.getUnknownFields();
    }

    public static C11694s getDefaultInstance() {
        return f23943j;
    }

    public static b newBuilder(C11694s c11694s) {
        return newBuilder().mergeFrom(c11694s);
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

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.InterfaceC11734n
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
        int size = this.unknownFields.size() + m9849c() + iComputeInt32SizeNoTag2;
        this.memoizedSerializedSize = size;
        return size;
    }

    public C11692q getUpperBound(int i) {
        return this.upperBound_.get(i);
    }

    public int getUpperBoundCount() {
        return this.upperBound_.size();
    }

    public List<Integer> getUpperBoundIdList() {
        return this.upperBoundId_;
    }

    public List<C11692q> getUpperBoundList() {
        return this.upperBound_;
    }

    public c getVariance() {
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

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.InterfaceC11735o
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
        if (m9848b()) {
            this.memoizedIsInitialized = (byte) 1;
            return true;
        }
        this.memoizedIsInitialized = (byte) 0;
        return false;
    }

    /* JADX INFO: renamed from: r */
    public final void m9787r() {
        this.id_ = 0;
        this.name_ = 0;
        this.reified_ = false;
        this.variance_ = c.INV;
        this.upperBound_ = Collections.emptyList();
        this.upperBoundId_ = Collections.emptyList();
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.InterfaceC11734n
    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        getSerializedSize();
        AbstractC11727g.d<MessageType>.a aVarM9851e = m9851e();
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
        aVarM9851e.writeUntil(1000, codedOutputStream);
        codedOutputStream.writeRawBytes(this.unknownFields);
    }

    public static b newBuilder() {
        return new b();
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.InterfaceC11735o
    public C11694s getDefaultInstanceForType() {
        return f23943j;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.InterfaceC11734n
    public b newBuilderForType() {
        return newBuilder();
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.InterfaceC11734n
    public b toBuilder() {
        return newBuilder(this);
    }

    public C11694s() {
        this.upperBoundIdMemoizedSerializedSize = -1;
        this.memoizedIsInitialized = (byte) -1;
        this.memoizedSerializedSize = -1;
        this.unknownFields = AbstractC11723c.f24100j;
    }

    public C11694s(C11724d c11724d, C11725e c11725e, C11666a c11666a) throws InvalidProtocolBufferException {
        this.upperBoundIdMemoizedSerializedSize = -1;
        this.memoizedIsInitialized = (byte) -1;
        this.memoizedSerializedSize = -1;
        m9787r();
        AbstractC11723c.b bVarNewOutput = AbstractC11723c.newOutput();
        CodedOutputStream codedOutputStreamNewInstance = CodedOutputStream.newInstance(bVarNewOutput, 1);
        boolean z2 = false;
        int i = 0;
        while (!z2) {
            try {
                try {
                    try {
                        int tag = c11724d.readTag();
                        if (tag != 0) {
                            if (tag == 8) {
                                this.bitField0_ |= 1;
                                this.id_ = c11724d.readInt32();
                            } else if (tag == 16) {
                                this.bitField0_ |= 2;
                                this.name_ = c11724d.readInt32();
                            } else if (tag == 24) {
                                this.bitField0_ |= 4;
                                this.reified_ = c11724d.readBool();
                            } else if (tag == 32) {
                                int i2 = c11724d.readEnum();
                                c cVarValueOf = c.valueOf(i2);
                                if (cVarValueOf == null) {
                                    codedOutputStreamNewInstance.writeRawVarint32(tag);
                                    codedOutputStreamNewInstance.writeRawVarint32(i2);
                                } else {
                                    this.bitField0_ |= 8;
                                    this.variance_ = cVarValueOf;
                                }
                            } else if (tag == 42) {
                                if ((i & 16) != 16) {
                                    this.upperBound_ = new ArrayList();
                                    i |= 16;
                                }
                                this.upperBound_.add((C11692q) c11724d.readMessage(C11692q.f23904k, c11725e));
                            } else if (tag == 48) {
                                if ((i & 32) != 32) {
                                    this.upperBoundId_ = new ArrayList();
                                    i |= 32;
                                }
                                this.upperBoundId_.add(Integer.valueOf(c11724d.readInt32()));
                            } else if (tag != 50) {
                                if (!m9852f(c11724d, codedOutputStreamNewInstance, c11725e, tag)) {
                                }
                            } else {
                                int iPushLimit = c11724d.pushLimit(c11724d.readRawVarint32());
                                if ((i & 32) != 32 && c11724d.getBytesUntilLimit() > 0) {
                                    this.upperBoundId_ = new ArrayList();
                                    i |= 32;
                                }
                                while (c11724d.getBytesUntilLimit() > 0) {
                                    this.upperBoundId_.add(Integer.valueOf(c11724d.readInt32()));
                                }
                                c11724d.popLimit(iPushLimit);
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
                    this.unknownFields = bVarNewOutput.toByteString();
                    throw th2;
                }
                this.unknownFields = bVarNewOutput.toByteString();
                m9850d();
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
            this.unknownFields = bVarNewOutput.toByteString();
            throw th3;
        }
        this.unknownFields = bVarNewOutput.toByteString();
        m9850d();
    }
}
