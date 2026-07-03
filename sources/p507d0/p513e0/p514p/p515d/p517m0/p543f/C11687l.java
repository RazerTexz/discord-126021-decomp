package p507d0.p513e0.p514p.p515d.p517m0.p543f;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.protobuf.CodedOutputStream;
import kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException;
import kotlin.reflect.jvm.internal.impl.protobuf.UninitializedMessageException;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.C11695t;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.C11698w;
import p507d0.p513e0.p514p.p515d.p517m0.p550i.AbstractC11722b;
import p507d0.p513e0.p514p.p515d.p517m0.p550i.AbstractC11723c;
import p507d0.p513e0.p514p.p515d.p517m0.p550i.AbstractC11727g;
import p507d0.p513e0.p514p.p515d.p517m0.p550i.C11724d;
import p507d0.p513e0.p514p.p515d.p517m0.p550i.C11725e;
import p507d0.p513e0.p514p.p515d.p517m0.p550i.InterfaceC11735o;
import p507d0.p513e0.p514p.p515d.p517m0.p550i.InterfaceC11736p;

/* JADX INFO: renamed from: d0.e0.p.d.m0.f.l */
/* JADX INFO: compiled from: ProtoBuf.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C11687l extends AbstractC11727g.d<C11687l> implements InterfaceC11735o {

    /* JADX INFO: renamed from: j */
    public static final C11687l f23855j;

    /* JADX INFO: renamed from: k */
    public static InterfaceC11736p<C11687l> f23856k = new a();
    private int bitField0_;
    private List<C11684i> function_;
    private byte memoizedIsInitialized;
    private int memoizedSerializedSize;
    private List<C11689n> property_;
    private List<C11693r> typeAlias_;
    private C11695t typeTable_;
    private final AbstractC11723c unknownFields;
    private C11698w versionRequirementTable_;

    /* JADX INFO: renamed from: d0.e0.p.d.m0.f.l$a */
    /* JADX INFO: compiled from: ProtoBuf.java */
    public static class a extends AbstractC11722b<C11687l> {
        @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.InterfaceC11736p
        public C11687l parsePartialFrom(C11724d c11724d, C11725e c11725e) throws InvalidProtocolBufferException {
            return new C11687l(c11724d, c11725e, null);
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.f.l$b */
    /* JADX INFO: compiled from: ProtoBuf.java */
    public static final class b extends AbstractC11727g.c<C11687l, b> implements InterfaceC11735o {

        /* JADX INFO: renamed from: m */
        public int f23857m;

        /* JADX INFO: renamed from: n */
        public List<C11684i> f23858n = Collections.emptyList();

        /* JADX INFO: renamed from: o */
        public List<C11689n> f23859o = Collections.emptyList();

        /* JADX INFO: renamed from: p */
        public List<C11693r> f23860p = Collections.emptyList();

        /* JADX INFO: renamed from: q */
        public C11695t f23861q = C11695t.getDefaultInstance();

        /* JADX INFO: renamed from: r */
        public C11698w f23862r = C11698w.getDefaultInstance();

        public C11687l buildPartial() {
            C11687l c11687l = new C11687l(this, null);
            int i = this.f23857m;
            if ((i & 1) == 1) {
                this.f23858n = Collections.unmodifiableList(this.f23858n);
                this.f23857m &= -2;
            }
            c11687l.function_ = this.f23858n;
            if ((this.f23857m & 2) == 2) {
                this.f23859o = Collections.unmodifiableList(this.f23859o);
                this.f23857m &= -3;
            }
            c11687l.property_ = this.f23859o;
            if ((this.f23857m & 4) == 4) {
                this.f23860p = Collections.unmodifiableList(this.f23860p);
                this.f23857m &= -5;
            }
            c11687l.typeAlias_ = this.f23860p;
            int i2 = (i & 8) != 8 ? 0 : 1;
            c11687l.typeTable_ = this.f23861q;
            if ((i & 16) == 16) {
                i2 |= 2;
            }
            c11687l.versionRequirementTable_ = this.f23862r;
            c11687l.bitField0_ = i2;
            return c11687l;
        }

        public b mergeTypeTable(C11695t c11695t) {
            if ((this.f23857m & 8) != 8 || this.f23861q == C11695t.getDefaultInstance()) {
                this.f23861q = c11695t;
            } else {
                this.f23861q = C11695t.newBuilder(this.f23861q).mergeFrom(c11695t).buildPartial();
            }
            this.f23857m |= 8;
            return this;
        }

        public b mergeVersionRequirementTable(C11698w c11698w) {
            if ((this.f23857m & 16) != 16 || this.f23862r == C11698w.getDefaultInstance()) {
                this.f23862r = c11698w;
            } else {
                this.f23862r = C11698w.newBuilder(this.f23862r).mergeFrom(c11698w).buildPartial();
            }
            this.f23857m |= 16;
            return this;
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.InterfaceC11734n.a
        public C11687l build() {
            C11687l c11687lBuildPartial = buildPartial();
            if (c11687lBuildPartial.isInitialized()) {
                return c11687lBuildPartial;
            }
            throw new UninitializedMessageException(c11687lBuildPartial);
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.AbstractC11727g.b
        /* JADX INFO: renamed from: clone */
        public b mo11465clone() {
            return new b().mergeFrom(buildPartial());
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.AbstractC11727g.b
        public b mergeFrom(C11687l c11687l) {
            if (c11687l == C11687l.getDefaultInstance()) {
                return this;
            }
            if (!c11687l.function_.isEmpty()) {
                if (this.f23858n.isEmpty()) {
                    this.f23858n = c11687l.function_;
                    this.f23857m &= -2;
                } else {
                    if ((this.f23857m & 1) != 1) {
                        this.f23858n = new ArrayList(this.f23858n);
                        this.f23857m |= 1;
                    }
                    this.f23858n.addAll(c11687l.function_);
                }
            }
            if (!c11687l.property_.isEmpty()) {
                if (this.f23859o.isEmpty()) {
                    this.f23859o = c11687l.property_;
                    this.f23857m &= -3;
                } else {
                    if ((this.f23857m & 2) != 2) {
                        this.f23859o = new ArrayList(this.f23859o);
                        this.f23857m |= 2;
                    }
                    this.f23859o.addAll(c11687l.property_);
                }
            }
            if (!c11687l.typeAlias_.isEmpty()) {
                if (this.f23860p.isEmpty()) {
                    this.f23860p = c11687l.typeAlias_;
                    this.f23857m &= -5;
                } else {
                    if ((this.f23857m & 4) != 4) {
                        this.f23860p = new ArrayList(this.f23860p);
                        this.f23857m |= 4;
                    }
                    this.f23860p.addAll(c11687l.typeAlias_);
                }
            }
            if (c11687l.hasTypeTable()) {
                mergeTypeTable(c11687l.getTypeTable());
            }
            if (c11687l.hasVersionRequirementTable()) {
                mergeVersionRequirementTable(c11687l.getVersionRequirementTable());
            }
            m9846b(c11687l);
            setUnknownFields(getUnknownFields().concat(c11687l.unknownFields));
            return this;
        }

        /* JADX WARN: Code duplicated, block: B:15:0x001d  */
        @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.AbstractC11721a.a, p507d0.p513e0.p514p.p515d.p517m0.p550i.InterfaceC11734n.a
        public b mergeFrom(C11724d c11724d, C11725e c11725e) throws Throwable {
            C11687l c11687l = null;
            try {
                try {
                    C11687l partialFrom = C11687l.f23856k.parsePartialFrom(c11724d, c11725e);
                    if (partialFrom != null) {
                        mergeFrom(partialFrom);
                    }
                    return this;
                } catch (InvalidProtocolBufferException e) {
                    C11687l c11687l2 = (C11687l) e.getUnfinishedMessage();
                    try {
                        throw e;
                    } catch (Throwable th) {
                        th = th;
                        c11687l = c11687l2;
                        if (c11687l != null) {
                            mergeFrom(c11687l);
                        }
                        throw th;
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                if (c11687l != null) {
                    mergeFrom(c11687l);
                }
                throw th;
            }
        }
    }

    static {
        C11687l c11687l = new C11687l();
        f23855j = c11687l;
        c11687l.m9702r();
    }

    public C11687l(AbstractC11727g.c cVar, C11666a c11666a) {
        super(cVar);
        this.memoizedIsInitialized = (byte) -1;
        this.memoizedSerializedSize = -1;
        this.unknownFields = cVar.getUnknownFields();
    }

    public static C11687l getDefaultInstance() {
        return f23855j;
    }

    public static b newBuilder(C11687l c11687l) {
        return newBuilder().mergeFrom(c11687l);
    }

    public static C11687l parseFrom(InputStream inputStream, C11725e c11725e) throws IOException {
        return (C11687l) ((AbstractC11722b) f23856k).m11467parseFrom(inputStream, c11725e);
    }

    public C11684i getFunction(int i) {
        return this.function_.get(i);
    }

    public int getFunctionCount() {
        return this.function_.size();
    }

    public List<C11684i> getFunctionList() {
        return this.function_;
    }

    public C11689n getProperty(int i) {
        return this.property_.get(i);
    }

    public int getPropertyCount() {
        return this.property_.size();
    }

    public List<C11689n> getPropertyList() {
        return this.property_;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.InterfaceC11734n
    public int getSerializedSize() {
        int i = this.memoizedSerializedSize;
        if (i != -1) {
            return i;
        }
        int iComputeMessageSize = 0;
        for (int i2 = 0; i2 < this.function_.size(); i2++) {
            iComputeMessageSize += CodedOutputStream.computeMessageSize(3, this.function_.get(i2));
        }
        for (int i3 = 0; i3 < this.property_.size(); i3++) {
            iComputeMessageSize += CodedOutputStream.computeMessageSize(4, this.property_.get(i3));
        }
        for (int i4 = 0; i4 < this.typeAlias_.size(); i4++) {
            iComputeMessageSize += CodedOutputStream.computeMessageSize(5, this.typeAlias_.get(i4));
        }
        if ((this.bitField0_ & 1) == 1) {
            iComputeMessageSize += CodedOutputStream.computeMessageSize(30, this.typeTable_);
        }
        if ((this.bitField0_ & 2) == 2) {
            iComputeMessageSize += CodedOutputStream.computeMessageSize(32, this.versionRequirementTable_);
        }
        int size = this.unknownFields.size() + m9849c() + iComputeMessageSize;
        this.memoizedSerializedSize = size;
        return size;
    }

    public C11693r getTypeAlias(int i) {
        return this.typeAlias_.get(i);
    }

    public int getTypeAliasCount() {
        return this.typeAlias_.size();
    }

    public List<C11693r> getTypeAliasList() {
        return this.typeAlias_;
    }

    public C11695t getTypeTable() {
        return this.typeTable_;
    }

    public C11698w getVersionRequirementTable() {
        return this.versionRequirementTable_;
    }

    public boolean hasTypeTable() {
        return (this.bitField0_ & 1) == 1;
    }

    public boolean hasVersionRequirementTable() {
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
        for (int i = 0; i < getFunctionCount(); i++) {
            if (!getFunction(i).isInitialized()) {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            }
        }
        for (int i2 = 0; i2 < getPropertyCount(); i2++) {
            if (!getProperty(i2).isInitialized()) {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            }
        }
        for (int i3 = 0; i3 < getTypeAliasCount(); i3++) {
            if (!getTypeAlias(i3).isInitialized()) {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            }
        }
        if (hasTypeTable() && !getTypeTable().isInitialized()) {
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

    /* JADX INFO: renamed from: r */
    public final void m9702r() {
        this.function_ = Collections.emptyList();
        this.property_ = Collections.emptyList();
        this.typeAlias_ = Collections.emptyList();
        this.typeTable_ = C11695t.getDefaultInstance();
        this.versionRequirementTable_ = C11698w.getDefaultInstance();
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.InterfaceC11734n
    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        getSerializedSize();
        AbstractC11727g.d<MessageType>.a aVarM9851e = m9851e();
        for (int i = 0; i < this.function_.size(); i++) {
            codedOutputStream.writeMessage(3, this.function_.get(i));
        }
        for (int i2 = 0; i2 < this.property_.size(); i2++) {
            codedOutputStream.writeMessage(4, this.property_.get(i2));
        }
        for (int i3 = 0; i3 < this.typeAlias_.size(); i3++) {
            codedOutputStream.writeMessage(5, this.typeAlias_.get(i3));
        }
        if ((this.bitField0_ & 1) == 1) {
            codedOutputStream.writeMessage(30, this.typeTable_);
        }
        if ((this.bitField0_ & 2) == 2) {
            codedOutputStream.writeMessage(32, this.versionRequirementTable_);
        }
        aVarM9851e.writeUntil(200, codedOutputStream);
        codedOutputStream.writeRawBytes(this.unknownFields);
    }

    public static b newBuilder() {
        return new b();
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.InterfaceC11735o
    public C11687l getDefaultInstanceForType() {
        return f23855j;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.InterfaceC11734n
    public b newBuilderForType() {
        return newBuilder();
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.InterfaceC11734n
    public b toBuilder() {
        return newBuilder(this);
    }

    public C11687l() {
        this.memoizedIsInitialized = (byte) -1;
        this.memoizedSerializedSize = -1;
        this.unknownFields = AbstractC11723c.f24100j;
    }

    public C11687l(C11724d c11724d, C11725e c11725e, C11666a c11666a) throws InvalidProtocolBufferException {
        this.memoizedIsInitialized = (byte) -1;
        this.memoizedSerializedSize = -1;
        m9702r();
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
                            if (tag == 26) {
                                if ((i & 1) != 1) {
                                    this.function_ = new ArrayList();
                                    i |= 1;
                                }
                                this.function_.add((C11684i) c11724d.readMessage(C11684i.f23831k, c11725e));
                            } else if (tag == 34) {
                                if ((i & 2) != 2) {
                                    this.property_ = new ArrayList();
                                    i |= 2;
                                }
                                this.property_.add((C11689n) c11724d.readMessage(C11689n.f23871k, c11725e));
                            } else if (tag != 42) {
                                if (tag == 242) {
                                    C11695t.b builder = (this.bitField0_ & 1) == 1 ? this.typeTable_.toBuilder() : null;
                                    C11695t c11695t = (C11695t) c11724d.readMessage(C11695t.f23957k, c11725e);
                                    this.typeTable_ = c11695t;
                                    if (builder != null) {
                                        builder.mergeFrom(c11695t);
                                        this.typeTable_ = builder.buildPartial();
                                    }
                                    this.bitField0_ |= 1;
                                } else if (tag != 258) {
                                    if (!m9852f(c11724d, codedOutputStreamNewInstance, c11725e, tag)) {
                                    }
                                } else {
                                    C11698w.b builder2 = (this.bitField0_ & 2) == 2 ? this.versionRequirementTable_.toBuilder() : null;
                                    C11698w c11698w = (C11698w) c11724d.readMessage(C11698w.f23988k, c11725e);
                                    this.versionRequirementTable_ = c11698w;
                                    if (builder2 != null) {
                                        builder2.mergeFrom(c11698w);
                                        this.versionRequirementTable_ = builder2.buildPartial();
                                    }
                                    this.bitField0_ |= 2;
                                }
                            } else {
                                if ((i & 4) != 4) {
                                    this.typeAlias_ = new ArrayList();
                                    i |= 4;
                                }
                                this.typeAlias_.add((C11693r) c11724d.readMessage(C11693r.f23932k, c11725e));
                            }
                        }
                        z2 = true;
                    } catch (InvalidProtocolBufferException e) {
                        throw e.setUnfinishedMessage(this);
                    }
                } catch (IOException e2) {
                    throw new InvalidProtocolBufferException(e2.getMessage()).setUnfinishedMessage(this);
                }
            } catch (Throwable th) {
                if ((i & 1) == 1) {
                    this.function_ = Collections.unmodifiableList(this.function_);
                }
                if ((i & 2) == 2) {
                    this.property_ = Collections.unmodifiableList(this.property_);
                }
                if ((i & 4) == 4) {
                    this.typeAlias_ = Collections.unmodifiableList(this.typeAlias_);
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
        if ((i & 1) == 1) {
            this.function_ = Collections.unmodifiableList(this.function_);
        }
        if ((i & 2) == 2) {
            this.property_ = Collections.unmodifiableList(this.property_);
        }
        if ((i & 4) == 4) {
            this.typeAlias_ = Collections.unmodifiableList(this.typeAlias_);
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
