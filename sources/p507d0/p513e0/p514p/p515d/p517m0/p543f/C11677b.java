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

/* JADX INFO: renamed from: d0.e0.p.d.m0.f.b */
/* JADX INFO: compiled from: ProtoBuf.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C11677b extends AbstractC11727g implements InterfaceC11735o {

    /* JADX INFO: renamed from: j */
    public static final C11677b f23722j;

    /* JADX INFO: renamed from: k */
    public static InterfaceC11736p<C11677b> f23723k = new a();
    private List<b> argument_;
    private int bitField0_;
    private int id_;
    private byte memoizedIsInitialized;
    private int memoizedSerializedSize;
    private final AbstractC11723c unknownFields;

    /* JADX INFO: renamed from: d0.e0.p.d.m0.f.b$a */
    /* JADX INFO: compiled from: ProtoBuf.java */
    public static class a extends AbstractC11722b<C11677b> {
        @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.InterfaceC11736p
        public C11677b parsePartialFrom(C11724d c11724d, C11725e c11725e) throws InvalidProtocolBufferException {
            return new C11677b(c11724d, c11725e, null);
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.f.b$b */
    /* JADX INFO: compiled from: ProtoBuf.java */
    public static final class b extends AbstractC11727g implements InterfaceC11735o {

        /* JADX INFO: renamed from: j */
        public static final b f23724j;

        /* JADX INFO: renamed from: k */
        public static InterfaceC11736p<b> f23725k = new a();
        private int bitField0_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private int nameId_;
        private final AbstractC11723c unknownFields;
        private c value_;

        /* JADX INFO: renamed from: d0.e0.p.d.m0.f.b$b$a */
        /* JADX INFO: compiled from: ProtoBuf.java */
        public static class a extends AbstractC11722b<b> {
            @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.InterfaceC11736p
            public b parsePartialFrom(C11724d c11724d, C11725e c11725e) throws InvalidProtocolBufferException {
                return new b(c11724d, c11725e, null);
            }
        }

        /* JADX INFO: renamed from: d0.e0.p.d.m0.f.b$b$b, reason: collision with other inner class name */
        /* JADX INFO: compiled from: ProtoBuf.java */
        public static final class C13319b extends AbstractC11727g.b<b, C13319b> implements InterfaceC11735o {

            /* JADX INFO: renamed from: k */
            public int f23726k;

            /* JADX INFO: renamed from: l */
            public int f23727l;

            /* JADX INFO: renamed from: m */
            public c f23728m = c.getDefaultInstance();

            public b buildPartial() {
                b bVar = new b(this, null);
                int i = this.f23726k;
                int i2 = (i & 1) != 1 ? 0 : 1;
                bVar.nameId_ = this.f23727l;
                if ((i & 2) == 2) {
                    i2 |= 2;
                }
                bVar.value_ = this.f23728m;
                bVar.bitField0_ = i2;
                return bVar;
            }

            public C13319b mergeValue(c cVar) {
                if ((this.f23726k & 2) != 2 || this.f23728m == c.getDefaultInstance()) {
                    this.f23728m = cVar;
                } else {
                    this.f23728m = c.newBuilder(this.f23728m).mergeFrom(cVar).buildPartial();
                }
                this.f23726k |= 2;
                return this;
            }

            public C13319b setNameId(int i) {
                this.f23726k |= 1;
                this.f23727l = i;
                return this;
            }

            @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.InterfaceC11734n.a
            public b build() {
                b bVarBuildPartial = buildPartial();
                if (bVarBuildPartial.isInitialized()) {
                    return bVarBuildPartial;
                }
                throw new UninitializedMessageException(bVarBuildPartial);
            }

            @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.AbstractC11727g.b
            /* JADX INFO: renamed from: clone */
            public C13319b mo11465clone() {
                return new C13319b().mergeFrom(buildPartial());
            }

            @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.AbstractC11727g.b
            public C13319b mergeFrom(b bVar) {
                if (bVar == b.getDefaultInstance()) {
                    return this;
                }
                if (bVar.hasNameId()) {
                    setNameId(bVar.getNameId());
                }
                if (bVar.hasValue()) {
                    mergeValue(bVar.getValue());
                }
                setUnknownFields(getUnknownFields().concat(bVar.unknownFields));
                return this;
            }

            /* JADX WARN: Code duplicated, block: B:15:0x001d  */
            @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.AbstractC11721a.a, p507d0.p513e0.p514p.p515d.p517m0.p550i.InterfaceC11734n.a
            public C13319b mergeFrom(C11724d c11724d, C11725e c11725e) throws Throwable {
                b bVar = null;
                try {
                    try {
                        b partialFrom = b.f23725k.parsePartialFrom(c11724d, c11725e);
                        if (partialFrom != null) {
                            mergeFrom(partialFrom);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        b bVar2 = (b) e.getUnfinishedMessage();
                        try {
                            throw e;
                        } catch (Throwable th) {
                            th = th;
                            bVar = bVar2;
                            if (bVar != null) {
                                mergeFrom(bVar);
                            }
                            throw th;
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (bVar != null) {
                        mergeFrom(bVar);
                    }
                    throw th;
                }
            }
        }

        /* JADX INFO: renamed from: d0.e0.p.d.m0.f.b$b$c */
        /* JADX INFO: compiled from: ProtoBuf.java */
        public static final class c extends AbstractC11727g implements InterfaceC11735o {

            /* JADX INFO: renamed from: j */
            public static final c f23729j;

            /* JADX INFO: renamed from: k */
            public static InterfaceC11736p<c> f23730k = new a();
            private C11677b annotation_;
            private int arrayDimensionCount_;
            private List<c> arrayElement_;
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
            private EnumC13321c type_;
            private final AbstractC11723c unknownFields;

            /* JADX INFO: renamed from: d0.e0.p.d.m0.f.b$b$c$a */
            /* JADX INFO: compiled from: ProtoBuf.java */
            public static class a extends AbstractC11722b<c> {
                @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.InterfaceC11736p
                public c parsePartialFrom(C11724d c11724d, C11725e c11725e) throws InvalidProtocolBufferException {
                    return new c(c11724d, c11725e, null);
                }
            }

            /* JADX INFO: renamed from: d0.e0.p.d.m0.f.b$b$c$b, reason: collision with other inner class name */
            /* JADX INFO: compiled from: ProtoBuf.java */
            public static final class C13320b extends AbstractC11727g.b<c, C13320b> implements InterfaceC11735o {

                /* JADX INFO: renamed from: k */
                public int f23731k;

                /* JADX INFO: renamed from: m */
                public long f23733m;

                /* JADX INFO: renamed from: n */
                public float f23734n;

                /* JADX INFO: renamed from: o */
                public double f23735o;

                /* JADX INFO: renamed from: p */
                public int f23736p;

                /* JADX INFO: renamed from: q */
                public int f23737q;

                /* JADX INFO: renamed from: r */
                public int f23738r;

                /* JADX INFO: renamed from: u */
                public int f23741u;

                /* JADX INFO: renamed from: v */
                public int f23742v;

                /* JADX INFO: renamed from: l */
                public EnumC13321c f23732l = EnumC13321c.BYTE;

                /* JADX INFO: renamed from: s */
                public C11677b f23739s = C11677b.getDefaultInstance();

                /* JADX INFO: renamed from: t */
                public List<c> f23740t = Collections.emptyList();

                public c buildPartial() {
                    c cVar = new c(this, null);
                    int i = this.f23731k;
                    int i2 = (i & 1) != 1 ? 0 : 1;
                    cVar.type_ = this.f23732l;
                    if ((i & 2) == 2) {
                        i2 |= 2;
                    }
                    cVar.intValue_ = this.f23733m;
                    if ((i & 4) == 4) {
                        i2 |= 4;
                    }
                    cVar.floatValue_ = this.f23734n;
                    if ((i & 8) == 8) {
                        i2 |= 8;
                    }
                    cVar.doubleValue_ = this.f23735o;
                    if ((i & 16) == 16) {
                        i2 |= 16;
                    }
                    cVar.stringValue_ = this.f23736p;
                    if ((i & 32) == 32) {
                        i2 |= 32;
                    }
                    cVar.classId_ = this.f23737q;
                    if ((i & 64) == 64) {
                        i2 |= 64;
                    }
                    cVar.enumValueId_ = this.f23738r;
                    if ((i & 128) == 128) {
                        i2 |= 128;
                    }
                    cVar.annotation_ = this.f23739s;
                    if ((this.f23731k & 256) == 256) {
                        this.f23740t = Collections.unmodifiableList(this.f23740t);
                        this.f23731k &= -257;
                    }
                    cVar.arrayElement_ = this.f23740t;
                    if ((i & 512) == 512) {
                        i2 |= 256;
                    }
                    cVar.arrayDimensionCount_ = this.f23741u;
                    if ((i & 1024) == 1024) {
                        i2 |= 512;
                    }
                    cVar.flags_ = this.f23742v;
                    cVar.bitField0_ = i2;
                    return cVar;
                }

                public C13320b mergeAnnotation(C11677b c11677b) {
                    if ((this.f23731k & 128) != 128 || this.f23739s == C11677b.getDefaultInstance()) {
                        this.f23739s = c11677b;
                    } else {
                        this.f23739s = C11677b.newBuilder(this.f23739s).mergeFrom(c11677b).buildPartial();
                    }
                    this.f23731k |= 128;
                    return this;
                }

                public C13320b setArrayDimensionCount(int i) {
                    this.f23731k |= 512;
                    this.f23741u = i;
                    return this;
                }

                public C13320b setClassId(int i) {
                    this.f23731k |= 32;
                    this.f23737q = i;
                    return this;
                }

                public C13320b setDoubleValue(double d) {
                    this.f23731k |= 8;
                    this.f23735o = d;
                    return this;
                }

                public C13320b setEnumValueId(int i) {
                    this.f23731k |= 64;
                    this.f23738r = i;
                    return this;
                }

                public C13320b setFlags(int i) {
                    this.f23731k |= 1024;
                    this.f23742v = i;
                    return this;
                }

                public C13320b setFloatValue(float f) {
                    this.f23731k |= 4;
                    this.f23734n = f;
                    return this;
                }

                public C13320b setIntValue(long j) {
                    this.f23731k |= 2;
                    this.f23733m = j;
                    return this;
                }

                public C13320b setStringValue(int i) {
                    this.f23731k |= 16;
                    this.f23736p = i;
                    return this;
                }

                public C13320b setType(EnumC13321c enumC13321c) {
                    Objects.requireNonNull(enumC13321c);
                    this.f23731k |= 1;
                    this.f23732l = enumC13321c;
                    return this;
                }

                @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.InterfaceC11734n.a
                public c build() {
                    c cVarBuildPartial = buildPartial();
                    if (cVarBuildPartial.isInitialized()) {
                        return cVarBuildPartial;
                    }
                    throw new UninitializedMessageException(cVarBuildPartial);
                }

                @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.AbstractC11727g.b
                /* JADX INFO: renamed from: clone */
                public C13320b mo11465clone() {
                    return new C13320b().mergeFrom(buildPartial());
                }

                @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.AbstractC11727g.b
                public C13320b mergeFrom(c cVar) {
                    if (cVar == c.getDefaultInstance()) {
                        return this;
                    }
                    if (cVar.hasType()) {
                        setType(cVar.getType());
                    }
                    if (cVar.hasIntValue()) {
                        setIntValue(cVar.getIntValue());
                    }
                    if (cVar.hasFloatValue()) {
                        setFloatValue(cVar.getFloatValue());
                    }
                    if (cVar.hasDoubleValue()) {
                        setDoubleValue(cVar.getDoubleValue());
                    }
                    if (cVar.hasStringValue()) {
                        setStringValue(cVar.getStringValue());
                    }
                    if (cVar.hasClassId()) {
                        setClassId(cVar.getClassId());
                    }
                    if (cVar.hasEnumValueId()) {
                        setEnumValueId(cVar.getEnumValueId());
                    }
                    if (cVar.hasAnnotation()) {
                        mergeAnnotation(cVar.getAnnotation());
                    }
                    if (!cVar.arrayElement_.isEmpty()) {
                        if (this.f23740t.isEmpty()) {
                            this.f23740t = cVar.arrayElement_;
                            this.f23731k &= -257;
                        } else {
                            if ((this.f23731k & 256) != 256) {
                                this.f23740t = new ArrayList(this.f23740t);
                                this.f23731k |= 256;
                            }
                            this.f23740t.addAll(cVar.arrayElement_);
                        }
                    }
                    if (cVar.hasArrayDimensionCount()) {
                        setArrayDimensionCount(cVar.getArrayDimensionCount());
                    }
                    if (cVar.hasFlags()) {
                        setFlags(cVar.getFlags());
                    }
                    setUnknownFields(getUnknownFields().concat(cVar.unknownFields));
                    return this;
                }

                /* JADX WARN: Code duplicated, block: B:15:0x001d  */
                @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.AbstractC11721a.a, p507d0.p513e0.p514p.p515d.p517m0.p550i.InterfaceC11734n.a
                public C13320b mergeFrom(C11724d c11724d, C11725e c11725e) throws Throwable {
                    c cVar = null;
                    try {
                        try {
                            c partialFrom = c.f23730k.parsePartialFrom(c11724d, c11725e);
                            if (partialFrom != null) {
                                mergeFrom(partialFrom);
                            }
                            return this;
                        } catch (InvalidProtocolBufferException e) {
                            c cVar2 = (c) e.getUnfinishedMessage();
                            try {
                                throw e;
                            } catch (Throwable th) {
                                th = th;
                                cVar = cVar2;
                                if (cVar != null) {
                                    mergeFrom(cVar);
                                }
                                throw th;
                            }
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        if (cVar != null) {
                            mergeFrom(cVar);
                        }
                        throw th;
                    }
                }
            }

            /* JADX INFO: renamed from: d0.e0.p.d.m0.f.b$b$c$c, reason: collision with other inner class name */
            /* JADX INFO: compiled from: ProtoBuf.java */
            public enum EnumC13321c implements C11728h.a {
                BYTE(0),
                CHAR(1),
                SHORT(2),
                INT(3),
                LONG(4),
                FLOAT(5),
                DOUBLE(6),
                BOOLEAN(7),
                STRING(8),
                CLASS(9),
                ENUM(10),
                ANNOTATION(11),
                ARRAY(12);

                private final int value;

                EnumC13321c(int i) {
                    this.value = i;
                }

                @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.C11728h.a
                public final int getNumber() {
                    return this.value;
                }

                public static EnumC13321c valueOf(int i) {
                    switch (i) {
                        case 0:
                            return BYTE;
                        case 1:
                            return CHAR;
                        case 2:
                            return SHORT;
                        case 3:
                            return INT;
                        case 4:
                            return LONG;
                        case 5:
                            return FLOAT;
                        case 6:
                            return DOUBLE;
                        case 7:
                            return BOOLEAN;
                        case 8:
                            return STRING;
                        case 9:
                            return CLASS;
                        case 10:
                            return ENUM;
                        case 11:
                            return ANNOTATION;
                        case 12:
                            return ARRAY;
                        default:
                            return null;
                    }
                }
            }

            static {
                c cVar = new c();
                f23729j = cVar;
                cVar.m9610o();
            }

            public c(AbstractC11727g.b bVar, C11666a c11666a) {
                super(bVar);
                this.memoizedIsInitialized = (byte) -1;
                this.memoizedSerializedSize = -1;
                this.unknownFields = bVar.getUnknownFields();
            }

            public static c getDefaultInstance() {
                return f23729j;
            }

            public static C13320b newBuilder(c cVar) {
                return newBuilder().mergeFrom(cVar);
            }

            public C11677b getAnnotation() {
                return this.annotation_;
            }

            public int getArrayDimensionCount() {
                return this.arrayDimensionCount_;
            }

            public c getArrayElement(int i) {
                return this.arrayElement_.get(i);
            }

            public int getArrayElementCount() {
                return this.arrayElement_.size();
            }

            public List<c> getArrayElementList() {
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

            @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.InterfaceC11734n
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

            public EnumC13321c getType() {
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

            @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.InterfaceC11735o
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

            /* JADX INFO: renamed from: o */
            public final void m9610o() {
                this.type_ = EnumC13321c.BYTE;
                this.intValue_ = 0L;
                this.floatValue_ = 0.0f;
                this.doubleValue_ = 0.0d;
                this.stringValue_ = 0;
                this.classId_ = 0;
                this.enumValueId_ = 0;
                this.annotation_ = C11677b.getDefaultInstance();
                this.arrayElement_ = Collections.emptyList();
                this.arrayDimensionCount_ = 0;
                this.flags_ = 0;
            }

            @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.InterfaceC11734n
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

            public static C13320b newBuilder() {
                return new C13320b();
            }

            @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.InterfaceC11734n
            public C13320b newBuilderForType() {
                return newBuilder();
            }

            @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.InterfaceC11734n
            public C13320b toBuilder() {
                return newBuilder(this);
            }

            public c() {
                this.memoizedIsInitialized = (byte) -1;
                this.memoizedSerializedSize = -1;
                this.unknownFields = AbstractC11723c.f24100j;
            }

            public c(C11724d c11724d, C11725e c11725e, C11666a c11666a) throws InvalidProtocolBufferException {
                this.memoizedIsInitialized = (byte) -1;
                this.memoizedSerializedSize = -1;
                m9610o();
                AbstractC11723c.b bVarNewOutput = AbstractC11723c.newOutput();
                CodedOutputStream codedOutputStreamNewInstance = CodedOutputStream.newInstance(bVarNewOutput, 1);
                boolean z2 = false;
                int i = 0;
                while (!z2) {
                    try {
                        try {
                            int tag = c11724d.readTag();
                            switch (tag) {
                                case 0:
                                    break;
                                case 8:
                                    int i2 = c11724d.readEnum();
                                    EnumC13321c enumC13321cValueOf = EnumC13321c.valueOf(i2);
                                    if (enumC13321cValueOf == null) {
                                        codedOutputStreamNewInstance.writeRawVarint32(tag);
                                        codedOutputStreamNewInstance.writeRawVarint32(i2);
                                    } else {
                                        this.bitField0_ |= 1;
                                        this.type_ = enumC13321cValueOf;
                                        continue;
                                    }
                                    break;
                                case 16:
                                    this.bitField0_ |= 2;
                                    this.intValue_ = c11724d.readSInt64();
                                    continue;
                                case 29:
                                    this.bitField0_ |= 4;
                                    this.floatValue_ = c11724d.readFloat();
                                    continue;
                                case 33:
                                    this.bitField0_ |= 8;
                                    this.doubleValue_ = c11724d.readDouble();
                                    continue;
                                case 40:
                                    this.bitField0_ |= 16;
                                    this.stringValue_ = c11724d.readInt32();
                                    continue;
                                case 48:
                                    this.bitField0_ |= 32;
                                    this.classId_ = c11724d.readInt32();
                                    continue;
                                case 56:
                                    this.bitField0_ |= 64;
                                    this.enumValueId_ = c11724d.readInt32();
                                    continue;
                                case 66:
                                    c builder = (this.bitField0_ & 128) == 128 ? this.annotation_.toBuilder() : null;
                                    C11677b c11677b = (C11677b) c11724d.readMessage(C11677b.f23723k, c11725e);
                                    this.annotation_ = c11677b;
                                    if (builder != null) {
                                        builder.mergeFrom(c11677b);
                                        this.annotation_ = builder.buildPartial();
                                    }
                                    this.bitField0_ |= 128;
                                    continue;
                                case 74:
                                    if ((i & 256) != 256) {
                                        this.arrayElement_ = new ArrayList();
                                        i |= 256;
                                    }
                                    this.arrayElement_.add((c) c11724d.readMessage(f23730k, c11725e));
                                    continue;
                                case 80:
                                    this.bitField0_ |= 512;
                                    this.flags_ = c11724d.readInt32();
                                    continue;
                                case 88:
                                    this.bitField0_ |= 256;
                                    this.arrayDimensionCount_ = c11724d.readInt32();
                                    continue;
                                default:
                                    if (!c11724d.skipField(tag, codedOutputStreamNewInstance)) {
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
                            this.unknownFields = bVarNewOutput.toByteString();
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
                    this.unknownFields = bVarNewOutput.toByteString();
                }
            }
        }

        static {
            b bVar = new b();
            f23724j = bVar;
            bVar.nameId_ = 0;
            bVar.value_ = c.getDefaultInstance();
        }

        public b(AbstractC11727g.b bVar, C11666a c11666a) {
            super(bVar);
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = bVar.getUnknownFields();
        }

        public static b getDefaultInstance() {
            return f23724j;
        }

        public static C13319b newBuilder(b bVar) {
            return newBuilder().mergeFrom(bVar);
        }

        public int getNameId() {
            return this.nameId_;
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.InterfaceC11734n
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

        public c getValue() {
            return this.value_;
        }

        public boolean hasNameId() {
            return (this.bitField0_ & 1) == 1;
        }

        public boolean hasValue() {
            return (this.bitField0_ & 2) == 2;
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

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.InterfaceC11734n
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

        public static C13319b newBuilder() {
            return new C13319b();
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.InterfaceC11734n
        public C13319b newBuilderForType() {
            return newBuilder();
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.InterfaceC11734n
        public C13319b toBuilder() {
            return newBuilder(this);
        }

        public b() {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = AbstractC11723c.f24100j;
        }

        public b(C11724d c11724d, C11725e c11725e, C11666a c11666a) throws InvalidProtocolBufferException {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            boolean z2 = false;
            this.nameId_ = 0;
            this.value_ = c.getDefaultInstance();
            AbstractC11723c.b bVarNewOutput = AbstractC11723c.newOutput();
            CodedOutputStream codedOutputStreamNewInstance = CodedOutputStream.newInstance(bVarNewOutput, 1);
            while (!z2) {
                try {
                    try {
                        int tag = c11724d.readTag();
                        if (tag != 0) {
                            if (tag == 8) {
                                this.bitField0_ |= 1;
                                this.nameId_ = c11724d.readInt32();
                            } else if (tag != 18) {
                                if (!c11724d.skipField(tag, codedOutputStreamNewInstance)) {
                                }
                            } else {
                                c.C13320b builder = (this.bitField0_ & 2) == 2 ? this.value_.toBuilder() : null;
                                c cVar = (c) c11724d.readMessage(c.f23730k, c11725e);
                                this.value_ = cVar;
                                if (builder != null) {
                                    builder.mergeFrom(cVar);
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
                        this.unknownFields = bVarNewOutput.toByteString();
                    }
                    throw th;
                }
            }
            try {
                codedOutputStreamNewInstance.flush();
            } catch (IOException unused2) {
            } finally {
                this.unknownFields = bVarNewOutput.toByteString();
            }
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.f.b$c */
    /* JADX INFO: compiled from: ProtoBuf.java */
    public static final class c extends AbstractC11727g.b<C11677b, c> implements InterfaceC11735o {

        /* JADX INFO: renamed from: k */
        public int f23757k;

        /* JADX INFO: renamed from: l */
        public int f23758l;

        /* JADX INFO: renamed from: m */
        public List<b> f23759m = Collections.emptyList();

        public C11677b buildPartial() {
            C11677b c11677b = new C11677b(this, null);
            int i = (this.f23757k & 1) != 1 ? 0 : 1;
            c11677b.id_ = this.f23758l;
            if ((this.f23757k & 2) == 2) {
                this.f23759m = Collections.unmodifiableList(this.f23759m);
                this.f23757k &= -3;
            }
            c11677b.argument_ = this.f23759m;
            c11677b.bitField0_ = i;
            return c11677b;
        }

        public c setId(int i) {
            this.f23757k |= 1;
            this.f23758l = i;
            return this;
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.InterfaceC11734n.a
        public C11677b build() {
            C11677b c11677bBuildPartial = buildPartial();
            if (c11677bBuildPartial.isInitialized()) {
                return c11677bBuildPartial;
            }
            throw new UninitializedMessageException(c11677bBuildPartial);
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.AbstractC11727g.b
        /* JADX INFO: renamed from: clone */
        public c mo11465clone() {
            return new c().mergeFrom(buildPartial());
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.AbstractC11727g.b
        public c mergeFrom(C11677b c11677b) {
            if (c11677b == C11677b.getDefaultInstance()) {
                return this;
            }
            if (c11677b.hasId()) {
                setId(c11677b.getId());
            }
            if (!c11677b.argument_.isEmpty()) {
                if (this.f23759m.isEmpty()) {
                    this.f23759m = c11677b.argument_;
                    this.f23757k &= -3;
                } else {
                    if ((this.f23757k & 2) != 2) {
                        this.f23759m = new ArrayList(this.f23759m);
                        this.f23757k |= 2;
                    }
                    this.f23759m.addAll(c11677b.argument_);
                }
            }
            setUnknownFields(getUnknownFields().concat(c11677b.unknownFields));
            return this;
        }

        /* JADX WARN: Code duplicated, block: B:15:0x001d  */
        @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.AbstractC11721a.a, p507d0.p513e0.p514p.p515d.p517m0.p550i.InterfaceC11734n.a
        public c mergeFrom(C11724d c11724d, C11725e c11725e) throws Throwable {
            C11677b c11677b = null;
            try {
                try {
                    C11677b partialFrom = C11677b.f23723k.parsePartialFrom(c11724d, c11725e);
                    if (partialFrom != null) {
                        mergeFrom(partialFrom);
                    }
                    return this;
                } catch (InvalidProtocolBufferException e) {
                    C11677b c11677b2 = (C11677b) e.getUnfinishedMessage();
                    try {
                        throw e;
                    } catch (Throwable th) {
                        th = th;
                        c11677b = c11677b2;
                        if (c11677b != null) {
                            mergeFrom(c11677b);
                        }
                        throw th;
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                if (c11677b != null) {
                    mergeFrom(c11677b);
                }
                throw th;
            }
        }
    }

    static {
        C11677b c11677b = new C11677b();
        f23722j = c11677b;
        c11677b.id_ = 0;
        c11677b.argument_ = Collections.emptyList();
    }

    public C11677b(AbstractC11727g.b bVar, C11666a c11666a) {
        super(bVar);
        this.memoizedIsInitialized = (byte) -1;
        this.memoizedSerializedSize = -1;
        this.unknownFields = bVar.getUnknownFields();
    }

    public static C11677b getDefaultInstance() {
        return f23722j;
    }

    public static c newBuilder(C11677b c11677b) {
        return newBuilder().mergeFrom(c11677b);
    }

    public b getArgument(int i) {
        return this.argument_.get(i);
    }

    public int getArgumentCount() {
        return this.argument_.size();
    }

    public List<b> getArgumentList() {
        return this.argument_;
    }

    public int getId() {
        return this.id_;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.InterfaceC11734n
    public int getSerializedSize() {
        int i = this.memoizedSerializedSize;
        if (i != -1) {
            return i;
        }
        int iComputeInt32Size = (this.bitField0_ & 1) == 1 ? CodedOutputStream.computeInt32Size(1, this.id_) + 0 : 0;
        for (int i2 = 0; i2 < this.argument_.size(); i2++) {
            iComputeInt32Size += CodedOutputStream.computeMessageSize(2, this.argument_.get(i2));
        }
        int size = this.unknownFields.size() + iComputeInt32Size;
        this.memoizedSerializedSize = size;
        return size;
    }

    public boolean hasId() {
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
        if (!hasId()) {
            this.memoizedIsInitialized = (byte) 0;
            return false;
        }
        for (int i = 0; i < getArgumentCount(); i++) {
            if (!getArgument(i).isInitialized()) {
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
        if ((this.bitField0_ & 1) == 1) {
            codedOutputStream.writeInt32(1, this.id_);
        }
        for (int i = 0; i < this.argument_.size(); i++) {
            codedOutputStream.writeMessage(2, this.argument_.get(i));
        }
        codedOutputStream.writeRawBytes(this.unknownFields);
    }

    public static c newBuilder() {
        return new c();
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.InterfaceC11734n
    public c newBuilderForType() {
        return newBuilder();
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.InterfaceC11734n
    public c toBuilder() {
        return newBuilder(this);
    }

    public C11677b() {
        this.memoizedIsInitialized = (byte) -1;
        this.memoizedSerializedSize = -1;
        this.unknownFields = AbstractC11723c.f24100j;
    }

    public C11677b(C11724d c11724d, C11725e c11725e, C11666a c11666a) throws InvalidProtocolBufferException {
        this.memoizedIsInitialized = (byte) -1;
        this.memoizedSerializedSize = -1;
        boolean z2 = false;
        this.id_ = 0;
        this.argument_ = Collections.emptyList();
        AbstractC11723c.b bVarNewOutput = AbstractC11723c.newOutput();
        CodedOutputStream codedOutputStreamNewInstance = CodedOutputStream.newInstance(bVarNewOutput, 1);
        int i = 0;
        while (!z2) {
            try {
                try {
                    try {
                        int tag = c11724d.readTag();
                        if (tag != 0) {
                            if (tag == 8) {
                                this.bitField0_ |= 1;
                                this.id_ = c11724d.readInt32();
                            } else if (tag != 18) {
                                if (!c11724d.skipField(tag, codedOutputStreamNewInstance)) {
                                }
                            } else {
                                if ((i & 2) != 2) {
                                    this.argument_ = new ArrayList();
                                    i |= 2;
                                }
                                this.argument_.add((b) c11724d.readMessage(b.f23725k, c11725e));
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
                if ((i & 2) == 2) {
                    this.argument_ = Collections.unmodifiableList(this.argument_);
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
        if ((i & 2) == 2) {
            this.argument_ = Collections.unmodifiableList(this.argument_);
        }
        try {
            codedOutputStreamNewInstance.flush();
        } catch (IOException unused2) {
        } finally {
            this.unknownFields = bVarNewOutput.toByteString();
        }
    }
}
