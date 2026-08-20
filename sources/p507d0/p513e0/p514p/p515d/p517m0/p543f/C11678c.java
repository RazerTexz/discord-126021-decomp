package p507d0.p513e0.p514p.p515d.p517m0.p543f;

import java.io.IOException;
import java.io.InputStream;
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
import p507d0.p513e0.p514p.p515d.p517m0.p550i.C11728h;
import p507d0.p513e0.p514p.p515d.p517m0.p550i.InterfaceC11735o;
import p507d0.p513e0.p514p.p515d.p517m0.p550i.InterfaceC11736p;

/* JADX INFO: renamed from: d0.e0.p.d.m0.f.c */
/* JADX INFO: compiled from: ProtoBuf.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C11678c extends AbstractC11727g.d<C11678c> implements InterfaceC11735o {

    /* JADX INFO: renamed from: j */
    public static final C11678c f23760j;

    /* JADX INFO: renamed from: k */
    public static InterfaceC11736p<C11678c> f23761k = new a();
    private int bitField0_;
    private int companionObjectName_;
    private List<C11679d> constructor_;
    private List<C11682g> enumEntry_;
    private int flags_;
    private int fqName_;
    private List<C11684i> function_;
    private byte memoizedIsInitialized;
    private int memoizedSerializedSize;
    private int nestedClassNameMemoizedSerializedSize;
    private List<Integer> nestedClassName_;
    private List<C11689n> property_;
    private int sealedSubclassFqNameMemoizedSerializedSize;
    private List<Integer> sealedSubclassFqName_;
    private int supertypeIdMemoizedSerializedSize;
    private List<Integer> supertypeId_;
    private List<C11692q> supertype_;
    private List<C11693r> typeAlias_;
    private List<C11694s> typeParameter_;
    private C11695t typeTable_;
    private final AbstractC11723c unknownFields;
    private C11698w versionRequirementTable_;
    private List<Integer> versionRequirement_;

    /* JADX INFO: renamed from: d0.e0.p.d.m0.f.c$a */
    /* JADX INFO: compiled from: ProtoBuf.java */
    public static class a extends AbstractC11722b<C11678c> {
        @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.InterfaceC11736p
        public C11678c parsePartialFrom(C11724d c11724d, C11725e c11725e) throws InvalidProtocolBufferException {
            return new C11678c(c11724d, c11725e);
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.f.c$b */
    /* JADX INFO: compiled from: ProtoBuf.java */
    public static final class b extends AbstractC11727g.c<C11678c, b> implements InterfaceC11735o {

        /* JADX INFO: renamed from: m */
        public int f23765m;

        /* JADX INFO: renamed from: o */
        public int f23767o;

        /* JADX INFO: renamed from: p */
        public int f23768p;

        /* JADX INFO: renamed from: n */
        public int f23766n = 6;

        /* JADX INFO: renamed from: q */
        public List<C11694s> f23769q = Collections.emptyList();

        /* JADX INFO: renamed from: r */
        public List<C11692q> f23770r = Collections.emptyList();

        /* JADX INFO: renamed from: s */
        public List<Integer> f23771s = Collections.emptyList();

        /* JADX INFO: renamed from: t */
        public List<Integer> f23772t = Collections.emptyList();

        /* JADX INFO: renamed from: u */
        public List<C11679d> f23773u = Collections.emptyList();

        /* JADX INFO: renamed from: v */
        public List<C11684i> f23774v = Collections.emptyList();

        /* JADX INFO: renamed from: w */
        public List<C11689n> f23775w = Collections.emptyList();

        /* JADX INFO: renamed from: x */
        public List<C11693r> f23776x = Collections.emptyList();

        /* JADX INFO: renamed from: y */
        public List<C11682g> f23777y = Collections.emptyList();

        /* JADX INFO: renamed from: z */
        public List<Integer> f23778z = Collections.emptyList();

        /* JADX INFO: renamed from: A */
        public C11695t f23762A = C11695t.getDefaultInstance();

        /* JADX INFO: renamed from: B */
        public List<Integer> f23763B = Collections.emptyList();

        /* JADX INFO: renamed from: C */
        public C11698w f23764C = C11698w.getDefaultInstance();

        public C11678c buildPartial() {
            C11678c c11678c = new C11678c(this, (C11666a) null);
            int i = this.f23765m;
            int i2 = (i & 1) != 1 ? 0 : 1;
            c11678c.flags_ = this.f23766n;
            if ((i & 2) == 2) {
                i2 |= 2;
            }
            c11678c.fqName_ = this.f23767o;
            if ((i & 4) == 4) {
                i2 |= 4;
            }
            c11678c.companionObjectName_ = this.f23768p;
            if ((this.f23765m & 8) == 8) {
                this.f23769q = Collections.unmodifiableList(this.f23769q);
                this.f23765m &= -9;
            }
            c11678c.typeParameter_ = this.f23769q;
            if ((this.f23765m & 16) == 16) {
                this.f23770r = Collections.unmodifiableList(this.f23770r);
                this.f23765m &= -17;
            }
            c11678c.supertype_ = this.f23770r;
            if ((this.f23765m & 32) == 32) {
                this.f23771s = Collections.unmodifiableList(this.f23771s);
                this.f23765m &= -33;
            }
            c11678c.supertypeId_ = this.f23771s;
            if ((this.f23765m & 64) == 64) {
                this.f23772t = Collections.unmodifiableList(this.f23772t);
                this.f23765m &= -65;
            }
            c11678c.nestedClassName_ = this.f23772t;
            if ((this.f23765m & 128) == 128) {
                this.f23773u = Collections.unmodifiableList(this.f23773u);
                this.f23765m &= -129;
            }
            c11678c.constructor_ = this.f23773u;
            if ((this.f23765m & 256) == 256) {
                this.f23774v = Collections.unmodifiableList(this.f23774v);
                this.f23765m &= -257;
            }
            c11678c.function_ = this.f23774v;
            if ((this.f23765m & 512) == 512) {
                this.f23775w = Collections.unmodifiableList(this.f23775w);
                this.f23765m &= -513;
            }
            c11678c.property_ = this.f23775w;
            if ((this.f23765m & 1024) == 1024) {
                this.f23776x = Collections.unmodifiableList(this.f23776x);
                this.f23765m &= -1025;
            }
            c11678c.typeAlias_ = this.f23776x;
            if ((this.f23765m & 2048) == 2048) {
                this.f23777y = Collections.unmodifiableList(this.f23777y);
                this.f23765m &= -2049;
            }
            c11678c.enumEntry_ = this.f23777y;
            if ((this.f23765m & 4096) == 4096) {
                this.f23778z = Collections.unmodifiableList(this.f23778z);
                this.f23765m &= -4097;
            }
            c11678c.sealedSubclassFqName_ = this.f23778z;
            if ((i & 8192) == 8192) {
                i2 |= 8;
            }
            c11678c.typeTable_ = this.f23762A;
            if ((this.f23765m & 16384) == 16384) {
                this.f23763B = Collections.unmodifiableList(this.f23763B);
                this.f23765m &= -16385;
            }
            c11678c.versionRequirement_ = this.f23763B;
            if ((i & 32768) == 32768) {
                i2 |= 16;
            }
            c11678c.versionRequirementTable_ = this.f23764C;
            c11678c.bitField0_ = i2;
            return c11678c;
        }

        public b mergeTypeTable(C11695t c11695t) {
            if ((this.f23765m & 8192) != 8192 || this.f23762A == C11695t.getDefaultInstance()) {
                this.f23762A = c11695t;
            } else {
                this.f23762A = C11695t.newBuilder(this.f23762A).mergeFrom(c11695t).buildPartial();
            }
            this.f23765m |= 8192;
            return this;
        }

        public b mergeVersionRequirementTable(C11698w c11698w) {
            if ((this.f23765m & 32768) != 32768 || this.f23764C == C11698w.getDefaultInstance()) {
                this.f23764C = c11698w;
            } else {
                this.f23764C = C11698w.newBuilder(this.f23764C).mergeFrom(c11698w).buildPartial();
            }
            this.f23765m |= 32768;
            return this;
        }

        public b setCompanionObjectName(int i) {
            this.f23765m |= 4;
            this.f23768p = i;
            return this;
        }

        public b setFlags(int i) {
            this.f23765m |= 1;
            this.f23766n = i;
            return this;
        }

        public b setFqName(int i) {
            this.f23765m |= 2;
            this.f23767o = i;
            return this;
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.InterfaceC11734n.a
        public C11678c build() {
            C11678c c11678cBuildPartial = buildPartial();
            if (c11678cBuildPartial.isInitialized()) {
                return c11678cBuildPartial;
            }
            throw new UninitializedMessageException(c11678cBuildPartial);
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.AbstractC11727g.b
        /* JADX INFO: renamed from: clone, reason: merged with bridge method [inline-methods] */
        public b mo11465clone() {
            return new b().mergeFrom(buildPartial());
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.AbstractC11727g.b
        public b mergeFrom(C11678c c11678c) {
            if (c11678c == C11678c.getDefaultInstance()) {
                return this;
            }
            if (c11678c.hasFlags()) {
                setFlags(c11678c.getFlags());
            }
            if (c11678c.hasFqName()) {
                setFqName(c11678c.getFqName());
            }
            if (c11678c.hasCompanionObjectName()) {
                setCompanionObjectName(c11678c.getCompanionObjectName());
            }
            if (!c11678c.typeParameter_.isEmpty()) {
                if (this.f23769q.isEmpty()) {
                    this.f23769q = c11678c.typeParameter_;
                    this.f23765m &= -9;
                } else {
                    if ((this.f23765m & 8) != 8) {
                        this.f23769q = new ArrayList(this.f23769q);
                        this.f23765m |= 8;
                    }
                    this.f23769q.addAll(c11678c.typeParameter_);
                }
            }
            if (!c11678c.supertype_.isEmpty()) {
                if (this.f23770r.isEmpty()) {
                    this.f23770r = c11678c.supertype_;
                    this.f23765m &= -17;
                } else {
                    if ((this.f23765m & 16) != 16) {
                        this.f23770r = new ArrayList(this.f23770r);
                        this.f23765m |= 16;
                    }
                    this.f23770r.addAll(c11678c.supertype_);
                }
            }
            if (!c11678c.supertypeId_.isEmpty()) {
                if (this.f23771s.isEmpty()) {
                    this.f23771s = c11678c.supertypeId_;
                    this.f23765m &= -33;
                } else {
                    if ((this.f23765m & 32) != 32) {
                        this.f23771s = new ArrayList(this.f23771s);
                        this.f23765m |= 32;
                    }
                    this.f23771s.addAll(c11678c.supertypeId_);
                }
            }
            if (!c11678c.nestedClassName_.isEmpty()) {
                if (this.f23772t.isEmpty()) {
                    this.f23772t = c11678c.nestedClassName_;
                    this.f23765m &= -65;
                } else {
                    if ((this.f23765m & 64) != 64) {
                        this.f23772t = new ArrayList(this.f23772t);
                        this.f23765m |= 64;
                    }
                    this.f23772t.addAll(c11678c.nestedClassName_);
                }
            }
            if (!c11678c.constructor_.isEmpty()) {
                if (this.f23773u.isEmpty()) {
                    this.f23773u = c11678c.constructor_;
                    this.f23765m &= -129;
                } else {
                    if ((this.f23765m & 128) != 128) {
                        this.f23773u = new ArrayList(this.f23773u);
                        this.f23765m |= 128;
                    }
                    this.f23773u.addAll(c11678c.constructor_);
                }
            }
            if (!c11678c.function_.isEmpty()) {
                if (this.f23774v.isEmpty()) {
                    this.f23774v = c11678c.function_;
                    this.f23765m &= -257;
                } else {
                    if ((this.f23765m & 256) != 256) {
                        this.f23774v = new ArrayList(this.f23774v);
                        this.f23765m |= 256;
                    }
                    this.f23774v.addAll(c11678c.function_);
                }
            }
            if (!c11678c.property_.isEmpty()) {
                if (this.f23775w.isEmpty()) {
                    this.f23775w = c11678c.property_;
                    this.f23765m &= -513;
                } else {
                    if ((this.f23765m & 512) != 512) {
                        this.f23775w = new ArrayList(this.f23775w);
                        this.f23765m |= 512;
                    }
                    this.f23775w.addAll(c11678c.property_);
                }
            }
            if (!c11678c.typeAlias_.isEmpty()) {
                if (this.f23776x.isEmpty()) {
                    this.f23776x = c11678c.typeAlias_;
                    this.f23765m &= -1025;
                } else {
                    if ((this.f23765m & 1024) != 1024) {
                        this.f23776x = new ArrayList(this.f23776x);
                        this.f23765m |= 1024;
                    }
                    this.f23776x.addAll(c11678c.typeAlias_);
                }
            }
            if (!c11678c.enumEntry_.isEmpty()) {
                if (this.f23777y.isEmpty()) {
                    this.f23777y = c11678c.enumEntry_;
                    this.f23765m &= -2049;
                } else {
                    if ((this.f23765m & 2048) != 2048) {
                        this.f23777y = new ArrayList(this.f23777y);
                        this.f23765m |= 2048;
                    }
                    this.f23777y.addAll(c11678c.enumEntry_);
                }
            }
            if (!c11678c.sealedSubclassFqName_.isEmpty()) {
                if (this.f23778z.isEmpty()) {
                    this.f23778z = c11678c.sealedSubclassFqName_;
                    this.f23765m &= -4097;
                } else {
                    if ((this.f23765m & 4096) != 4096) {
                        this.f23778z = new ArrayList(this.f23778z);
                        this.f23765m |= 4096;
                    }
                    this.f23778z.addAll(c11678c.sealedSubclassFqName_);
                }
            }
            if (c11678c.hasTypeTable()) {
                mergeTypeTable(c11678c.getTypeTable());
            }
            if (!c11678c.versionRequirement_.isEmpty()) {
                if (this.f23763B.isEmpty()) {
                    this.f23763B = c11678c.versionRequirement_;
                    this.f23765m &= -16385;
                } else {
                    if ((this.f23765m & 16384) != 16384) {
                        this.f23763B = new ArrayList(this.f23763B);
                        this.f23765m |= 16384;
                    }
                    this.f23763B.addAll(c11678c.versionRequirement_);
                }
            }
            if (c11678c.hasVersionRequirementTable()) {
                mergeVersionRequirementTable(c11678c.getVersionRequirementTable());
            }
            m9846b(c11678c);
            setUnknownFields(getUnknownFields().concat(c11678c.unknownFields));
            return this;
        }

        /* JADX WARN: Code duplicated, block: B:15:0x001d  */
        @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.AbstractC11721a.a, p507d0.p513e0.p514p.p515d.p517m0.p550i.InterfaceC11734n.a
        public b mergeFrom(C11724d c11724d, C11725e c11725e) throws Throwable {
            C11678c c11678c = null;
            try {
                try {
                    C11678c partialFrom = C11678c.f23761k.parsePartialFrom(c11724d, c11725e);
                    if (partialFrom != null) {
                        mergeFrom(partialFrom);
                    }
                    return this;
                } catch (InvalidProtocolBufferException e) {
                    C11678c c11678c2 = (C11678c) e.getUnfinishedMessage();
                    try {
                        throw e;
                    } catch (Throwable th) {
                        th = th;
                        c11678c = c11678c2;
                        if (c11678c != null) {
                            mergeFrom(c11678c);
                        }
                        throw th;
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                if (c11678c != null) {
                    mergeFrom(c11678c);
                }
                throw th;
            }
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.f.c$c */
    /* JADX INFO: compiled from: ProtoBuf.java */
    public enum c implements C11728h.a {
        CLASS(0),
        INTERFACE(1),
        ENUM_CLASS(2),
        ENUM_ENTRY(3),
        ANNOTATION_CLASS(4),
        OBJECT(5),
        COMPANION_OBJECT(6);

        private final int value;

        c(int i) {
            this.value = i;
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.C11728h.a
        public final int getNumber() {
            return this.value;
        }
    }

    static {
        C11678c c11678c = new C11678c();
        f23760j = c11678c;
        c11678c.m9640K();
    }

    public C11678c(AbstractC11727g.c cVar, C11666a c11666a) {
        super(cVar);
        this.supertypeIdMemoizedSerializedSize = -1;
        this.nestedClassNameMemoizedSerializedSize = -1;
        this.sealedSubclassFqNameMemoizedSerializedSize = -1;
        this.memoizedIsInitialized = (byte) -1;
        this.memoizedSerializedSize = -1;
        this.unknownFields = cVar.getUnknownFields();
    }

    public static C11678c getDefaultInstance() {
        return f23760j;
    }

    public static b newBuilder(C11678c c11678c) {
        return newBuilder().mergeFrom(c11678c);
    }

    public static C11678c parseFrom(InputStream inputStream, C11725e c11725e) throws IOException {
        return (C11678c) ((AbstractC11722b) f23761k).m11467parseFrom(inputStream, c11725e);
    }

    /* JADX INFO: renamed from: K */
    public final void m9640K() {
        this.flags_ = 6;
        this.fqName_ = 0;
        this.companionObjectName_ = 0;
        this.typeParameter_ = Collections.emptyList();
        this.supertype_ = Collections.emptyList();
        this.supertypeId_ = Collections.emptyList();
        this.nestedClassName_ = Collections.emptyList();
        this.constructor_ = Collections.emptyList();
        this.function_ = Collections.emptyList();
        this.property_ = Collections.emptyList();
        this.typeAlias_ = Collections.emptyList();
        this.enumEntry_ = Collections.emptyList();
        this.sealedSubclassFqName_ = Collections.emptyList();
        this.typeTable_ = C11695t.getDefaultInstance();
        this.versionRequirement_ = Collections.emptyList();
        this.versionRequirementTable_ = C11698w.getDefaultInstance();
    }

    public int getCompanionObjectName() {
        return this.companionObjectName_;
    }

    public C11679d getConstructor(int i) {
        return this.constructor_.get(i);
    }

    public int getConstructorCount() {
        return this.constructor_.size();
    }

    public List<C11679d> getConstructorList() {
        return this.constructor_;
    }

    public C11682g getEnumEntry(int i) {
        return this.enumEntry_.get(i);
    }

    public int getEnumEntryCount() {
        return this.enumEntry_.size();
    }

    public List<C11682g> getEnumEntryList() {
        return this.enumEntry_;
    }

    public int getFlags() {
        return this.flags_;
    }

    public int getFqName() {
        return this.fqName_;
    }

    public C11684i getFunction(int i) {
        return this.function_.get(i);
    }

    public int getFunctionCount() {
        return this.function_.size();
    }

    public List<C11684i> getFunctionList() {
        return this.function_;
    }

    public List<Integer> getNestedClassNameList() {
        return this.nestedClassName_;
    }

    public C11689n getProperty(int i) {
        return this.property_.get(i);
    }

    public int getPropertyCount() {
        return this.property_.size();
    }

    public List<C11689n> getPropertyList() {
        return this.property_;
    }

    public List<Integer> getSealedSubclassFqNameList() {
        return this.sealedSubclassFqName_;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.InterfaceC11734n
    public int getSerializedSize() {
        int i = this.memoizedSerializedSize;
        if (i != -1) {
            return i;
        }
        int iComputeInt32Size = (this.bitField0_ & 1) == 1 ? CodedOutputStream.computeInt32Size(1, this.flags_) + 0 : 0;
        int iComputeInt32SizeNoTag = 0;
        for (int i2 = 0; i2 < this.supertypeId_.size(); i2++) {
            iComputeInt32SizeNoTag += CodedOutputStream.computeInt32SizeNoTag(this.supertypeId_.get(i2).intValue());
        }
        int iComputeMessageSize = iComputeInt32Size + iComputeInt32SizeNoTag;
        if (!getSupertypeIdList().isEmpty()) {
            iComputeMessageSize = iComputeMessageSize + 1 + CodedOutputStream.computeInt32SizeNoTag(iComputeInt32SizeNoTag);
        }
        this.supertypeIdMemoizedSerializedSize = iComputeInt32SizeNoTag;
        if ((this.bitField0_ & 2) == 2) {
            iComputeMessageSize += CodedOutputStream.computeInt32Size(3, this.fqName_);
        }
        if ((this.bitField0_ & 4) == 4) {
            iComputeMessageSize += CodedOutputStream.computeInt32Size(4, this.companionObjectName_);
        }
        for (int i3 = 0; i3 < this.typeParameter_.size(); i3++) {
            iComputeMessageSize += CodedOutputStream.computeMessageSize(5, this.typeParameter_.get(i3));
        }
        for (int i4 = 0; i4 < this.supertype_.size(); i4++) {
            iComputeMessageSize += CodedOutputStream.computeMessageSize(6, this.supertype_.get(i4));
        }
        int iComputeInt32SizeNoTag2 = 0;
        for (int i5 = 0; i5 < this.nestedClassName_.size(); i5++) {
            iComputeInt32SizeNoTag2 += CodedOutputStream.computeInt32SizeNoTag(this.nestedClassName_.get(i5).intValue());
        }
        int iComputeMessageSize2 = iComputeMessageSize + iComputeInt32SizeNoTag2;
        if (!getNestedClassNameList().isEmpty()) {
            iComputeMessageSize2 = iComputeMessageSize2 + 1 + CodedOutputStream.computeInt32SizeNoTag(iComputeInt32SizeNoTag2);
        }
        this.nestedClassNameMemoizedSerializedSize = iComputeInt32SizeNoTag2;
        for (int i6 = 0; i6 < this.constructor_.size(); i6++) {
            iComputeMessageSize2 += CodedOutputStream.computeMessageSize(8, this.constructor_.get(i6));
        }
        for (int i7 = 0; i7 < this.function_.size(); i7++) {
            iComputeMessageSize2 += CodedOutputStream.computeMessageSize(9, this.function_.get(i7));
        }
        for (int i8 = 0; i8 < this.property_.size(); i8++) {
            iComputeMessageSize2 += CodedOutputStream.computeMessageSize(10, this.property_.get(i8));
        }
        for (int i9 = 0; i9 < this.typeAlias_.size(); i9++) {
            iComputeMessageSize2 += CodedOutputStream.computeMessageSize(11, this.typeAlias_.get(i9));
        }
        for (int i10 = 0; i10 < this.enumEntry_.size(); i10++) {
            iComputeMessageSize2 += CodedOutputStream.computeMessageSize(13, this.enumEntry_.get(i10));
        }
        int iComputeInt32SizeNoTag3 = 0;
        for (int i11 = 0; i11 < this.sealedSubclassFqName_.size(); i11++) {
            iComputeInt32SizeNoTag3 += CodedOutputStream.computeInt32SizeNoTag(this.sealedSubclassFqName_.get(i11).intValue());
        }
        int iComputeMessageSize3 = iComputeMessageSize2 + iComputeInt32SizeNoTag3;
        if (!getSealedSubclassFqNameList().isEmpty()) {
            iComputeMessageSize3 = iComputeMessageSize3 + 2 + CodedOutputStream.computeInt32SizeNoTag(iComputeInt32SizeNoTag3);
        }
        this.sealedSubclassFqNameMemoizedSerializedSize = iComputeInt32SizeNoTag3;
        if ((this.bitField0_ & 8) == 8) {
            iComputeMessageSize3 += CodedOutputStream.computeMessageSize(30, this.typeTable_);
        }
        int iComputeInt32SizeNoTag4 = 0;
        for (int i12 = 0; i12 < this.versionRequirement_.size(); i12++) {
            iComputeInt32SizeNoTag4 += CodedOutputStream.computeInt32SizeNoTag(this.versionRequirement_.get(i12).intValue());
        }
        int size = (getVersionRequirementList().size() * 2) + iComputeMessageSize3 + iComputeInt32SizeNoTag4;
        if ((this.bitField0_ & 16) == 16) {
            size += CodedOutputStream.computeMessageSize(32, this.versionRequirementTable_);
        }
        int size2 = this.unknownFields.size() + m9849c() + size;
        this.memoizedSerializedSize = size2;
        return size2;
    }

    public C11692q getSupertype(int i) {
        return this.supertype_.get(i);
    }

    public int getSupertypeCount() {
        return this.supertype_.size();
    }

    public List<Integer> getSupertypeIdList() {
        return this.supertypeId_;
    }

    public List<C11692q> getSupertypeList() {
        return this.supertype_;
    }

    public C11693r getTypeAlias(int i) {
        return this.typeAlias_.get(i);
    }

    public int getTypeAliasCount() {
        return this.typeAlias_.size();
    }

    public List<C11693r> getTypeAliasList() {
        return this.typeAlias_;
    }

    public C11694s getTypeParameter(int i) {
        return this.typeParameter_.get(i);
    }

    public int getTypeParameterCount() {
        return this.typeParameter_.size();
    }

    public List<C11694s> getTypeParameterList() {
        return this.typeParameter_;
    }

    public C11695t getTypeTable() {
        return this.typeTable_;
    }

    public List<Integer> getVersionRequirementList() {
        return this.versionRequirement_;
    }

    public C11698w getVersionRequirementTable() {
        return this.versionRequirementTable_;
    }

    public boolean hasCompanionObjectName() {
        return (this.bitField0_ & 4) == 4;
    }

    public boolean hasFlags() {
        return (this.bitField0_ & 1) == 1;
    }

    public boolean hasFqName() {
        return (this.bitField0_ & 2) == 2;
    }

    public boolean hasTypeTable() {
        return (this.bitField0_ & 8) == 8;
    }

    public boolean hasVersionRequirementTable() {
        return (this.bitField0_ & 16) == 16;
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
        if (!hasFqName()) {
            this.memoizedIsInitialized = (byte) 0;
            return false;
        }
        for (int i = 0; i < getTypeParameterCount(); i++) {
            if (!getTypeParameter(i).isInitialized()) {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            }
        }
        for (int i2 = 0; i2 < getSupertypeCount(); i2++) {
            if (!getSupertype(i2).isInitialized()) {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            }
        }
        for (int i3 = 0; i3 < getConstructorCount(); i3++) {
            if (!getConstructor(i3).isInitialized()) {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            }
        }
        for (int i4 = 0; i4 < getFunctionCount(); i4++) {
            if (!getFunction(i4).isInitialized()) {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            }
        }
        for (int i5 = 0; i5 < getPropertyCount(); i5++) {
            if (!getProperty(i5).isInitialized()) {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            }
        }
        for (int i6 = 0; i6 < getTypeAliasCount(); i6++) {
            if (!getTypeAlias(i6).isInitialized()) {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            }
        }
        for (int i7 = 0; i7 < getEnumEntryCount(); i7++) {
            if (!getEnumEntry(i7).isInitialized()) {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            }
        }
        if (hasTypeTable() && !getTypeTable().isInitialized()) {
            this.memoizedIsInitialized = (byte) 0;
            return false;
        }
        if (m9848b()) {
            this.memoizedIsInitialized = (byte) 1;
            return true;
        }
        this.memoizedIsInitialized = (byte) 0;
        return false;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.InterfaceC11734n
    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        getSerializedSize();
        AbstractC11727g.d<MessageType>.a aVarM9851e = m9851e();
        if ((this.bitField0_ & 1) == 1) {
            codedOutputStream.writeInt32(1, this.flags_);
        }
        if (getSupertypeIdList().size() > 0) {
            codedOutputStream.writeRawVarint32(18);
            codedOutputStream.writeRawVarint32(this.supertypeIdMemoizedSerializedSize);
        }
        for (int i = 0; i < this.supertypeId_.size(); i++) {
            codedOutputStream.writeInt32NoTag(this.supertypeId_.get(i).intValue());
        }
        if ((this.bitField0_ & 2) == 2) {
            codedOutputStream.writeInt32(3, this.fqName_);
        }
        if ((this.bitField0_ & 4) == 4) {
            codedOutputStream.writeInt32(4, this.companionObjectName_);
        }
        for (int i2 = 0; i2 < this.typeParameter_.size(); i2++) {
            codedOutputStream.writeMessage(5, this.typeParameter_.get(i2));
        }
        for (int i3 = 0; i3 < this.supertype_.size(); i3++) {
            codedOutputStream.writeMessage(6, this.supertype_.get(i3));
        }
        if (getNestedClassNameList().size() > 0) {
            codedOutputStream.writeRawVarint32(58);
            codedOutputStream.writeRawVarint32(this.nestedClassNameMemoizedSerializedSize);
        }
        for (int i4 = 0; i4 < this.nestedClassName_.size(); i4++) {
            codedOutputStream.writeInt32NoTag(this.nestedClassName_.get(i4).intValue());
        }
        for (int i5 = 0; i5 < this.constructor_.size(); i5++) {
            codedOutputStream.writeMessage(8, this.constructor_.get(i5));
        }
        for (int i6 = 0; i6 < this.function_.size(); i6++) {
            codedOutputStream.writeMessage(9, this.function_.get(i6));
        }
        for (int i7 = 0; i7 < this.property_.size(); i7++) {
            codedOutputStream.writeMessage(10, this.property_.get(i7));
        }
        for (int i8 = 0; i8 < this.typeAlias_.size(); i8++) {
            codedOutputStream.writeMessage(11, this.typeAlias_.get(i8));
        }
        for (int i9 = 0; i9 < this.enumEntry_.size(); i9++) {
            codedOutputStream.writeMessage(13, this.enumEntry_.get(i9));
        }
        if (getSealedSubclassFqNameList().size() > 0) {
            codedOutputStream.writeRawVarint32(130);
            codedOutputStream.writeRawVarint32(this.sealedSubclassFqNameMemoizedSerializedSize);
        }
        for (int i10 = 0; i10 < this.sealedSubclassFqName_.size(); i10++) {
            codedOutputStream.writeInt32NoTag(this.sealedSubclassFqName_.get(i10).intValue());
        }
        if ((this.bitField0_ & 8) == 8) {
            codedOutputStream.writeMessage(30, this.typeTable_);
        }
        for (int i11 = 0; i11 < this.versionRequirement_.size(); i11++) {
            codedOutputStream.writeInt32(31, this.versionRequirement_.get(i11).intValue());
        }
        if ((this.bitField0_ & 16) == 16) {
            codedOutputStream.writeMessage(32, this.versionRequirementTable_);
        }
        aVarM9851e.writeUntil(19000, codedOutputStream);
        codedOutputStream.writeRawBytes(this.unknownFields);
    }

    public static b newBuilder() {
        return new b();
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.InterfaceC11735o
    public C11678c getDefaultInstanceForType() {
        return f23760j;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.InterfaceC11734n
    public b newBuilderForType() {
        return newBuilder();
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.InterfaceC11734n
    public b toBuilder() {
        return newBuilder(this);
    }

    public C11678c() {
        this.supertypeIdMemoizedSerializedSize = -1;
        this.nestedClassNameMemoizedSerializedSize = -1;
        this.sealedSubclassFqNameMemoizedSerializedSize = -1;
        this.memoizedIsInitialized = (byte) -1;
        this.memoizedSerializedSize = -1;
        this.unknownFields = AbstractC11723c.f24100j;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public C11678c(C11724d c11724d, C11725e c11725e) throws InvalidProtocolBufferException {
        this.supertypeIdMemoizedSerializedSize = -1;
        this.nestedClassNameMemoizedSerializedSize = -1;
        this.sealedSubclassFqNameMemoizedSerializedSize = -1;
        this.memoizedIsInitialized = (byte) -1;
        this.memoizedSerializedSize = -1;
        m9640K();
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
                            z2 = true;
                            break;
                        case 8:
                            this.bitField0_ |= 1;
                            this.flags_ = c11724d.readInt32();
                            break;
                        case 16:
                            if ((i & 32) != 32) {
                                this.supertypeId_ = new ArrayList();
                                i |= 32;
                            }
                            this.supertypeId_.add(Integer.valueOf(c11724d.readInt32()));
                            break;
                        case 18:
                            int iPushLimit = c11724d.pushLimit(c11724d.readRawVarint32());
                            if ((i & 32) != 32 && c11724d.getBytesUntilLimit() > 0) {
                                this.supertypeId_ = new ArrayList();
                                i |= 32;
                            }
                            while (c11724d.getBytesUntilLimit() > 0) {
                                this.supertypeId_.add(Integer.valueOf(c11724d.readInt32()));
                            }
                            c11724d.popLimit(iPushLimit);
                            break;
                        case 24:
                            this.bitField0_ |= 2;
                            this.fqName_ = c11724d.readInt32();
                            break;
                        case 32:
                            this.bitField0_ |= 4;
                            this.companionObjectName_ = c11724d.readInt32();
                            break;
                        case 42:
                            if ((i & 8) != 8) {
                                this.typeParameter_ = new ArrayList();
                                i |= 8;
                            }
                            this.typeParameter_.add((C11694s) c11724d.readMessage(C11694s.f23944k, c11725e));
                            break;
                        case 50:
                            if ((i & 16) != 16) {
                                this.supertype_ = new ArrayList();
                                i |= 16;
                            }
                            this.supertype_.add((C11692q) c11724d.readMessage(C11692q.f23904k, c11725e));
                            break;
                        case 56:
                            if ((i & 64) != 64) {
                                this.nestedClassName_ = new ArrayList();
                                i |= 64;
                            }
                            this.nestedClassName_.add(Integer.valueOf(c11724d.readInt32()));
                            break;
                        case 58:
                            int iPushLimit2 = c11724d.pushLimit(c11724d.readRawVarint32());
                            if ((i & 64) != 64 && c11724d.getBytesUntilLimit() > 0) {
                                this.nestedClassName_ = new ArrayList();
                                i |= 64;
                            }
                            while (c11724d.getBytesUntilLimit() > 0) {
                                this.nestedClassName_.add(Integer.valueOf(c11724d.readInt32()));
                            }
                            c11724d.popLimit(iPushLimit2);
                            break;
                        case 66:
                            if ((i & 128) != 128) {
                                this.constructor_ = new ArrayList();
                                i |= 128;
                            }
                            this.constructor_.add((C11679d) c11724d.readMessage(C11679d.f23788k, c11725e));
                            break;
                        case 74:
                            if ((i & 256) != 256) {
                                this.function_ = new ArrayList();
                                i |= 256;
                            }
                            this.function_.add((C11684i) c11724d.readMessage(C11684i.f23831k, c11725e));
                            break;
                        case 82:
                            if ((i & 512) != 512) {
                                this.property_ = new ArrayList();
                                i |= 512;
                            }
                            this.property_.add((C11689n) c11724d.readMessage(C11689n.f23871k, c11725e));
                            break;
                        case 90:
                            if ((i & 1024) != 1024) {
                                this.typeAlias_ = new ArrayList();
                                i |= 1024;
                            }
                            this.typeAlias_.add((C11693r) c11724d.readMessage(C11693r.f23932k, c11725e));
                            break;
                        case 106:
                            if ((i & 2048) != 2048) {
                                this.enumEntry_ = new ArrayList();
                                i |= 2048;
                            }
                            this.enumEntry_.add((C11682g) c11724d.readMessage(C11682g.f23813k, c11725e));
                            break;
                        case 128:
                            if ((i & 4096) != 4096) {
                                this.sealedSubclassFqName_ = new ArrayList();
                                i |= 4096;
                            }
                            this.sealedSubclassFqName_.add(Integer.valueOf(c11724d.readInt32()));
                            break;
                        case 130:
                            int iPushLimit3 = c11724d.pushLimit(c11724d.readRawVarint32());
                            if ((i & 4096) != 4096 && c11724d.getBytesUntilLimit() > 0) {
                                this.sealedSubclassFqName_ = new ArrayList();
                                i |= 4096;
                            }
                            while (c11724d.getBytesUntilLimit() > 0) {
                                this.sealedSubclassFqName_.add(Integer.valueOf(c11724d.readInt32()));
                            }
                            c11724d.popLimit(iPushLimit3);
                            break;
                        case 242:
                            C11695t.b builder = (this.bitField0_ & 8) == 8 ? this.typeTable_.toBuilder() : null;
                            C11695t c11695t = (C11695t) c11724d.readMessage(C11695t.f23957k, c11725e);
                            this.typeTable_ = c11695t;
                            if (builder != 0) {
                                builder.mergeFrom(c11695t);
                                this.typeTable_ = builder.buildPartial();
                            }
                            this.bitField0_ |= 8;
                            break;
                        case 248:
                            if ((i & 16384) != 16384) {
                                this.versionRequirement_ = new ArrayList();
                                i |= 16384;
                            }
                            this.versionRequirement_.add(Integer.valueOf(c11724d.readInt32()));
                            break;
                        case 250:
                            int iPushLimit4 = c11724d.pushLimit(c11724d.readRawVarint32());
                            if ((i & 16384) != 16384 && c11724d.getBytesUntilLimit() > 0) {
                                this.versionRequirement_ = new ArrayList();
                                i |= 16384;
                            }
                            while (c11724d.getBytesUntilLimit() > 0) {
                                this.versionRequirement_.add(Integer.valueOf(c11724d.readInt32()));
                            }
                            c11724d.popLimit(iPushLimit4);
                            break;
                        case 258:
                            C11698w.b builder2 = (this.bitField0_ & 16) == 16 ? this.versionRequirementTable_.toBuilder() : null;
                            C11698w c11698w = (C11698w) c11724d.readMessage(C11698w.f23988k, c11725e);
                            this.versionRequirementTable_ = c11698w;
                            if (builder2 != 0) {
                                builder2.mergeFrom(c11698w);
                                this.versionRequirementTable_ = builder2.buildPartial();
                            }
                            this.bitField0_ |= 16;
                            break;
                        default:
                            if (!m9852f(c11724d, codedOutputStreamNewInstance, c11725e, tag)) {
                                z2 = true;
                            }
                            break;
                    }
                } catch (InvalidProtocolBufferException e) {
                    throw e.setUnfinishedMessage(this);
                } catch (IOException e2) {
                    throw new InvalidProtocolBufferException(e2.getMessage()).setUnfinishedMessage(this);
                }
            } catch (Throwable th) {
                if ((i & 32) == 32) {
                    this.supertypeId_ = Collections.unmodifiableList(this.supertypeId_);
                }
                if ((i & 8) == 8) {
                    this.typeParameter_ = Collections.unmodifiableList(this.typeParameter_);
                }
                if ((i & 16) == 16) {
                    this.supertype_ = Collections.unmodifiableList(this.supertype_);
                }
                if ((i & 64) == 64) {
                    this.nestedClassName_ = Collections.unmodifiableList(this.nestedClassName_);
                }
                if ((i & 128) == 128) {
                    this.constructor_ = Collections.unmodifiableList(this.constructor_);
                }
                if ((i & 256) == 256) {
                    this.function_ = Collections.unmodifiableList(this.function_);
                }
                if ((i & 512) == 512) {
                    this.property_ = Collections.unmodifiableList(this.property_);
                }
                if ((i & 1024) == 1024) {
                    this.typeAlias_ = Collections.unmodifiableList(this.typeAlias_);
                }
                if ((i & 2048) == 2048) {
                    this.enumEntry_ = Collections.unmodifiableList(this.enumEntry_);
                }
                if ((i & 4096) == 4096) {
                    this.sealedSubclassFqName_ = Collections.unmodifiableList(this.sealedSubclassFqName_);
                }
                if ((i & 16384) == 16384) {
                    this.versionRequirement_ = Collections.unmodifiableList(this.versionRequirement_);
                }
                try {
                    codedOutputStreamNewInstance.flush();
                } catch (IOException unused) {
                } finally {
                    this.unknownFields = bVarNewOutput.toByteString();
                }
                m9850d();
                throw th;
            }
        }
        if ((i & 32) == 32) {
            this.supertypeId_ = Collections.unmodifiableList(this.supertypeId_);
        }
        if ((i & 8) == 8) {
            this.typeParameter_ = Collections.unmodifiableList(this.typeParameter_);
        }
        if ((i & 16) == 16) {
            this.supertype_ = Collections.unmodifiableList(this.supertype_);
        }
        if ((i & 64) == 64) {
            this.nestedClassName_ = Collections.unmodifiableList(this.nestedClassName_);
        }
        if ((i & 128) == 128) {
            this.constructor_ = Collections.unmodifiableList(this.constructor_);
        }
        if ((i & 256) == 256) {
            this.function_ = Collections.unmodifiableList(this.function_);
        }
        if ((i & 512) == 512) {
            this.property_ = Collections.unmodifiableList(this.property_);
        }
        if ((i & 1024) == 1024) {
            this.typeAlias_ = Collections.unmodifiableList(this.typeAlias_);
        }
        if ((i & 2048) == 2048) {
            this.enumEntry_ = Collections.unmodifiableList(this.enumEntry_);
        }
        if ((i & 4096) == 4096) {
            this.sealedSubclassFqName_ = Collections.unmodifiableList(this.sealedSubclassFqName_);
        }
        if ((i & 16384) == 16384) {
            this.versionRequirement_ = Collections.unmodifiableList(this.versionRequirement_);
        }
        try {
            codedOutputStreamNewInstance.flush();
        } catch (IOException unused2) {
        } finally {
            this.unknownFields = bVarNewOutput.toByteString();
        }
        m9850d();
    }
}
