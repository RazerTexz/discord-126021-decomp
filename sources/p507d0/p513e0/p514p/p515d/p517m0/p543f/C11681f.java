package p507d0.p513e0.p514p.p515d.p517m0.p543f;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import kotlin.reflect.jvm.internal.impl.protobuf.CodedOutputStream;
import kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException;
import kotlin.reflect.jvm.internal.impl.protobuf.UninitializedMessageException;
import p507d0.p513e0.p514p.p515d.p517m0.p550i.AbstractC11722b;
import p507d0.p513e0.p514p.p515d.p517m0.p550i.AbstractC11723c;
import p507d0.p513e0.p514p.p515d.p517m0.p550i.AbstractC11727g;
import p507d0.p513e0.p514p.p515d.p517m0.p550i.C11724d;
import p507d0.p513e0.p514p.p515d.p517m0.p550i.C11725e;
import p507d0.p513e0.p514p.p515d.p517m0.p550i.C11728h;
import p507d0.p513e0.p514p.p515d.p517m0.p550i.InterfaceC11735o;
import p507d0.p513e0.p514p.p515d.p517m0.p550i.InterfaceC11736p;

/* JADX INFO: renamed from: d0.e0.p.d.m0.f.f */
/* JADX INFO: compiled from: ProtoBuf.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C11681f extends AbstractC11727g implements InterfaceC11735o {

    /* JADX INFO: renamed from: j */
    public static final C11681f f23797j;

    /* JADX INFO: renamed from: k */
    public static InterfaceC11736p<C11681f> f23798k = new a();
    private int bitField0_;
    private C11683h conclusionOfConditionalEffect_;
    private List<C11683h> effectConstructorArgument_;
    private c effectType_;
    private d kind_;
    private byte memoizedIsInitialized;
    private int memoizedSerializedSize;
    private final AbstractC11723c unknownFields;

    /* JADX INFO: renamed from: d0.e0.p.d.m0.f.f$a */
    /* JADX INFO: compiled from: ProtoBuf.java */
    public static class a extends AbstractC11722b<C11681f> {
        @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.InterfaceC11736p
        public C11681f parsePartialFrom(C11724d c11724d, C11725e c11725e) throws InvalidProtocolBufferException {
            return new C11681f(c11724d, c11725e, null);
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.f.f$b */
    /* JADX INFO: compiled from: ProtoBuf.java */
    public static final class b extends AbstractC11727g.b<C11681f, b> implements InterfaceC11735o {

        /* JADX INFO: renamed from: k */
        public int f23799k;

        /* JADX INFO: renamed from: l */
        public c f23800l = c.RETURNS_CONSTANT;

        /* JADX INFO: renamed from: m */
        public List<C11683h> f23801m = Collections.emptyList();

        /* JADX INFO: renamed from: n */
        public C11683h f23802n = C11683h.getDefaultInstance();

        /* JADX INFO: renamed from: o */
        public d f23803o = d.AT_MOST_ONCE;

        public C11681f buildPartial() {
            C11681f c11681f = new C11681f(this, null);
            int i = this.f23799k;
            int i2 = (i & 1) != 1 ? 0 : 1;
            c11681f.effectType_ = this.f23800l;
            if ((this.f23799k & 2) == 2) {
                this.f23801m = Collections.unmodifiableList(this.f23801m);
                this.f23799k &= -3;
            }
            c11681f.effectConstructorArgument_ = this.f23801m;
            if ((i & 4) == 4) {
                i2 |= 2;
            }
            c11681f.conclusionOfConditionalEffect_ = this.f23802n;
            if ((i & 8) == 8) {
                i2 |= 4;
            }
            c11681f.kind_ = this.f23803o;
            c11681f.bitField0_ = i2;
            return c11681f;
        }

        public b mergeConclusionOfConditionalEffect(C11683h c11683h) {
            if ((this.f23799k & 4) != 4 || this.f23802n == C11683h.getDefaultInstance()) {
                this.f23802n = c11683h;
            } else {
                this.f23802n = C11683h.newBuilder(this.f23802n).mergeFrom(c11683h).buildPartial();
            }
            this.f23799k |= 4;
            return this;
        }

        public b setEffectType(c cVar) {
            Objects.requireNonNull(cVar);
            this.f23799k |= 1;
            this.f23800l = cVar;
            return this;
        }

        public b setKind(d dVar) {
            Objects.requireNonNull(dVar);
            this.f23799k |= 8;
            this.f23803o = dVar;
            return this;
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.InterfaceC11734n.a
        public C11681f build() {
            C11681f c11681fBuildPartial = buildPartial();
            if (c11681fBuildPartial.isInitialized()) {
                return c11681fBuildPartial;
            }
            throw new UninitializedMessageException(c11681fBuildPartial);
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.AbstractC11727g.b
        /* JADX INFO: renamed from: clone */
        public b mo11465clone() {
            return new b().mergeFrom(buildPartial());
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.AbstractC11727g.b
        public b mergeFrom(C11681f c11681f) {
            if (c11681f == C11681f.getDefaultInstance()) {
                return this;
            }
            if (c11681f.hasEffectType()) {
                setEffectType(c11681f.getEffectType());
            }
            if (!c11681f.effectConstructorArgument_.isEmpty()) {
                if (this.f23801m.isEmpty()) {
                    this.f23801m = c11681f.effectConstructorArgument_;
                    this.f23799k &= -3;
                } else {
                    if ((this.f23799k & 2) != 2) {
                        this.f23801m = new ArrayList(this.f23801m);
                        this.f23799k |= 2;
                    }
                    this.f23801m.addAll(c11681f.effectConstructorArgument_);
                }
            }
            if (c11681f.hasConclusionOfConditionalEffect()) {
                mergeConclusionOfConditionalEffect(c11681f.getConclusionOfConditionalEffect());
            }
            if (c11681f.hasKind()) {
                setKind(c11681f.getKind());
            }
            setUnknownFields(getUnknownFields().concat(c11681f.unknownFields));
            return this;
        }

        /* JADX WARN: Code duplicated, block: B:15:0x001d  */
        @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.AbstractC11721a.a, p507d0.p513e0.p514p.p515d.p517m0.p550i.InterfaceC11734n.a
        public b mergeFrom(C11724d c11724d, C11725e c11725e) throws Throwable {
            C11681f c11681f = null;
            try {
                try {
                    C11681f partialFrom = C11681f.f23798k.parsePartialFrom(c11724d, c11725e);
                    if (partialFrom != null) {
                        mergeFrom(partialFrom);
                    }
                    return this;
                } catch (InvalidProtocolBufferException e) {
                    C11681f c11681f2 = (C11681f) e.getUnfinishedMessage();
                    try {
                        throw e;
                    } catch (Throwable th) {
                        th = th;
                        c11681f = c11681f2;
                        if (c11681f != null) {
                            mergeFrom(c11681f);
                        }
                        throw th;
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                if (c11681f != null) {
                    mergeFrom(c11681f);
                }
                throw th;
            }
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.f.f$c */
    /* JADX INFO: compiled from: ProtoBuf.java */
    public enum c implements C11728h.a {
        RETURNS_CONSTANT(0),
        CALLS(1),
        RETURNS_NOT_NULL(2);

        private final int value;

        c(int i) {
            this.value = i;
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.C11728h.a
        public final int getNumber() {
            return this.value;
        }

        public static c valueOf(int i) {
            if (i == 0) {
                return RETURNS_CONSTANT;
            }
            if (i == 1) {
                return CALLS;
            }
            if (i != 2) {
                return null;
            }
            return RETURNS_NOT_NULL;
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.f.f$d */
    /* JADX INFO: compiled from: ProtoBuf.java */
    public enum d implements C11728h.a {
        AT_MOST_ONCE(0),
        EXACTLY_ONCE(1),
        AT_LEAST_ONCE(2);

        private final int value;

        d(int i) {
            this.value = i;
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.C11728h.a
        public final int getNumber() {
            return this.value;
        }

        public static d valueOf(int i) {
            if (i == 0) {
                return AT_MOST_ONCE;
            }
            if (i == 1) {
                return EXACTLY_ONCE;
            }
            if (i != 2) {
                return null;
            }
            return AT_LEAST_ONCE;
        }
    }

    static {
        C11681f c11681f = new C11681f();
        f23797j = c11681f;
        c11681f.m9658h();
    }

    public C11681f(AbstractC11727g.b bVar, C11666a c11666a) {
        super(bVar);
        this.memoizedIsInitialized = (byte) -1;
        this.memoizedSerializedSize = -1;
        this.unknownFields = bVar.getUnknownFields();
    }

    public static C11681f getDefaultInstance() {
        return f23797j;
    }

    public static b newBuilder(C11681f c11681f) {
        return newBuilder().mergeFrom(c11681f);
    }

    public C11683h getConclusionOfConditionalEffect() {
        return this.conclusionOfConditionalEffect_;
    }

    public C11683h getEffectConstructorArgument(int i) {
        return this.effectConstructorArgument_.get(i);
    }

    public int getEffectConstructorArgumentCount() {
        return this.effectConstructorArgument_.size();
    }

    public c getEffectType() {
        return this.effectType_;
    }

    public d getKind() {
        return this.kind_;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.InterfaceC11734n
    public int getSerializedSize() {
        int i = this.memoizedSerializedSize;
        if (i != -1) {
            return i;
        }
        int iComputeEnumSize = (this.bitField0_ & 1) == 1 ? CodedOutputStream.computeEnumSize(1, this.effectType_.getNumber()) + 0 : 0;
        for (int i2 = 0; i2 < this.effectConstructorArgument_.size(); i2++) {
            iComputeEnumSize += CodedOutputStream.computeMessageSize(2, this.effectConstructorArgument_.get(i2));
        }
        if ((this.bitField0_ & 2) == 2) {
            iComputeEnumSize += CodedOutputStream.computeMessageSize(3, this.conclusionOfConditionalEffect_);
        }
        if ((this.bitField0_ & 4) == 4) {
            iComputeEnumSize += CodedOutputStream.computeEnumSize(4, this.kind_.getNumber());
        }
        int size = this.unknownFields.size() + iComputeEnumSize;
        this.memoizedSerializedSize = size;
        return size;
    }

    /* JADX INFO: renamed from: h */
    public final void m9658h() {
        this.effectType_ = c.RETURNS_CONSTANT;
        this.effectConstructorArgument_ = Collections.emptyList();
        this.conclusionOfConditionalEffect_ = C11683h.getDefaultInstance();
        this.kind_ = d.AT_MOST_ONCE;
    }

    public boolean hasConclusionOfConditionalEffect() {
        return (this.bitField0_ & 2) == 2;
    }

    public boolean hasEffectType() {
        return (this.bitField0_ & 1) == 1;
    }

    public boolean hasKind() {
        return (this.bitField0_ & 4) == 4;
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
        for (int i = 0; i < getEffectConstructorArgumentCount(); i++) {
            if (!getEffectConstructorArgument(i).isInitialized()) {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            }
        }
        if (!hasConclusionOfConditionalEffect() || getConclusionOfConditionalEffect().isInitialized()) {
            this.memoizedIsInitialized = (byte) 1;
            return true;
        }
        this.memoizedIsInitialized = (byte) 0;
        return false;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.InterfaceC11734n
    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        getSerializedSize();
        if ((this.bitField0_ & 1) == 1) {
            codedOutputStream.writeEnum(1, this.effectType_.getNumber());
        }
        for (int i = 0; i < this.effectConstructorArgument_.size(); i++) {
            codedOutputStream.writeMessage(2, this.effectConstructorArgument_.get(i));
        }
        if ((this.bitField0_ & 2) == 2) {
            codedOutputStream.writeMessage(3, this.conclusionOfConditionalEffect_);
        }
        if ((this.bitField0_ & 4) == 4) {
            codedOutputStream.writeEnum(4, this.kind_.getNumber());
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

    public C11681f() {
        this.memoizedIsInitialized = (byte) -1;
        this.memoizedSerializedSize = -1;
        this.unknownFields = AbstractC11723c.f24100j;
    }

    public C11681f(C11724d c11724d, C11725e c11725e, C11666a c11666a) throws InvalidProtocolBufferException {
        this.memoizedIsInitialized = (byte) -1;
        this.memoizedSerializedSize = -1;
        m9658h();
        AbstractC11723c.b bVarNewOutput = AbstractC11723c.newOutput();
        CodedOutputStream codedOutputStreamNewInstance = CodedOutputStream.newInstance(bVarNewOutput, 1);
        boolean z2 = false;
        int i = 0;
        while (!z2) {
            try {
                try {
                    int tag = c11724d.readTag();
                    if (tag != 0) {
                        if (tag == 8) {
                            int i2 = c11724d.readEnum();
                            c cVarValueOf = c.valueOf(i2);
                            if (cVarValueOf == null) {
                                codedOutputStreamNewInstance.writeRawVarint32(tag);
                                codedOutputStreamNewInstance.writeRawVarint32(i2);
                            } else {
                                this.bitField0_ |= 1;
                                this.effectType_ = cVarValueOf;
                            }
                        } else if (tag == 18) {
                            if ((i & 2) != 2) {
                                this.effectConstructorArgument_ = new ArrayList();
                                i |= 2;
                            }
                            this.effectConstructorArgument_.add((C11683h) c11724d.readMessage(C11683h.f23817k, c11725e));
                        } else if (tag == 26) {
                            C11683h.b builder = (this.bitField0_ & 2) == 2 ? this.conclusionOfConditionalEffect_.toBuilder() : null;
                            C11683h c11683h = (C11683h) c11724d.readMessage(C11683h.f23817k, c11725e);
                            this.conclusionOfConditionalEffect_ = c11683h;
                            if (builder != null) {
                                builder.mergeFrom(c11683h);
                                this.conclusionOfConditionalEffect_ = builder.buildPartial();
                            }
                            this.bitField0_ |= 2;
                        } else if (tag != 32) {
                            if (!c11724d.skipField(tag, codedOutputStreamNewInstance)) {
                            }
                        } else {
                            int i3 = c11724d.readEnum();
                            d dVarValueOf = d.valueOf(i3);
                            if (dVarValueOf == null) {
                                codedOutputStreamNewInstance.writeRawVarint32(tag);
                                codedOutputStreamNewInstance.writeRawVarint32(i3);
                            } else {
                                this.bitField0_ |= 4;
                                this.kind_ = dVarValueOf;
                            }
                        }
                    }
                    z2 = true;
                } catch (Throwable th) {
                    if ((i & 2) == 2) {
                        this.effectConstructorArgument_ = Collections.unmodifiableList(this.effectConstructorArgument_);
                    }
                    try {
                        codedOutputStreamNewInstance.flush();
                    } catch (IOException unused) {
                    } finally {
                        this.unknownFields = bVarNewOutput.toByteString();
                    }
                    throw th;
                }
            } catch (InvalidProtocolBufferException e) {
                throw e.setUnfinishedMessage(this);
            } catch (IOException e2) {
                throw new InvalidProtocolBufferException(e2.getMessage()).setUnfinishedMessage(this);
            }
        }
        if ((i & 2) == 2) {
            this.effectConstructorArgument_ = Collections.unmodifiableList(this.effectConstructorArgument_);
        }
        try {
            codedOutputStreamNewInstance.flush();
        } catch (IOException unused2) {
        } finally {
            this.unknownFields = bVarNewOutput.toByteString();
        }
    }
}
