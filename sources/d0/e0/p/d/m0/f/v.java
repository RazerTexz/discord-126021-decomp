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
import java.util.Objects;
import kotlin.reflect.jvm.internal.impl.protobuf.CodedOutputStream;
import kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException;
import kotlin.reflect.jvm.internal.impl.protobuf.UninitializedMessageException;

/* JADX INFO: compiled from: ProtoBuf.java */
/* JADX INFO: loaded from: classes3.dex */
public final class v extends GeneratedMessageLite implements MessageLiteOrBuilder {
    public static final v j;
    public static Parser2<v> k = new a();
    private int bitField0_;
    private int errorCode_;
    private c level_;
    private byte memoizedIsInitialized;
    private int memoizedSerializedSize;
    private int message_;
    private final ByteString3 unknownFields;
    private int versionFull_;
    private d versionKind_;
    private int version_;

    /* JADX INFO: compiled from: ProtoBuf.java */
    public static class a extends AbstractParser<v> {
        @Override // d0.e0.p.d.m0.i.Parser2
        public v parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return new v(codedInputStream, extensionRegistryLite, null);
        }
    }

    /* JADX INFO: compiled from: ProtoBuf.java */
    public static final class b extends GeneratedMessageLite.b<v, b> implements MessageLiteOrBuilder {
        public int k;
        public int l;
        public int m;
        public int o;
        public int p;
        public c n = c.ERROR;
        public d q = d.LANGUAGE_VERSION;

        public v buildPartial() {
            v vVar = new v(this, null);
            int i = this.k;
            int i2 = (i & 1) != 1 ? 0 : 1;
            vVar.version_ = this.l;
            if ((i & 2) == 2) {
                i2 |= 2;
            }
            vVar.versionFull_ = this.m;
            if ((i & 4) == 4) {
                i2 |= 4;
            }
            vVar.level_ = this.n;
            if ((i & 8) == 8) {
                i2 |= 8;
            }
            vVar.errorCode_ = this.o;
            if ((i & 16) == 16) {
                i2 |= 16;
            }
            vVar.message_ = this.p;
            if ((i & 32) == 32) {
                i2 |= 32;
            }
            vVar.versionKind_ = this.q;
            vVar.bitField0_ = i2;
            return vVar;
        }

        public b setErrorCode(int i) {
            this.k |= 8;
            this.o = i;
            return this;
        }

        public b setLevel(c cVar) {
            Objects.requireNonNull(cVar);
            this.k |= 4;
            this.n = cVar;
            return this;
        }

        public b setMessage(int i) {
            this.k |= 16;
            this.p = i;
            return this;
        }

        public b setVersion(int i) {
            this.k |= 1;
            this.l = i;
            return this;
        }

        public b setVersionFull(int i) {
            this.k |= 2;
            this.m = i;
            return this;
        }

        public b setVersionKind(d dVar) {
            Objects.requireNonNull(dVar);
            this.k |= 32;
            this.q = dVar;
            return this;
        }

        @Override // d0.e0.p.d.m0.i.MessageLite.a
        public v build() {
            v vVarBuildPartial = buildPartial();
            if (vVarBuildPartial.isInitialized()) {
                return vVarBuildPartial;
            }
            throw new UninitializedMessageException(vVarBuildPartial);
        }

        @Override // d0.e0.p.d.m0.i.GeneratedMessageLite.b
        /* JADX INFO: renamed from: clone */
        public b mo88clone() {
            return new b().mergeFrom(buildPartial());
        }

        @Override // d0.e0.p.d.m0.i.GeneratedMessageLite.b
        public b mergeFrom(v vVar) {
            if (vVar == v.getDefaultInstance()) {
                return this;
            }
            if (vVar.hasVersion()) {
                setVersion(vVar.getVersion());
            }
            if (vVar.hasVersionFull()) {
                setVersionFull(vVar.getVersionFull());
            }
            if (vVar.hasLevel()) {
                setLevel(vVar.getLevel());
            }
            if (vVar.hasErrorCode()) {
                setErrorCode(vVar.getErrorCode());
            }
            if (vVar.hasMessage()) {
                setMessage(vVar.getMessage());
            }
            if (vVar.hasVersionKind()) {
                setVersionKind(vVar.getVersionKind());
            }
            setUnknownFields(getUnknownFields().concat(vVar.unknownFields));
            return this;
        }

        /* JADX WARN: Code duplicated, block: B:15:0x001d  */
        @Override // d0.e0.p.d.m0.i.AbstractMessageLite.a, d0.e0.p.d.m0.i.MessageLite.a
        public b mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws Throwable {
            v vVar = null;
            try {
                try {
                    v partialFrom = v.k.parsePartialFrom(codedInputStream, extensionRegistryLite);
                    if (partialFrom != null) {
                        mergeFrom(partialFrom);
                    }
                    return this;
                } catch (InvalidProtocolBufferException e) {
                    v vVar2 = (v) e.getUnfinishedMessage();
                    try {
                        throw e;
                    } catch (Throwable th) {
                        th = th;
                        vVar = vVar2;
                        if (vVar != null) {
                            mergeFrom(vVar);
                        }
                        throw th;
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                if (vVar != null) {
                    mergeFrom(vVar);
                }
                throw th;
            }
        }
    }

    /* JADX INFO: compiled from: ProtoBuf.java */
    public enum c implements Internal.a {
        WARNING(0),
        ERROR(1),
        HIDDEN(2);

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

    /* JADX INFO: compiled from: ProtoBuf.java */
    public enum d implements Internal.a {
        LANGUAGE_VERSION(0),
        COMPILER_VERSION(1),
        API_VERSION(2);

        private final int value;

        d(int i) {
            this.value = i;
        }

        @Override // d0.e0.p.d.m0.i.Internal.a
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
        v vVar = new v();
        j = vVar;
        vVar.version_ = 0;
        vVar.versionFull_ = 0;
        vVar.level_ = c.ERROR;
        vVar.errorCode_ = 0;
        vVar.message_ = 0;
        vVar.versionKind_ = d.LANGUAGE_VERSION;
    }

    public v(GeneratedMessageLite.b bVar, d0.e0.p.d.m0.f.a aVar) {
        super(bVar);
        this.memoizedIsInitialized = (byte) -1;
        this.memoizedSerializedSize = -1;
        this.unknownFields = bVar.getUnknownFields();
    }

    public static v getDefaultInstance() {
        return j;
    }

    public static b newBuilder(v vVar) {
        return newBuilder().mergeFrom(vVar);
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

    @Override // d0.e0.p.d.m0.i.MessageLite
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

    @Override // d0.e0.p.d.m0.i.MessageLiteOrBuilder
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

    @Override // d0.e0.p.d.m0.i.MessageLite
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

    @Override // d0.e0.p.d.m0.i.MessageLite
    public b newBuilderForType() {
        return newBuilder();
    }

    @Override // d0.e0.p.d.m0.i.MessageLite
    public b toBuilder() {
        return newBuilder(this);
    }

    public v() {
        this.memoizedIsInitialized = (byte) -1;
        this.memoizedSerializedSize = -1;
        this.unknownFields = ByteString3.j;
    }

    public v(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, d0.e0.p.d.m0.f.a aVar) throws InvalidProtocolBufferException {
        this.memoizedIsInitialized = (byte) -1;
        this.memoizedSerializedSize = -1;
        boolean z2 = false;
        this.version_ = 0;
        this.versionFull_ = 0;
        this.level_ = c.ERROR;
        this.errorCode_ = 0;
        this.message_ = 0;
        this.versionKind_ = d.LANGUAGE_VERSION;
        ByteString3.b bVarNewOutput = ByteString3.newOutput();
        CodedOutputStream codedOutputStreamNewInstance = CodedOutputStream.newInstance(bVarNewOutput, 1);
        while (!z2) {
            try {
                try {
                    try {
                        int tag = codedInputStream.readTag();
                        if (tag != 0) {
                            if (tag == 8) {
                                this.bitField0_ |= 1;
                                this.version_ = codedInputStream.readInt32();
                            } else if (tag == 16) {
                                this.bitField0_ |= 2;
                                this.versionFull_ = codedInputStream.readInt32();
                            } else if (tag == 24) {
                                int i = codedInputStream.readEnum();
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
                                this.errorCode_ = codedInputStream.readInt32();
                            } else if (tag == 40) {
                                this.bitField0_ |= 16;
                                this.message_ = codedInputStream.readInt32();
                            } else if (tag != 48) {
                                if (!codedInputStream.skipField(tag, codedOutputStreamNewInstance)) {
                                }
                            } else {
                                int i2 = codedInputStream.readEnum();
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
