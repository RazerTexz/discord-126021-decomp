package p507d0.p513e0.p514p.p515d.p517m0.p543f;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.protobuf.CodedOutputStream;
import kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException;
import kotlin.reflect.jvm.internal.impl.protobuf.UninitializedMessageException;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.C11680e;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.C11692q;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.C11695t;
import p507d0.p513e0.p514p.p515d.p517m0.p550i.AbstractC11722b;
import p507d0.p513e0.p514p.p515d.p517m0.p550i.AbstractC11723c;
import p507d0.p513e0.p514p.p515d.p517m0.p550i.AbstractC11727g;
import p507d0.p513e0.p514p.p515d.p517m0.p550i.C11724d;
import p507d0.p513e0.p514p.p515d.p517m0.p550i.C11725e;
import p507d0.p513e0.p514p.p515d.p517m0.p550i.InterfaceC11735o;
import p507d0.p513e0.p514p.p515d.p517m0.p550i.InterfaceC11736p;

/* JADX INFO: renamed from: d0.e0.p.d.m0.f.i */
/* JADX INFO: compiled from: ProtoBuf.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C11684i extends AbstractC11727g.d<C11684i> implements InterfaceC11735o {

    /* JADX INFO: renamed from: j */
    public static final C11684i f23830j;

    /* JADX INFO: renamed from: k */
    public static InterfaceC11736p<C11684i> f23831k = new a();
    private int bitField0_;
    private C11680e contract_;
    private int flags_;
    private byte memoizedIsInitialized;
    private int memoizedSerializedSize;
    private int name_;
    private int oldFlags_;
    private int receiverTypeId_;
    private C11692q receiverType_;
    private int returnTypeId_;
    private C11692q returnType_;
    private List<C11694s> typeParameter_;
    private C11695t typeTable_;
    private final AbstractC11723c unknownFields;
    private List<C11696u> valueParameter_;
    private List<Integer> versionRequirement_;

    /* JADX INFO: renamed from: d0.e0.p.d.m0.f.i$a */
    /* JADX INFO: compiled from: ProtoBuf.java */
    public static class a extends AbstractC11722b<C11684i> {
        @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.InterfaceC11736p
        public C11684i parsePartialFrom(C11724d c11724d, C11725e c11725e) throws InvalidProtocolBufferException {
            return new C11684i(c11724d, c11725e, null);
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.f.i$b */
    /* JADX INFO: compiled from: ProtoBuf.java */
    public static final class b extends AbstractC11727g.c<C11684i, b> implements InterfaceC11735o {

        /* JADX INFO: renamed from: m */
        public int f23832m;

        /* JADX INFO: renamed from: p */
        public int f23835p;

        /* JADX INFO: renamed from: r */
        public int f23837r;

        /* JADX INFO: renamed from: u */
        public int f23840u;

        /* JADX INFO: renamed from: n */
        public int f23833n = 6;

        /* JADX INFO: renamed from: o */
        public int f23834o = 6;

        /* JADX INFO: renamed from: q */
        public C11692q f23836q = C11692q.getDefaultInstance();

        /* JADX INFO: renamed from: s */
        public List<C11694s> f23838s = Collections.emptyList();

        /* JADX INFO: renamed from: t */
        public C11692q f23839t = C11692q.getDefaultInstance();

        /* JADX INFO: renamed from: v */
        public List<C11696u> f23841v = Collections.emptyList();

        /* JADX INFO: renamed from: w */
        public C11695t f23842w = C11695t.getDefaultInstance();

        /* JADX INFO: renamed from: x */
        public List<Integer> f23843x = Collections.emptyList();

        /* JADX INFO: renamed from: y */
        public C11680e f23844y = C11680e.getDefaultInstance();

        public C11684i buildPartial() {
            C11684i c11684i = new C11684i(this, null);
            int i = this.f23832m;
            int i2 = (i & 1) != 1 ? 0 : 1;
            c11684i.flags_ = this.f23833n;
            if ((i & 2) == 2) {
                i2 |= 2;
            }
            c11684i.oldFlags_ = this.f23834o;
            if ((i & 4) == 4) {
                i2 |= 4;
            }
            c11684i.name_ = this.f23835p;
            if ((i & 8) == 8) {
                i2 |= 8;
            }
            c11684i.returnType_ = this.f23836q;
            if ((i & 16) == 16) {
                i2 |= 16;
            }
            c11684i.returnTypeId_ = this.f23837r;
            if ((this.f23832m & 32) == 32) {
                this.f23838s = Collections.unmodifiableList(this.f23838s);
                this.f23832m &= -33;
            }
            c11684i.typeParameter_ = this.f23838s;
            if ((i & 64) == 64) {
                i2 |= 32;
            }
            c11684i.receiverType_ = this.f23839t;
            if ((i & 128) == 128) {
                i2 |= 64;
            }
            c11684i.receiverTypeId_ = this.f23840u;
            if ((this.f23832m & 256) == 256) {
                this.f23841v = Collections.unmodifiableList(this.f23841v);
                this.f23832m &= -257;
            }
            c11684i.valueParameter_ = this.f23841v;
            if ((i & 512) == 512) {
                i2 |= 128;
            }
            c11684i.typeTable_ = this.f23842w;
            if ((this.f23832m & 1024) == 1024) {
                this.f23843x = Collections.unmodifiableList(this.f23843x);
                this.f23832m &= -1025;
            }
            c11684i.versionRequirement_ = this.f23843x;
            if ((i & 2048) == 2048) {
                i2 |= 256;
            }
            c11684i.contract_ = this.f23844y;
            c11684i.bitField0_ = i2;
            return c11684i;
        }

        public b mergeContract(C11680e c11680e) {
            if ((this.f23832m & 2048) != 2048 || this.f23844y == C11680e.getDefaultInstance()) {
                this.f23844y = c11680e;
            } else {
                this.f23844y = C11680e.newBuilder(this.f23844y).mergeFrom(c11680e).buildPartial();
            }
            this.f23832m |= 2048;
            return this;
        }

        public b mergeReceiverType(C11692q c11692q) {
            if ((this.f23832m & 64) != 64 || this.f23839t == C11692q.getDefaultInstance()) {
                this.f23839t = c11692q;
            } else {
                this.f23839t = C11692q.newBuilder(this.f23839t).mergeFrom(c11692q).buildPartial();
            }
            this.f23832m |= 64;
            return this;
        }

        public b mergeReturnType(C11692q c11692q) {
            if ((this.f23832m & 8) != 8 || this.f23836q == C11692q.getDefaultInstance()) {
                this.f23836q = c11692q;
            } else {
                this.f23836q = C11692q.newBuilder(this.f23836q).mergeFrom(c11692q).buildPartial();
            }
            this.f23832m |= 8;
            return this;
        }

        public b mergeTypeTable(C11695t c11695t) {
            if ((this.f23832m & 512) != 512 || this.f23842w == C11695t.getDefaultInstance()) {
                this.f23842w = c11695t;
            } else {
                this.f23842w = C11695t.newBuilder(this.f23842w).mergeFrom(c11695t).buildPartial();
            }
            this.f23832m |= 512;
            return this;
        }

        public b setFlags(int i) {
            this.f23832m |= 1;
            this.f23833n = i;
            return this;
        }

        public b setName(int i) {
            this.f23832m |= 4;
            this.f23835p = i;
            return this;
        }

        public b setOldFlags(int i) {
            this.f23832m |= 2;
            this.f23834o = i;
            return this;
        }

        public b setReceiverTypeId(int i) {
            this.f23832m |= 128;
            this.f23840u = i;
            return this;
        }

        public b setReturnTypeId(int i) {
            this.f23832m |= 16;
            this.f23837r = i;
            return this;
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.InterfaceC11734n.a
        public C11684i build() {
            C11684i c11684iBuildPartial = buildPartial();
            if (c11684iBuildPartial.isInitialized()) {
                return c11684iBuildPartial;
            }
            throw new UninitializedMessageException(c11684iBuildPartial);
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.AbstractC11727g.b
        /* JADX INFO: renamed from: clone */
        public b mo11465clone() {
            return new b().mergeFrom(buildPartial());
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.AbstractC11727g.b
        public b mergeFrom(C11684i c11684i) {
            if (c11684i == C11684i.getDefaultInstance()) {
                return this;
            }
            if (c11684i.hasFlags()) {
                setFlags(c11684i.getFlags());
            }
            if (c11684i.hasOldFlags()) {
                setOldFlags(c11684i.getOldFlags());
            }
            if (c11684i.hasName()) {
                setName(c11684i.getName());
            }
            if (c11684i.hasReturnType()) {
                mergeReturnType(c11684i.getReturnType());
            }
            if (c11684i.hasReturnTypeId()) {
                setReturnTypeId(c11684i.getReturnTypeId());
            }
            if (!c11684i.typeParameter_.isEmpty()) {
                if (this.f23838s.isEmpty()) {
                    this.f23838s = c11684i.typeParameter_;
                    this.f23832m &= -33;
                } else {
                    if ((this.f23832m & 32) != 32) {
                        this.f23838s = new ArrayList(this.f23838s);
                        this.f23832m |= 32;
                    }
                    this.f23838s.addAll(c11684i.typeParameter_);
                }
            }
            if (c11684i.hasReceiverType()) {
                mergeReceiverType(c11684i.getReceiverType());
            }
            if (c11684i.hasReceiverTypeId()) {
                setReceiverTypeId(c11684i.getReceiverTypeId());
            }
            if (!c11684i.valueParameter_.isEmpty()) {
                if (this.f23841v.isEmpty()) {
                    this.f23841v = c11684i.valueParameter_;
                    this.f23832m &= -257;
                } else {
                    if ((this.f23832m & 256) != 256) {
                        this.f23841v = new ArrayList(this.f23841v);
                        this.f23832m |= 256;
                    }
                    this.f23841v.addAll(c11684i.valueParameter_);
                }
            }
            if (c11684i.hasTypeTable()) {
                mergeTypeTable(c11684i.getTypeTable());
            }
            if (!c11684i.versionRequirement_.isEmpty()) {
                if (this.f23843x.isEmpty()) {
                    this.f23843x = c11684i.versionRequirement_;
                    this.f23832m &= -1025;
                } else {
                    if ((this.f23832m & 1024) != 1024) {
                        this.f23843x = new ArrayList(this.f23843x);
                        this.f23832m |= 1024;
                    }
                    this.f23843x.addAll(c11684i.versionRequirement_);
                }
            }
            if (c11684i.hasContract()) {
                mergeContract(c11684i.getContract());
            }
            m9846b(c11684i);
            setUnknownFields(getUnknownFields().concat(c11684i.unknownFields));
            return this;
        }

        /* JADX WARN: Code duplicated, block: B:15:0x001d  */
        @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.AbstractC11721a.a, p507d0.p513e0.p514p.p515d.p517m0.p550i.InterfaceC11734n.a
        public b mergeFrom(C11724d c11724d, C11725e c11725e) throws Throwable {
            C11684i c11684i = null;
            try {
                try {
                    C11684i partialFrom = C11684i.f23831k.parsePartialFrom(c11724d, c11725e);
                    if (partialFrom != null) {
                        mergeFrom(partialFrom);
                    }
                    return this;
                } catch (InvalidProtocolBufferException e) {
                    C11684i c11684i2 = (C11684i) e.getUnfinishedMessage();
                    try {
                        throw e;
                    } catch (Throwable th) {
                        th = th;
                        c11684i = c11684i2;
                        if (c11684i != null) {
                            mergeFrom(c11684i);
                        }
                        throw th;
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                if (c11684i != null) {
                    mergeFrom(c11684i);
                }
                throw th;
            }
        }
    }

    static {
        C11684i c11684i = new C11684i();
        f23830j = c11684i;
        c11684i.m9691y();
    }

    public C11684i(AbstractC11727g.c cVar, C11666a c11666a) {
        super(cVar);
        this.memoizedIsInitialized = (byte) -1;
        this.memoizedSerializedSize = -1;
        this.unknownFields = cVar.getUnknownFields();
    }

    public static C11684i getDefaultInstance() {
        return f23830j;
    }

    public static b newBuilder(C11684i c11684i) {
        return newBuilder().mergeFrom(c11684i);
    }

    public static C11684i parseFrom(InputStream inputStream, C11725e c11725e) throws IOException {
        return (C11684i) ((AbstractC11722b) f23831k).m11467parseFrom(inputStream, c11725e);
    }

    public C11680e getContract() {
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

    public C11692q getReceiverType() {
        return this.receiverType_;
    }

    public int getReceiverTypeId() {
        return this.receiverTypeId_;
    }

    public C11692q getReturnType() {
        return this.returnType_;
    }

    public int getReturnTypeId() {
        return this.returnTypeId_;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.InterfaceC11734n
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
        int size2 = this.unknownFields.size() + m9849c() + size;
        this.memoizedSerializedSize = size2;
        return size2;
    }

    public C11694s getTypeParameter(int i) {
        return this.typeParameter_.get(i);
    }

    public int getTypeParameterCount() {
        return this.typeParameter_.size();
    }

    public List<C11694s> getTypeParameterList() {
        return this.typeParameter_;
    }

    public C11695t getTypeTable() {
        return this.typeTable_;
    }

    public C11696u getValueParameter(int i) {
        return this.valueParameter_.get(i);
    }

    public int getValueParameterCount() {
        return this.valueParameter_.size();
    }

    public List<C11696u> getValueParameterList() {
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

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.InterfaceC11735o
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
        aVarM9851e.writeUntil(19000, codedOutputStream);
        codedOutputStream.writeRawBytes(this.unknownFields);
    }

    /* JADX INFO: renamed from: y */
    public final void m9691y() {
        this.flags_ = 6;
        this.oldFlags_ = 6;
        this.name_ = 0;
        this.returnType_ = C11692q.getDefaultInstance();
        this.returnTypeId_ = 0;
        this.typeParameter_ = Collections.emptyList();
        this.receiverType_ = C11692q.getDefaultInstance();
        this.receiverTypeId_ = 0;
        this.valueParameter_ = Collections.emptyList();
        this.typeTable_ = C11695t.getDefaultInstance();
        this.versionRequirement_ = Collections.emptyList();
        this.contract_ = C11680e.getDefaultInstance();
    }

    public static b newBuilder() {
        return new b();
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.InterfaceC11735o
    public C11684i getDefaultInstanceForType() {
        return f23830j;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.InterfaceC11734n
    public b newBuilderForType() {
        return newBuilder();
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.InterfaceC11734n
    public b toBuilder() {
        return newBuilder(this);
    }

    public C11684i() {
        this.memoizedIsInitialized = (byte) -1;
        this.memoizedSerializedSize = -1;
        this.unknownFields = AbstractC11723c.f24100j;
    }

    public C11684i(C11724d c11724d, C11725e c11725e, C11666a c11666a) throws InvalidProtocolBufferException {
        this.memoizedIsInitialized = (byte) -1;
        this.memoizedSerializedSize = -1;
        m9691y();
        AbstractC11723c.b bVarNewOutput = AbstractC11723c.newOutput();
        CodedOutputStream codedOutputStreamNewInstance = CodedOutputStream.newInstance(bVarNewOutput, 1);
        boolean z2 = false;
        int i = 0;
        while (!z2) {
            try {
                try {
                    int tag = c11724d.readTag();
                    switch (tag) {
                        case 0:
                            break;
                        case 8:
                            this.bitField0_ |= 2;
                            this.oldFlags_ = c11724d.readInt32();
                            continue;
                        case 16:
                            this.bitField0_ |= 4;
                            this.name_ = c11724d.readInt32();
                            continue;
                        case 26:
                            C11692q.c builder = (this.bitField0_ & 8) == 8 ? this.returnType_.toBuilder() : null;
                            C11692q c11692q = (C11692q) c11724d.readMessage(C11692q.f23904k, c11725e);
                            this.returnType_ = c11692q;
                            if (builder != null) {
                                builder.mergeFrom(c11692q);
                                this.returnType_ = builder.buildPartial();
                            }
                            this.bitField0_ |= 8;
                            continue;
                        case 34:
                            if ((i & 32) != 32) {
                                this.typeParameter_ = new ArrayList();
                                i |= 32;
                            }
                            this.typeParameter_.add((C11694s) c11724d.readMessage(C11694s.f23944k, c11725e));
                            continue;
                        case 42:
                            C11692q.c builder2 = (this.bitField0_ & 32) == 32 ? this.receiverType_.toBuilder() : null;
                            C11692q c11692q2 = (C11692q) c11724d.readMessage(C11692q.f23904k, c11725e);
                            this.receiverType_ = c11692q2;
                            if (builder2 != null) {
                                builder2.mergeFrom(c11692q2);
                                this.receiverType_ = builder2.buildPartial();
                            }
                            this.bitField0_ |= 32;
                            continue;
                        case 50:
                            if ((i & 256) != 256) {
                                this.valueParameter_ = new ArrayList();
                                i |= 256;
                            }
                            this.valueParameter_.add((C11696u) c11724d.readMessage(C11696u.f23962k, c11725e));
                            continue;
                        case 56:
                            this.bitField0_ |= 16;
                            this.returnTypeId_ = c11724d.readInt32();
                            continue;
                        case 64:
                            this.bitField0_ |= 64;
                            this.receiverTypeId_ = c11724d.readInt32();
                            continue;
                        case 72:
                            this.bitField0_ |= 1;
                            this.flags_ = c11724d.readInt32();
                            continue;
                        case 242:
                            C11695t.b builder3 = (this.bitField0_ & 128) == 128 ? this.typeTable_.toBuilder() : null;
                            C11695t c11695t = (C11695t) c11724d.readMessage(C11695t.f23957k, c11725e);
                            this.typeTable_ = c11695t;
                            if (builder3 != null) {
                                builder3.mergeFrom(c11695t);
                                this.typeTable_ = builder3.buildPartial();
                            }
                            this.bitField0_ |= 128;
                            continue;
                        case 248:
                            if ((i & 1024) != 1024) {
                                this.versionRequirement_ = new ArrayList();
                                i |= 1024;
                            }
                            this.versionRequirement_.add(Integer.valueOf(c11724d.readInt32()));
                            continue;
                        case 250:
                            int iPushLimit = c11724d.pushLimit(c11724d.readRawVarint32());
                            if ((i & 1024) != 1024 && c11724d.getBytesUntilLimit() > 0) {
                                this.versionRequirement_ = new ArrayList();
                                i |= 1024;
                            }
                            while (c11724d.getBytesUntilLimit() > 0) {
                                this.versionRequirement_.add(Integer.valueOf(c11724d.readInt32()));
                            }
                            c11724d.popLimit(iPushLimit);
                            continue;
                        case 258:
                            C11680e.b builder4 = (this.bitField0_ & 256) == 256 ? this.contract_.toBuilder() : null;
                            C11680e c11680e = (C11680e) c11724d.readMessage(C11680e.f23794k, c11725e);
                            this.contract_ = c11680e;
                            if (builder4 != null) {
                                builder4.mergeFrom(c11680e);
                                this.contract_ = builder4.buildPartial();
                            }
                            this.bitField0_ |= 256;
                            continue;
                        default:
                            if (!m9852f(c11724d, codedOutputStreamNewInstance, c11725e, tag)) {
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
                    m9850d();
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
        m9850d();
    }
}
