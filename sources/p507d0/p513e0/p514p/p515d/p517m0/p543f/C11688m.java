package p507d0.p513e0.p514p.p515d.p517m0.p543f;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.protobuf.CodedOutputStream;
import kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException;
import kotlin.reflect.jvm.internal.impl.protobuf.UninitializedMessageException;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.C11687l;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.C11690o;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.C11691p;
import p507d0.p513e0.p514p.p515d.p517m0.p550i.AbstractC11722b;
import p507d0.p513e0.p514p.p515d.p517m0.p550i.AbstractC11723c;
import p507d0.p513e0.p514p.p515d.p517m0.p550i.AbstractC11727g;
import p507d0.p513e0.p514p.p515d.p517m0.p550i.C11724d;
import p507d0.p513e0.p514p.p515d.p517m0.p550i.C11725e;
import p507d0.p513e0.p514p.p515d.p517m0.p550i.InterfaceC11735o;
import p507d0.p513e0.p514p.p515d.p517m0.p550i.InterfaceC11736p;

/* JADX INFO: renamed from: d0.e0.p.d.m0.f.m */
/* JADX INFO: compiled from: ProtoBuf.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C11688m extends AbstractC11727g.d<C11688m> implements InterfaceC11735o {

    /* JADX INFO: renamed from: j */
    public static final C11688m f23863j;

    /* JADX INFO: renamed from: k */
    public static InterfaceC11736p<C11688m> f23864k = new a();
    private int bitField0_;
    private List<C11678c> class__;
    private byte memoizedIsInitialized;
    private int memoizedSerializedSize;
    private C11687l package_;
    private C11690o qualifiedNames_;
    private C11691p strings_;
    private final AbstractC11723c unknownFields;

    /* JADX INFO: renamed from: d0.e0.p.d.m0.f.m$a */
    /* JADX INFO: compiled from: ProtoBuf.java */
    public static class a extends AbstractC11722b<C11688m> {
        @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.InterfaceC11736p
        public C11688m parsePartialFrom(C11724d c11724d, C11725e c11725e) throws InvalidProtocolBufferException {
            return new C11688m(c11724d, c11725e, null);
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.f.m$b */
    /* JADX INFO: compiled from: ProtoBuf.java */
    public static final class b extends AbstractC11727g.c<C11688m, b> implements InterfaceC11735o {

        /* JADX INFO: renamed from: m */
        public int f23865m;

        /* JADX INFO: renamed from: n */
        public C11691p f23866n = C11691p.getDefaultInstance();

        /* JADX INFO: renamed from: o */
        public C11690o f23867o = C11690o.getDefaultInstance();

        /* JADX INFO: renamed from: p */
        public C11687l f23868p = C11687l.getDefaultInstance();

        /* JADX INFO: renamed from: q */
        public List<C11678c> f23869q = Collections.emptyList();

        public C11688m buildPartial() {
            C11688m c11688m = new C11688m(this, null);
            int i = this.f23865m;
            int i2 = (i & 1) != 1 ? 0 : 1;
            c11688m.strings_ = this.f23866n;
            if ((i & 2) == 2) {
                i2 |= 2;
            }
            c11688m.qualifiedNames_ = this.f23867o;
            if ((i & 4) == 4) {
                i2 |= 4;
            }
            c11688m.package_ = this.f23868p;
            if ((this.f23865m & 8) == 8) {
                this.f23869q = Collections.unmodifiableList(this.f23869q);
                this.f23865m &= -9;
            }
            c11688m.class__ = this.f23869q;
            c11688m.bitField0_ = i2;
            return c11688m;
        }

        public b mergePackage(C11687l c11687l) {
            if ((this.f23865m & 4) != 4 || this.f23868p == C11687l.getDefaultInstance()) {
                this.f23868p = c11687l;
            } else {
                this.f23868p = C11687l.newBuilder(this.f23868p).mergeFrom(c11687l).buildPartial();
            }
            this.f23865m |= 4;
            return this;
        }

        public b mergeQualifiedNames(C11690o c11690o) {
            if ((this.f23865m & 2) != 2 || this.f23867o == C11690o.getDefaultInstance()) {
                this.f23867o = c11690o;
            } else {
                this.f23867o = C11690o.newBuilder(this.f23867o).mergeFrom(c11690o).buildPartial();
            }
            this.f23865m |= 2;
            return this;
        }

        public b mergeStrings(C11691p c11691p) {
            if ((this.f23865m & 1) != 1 || this.f23866n == C11691p.getDefaultInstance()) {
                this.f23866n = c11691p;
            } else {
                this.f23866n = C11691p.newBuilder(this.f23866n).mergeFrom(c11691p).buildPartial();
            }
            this.f23865m |= 1;
            return this;
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.InterfaceC11734n.a
        public C11688m build() {
            C11688m c11688mBuildPartial = buildPartial();
            if (c11688mBuildPartial.isInitialized()) {
                return c11688mBuildPartial;
            }
            throw new UninitializedMessageException(c11688mBuildPartial);
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.AbstractC11727g.b
        /* JADX INFO: renamed from: clone */
        public b mo11465clone() {
            return new b().mergeFrom(buildPartial());
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.AbstractC11727g.b
        public b mergeFrom(C11688m c11688m) {
            if (c11688m == C11688m.getDefaultInstance()) {
                return this;
            }
            if (c11688m.hasStrings()) {
                mergeStrings(c11688m.getStrings());
            }
            if (c11688m.hasQualifiedNames()) {
                mergeQualifiedNames(c11688m.getQualifiedNames());
            }
            if (c11688m.hasPackage()) {
                mergePackage(c11688m.getPackage());
            }
            if (!c11688m.class__.isEmpty()) {
                if (this.f23869q.isEmpty()) {
                    this.f23869q = c11688m.class__;
                    this.f23865m &= -9;
                } else {
                    if ((this.f23865m & 8) != 8) {
                        this.f23869q = new ArrayList(this.f23869q);
                        this.f23865m |= 8;
                    }
                    this.f23869q.addAll(c11688m.class__);
                }
            }
            m9846b(c11688m);
            setUnknownFields(getUnknownFields().concat(c11688m.unknownFields));
            return this;
        }

        /* JADX WARN: Code duplicated, block: B:15:0x001d  */
        @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.AbstractC11721a.a, p507d0.p513e0.p514p.p515d.p517m0.p550i.InterfaceC11734n.a
        public b mergeFrom(C11724d c11724d, C11725e c11725e) throws Throwable {
            C11688m c11688m = null;
            try {
                try {
                    C11688m partialFrom = C11688m.f23864k.parsePartialFrom(c11724d, c11725e);
                    if (partialFrom != null) {
                        mergeFrom(partialFrom);
                    }
                    return this;
                } catch (InvalidProtocolBufferException e) {
                    C11688m c11688m2 = (C11688m) e.getUnfinishedMessage();
                    try {
                        throw e;
                    } catch (Throwable th) {
                        th = th;
                        c11688m = c11688m2;
                        if (c11688m != null) {
                            mergeFrom(c11688m);
                        }
                        throw th;
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                if (c11688m != null) {
                    mergeFrom(c11688m);
                }
                throw th;
            }
        }
    }

    static {
        C11688m c11688m = new C11688m();
        f23863j = c11688m;
        c11688m.m9710o();
    }

    public C11688m(AbstractC11727g.c cVar, C11666a c11666a) {
        super(cVar);
        this.memoizedIsInitialized = (byte) -1;
        this.memoizedSerializedSize = -1;
        this.unknownFields = cVar.getUnknownFields();
    }

    public static C11688m getDefaultInstance() {
        return f23863j;
    }

    public static b newBuilder(C11688m c11688m) {
        return newBuilder().mergeFrom(c11688m);
    }

    public static C11688m parseFrom(InputStream inputStream, C11725e c11725e) throws IOException {
        return (C11688m) ((AbstractC11722b) f23864k).m11467parseFrom(inputStream, c11725e);
    }

    public C11678c getClass_(int i) {
        return this.class__.get(i);
    }

    public int getClass_Count() {
        return this.class__.size();
    }

    public List<C11678c> getClass_List() {
        return this.class__;
    }

    public C11687l getPackage() {
        return this.package_;
    }

    public C11690o getQualifiedNames() {
        return this.qualifiedNames_;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.InterfaceC11734n
    public int getSerializedSize() {
        int i = this.memoizedSerializedSize;
        if (i != -1) {
            return i;
        }
        int iComputeMessageSize = (this.bitField0_ & 1) == 1 ? CodedOutputStream.computeMessageSize(1, this.strings_) + 0 : 0;
        if ((this.bitField0_ & 2) == 2) {
            iComputeMessageSize += CodedOutputStream.computeMessageSize(2, this.qualifiedNames_);
        }
        if ((this.bitField0_ & 4) == 4) {
            iComputeMessageSize += CodedOutputStream.computeMessageSize(3, this.package_);
        }
        for (int i2 = 0; i2 < this.class__.size(); i2++) {
            iComputeMessageSize += CodedOutputStream.computeMessageSize(4, this.class__.get(i2));
        }
        int size = this.unknownFields.size() + m9849c() + iComputeMessageSize;
        this.memoizedSerializedSize = size;
        return size;
    }

    public C11691p getStrings() {
        return this.strings_;
    }

    public boolean hasPackage() {
        return (this.bitField0_ & 4) == 4;
    }

    public boolean hasQualifiedNames() {
        return (this.bitField0_ & 2) == 2;
    }

    public boolean hasStrings() {
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
        if (hasQualifiedNames() && !getQualifiedNames().isInitialized()) {
            this.memoizedIsInitialized = (byte) 0;
            return false;
        }
        if (hasPackage() && !getPackage().isInitialized()) {
            this.memoizedIsInitialized = (byte) 0;
            return false;
        }
        for (int i = 0; i < getClass_Count(); i++) {
            if (!getClass_(i).isInitialized()) {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            }
        }
        if (m9848b()) {
            this.memoizedIsInitialized = (byte) 1;
            return true;
        }
        this.memoizedIsInitialized = (byte) 0;
        return false;
    }

    /* JADX INFO: renamed from: o */
    public final void m9710o() {
        this.strings_ = C11691p.getDefaultInstance();
        this.qualifiedNames_ = C11690o.getDefaultInstance();
        this.package_ = C11687l.getDefaultInstance();
        this.class__ = Collections.emptyList();
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.InterfaceC11734n
    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        getSerializedSize();
        AbstractC11727g.d<MessageType>.a aVarM9851e = m9851e();
        if ((this.bitField0_ & 1) == 1) {
            codedOutputStream.writeMessage(1, this.strings_);
        }
        if ((this.bitField0_ & 2) == 2) {
            codedOutputStream.writeMessage(2, this.qualifiedNames_);
        }
        if ((this.bitField0_ & 4) == 4) {
            codedOutputStream.writeMessage(3, this.package_);
        }
        for (int i = 0; i < this.class__.size(); i++) {
            codedOutputStream.writeMessage(4, this.class__.get(i));
        }
        aVarM9851e.writeUntil(200, codedOutputStream);
        codedOutputStream.writeRawBytes(this.unknownFields);
    }

    public static b newBuilder() {
        return new b();
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.InterfaceC11735o
    public C11688m getDefaultInstanceForType() {
        return f23863j;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.InterfaceC11734n
    public b newBuilderForType() {
        return newBuilder();
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.InterfaceC11734n
    public b toBuilder() {
        return newBuilder(this);
    }

    public C11688m() {
        this.memoizedIsInitialized = (byte) -1;
        this.memoizedSerializedSize = -1;
        this.unknownFields = AbstractC11723c.f24100j;
    }

    public C11688m(C11724d c11724d, C11725e c11725e, C11666a c11666a) throws InvalidProtocolBufferException {
        this.memoizedIsInitialized = (byte) -1;
        this.memoizedSerializedSize = -1;
        m9710o();
        AbstractC11723c.b bVarNewOutput = AbstractC11723c.newOutput();
        CodedOutputStream codedOutputStreamNewInstance = CodedOutputStream.newInstance(bVarNewOutput, 1);
        boolean z2 = false;
        int i = 0;
        while (!z2) {
            try {
                try {
                    try {
                        int tag = c11724d.readTag();
                        if (tag != 0) {
                            if (tag == 10) {
                                C11691p.b builder = (this.bitField0_ & 1) == 1 ? this.strings_.toBuilder() : null;
                                C11691p c11691p = (C11691p) c11724d.readMessage(C11691p.f23900k, c11725e);
                                this.strings_ = c11691p;
                                if (builder != null) {
                                    builder.mergeFrom(c11691p);
                                    this.strings_ = builder.buildPartial();
                                }
                                this.bitField0_ |= 1;
                            } else if (tag == 18) {
                                C11690o.b builder2 = (this.bitField0_ & 2) == 2 ? this.qualifiedNames_.toBuilder() : null;
                                C11690o c11690o = (C11690o) c11724d.readMessage(C11690o.f23886k, c11725e);
                                this.qualifiedNames_ = c11690o;
                                if (builder2 != null) {
                                    builder2.mergeFrom(c11690o);
                                    this.qualifiedNames_ = builder2.buildPartial();
                                }
                                this.bitField0_ |= 2;
                            } else if (tag == 26) {
                                C11687l.b builder3 = (this.bitField0_ & 4) == 4 ? this.package_.toBuilder() : null;
                                C11687l c11687l = (C11687l) c11724d.readMessage(C11687l.f23856k, c11725e);
                                this.package_ = c11687l;
                                if (builder3 != null) {
                                    builder3.mergeFrom(c11687l);
                                    this.package_ = builder3.buildPartial();
                                }
                                this.bitField0_ |= 4;
                            } else if (tag != 34) {
                                if (!m9852f(c11724d, codedOutputStreamNewInstance, c11725e, tag)) {
                                }
                            } else {
                                if ((i & 8) != 8) {
                                    this.class__ = new ArrayList();
                                    i |= 8;
                                }
                                this.class__.add((C11678c) c11724d.readMessage(C11678c.f23761k, c11725e));
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
                if ((i & 8) == 8) {
                    this.class__ = Collections.unmodifiableList(this.class__);
                }
                try {
                    codedOutputStreamNewInstance.flush();
                } catch (IOException unused) {
                } catch (Throwable th2) {
                    this.unknownFields = bVarNewOutput.toByteString();
                    throw th2;
                }
                this.unknownFields = bVarNewOutput.toByteString();
                m9850d();
                throw th;
            }
        }
        if ((i & 8) == 8) {
            this.class__ = Collections.unmodifiableList(this.class__);
        }
        try {
            codedOutputStreamNewInstance.flush();
        } catch (IOException unused2) {
        } catch (Throwable th3) {
            this.unknownFields = bVarNewOutput.toByteString();
            throw th3;
        }
        this.unknownFields = bVarNewOutput.toByteString();
        m9850d();
    }
}
