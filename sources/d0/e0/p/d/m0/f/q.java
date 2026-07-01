package d0.e0.p.d.m0.f;

import d0.e0.p.d.m0.i.AbstractParser;
import d0.e0.p.d.m0.i.ByteString3;
import d0.e0.p.d.m0.i.CodedInputStream;
import d0.e0.p.d.m0.i.ExtensionRegistryLite;
import d0.e0.p.d.m0.i.GeneratedMessageLite;
import d0.e0.p.d.m0.i.Internal;
import d0.e0.p.d.m0.i.MessageLiteOrBuilder;
import d0.e0.p.d.m0.i.Parser2;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import kotlin.reflect.jvm.internal.impl.protobuf.CodedOutputStream;
import kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException;
import kotlin.reflect.jvm.internal.impl.protobuf.UninitializedMessageException;

/* JADX INFO: compiled from: ProtoBuf.java */
/* JADX INFO: loaded from: classes3.dex */
public final class q extends GeneratedMessageLite.d<q> implements MessageLiteOrBuilder {
    public static final q j;
    public static Parser2<q> k = new a();
    private int abbreviatedTypeId_;
    private q abbreviatedType_;
    private List<b> argument_;
    private int bitField0_;
    private int className_;
    private int flags_;
    private int flexibleTypeCapabilitiesId_;
    private int flexibleUpperBoundId_;
    private q flexibleUpperBound_;
    private byte memoizedIsInitialized;
    private int memoizedSerializedSize;
    private boolean nullable_;
    private int outerTypeId_;
    private q outerType_;
    private int typeAliasName_;
    private int typeParameterName_;
    private int typeParameter_;
    private final ByteString3 unknownFields;

    /* JADX INFO: compiled from: ProtoBuf.java */
    public static class a extends AbstractParser<q> {
        @Override // d0.e0.p.d.m0.i.Parser2
        public q parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return new q(codedInputStream, extensionRegistryLite, null);
        }
    }

    /* JADX INFO: compiled from: ProtoBuf.java */
    public static final class b extends GeneratedMessageLite implements MessageLiteOrBuilder {
        public static final b j;
        public static Parser2<b> k = new a();
        private int bitField0_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private c projection_;
        private int typeId_;
        private q type_;
        private final ByteString3 unknownFields;

        /* JADX INFO: compiled from: ProtoBuf.java */
        public static class a extends AbstractParser<b> {
            @Override // d0.e0.p.d.m0.i.Parser2
            public b parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new b(codedInputStream, extensionRegistryLite, null);
            }
        }

        /* JADX INFO: renamed from: d0.e0.p.d.m0.f.q$b$b, reason: collision with other inner class name */
        /* JADX INFO: compiled from: ProtoBuf.java */
        public static final class C0399b extends GeneratedMessageLite.b<b, C0399b> implements MessageLiteOrBuilder {
            public int k;
            public c l = c.INV;
            public q m = q.getDefaultInstance();
            public int n;

            public b buildPartial() {
                b bVar = new b(this, null);
                int i = this.k;
                int i2 = (i & 1) != 1 ? 0 : 1;
                bVar.projection_ = this.l;
                if ((i & 2) == 2) {
                    i2 |= 2;
                }
                bVar.type_ = this.m;
                if ((i & 4) == 4) {
                    i2 |= 4;
                }
                bVar.typeId_ = this.n;
                bVar.bitField0_ = i2;
                return bVar;
            }

            public C0399b mergeType(q qVar) {
                if ((this.k & 2) != 2 || this.m == q.getDefaultInstance()) {
                    this.m = qVar;
                } else {
                    this.m = q.newBuilder(this.m).mergeFrom(qVar).buildPartial();
                }
                this.k |= 2;
                return this;
            }

            public C0399b setProjection(c cVar) {
                Objects.requireNonNull(cVar);
                this.k |= 1;
                this.l = cVar;
                return this;
            }

            public C0399b setTypeId(int i) {
                this.k |= 4;
                this.n = i;
                return this;
            }

            @Override // d0.e0.p.d.m0.i.MessageLite.a
            public b build() {
                b bVarBuildPartial = buildPartial();
                if (bVarBuildPartial.isInitialized()) {
                    return bVarBuildPartial;
                }
                throw new UninitializedMessageException(bVarBuildPartial);
            }

            @Override // d0.e0.p.d.m0.i.GeneratedMessageLite.b
            /* JADX INFO: renamed from: clone */
            public C0399b mo88clone() {
                return new C0399b().mergeFrom(buildPartial());
            }

            @Override // d0.e0.p.d.m0.i.GeneratedMessageLite.b
            public C0399b mergeFrom(b bVar) {
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
            @Override // d0.e0.p.d.m0.i.AbstractMessageLite.a, d0.e0.p.d.m0.i.MessageLite.a
            public C0399b mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws Throwable {
                b bVar = null;
                try {
                    try {
                        b partialFrom = b.k.parsePartialFrom(codedInputStream, extensionRegistryLite);
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

        /* JADX INFO: compiled from: ProtoBuf.java */
        public enum c implements Internal.a {
            IN(0),
            OUT(1),
            INV(2),
            STAR(3);

            private final int value;

            c(int i) {
                this.value = i;
            }

            @Override // d0.e0.p.d.m0.i.Internal.a
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
            j = bVar;
            bVar.projection_ = c.INV;
            bVar.type_ = q.getDefaultInstance();
            bVar.typeId_ = 0;
        }

        public b(GeneratedMessageLite.b bVar, d0.e0.p.d.m0.f.a aVar) {
            super(bVar);
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = bVar.getUnknownFields();
        }

        public static b getDefaultInstance() {
            return j;
        }

        public static C0399b newBuilder(b bVar) {
            return newBuilder().mergeFrom(bVar);
        }

        public c getProjection() {
            return this.projection_;
        }

        @Override // d0.e0.p.d.m0.i.MessageLite
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

        public q getType() {
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

        @Override // d0.e0.p.d.m0.i.MessageLiteOrBuilder
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

        @Override // d0.e0.p.d.m0.i.MessageLite
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

        public static C0399b newBuilder() {
            return new C0399b();
        }

        @Override // d0.e0.p.d.m0.i.MessageLite
        public C0399b newBuilderForType() {
            return newBuilder();
        }

        @Override // d0.e0.p.d.m0.i.MessageLite
        public C0399b toBuilder() {
            return newBuilder(this);
        }

        public b() {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = ByteString3.j;
        }

        public b(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, d0.e0.p.d.m0.f.a aVar) throws InvalidProtocolBufferException {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.projection_ = c.INV;
            this.type_ = q.getDefaultInstance();
            boolean z2 = false;
            this.typeId_ = 0;
            ByteString3.b bVarNewOutput = ByteString3.newOutput();
            CodedOutputStream codedOutputStreamNewInstance = CodedOutputStream.newInstance(bVarNewOutput, 1);
            while (!z2) {
                try {
                    try {
                        try {
                            int tag = codedInputStream.readTag();
                            if (tag != 0) {
                                if (tag == 8) {
                                    int i = codedInputStream.readEnum();
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
                                    q qVar = (q) codedInputStream.readMessage(q.k, extensionRegistryLite);
                                    this.type_ = qVar;
                                    if (builder != null) {
                                        builder.mergeFrom(qVar);
                                        this.type_ = builder.buildPartial();
                                    }
                                    this.bitField0_ |= 2;
                                } else if (tag != 24) {
                                    if (!codedInputStream.skipField(tag, codedOutputStreamNewInstance)) {
                                    }
                                } else {
                                    this.bitField0_ |= 4;
                                    this.typeId_ = codedInputStream.readInt32();
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

    /* JADX INFO: compiled from: ProtoBuf.java */
    public static final class c extends GeneratedMessageLite.c<q, c> implements MessageLiteOrBuilder {
        public int A;
        public int m;
        public boolean o;
        public int p;
        public int r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public int f3403s;
        public int t;
        public int u;
        public int v;

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        public int f3404x;

        /* JADX INFO: renamed from: z, reason: collision with root package name */
        public int f3406z;
        public List<b> n = Collections.emptyList();
        public q q = q.getDefaultInstance();
        public q w = q.getDefaultInstance();

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        public q f3405y = q.getDefaultInstance();

        public q buildPartial() {
            q qVar = new q(this, null);
            int i = this.m;
            if ((i & 1) == 1) {
                this.n = Collections.unmodifiableList(this.n);
                this.m &= -2;
            }
            qVar.argument_ = this.n;
            int i2 = (i & 2) != 2 ? 0 : 1;
            qVar.nullable_ = this.o;
            if ((i & 4) == 4) {
                i2 |= 2;
            }
            qVar.flexibleTypeCapabilitiesId_ = this.p;
            if ((i & 8) == 8) {
                i2 |= 4;
            }
            qVar.flexibleUpperBound_ = this.q;
            if ((i & 16) == 16) {
                i2 |= 8;
            }
            qVar.flexibleUpperBoundId_ = this.r;
            if ((i & 32) == 32) {
                i2 |= 16;
            }
            qVar.className_ = this.f3403s;
            if ((i & 64) == 64) {
                i2 |= 32;
            }
            qVar.typeParameter_ = this.t;
            if ((i & 128) == 128) {
                i2 |= 64;
            }
            qVar.typeParameterName_ = this.u;
            if ((i & 256) == 256) {
                i2 |= 128;
            }
            qVar.typeAliasName_ = this.v;
            if ((i & 512) == 512) {
                i2 |= 256;
            }
            qVar.outerType_ = this.w;
            if ((i & 1024) == 1024) {
                i2 |= 512;
            }
            qVar.outerTypeId_ = this.f3404x;
            if ((i & 2048) == 2048) {
                i2 |= 1024;
            }
            qVar.abbreviatedType_ = this.f3405y;
            if ((i & 4096) == 4096) {
                i2 |= 2048;
            }
            qVar.abbreviatedTypeId_ = this.f3406z;
            if ((i & 8192) == 8192) {
                i2 |= 4096;
            }
            qVar.flags_ = this.A;
            qVar.bitField0_ = i2;
            return qVar;
        }

        public c mergeAbbreviatedType(q qVar) {
            if ((this.m & 2048) != 2048 || this.f3405y == q.getDefaultInstance()) {
                this.f3405y = qVar;
            } else {
                this.f3405y = q.newBuilder(this.f3405y).mergeFrom(qVar).buildPartial();
            }
            this.m |= 2048;
            return this;
        }

        public c mergeFlexibleUpperBound(q qVar) {
            if ((this.m & 8) != 8 || this.q == q.getDefaultInstance()) {
                this.q = qVar;
            } else {
                this.q = q.newBuilder(this.q).mergeFrom(qVar).buildPartial();
            }
            this.m |= 8;
            return this;
        }

        public c mergeOuterType(q qVar) {
            if ((this.m & 512) != 512 || this.w == q.getDefaultInstance()) {
                this.w = qVar;
            } else {
                this.w = q.newBuilder(this.w).mergeFrom(qVar).buildPartial();
            }
            this.m |= 512;
            return this;
        }

        public c setAbbreviatedTypeId(int i) {
            this.m |= 4096;
            this.f3406z = i;
            return this;
        }

        public c setClassName(int i) {
            this.m |= 32;
            this.f3403s = i;
            return this;
        }

        public c setFlags(int i) {
            this.m |= 8192;
            this.A = i;
            return this;
        }

        public c setFlexibleTypeCapabilitiesId(int i) {
            this.m |= 4;
            this.p = i;
            return this;
        }

        public c setFlexibleUpperBoundId(int i) {
            this.m |= 16;
            this.r = i;
            return this;
        }

        public c setNullable(boolean z2) {
            this.m |= 2;
            this.o = z2;
            return this;
        }

        public c setOuterTypeId(int i) {
            this.m |= 1024;
            this.f3404x = i;
            return this;
        }

        public c setTypeAliasName(int i) {
            this.m |= 256;
            this.v = i;
            return this;
        }

        public c setTypeParameter(int i) {
            this.m |= 64;
            this.t = i;
            return this;
        }

        public c setTypeParameterName(int i) {
            this.m |= 128;
            this.u = i;
            return this;
        }

        @Override // d0.e0.p.d.m0.i.MessageLite.a
        public q build() {
            q qVarBuildPartial = buildPartial();
            if (qVarBuildPartial.isInitialized()) {
                return qVarBuildPartial;
            }
            throw new UninitializedMessageException(qVarBuildPartial);
        }

        @Override // d0.e0.p.d.m0.i.GeneratedMessageLite.b
        /* JADX INFO: renamed from: clone */
        public c mo88clone() {
            return new c().mergeFrom(buildPartial());
        }

        @Override // d0.e0.p.d.m0.i.GeneratedMessageLite.b
        public c mergeFrom(q qVar) {
            if (qVar == q.getDefaultInstance()) {
                return this;
            }
            if (!qVar.argument_.isEmpty()) {
                if (this.n.isEmpty()) {
                    this.n = qVar.argument_;
                    this.m &= -2;
                } else {
                    if ((this.m & 1) != 1) {
                        this.n = new ArrayList(this.n);
                        this.m |= 1;
                    }
                    this.n.addAll(qVar.argument_);
                }
            }
            if (qVar.hasNullable()) {
                setNullable(qVar.getNullable());
            }
            if (qVar.hasFlexibleTypeCapabilitiesId()) {
                setFlexibleTypeCapabilitiesId(qVar.getFlexibleTypeCapabilitiesId());
            }
            if (qVar.hasFlexibleUpperBound()) {
                mergeFlexibleUpperBound(qVar.getFlexibleUpperBound());
            }
            if (qVar.hasFlexibleUpperBoundId()) {
                setFlexibleUpperBoundId(qVar.getFlexibleUpperBoundId());
            }
            if (qVar.hasClassName()) {
                setClassName(qVar.getClassName());
            }
            if (qVar.hasTypeParameter()) {
                setTypeParameter(qVar.getTypeParameter());
            }
            if (qVar.hasTypeParameterName()) {
                setTypeParameterName(qVar.getTypeParameterName());
            }
            if (qVar.hasTypeAliasName()) {
                setTypeAliasName(qVar.getTypeAliasName());
            }
            if (qVar.hasOuterType()) {
                mergeOuterType(qVar.getOuterType());
            }
            if (qVar.hasOuterTypeId()) {
                setOuterTypeId(qVar.getOuterTypeId());
            }
            if (qVar.hasAbbreviatedType()) {
                mergeAbbreviatedType(qVar.getAbbreviatedType());
            }
            if (qVar.hasAbbreviatedTypeId()) {
                setAbbreviatedTypeId(qVar.getAbbreviatedTypeId());
            }
            if (qVar.hasFlags()) {
                setFlags(qVar.getFlags());
            }
            b(qVar);
            setUnknownFields(getUnknownFields().concat(qVar.unknownFields));
            return this;
        }

        /* JADX WARN: Code duplicated, block: B:15:0x001d  */
        @Override // d0.e0.p.d.m0.i.AbstractMessageLite.a, d0.e0.p.d.m0.i.MessageLite.a
        public c mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws Throwable {
            q qVar = null;
            try {
                try {
                    q partialFrom = q.k.parsePartialFrom(codedInputStream, extensionRegistryLite);
                    if (partialFrom != null) {
                        mergeFrom(partialFrom);
                    }
                    return this;
                } catch (InvalidProtocolBufferException e) {
                    q qVar2 = (q) e.getUnfinishedMessage();
                    try {
                        throw e;
                    } catch (Throwable th) {
                        th = th;
                        qVar = qVar2;
                        if (qVar != null) {
                            mergeFrom(qVar);
                        }
                        throw th;
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                if (qVar != null) {
                    mergeFrom(qVar);
                }
                throw th;
            }
        }
    }

    static {
        q qVar = new q();
        j = qVar;
        qVar.y();
    }

    public q(GeneratedMessageLite.c cVar, d0.e0.p.d.m0.f.a aVar) {
        super(cVar);
        this.memoizedIsInitialized = (byte) -1;
        this.memoizedSerializedSize = -1;
        this.unknownFields = cVar.getUnknownFields();
    }

    public static q getDefaultInstance() {
        return j;
    }

    public static c newBuilder(q qVar) {
        return newBuilder().mergeFrom(qVar);
    }

    public q getAbbreviatedType() {
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

    public q getFlexibleUpperBound() {
        return this.flexibleUpperBound_;
    }

    public int getFlexibleUpperBoundId() {
        return this.flexibleUpperBoundId_;
    }

    public boolean getNullable() {
        return this.nullable_;
    }

    public q getOuterType() {
        return this.outerType_;
    }

    public int getOuterTypeId() {
        return this.outerTypeId_;
    }

    @Override // d0.e0.p.d.m0.i.MessageLite
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
        int size = this.unknownFields.size() + c() + iComputeInt32Size;
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

    @Override // d0.e0.p.d.m0.i.MessageLiteOrBuilder
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
        if (b()) {
            this.memoizedIsInitialized = (byte) 1;
            return true;
        }
        this.memoizedIsInitialized = (byte) 0;
        return false;
    }

    @Override // d0.e0.p.d.m0.i.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        getSerializedSize();
        GeneratedMessageLite.d<MessageType>.a aVarE = e();
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
        aVarE.writeUntil(200, codedOutputStream);
        codedOutputStream.writeRawBytes(this.unknownFields);
    }

    public final void y() {
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

    @Override // d0.e0.p.d.m0.i.MessageLiteOrBuilder
    public q getDefaultInstanceForType() {
        return j;
    }

    @Override // d0.e0.p.d.m0.i.MessageLite
    public c newBuilderForType() {
        return newBuilder();
    }

    @Override // d0.e0.p.d.m0.i.MessageLite
    public c toBuilder() {
        return newBuilder(this);
    }

    public q() {
        this.memoizedIsInitialized = (byte) -1;
        this.memoizedSerializedSize = -1;
        this.unknownFields = ByteString3.j;
    }

    public q(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, d0.e0.p.d.m0.f.a aVar) throws InvalidProtocolBufferException {
        c builder;
        this.memoizedIsInitialized = (byte) -1;
        this.memoizedSerializedSize = -1;
        y();
        ByteString3.b bVarNewOutput = ByteString3.newOutput();
        CodedOutputStream codedOutputStreamNewInstance = CodedOutputStream.newInstance(bVarNewOutput, 1);
        boolean z2 = false;
        boolean z3 = false;
        while (!z2) {
            try {
                try {
                    int tag = codedInputStream.readTag();
                    switch (tag) {
                        case 0:
                            break;
                        case 8:
                            this.bitField0_ |= 4096;
                            this.flags_ = codedInputStream.readInt32();
                            continue;
                        case 18:
                            if (!(z3 & true)) {
                                this.argument_ = new ArrayList();
                                z3 |= true;
                            }
                            this.argument_.add((b) codedInputStream.readMessage(b.k, extensionRegistryLite));
                            continue;
                        case 24:
                            this.bitField0_ |= 1;
                            this.nullable_ = codedInputStream.readBool();
                            continue;
                        case 32:
                            this.bitField0_ |= 2;
                            this.flexibleTypeCapabilitiesId_ = codedInputStream.readInt32();
                            continue;
                        case 42:
                            builder = (this.bitField0_ & 4) == 4 ? this.flexibleUpperBound_.toBuilder() : null;
                            q qVar = (q) codedInputStream.readMessage(k, extensionRegistryLite);
                            this.flexibleUpperBound_ = qVar;
                            if (builder != null) {
                                builder.mergeFrom(qVar);
                                this.flexibleUpperBound_ = builder.buildPartial();
                            }
                            this.bitField0_ |= 4;
                            continue;
                        case 48:
                            this.bitField0_ |= 16;
                            this.className_ = codedInputStream.readInt32();
                            continue;
                        case 56:
                            this.bitField0_ |= 32;
                            this.typeParameter_ = codedInputStream.readInt32();
                            continue;
                        case 64:
                            this.bitField0_ |= 8;
                            this.flexibleUpperBoundId_ = codedInputStream.readInt32();
                            continue;
                        case 72:
                            this.bitField0_ |= 64;
                            this.typeParameterName_ = codedInputStream.readInt32();
                            continue;
                        case 82:
                            builder = (this.bitField0_ & 256) == 256 ? this.outerType_.toBuilder() : null;
                            q qVar2 = (q) codedInputStream.readMessage(k, extensionRegistryLite);
                            this.outerType_ = qVar2;
                            if (builder != null) {
                                builder.mergeFrom(qVar2);
                                this.outerType_ = builder.buildPartial();
                            }
                            this.bitField0_ |= 256;
                            continue;
                        case 88:
                            this.bitField0_ |= 512;
                            this.outerTypeId_ = codedInputStream.readInt32();
                            continue;
                        case 96:
                            this.bitField0_ |= 128;
                            this.typeAliasName_ = codedInputStream.readInt32();
                            continue;
                        case 106:
                            builder = (this.bitField0_ & 1024) == 1024 ? this.abbreviatedType_.toBuilder() : null;
                            q qVar3 = (q) codedInputStream.readMessage(k, extensionRegistryLite);
                            this.abbreviatedType_ = qVar3;
                            if (builder != null) {
                                builder.mergeFrom(qVar3);
                                this.abbreviatedType_ = builder.buildPartial();
                            }
                            this.bitField0_ |= 1024;
                            continue;
                        case 112:
                            this.bitField0_ |= 2048;
                            this.abbreviatedTypeId_ = codedInputStream.readInt32();
                            continue;
                        default:
                            if (!f(codedInputStream, codedOutputStreamNewInstance, extensionRegistryLite, tag)) {
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
                d();
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
        d();
    }
}
