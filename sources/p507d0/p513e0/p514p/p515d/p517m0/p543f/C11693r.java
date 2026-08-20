package p507d0.p513e0.p514p.p515d.p517m0.p543f;

import java.io.IOException;
import java.io.InputStream;
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

/* JADX INFO: renamed from: d0.e0.p.d.m0.f.r */
/* JADX INFO: compiled from: ProtoBuf.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C11693r extends AbstractC11727g.d<C11693r> implements InterfaceC11735o {

    /* JADX INFO: renamed from: j */
    public static final C11693r f23931j;

    /* JADX INFO: renamed from: k */
    public static InterfaceC11736p<C11693r> f23932k = new a();
    private List<C11677b> annotation_;
    private int bitField0_;
    private int expandedTypeId_;
    private C11692q expandedType_;
    private int flags_;
    private byte memoizedIsInitialized;
    private int memoizedSerializedSize;
    private int name_;
    private List<C11694s> typeParameter_;
    private int underlyingTypeId_;
    private C11692q underlyingType_;
    private final AbstractC11723c unknownFields;
    private List<Integer> versionRequirement_;

    /* JADX INFO: renamed from: d0.e0.p.d.m0.f.r$a */
    /* JADX INFO: compiled from: ProtoBuf.java */
    public static class a extends AbstractC11722b<C11693r> {
        @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.InterfaceC11736p
        public C11693r parsePartialFrom(C11724d c11724d, C11725e c11725e) throws InvalidProtocolBufferException {
            return new C11693r(c11724d, c11725e, null);
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.f.r$b */
    /* JADX INFO: compiled from: ProtoBuf.java */
    public static final class b extends AbstractC11727g.c<C11693r, b> implements InterfaceC11735o {

        /* JADX INFO: renamed from: m */
        public int f23933m;

        /* JADX INFO: renamed from: o */
        public int f23935o;

        /* JADX INFO: renamed from: r */
        public int f23938r;

        /* JADX INFO: renamed from: t */
        public int f23940t;

        /* JADX INFO: renamed from: n */
        public int f23934n = 6;

        /* JADX INFO: renamed from: p */
        public List<C11694s> f23936p = Collections.emptyList();

        /* JADX INFO: renamed from: q */
        public C11692q f23937q = C11692q.getDefaultInstance();

        /* JADX INFO: renamed from: s */
        public C11692q f23939s = C11692q.getDefaultInstance();

        /* JADX INFO: renamed from: u */
        public List<C11677b> f23941u = Collections.emptyList();

        /* JADX INFO: renamed from: v */
        public List<Integer> f23942v = Collections.emptyList();

        public C11693r buildPartial() {
            C11693r c11693r = new C11693r(this, null);
            int i = this.f23933m;
            int i2 = (i & 1) != 1 ? 0 : 1;
            c11693r.flags_ = this.f23934n;
            if ((i & 2) == 2) {
                i2 |= 2;
            }
            c11693r.name_ = this.f23935o;
            if ((this.f23933m & 4) == 4) {
                this.f23936p = Collections.unmodifiableList(this.f23936p);
                this.f23933m &= -5;
            }
            c11693r.typeParameter_ = this.f23936p;
            if ((i & 8) == 8) {
                i2 |= 4;
            }
            c11693r.underlyingType_ = this.f23937q;
            if ((i & 16) == 16) {
                i2 |= 8;
            }
            c11693r.underlyingTypeId_ = this.f23938r;
            if ((i & 32) == 32) {
                i2 |= 16;
            }
            c11693r.expandedType_ = this.f23939s;
            if ((i & 64) == 64) {
                i2 |= 32;
            }
            c11693r.expandedTypeId_ = this.f23940t;
            if ((this.f23933m & 128) == 128) {
                this.f23941u = Collections.unmodifiableList(this.f23941u);
                this.f23933m &= -129;
            }
            c11693r.annotation_ = this.f23941u;
            if ((this.f23933m & 256) == 256) {
                this.f23942v = Collections.unmodifiableList(this.f23942v);
                this.f23933m &= -257;
            }
            c11693r.versionRequirement_ = this.f23942v;
            c11693r.bitField0_ = i2;
            return c11693r;
        }

        public b mergeExpandedType(C11692q c11692q) {
            if ((this.f23933m & 32) != 32 || this.f23939s == C11692q.getDefaultInstance()) {
                this.f23939s = c11692q;
            } else {
                this.f23939s = C11692q.newBuilder(this.f23939s).mergeFrom(c11692q).buildPartial();
            }
            this.f23933m |= 32;
            return this;
        }

        public b mergeUnderlyingType(C11692q c11692q) {
            if ((this.f23933m & 8) != 8 || this.f23937q == C11692q.getDefaultInstance()) {
                this.f23937q = c11692q;
            } else {
                this.f23937q = C11692q.newBuilder(this.f23937q).mergeFrom(c11692q).buildPartial();
            }
            this.f23933m |= 8;
            return this;
        }

        public b setExpandedTypeId(int i) {
            this.f23933m |= 64;
            this.f23940t = i;
            return this;
        }

        public b setFlags(int i) {
            this.f23933m |= 1;
            this.f23934n = i;
            return this;
        }

        public b setName(int i) {
            this.f23933m |= 2;
            this.f23935o = i;
            return this;
        }

        public b setUnderlyingTypeId(int i) {
            this.f23933m |= 16;
            this.f23938r = i;
            return this;
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.InterfaceC11734n.a
        public C11693r build() {
            C11693r c11693rBuildPartial = buildPartial();
            if (c11693rBuildPartial.isInitialized()) {
                return c11693rBuildPartial;
            }
            throw new UninitializedMessageException(c11693rBuildPartial);
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.AbstractC11727g.b
        /* JADX INFO: renamed from: clone */
        public b mo11465clone() {
            return new b().mergeFrom(buildPartial());
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.AbstractC11727g.b
        public b mergeFrom(C11693r c11693r) {
            if (c11693r == C11693r.getDefaultInstance()) {
                return this;
            }
            if (c11693r.hasFlags()) {
                setFlags(c11693r.getFlags());
            }
            if (c11693r.hasName()) {
                setName(c11693r.getName());
            }
            if (!c11693r.typeParameter_.isEmpty()) {
                if (this.f23936p.isEmpty()) {
                    this.f23936p = c11693r.typeParameter_;
                    this.f23933m &= -5;
                } else {
                    if ((this.f23933m & 4) != 4) {
                        this.f23936p = new ArrayList(this.f23936p);
                        this.f23933m |= 4;
                    }
                    this.f23936p.addAll(c11693r.typeParameter_);
                }
            }
            if (c11693r.hasUnderlyingType()) {
                mergeUnderlyingType(c11693r.getUnderlyingType());
            }
            if (c11693r.hasUnderlyingTypeId()) {
                setUnderlyingTypeId(c11693r.getUnderlyingTypeId());
            }
            if (c11693r.hasExpandedType()) {
                mergeExpandedType(c11693r.getExpandedType());
            }
            if (c11693r.hasExpandedTypeId()) {
                setExpandedTypeId(c11693r.getExpandedTypeId());
            }
            if (!c11693r.annotation_.isEmpty()) {
                if (this.f23941u.isEmpty()) {
                    this.f23941u = c11693r.annotation_;
                    this.f23933m &= -129;
                } else {
                    if ((this.f23933m & 128) != 128) {
                        this.f23941u = new ArrayList(this.f23941u);
                        this.f23933m |= 128;
                    }
                    this.f23941u.addAll(c11693r.annotation_);
                }
            }
            if (!c11693r.versionRequirement_.isEmpty()) {
                if (this.f23942v.isEmpty()) {
                    this.f23942v = c11693r.versionRequirement_;
                    this.f23933m &= -257;
                } else {
                    if ((this.f23933m & 256) != 256) {
                        this.f23942v = new ArrayList(this.f23942v);
                        this.f23933m |= 256;
                    }
                    this.f23942v.addAll(c11693r.versionRequirement_);
                }
            }
            m9846b(c11693r);
            setUnknownFields(getUnknownFields().concat(c11693r.unknownFields));
            return this;
        }

        /* JADX WARN: Code duplicated, block: B:15:0x001d  */
        @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.AbstractC11721a.a, p507d0.p513e0.p514p.p515d.p517m0.p550i.InterfaceC11734n.a
        public b mergeFrom(C11724d c11724d, C11725e c11725e) throws Throwable {
            C11693r c11693r = null;
            try {
                try {
                    C11693r partialFrom = C11693r.f23932k.parsePartialFrom(c11724d, c11725e);
                    if (partialFrom != null) {
                        mergeFrom(partialFrom);
                    }
                    return this;
                } catch (InvalidProtocolBufferException e) {
                    C11693r c11693r2 = (C11693r) e.getUnfinishedMessage();
                    try {
                        throw e;
                    } catch (Throwable th) {
                        th = th;
                        c11693r = c11693r2;
                        if (c11693r != null) {
                            mergeFrom(c11693r);
                        }
                        throw th;
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                if (c11693r != null) {
                    mergeFrom(c11693r);
                }
                throw th;
            }
        }
    }

    static {
        C11693r c11693r = new C11693r();
        f23931j = c11693r;
        c11693r.m9776v();
    }

    public C11693r(AbstractC11727g.c cVar, C11666a c11666a) {
        super(cVar);
        this.memoizedIsInitialized = (byte) -1;
        this.memoizedSerializedSize = -1;
        this.unknownFields = cVar.getUnknownFields();
    }

    public static C11693r getDefaultInstance() {
        return f23931j;
    }

    public static b newBuilder(C11693r c11693r) {
        return newBuilder().mergeFrom(c11693r);
    }

    public static C11693r parseDelimitedFrom(InputStream inputStream, C11725e c11725e) throws IOException {
        return (C11693r) ((AbstractC11722b) f23932k).m11466parseDelimitedFrom(inputStream, c11725e);
    }

    public C11677b getAnnotation(int i) {
        return this.annotation_.get(i);
    }

    public int getAnnotationCount() {
        return this.annotation_.size();
    }

    public List<C11677b> getAnnotationList() {
        return this.annotation_;
    }

    public C11692q getExpandedType() {
        return this.expandedType_;
    }

    public int getExpandedTypeId() {
        return this.expandedTypeId_;
    }

    public int getFlags() {
        return this.flags_;
    }

    public int getName() {
        return this.name_;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.InterfaceC11734n
    public int getSerializedSize() {
        int i = this.memoizedSerializedSize;
        if (i != -1) {
            return i;
        }
        int iComputeInt32Size = (this.bitField0_ & 1) == 1 ? CodedOutputStream.computeInt32Size(1, this.flags_) + 0 : 0;
        if ((this.bitField0_ & 2) == 2) {
            iComputeInt32Size += CodedOutputStream.computeInt32Size(2, this.name_);
        }
        for (int i2 = 0; i2 < this.typeParameter_.size(); i2++) {
            iComputeInt32Size += CodedOutputStream.computeMessageSize(3, this.typeParameter_.get(i2));
        }
        if ((this.bitField0_ & 4) == 4) {
            iComputeInt32Size += CodedOutputStream.computeMessageSize(4, this.underlyingType_);
        }
        if ((this.bitField0_ & 8) == 8) {
            iComputeInt32Size += CodedOutputStream.computeInt32Size(5, this.underlyingTypeId_);
        }
        if ((this.bitField0_ & 16) == 16) {
            iComputeInt32Size += CodedOutputStream.computeMessageSize(6, this.expandedType_);
        }
        if ((this.bitField0_ & 32) == 32) {
            iComputeInt32Size += CodedOutputStream.computeInt32Size(7, this.expandedTypeId_);
        }
        for (int i3 = 0; i3 < this.annotation_.size(); i3++) {
            iComputeInt32Size += CodedOutputStream.computeMessageSize(8, this.annotation_.get(i3));
        }
        int iComputeInt32SizeNoTag = 0;
        for (int i4 = 0; i4 < this.versionRequirement_.size(); i4++) {
            iComputeInt32SizeNoTag += CodedOutputStream.computeInt32SizeNoTag(this.versionRequirement_.get(i4).intValue());
        }
        int size = this.unknownFields.size() + m9849c() + (getVersionRequirementList().size() * 2) + iComputeInt32Size + iComputeInt32SizeNoTag;
        this.memoizedSerializedSize = size;
        return size;
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

    public C11692q getUnderlyingType() {
        return this.underlyingType_;
    }

    public int getUnderlyingTypeId() {
        return this.underlyingTypeId_;
    }

    public List<Integer> getVersionRequirementList() {
        return this.versionRequirement_;
    }

    public boolean hasExpandedType() {
        return (this.bitField0_ & 16) == 16;
    }

    public boolean hasExpandedTypeId() {
        return (this.bitField0_ & 32) == 32;
    }

    public boolean hasFlags() {
        return (this.bitField0_ & 1) == 1;
    }

    public boolean hasName() {
        return (this.bitField0_ & 2) == 2;
    }

    public boolean hasUnderlyingType() {
        return (this.bitField0_ & 4) == 4;
    }

    public boolean hasUnderlyingTypeId() {
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
        if (!hasName()) {
            this.memoizedIsInitialized = (byte) 0;
            return false;
        }
        for (int i = 0; i < getTypeParameterCount(); i++) {
            if (!getTypeParameter(i).isInitialized()) {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            }
        }
        if (hasUnderlyingType() && !getUnderlyingType().isInitialized()) {
            this.memoizedIsInitialized = (byte) 0;
            return false;
        }
        if (hasExpandedType() && !getExpandedType().isInitialized()) {
            this.memoizedIsInitialized = (byte) 0;
            return false;
        }
        for (int i2 = 0; i2 < getAnnotationCount(); i2++) {
            if (!getAnnotation(i2).isInitialized()) {
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

    /* JADX INFO: renamed from: v */
    public final void m9776v() {
        this.flags_ = 6;
        this.name_ = 0;
        this.typeParameter_ = Collections.emptyList();
        this.underlyingType_ = C11692q.getDefaultInstance();
        this.underlyingTypeId_ = 0;
        this.expandedType_ = C11692q.getDefaultInstance();
        this.expandedTypeId_ = 0;
        this.annotation_ = Collections.emptyList();
        this.versionRequirement_ = Collections.emptyList();
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.InterfaceC11734n
    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        getSerializedSize();
        AbstractC11727g.d<MessageType>.a aVarM9851e = m9851e();
        if ((this.bitField0_ & 1) == 1) {
            codedOutputStream.writeInt32(1, this.flags_);
        }
        if ((this.bitField0_ & 2) == 2) {
            codedOutputStream.writeInt32(2, this.name_);
        }
        for (int i = 0; i < this.typeParameter_.size(); i++) {
            codedOutputStream.writeMessage(3, this.typeParameter_.get(i));
        }
        if ((this.bitField0_ & 4) == 4) {
            codedOutputStream.writeMessage(4, this.underlyingType_);
        }
        if ((this.bitField0_ & 8) == 8) {
            codedOutputStream.writeInt32(5, this.underlyingTypeId_);
        }
        if ((this.bitField0_ & 16) == 16) {
            codedOutputStream.writeMessage(6, this.expandedType_);
        }
        if ((this.bitField0_ & 32) == 32) {
            codedOutputStream.writeInt32(7, this.expandedTypeId_);
        }
        for (int i2 = 0; i2 < this.annotation_.size(); i2++) {
            codedOutputStream.writeMessage(8, this.annotation_.get(i2));
        }
        for (int i3 = 0; i3 < this.versionRequirement_.size(); i3++) {
            codedOutputStream.writeInt32(31, this.versionRequirement_.get(i3).intValue());
        }
        aVarM9851e.writeUntil(200, codedOutputStream);
        codedOutputStream.writeRawBytes(this.unknownFields);
    }

    public static b newBuilder() {
        return new b();
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.InterfaceC11735o
    public C11693r getDefaultInstanceForType() {
        return f23931j;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.InterfaceC11734n
    public b newBuilderForType() {
        return newBuilder();
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.InterfaceC11734n
    public b toBuilder() {
        return newBuilder(this);
    }

    public C11693r() {
        this.memoizedIsInitialized = (byte) -1;
        this.memoizedSerializedSize = -1;
        this.unknownFields = AbstractC11723c.f24100j;
    }

    public C11693r(C11724d c11724d, C11725e c11725e, C11666a c11666a) throws InvalidProtocolBufferException {
        C11692q.c builder;
        this.memoizedIsInitialized = (byte) -1;
        this.memoizedSerializedSize = -1;
        m9776v();
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
                            this.bitField0_ |= 1;
                            this.flags_ = c11724d.readInt32();
                            continue;
                        case 16:
                            this.bitField0_ |= 2;
                            this.name_ = c11724d.readInt32();
                            continue;
                        case 26:
                            if ((i & 4) != 4) {
                                this.typeParameter_ = new ArrayList();
                                i |= 4;
                            }
                            this.typeParameter_.add((C11694s) c11724d.readMessage(C11694s.f23944k, c11725e));
                            continue;
                        case 34:
                            builder = (this.bitField0_ & 4) == 4 ? this.underlyingType_.toBuilder() : null;
                            C11692q c11692q = (C11692q) c11724d.readMessage(C11692q.f23904k, c11725e);
                            this.underlyingType_ = c11692q;
                            if (builder != null) {
                                builder.mergeFrom(c11692q);
                                this.underlyingType_ = builder.buildPartial();
                            }
                            this.bitField0_ |= 4;
                            continue;
                        case 40:
                            this.bitField0_ |= 8;
                            this.underlyingTypeId_ = c11724d.readInt32();
                            continue;
                        case 50:
                            builder = (this.bitField0_ & 16) == 16 ? this.expandedType_.toBuilder() : null;
                            C11692q c11692q2 = (C11692q) c11724d.readMessage(C11692q.f23904k, c11725e);
                            this.expandedType_ = c11692q2;
                            if (builder != null) {
                                builder.mergeFrom(c11692q2);
                                this.expandedType_ = builder.buildPartial();
                            }
                            this.bitField0_ |= 16;
                            continue;
                        case 56:
                            this.bitField0_ |= 32;
                            this.expandedTypeId_ = c11724d.readInt32();
                            continue;
                        case 66:
                            if ((i & 128) != 128) {
                                this.annotation_ = new ArrayList();
                                i |= 128;
                            }
                            this.annotation_.add((C11677b) c11724d.readMessage(C11677b.f23723k, c11725e));
                            continue;
                        case 248:
                            if ((i & 256) != 256) {
                                this.versionRequirement_ = new ArrayList();
                                i |= 256;
                            }
                            this.versionRequirement_.add(Integer.valueOf(c11724d.readInt32()));
                            continue;
                        case 250:
                            int iPushLimit = c11724d.pushLimit(c11724d.readRawVarint32());
                            if ((i & 256) != 256 && c11724d.getBytesUntilLimit() > 0) {
                                this.versionRequirement_ = new ArrayList();
                                i |= 256;
                            }
                            while (c11724d.getBytesUntilLimit() > 0) {
                                this.versionRequirement_.add(Integer.valueOf(c11724d.readInt32()));
                            }
                            c11724d.popLimit(iPushLimit);
                            continue;
                        default:
                            if (!m9852f(c11724d, codedOutputStreamNewInstance, c11725e, tag)) {
                                break;
                            }
                            break;
                    }
                    z2 = true;
                } catch (Throwable th) {
                    if ((i & 4) == 4) {
                        this.typeParameter_ = Collections.unmodifiableList(this.typeParameter_);
                    }
                    if ((i & 128) == 128) {
                        this.annotation_ = Collections.unmodifiableList(this.annotation_);
                    }
                    if ((i & 256) == 256) {
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
        if ((i & 4) == 4) {
            this.typeParameter_ = Collections.unmodifiableList(this.typeParameter_);
        }
        if ((i & 128) == 128) {
            this.annotation_ = Collections.unmodifiableList(this.annotation_);
        }
        if ((i & 256) == 256) {
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
