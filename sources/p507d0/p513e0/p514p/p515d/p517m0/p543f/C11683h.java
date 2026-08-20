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

/* JADX INFO: renamed from: d0.e0.p.d.m0.f.h */
/* JADX INFO: compiled from: ProtoBuf.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C11683h extends AbstractC11727g implements InterfaceC11735o {

    /* JADX INFO: renamed from: j */
    public static final C11683h f23816j;

    /* JADX INFO: renamed from: k */
    public static InterfaceC11736p<C11683h> f23817k = new a();
    private List<C11683h> andArgument_;
    private int bitField0_;
    private c constantValue_;
    private int flags_;
    private int isInstanceTypeId_;
    private C11692q isInstanceType_;
    private byte memoizedIsInitialized;
    private int memoizedSerializedSize;
    private List<C11683h> orArgument_;
    private final AbstractC11723c unknownFields;
    private int valueParameterReference_;

    /* JADX INFO: renamed from: d0.e0.p.d.m0.f.h$a */
    /* JADX INFO: compiled from: ProtoBuf.java */
    public static class a extends AbstractC11722b<C11683h> {
        @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.InterfaceC11736p
        public C11683h parsePartialFrom(C11724d c11724d, C11725e c11725e) throws InvalidProtocolBufferException {
            return new C11683h(c11724d, c11725e, null);
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.f.h$b */
    /* JADX INFO: compiled from: ProtoBuf.java */
    public static final class b extends AbstractC11727g.b<C11683h, b> implements InterfaceC11735o {

        /* JADX INFO: renamed from: k */
        public int f23818k;

        /* JADX INFO: renamed from: l */
        public int f23819l;

        /* JADX INFO: renamed from: m */
        public int f23820m;

        /* JADX INFO: renamed from: p */
        public int f23823p;

        /* JADX INFO: renamed from: n */
        public c f23821n = c.TRUE;

        /* JADX INFO: renamed from: o */
        public C11692q f23822o = C11692q.getDefaultInstance();

        /* JADX INFO: renamed from: q */
        public List<C11683h> f23824q = Collections.emptyList();

        /* JADX INFO: renamed from: r */
        public List<C11683h> f23825r = Collections.emptyList();

        public C11683h buildPartial() {
            C11683h c11683h = new C11683h(this, null);
            int i = this.f23818k;
            int i2 = (i & 1) != 1 ? 0 : 1;
            c11683h.flags_ = this.f23819l;
            if ((i & 2) == 2) {
                i2 |= 2;
            }
            c11683h.valueParameterReference_ = this.f23820m;
            if ((i & 4) == 4) {
                i2 |= 4;
            }
            c11683h.constantValue_ = this.f23821n;
            if ((i & 8) == 8) {
                i2 |= 8;
            }
            c11683h.isInstanceType_ = this.f23822o;
            if ((i & 16) == 16) {
                i2 |= 16;
            }
            c11683h.isInstanceTypeId_ = this.f23823p;
            if ((this.f23818k & 32) == 32) {
                this.f23824q = Collections.unmodifiableList(this.f23824q);
                this.f23818k &= -33;
            }
            c11683h.andArgument_ = this.f23824q;
            if ((this.f23818k & 64) == 64) {
                this.f23825r = Collections.unmodifiableList(this.f23825r);
                this.f23818k &= -65;
            }
            c11683h.orArgument_ = this.f23825r;
            c11683h.bitField0_ = i2;
            return c11683h;
        }

        public b mergeIsInstanceType(C11692q c11692q) {
            if ((this.f23818k & 8) != 8 || this.f23822o == C11692q.getDefaultInstance()) {
                this.f23822o = c11692q;
            } else {
                this.f23822o = C11692q.newBuilder(this.f23822o).mergeFrom(c11692q).buildPartial();
            }
            this.f23818k |= 8;
            return this;
        }

        public b setConstantValue(c cVar) {
            Objects.requireNonNull(cVar);
            this.f23818k |= 4;
            this.f23821n = cVar;
            return this;
        }

        public b setFlags(int i) {
            this.f23818k |= 1;
            this.f23819l = i;
            return this;
        }

        public b setIsInstanceTypeId(int i) {
            this.f23818k |= 16;
            this.f23823p = i;
            return this;
        }

        public b setValueParameterReference(int i) {
            this.f23818k |= 2;
            this.f23820m = i;
            return this;
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.InterfaceC11734n.a
        public C11683h build() {
            C11683h c11683hBuildPartial = buildPartial();
            if (c11683hBuildPartial.isInitialized()) {
                return c11683hBuildPartial;
            }
            throw new UninitializedMessageException(c11683hBuildPartial);
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.AbstractC11727g.b
        /* JADX INFO: renamed from: clone */
        public b mo11465clone() {
            return new b().mergeFrom(buildPartial());
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.AbstractC11727g.b
        public b mergeFrom(C11683h c11683h) {
            if (c11683h == C11683h.getDefaultInstance()) {
                return this;
            }
            if (c11683h.hasFlags()) {
                setFlags(c11683h.getFlags());
            }
            if (c11683h.hasValueParameterReference()) {
                setValueParameterReference(c11683h.getValueParameterReference());
            }
            if (c11683h.hasConstantValue()) {
                setConstantValue(c11683h.getConstantValue());
            }
            if (c11683h.hasIsInstanceType()) {
                mergeIsInstanceType(c11683h.getIsInstanceType());
            }
            if (c11683h.hasIsInstanceTypeId()) {
                setIsInstanceTypeId(c11683h.getIsInstanceTypeId());
            }
            if (!c11683h.andArgument_.isEmpty()) {
                if (this.f23824q.isEmpty()) {
                    this.f23824q = c11683h.andArgument_;
                    this.f23818k &= -33;
                } else {
                    if ((this.f23818k & 32) != 32) {
                        this.f23824q = new ArrayList(this.f23824q);
                        this.f23818k |= 32;
                    }
                    this.f23824q.addAll(c11683h.andArgument_);
                }
            }
            if (!c11683h.orArgument_.isEmpty()) {
                if (this.f23825r.isEmpty()) {
                    this.f23825r = c11683h.orArgument_;
                    this.f23818k &= -65;
                } else {
                    if ((this.f23818k & 64) != 64) {
                        this.f23825r = new ArrayList(this.f23825r);
                        this.f23818k |= 64;
                    }
                    this.f23825r.addAll(c11683h.orArgument_);
                }
            }
            setUnknownFields(getUnknownFields().concat(c11683h.unknownFields));
            return this;
        }

        /* JADX WARN: Code duplicated, block: B:15:0x001d  */
        @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.AbstractC11721a.a, p507d0.p513e0.p514p.p515d.p517m0.p550i.InterfaceC11734n.a
        public b mergeFrom(C11724d c11724d, C11725e c11725e) throws Throwable {
            C11683h c11683h = null;
            try {
                try {
                    C11683h partialFrom = C11683h.f23817k.parsePartialFrom(c11724d, c11725e);
                    if (partialFrom != null) {
                        mergeFrom(partialFrom);
                    }
                    return this;
                } catch (InvalidProtocolBufferException e) {
                    C11683h c11683h2 = (C11683h) e.getUnfinishedMessage();
                    try {
                        throw e;
                    } catch (Throwable th) {
                        th = th;
                        c11683h = c11683h2;
                        if (c11683h != null) {
                            mergeFrom(c11683h);
                        }
                        throw th;
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                if (c11683h != null) {
                    mergeFrom(c11683h);
                }
                throw th;
            }
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.f.h$c */
    /* JADX INFO: compiled from: ProtoBuf.java */
    public enum c implements C11728h.a {
        TRUE(0),
        FALSE(1),
        NULL(2);

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
                return TRUE;
            }
            if (i == 1) {
                return FALSE;
            }
            if (i != 2) {
                return null;
            }
            return NULL;
        }
    }

    static {
        C11683h c11683h = new C11683h();
        f23816j = c11683h;
        c11683h.m9673l();
    }

    public C11683h(AbstractC11727g.b bVar, C11666a c11666a) {
        super(bVar);
        this.memoizedIsInitialized = (byte) -1;
        this.memoizedSerializedSize = -1;
        this.unknownFields = bVar.getUnknownFields();
    }

    public static C11683h getDefaultInstance() {
        return f23816j;
    }

    public static b newBuilder(C11683h c11683h) {
        return newBuilder().mergeFrom(c11683h);
    }

    public C11683h getAndArgument(int i) {
        return this.andArgument_.get(i);
    }

    public int getAndArgumentCount() {
        return this.andArgument_.size();
    }

    public c getConstantValue() {
        return this.constantValue_;
    }

    public int getFlags() {
        return this.flags_;
    }

    public C11692q getIsInstanceType() {
        return this.isInstanceType_;
    }

    public int getIsInstanceTypeId() {
        return this.isInstanceTypeId_;
    }

    public C11683h getOrArgument(int i) {
        return this.orArgument_.get(i);
    }

    public int getOrArgumentCount() {
        return this.orArgument_.size();
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.InterfaceC11734n
    public int getSerializedSize() {
        int i = this.memoizedSerializedSize;
        if (i != -1) {
            return i;
        }
        int iComputeInt32Size = (this.bitField0_ & 1) == 1 ? CodedOutputStream.computeInt32Size(1, this.flags_) + 0 : 0;
        if ((this.bitField0_ & 2) == 2) {
            iComputeInt32Size += CodedOutputStream.computeInt32Size(2, this.valueParameterReference_);
        }
        if ((this.bitField0_ & 4) == 4) {
            iComputeInt32Size += CodedOutputStream.computeEnumSize(3, this.constantValue_.getNumber());
        }
        if ((this.bitField0_ & 8) == 8) {
            iComputeInt32Size += CodedOutputStream.computeMessageSize(4, this.isInstanceType_);
        }
        if ((this.bitField0_ & 16) == 16) {
            iComputeInt32Size += CodedOutputStream.computeInt32Size(5, this.isInstanceTypeId_);
        }
        for (int i2 = 0; i2 < this.andArgument_.size(); i2++) {
            iComputeInt32Size += CodedOutputStream.computeMessageSize(6, this.andArgument_.get(i2));
        }
        for (int i3 = 0; i3 < this.orArgument_.size(); i3++) {
            iComputeInt32Size += CodedOutputStream.computeMessageSize(7, this.orArgument_.get(i3));
        }
        int size = this.unknownFields.size() + iComputeInt32Size;
        this.memoizedSerializedSize = size;
        return size;
    }

    public int getValueParameterReference() {
        return this.valueParameterReference_;
    }

    public boolean hasConstantValue() {
        return (this.bitField0_ & 4) == 4;
    }

    public boolean hasFlags() {
        return (this.bitField0_ & 1) == 1;
    }

    public boolean hasIsInstanceType() {
        return (this.bitField0_ & 8) == 8;
    }

    public boolean hasIsInstanceTypeId() {
        return (this.bitField0_ & 16) == 16;
    }

    public boolean hasValueParameterReference() {
        return (this.bitField0_ & 2) == 2;
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
        if (hasIsInstanceType() && !getIsInstanceType().isInitialized()) {
            this.memoizedIsInitialized = (byte) 0;
            return false;
        }
        for (int i = 0; i < getAndArgumentCount(); i++) {
            if (!getAndArgument(i).isInitialized()) {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            }
        }
        for (int i2 = 0; i2 < getOrArgumentCount(); i2++) {
            if (!getOrArgument(i2).isInitialized()) {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            }
        }
        this.memoizedIsInitialized = (byte) 1;
        return true;
    }

    /* JADX INFO: renamed from: l */
    public final void m9673l() {
        this.flags_ = 0;
        this.valueParameterReference_ = 0;
        this.constantValue_ = c.TRUE;
        this.isInstanceType_ = C11692q.getDefaultInstance();
        this.isInstanceTypeId_ = 0;
        this.andArgument_ = Collections.emptyList();
        this.orArgument_ = Collections.emptyList();
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.InterfaceC11734n
    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        getSerializedSize();
        if ((this.bitField0_ & 1) == 1) {
            codedOutputStream.writeInt32(1, this.flags_);
        }
        if ((this.bitField0_ & 2) == 2) {
            codedOutputStream.writeInt32(2, this.valueParameterReference_);
        }
        if ((this.bitField0_ & 4) == 4) {
            codedOutputStream.writeEnum(3, this.constantValue_.getNumber());
        }
        if ((this.bitField0_ & 8) == 8) {
            codedOutputStream.writeMessage(4, this.isInstanceType_);
        }
        if ((this.bitField0_ & 16) == 16) {
            codedOutputStream.writeInt32(5, this.isInstanceTypeId_);
        }
        for (int i = 0; i < this.andArgument_.size(); i++) {
            codedOutputStream.writeMessage(6, this.andArgument_.get(i));
        }
        for (int i2 = 0; i2 < this.orArgument_.size(); i2++) {
            codedOutputStream.writeMessage(7, this.orArgument_.get(i2));
        }
        codedOutputStream.writeRawBytes(this.unknownFields);
    }

    public static b newBuilder() {
        return new b();
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.InterfaceC11734n
    public b newBuilderForType() {
        return newBuilder();
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.InterfaceC11734n
    public b toBuilder() {
        return newBuilder(this);
    }

    public C11683h() {
        this.memoizedIsInitialized = (byte) -1;
        this.memoizedSerializedSize = -1;
        this.unknownFields = AbstractC11723c.f24100j;
    }

    public C11683h(C11724d c11724d, C11725e c11725e, C11666a c11666a) throws InvalidProtocolBufferException {
        this.memoizedIsInitialized = (byte) -1;
        this.memoizedSerializedSize = -1;
        m9673l();
        AbstractC11723c.b bVarNewOutput = AbstractC11723c.newOutput();
        CodedOutputStream codedOutputStreamNewInstance = CodedOutputStream.newInstance(bVarNewOutput, 1);
        boolean z2 = false;
        int i = 0;
        while (!z2) {
            try {
                try {
                    int tag = c11724d.readTag();
                    if (tag != 0) {
                        if (tag == 8) {
                            this.bitField0_ |= 1;
                            this.flags_ = c11724d.readInt32();
                        } else if (tag == 16) {
                            this.bitField0_ |= 2;
                            this.valueParameterReference_ = c11724d.readInt32();
                        } else if (tag == 24) {
                            int i2 = c11724d.readEnum();
                            c cVarValueOf = c.valueOf(i2);
                            if (cVarValueOf == null) {
                                codedOutputStreamNewInstance.writeRawVarint32(tag);
                                codedOutputStreamNewInstance.writeRawVarint32(i2);
                            } else {
                                this.bitField0_ |= 4;
                                this.constantValue_ = cVarValueOf;
                            }
                        } else if (tag == 34) {
                            C11692q.c builder = (this.bitField0_ & 8) == 8 ? this.isInstanceType_.toBuilder() : null;
                            C11692q c11692q = (C11692q) c11724d.readMessage(C11692q.f23904k, c11725e);
                            this.isInstanceType_ = c11692q;
                            if (builder != null) {
                                builder.mergeFrom(c11692q);
                                this.isInstanceType_ = builder.buildPartial();
                            }
                            this.bitField0_ |= 8;
                        } else if (tag == 40) {
                            this.bitField0_ |= 16;
                            this.isInstanceTypeId_ = c11724d.readInt32();
                        } else if (tag == 50) {
                            if ((i & 32) != 32) {
                                this.andArgument_ = new ArrayList();
                                i |= 32;
                            }
                            this.andArgument_.add((C11683h) c11724d.readMessage(f23817k, c11725e));
                        } else if (tag != 58) {
                            if (!c11724d.skipField(tag, codedOutputStreamNewInstance)) {
                            }
                        } else {
                            if ((i & 64) != 64) {
                                this.orArgument_ = new ArrayList();
                                i |= 64;
                            }
                            this.orArgument_.add((C11683h) c11724d.readMessage(f23817k, c11725e));
                        }
                    }
                    z2 = true;
                } catch (InvalidProtocolBufferException e) {
                    throw e.setUnfinishedMessage(this);
                } catch (IOException e2) {
                    throw new InvalidProtocolBufferException(e2.getMessage()).setUnfinishedMessage(this);
                }
            } catch (Throwable th) {
                if ((i & 32) == 32) {
                    this.andArgument_ = Collections.unmodifiableList(this.andArgument_);
                }
                if ((i & 64) == 64) {
                    this.orArgument_ = Collections.unmodifiableList(this.orArgument_);
                }
                try {
                    codedOutputStreamNewInstance.flush();
                } catch (IOException unused) {
                } finally {
                    this.unknownFields = bVarNewOutput.toByteString();
                }
                throw th;
            }
        }
        if ((i & 32) == 32) {
            this.andArgument_ = Collections.unmodifiableList(this.andArgument_);
        }
        if ((i & 64) == 64) {
            this.orArgument_ = Collections.unmodifiableList(this.orArgument_);
        }
        try {
            codedOutputStreamNewInstance.flush();
        } catch (IOException unused2) {
        } finally {
            this.unknownFields = bVarNewOutput.toByteString();
        }
    }
}
