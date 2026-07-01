package d0.e0.p.d.m0.f;

import java.io.IOException;
import kotlin.reflect.jvm.internal.impl.protobuf.CodedOutputStream;
import kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException;

/* JADX INFO: compiled from: ProtoBuf.java */
/* JADX INFO: loaded from: classes3.dex */
public final class o$c extends d0.e0.p.d.m0.i.g implements d0.e0.p.d.m0.i.o {
    public static final o$c j;
    public static d0.e0.p.d.m0.i.p<o$c> k = new o$c$a();
    private int bitField0_;
    private o$c$c kind_;
    private byte memoizedIsInitialized;
    private int memoizedSerializedSize;
    private int parentQualifiedName_;
    private int shortName_;
    private final d0.e0.p.d.m0.i.c unknownFields;

    static {
        o$c o_c = new o$c();
        j = o_c;
        o_c.parentQualifiedName_ = -1;
        o_c.shortName_ = 0;
        o_c.kind_ = o$c$c.PACKAGE;
    }

    public o$c(d0.e0.p.d.m0.i.g$b g_b, a aVar) {
        super(g_b);
        this.memoizedIsInitialized = (byte) -1;
        this.memoizedSerializedSize = -1;
        this.unknownFields = g_b.getUnknownFields();
    }

    public static /* synthetic */ int a(o$c o_c, int i) {
        o_c.shortName_ = i;
        return i;
    }

    public static /* synthetic */ o$c$c b(o$c o_c, o$c$c o_c_c) {
        o_c.kind_ = o_c_c;
        return o_c_c;
    }

    public static /* synthetic */ int c(o$c o_c, int i) {
        o_c.bitField0_ = i;
        return i;
    }

    public static /* synthetic */ d0.e0.p.d.m0.i.c d(o$c o_c) {
        return o_c.unknownFields;
    }

    public static /* synthetic */ int e(o$c o_c, int i) {
        o_c.parentQualifiedName_ = i;
        return i;
    }

    public static o$c getDefaultInstance() {
        return j;
    }

    public static o$c$b newBuilder(o$c o_c) {
        return newBuilder().mergeFrom(o_c);
    }

    public o$c$c getKind() {
        return this.kind_;
    }

    public int getParentQualifiedName() {
        return this.parentQualifiedName_;
    }

    @Override // d0.e0.p.d.m0.i.n
    public int getSerializedSize() {
        int i = this.memoizedSerializedSize;
        if (i != -1) {
            return i;
        }
        int iComputeInt32Size = (this.bitField0_ & 1) == 1 ? 0 + CodedOutputStream.computeInt32Size(1, this.parentQualifiedName_) : 0;
        if ((this.bitField0_ & 2) == 2) {
            iComputeInt32Size += CodedOutputStream.computeInt32Size(2, this.shortName_);
        }
        if ((this.bitField0_ & 4) == 4) {
            iComputeInt32Size += CodedOutputStream.computeEnumSize(3, this.kind_.getNumber());
        }
        int size = this.unknownFields.size() + iComputeInt32Size;
        this.memoizedSerializedSize = size;
        return size;
    }

    public int getShortName() {
        return this.shortName_;
    }

    public boolean hasKind() {
        return (this.bitField0_ & 4) == 4;
    }

    public boolean hasParentQualifiedName() {
        return (this.bitField0_ & 1) == 1;
    }

    public boolean hasShortName() {
        return (this.bitField0_ & 2) == 2;
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
        if (hasShortName()) {
            this.memoizedIsInitialized = (byte) 1;
            return true;
        }
        this.memoizedIsInitialized = (byte) 0;
        return false;
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
            codedOutputStream.writeInt32(1, this.parentQualifiedName_);
        }
        if ((this.bitField0_ & 2) == 2) {
            codedOutputStream.writeInt32(2, this.shortName_);
        }
        if ((this.bitField0_ & 4) == 4) {
            codedOutputStream.writeEnum(3, this.kind_.getNumber());
        }
        codedOutputStream.writeRawBytes(this.unknownFields);
    }

    public static o$c$b newBuilder() {
        return new o$c$b();
    }

    @Override // d0.e0.p.d.m0.i.n
    public o$c$b newBuilderForType() {
        return newBuilder();
    }

    @Override // d0.e0.p.d.m0.i.n
    public o$c$b toBuilder() {
        return newBuilder(this);
    }

    public o$c() {
        this.memoizedIsInitialized = (byte) -1;
        this.memoizedSerializedSize = -1;
        this.unknownFields = d0.e0.p.d.m0.i.c.j;
    }

    public o$c(d0.e0.p.d.m0.i.d dVar, d0.e0.p.d.m0.i.e eVar, a aVar) throws InvalidProtocolBufferException {
        this.memoizedIsInitialized = (byte) -1;
        this.memoizedSerializedSize = -1;
        this.parentQualifiedName_ = -1;
        boolean z2 = false;
        this.shortName_ = 0;
        this.kind_ = o$c$c.PACKAGE;
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
                                this.parentQualifiedName_ = dVar.readInt32();
                            } else if (tag == 16) {
                                this.bitField0_ |= 2;
                                this.shortName_ = dVar.readInt32();
                            } else if (tag != 24) {
                                if (!dVar.skipField(tag, codedOutputStreamNewInstance)) {
                                }
                            } else {
                                int i = dVar.readEnum();
                                o$c$c o_c_cValueOf = o$c$c.valueOf(i);
                                if (o_c_cValueOf == null) {
                                    codedOutputStreamNewInstance.writeRawVarint32(tag);
                                    codedOutputStreamNewInstance.writeRawVarint32(i);
                                } else {
                                    this.bitField0_ |= 4;
                                    this.kind_ = o_c_cValueOf;
                                }
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
