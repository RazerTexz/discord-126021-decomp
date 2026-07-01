package d0.e0.p.d.m0.f;

import java.io.IOException;
import kotlin.reflect.jvm.internal.impl.protobuf.CodedOutputStream;
import kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException;

/* JADX INFO: compiled from: ProtoBuf.java */
/* JADX INFO: loaded from: classes3.dex */
public final class b$b extends d0.e0.p.d.m0.i.g implements d0.e0.p.d.m0.i.o {
    public static final b$b j;
    public static d0.e0.p.d.m0.i.p<b$b> k = new b$b$a();
    private int bitField0_;
    private byte memoizedIsInitialized;
    private int memoizedSerializedSize;
    private int nameId_;
    private final d0.e0.p.d.m0.i.c unknownFields;
    private b$b$c value_;

    static {
        b$b b_b = new b$b();
        j = b_b;
        b_b.nameId_ = 0;
        b_b.value_ = b$b$c.getDefaultInstance();
    }

    public b$b(d0.e0.p.d.m0.i.g$b g_b, a aVar) {
        super(g_b);
        this.memoizedIsInitialized = (byte) -1;
        this.memoizedSerializedSize = -1;
        this.unknownFields = g_b.getUnknownFields();
    }

    public static /* synthetic */ int a(b$b b_b, int i) {
        b_b.nameId_ = i;
        return i;
    }

    public static /* synthetic */ b$b$c b(b$b b_b, b$b$c b_b_c) {
        b_b.value_ = b_b_c;
        return b_b_c;
    }

    public static /* synthetic */ int c(b$b b_b, int i) {
        b_b.bitField0_ = i;
        return i;
    }

    public static /* synthetic */ d0.e0.p.d.m0.i.c d(b$b b_b) {
        return b_b.unknownFields;
    }

    public static b$b getDefaultInstance() {
        return j;
    }

    public static b$b$b newBuilder(b$b b_b) {
        return newBuilder().mergeFrom(b_b);
    }

    public int getNameId() {
        return this.nameId_;
    }

    @Override // d0.e0.p.d.m0.i.n
    public int getSerializedSize() {
        int i = this.memoizedSerializedSize;
        if (i != -1) {
            return i;
        }
        int iComputeInt32Size = (this.bitField0_ & 1) == 1 ? 0 + CodedOutputStream.computeInt32Size(1, this.nameId_) : 0;
        if ((this.bitField0_ & 2) == 2) {
            iComputeInt32Size += CodedOutputStream.computeMessageSize(2, this.value_);
        }
        int size = this.unknownFields.size() + iComputeInt32Size;
        this.memoizedSerializedSize = size;
        return size;
    }

    public b$b$c getValue() {
        return this.value_;
    }

    public boolean hasNameId() {
        return (this.bitField0_ & 1) == 1;
    }

    public boolean hasValue() {
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
        if (!hasNameId()) {
            this.memoizedIsInitialized = (byte) 0;
            return false;
        }
        if (!hasValue()) {
            this.memoizedIsInitialized = (byte) 0;
            return false;
        }
        if (getValue().isInitialized()) {
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
            codedOutputStream.writeInt32(1, this.nameId_);
        }
        if ((this.bitField0_ & 2) == 2) {
            codedOutputStream.writeMessage(2, this.value_);
        }
        codedOutputStream.writeRawBytes(this.unknownFields);
    }

    public static b$b$b newBuilder() {
        return new b$b$b();
    }

    @Override // d0.e0.p.d.m0.i.n
    public b$b$b newBuilderForType() {
        return newBuilder();
    }

    @Override // d0.e0.p.d.m0.i.n
    public b$b$b toBuilder() {
        return newBuilder(this);
    }

    public b$b() {
        this.memoizedIsInitialized = (byte) -1;
        this.memoizedSerializedSize = -1;
        this.unknownFields = d0.e0.p.d.m0.i.c.j;
    }

    public b$b(d0.e0.p.d.m0.i.d dVar, d0.e0.p.d.m0.i.e eVar, a aVar) throws InvalidProtocolBufferException {
        this.memoizedIsInitialized = (byte) -1;
        this.memoizedSerializedSize = -1;
        boolean z2 = false;
        this.nameId_ = 0;
        this.value_ = b$b$c.getDefaultInstance();
        d0.e0.p.d.m0.i.c$b c_bNewOutput = d0.e0.p.d.m0.i.c.newOutput();
        CodedOutputStream codedOutputStreamNewInstance = CodedOutputStream.newInstance(c_bNewOutput, 1);
        while (!z2) {
            try {
                try {
                    int tag = dVar.readTag();
                    if (tag != 0) {
                        if (tag == 8) {
                            this.bitField0_ |= 1;
                            this.nameId_ = dVar.readInt32();
                        } else if (tag != 18) {
                            if (!dVar.skipField(tag, codedOutputStreamNewInstance)) {
                            }
                        } else {
                            b$b$c$b builder = (this.bitField0_ & 2) == 2 ? this.value_.toBuilder() : null;
                            b$b$c b_b_c = (b$b$c) dVar.readMessage(b$b$c.k, eVar);
                            this.value_ = b_b_c;
                            if (builder != null) {
                                builder.mergeFrom(b_b_c);
                                this.value_ = builder.buildPartial();
                            }
                            this.bitField0_ |= 2;
                        }
                    }
                    z2 = true;
                } catch (InvalidProtocolBufferException e) {
                    throw e.setUnfinishedMessage(this);
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
