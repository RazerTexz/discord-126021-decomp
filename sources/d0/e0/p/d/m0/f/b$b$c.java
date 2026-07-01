package d0.e0.p.d.m0.f;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.protobuf.CodedOutputStream;
import kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException;

/* JADX INFO: compiled from: ProtoBuf.java */
/* JADX INFO: loaded from: classes3.dex */
public final class b$b$c extends d0.e0.p.d.m0.i.g implements d0.e0.p.d.m0.i.o {
    public static final b$b$c j;
    public static d0.e0.p.d.m0.i.p<b$b$c> k = new b$b$c$a();
    private b annotation_;
    private int arrayDimensionCount_;
    private List<b$b$c> arrayElement_;
    private int bitField0_;
    private int classId_;
    private double doubleValue_;
    private int enumValueId_;
    private int flags_;
    private float floatValue_;
    private long intValue_;
    private byte memoizedIsInitialized;
    private int memoizedSerializedSize;
    private int stringValue_;
    private b$b$c$c type_;
    private final d0.e0.p.d.m0.i.c unknownFields;

    static {
        b$b$c b_b_c = new b$b$c();
        j = b_b_c;
        b_b_c.o();
    }

    public b$b$c(d0.e0.p.d.m0.i.g$b g_b, a aVar) {
        super(g_b);
        this.memoizedIsInitialized = (byte) -1;
        this.memoizedSerializedSize = -1;
        this.unknownFields = g_b.getUnknownFields();
    }

    public static /* synthetic */ b$b$c$c a(b$b$c b_b_c, b$b$c$c b_b_c_c) {
        b_b_c.type_ = b_b_c_c;
        return b_b_c_c;
    }

    public static /* synthetic */ long b(b$b$c b_b_c, long j2) {
        b_b_c.intValue_ = j2;
        return j2;
    }

    public static /* synthetic */ float c(b$b$c b_b_c, float f) {
        b_b_c.floatValue_ = f;
        return f;
    }

    public static /* synthetic */ double d(b$b$c b_b_c, double d) {
        b_b_c.doubleValue_ = d;
        return d;
    }

    public static /* synthetic */ int e(b$b$c b_b_c, int i) {
        b_b_c.stringValue_ = i;
        return i;
    }

    public static /* synthetic */ int f(b$b$c b_b_c, int i) {
        b_b_c.classId_ = i;
        return i;
    }

    public static /* synthetic */ int g(b$b$c b_b_c, int i) {
        b_b_c.enumValueId_ = i;
        return i;
    }

    public static b$b$c getDefaultInstance() {
        return j;
    }

    public static /* synthetic */ b h(b$b$c b_b_c, b bVar) {
        b_b_c.annotation_ = bVar;
        return bVar;
    }

    public static /* synthetic */ List i(b$b$c b_b_c) {
        return b_b_c.arrayElement_;
    }

    public static /* synthetic */ List j(b$b$c b_b_c, List list) {
        b_b_c.arrayElement_ = list;
        return list;
    }

    public static /* synthetic */ int k(b$b$c b_b_c, int i) {
        b_b_c.arrayDimensionCount_ = i;
        return i;
    }

    public static /* synthetic */ int l(b$b$c b_b_c, int i) {
        b_b_c.flags_ = i;
        return i;
    }

    public static /* synthetic */ int m(b$b$c b_b_c, int i) {
        b_b_c.bitField0_ = i;
        return i;
    }

    public static /* synthetic */ d0.e0.p.d.m0.i.c n(b$b$c b_b_c) {
        return b_b_c.unknownFields;
    }

    public static b$b$c$b newBuilder(b$b$c b_b_c) {
        return newBuilder().mergeFrom(b_b_c);
    }

    public b getAnnotation() {
        return this.annotation_;
    }

    public int getArrayDimensionCount() {
        return this.arrayDimensionCount_;
    }

    public b$b$c getArrayElement(int i) {
        return this.arrayElement_.get(i);
    }

    public int getArrayElementCount() {
        return this.arrayElement_.size();
    }

    public List<b$b$c> getArrayElementList() {
        return this.arrayElement_;
    }

    public int getClassId() {
        return this.classId_;
    }

    public double getDoubleValue() {
        return this.doubleValue_;
    }

    public int getEnumValueId() {
        return this.enumValueId_;
    }

    public int getFlags() {
        return this.flags_;
    }

    public float getFloatValue() {
        return this.floatValue_;
    }

    public long getIntValue() {
        return this.intValue_;
    }

    @Override // d0.e0.p.d.m0.i.n
    public int getSerializedSize() {
        int i = this.memoizedSerializedSize;
        if (i != -1) {
            return i;
        }
        int iComputeEnumSize = (this.bitField0_ & 1) == 1 ? CodedOutputStream.computeEnumSize(1, this.type_.getNumber()) + 0 : 0;
        if ((this.bitField0_ & 2) == 2) {
            iComputeEnumSize += CodedOutputStream.computeSInt64Size(2, this.intValue_);
        }
        if ((this.bitField0_ & 4) == 4) {
            iComputeEnumSize += CodedOutputStream.computeFloatSize(3, this.floatValue_);
        }
        if ((this.bitField0_ & 8) == 8) {
            iComputeEnumSize += CodedOutputStream.computeDoubleSize(4, this.doubleValue_);
        }
        if ((this.bitField0_ & 16) == 16) {
            iComputeEnumSize += CodedOutputStream.computeInt32Size(5, this.stringValue_);
        }
        if ((this.bitField0_ & 32) == 32) {
            iComputeEnumSize += CodedOutputStream.computeInt32Size(6, this.classId_);
        }
        if ((this.bitField0_ & 64) == 64) {
            iComputeEnumSize += CodedOutputStream.computeInt32Size(7, this.enumValueId_);
        }
        if ((this.bitField0_ & 128) == 128) {
            iComputeEnumSize += CodedOutputStream.computeMessageSize(8, this.annotation_);
        }
        for (int i2 = 0; i2 < this.arrayElement_.size(); i2++) {
            iComputeEnumSize += CodedOutputStream.computeMessageSize(9, this.arrayElement_.get(i2));
        }
        if ((this.bitField0_ & 512) == 512) {
            iComputeEnumSize += CodedOutputStream.computeInt32Size(10, this.flags_);
        }
        if ((this.bitField0_ & 256) == 256) {
            iComputeEnumSize += CodedOutputStream.computeInt32Size(11, this.arrayDimensionCount_);
        }
        int size = this.unknownFields.size() + iComputeEnumSize;
        this.memoizedSerializedSize = size;
        return size;
    }

    public int getStringValue() {
        return this.stringValue_;
    }

    public b$b$c$c getType() {
        return this.type_;
    }

    public boolean hasAnnotation() {
        return (this.bitField0_ & 128) == 128;
    }

    public boolean hasArrayDimensionCount() {
        return (this.bitField0_ & 256) == 256;
    }

    public boolean hasClassId() {
        return (this.bitField0_ & 32) == 32;
    }

    public boolean hasDoubleValue() {
        return (this.bitField0_ & 8) == 8;
    }

    public boolean hasEnumValueId() {
        return (this.bitField0_ & 64) == 64;
    }

    public boolean hasFlags() {
        return (this.bitField0_ & 512) == 512;
    }

    public boolean hasFloatValue() {
        return (this.bitField0_ & 4) == 4;
    }

    public boolean hasIntValue() {
        return (this.bitField0_ & 2) == 2;
    }

    public boolean hasStringValue() {
        return (this.bitField0_ & 16) == 16;
    }

    public boolean hasType() {
        return (this.bitField0_ & 1) == 1;
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
        if (hasAnnotation() && !getAnnotation().isInitialized()) {
            this.memoizedIsInitialized = (byte) 0;
            return false;
        }
        for (int i = 0; i < getArrayElementCount(); i++) {
            if (!getArrayElement(i).isInitialized()) {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            }
        }
        this.memoizedIsInitialized = (byte) 1;
        return true;
    }

    @Override // d0.e0.p.d.m0.i.n
    public /* bridge */ /* synthetic */ d0.e0.p.d.m0.i.n$a newBuilderForType() {
        return newBuilderForType();
    }

    public final void o() {
        this.type_ = b$b$c$c.BYTE;
        this.intValue_ = 0L;
        this.floatValue_ = 0.0f;
        this.doubleValue_ = 0.0d;
        this.stringValue_ = 0;
        this.classId_ = 0;
        this.enumValueId_ = 0;
        this.annotation_ = b.getDefaultInstance();
        this.arrayElement_ = Collections.emptyList();
        this.arrayDimensionCount_ = 0;
        this.flags_ = 0;
    }

    @Override // d0.e0.p.d.m0.i.n
    public /* bridge */ /* synthetic */ d0.e0.p.d.m0.i.n$a toBuilder() {
        return toBuilder();
    }

    @Override // d0.e0.p.d.m0.i.n
    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        getSerializedSize();
        if ((this.bitField0_ & 1) == 1) {
            codedOutputStream.writeEnum(1, this.type_.getNumber());
        }
        if ((this.bitField0_ & 2) == 2) {
            codedOutputStream.writeSInt64(2, this.intValue_);
        }
        if ((this.bitField0_ & 4) == 4) {
            codedOutputStream.writeFloat(3, this.floatValue_);
        }
        if ((this.bitField0_ & 8) == 8) {
            codedOutputStream.writeDouble(4, this.doubleValue_);
        }
        if ((this.bitField0_ & 16) == 16) {
            codedOutputStream.writeInt32(5, this.stringValue_);
        }
        if ((this.bitField0_ & 32) == 32) {
            codedOutputStream.writeInt32(6, this.classId_);
        }
        if ((this.bitField0_ & 64) == 64) {
            codedOutputStream.writeInt32(7, this.enumValueId_);
        }
        if ((this.bitField0_ & 128) == 128) {
            codedOutputStream.writeMessage(8, this.annotation_);
        }
        for (int i = 0; i < this.arrayElement_.size(); i++) {
            codedOutputStream.writeMessage(9, this.arrayElement_.get(i));
        }
        if ((this.bitField0_ & 512) == 512) {
            codedOutputStream.writeInt32(10, this.flags_);
        }
        if ((this.bitField0_ & 256) == 256) {
            codedOutputStream.writeInt32(11, this.arrayDimensionCount_);
        }
        codedOutputStream.writeRawBytes(this.unknownFields);
    }

    public static b$b$c$b newBuilder() {
        return new b$b$c$b();
    }

    @Override // d0.e0.p.d.m0.i.n
    public b$b$c$b newBuilderForType() {
        return newBuilder();
    }

    @Override // d0.e0.p.d.m0.i.n
    public b$b$c$b toBuilder() {
        return newBuilder(this);
    }

    public b$b$c() {
        this.memoizedIsInitialized = (byte) -1;
        this.memoizedSerializedSize = -1;
        this.unknownFields = d0.e0.p.d.m0.i.c.j;
    }

    public b$b$c(d0.e0.p.d.m0.i.d dVar, d0.e0.p.d.m0.i.e eVar, a aVar) throws InvalidProtocolBufferException {
        this.memoizedIsInitialized = (byte) -1;
        this.memoizedSerializedSize = -1;
        o();
        d0.e0.p.d.m0.i.c$b c_bNewOutput = d0.e0.p.d.m0.i.c.newOutput();
        CodedOutputStream codedOutputStreamNewInstance = CodedOutputStream.newInstance(c_bNewOutput, 1);
        boolean z2 = false;
        int i = 0;
        while (!z2) {
            try {
                try {
                    int tag = dVar.readTag();
                    switch (tag) {
                        case 0:
                            break;
                        case 8:
                            int i2 = dVar.readEnum();
                            b$b$c$c b_b_c_cValueOf = b$b$c$c.valueOf(i2);
                            if (b_b_c_cValueOf == null) {
                                codedOutputStreamNewInstance.writeRawVarint32(tag);
                                codedOutputStreamNewInstance.writeRawVarint32(i2);
                            } else {
                                this.bitField0_ |= 1;
                                this.type_ = b_b_c_cValueOf;
                                continue;
                            }
                            break;
                        case 16:
                            this.bitField0_ |= 2;
                            this.intValue_ = dVar.readSInt64();
                            continue;
                        case 29:
                            this.bitField0_ |= 4;
                            this.floatValue_ = dVar.readFloat();
                            continue;
                        case 33:
                            this.bitField0_ |= 8;
                            this.doubleValue_ = dVar.readDouble();
                            continue;
                        case 40:
                            this.bitField0_ |= 16;
                            this.stringValue_ = dVar.readInt32();
                            continue;
                        case 48:
                            this.bitField0_ |= 32;
                            this.classId_ = dVar.readInt32();
                            continue;
                        case 56:
                            this.bitField0_ |= 64;
                            this.enumValueId_ = dVar.readInt32();
                            continue;
                        case 66:
                            b$c builder = (this.bitField0_ & 128) == 128 ? this.annotation_.toBuilder() : null;
                            b bVar = (b) dVar.readMessage(b.k, eVar);
                            this.annotation_ = bVar;
                            if (builder != null) {
                                builder.mergeFrom(bVar);
                                this.annotation_ = builder.buildPartial();
                            }
                            this.bitField0_ |= 128;
                            continue;
                        case 74:
                            if ((i & 256) != 256) {
                                this.arrayElement_ = new ArrayList();
                                i |= 256;
                            }
                            this.arrayElement_.add((b$b$c) dVar.readMessage(k, eVar));
                            continue;
                        case 80:
                            this.bitField0_ |= 512;
                            this.flags_ = dVar.readInt32();
                            continue;
                        case 88:
                            this.bitField0_ |= 256;
                            this.arrayDimensionCount_ = dVar.readInt32();
                            continue;
                        default:
                            if (!dVar.skipField(tag, codedOutputStreamNewInstance)) {
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
                if ((i & 256) == 256) {
                    this.arrayElement_ = Collections.unmodifiableList(this.arrayElement_);
                }
                try {
                    codedOutputStreamNewInstance.flush();
                } catch (IOException unused) {
                } finally {
                    this.unknownFields = c_bNewOutput.toByteString();
                }
                throw th;
            }
        }
        if ((i & 256) == 256) {
            this.arrayElement_ = Collections.unmodifiableList(this.arrayElement_);
        }
        try {
            codedOutputStreamNewInstance.flush();
        } catch (IOException unused2) {
        } finally {
            this.unknownFields = c_bNewOutput.toByteString();
        }
    }
}
