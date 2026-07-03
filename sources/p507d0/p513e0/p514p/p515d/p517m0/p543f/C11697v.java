package p507d0.p513e0.p514p.p515d.p517m0.p543f;

import java.io.IOException;
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

/* JADX INFO: renamed from: d0.e0.p.d.m0.f.v */
/* JADX INFO: compiled from: ProtoBuf.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C11697v extends AbstractC11727g implements InterfaceC11735o {

    /* JADX INFO: renamed from: j */
    public static final C11697v f23970j;

    /* JADX INFO: renamed from: k */
    public static InterfaceC11736p<C11697v> f23971k = new a();
    private int bitField0_;
    private int errorCode_;
    private c level_;
    private byte memoizedIsInitialized;
    private int memoizedSerializedSize;
    private int message_;
    private final AbstractC11723c unknownFields;
    private int versionFull_;
    private d versionKind_;
    private int version_;

    /* JADX INFO: renamed from: d0.e0.p.d.m0.f.v$a */
    /* JADX INFO: compiled from: ProtoBuf.java */
    public static class a extends AbstractC11722b<C11697v> {
        @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.InterfaceC11736p
        public C11697v parsePartialFrom(C11724d c11724d, C11725e c11725e) throws InvalidProtocolBufferException {
            return new C11697v(c11724d, c11725e, null);
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.f.v$b */
    /* JADX INFO: compiled from: ProtoBuf.java */
    public static final class b extends AbstractC11727g.b<C11697v, b> implements InterfaceC11735o {

        /* JADX INFO: renamed from: k */
        public int f23972k;

        /* JADX INFO: renamed from: l */
        public int f23973l;

        /* JADX INFO: renamed from: m */
        public int f23974m;

        /* JADX INFO: renamed from: o */
        public int f23976o;

        /* JADX INFO: renamed from: p */
        public int f23977p;

        /* JADX INFO: renamed from: n */
        public c f23975n = c.ERROR;

        /* JADX INFO: renamed from: q */
        public d f23978q = d.LANGUAGE_VERSION;

        public C11697v buildPartial() {
            C11697v c11697v = new C11697v(this, null);
            int i = this.f23972k;
            int i2 = (i & 1) != 1 ? 0 : 1;
            c11697v.version_ = this.f23973l;
            if ((i & 2) == 2) {
                i2 |= 2;
            }
            c11697v.versionFull_ = this.f23974m;
            if ((i & 4) == 4) {
                i2 |= 4;
            }
            c11697v.level_ = this.f23975n;
            if ((i & 8) == 8) {
                i2 |= 8;
            }
            c11697v.errorCode_ = this.f23976o;
            if ((i & 16) == 16) {
                i2 |= 16;
            }
            c11697v.message_ = this.f23977p;
            if ((i & 32) == 32) {
                i2 |= 32;
            }
            c11697v.versionKind_ = this.f23978q;
            c11697v.bitField0_ = i2;
            return c11697v;
        }

        public b setErrorCode(int i) {
            this.f23972k |= 8;
            this.f23976o = i;
            return this;
        }

        public b setLevel(c cVar) {
            Objects.requireNonNull(cVar);
            this.f23972k |= 4;
            this.f23975n = cVar;
            return this;
        }

        public b setMessage(int i) {
            this.f23972k |= 16;
            this.f23977p = i;
            return this;
        }

        public b setVersion(int i) {
            this.f23972k |= 1;
            this.f23973l = i;
            return this;
        }

        public b setVersionFull(int i) {
            this.f23972k |= 2;
            this.f23974m = i;
            return this;
        }

        public b setVersionKind(d dVar) {
            Objects.requireNonNull(dVar);
            this.f23972k |= 32;
            this.f23978q = dVar;
            return this;
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.InterfaceC11734n.a
        public C11697v build() {
            C11697v c11697vBuildPartial = buildPartial();
            if (c11697vBuildPartial.isInitialized()) {
                return c11697vBuildPartial;
            }
            throw new UninitializedMessageException(c11697vBuildPartial);
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.AbstractC11727g.b
        /* JADX INFO: renamed from: clone */
        public b mo11465clone() {
            return new b().mergeFrom(buildPartial());
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.AbstractC11727g.b
        public b mergeFrom(C11697v c11697v) {
            if (c11697v == C11697v.getDefaultInstance()) {
                return this;
            }
            if (c11697v.hasVersion()) {
                setVersion(c11697v.getVersion());
            }
            if (c11697v.hasVersionFull()) {
                setVersionFull(c11697v.getVersionFull());
            }
            if (c11697v.hasLevel()) {
                setLevel(c11697v.getLevel());
            }
            if (c11697v.hasErrorCode()) {
                setErrorCode(c11697v.getErrorCode());
            }
            if (c11697v.hasMessage()) {
                setMessage(c11697v.getMessage());
            }
            if (c11697v.hasVersionKind()) {
                setVersionKind(c11697v.getVersionKind());
            }
            setUnknownFields(getUnknownFields().concat(c11697v.unknownFields));
            return this;
        }

        /* JADX WARN: Code duplicated, block: B:15:0x001d  */
        @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.AbstractC11721a.a, p507d0.p513e0.p514p.p515d.p517m0.p550i.InterfaceC11734n.a
        public b mergeFrom(C11724d c11724d, C11725e c11725e) throws Throwable {
            C11697v c11697v = null;
            try {
                try {
                    C11697v partialFrom = C11697v.f23971k.parsePartialFrom(c11724d, c11725e);
                    if (partialFrom != null) {
                        mergeFrom(partialFrom);
                    }
                    return this;
                } catch (InvalidProtocolBufferException e) {
                    C11697v c11697v2 = (C11697v) e.getUnfinishedMessage();
                    try {
                        throw e;
                    } catch (Throwable th) {
                        th = th;
                        c11697v = c11697v2;
                        if (c11697v != null) {
                            mergeFrom(c11697v);
                        }
                        throw th;
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                if (c11697v != null) {
                    mergeFrom(c11697v);
                }
                throw th;
            }
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.f.v$c */
    /* JADX INFO: compiled from: ProtoBuf.java */
    public enum c implements C11728h.a {
        WARNING(0),
        ERROR(1),
        HIDDEN(2);

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
                return WARNING;
            }
            if (i == 1) {
                return ERROR;
            }
            if (i != 2) {
                return null;
            }
            return HIDDEN;
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.f.v$d */
    /* JADX INFO: compiled from: ProtoBuf.java */
    public enum d implements C11728h.a {
        LANGUAGE_VERSION(0),
        COMPILER_VERSION(1),
        API_VERSION(2);

        private final int value;

        d(int i) {
            this.value = i;
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.C11728h.a
        public final int getNumber() {
            return this.value;
        }

        public static d valueOf(int i) {
            if (i == 0) {
                return LANGUAGE_VERSION;
            }
            if (i == 1) {
                return COMPILER_VERSION;
            }
            if (i != 2) {
                return null;
            }
            return API_VERSION;
        }
    }

    static {
        C11697v c11697v = new C11697v();
        f23970j = c11697v;
        c11697v.version_ = 0;
        c11697v.versionFull_ = 0;
        c11697v.level_ = c.ERROR;
        c11697v.errorCode_ = 0;
        c11697v.message_ = 0;
        c11697v.versionKind_ = d.LANGUAGE_VERSION;
    }

    public C11697v(AbstractC11727g.b bVar, C11666a c11666a) {
        super(bVar);
        this.memoizedIsInitialized = (byte) -1;
        this.memoizedSerializedSize = -1;
        this.unknownFields = bVar.getUnknownFields();
    }

    public static C11697v getDefaultInstance() {
        return f23970j;
    }

    public static b newBuilder(C11697v c11697v) {
        return newBuilder().mergeFrom(c11697v);
    }

    public int getErrorCode() {
        return this.errorCode_;
    }

    public c getLevel() {
        return this.level_;
    }

    public int getMessage() {
        return this.message_;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.InterfaceC11734n
    public int getSerializedSize() {
        int i = this.memoizedSerializedSize;
        if (i != -1) {
            return i;
        }
        int iComputeInt32Size = (this.bitField0_ & 1) == 1 ? 0 + CodedOutputStream.computeInt32Size(1, this.version_) : 0;
        if ((this.bitField0_ & 2) == 2) {
            iComputeInt32Size += CodedOutputStream.computeInt32Size(2, this.versionFull_);
        }
        if ((this.bitField0_ & 4) == 4) {
            iComputeInt32Size += CodedOutputStream.computeEnumSize(3, this.level_.getNumber());
        }
        if ((this.bitField0_ & 8) == 8) {
            iComputeInt32Size += CodedOutputStream.computeInt32Size(4, this.errorCode_);
        }
        if ((this.bitField0_ & 16) == 16) {
            iComputeInt32Size += CodedOutputStream.computeInt32Size(5, this.message_);
        }
        if ((this.bitField0_ & 32) == 32) {
            iComputeInt32Size += CodedOutputStream.computeEnumSize(6, this.versionKind_.getNumber());
        }
        int size = this.unknownFields.size() + iComputeInt32Size;
        this.memoizedSerializedSize = size;
        return size;
    }

    public int getVersion() {
        return this.version_;
    }

    public int getVersionFull() {
        return this.versionFull_;
    }

    public d getVersionKind() {
        return this.versionKind_;
    }

    public boolean hasErrorCode() {
        return (this.bitField0_ & 8) == 8;
    }

    public boolean hasLevel() {
        return (this.bitField0_ & 4) == 4;
    }

    public boolean hasMessage() {
        return (this.bitField0_ & 16) == 16;
    }

    public boolean hasVersion() {
        return (this.bitField0_ & 1) == 1;
    }

    public boolean hasVersionFull() {
        return (this.bitField0_ & 2) == 2;
    }

    public boolean hasVersionKind() {
        return (this.bitField0_ & 32) == 32;
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
        this.memoizedIsInitialized = (byte) 1;
        return true;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.InterfaceC11734n
    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        getSerializedSize();
        if ((this.bitField0_ & 1) == 1) {
            codedOutputStream.writeInt32(1, this.version_);
        }
        if ((this.bitField0_ & 2) == 2) {
            codedOutputStream.writeInt32(2, this.versionFull_);
        }
        if ((this.bitField0_ & 4) == 4) {
            codedOutputStream.writeEnum(3, this.level_.getNumber());
        }
        if ((this.bitField0_ & 8) == 8) {
            codedOutputStream.writeInt32(4, this.errorCode_);
        }
        if ((this.bitField0_ & 16) == 16) {
            codedOutputStream.writeInt32(5, this.message_);
        }
        if ((this.bitField0_ & 32) == 32) {
            codedOutputStream.writeEnum(6, this.versionKind_.getNumber());
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

    public C11697v() {
        this.memoizedIsInitialized = (byte) -1;
        this.memoizedSerializedSize = -1;
        this.unknownFields = AbstractC11723c.f24100j;
    }

    public C11697v(C11724d c11724d, C11725e c11725e, C11666a c11666a) throws InvalidProtocolBufferException {
        this.memoizedIsInitialized = (byte) -1;
        this.memoizedSerializedSize = -1;
        boolean z2 = false;
        this.version_ = 0;
        this.versionFull_ = 0;
        this.level_ = c.ERROR;
        this.errorCode_ = 0;
        this.message_ = 0;
        this.versionKind_ = d.LANGUAGE_VERSION;
        AbstractC11723c.b bVarNewOutput = AbstractC11723c.newOutput();
        CodedOutputStream codedOutputStreamNewInstance = CodedOutputStream.newInstance(bVarNewOutput, 1);
        while (!z2) {
            try {
                try {
                    try {
                        int tag = c11724d.readTag();
                        if (tag != 0) {
                            if (tag == 8) {
                                this.bitField0_ |= 1;
                                this.version_ = c11724d.readInt32();
                            } else if (tag == 16) {
                                this.bitField0_ |= 2;
                                this.versionFull_ = c11724d.readInt32();
                            } else if (tag == 24) {
                                int i = c11724d.readEnum();
                                c cVarValueOf = c.valueOf(i);
                                if (cVarValueOf == null) {
                                    codedOutputStreamNewInstance.writeRawVarint32(tag);
                                    codedOutputStreamNewInstance.writeRawVarint32(i);
                                } else {
                                    this.bitField0_ |= 4;
                                    this.level_ = cVarValueOf;
                                }
                            } else if (tag == 32) {
                                this.bitField0_ |= 8;
                                this.errorCode_ = c11724d.readInt32();
                            } else if (tag == 40) {
                                this.bitField0_ |= 16;
                                this.message_ = c11724d.readInt32();
                            } else if (tag != 48) {
                                if (!c11724d.skipField(tag, codedOutputStreamNewInstance)) {
                                }
                            } else {
                                int i2 = c11724d.readEnum();
                                d dVarValueOf = d.valueOf(i2);
                                if (dVarValueOf == null) {
                                    codedOutputStreamNewInstance.writeRawVarint32(tag);
                                    codedOutputStreamNewInstance.writeRawVarint32(i2);
                                } else {
                                    this.bitField0_ |= 32;
                                    this.versionKind_ = dVarValueOf;
                                }
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
