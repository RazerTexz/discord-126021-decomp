package p507d0.p513e0.p514p.p515d.p517m0.p543f;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.protobuf.CodedOutputStream;
import kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException;
import kotlin.reflect.jvm.internal.impl.protobuf.UninitializedMessageException;
import p507d0.p513e0.p514p.p515d.p517m0.p550i.AbstractC11722b;
import p507d0.p513e0.p514p.p515d.p517m0.p550i.AbstractC11723c;
import p507d0.p513e0.p514p.p515d.p517m0.p550i.AbstractC11727g;
import p507d0.p513e0.p514p.p515d.p517m0.p550i.C11724d;
import p507d0.p513e0.p514p.p515d.p517m0.p550i.C11725e;
import p507d0.p513e0.p514p.p515d.p517m0.p550i.InterfaceC11735o;
import p507d0.p513e0.p514p.p515d.p517m0.p550i.InterfaceC11736p;

/* JADX INFO: renamed from: d0.e0.p.d.m0.f.d */
/* JADX INFO: compiled from: ProtoBuf.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C11679d extends AbstractC11727g.d<C11679d> implements InterfaceC11735o {

    /* JADX INFO: renamed from: j */
    public static final C11679d f23787j;

    /* JADX INFO: renamed from: k */
    public static InterfaceC11736p<C11679d> f23788k = new a();
    private int bitField0_;
    private int flags_;
    private byte memoizedIsInitialized;
    private int memoizedSerializedSize;
    private final AbstractC11723c unknownFields;
    private List<C11696u> valueParameter_;
    private List<Integer> versionRequirement_;

    /* JADX INFO: renamed from: d0.e0.p.d.m0.f.d$a */
    /* JADX INFO: compiled from: ProtoBuf.java */
    public static class a extends AbstractC11722b<C11679d> {
        @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.InterfaceC11736p
        public C11679d parsePartialFrom(C11724d c11724d, C11725e c11725e) throws InvalidProtocolBufferException {
            return new C11679d(c11724d, c11725e, null);
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.f.d$b */
    /* JADX INFO: compiled from: ProtoBuf.java */
    public static final class b extends AbstractC11727g.c<C11679d, b> implements InterfaceC11735o {

        /* JADX INFO: renamed from: m */
        public int f23789m;

        /* JADX INFO: renamed from: n */
        public int f23790n = 6;

        /* JADX INFO: renamed from: o */
        public List<C11696u> f23791o = Collections.emptyList();

        /* JADX INFO: renamed from: p */
        public List<Integer> f23792p = Collections.emptyList();

        public C11679d buildPartial() {
            C11679d c11679d = new C11679d(this, null);
            int i = (this.f23789m & 1) != 1 ? 0 : 1;
            c11679d.flags_ = this.f23790n;
            if ((this.f23789m & 2) == 2) {
                this.f23791o = Collections.unmodifiableList(this.f23791o);
                this.f23789m &= -3;
            }
            c11679d.valueParameter_ = this.f23791o;
            if ((this.f23789m & 4) == 4) {
                this.f23792p = Collections.unmodifiableList(this.f23792p);
                this.f23789m &= -5;
            }
            c11679d.versionRequirement_ = this.f23792p;
            c11679d.bitField0_ = i;
            return c11679d;
        }

        public b setFlags(int i) {
            this.f23789m |= 1;
            this.f23790n = i;
            return this;
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.InterfaceC11734n.a
        public C11679d build() {
            C11679d c11679dBuildPartial = buildPartial();
            if (c11679dBuildPartial.isInitialized()) {
                return c11679dBuildPartial;
            }
            throw new UninitializedMessageException(c11679dBuildPartial);
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.AbstractC11727g.b
        /* JADX INFO: renamed from: clone */
        public b mo11465clone() {
            return new b().mergeFrom(buildPartial());
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.AbstractC11727g.b
        public b mergeFrom(C11679d c11679d) {
            if (c11679d == C11679d.getDefaultInstance()) {
                return this;
            }
            if (c11679d.hasFlags()) {
                setFlags(c11679d.getFlags());
            }
            if (!c11679d.valueParameter_.isEmpty()) {
                if (this.f23791o.isEmpty()) {
                    this.f23791o = c11679d.valueParameter_;
                    this.f23789m &= -3;
                } else {
                    if ((this.f23789m & 2) != 2) {
                        this.f23791o = new ArrayList(this.f23791o);
                        this.f23789m |= 2;
                    }
                    this.f23791o.addAll(c11679d.valueParameter_);
                }
            }
            if (!c11679d.versionRequirement_.isEmpty()) {
                if (this.f23792p.isEmpty()) {
                    this.f23792p = c11679d.versionRequirement_;
                    this.f23789m &= -5;
                } else {
                    if ((this.f23789m & 4) != 4) {
                        this.f23792p = new ArrayList(this.f23792p);
                        this.f23789m |= 4;
                    }
                    this.f23792p.addAll(c11679d.versionRequirement_);
                }
            }
            m9846b(c11679d);
            setUnknownFields(getUnknownFields().concat(c11679d.unknownFields));
            return this;
        }

        /* JADX WARN: Code duplicated, block: B:15:0x001d  */
        @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.AbstractC11721a.a, p507d0.p513e0.p514p.p515d.p517m0.p550i.InterfaceC11734n.a
        public b mergeFrom(C11724d c11724d, C11725e c11725e) throws Throwable {
            C11679d c11679d = null;
            try {
                try {
                    C11679d partialFrom = C11679d.f23788k.parsePartialFrom(c11724d, c11725e);
                    if (partialFrom != null) {
                        mergeFrom(partialFrom);
                    }
                    return this;
                } catch (InvalidProtocolBufferException e) {
                    C11679d c11679d2 = (C11679d) e.getUnfinishedMessage();
                    try {
                        throw e;
                    } catch (Throwable th) {
                        th = th;
                        c11679d = c11679d2;
                        if (c11679d != null) {
                            mergeFrom(c11679d);
                        }
                        throw th;
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                if (c11679d != null) {
                    mergeFrom(c11679d);
                }
                throw th;
            }
        }
    }

    static {
        C11679d c11679d = new C11679d();
        f23787j = c11679d;
        c11679d.flags_ = 6;
        c11679d.valueParameter_ = Collections.emptyList();
        c11679d.versionRequirement_ = Collections.emptyList();
    }

    public C11679d(AbstractC11727g.c cVar, C11666a c11666a) {
        super(cVar);
        this.memoizedIsInitialized = (byte) -1;
        this.memoizedSerializedSize = -1;
        this.unknownFields = cVar.getUnknownFields();
    }

    public static C11679d getDefaultInstance() {
        return f23787j;
    }

    public static b newBuilder(C11679d c11679d) {
        return newBuilder().mergeFrom(c11679d);
    }

    public int getFlags() {
        return this.flags_;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.InterfaceC11734n
    public int getSerializedSize() {
        int i = this.memoizedSerializedSize;
        if (i != -1) {
            return i;
        }
        int iComputeInt32Size = (this.bitField0_ & 1) == 1 ? CodedOutputStream.computeInt32Size(1, this.flags_) + 0 : 0;
        for (int i2 = 0; i2 < this.valueParameter_.size(); i2++) {
            iComputeInt32Size += CodedOutputStream.computeMessageSize(2, this.valueParameter_.get(i2));
        }
        int iComputeInt32SizeNoTag = 0;
        for (int i3 = 0; i3 < this.versionRequirement_.size(); i3++) {
            iComputeInt32SizeNoTag += CodedOutputStream.computeInt32SizeNoTag(this.versionRequirement_.get(i3).intValue());
        }
        int size = this.unknownFields.size() + m9849c() + (getVersionRequirementList().size() * 2) + iComputeInt32Size + iComputeInt32SizeNoTag;
        this.memoizedSerializedSize = size;
        return size;
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

    public boolean hasFlags() {
        return (this.bitField0_ & 1) == 1;
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
        for (int i = 0; i < getValueParameterCount(); i++) {
            if (!getValueParameter(i).isInitialized()) {
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

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.InterfaceC11734n
    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        getSerializedSize();
        AbstractC11727g.d<MessageType>.a aVarM9851e = m9851e();
        if ((this.bitField0_ & 1) == 1) {
            codedOutputStream.writeInt32(1, this.flags_);
        }
        for (int i = 0; i < this.valueParameter_.size(); i++) {
            codedOutputStream.writeMessage(2, this.valueParameter_.get(i));
        }
        for (int i2 = 0; i2 < this.versionRequirement_.size(); i2++) {
            codedOutputStream.writeInt32(31, this.versionRequirement_.get(i2).intValue());
        }
        aVarM9851e.writeUntil(19000, codedOutputStream);
        codedOutputStream.writeRawBytes(this.unknownFields);
    }

    public static b newBuilder() {
        return new b();
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.InterfaceC11735o
    public C11679d getDefaultInstanceForType() {
        return f23787j;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.InterfaceC11734n
    public b newBuilderForType() {
        return newBuilder();
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.InterfaceC11734n
    public b toBuilder() {
        return newBuilder(this);
    }

    public C11679d() {
        this.memoizedIsInitialized = (byte) -1;
        this.memoizedSerializedSize = -1;
        this.unknownFields = AbstractC11723c.f24100j;
    }

    public C11679d(C11724d c11724d, C11725e c11725e, C11666a c11666a) throws InvalidProtocolBufferException {
        this.memoizedIsInitialized = (byte) -1;
        this.memoizedSerializedSize = -1;
        this.flags_ = 6;
        this.valueParameter_ = Collections.emptyList();
        this.versionRequirement_ = Collections.emptyList();
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
                        } else if (tag == 18) {
                            if ((i & 2) != 2) {
                                this.valueParameter_ = new ArrayList();
                                i |= 2;
                            }
                            this.valueParameter_.add((C11696u) c11724d.readMessage(C11696u.f23962k, c11725e));
                        } else if (tag == 248) {
                            if ((i & 4) != 4) {
                                this.versionRequirement_ = new ArrayList();
                                i |= 4;
                            }
                            this.versionRequirement_.add(Integer.valueOf(c11724d.readInt32()));
                        } else if (tag != 250) {
                            if (!m9852f(c11724d, codedOutputStreamNewInstance, c11725e, tag)) {
                            }
                        } else {
                            int iPushLimit = c11724d.pushLimit(c11724d.readRawVarint32());
                            if ((i & 4) != 4 && c11724d.getBytesUntilLimit() > 0) {
                                this.versionRequirement_ = new ArrayList();
                                i |= 4;
                            }
                            while (c11724d.getBytesUntilLimit() > 0) {
                                this.versionRequirement_.add(Integer.valueOf(c11724d.readInt32()));
                            }
                            c11724d.popLimit(iPushLimit);
                        }
                    }
                    z2 = true;
                } catch (Throwable th) {
                    if ((i & 2) == 2) {
                        this.valueParameter_ = Collections.unmodifiableList(this.valueParameter_);
                    }
                    if ((i & 4) == 4) {
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
        if ((i & 2) == 2) {
            this.valueParameter_ = Collections.unmodifiableList(this.valueParameter_);
        }
        if ((i & 4) == 4) {
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
