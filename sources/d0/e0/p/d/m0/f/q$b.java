package d0.e0.p.d.m0.f;

import java.io.IOException;
import kotlin.reflect.jvm.internal.impl.protobuf.CodedOutputStream;
import kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException;

/* JADX INFO: compiled from: ProtoBuf.java */
/* JADX INFO: loaded from: classes3.dex */
public final class q$b extends d0.e0.p.d.m0.i.g implements d0.e0.p.d.m0.i.o {
    public static final q$b j;
    public static d0.e0.p.d.m0.i.p<q$b> k = new q$b$a();
    private int bitField0_;
    private byte memoizedIsInitialized;
    private int memoizedSerializedSize;
    private q$b$c projection_;
    private int typeId_;
    private q type_;
    private final d0.e0.p.d.m0.i.c unknownFields;

    static {
        q$b q_b = new q$b();
        j = q_b;
        q_b.projection_ = q$b$c.INV;
        q_b.type_ = q.getDefaultInstance();
        q_b.typeId_ = 0;
    }

    public q$b(d0.e0.p.d.m0.i.g$b g_b, a aVar) {
        super(g_b);
        this.memoizedIsInitialized = (byte) -1;
        this.memoizedSerializedSize = -1;
        this.unknownFields = g_b.getUnknownFields();
    }

    public static /* synthetic */ q$b$c a(q$b q_b, q$b$c q_b_c) {
        q_b.projection_ = q_b_c;
        return q_b_c;
    }

    public static /* synthetic */ q b(q$b q_b, q qVar) {
        q_b.type_ = qVar;
        return qVar;
    }

    public static /* synthetic */ int c(q$b q_b, int i) {
        q_b.typeId_ = i;
        return i;
    }

    public static /* synthetic */ int d(q$b q_b, int i) {
        q_b.bitField0_ = i;
        return i;
    }

    public static /* synthetic */ d0.e0.p.d.m0.i.c e(q$b q_b) {
        return q_b.unknownFields;
    }

    public static q$b getDefaultInstance() {
        return j;
    }

    public static q$b$b newBuilder(q$b q_b) {
        return newBuilder().mergeFrom(q_b);
    }

    public q$b$c getProjection() {
        return this.projection_;
    }

    @Override // d0.e0.p.d.m0.i.n
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

    @Override // d0.e0.p.d.m0.i.o
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

    public static q$b$b newBuilder() {
        return new q$b$b();
    }

    @Override // d0.e0.p.d.m0.i.n
    public q$b$b newBuilderForType() {
        return newBuilder();
    }

    @Override // d0.e0.p.d.m0.i.n
    public q$b$b toBuilder() {
        return newBuilder(this);
    }

    public q$b() {
        this.memoizedIsInitialized = (byte) -1;
        this.memoizedSerializedSize = -1;
        this.unknownFields = d0.e0.p.d.m0.i.c.j;
    }

    public q$b(d0.e0.p.d.m0.i.d dVar, d0.e0.p.d.m0.i.e eVar, a aVar) throws InvalidProtocolBufferException {
        this.memoizedIsInitialized = (byte) -1;
        this.memoizedSerializedSize = -1;
        this.projection_ = q$b$c.INV;
        this.type_ = q.getDefaultInstance();
        boolean z2 = false;
        this.typeId_ = 0;
        d0.e0.p.d.m0.i.c$b c_bNewOutput = d0.e0.p.d.m0.i.c.newOutput();
        CodedOutputStream codedOutputStreamNewInstance = CodedOutputStream.newInstance(c_bNewOutput, 1);
        while (!z2) {
            try {
                try {
                    try {
                        int tag = dVar.readTag();
                        if (tag != 0) {
                            if (tag == 8) {
                                int i = dVar.readEnum();
                                q$b$c q_b_cValueOf = q$b$c.valueOf(i);
                                if (q_b_cValueOf == null) {
                                    codedOutputStreamNewInstance.writeRawVarint32(tag);
                                    codedOutputStreamNewInstance.writeRawVarint32(i);
                                } else {
                                    this.bitField0_ |= 1;
                                    this.projection_ = q_b_cValueOf;
                                }
                            } else if (tag == 18) {
                                q$c builder = (this.bitField0_ & 2) == 2 ? this.type_.toBuilder() : null;
                                q qVar = (q) dVar.readMessage(q.k, eVar);
                                this.type_ = qVar;
                                if (builder != null) {
                                    builder.mergeFrom(qVar);
                                    this.type_ = builder.buildPartial();
                                }
                                this.bitField0_ |= 2;
                            } else if (tag != 24) {
                                if (!dVar.skipField(tag, codedOutputStreamNewInstance)) {
                                }
                            } else {
                                this.bitField0_ |= 4;
                                this.typeId_ = dVar.readInt32();
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
