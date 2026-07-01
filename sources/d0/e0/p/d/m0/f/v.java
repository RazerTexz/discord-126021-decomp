package d0.e0.p.d.m0.f;

import java.io.IOException;
import kotlin.reflect.jvm.internal.impl.protobuf.CodedOutputStream;
import kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException;

/* JADX INFO: compiled from: ProtoBuf.java */
/* JADX INFO: loaded from: classes3.dex */
public final class v extends d0.e0.p.d.m0.i.g implements d0.e0.p.d.m0.i.o {
    public static final v j;
    public static d0.e0.p.d.m0.i.p<v> k = new v$a();
    private int bitField0_;
    private int errorCode_;
    private v$c level_;
    private byte memoizedIsInitialized;
    private int memoizedSerializedSize;
    private int message_;
    private final d0.e0.p.d.m0.i.c unknownFields;
    private int versionFull_;
    private v$d versionKind_;
    private int version_;

    static {
        v vVar = new v();
        j = vVar;
        vVar.version_ = 0;
        vVar.versionFull_ = 0;
        vVar.level_ = v$c.ERROR;
        vVar.errorCode_ = 0;
        vVar.message_ = 0;
        vVar.versionKind_ = v$d.LANGUAGE_VERSION;
    }

    public v(d0.e0.p.d.m0.i.g$b g_b, a aVar) {
        super(g_b);
        this.memoizedIsInitialized = (byte) -1;
        this.memoizedSerializedSize = -1;
        this.unknownFields = g_b.getUnknownFields();
    }

    public static /* synthetic */ int a(v vVar, int i) {
        vVar.version_ = i;
        return i;
    }

    public static /* synthetic */ int b(v vVar, int i) {
        vVar.versionFull_ = i;
        return i;
    }

    public static /* synthetic */ v$c c(v vVar, v$c v_c) {
        vVar.level_ = v_c;
        return v_c;
    }

    public static /* synthetic */ int d(v vVar, int i) {
        vVar.errorCode_ = i;
        return i;
    }

    public static /* synthetic */ int e(v vVar, int i) {
        vVar.message_ = i;
        return i;
    }

    public static /* synthetic */ v$d f(v vVar, v$d v_d) {
        vVar.versionKind_ = v_d;
        return v_d;
    }

    public static /* synthetic */ int g(v vVar, int i) {
        vVar.bitField0_ = i;
        return i;
    }

    public static v getDefaultInstance() {
        return j;
    }

    public static /* synthetic */ d0.e0.p.d.m0.i.c h(v vVar) {
        return vVar.unknownFields;
    }

    public static v$b newBuilder(v vVar) {
        return newBuilder().mergeFrom(vVar);
    }

    public int getErrorCode() {
        return this.errorCode_;
    }

    public v$c getLevel() {
        return this.level_;
    }

    public int getMessage() {
        return this.message_;
    }

    @Override // d0.e0.p.d.m0.i.n
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

    public v$d getVersionKind() {
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

    @Override // d0.e0.p.d.m0.i.o
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

    @Override // d0.e0.p.d.m0.i.n
    public /* bridge */ /* synthetic */ d0.e0.p.d.m0.i.n$a newBuilderForType() {
        return newBuilderForType();
    }

    @Override // d0.e0.p.d.m0.i.n
    public /* bridge */ /* synthetic */ d0.e0.p.d.m0.i.n$a toBuilder() {
        return toBuilder();
    }

    @Override // d0.e0.p.d.m0.i.n
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

    public static v$b newBuilder() {
        return new v$b();
    }

    @Override // d0.e0.p.d.m0.i.n
    public v$b newBuilderForType() {
        return newBuilder();
    }

    @Override // d0.e0.p.d.m0.i.n
    public v$b toBuilder() {
        return newBuilder(this);
    }

    public v() {
        this.memoizedIsInitialized = (byte) -1;
        this.memoizedSerializedSize = -1;
        this.unknownFields = d0.e0.p.d.m0.i.c.j;
    }

    public v(d0.e0.p.d.m0.i.d dVar, d0.e0.p.d.m0.i.e eVar, a aVar) throws InvalidProtocolBufferException {
        this.memoizedIsInitialized = (byte) -1;
        this.memoizedSerializedSize = -1;
        boolean z2 = false;
        this.version_ = 0;
        this.versionFull_ = 0;
        this.level_ = v$c.ERROR;
        this.errorCode_ = 0;
        this.message_ = 0;
        this.versionKind_ = v$d.LANGUAGE_VERSION;
        d0.e0.p.d.m0.i.c$b c_bNewOutput = d0.e0.p.d.m0.i.c.newOutput();
        CodedOutputStream codedOutputStreamNewInstance = CodedOutputStream.newInstance(c_bNewOutput, 1);
        while (!z2) {
            try {
                try {
                    try {
                        int tag = dVar.readTag();
                        if (tag != 0) {
                            if (tag == 8) {
                                this.bitField0_ |= 1;
                                this.version_ = dVar.readInt32();
                            } else if (tag == 16) {
                                this.bitField0_ |= 2;
                                this.versionFull_ = dVar.readInt32();
                            } else if (tag == 24) {
                                int i = dVar.readEnum();
                                v$c v_cValueOf = v$c.valueOf(i);
                                if (v_cValueOf == null) {
                                    codedOutputStreamNewInstance.writeRawVarint32(tag);
                                    codedOutputStreamNewInstance.writeRawVarint32(i);
                                } else {
                                    this.bitField0_ |= 4;
                                    this.level_ = v_cValueOf;
                                }
                            } else if (tag == 32) {
                                this.bitField0_ |= 8;
                                this.errorCode_ = dVar.readInt32();
                            } else if (tag == 40) {
                                this.bitField0_ |= 16;
                                this.message_ = dVar.readInt32();
                            } else if (tag != 48) {
                                if (!dVar.skipField(tag, codedOutputStreamNewInstance)) {
                                }
                            } else {
                                int i2 = dVar.readEnum();
                                v$d v_dValueOf = v$d.valueOf(i2);
                                if (v_dValueOf == null) {
                                    codedOutputStreamNewInstance.writeRawVarint32(tag);
                                    codedOutputStreamNewInstance.writeRawVarint32(i2);
                                } else {
                                    this.bitField0_ |= 32;
                                    this.versionKind_ = v_dValueOf;
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
                    this.unknownFields = c_bNewOutput.toByteString();
                }
                throw th;
            }
        }
        try {
            codedOutputStreamNewInstance.flush();
        } catch (IOException unused2) {
        } finally {
            this.unknownFields = c_bNewOutput.toByteString();
        }
    }
}
