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

/* JADX INFO: renamed from: d0.e0.p.d.m0.f.q */
/* JADX INFO: compiled from: ProtoBuf.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C11692q extends AbstractC11727g.d<C11692q> implements InterfaceC11735o {

    /* JADX INFO: renamed from: j */
    public static final C11692q f23903j;

    /* JADX INFO: renamed from: k */
    public static InterfaceC11736p<C11692q> f23904k = new a();
    private int abbreviatedTypeId_;
    private C11692q abbreviatedType_;
    private List<b> argument_;
    private int bitField0_;
    private int className_;
    private int flags_;
    private int flexibleTypeCapabilitiesId_;
    private int flexibleUpperBoundId_;
    private C11692q flexibleUpperBound_;
    private byte memoizedIsInitialized;
    private int memoizedSerializedSize;
    private boolean nullable_;
    private int outerTypeId_;
    private C11692q outerType_;
    private int typeAliasName_;
    private int typeParameterName_;
    private int typeParameter_;
    private final AbstractC11723c unknownFields;

    /* JADX INFO: renamed from: d0.e0.p.d.m0.f.q$a */
    /* JADX INFO: compiled from: ProtoBuf.java */
    public static class a extends AbstractC11722b<C11692q> {
        @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.InterfaceC11736p
        public C11692q parsePartialFrom(C11724d c11724d, C11725e c11725e) throws InvalidProtocolBufferException {
            return new C11692q(c11724d, c11725e, null);
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.f.q$b */
    /* JADX INFO: compiled from: ProtoBuf.java */
    public static final class b extends AbstractC11727g implements InterfaceC11735o {

        /* JADX INFO: renamed from: j */
        public static final b f23905j;

        /* JADX INFO: renamed from: k */
        public static InterfaceC11736p<b> f23906k = new a();
        private int bitField0_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private c projection_;
        private int typeId_;
        private C11692q type_;
        private final AbstractC11723c unknownFields;

        /* JADX INFO: renamed from: d0.e0.p.d.m0.f.q$b$a */
        /* JADX INFO: compiled from: ProtoBuf.java */
        public static class a extends AbstractC11722b<b> {
            @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.InterfaceC11736p
            public b parsePartialFrom(C11724d c11724d, C11725e c11725e) throws InvalidProtocolBufferException {
                return new b(c11724d, c11725e, null);
            }
        }

        /* JADX INFO: renamed from: d0.e0.p.d.m0.f.q$b$b, reason: collision with other inner class name */
        /* JADX INFO: compiled from: ProtoBuf.java */
        public static final class C13323b extends AbstractC11727g.b<b, C13323b> implements InterfaceC11735o {

            /* JADX INFO: renamed from: k */
            public int f23907k;

            /* JADX INFO: renamed from: l */
            public c f23908l = c.INV;

            /* JADX INFO: renamed from: m */
            public C11692q f23909m = C11692q.getDefaultInstance();

            /* JADX INFO: renamed from: n */
            public int f23910n;

            public b buildPartial() {
                b bVar = new b(this, null);
                int i = this.f23907k;
                int i2 = (i & 1) != 1 ? 0 : 1;
                bVar.projection_ = this.f23908l;
                if ((i & 2) == 2) {
                    i2 |= 2;
                }
                bVar.type_ = this.f23909m;
                if ((i & 4) == 4) {
                    i2 |= 4;
                }
                bVar.typeId_ = this.f23910n;
                bVar.bitField0_ = i2;
                return bVar;
            }

            public C13323b mergeType(C11692q c11692q) {
                if ((this.f23907k & 2) != 2 || this.f23909m == C11692q.getDefaultInstance()) {
                    this.f23909m = c11692q;
                } else {
                    this.f23909m = C11692q.newBuilder(this.f23909m).mergeFrom(c11692q).buildPartial();
                }
                this.f23907k |= 2;
                return this;
            }

            public C13323b setProjection(c cVar) {
                Objects.requireNonNull(cVar);
                this.f23907k |= 1;
                this.f23908l = cVar;
                return this;
            }

            public C13323b setTypeId(int i) {
                this.f23907k |= 4;
                this.f23910n = i;
                return this;
            }

            @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.InterfaceC11734n.a
            public b build() {
                b bVarBuildPartial = buildPartial();
                if (bVarBuildPartial.isInitialized()) {
                    return bVarBuildPartial;
                }
                throw new UninitializedMessageException(bVarBuildPartial);
            }

            @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.AbstractC11727g.b
            /* JADX INFO: renamed from: clone */
            public C13323b mo11465clone() {
                return new C13323b().mergeFrom(buildPartial());
            }

            @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.AbstractC11727g.b
            public C13323b mergeFrom(b bVar) {
                if (bVar == b.getDefaultInstance()) {
                    return this;
                }
                if (bVar.hasProjection()) {
                    setProjection(bVar.getProjection());
                }
                if (bVar.hasType()) {
                    mergeType(bVar.getType());
                }
                if (bVar.hasTypeId()) {
                    setTypeId(bVar.getTypeId());
                }
                setUnknownFields(getUnknownFields().concat(bVar.unknownFields));
                return this;
            }

            /* JADX WARN: Code duplicated, block: B:15:0x001d  */
            @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.AbstractC11721a.a, p507d0.p513e0.p514p.p515d.p517m0.p550i.InterfaceC11734n.a
            public C13323b mergeFrom(C11724d c11724d, C11725e c11725e) throws Throwable {
                b bVar = null;
                try {
                    try {
                        b partialFrom = b.f23906k.parsePartialFrom(c11724d, c11725e);
                        if (partialFrom != null) {
                            mergeFrom(partialFrom);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        b bVar2 = (b) e.getUnfinishedMessage();
                        try {
                            throw e;
                        } catch (Throwable th) {
                            th = th;
                            bVar = bVar2;
                            if (bVar != null) {
                                mergeFrom(bVar);
                            }
                            throw th;
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (bVar != null) {
                        mergeFrom(bVar);
                    }
                    throw th;
                }
            }
        }

        /* JADX INFO: renamed from: d0.e0.p.d.m0.f.q$b$c */
        /* JADX INFO: compiled from: ProtoBuf.java */
        public enum c implements C11728h.a {
            IN(0),
            OUT(1),
            INV(2),
            STAR(3);

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
                if (i == 2) {
                    return INV;
                }
                if (i != 3) {
                    return null;
                }
                return STAR;
            }
        }

        static {
            b bVar = new b();
            f23905j = bVar;
            bVar.projection_ = c.INV;
            bVar.type_ = C11692q.getDefaultInstance();
            bVar.typeId_ = 0;
        }

        public b(AbstractC11727g.b bVar, C11666a c11666a) {
            super(bVar);
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = bVar.getUnknownFields();
        }

        public static b getDefaultInstance() {
            return f23905j;
        }

        public static C13323b newBuilder(b bVar) {
            return newBuilder().mergeFrom(bVar);
        }

        public c getProjection() {
            return this.projection_;
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.InterfaceC11734n
        public int getSerializedSize() {
            int i = this.memoizedSerializedSize;
            if (i != -1) {
                return i;
            }
            int iComputeEnumSize = (this.bitField0_ & 1) == 1 ? 0 + CodedOutputStream.computeEnumSize(1, this.projection_.getNumber()) : 0;
            if ((this.bitField0_ & 2) == 2) {
                iComputeEnumSize += CodedOutputStream.computeMessageSize(2, this.type_);
            }
            if ((this.bitField0_ & 4) == 4) {
                iComputeEnumSize += CodedOutputStream.computeInt32Size(3, this.typeId_);
            }
            int size = this.unknownFields.size() + iComputeEnumSize;
            this.memoizedSerializedSize = size;
            return size;
        }

        public C11692q getType() {
            return this.type_;
        }

        public int getTypeId() {
            return this.typeId_;
        }

        public boolean hasProjection() {
            return (this.bitField0_ & 1) == 1;
        }

        public boolean hasType() {
            return (this.bitField0_ & 2) == 2;
        }

        public boolean hasTypeId() {
            return (this.bitField0_ & 4) == 4;
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
            if (!hasType() || getType().isInitialized()) {
                this.memoizedIsInitialized = (byte) 1;
                return true;
            }
            this.memoizedIsInitialized = (byte) 0;
            return false;
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.InterfaceC11734n
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            getSerializedSize();
            if ((this.bitField0_ & 1) == 1) {
                codedOutputStream.writeEnum(1, this.projection_.getNumber());
            }
            if ((this.bitField0_ & 2) == 2) {
                codedOutputStream.writeMessage(2, this.type_);
            }
            if ((this.bitField0_ & 4) == 4) {
                codedOutputStream.writeInt32(3, this.typeId_);
            }
            codedOutputStream.writeRawBytes(this.unknownFields);
        }

        public static C13323b newBuilder() {
            return new C13323b();
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.InterfaceC11734n
        public C13323b newBuilderForType() {
            return newBuilder();
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.InterfaceC11734n
        public C13323b toBuilder() {
            return newBuilder(this);
        }

        public b() {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = AbstractC11723c.f24100j;
        }

        public b(C11724d c11724d, C11725e c11725e, C11666a c11666a) throws InvalidProtocolBufferException {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.projection_ = c.INV;
            this.type_ = C11692q.getDefaultInstance();
            boolean z2 = false;
            this.typeId_ = 0;
            AbstractC11723c.b bVarNewOutput = AbstractC11723c.newOutput();
            CodedOutputStream codedOutputStreamNewInstance = CodedOutputStream.newInstance(bVarNewOutput, 1);
            while (!z2) {
                try {
                    try {
                        try {
                            int tag = c11724d.readTag();
                            if (tag != 0) {
                                if (tag == 8) {
                                    int i = c11724d.readEnum();
                                    c cVarValueOf = c.valueOf(i);
                                    if (cVarValueOf == null) {
                                        codedOutputStreamNewInstance.writeRawVarint32(tag);
                                        codedOutputStreamNewInstance.writeRawVarint32(i);
                                    } else {
                                        this.bitField0_ |= 1;
                                        this.projection_ = cVarValueOf;
                                    }
                                } else if (tag == 18) {
                                    c builder = (this.bitField0_ & 2) == 2 ? this.type_.toBuilder() : null;
                                    C11692q c11692q = (C11692q) c11724d.readMessage(C11692q.f23904k, c11725e);
                                    this.type_ = c11692q;
                                    if (builder != null) {
                                        builder.mergeFrom(c11692q);
                                        this.type_ = builder.buildPartial();
                                    }
                                    this.bitField0_ |= 2;
                                } else if (tag != 24) {
                                    if (!c11724d.skipField(tag, codedOutputStreamNewInstance)) {
                                    }
                                } else {
                                    this.bitField0_ |= 4;
                                    this.typeId_ = c11724d.readInt32();
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
                    try {
                        codedOutputStreamNewInstance.flush();
                    } catch (IOException unused) {
                    } finally {
                        this.unknownFields = bVarNewOutput.toByteString();
                    }
                    throw th;
                }
            }
            try {
                codedOutputStreamNewInstance.flush();
            } catch (IOException unused2) {
            } finally {
                this.unknownFields = bVarNewOutput.toByteString();
            }
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.f.q$c */
    /* JADX INFO: compiled from: ProtoBuf.java */
    public static final class c extends AbstractC11727g.c<C11692q, c> implements InterfaceC11735o {

        /* JADX INFO: renamed from: A */
        public int f23916A;

        /* JADX INFO: renamed from: m */
        public int f23917m;

        /* JADX INFO: renamed from: o */
        public boolean f23919o;

        /* JADX INFO: renamed from: p */
        public int f23920p;

        /* JADX INFO: renamed from: r */
        public int f23922r;

        /* JADX INFO: renamed from: s */
        public int f23923s;

        /* JADX INFO: renamed from: t */
        public int f23924t;

        /* JADX INFO: renamed from: u */
        public int f23925u;

        /* JADX INFO: renamed from: v */
        public int f23926v;

        /* JADX INFO: renamed from: x */
        public int f23928x;

        /* JADX INFO: renamed from: z */
        public int f23930z;

        /* JADX INFO: renamed from: n */
        public List<b> f23918n = Collections.emptyList();

        /* JADX INFO: renamed from: q */
        public C11692q f23921q = C11692q.getDefaultInstance();

        /* JADX INFO: renamed from: w */
        public C11692q f23927w = C11692q.getDefaultInstance();

        /* JADX INFO: renamed from: y */
        public C11692q f23929y = C11692q.getDefaultInstance();

        public C11692q buildPartial() {
            C11692q c11692q = new C11692q(this, null);
            int i = this.f23917m;
            if ((i & 1) == 1) {
                this.f23918n = Collections.unmodifiableList(this.f23918n);
                this.f23917m &= -2;
            }
            c11692q.argument_ = this.f23918n;
            int i2 = (i & 2) != 2 ? 0 : 1;
            c11692q.nullable_ = this.f23919o;
            if ((i & 4) == 4) {
                i2 |= 2;
            }
            c11692q.flexibleTypeCapabilitiesId_ = this.f23920p;
            if ((i & 8) == 8) {
                i2 |= 4;
            }
            c11692q.flexibleUpperBound_ = this.f23921q;
            if ((i & 16) == 16) {
                i2 |= 8;
            }
            c11692q.flexibleUpperBoundId_ = this.f23922r;
            if ((i & 32) == 32) {
                i2 |= 16;
            }
            c11692q.className_ = this.f23923s;
            if ((i & 64) == 64) {
                i2 |= 32;
            }
            c11692q.typeParameter_ = this.f23924t;
            if ((i & 128) == 128) {
                i2 |= 64;
            }
            c11692q.typeParameterName_ = this.f23925u;
            if ((i & 256) == 256) {
                i2 |= 128;
            }
            c11692q.typeAliasName_ = this.f23926v;
            if ((i & 512) == 512) {
                i2 |= 256;
            }
            c11692q.outerType_ = this.f23927w;
            if ((i & 1024) == 1024) {
                i2 |= 512;
            }
            c11692q.outerTypeId_ = this.f23928x;
            if ((i & 2048) == 2048) {
                i2 |= 1024;
            }
            c11692q.abbreviatedType_ = this.f23929y;
            if ((i & 4096) == 4096) {
                i2 |= 2048;
            }
            c11692q.abbreviatedTypeId_ = this.f23930z;
            if ((i & 8192) == 8192) {
                i2 |= 4096;
            }
            c11692q.flags_ = this.f23916A;
            c11692q.bitField0_ = i2;
            return c11692q;
        }

        public c mergeAbbreviatedType(C11692q c11692q) {
            if ((this.f23917m & 2048) != 2048 || this.f23929y == C11692q.getDefaultInstance()) {
                this.f23929y = c11692q;
            } else {
                this.f23929y = C11692q.newBuilder(this.f23929y).mergeFrom(c11692q).buildPartial();
            }
            this.f23917m |= 2048;
            return this;
        }

        public c mergeFlexibleUpperBound(C11692q c11692q) {
            if ((this.f23917m & 8) != 8 || this.f23921q == C11692q.getDefaultInstance()) {
                this.f23921q = c11692q;
            } else {
                this.f23921q = C11692q.newBuilder(this.f23921q).mergeFrom(c11692q).buildPartial();
            }
            this.f23917m |= 8;
            return this;
        }

        public c mergeOuterType(C11692q c11692q) {
            if ((this.f23917m & 512) != 512 || this.f23927w == C11692q.getDefaultInstance()) {
                this.f23927w = c11692q;
            } else {
                this.f23927w = C11692q.newBuilder(this.f23927w).mergeFrom(c11692q).buildPartial();
            }
            this.f23917m |= 512;
            return this;
        }

        public c setAbbreviatedTypeId(int i) {
            this.f23917m |= 4096;
            this.f23930z = i;
            return this;
        }

        public c setClassName(int i) {
            this.f23917m |= 32;
            this.f23923s = i;
            return this;
        }

        public c setFlags(int i) {
            this.f23917m |= 8192;
            this.f23916A = i;
            return this;
        }

        public c setFlexibleTypeCapabilitiesId(int i) {
            this.f23917m |= 4;
            this.f23920p = i;
            return this;
        }

        public c setFlexibleUpperBoundId(int i) {
            this.f23917m |= 16;
            this.f23922r = i;
            return this;
        }

        public c setNullable(boolean z2) {
            this.f23917m |= 2;
            this.f23919o = z2;
            return this;
        }

        public c setOuterTypeId(int i) {
            this.f23917m |= 1024;
            this.f23928x = i;
            return this;
        }

        public c setTypeAliasName(int i) {
            this.f23917m |= 256;
            this.f23926v = i;
            return this;
        }

        public c setTypeParameter(int i) {
            this.f23917m |= 64;
            this.f23924t = i;
            return this;
        }

        public c setTypeParameterName(int i) {
            this.f23917m |= 128;
            this.f23925u = i;
            return this;
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.InterfaceC11734n.a
        public C11692q build() {
            C11692q c11692qBuildPartial = buildPartial();
            if (c11692qBuildPartial.isInitialized()) {
                return c11692qBuildPartial;
            }
            throw new UninitializedMessageException(c11692qBuildPartial);
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.AbstractC11727g.b
        /* JADX INFO: renamed from: clone */
        public c mo11465clone() {
            return new c().mergeFrom(buildPartial());
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.AbstractC11727g.b
        public c mergeFrom(C11692q c11692q) {
            if (c11692q == C11692q.getDefaultInstance()) {
                return this;
            }
            if (!c11692q.argument_.isEmpty()) {
                if (this.f23918n.isEmpty()) {
                    this.f23918n = c11692q.argument_;
                    this.f23917m &= -2;
                } else {
                    if ((this.f23917m & 1) != 1) {
                        this.f23918n = new ArrayList(this.f23918n);
                        this.f23917m |= 1;
                    }
                    this.f23918n.addAll(c11692q.argument_);
                }
            }
            if (c11692q.hasNullable()) {
                setNullable(c11692q.getNullable());
            }
            if (c11692q.hasFlexibleTypeCapabilitiesId()) {
                setFlexibleTypeCapabilitiesId(c11692q.getFlexibleTypeCapabilitiesId());
            }
            if (c11692q.hasFlexibleUpperBound()) {
                mergeFlexibleUpperBound(c11692q.getFlexibleUpperBound());
            }
            if (c11692q.hasFlexibleUpperBoundId()) {
                setFlexibleUpperBoundId(c11692q.getFlexibleUpperBoundId());
            }
            if (c11692q.hasClassName()) {
                setClassName(c11692q.getClassName());
            }
            if (c11692q.hasTypeParameter()) {
                setTypeParameter(c11692q.getTypeParameter());
            }
            if (c11692q.hasTypeParameterName()) {
                setTypeParameterName(c11692q.getTypeParameterName());
            }
            if (c11692q.hasTypeAliasName()) {
                setTypeAliasName(c11692q.getTypeAliasName());
            }
            if (c11692q.hasOuterType()) {
                mergeOuterType(c11692q.getOuterType());
            }
            if (c11692q.hasOuterTypeId()) {
                setOuterTypeId(c11692q.getOuterTypeId());
            }
            if (c11692q.hasAbbreviatedType()) {
                mergeAbbreviatedType(c11692q.getAbbreviatedType());
            }
            if (c11692q.hasAbbreviatedTypeId()) {
                setAbbreviatedTypeId(c11692q.getAbbreviatedTypeId());
            }
            if (c11692q.hasFlags()) {
                setFlags(c11692q.getFlags());
            }
            m9846b(c11692q);
            setUnknownFields(getUnknownFields().concat(c11692q.unknownFields));
            return this;
        }

        /* JADX WARN: Code duplicated, block: B:15:0x001d  */
        @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.AbstractC11721a.a, p507d0.p513e0.p514p.p515d.p517m0.p550i.InterfaceC11734n.a
        public c mergeFrom(C11724d c11724d, C11725e c11725e) throws Throwable {
            C11692q c11692q = null;
            try {
                try {
                    C11692q partialFrom = C11692q.f23904k.parsePartialFrom(c11724d, c11725e);
                    if (partialFrom != null) {
                        mergeFrom(partialFrom);
                    }
                    return this;
                } catch (InvalidProtocolBufferException e) {
                    C11692q c11692q2 = (C11692q) e.getUnfinishedMessage();
                    try {
                        throw e;
                    } catch (Throwable th) {
                        th = th;
                        c11692q = c11692q2;
                        if (c11692q != null) {
                            mergeFrom(c11692q);
                        }
                        throw th;
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                if (c11692q != null) {
                    mergeFrom(c11692q);
                }
                throw th;
            }
        }
    }

    static {
        C11692q c11692q = new C11692q();
        f23903j = c11692q;
        c11692q.m9756y();
    }

    public C11692q(AbstractC11727g.c cVar, C11666a c11666a) {
        super(cVar);
        this.memoizedIsInitialized = (byte) -1;
        this.memoizedSerializedSize = -1;
        this.unknownFields = cVar.getUnknownFields();
    }

    public static C11692q getDefaultInstance() {
        return f23903j;
    }

    public static c newBuilder(C11692q c11692q) {
        return newBuilder().mergeFrom(c11692q);
    }

    public C11692q getAbbreviatedType() {
        return this.abbreviatedType_;
    }

    public int getAbbreviatedTypeId() {
        return this.abbreviatedTypeId_;
    }

    public b getArgument(int i) {
        return this.argument_.get(i);
    }

    public int getArgumentCount() {
        return this.argument_.size();
    }

    public List<b> getArgumentList() {
        return this.argument_;
    }

    public int getClassName() {
        return this.className_;
    }

    public int getFlags() {
        return this.flags_;
    }

    public int getFlexibleTypeCapabilitiesId() {
        return this.flexibleTypeCapabilitiesId_;
    }

    public C11692q getFlexibleUpperBound() {
        return this.flexibleUpperBound_;
    }

    public int getFlexibleUpperBoundId() {
        return this.flexibleUpperBoundId_;
    }

    public boolean getNullable() {
        return this.nullable_;
    }

    public C11692q getOuterType() {
        return this.outerType_;
    }

    public int getOuterTypeId() {
        return this.outerTypeId_;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.InterfaceC11734n
    public int getSerializedSize() {
        int i = this.memoizedSerializedSize;
        if (i != -1) {
            return i;
        }
        int iComputeInt32Size = (this.bitField0_ & 4096) == 4096 ? CodedOutputStream.computeInt32Size(1, this.flags_) + 0 : 0;
        for (int i2 = 0; i2 < this.argument_.size(); i2++) {
            iComputeInt32Size += CodedOutputStream.computeMessageSize(2, this.argument_.get(i2));
        }
        if ((this.bitField0_ & 1) == 1) {
            iComputeInt32Size += CodedOutputStream.computeBoolSize(3, this.nullable_);
        }
        if ((this.bitField0_ & 2) == 2) {
            iComputeInt32Size += CodedOutputStream.computeInt32Size(4, this.flexibleTypeCapabilitiesId_);
        }
        if ((this.bitField0_ & 4) == 4) {
            iComputeInt32Size += CodedOutputStream.computeMessageSize(5, this.flexibleUpperBound_);
        }
        if ((this.bitField0_ & 16) == 16) {
            iComputeInt32Size += CodedOutputStream.computeInt32Size(6, this.className_);
        }
        if ((this.bitField0_ & 32) == 32) {
            iComputeInt32Size += CodedOutputStream.computeInt32Size(7, this.typeParameter_);
        }
        if ((this.bitField0_ & 8) == 8) {
            iComputeInt32Size += CodedOutputStream.computeInt32Size(8, this.flexibleUpperBoundId_);
        }
        if ((this.bitField0_ & 64) == 64) {
            iComputeInt32Size += CodedOutputStream.computeInt32Size(9, this.typeParameterName_);
        }
        if ((this.bitField0_ & 256) == 256) {
            iComputeInt32Size += CodedOutputStream.computeMessageSize(10, this.outerType_);
        }
        if ((this.bitField0_ & 512) == 512) {
            iComputeInt32Size += CodedOutputStream.computeInt32Size(11, this.outerTypeId_);
        }
        if ((this.bitField0_ & 128) == 128) {
            iComputeInt32Size += CodedOutputStream.computeInt32Size(12, this.typeAliasName_);
        }
        if ((this.bitField0_ & 1024) == 1024) {
            iComputeInt32Size += CodedOutputStream.computeMessageSize(13, this.abbreviatedType_);
        }
        if ((this.bitField0_ & 2048) == 2048) {
            iComputeInt32Size += CodedOutputStream.computeInt32Size(14, this.abbreviatedTypeId_);
        }
        int size = this.unknownFields.size() + m9849c() + iComputeInt32Size;
        this.memoizedSerializedSize = size;
        return size;
    }

    public int getTypeAliasName() {
        return this.typeAliasName_;
    }

    public int getTypeParameter() {
        return this.typeParameter_;
    }

    public int getTypeParameterName() {
        return this.typeParameterName_;
    }

    public boolean hasAbbreviatedType() {
        return (this.bitField0_ & 1024) == 1024;
    }

    public boolean hasAbbreviatedTypeId() {
        return (this.bitField0_ & 2048) == 2048;
    }

    public boolean hasClassName() {
        return (this.bitField0_ & 16) == 16;
    }

    public boolean hasFlags() {
        return (this.bitField0_ & 4096) == 4096;
    }

    public boolean hasFlexibleTypeCapabilitiesId() {
        return (this.bitField0_ & 2) == 2;
    }

    public boolean hasFlexibleUpperBound() {
        return (this.bitField0_ & 4) == 4;
    }

    public boolean hasFlexibleUpperBoundId() {
        return (this.bitField0_ & 8) == 8;
    }

    public boolean hasNullable() {
        return (this.bitField0_ & 1) == 1;
    }

    public boolean hasOuterType() {
        return (this.bitField0_ & 256) == 256;
    }

    public boolean hasOuterTypeId() {
        return (this.bitField0_ & 512) == 512;
    }

    public boolean hasTypeAliasName() {
        return (this.bitField0_ & 128) == 128;
    }

    public boolean hasTypeParameter() {
        return (this.bitField0_ & 32) == 32;
    }

    public boolean hasTypeParameterName() {
        return (this.bitField0_ & 64) == 64;
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
        for (int i = 0; i < getArgumentCount(); i++) {
            if (!getArgument(i).isInitialized()) {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            }
        }
        if (hasFlexibleUpperBound() && !getFlexibleUpperBound().isInitialized()) {
            this.memoizedIsInitialized = (byte) 0;
            return false;
        }
        if (hasOuterType() && !getOuterType().isInitialized()) {
            this.memoizedIsInitialized = (byte) 0;
            return false;
        }
        if (hasAbbreviatedType() && !getAbbreviatedType().isInitialized()) {
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
        if ((this.bitField0_ & 4096) == 4096) {
            codedOutputStream.writeInt32(1, this.flags_);
        }
        for (int i = 0; i < this.argument_.size(); i++) {
            codedOutputStream.writeMessage(2, this.argument_.get(i));
        }
        if ((this.bitField0_ & 1) == 1) {
            codedOutputStream.writeBool(3, this.nullable_);
        }
        if ((this.bitField0_ & 2) == 2) {
            codedOutputStream.writeInt32(4, this.flexibleTypeCapabilitiesId_);
        }
        if ((this.bitField0_ & 4) == 4) {
            codedOutputStream.writeMessage(5, this.flexibleUpperBound_);
        }
        if ((this.bitField0_ & 16) == 16) {
            codedOutputStream.writeInt32(6, this.className_);
        }
        if ((this.bitField0_ & 32) == 32) {
            codedOutputStream.writeInt32(7, this.typeParameter_);
        }
        if ((this.bitField0_ & 8) == 8) {
            codedOutputStream.writeInt32(8, this.flexibleUpperBoundId_);
        }
        if ((this.bitField0_ & 64) == 64) {
            codedOutputStream.writeInt32(9, this.typeParameterName_);
        }
        if ((this.bitField0_ & 256) == 256) {
            codedOutputStream.writeMessage(10, this.outerType_);
        }
        if ((this.bitField0_ & 512) == 512) {
            codedOutputStream.writeInt32(11, this.outerTypeId_);
        }
        if ((this.bitField0_ & 128) == 128) {
            codedOutputStream.writeInt32(12, this.typeAliasName_);
        }
        if ((this.bitField0_ & 1024) == 1024) {
            codedOutputStream.writeMessage(13, this.abbreviatedType_);
        }
        if ((this.bitField0_ & 2048) == 2048) {
            codedOutputStream.writeInt32(14, this.abbreviatedTypeId_);
        }
        aVarM9851e.writeUntil(200, codedOutputStream);
        codedOutputStream.writeRawBytes(this.unknownFields);
    }

    /* JADX INFO: renamed from: y */
    public final void m9756y() {
        this.argument_ = Collections.emptyList();
        this.nullable_ = false;
        this.flexibleTypeCapabilitiesId_ = 0;
        this.flexibleUpperBound_ = getDefaultInstance();
        this.flexibleUpperBoundId_ = 0;
        this.className_ = 0;
        this.typeParameter_ = 0;
        this.typeParameterName_ = 0;
        this.typeAliasName_ = 0;
        this.outerType_ = getDefaultInstance();
        this.outerTypeId_ = 0;
        this.abbreviatedType_ = getDefaultInstance();
        this.abbreviatedTypeId_ = 0;
        this.flags_ = 0;
    }

    public static c newBuilder() {
        return new c();
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.InterfaceC11735o
    public C11692q getDefaultInstanceForType() {
        return f23903j;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.InterfaceC11734n
    public c newBuilderForType() {
        return newBuilder();
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.InterfaceC11734n
    public c toBuilder() {
        return newBuilder(this);
    }

    public C11692q() {
        this.memoizedIsInitialized = (byte) -1;
        this.memoizedSerializedSize = -1;
        this.unknownFields = AbstractC11723c.f24100j;
    }

    public C11692q(C11724d c11724d, C11725e c11725e, C11666a c11666a) throws InvalidProtocolBufferException {
        c builder;
        this.memoizedIsInitialized = (byte) -1;
        this.memoizedSerializedSize = -1;
        m9756y();
        AbstractC11723c.b bVarNewOutput = AbstractC11723c.newOutput();
        CodedOutputStream codedOutputStreamNewInstance = CodedOutputStream.newInstance(bVarNewOutput, 1);
        boolean z2 = false;
        boolean z3 = false;
        while (!z2) {
            try {
                try {
                    int tag = c11724d.readTag();
                    switch (tag) {
                        case 0:
                            break;
                        case 8:
                            this.bitField0_ |= 4096;
                            this.flags_ = c11724d.readInt32();
                            continue;
                        case 18:
                            if (!(z3 & true)) {
                                this.argument_ = new ArrayList();
                                z3 |= true;
                            }
                            this.argument_.add((b) c11724d.readMessage(b.f23906k, c11725e));
                            continue;
                        case 24:
                            this.bitField0_ |= 1;
                            this.nullable_ = c11724d.readBool();
                            continue;
                        case 32:
                            this.bitField0_ |= 2;
                            this.flexibleTypeCapabilitiesId_ = c11724d.readInt32();
                            continue;
                        case 42:
                            builder = (this.bitField0_ & 4) == 4 ? this.flexibleUpperBound_.toBuilder() : null;
                            C11692q c11692q = (C11692q) c11724d.readMessage(f23904k, c11725e);
                            this.flexibleUpperBound_ = c11692q;
                            if (builder != null) {
                                builder.mergeFrom(c11692q);
                                this.flexibleUpperBound_ = builder.buildPartial();
                            }
                            this.bitField0_ |= 4;
                            continue;
                        case 48:
                            this.bitField0_ |= 16;
                            this.className_ = c11724d.readInt32();
                            continue;
                        case 56:
                            this.bitField0_ |= 32;
                            this.typeParameter_ = c11724d.readInt32();
                            continue;
                        case 64:
                            this.bitField0_ |= 8;
                            this.flexibleUpperBoundId_ = c11724d.readInt32();
                            continue;
                        case 72:
                            this.bitField0_ |= 64;
                            this.typeParameterName_ = c11724d.readInt32();
                            continue;
                        case 82:
                            builder = (this.bitField0_ & 256) == 256 ? this.outerType_.toBuilder() : null;
                            C11692q c11692q2 = (C11692q) c11724d.readMessage(f23904k, c11725e);
                            this.outerType_ = c11692q2;
                            if (builder != null) {
                                builder.mergeFrom(c11692q2);
                                this.outerType_ = builder.buildPartial();
                            }
                            this.bitField0_ |= 256;
                            continue;
                        case 88:
                            this.bitField0_ |= 512;
                            this.outerTypeId_ = c11724d.readInt32();
                            continue;
                        case 96:
                            this.bitField0_ |= 128;
                            this.typeAliasName_ = c11724d.readInt32();
                            continue;
                        case 106:
                            builder = (this.bitField0_ & 1024) == 1024 ? this.abbreviatedType_.toBuilder() : null;
                            C11692q c11692q3 = (C11692q) c11724d.readMessage(f23904k, c11725e);
                            this.abbreviatedType_ = c11692q3;
                            if (builder != null) {
                                builder.mergeFrom(c11692q3);
                                this.abbreviatedType_ = builder.buildPartial();
                            }
                            this.bitField0_ |= 1024;
                            continue;
                        case 112:
                            this.bitField0_ |= 2048;
                            this.abbreviatedTypeId_ = c11724d.readInt32();
                            continue;
                        default:
                            if (!m9852f(c11724d, codedOutputStreamNewInstance, c11725e, tag)) {
                                break;
                            }
                            break;
                    }
                    z2 = true;
                } catch (InvalidProtocolBufferException e) {
                    throw e.setUnfinishedMessage(this);
                } catch (IOException e2) {
                    throw new InvalidProtocolBufferException(e2.getMessage()).setUnfinishedMessage(this);
                }
            } catch (Throwable th) {
                if (z3 & true) {
                    this.argument_ = Collections.unmodifiableList(this.argument_);
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
        if (z3 & true) {
            this.argument_ = Collections.unmodifiableList(this.argument_);
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
