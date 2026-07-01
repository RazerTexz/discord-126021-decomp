package d0.e0.p.d.m0.f;

import java.io.IOException;
import kotlin.reflect.jvm.internal.impl.protobuf.CodedOutputStream;
import kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException;

/* JADX INFO: compiled from: ProtoBuf.java */
/* JADX INFO: loaded from: classes3.dex */
public final class p extends d0.e0.p.d.m0.i.g implements d0.e0.p.d.m0.i.o {
    public static final p j;
    public static d0.e0.p.d.m0.i.p<p> k = new p$a();
    private byte memoizedIsInitialized;
    private int memoizedSerializedSize;
    private d0.e0.p.d.m0.i.l string_;
    private final d0.e0.p.d.m0.i.c unknownFields;

    static {
        p pVar = new p();
        j = pVar;
        pVar.string_ = d0.e0.p.d.m0.i.k.j;
    }

    public p(d0.e0.p.d.m0.i.g$b g_b, a aVar) {
        super(g_b);
        this.memoizedIsInitialized = (byte) -1;
        this.memoizedSerializedSize = -1;
        this.unknownFields = g_b.getUnknownFields();
    }

    public static /* synthetic */ d0.e0.p.d.m0.i.l a(p pVar) {
        return pVar.string_;
    }

    public static /* synthetic */ d0.e0.p.d.m0.i.l b(p pVar, d0.e0.p.d.m0.i.l lVar) {
        pVar.string_ = lVar;
        return lVar;
    }

    public static /* synthetic */ d0.e0.p.d.m0.i.c c(p pVar) {
        return pVar.unknownFields;
    }

    public static p getDefaultInstance() {
        return j;
    }

    public static p$b newBuilder(p pVar) {
        return newBuilder().mergeFrom(pVar);
    }

    @Override // d0.e0.p.d.m0.i.n
    public int getSerializedSize() {
        int i = this.memoizedSerializedSize;
        if (i != -1) {
            return i;
        }
        int iComputeBytesSizeNoTag = 0;
        for (int i2 = 0; i2 < this.string_.size(); i2++) {
            iComputeBytesSizeNoTag += CodedOutputStream.computeBytesSizeNoTag(this.string_.getByteString(i2));
        }
        int size = this.unknownFields.size() + (getStringList().size() * 1) + 0 + iComputeBytesSizeNoTag;
        this.memoizedSerializedSize = size;
        return size;
    }

    public String getString(int i) {
        return this.string_.get(i);
    }

    public d0.e0.p.d.m0.i.q getStringList() {
        return this.string_;
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
        for (int i = 0; i < this.string_.size(); i++) {
            codedOutputStream.writeBytes(1, this.string_.getByteString(i));
        }
        codedOutputStream.writeRawBytes(this.unknownFields);
    }

    public static p$b newBuilder() {
        return new p$b();
    }

    @Override // d0.e0.p.d.m0.i.n
    public p$b newBuilderForType() {
        return newBuilder();
    }

    @Override // d0.e0.p.d.m0.i.n
    public p$b toBuilder() {
        return newBuilder(this);
    }

    public p() {
        this.memoizedIsInitialized = (byte) -1;
        this.memoizedSerializedSize = -1;
        this.unknownFields = d0.e0.p.d.m0.i.c.j;
    }

    public p(d0.e0.p.d.m0.i.d dVar, d0.e0.p.d.m0.i.e eVar, a aVar) throws InvalidProtocolBufferException {
        this.memoizedIsInitialized = (byte) -1;
        this.memoizedSerializedSize = -1;
        this.string_ = d0.e0.p.d.m0.i.k.j;
        d0.e0.p.d.m0.i.c$b c_bNewOutput = d0.e0.p.d.m0.i.c.newOutput();
        CodedOutputStream codedOutputStreamNewInstance = CodedOutputStream.newInstance(c_bNewOutput, 1);
        boolean z2 = false;
        boolean z3 = false;
        while (!z2) {
            try {
                try {
                    try {
                        int tag = dVar.readTag();
                        if (tag != 0) {
                            if (tag != 10) {
                                if (!dVar.skipField(tag, codedOutputStreamNewInstance)) {
                                }
                            } else {
                                d0.e0.p.d.m0.i.c bytes = dVar.readBytes();
                                if (!(z3 & true)) {
                                    this.string_ = new d0.e0.p.d.m0.i.k();
                                    z3 |= true;
                                }
                                this.string_.add(bytes);
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
                if (z3 & true) {
                    this.string_ = this.string_.getUnmodifiableView();
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
        if (z3 & true) {
            this.string_ = this.string_.getUnmodifiableView();
        }
        try {
            codedOutputStreamNewInstance.flush();
        } catch (IOException unused2) {
        } finally {
            this.unknownFields = c_bNewOutput.toByteString();
        }
    }
}
