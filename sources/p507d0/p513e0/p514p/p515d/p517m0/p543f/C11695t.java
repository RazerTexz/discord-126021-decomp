package p507d0.p513e0.p514p.p515d.p517m0.p543f;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.protobuf.CodedOutputStream;
import kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException;
import kotlin.reflect.jvm.internal.impl.protobuf.UninitializedMessageException;
import p507d0.p513e0.p514p.p515d.p517m0.p550i.AbstractC11722b;
import p507d0.p513e0.p514p.p515d.p517m0.p550i.AbstractC11723c;
import p507d0.p513e0.p514p.p515d.p517m0.p550i.AbstractC11727g;
import p507d0.p513e0.p514p.p515d.p517m0.p550i.C11724d;
import p507d0.p513e0.p514p.p515d.p517m0.p550i.C11725e;
import p507d0.p513e0.p514p.p515d.p517m0.p550i.InterfaceC11735o;
import p507d0.p513e0.p514p.p515d.p517m0.p550i.InterfaceC11736p;

/* JADX INFO: renamed from: d0.e0.p.d.m0.f.t */
/* JADX INFO: compiled from: ProtoBuf.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C11695t extends AbstractC11727g implements InterfaceC11735o {

    /* JADX INFO: renamed from: j */
    public static final C11695t f23956j;

    /* JADX INFO: renamed from: k */
    public static InterfaceC11736p<C11695t> f23957k = new a();
    private int bitField0_;
    private int firstNullable_;
    private byte memoizedIsInitialized;
    private int memoizedSerializedSize;
    private List<C11692q> type_;
    private final AbstractC11723c unknownFields;

    /* JADX INFO: renamed from: d0.e0.p.d.m0.f.t$a */
    /* JADX INFO: compiled from: ProtoBuf.java */
    public static class a extends AbstractC11722b<C11695t> {
        @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.InterfaceC11736p
        public C11695t parsePartialFrom(C11724d c11724d, C11725e c11725e) throws InvalidProtocolBufferException {
            return new C11695t(c11724d, c11725e, null);
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.f.t$b */
    /* JADX INFO: compiled from: ProtoBuf.java */
    public static final class b extends AbstractC11727g.b<C11695t, b> implements InterfaceC11735o {

        /* JADX INFO: renamed from: k */
        public int f23958k;

        /* JADX INFO: renamed from: l */
        public List<C11692q> f23959l = Collections.emptyList();

        /* JADX INFO: renamed from: m */
        public int f23960m = -1;

        public C11695t buildPartial() {
            C11695t c11695t = new C11695t(this, null);
            int i = this.f23958k;
            if ((i & 1) == 1) {
                this.f23959l = Collections.unmodifiableList(this.f23959l);
                this.f23958k &= -2;
            }
            c11695t.type_ = this.f23959l;
            int i2 = (i & 2) != 2 ? 0 : 1;
            c11695t.firstNullable_ = this.f23960m;
            c11695t.bitField0_ = i2;
            return c11695t;
        }

        public b setFirstNullable(int i) {
            this.f23958k |= 2;
            this.f23960m = i;
            return this;
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.InterfaceC11734n.a
        public C11695t build() {
            C11695t c11695tBuildPartial = buildPartial();
            if (c11695tBuildPartial.isInitialized()) {
                return c11695tBuildPartial;
            }
            throw new UninitializedMessageException(c11695tBuildPartial);
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.AbstractC11727g.b
        /* JADX INFO: renamed from: clone */
        public b mo11465clone() {
            return new b().mergeFrom(buildPartial());
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.AbstractC11727g.b
        public b mergeFrom(C11695t c11695t) {
            if (c11695t == C11695t.getDefaultInstance()) {
                return this;
            }
            if (!c11695t.type_.isEmpty()) {
                if (this.f23959l.isEmpty()) {
                    this.f23959l = c11695t.type_;
                    this.f23958k &= -2;
                } else {
                    if ((this.f23958k & 1) != 1) {
                        this.f23959l = new ArrayList(this.f23959l);
                        this.f23958k |= 1;
                    }
                    this.f23959l.addAll(c11695t.type_);
                }
            }
            if (c11695t.hasFirstNullable()) {
                setFirstNullable(c11695t.getFirstNullable());
            }
            setUnknownFields(getUnknownFields().concat(c11695t.unknownFields));
            return this;
        }

        /* JADX WARN: Code duplicated, block: B:15:0x001d  */
        @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.AbstractC11721a.a, p507d0.p513e0.p514p.p515d.p517m0.p550i.InterfaceC11734n.a
        public b mergeFrom(C11724d c11724d, C11725e c11725e) throws Throwable {
            C11695t c11695t = null;
            try {
                try {
                    C11695t partialFrom = C11695t.f23957k.parsePartialFrom(c11724d, c11725e);
                    if (partialFrom != null) {
                        mergeFrom(partialFrom);
                    }
                    return this;
                } catch (InvalidProtocolBufferException e) {
                    C11695t c11695t2 = (C11695t) e.getUnfinishedMessage();
                    try {
                        throw e;
                    } catch (Throwable th) {
                        th = th;
                        c11695t = c11695t2;
                        if (c11695t != null) {
                            mergeFrom(c11695t);
                        }
                        throw th;
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                if (c11695t != null) {
                    mergeFrom(c11695t);
                }
                throw th;
            }
        }
    }

    static {
        C11695t c11695t = new C11695t();
        f23956j = c11695t;
        c11695t.type_ = Collections.emptyList();
        c11695t.firstNullable_ = -1;
    }

    public C11695t(AbstractC11727g.b bVar, C11666a c11666a) {
        super(bVar);
        this.memoizedIsInitialized = (byte) -1;
        this.memoizedSerializedSize = -1;
        this.unknownFields = bVar.getUnknownFields();
    }

    public static C11695t getDefaultInstance() {
        return f23956j;
    }

    public static b newBuilder(C11695t c11695t) {
        return newBuilder().mergeFrom(c11695t);
    }

    public int getFirstNullable() {
        return this.firstNullable_;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.InterfaceC11734n
    public int getSerializedSize() {
        int i = this.memoizedSerializedSize;
        if (i != -1) {
            return i;
        }
        int iComputeInt32Size = 0;
        for (int i2 = 0; i2 < this.type_.size(); i2++) {
            iComputeInt32Size += CodedOutputStream.computeMessageSize(1, this.type_.get(i2));
        }
        if ((this.bitField0_ & 1) == 1) {
            iComputeInt32Size += CodedOutputStream.computeInt32Size(2, this.firstNullable_);
        }
        int size = this.unknownFields.size() + iComputeInt32Size;
        this.memoizedSerializedSize = size;
        return size;
    }

    public C11692q getType(int i) {
        return this.type_.get(i);
    }

    public int getTypeCount() {
        return this.type_.size();
    }

    public List<C11692q> getTypeList() {
        return this.type_;
    }

    public boolean hasFirstNullable() {
        return (this.bitField0_ & 1) == 1;
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
        for (int i = 0; i < getTypeCount(); i++) {
            if (!getType(i).isInitialized()) {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            }
        }
        this.memoizedIsInitialized = (byte) 1;
        return true;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.InterfaceC11734n
    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        getSerializedSize();
        for (int i = 0; i < this.type_.size(); i++) {
            codedOutputStream.writeMessage(1, this.type_.get(i));
        }
        if ((this.bitField0_ & 1) == 1) {
            codedOutputStream.writeInt32(2, this.firstNullable_);
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

    public C11695t() {
        this.memoizedIsInitialized = (byte) -1;
        this.memoizedSerializedSize = -1;
        this.unknownFields = AbstractC11723c.f24100j;
    }

    public C11695t(C11724d c11724d, C11725e c11725e, C11666a c11666a) throws InvalidProtocolBufferException {
        this.memoizedIsInitialized = (byte) -1;
        this.memoizedSerializedSize = -1;
        this.type_ = Collections.emptyList();
        this.firstNullable_ = -1;
        AbstractC11723c.b bVarNewOutput = AbstractC11723c.newOutput();
        CodedOutputStream codedOutputStreamNewInstance = CodedOutputStream.newInstance(bVarNewOutput, 1);
        boolean z2 = false;
        boolean z3 = false;
        while (!z2) {
            try {
                try {
                    try {
                        int tag = c11724d.readTag();
                        if (tag != 0) {
                            if (tag == 10) {
                                if (!(z3 & true)) {
                                    this.type_ = new ArrayList();
                                    z3 |= true;
                                }
                                this.type_.add((C11692q) c11724d.readMessage(C11692q.f23904k, c11725e));
                            } else if (tag != 16) {
                                if (!c11724d.skipField(tag, codedOutputStreamNewInstance)) {
                                }
                            } else {
                                this.bitField0_ |= 1;
                                this.firstNullable_ = c11724d.readInt32();
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
                    this.type_ = Collections.unmodifiableList(this.type_);
                }
                try {
                    codedOutputStreamNewInstance.flush();
                } catch (IOException unused) {
                } finally {
                    this.unknownFields = bVarNewOutput.toByteString();
                }
                throw th;
            }
        }
        if (z3 & true) {
            this.type_ = Collections.unmodifiableList(this.type_);
        }
        try {
            codedOutputStreamNewInstance.flush();
        } catch (IOException unused2) {
        } finally {
            this.unknownFields = bVarNewOutput.toByteString();
        }
    }
}
