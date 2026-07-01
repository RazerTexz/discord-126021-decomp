package d0.e0.p.d.m0.f.a0;

import d0.e0.p.d.m0.i.c;
import d0.e0.p.d.m0.i.c$b;
import d0.e0.p.d.m0.i.d;
import d0.e0.p.d.m0.i.e;
import d0.e0.p.d.m0.i.g;
import d0.e0.p.d.m0.i.g$b;
import d0.e0.p.d.m0.i.n$a;
import d0.e0.p.d.m0.i.o;
import d0.e0.p.d.m0.i.p;
import java.io.IOException;
import kotlin.reflect.jvm.internal.impl.protobuf.CodedOutputStream;
import kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException;

/* JADX INFO: compiled from: JvmProtoBuf.java */
/* JADX INFO: loaded from: classes3.dex */
public final class a$d extends g implements o {
    public static final a$d j;
    public static p<a$d> k = new a$d$a();
    private int bitField0_;
    private a$b field_;
    private a$c getter_;
    private byte memoizedIsInitialized;
    private int memoizedSerializedSize;
    private a$c setter_;
    private a$c syntheticMethod_;
    private final c unknownFields;

    static {
        a$d a_d = new a$d();
        j = a_d;
        a_d.g();
    }

    public a$d(g$b g_b, a$a a_a) {
        super(g_b);
        this.memoizedIsInitialized = (byte) -1;
        this.memoizedSerializedSize = -1;
        this.unknownFields = g_b.getUnknownFields();
    }

    public static /* synthetic */ a$b a(a$d a_d, a$b a_b) {
        a_d.field_ = a_b;
        return a_b;
    }

    public static /* synthetic */ a$c b(a$d a_d, a$c a_c) {
        a_d.syntheticMethod_ = a_c;
        return a_c;
    }

    public static /* synthetic */ a$c c(a$d a_d, a$c a_c) {
        a_d.getter_ = a_c;
        return a_c;
    }

    public static /* synthetic */ a$c d(a$d a_d, a$c a_c) {
        a_d.setter_ = a_c;
        return a_c;
    }

    public static /* synthetic */ int e(a$d a_d, int i) {
        a_d.bitField0_ = i;
        return i;
    }

    public static /* synthetic */ c f(a$d a_d) {
        return a_d.unknownFields;
    }

    public static a$d getDefaultInstance() {
        return j;
    }

    public static a$d$b newBuilder(a$d a_d) {
        return newBuilder().mergeFrom(a_d);
    }

    public final void g() {
        this.field_ = a$b.getDefaultInstance();
        this.syntheticMethod_ = a$c.getDefaultInstance();
        this.getter_ = a$c.getDefaultInstance();
        this.setter_ = a$c.getDefaultInstance();
    }

    public a$b getField() {
        return this.field_;
    }

    public a$c getGetter() {
        return this.getter_;
    }

    @Override // d0.e0.p.d.m0.i.n
    public int getSerializedSize() {
        int i = this.memoizedSerializedSize;
        if (i != -1) {
            return i;
        }
        int iComputeMessageSize = (this.bitField0_ & 1) == 1 ? 0 + CodedOutputStream.computeMessageSize(1, this.field_) : 0;
        if ((this.bitField0_ & 2) == 2) {
            iComputeMessageSize += CodedOutputStream.computeMessageSize(2, this.syntheticMethod_);
        }
        if ((this.bitField0_ & 4) == 4) {
            iComputeMessageSize += CodedOutputStream.computeMessageSize(3, this.getter_);
        }
        if ((this.bitField0_ & 8) == 8) {
            iComputeMessageSize += CodedOutputStream.computeMessageSize(4, this.setter_);
        }
        int size = this.unknownFields.size() + iComputeMessageSize;
        this.memoizedSerializedSize = size;
        return size;
    }

    public a$c getSetter() {
        return this.setter_;
    }

    public a$c getSyntheticMethod() {
        return this.syntheticMethod_;
    }

    public boolean hasField() {
        return (this.bitField0_ & 1) == 1;
    }

    public boolean hasGetter() {
        return (this.bitField0_ & 4) == 4;
    }

    public boolean hasSetter() {
        return (this.bitField0_ & 8) == 8;
    }

    public boolean hasSyntheticMethod() {
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
        this.memoizedIsInitialized = (byte) 1;
        return true;
    }

    @Override // d0.e0.p.d.m0.i.n
    public /* bridge */ /* synthetic */ n$a newBuilderForType() {
        return newBuilderForType();
    }

    @Override // d0.e0.p.d.m0.i.n
    public /* bridge */ /* synthetic */ n$a toBuilder() {
        return toBuilder();
    }

    @Override // d0.e0.p.d.m0.i.n
    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        getSerializedSize();
        if ((this.bitField0_ & 1) == 1) {
            codedOutputStream.writeMessage(1, this.field_);
        }
        if ((this.bitField0_ & 2) == 2) {
            codedOutputStream.writeMessage(2, this.syntheticMethod_);
        }
        if ((this.bitField0_ & 4) == 4) {
            codedOutputStream.writeMessage(3, this.getter_);
        }
        if ((this.bitField0_ & 8) == 8) {
            codedOutputStream.writeMessage(4, this.setter_);
        }
        codedOutputStream.writeRawBytes(this.unknownFields);
    }

    public static a$d$b newBuilder() {
        return new a$d$b();
    }

    @Override // d0.e0.p.d.m0.i.n
    public a$d$b newBuilderForType() {
        return newBuilder();
    }

    @Override // d0.e0.p.d.m0.i.n
    public a$d$b toBuilder() {
        return newBuilder(this);
    }

    public a$d() {
        this.memoizedIsInitialized = (byte) -1;
        this.memoizedSerializedSize = -1;
        this.unknownFields = c.j;
    }

    public a$d(d dVar, e eVar, a$a a_a) throws InvalidProtocolBufferException {
        this.memoizedIsInitialized = (byte) -1;
        this.memoizedSerializedSize = -1;
        g();
        c$b c_bNewOutput = c.newOutput();
        CodedOutputStream codedOutputStreamNewInstance = CodedOutputStream.newInstance(c_bNewOutput, 1);
        boolean z2 = false;
        while (!z2) {
            try {
                try {
                    int tag = dVar.readTag();
                    if (tag != 0) {
                        if (tag == 10) {
                            a$b$b builder = (this.bitField0_ & 1) == 1 ? this.field_.toBuilder() : null;
                            a$b a_b = (a$b) dVar.readMessage(a$b.k, eVar);
                            this.field_ = a_b;
                            if (builder != null) {
                                builder.mergeFrom(a_b);
                                this.field_ = builder.buildPartial();
                            }
                            this.bitField0_ |= 1;
                        } else if (tag == 18) {
                            a$c$b builder2 = (this.bitField0_ & 2) == 2 ? this.syntheticMethod_.toBuilder() : null;
                            a$c a_c = (a$c) dVar.readMessage(a$c.k, eVar);
                            this.syntheticMethod_ = a_c;
                            if (builder2 != null) {
                                builder2.mergeFrom(a_c);
                                this.syntheticMethod_ = builder2.buildPartial();
                            }
                            this.bitField0_ |= 2;
                        } else if (tag == 26) {
                            a$c$b builder3 = (this.bitField0_ & 4) == 4 ? this.getter_.toBuilder() : null;
                            a$c a_c2 = (a$c) dVar.readMessage(a$c.k, eVar);
                            this.getter_ = a_c2;
                            if (builder3 != null) {
                                builder3.mergeFrom(a_c2);
                                this.getter_ = builder3.buildPartial();
                            }
                            this.bitField0_ |= 4;
                        } else if (tag != 34) {
                            if (!dVar.skipField(tag, codedOutputStreamNewInstance)) {
                            }
                        } else {
                            a$c$b builder4 = (this.bitField0_ & 8) == 8 ? this.setter_.toBuilder() : null;
                            a$c a_c3 = (a$c) dVar.readMessage(a$c.k, eVar);
                            this.setter_ = a_c3;
                            if (builder4 != null) {
                                builder4.mergeFrom(a_c3);
                                this.setter_ = builder4.buildPartial();
                            }
                            this.bitField0_ |= 8;
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
