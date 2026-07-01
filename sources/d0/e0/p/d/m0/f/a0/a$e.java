package d0.e0.p.d.m0.f.a0;

import d0.e0.p.d.m0.i.b;
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
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.protobuf.CodedOutputStream;
import kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException;

/* JADX INFO: compiled from: JvmProtoBuf.java */
/* JADX INFO: loaded from: classes3.dex */
public final class a$e extends g implements o {
    public static final a$e j;
    public static p<a$e> k = new a$e$a();
    private int localNameMemoizedSerializedSize;
    private List<Integer> localName_;
    private byte memoizedIsInitialized;
    private int memoizedSerializedSize;
    private List<a$e$c> record_;
    private final c unknownFields;

    static {
        a$e a_e = new a$e();
        j = a_e;
        a_e.record_ = Collections.emptyList();
        a_e.localName_ = Collections.emptyList();
    }

    public a$e(g$b g_b, a$a a_a) {
        super(g_b);
        this.localNameMemoizedSerializedSize = -1;
        this.memoizedIsInitialized = (byte) -1;
        this.memoizedSerializedSize = -1;
        this.unknownFields = g_b.getUnknownFields();
    }

    public static /* synthetic */ List a(a$e a_e) {
        return a_e.record_;
    }

    public static /* synthetic */ List b(a$e a_e, List list) {
        a_e.record_ = list;
        return list;
    }

    public static /* synthetic */ List c(a$e a_e) {
        return a_e.localName_;
    }

    public static /* synthetic */ List d(a$e a_e, List list) {
        a_e.localName_ = list;
        return list;
    }

    public static /* synthetic */ c e(a$e a_e) {
        return a_e.unknownFields;
    }

    public static a$e getDefaultInstance() {
        return j;
    }

    public static a$e$b newBuilder(a$e a_e) {
        return newBuilder().mergeFrom(a_e);
    }

    public static a$e parseDelimitedFrom(InputStream inputStream, e eVar) throws IOException {
        return (a$e) ((b) k).m89parseDelimitedFrom(inputStream, eVar);
    }

    public List<Integer> getLocalNameList() {
        return this.localName_;
    }

    public List<a$e$c> getRecordList() {
        return this.record_;
    }

    @Override // d0.e0.p.d.m0.i.n
    public int getSerializedSize() {
        int i = this.memoizedSerializedSize;
        if (i != -1) {
            return i;
        }
        int iComputeMessageSize = 0;
        for (int i2 = 0; i2 < this.record_.size(); i2++) {
            iComputeMessageSize += CodedOutputStream.computeMessageSize(1, this.record_.get(i2));
        }
        int iComputeInt32SizeNoTag = 0;
        for (int i3 = 0; i3 < this.localName_.size(); i3++) {
            iComputeInt32SizeNoTag += CodedOutputStream.computeInt32SizeNoTag(this.localName_.get(i3).intValue());
        }
        int iComputeInt32SizeNoTag2 = iComputeMessageSize + iComputeInt32SizeNoTag;
        if (!getLocalNameList().isEmpty()) {
            iComputeInt32SizeNoTag2 = iComputeInt32SizeNoTag2 + 1 + CodedOutputStream.computeInt32SizeNoTag(iComputeInt32SizeNoTag);
        }
        this.localNameMemoizedSerializedSize = iComputeInt32SizeNoTag;
        int size = this.unknownFields.size() + iComputeInt32SizeNoTag2;
        this.memoizedSerializedSize = size;
        return size;
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
        for (int i = 0; i < this.record_.size(); i++) {
            codedOutputStream.writeMessage(1, this.record_.get(i));
        }
        if (getLocalNameList().size() > 0) {
            codedOutputStream.writeRawVarint32(42);
            codedOutputStream.writeRawVarint32(this.localNameMemoizedSerializedSize);
        }
        for (int i2 = 0; i2 < this.localName_.size(); i2++) {
            codedOutputStream.writeInt32NoTag(this.localName_.get(i2).intValue());
        }
        codedOutputStream.writeRawBytes(this.unknownFields);
    }

    public static a$e$b newBuilder() {
        return new a$e$b();
    }

    @Override // d0.e0.p.d.m0.i.n
    public a$e$b newBuilderForType() {
        return newBuilder();
    }

    @Override // d0.e0.p.d.m0.i.n
    public a$e$b toBuilder() {
        return newBuilder(this);
    }

    public a$e() {
        this.localNameMemoizedSerializedSize = -1;
        this.memoizedIsInitialized = (byte) -1;
        this.memoizedSerializedSize = -1;
        this.unknownFields = c.j;
    }

    public a$e(d dVar, e eVar, a$a a_a) throws InvalidProtocolBufferException {
        this.localNameMemoizedSerializedSize = -1;
        this.memoizedIsInitialized = (byte) -1;
        this.memoizedSerializedSize = -1;
        this.record_ = Collections.emptyList();
        this.localName_ = Collections.emptyList();
        c$b c_bNewOutput = c.newOutput();
        CodedOutputStream codedOutputStreamNewInstance = CodedOutputStream.newInstance(c_bNewOutput, 1);
        boolean z2 = false;
        int i = 0;
        while (!z2) {
            try {
                try {
                    int tag = dVar.readTag();
                    if (tag != 0) {
                        if (tag == 10) {
                            if ((i & 1) != 1) {
                                this.record_ = new ArrayList();
                                i |= 1;
                            }
                            this.record_.add((a$e$c) dVar.readMessage(a$e$c.k, eVar));
                        } else if (tag == 40) {
                            if ((i & 2) != 2) {
                                this.localName_ = new ArrayList();
                                i |= 2;
                            }
                            this.localName_.add(Integer.valueOf(dVar.readInt32()));
                        } else if (tag != 42) {
                            if (!dVar.skipField(tag, codedOutputStreamNewInstance)) {
                            }
                        } else {
                            int iPushLimit = dVar.pushLimit(dVar.readRawVarint32());
                            if ((i & 2) != 2 && dVar.getBytesUntilLimit() > 0) {
                                this.localName_ = new ArrayList();
                                i |= 2;
                            }
                            while (dVar.getBytesUntilLimit() > 0) {
                                this.localName_.add(Integer.valueOf(dVar.readInt32()));
                            }
                            dVar.popLimit(iPushLimit);
                        }
                    }
                    z2 = true;
                } catch (InvalidProtocolBufferException e) {
                    throw e.setUnfinishedMessage(this);
                } catch (IOException e2) {
                    throw new InvalidProtocolBufferException(e2.getMessage()).setUnfinishedMessage(this);
                }
            } catch (Throwable th) {
                if ((i & 1) == 1) {
                    this.record_ = Collections.unmodifiableList(this.record_);
                }
                if ((i & 2) == 2) {
                    this.localName_ = Collections.unmodifiableList(this.localName_);
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
        if ((i & 1) == 1) {
            this.record_ = Collections.unmodifiableList(this.record_);
        }
        if ((i & 2) == 2) {
            this.localName_ = Collections.unmodifiableList(this.localName_);
        }
        try {
            codedOutputStreamNewInstance.flush();
        } catch (IOException unused2) {
        } finally {
            this.unknownFields = c_bNewOutput.toByteString();
        }
    }
}
